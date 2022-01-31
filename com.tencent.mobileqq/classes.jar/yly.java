import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class yly
  extends ymd
{
  private Runnable a;
  
  protected yly(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yny.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Ylv + " targetMode " + paramInt);
    ylu localylu;
    if (this.jdField_a_of_type_Ylv != null)
    {
      localylu = (ylu)this.jdField_a_of_type_Ylv;
      a();
      if (paramInt == 1)
      {
        if (localylu.jdField_a_of_type_AndroidViewView != null) {
          localylu.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localylu.jdField_f_of_type_AndroidViewView, localylu.j, localylu.k);
        a(localylu.jdField_e_of_type_AndroidViewView, localylu.jdField_g_of_type_Int, localylu.h);
        a(localylu.jdField_b_of_type_AndroidViewView, localylu.jdField_a_of_type_Int, localylu.jdField_b_of_type_Int);
        a(localylu.jdField_d_of_type_AndroidViewView, localylu.jdField_e_of_type_Int, localylu.jdField_f_of_type_Int);
        a(localylu.jdField_c_of_type_AndroidViewView, localylu.jdField_c_of_type_Int, localylu.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localylu.jdField_f_of_type_AndroidViewView, -localylu.j, -localylu.k);
    a(localylu.jdField_e_of_type_AndroidViewView, -localylu.jdField_g_of_type_Int, -localylu.h);
    a(localylu.jdField_b_of_type_AndroidViewView, -localylu.jdField_a_of_type_Int, -localylu.jdField_b_of_type_Int);
    a(localylu.jdField_d_of_type_AndroidViewView, -localylu.jdField_e_of_type_Int, -localylu.jdField_f_of_type_Int);
    a(localylu.jdField_c_of_type_AndroidViewView, -localylu.jdField_c_of_type_Int, -localylu.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    ylu localylu = new ylu();
    localylu.jdField_a_of_type_AndroidViewView = paramView1;
    localylu.jdField_f_of_type_AndroidViewView = paramView3;
    localylu.jdField_g_of_type_AndroidViewView = paramView2;
    localylu.j = ypk.a(-406, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylu.k = ypk.a(125, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    float f = ypk.a(220, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localylu.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / ypk.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localylu.jdField_b_of_type_Float = localylu.jdField_a_of_type_Float;
    }
    localylu.l = ypk.a(50, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localylu.m = ypk.a(50, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylu.jdField_b_of_type_AndroidViewView = paramView4;
    localylu.jdField_c_of_type_AndroidViewView = paramView5;
    localylu.jdField_d_of_type_AndroidViewView = paramView6;
    localylu.jdField_e_of_type_AndroidViewView = paramView7;
    localylu.jdField_a_of_type_Int = ypk.a(-618, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylu.jdField_b_of_type_Int = ypk.a(275, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localylu.jdField_c_of_type_Int = ypk.a(-457, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylu.jdField_d_of_type_Int = ((ypk.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - ypk.a(196, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext)));
    localylu.jdField_e_of_type_Int = ypk.a(-451, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylu.jdField_f_of_type_Int = ((ypk.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - ypk.a(196, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext)));
    localylu.jdField_g_of_type_Int = ypk.a(-440, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localylu.h = ((ypk.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - ypk.a(196, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localylu, paramView8);
    this.jdField_a_of_type_Ylv = localylu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yly
 * JD-Core Version:    0.7.0.1
 */