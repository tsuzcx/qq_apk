import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation585V.1;

public class yvp
  extends yvu
{
  private Runnable a;
  
  protected yvp(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation585V.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yxs.b("GdtMotiveVideoAd", "585V doAnimation " + this.jdField_a_of_type_Yvm + " targetMode " + paramInt);
    yvl localyvl;
    if (this.jdField_a_of_type_Yvm != null)
    {
      localyvl = (yvl)this.jdField_a_of_type_Yvm;
      a();
      if (paramInt == 1)
      {
        if (localyvl.jdField_a_of_type_AndroidViewView != null) {
          localyvl.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localyvl.jdField_f_of_type_AndroidViewView, localyvl.j, localyvl.k);
        a(localyvl.jdField_e_of_type_AndroidViewView, localyvl.jdField_g_of_type_Int, localyvl.h);
        a(localyvl.jdField_b_of_type_AndroidViewView, localyvl.jdField_a_of_type_Int, localyvl.jdField_b_of_type_Int);
        a(localyvl.jdField_d_of_type_AndroidViewView, localyvl.jdField_e_of_type_Int, localyvl.jdField_f_of_type_Int);
        a(localyvl.jdField_c_of_type_AndroidViewView, localyvl.jdField_c_of_type_Int, localyvl.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localyvl.jdField_f_of_type_AndroidViewView, -localyvl.j, -localyvl.k);
    a(localyvl.jdField_e_of_type_AndroidViewView, -localyvl.jdField_g_of_type_Int, -localyvl.h);
    a(localyvl.jdField_b_of_type_AndroidViewView, -localyvl.jdField_a_of_type_Int, -localyvl.jdField_b_of_type_Int);
    a(localyvl.jdField_d_of_type_AndroidViewView, -localyvl.jdField_e_of_type_Int, -localyvl.jdField_f_of_type_Int);
    a(localyvl.jdField_c_of_type_AndroidViewView, -localyvl.jdField_c_of_type_Int, -localyvl.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    yvl localyvl = new yvl();
    localyvl.jdField_a_of_type_AndroidViewView = paramView1;
    localyvl.jdField_f_of_type_AndroidViewView = paramView3;
    localyvl.jdField_g_of_type_AndroidViewView = paramView2;
    localyvl.j = yze.a(-406, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvl.k = yze.a(125, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    float f = yze.a(220, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyvl.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / yze.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyvl.jdField_b_of_type_Float = localyvl.jdField_a_of_type_Float;
    }
    localyvl.l = yze.a(50, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvl.m = yze.a(50, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvl.jdField_b_of_type_AndroidViewView = paramView4;
    localyvl.jdField_c_of_type_AndroidViewView = paramView5;
    localyvl.jdField_d_of_type_AndroidViewView = paramView6;
    localyvl.jdField_e_of_type_AndroidViewView = paramView7;
    localyvl.jdField_a_of_type_Int = yze.a(-618, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvl.jdField_b_of_type_Int = yze.a(275, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvl.jdField_c_of_type_Int = yze.a(-457, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvl.jdField_d_of_type_Int = ((yze.f(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - yze.a(196, 750, yze.f(this.jdField_a_of_type_AndroidContentContext)));
    localyvl.jdField_e_of_type_Int = yze.a(-451, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvl.jdField_f_of_type_Int = ((yze.f(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - yze.a(196, 750, yze.f(this.jdField_a_of_type_AndroidContentContext)));
    localyvl.jdField_g_of_type_Int = yze.a(-440, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvl.h = ((yze.f(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - yze.a(196, 750, yze.f(this.jdField_a_of_type_AndroidContentContext)));
    a(localyvl, paramView8);
    this.jdField_a_of_type_Yvm = localyvl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvp
 * JD-Core Version:    0.7.0.1
 */