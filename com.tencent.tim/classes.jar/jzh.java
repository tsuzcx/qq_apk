import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.ADFeedsVideoAppDownlodManager.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class jzh
  extends jzg
{
  private ListView b;
  
  public jzh(Context paramContext, ListView paramListView)
  {
    super(paramContext);
    this.b = paramListView;
  }
  
  public jzh(Context paramContext, boolean paramBoolean, ReadInJoyListViewGroup paramReadInJoyListViewGroup, ndi paramndi)
  {
    super(paramContext);
    this.b = paramReadInJoyListViewGroup.b();
  }
  
  private void a(koh paramkoh, AdvertisementInfo paramAdvertisementInfo, mrm parammrm, int paramInt1, int paramInt2)
  {
    if ((paramkoh == null) || (paramAdvertisementInfo == null) || (parammrm == null)) {
      return;
    }
    String str = "";
    Object localObject = "";
    for (;;)
    {
      try
      {
        if (knd.f(paramAdvertisementInfo) != 2) {
          break label177;
        }
        str = new JSONObject(paramAdvertisementInfo.mAdExtInfo).optString("game_app_id");
        localObject = knd.c(paramAdvertisementInfo);
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(parammrm.mAppID)) || (!((String)localObject).equals(parammrm.mPackageName))) {
          break;
        }
        paramAdvertisementInfo.progress = parammrm.advertisementInfo.progress;
        paramAdvertisementInfo.downloadState = parammrm.advertisementInfo.downloadState;
        this.mainHandler.post(new ADFeedsVideoAppDownlodManager.1(this, paramkoh, paramInt1, paramInt2));
        return;
      }
      catch (JSONException paramkoh) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramkoh.printStackTrace();
      QLog.d("ADFeedsVideoAppDownlodManager", 1, "updateUIState exception :" + paramkoh.toString());
      return;
      label177:
      if (paramAdvertisementInfo.mAdExt != null)
      {
        localObject = new JSONObject(paramAdvertisementInfo.mAdExt);
        str = ((JSONObject)localObject).optString("appid");
        localObject = ((JSONObject)localObject).optString("pkg_name");
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    super.a(paramDownloadInfo, paramInt);
    try
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.mPackageName != null) && (localmrm.mPackageName.equals(paramDownloadInfo.packageName)) && (localmrm.advertisementInfo != null))
        {
          localmrm.advertisementInfo.downloadState = paramInt;
          localmrm.advertisementInfo.progress = paramDownloadInfo.progress;
          a(localmrm, paramInt, paramDownloadInfo.progress);
        }
      }
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramDownloadInfo.getMessage());
    }
  }
  
  public void a(WadlResult paramWadlResult, int paramInt)
  {
    super.a(paramWadlResult, paramInt);
    try
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.mPackageName != null) && (localmrm.mAppID.equals(paramWadlResult.a.appId)) && (localmrm.mPackageName.equals(paramWadlResult.a.packageName)) && (localmrm.advertisementInfo != null))
        {
          localmrm.advertisementInfo.downloadState = paramInt;
          localmrm.advertisementInfo.progress = paramWadlResult.progress;
          if (!TextUtils.isEmpty(paramWadlResult.aJb)) {
            localmrm.ajH = paramWadlResult.aJb;
          }
          a(localmrm, paramInt, paramWadlResult.progress);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ADFeedsVideoAppDownlodManager", 2, "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(mrm parammrm, int paramInt1, int paramInt2)
  {
    super.a(parammrm, paramInt1, paramInt2);
    if ((parammrm == null) || (parammrm.advertisementInfo == null)) {
      return;
    }
    int i = 0;
    label22:
    Object localObject1;
    Object localObject2;
    if (i < this.b.getChildCount())
    {
      localObject1 = this.b.getChildAt(i);
      localObject2 = ((View)localObject1).getTag(2131381960);
      if ((!(localObject2 instanceof lis)) || (((lis)localObject2).a() == null) || (!(((lis)localObject2).a() instanceof AdvertisementInfo)) || (!(localObject1 instanceof ProteusItemView))) {
        break label157;
      }
      localObject2 = (AdvertisementInfo)((lis)localObject2).a();
      localObject1 = ((ProteusItemView)localObject1).a().getVirtualView().findViewBaseByName("id_view_AdDownloadView");
    }
    for (;;)
    {
      if ((localObject1 instanceof koh)) {
        a((koh)localObject1, (AdvertisementInfo)localObject2, parammrm, paramInt1, paramInt2);
      }
      i += 1;
      break label22;
      break;
      label157:
      if ((localObject2 instanceof AdvertisementInfo))
      {
        localObject2 = (AdvertisementInfo)localObject2;
        if (((localObject1 instanceof Container)) && (((Container)localObject1).getVirtualView() != null)) {
          localObject1 = ((Container)localObject1).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
        } else {
          localObject1 = null;
        }
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzh
 * JD-Core Version:    0.7.0.1
 */