import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class abvq
{
  static abvq jdField_a_of_type_Abvq;
  private abvy.c jdField_a_of_type_Abvy$c = new abvx(this);
  abwd jdField_a_of_type_Abwd;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new abvw(this);
  public asrs b;
  private boolean bFX;
  public Context context;
  int cte = 0;
  Map<String, Integer> jd = new HashMap();
  public String mAppID = "";
  
  public static abvq a()
  {
    if (jdField_a_of_type_Abvq == null) {
      jdField_a_of_type_Abvq = new abvq();
    }
    return jdField_a_of_type_Abvq;
  }
  
  private void cFL()
  {
    abwe.a().a(this.jdField_a_of_type_Abwd, new abvr(this));
  }
  
  public void B(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Abwd = new abwd(paramInt, paramString1, paramString2);
  }
  
  public void CT(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    abvy.a(this.context).exitRoom();
  }
  
  public void CU(String paramString)
  {
    abvy.a(this.context).CU(paramString);
  }
  
  public void Ek(boolean paramBoolean)
  {
    abvy.a(this.context).a(paramBoolean, new abvu(this));
  }
  
  public void El(boolean paramBoolean)
  {
    abvy.a(this.context).a(paramBoolean, new abvv(this));
  }
  
  public void Ij(int paramInt)
  {
    this.cte = paramInt;
  }
  
  boolean Zm()
  {
    try
    {
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      int i = localGraphicRendererMgr.getRecvDecoderFrameFunctionptr();
      QLog.e("AVEngineWalper", 1, "mgr=" + String.valueOf(localGraphicRendererMgr) + ", nFunID=" + String.valueOf(i));
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AVEngineWalper", 1, "CheckGraphicMgrStart stack=" + QLog.getStackTraceString(localThrowable));
    }
    return false;
  }
  
  public void a(asrs paramasrs)
  {
    this.b = paramasrs;
  }
  
  public void cFM()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    abvy.a(this.context).zU();
    abvy.a(this.context).cFP();
  }
  
  public void cFN()
  {
    abvy.a(this.context).pauseAudio();
  }
  
  public void cFO()
  {
    abvy.a(this.context).resumeAudio();
  }
  
  public void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    abvy.a(this.context).a(paramString, paramBoolean1, paramBoolean2, this.cte, new abvs(this));
  }
  
  public void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    asrt.a().a(Integer.valueOf(this.mAppID).intValue(), new abvt(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void hc(long paramLong)
  {
    abvy.a(this.context).he(paramLong);
  }
  
  public void hd(long paramLong)
  {
    abvy.a(this.context).hf(paramLong);
  }
  
  public void j(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, abwc.oE());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.context = paramContext;
    this.mAppID = paramString2;
    abvy.a(this.context).a(this.jdField_a_of_type_Abvy$c);
    abvy.a(this.context).dE(this.context);
    paramContext = new abvy.a();
    paramContext.bih = paramString2;
    paramContext.accountType = paramString3;
    paramContext.identifier = paramString1;
    abvy.a(this.context).a(paramContext);
    cFL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvq
 * JD-Core Version:    0.7.0.1
 */