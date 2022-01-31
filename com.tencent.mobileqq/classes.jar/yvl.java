import android.content.Context;
import android.view.View;

public class yvl
  extends yvr
{
  protected yvl(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yxp.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Yvj + " targetMode " + paramInt);
    yvh localyvh;
    if (this.jdField_a_of_type_Yvj != null)
    {
      localyvh = (yvh)this.jdField_a_of_type_Yvj;
      a();
      if (paramInt == 1)
      {
        a(localyvh.jdField_a_of_type_AndroidViewView, localyvh.jdField_a_of_type_Int, 0);
        a(localyvh.f, localyvh.j, localyvh.k);
      }
    }
    else
    {
      return;
    }
    a(localyvh.jdField_a_of_type_AndroidViewView, -localyvh.jdField_a_of_type_Int, 0);
    a(localyvh.f, -localyvh.j, -localyvh.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    yvh localyvh = new yvh();
    localyvh.jdField_a_of_type_AndroidViewView = paramView1;
    localyvh.f = paramView2;
    localyvh.g = paramView3;
    localyvh.jdField_a_of_type_Int = yzb.a(-306, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvh.j = yzb.a(-406, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    localyvh.k = yzb.a(125, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    float f = yzb.a(400, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyvh.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / yzb.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyvh.b = localyvh.jdField_a_of_type_Float;
    }
    localyvh.l = yzb.a(50, 750, yzb.f(this.jdField_a_of_type_AndroidContentContext));
    localyvh.m = yzb.a(-100, 1334, yzb.e(this.jdField_a_of_type_AndroidContentContext));
    a(localyvh, paramView4);
    this.jdField_a_of_type_Yvj = localyvh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvl
 * JD-Core Version:    0.7.0.1
 */