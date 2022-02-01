import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.1;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.4;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class kjt
{
  public AdData a;
  public jzi a;
  public kns a;
  public int aJm = 2;
  public AdvertisementInfo advertisementInfo;
  public boolean afT;
  public mrm b;
  public Context context;
  public boolean isUserClick;
  public ArrayList<kjt.a> kf = new ArrayList();
  
  private String io()
  {
    String str = "1";
    if (this.aJm == 2) {
      str = "2";
    }
    while (this.aJm != 1) {
      return str;
    }
    return "1";
  }
  
  public void V(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (tll.isWifiConnected()))
    {
      if (zx())
      {
        if (zv()) {}
        while ((!tll.isWifiConnected()) || (paramBoolean2)) {
          return;
        }
        aDE();
        return;
      }
      kna.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, new kjv(this, paramBoolean2));
      return;
    }
    kna.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, paramBoolean1, zx(), new kjw(this, paramBoolean2));
  }
  
  public String a(AdData paramAdData)
  {
    String str2 = "";
    String str1 = str2;
    if (paramAdData != null)
    {
      str1 = str2;
      if (paramAdData.a != null) {
        str1 = paramAdData.a.appid;
      }
    }
    return str1;
  }
  
  public kjt a(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
  
  public kjt a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.advertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public kjt a(AdData paramAdData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    return this;
  }
  
  public kjt a(jzi paramjzi)
  {
    this.jdField_a_of_type_Jzi = paramjzi;
    return this;
  }
  
  public kjt a(kjt.a parama)
  {
    this.kf.add(parama);
    return this;
  }
  
  public kjt a(mrm parammrm)
  {
    this.b = parammrm;
    return this;
  }
  
  public void a(TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView, int paramInt1, int paramInt2)
  {
    if ((paramNativeAdDownloadView == null) || (paramTextView == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.4(this, paramInt1, paramInt2, paramNativeAdDownloadView, paramTextView));
  }
  
  public void aDD()
  {
    if (kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      ThreadManager.executeOnNetWorkThread(new AdDownloadProxy.1(this));
      jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aEJ).b(getOrigin()).e(klt.a(cd(), jzk.aFp, this.aJm, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null)).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((kmx.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData)));
        if (!kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          break;
        }
      } while (zv());
      V(false, false);
      return;
    } while (!kmx.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
    kkm.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    kkn.a(this.advertisementInfo, jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.abq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.rowkey, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.ZR, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.aaa, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.packageName, new HashMap()), kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, 3010405L, 9L, "", io()));
  }
  
  public void aDE()
  {
    this.jdField_a_of_type_Jzi.c(this.b);
  }
  
  public void aDF()
  {
    if ((this.jdField_a_of_type_Jzi == null) || (this.b == null)) {
      return;
    }
    this.jdField_a_of_type_Jzi.f(this.b);
  }
  
  public void aDG()
  {
    if (this.advertisementInfo == null) {
      return;
    }
    this.advertisementInfo.downloadState = 5;
    this.advertisementInfo.progress = 100;
  }
  
  public void aDH()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.baa == 32) && (zy())) {
      ods.b(this.context, kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
    }
    while ((this.b == null) || (TextUtils.isEmpty(this.b.mPackageName))) {
      return;
    }
    knd.D(this.context, this.b.mPackageName);
  }
  
  public void aDI()
  {
    if ((this.b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null)) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (this.isUserClick) {
            break label250;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState == 4)
          {
            localObject = this.kf.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((kjt.a)((Iterator)localObject).next()).a(this.b, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.progress);
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState != 5) {
              break;
            }
            localObject = this.b.mPackageName;
            if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState = 1;
              localObject = this.kf.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((kjt.a)((Iterator)localObject).next()).a(this.b, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.progress);
              }
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState != 3);
      localObject = this.kf.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((kjt.a)((Iterator)localObject).next()).a(this.b, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.progress);
      }
    } while (this.jdField_a_of_type_Jzi == null);
    this.jdField_a_of_type_Jzi.a(this.b);
    return;
    label250:
    int j = jzk.aFw;
    int i = jzk.aEJ;
    long l = cd();
    Object localObject = new HashMap();
    if (jzg.a(this.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState))
    {
      aDF();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState = 5;
      if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = getOrigin();
        i = jzk.aEN;
        ((HashMap)localObject).put("download_state", "3");
      }
      jzk.a(new kku.a().a(this.context).a(i).b(j).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).e(klt.a(l, jzk.aFp, this.aJm, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), String.valueOf(2))).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject)).a());
      return;
    }
    doDownload();
    kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, 3, io());
  }
  
  public long cd()
  {
    if (this.advertisementInfo == null) {}
    VideoInfo.GameAdComData localGameAdComData;
    do
    {
      return 0L;
      localGameAdComData = this.advertisementInfo.gameAdComData;
    } while (localGameAdComData == null);
    try
    {
      int i = new JSONObject(localGameAdComData.Xm).optInt("iGiftId");
      return i;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return 0L;
  }
  
  public boolean d(mrm parammrm)
  {
    return (parammrm != null) && (this.b != null) && (parammrm.mPackageName.equals(this.b.mPackageName));
  }
  
  public void doDownload()
  {
    if ((this.jdField_a_of_type_Jzi == null) || (this.b == null)) {}
    Iterator localIterator;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Jzi.a(this.b);
      if (this.b.mState != 4) {
        break;
      }
      localIterator = this.kf.iterator();
      while (localIterator.hasNext()) {
        ((kjt.a)localIterator.next()).setProgress(this.b.aTP);
      }
    }
    if (this.b.aTP != 100) {}
    for (int i = this.b.aTP;; i = 0)
    {
      localIterator = this.kf.iterator();
      while (localIterator.hasNext()) {
        ((kjt.a)localIterator.next()).a(this.b, 3, i);
      }
      break;
    }
  }
  
  public void doOnDestroy()
  {
    this.kf.clear();
  }
  
  public void doPause()
  {
    if ((this.jdField_a_of_type_Jzi == null) || (this.b == null)) {
      return;
    }
    this.jdField_a_of_type_Jzi.d(this.b);
  }
  
  public int getOrigin()
  {
    if (this.aJm == 1) {
      return jzk.aFN;
    }
    if (this.aJm == 2) {
      return jzk.aFH;
    }
    if (this.aJm == 3) {
      return jzk.aFO;
    }
    return jzk.aFN;
  }
  
  protected String getPkgName()
  {
    if (this.b != null) {
      return this.b.mPackageName;
    }
    return "";
  }
  
  public int gq()
  {
    if (this.aJm == 2) {
      return 2;
    }
    return 7;
  }
  
  public String in()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    do
    {
      do
      {
        return "";
      } while ((knk.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && ((kmx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (kmx.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))))));
      if (((!kmx.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (!zA())) || (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
      {
        if ((!this.isUserClick) && (!this.afT) && (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
        {
          this.afT = true;
          aDE();
        }
        if ((TextUtils.isEmpty(getPkgName())) || (!jzk.C(BaseApplicationImpl.getContext(), getPkgName()))) {}
      }
    } while (((zy()) && (!TextUtils.isEmpty(getPkgName())) && (jzk.C(BaseApplicationImpl.getContext(), getPkgName()))) && ((kmx.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && ((!kmx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.buttonDesc)))));
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.buttonDesc;
  }
  
  public void pf(int paramInt)
  {
    this.aJm = paramInt;
    this.isUserClick = true;
    try
    {
      if (knk.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        knk.a(this.context, kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData));
        return;
      }
      if (kmx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        aDD();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (this.b != null)
    {
      boolean bool = zv();
      if (!bool)
      {
        int i;
        if ((aqiw.isMobileNetWork(this.context)) && (knc.dv(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.mAdExtInfo))) {
          i = 1;
        }
        while ((tll.isWifiConnected()) || (i != 0)) {
          if (kmx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
          {
            aDE();
            return;
            i = 0;
          }
          else if (zy())
          {
            doDownload();
            if (zz())
            {
              paramInt = kjz.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState, false);
              kjz.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, jzk.aEJ, 1, paramInt, gq());
              return;
            }
            jzk.a(new kku.a().a(this.context).a(jzk.aEJ).b(jzk.aFI).e(klt.a(cd(), jzk.aFp, paramInt, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null)).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
            return;
          }
        }
        if ((this.context instanceof Activity))
        {
          nnb.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
          jzk.a(new kku.a().a(this.context).a(jzk.aEJ).b(jzk.aFv).e(klt.a(cd(), jzk.aFp, paramInt, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null)).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
        }
      }
    }
  }
  
  public void pg(int paramInt)
  {
    this.aJm = paramInt;
    this.isUserClick = true;
    paramInt = jzk.aFv;
    int i = jzk.aEJ;
    Object localObject1 = new HashMap();
    try
    {
      if (this.b == null) {
        return;
      }
      localObject2 = this.b.mPackageName;
      if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject2))
      {
        aDH();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState = 1;
        if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
        {
          ((HashMap)localObject1).put("download_state", "5");
          paramInt = getOrigin();
          i = jzk.aEN;
        }
        jzk.a(new kku.a().a(this.context).a(i).b(paramInt).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, (HashMap)localObject1)).a());
        localObject1 = this.kf.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((kjt.a)((Iterator)localObject1).next()).aDL();
        }
      }
      if (!jzh.a(this.context, this.b)) {
        break label357;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Object localObject2 = arvv.a().f(this.b.mPackageName);
    arvv.a().d((DownloadInfo)localObject2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState = 5;
    if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      localException.put("download_state", "3");
      paramInt = getOrigin();
      i = jzk.aEN;
    }
    jzk.a(new kku.a().a(this.context).a(i).b(paramInt).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localException)).a());
    Iterator localIterator = this.kf.iterator();
    while (localIterator.hasNext())
    {
      ((kjt.a)localIterator.next()).aDK();
      continue;
      label357:
      int j;
      if ((aqiw.isMobileNetWork(this.context)) && (knc.dv(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.mAdExtInfo))) {
        j = 1;
      }
      while ((tll.isWifiConnected()) || (j != 0)) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState == 3)
        {
          doPause();
          if ((kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
          {
            kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, 4, io());
            return;
            j = 0;
          }
          else
          {
            if (zz())
            {
              paramInt = kjz.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState, false);
              kjz.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, jzk.aEJ, 1, paramInt, gq());
              return;
            }
            jzk.a(new kku.a().a(this.context).a(i).b(paramInt).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localIterator)).a());
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState != 4) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState != 0)) {
            return;
          }
          doDownload();
          if ((kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
          {
            kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, 9, io());
            return;
          }
          if (zz())
          {
            paramInt = kjz.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState, false);
            kjz.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, jzk.aEJ, 1, paramInt, gq());
            return;
          }
          jzk.a(new kku.a().a(this.context).a(i).b(paramInt).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localIterator)).a());
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState == 3)
      {
        doPause();
        if (!kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) {
          break label808;
        }
        localIterator.put("download_state", "8");
        i = getOrigin();
        paramInt = jzk.aEN;
      }
      for (;;)
      {
        jzk.a(new kku.a().a(this.context).a(paramInt).b(i).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localIterator)).a());
        return;
        if (!(this.context instanceof Activity)) {
          break;
        }
        nnb.a(this.context, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, true, 8);
        return;
        label808:
        j = paramInt;
        paramInt = i;
        i = j;
      }
    }
  }
  
  public void ph(int paramInt)
  {
    if ((this.context == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) || (paramInt != 5)) {
      return;
    }
    if ((kmx.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) || (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)))
    {
      kkn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, 5, io());
      return;
    }
    HashMap localHashMap = new HashMap();
    jzk.a(new kku.a().a(this.context).a(jzk.aEJ).b(getOrigin()).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).e(klt.a(cd(), jzk.aFp, this.aJm, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), String.valueOf(2))).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
  }
  
  public boolean zA()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (kmx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)) && (knp.b(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.packageName));
  }
  
  public boolean zv()
  {
    if (this.b == null) {
      return false;
    }
    Object localObject = this.b.mPackageName;
    int j = jzk.aFv;
    int i = jzk.aEJ;
    HashMap localHashMap = new HashMap();
    if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject))
    {
      aDH();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState = 1;
      if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = getOrigin();
        i = jzk.aEN;
        localHashMap.put("download_state", "5");
      }
      jzk.a(new kku.a().a(this.context).a(i).b(j).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).e(klt.a(cd(), jzk.aFp, this.aJm, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), String.valueOf(5))).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
      return true;
    }
    if (jzh.a(this.context, this.b))
    {
      localObject = arvv.a().f(this.b.mPackageName);
      arvv.a().d((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.downloadState = 5;
      if (kmx.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
      {
        j = getOrigin();
        i = jzk.aEN;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        jzk.a(new kku.a().a(this.context).a(i).b(j).e(klt.a(cd(), jzk.aFp, this.aJm, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), String.valueOf(6))).a(kne.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).d(jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData, localHashMap)).a());
        return true;
        j = jzk.aFI;
      }
    }
    return false;
  }
  
  public boolean zw()
  {
    if ((zy()) && (this.b != null)) {
      try
      {
        String str = this.b.mPackageName;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = arvv.a().f(str);
          if ((jzh.B(this.context, str)) && (localDownloadInfo != null) && (localDownloadInfo.getState() == 4))
          {
            aDG();
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public boolean zx()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    while ((!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
      return false;
    }
    return true;
  }
  
  public boolean zy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.productType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean zz()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.FK();
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(mrm parammrm, int paramInt1, int paramInt2);
    
    public abstract void aDK();
    
    public abstract void aDL();
    
    public abstract void setProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjt
 * JD-Core Version:    0.7.0.1
 */