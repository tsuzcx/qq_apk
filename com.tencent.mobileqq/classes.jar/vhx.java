import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vhx
  implements ActionSheet.OnButtonClickListener
{
  public vhx(PokeEmoItemBuilder paramPokeEmoItemBuilder, MessageForPokeEmo paramMessageForPokeEmo, ActionSheet paramActionSheet) {}
  
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
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.c < 500L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.c = l;
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPokeEmo.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhx
 * JD-Core Version:    0.7.0.1
 */