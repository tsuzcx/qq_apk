import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agdm
  implements ausj.a
{
  public agdm(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.e == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = this.this$0.e.getContent(paramInt);
      if (!TextUtils.isEmpty(paramView))
      {
        if ((!paramView.equals(this.this$0.getResources().getString(2131692932))) && (!paramView.equals(this.this$0.getResources().getString(2131692933)))) {
          break label270;
        }
        anot.a(null, "dc00898", "", "", "0X8008F87", "0X8008F87", 1, 0, "", "", "", "");
        if (!UniformDownloadActivity.a(this.this$0)) {
          break label241;
        }
        if (!aryq.aHr()) {
          break label231;
        }
        aryb.a().d(UniformDownloadActivity.a(this.this$0), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
        paramView = UniformDownloadActivity.a(this.this$0);
        UniformDownloadActivity.a(this.this$0, paramView);
        paramView = UniformDownloadActivity.a(this.this$0, paramView);
        if (QLog.isColorLevel()) {
          QLog.d(UniformDownloadActivity.TAG, 2, "tmastUrl=" + paramView);
        }
        UniformDownloadActivity.a(this.this$0, paramView);
        UniformDownloadActivity.b(this.this$0);
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      this.this$0.e.dismiss();
      return;
      label231:
      UniformDownloadActivity.c(this.this$0);
      continue;
      label241:
      UniformDownloadActivity.b(this.this$0).setVisibility(0);
      ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.7.1(this));
      continue;
      label270:
      if ((paramView.equals(this.this$0.getResources().getString(2131692931))) || (paramView.equals(this.this$0.getResources().getString(2131690406))) || (paramView.equals(this.this$0.getResources().getString(2131690405)))) {
        UniformDownloadActivity.c(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdm
 * JD-Core Version:    0.7.0.1
 */