import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class afdy
  extends aquy
{
  afdy(afdw paramafdw, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(aquz paramaquz)
  {
    boolean bool;
    int i;
    if (paramaquz.getStatus() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.val$url);
      }
      paramaquz = afdw.a(this.this$0, this.val$outputPath);
      if (this.val$md5.equalsIgnoreCase(paramaquz))
      {
        afdw.a(this.this$0, this.val$outputPath);
        afdw.a(this.this$0, afdw.bDf + "doutuResInfo", this.val$md5);
        aqmj.L(BaseApplication.getContext(), false);
        DuiButtonImageView.aiQ();
        bool = true;
        i = 0;
      }
    }
    for (;;)
    {
      paramaquz = new HashMap();
      paramaquz.put("param_FailCode", String.valueOf(i));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "doutuResDownload", bool, 0L, 0L, paramaquz, "");
      afdw.bXy = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[onDone] checkMd5 failed: " + this.val$outputPath);
      }
      i = 80704;
      aqhq.deleteFile(this.val$outputPath);
      bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + paramaquz.errMsg + " code=" + paramaquz.errCode);
      }
      i = paramaquz.errCode;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdy
 * JD-Core Version:    0.7.0.1
 */