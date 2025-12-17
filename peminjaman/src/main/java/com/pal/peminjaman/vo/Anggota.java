package com.pal.peminjaman.vo;

public class Anggota {
    private Long id;
    private String nama;
    private String nim;
    private String alamat;
    private String jenis_kelamin;

    public Anggota() {
    }

    public Anggota(Long id, String nama, String nim, String alamat, String jenis_kelamin) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
