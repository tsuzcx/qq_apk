import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvAnimation185H.1;

public class yvk
  extends yvr
{
  private Runnable a;
  
  protected yvk(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new GdtMvAnimation185H.1(this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yxp.b("GdtMotiveVideoAd", "185H doAnimation " + this.jdField_a_of_type_Yvj + " targetMode " + paramInt);
    yvg localyvg;
    if (this.jdField_a_of_type_Yvj != null)
    {
      localyvg = (yvg)this.jdField_a_of_type_Yvj;
      a();
      if (paramInt == 1)
      {
        if (localyvg.jdField_a_of_type_AndroidViewView != null) {
          localyvg.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
        a(localyvg.jdField_f_of_type_AndroidViewView, localyvg.j, localyvg.k, localyvg.i);
        a(localyvg.jdField_e_of_type_AndroidViewView, localyvg.jdField_g_of_type_Int, localyvg.jdField_h_of_type_Int);
        a(localyvg.jdField_b_of_type_AndroidViewView, localyvg.jdField_a_of_type_Int, localyvg.jdField_b_of_type_Int);
        a(localyvg.jdField_d_of_type_AndroidViewView, localyvg.jdField_e_of_type_Int, localyvg.jdField_f_of_type_Int);
        a(localyvg.jdField_c_of_type_AndroidViewView, localyvg.jdField_c_of_type_Int, localyvg.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    a(localyvg.jdField_f_of_type_AndroidViewView, -localyvg.j, -localyvg.k, -localyvg.i);
    a(localyvg.jdField_e_of_type_AndroidViewView, -localyvg.jdField_g_of_type_Int, -localyvg.jdField_h_of_type_Int);
    a(localyvg.jdField_b_of_type_AndroidViewView, -localyvg.jdField_a_of_type_Int, -localyvg.jdField_b_of_type_Int);
    a(localyvg.jdField_d_of_type_AndroidViewView, -localyvg.jdField_e_of_type_Int, -localyvg.jdField_f_of_type_Int);
    a(localyvg.jdField_c_of_type_AndroidViewView, -localyvg.jdField_c_of_type_Int, -localyvg.jdField_d_of_type_Int);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    yvg localyvg = new yvg();
    localyvg.jdField_a_of_type_AndroidViewView = paramView1;
    localyvg.jdField_f_of_type_AndroidViewView = paramView3;
    localyvg.jdField_g_of_type_AndroidViewView = paramView2;
    localyvg.jdField_h_of_type_AndroidViewView = paramView8;
    localyvg.j = yzb.a(-85, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvg.k = yzb.a(-588, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvg.i = yzb.a(416, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    float f = yzb.a(400, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyvg.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / yzb.e(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyvg.jdField_b_of_type_Float = localyvg.jdField_a_of_type_Float;
    }
    localyvg.l = yzb.a(50, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvg.m = yzb.a(50, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvg.jdField_b_of_type_AndroidViewView = paramView4;
    localyvg.jdField_c_of_type_AndroidViewView = paramView5;
    localyvg.jdField_d_of_type_AndroidViewView = paramView6;
    localyvg.jdField_e_of_type_AndroidViewView = paramView7;
    localyvg.jdField_a_of_type_Int = yzb.a(-436, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvg.jdField_b_of_type_Int = yzb.a(567, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvg.jdField_c_of_type_Int = yzb.a(-275, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvg.jdField_d_of_type_Int = ((yzb.e(this.jdField_a_of_type_AndroidContentContext) - paramView5.getWidth()) / 2 - yzb.a(196, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext)));
    localyvg.jdField_e_of_type_Int = yzb.a(-269, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvg.jdField_f_of_type_Int = ((yzb.e(this.jdField_a_of_type_AndroidContentContext) - paramView6.getWidth()) / 2 - yzb.a(196, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext)));
    localyvg.jdField_g_of_type_Int = yzb.a(-257, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvg.jdField_h_of_type_Int = ((yzb.e(this.jdField_a_of_type_AndroidContentContext) - paramView7.getWidth()) / 2 - yzb.a(196, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext)));
    a(localyvg, paramView8);
    this.jdField_a_of_type_Yvj = localyvg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvk
 * JD-Core Version:    0.7.0.1
 */