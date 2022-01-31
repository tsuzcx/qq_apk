import android.view.View;
import com.tencent.mobileqq.activity.aio.item.FrameAnimationActor;
import com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.Listener;

public class but
  implements Runnable
{
  public but(FrameAnimationActor paramFrameAnimationActor) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.a();
      }
      if (this.a.jdField_a_of_type_Int < this.a.jdField_a_of_type_ArrayOfInt.length) {
        break;
      }
      this.a.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.a.jdField_a_of_type_ArrayOfInt[this.a.b]);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.b();
    return;
    this.a.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.a.jdField_a_of_type_ArrayOfInt[this.a.jdField_a_of_type_Int]);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.a(this.a.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_AndroidViewView.postDelayed(FrameAnimationActor.a(this.a), this.a.c);
    FrameAnimationActor localFrameAnimationActor = this.a;
    localFrameAnimationActor.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     but
 * JD-Core Version:    0.7.0.1
 */