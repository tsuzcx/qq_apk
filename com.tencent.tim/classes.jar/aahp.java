import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahp
  implements View.OnClickListener
{
  aahp(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if (aahb.a(this.this$0) != null) {}
    for (QQAppInterface localQQAppInterface = aahb.a(this.this$0).app;; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        adrm.a().c(aahb.a(this.this$0), localQQAppInterface);
      }
      adrm.a().reportClick();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahp
 * JD-Core Version:    0.7.0.1
 */