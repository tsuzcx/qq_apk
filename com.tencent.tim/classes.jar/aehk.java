import com.tencent.common.config.AppSetting;

public class aehk
{
  public static aevp a(String paramString)
  {
    aevp localaevp = new aevp();
    paramString = kf(paramString);
    localaevp.bCh = aqoj.pL(aqoj.ca("DESC", paramString));
    localaevp.bCi = aqoj.pL(aqoj.ca("SUBJECT", paramString));
    localaevp.bCj = aqoj.ca("RESPCONDITION", paramString);
    if ((!localaevp.bCj.equals("MANUAL")) && (!localaevp.bCj.equals("AUTO")) && (!localaevp.bCj.equals("SEMIAUTO"))) {
      return null;
    }
    localaevp.bCk = aqoj.ca("RESPDESC", paramString);
    localaevp.bCl = aqoj.ca("RESPCONTENTTYPES", paramString);
    localaevp.bCm = aqoj.ca("RESPDEST", paramString);
    localaevp.bCn = aqoj.ca("RESPCONTENTS", paramString);
    localaevp.bCk = aqoj.pL(localaevp.bCk);
    localaevp.bCm = aqoj.pL(localaevp.bCm).trim();
    localaevp.bCn = aqoj.pL(localaevp.bCn);
    return localaevp;
  }
  
  public static aevp b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return paramString;
      if (paramString.bCj.equals("MANUAL"))
      {
        paramString.Hw(false);
        return paramString;
      }
      if (paramString.bCj.equals("AUTO"))
      {
        paramString.cXp();
        return paramString;
      }
    } while (!paramString.bCj.equals("SEMIAUTO"));
    paramString.cXp();
    return paramString;
  }
  
  public static int cK(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = kf(paramString);
      str = aqoj.ca("RESPCONDITION", paramString);
      if (aqoj.ca("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
        return 3;
      }
      if (str.equals("MANUAL")) {
        return 0;
      }
      if (str.equals("AUTO")) {
        return 1;
      }
    } while (!str.equals("SEMIAUTO"));
    return 2;
  }
  
  private static String kf(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return aqoj.b(aqoj.b(paramString, 0, "||QQNO||", aehp.getUin()), 0, "||LICENCE||", AppSetting.getLC());
  }
  
  public static String kg(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return aqoj.ca("RESPCONTENTTYPES", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aehk
 * JD-Core Version:    0.7.0.1
 */