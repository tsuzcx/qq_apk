import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aelc
{
  private static final String bzh = acfp.m(2131709050);
  private static final String bzi = acfp.m(2131709044);
  private static final String bzj = acfp.m(2131709031);
  private static final String bzk = acfp.m(2131709034);
  private static final String bzl = acfp.m(2131709039);
  private static final String bzm = acfp.m(2131709046);
  private static final String bzn = acfp.m(2131709038);
  private static final String bzo = acfp.m(2131709035);
  private static final String bzp = acfp.m(2131709032);
  private static final String bzq = acfp.m(2131709036);
  private static final String bzr = acfp.m(2131709049);
  private static final String bzs = acfp.m(2131709041);
  private static final String bzt = acfp.m(2131709033);
  private static final String bzu = acfp.m(2131709037);
  public final aelc.a a = new aelc.a(bzh, bzi, bzj);
  public final aelc.a b = new aelc.a(bzk, bzl, bzm);
  public boolean bUU;
  public final aelc.a c = new aelc.a(bzn, "", bzo);
  public final aelc.a d = new aelc.a(bzp, "", bzq);
  public final aelc.a e = new aelc.a(bzr, "", bzs);
  public final aelc.a f = new aelc.a(bzt, "", bzu);
  public int totalCount = 3;
  
  public static aelc a(aeic[] paramArrayOfaeic)
  {
    aelc localaelc = new aelc();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      int j = paramArrayOfaeic.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaeic[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aeic)localObject).content;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localaelc.bUU = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localaelc.totalCount = localJSONObject.optInt("totalCount", 0);
            a(localaelc.a, localJSONObject.optJSONObject("unauthorized"), bzh, bzi, bzj);
            a(localaelc.b, localJSONObject.optJSONObject("unbound"), bzk, bzl, bzj);
            a(localaelc.c, localJSONObject.optJSONObject("contactsListUnauthorized"), bzn, "", bzo);
            a(localaelc.d, localJSONObject.optJSONObject("contactsListUnbinding"), bzp, "", bzq);
            a(localaelc.e, localJSONObject.optJSONObject("contactsListInactive"), bzr, "", bzs);
            a(localaelc.f, localJSONObject.optJSONObject("contactsListUnmatched"), bzt, "", bzu);
            if (QLog.isColorLevel()) {
              QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + (String)localObject);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendContactGuideConfBean", 2, "parse: " + localaelc);
    }
    return localaelc;
  }
  
  private static void a(aelc.a parama, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (parama == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      parama.title = paramJSONObject.optString("title", paramString1);
      parama.subTitle = paramJSONObject.optString("subTitle", paramString2);
      parama.buttonTitle = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    parama.title = paramString1;
    parama.subTitle = paramString2;
    parama.buttonTitle = paramString3;
  }
  
  public String toString()
  {
    return "NewFriendContactGuideConfBean(" + this.bUU + ", " + this.totalCount + ", " + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ")";
  }
  
  public static class a
  {
    public String buttonTitle;
    public String subTitle;
    public String title;
    
    a(String paramString1, String paramString2, String paramString3)
    {
      this.title = paramString1;
      this.subTitle = paramString2;
      this.buttonTitle = paramString3;
    }
    
    public String toString()
    {
      return "UIElement(" + this.title + ", " + this.subTitle + ", " + this.buttonTitle + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelc
 * JD-Core Version:    0.7.0.1
 */