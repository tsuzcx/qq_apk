import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

class rwl
  implements View.OnTouchListener
{
  rwl(rwk paramrwk, Drawable paramDrawable, rwo paramrwo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((this.val$drawable instanceof GradientDrawable)) {
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)this.val$drawable).setColor(-15263977);
        }
        else
        {
          ((GradientDrawable)this.val$drawable).setColor(-920840);
          continue;
          if (rwk.a(this.jdField_b_of_type_Rwk) != null) {
            rwk.a(this.jdField_b_of_type_Rwk).a(this.jdField_b_of_type_Rwo);
          }
          if ((this.val$drawable instanceof GradientDrawable)) {
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
              ((GradientDrawable)this.val$drawable).setColor(-16777216);
            } else {
              ((GradientDrawable)this.val$drawable).setColor(-1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwl
 * JD-Core Version:    0.7.0.1
 */