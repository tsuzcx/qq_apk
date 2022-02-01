import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;

class zzn
  extends zzu
{
  zzn(zzl paramzzl, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    this.jdField_a_of_type_Zzl.dispatchAddFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    zzl.e(this.jdField_a_of_type_Zzl).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    zzl.a(this.jdField_a_of_type_Zzl);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zzl.dispatchAddStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzn
 * JD-Core Version:    0.7.0.1
 */