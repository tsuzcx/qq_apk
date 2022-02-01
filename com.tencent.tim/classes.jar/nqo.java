import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

final class nqo
  extends lsz
{
  nqo(int paramInt1, int paramInt2, int paramInt3, String paramString, ArticleInfo paramArticleInfo)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(@NonNull View paramView)
  {
    kxm.a(paramView.getContext(), this.val$jumpUrl, null);
    if ((this.d != null) && (this.d.isPGCShortContent()))
    {
      this.d.click_area = 11;
      this.d.click_jump_target = lrm.R(this.val$jumpUrl, "-1");
      kxm.b(paramView.getContext(), this.d, (int)this.d.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqo
 * JD-Core Version:    0.7.0.1
 */