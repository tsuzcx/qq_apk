import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.AdDownloadProxy.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.AdDownloadProxy.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class tkv
{
  public int a;
  public Context a;
  public AdvertisementInfo a;
  public AdData a;
  public ArrayList<tky> a;
  private AtomicBoolean a;
  public nzj a;
  public tqt a;
  public trg a;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public tkv()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static void a(tqt paramtqt, int paramInt)
  {
    if (paramtqt != null)
    {
      paramtqt.jdField_a_of_type_Int = paramInt;
      if (paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = paramInt;
      }
      if (paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = paramInt;
      }
      if (paramtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = paramInt;
      }
    }
  }
  
  public static void b(tqt paramtqt, int paramInt)
  {
    if (paramtqt != null)
    {
      paramtqt.b = paramInt;
      if (paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = paramInt;
      }
      if (paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramtqt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = paramInt;
      }
      if (paramtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramtqt.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramInt;
      }
    }
  }
  
  private String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (tpp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.v;
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt;
    }
    return "";
  }
  
  private String d()
  {
    String str = "1";
    if (this.jdField_a_of_type_Int == 3) {
      str = "2";
    }
    while (this.jdField_a_of_type_Int != 4) {
      return str;
    }
    return "1";
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 4) {
      return nzq.ae;
    }
    if (this.jdField_a_of_type_Int == 3) {
      return nzq.Y;
    }
    if (this.jdField_a_of_type_Int == 5) {
      return nzq.af;
    }
    return nzq.ae;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    VideoInfo.GameAdComData localGameAdComData;
    do
    {
      return 0L;
      localGameAdComData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
    } while (localGameAdComData == null);
    try
    {
      int i = new JSONObject(localGameAdComData.u).optInt("iGiftId");
      return i;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return 0L;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Tqt != null) {
      return this.jdField_a_of_type_Tqt.d;
    }
    return "";
  }
  
  public String a(AdvertisementInfo paramAdvertisementInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramAdvertisementInfo != null)
    {
      str1 = str2;
      if (paramAdvertisementInfo.gameAdComData != null) {
        str1 = paramAdvertisementInfo.gameAdComData.g;
      }
    }
    return str1;
  }
  
  public tkv a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public tkv a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public tkv a(AdData paramAdData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    return this;
  }
  
  public tkv a(nzj paramnzj)
  {
    this.jdField_a_of_type_Nzj = paramnzj;
    return this;
  }
  
  public tkv a(tky paramtky)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramtky);
    return this;
  }
  
  public tkv a(tqt paramtqt)
  {
    this.jdField_a_of_type_Tqt = paramtqt;
    return this;
  }
  
  public void a()
  {
    if (tpp.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      ThreadManager.executeOnNetWorkThread(new AdDownloadProxy.1(this));
      nzq.a(new tlx().a(BaseApplication.getContext()).a(nzq.jdField_a_of_type_Int).b(a()).e(tns.a(a(), nzq.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), null)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)).a());
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (tpp.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
        if (!tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          break;
        }
      } while (a());
      a(false, false);
      return;
    } while (!tpp.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      tkq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3010405L, 9L, "", d()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    tpx.a("AdDownloadProxy", "mAppButton is clickable");
    try
    {
      if (tql.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        tql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        return;
      }
      if (tpp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        a();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (this.jdField_a_of_type_Tqt != null)
    {
      boolean bool = a();
      if (!bool)
      {
        int i;
        if ((bhnv.b(this.jdField_a_of_type_AndroidContentContext)) && (tpz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {
          i = 1;
        }
        while ((acwa.a()) || (i != 0)) {
          if (tpp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
          {
            this.b.set(true);
            b();
            return;
            i = 0;
          }
          else if (d())
          {
            c();
            if (e())
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(1);
              tku.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nzq.an, nzq.jdField_a_of_type_Int, paramInt);
              return;
            }
            tku.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nzq.Z, nzq.jdField_a_of_type_Int, paramInt);
            return;
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          ssa.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
        }
      }
    }
  }
  
  public void a(TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView, int paramInt1, int paramInt2)
  {
    if ((paramNativeAdDownloadView == null) || (paramTextView == null))
    {
      tpx.a("AdDownloadProxy", "updateUIState error : ui is null");
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.3(this, paramInt1, paramInt2, paramTextView, paramNativeAdDownloadView));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (acwa.a()))
    {
      if (a()) {}
      while ((!acwa.a()) || (paramBoolean2)) {
        return;
      }
      this.b.set(true);
      b();
      return;
    }
    tps.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramBoolean1, c(), new tkx(this, paramBoolean2));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Tqt == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    Object localObject = this.jdField_a_of_type_Tqt.d;
    int j = nzq.M;
    int i = nzq.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bhny.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_Tqt.jdField_a_of_type_Int = 1;
      if (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = nzq.e;
        localHashMap.put("download_state", "5");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
      }
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(tns.a(a(), nzq.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(5))).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
      return true;
    }
    if (nzj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tqt))
    {
      localObject = bjsz.a().c(this.jdField_a_of_type_Tqt.d);
      bjsz.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_Tqt.jdField_a_of_type_Int = 5;
      if (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = nzq.e;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).e(tns.a(a(), nzq.T, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(6))).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        return true;
        j = nzq.Z;
      }
    }
    return false;
  }
  
  public boolean a(tqt paramtqt)
  {
    return (paramtqt != null) && (this.jdField_a_of_type_Tqt != null) && (paramtqt.d.equals(this.jdField_a_of_type_Tqt.d));
  }
  
  public String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      localObject = anzj.a(2131711836);
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          str = c();
          if (!tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break;
          }
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            this.b.set(false);
            b();
          }
          localObject = a();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (nzq.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return anzj.a(2131711882);
          }
          if (nzj.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return "安装";
          }
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        return anzj.a(2131711755);
        if (!d()) {
          break;
        }
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (nzq.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return anzj.a(2131711954);
        }
        if (nzj.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return "立即安装";
        }
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      return anzj.a(2131711682);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (tql.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anzj.a(2131711998);
    }
    if (tqa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717149);
    }
    if (tqa.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717150);
    }
    if (tpp.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anzj.a(2131711688);
    }
    if (tpp.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anzj.a(2131711588);
    }
    if (tpp.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anzj.a(2131711961);
    }
    return anzj.a(2131711836);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    int j = nzq.M;
    int i = nzq.jdField_a_of_type_Int;
    Object localObject1 = new HashMap();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Tqt == null) {
          return;
        }
        localObject2 = this.jdField_a_of_type_Tqt.d;
        if (bhny.a(BaseApplicationImpl.getContext(), (String)localObject2))
        {
          g();
          this.jdField_a_of_type_Tqt.jdField_a_of_type_Int = 1;
          if (!tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break label741;
          }
          ((HashMap)localObject1).put("download_state", "5");
          paramInt = a();
          i = nzq.e;
          nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (HashMap)localObject1)).a());
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((tky)((Iterator)localObject1).next()).b();
          continue;
        }
        if (!nzj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tqt)) {
          break label369;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = bjsz.a().c(this.jdField_a_of_type_Tqt.d);
      bjsz.a().a((DownloadInfo)localObject2);
      this.jdField_a_of_type_Tqt.jdField_a_of_type_Int = 5;
      if (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localException.put("download_state", "3");
        paramInt = a();
        i = nzq.e;
      }
      Iterator localIterator;
      for (;;)
      {
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localException)).a());
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((tky)localIterator.next()).a();
        }
        paramInt = nzq.T;
      }
      label369:
      if ((bhnv.b(this.jdField_a_of_type_AndroidContentContext)) && (tpz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {}
      int k;
      for (j = 1;; j = 0)
      {
        k = nzq.T;
        if ((!acwa.a()) && (j == 0)) {
          break label619;
        }
        if (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int != 3) {
          break label511;
        }
        e();
        if ((!tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!tpp.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
          break;
        }
        tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 4, d());
        return;
      }
      if (e())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
        tku.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
        return;
      }
      tku.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
      return;
      label511:
      if ((this.jdField_a_of_type_Tqt.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int != 0)) {
        break;
      }
      c();
      if ((tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (tpp.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
      {
        tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 9, d());
        return;
      }
      if (e())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
        tku.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
        return;
      }
      tku.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
      return;
      label619:
      if (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int == 3)
      {
        e();
        paramInt = k;
        if (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          localIterator.put("download_state", "8");
          paramInt = a();
          i = nzq.e;
        }
        nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localIterator)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      ssa.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
      return;
      label741:
      paramInt = j;
    }
  }
  
  public boolean b()
  {
    if ((d()) && (this.jdField_a_of_type_Tqt != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Tqt.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bjsz.a().c((String)localObject);
          if ((nzj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tqt)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
          {
            f();
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
  
  public void c()
  {
    if ((this.jdField_a_of_type_Nzj == null) || (this.jdField_a_of_type_Tqt == null)) {}
    Iterator localIterator;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt);
      if (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int != 4) {
        break;
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((tky)localIterator.next()).a(this.jdField_a_of_type_Tqt.b);
      }
    }
    if (this.jdField_a_of_type_Tqt.b != 100) {}
    for (int i = this.jdField_a_of_type_Tqt.b;; i = 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((tky)localIterator.next()).a(this.jdField_a_of_type_Tqt, 3, i);
      }
      break;
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (paramInt != 5)) {
      return;
    }
    if ((tpp.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 5, d());
      return;
    }
    HashMap localHashMap = new HashMap();
    nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_a_of_type_Int).b(a()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(tns.a(a(), nzq.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    while ((!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Nzj == null) || (this.jdField_a_of_type_Tqt == null)) {
      return;
    }
    this.jdField_a_of_type_Nzj.d(this.jdField_a_of_type_Tqt);
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Nzj == null) || (this.jdField_a_of_type_Tqt == null)) {
      return;
    }
    this.jdField_a_of_type_Nzj.b(this.jdField_a_of_type_Tqt);
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      bool1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null);
      bool1 = bool2;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.o));
    return true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = 100;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.n == 32) && (d())) {
      ubd.b(this.jdField_a_of_type_AndroidContentContext, tqb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
    }
    while ((this.jdField_a_of_type_Tqt == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Tqt.d))) {
      return;
    }
    tqa.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tqt.d);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Tqt == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.b.get())) {
            break label256;
          }
          if (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int == 4)
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((tky)((Iterator)localObject).next()).a(this.jdField_a_of_type_Tqt, 4, this.jdField_a_of_type_Tqt.b);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int != 5) {
              break;
            }
            localObject = this.jdField_a_of_type_Tqt.d;
            if (bhny.a(BaseApplicationImpl.getContext(), (String)localObject))
            {
              this.jdField_a_of_type_Tqt.jdField_a_of_type_Int = 1;
              localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((tky)((Iterator)localObject).next()).a(this.jdField_a_of_type_Tqt, 1, this.jdField_a_of_type_Tqt.b);
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Tqt.jdField_a_of_type_Int != 3);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((tky)((Iterator)localObject).next()).a(this.jdField_a_of_type_Tqt, 3, this.jdField_a_of_type_Tqt.b);
      }
    } while (this.jdField_a_of_type_Nzj == null);
    this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt);
    return;
    label256:
    this.b.compareAndSet(true, false);
    int j = nzq.N;
    int i = nzq.jdField_a_of_type_Int;
    long l = a();
    Object localObject = new HashMap();
    if (nzj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tqt))
    {
      d();
      this.jdField_a_of_type_Tqt.jdField_a_of_type_Int = 5;
      if (tpp.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = nzq.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(tns.a(l, nzq.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (HashMap)localObject)).a());
      return;
    }
    c();
    tkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3, d());
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Trg != null)
    {
      this.jdField_a_of_type_Trg.dismiss();
      this.jdField_a_of_type_Trg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkv
 * JD-Core Version:    0.7.0.1
 */