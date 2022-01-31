import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class uyu
  implements ActionSheet.OnButtonClickListener
{
  public uyu(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder.f)
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", ApolloConstant.I);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
      else if (2 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder.f)
      {
        paramView = new Intent();
        paramView.putExtra("extra_key_url_append", "&showDialog=1&type=level");
        ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, "aio", ApolloConstant.X, null);
      }
      else
      {
        if (3 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder.f)
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url)) {
            paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            break;
            paramView.putExtra("url", ApolloConstant.J + "&id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
          }
        }
        if (4 != this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder.f) {
          ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$Holder.a.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyu
 * JD-Core Version:    0.7.0.1
 */