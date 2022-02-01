import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class aveo
{
  private static String TAG = "GMEAVEngineWalper";
  static aveo jdField_a_of_type_Aveo;
  private avev.c jdField_a_of_type_Avev$c = new aveu(this);
  avey jdField_a_of_type_Avey;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new avet(this);
  public asrs b;
  private boolean bFX;
  public Context context;
  int cte = 0;
  Map<String, Integer> jd = new HashMap();
  String mAppID = "";
  
  public static aveo a()
  {
    if (jdField_a_of_type_Aveo == null) {
      jdField_a_of_type_Aveo = new aveo();
    }
    return jdField_a_of_type_Aveo;
  }
  
  private void cFL()
  {
    avez.a().a(this.jdField_a_of_type_Avey, new avep(this));
  }
  
  public void B(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Avey = new avey(paramInt, paramString1, paramString2);
  }
  
  public void CT(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    avev.a(this.context).exitRoom();
  }
  
  public void Ek(boolean paramBoolean)
  {
    if (avev.a(this.context).aKx() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.b != null) {
        this.b.aP(paramBoolean, 0);
      }
      return;
    }
    avev.a(this.context).a(paramBoolean, new aver(this));
  }
  
  public void El(boolean paramBoolean)
  {
    if (avev.a(this.context).aKy() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.b != null) {
        this.b.aQ(paramBoolean, 0);
      }
      return;
    }
    avev.a(this.context).a(paramBoolean, new aves(this));
  }
  
  public void a(asrs paramasrs)
  {
    this.b = paramasrs;
  }
  
  public void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    avev.a(this.context).a(paramString, paramBoolean1, paramBoolean2, this.cte, new aveq(this));
  }
  
  public void f(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    e(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void g(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, avex.oE());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.context = paramContext;
    this.mAppID = paramString2;
    avev.a(this.context).a(this.jdField_a_of_type_Avev$c);
    avev.a(this.context).dE(this.context);
    paramContext = new avev.a();
    paramContext.bih = paramString2;
    paramContext.accountType = paramString3;
    paramContext.key = paramString4;
    paramContext.identifier = paramString1;
    avev.a(this.context).a(paramContext);
    cFL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aveo
 * JD-Core Version:    0.7.0.1
 */