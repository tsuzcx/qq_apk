import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import org.json.JSONException;
import org.json.JSONObject;

public class xvv
  extends xvb
{
  zxj b;
  
  public xvv(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    super(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    this.b = ((zxj)paramQQAppInterface.getManager(125));
    if (a(this.b.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.effectsId = 0;; this.effectsId = paramQQWalletTransferMsgElem.effectsId)
    {
      this.bXF = 2130848107;
      return;
    }
  }
  
  public boolean ST()
  {
    boolean bool = super.ST();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Xvt.Kv.setVisibility(0);
    this.jdField_a_of_type_Xvt.Kv.setTextColor(-8947849);
    this.jdField_a_of_type_Xvt.Kv.setText(xvg.aWI);
    this.jdField_a_of_type_Xvt.Kv.setSingleLine(true);
    this.jdField_a_of_type_Xvt.Kv.setEllipsize(TextUtils.TruncateAt.START);
    this.jdField_a_of_type_Xvt.Kv.setSelected(true);
    return false;
  }
  
  public void onResume()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    Object localObject2 = this.b.a(localQQWalletRedPacketMsg.redPacketId);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("key_sub_channel", localQQWalletRedPacketMsg.body.subChannel);
      localObject1 = zxi.hU(localQQWalletRedPacketMsg.body.poemRule);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((JSONObject)localObject2).put("key_poem_rule", localObject1);
      }
      if (localQQWalletRedPacketMsg.body.subChannel == 2)
      {
        localObject1 = localQQWalletRedPacketMsg.elem.lastPinyin;
        localObject1 = new zxi(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.elem.title, false, false, false, 4, (String)localObject1, ((JSONObject)localObject2).toString());
        this.b.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.elem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.b.fH(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 4);
        if ((aqmr.isEmpty(((zxi)localObject1).bbb)) || (aqmr.isEmpty(((zxi)localObject1).bbb.trim()))) {
          this.b.m(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, localQQWalletRedPacketMsg.elem.lastPinyin, 0);
        }
        if (a((zxi)localObject1)) {
          break label330;
        }
        this.jdField_a_of_type_Xvt.hV.setVisibility(8);
        if (aqmr.isEmpty(((zxi)localObject1).bbb)) {
          break label478;
        }
        if (!((zxi)localObject1).isFinish) {
          break label344;
        }
        this.jdField_a_of_type_Xvt.Kv.setText(acfp.m(2131714641));
      }
    }
    catch (JSONException localJSONException)
    {
      String str1;
      label330:
      label344:
      label478:
      do
      {
        String str2;
        do
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            str1 = "";
            continue;
            this.jdField_a_of_type_Xvt.hV.setVisibility(0);
          }
          localObject2 = str1.bbb;
          str2 = this.b.hV((String)localObject2);
        } while (aqmr.isEmpty(str2));
        if (localQQWalletRedPacketMsg.body.subChannel == 2) {}
        for (localObject2 = acfp.m(2131714642) + str2.trim() + " ";; localObject2 = acfp.m(2131714643) + str2.trim() + " ")
        {
          this.jdField_a_of_type_Xvt.Kv.setText((CharSequence)localObject2);
          this.b.t(this.context, str2.trim(), str1.redBagId);
          return;
        }
      } while (!str1.isFinish);
      this.jdField_a_of_type_Xvt.Kv.setText(acfp.m(2131714640));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvv
 * JD-Core Version:    0.7.0.1
 */