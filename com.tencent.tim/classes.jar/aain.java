import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aain
  implements View.OnClickListener
{
  aain(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (anqr)paramView.getTag();
    if (localObject != null) {
      ((anqr)localObject).a.aCP();
    }
    try
    {
      if (!TextUtils.isEmpty(((anqr)localObject).id))
      {
        i = Integer.parseInt(((anqr)localObject).id);
        anot.a(aahb.a(this.this$0).app, "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
        localObject = new aehr(aahb.a(this.this$0).getApplicationContext(), aevk.mCurUin);
        if (localObject != null)
        {
          ((aehr)localObject).cXa();
          ((aehr)localObject).cXb();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        int i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aain
 * JD-Core Version:    0.7.0.1
 */