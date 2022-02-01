public class awen
{
  public static String cPA = "famousShareToQQFriend";
  public static String cPB = "famousShareToQzone";
  public static String cPC = "famousShareToWxFriend";
  public static String cPD = "famousShareToWxPengyouquan";
  public static String cPE = "famousJubao";
  public static String cPF = "setUserHomePageMsgBoardGate";
  public static String cPG = "SetHostMessage";
  public static String cPH = "writeMood";
  public static final String cPI = acfp.m(2131713130);
  public static final String cPJ = acfp.m(2131713129);
  public static String cPz = "JsFamousShare";
  public static String[] jc = { "SetPersonalizeFinished", "setAvatar", "SetNaviDeco", "setFloat", "updateCustomPraise", "setcardfinish", "updatePloymorphicPraise", "setResponsiveLike", "OpenCustomVipSucc", "SetFacade", "setFriendNaviDeco", "SetPlayerDeco", "setDefaultFont", "refreshFeeds", "setCustomTrack" };
  
  public static boolean tQ(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jc;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awen
 * JD-Core Version:    0.7.0.1
 */