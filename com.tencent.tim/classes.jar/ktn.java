import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class ktn
  extends ClickableSpan
{
  ktn(ktm paramktm, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ksz.f(this.a.uin, BaseActivity.sTopActivity);
    paramView = new krx(this.c).a().build();
    kbp.a(null, ksz.a(this.c.articleInfo), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.c.articleInfo.mArticleID), String.valueOf(this.c.articleInfo.mAlgorithmID), this.c.articleInfo.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.a.isAuthorSelection()) {}
    for (String str = "#FF8444";; str = "#737373")
    {
      paramTextPaint.setColor(Color.parseColor(str));
      paramTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktn
 * JD-Core Version:    0.7.0.1
 */