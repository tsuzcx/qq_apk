import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class aljl
  extends alji
{
  protected String D(QQAppInterface paramQQAppInterface)
  {
    if (aqmr.isEmpty(this.bWH)) {
      paramQQAppInterface = "";
    }
    aegp localaegp;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.bWH.equalsIgnoreCase("qqgame")) {
          return aqqj.getUrl("vipGameCenter");
        }
        if (!this.bWH.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localaegp = ((aegs)paramQQAppInterface.getManager(269)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localaegp == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localaegp.bwV));
    return localaegp.bwV;
    if (this.bWH.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = aqmj.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return acgu.bow;
    }
    if (this.bWH.equalsIgnoreCase("bodong")) {}
    return "";
  }
  
  protected void a(aqhv paramaqhv, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.bWH.equalsIgnoreCase("qqgame")) {
      paramaqhv.gY("platformId=qq_m");
    }
  }
  
  protected boolean e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !aqmr.isEmpty(this.bWD);
  }
  
  protected void i(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = D(paramQQAppInterface);
    if (aqmr.isEmpty(paramQQAppInterface)) {
      return;
    }
    this.bWD = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljl
 * JD-Core Version:    0.7.0.1
 */