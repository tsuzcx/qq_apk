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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class tql
{
  public int a;
  public Context a;
  public AdvertisementInfo a;
  public AdData a;
  public ArrayList<tqo> a;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public oau a;
  public txh a;
  public txz a;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public tql()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 3;
  }
  
  public static void a(txh paramtxh, int paramInt)
  {
    if (paramtxh != null)
    {
      paramtxh.jdField_a_of_type_Int = paramInt;
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = paramInt;
      }
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = paramInt;
      }
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = paramInt;
      }
    }
  }
  
  public static void b(txh paramtxh, int paramInt)
  {
    if (paramtxh != null)
    {
      paramtxh.b = paramInt;
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = paramInt;
      }
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = paramInt;
      }
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramInt;
      }
    }
  }
  
  private String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (twh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
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
      return obb.ae;
    }
    if (this.jdField_a_of_type_Int == 3) {
      return obb.Y;
    }
    if (this.jdField_a_of_type_Int == 5) {
      return obb.af;
    }
    return obb.ae;
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
    if (this.jdField_a_of_type_Txh != null) {
      return this.jdField_a_of_type_Txh.d;
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
  
  public tql a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public tql a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public tql a(AdData paramAdData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    return this;
  }
  
  public tql a(oau paramoau)
  {
    this.jdField_a_of_type_Oau = paramoau;
    return this;
  }
  
  public tql a(tqo paramtqo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramtqo);
    return this;
  }
  
  public tql a(txh paramtxh)
  {
    this.jdField_a_of_type_Txh = paramtxh;
    return this;
  }
  
  public void a()
  {
    if (twh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      ThreadManager.executeOnNetWorkThread(new AdDownloadProxy.1(this));
      obb.a(new trn().a(BaseApplication.getContext()).a(obb.jdField_a_of_type_Int).b(a()).e(ttp.a(a(), obb.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), null)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)).a());
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (twh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
        if (!twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          break;
        }
      } while (a());
      a(false, false);
      return;
    } while (!twh.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      tqg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3010405L, 9L, "", d()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    twp.a("AdDownloadProxy", "mAppButton is clickable");
    try
    {
      if (twz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        twz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        return;
      }
      if (twh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
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
    if (this.jdField_a_of_type_Txh != null)
    {
      boolean bool = a();
      if (!bool)
      {
        int i;
        if ((NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) && (twq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {
          i = 1;
        }
        while ((absl.a()) || (i != 0)) {
          if (twh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
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
              tqk.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, obb.an, obb.jdField_a_of_type_Int, paramInt);
              return;
            }
            tqk.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, obb.Z, obb.jdField_a_of_type_Int, paramInt);
            return;
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          svz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
        }
      }
    }
  }
  
  public void a(TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView, int paramInt1, int paramInt2)
  {
    if ((paramNativeAdDownloadView == null) || (paramTextView == null))
    {
      twp.a("AdDownloadProxy", "updateUIState error : ui is null");
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.3(this, paramInt1, paramInt2, paramTextView, paramNativeAdDownloadView));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (absl.a()))
    {
      if (a()) {}
      while ((!absl.a()) || (paramBoolean2)) {
        return;
      }
      this.b.set(true);
      b();
      return;
    }
    twk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramBoolean1, c(), new tqn(this, paramBoolean2));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Txh == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    Object localObject = this.jdField_a_of_type_Txh.d;
    int j = obb.M;
    int i = obb.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bfwv.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 1;
      if (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = obb.e;
        localHashMap.put("download_state", "5");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
      }
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(ttp.a(a(), obb.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(5))).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
      return true;
    }
    if (oau.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Txh))
    {
      localObject = bhyo.a().c(this.jdField_a_of_type_Txh.d);
      bhyo.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 5;
      if (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = obb.e;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).e(ttp.a(a(), obb.T, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(6))).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        return true;
        j = obb.Z;
      }
    }
    return false;
  }
  
  public boolean a(txh paramtxh)
  {
    return (paramtxh != null) && (this.jdField_a_of_type_Txh != null) && (paramtxh.d.equals(this.jdField_a_of_type_Txh.d));
  }
  
  public String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      localObject = amtj.a(2131712068);
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
          if (!twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break;
          }
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            this.b.set(false);
            b();
          }
          localObject = a();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (obb.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return amtj.a(2131712114);
          }
          if (oau.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return "安装";
          }
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        return amtj.a(2131711987);
        if (!d()) {
          break;
        }
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (obb.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return amtj.a(2131712186);
        }
        if (oau.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return "立即安装";
        }
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      return amtj.a(2131711914);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (twz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return amtj.a(2131712230);
    }
    if (twr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717386);
    }
    if (twr.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717387);
    }
    if (twh.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return amtj.a(2131711920);
    }
    if (twh.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return amtj.a(2131711820);
    }
    if (twh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return amtj.a(2131712193);
    }
    return amtj.a(2131712068);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    int j = obb.M;
    int i = obb.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Txh == null) {
          return;
        }
        Object localObject1 = this.jdField_a_of_type_Txh.d;
        if (bfwv.a(BaseApplicationImpl.getContext(), (String)localObject1))
        {
          g();
          this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 1;
          if (!twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break label763;
          }
          localHashMap.put("download_state", "5");
          paramInt = a();
          i = obb.e;
          obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((tqo)((Iterator)localObject1).next()).b();
          continue;
        }
        if (!oau.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Txh)) {
          break label369;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = bhyo.a().c(this.jdField_a_of_type_Txh.d);
      bhyo.a().a((DownloadInfo)localObject2);
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 5;
      if (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localHashMap.put("download_state", "3");
        paramInt = a();
        i = obb.e;
      }
      for (;;)
      {
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((tqo)((Iterator)localObject2).next()).a();
        }
        paramInt = obb.T;
      }
      label369:
      localObject2 = "";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
      }
      if ((NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) && (twq.a((String)localObject2))) {}
      int k;
      for (j = 1;; j = 0)
      {
        k = obb.T;
        if ((!absl.a()) && (j == 0)) {
          break label641;
        }
        if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 3) {
          break label526;
        }
        e();
        if ((!twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!twh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
          break;
        }
        tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 4, d());
        return;
      }
      if (e())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
        tqk.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
        return;
      }
      tqk.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
      return;
      label526:
      if ((this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 0)) {
        break;
      }
      c();
      if ((twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (twh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
      {
        tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 9, d());
        return;
      }
      if (e())
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
        }
        tqk.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
        return;
      }
      tqk.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
      return;
      label641:
      if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int == 3)
      {
        e();
        paramInt = k;
        if (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          localHashMap.put("download_state", "8");
          paramInt = a();
          i = obb.e;
        }
        obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      svz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
      return;
      label763:
      paramInt = j;
    }
  }
  
  public boolean b()
  {
    if ((d()) && (this.jdField_a_of_type_Txh != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Txh.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bhyo.a().c((String)localObject);
          if ((oau.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Txh)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
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
    if ((this.jdField_a_of_type_Oau == null) || (this.jdField_a_of_type_Txh == null)) {}
    Iterator localIterator;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
      if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 4) {
        break;
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((tqo)localIterator.next()).a(this.jdField_a_of_type_Txh.b);
      }
    }
    if (this.jdField_a_of_type_Txh.b != 100) {}
    for (int i = this.jdField_a_of_type_Txh.b;; i = 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((tqo)localIterator.next()).a(this.jdField_a_of_type_Txh, 3, i);
      }
      break;
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (paramInt != 5) || (this.jdField_a_of_type_Txh == null)) {}
    while ((paramInt == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.d)) && (this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_Txh.d))) {
      return;
    }
    if ((twh.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_Txh.d);
      tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 5, d());
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_Txh.d);
    HashMap localHashMap = new HashMap();
    obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_a_of_type_Int).b(a()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(ttp.a(a(), obb.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
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
    if ((this.jdField_a_of_type_Oau == null) || (this.jdField_a_of_type_Txh == null)) {
      return;
    }
    this.jdField_a_of_type_Oau.d(this.jdField_a_of_type_Txh);
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
    if ((this.jdField_a_of_type_Oau == null) || (this.jdField_a_of_type_Txh == null)) {
      return;
    }
    this.jdField_a_of_type_Oau.b(this.jdField_a_of_type_Txh);
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
      uhs.b(this.jdField_a_of_type_AndroidContentContext, tws.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
    }
    while ((this.jdField_a_of_type_Txh == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Txh.d))) {
      return;
    }
    twr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Txh.d);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Txh == null) {}
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
          if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int == 4)
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((tqo)((Iterator)localObject).next()).a(this.jdField_a_of_type_Txh, 4, this.jdField_a_of_type_Txh.b);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 5) {
              break;
            }
            localObject = this.jdField_a_of_type_Txh.d;
            if (bfwv.a(BaseApplicationImpl.getContext(), (String)localObject))
            {
              this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 1;
              localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((tqo)((Iterator)localObject).next()).a(this.jdField_a_of_type_Txh, 1, this.jdField_a_of_type_Txh.b);
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Txh.jdField_a_of_type_Int != 3);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((tqo)((Iterator)localObject).next()).a(this.jdField_a_of_type_Txh, 3, this.jdField_a_of_type_Txh.b);
      }
    } while (this.jdField_a_of_type_Oau == null);
    this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
    return;
    label256:
    this.b.compareAndSet(true, false);
    int j = obb.N;
    int i = obb.jdField_a_of_type_Int;
    long l = a();
    Object localObject = new HashMap();
    if (oau.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Txh))
    {
      d();
      this.jdField_a_of_type_Txh.jdField_a_of_type_Int = 5;
      if (twh.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = obb.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(ttp.a(l, obb.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(obb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (HashMap)localObject)).a());
      return;
    }
    c();
    tqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3, d());
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Txz != null)
    {
      this.jdField_a_of_type_Txz.dismiss();
      this.jdField_a_of_type_Txz = null;
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tql
 * JD-Core Version:    0.7.0.1
 */