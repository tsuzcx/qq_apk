import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

class ktq
  extends ClickableSpan
{
  ktq(ktm paramktm, BaseCommentData paramBaseCommentData, String paramString1, String paramString2) {}
  
  public void onClick(@NotNull View paramView)
  {
    if ((this.b.isAuthorReply()) && (!TextUtils.isEmpty(this.b.ksHomePage))) {
      ksz.g(this.b.ksHomePage, BaseActivity.sTopActivity);
    }
    for (;;)
    {
      kbp.a(null, ksz.a(this.c.articleInfo), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.c.articleInfo.mArticleID), String.valueOf(this.c.articleInfo.mAlgorithmID), this.c.articleInfo.innerUniqueID, this.acf, false);
      return;
      ksz.f(this.val$uin, BaseActivity.sTopActivity);
    }
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#376099"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktq
 * JD-Core Version:    0.7.0.1
 */