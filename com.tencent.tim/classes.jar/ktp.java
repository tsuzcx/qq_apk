import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;

class ktp
  extends ClickableSpan
{
  ktp(ktm paramktm, SubCommentData paramSubCommentData) {}
  
  public void onClick(View paramView)
  {
    ksz.f(this.a.repliedUserUin, BaseActivity.sTopActivity);
    paramView = new krx(this.c).a().build();
    kbp.a(null, ksz.a(this.c.articleInfo), "0X800955B", "0X800955B", 0, 0, String.valueOf(this.c.articleInfo.mArticleID), String.valueOf(this.c.articleInfo.mAlgorithmID), this.c.articleInfo.innerUniqueID, paramView, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D7CAF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktp
 * JD-Core Version:    0.7.0.1
 */