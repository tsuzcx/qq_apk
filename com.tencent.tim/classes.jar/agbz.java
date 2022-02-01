import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.1;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.2;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.3;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.9.4;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.b;
import com.tencent.qphone.base.util.QLog;

public class agbz
  implements FileWebView.b
{
  long Ym = 0L;
  
  public agbz(FilePreviewActivity paramFilePreviewActivity, Handler paramHandler) {}
  
  public void IR(boolean paramBoolean)
  {
    this.this$0.dfk();
  }
  
  public void dfn()
  {
    this.this$0.dfj();
  }
  
  public void dfo()
  {
    FilePreviewActivity.9.2 local2 = new FilePreviewActivity.9.2(this);
    this.val$handler.postDelayed(local2, 3000L);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "postDelayed(newRunnable, 3000)");
  }
  
  public void dfp()
  {
    this.this$0.runOnUiThread(new FilePreviewActivity.9.4(this));
  }
  
  public void dfq()
  {
    this.this$0.NR(1000);
  }
  
  public void dfr()
  {
    if (this.this$0.ccR) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.Ym < 1000L);
      this.Ym = l;
    } while (this.this$0.ccL);
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
  }
  
  public void hl()
  {
    this.this$0.runOnUiThread(new FilePreviewActivity.9.3(this));
  }
  
  public void onGetMore()
  {
    long l = System.currentTimeMillis();
    if (l - this.Ym < 1000L) {}
    do
    {
      return;
      this.Ym = l;
    } while (this.this$0.ccL);
    if (this.this$0.ccR)
    {
      this.this$0.dfk();
      return;
    }
    if (this.this$0.jdField_a_of_type_Agnf != null)
    {
      this.this$0.jdField_a_of_type_Agnf.bIw = "3";
      this.this$0.jdField_a_of_type_Agnf.startTime = System.currentTimeMillis();
    }
    if (!aqiw.isNetSupport(this.this$0.getActivity()))
    {
      this.this$0.mProgressBar.setVisibility(8);
      this.this$0.Si.setText(2131695453);
      this.this$0.Si.setVisibility(0);
      this.this$0.iR.setVisibility(0);
      if (this.this$0.jdField_a_of_type_Agnf != null)
      {
        this.this$0.jdField_a_of_type_Agnf.endTime = System.currentTimeMillis();
        this.this$0.jdField_a_of_type_Agnf.Zk = (this.this$0.jdField_a_of_type_Agnf.endTime - this.this$0.jdField_a_of_type_Agnf.startTime);
        this.this$0.jdField_a_of_type_Agnf.cew = false;
        this.this$0.jdField_a_of_type_Agnf.bIq = "2";
        this.this$0.jdField_a_of_type_Agnf.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Agnf.mInitTime);
        this.this$0.jdField_a_of_type_Agnf.doReport();
      }
      this.this$0.NR(5000);
      return;
    }
    this.this$0.dfl();
    new Handler().postDelayed(new FilePreviewActivity.9.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbz
 * JD-Core Version:    0.7.0.1
 */