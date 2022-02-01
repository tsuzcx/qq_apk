import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class xwb
  extends xvb
{
  zxj b;
  
  public xwb(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    super(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    this.b = ((zxj)paramQQAppInterface.getManager(125));
    if (a(this.b.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId))) {}
    for (this.effectsId = 0;; this.effectsId = paramQQWalletTransferMsgElem.effectsId)
    {
      this.bXF = 2130848112;
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
    this.jdField_a_of_type_Xvt.Kv.setText("QQ语音口令红包");
    return true;
  }
  
  public void onResume()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    zxi localzxi2 = this.b.a(localQQWalletRedPacketMsg.redPacketId);
    zxi localzxi1 = localzxi2;
    if (localzxi2 == null)
    {
      localzxi1 = new zxi(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, this.elem.title, false, false, false, 1);
      this.b.a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.redPacketIndex, this.elem.title, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.time + 90000L, String.valueOf(this.b.fH(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop)), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, localQQWalletRedPacketMsg.authkey, false, false, 1);
    }
    if (!a(localzxi1))
    {
      this.jdField_a_of_type_Xvt.hV.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Xvt.hV.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwb
 * JD-Core Version:    0.7.0.1
 */