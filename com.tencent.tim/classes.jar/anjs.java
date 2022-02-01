import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class anjs
  extends aquy
{
  public anjs(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(aquz paramaquz)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (paramaquz.getStatus() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.val$url);
        }
        paramaquz = anjo.access$200(this.val$outputPath);
        if (this.val$md5.equalsIgnoreCase(paramaquz))
        {
          anjo.ed(this.val$outputPath);
          anjo.access$400(anjo.ceq + "videoRedbagResInfo", this.val$md5);
          aqmj.M(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        paramaquz = new HashMap();
        paramaquz.put("param_FailCode", String.valueOf(i));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "videoRedbagResDownload", bool, 0L, 0L, paramaquz, "");
        anjo.bXy = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.val$outputPath);
        }
        aqhq.deleteFile(this.val$outputPath);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + paramaquz.errMsg + " code=" + paramaquz.errCode);
        }
        i = paramaquz.errCode;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjs
 * JD-Core Version:    0.7.0.1
 */