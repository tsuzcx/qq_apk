import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.data.MessageForScribble;

public class xmn
  implements ausj.a
{
  public xmn(ScribbleItemBuilder paramScribbleItemBuilder, View paramView, MessageForScribble paramMessageForScribble, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.IX < 500L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.IX = l;
      paramView = wla.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.app);
      if (paramView != null) {
        paramView.a(this.val$contentView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder);
      }
      amjb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmn
 * JD-Core Version:    0.7.0.1
 */