import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class yvn
  extends yvu
{
  private Runnable a;
  
  protected yvn(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yxs.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Yvm + " targetMode " + paramInt);
    yvj localyvj;
    if (this.jdField_a_of_type_Yvm != null)
    {
      localyvj = (yvj)this.jdField_a_of_type_Yvm;
      a();
      if (paramInt == 1)
      {
        if (localyvj.jdField_a_of_type_AndroidViewView != null) {
          localyvj.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localyvj.jdField_f_of_type_AndroidViewView, localyvj.j, localyvj.k, localyvj.i);
        a(localyvj.jdField_e_of_type_AndroidViewView, localyvj.jdField_g_of_type_Int, localyvj.jdField_h_of_type_Int);
        a(localyvj.jdField_b_of_type_AndroidViewView, localyvj.jdField_a_of_type_Int, localyvj.jdField_b_of_type_Int);
        a(localyvj.jdField_d_of_type_AndroidViewView, localyvj.jdField_e_of_type_Int, localyvj.jdField_f_of_type_Int);
        a(localyvj.jdField_c_of_type_AndroidViewView, localyvj.jdField_c_of_type_Int, localyvj.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localyvj.jdField_f_of_type_AndroidViewView, -localyvj.j, -localyvj.k, -localyvj.i);
    a(localyvj.jdField_e_of_type_AndroidViewView, -localyvj.jdField_g_of_type_Int, -localyvj.jdField_h_of_type_Int);
    a(localyvj.jdField_b_of_type_AndroidViewView, -localyvj.jdField_a_of_type_Int, -localyvj.jdField_b_of_type_Int);
    a(localyvj.jdField_d_of_type_AndroidViewView, -localyvj.jdField_e_of_type_Int, -localyvj.jdField_f_of_type_Int);
    a(localyvj.jdField_c_of_type_AndroidViewView, -localyvj.jdField_c_of_type_Int, -localyvj.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    yvj localyvj = new yvj();
    localyvj.jdField_a_of_type_AndroidViewView = paramView1;
    localyvj.jdField_f_of_type_AndroidViewView = paramView3;
    localyvj.jdField_g_of_type_AndroidViewView = paramView2;
    localyvj.jdField_h_of_type_AndroidViewView = paramView8;
    localyvj.j = yze.a(-85, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvj.k = yze.a(-588, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvj.i = yze.a(416, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = yze.a(400, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyvj.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / yze.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyvj.jdField_b_of_type_Float = localyvj.jdField_a_of_type_Float;
    }
    localyvj.l = yze.a(50, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvj.m = yze.a(50, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvj.jdField_b_of_type_AndroidViewView = paramView4;
    localyvj.jdField_c_of_type_AndroidViewView = paramView5;
    localyvj.jdField_d_of_type_AndroidViewView = paramView6;
    localyvj.jdField_e_of_type_AndroidViewView = paramView7;
    localyvj.jdField_a_of_type_Int = yze.a(-436, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvj.jdField_b_of_type_Int = yze.a(567, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvj.jdField_c_of_type_Int = yze.a(-275, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvj.jdField_d_of_type_Int = ((yze.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - yze.a(196, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext)));
    localyvj.jdField_e_of_type_Int = yze.a(-269, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvj.jdField_f_of_type_Int = ((yze.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - yze.a(196, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext)));
    localyvj.jdField_g_of_type_Int = yze.a(-257, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvj.jdField_h_of_type_Int = ((yze.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - yze.a(196, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localyvj, paramView8);
    this.jdField_a_of_type_Yvm = localyvj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvn
 * JD-Core Version:    0.7.0.1
 */