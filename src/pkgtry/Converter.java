package pkgtry;

import static pkgtry.Try.ev;
import static pkgtry.Try.map;

public class Converter {

    public static String retInt(String str) {
        if (str==null) return str;
        double db = Double.parseDouble(str);
            int aa=(int)db;
//             System.out.println(str+" "+db+" "+aa);
           if(aa==db) return String.format("%d",aa);

        return String.format("%s", db);

    }

    static String stringFormula(String formula) throws Exception {

        String temp, str = "";
        temp = "";
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == 's' && formula.substring(i, i + 3).equals("sqrt")) {
                str = str + "sqrt";
                temp = "";
                i = i + 3;
            } else if (formula.charAt(i) == 'P' && formula.substring(i, i + 2).equals("PI")) {
                str += "PI";
                temp = "";
                i = i + 1;
            } else if (formula.charAt(i) == '(' || formula.charAt(i) == ')' || formula.charAt(i) == '+'
                    || formula.charAt(i) == '-' || formula.charAt(i) == '*' || formula.charAt(i) == '/'
                    || formula.charAt(i) == '^') {
                String add = retInt((String) map.get(temp));
                if (add == null) {

                    str += temp;
                } else {
                    //add = "(" + add + ")";
                    str += add;
                }

                str += formula.charAt(i);
                temp = "";
            } else {
                temp += formula.charAt(i);
            }
//            System.out.println(temp);
        }
        if (!temp.equals("")) {
            String add = retInt((String) map.get(temp));
            if (add == null) {
                str += temp;
            } else {
                str += add;
            }
        }

//        Set keys = map.keySet();
//        String str = formula;
//        for (Iterator i = keys.iterator(); i.hasNext();) {
//            String key = (String) i.next();
//            String value = (String) map.get(key);
//            value = "" + String.format("%f", Double.parseDouble(value));
//            if (exceptThis(key, formula)) {
//                str = str.replaceAll(key, value);
//            }
////            System.out.println(value + " " + key + " " + str);
//        }
        System.out.println(formula + " " + str);
        return str;
    }

    static String getFormula(String equations, String part) throws Exception {
        String formula = "";
        int len = part.length();
        for (int i = 0; i < equations.length(); i++) {

            if (equations.substring(i, i + len).equals(part)) {
                //System.out.println("pkgtry.Converter.getFormula()");
                for (int j = i + len; j < equations.length() && equations.charAt(j) != ' '; j++) {
                    formula += equations.charAt(j);
                }

                break;
            }
        }
        return formula;
    }

    public static String calculation(String equations, String part) throws Exception {

        //System.out.println(equations + " " + part);
        String ttt = getFormula(equations, part);
        Try.equation = part + ttt;
//        System.out.println(ttt);
        ttt = stringFormula(ttt);
        Try.solution =part+ ttt;
        ttt = ev.expreesionValue(ttt);
//        System.out.println(ttt);
        // System.out.println(ev.expreesionValue(stringFormula(getFormula("v=v0+at v=v0+a*t v0=v-at a=(v-v0)/t t=(v-v0)/a","t=" ))));
        String ret = "";
        for (int i = 0; i < ttt.length(); i++) {
            if (ttt.charAt(i) == '=') {
                ret = ttt.substring(i + 2);
                break;

            }
        }
        Try.result=ret;
        return ret;
    }

}
