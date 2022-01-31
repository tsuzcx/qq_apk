import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.statistics.ReportController;

public class uxq
  implements View.OnClickListener
{
  public uxq(FoldMsgGrayTipsItemBuilder paramFoldMsgGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if ((localObject instanceof MessageForFoldMsgGrayTips))
    {
      ((MessageForFoldMsgGrayTips)localObject).isOpen = true;
      paramView = (uxr)AIOUtils.a(paramView);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((MessageForFoldMsgGrayTips)localObject).getShowMsgContent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext));
      localObject = paramView.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != AIOUtils.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.a.requestLayout();
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */