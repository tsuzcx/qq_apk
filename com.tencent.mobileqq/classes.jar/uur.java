import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;

class uur
  implements use
{
  uur(uuq paramuuq, Runnable paramRunnable) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (uuq.a(this.jdField_a_of_type_Uuq) != null)
    {
      localObject = new Rect();
      uuq.a(this.jdField_a_of_type_Uuq).a((Rect)localObject);
      if ((uuq.a(this.jdField_a_of_type_Uuq)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - bdep.a(10.0F)) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + bdep.a(10.0F))))
      {
        if (!uuq.a(this.jdField_a_of_type_Uuq))
        {
          uuq.a(this.jdField_a_of_type_Uuq, true);
          uuq.a(this.jdField_a_of_type_Uuq).a(this.jdField_a_of_type_JavaLangRunnable);
          uuq.a(this.jdField_a_of_type_Uuq).setSeekBarActivated(true);
          uuq.a(this.jdField_a_of_type_Uuq).setThumb(uuq.b(this.jdField_a_of_type_Uuq).getDrawable(2130841792));
          uuq.a(this.jdField_a_of_type_Uuq).requestDisallowInterceptTouchEvent(true);
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
        uuq.a(this.jdField_a_of_type_Uuq).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
        uuq.a(this.jdField_a_of_type_Uuq, false);
        uuq.a(this.jdField_a_of_type_Uuq).requestDisallowInterceptTouchEvent(false);
      }
      uuq.a(this.jdField_a_of_type_Uuq).a((MotionEvent)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uur
 * JD-Core Version:    0.7.0.1
 */