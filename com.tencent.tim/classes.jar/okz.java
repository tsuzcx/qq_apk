import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class okz
  implements okn
{
  protected static final okv b = okv.a();
  private static Handler mMainHandler = new Handler(Looper.getMainLooper());
  public static boolean needPrintRequest;
  public transient oko a;
  public okp a;
  public okw a;
  public Object bb;
  public int bfj;
  public HashMap<Object, Object> extraData = new HashMap();
  private WeakReference<Handler> mHandler;
  public int mResultCode;
  public int mType;
  public transient UniAttribute mUniAttr;
  public transient String msg = "";
  public int taskRetryCount;
  public long timestamp;
  
  public okz()
  {
    this.timestamp = System.currentTimeMillis();
  }
  
  public okz(okw paramokw, Handler paramHandler, oko paramoko, int paramInt)
  {
    this.jdField_a_of_type_Okw = paramokw;
    this.mType = paramInt;
    this.jdField_a_of_type_Oko = paramoko;
    this.timestamp = System.currentTimeMillis();
    if (paramHandler != null) {
      this.mHandler = new WeakReference(paramHandler);
    }
  }
  
  private String getErrString(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    default: 
      return "";
    case 1000006: 
      QZLog.i("QZLog", 1, "WeishiTask\t 网络无连接");
      return QzoneConfig.getInstance().getConfig("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    case 1000004: 
      return "";
    }
    return "";
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, okp paramokp)
  {
    if ((paramObject instanceof UniAttribute)) {
      this.mUniAttr = ((UniAttribute)paramObject);
    }
    this.bb = paramObject;
    this.mResultCode = paramInt1;
    this.bfj = paramInt2;
    this.msg = paramString;
    this.jdField_a_of_type_Okp = paramokp;
    if (1000006 == paramInt1) {}
    oks.a().c(this);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Okw != null)
    {
      this.jdField_a_of_type_Okw.setRequestRetryCount(this.taskRetryCount);
      if (needPrintRequest)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.jdField_a_of_type_Okw.req != null) {
          this.jdField_a_of_type_Okw.req.display(localStringBuilder, 0);
        }
      }
      ooz.i("WeishiTask", "startRunTask: " + this.jdField_a_of_type_Okw.getCmdString() + ", " + this.jdField_a_of_type_Okw.toString());
    }
    int i = b.a(this.jdField_a_of_type_Okw, this);
    if (i != 0) {
      a(null, i, i, getErrString(i), false, this.jdField_a_of_type_Okp);
    }
  }
  
  public boolean succeeded()
  {
    return (this.mResultCode == 0) || (this.mResultCode == 1000) || ((Math.abs(this.mResultCode) <= 19999) && (Math.abs(this.mResultCode) >= 19000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okz
 * JD-Core Version:    0.7.0.1
 */