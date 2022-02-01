import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class wmd
  implements ausj.a
{
  public wmd(PlusPanel paramPlusPanel, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.val$actionSheet != null) {
      this.val$actionSheet.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      try
      {
        PlusPanel.a(this.this$0, true);
        anot.a(this.this$0.app, "dc00898", "", "", "0X800ABFC", "0X800ABFC", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          QLog.d("PlusPanel", 1, "showTroopCourseActionSheet handleTroopLiveOrTroopCourseClick Exception", paramView);
        }
      }
    }
    paramView = this.this$0.sessionInfo.aTl;
    paramView = "https://qun.qq.com/livework/index?gc=" + paramView + "&_wv=2";
    Intent localIntent = new Intent(this.this$0.c.a(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanel", 2, "showTroopCourseActionSheet replayUrl = " + paramView);
    }
    this.this$0.c.a().startActivity(localIntent);
    anot.a(this.this$0.app, "dc00898", "", "", "0X800ABFD", "0X800ABFD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmd
 * JD-Core Version:    0.7.0.1
 */