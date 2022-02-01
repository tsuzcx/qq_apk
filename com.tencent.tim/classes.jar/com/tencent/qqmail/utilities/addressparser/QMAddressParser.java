package com.tencent.qqmail.utilities.addressparser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMAddressParser
{
  private static final String _oAliasPat = "^([^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+)(\\.([^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+))*$";
  private static final String _oAtomPat = "^[^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+$";
  private static final String _oEmailPat = "^(.+)@(.+)$";
  private static final String _oIpDomainPat = "^\\[(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\]$";
  private static final String _sAtom = "[^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+";
  private static final String _sSpecialChars = "\\(\\)><@,;:\\\\\\\"\\.\\[\\]";
  private static final String _sValidChars = "[^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]";
  private static final String _sWord = "([^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+)";
  private static final Pattern aliasPattern;
  private static final Pattern atomPattern = Pattern.compile("^[^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+$");
  private static final Pattern ipDomainPattern;
  private static final Pattern pattern = Pattern.compile("^(.+)@(.+)$");
  
  static
  {
    aliasPattern = Pattern.compile("^([^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+)(\\.([^\\s\\(\\)><@,;:\\\\\\\"\\.\\[\\]]+))*$");
    ipDomainPattern = Pattern.compile("^\\[(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\]$");
  }
  
  private static List<String> _getSegment(String paramString, int paramInt, List<List<String>> paramList, List<String> paramList1)
  {
    int n = 0;
    int i = 78;
    String str = "";
    int i1 = 0;
    int m = paramInt;
    int i3 = paramInt;
    int j;
    if (i != 68) {
      if (m >= paramString.length())
      {
        j = 0;
        label39:
        if ((j != 92) || (i == 60)) {
          break label654;
        }
        m += 1;
        j = paramString.charAt(m);
      }
    }
    label654:
    for (int i2 = 1;; i2 = 0)
    {
      if (j == 0)
      {
        j = 68;
        i1 = m;
        i2 = m;
        m = i1;
        if (j != i) {
          break label446;
        }
        i = j;
        i1 = m;
        m = i2;
        break;
        j = paramString.charAt(m);
        break label39;
      }
      if (i == 78)
      {
        int i4 = "<(\",;，；、 ".indexOf(j);
        if ((i2 <= 0) && (i4 > -1)) {
          if (m + 1 >= paramString.length())
          {
            i2 = 0;
            label165:
            if (i2 == 60) {
              break label255;
            }
            j = "<(\"DDDDDD".charAt(i4);
            if (">)\"DDDDDD".length() > i4) {
              break label234;
            }
            i1 = 0;
            label194:
            if (i4 <= 2) {
              break label246;
            }
            n = m;
          }
        }
        for (;;)
        {
          i2 = m + 1;
          m = n;
          n = i1;
          break;
          i2 = paramString.charAt(m + 1);
          break label165;
          label234:
          i1 = ">)\"DDDDDD".charAt(i4);
          break label194;
          label246:
          n = m - 1;
          continue;
          label255:
          if (j != 32)
          {
            j = "<(\"DDDDDD".charAt(i4);
            i1 = ">)\"DDDDDD".charAt(i4);
            if (i4 > 2) {
              n = m;
            } else {
              n = m - 1;
            }
          }
          else
          {
            str = str + j;
            i2 = n;
            j = i;
            n = i1;
            i1 = i2;
            continue;
            str = str + j;
            i2 = n;
            j = i;
            n = i1;
            i1 = i2;
          }
        }
      }
      int k;
      if ((i2 <= 0) && (j == n))
      {
        k = 78;
        i1 = m;
      }
      for (;;)
      {
        i2 = m + 1;
        m = i1;
        break;
        str = str + k;
        k = i;
      }
      label446:
      if ((i == 34) || (!str.trim().equals("")))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str);
        localArrayList.add(i + "");
        localArrayList.add(i3 + "");
        localArrayList.add(paramString.substring(i3, m));
        paramList.add(localArrayList);
        paramList1.add(i + "");
      }
      i3 = m + 1;
      i = k;
      str = "";
      i1 = m;
      m = i2;
      break;
      paramList = new ArrayList();
      paramList.add(String.valueOf(m));
      paramList.add(paramString.substring(paramInt, m));
      return paramList;
    }
  }
  
  private static String _maybeChangeToBizEmail(String paramString)
  {
    String str;
    if (!check("(400\\d{7})@qq.com", paramString))
    {
      str = paramString;
      if (!check("(800\\d{6,7})@qq.com", paramString)) {}
    }
    else
    {
      str = paramString.replace("@qq.com", "") + "@b.qq.com";
    }
    return str;
  }
  
  private static HashMap<String, String> _parseSegment(String paramString, List<List<String>> paramList, List<String> paramList1)
  {
    String str = "";
    int i = 0;
    while (i < paramList1.size())
    {
      str = str + String.valueOf(paramList1.get(i));
      i += 1;
    }
    if ((str.equals("N")) || (str.equals("<")))
    {
      paramList1 = (String)((List)paramList.get(0)).get(0);
      paramList = "";
    }
    for (;;)
    {
      paramList1 = paramList1.trim();
      str = paramList.trim();
      if ((Pattern.matches("^\\d+$", paramList1)) && (!paramList1.endsWith("@qq.com"))) {}
      for (paramList = paramList1 + "@qq.com";; paramList = paramList1)
      {
        paramList = _maybeChangeToBizEmail(paramList);
        paramList1 = new HashMap();
        if (isEmailAddress(paramList))
        {
          paramList1.put("nick", str);
          paramList1.put("addr", paramList);
          paramList1.put("valid", "true");
          return paramList1;
          if ((!str.equals("\"<")) && (!str.equals("N<")) && (!str.equals("\"N"))) {
            break label334;
          }
          paramList1 = (String)((List)paramList.get(0)).get(0);
          str = (String)((List)paramList.get(1)).get(0);
          paramList = paramList1;
          paramList1 = str;
          break;
        }
        paramList = paramString;
        if (Pattern.compile("[;,；，、 ]$").matcher(paramString).find()) {
          paramList = paramString.substring(0, paramString.length() - 1);
        }
        paramList1.put("nick", "");
        paramList1.put("addr", paramList);
        paramList1.put("valid", "false");
        return paramList1;
      }
      label334:
      paramList1 = "";
      paramList = "";
    }
  }
  
  private static boolean check(String paramString1, String paramString2)
  {
    return Pattern.compile(paramString1).matcher(paramString2).matches();
  }
  
  private static boolean isEmailAddress(String paramString)
  {
    Object localObject = pattern.matcher(paramString);
    if (!((Matcher)localObject).matches()) {}
    int j;
    label64:
    do
    {
      return false;
      paramString = ((Matcher)localObject).group(1);
      localObject = ((Matcher)localObject).group(2);
      i = 0;
      for (;;)
      {
        if (i >= paramString.length()) {
          break label64;
        }
        j = Character.codePointAt(paramString, i);
        if ((j > 126) || (j < 32)) {
          break;
        }
        i += 1;
      }
    } while (!aliasPattern.matcher(paramString).find());
    int i = 0;
    for (;;)
    {
      if (i >= ((String)localObject).length()) {
        break label112;
      }
      j = Character.codePointAt((CharSequence)localObject, i);
      if ((j > 126) || (j < 32)) {
        break;
      }
      i += 1;
    }
    label112:
    paramString = ipDomainPattern.matcher((CharSequence)localObject);
    if (paramString.find())
    {
      i = 1;
      for (;;)
      {
        if (i > 4) {
          break label155;
        }
        if (Integer.parseInt(paramString.group(i)) > 255) {
          break;
        }
        i += 1;
      }
    }
    label155:
    paramString = ((String)localObject).split("\\.");
    i = 0;
    for (;;)
    {
      if (i >= paramString.length) {
        break label192;
      }
      if (!atomPattern.matcher(paramString[i]).find()) {
        break;
      }
      i += 1;
    }
    label192:
    return true;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("492659760@qq.com;");
    paramArrayOfString = parseAddr("492659760@qq.com;");
    int i = 0;
    while (i < paramArrayOfString.size())
    {
      System.out.println(paramArrayOfString.get(i));
      i += 1;
    }
  }
  
  public static List<HashMap<String, String>> parseAddr(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    paramString = paramString.replace('\t', ' ').replaceAll("　", " ").replaceAll(" ", "");
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.trim())
    {
      int j = paramString.length();
      List localList;
      for (int i = 0; i < j; i = Integer.parseInt(String.valueOf(localList.get(0))))
      {
        Object localObject = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localList = _getSegment(paramString, i, (List)localObject, localArrayList2);
        localObject = _parseSegment(String.valueOf(localList.get(1)), (List)localObject, localArrayList2);
        if (String.valueOf(((HashMap)localObject).get("addr")).length() >= 1) {
          localArrayList1.add(localObject);
        }
      }
    }
    return localArrayList1;
  }
  
  private static boolean startWithDigit(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((paramString.charAt(0) != '0') && (paramString.charAt(0) != '1') && (paramString.charAt(0) != '2') && (paramString.charAt(0) != '3') && (paramString.charAt(0) != '4') && (paramString.charAt(0) != '5') && (paramString.charAt(0) != '6') && (paramString.charAt(0) != '7') && (paramString.charAt(0) != '8') && (paramString.charAt(0) != '9')) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.addressparser.QMAddressParser
 * JD-Core Version:    0.7.0.1
 */