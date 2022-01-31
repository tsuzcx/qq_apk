import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

class vve
  implements View.OnTouchListener
{
  vve(vvd paramvvd, Drawable paramDrawable, vvj paramvvj) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable)) {
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-15263977);
        }
        else
        {
          ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-920840);
          continue;
          if (vvd.a(this.jdField_a_of_type_Vvd) != null) {
            vvd.a(this.jdField_a_of_type_Vvd).a(this.jdField_a_of_type_Vvj);
          }
          if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable)) {
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
              ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-16777216);
            } else {
              ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vve
 * JD-Core Version:    0.7.0.1
 */