import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.8.1;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.8.2;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.8.3;
import com.tencent.tim.filemanager.activity.FilePreviewActivity.8.4;
import com.tencent.tim.filemanager.widget.FileWebView;
import com.tencent.tim.filemanager.widget.FileWebView.b;

public class atok
  implements FileWebView.b
{
  long Ym = 0L;
  boolean dix = false;
  
  public atok(FilePreviewActivity paramFilePreviewActivity, Handler paramHandler) {}
  
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
    FilePreviewActivity.8.2 local2 = new FilePreviewActivity.8.2(this);
    this.val$handler.postDelayed(local2, 3000L);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "postDelayed(newRunnable, 3000)");
  }
  
  public void dfp()
  {
    this.this$0.runOnUiThread(new FilePreviewActivity.8.4(this));
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
      this.dix = true;
    } while (this.this$0.ccL);
    this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetFileWebView.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
  }
  
  public void hl()
  {
    this.this$0.runOnUiThread(new FilePreviewActivity.8.3(this));
  }
  
  public void onGetMore()
  {
    long l = System.currentTimeMillis();
    if (l - this.Ym < 1000L) {
      if (this.dix)
      {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "last getmore is prepare getmore just now, so show getmore this time");
        this.dix = false;
        this.this$0.dfl();
      }
    }
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
    if (this.this$0.jdField_a_of_type_Atwe != null)
    {
      this.this$0.jdField_a_of_type_Atwe.bIw = "3";
      this.this$0.jdField_a_of_type_Atwe.startTime = System.currentTimeMillis();
    }
    if (!aqiw.isNetSupport(this.this$0.getActivity()))
    {
      this.this$0.mProgressBar.setVisibility(8);
      this.this$0.Si.setText(2131695453);
      this.this$0.Si.setVisibility(0);
      this.this$0.iR.setVisibility(0);
      if (this.this$0.jdField_a_of_type_Atwe != null)
      {
        this.this$0.jdField_a_of_type_Atwe.endTime = System.currentTimeMillis();
        this.this$0.jdField_a_of_type_Atwe.Zk = (this.this$0.jdField_a_of_type_Atwe.endTime - this.this$0.jdField_a_of_type_Atwe.startTime);
        this.this$0.jdField_a_of_type_Atwe.cew = false;
        this.this$0.jdField_a_of_type_Atwe.bIq = "2";
        this.this$0.jdField_a_of_type_Atwe.Zl = (System.currentTimeMillis() - this.this$0.jdField_a_of_type_Atwe.mInitTime);
        this.this$0.jdField_a_of_type_Atwe.doReport();
      }
      this.this$0.NR(5000);
      return;
    }
    this.dix = false;
    this.this$0.dfl();
    new Handler().postDelayed(new FilePreviewActivity.8.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atok
 * JD-Core Version:    0.7.0.1
 */