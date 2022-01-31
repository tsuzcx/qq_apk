import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BigAnimRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.ResPathRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.SkinRedPkgElem;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class upr
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  QWalletConfigManager jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = null;
  PreloadManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public upr(QQAppInterface paramQQAppInterface)
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
    ThreadManager.post(new ups(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramBaseRedPkgElem instanceof SkinRedPkgElem)) {
        break label66;
      }
      paramBaseRedPkgElem = (SkinRedPkgElem)paramBaseRedPkgElem;
      paramRedPacketInfo.background = paramBaseRedPkgElem.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.corner = paramBaseRedPkgElem.jdField_b_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramBaseRedPkgElem.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramBaseRedPkgElem.jdField_b_of_type_JavaLangString;
      paramRedPacketInfo.icon = paramBaseRedPkgElem.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramBaseRedPkgElem.jdField_a_of_type_Int;
    }
    label66:
    do
    {
      return;
      if ((paramBaseRedPkgElem instanceof BigAnimRedPkgElem))
      {
        paramBaseRedPkgElem = (BigAnimRedPkgElem)paramBaseRedPkgElem;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramBaseRedPkgElem.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramBaseRedPkgElem.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramBaseRedPkgElem instanceof ResPathRedPkgElem));
    paramRedPacketInfo.resPath = ((ResPathRedPkgElem)paramBaseRedPkgElem).jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upr
 * JD-Core Version:    0.7.0.1
 */