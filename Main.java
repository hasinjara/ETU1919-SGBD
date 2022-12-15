package algo.main;
import algo.fonction.*;
import algo.langage.*;
import java.io.ObjectStreamField;
public class Main {

    public static void main(String[] args) {
        Langage myLangage = new Langage();
        try {
            //myLangage.update("update dept set ( location = Mac ) where [ location = os ]");
            //myLangage.execute("delete from dept where [ location = test ]");
            //myLangage.execute("select * from test where [ test = 1 ]");
            //myLangage.execute("show table");
            //myLangage.execute("describe dept");
            //myLangage.execute("select * from emp join emp join salaire");
            //myLangage.execute("alaina * ao_@ module");
            //myLangage.execute( "select id_S,id_M from stagiere/select id_M from module" );
            //myLangage.execute("alaina nom,numero_sal,valeur ao_@ emp atambatra_@ dept,atambatra_@ salaire ka [ numero_emp misy 1,nom misy o ]");
            //myLangage.executeInsertion("ampidiro ao_@ emp ( 16,raly )");
            //myLangage.execute("alaina * ao_@ emp ka [ numero_emp misy 1,nom misy o ]");
            //myLangage.execute("create table test ( int numero_test,string test )");
            // myLangage.executeInsertion("ampidiro ao_@ dept ( 1,10,windows )");
            // myLangage.executeInsertion("ampidiro ao_@ dept ( 2,11,linux )");
            // myLangage.executeInsertion("ampidiro ao_@ dept ( 3,14,windows)");
            //myLangage.execute("insert into dept ( 5,17,Mac )");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}