import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

class vaw
  implements Runnable
{
  vaw(vau paramvau, Emoticon paramEmoticon, String paramString, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2) && (this.jdField_a_of_type_Vau.a.b != null) && ((this.jdField_a_of_type_Vau.a.b instanceof FragmentActivity)))
    {
      localObject1 = (FragmentActivity)this.jdField_a_of_type_Vau.a.b;
      if ((((FragmentActivity)localObject1).getChatFragment() != null) && (((FragmentActivity)localObject1).getChatFragment().a() != null) && (MagicfaceViewController.a())) {
        ((FragmentActivity)localObject1).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 1, this.jdField_a_of_type_JavaLangString, false);
      }
      ReportController.b(this.jdField_a_of_type_Vau.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (this.jdField_a_of_type_Vau.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()))
    {
      if (!this.jdField_a_of_type_Vau.a.c) {
        break label431;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setImageResource(2130837576);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    for (;;)
    {
      localObject1 = new Intent(this.jdField_a_of_type_Vau.a.b, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("selfUin", this.jdField_a_of_type_Vau.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.jdField_a_of_type_Vau.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject1).putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject2 = (EmoticonManager)this.jdField_a_of_type_Vau.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((EmoticonManager)localObject2).a(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.jdField_a_of_type_Vau.a.b.startActivity((Intent)localObject1);
      return;
      label431:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vaw
 * JD-Core Version:    0.7.0.1
 */