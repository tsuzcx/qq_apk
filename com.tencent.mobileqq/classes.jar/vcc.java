import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.widget.MessageProgressView;

public class vcc
  implements Runnable
{
  public vcc(ScribbleItemBuilder paramScribbleItemBuilder, MessageForScribble paramMessageForScribble, ScribbleItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    ScribbleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mUiProgress, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder$Holder.a.isShown()) {
      ScribbleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder).postDelayed(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mUpdateProgressRunnable, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcc
 * JD-Core Version:    0.7.0.1
 */