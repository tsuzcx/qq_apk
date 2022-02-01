import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetRecommendTagRequest;
import com.tencent.biz.qqcircle.requests.QCirclePublishFeedRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;
import cooperation.qzone.feed.CertifiedFakeFeed;
import cooperation.qzone.model.QCirclePublishPictureTagInfo;
import eipc.EIPCResult;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudTagcategorysvr.PicRecomEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avre
  extends QIPCModule
{
  private static avre a;
  private final AtomicReference<avre.a> i = new AtomicReference();
  
  public avre(String paramString)
  {
    super(paramString);
  }
  
  public static avre a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avre("QzoneIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public static JSONObject a(List<ygl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = new StringBuilder().append("parseSticker2Json: empty img list ");
      if (paramList == null) {}
      for (paramList = "null";; paramList = Integer.valueOf(paramList.size()))
      {
        QLog.i("QzoneIPCModule", 2, paramList);
        return null;
      }
    }
    Object localObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (ygl)paramList.next();
      if ((localObject2 != null) && ((localObject2 instanceof ygz)))
      {
        localObject2 = (ygz)localObject2;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("url", ((ygz)localObject2).getImgUrl()).put("thumbUrl", ((ygz)localObject2).getThumbUrl()).put("md5", ((ygz)localObject2).pz());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to create data json", localJSONException);
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("data", localJSONArray);
      return localObject1;
    }
    catch (JSONException paramList)
    {
      QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to put data json", paramList);
    }
    return null;
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramBundle.getStringArrayList("uins");
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof QQAppInterface)));
      paramBundle = (abhh)paramQQAppInterface.getManager(153);
      paramQQAppInterface = (aqrb)paramQQAppInterface.getBusinessHandler(71);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ApolloBaseInfo localApolloBaseInfo = paramBundle.b(str);
        if ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)) {
          localArrayList.add(str);
        }
      }
    } while (localArrayList.isEmpty());
    QLog.i("QzoneIPCModule", 1, "CmShow preloadCmData but ApolloBaseInfo need update size:" + localArrayList.size());
    paramBundle = new String[localArrayList.size()];
    int j = 0;
    while (j < localArrayList.size())
    {
      paramBundle[j] = ((String)localArrayList.get(j));
      j += 1;
    }
    paramQQAppInterface.Z(paramBundle);
  }
  
  private static List<ygz> b(String paramString1, String paramString2, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    JSONArray localJSONArray;
    int j;
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 == null) {
        return localLinkedList;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.w("QzoneIPCModule", 2, "parseJson2Sticker: failed to parse json", paramString1);
        paramString1 = null;
      }
      localJSONArray = paramString1.optJSONArray("data");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        paramString2 = new StringBuilder().append("parseJson2Sticker: empty data ");
        if (localJSONArray == null) {}
        for (paramString1 = "null";; paramString1 = "0")
        {
          QLog.i("QzoneIPCModule", 2, paramString1);
          return localLinkedList;
        }
      }
      j = 0;
    }
    for (;;)
    {
      if ((j >= localJSONArray.length()) || (j > paramInt)) {
        return localLinkedList;
      }
      paramString1 = localJSONArray.optJSONObject(j);
      String str = paramString1.optString("url");
      paramString1 = paramString1.optString("md5");
      ygz localygz = new ygz();
      localygz.setImgUrl(str);
      localygz.yE(paramString1);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.equals(str))
        {
          localygz.setClicked(true);
          paramString1 = null;
        }
      }
      localLinkedList.add(localygz);
      j += 1;
      paramString2 = paramString1;
    }
  }
  
  private void f(Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ovd.u(paramBundle.getString("key_qcircle_pic_tag")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      QCirclePublishPictureTagInfo localQCirclePublishPictureTagInfo = (QCirclePublishPictureTagInfo)((Iterator)localObject).next();
      if (localQCirclePublishPictureTagInfo != null)
      {
        FeedCloudTagcategorysvr.PicRecomEntry localPicRecomEntry = new FeedCloudTagcategorysvr.PicRecomEntry();
        localPicRecomEntry.picId.set(localQCirclePublishPictureTagInfo.picId);
        localPicRecomEntry.recomTags.set(localQCirclePublishPictureTagInfo.picTags);
        localArrayList.add(localPicRecomEntry);
      }
    }
    localObject = new FeedCloudMeta.StGPSV2();
    paramBundle = paramBundle.getByteArray("key_qcircle_gps_info");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle = (FeedCloudMeta.StGPSV2)((FeedCloudMeta.StGPSV2)localObject).mergeFrom(paramBundle);
        paramBundle = new QCircleGetRecommendTagRequest(paramBundle, localArrayList);
        VSNetworkHelper.a().a(paramBundle, new avrh(this, paramInt));
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle = (Bundle)localObject;
        continue;
      }
      paramBundle = (Bundle)localObject;
    }
  }
  
  public void bz(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    avre.a locala;
    do
    {
      return;
      QLog.i("QzoneIPCModule", 1, "onGetStickerRecResp: " + paramString1 + " " + paramString2);
      locala = (avre.a)this.i.get();
    } while ((locala == null) || (!paramString1.equals(avre.a.b(locala))) || (!this.i.compareAndSet(locala, null)));
    avre.a.a(locala, paramString2);
    avre.a.b(locala, paramString3);
    avre.a.a(locala).countDown();
  }
  
  public void eBI()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "QQCirCleClientIPCModule", "cooperation.qzone.ACTION_QCIRCLE_GET_TASK_LIST", null, new avrj(this));
  }
  
  public void eBJ()
  {
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PubAccountIPCModule", "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST", null, new avrk(this));
  }
  
  public void g(Bundle paramBundle, int paramInt)
  {
    String str;
    Object localObject1;
    Object localObject2;
    try
    {
      str = paramBundle.getString("key_clientkey");
      localObject1 = paramBundle.getByteArray("key_stfeed");
      paramBundle = (HashMap)paramBundle.getSerializable("key_common_ext");
      localObject2 = new FeedCloudMeta.StFeed();
      if (localObject1 != null)
      {
        localObject1 = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)localObject2).mergeFrom((byte[])localObject1);
        QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED publishFeed" + ((FeedCloudMeta.StFeed)localObject1).id.get());
        localObject2 = new FeedCloudCommon.StCommonExt();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.entrySet().iterator();
          while (paramBundle.hasNext()) {
            ((FeedCloudCommon.StCommonExt)localObject2).mapInfo.add(pcr.a((Map.Entry)paramBundle.next()));
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED error" + paramBundle);
    }
    paramBundle = new QCirclePublishFeedRequest((FeedCloudCommon.StCommonExt)localObject2, (FeedCloudMeta.StFeed)localObject1);
    VSNetworkHelper.a().a(paramBundle, new avri(this, str, paramInt));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPCModule", 2, "action = " + paramString + " callbackId:" + paramInt);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
    if ("getHostInfo".equals(paramString)) {
      try
      {
        paramString = ((acff)localQQAppInterface.getManager(51)).c(localQQAppInterface.getCurrentAccountUin());
        paramBundle = new Bundle();
        paramBundle.putLong("age", paramString.age);
        paramBundle.putLong("gender", paramString.shGender);
        paramBundle.putLong("constellation", paramString.constellation);
        paramBundle.putString("country", paramString.strCountry);
        paramBundle.putString("province", paramString.strProvince);
        paramBundle.putString("city", paramString.strCity);
        paramString = EIPCResult.createResult(0, paramBundle);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
      }
    }
    for (;;)
    {
      return null;
      boolean bool1;
      if ("isFriend".equals(paramString))
      {
        long l = 0L;
        if (paramBundle != null) {}
        try
        {
          l = paramBundle.getLong("uin");
          bool1 = ((acff)localQQAppInterface.getManager(51)).isFriend(String.valueOf(l));
          paramString = new Bundle();
          paramString.putBoolean("isFriend", bool1);
          paramString = EIPCResult.createResult(0, paramString);
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        }
      }
      else
      {
        if ("startDownloadVoicechangeSo".equals(paramString)) {
          for (;;)
          {
            try
            {
              paramInt = imm.getCpuArchitecture();
              if (paramInt > 2) {
                continue;
              }
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
              continue;
              AVSoUtils.d(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
              continue;
            }
            try
            {
              paramString = ((afem)localQQAppInterface.getManager(77)).a(affj.ur());
              if (paramString == null) {
                continue;
              }
              paramString.HL(false);
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo Exception:" + paramString.getMessage());
              continue;
            }
            return EIPCResult.createResult(0, new Bundle());
            QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo null == earlyHandler:");
          }
        }
        if ("action_qzone_pic_pre_send".equals(paramString))
        {
          try
          {
            akxf.d(localQQAppInterface, paramBundle);
            paramString = new Bundle();
            paramString.putBoolean("qzone_pre_send_result", true);
            paramString = EIPCResult.createResult(0, paramString);
            return paramString;
          }
          catch (Exception paramString)
          {
            QLog.e("QzoneIPCModule", 1, "action QzonePic preSend exception: ", paramString);
          }
        }
        else
        {
          Object localObject2;
          if ("action_qzone_get_sticker_rec_gif".equals(paramString))
          {
            localObject1 = null;
            paramString = null;
            if (paramBundle != null)
            {
              localObject1 = paramBundle.getString("analyze_text");
              paramString = paramBundle.getString("toUin");
            }
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString)))
            {
              QLog.w("QzoneIPCModule", 1, "empty text or unit " + (String)localObject1 + " , " + paramString);
              return null;
            }
            localObject2 = yhf.a(localQQAppInterface);
            ((yhf)localObject2).init();
            if (!((yhf)localObject2).TC())
            {
              QLog.i("QzoneIPCModule", 1, "emo rec is not open");
              return null;
            }
            paramBundle = new avre.a((String)localObject1, null);
            this.i.set(paramBundle);
            if (!((yhf)localObject2).a((String)localObject1, 0, paramString, true))
            {
              this.i.compareAndSet(paramBundle, null);
              return null;
            }
            try
            {
              avre.a.a(paramBundle).await(2L, TimeUnit.SECONDS);
              if (TextUtils.isEmpty(avre.a.a(paramBundle)))
              {
                QLog.i("QzoneIPCModule", 1, "empty sticker rec resp list");
                return EIPCResult.createResult(-102, null);
              }
            }
            catch (InterruptedException paramString)
            {
              for (;;)
              {
                QLog.w("QzoneIPCModule", 1, "waiting req interrupted ", paramString);
              }
              paramString = new Bundle();
              paramString.putString("analyze_text", avre.a.b(paramBundle));
              paramString.putString("resp_data", avre.a.a(paramBundle));
              paramString.putString("resp_pass", avre.a.c(paramBundle));
              return EIPCResult.createSuccessResult(paramString);
            }
          }
          Object localObject3;
          if ("action_qzone_report_sticker_gif".equals(paramString))
          {
            paramString = null;
            String str = null;
            localObject3 = null;
            localObject2 = null;
            localObject1 = null;
            paramInt = 0;
            if (paramBundle != null)
            {
              str = paramBundle.getString("rpt_data");
              localObject3 = paramBundle.getString("rpt_click");
              paramString = paramBundle.getString("toUin");
              localObject2 = paramBundle.getString("rpt_pass");
              localObject1 = paramBundle.getString("analyze_text");
              paramInt = paramBundle.getInt("rpt_expose_cnt", 0);
            }
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (paramInt < 1)) {
              return null;
            }
            paramBundle = new yhl();
            paramBundle.keyword = ((String)localObject1);
            paramBundle.aXF = ((String)localObject2);
            paramBundle.exposedList = b(str, (String)localObject3, paramInt);
            localObject1 = yhf.a(localQQAppInterface);
            ((yhf)localObject1).init();
            ((yhf)localObject1).a(Collections.singletonList(paramBundle), true, 11000, paramString);
            return EIPCResult.createSuccessResult(null);
          }
          if ("action_save_customenotion".equals(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("pic_path");
              if (!TextUtils.isEmpty(paramString))
              {
                paramInt = xtm.g(localQQAppInterface, paramString);
                paramString = new Bundle();
                paramString.putInt("resultCode", paramInt);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
          }
          else if ("action_pre_pull_mini_app".equals(paramString))
          {
            if (paramBundle != null)
            {
              QLog.d("QzoneIPCModule", 4, "ACTION_PRE_PULL_MINI_APP change to qq_process by QzoneIPCModule");
              paramString = paramBundle.getString("miniapp_preload_link");
              paramInt = paramBundle.getInt("miniapp_preload_link_type");
              bool1 = paramBundle.getBoolean("miniapp_repload_with_package_and_cache_preload", false);
              MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramInt, bool1, new avrf(this));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              rwv.a().a(new SubscribeFeedsEvent(paramString, 1));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              rwv.a().a(new SubscribeFeedsEvent(paramString, 2));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
            paramBundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            paramString = paramBundle.getParcelable("KEY_CERTIFIED_FAKE_FEED");
            if ((paramString instanceof CertifiedFakeFeed))
            {
              paramString = (CertifiedFakeFeed)paramString;
              rwv.a().a(new SubscribeFeedsEvent(paramString, 3));
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED".equalsIgnoreCase(paramString))
          {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
            rwv.a().a(new PublishBoxStatusEvent(paramBundle));
            rwv.a().a(new SubscribeFeedsEvent(4));
          }
          else if ("action_qzone_get_themeid".equalsIgnoreCase(paramString))
          {
            try
            {
              paramString = new Bundle();
              paramString.putString("themeId", ThemeUtil.getCurrentThemeId());
              paramString = EIPCResult.createResult(0, paramString);
              return paramString;
            }
            catch (Exception paramString)
            {
              QLog.e("QzoneIPCModule", 1, "action getThemeId exception: ", paramString);
            }
          }
          else if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("uin", null);
              if (paramString != null)
              {
                ocp.a(localQQAppInterface, localQQAppInterface.getApp().getApplicationContext(), paramString, false, null, true);
                awdg.aU(localQQAppInterface.getApp().getApplicationContext(), paramString, 0);
              }
            }
          }
          else if ("action_qzone_main_process_prop_set".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("key", null);
              if (paramString != null)
              {
                bool1 = paramBundle.getBoolean("value");
                localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).edit().putBoolean(paramString, bool1).apply();
                return EIPCResult.createSuccessResult(null);
              }
            }
          }
          else if ("action_qzone_main_process_prop_get".equalsIgnoreCase(paramString))
          {
            if (paramBundle != null)
            {
              paramString = paramBundle.getString("key", null);
              if (paramString != null)
              {
                bool1 = localQQAppInterface.getApp().getSharedPreferences("QZ_main_setting", 0).getBoolean(paramString, false);
                paramString = new Bundle();
                paramString.putBoolean("value", bool1);
                return EIPCResult.createSuccessResult(paramString);
              }
            }
          }
          else
          {
            if ("action_qzone_send_event".equalsIgnoreCase(paramString))
            {
              if (avsn.aLz()) {
                return EIPCResult.createResult(-1, null);
              }
              if (paramBundle != null)
              {
                paramBundle.setClassLoader(ExoticEvent.getLoader());
                paramString = (ExoticEvent)paramBundle.getParcelable("event");
                if (paramString != null)
                {
                  bool1 = ExoticEventPool.getInstance().onEventReceived(paramString);
                  paramString = new Bundle();
                  paramString.putBoolean("re", bool1);
                  return EIPCResult.createSuccessResult(paramString);
                }
              }
              return EIPCResult.createResult(-1, null);
            }
            if ("cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH".equalsIgnoreCase(paramString))
            {
              QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH to qq_process by QzoneIPCModule");
              try
              {
                paramString = paramBundle.getByteArray("bundle_key_feed_byte_array");
                paramBundle = new CertifiedAccountMeta.StFeed();
                if (paramString == null) {
                  continue;
                }
                paramString = (CertifiedAccountMeta.StFeed)paramBundle.mergeFrom(paramString);
                QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH publishFeed" + paramString.id.get());
                rwv.a().a(new SubscribePublishFeedsEvent(paramString, 1));
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                QLog.e("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH error" + paramString);
              }
            }
            else
            {
              if ("action_qzone_show_push_setting_banner".equalsIgnoreCase(paramString))
              {
                paramString = new Bundle();
                paramBundle = aeaq.a(localQQAppInterface);
                if (paramBundle == null)
                {
                  QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null mgr");
                  return EIPCResult.createResult(-102, null);
                }
                bool1 = paramBundle.agg();
                paramString.putBoolean("visible", bool1);
                if (bool1)
                {
                  localObject1 = aelf.a();
                  if (localObject1 == null) {
                    break label1877;
                  }
                  paramBundle = ((aele)localObject1).tw();
                  localObject1 = ((aele)localObject1).tx();
                  paramString.putString("msg", paramBundle);
                  paramString.putString("setting", (String)localObject1);
                }
                for (;;)
                {
                  return EIPCResult.createSuccessResult(paramString);
                  label1877:
                  QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null conf bean");
                }
              }
              if ("action_qzone_close_push_setting_banner".equalsIgnoreCase(paramString))
              {
                paramString = aeaq.a(localQQAppInterface);
                if (paramString == null)
                {
                  QLog.d("QzoneIPCModule", 1, "ACTION_CLOSE_PUSH_SETTING_BANNER null mgr");
                  return EIPCResult.createResult(-102, null);
                }
                paramString.cVw();
                return EIPCResult.createSuccessResult(null);
              }
              if ("cooperation.qzone.ACTION_QCIRCLE_PULISH_FEED".equalsIgnoreCase(paramString))
              {
                QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PULISH_FEED to qq_process by QzoneIPCModule");
                g(paramBundle, paramInt);
              }
              else
              {
                if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT to qq_process by QzoneIPCModule");
                  paramString = (ArrayList)paramBundle.getSerializable("key_report_info");
                  if (paramString != null) {}
                  for (paramInt = paramString.size();; paramInt = 0)
                  {
                    QLog.d("[QzoneIPCModule_upload2]QCircle", 4, new Object[] { "ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT size:", Integer.valueOf(paramInt) });
                    pck.aZ(paramString);
                    break;
                  }
                }
                if ("cooperation.qzone.ACTION_QQCIRCLE_FAKE_FEED_CREATE".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QQCIRCLE_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    rwv.a().a(new QCircleFeedEvent(paramString, 1));
                    rwv.a().a(new QCircleSelectTabEvent(1).needScrollTop());
                  }
                  else
                  {
                    QLog.e("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QQCIRCLE_FAKE_FEED_CREATE fakeFeed == null");
                  }
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_QUEUE_CHANGED".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_QUEUE_CHANGED to qq_process by QzoneIPCModule");
                  eBI();
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_FAKE_FEED_DELETE".equalsIgnoreCase(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    rwv.a().a(new QCircleFeedEvent(paramString, 3));
                  }
                }
                else if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS".equals(paramString))
                {
                  QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_STATUS to qq_process by QzoneIPCModule");
                  paramBundle.setClassLoader(QCircleFakeFeed.class.getClassLoader());
                  paramString = paramBundle.getParcelable("KEY_Q_CIRCLE_FAKE_FEED");
                  if ((paramString instanceof QCircleFakeFeed))
                  {
                    paramString = (QCircleFakeFeed)paramString;
                    rwv.a().a(new QCircleFeedEvent(paramString.getFeedId(), 5));
                  }
                }
                else
                {
                  if ("action_qzone_follow_qq_circle".equalsIgnoreCase(paramString))
                  {
                    paramString = new Bundle();
                    if (paramBundle == null)
                    {
                      QLog.w("QzoneIPCModule", 1, "flow qq circle no param");
                      paramString.putInt("code", -1);
                      return EIPCResult.createResult(-102, paramString);
                    }
                    localObject1 = paramBundle.getString("circle_uin");
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      QLog.w("QzoneIPCModule", 1, "flow qq circle no uin");
                    }
                    bool1 = paramBundle.getBoolean("circle_follow");
                    paramBundle = new FeedCloudMeta.StUser();
                    paramBundle.id.set((String)localObject1);
                    localObject2 = new CountDownLatch(1);
                    localObject1 = new boolean[1];
                    localObject1[0] = 0;
                    localObject3 = VSNetworkHelper.a();
                    if (bool1) {}
                    for (paramInt = 1;; paramInt = 0)
                    {
                      ((VSNetworkHelper)localObject3).a(new QCircleDoFollowRequest(paramBundle, paramInt, null), new avrg(this, (boolean[])localObject1, (CountDownLatch)localObject2));
                      bool1 = false;
                      try
                      {
                        boolean bool2 = ((CountDownLatch)localObject2).await(10L, TimeUnit.SECONDS);
                        bool1 = bool2;
                      }
                      catch (InterruptedException paramBundle)
                      {
                        for (;;)
                        {
                          QLog.w("QzoneIPCModule", 1, "flow qq circle is interrupted", paramBundle);
                        }
                        if (!bool1) {
                          break label2550;
                        }
                        QLog.d("QzoneIPCModule", 1, "flow qq circle failed");
                        paramString.putInt("code", -2);
                        return EIPCResult.createResult(-102, paramString);
                        QLog.d("QzoneIPCModule", 1, "flow qq circle over time");
                        paramString.putInt("code", -3);
                        return EIPCResult.createResult(-102, paramString);
                      }
                      if (localObject1[0] == 0) {
                        break;
                      }
                      QLog.d("QzoneIPCModule", 1, "flow qq circle ok");
                      return EIPCResult.createSuccessResult(null);
                    }
                  }
                  label2550:
                  if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG".equalsIgnoreCase(paramString))
                  {
                    if (QLog.isDevelopLevel()) {
                      QLog.d("[QzoneIPCModule_upload2]QCircle", 4, "ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG to qq_process by QzoneIPCModule");
                    }
                    f(paramBundle, paramInt);
                  }
                  else if ("action_qzone_preload_cm_data".equalsIgnoreCase(paramString))
                  {
                    a(paramBundle, localQQAppInterface);
                  }
                  else if ("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO".equalsIgnoreCase(paramString))
                  {
                    oum.bhL();
                  }
                  else if (("cooperation.qzone.ACTION_QCIRCLE_PUBLISH_REPORT".equalsIgnoreCase(paramString)) && (paramBundle != null))
                  {
                    paramInt = paramBundle.getInt("key_qcircle_report_action_type");
                    int j = paramBundle.getInt("key_qcircle_report_sub_action_type");
                    int k = paramBundle.getInt("key_qcircle_report_thr_action_type");
                    paramString = paramBundle.getString("key_qcircle_report_ext1");
                    paramBundle = paramBundle.getString("key_qcircle_report_ext6");
                    pco.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramInt, j, k, paramString, "", paramBundle, "", "");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  static class a
  {
    private volatile String data;
    private final CountDownLatch latch;
    private volatile String pass;
    private final String text;
    
    private a(String paramString)
    {
      this.text = paramString;
      this.latch = new CountDownLatch(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avre
 * JD-Core Version:    0.7.0.1
 */