import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;

class zoc
  extends zoi
{
  zoc(znz paramznz, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
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
    this.jdField_a_of_type_Znz.dispatchMoveFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    znz.f(this.jdField_a_of_type_Znz).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    znz.a(this.jdField_a_of_type_Znz);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_Znz.dispatchMoveStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoc
 * JD-Core Version:    0.7.0.1
 */