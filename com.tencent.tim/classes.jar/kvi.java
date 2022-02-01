import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView;

public class kvi
  implements ValueAnimator.AnimatorUpdateListener
{
  String commentId = NativeCommentTextView.a(this.b).a.commentId;
  
  public kvi(NativeCommentTextView paramNativeCommentTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((NativeCommentTextView.a(this.b) == null) || (NativeCommentTextView.a(this.b).a == null) || (this.commentId == null))
    {
      NativeCommentTextView.a(this.b, this.kb);
      return;
    }
    if (!this.commentId.equals(NativeCommentTextView.a(this.b).a.commentId))
    {
      NativeCommentTextView.a(this.b, this.kb);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    NativeCommentTextView.a(this.b).setAlpha(i);
    this.kb.setBackgroundDrawable(NativeCommentTextView.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvi
 * JD-Core Version:    0.7.0.1
 */