import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class jkb
{
  private static volatile jkb jdField_b_of_type_Jkb;
  VideoController a = null;
  BroadcastReceiver ab = new jkc(this);
  jkb.a jdField_b_of_type_Jkb$a = null;
  List<String> fG = new ArrayList();
  VideoAppInterface mApp = null;
  Context mContext = null;
  String mSessionId = null;
  
  private jkb(VideoAppInterface paramVideoAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.getNearByProfile");
    this.mApp = paramVideoAppInterface;
    this.mApp.getApp();
    this.mContext = BaseApplication.getContext();
    this.mContext.registerReceiver(this.ab, localIntentFilter);
    this.a = this.mApp.b();
  }
  
  public static jkb a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_b_of_type_Jkb == null) {}
    try
    {
      if (jdField_b_of_type_Jkb == null) {
        jdField_b_of_type_Jkb = new jkb(paramVideoAppInterface);
      }
      return jdField_b_of_type_Jkb;
    }
    finally {}
  }
  
  public void a(jkb.a parama)
  {
    this.jdField_b_of_type_Jkb$a = parama;
  }
  
  public void axp()
  {
    this.jdField_b_of_type_Jkb$a = null;
    this.mContext.unregisterReceiver(this.ab);
    this.fG.clear();
    this.a = null;
    this.mContext = null;
    this.mApp = null;
    jdField_b_of_type_Jkb = null;
  }
  
  /* Error */
  public void e(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 102	igv:a	()Ligv;
    //   5: aload_0
    //   6: getfield 44	jkb:mSessionId	Ljava/lang/String;
    //   9: invokevirtual 106	igv:c	(Ljava/lang/String;)Liiv;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 42	jkb:fG	Ljava/util/List;
    //   24: aload_2
    //   25: invokeinterface 110 2 0
    //   30: ifne -13 -> 17
    //   33: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +28 -> 64
    //   39: ldc 118
    //   41: iconst_2
    //   42: new 120	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   49: ldc 123
    //   51: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 139	com/tencent/av/app/VideoAppInterface:cp	(Ljava/lang/String;)Z
    //   69: ifeq -52 -> 17
    //   72: aload_0
    //   73: getfield 42	jkb:fG	Ljava/util/List;
    //   76: aload_2
    //   77: invokeinterface 142 2 0
    //   82: pop
    //   83: goto -66 -> 17
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	jkb
    //   0	91	1	paramVideoAppInterface	VideoAppInterface
    //   0	91	2	paramString	String
    //   12	2	3	localiiv	iiv
    // Exception table:
    //   from	to	target	type
    //   2	13	86	finally
    //   20	64	86	finally
    //   64	83	86	finally
  }
  
  public void kJ(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, jkb.b paramb);
  }
  
  public class b
  {
    public int age;
    public byte constellation;
    public int gender;
    public String nickname;
    public String uin;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkb
 * JD-Core Version:    0.7.0.1
 */