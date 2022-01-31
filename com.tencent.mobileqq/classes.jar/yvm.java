import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class yvm
  extends yvr
{
  private Runnable a;
  
  protected yvm(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yxp.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Yvj + " targetMode " + paramInt);
    yvi localyvi;
    if (this.jdField_a_of_type_Yvj != null)
    {
      localyvi = (yvi)this.jdField_a_of_type_Yvj;
      a();
      if (paramInt == 1)
      {
        if (localyvi.jdField_a_of_type_AndroidViewView != null) {
          localyvi.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localyvi.jdField_f_of_type_AndroidViewView, localyvi.j, localyvi.k);
        a(localyvi.jdField_e_of_type_AndroidViewView, localyvi.jdField_g_of_type_Int, localyvi.h);
        a(localyvi.jdField_b_of_type_AndroidViewView, localyvi.jdField_a_of_type_Int, localyvi.jdField_b_of_type_Int);
        a(localyvi.jdField_d_of_type_AndroidViewView, localyvi.jdField_e_of_type_Int, localyvi.jdField_f_of_type_Int);
        a(localyvi.jdField_c_of_type_AndroidViewView, localyvi.jdField_c_of_type_Int, localyvi.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localyvi.jdField_f_of_type_AndroidViewView, -localyvi.j, -localyvi.k);
    a(localyvi.jdField_e_of_type_AndroidViewView, -localyvi.jdField_g_of_type_Int, -localyvi.h);
    a(localyvi.jdField_b_of_type_AndroidViewView, -localyvi.jdField_a_of_type_Int, -localyvi.jdField_b_of_type_Int);
    a(localyvi.jdField_d_of_type_AndroidViewView, -localyvi.jdField_e_of_type_Int, -localyvi.jdField_f_of_type_Int);
    a(localyvi.jdField_c_of_type_AndroidViewView, -localyvi.jdField_c_of_type_Int, -localyvi.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    yvi localyvi = new yvi();
    localyvi.jdField_a_of_type_AndroidViewView = paramView1;
    localyvi.jdField_f_of_type_AndroidViewView = paramView3;
    localyvi.jdField_g_of_type_AndroidViewView = paramView2;
    localyvi.j = yzb.a(-406, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvi.k = yzb.a(125, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    float f = yzb.a(220, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyvi.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / yzb.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyvi.jdField_b_of_type_Float = localyvi.jdField_a_of_type_Float;
    }
    localyvi.l = yzb.a(50, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvi.m = yzb.a(50, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvi.jdField_b_of_type_AndroidViewView = paramView4;
    localyvi.jdField_c_of_type_AndroidViewView = paramView5;
    localyvi.jdField_d_of_type_AndroidViewView = paramView6;
    localyvi.jdField_e_of_type_AndroidViewView = paramView7;
    localyvi.jdField_a_of_type_Int = yzb.a(-618, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvi.jdField_b_of_type_Int = yzb.a(275, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvi.jdField_c_of_type_Int = yzb.a(-457, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvi.jdField_d_of_type_Int = ((yzb.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - yzb.a(196, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext)));
    localyvi.jdField_e_of_type_Int = yzb.a(-451, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvi.jdField_f_of_type_Int = ((yzb.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - yzb.a(196, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext)));
    localyvi.jdField_g_of_type_Int = yzb.a(-440, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvi.h = ((yzb.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - yzb.a(196, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localyvi, paramView8);
    this.jdField_a_of_type_Yvj = localyvi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvm
 * JD-Core Version:    0.7.0.1
 */