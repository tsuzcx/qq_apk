import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class mcl
  extends ClickableSpan
{
  public mcl(ComponentHeaderUgc paramComponentHeaderUgc, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    kxm.a(this.b.getContext(), this.b.a.a.a(), 4, false, 7, false);
    ndi.g(this.j, this.b.a.a.nh());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(wja.a(2, 14, this.b.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcl
 * JD-Core Version:    0.7.0.1
 */