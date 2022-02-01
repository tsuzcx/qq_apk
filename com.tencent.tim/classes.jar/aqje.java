import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils.1;
import com.tencent.mobileqq.utils.PhoneCodeUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqje
{
  private static int dZs = x.length;
  private static HashMap<String, String> oT = new HashMap(250);
  public static HashMap<String, String> oU;
  public static HashMap<String, String> oV;
  private static String phoneCode;
  private static char[] x;
  
  static
  {
    oT.put("IL", "972");
    oT.put("AF", "93");
    oT.put("AL", "355");
    oT.put("DZ", "213");
    oT.put("AS", "1684");
    oT.put("AD", "376");
    oT.put("AO", "244");
    oT.put("AI", "1264");
    oT.put("AQ", "672");
    oT.put("AG", "1268");
    oT.put("AR", "54");
    oT.put("AM", "374");
    oT.put("AW", "297");
    oT.put("AU", "61");
    oT.put("AT", "43");
    oT.put("AZ", "994");
    oT.put("BS", "1242");
    oT.put("BH", "973");
    oT.put("BD", "880");
    oT.put("BB", "1246");
    oT.put("BY", "375");
    oT.put("BE", "32");
    oT.put("BZ", "501");
    oT.put("BJ", "229");
    oT.put("BM", "1441");
    oT.put("BT", "975");
    oT.put("BA", "387");
    oT.put("BW", "267");
    oT.put("BR", "55");
    oT.put("IO", "246");
    oT.put("BG", "359");
    oT.put("BF", "226");
    oT.put("BI", "257");
    oT.put("KH", "855");
    oT.put("CM", "237");
    oT.put("CA", "1");
    oT.put("CV", "238");
    oT.put("KY", "345");
    oT.put("CF", "236");
    oT.put("TD", "235");
    oT.put("CL", "56");
    oT.put("CN", "86");
    oT.put("CX", "61");
    oT.put("CO", "57");
    oT.put("KM", "269");
    oT.put("CG", "242");
    oT.put("CK", "682");
    oT.put("CR", "506");
    oT.put("HR", "385");
    oT.put("CU", "53");
    oT.put("CY", "537");
    oT.put("CZ", "420");
    oT.put("DK", "45");
    oT.put("DJ", "253");
    oT.put("DM", "1767");
    oT.put("DO", "1809");
    oT.put("EC", "593");
    oT.put("EG", "20");
    oT.put("SV", "503");
    oT.put("GQ", "240");
    oT.put("ER", "291");
    oT.put("EE", "372");
    oT.put("ET", "251");
    oT.put("FO", "298");
    oT.put("FJ", "679");
    oT.put("FI", "358");
    oT.put("FR", "33");
    oT.put("GF", "594");
    oT.put("PF", "689");
    oT.put("GA", "241");
    oT.put("GM", "220");
    oT.put("GE", "995");
    oT.put("DE", "49");
    oT.put("GH", "233");
    oT.put("GI", "350");
    oT.put("GR", "30");
    oT.put("GL", "299");
    oT.put("GD", "1473");
    oT.put("GP", "590");
    oT.put("GU", "1671");
    oT.put("GT", "502");
    oT.put("GN", "224");
    oT.put("GW", "245");
    oT.put("GY", "595");
    oT.put("HT", "509");
    oT.put("HN", "504");
    oT.put("HU", "36");
    oT.put("IS", "354");
    oT.put("IN", "91");
    oT.put("ID", "62");
    oT.put("IQ", "964");
    oT.put("IE", "353");
    oT.put("IL", "972");
    oT.put("IT", "39");
    oT.put("JM", "1876");
    oT.put("JP", "81");
    oT.put("JO", "962");
    oT.put("KZ", "77");
    oT.put("KE", "254");
    oT.put("KI", "686");
    oT.put("KW", "965");
    oT.put("KG", "996");
    oT.put("LV", "371");
    oT.put("LB", "961");
    oT.put("LS", "266");
    oT.put("LR", "231");
    oT.put("LI", "423");
    oT.put("LT", "370");
    oT.put("LU", "352");
    oT.put("MG", "261");
    oT.put("MW", "265");
    oT.put("MY", "60");
    oT.put("MV", "960");
    oT.put("ML", "223");
    oT.put("MT", "356");
    oT.put("MH", "692");
    oT.put("MQ", "596");
    oT.put("MR", "222");
    oT.put("MU", "230");
    oT.put("YT", "262");
    oT.put("MX", "52");
    oT.put("MC", "377");
    oT.put("MN", "976");
    oT.put("ME", "382");
    oT.put("MS", "1664");
    oT.put("MA", "212");
    oT.put("MM", "95");
    oT.put("NA", "264");
    oT.put("NR", "674");
    oT.put("NP", "977");
    oT.put("NL", "31");
    oT.put("AN", "599");
    oT.put("NC", "687");
    oT.put("NZ", "64");
    oT.put("NI", "505");
    oT.put("NE", "227");
    oT.put("NG", "234");
    oT.put("NU", "683");
    oT.put("NF", "672");
    oT.put("MP", "1670");
    oT.put("NO", "47");
    oT.put("OM", "968");
    oT.put("PK", "92");
    oT.put("PW", "680");
    oT.put("PA", "507");
    oT.put("PG", "675");
    oT.put("PY", "595");
    oT.put("PE", "51");
    oT.put("PH", "63");
    oT.put("PL", "48");
    oT.put("PT", "351");
    oT.put("PR", "1");
    oT.put("QA", "974");
    oT.put("RO", "40");
    oT.put("RW", "250");
    oT.put("WS", "685");
    oT.put("SM", "378");
    oT.put("SA", "966");
    oT.put("SN", "221");
    oT.put("RS", "381");
    oT.put("SC", "248");
    oT.put("SL", "232");
    oT.put("SG", "65");
    oT.put("SK", "421");
    oT.put("SI", "386");
    oT.put("SB", "677");
    oT.put("ZA", "27");
    oT.put("GS", "500");
    oT.put("ES", "34");
    oT.put("LK", "94");
    oT.put("SD", "249");
    oT.put("SR", "597");
    oT.put("SZ", "268");
    oT.put("SE", "46");
    oT.put("CH", "41");
    oT.put("TJ", "992");
    oT.put("TH", "66");
    oT.put("TG", "228");
    oT.put("TK", "690");
    oT.put("TO", "676");
    oT.put("TT", "1868");
    oT.put("TN", "216");
    oT.put("TR", "90");
    oT.put("TM", "993");
    oT.put("TC", "1649");
    oT.put("TV", "688");
    oT.put("UG", "256");
    oT.put("UA", "380");
    oT.put("AE", "971");
    oT.put("GB", "44");
    oT.put("US", "1");
    oT.put("UY", "598");
    oT.put("UZ", "998");
    oT.put("VU", "678");
    oT.put("WF", "681");
    oT.put("YE", "967");
    oT.put("ZM", "260");
    oT.put("ZW", "263");
    oT.put("BO", "591");
    oT.put("BN", "673");
    oT.put("CC", "61");
    oT.put("CD", "243");
    oT.put("CI", "225");
    oT.put("FK", "500");
    oT.put("GG", "44");
    oT.put("VA", "379");
    oT.put("HK", "852");
    oT.put("IR", "98");
    oT.put("IM", "44");
    oT.put("JE", "44");
    oT.put("KP", "850");
    oT.put("KR", "82");
    oT.put("LA", "856");
    oT.put("LY", "218");
    oT.put("MO", "853");
    oT.put("MK", "389");
    oT.put("FM", "691");
    oT.put("MD", "373");
    oT.put("MZ", "258");
    oT.put("PS", "970");
    oT.put("PN", "872");
    oT.put("RE", "262");
    oT.put("RU", "7");
    oT.put("BL", "590");
    oT.put("SH", "290");
    oT.put("KN", "1869");
    oT.put("LC", "1758");
    oT.put("MF", "590");
    oT.put("PM", "508");
    oT.put("VC", "1784");
    oT.put("ST", "239");
    oT.put("SO", "252");
    oT.put("SJ", "47");
    oT.put("SY", "963");
    oT.put("TW", "886");
    oT.put("TZ", "255");
    oT.put("TL", "670");
    oT.put("VE", "58");
    oT.put("VN", "84");
    oT.put("VG", "1284");
    oT.put("VI", "1340");
    oU = new PhoneCodeUtils.1(130);
    oV = new PhoneCodeUtils.2(20);
    x = new char[] { 0, 1, 0, 1 };
  }
  
  public static String Cd()
  {
    String str = a(Locale.getDefault());
    if (oV.containsKey(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneCodeUtil", 2, "code from Locale=" + str);
      }
      return (String)oV.get(str);
    }
    return "86";
  }
  
  public static String a(Locale paramLocale)
  {
    String str1 = paramLocale.getLanguage();
    String str2 = paramLocale.getCountry();
    paramLocale = str1;
    if (!aqmr.isEmpty(str2)) {
      paramLocale = str1 + "-" + str2;
    }
    return paramLocale.toLowerCase();
  }
  
  public static LinkedHashMap<String, Integer> a(String[] paramArrayOfString, List<aqje.a> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramArrayOfString == null))
    {
      QLog.e("PhoneCodeUtils", 1, "getNavigateMap error : countryCodes is null or navigationTags is null");
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      aqje.a locala = (aqje.a)paramList.next();
      if (localLinkedHashMap.containsKey(locala.tag))
      {
        i += 1;
      }
      else
      {
        localLinkedHashMap.put(locala.tag, Integer.valueOf(i));
        i += 1;
      }
    }
    int m = paramArrayOfString.length;
    int k = 0;
    i = j;
    j = k;
    if (i < m)
    {
      paramList = paramArrayOfString[i];
      if (localLinkedHashMap.containsKey(paramList)) {
        j = ((Integer)localLinkedHashMap.get(paramList)).intValue();
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedHashMap.put(paramList, Integer.valueOf(j));
      }
    }
    return localLinkedHashMap;
  }
  
  public static ArrayList<aqje.a> ah(String paramString)
  {
    QLog.d("PhoneCodeUtils", 1, "start parseCountryList");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PhoneCodeUtils", 1, "parseCountryList error : countryData is empty");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optJSONArray("favList");
      localObject = ((JSONObject)localObject).optJSONArray("itemList");
      paramString = e(paramString);
      if (paramString != null) {
        localArrayList.addAll(paramString);
      }
      paramString = e((JSONArray)localObject);
      if (paramString != null) {
        localArrayList.addAll(paramString);
      }
      QLog.d("PhoneCodeUtils", 1, "parseCountryList finish");
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      QLog.e("PhoneCodeUtils", 1, new Object[] { "parseCountryList JSONException : ", paramString.getMessage() });
    }
    return localArrayList;
  }
  
  public static String bf(Context paramContext)
  {
    if (TextUtils.isEmpty(phoneCode))
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getCountry();
      if (!TextUtils.isEmpty(paramContext)) {
        phoneCode = (String)oT.get(paramContext.toUpperCase());
      }
      if (TextUtils.isEmpty(phoneCode)) {
        phoneCode = "86";
      }
      phoneCode = "+" + phoneCode;
    }
    return phoneCode;
  }
  
  public static String bg(Context paramContext)
  {
    paramContext = aqgz.getIMSI();
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() > 3))
    {
      String str = paramContext.trim().substring(0, 3);
      str = (String)oU.get(str);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneCodeUtil", 2, "code from IMSI=" + paramContext + "code=" + str);
      }
      return str;
    }
    return Cd();
  }
  
  public static ArrayList<aqje.a> e(JSONArray paramJSONArray)
  {
    Object localObject2;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      QLog.e("PhoneCodeUtils", 1, "parseCountryList error : countryArray is null or empty");
      localObject2 = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return localObject2;
      localArrayList = new ArrayList();
      Object localObject1 = null;
      int i = 0;
      localObject2 = localArrayList;
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject2 = paramJSONArray.getJSONObject(i);
          String str1 = ((JSONObject)localObject2).optString("tag");
          String str2 = ((JSONObject)localObject2).optString("name");
          String str3 = ((JSONObject)localObject2).optString("abbr");
          String str4 = ((JSONObject)localObject2).optString("code");
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localObject1.equals(str1)) {}
          }
          else
          {
            localArrayList.add(new aqje.a(str1));
            localObject2 = str1;
          }
          localArrayList.add(new aqje.a(str1, str3, str2, str4));
          i += 1;
          localObject1 = localObject2;
        }
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("PhoneCodeUtils", 1, new Object[] { "parseCountryList JSONException : ", paramJSONArray.getMessage() });
      }
    }
    return localArrayList;
  }
  
  public static String encrypt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = String.valueOf(Long.valueOf(Long.valueOf(paramString).longValue() + 6666L)).toCharArray();
      char[] arrayOfChar = new char[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfChar[i] = ((char)(paramString[i] ^ x[(i % dZs)]));
        i += 1;
      }
      if (arrayOfChar.length == 0) {
        return "";
      }
      paramString = new String(arrayOfChar);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String getCountryCode()
  {
    String str = bg(null);
    if (!TextUtils.isEmpty(str))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = oU.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (str.equals(localEntry.getValue())) {
          localHashSet.add(localEntry.getKey());
        }
      }
      if (!localHashSet.isEmpty()) {
        return (String)localHashSet.iterator().next();
      }
    }
    return "";
  }
  
  public static class a
  {
    public String bYY;
    public boolean cUl;
    public String code;
    public String name;
    public String tag;
    
    public a(String paramString)
    {
      this.tag = paramString;
      this.cUl = true;
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.bYY = paramString2;
      this.tag = paramString1;
      this.code = paramString4;
      this.name = paramString3;
      this.cUl = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqje
 * JD-Core Version:    0.7.0.1
 */