import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webdownload.DownloadURLCheck.RspDownloadUrlCheckRecmd;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class agjl
  implements BusinessObserver
{
  agjl(agjj.a parama, String paramString, long paramLong, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("UniformDownloadMgr<FileAssistant>", 2, "handleCheck, success: " + paramBoolean + ", canceled: " + agjj.a.a(this.a));
    }
    Activity localActivity = (Activity)agjj.a.a(this.a).get();
    if ((agjj.a.a(this.a)) || (localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_url", this.val$url);
    localIntent.putExtra("_filesize", this.val$contentLength);
    localIntent.putExtra("big_brother_source_key", localActivity.getIntent().getStringExtra("big_brother_source_key"));
    DownloadURLCheck.RspDownloadUrlCheckRecmd localRspDownloadUrlCheckRecmd;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("extra_data");
      if (paramBundle != null) {
        localRspDownloadUrlCheckRecmd = new DownloadURLCheck.RspDownloadUrlCheckRecmd();
      }
    }
    for (;;)
    {
      try
      {
        localRspDownloadUrlCheckRecmd.mergeFrom(paramBundle);
        if (localRspDownloadUrlCheckRecmd.err_code.has())
        {
          if (localRspDownloadUrlCheckRecmd.err_code.get() != 0) {
            continue;
          }
          paramInt = 1;
          if (QLog.isColorLevel()) {
            QLog.d("UniformDownloadMgr<FileAssistant>", 2, "handleCheck, code: " + localRspDownloadUrlCheckRecmd.err_code.get());
          }
          if (paramInt != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start download from yyb");
            }
            if ((!localRspDownloadUrlCheckRecmd.is_white_url.has()) || (!localRspDownloadUrlCheckRecmd.is_white_url.get())) {
              continue;
            }
            paramBoolean = true;
            localIntent.putExtra("param_in_white_list", paramBoolean);
            if (!localRspDownloadUrlCheckRecmd.pkg_name.has()) {
              continue;
            }
            paramBundle = localRspDownloadUrlCheckRecmd.pkg_name.get();
            localIntent.putExtra("param_pkg_name", paramBundle);
            paramBundle = localObject;
            if (localRspDownloadUrlCheckRecmd.extra_info.has()) {
              paramBundle = localRspDownloadUrlCheckRecmd.extra_info.get();
            }
            localIntent.putExtra("param_ext_info", paramBundle);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramBundle, new Object[0]);
        continue;
        this.a.uiHandler.sendEmptyMessage(2);
      }
      PublicFragmentActivity.b.start(localActivity, localIntent, PublicFragmentActivity.class, ApkFileDownloadFragment.class);
      if (!this.cdD) {
        continue;
      }
      localActivity.finish();
      return;
      paramInt = 0;
      continue;
      paramBoolean = false;
      continue;
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjl
 * JD-Core Version:    0.7.0.1
 */