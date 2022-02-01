import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aafe
{
  private static volatile aafe a;
  private String bcG = "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip";
  private boolean mIsInit;
  
  public static aafe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aafe();
      }
      return a;
    }
    finally {}
  }
  
  public void a(aafe.a parama)
  {
    if (this.mIsInit)
    {
      if (parama != null) {
        parama.Ce(true);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = BaseHbFragment.getHbPannelConfig(10);
      if (localJSONObject != null) {
        this.bcG = localJSONObject.optString("aLib", "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TensorFlowlibManager", 2, "init libUrl=" + this.bcG);
    }
    anmc.a().a("tensorflowlite_jni", new aaff(this, parama));
  }
  
  public static abstract interface a
  {
    public abstract void Ce(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafe
 * JD-Core Version:    0.7.0.1
 */