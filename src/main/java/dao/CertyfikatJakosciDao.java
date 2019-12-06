package dao;

import config.Config;
import model.CertyfikatJakosci;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CertyfikatJakosciDao {
    private Connection connection;
    private final String tableName = "certyfikaty";


    public CertyfikatJakosciDao() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + Config.HOSTNAME + ":"+Config.PORT+"/" + Config.DATABASENAME + "?useSSL=false", Config.USER, Config.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CertyfikatJakosci> getAllCertyfikatJakosci() {
        List<CertyfikatJakosci> certyfikatyJakosci = new LinkedList<CertyfikatJakosci>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String nr_certyfikaty = resultSet.getString("nr_certyfikaty");
                String aktywny_certyfikaty = resultSet.getString("aktywny_certyfikaty");
                String nasza_nazwa_certyfikaty = resultSet.getString("nasza_nazwa_certyfikaty");
                String asortyment_certyfikaty = resultSet.getString("asortyment_certyfikaty");
                String data_certyfikaty = resultSet.getString("data_certyfikaty");
                String nr_lab_certyfikaty = resultSet.getString("nr_lab_certyfikaty");
                String popiol_certyfikaty = resultSet.getString("popiol_certyfikaty");
                String siarka_certyfikaty = resultSet.getString("siarka_certyfikaty");
                String cz_lotne_certyfikaty = resultSet.getString("cz_lotne_certyfikaty");
                String wartosc_opalowa_certyfikaty = resultSet.getString("wartosc_opalowa_certyfikaty");
                String spiekalnosc_certyfikaty = resultSet.getString("spiekalnosc_certyfikaty");
                String min_ziarno_certyfikaty = resultSet.getString("min_ziarno_certyfikaty");
                String max_ziarno_certyfikaty = resultSet.getString("max_ziarno_certyfikaty");
                String podziarno_certyfikaty = resultSet.getString("podziarno_certyfikaty");
                String nadziarno_certyfikaty = resultSet.getString("nadziarno_certyfikaty");
                String wilgoc_certyfikaty = resultSet.getString("wilgoc_certyfikaty");
                String dostawca_certyfikaty = resultSet.getString("dostawca_certyfikaty");
                String nr_fv_certyfikaty = resultSet.getString("nr_fv_certyfikaty");

                CertyfikatJakosci certyfikatJakosci = new CertyfikatJakosci(nr_certyfikaty, aktywny_certyfikaty, nasza_nazwa_certyfikaty,
                        asortyment_certyfikaty, data_certyfikaty, nr_lab_certyfikaty, popiol_certyfikaty,
                        siarka_certyfikaty, cz_lotne_certyfikaty, wartosc_opalowa_certyfikaty, spiekalnosc_certyfikaty,
                        min_ziarno_certyfikaty, max_ziarno_certyfikaty, podziarno_certyfikaty, nadziarno_certyfikaty,
                        wilgoc_certyfikaty, dostawca_certyfikaty, nr_fv_certyfikaty);

                certyfikatyJakosci.add(certyfikatJakosci);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certyfikatyJakosci;
    }


    public List<CertyfikatJakosci> getAllCertyfikatJakosciTylkoAktywne() {
        List<CertyfikatJakosci> certyfikatyJakosci = new LinkedList<CertyfikatJakosci>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " WHERE aktywny_certyfikaty='TAK'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String nr_certyfikaty = resultSet.getString("nr_certyfikaty");
                String aktywny_certyfikaty = resultSet.getString("aktywny_certyfikaty");
                String nasza_nazwa_certyfikaty = resultSet.getString("nasza_nazwa_certyfikaty");
                String asortyment_certyfikaty = resultSet.getString("asortyment_certyfikaty");
                String data_certyfikaty = resultSet.getString("data_certyfikaty");
                String nr_lab_certyfikaty = resultSet.getString("nr_lab_certyfikaty");
                String popiol_certyfikaty = resultSet.getString("popiol_certyfikaty");
                String siarka_certyfikaty = resultSet.getString("siarka_certyfikaty");
                String cz_lotne_certyfikaty = resultSet.getString("cz_lotne_certyfikaty");
                String wartosc_opalowa_certyfikaty = resultSet.getString("wartosc_opalowa_certyfikaty");
                String spiekalnosc_certyfikaty = resultSet.getString("spiekalnosc_certyfikaty");
                String min_ziarno_certyfikaty = resultSet.getString("min_ziarno_certyfikaty");
                String max_ziarno_certyfikaty = resultSet.getString("max_ziarno_certyfikaty");
                String podziarno_certyfikaty = resultSet.getString("podziarno_certyfikaty");
                String nadziarno_certyfikaty = resultSet.getString("nadziarno_certyfikaty");
                String wilgoc_certyfikaty = resultSet.getString("wilgoc_certyfikaty");
                String dostawca_certyfikaty = resultSet.getString("dostawca_certyfikaty");
                String nr_fv_certyfikaty = resultSet.getString("nr_fv_certyfikaty");

                CertyfikatJakosci certyfikatJakosci = new CertyfikatJakosci(nr_certyfikaty, aktywny_certyfikaty, nasza_nazwa_certyfikaty,
                        asortyment_certyfikaty, data_certyfikaty, nr_lab_certyfikaty, popiol_certyfikaty,
                        siarka_certyfikaty, cz_lotne_certyfikaty, wartosc_opalowa_certyfikaty, spiekalnosc_certyfikaty,
                        min_ziarno_certyfikaty, max_ziarno_certyfikaty, podziarno_certyfikaty, nadziarno_certyfikaty,
                        wilgoc_certyfikaty, dostawca_certyfikaty, nr_fv_certyfikaty);

                certyfikatyJakosci.add(certyfikatJakosci);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certyfikatyJakosci;
    }

    public void addCertyfikatJakosciToDatabase(CertyfikatJakosci certyfikatJakosci) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "insert into " + tableName + "(nr_certyfikaty, aktywny_certyfikaty, nasza_nazwa_certyfikaty, asortyment_certyfikaty, data_certyfikaty, nr_lab_certyfikaty, popiol_certyfikaty, siarka_certyfikaty, cz_lotne_certyfikaty, wartosc_opalowa_certyfikaty, spiekalnosc_certyfikaty, min_ziarno_certyfikaty, max_ziarno_certyfikaty, podziarno_certyfikaty, nadziarno_certyfikaty, wilgoc_certyfikaty, dostawca_certyfikaty, nr_fv_certyfikaty) values('" + certyfikatJakosci.getNumerCertyfikatu() + "', '" + certyfikatJakosci.getAktywny() + "', '" + certyfikatJakosci.getNaszaNazwa() + "', '" + certyfikatJakosci.getAsortyment() + "', '" + certyfikatJakosci.getData() + "', '" + certyfikatJakosci.getNumerCertyfikatuLaboratorium() + "', '" + certyfikatJakosci.getZawartoscPopiolu() + "', '" + certyfikatJakosci.getZawartoscSiarkiCalkowitej() + "', '" + certyfikatJakosci.getZawartoscCzesciLotnych() + "', '" + certyfikatJakosci.getWartoscOpalowa() + "', '" + certyfikatJakosci.getZdolnoscSpiekania() + "', '" + certyfikatJakosci.getMinimalnyWymiarZiarna() + "', '" + certyfikatJakosci.getMaksymalnyWymiarZiarna() + "', '" + certyfikatJakosci.getZawartoscPodziarna() + "', '" + certyfikatJakosci.getZawartoscNadziarna() + "', '" + certyfikatJakosci.getZawartoscWilgociCalkowitej() + "', '" + certyfikatJakosci.getDostawca() + "', '" + certyfikatJakosci.getNrFV() + "');";
            int resultSet = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNajwyzszyNumerCertyfikatuDao() {
        Statement statement = null;
        int nrNajwyzszy = 0;
        int nr = 0;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                nr = resultSet.getInt("nr_certyfikaty");
                if (nrNajwyzszy < nr) {
                    nrNajwyzszy = nr;
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nrNajwyzszy;
    }

    public CertyfikatJakosci znajdzCertyfikatPoId(String id) {

        CertyfikatJakosci dokument = new CertyfikatJakosci("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " WHERE nr_certyfikaty=" + id;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                String nr_certyfikaty = resultSet.getString("nr_certyfikaty");
                String aktywny_certyfikaty = resultSet.getString("aktywny_certyfikaty");
                String nasza_nazwa_certyfikaty = resultSet.getString("nasza_nazwa_certyfikaty");
                String asortyment_certyfikaty = resultSet.getString("asortyment_certyfikaty");
                String data_certyfikaty = resultSet.getString("data_certyfikaty");
                String nr_lab_certyfikaty = resultSet.getString("nr_lab_certyfikaty");
                String popiol_certyfikaty = resultSet.getString("popiol_certyfikaty");
                String siarka_certyfikaty = resultSet.getString("siarka_certyfikaty");
                String cz_lotne_certyfikaty = resultSet.getString("cz_lotne_certyfikaty");
                String wartosc_opalowa_certyfikaty = resultSet.getString("wartosc_opalowa_certyfikaty");
                String spiekalnosc_certyfikaty = resultSet.getString("spiekalnosc_certyfikaty");
                String min_ziarno_certyfikaty = resultSet.getString("min_ziarno_certyfikaty");
                String max_ziarno_certyfikaty = resultSet.getString("max_ziarno_certyfikaty");
                String podziarno_certyfikaty = resultSet.getString("podziarno_certyfikaty");
                String nadziarno_certyfikaty = resultSet.getString("nadziarno_certyfikaty");
                String wilgoc_certyfikaty = resultSet.getString("wilgoc_certyfikaty");
                String dostawca_certyfikaty = resultSet.getString("dostawca_certyfikaty");
                String nr_fv_certyfikaty = resultSet.getString("nr_fv_certyfikaty");

                CertyfikatJakosci dokumenty = new CertyfikatJakosci(nr_certyfikaty, aktywny_certyfikaty, nasza_nazwa_certyfikaty,
                        asortyment_certyfikaty, data_certyfikaty, nr_lab_certyfikaty, popiol_certyfikaty,
                        siarka_certyfikaty, cz_lotne_certyfikaty, wartosc_opalowa_certyfikaty, spiekalnosc_certyfikaty,
                        min_ziarno_certyfikaty, max_ziarno_certyfikaty, podziarno_certyfikaty, nadziarno_certyfikaty,
                        wilgoc_certyfikaty, dostawca_certyfikaty, nr_fv_certyfikaty);
                dokument = dokumenty;

            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dokument;
    }
}