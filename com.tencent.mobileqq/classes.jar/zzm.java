import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;

class zzm
  extends zzu
{
  zzm(zzl paramzzl, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this.jdField_a_of_type_Zzl.dispatchRemoveFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    zzl.d(this.jdField_a_of_type_Zzl).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    zzl.a(this.jdField_a_of_type_Zzl);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zzl.dispatchRemoveStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzm
 * JD-Core Version:    0.7.0.1
 */