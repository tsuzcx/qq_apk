import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class vrg
  implements vor
{
  vrg(vrf paramvrf, Runnable paramRunnable) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (vrf.a(this.jdField_a_of_type_Vrf) != null)
    {
      localObject = new Rect();
      vrf.a(this.jdField_a_of_type_Vrf).a((Rect)localObject);
      if ((vrf.a(this.jdField_a_of_type_Vrf)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - ScreenUtil.dip2px(10.0F)) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + ScreenUtil.dip2px(10.0F))))
      {
        if (!vrf.a(this.jdField_a_of_type_Vrf))
        {
          vrf.a(this.jdField_a_of_type_Vrf, true);
          vrf.a(this.jdField_a_of_type_Vrf).a(this.jdField_a_of_type_JavaLangRunnable);
          vrf.a(this.jdField_a_of_type_Vrf).setSeekBarActivated(true);
          vrf.a(this.jdField_a_of_type_Vrf).setThumb(vrf.b(this.jdField_a_of_type_Vrf).getDrawable(2130841847));
          vrf.a(this.jdField_a_of_type_Vrf).requestDisallowInterceptTouchEvent(true);
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
        vrf.a(this.jdField_a_of_type_Vrf).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
        vrf.a(this.jdField_a_of_type_Vrf, false);
        vrf.a(this.jdField_a_of_type_Vrf).requestDisallowInterceptTouchEvent(false);
      }
      vrf.a(this.jdField_a_of_type_Vrf).a((MotionEvent)localObject);
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
 * Qualified Name:     vrg
 * JD-Core Version:    0.7.0.1
 */