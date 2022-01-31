import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class ztv
  extends DownloadListener
{
  public ztv(SignatureManager paramSignatureManager) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onCancel| task:" + paramDownloadTask);
    }
  }
  
  @TargetApi(9)
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onDone| task:" + paramDownloadTask);
    }
    Object localObject2 = paramDownloadTask.a();
    if (localObject2 != null) {}
    for (int i = ((Bundle)localObject2).getInt("resType");; i = 0)
    {
      switch (i)
      {
      }
      label256:
      label385:
      for (;;)
      {
        return;
        if ((3 == paramDownloadTask.a()) || (paramDownloadTask.a() == 0))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          label177:
          Object localObject1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            paramDownloadTask = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0);
            i = paramDownloadTask.getInt("sigTplCfgVerTemp", 0);
            paramDownloadTask = paramDownloadTask.edit();
            paramDownloadTask.putInt("sigTplCfgVer", i);
            if (Build.VERSION.SDK_INT <= 8) {
              paramDownloadTask.commit();
            }
          }
          else
          {
            if (SignatureManager.a(this.a) == null) {
              break label256;
            }
            paramDownloadTask = new File(SignatureManager.b);
            localObject1 = SignatureManager.a(this.a);
            localObject2 = IndividuationUrlHelper.a("signatureTemplate");
            if (!paramDownloadTask.exists()) {
              break label258;
            }
          }
          label258:
          for (long l = paramDownloadTask.length();; l = -1L)
          {
            ((PreDownloadController)localObject1).a((String)localObject2, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SignatureManager", 2, "[preDownload]:preDownload individual sign Success");
            return;
            paramDownloadTask.apply();
            break label177;
            break;
          }
          if ((3 == paramDownloadTask.a()) || (paramDownloadTask.a() == 0))
          {
            i = ((Bundle)localObject2).getInt("dynamicType");
            localObject1 = ((Bundle)localObject2).getString("tplId");
            localObject2 = ((Bundle)localObject2).getString("fileName");
            paramDownloadTask = null;
            switch (i)
            {
            }
            for (;;)
            {
              if (paramDownloadTask == null) {
                break label385;
              }
              paramDownloadTask = new File(paramDownloadTask);
              if (!DownloaderFactory.a(new File(SignatureTemplateConfig.a((String)localObject1, (String)localObject2)), paramDownloadTask, true)) {
                break;
              }
              this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
              return;
              paramDownloadTask = SignatureTemplateConfig.a((String)localObject1, "dynamic_aio");
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureManager", 2, "sigTplResDownloadListener.onStart| task:" + paramDownloadTask);
    }
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztv
 * JD-Core Version:    0.7.0.1
 */