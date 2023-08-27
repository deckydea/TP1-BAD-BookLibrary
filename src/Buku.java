class Buku {
    private String jenis;
    private int hariPengembalian;

    public Buku(String jenis, int hariPengembalian) {
        this.jenis = jenis;
        this.hariPengembalian = hariPengembalian;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHariPengembalian() {
        return hariPengembalian;
    }
}