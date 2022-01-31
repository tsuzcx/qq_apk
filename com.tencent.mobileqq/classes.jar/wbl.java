import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessActivity.AnimationDrawable2;
import com.tencent.mobileqq.activity.bless.BlessActivity.IAnimationFinishListener;
import com.tencent.mobileqq.activity.bless.BlessManager;

public class wbl
  implements BlessActivity.IAnimationFinishListener
{
  public wbl(BlessActivity paramBlessActivity) {}
  
  public void a()
  {
    if (BlessActivity.a(this.a) < this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.m())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.a();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity$AnimationDrawable2.start();
      BlessActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbl
 * JD-Core Version:    0.7.0.1
 */