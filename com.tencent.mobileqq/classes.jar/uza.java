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

public class uza
  implements zvo
{
  private RecyclerView.ViewHolder a;
  
  public uza(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
  }
  
  private View a(View paramView)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(2131376862);
    paramView = paramView.findViewById(2131373811);
    if ((localRecyclerView.getVisibility() == 0) && (localRecyclerView.getChildCount() > 0)) {
      return localRecyclerView.getChildAt(0);
    }
    return paramView;
  }
  
  private boolean b(zvx paramzvx)
  {
    paramzvx = paramzvx.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    ViewCompat.setTranslationX(paramzvx.itemView, 0.0F);
    ViewCompat.setTranslationY(paramzvx.itemView, 0.0F);
    ViewCompat.setScaleX(paramzvx.itemView, 1.0F);
    ViewCompat.setScaleY(paramzvx.itemView, 1.0F);
    ViewCompat.setAlpha(paramzvx.itemView, 0.0F);
    return true;
  }
  
  private boolean c(zvx paramzvx)
  {
    RecyclerView.ViewHolder localViewHolder1 = paramzvx.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    RecyclerView.ViewHolder localViewHolder2 = paramzvx.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    int i = paramzvx.jdField_a_of_type_Int;
    i = paramzvx.jdField_b_of_type_Int;
    int k = paramzvx.c;
    int j = paramzvx.d;
    paramzvx = (FrameLayout)localViewHolder1.itemView.findViewById(2131366689);
    View localView = a(localViewHolder1.itemView);
    SquareImageView localSquareImageView = (SquareImageView)localViewHolder2.itemView.findViewById(2131369125);
    float f1 = ViewCompat.getTranslationX(localViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(localViewHolder1.itemView);
    if ((localView != null) && (localSquareImageView != null))
    {
      float f3 = localView.getWidth() * 1.0F / localSquareImageView.getWidth();
      float f4 = localView.getHeight() * 1.0F / localSquareImageView.getHeight();
      float f5 = paramzvx.getLeft();
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
  
  public ViewPropertyAnimatorCompat a(zvx paramzvx, long paramLong, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = paramzvx.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    Object localObject = paramzvx.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((localViewHolder == null) || (localObject == null)) {
      return null;
    }
    if (((localViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof QCircleGridFeedItemView)))
    {
      if (paramBoolean)
      {
        paramzvx = ViewCompat.animate(localViewHolder.itemView).setDuration(300L);
        paramzvx.translationX(0.0F);
        paramzvx.translationY(0.0F);
        paramzvx.scaleY(1.0F);
        paramzvx.scaleX(1.0F);
        paramzvx.alpha(0.0F);
        return paramzvx;
      }
      paramzvx = ViewCompat.animate(((RecyclerView.ViewHolder)localObject).itemView).setDuration(300L);
      paramzvx.setInterpolator(new AccelerateDecelerateInterpolator());
      paramzvx.translationX(0.0F);
      paramzvx.translationY(0.0F);
      paramzvx.scaleY(1.0F);
      paramzvx.scaleX(1.0F);
      paramzvx.alpha(1.0F);
      return paramzvx;
    }
    if (((localViewHolder.itemView instanceof QCircleGridFeedItemView)) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof QCircleTimeLineFeedItemView))) {
      if (paramBoolean)
      {
        int j = paramzvx.jdField_a_of_type_Int;
        int i = paramzvx.jdField_b_of_type_Int;
        int k = paramzvx.c;
        k = paramzvx.d;
        paramzvx = (SquareImageView)localViewHolder.itemView.findViewById(2131369125);
        FrameLayout localFrameLayout = (FrameLayout)((RecyclerView.ViewHolder)localObject).itemView.findViewById(2131366689);
        localObject = a(((RecyclerView.ViewHolder)localObject).itemView);
        float f1 = ViewCompat.getTranslationX(localViewHolder.itemView);
        float f2 = ViewCompat.getTranslationY(localViewHolder.itemView);
        if ((localObject != null) && (paramzvx != null))
        {
          float f3 = ((View)localObject).getWidth() * 1.0F / paramzvx.getWidth();
          float f4 = ((View)localObject).getHeight() * 1.0F / paramzvx.getHeight();
          float f5 = localFrameLayout.getLeft();
          float f6 = (f3 - 1.0F) * localViewHolder.itemView.getWidth() / 2.0F;
          float f7 = (f4 - 1.0F) * localViewHolder.itemView.getHeight() / 2.0F;
          j = (int)(f5 - j + f6 - f1);
          i = (int)(k - i + f7 - f2);
          paramzvx = ViewCompat.animate(localViewHolder.itemView).setDuration(300L);
          paramzvx.setInterpolator(new DecelerateInterpolator());
          paramzvx.translationX(j);
          paramzvx.translationY(i);
          paramzvx.scaleY(f4);
          paramzvx.scaleX(f3);
          paramzvx.alpha(1.0F);
          return paramzvx;
        }
      }
      else
      {
        paramzvx = ViewCompat.animate(((RecyclerView.ViewHolder)localObject).itemView).setDuration(250L);
        paramzvx.setInterpolator(new AccelerateInterpolator());
        paramzvx.translationX(0.0F);
        paramzvx.translationY(0.0F);
        paramzvx.scaleY(1.0F);
        paramzvx.scaleX(1.0F);
        paramzvx.alpha(1.0F);
        return paramzvx;
      }
    }
    return null;
  }
  
  public ViewPropertyAnimatorCompat a(zvy paramzvy, long paramLong)
  {
    paramzvy = ViewCompat.animate(paramzvy.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView).setDuration(300L);
    paramzvy.setInterpolator(new AccelerateDecelerateInterpolator());
    return paramzvy;
  }
  
  public boolean a(zvx paramzvx)
  {
    RecyclerView.ViewHolder localViewHolder1 = paramzvx.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    RecyclerView.ViewHolder localViewHolder2 = paramzvx.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == localViewHolder2) && ((localViewHolder2.itemView instanceof QCircleGridFeedItemView)) && ((localViewHolder1.itemView instanceof QCircleTimeLineFeedItemView))) {
      return c(paramzvx);
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == localViewHolder2) && ((localViewHolder2.itemView instanceof QCircleTimeLineFeedItemView)) && ((localViewHolder1.itemView instanceof QCircleGridFeedItemView))) {
      return b(paramzvx);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uza
 * JD-Core Version:    0.7.0.1
 */