import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.a;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

public class agbx
  implements FilePreviewActivity.a
{
  public agbx(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.this$0.ccO) {}
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Agnf != null) {
        this.this$0.jdField_a_of_type_Agnf.endTime = System.currentTimeMillis();
      }
      this.this$0.ccO = true;
      if (!paramBoolean)
      {
        if ((paramString3 != null) && (paramString3.length() > 0)) {
          this.this$0.Sh.setText(paramString3);
        }
        for (;;)
        {
          this.this$0.iS.setVisibility(0);
          this.this$0.iS.setOnClickListener(null);
          this.this$0.zE.setVisibility(0);
          this.this$0.Sh.setVisibility(0);
          this.this$0.ccR = true;
          this.this$0.stopTitleProgress();
          if (this.this$0.jdField_a_of_type_Agnf != null)
          {
            this.this$0.jdField_a_of_type_Agnf.cew = false;
            this.this$0.jdField_a_of_type_Agnf.Zk = (this.this$0.jdField_a_of_type_Agnf.endTime - this.this$0.jdField_a_of_type_Agnf.startTime);
            this.this$0.jdField_a_of_type_Agnf.bIq = String.valueOf(paramLong);
            this.this$0.jdField_a_of_type_Agnf.bIu = paramString3;
            this.this$0.jdField_a_of_type_Agnf.bIp = paramString6;
            this.this$0.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Agnf.mInitTime);
            this.this$0.jdField_a_of_type_Agnf.doReport();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[" + paramString3 + "]");
          return;
          this.this$0.Sh.setText(acfp.m(2131706286));
        }
      }
      paramBoolean = false;
      if (paramBundle != null)
      {
        paramBoolean = paramBundle.getBoolean("ishttps", false);
        paramString1 = paramBundle.getString("httpsdomain", null);
        paramString2 = paramBundle.getShort("httpsport", (short)0) + "";
      }
      this.this$0.bGu = paramString1;
      this.this$0.bGv = paramString2;
      this.this$0.ccM = paramBoolean;
      this.this$0.bGt = paramString4;
      this.this$0.strCookie = paramString5;
      if (paramBoolean) {}
      for (this.this$0.bGp = ("https://" + paramString1 + ":" + paramString2 + "/ftn_doc_previewer/" + this.this$0.bGw);; this.this$0.bGp = ("http://" + paramString1 + ":" + paramString2 + "/ftn_doc_previewer/" + this.this$0.bGw))
      {
        this.this$0.mUuid = paramString6;
        if (this.this$0.jdField_a_of_type_Agnf != null)
        {
          this.this$0.jdField_a_of_type_Agnf.cew = true;
          this.this$0.jdField_a_of_type_Agnf.bIs = paramString4;
          this.this$0.jdField_a_of_type_Agnf.bIu = "";
          this.this$0.jdField_a_of_type_Agnf.endTime = System.currentTimeMillis();
          this.this$0.jdField_a_of_type_Agnf.Zk = (this.this$0.jdField_a_of_type_Agnf.endTime - this.this$0.jdField_a_of_type_Agnf.startTime);
          this.this$0.jdField_a_of_type_Agnf.bIo = paramString1;
          this.this$0.jdField_a_of_type_Agnf.bIr = this.this$0.bGp;
          this.this$0.jdField_a_of_type_Agnf.bIp = paramString6;
          this.this$0.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Agnf.mInitTime);
          this.this$0.jdField_a_of_type_Agnf.doReport();
        }
        if (this.this$0.bGp != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "mPreviewUrl is null ,threadid[" + Thread.currentThread().getId() + "], mainId[" + Looper.getMainLooper().getThread().getId() + "]");
        }
        this.this$0.finish();
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl(this.this$0.bGp);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + this.this$0.bGp + ")");
      }
    } while (this.this$0.jdField_a_of_type_Agnf == null);
    this.this$0.jdField_a_of_type_Agnf.startTime = System.currentTimeMillis();
    this.this$0.jdField_a_of_type_Agnf.bIw = "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbx
 * JD-Core Version:    0.7.0.1
 */