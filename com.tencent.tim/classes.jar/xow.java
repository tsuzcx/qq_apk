import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xow
  implements View.OnClickListener
{
  xow(xov paramxov) {}
  
  public void onClick(View paramView)
  {
    Object localObject = wja.a(paramView);
    if (!(localObject instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (MessageForText)localObject;
      if (!this.this$0.Rk())
      {
        if (((MessageForText)localObject).msgtype == -1003)
        {
          wja.bcO = true;
          localObject = aqoj.pL(((MessageForText)localObject).action);
          localObject = aqik.c(this.this$0.app, paramView.getContext(), (String)localObject);
          if (localObject != null) {
            ((aqhv)localObject).ace();
          }
        }
        if ((paramView instanceof ETTextView)) {
          ((ETTextView)paramView).startAnimation(true, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xow
 * JD-Core Version:    0.7.0.1
 */