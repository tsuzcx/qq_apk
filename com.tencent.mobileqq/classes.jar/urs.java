import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.AddressCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.LocationCallback;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class urs
  implements Runnable
{
  urs(urr paramurr, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    double d1;
    if (this.jdField_a_of_type_Boolean) {
      d1 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c;
    }
    double d2;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        d2 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d;
      }
      synchronized (ArkAppLocationManager.a(this.jdField_a_of_type_Urr.a))
      {
        Object localObject2 = new ArrayList(ArkAppLocationManager.a(this.jdField_a_of_type_Urr.a));
        if (((ArrayList)localObject2).size() == 0) {
          SosoInterface.b(ArkAppLocationManager.a(this.jdField_a_of_type_Urr.a));
        }
        ??? = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            localObject2 = (ArkAppLocationManager.LocationCallback)((Iterator)???).next();
            ((ArkAppLocationManager.LocationCallback)localObject2).a(this.jdField_a_of_type_Boolean, d1, d2);
            if (!this.jdField_a_of_type_Boolean)
            {
              ((ArkAppLocationManager.LocationCallback)localObject2).a();
              continue;
              d1 = 0.0D;
              break;
              d2 = 0.0D;
            }
          }
        }
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
      synchronized (ArkAppLocationManager.a(this.jdField_a_of_type_Urr.a))
      {
        ArkAppLocationManager.a(this.jdField_a_of_type_Urr.a).clear();
      }
    }
    synchronized (ArkAppLocationManager.b(this.jdField_a_of_type_Urr.a))
    {
      Object localObject4 = new ArrayList(ArkAppLocationManager.b(this.jdField_a_of_type_Urr.a));
      ArkAppLocationManager.b(this.jdField_a_of_type_Urr.a).removeAll((Collection)localObject4);
      ??? = ((ArrayList)localObject4).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (ArkAppLocationManager.LocationCallback)((Iterator)???).next();
        ((ArkAppLocationManager.LocationCallback)localObject4).a(this.jdField_a_of_type_Boolean, d1, d2);
        ((ArkAppLocationManager.LocationCallback)localObject4).a();
        continue;
        localObject5 = finally;
        throw localObject5;
      }
    }
    synchronized (ArkAppLocationManager.c(this.jdField_a_of_type_Urr.a))
    {
      ArrayList localArrayList = new ArrayList(ArkAppLocationManager.c(this.jdField_a_of_type_Urr.a));
      ArkAppLocationManager.c(this.jdField_a_of_type_Urr.a).removeAll(localArrayList);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((ArkAppLocationManager.AddressCallback)((Iterator)???).next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urs
 * JD-Core Version:    0.7.0.1
 */