import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stWaterFallItemStrategy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.holder.WSGridCardPresenter.2;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class vdo
{
  private vdk a;
  
  public vdo(vdk paramvdk)
  {
    this.a = paramvdk;
  }
  
  private int a()
  {
    return vau.a().a(1);
  }
  
  private String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null)
    {
      String str = "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id;
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed.weishi_jump_url)) {
        str = paramstSimpleMetaFeed.weishi_jump_url;
      }
      return str;
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt1, String paramString, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        int i = a();
        vmp.d("WSGridCardPresenter", "open weishi scheme = " + paramString + ", weishi_jump_url = " + paramstSimpleMetaFeed.weishi_jump_url);
        vmr.a(paramContext.getApplicationContext(), "biz_src_jc_gzh_weishi", paramString, 1, i, paramInt2);
        if (i == 2) {
          vjx.a(paramstSimpleMetaFeed, paramInt1, 1000);
        }
        vjx.a(1, 114, paramInt1, paramstSimpleMetaFeed, null);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        vmp.d("WSGridCardPresenter", "open weishi error scheme = " + paramString);
        return;
      }
      paramString = a(paramstSimpleMetaFeed);
    }
  }
  
  private void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    localWSDownloadParams.mEventId = 501;
    localWSDownloadParams.mTestId = vkf.b();
    localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
    vbq.a((Activity)paramContext, localWSDownloadParams, false);
  }
  
  private String b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id + "&logsour=2020020032";
    }
    return "";
  }
  
  private void b(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (TextUtils.equals("wifi", DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase())) {
      c(paramContext, paramInt, paramstSimpleMetaFeed);
    }
    for (;;)
    {
      vjx.a(paramstSimpleMetaFeed, paramInt, 1001);
      return;
      if (vau.a().a()) {
        c(paramContext, paramInt, paramstSimpleMetaFeed);
      } else {
        vmp.a("WSGridCardPresenter", "B test do not download when 4g is not open is server");
      }
    }
  }
  
  private void c(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i = vau.a().c(1);
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = a();
    Activity localActivity;
    if (i < 10000)
    {
      i = 104;
      localWSDownloadParams.mEventId = i;
      localWSDownloadParams.mTestId = vkf.b();
      localWSDownloadParams.mScheme = a(paramstSimpleMetaFeed);
      localObject = this.a.a();
      localActivity = (Activity)paramContext;
      if (localObject == null) {
        break label154;
      }
      paramContext = ((uyd)localObject).a();
      label98:
      if (localObject == null) {
        break label159;
      }
    }
    label154:
    label159:
    for (Object localObject = ((uyd)localObject).a();; localObject = null)
    {
      vbq.a(localActivity, localWSDownloadParams, paramContext, (RockDownloadListenerWrapper)localObject);
      vjx.a(1, 115, paramInt, paramstSimpleMetaFeed, vbq.a(localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId));
      return;
      i = 100;
      break;
      paramContext = null;
      break label98;
    }
  }
  
  private void d(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.video != null)
    {
      stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo != null) && (!TextUtils.isEmpty(localstH5OpInfo.h5Url)))
      {
        pqx.a(paramContext, localstH5OpInfo.h5Url);
        vkf.a(140, localstH5OpInfo.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
        vjx.a(140, 9, null);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000004, paramstSimpleMetaFeed);
      }
    }
  }
  
  public void a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str2 = paramstSimpleMetaFeed.id;
    String str3 = paramstSimpleMetaFeed.poster_id;
    if (paramstSimpleMetaFeed.poster != null) {}
    for (String str1 = paramstSimpleMetaFeed.poster.nick;; str1 = "")
    {
      vjx.a(str2, str3, str1, paramstSimpleMetaFeed.feed_desc, paramInt, 112, 1, 0);
      vkf.a(true);
      if ((paramContext instanceof BaseActivity))
      {
        paramContext = bhey.a(((BaseActivity)paramContext).app, paramContext, paramstSimpleMetaFeed.video_url + "&click_index=" + (paramInt + 1));
        if (paramContext != null) {
          paramContext.a();
        }
        avvy.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
        avvy.b = paramstSimpleMetaFeed.feed_desc;
        avvy.jdField_a_of_type_Int = paramInt;
      }
      return;
    }
  }
  
  public void a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramArrayList.add(paramstSimpleMetaFeed);
    this.a.a().c = (paramInt - 0);
    WSVerticalPageFragment.a(paramContext, "recommend_tab", "feeds", paramArrayList, 0);
    if ((paramInt == 0) && (paramstSimpleMetaFeed.video_type == 7))
    {
      vkf.a(141, paramstSimpleMetaFeed.id);
      return;
    }
    vkf.a(112, Integer.valueOf(2));
  }
  
  public void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    int i;
    Object localObject2;
    String str1;
    int j;
    String str2;
    String str3;
    String str4;
    if (paramstSimpleMetaFeed.h5_op_info != null)
    {
      vkf.a(112, paramstSimpleMetaFeed.h5_op_info.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
      i = paramstSimpleMetaFeed.h5_op_info.type;
      localObject2 = paramstSimpleMetaFeed.map_pass_back;
      str1 = paramstSimpleMetaFeed.id;
      j = paramstSimpleMetaFeed.video.duration;
      str2 = paramstSimpleMetaFeed.poster_id;
      str3 = paramstSimpleMetaFeed.poster.nick;
      str4 = paramstSimpleMetaFeed.feed_desc;
      if (paramstSimpleMetaFeed.bt_style != null) {
        break label215;
      }
    }
    label215:
    for (Object localObject1 = "";; localObject1 = paramstSimpleMetaFeed.bt_style.title)
    {
      vjx.a(i, (Map)localObject2, str1, j, str2, str3, str4, paramInt, "", (String)localObject1, paramstSimpleMetaFeed.h5_op_info.id);
      str1 = paramstSimpleMetaFeed.h5_op_info.h5Url;
      localObject2 = paramstSimpleMetaFeed.h5_op_info.scheme_url;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty(str1)))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (((String)localObject2).startsWith("weishi://")) {}
        }
      }
      else
      {
        localObject1 = b(paramstSimpleMetaFeed);
      }
      vnd.a(paramContext, (String)localObject1, str1, "", paramstSimpleMetaFeed.h5_op_info.type, new vdp(this, paramContext, paramInt, paramstSimpleMetaFeed));
      return;
    }
  }
  
  public boolean a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i;
    uyd localuyd;
    if (a() == 2)
    {
      i = 1;
      if (i != 0)
      {
        localuyd = this.a.a();
        if (localuyd != null) {
          break label40;
        }
      }
    }
    label40:
    boolean bool2;
    label79:
    int j;
    label245:
    do
    {
      boolean bool1;
      do
      {
        return false;
        i = 0;
        break;
        stWaterFallItemStrategy localstWaterFallItemStrategy = paramstSimpleMetaFeed.waterFallItemStrategy;
        if ((localstWaterFallItemStrategy == null) || (!localstWaterFallItemStrategy.isCallWeishi)) {
          break label294;
        }
        bool1 = true;
        if ((localstWaterFallItemStrategy == null) || (!localstWaterFallItemStrategy.isDonwloadWeish)) {
          break label300;
        }
        bool2 = true;
        i = vau.a().b(1);
        j = vau.a().c(1);
        if (!zfn.a(BaseApplicationImpl.getApplication())) {
          break label321;
        }
        bool2 = vau.a().a(1);
        vmp.d("WSGridCardPresenter", "openCallWeishi = " + bool1 + ", isOpenVideoPage = " + bool2 + ", callCount = " + i + ", openCallWSCount = " + localuyd.jdField_a_of_type_Int);
        vkf.a(112, Integer.valueOf(114));
        WSPublicAccReport.getInstance().feedsItemReport("gzh_click", paramstSimpleMetaFeed, vjx.a(paramstSimpleMetaFeed, paramInt), 1000003);
      } while ((!bool1) || (localuyd.jdField_a_of_type_Int >= i));
      localuyd.jdField_a_of_type_Int += 1;
      if (i < 10000)
      {
        i = 104;
        if (bool2) {
          a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed);
        }
        a(paramContext, paramInt, paramstSimpleMetaFeed.weishi_jump_url, paramstSimpleMetaFeed, i);
        if (!bool2) {
          break label313;
        }
      }
      for (i = 143;; i = 142)
      {
        vjx.a(paramstSimpleMetaFeed, paramInt, i);
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label79;
        i = 100;
        break label245;
      }
      vmp.d("WSGridCardPresenter", "openDownloadWeishi = " + bool2 + ", downloadCount = " + j + ", openDownloadWSCount = " + uyd.b);
      vkf.a(112, Integer.valueOf(115));
      WSPublicAccReport.getInstance().feedsItemReport("gzh_click", paramstSimpleMetaFeed, vjx.a(paramstSimpleMetaFeed, paramInt), 1000002);
    } while ((!bool2) || (uyd.b >= j));
    label294:
    label300:
    label313:
    label321:
    a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed);
    ThreadManager.getUIHandler().postDelayed(new WSGridCardPresenter.2(this, paramContext, paramInt, paramstSimpleMetaFeed), 50L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdo
 * JD-Core Version:    0.7.0.1
 */