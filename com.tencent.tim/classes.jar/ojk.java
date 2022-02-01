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

public class ojk
{
  public static stSimpleMetaFeed e;
  private ojh.a a;
  
  public ojk(ojh.a parama)
  {
    this.a = parama;
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
        int i = rx();
        ooz.e("WSGridCardPresenter", "open weishi scheme = " + paramString + ", weishi_jump_url = " + paramstSimpleMetaFeed.weishi_jump_url);
        opb.a(paramContext.getApplicationContext(), "biz_src_jc_gzh_weishi", paramString, 1, i, paramInt2);
        if (i == 2) {
          ond.b(paramstSimpleMetaFeed, paramInt1, 1000);
        }
        ond.a(1, 114, paramInt1, paramstSimpleMetaFeed, null);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        ooz.e("WSGridCardPresenter", "open weishi error scheme = " + paramString);
        return;
      }
      paramString = b(paramstSimpleMetaFeed);
    }
  }
  
  private void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = rx();
    localWSDownloadParams.mEventId = 501;
    localWSDownloadParams.mTestId = ong.lD();
    localWSDownloadParams.mScheme = b(paramstSimpleMetaFeed);
    oir.a((Activity)paramContext, localWSDownloadParams, false);
  }
  
  private String b(stSimpleMetaFeed paramstSimpleMetaFeed)
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
  
  private void b(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (TextUtils.equals("wifi", DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase())) {
      c(paramContext, paramInt, paramstSimpleMetaFeed);
    }
    for (;;)
    {
      ond.b(paramstSimpleMetaFeed, paramInt, 1001);
      return;
      if (ohy.a().GM()) {
        c(paramContext, paramInt, paramstSimpleMetaFeed);
      } else {
        ooz.i("WSGridCardPresenter", "B test do not download when 4g is not open is server");
      }
    }
  }
  
  private String c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id + "&logsour=2020020032";
    }
    return "";
  }
  
  private void c(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i = ohy.a().rr();
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = rx();
    Activity localActivity;
    if (i < 10000)
    {
      i = 104;
      localWSDownloadParams.mEventId = i;
      localWSDownloadParams.mTestId = ong.lD();
      localWSDownloadParams.mScheme = b(paramstSimpleMetaFeed);
      localObject = this.a.a();
      localActivity = (Activity)paramContext;
      if (localObject == null) {
        break label153;
      }
      paramContext = ((ofv)localObject).a();
      label97:
      if (localObject == null) {
        break label158;
      }
    }
    label153:
    label158:
    for (Object localObject = ((ofv)localObject).a();; localObject = null)
    {
      oir.a(localActivity, localWSDownloadParams, paramContext, (RockDownloadListenerWrapper)localObject);
      ond.a(1, 115, paramInt, paramstSimpleMetaFeed, oir.e(localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId));
      return;
      i = 100;
      break;
      paramContext = null;
      break label97;
    }
  }
  
  private void d(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.video != null)
    {
      stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo != null) && (!TextUtils.isEmpty(localstH5OpInfo.h5Url)))
      {
        kxm.C(paramContext, localstH5OpInfo.h5Url);
        ong.q(140, localstH5OpInfo.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
        ond.a(140, 9, null);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000004, paramstSimpleMetaFeed);
      }
    }
  }
  
  private int rx()
  {
    return ohy.a().rp();
  }
  
  public void a(Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str2 = paramstSimpleMetaFeed.id;
    String str3 = paramstSimpleMetaFeed.poster_id;
    if (paramstSimpleMetaFeed.poster != null) {}
    for (String str1 = paramstSimpleMetaFeed.poster.nick;; str1 = "")
    {
      ond.a(str2, str3, str1, paramstSimpleMetaFeed.feed_desc, paramInt, 112, 1, 0);
      ong.qS(true);
      if ((paramContext instanceof BaseActivity))
      {
        paramContext = aqik.c(((BaseActivity)paramContext).app, paramContext, paramstSimpleMetaFeed.video_url + "&click_index=" + (paramInt + 1));
        if (paramContext != null) {
          paramContext.ace();
        }
        aigh.feedId = paramstSimpleMetaFeed.id;
        aigh.title = paramstSimpleMetaFeed.feed_desc;
        aigh.upos = paramInt;
      }
      return;
    }
  }
  
  public void a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    e = paramstSimpleMetaFeed;
    paramArrayList.add(paramstSimpleMetaFeed);
    this.a.a().beM = (paramInt - 0);
    WSVerticalPageFragment.a(paramContext, "recommend_tab", "feeds", paramArrayList, 0);
    if ((paramInt == 0) && (paramstSimpleMetaFeed.video_type == 7))
    {
      ong.n(141, paramstSimpleMetaFeed.id);
      return;
    }
    ong.n(112, Integer.valueOf(2));
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
      ong.q(112, paramstSimpleMetaFeed.h5_op_info.type, paramInt, paramstSimpleMetaFeed.h5_op_info.id);
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
      ond.a(i, (Map)localObject2, str1, j, str2, str3, str4, paramInt, "", (String)localObject1, paramstSimpleMetaFeed.h5_op_info.id);
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
        localObject1 = c(paramstSimpleMetaFeed);
      }
      opn.a(paramContext, (String)localObject1, str1, "", paramstSimpleMetaFeed.h5_op_info.type, new ojl(this, paramContext, paramInt, paramstSimpleMetaFeed));
      return;
    }
  }
  
  public boolean a(Context paramContext, int paramInt, ArrayList<stSimpleMetaFeed> paramArrayList, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i;
    if (rx() == 2) {
      i = 1;
    }
    while (i != 0)
    {
      ofv localofv = this.a.a();
      if (localofv == null)
      {
        return false;
        i = 0;
      }
      else
      {
        stWaterFallItemStrategy localstWaterFallItemStrategy = paramstSimpleMetaFeed.waterFallItemStrategy;
        boolean bool1;
        boolean bool2;
        label79:
        int j;
        if ((localstWaterFallItemStrategy != null) && (localstWaterFallItemStrategy.isCallWeishi))
        {
          bool1 = true;
          if ((localstWaterFallItemStrategy == null) || (!localstWaterFallItemStrategy.isDonwloadWeish)) {
            break label301;
          }
          bool2 = true;
          i = ohy.a().rq();
          j = ohy.a().rr();
          if (!rpw.isWeishiInstalled(BaseApplicationImpl.getApplication())) {
            break label322;
          }
          bool2 = ohy.a().GN();
          ooz.e("WSGridCardPresenter", "openCallWeishi = " + bool1 + ", isOpenVideoPage = " + bool2 + ", callCount = " + i + ", openCallWSCount = " + localofv.beK);
          ong.n(112, Integer.valueOf(114));
          WSPublicAccReport.getInstance().feedsItemReport("gzh_click", opn.getSceneTypeTestId(1), paramstSimpleMetaFeed, ond.a(paramstSimpleMetaFeed, paramInt), 1000003);
          if ((!bool1) || (localofv.beK >= i)) {
            break;
          }
          localofv.beK += 1;
          if (i >= 10000) {
            break label307;
          }
          i = 104;
          label246:
          if (bool2) {
            a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed);
          }
          a(paramContext, paramInt, paramstSimpleMetaFeed.weishi_jump_url, paramstSimpleMetaFeed, i);
          if (!bool2) {
            break label314;
          }
        }
        label301:
        label307:
        label314:
        for (i = 143;; i = 142)
        {
          ond.b(paramstSimpleMetaFeed, paramInt, i);
          return true;
          bool1 = false;
          break;
          bool2 = false;
          break label79;
          i = 100;
          break label246;
        }
        label322:
        ooz.e("WSGridCardPresenter", "openDownloadWeishi = " + bool2 + ", downloadCount = " + j + ", openDownloadWSCount = " + ofv.beL);
        ong.n(112, Integer.valueOf(115));
        WSPublicAccReport.getInstance().feedsItemReport("gzh_click", opn.getSceneTypeTestId(1), paramstSimpleMetaFeed, ond.a(paramstSimpleMetaFeed, paramInt), 1000002);
        if ((bool2) && (ofv.beL < j))
        {
          a(paramContext, paramInt, paramArrayList, paramstSimpleMetaFeed);
          ThreadManager.getUIHandler().postDelayed(new WSGridCardPresenter.2(this, paramContext, paramInt, paramstSimpleMetaFeed), 50L);
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojk
 * JD-Core Version:    0.7.0.1
 */