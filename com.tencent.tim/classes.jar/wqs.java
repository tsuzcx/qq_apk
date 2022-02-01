import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextShowAnimator.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.Timer;

public class wqs
{
  private static final String[] cF = { ".", "..", "..." };
  private wqs.a a;
  private String aTU = ".";
  private String aTV = "";
  private String aTW;
  private int bQK;
  private ColorStateList m;
  private QQAppInterface mApp;
  private Timer x;
  
  public void a(QQAppInterface paramQQAppInterface, ColorStateList paramColorStateList, wqs.a parama)
  {
    this.m = paramColorStateList;
    this.mApp = paramQQAppInterface;
    this.x = new Timer();
    this.a = parama;
  }
  
  public SpannableString b(String paramString)
  {
    int i = 3;
    if (paramString.length() - this.aTV.length() < 3)
    {
      this.aTV = paramString;
      this.aTW = (this.aTV + this.aTU);
      paramString = new SpannableString(this.aTW);
      if (this.aTV.length() <= 4) {
        break label227;
      }
    }
    for (;;)
    {
      int j = this.aTV.length() - i;
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null))
      {
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), 0, i, 33);
        paramString.setSpan(new ForegroundColorSpan(this.m.getDefaultColor()), i, this.aTW.length(), 33);
        return paramString;
        this.aTV = paramString.substring(0, this.aTV.length() + 3 - 1);
        break;
      }
      paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#03081a")), 0, i, 33);
      paramString.setSpan(new ForegroundColorSpan(this.m.getDefaultColor()), i, this.aTW.length(), 33);
      return paramString;
      label227:
      i = 1;
    }
  }
  
  public void cba()
  {
    this.x.schedule(new VoiceTextShowAnimator.1(this), 0L, 100L);
  }
  
  public SpannableString g()
  {
    SpannableString localSpannableString = new SpannableString(acfp.m(2131716869) + this.aTU);
    localSpannableString.setSpan(new ForegroundColorSpan(this.m.getDefaultColor()), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  public boolean hE(String paramString)
  {
    return paramString.length() - this.aTV.length() < 3;
  }
  
  public void stop()
  {
    if (this.x != null)
    {
      this.x.cancel();
      this.x = null;
    }
    this.bQK = 0;
    this.aTV = "";
    this.aTW = "";
    this.aTU = "";
  }
  
  public int vU()
  {
    return this.aTW.length();
  }
  
  public static abstract interface a
  {
    public abstract void caM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqs
 * JD-Core Version:    0.7.0.1
 */