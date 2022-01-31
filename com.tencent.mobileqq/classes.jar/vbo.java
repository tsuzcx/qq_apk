import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class vbo
  implements View.OnClickListener
{
  public vbo(MarketFaceItemBuilder paramMarketFaceItemBuilder, int paramInt, String paramString1, String paramString2, MarkFaceMessage paramMarkFaceMessage, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "rewordTxt has been clicked! type = " + this.jdField_a_of_type_Int + " content = " + this.jdField_a_of_type_JavaLangString + " jumpUrl = " + this.b);
    }
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.showIpProduct)
    {
      paramView = "1";
      if (!TextUtils.isEmpty(this.b))
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.b, -1L, (Intent)localObject, false, -1);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.c();
        str2 = MarketFaceItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a != null) {
          break label200;
        }
      }
    }
    label200:
    for (Object localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_click", "AIO", 1, 0, 1, str2, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.copywritingContent, paramView, "", "", "", 0, 0, 0, 0);
      return;
      paramView = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbo
 * JD-Core Version:    0.7.0.1
 */