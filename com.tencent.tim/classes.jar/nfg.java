import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class nfg
  extends AnimatorListenerAdapter
{
  public nfg(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    ReadInJoyListViewGroup.a(this.this$0).setLayerType(0, null);
    ReadInJoyListViewGroup.a(this.this$0).setVisibility(8);
    this.this$0.a.setAlpha(1.0F);
    if (ReadInJoyListViewGroup.a(this.this$0) != null) {
      ReadInJoyListViewGroup.a(this.this$0).aVV();
    }
    ReadInJoyListViewGroup.a(this.this$0).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "trans animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nfg
 * JD-Core Version:    0.7.0.1
 */