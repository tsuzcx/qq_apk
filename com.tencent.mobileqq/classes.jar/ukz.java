import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.HBCustomizeStrategy;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.ThemeRedPkgElem;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ukz
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  private PreloadManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ukz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager = ((PreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(150));
    }
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {
      return;
    }
    ThreadManager.post(new ula(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if ((paramRedPacketInfo != null) && ((paramBaseRedPkgElem instanceof ThemeRedPkgElem))) {
      paramRedPacketInfo.animInfo = ((ThemeRedPkgElem)paramBaseRedPkgElem).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukz
 * JD-Core Version:    0.7.0.1
 */