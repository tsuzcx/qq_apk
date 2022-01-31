package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;

public class PhoneCodeUtils
{
  private static final String jdField_a_of_type_JavaLangString = "86";
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static String b;
  
  static
  {
    a = new HashMap();
    b = null;
    a.put("IL", "972");
    a.put("AF", "93");
    a.put("AL", "355");
    a.put("DZ", "213");
    a.put("AS", "1684");
    a.put("AD", "376");
    a.put("AO", "244");
    a.put("AI", "1264");
    a.put("AQ", "672");
    a.put("AG", "1268");
    a.put("AR", "54");
    a.put("AM", "374");
    a.put("AW", "297");
    a.put("AU", "61");
    a.put("AT", "43");
    a.put("AZ", "994");
    a.put("BS", "1242");
    a.put("BH", "973");
    a.put("BD", "880");
    a.put("BB", "1246");
    a.put("BY", "375");
    a.put("BE", "32");
    a.put("BZ", "501");
    a.put("BJ", "229");
    a.put("BM", "1441");
    a.put("BT", "975");
    a.put("BA", "387");
    a.put("BW", "267");
    a.put("BR", "55");
    a.put("IO", "246");
    a.put("BG", "359");
    a.put("BF", "226");
    a.put("BI", "257");
    a.put("KH", "855");
    a.put("CM", "237");
    a.put("CA", "1");
    a.put("CV", "238");
    a.put("KY", "345");
    a.put("CF", "236");
    a.put("TD", "235");
    a.put("CL", "56");
    a.put("CN", "86");
    a.put("CX", "61");
    a.put("CO", "57");
    a.put("KM", "269");
    a.put("CG", "242");
    a.put("CK", "682");
    a.put("CR", "506");
    a.put("HR", "385");
    a.put("CU", "53");
    a.put("CY", "537");
    a.put("CZ", "420");
    a.put("DK", "45");
    a.put("DJ", "253");
    a.put("DM", "1767");
    a.put("DO", "1809");
    a.put("EC", "593");
    a.put("EG", "20");
    a.put("SV", "503");
    a.put("GQ", "240");
    a.put("ER", "291");
    a.put("EE", "372");
    a.put("ET", "251");
    a.put("FO", "298");
    a.put("FJ", "679");
    a.put("FI", "358");
    a.put("FR", "33");
    a.put("GF", "594");
    a.put("PF", "689");
    a.put("GA", "241");
    a.put("GM", "220");
    a.put("GE", "995");
    a.put("DE", "49");
    a.put("GH", "233");
    a.put("GI", "350");
    a.put("GR", "30");
    a.put("GL", "299");
    a.put("GD", "1473");
    a.put("GP", "590");
    a.put("GU", "1671");
    a.put("GT", "502");
    a.put("GN", "224");
    a.put("GW", "245");
    a.put("GY", "595");
    a.put("HT", "509");
    a.put("HN", "504");
    a.put("HU", "36");
    a.put("IS", "354");
    a.put("IN", "91");
    a.put("ID", "62");
    a.put("IQ", "964");
    a.put("IE", "353");
    a.put("IL", "972");
    a.put("IT", "39");
    a.put("JM", "1876");
    a.put("JP", "81");
    a.put("JO", "962");
    a.put("KZ", "77");
    a.put("KE", "254");
    a.put("KI", "686");
    a.put("KW", "965");
    a.put("KG", "996");
    a.put("LV", "371");
    a.put("LB", "961");
    a.put("LS", "266");
    a.put("LR", "231");
    a.put("LI", "423");
    a.put("LT", "370");
    a.put("LU", "352");
    a.put("MG", "261");
    a.put("MW", "265");
    a.put("MY", "60");
    a.put("MV", "960");
    a.put("ML", "223");
    a.put("MT", "356");
    a.put("MH", "692");
    a.put("MQ", "596");
    a.put("MR", "222");
    a.put("MU", "230");
    a.put("YT", "262");
    a.put("MX", "52");
    a.put("MC", "377");
    a.put("MN", "976");
    a.put("ME", "382");
    a.put("MS", "1664");
    a.put("MA", "212");
    a.put("MM", "95");
    a.put("NA", "264");
    a.put("NR", "674");
    a.put("NP", "977");
    a.put("NL", "31");
    a.put("AN", "599");
    a.put("NC", "687");
    a.put("NZ", "64");
    a.put("NI", "505");
    a.put("NE", "227");
    a.put("NG", "234");
    a.put("NU", "683");
    a.put("NF", "672");
    a.put("MP", "1670");
    a.put("NO", "47");
    a.put("OM", "968");
    a.put("PK", "92");
    a.put("PW", "680");
    a.put("PA", "507");
    a.put("PG", "675");
    a.put("PY", "595");
    a.put("PE", "51");
    a.put("PH", "63");
    a.put("PL", "48");
    a.put("PT", "351");
    a.put("PR", "1");
    a.put("QA", "974");
    a.put("RO", "40");
    a.put("RW", "250");
    a.put("WS", "685");
    a.put("SM", "378");
    a.put("SA", "966");
    a.put("SN", "221");
    a.put("RS", "381");
    a.put("SC", "248");
    a.put("SL", "232");
    a.put("SG", "65");
    a.put("SK", "421");
    a.put("SI", "386");
    a.put("SB", "677");
    a.put("ZA", "27");
    a.put("GS", "500");
    a.put("ES", "34");
    a.put("LK", "94");
    a.put("SD", "249");
    a.put("SR", "597");
    a.put("SZ", "268");
    a.put("SE", "46");
    a.put("CH", "41");
    a.put("TJ", "992");
    a.put("TH", "66");
    a.put("TG", "228");
    a.put("TK", "690");
    a.put("TO", "676");
    a.put("TT", "1868");
    a.put("TN", "216");
    a.put("TR", "90");
    a.put("TM", "993");
    a.put("TC", "1649");
    a.put("TV", "688");
    a.put("UG", "256");
    a.put("UA", "380");
    a.put("AE", "971");
    a.put("GB", "44");
    a.put("US", "1");
    a.put("UY", "598");
    a.put("UZ", "998");
    a.put("VU", "678");
    a.put("WF", "681");
    a.put("YE", "967");
    a.put("ZM", "260");
    a.put("ZW", "263");
    a.put("BO", "591");
    a.put("BN", "673");
    a.put("CC", "61");
    a.put("CD", "243");
    a.put("CI", "225");
    a.put("FK", "500");
    a.put("GG", "44");
    a.put("VA", "379");
    a.put("HK", "852");
    a.put("IR", "98");
    a.put("IM", "44");
    a.put("JE", "44");
    a.put("KP", "850");
    a.put("KR", "82");
    a.put("LA", "856");
    a.put("LY", "218");
    a.put("MO", "853");
    a.put("MK", "389");
    a.put("FM", "691");
    a.put("MD", "373");
    a.put("MZ", "258");
    a.put("PS", "970");
    a.put("PN", "872");
    a.put("RE", "262");
    a.put("RU", "7");
    a.put("BL", "590");
    a.put("SH", "290");
    a.put("KN", "1869");
    a.put("LC", "1758");
    a.put("MF", "590");
    a.put("PM", "508");
    a.put("VC", "1784");
    a.put("ST", "239");
    a.put("SO", "252");
    a.put("SJ", "47");
    a.put("SY", "963");
    a.put("TW", "886");
    a.put("TZ", "255");
    a.put("TL", "670");
    a.put("VE", "58");
    a.put("VN", "84");
    a.put("VG", "1284");
    a.put("VI", "1340");
  }
  
  public static String a(Context paramContext)
  {
    if (TextUtils.isEmpty(b))
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getCountry();
      if (!TextUtils.isEmpty(paramContext)) {
        b = (String)a.get(paramContext.toUpperCase());
      }
      if (TextUtils.isEmpty(b)) {
        b = "86";
      }
      b = "+" + b;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PhoneCodeUtils
 * JD-Core Version:    0.7.0.1
 */