package com.pal.pengembalian.vo;

public class Peminjaman {
    private Long id;
    private Long bukuId;
    private Long anggotaId;
    private String tanggal_pinjam;
    private String tanggal_kembali;

    public Peminjaman() {
    }

    public Peminjaman(Long id, Long bukuId, Long anggotaId, String tanggal_pinjam, String tanggal_kembali) {
        this.id = id;
        this.bukuId = bukuId;
        this.anggotaId = anggotaId;
        this.tanggal_pinjam = tanggal_pinjam;
        this.tanggal_kembali = tanggal_kembali;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBukuId() {
        return bukuId;
    }
    public void setBukuId(Long bukuId) {
        this.bukuId = bukuId;
    }
    public Long getAnggotaId() {
        return anggotaId;
    }
    public void setAnggotaId(Long anggotaId) {
        this.anggotaId = anggotaId;
    }
    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }
    public void setTanggal_pinjam(String tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }
    public String getTanggal_kembali() {
        return tanggal_kembali;
    }
    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
