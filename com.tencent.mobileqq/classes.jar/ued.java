import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.AdDownloadProxy.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.AdDownloadProxy.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ued
{
  public int a;
  public Context a;
  public AdvertisementInfo a;
  public AdData a;
  public ArrayList<ueg> a;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public oil a;
  public ule a;
  public ulx a;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public ued()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 3;
  }
  
  public static void a(ule paramule, int paramInt)
  {
    if (paramule != null)
    {
      paramule.jdField_a_of_type_Int = paramInt;
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = paramInt;
      }
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = paramInt;
      }
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = paramInt;
      }
    }
  }
  
  public static void b(ule paramule, int paramInt)
  {
    if (paramule != null)
    {
      paramule.b = paramInt;
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = paramInt;
      }
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = paramInt;
      }
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramInt;
      }
    }
  }
  
  private String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
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
    if (this.jdField_a_of_type_Int == 4) {}
    do
    {
      return 25;
      if (this.jdField_a_of_type_Int == 3) {
        return 18;
      }
    } while (this.jdField_a_of_type_Int != 5);
    return 26;
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
    if (this.jdField_a_of_type_Ule != null) {
      return this.jdField_a_of_type_Ule.d;
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
  
  public ued a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public ued a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public ued a(AdData paramAdData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    return this;
  }
  
  public ued a(ueg paramueg)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramueg);
    return this;
  }
  
  public ued a(ule paramule)
  {
    this.jdField_a_of_type_Ule = paramule;
    return this;
  }
  
  public void a()
  {
    if (uki.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      ThreadManager.executeOnNetWorkThread(new AdDownloadProxy.1(this));
      ois.a(new ufy().a(BaseApplication.getContext()).a(1).b(a()).a(JumpMode.GIFT).e(uhw.a(a(), 1, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), null)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)).a());
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (uki.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
        if (!uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          break;
        }
      } while (a());
      a(false, false);
      return;
    } while (!uki.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
    JumpMode localJumpMode = JumpMode.UNKNOWN;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localJumpMode = udy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    ueb.a(localJumpMode, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3010405L, 9L, "", d()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
      if ((d()) || (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdClickBtn);
      }
    }
    ukq.a("AdDownloadProxy", "mAppButton is clickable");
    try
    {
      if (ula.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        ula.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        return;
      }
      if (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
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
    if (this.jdField_a_of_type_Ule != null)
    {
      boolean bool = a();
      if (!bool)
      {
        int i;
        if ((NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) && (ukr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {
          i = 1;
        }
        while ((acik.a()) || (i != 0)) {
          if (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
          {
            this.b.set(true);
            b();
            return;
            i = 0;
          }
          else if (c())
          {
            c();
            if (d())
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(1);
              uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, 1, paramInt);
              return;
            }
            uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 20, 1, paramInt);
            return;
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          tjk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
        }
      }
    }
  }
  
  public void a(TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView, int paramInt1, int paramInt2)
  {
    if ((paramNativeAdDownloadView == null) || (paramTextView == null))
    {
      ukq.a("AdDownloadProxy", "updateUIState error : ui is null");
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.3(this, paramInt1, paramInt2, paramTextView, paramNativeAdDownloadView));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (acik.a()))
    {
      if (a()) {}
      while ((!acik.a()) || (paramBoolean2)) {
        return;
      }
      this.b.set(true);
      b();
      return;
    }
    ukl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramBoolean1, b(), new uef(this, paramBoolean2));
  }
  
  public boolean a()
  {
    int j = 5;
    if (this.jdField_a_of_type_Ule == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
    }
    Object localObject = this.jdField_a_of_type_Ule.d;
    HashMap localHashMap = new HashMap();
    int i;
    if (bhfn.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      f();
      this.jdField_a_of_type_Ule.jdField_a_of_type_Int = 1;
      if (!uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        break label357;
      }
      j = a();
      localHashMap.put("download_state", "5");
      i = 5;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
      }
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(JumpMode.ANDROID_OPEN_APP).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(uhw.a(a(), 1, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(5))).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
      return true;
      if (oil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ule))
      {
        localObject = bjjq.a().c(this.jdField_a_of_type_Ule.d);
        bjjq.a().a((DownloadInfo)localObject);
        this.jdField_a_of_type_Ule.jdField_a_of_type_Int = 5;
        if (uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          i = a();
          localHashMap.put("download_state", "3");
        }
        for (;;)
        {
          ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(j).b(i).a(JumpMode.ANDROID_INSTALL).e(uhw.a(a(), 8, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(6))).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
          return true;
          i = 20;
          j = 1;
        }
      }
      return false;
      label357:
      i = 1;
      j = 1;
    }
  }
  
  public boolean a(ule paramule)
  {
    return (paramule != null) && (this.jdField_a_of_type_Ule != null) && (paramule.d.equals(this.jdField_a_of_type_Ule.d));
  }
  
  public String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      localObject = anvx.a(2131712415);
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
          if (!uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break;
          }
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            this.b.set(false);
            b();
          }
          localObject = a();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (ois.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return anvx.a(2131712461);
          }
          if (oil.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return "安装";
          }
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        return anvx.a(2131712334);
        if (!c()) {
          break;
        }
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (ois.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return anvx.a(2131712533);
        }
        if (oil.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return "立即安装";
        }
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      return anvx.a(2131712261);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (ula.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anvx.a(2131712577);
    }
    if (uks.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717752);
    }
    if (uks.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717753);
    }
    if (uki.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anvx.a(2131712267);
    }
    if (uki.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anvx.a(2131712167);
    }
    if (uki.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anvx.a(2131712540);
    }
    return anvx.a(2131712415);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule);
  }
  
  public void b(int paramInt)
  {
    int i = 8;
    int j = 5;
    int k = 1;
    int m = 1;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(8);
      if ((d()) || (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdClickBtn);
      }
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ule == null) {
          return;
        }
        Object localObject1 = this.jdField_a_of_type_Ule.d;
        if (bhfn.a(BaseApplicationImpl.getContext(), (String)localObject1))
        {
          f();
          this.jdField_a_of_type_Ule.jdField_a_of_type_Int = 1;
          if (!uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break label820;
          }
          localHashMap.put("download_state", "5");
          paramInt = a();
          ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(j).a(JumpMode.ANDROID_OPEN_APP).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((ueg)((Iterator)localObject1).next()).b();
          continue;
        }
        if (!oil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ule)) {
          break label401;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = bjjq.a().c(this.jdField_a_of_type_Ule.d);
      bjjq.a().a((DownloadInfo)localObject2);
      this.jdField_a_of_type_Ule.jdField_a_of_type_Int = 5;
      if (uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localHashMap.put("download_state", "3");
        i = a();
      }
      for (;;)
      {
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(j).a(JumpMode.ANDROID_INSTALL).b(i).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ueg)((Iterator)localObject2).next()).a();
        }
        j = 1;
      }
      label401:
      localObject2 = "";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
      }
      if ((NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) && (ukr.a((String)localObject2))) {
        j = 1;
      }
      while ((acik.a()) || (j != 0)) {
        if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int == 3)
        {
          e();
          if ((uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (uki.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            ueb.a(JumpMode.ANDROID_DOWNLOAD_PAUSE, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 4, d());
            return;
            j = 0;
          }
          else
          {
            if (d())
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
              uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_PAUSE, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 8, 1, paramInt);
              return;
            }
            uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_PAUSE, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 8, 1, paramInt);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_Ule.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Ule.jdField_a_of_type_Int != 0)) {
            return;
          }
          c();
          if ((uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (uki.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            ueb.a(JumpMode.ANDROID_DOWNLOAD_CONTINUE, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 9, d());
            return;
          }
          if (d())
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
            }
            uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_CONTINUE, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 8, 1, paramInt);
            return;
          }
          uec.a(ReportAction.CLICK, JumpMode.ANDROID_DOWNLOAD_CONTINUE, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 8, 1, paramInt);
          return;
        }
      }
      if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int == 3)
      {
        e();
        paramInt = k;
        if (uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          localHashMap.put("download_state", "8");
          i = a();
          paramInt = 5;
        }
        ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(paramInt).b(i).a(JumpMode.ANDROID_DOWNLOAD_PAUSE).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      tjk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
      return;
      label820:
      j = 1;
      paramInt = m;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    while ((!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Oil == null) || (this.jdField_a_of_type_Ule == null)) {}
    Iterator localIterator;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule);
      if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int != 4) {
        break;
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ueg)localIterator.next()).a(this.jdField_a_of_type_Ule.b);
      }
    }
    if (this.jdField_a_of_type_Ule.b != 100) {}
    for (int i = this.jdField_a_of_type_Ule.b;; i = 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ueg)localIterator.next()).a(this.jdField_a_of_type_Ule, 3, i);
      }
      break;
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (paramInt != 5) || (this.jdField_a_of_type_Ule == null)) {}
    while ((paramInt == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.d)) && (this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_Ule.d))) {
      return;
    }
    if ((uki.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_Ule.d);
      ueb.a(JumpMode.UNKNOWN, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 5, d());
      return;
    }
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_Ule.d);
    HashMap localHashMap = new HashMap();
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(a()).a(JumpMode.UNKNOWN).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(uhw.a(a(), 1, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
  }
  
  public boolean c()
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
  
  public void d()
  {
    if ((this.jdField_a_of_type_Oil == null) || (this.jdField_a_of_type_Ule == null)) {
      return;
    }
    this.jdField_a_of_type_Oil.d(this.jdField_a_of_type_Ule);
  }
  
  public boolean d()
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
  
  public void e()
  {
    if ((this.jdField_a_of_type_Oil == null) || (this.jdField_a_of_type_Ule == null)) {
      return;
    }
    this.jdField_a_of_type_Oil.b(this.jdField_a_of_type_Ule);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.n == 32) && (c())) {
      uvp.a(this.jdField_a_of_type_AndroidContentContext, ukt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
    }
    while ((this.jdField_a_of_type_Ule == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Ule.d))) {
      return;
    }
    uks.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ule.d);
  }
  
  public void g()
  {
    int i = 5;
    int j = 3;
    if (this.jdField_a_of_type_Ule == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.b.get())) {
            break label260;
          }
          if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int == 4)
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((ueg)((Iterator)localObject).next()).a(this.jdField_a_of_type_Ule, 4, this.jdField_a_of_type_Ule.b);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Ule.jdField_a_of_type_Int != 5) {
              break;
            }
            localObject = this.jdField_a_of_type_Ule.d;
            if (bhfn.a(BaseApplicationImpl.getContext(), (String)localObject))
            {
              this.jdField_a_of_type_Ule.jdField_a_of_type_Int = 1;
              localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((ueg)((Iterator)localObject).next()).a(this.jdField_a_of_type_Ule, 1, this.jdField_a_of_type_Ule.b);
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Ule.jdField_a_of_type_Int != 3);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ueg)((Iterator)localObject).next()).a(this.jdField_a_of_type_Ule, 3, this.jdField_a_of_type_Ule.b);
      }
    } while (this.jdField_a_of_type_Oil == null);
    this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule);
    return;
    label260:
    this.b.compareAndSet(true, false);
    long l = a();
    Object localObject = new HashMap();
    if (oil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ule))
    {
      d();
      this.jdField_a_of_type_Ule.jdField_a_of_type_Int = 5;
      if (!uki.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        break label435;
      }
      j = a();
      ((HashMap)localObject).put("download_state", "3");
    }
    for (;;)
    {
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(JumpMode.ANDROID_INSTALL).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(uhw.a(l, 1, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (HashMap)localObject)).a());
      return;
      c();
      ueb.a(JumpMode.ANDROID_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3, d());
      return;
      label435:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ued
 * JD-Core Version:    0.7.0.1
 */