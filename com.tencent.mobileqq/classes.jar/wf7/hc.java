package wf7;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.wifisdk.services.common.api.IThreadPool;
import java.io.File;

public class hc
{
  public static final String TAG = hc.class.getSimpleName();
  public static String sF = "tencent" + File.separator + "apdl" + File.separator;
  private Context mContext;
  private hc.a sE;
  private IThreadPool sd;
  
  public hc(Context paramContext, IThreadPool paramIThreadPool)
  {
    this.mContext = paramContext;
    this.sd = paramIThreadPool;
  }
  
  public String a(String paramString1, String paramString2, hc.b paramb)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    String str2 = ha.Z(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString1;
    }
    this.sE = new hc.a(this, paramString1, paramString2, paramb);
    this.sd.addTask(this.sE, "startDownloadTask", 4);
    return str1;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.hc
 * JD-Core Version:    0.7.0.1
 */