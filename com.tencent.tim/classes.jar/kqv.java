import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

public class kqv
  extends ClickableSpan
{
  public kqv(CommentInfo paramCommentInfo1, CommentInfo paramCommentInfo2, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ksz.f(this.b.authorUin, this.val$activity);
    paramView = new ksz.c(this.c.articleInfo, this.b).b(ksm.aLx).c(this.c.area).d(0).a().build();
    kbp.a(null, ksz.a(this.c.articleInfo), "0X800900D", "0X800900D", 0, 0, String.valueOf(this.c.articleInfo.mArticleID), String.valueOf(this.c.articleInfo.mAlgorithmID), this.c.articleInfo.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqv
 * JD-Core Version:    0.7.0.1
 */