import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jhz
  extends jit
{
  public jil b;
  
  jhz(jht paramjht)
  {
    super(paramjht);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, int paramInt5)
  {
    jht localjht = a();
    if (localjht == null) {
      return;
    }
    if (this.b == null)
    {
      this.b = new jil(paramString1, paramString2, this.mApp);
      QLog.w("AVRedBag_GameSink", 1, "onGameEnd , mResultData is empty");
    }
    String str1 = this.b.Sl;
    String str2 = this.b.Sm;
    this.b.Sl = paramString1;
    this.b.Sm = paramString2;
    this.b.Zx = TextUtils.equals(paramString1, this.mApp.getCurrentAccountUin());
    this.b.Sn = paramString3;
    this.b.So = paramString4;
    this.b.aAf = paramInt1;
    this.b.aAg = paramInt2;
    this.b.aAh = paramInt3;
    this.b.aAi = paramInt4;
    this.b.St = paramString5;
    this.b.Sq = paramString7;
    this.b.Sp = paramString6;
    this.b.Zw = paramBoolean;
    this.b.aAk = paramInt5;
    if (this.b.Zx) {
      this.b.aAj = jia.d(this.b.St, this.b.Sp, this.b.Sq);
    }
    if ((!this.b.Zx) && (paramBoolean)) {
      anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "avRedPacketFinGameSuc", true, 0L, 0L, null, "");
    }
    paramString1 = new StringBuilder().append("onGameEnd, startUin[").append(str1).append("->").append(this.b.Sl).append("], playUin[").append(str2).append("->").append(this.b.Sm).append("], mStarter[").append(this.b.Zx).append("], score[").append(this.b.aAf).append("/").append(this.b.aAg).append("], Emoji[").append(this.b.aAh).append("/").append(this.b.aAi).append("], money[").append(this.b.St).append("], playerGetRedbagResultCode[").append(this.b.Sp).append("], playerGetRedbagResultState[").append(this.b.Sq).append("], isSucc[").append(this.b.Zw).append("], exceptionType[").append(this.b.aAk).append("], mRedbagErrorType[").append(this.b.aAj).append("], mRedbagId[").append(this.b.Sn).append("], mAuthKey[");
    if (paramString4 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString4.length())
    {
      QLog.w("AVRedBag_GameSink", 1, paramInt1 + "]");
      localjht.b(this.b);
      if ((this.b.Zx) && (this.b.xv()))
      {
        paramString1 = this.mApp.getApp().getString(2131698007);
        jik.a(this.mApp, this.b.Sm, 0, paramString1);
      }
      if (this.b.Zx) {
        jij.kD(this.b.Sn);
      }
      jib.r(this.mApp);
      this.b = null;
      return;
    }
  }
  
  public void g(String paramString1, String paramString2, int paramInt)
  {
    jht localjht = a();
    if (localjht == null) {
      return;
    }
    jil localjil = this.b;
    this.b = new jil(paramString1, paramString2, this.mApp);
    QLog.w("AVRedBag_GameSink", 1, "onGameStart, new[" + this.b + "], last[" + localjil + "], fromType[" + paramInt + "], isAVActivityVisible[" + localjht.xt() + "], isSelfVideoOpen[" + jik.j(this.mApp) + "]");
    if (!this.b.Zx)
    {
      if (!localjht.xt()) {
        jij.awE();
      }
      if (!jik.j(this.mApp)) {
        jij.awF();
      }
    }
    jij.nA(paramInt);
    localjht.a(this);
  }
  
  public String toString()
  {
    return "mResultData[" + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhz
 * JD-Core Version:    0.7.0.1
 */