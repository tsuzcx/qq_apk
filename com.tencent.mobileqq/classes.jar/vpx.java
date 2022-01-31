import android.view.View;
import com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask;
import com.tencent.mobileqq.activity.aio.item.TroopStoryItemBuilder;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vpx
  implements ActionSheet.OnButtonClickListener
{
  public vpx(TroopStoryItemBuilder paramTroopStoryItemBuilder, MessageForTroopStory paramMessageForTroopStory, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      TroopStoryForwardTask.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopStoryItemBuilder.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopStory).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpx
 * JD-Core Version:    0.7.0.1
 */