import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amcj
{
  private long Jw;
  private String QE;
  private String aRJ;
  private String aWf;
  private int bWM;
  private int bWO;
  protected int bWR = -1;
  private boolean biE;
  private boolean biF;
  private boolean biH;
  private boolean biL;
  private boolean biO;
  private boolean biT;
  boolean cCh = true;
  public boolean cCi;
  public boolean cCj = true;
  private int loadType;
  private int mCurType;
  private String mFriendUin;
  public Rect thumbRect;
  
  public static amcj a()
  {
    return amcj.a.b();
  }
  
  public void D(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    this.biT = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.biH = localBundle.getBoolean("extra.IS_APOLLO");
    this.QE = localBundle.getString("extra.GROUP_UIN");
    this.aRJ = localBundle.getString("extra.GROUP_CODE");
    this.biF = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.Jw = localBundle.getLong("key_multi_forward_seq", 0L);
    this.mCurType = localBundle.getInt("forward_source_uin_type", -1);
    this.mFriendUin = localBundle.getString("uin");
    this.aWf = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool;
    if (TextUtils.isEmpty(localBundle.getString("babyq_video_type")))
    {
      bool = false;
      this.biO = bool;
      this.bWR = localBundle.getInt("extra.EXTRA_ENTRANCE");
      if ((!this.biH) && (this.bWR != 4) && (!localBundle.getBoolean("is_one_item"))) {
        break label272;
      }
      bool = true;
      label168:
      this.biE = bool;
      if (!paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false)) {
        break label277;
      }
    }
    label272:
    label277:
    for (int i = 1;; i = 0)
    {
      this.loadType = i;
      this.bWM = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
      this.bWO = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
      this.biL = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
      this.cCh = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
      this.cCj = localBundle.getBoolean(avfp.cKr, true);
      this.cCi = localBundle.getBoolean(avfp.cKq);
      return;
      bool = true;
      break;
      bool = false;
      break label168;
    }
  }
  
  public int IA()
  {
    return this.loadType;
  }
  
  public int IB()
  {
    return this.bWR;
  }
  
  public int IC()
  {
    return this.bWM;
  }
  
  public int ID()
  {
    return this.bWO;
  }
  
  public int Iz()
  {
    return this.mCurType;
  }
  
  public boolean avA()
  {
    return this.biH;
  }
  
  public boolean avB()
  {
    return this.biF;
  }
  
  public boolean avC()
  {
    return this.biO;
  }
  
  public boolean avD()
  {
    return this.biE;
  }
  
  public boolean avE()
  {
    return this.biL;
  }
  
  public boolean avF()
  {
    return (this.cCh) && (this.mCurType != -1);
  }
  
  public boolean avG()
  {
    return this.cCh;
  }
  
  public boolean avz()
  {
    return this.biT;
  }
  
  public long gJ()
  {
    return this.Jw;
  }
  
  public Rect getThumbRect()
  {
    return this.thumbRect;
  }
  
  public void n(Rect paramRect)
  {
    this.thumbRect = paramRect;
  }
  
  public String yM()
  {
    if (TextUtils.isEmpty(this.QE)) {
      this.QE = this.mFriendUin;
    }
    return this.QE;
  }
  
  public String yN()
  {
    return this.aRJ;
  }
  
  public String yO()
  {
    return this.mFriendUin;
  }
  
  public String yP()
  {
    return this.aWf;
  }
  
  static class a
  {
    private static final amcj a = new amcj(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcj
 * JD-Core Version:    0.7.0.1
 */