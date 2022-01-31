import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

class zjn
  implements BusinessObserver
{
  zjn(zjm paramzjm, DiyPendantFetcher paramDiyPendantFetcher) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (paramObject.size() > 0)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            Iterator localIterator = ((DiyPendantEntity)paramObject.next()).getStickerInfoList().iterator();
            while (localIterator.hasNext())
            {
              Object localObject = (DiyPendantSticker)localIterator.next();
              localObject = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a((DiyPendantSticker)localObject);
              this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.b.add(localObject);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, paramObject.getMessage());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjn
 * JD-Core Version:    0.7.0.1
 */