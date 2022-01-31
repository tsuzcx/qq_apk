import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

public class bxf
  implements View.OnClickListener
{
  public bxf(PATextItemBuilder paramPATextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (bxg)AIOUtils.a(paramView);
    if (PAMessageUtil.a(paramView.jdField_a_of_type_JavaLangString, PATextItemBuilder.a(this.a))) {}
    for (;;)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramView instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          ReportController.b(PATextItemBuilder.b(this.a), "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
      return;
      if ((paramView.b == null) || (!paramView.b.equals("open_local")))
      {
        Intent localIntent = new Intent(PATextItemBuilder.b(this.a), PublicAccountBrowser.class);
        localIntent.putExtra("uin", PATextItemBuilder.a(this.a).a());
        localIntent.putExtra("url", paramView.c);
        localIntent.putExtra("assignBackText", PATextItemBuilder.c(this.a).getResources().getString(2131363123));
        localIntent.putExtra("puin", PATextItemBuilder.a(this.a).jdField_a_of_type_JavaLangString);
        localIntent.putExtra("source_name", PATextItemBuilder.b(this.a).d);
        localIntent.putExtra("fromAio", true);
        PublicAccountUtil.a(localIntent, paramView.c);
        PATextItemBuilder.d(this.a).startActivity(localIntent);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramView.c, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bxf
 * JD-Core Version:    0.7.0.1
 */