import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aaeh
{
  private static volatile aaeh jdField_a_of_type_Aaeh;
  private aafa jdField_a_of_type_Aafa;
  private String bcD;
  private String bcE = "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip";
  private int cgj = 5;
  private boolean mIsInit;
  public float threshold = 0.2F;
  
  public static aaeh a()
  {
    if (jdField_a_of_type_Aaeh == null) {}
    try
    {
      if (jdField_a_of_type_Aaeh == null) {
        jdField_a_of_type_Aaeh = new aaeh();
      }
      return jdField_a_of_type_Aaeh;
    }
    finally {}
  }
  
  private void a(String paramString, aaeh.a parama, boolean paramBoolean)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("DrawClassifier", 2, "init modelUrl=" + paramString + ",isRetryLastAfterFail=" + paramBoolean);
    }
    PreloadManager.a().a(localDownloadParam, new aaej(this, paramBoolean, parama));
  }
  
  private void b(wrb paramwrb, aaeh.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "recognize called");
    }
    if ((!this.mIsInit) || (paramwrb == null))
    {
      if (paramb != null) {
        paramb.Cf(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "recognize has not init");
      }
    }
    ThreadManager.excute(new DrawClassifier.3(this, paramb, paramwrb), 16, null, true);
  }
  
  public void a(Context paramContext, String paramString, aaeh.a parama)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          this.bcD = paramString;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "init recogtitle:" + this.bcD + ",mIsInit" + this.mIsInit);
        }
        try
        {
          paramContext = BaseHbFragment.getHbPannelConfig(10);
          if (QLog.isColorLevel()) {
            QLog.d("DrawClassifier", 2, "init configObj:" + paramContext);
          }
          if (paramContext != null)
          {
            this.bcE = paramContext.optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
            this.threshold = ((float)paramContext.optDouble("aThreshold", 0.2000000029802322D));
            this.cgj = paramContext.optInt("topN", 5);
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "init modelUrl=" + this.bcE + ",threshold=" + this.threshold + ",topN" + this.cgj);
        }
        if (this.mIsInit)
        {
          if (parama != null) {
            parama.onInit(true);
          }
          return;
        }
      }
      finally {}
      aafe.a().a(new aaei(this, parama));
    }
  }
  
  public void a(wrb paramwrb, aaeh.b paramb)
  {
    b(paramwrb, paramb);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 66
    //   10: iconst_2
    //   11: new 68	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   18: ldc 212
    //   20: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 106	aaeh:mIsInit	Z
    //   27: invokevirtual 80	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 106	aaeh:mIsInit	Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 106	aaeh:mIsInit	Z
    //   53: aload_0
    //   54: getfield 43	aaeh:jdField_a_of_type_Aafa	Laafa;
    //   57: ifnull -12 -> 45
    //   60: aload_0
    //   61: getfield 43	aaeh:jdField_a_of_type_Aafa	Laafa;
    //   64: invokevirtual 216	aafa:close	()V
    //   67: goto -22 -> 45
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	aaeh
    //   40	2	1	bool	boolean
    //   70	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	70	finally
    //   36	41	70	finally
    //   48	67	70	finally
  }
  
  public String qn()
  {
    if (this.jdField_a_of_type_Aafa == null) {
      return null;
    }
    return this.jdField_a_of_type_Aafa.qm();
  }
  
  public static abstract interface a
  {
    public abstract void onInit(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void Cf(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaeh
 * JD-Core Version:    0.7.0.1
 */