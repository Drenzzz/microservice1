package com.pal.peminjaman.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pal.peminjaman.model.Peminjaman;
import com.pal.peminjaman.repository.PeminjamanRepository;
import com.pal.peminjaman.vo.Anggota;
import com.pal.peminjaman.vo.Buku;
import com.pal.peminjaman.vo.ResponseTemplate;

@Service
public class PeminjamanService {
    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Peminjaman> getAllPeminjamans() {
        return peminjamanRepository.findAll();
    }
    public Peminjaman getPeminjamanById(Long id) {
        return peminjamanRepository.findById(id).orElse(null);
    }
    public Peminjaman createPeminjaman(Peminjaman peminjaman) {
        return peminjamanRepository.save(peminjaman);
    }
    public void deletePeminjaman(Long id) {
        peminjamanRepository.deleteById(id);
    }
    public List<ResponseTemplate> getPeminjamanWithBukuById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Peminjaman peminjaman = getPeminjamanById(id);
        Buku buku = restTemplate.getForObject("http://localhost:8085/api/buku/"
                + peminjaman.getBukuId(), Buku.class);
        Anggota anggota = restTemplate.getForObject("http://localhost:8084/api/anggota/"
                + peminjaman.getAnggotaId(), Anggota.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setPeminjaman(peminjaman);
        vo.setBuku(buku);
        vo.setAnggota(anggota);
        responseList.add(vo);
        return responseList;
    }
}
