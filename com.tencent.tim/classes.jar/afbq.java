import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afbq
  implements View.OnClickListener
{
  afbq(afbo paramafbo, ReportData paramReportData, WindowManager paramWindowManager) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)this.jdField_a_of_type_Afbo.val$context.getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      ClipData localClipData = ClipData.newPlainText(null, this.jdField_a_of_type_ComTencentMobileqqDatareportviewerReportData.toString());
      alkw.a(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
      QQToast.a(this.jdField_a_of_type_Afbo.this$0.getContext(), acfp.m(2131704642), 0).show();
    }
    this.b.removeViewImmediate(this.jdField_a_of_type_Afbo.this$0.jP);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbq
 * JD-Core Version:    0.7.0.1
 */