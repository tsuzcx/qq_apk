import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;

public class aotq
  implements ausj.a
{
  String url = this.this$0.a.fT(this.this$0.mIndex);
  
  public aotq(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, ausj paramausj, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.val$actionSheet.getContent(paramInt);
    if (this.this$0.getString(2131694752).equals(paramView)) {
      this.this$0.c(this.x, this.url);
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if (this.this$0.getString(2131694762).equals(paramView)) {
        TroopAvatarWallEditActivity.a(this.this$0, this.x);
      } else if (this.this$0.getString(2131694760).equals(paramView)) {
        this.this$0.hO(this.this$0.aWb, this.url);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotq
 * JD-Core Version:    0.7.0.1
 */