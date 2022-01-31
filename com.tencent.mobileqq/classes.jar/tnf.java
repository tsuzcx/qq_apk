import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;

class tnf
  implements tmq
{
  tnf(tne paramtne, Runnable paramRunnable) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (tne.a(this.jdField_a_of_type_Tne) != null)
    {
      localObject = new Rect();
      tne.a(this.jdField_a_of_type_Tne).a((Rect)localObject);
      if ((tne.a(this.jdField_a_of_type_Tne)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - azkz.a(10.0F)) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + azkz.a(10.0F))))
      {
        if (!tne.a(this.jdField_a_of_type_Tne))
        {
          tne.a(this.jdField_a_of_type_Tne, true);
          tne.a(this.jdField_a_of_type_Tne).a(this.jdField_a_of_type_JavaLangRunnable);
          tne.a(this.jdField_a_of_type_Tne).setSeekBarActivated(true);
          tne.a(this.jdField_a_of_type_Tne).setThumb(tne.b(this.jdField_a_of_type_Tne).getDrawable(2130841469));
          tne.a(this.jdField_a_of_type_Tne).requestDisallowInterceptTouchEvent(true);
        }
        f3 = ((Rect)localObject).top;
        f4 = ((Rect)localObject).height() / 2.0F;
        f2 = paramMotionEvent.getX() - ((Rect)localObject).left;
        if (f2 >= 0.0F) {}
      }
    }
    for (;;)
    {
      localObject = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f3 + f4, paramMotionEvent.getMetaState());
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        tne.a(this.jdField_a_of_type_Tne).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        tne.a(this.jdField_a_of_type_Tne, false);
        tne.a(this.jdField_a_of_type_Tne).requestDisallowInterceptTouchEvent(false);
      }
      tne.a(this.jdField_a_of_type_Tne).a((MotionEvent)localObject);
      return true;
      if (f2 > ((Rect)localObject).width())
      {
        f1 = ((Rect)localObject).width();
        continue;
        return false;
      }
      else
      {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnf
 * JD-Core Version:    0.7.0.1
 */