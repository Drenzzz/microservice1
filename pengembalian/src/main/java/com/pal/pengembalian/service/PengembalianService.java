package com.pal.pengembalian.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pal.pengembalian.model.Pengembalian;
import com.pal.pengembalian.repository.PengembalianRepository;
import com.pal.pengembalian.vo.Anggota;
import com.pal.pengembalian.vo.Buku;
import com.pal.pengembalian.vo.Peminjaman;
import com.pal.pengembalian.vo.ResponseTemplate;

@Service
public class PengembalianService {
    @Autowired
    private PengembalianRepository pengembalianRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Pengembalian> getAllPengembalians() {
        return pengembalianRepository.findAll();
    }
    public Pengembalian getPengembalianById(long id) {
        return pengembalianRepository.findById(id).orElse(null);
    }
    public Pengembalian createPengembalian(Pengembalian pengembalian) {
        return pengembalianRepository.save(pengembalian);
    }
    public void deletePengembalian(Long id) {
        pengembalianRepository.deleteById(id);
    }
    public List<ResponseTemplate> getPengembalianWithPeminjamanById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Pengembalian pengembalian = getPengembalianById(id);
        Peminjaman peminjaman = restTemplate.getForObject("http://localhost:8086/api/peminjaman/"
                + pengembalian.getPeminjamanId(), Peminjaman.class);
        Buku buku = restTemplate.getForObject("http://localhost:8085/api/buku/"
                + peminjaman.getBukuId(), Buku.class);
        Anggota anggota = restTemplate.getForObject("http://localhost:8084/api/anggota/"
                + peminjaman.getAnggotaId(), Anggota.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setPengembalian(pengembalian);
        vo.setPeminjaman(peminjaman);
        vo.setBuku(buku);
        vo.setAnggota(anggota);
        responseList.add(vo);
        return responseList;
    }
}
