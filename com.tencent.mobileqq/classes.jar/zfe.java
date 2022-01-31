import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public final class zfe
  implements AdapterView.OnItemClickListener
{
  public zfe(ShareActionSheetBuilder paramShareActionSheetBuilder, int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c;
    paramAdapterView = "";
    if (1 == this.jdField_a_of_type_Int)
    {
      paramAdapterView = "0X8005D50";
      if (!TextUtils.isEmpty(paramAdapterView)) {}
      switch (i)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        label104:
        if ((i != 9) && (i != 10)) {
          break label325;
        }
        paramInt = -1;
        if (!WXShareHelper.a().a()) {
          paramInt = 2131435319;
        }
        break;
      }
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label325;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131558448));
      return;
      if (2 == this.jdField_a_of_type_Int)
      {
        paramAdapterView = "0X8005D51";
        break;
      }
      if (3 != this.jdField_a_of_type_Int) {
        break;
      }
      paramAdapterView = "";
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "1", "", "", "");
      break label104;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "2", "", "", "");
      break label104;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "3", "", "", "");
      break label104;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "4", "", "", "");
      break label104;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131435320;
      }
    }
    label325:
    paramAdapterView = "邀请加入QQ热聊：" + this.jdField_a_of_type_JavaLangString;
    switch (i)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      paramAdapterView = "我在[" + this.jdField_a_of_type_JavaLangString + "]热聊";
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, this.b, this.c, this.d, this.e, false);
      return;
    case 3: 
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, this.b, this.c, this.e);
      return;
    case 9: 
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, "立即加入，一起热聊！\nQQ热聊有上百个热门话题，与同兴趣的人一起群聊。", this.f, this.c, this.g);
      return;
    }
    HotChatHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, this.b, this.f, this.c, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfe
 * JD-Core Version:    0.7.0.1
 */