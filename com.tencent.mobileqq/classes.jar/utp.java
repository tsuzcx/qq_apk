import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;

class utp
  implements urd
{
  utp(uto paramuto, Runnable paramRunnable) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (uto.a(this.jdField_a_of_type_Uto) != null)
    {
      localObject = new Rect();
      uto.a(this.jdField_a_of_type_Uto).a((Rect)localObject);
      if ((uto.a(this.jdField_a_of_type_Uto)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - bclx.a(10.0F)) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + bclx.a(10.0F))))
      {
        if (!uto.a(this.jdField_a_of_type_Uto))
        {
          uto.a(this.jdField_a_of_type_Uto, true);
          uto.a(this.jdField_a_of_type_Uto).a(this.jdField_a_of_type_JavaLangRunnable);
          uto.a(this.jdField_a_of_type_Uto).setSeekBarActivated(true);
          uto.a(this.jdField_a_of_type_Uto).setThumb(uto.b(this.jdField_a_of_type_Uto).getDrawable(2130841781));
          uto.a(this.jdField_a_of_type_Uto).requestDisallowInterceptTouchEvent(true);
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
        uto.a(this.jdField_a_of_type_Uto).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
        uto.a(this.jdField_a_of_type_Uto, false);
        uto.a(this.jdField_a_of_type_Uto).requestDisallowInterceptTouchEvent(false);
      }
      uto.a(this.jdField_a_of_type_Uto).a((MotionEvent)localObject);
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
 * Qualified Name:     utp
 * JD-Core Version:    0.7.0.1
 */