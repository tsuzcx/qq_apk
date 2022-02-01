import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.mobileqq.widget.SquareImageView;

public class vaq
  implements zzj
{
  private RecyclerView.ViewHolder a;
  
  public vaq(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
  }
  
  private View a(View paramView)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(2131377001);
    paramView = paramView.findViewById(2131373939);
    if ((localRecyclerView.getVisibility() == 0) && (localRecyclerView.getChildCount() > 0)) {
      return localRecyclerView.getChildAt(0);
    }
    return paramView;
  }
  
  private boolean b(zzs paramzzs)
  {
    paramzzs = paramzzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    ViewCompat.setTranslationX(paramzzs.itemView, 0.0F);
    ViewCompat.setTranslationY(paramzzs.itemView, 0.0F);
    ViewCompat.setScaleX(paramzzs.itemView, 1.0F);
    ViewCompat.setScaleY(paramzzs.itemView, 1.0F);
    ViewCompat.setAlpha(paramzzs.itemView, 0.0F);
    return true;
  }
  
  private boolean c(zzs paramzzs)
  {
    RecyclerView.ViewHolder localViewHolder1 = paramzzs.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    RecyclerView.ViewHolder localViewHolder2 = paramzzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    int i = paramzzs.jdField_a_of_type_Int;
    i = paramzzs.jdField_b_of_type_Int;
    int k = paramzzs.c;
    int j = paramzzs.d;
    paramzzs = (FrameLayout)localViewHolder1.itemView.findViewById(2131366739);
    View localView = a(localViewHolder1.itemView);
    SquareImageView localSquareImageView = (SquareImageView)localViewHolder2.itemView.findViewById(2131369215);
    float f1 = ViewCompat.getTranslationX(localViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(localViewHolder1.itemView);
    if ((localView != null) && (localSquareImageView != null))
    {
      float f3 = localView.getWidth() * 1.0F / localSquareImageView.getWidth();
      float f4 = localView.getHeight() * 1.0F / localSquareImageView.getHeight();
      float f5 = paramzzs.getLeft();
      float f6 = (f3 - 1.0F) * localViewHolder2.itemView.getWidth() / 2.0F;
      float f7 = (f4 - 1.0F) * localViewHolder2.itemView.getHeight() / 2.0F;
      k = (int)(k - f5 - f6 - f1);
      i = (int)(j - i - f7 - f2);
      ViewCompat.setScaleX(localViewHolder2.itemView, f3);
      ViewCompat.setScaleY(localViewHolder2.itemView, f4);
      ViewCompat.setTranslationX(localViewHolder2.itemView, -k);
      ViewCompat.setTranslationY(localViewHolder2.itemView, -i);
    }
    return true;
  }
  
  public ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder paramViewHolder)
  {
    return null;
  }
  
  public ViewPropertyAnimatorCompat a(zzs paramzzs, long paramLong, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = paramzzs.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    Object localObject = paramzzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((localViewHolder == null) || (localObject == null)) {
      return null;
    }
    if (((localViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof QCircleGridFeedItemView)))
    {
      if (paramBoolean)
      {
        paramzzs = ViewCompat.animate(localViewHolder.itemView).setDuration(300L);
        paramzzs.translationX(0.0F);
        paramzzs.translationY(0.0F);
        paramzzs.scaleY(1.0F);
        paramzzs.scaleX(1.0F);
        paramzzs.alpha(0.0F);
        return paramzzs;
      }
      paramzzs = ViewCompat.animate(((RecyclerView.ViewHolder)localObject).itemView).setDuration(300L);
      paramzzs.setInterpolator(new AccelerateDecelerateInterpolator());
      paramzzs.translationX(0.0F);
      paramzzs.translationY(0.0F);
      paramzzs.scaleY(1.0F);
      paramzzs.scaleX(1.0F);
      paramzzs.alpha(1.0F);
      return paramzzs;
    }
    if (((localViewHolder.itemView instanceof QCircleGridFeedItemView)) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof QCircleTimeLineFeedItemView))) {
      if (paramBoolean)
      {
        int j = paramzzs.jdField_a_of_type_Int;
        int i = paramzzs.jdField_b_of_type_Int;
        int k = paramzzs.c;
        k = paramzzs.d;
        paramzzs = (SquareImageView)localViewHolder.itemView.findViewById(2131369215);
        FrameLayout localFrameLayout = (FrameLayout)((RecyclerView.ViewHolder)localObject).itemView.findViewById(2131366739);
        localObject = a(((RecyclerView.ViewHolder)localObject).itemView);
        float f1 = ViewCompat.getTranslationX(localViewHolder.itemView);
        float f2 = ViewCompat.getTranslationY(localViewHolder.itemView);
        if ((localObject != null) && (paramzzs != null))
        {
          float f3 = ((View)localObject).getWidth() * 1.0F / paramzzs.getWidth();
          float f4 = ((View)localObject).getHeight() * 1.0F / paramzzs.getHeight();
          float f5 = localFrameLayout.getLeft();
          float f6 = (f3 - 1.0F) * localViewHolder.itemView.getWidth() / 2.0F;
          float f7 = (f4 - 1.0F) * localViewHolder.itemView.getHeight() / 2.0F;
          j = (int)(f5 - j + f6 - f1);
          i = (int)(k - i + f7 - f2);
          paramzzs = ViewCompat.animate(localViewHolder.itemView).setDuration(300L);
          paramzzs.setInterpolator(new DecelerateInterpolator());
          paramzzs.translationX(j);
          paramzzs.translationY(i);
          paramzzs.scaleY(f4);
          paramzzs.scaleX(f3);
          paramzzs.alpha(1.0F);
          return paramzzs;
        }
      }
      else
      {
        paramzzs = ViewCompat.animate(((RecyclerView.ViewHolder)localObject).itemView).setDuration(250L);
        paramzzs.setInterpolator(new AccelerateInterpolator());
        paramzzs.translationX(0.0F);
        paramzzs.translationY(0.0F);
        paramzzs.scaleY(1.0F);
        paramzzs.scaleX(1.0F);
        paramzzs.alpha(1.0F);
        return paramzzs;
      }
    }
    return null;
  }
  
  public ViewPropertyAnimatorCompat a(zzt paramzzt, long paramLong)
  {
    paramzzt = ViewCompat.animate(paramzzt.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView).setDuration(300L);
    paramzzt.setInterpolator(new AccelerateDecelerateInterpolator());
    return paramzzt;
  }
  
  public boolean a(zzs paramzzs)
  {
    RecyclerView.ViewHolder localViewHolder1 = paramzzs.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    RecyclerView.ViewHolder localViewHolder2 = paramzzs.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == localViewHolder2) && ((localViewHolder2.itemView instanceof QCircleGridFeedItemView)) && ((localViewHolder1.itemView instanceof QCircleTimeLineFeedItemView))) {
      return c(paramzzs);
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == localViewHolder2) && ((localViewHolder2.itemView instanceof QCircleTimeLineFeedItemView)) && ((localViewHolder1.itemView instanceof QCircleGridFeedItemView))) {
      return b(paramzzs);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaq
 * JD-Core Version:    0.7.0.1
 */