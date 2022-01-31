import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class uyj
  implements QueryCallback
{
  public uyj(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong) {}
  
  public void a(Void paramVoid)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.copywritingContent);
    PicItemBuilder.e();
    long l = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageResource(2130837572);
    }
    for (;;)
    {
      l = System.currentTimeMillis();
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        QLog.d("MarketFaceItemBuilder", 1, "epId = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId + ":view time = " + (l - this.jdField_a_of_type_Long));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setContentDescription("大表情:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name);
      if (2 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType)
      {
        PngFrameManager localPngFrameManager = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getManager(82);
        boolean bool = false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_c_of_type_Int - 1) {
          bool = localPngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramVoid = "";
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0)) {
            paramVoid = new String(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.mMarkFaceMessage.mobileparam);
          }
        }
        for (;;)
        {
          localPngFrameManager.a(paramVoid, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder, l, bool, true, new uyk(this));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.d.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(8);
          MarketFaceItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
          break;
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
          continue;
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
        }
      }
      if (4 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        }
        MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
        MarketFaceItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
      }
      else
      {
        MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyj
 * JD-Core Version:    0.7.0.1
 */