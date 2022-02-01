import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uid
  implements View.OnClickListener
{
  public uid(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.this$0.a.ciA();
    SharedPreferences.Editor localEditor = this.this$0.app.getPreferences().edit();
    localEditor.putInt("funcall_tip_" + this.this$0.sessionInfo.aTl, 4);
    localEditor.commit();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uid
 * JD-Core Version:    0.7.0.1
 */