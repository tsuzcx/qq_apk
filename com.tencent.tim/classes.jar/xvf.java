import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class xvf
  extends xvb
{
  zxj b;
  
  public xvf(QQAppInterface paramQQAppInterface, xvt paramxvt, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.c paramc)
  {
    super(paramQQAppInterface, paramxvt, paramQQWalletTransferMsgElem, paramInt, paramc);
    this.b = ((zxj)paramQQAppInterface.getManager(125));
    if (a(this.b.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
    {
      this.effectsId = 0;
      return;
    }
    this.effectsId = paramQQWalletTransferMsgElem.effectsId;
  }
  
  public boolean ST()
  {
    boolean bool = super.ST();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Xvt.Kv.setVisibility(0);
    this.jdField_a_of_type_Xvt.Kv.setTextColor(-8947849);
    this.jdField_a_of_type_Xvt.Kv.setText(xvg.aWK);
    return true;
  }
  
  public void cfm()
  {
    super.cfm();
    try
    {
      this.jdField_a_of_type_Xvt.title.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Xvt.title.setText(aagd.b(this.jdField_a_of_type_Xvt.title.getContext(), this.elem.title, 330, this.jdField_a_of_type_Xvt.title.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvf
 * JD-Core Version:    0.7.0.1
 */