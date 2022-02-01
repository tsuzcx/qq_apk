import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class kel
  extends SosoInterface.a
{
  public kel(ShopWebViewFragment paramShopWebViewFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((this.b.mApp == null) || (this.b.gb == null)) {}
    ArrayList localArrayList;
    double d1;
    double d2;
    do
    {
      do
      {
        return;
      } while ((paramInt != 0) || (paramSosoLbsInfo == null));
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.gb.iterator();
      while (localIterator.hasNext())
      {
        RecentShopParcel localRecentShopParcel = (RecentShopParcel)localIterator.next();
        if (localRecentShopParcel.aIi != 1) {
          try
          {
            localArrayList.add(Long.valueOf(Long.valueOf(localRecentShopParcel.puin).longValue()));
          }
          catch (Exception localException) {}
        }
      }
      d1 = paramSosoLbsInfo.a.cd;
      d2 = paramSosoLbsInfo.a.ce;
    } while (this.b.a == null);
    this.b.a.a(this.b.mApp, localArrayList, d2, d1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kel
 * JD-Core Version:    0.7.0.1
 */