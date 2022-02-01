import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class asxk
  implements rqi
{
  asxk(asxf paramasxf, long paramLong1, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt, String paramString2, long paramLong2) {}
  
  public void onFailure(String paramString)
  {
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      QLog.w("VideoJsPlugin", 1, "onFailure: " + str);
      i += 1;
    }
    if (this.val$cmd.contains("-vf"))
    {
      asxf.a(this.this$0, this.val$info, false);
      return;
    }
    paramString = ((IMiniAppFileManager)asxf.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.val$info.path);
    asxf.a(this.this$0, paramString, this.val$info.fileSize, this.val$info);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress finish " + paramBoolean + " " + (System.currentTimeMillis() - this.val$now));
    }
  }
  
  public void onProgress(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress progress " + paramString);
    }
    if ((paramString.length() < 90) || (paramString.length() > 150)) {}
    for (;;)
    {
      return;
      String str = new Scanner(paramString).findWithinHorizon(asxf.a(), 0);
      if (QLog.isColorLevel()) {
        QLog.i("VideoJsPlugin", 2, "onProgress: " + paramString.length());
      }
      if (str != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoJsPlugin", 2, "onProgress: valid " + paramString.length());
        }
        paramString = str.split(":");
        if (paramString.length > 2) {
          try
          {
            int i = Integer.parseInt(paramString[0]);
            int j = Integer.parseInt(paramString[1]);
            double d = Double.parseDouble(paramString[2]);
            i = (int)((float)(TimeUnit.HOURS.toMillis(i) + TimeUnit.MINUTES.toMillis(j) + (1000.0D * d)) * 100.0F / (float)this.val$duration);
            if (i < 100)
            {
              asxf.a(this.this$0, acfp.m(2131716418) + i + "%");
              return;
            }
          }
          catch (NumberFormatException paramString) {}
        }
      }
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress success " + paramString + " " + this.val$cmd);
    }
    if (this.val$cmd.contains("-vf"))
    {
      paramString = this.val$info;
      paramString.mediaWidth /= this.val$compressMultiple;
      paramString = this.val$info;
      paramString.mediaHeight /= this.val$compressMultiple;
    }
    paramString = ((IMiniAppFileManager)asxf.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.val$outPath);
    asxf.a(this.this$0, paramString, new File(this.val$outPath).length(), this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxk
 * JD-Core Version:    0.7.0.1
 */