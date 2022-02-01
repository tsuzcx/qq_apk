import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.4;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class omc
  extends olr<omy.b>
  implements omy.a
{
  private static String aqt = "";
  private static String aqu = "";
  private String attachInfo = "";
  private boolean axK;
  private boolean axL;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  public long zf = -1L;
  
  public omc()
  {
    setGdtArgs("");
  }
  
  private stSimpleMetaFeed a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    int i = paramArrayList.size() - 1;
    while (i > 0)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(i);
      if (!TextUtils.isEmpty(localstSimpleMetaFeed.feed_desc)) {
        return localstSimpleMetaFeed;
      }
      i -= 1;
    }
    return (stSimpleMetaFeed)paramArrayList.get(paramArrayList.size() - 1);
  }
  
  public static void a(String paramString, int paramInt, byte paramByte1, byte paramByte2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, oko paramoko)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "";
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((stSimpleMetaFeed)paramList.next()).id);
      }
    }
    paramList = str;
    if (paramWSRedDotPushMsg != null) {
      paramList = paramWSRedDotPushMsg.mMsgData;
    }
    if (TextUtils.isEmpty(aqt)) {
      setGdtArgs(aqt);
    }
    paramString = new okz(new onz(paramString, paramByte1, paramByte2, localArrayList, paramInt, aqt, "", aqu, paramList), null, paramoko, 1001);
    oks.a().b(paramString);
  }
  
  private void a(okz paramokz, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      this.zf = (System.currentTimeMillis() - paramLong);
      ong.n(302, new Object[] { Integer.valueOf(paramokz.bfj), Long.valueOf(this.zf) });
    }
  }
  
  private void a(okz paramokz, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    ooz.d("WSRecommendFragmentPresenter", "onTaskResponse-resultCode:" + paramokz.mResultCode + " | resultBean:" + paramokz.bb + " | thread" + Thread.currentThread().getName());
    this.axL = true;
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)b();
    if ((localWSRecommendFragment == null) || (localWSRecommendFragment.getActivity().isFinishing())) {
      return;
    }
    if (paramokz.succeeded())
    {
      if (((paramokz.bb instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramokz.bb).feeds != null) && (((stSimpleGetFeedListRsp)paramokz.bb).feeds.size() > 0))
      {
        okp localokp = paramokz.a;
        stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramokz.bb;
        if (paramokz.a != null) {
          ohy.a().f(localstSimpleGetFeedListRsp.trace_id, paramokz.a.mapExt);
        }
        this.zf = (System.currentTimeMillis() - paramLong);
        ooz.i("weishi-beacon", "请求瀑布流耗时：" + this.zf + "毫秒");
        onk.a().a(true, this.zf, "feeds", 1, "feeds", paramBoolean1);
        if (paramBoolean1)
        {
          ohy.a().a(localstSimpleGetFeedListRsp.config, "global_key_recommend");
          onk.a().t(true, this.zf);
          if (ogd.GI()) {
            oiv.a().b(new WSUserAuthEvent());
          }
        }
        this.attachInfo = ((stSimpleGetFeedListRsp)paramokz.bb).attach_info;
        paramokz = localstSimpleGetFeedListRsp.feeds;
        cc(paramokz);
        cd(paramokz);
        ooz.d("WSRecommendFragmentPresenter", "size=" + paramokz.size());
        stSimpleMetaFeed localstSimpleMetaFeed = a(paramokz);
        ooz.d("WSRecommendFragmentPresenter", "lastfeed desc:" + localstSimpleMetaFeed.feed_desc + ",videoUrl:" + localstSimpleMetaFeed.video_url);
        if ((localWSRecommendFragment.getActivity() != null) && (!localWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((lcr)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        pN(localstSimpleGetFeedListRsp.session);
        if (!localstSimpleGetFeedListRsp.is_finished) {}
        for (boolean bool = true;; bool = false)
        {
          localWSRecommendFragment.a(paramokz, localokp, paramBoolean1, paramBoolean2, bool, paramBoolean3);
          return;
        }
      }
      a(paramokz, paramBoolean1, paramLong);
      return;
    }
    localWSRecommendFragment.c(paramokz.bfj, paramokz.msg, paramBoolean1, paramBoolean2);
    a(paramokz, paramBoolean1, paramLong);
  }
  
  private void aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    ooz.e("WSRecommendFragmentPresenter", "getCacheData");
    ogr.a().a(new ome(this, paramBoolean1, paramBoolean2));
  }
  
  private void aq(String paramString, boolean paramBoolean)
  {
    ooz.d("WSRecommendFragmentPresenter", "doPlanDefaultLoad");
    a(false, true, false, paramString);
    aj(false, paramBoolean);
  }
  
  private void bfN()
  {
    ooz.d("WSRecommendFragmentPresenter", "doPlanRedDotPreload");
    aj(true, true);
  }
  
  private void cc(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (paramArrayList.size() == 0) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return;
        paramArrayList = (stSimpleMetaFeed)paramArrayList.get(0);
      } while ((paramArrayList == null) || (paramArrayList.map_pass_back == null) || (paramArrayList.map_pass_back.size() != 0));
      arrayOfByte = aqhq.readFile(((lcr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).jm());
    } while (arrayOfByte == null);
    ooz.i("weishi-report", "load map passback length:" + arrayOfByte.length);
    ooz.d("weishi-report", "load map passback:" + opn.bytesToHexString(arrayOfByte));
    paramArrayList.map_pass_back.put(Integer.valueOf(1), arrayOfByte);
    paramArrayList.map_ext.put("recmd_feed_key", new Gson().toJson(paramArrayList.map_pass_back));
  }
  
  private void cd(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.next();
        localstSimpleMetaFeed.feed_desc = opn.fz(localstSimpleMetaFeed.feed_desc);
      }
    }
  }
  
  private static void d(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    try
    {
      paramJSONObject1.put("deep_link_version", 1);
      paramJSONObject2.put("device_info", paramJSONObject1);
      aqt = paramJSONObject2.toString();
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      tkw.e("WSRecommendFragmentPresenter", "onResult", paramJSONObject1);
    }
  }
  
  public static void pN(String paramString)
  {
    aqu = paramString;
  }
  
  public static void setGdtArgs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        aqt = paramString.toString();
        String str = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty(str))
        {
          d(new JSONObject(str), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        tkw.e("WSRecommendFragmentPresenter", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSRecommendFragmentPresenter.4());
      return;
      aqt = paramString;
    }
  }
  
  public boolean Hc()
  {
    return this.axK;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    long l = System.currentTimeMillis();
    if (b() == null) {
      return;
    }
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)b();
    if ((paramBoolean2) && (!paramBoolean3)) {
      localWSRecommendFragment.showLoading(true);
    }
    String str2 = "";
    Object localObject2 = "";
    ArrayList localArrayList = new ArrayList();
    String str1 = str2;
    Object localObject1 = localObject2;
    if (paramBoolean2)
    {
      str1 = str2;
      localObject1 = localObject2;
      if (!paramBoolean1)
      {
        str1 = localWSRecommendFragment.getRowKey();
        ooz.e("WSAioLog", "rowKey:" + str1 + ", magActionData:" + paramString);
        localObject2 = opn.a();
        str2 = opn.ara;
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject1 = ((lcr)localObject2).jn();
          }
        }
        ooz.i("WSAioLog", "getFeedList lastFeedId:" + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = paramString;
      }
    }
    if (paramBoolean1) {
      this.attachInfo = "";
    }
    ooz.i("WSAioLog", "getFeedList isFirstFromService:" + paramBoolean2 + ", contentFeedIds:" + localArrayList);
    paramString = this.attachInfo;
    byte b;
    if (paramBoolean1)
    {
      i = 1;
      b = (byte)i;
      if (!paramBoolean2) {
        break label350;
      }
    }
    label350:
    for (int i = 1;; i = 0)
    {
      paramString = new okz(new onz(paramString, b, (byte)i, localArrayList, 1, aqt, str1, aqu, (String)localObject1), this.mHandler, new omf(this, paramBoolean2, l, paramBoolean1, paramBoolean3), 1001);
      oks.a().b(paramString);
      return;
      i = 0;
      break;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(paramBoolean1, paramBoolean2, false, paramString);
  }
  
  public long dr()
  {
    return this.zf;
  }
  
  public void pL(String paramString)
  {
    paramString = new okz(new onu(paramString), this.mHandler, new omd(this), 2001);
    oks.a().b(paramString);
  }
  
  public void pM(String paramString)
  {
    boolean bool = false;
    lcr locallcr = opn.a();
    if (locallcr != null) {
      bool = opn.a(locallcr);
    }
    ooz.d("WSRecommendFragmentPresenter", "isFromWeiShiPush = " + bool);
    if ((bool) && (ogr.a().GJ()) && (ogr.a().ro() >= 8) && (ogr.a().GK()))
    {
      bfN();
      return;
    }
    aq(paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omc
 * JD-Core Version:    0.7.0.1
 */