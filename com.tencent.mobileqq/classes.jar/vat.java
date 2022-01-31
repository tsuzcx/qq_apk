import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class vat
  implements QueryCallback
{
  public vat(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder, QQProgressDialog paramQQProgressDialog) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.eId, "");
    if (paramEmoticonPackage == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars.a(107, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder));
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId, EmojiManager.b);
      return;
    }
    MarketFaceItemBuilder.a(107, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vat
 * JD-Core Version:    0.7.0.1
 */