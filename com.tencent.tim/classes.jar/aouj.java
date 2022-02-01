import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aouj
  implements View.OnClickListener
{
  public aouj(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ArticleInfo paramArticleInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.d != null) && (this.d.isPGCShortContent())) {
      lrm.b(this.this$0.getActivity(), this.d);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!TextUtils.isEmpty(this.cna)) && (this.this$0.getActivity() != null) && ((this.this$0.getActivity() instanceof TroopAvatarWallPreviewActivity))) {
        if ((this.d != null) && (kxm.a(this.d.mArticleContentUrl, this.d.mChannelID, this.d)))
        {
          TroopAvatarWallPreviewActivity.a(this.this$0, this.d, this.cna);
        }
        else
        {
          kxm.aJ(this.this$0.getActivity(), this.cna);
          if (this.this$0.cOM) {
            TroopAvatarWallPreviewActivity.d(this.this$0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouj
 * JD-Core Version:    0.7.0.1
 */