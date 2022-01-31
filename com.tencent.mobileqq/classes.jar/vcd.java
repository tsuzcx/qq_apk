import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vcd
  implements ActionSheet.OnButtonClickListener
{
  public vcd(ScribbleItemBuilder paramScribbleItemBuilder, View paramView, MessageForScribble paramMessageForScribble, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.c < 500L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.c = l;
      paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.a);
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder);
      }
      ScribbleMsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */