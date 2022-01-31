import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class uwj
  extends ClickableSpan
{
  public uwj(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j;
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label225;
      }
      j = 0;
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("recv_uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.put("recv_nick", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        if (j > 0) {
          paramView.put("people_num", j);
        }
        paramView.put("recv_type", i);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Intent localIntent;
          localJSONException.printStackTrace();
        }
        i = 0;
        j = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "click HongBao:params=" + paramView.toString());
      }
      localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, SendHbActivity.class);
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("extra_data", paramView.toString());
      localIntent.addFlags(536870912);
      localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      label225:
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        j = ((DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        i = 2;
      }
      else if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        i = 3;
        j = 0;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uwj
 * JD-Core Version:    0.7.0.1
 */