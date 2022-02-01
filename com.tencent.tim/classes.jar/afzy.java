import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.a;
import com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afzy
  implements View.OnClickListener
{
  public afzy(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (aqiw.isNetSupport(this.this$0))
    {
      Face2FaceAddFriendActivity.a(this.this$0, this.aGq);
      this.this$0.a.hide();
      localObject = Face2FaceAddFriendActivity.a(this.this$0).obtainMessage();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = 2;
      ((Message)localObject).obj = this.aGq;
      Face2FaceAddFriendActivity.a(this.this$0).sendMessage((Message)localObject);
      anot.a(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.this$0.getResources().getString(2131693354);
      QQToast.a(this.this$0, 0, (CharSequence)localObject, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzy
 * JD-Core Version:    0.7.0.1
 */