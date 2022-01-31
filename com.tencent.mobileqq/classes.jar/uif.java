import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.VoiceResElem;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class uif
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  QWalletConfigManager jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = null;
  PreloadManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public uif(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(150));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = ((QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new uig(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramBaseRedPkgElem instanceof VoiceResElem)))
    {
      paramBaseRedPkgElem = (VoiceResElem)paramBaseRedPkgElem;
      paramRedPacketInfo.icon = paramBaseRedPkgElem.a;
      paramRedPacketInfo.resPath = paramBaseRedPkgElem.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uif
 * JD-Core Version:    0.7.0.1
 */