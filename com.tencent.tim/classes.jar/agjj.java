import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webdownload.DownloadURLCheck.ReqDownloadUrlCheckRecmd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.DownloadListener;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class agjj
{
  public static boolean cdC = true;
  public Activity mActivity;
  
  private agjj(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + paramString);
    if ((paramActivity == null) || (paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
      return false;
    }
    new agjj(paramActivity).x(paramString, paramBundle);
    return true;
  }
  
  public void x(String paramString, Bundle paramBundle)
  {
    ahch.a(paramString, new agjk(this, paramBundle, paramString, paramBundle.getLong("_filesize"), paramBundle.getLong("_buttontype", 0L)));
  }
  
  public static class a
    implements DialogInterface.OnDismissListener, Handler.Callback, DownloadListener
  {
    private boolean canceled;
    private boolean ccX;
    private Dialog dialog;
    private WeakReference<Activity> gP;
    private WeakReference<TouchWebView> gQ;
    private WeakReference<AppInterface> n;
    final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
    
    public a(AppInterface paramAppInterface, Activity paramActivity, TouchWebView paramTouchWebView)
    {
      this.n = new WeakReference(paramAppInterface);
      this.gP = new WeakReference(paramActivity);
      this.gQ = new WeakReference(paramTouchWebView);
      if (paramTouchWebView == null) {
        QLog.e("UniformDownloadMgr<FileAssistant>", 1, "constructor: webview is null");
      }
    }
    
    private void a(String paramString1, String paramString2, long paramLong, Activity paramActivity, AppInterface paramAppInterface, boolean paramBoolean)
    {
      if (!paramBoolean) {
        this.uiHandler.sendEmptyMessage(1);
      }
      DownloadURLCheck.ReqDownloadUrlCheckRecmd localReqDownloadUrlCheckRecmd = new DownloadURLCheck.ReqDownloadUrlCheckRecmd();
      localReqDownloadUrlCheckRecmd.download_url.set(paramString1);
      localReqDownloadUrlCheckRecmd.mime_type.set(paramString2);
      try
      {
        localReqDownloadUrlCheckRecmd.uin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
        paramString2 = new NewIntent(paramActivity.getApplicationContext(), ailu.class);
        paramString2.putExtra("extra_cmd", "QQApkSvc.check_download_url");
        paramString2.putExtra("extra_data", localReqDownloadUrlCheckRecmd.toByteArray());
        paramString2.setObserver(new agjl(this, paramString1, paramLong, paramBoolean));
        paramAppInterface.startServlet(paramString2);
        return;
      }
      catch (NumberFormatException paramString2)
      {
        for (;;)
        {
          QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramString2, new Object[0]);
        }
      }
    }
    
    public void Ja(boolean paramBoolean)
    {
      this.ccX = paramBoolean;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return true;
          paramMessage = (Activity)this.gP.get();
        } while ((paramMessage == null) || (paramMessage.isFinishing()));
        if (this.dialog == null)
        {
          this.dialog = new ReportDialog(paramMessage);
          this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
          this.dialog.setCanceledOnTouchOutside(false);
          this.dialog.requestWindowFeature(1);
          this.dialog.setOnDismissListener(this);
          this.dialog.setContentView(2131562047);
          this.dialog.findViewById(2131363405).setBackgroundColor(0);
          ((TextView)this.dialog.findViewById(2131379401)).setText(acfp.m(2131716234));
        }
        this.dialog.show();
        return true;
      } while ((this.dialog == null) || (!this.dialog.isShowing()));
      this.dialog.dismiss();
      return true;
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      this.canceled = true;
    }
    
    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      boolean bool = true;
      Object localObject1 = (TouchWebView)this.gQ.get();
      Activity localActivity = (Activity)this.gP.get();
      Object localObject2 = (AppInterface)this.n.get();
      if ((localObject1 == null) || (localActivity == null) || (localObject2 == null) || (localActivity.isFinishing())) {
        QLog.e("UniformDownloadMgr<FileAssistant>", 1, "download failed, webview=" + localObject1 + ", act=" + localActivity + ", app=" + localObject2);
      }
      do
      {
        return;
        this.canceled = false;
        if ((((TouchWebView)localObject1).getUrl() != null) && (((TouchWebView)localObject1).getUrl().equals(paramString1))) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start UniformDownloadActivity: " + paramString4);
          }
          if (!"application/vnd.android.package-archive".equals(paramString4)) {
            break;
          }
          a(paramString1, paramString4, paramLong, localActivity, (AppInterface)localObject2, bool);
          return;
          bool = false;
        }
        localObject1 = ((TouchWebView)localObject1).getUrl();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("_filesize", paramLong);
        ((Bundle)localObject2).putString("param_user_agent", paramString2);
        ((Bundle)localObject2).putString("param_content_des", paramString3);
        ((Bundle)localObject2).putString("param_mime_type", paramString4);
        ((Bundle)localObject2).putString("param_refer_url", (String)localObject1);
        ((Bundle)localObject2).putBoolean("fromArkAppDownload", this.ccX);
      } while ((!agjj.a(localActivity, paramString1, (Bundle)localObject2)) || (!bool));
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjj
 * JD-Core Version:    0.7.0.1
 */