import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation;

public class uoh
  extends View
{
  public uoh(XBubbleAnimation paramXBubbleAnimation, Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a()) || (this.a.b.a())) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new uoi(this));
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.a.b.d)) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new uoj(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uoh
 * JD-Core Version:    0.7.0.1
 */