import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aotr
  implements ausj.a
{
  public aotr(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ausj paramausj, URLDrawable paramURLDrawable, String paramString1, String paramString2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.val$actionSheet.getContent(paramInt);
    if (this.this$0.getString(2131694762).equals(paramView))
    {
      TroopAvatarWallPreviewActivity.a(this.this$0, this.x);
      this.val$actionSheet.dismiss();
      return;
    }
    if (!TextUtils.isEmpty(this.bNj)) {
      aqep.a(this.this$0, Long.parseLong(this.bNj), "0", null, 20006);
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", this.bNj, "video", "clk_rep", 0, 0, "", "", "", "");
      break;
      if ((TextUtils.isEmpty(this.val$uin)) || ("0".equals(this.val$uin))) {
        QQToast.a(this.this$0, 2, acfp.m(2131715568), 0).show();
      } else {
        aqep.a(this.this$0, 0L, this.val$uin, null, 20006);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotr
 * JD-Core Version:    0.7.0.1
 */