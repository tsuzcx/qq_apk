import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class vcm
  implements uzz
{
  vcm(vcl paramvcl, Runnable paramRunnable) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (vcl.a(this.jdField_a_of_type_Vcl) != null)
    {
      localObject = new Rect();
      vcl.a(this.jdField_a_of_type_Vcl).a((Rect)localObject);
      if ((vcl.a(this.jdField_a_of_type_Vcl)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - ScreenUtil.dip2px(10.0F)) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + ScreenUtil.dip2px(10.0F))))
      {
        if (!vcl.a(this.jdField_a_of_type_Vcl))
        {
          vcl.a(this.jdField_a_of_type_Vcl, true);
          vcl.a(this.jdField_a_of_type_Vcl).a(this.jdField_a_of_type_JavaLangRunnable);
          vcl.a(this.jdField_a_of_type_Vcl).setSeekBarActivated(true);
          vcl.a(this.jdField_a_of_type_Vcl).setThumb(vcl.b(this.jdField_a_of_type_Vcl).getDrawable(2130841834));
          vcl.a(this.jdField_a_of_type_Vcl).requestDisallowInterceptTouchEvent(true);
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
        vcl.a(this.jdField_a_of_type_Vcl).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
        vcl.a(this.jdField_a_of_type_Vcl, false);
        vcl.a(this.jdField_a_of_type_Vcl).requestDisallowInterceptTouchEvent(false);
      }
      vcl.a(this.jdField_a_of_type_Vcl).a((MotionEvent)localObject);
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
 * Qualified Name:     vcm
 * JD-Core Version:    0.7.0.1
 */