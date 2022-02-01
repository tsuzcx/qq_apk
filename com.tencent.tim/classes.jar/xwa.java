import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class xwa
  extends xvb
{
  acgn a;
  
  public xwa(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    super(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    this.jdField_a_of_type_Acgn = ((acgn)paramQQAppInterface.getManager(131));
  }
  
  public boolean ST()
  {
    boolean bool = super.ST();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Xvt.Kv.setVisibility(0);
    this.jdField_a_of_type_Xvt.Kv.setTextColor(-8947849);
    this.jdField_a_of_type_Xvt.Kv.setText("QQ红包");
    return false;
  }
  
  public void cfn()
  {
    super.cfn();
    if (this.skinId > 0) {
      return;
    }
    if (this.jdField_a_of_type_Acgn != null) {}
    for (boolean bool = this.jdField_a_of_type_Acgn.aau();; bool = false)
    {
      QQAppInterface localQQAppInterface = this.app;
      if (bool) {}
      for (Object localObject = "1";; localObject = "0")
      {
        anot.a(localQQAppInterface, "CliOper", "", "", "0X8006133", "0X8006133", 0, 0, (String)localObject, "0", "", "");
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        if ((!bool) || (((QQWalletRedPacketMsg)localObject).envelopeid == 0)) {
          break;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwa
 * JD-Core Version:    0.7.0.1
 */