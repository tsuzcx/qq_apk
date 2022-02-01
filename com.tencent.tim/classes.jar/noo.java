import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

class noo
  implements Animator.AnimatorListener
{
  noo(nom paramnom, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    nom.a(this.this$0).setText(this.val$prefix + this.this$0.a.title);
    nom.b(this.this$0).setText(this.val$prefix + this.this$0.a.title);
    nom.a(this.this$0).setVisibility(8);
    nom.b(this.this$0).setVisibility(0);
    nom.a(this.this$0).setTranslationY(Utils.dp2px(43.0D));
    nom.b(this.this$0).setTranslationY(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noo
 * JD-Core Version:    0.7.0.1
 */