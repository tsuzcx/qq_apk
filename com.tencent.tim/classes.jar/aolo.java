import android.support.annotation.VisibleForTesting;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import java.util.ArrayList;

public class aolo
{
  public static boolean cMN = true;
  
  @VisibleForTesting
  public static ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ipv6Strategy", 0, "selectIpList netType = " + paramInt);
    }
    if (paramInt == 2) {
      return paramArrayList1;
    }
    if (paramInt == 3) {
      return a(paramArrayList1, paramArrayList2, paramBoolean);
    }
    return paramArrayList2;
  }
  
  private static ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (bu(paramBoolean))
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localArrayList.add(paramArrayList1.get(0));
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
        localArrayList.addAll(paramArrayList2);
      }
    }
    do
    {
      return localArrayList;
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
        localArrayList.addAll(paramArrayList2);
      }
    } while ((paramArrayList1 == null) || (paramArrayList1.size() <= 0));
    localArrayList.add(paramArrayList1.get(0));
    return localArrayList;
  }
  
  public static boolean azX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ipv6Strategy", 0, "isIpv6Selected ");
    }
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    if (i == 2) {
      return true;
    }
    if (i == 3) {
      return azZ();
    }
    return false;
  }
  
  private static boolean azY()
  {
    aent.a locala = (aent.a)aeif.a().o(538);
    if (locala != null) {
      return locala.bVf;
    }
    return false;
  }
  
  public static boolean azZ()
  {
    return bu(false);
  }
  
  private static boolean bu(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramBoolean) {
      paramBoolean = cMN;
    }
    do
    {
      do
      {
        return paramBoolean;
        if (azY()) {
          break;
        }
        paramBoolean = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Ipv6Strategy", 0, "isIpv6DownFirst, getRichmediaIpv6Switch is false");
      return false;
      if (Ipv6Config.getInstance().mRMDownStrategy == 2) {
        return true;
      }
      paramBoolean = bool2;
    } while (Ipv6Config.getInstance().mRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (paramBoolean = bool1;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static ArrayList i(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    return a(paramArrayList1, paramArrayList2, NetConnInfoCenter.getActiveNetIpFamily(true), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolo
 * JD-Core Version:    0.7.0.1
 */