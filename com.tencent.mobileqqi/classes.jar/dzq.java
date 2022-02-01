import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dzq
  implements ActionSheet.OnButtonClickListener
{
  public dzq(MarketFaceItemBuilder paramMarketFaceItemBuilder, MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    ChatActivityFacade.a(MarketFaceItemBuilder.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
    ChatActivityFacade.a(MarketFaceItemBuilder.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, MarketFaceItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder), this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.uniseq);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzq
 * JD-Core Version:    0.7.0.1
 */