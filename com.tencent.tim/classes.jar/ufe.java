import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ufe
  implements ausj.a
{
  public ufe(AddRequestActivity paramAddRequestActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$sheet.dismiss();
      return;
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        stj.a(this.this$0, this.this$0.aKN, null, this.this$0.app.getCurrentAccountUin(), 20010, null);
      } else {
        QQToast.a(this.this$0, 2131696272, 0).show(this.this$0.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufe
 * JD-Core Version:    0.7.0.1
 */