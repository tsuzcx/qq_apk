import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.ArkHighLightClickCallback;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.text.QQText.ArkHighlightSpan;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class vfq
  implements TextItemBuilder.ArkHighLightClickCallback
{
  public vfq(TextItemBuilder paramTextItemBuilder, RecommendCommonMessage paramRecommendCommonMessage, TextItemBuilder.Holder paramHolder, int paramInt, String paramString1, String paramString2, String paramString3, Spannable paramSpannable) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a().jdField_a_of_type_ComTencentMobileqqArkArkRecommendController;
        if (localObject != null) {
          ((ArkRecommendController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener, this.jdField_a_of_type_Int);
        }
      }
    }
    ArkAppDataReport.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType, this.b);
    if (4 == this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType) {
      ArkAppDataReport.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType, this.b);
    }
    Object localObject = (ArkAppHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
    int i;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer)
    {
      i = 2;
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
      str3 = this.jdField_a_of_type_JavaLangString;
      str4 = this.c;
      str5 = this.jdField_a_of_type_AndroidTextSpannable.toString();
      if (!"1".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
        break label286;
      }
    }
    label286:
    for (int j = 1;; j = 0)
    {
      ((ArkAppHandler)localObject).a(i, 3, 2, str1, str2, str3, str4, str5, j, 0);
      return;
      i = 100;
      break;
    }
  }
  
  public void a(View paramView, TextItemBuilder.ArkHighLightClickCallback paramArkHighLightClickCallback)
  {
    Object localObject = paramView.getContext();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkDialog", 2, "appinterface is Empty");
      }
    }
    do
    {
      do
      {
        return;
      } while (paramArkHighLightClickCallback == null);
      if (!TextUtils.isEmpty(ArkRecommendController.a((Context)localObject, localQQAppInterface))) {
        break;
      }
    } while ((BaseActivity.sTopActivity == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
    localObject = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
    ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(BaseActivity.sTopActivity, 2131624515);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, paramView, localQQAppInterface, paramArkHighLightClickCallback);
    return;
    QQText.ArkHighlightSpan.a(paramView, paramArkHighLightClickCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfq
 * JD-Core Version:    0.7.0.1
 */