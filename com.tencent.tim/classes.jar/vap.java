import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;

public class vap
  implements ausj.a
{
  public vap(FriendProfileCardActivity paramFriendProfileCardActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 60;
    if (paramInt == 0)
    {
      paramView = new Intent(this.this$0, EditInfoActivity.class);
      paramView.putExtra("title", this.aNm);
      paramView.putExtra("default_text", this.aNn);
      paramView.putExtra("uin", this.this$0.a.d.uin);
      paramView.putExtra("edit_action", this.bHf);
      paramView.putExtra("max_limit_mode", 1);
      paramView.putExtra("edit_type", 2);
      if (this.aWE)
      {
        paramView.putExtra("max_num", 60);
        paramView.putExtra("isTroopNick", true);
        paramView.putExtra("troopUin", this.this$0.a.troopUin);
        this.this$0.startActivityForResult(paramView, 1034);
      }
    }
    else
    {
      if (this.W != null) {
        this.W.dismiss();
      }
      return;
    }
    if (this.bHf == 2) {}
    for (paramInt = i;; paramInt = 36)
    {
      paramView.putExtra("max_num", paramInt);
      paramView.putExtra("support_emotion", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vap
 * JD-Core Version:    0.7.0.1
 */