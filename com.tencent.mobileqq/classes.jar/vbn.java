import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class vbn
  implements View.OnClickListener
{
  public vbn(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder, MarkFaceMessage paramMarkFaceMessage) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b instanceof Activity))
    {
      paramView = new PanelData();
      paramView.a = 0;
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, 1);
      String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      String str2 = MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a == null) {}
      for (paramView = "";; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_click", "AIO", 1, 0, 1, str2, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.copywritingContent);
        return;
      }
    }
    QLog.e("MarketFaceItemBuilder", 1, "mContext is not Activity: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbn
 * JD-Core Version:    0.7.0.1
 */