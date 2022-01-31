import android.app.Activity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

class uyo
  implements Runnable
{
  uyo(uyn paramuyn) {}
  
  public void run()
  {
    Object localObject = (EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getManager(13);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a != null) {
      ((EmoticonManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a != null) {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getAccount(), 12, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId), false, false);
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a == null) {}
    for (localObject = "";; localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007188", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyo
 * JD-Core Version:    0.7.0.1
 */