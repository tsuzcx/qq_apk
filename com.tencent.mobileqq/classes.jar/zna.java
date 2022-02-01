import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

class zna
  implements View.OnTouchListener
{
  zna(zmz paramzmz, Drawable paramDrawable, znf paramznf) {}
  
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
          if (zmz.a(this.jdField_a_of_type_Zmz) != null) {
            zmz.a(this.jdField_a_of_type_Zmz).a(this.jdField_a_of_type_Znf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zna
 * JD-Core Version:    0.7.0.1
 */