import android.content.Context;
import android.view.View;

public class yvo
  extends yvu
{
  protected yvo(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    yxs.b("GdtMotiveVideoAd", "185V doAnimation " + this.jdField_a_of_type_Yvm + " targetMode " + paramInt);
    yvk localyvk;
    if (this.jdField_a_of_type_Yvm != null)
    {
      localyvk = (yvk)this.jdField_a_of_type_Yvm;
      a();
      if (paramInt == 1)
      {
        a(localyvk.jdField_a_of_type_AndroidViewView, localyvk.jdField_a_of_type_Int, 0);
        a(localyvk.f, localyvk.j, localyvk.k);
      }
    }
    else
    {
      return;
    }
    a(localyvk.jdField_a_of_type_AndroidViewView, -localyvk.jdField_a_of_type_Int, 0);
    a(localyvk.f, -localyvk.j, -localyvk.k);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, View paramView4)
  {
    yvk localyvk = new yvk();
    localyvk.jdField_a_of_type_AndroidViewView = paramView1;
    localyvk.f = paramView2;
    localyvk.g = paramView3;
    localyvk.jdField_a_of_type_Int = yze.a(-306, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvk.j = yze.a(-406, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    localyvk.k = yze.a(125, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    float f = yze.a(400, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    if (f > 0.0F)
    {
      localyvk.jdField_a_of_type_Float = (Float.valueOf(f * 1.0F / yze.f(this.jdField_a_of_type_AndroidContentContext)).floatValue() - 1.0F);
      localyvk.b = localyvk.jdField_a_of_type_Float;
    }
    localyvk.l = yze.a(50, 750, yze.f(this.jdField_a_of_type_AndroidContentContext));
    localyvk.m = yze.a(-100, 1334, yze.e(this.jdField_a_of_type_AndroidContentContext));
    a(localyvk, paramView4);
    this.jdField_a_of_type_Yvm = localyvk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvo
 * JD-Core Version:    0.7.0.1
 */