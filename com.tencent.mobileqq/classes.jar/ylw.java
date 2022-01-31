import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class ylw
  extends ymd
{
  private Runnable a;
  
  protected ylw(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yny.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Ylv + " targetMode " + paramInt);
    yls localyls;
    if (this.jdField_a_of_type_Ylv != null)
    {
      localyls = (yls)this.jdField_a_of_type_Ylv;
      a();
      if (paramInt == 1)
      {
        if (localyls.jdField_a_of_type_AndroidViewView != null) {
          localyls.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localyls.jdField_f_of_type_AndroidViewView, localyls.j, localyls.k, localyls.i);
        a(localyls.jdField_e_of_type_AndroidViewView, localyls.jdField_g_of_type_Int, localyls.jdField_h_of_type_Int);
        a(localyls.jdField_b_of_type_AndroidViewView, localyls.jdField_a_of_type_Int, localyls.jdField_b_of_type_Int);
        a(localyls.jdField_d_of_type_AndroidViewView, localyls.jdField_e_of_type_Int, localyls.jdField_f_of_type_Int);
        a(localyls.jdField_c_of_type_AndroidViewView, localyls.jdField_c_of_type_Int, localyls.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localyls.jdField_f_of_type_AndroidViewView, -localyls.j, -localyls.k, -localyls.i);
    a(localyls.jdField_e_of_type_AndroidViewView, -localyls.jdField_g_of_type_Int, -localyls.jdField_h_of_type_Int);
    a(localyls.jdField_b_of_type_AndroidViewView, -localyls.jdField_a_of_type_Int, -localyls.jdField_b_of_type_Int);
    a(localyls.jdField_d_of_type_AndroidViewView, -localyls.jdField_e_of_type_Int, -localyls.jdField_f_of_type_Int);
    a(localyls.jdField_c_of_type_AndroidViewView, -localyls.jdField_c_of_type_Int, -localyls.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    yls localyls = new yls();
    localyls.jdField_a_of_type_AndroidViewView = paramView1;
    localyls.jdField_f_of_type_AndroidViewView = paramView3;
    localyls.jdField_g_of_type_AndroidViewView = paramView2;
    localyls.jdField_h_of_type_AndroidViewView = paramView8;
    localyls.j = ypk.a(-85, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localyls.k = ypk.a(-588, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localyls.i = ypk.a(416, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = ypk.a(400, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyls.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / ypk.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyls.jdField_b_of_type_Float = localyls.jdField_a_of_type_Float;
    }
    localyls.l = ypk.a(50, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localyls.m = ypk.a(50, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localyls.jdField_b_of_type_AndroidViewView = paramView4;
    localyls.jdField_c_of_type_AndroidViewView = paramView5;
    localyls.jdField_d_of_type_AndroidViewView = paramView6;
    localyls.jdField_e_of_type_AndroidViewView = paramView7;
    localyls.jdField_a_of_type_Int = ypk.a(-436, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localyls.jdField_b_of_type_Int = ypk.a(567, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext));
    localyls.jdField_c_of_type_Int = ypk.a(-275, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localyls.jdField_d_of_type_Int = ((ypk.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - ypk.a(196, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext)));
    localyls.jdField_e_of_type_Int = ypk.a(-269, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localyls.jdField_f_of_type_Int = ((ypk.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - ypk.a(196, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext)));
    localyls.jdField_g_of_type_Int = ypk.a(-257, 750, ypk.f(this.jdField_a_of_type_AndroidContentContext));
    localyls.jdField_h_of_type_Int = ((ypk.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - ypk.a(196, 1334, ypk.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localyls, paramView8);
    this.jdField_a_of_type_Ylv = localyls;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ylw
 * JD-Core Version:    0.7.0.1
 */