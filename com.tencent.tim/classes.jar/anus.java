import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class anus
  implements View.OnClickListener
{
  anus(anur paramanur) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", anur.a(this.a));
    localBundle.putInt("video_play_caller", 2);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    Object localObject2 = "";
    Object localObject1 = null;
    try
    {
      localObject3 = wja.a(paramView);
      localObject1 = localObject3;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Object localObject3;
        continue;
        String str = "";
      }
    }
    if (localObject1 != null) {
      localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    }
    localBundle.putString("ad_gdt", (String)localObject2);
    localObject2 = this.a.a(paramView);
    if (localObject2 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("structmsg.StructMsgItemVideoForPA", 2, "StructMsgForGeneralShare == NULL");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localBundle.putString("msg_id", String.valueOf(((StructMsgForGeneralShare)localObject2).msgId));
      localObject1 = "";
      if ((anur.b(this.a) == null) || (anur.b(this.a).equals(""))) {
        break label520;
      }
      localBundle.putString("struct_msg_video_info", anur.b(this.a));
      localBundle.putString("from_uin", ((StructMsgForGeneralShare)localObject2).currentAccountUin);
      localBundle.putInt("from_uin_type", 1008);
      localBundle.putString("from_session_uin", ((StructMsgForGeneralShare)localObject2).uin);
      try
      {
        localObject3 = new JSONObject(anur.b(this.a));
        if (localObject3 != null) {
          localObject1 = ((JSONObject)localObject3).getString("file_uuid");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          str = "";
        }
      }
      localObject3 = new Intent(localContext, ShortVideoPlayActivity.class);
      ((Intent)localObject3).putExtras(localBundle);
      localContext.startActivity((Intent)localObject3);
      localObject3 = ((FragmentActivity)localContext).getChatFragment().getApp();
      anot.b((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9A", "0X8005C9A", 0, 1, 0, ((StructMsgForGeneralShare)localObject2).uin, ((StructMsgForGeneralShare)localObject2).currentAccountUin, anur.a(this.a), (String)localObject1);
      if ((((StructMsgForGeneralShare)localObject2).message != null) && ("1".equals(((StructMsgForGeneralShare)localObject2).message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("puin", ((StructMsgForGeneralShare)localObject2).message.frienduin);
          ((JSONObject)localObject1).put("type", this.a.index_type);
          ((JSONObject)localObject1).put("index", this.a.index);
          ((JSONObject)localObject1).put("name", this.a.index_name);
          ((JSONObject)localObject1).put("net", String.valueOf(jqc.getNetWorkType()));
          ((JSONObject)localObject1).put("mobile_imei", aqgz.getIMEI());
          ((JSONObject)localObject1).put("obj", "");
          ((JSONObject)localObject1).put("gdt_cli_data", ((StructMsgForGeneralShare)localObject2).message.getExtInfoFromExtStr("gdt_msgClick"));
          ((JSONObject)localObject1).put("view_id", ((StructMsgForGeneralShare)localObject2).message.getExtInfoFromExtStr("gdt_view_id"));
          obl.a((AppInterface)localObject3, ((StructMsgForGeneralShare)localObject2).message.selfuin, ((JSONObject)localObject1).toString(), "" + ((StructMsgForGeneralShare)localObject2).msgId);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anus
 * JD-Core Version:    0.7.0.1
 */