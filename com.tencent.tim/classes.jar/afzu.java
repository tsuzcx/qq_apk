import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afzu
  implements View.OnClickListener
{
  public afzu(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0, MoveToGroupActivity.class).putExtra("friendUin", this.this$0.bGc).putExtra("mgid", (byte)this.this$0.bDA);
    localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    this.this$0.startActivityForResult(localIntent, 100);
    anot.a(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzu
 * JD-Core Version:    0.7.0.1
 */