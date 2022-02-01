import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.b;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class wyn
  implements ausj.a
{
  public wyn(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.b paramb, ApolloActionData paramApolloActionData, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.b.cancel();
      return;
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$b.tag) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$b.tag == 2))
      {
        if (!(this.this$0.mContext instanceof Activity))
        {
          QLog.e("ApolloItemBuilder", 1, "mContext is not activity");
          return;
        }
        ApolloUtil.d((Activity)this.this$0.mContext, this.this$0.app.getCurrentUin(), "lmx_actchat");
      }
      else
      {
        if (3 == this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$b.tag)
        {
          paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url)) {
            paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.url);
          }
          for (;;)
          {
            this.this$0.mContext.startActivity(paramView);
            break;
            paramView.putExtra("url", abxi.bjg + "&id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
          }
        }
        if (4 != this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$b.tag) {
          ujt.c(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder$b.mMessage.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyn
 * JD-Core Version:    0.7.0.1
 */