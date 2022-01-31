import android.content.res.ColorStateList;
import android.text.Spannable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.IGetAppInfosByContextCallback;
import java.util.ArrayList;
import java.util.LinkedList;

public class vfp
  implements RecommendCommonMessage.IGetAppInfosByContextCallback
{
  public vfp(TextItemBuilder paramTextItemBuilder, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, Spannable paramSpannable, int paramInt1, int paramInt2, TextItemBuilder.Holder paramHolder, MessageForText paramMessageForText, ColorStateList paramColorStateList, int paramInt3) {}
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.contextAppInfoList.clear();
      int j = Math.min(paramArrayList.size(), ArkRecommendController.b);
      int i = 0;
      while (i < j)
      {
        RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)paramArrayList.get(i);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.contextAppInfoList.contains(localArkMsgAppInfo)) {
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.contextAppInfoList.add(localArkMsgAppInfo);
        }
        i += 1;
      }
      if (TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder, this.jdField_a_of_type_AndroidTextSpannable, this.jdField_a_of_type_Int, this.b))
      {
        TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText, this.jdField_a_of_type_AndroidTextSpannable, this.jdField_a_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_Int, this.b, this.c);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder$Holder.e.requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfp
 * JD-Core Version:    0.7.0.1
 */