import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yba
  implements View.OnClickListener
{
  yba(yam paramyam, String paramString) {}
  
  public void onClick(View paramView)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.this$0.app.getManager(60)).a(this.Uf);
    this.this$0.a.b(localHotChatInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yba
 * JD-Core Version:    0.7.0.1
 */