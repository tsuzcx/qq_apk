import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PATextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.OpenAppClient;

public class eab
  implements View.OnClickListener
{
  public eab(PATextItemBuilder paramPATextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (eac)AIOUtils.a(paramView);
    if (PAMessageUtil.a(paramView.jdField_a_of_type_JavaLangString, PATextItemBuilder.a(this.a))) {}
    for (;;)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramView instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          ReportController.b(PATextItemBuilder.d(this.a), "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
      return;
      Object localObject;
      if ((paramView.b != null) && (paramView.b.equals("open_local")))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("schemaurl", paramView.c);
        ((Bundle)localObject).putString("uin", PATextItemBuilder.a(this.a).a());
        ((Bundle)localObject).putString("vkey", PATextItemBuilder.b(this.a).f());
        OpenAppClient.b((Activity)PATextItemBuilder.b(this.a), (Bundle)localObject);
      }
      else
      {
        localObject = new Intent(PATextItemBuilder.c(this.a), PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("uin", PATextItemBuilder.c(this.a).a());
        ((Intent)localObject).putExtra("url", paramView.c);
        ((Intent)localObject).putExtra("assignBackText", PATextItemBuilder.d(this.a).getResources().getString(2131561692));
        ((Intent)localObject).putExtra("puin", PATextItemBuilder.a(this.a).jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("source_name", PATextItemBuilder.b(this.a).d);
        PublicAccountUtil.a((Intent)localObject, paramView.c);
        PATextItemBuilder.e(this.a).startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eab
 * JD-Core Version:    0.7.0.1
 */