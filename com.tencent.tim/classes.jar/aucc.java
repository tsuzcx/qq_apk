import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;

class aucc
  implements audx.c
{
  aucc(auby paramauby) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.mContext, QQSettingMsgHistoryActivity.class);
    paramView.putExtra("set_display_type", 3);
    this.a.mContext.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucc
 * JD-Core Version:    0.7.0.1
 */