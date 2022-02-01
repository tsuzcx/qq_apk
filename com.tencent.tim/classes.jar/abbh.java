import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class abbh
  extends Handler
{
  public abbh(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.this$0.mListView.springBackOverScrollHeaderView();
      return;
      this.this$0.mListView.springBackOverScrollHeaderView();
      QQToast.a(BaseApplication.getContext(), 1, 2131696272, 0).show(this.this$0.getTitleBarHeight());
      return;
      if (this.this$0.a == null) {
        this.this$0.a = new arhz(this.this$0, this.this$0.getTitleBarHeight());
      }
      this.this$0.a.setMessage(2131701718);
    } while ((this.this$0.isFinishing()) || (this.this$0.a.isShowing()));
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbh
 * JD-Core Version:    0.7.0.1
 */