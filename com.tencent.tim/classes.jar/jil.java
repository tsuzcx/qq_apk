import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public class jil
{
  public String Sl;
  public String Sm;
  public String Sn;
  public String So;
  public String Sp = "-9999";
  public String Sq;
  public String Sr;
  public String Ss;
  public String St = "---";
  public boolean Zw;
  public boolean Zx;
  public int aAf;
  public int aAg;
  public int aAh;
  public int aAi;
  public int aAj = -1;
  public int aAk = 0;
  public long mSeq;
  
  public jil(String paramString1, String paramString2, VideoAppInterface paramVideoAppInterface)
  {
    this.Sl = paramString1;
    this.Sm = paramString2;
    this.Zx = TextUtils.equals(this.Sl, paramVideoAppInterface.getCurrentAccountUin());
    this.mSeq = AudioHelper.hG();
  }
  
  public String toString()
  {
    return "mSeq(" + this.mSeq + "), mStartUin(" + this.Sl + "), mPlayUin(" + this.Sm + "), mStarter(" + this.Zx + "), mRedbagId(" + this.Sn + "), SucAboutGame(" + this.Zw + "), ExceptionType(" + this.aAk + "), ErrorType(" + this.aAj + "), ResultCode(" + this.Sp + "), ResultState(" + this.Sq + ")";
  }
  
  public boolean xv()
  {
    return (this.aAk == 1) || (this.aAk == 2) || ((this.aAf == 0) && (this.aAk == 0));
  }
  
  public boolean xw()
  {
    return (this.aAf != 0) && (this.aAk == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jil
 * JD-Core Version:    0.7.0.1
 */