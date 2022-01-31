import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import java.util.Iterator;

public class xpt
  extends xpd
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  protected View a;
  protected AnimationView a;
  xpj jdField_a_of_type_Xpj;
  View b;
  View c;
  
  public xpt(Activity paramActivity, xpj paramxpj)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xpj = paramxpj;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, xpv paramxpv, boolean paramBoolean)
  {
    if (paramxpv == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramxpv.c();
      paramRect1 = paramxpv.b();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramxpv.a(paramBoolean)));
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    if ((paramxpv instanceof aeiy)) {}
    for (paramRect2 = ((aeiy)paramxpv).a;; paramRect2 = null)
    {
      if ((!bfnz.e()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable))) {}
      for (paramRect1 = xpu.a(k, m, i, j, false, paramRect2);; paramRect1 = null)
      {
        if (paramRect1 == null) {
          paramRect1 = xpu.a(k, m, i, j, paramRect2);
        }
        for (;;)
        {
          paramRect4.set(paramRect1);
          return localDrawable;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((xps)localIterator.next()).b();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      f();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    xpv localxpv = this.jdField_a_of_type_Xpj.a();
    if (localxpv == null) {
      return false;
    }
    Rect localRect3 = localxpv.a();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localxpv, true);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable != null)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label126:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localxpv.c;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect1, localRect2, localxpv.a(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((xps)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      f();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    xpv localxpv = this.jdField_a_of_type_Xpj.a();
    Rect localRect1 = null;
    if (localxpv != null) {
      localRect1 = localxpv.a();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localxpv, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label127;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label127:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localxpv.c;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localxpv.a(), localxpv.c(), localxpv.d(), this.jdField_a_of_type_Long);
      if (localRect1 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localxpv.a(), localxpv.c(), localxpv.d(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((xps)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((xps)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131366897);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362548));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131375493);
    this.c = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xpt
 * JD-Core Version:    0.7.0.1
 */