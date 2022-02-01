import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afzv
  implements View.OnClickListener
{
  public afzv(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    long l;
    if (aqiw.isNetSupport(this.this$0))
    {
      l = System.currentTimeMillis();
      if ((l - this.this$0.lastClickTime < Face2FaceAddFriendActivity.XW) && (l > this.this$0.lastClickTime)) {
        if (QLog.isColorLevel()) {
          QLog.e(Face2FaceAddFriendActivity.TAG, 2, "click too offen,please try again later ");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.lastClickTime = l;
      Face2FaceAddFriendActivity.b(this.this$0, this.aGq);
      this.this$0.a.hide();
      anot.a(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 1, 0, "", "", "", "");
      continue;
      String str = this.this$0.getResources().getString(2131693354);
      QQToast.a(this.this$0, 0, str, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzv
 * JD-Core Version:    0.7.0.1
 */