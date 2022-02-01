import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ujf
  implements View.OnClickListener
{
  public ujf(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!win.Ra())
      {
        String str = this.this$0.sessionInfo.aTl;
        if (this.this$0.sessionInfo.cZ == 1006) {
          str = this.this$0.sessionInfo.aTo;
        }
        switch (((Integer)localObject).intValue())
        {
        default: 
          break;
        case 1: 
          BaseChatPie.a(this.this$0, str);
          break;
        case 2: 
          BaseChatPie.b(this.this$0, str);
          break;
        case 3: 
          BaseChatPie.d(this.this$0);
          break;
        case 4: 
          BaseChatPie.e(this.this$0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */