package com.tencent.mobileqq.structmsg.view;

import android.text.TextUtils;
import anot;
import anqu;
import ansl;
import anso;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.util.ArrayList;
import java.util.List;
import kbp;
import org.json.JSONException;
import org.json.JSONObject;
import ycd;

public class StructMsgItemButton$3$2
  implements Runnable
{
  public StructMsgItemButton$3$2(anso paramanso, ansl paramansl, StructMsgForGeneralShare paramStructMsgForGeneralShare, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.b.chH)) {}
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_Anso.a.chH);
      if (ycd.d(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, this.s))
      {
        j = 1;
        kbp.a(this.s, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X80055C8", "0X80055C8", i, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId), this.b.cgX, Integer.toString(j), false);
        j = 0;
        if (this.cJO) {
          j = 1;
        }
        Object localObject1 = new StringBuilder().append("MSGID=").append(Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(anqu.nH(this.b.ku));
        anot.a(this.s, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X8005D4A", "0X8005D4A", i, j, ((StringBuilder)localObject1).toString(), "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message == null) {}
        String str;
        do
        {
          do
          {
            return;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick");
          } while (TextUtils.isEmpty((CharSequence)localObject1));
          Object localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("puin", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
            ((JSONObject)localObject2).put("index", Long.toString(i));
            ((JSONObject)localObject2).put("gdt_cli_data", localObject1);
            new ArrayList().add(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId));
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_singleAd");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_mulAd");
            str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_followAd");
            if (((String)localObject1).equals("1")) {
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
            if (((String)localObject2).equals("1")) {
              return;
            }
          }
        } while (!str.equals("1"));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3.2
 * JD-Core Version:    0.7.0.1
 */