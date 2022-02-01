import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.qphone.base.util.BaseApplication;

public class nnb
{
  public static GdtHandler.Params a;
  public static long sr = -2147483648L;
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    a(paramContext, paramBaseData, false, paramBoolean, paramInt);
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBaseData == null) || (paramContext == null) || (!(paramContext instanceof Activity))) {}
    AdvertisementInfo localAdvertisementInfo;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          ods.cn(paramContext);
          localAdvertisementInfo = kne.a((AdData)paramBaseData);
        } while (ods.a(paramContext, (AdData)paramBaseData, localAdvertisementInfo));
        localAdvertisementInfo.setClickPos(paramInt);
        if ((knd.m(localAdvertisementInfo)) && ((paramInt == 4) || (paramInt == 3)) && ((paramContext instanceof Activity)))
        {
          knd.h((Activity)paramContext, 1);
          ods.b((Activity)paramContext, localAdvertisementInfo);
          jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aEJ).b(jzk.aFT).a(localAdvertisementInfo).d(jzk.a((AdData)paramBaseData)).a());
          return;
        }
        if (!((AdData)paramBaseData).FK()) {
          break;
        }
        kjz.a((Activity)paramContext, localAdvertisementInfo);
      } while ((localAdvertisementInfo.mAdvertisementSoftInfo == null) || (localAdvertisementInfo.mAdvertisementSoftInfo.sourceId == 0));
      int i = kjz.i(((AdData)paramBaseData).downloadState, false);
      kjz.a(paramContext, (AdData)paramBaseData, jzk.aEJ, paramInt, i, 2);
      return;
      localObject = new kks();
      if (paramInt == 8) {
        ((kks)localObject).afZ = true;
      }
      localObject = ods.a(paramContext, localAdvertisementInfo, null, 5, paramBoolean2, false, paramBoolean1, (kks)localObject);
    } while (localObject == null);
    ((GdtHandler.Params)localObject).directPlay = knc.j((AdData)paramBaseData);
    ods.a((GdtHandler.Params)localObject, paramContext, localAdvertisementInfo);
    a = (GdtHandler.Params)localObject;
    if (a != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      sr = l;
      kne.a((AdData)paramBaseData, paramInt);
      return;
    }
  }
  
  public void onDestroy()
  {
    a = null;
    sr = -2147483648L;
  }
  
  public void onResume()
  {
    ods.a(2, a, sr);
    a = null;
    sr = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnb
 * JD-Core Version:    0.7.0.1
 */