import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.a;
import com.tencent.tim.filemanager.widget.FileWebView;

public class atoi
  implements FilePreviewActivity.a
{
  public atoi(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (this.this$0.ccO) {}
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Atwe != null) {
        this.this$0.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
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
          if (this.this$0.jdField_a_of_type_Atwe != null)
          {
            this.this$0.jdField_a_of_type_Atwe.cew = false;
            this.this$0.jdField_a_of_type_Atwe.Zk = (this.this$0.jdField_a_of_type_Atwe.endTime - this.this$0.jdField_a_of_type_Atwe.startTime);
            this.this$0.jdField_a_of_type_Atwe.bIq = String.valueOf(paramLong);
            this.this$0.jdField_a_of_type_Atwe.bIu = paramString3;
            this.this$0.jdField_a_of_type_Atwe.bIp = paramString6;
            this.this$0.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Atwe.mInitTime);
            this.this$0.jdField_a_of_type_Atwe.doReport();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[" + paramString3 + "]");
          return;
          this.this$0.Sh.setText("文档加载失败，请稍后重试。");
        }
      }
      this.this$0.bGu = paramString1;
      this.this$0.bGv = paramString2;
      this.this$0.bGt = paramString4;
      this.this$0.strCookie = paramString5;
      this.this$0.bGp = ("http://" + paramString1 + ":" + paramString2 + "/ftn_doc_previewer/" + this.this$0.bGw);
      this.this$0.mUuid = paramString6;
      if (this.this$0.jdField_a_of_type_Atwe != null)
      {
        this.this$0.jdField_a_of_type_Atwe.cew = true;
        this.this$0.jdField_a_of_type_Atwe.bIs = paramString4;
        this.this$0.jdField_a_of_type_Atwe.bIu = "";
        this.this$0.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
        this.this$0.jdField_a_of_type_Atwe.Zk = (this.this$0.jdField_a_of_type_Atwe.endTime - this.this$0.jdField_a_of_type_Atwe.startTime);
        this.this$0.jdField_a_of_type_Atwe.bIo = paramString1;
        this.this$0.jdField_a_of_type_Atwe.bIr = this.this$0.bGp;
        this.this$0.jdField_a_of_type_Atwe.bIp = paramString6;
        this.this$0.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Atwe.mInitTime);
        this.this$0.jdField_a_of_type_Atwe.doReport();
      }
      if (this.this$0.bGp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("<FileAssistant>FilePreviewActivity", 2, "mPreviewUrl is null ,threadid[" + Thread.currentThread().getId() + "], mainId[" + Looper.getMainLooper().getThread().getId() + "]");
        }
        this.this$0.finish();
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl(this.this$0.bGp);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + this.this$0.bGp + ")");
      }
    } while (this.this$0.jdField_a_of_type_Atwe == null);
    this.this$0.jdField_a_of_type_Atwe.startTime = System.currentTimeMillis();
    this.this$0.jdField_a_of_type_Atwe.bIw = "2";
  }
  
  public void g(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (this.this$0.ccO) {}
    do
    {
      do
      {
        return;
        if (this.this$0.jdField_a_of_type_Atwe != null) {
          this.this$0.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
        }
        this.this$0.ccO = true;
        if (paramBoolean) {
          break;
        }
        this.this$0.Sh.setText("文档加载失败，请稍后重试。");
        this.this$0.iS.setVisibility(0);
        this.this$0.iS.setOnClickListener(null);
        this.this$0.zE.setVisibility(0);
        this.this$0.Sh.setVisibility(0);
        this.this$0.ccR = true;
        this.this$0.stopTitleProgress();
        if (this.this$0.jdField_a_of_type_Atwe != null)
        {
          this.this$0.jdField_a_of_type_Atwe.cew = false;
          this.this$0.jdField_a_of_type_Atwe.Zk = (this.this$0.jdField_a_of_type_Atwe.endTime - this.this$0.jdField_a_of_type_Atwe.startTime);
          this.this$0.jdField_a_of_type_Atwe.bIq = String.valueOf(0);
          this.this$0.jdField_a_of_type_Atwe.bIu = "Uuid is empty";
          this.this$0.jdField_a_of_type_Atwe.bIp = paramString1;
          this.this$0.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Atwe.mInitTime);
          this.this$0.jdField_a_of_type_Atwe.doReport();
        }
      } while (!QLog.isColorLevel());
      QLog.e("<FileAssistant>FilePreviewActivity", 2, "OnCSReplay[false],retMsg[Uuid is empty]");
      return;
      FilePreviewActivity.a(this.this$0, true);
      this.this$0.bGu = "preview.qpic.cn";
      this.this$0.bGv = "80";
      this.this$0.bGt = paramString2;
      FilePreviewActivity.a(this.this$0, paramInt);
      this.this$0.bGp = ("http://" + this.this$0.bGu + ":" + this.this$0.bGv + "/ftn_doc_previewer/" + this.this$0.bGw);
      this.this$0.mUuid = paramString1;
      if (this.this$0.jdField_a_of_type_Atwe != null)
      {
        this.this$0.jdField_a_of_type_Atwe.cew = true;
        this.this$0.jdField_a_of_type_Atwe.bIs = paramString2;
        this.this$0.jdField_a_of_type_Atwe.bIu = "";
        this.this$0.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
        this.this$0.jdField_a_of_type_Atwe.Zk = (this.this$0.jdField_a_of_type_Atwe.endTime - this.this$0.jdField_a_of_type_Atwe.startTime);
        this.this$0.jdField_a_of_type_Atwe.bIo = this.this$0.bGu;
        this.this$0.jdField_a_of_type_Atwe.bIr = this.this$0.bGp;
        this.this$0.jdField_a_of_type_Atwe.bIp = paramString1;
        this.this$0.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Atwe.mInitTime);
        this.this$0.jdField_a_of_type_Atwe.doReport();
      }
      this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl(this.this$0.bGp);
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 2, "time[" + System.currentTimeMillis() + "]OnCSReplay mWebView.loadUrl(" + this.this$0.bGp + ")");
      }
    } while (this.this$0.jdField_a_of_type_Atwe == null);
    this.this$0.jdField_a_of_type_Atwe.startTime = System.currentTimeMillis();
    this.this$0.jdField_a_of_type_Atwe.bIw = "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoi
 * JD-Core Version:    0.7.0.1
 */