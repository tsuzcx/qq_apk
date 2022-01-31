import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;

public class uvn
  implements FileManagerUtil.TipsClickedInterface
{
  public uvn(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2, MessageRecord paramMessageRecord, String paramString3, AioVipKeywordHelper paramAioVipKeywordHelper) {}
  
  public void a(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.i, this.jdField_a_of_type_JavaLangString);
    paramView.putString(VasH5PayUtil.c, this.b);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
      paramView.putString(VasH5PayUtil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
    }
    VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, paramView);
    String str = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {}
    for (paramView = "0";; paramView = "1")
    {
      VasWebviewUtil.reportVipKeywords(str, paramView, "1", this.jdField_a_of_type_ComTencentMobileqqVipAioVipKeywordHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvn
 * JD-Core Version:    0.7.0.1
 */