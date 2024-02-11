package Modelo;

public class Venda {
    private String empresaID;
    private String ruralID;
    private String dataVendido;
    private String horaVendida;
    private String vendaID;

    public Venda() {
    }

    public Venda(String empresaID, String ruralID, String dataVendido, String horaVendida,String vendaID) {
        this.empresaID = empresaID;
        this.ruralID = ruralID;
        this.dataVendido = dataVendido;
        this.horaVendida = horaVendida;
        this.vendaID = vendaID;
    }

    public String getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(String empresaID) {
        Comerciante c = new Comerciante();
        c.setEmpresaID(empresaID);
        this.empresaID = c.getEmpresaID();
    }

    public String getRuralID() {
        return ruralID;
    }

    public void setRuralID(String ruralID) {
        Produtor p = new Produtor();
        p.setRuralID(ruralID);
        this.ruralID = p.getRuralID();
    }

    public String getDataVendido() {
        return dataVendido;
    }

    public void setDataVendido(String dataVendido) {
        this.dataVendido = dataVendido;
    }

    public String getHoraVendida() {
        return horaVendida;
    }

    public void setHoraVendida(String horaVendida) {
        this.horaVendida = horaVendida;
    }

    public String getVendaID() {
        return vendaID;
    }

    public void setVendaID(String vendaID) {
        this.vendaID = vendaID;
    }

    public String toString() {
        return "EmpresaID: " + empresaID + "\nRuralID: " + ruralID + 
                "\nDataVendido: " + dataVendido + "\nHoraVendida:" + horaVendida 
                +"\nVendaID: " + vendaID;
    }
    
}
