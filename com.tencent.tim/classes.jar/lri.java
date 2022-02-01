import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.ColumnEntranceAnimationHelper.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class lri
  implements AbsListView.e
{
  private AnimatorSet A = new AnimatorSet();
  private boolean akL;
  private BaseArticleInfo d;
  private ViewBase i;
  private Runnable runnable;
  
  public lri(ViewBase paramViewBase)
  {
    this.i = paramViewBase;
    Object localObject = this.i.getNativeView();
    ((View)localObject).setScaleX(0.0F);
    ((View)localObject).setScaleY(0.0F);
    paramViewBase = ObjectAnimator.ofFloat(localObject, "ScaleX", new float[] { 0.0F, 1.0F, 0.8F, 1.2F, 1.0F });
    localObject = ObjectAnimator.ofFloat(localObject, "ScaleY", new float[] { 0.0F, 1.0F, 0.8F, 1.2F, 1.0F });
    this.A.playTogether(new Animator[] { paramViewBase, localObject });
    this.A.setInterpolator(new AccelerateInterpolator(1.5F));
    this.A.setDuration(300L);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Container paramContainer, lie paramlie)
  {
    if ((paramBaseArticleInfo.isShowColumnAnimation) && (!paramBaseArticleInfo.isColumnAnimationPlay))
    {
      paramBaseArticleInfo.isShowColumnAnimation = false;
      paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_column_root");
      if (paramContainer != null) {}
    }
    else
    {
      return;
    }
    paramContainer.setVisibility(8);
    paramlie = (ReadInJoyXListView)paramlie.b().b();
    if (paramContainer.getTag() != null) {
      paramlie.b((lri)paramContainer.getTag());
    }
    lri locallri = new lri(paramContainer);
    locallri.d(paramBaseArticleInfo);
    paramlie.c(locallri);
    paramContainer.setTag(locallri);
    locallri.onScrollStateChanged(paramlie, 0);
  }
  
  private boolean a(ReadInJoyXListView paramReadInJoyXListView)
  {
    int[] arrayOfInt = new int[2];
    this.i.getNativeView().getLocationInWindow(arrayOfInt);
    int j = Utils.dp2px(100.0D);
    int k = arrayOfInt[1];
    QLog.i("ColumnEntranceAnimationHelper", 1, "listView.getHeight()：" + paramReadInJoyXListView.getHeight() + "minTop:" + j);
    return (k < paramReadInJoyXListView.getHeight()) && (k > j);
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView)
  {
    paramReadInJoyXListView.b(this);
  }
  
  public void d(BaseArticleInfo paramBaseArticleInfo)
  {
    this.d = paramBaseArticleInfo;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.akL = true;
    if ((paramInt == 0) && (this.i != null))
    {
      this.akL = false;
      if (this.runnable == null) {
        this.runnable = new ColumnEntranceAnimationHelper.1(this, paramAbsListView);
      }
      paramAbsListView.removeCallbacks(this.runnable);
      paramAbsListView.postDelayed(this.runnable, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lri
 * JD-Core Version:    0.7.0.1
 */