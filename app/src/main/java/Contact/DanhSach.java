package Contact;

import java.io.Serializable;

public class DanhSach implements Serializable {
    private int SoA;
    private  int SoB;
    private String Chuoi;

    public DanhSach(int soA, int soB, String chuoi) {
        SoA = soA;
        SoB = soB;
        Chuoi = chuoi;
    }

    public int getSoA() {
        return SoA;
    }

    public void setSoA(int soA) {
        SoA = soA;
    }

    public int getSoB() {
        return SoB;
    }

    public void setSoB(int soB) {
        SoB = soB;
    }

    public String getChuoi() {
        return Chuoi;
    }

    public void setChuoi(String chuoi) {
        Chuoi = chuoi;
    }
}
