import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

public class vbh
  implements QueryCallback
{
  public vbh(MarketFaceItemBuilder paramMarketFaceItemBuilder, String paramString, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 10002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1002) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1003) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1005) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1006))
    {
      paramEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null)
      {
        paramEmoticonPackage.obtainMessage(22, this.jdField_a_of_type_JavaLangString).sendToTarget();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_aio_pkg_tab", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, this.jdField_a_of_type_JavaLangString, "", "");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder, "big_img");
      return;
    }
    MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
    MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramEmoticonPackage = "0";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) {
      paramEmoticonPackage = "1";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_detail_aio", 0, 0, "", paramEmoticonPackage, "", "");
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_JavaLangString, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbh
 * JD-Core Version:    0.7.0.1
 */