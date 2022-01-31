import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;

public class xgx
  implements CustomizeStrategyFactory.OnCustomizeListener
{
  public xgx(RedPacketManager paramRedPacketManager, RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    paramRedPacketInfo.isCache = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.isCache;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener.onGetSkin(paramRedPacketInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgx
 * JD-Core Version:    0.7.0.1
 */