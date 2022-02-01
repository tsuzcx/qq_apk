import android.os.Bundle;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class aouo
  implements ausj.a
{
  String seq = this.this$0.a.getItem(this.this$0.mIndex);
  
  public aouo(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ausj paramausj, URLDrawable paramURLDrawable) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i;
    if (!apqw.isNumeric(this.seq))
    {
      i = 1;
      if (i == 0) {
        break label74;
      }
      paramView = this.seq;
      paramView = this.val$actionSheet.getContent(paramInt);
      if (!this.this$0.getString(2131694752).equals(paramView)) {
        break label130;
      }
      this.this$0.c(this.x, this.seq);
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      i = 0;
      break;
      label74:
      if (this.seq.equals(zri.baD)) {}
      for (paramView = apqw.p(this.seq, this.this$0.mTroopUin, 0);; paramView = apqw.p(this.seq, this.this$0.mTroopUin, 1))
      {
        apqw.oK(paramView);
        break;
      }
      label130:
      if (this.this$0.getString(2131694762).equals(paramView)) {
        TroopAvatarWallPreviewActivity.a(this.this$0, this.x);
      } else if (this.this$0.getString(2131694760).equals(paramView)) {
        this.this$0.hO(this.this$0.aWb, this.seq);
      } else if (this.this$0.getString(2131699972).equals(paramView)) {
        this.this$0.setDefaultAvatar(this.this$0.mIndex);
      } else if (this.this$0.getString(2131694749).equals(paramView)) {
        if ((this.this$0.cOF) && (TroopAvatarWallPreviewActivity.a(this.this$0) != null) && (TroopAvatarWallPreviewActivity.a(this.this$0).getBoolean("from_personality_label", false))) {
          TroopAvatarWallPreviewActivity.a(this.this$0, this.this$0.mIndex, TroopAvatarWallPreviewActivity.a(this.this$0));
        } else if ((this.this$0.cOF) && (this.this$0.lT(this.this$0.mIndex))) {
          this.this$0.Wl(this.this$0.mIndex);
        } else {
          this.this$0.setDefaultAvatar(this.this$0.mIndex);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouo
 * JD-Core Version:    0.7.0.1
 */