import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;

class zzo
  extends zzu
{
  zzo(zzl paramzzl, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    if (this.jdField_a_of_type_Int != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (this.b != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    this.jdField_a_of_type_Zzl.dispatchMoveFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    zzl.f(this.jdField_a_of_type_Zzl).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    zzl.a(this.jdField_a_of_type_Zzl);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Zzl.dispatchMoveStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzo
 * JD-Core Version:    0.7.0.1
 */