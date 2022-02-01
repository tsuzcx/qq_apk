import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequestException;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.7;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class vij
  extends vhx<vjm>
  implements vjl
{
  private static String jdField_b_of_type_JavaLangString = "";
  private static String jdField_c_of_type_JavaLangString = "";
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString = "";
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public vij()
  {
    this.jdField_a_of_type_Long = -1L;
    c("");
  }
  
  private String a(StringBuilder paramStringBuilder)
  {
    String str = "";
    if (paramStringBuilder.length() > 1)
    {
      str = paramStringBuilder.substring(0, paramStringBuilder.length() - 1);
      vmp.g("WSRecommendFragmentPresenter", "[getRepetitiveFeedIds] repetitive feedIds:" + str);
    }
    return str;
  }
  
  private String a(HashSet<String> paramHashSet)
  {
    Object localObject = "";
    if (paramHashSet.size() > 0)
    {
      localObject = new StringBuilder();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext()) {
        ((StringBuilder)localObject).append((String)paramHashSet.next()).append("_");
      }
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
      vmp.g("WSRecommendFragmentPresenter", "[getRepetitiveTraceIds] repetitive traceIds:" + (String)localObject);
    }
    return localObject;
  }
  
  private void a(FollowEvent paramFollowEvent, List<stSimpleMetaFeed> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if ((localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramFollowEvent.getPersonId()))) {
        localstSimpleMetaFeed.poster.followStatus = paramFollowEvent.getIsFollow();
      }
    }
  }
  
  private void a(LikeRspEvent paramLikeRspEvent, uyd paramuyd, List<stSimpleMetaFeed> paramList)
  {
    int j = 0;
    int i = 0;
    stSimpleMetaFeed localstSimpleMetaFeed;
    for (;;)
    {
      if (i < paramList.size())
      {
        localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(i);
        if (!TextUtils.equals(localstSimpleMetaFeed.id, paramLikeRspEvent.getFeedId()))
        {
          i += 1;
        }
        else if (paramLikeRspEvent.getRspIsDing() != localstSimpleMetaFeed.is_ding)
        {
          if (localstSimpleMetaFeed.is_ding == 1) {
            j = 1;
          }
          if (j == 0) {
            break label111;
          }
        }
      }
    }
    label111:
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      localstSimpleMetaFeed.is_ding = paramLikeRspEvent.getRspIsDing();
      paramuyd.notifyItemChanged(i);
      return;
    }
  }
  
  private void a(WSAddCommentEvent paramWSAddCommentEvent, List<stSimpleMetaFeed> paramList)
  {
    vmp.b("WSRecommendFragmentPresenter", "WSAddCommentEvent feedId = " + paramWSAddCommentEvent.getFeedId() + "; position = " + paramWSAddCommentEvent.getPosition() + "; num = " + paramWSAddCommentEvent.getCommentNum());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (TextUtils.equals(localstSimpleMetaFeed.id, paramWSAddCommentEvent.getFeedId())) {
        localstSimpleMetaFeed.total_comment_num = ((int)paramWSAddCommentEvent.getCommentNum());
      }
    }
  }
  
  public static void a(String paramString, int paramInt, byte paramByte1, byte paramByte2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, vfg paramvfg)
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
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      c(jdField_b_of_type_JavaLangString);
    }
    paramString = new vfr(new vli(paramString, paramByte1, paramByte2, localArrayList, paramInt, jdField_b_of_type_JavaLangString, "", jdField_c_of_type_JavaLangString, paramList), null, paramvfg, 1001);
    vfk.a().a(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    vmp.b("WSRecommendFragmentPresenter", "doPlanDefaultLoad");
    a(false, true, false, paramString);
    a(false, paramBoolean);
  }
  
  private void a(Throwable paramThrowable, vfr paramvfr, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    a(paramvfr, paramBoolean1, paramBoolean2, paramLong);
    paramvfr = (vjm)a();
    if (paramvfr == null) {
      return;
    }
    if ((paramThrowable instanceof WeishiRequestException))
    {
      paramThrowable = (WeishiRequestException)paramThrowable;
      paramvfr.a(paramThrowable.code, paramThrowable.msg, paramBoolean1, paramBoolean2);
      return;
    }
    paramvfr.a(-1, paramThrowable.getMessage(), paramBoolean1, paramBoolean2);
  }
  
  private void a(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber, int paramInt, String paramString)
  {
    WeishiRequestException localWeishiRequestException = new WeishiRequestException();
    localWeishiRequestException.code = paramInt;
    localWeishiRequestException.msg = paramString;
    paramSubscriber.onError(localWeishiRequestException);
  }
  
  private void a(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber, vfr paramvfr, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramvfr.a())
    {
      if (((paramvfr.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        b(paramSubscriber, paramvfr, paramLong, paramBoolean1, paramBoolean2);
        return;
      }
      a(paramSubscriber, paramvfr.b, anvx.a(2131716364));
      vkk.a().a(this.jdField_a_of_type_Long, paramvfr.jdField_a_of_type_Vfo, -1, "数据无法解析或为空");
      return;
    }
    a(paramSubscriber, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
    vkk.a().a(this.jdField_a_of_type_Long, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
  }
  
  private void a(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber, boolean paramBoolean1, boolean paramBoolean2, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp)
  {
    ArrayList localArrayList = paramstSimpleGetFeedListRsp.feeds;
    a(paramBoolean1, paramBoolean2, localArrayList);
    pws.b((stSimpleMetaFeed)localArrayList.get(0));
    vnd.a(localArrayList);
    vmp.e("WSRecommendFragmentPresenter", "[handleFeedResponseActivityNotFinish] size:" + localArrayList.size());
    stSimpleMetaFeed localstSimpleMetaFeed = vmg.a(localArrayList);
    pws localpws = vnd.a();
    if ((localpws != null) && (localstSimpleMetaFeed != null)) {
      localpws.a(localstSimpleMetaFeed);
    }
    d(paramstSimpleGetFeedListRsp.session);
    paramSubscriber.onNext(localArrayList);
  }
  
  private void a(vfr paramvfr, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    vmp.b("WSRecommendFragmentPresenter", "[handleFeedResponse] onTaskResponse-resultCode:" + paramvfr.b + " | resultBean:" + paramvfr.jdField_a_of_type_JavaLangObject + " | thread" + Thread.currentThread().getName());
    this.jdField_c_of_type_Boolean = true;
    Observable.create(new vip(this, paramvfr, paramLong, paramBoolean1, paramBoolean2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new vin(this, paramBoolean1, paramBoolean2, paramBoolean3), new vio(this, paramvfr, paramBoolean1, paramBoolean2, paramLong));
  }
  
  private void a(vfr paramvfr, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
      vkf.a(302, new Object[] { Integer.valueOf(paramvfr.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
    }
    WSPublicAccReport.getInstance().reportFallListRequest(paramBoolean1, paramBoolean2, paramvfr.jdField_a_of_type_Int, "", "");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    vmp.d("WSRecommendFragmentPresenter", "getCacheData");
    uzf.a().a(new vil(this, paramBoolean1, paramBoolean2));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    Object localObject2 = new ArrayList(paramArrayList);
    Object localObject1 = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject2).next();
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(localstSimpleMetaFeed.id))
      {
        vmp.d("WSRecommendFragmentPresenter", "[filterRepetitiveFeedList] removeFromList feedId:" + localstSimpleMetaFeed.id + ", traceId:" + localstSimpleMetaFeed.traceId + ", title:" + localstSimpleMetaFeed.feed_desc);
        localStringBuilder.append(localstSimpleMetaFeed.id).append("_");
        ((HashSet)localObject1).add(localstSimpleMetaFeed.traceId);
        paramArrayList.remove(localstSimpleMetaFeed);
      }
      else if (!TextUtils.isEmpty(localstSimpleMetaFeed.id))
      {
        vmp.e("WSRecommendFragmentPresenter", "[filterRepetitiveFeedList] addToHashSet feedId:" + localstSimpleMetaFeed.id + ", traceId:" + localstSimpleMetaFeed.traceId + ", title:" + localstSimpleMetaFeed.feed_desc);
        this.jdField_a_of_type_JavaUtilHashSet.add(localstSimpleMetaFeed.id);
      }
    }
    paramArrayList = a(localStringBuilder);
    localObject1 = a((HashSet)localObject1);
    WSPublicAccReport.getInstance().reportFallListRequest(paramBoolean1, paramBoolean2, 0, paramArrayList, (String)localObject1);
  }
  
  private static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    try
    {
      paramJSONObject1.put("deep_link_version", 1);
      paramJSONObject2.put("device_info", paramJSONObject1);
      jdField_b_of_type_JavaLangString = paramJSONObject2.toString();
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      acho.d("WSRecommendFragmentPresenter", "onResult", paramJSONObject1);
    }
  }
  
  private void b(Subscriber<? super ArrayList<stSimpleMetaFeed>> paramSubscriber, vfr paramvfr, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    vfh localvfh = paramvfr.jdField_a_of_type_Vfh;
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject;
    if (localvfh != null)
    {
      vmp.e("WSRecommendFragmentPresenter", "[handleFeedResponseForSuccess] onLoadDataSuccess AbTestId = " + localvfh.jdField_a_of_type_JavaLangString);
      vkc.a().a(localstSimpleGetFeedListRsp.trace_id, localvfh.jdField_a_of_type_JavaUtilMap);
    }
    this.jdField_b_of_type_Boolean = localstSimpleGetFeedListRsp.is_finished;
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
    vmp.e("WSRecommendFragmentPresenter", "[handleFeedResponseForSuccess] 请求瀑布流耗时：" + this.jdField_a_of_type_Long + "毫秒");
    vkk.a().a(this.jdField_a_of_type_Long, paramvfr.jdField_a_of_type_Vfo, "feeds", paramBoolean1);
    if (paramBoolean1)
    {
      vau.a().a(1, localstSimpleGetFeedListRsp.config);
      vau.a().b(localstSimpleGetFeedListRsp.config);
      vkk.a().c(true, this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_JavaLangString = ((stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject).attach_info;
    if (c())
    {
      a(paramSubscriber, 333333, "当前页面已销毁");
      return;
    }
    a(paramSubscriber, paramBoolean1, paramBoolean2, localstSimpleGetFeedListRsp);
  }
  
  private void c()
  {
    vmp.b("WSRecommendFragmentPresenter", "doPlanRedDotPreload");
    a(true, true);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        jdField_b_of_type_JavaLangString = paramString.toString();
        String str = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty(str))
        {
          b(new JSONObject(str), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        acho.d("WSRecommendFragmentPresenter", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSRecommendFragmentPresenter.7());
      return;
      jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  private boolean c()
  {
    Object localObject = (vjm)a();
    if (!(localObject instanceof WSRecommendFragment)) {
      return true;
    }
    localObject = (WSRecommendFragment)localObject;
    if ((((WSRecommendFragment)localObject).getActivity() != null) && (((WSRecommendFragment)localObject).getActivity().isFinishing())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void d(String paramString)
  {
    jdField_c_of_type_JavaLangString = paramString;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = (vjm)a();
    if (localObject != null)
    {
      localObject = ((vjm)localObject).b();
      if ((localObject instanceof uyd)) {
        break label27;
      }
    }
    label27:
    List localList;
    do
    {
      do
      {
        return;
        localObject = (uyd)localObject;
        localList = ((uyd)localObject).b();
      } while (localList == null);
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        a((LikeRspEvent)paramWSSimpleBaseEvent, (uyd)localObject, localList);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        a((FollowEvent)paramWSSimpleBaseEvent, localList);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof WSAddCommentEvent));
    a((WSAddCommentEvent)paramWSSimpleBaseEvent, localList);
  }
  
  public void a(String paramString)
  {
    paramString = new vfr(new vlb(paramString), this.jdField_a_of_type_AndroidOsHandler, new vik(this), 2001);
    vfk.a().a(paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(paramBoolean1, paramBoolean2, false, paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    long l = System.currentTimeMillis();
    if (a() == null) {
      return;
    }
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)a();
    if ((paramBoolean2) && (!paramBoolean3)) {
      localWSRecommendFragment.c();
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
        str1 = localWSRecommendFragment.a();
        vmp.d("WSAioLog", "rowKey:" + str1 + ", magActionData:" + paramString);
        localObject2 = vnd.a();
        str2 = vnd.jdField_a_of_type_JavaLangString;
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject1 = ((pws)localObject2).c();
          }
        }
        vmp.a("WSAioLog", "getFeedList lastFeedId:" + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = paramString;
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    vmp.a("WSRecommendFragmentPresenter", "[getFeedList] getFeedList isFirstFromService:" + paramBoolean2 + ", contentFeedIds:" + localArrayList);
    paramString = this.jdField_a_of_type_JavaLangString;
    byte b1;
    if (paramBoolean1)
    {
      i = 1;
      b1 = (byte)i;
      if (!paramBoolean2) {
        break label348;
      }
    }
    label348:
    for (int i = 1;; i = 0)
    {
      paramString = new vfr(new vli(paramString, b1, (byte)i, localArrayList, 1, jdField_b_of_type_JavaLangString, str1, jdField_c_of_type_JavaLangString, (String)localObject1), this.jdField_a_of_type_AndroidOsHandler, new vim(this, paramBoolean2, l, paramBoolean1, paramBoolean3), 1001);
      vfk.a().a(paramString);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString)
  {
    boolean bool = false;
    pws localpws = vnd.a();
    if (localpws != null) {
      bool = vnd.a(localpws);
    }
    vmp.b("WSRecommendFragmentPresenter", "isFromWeiShiPush = " + bool);
    if ((bool) && (uzf.a().a()) && (uzf.a().a() >= 8) && (uzf.a().b()))
    {
      c();
      return;
    }
    a(paramString, bool);
  }
  
  public boolean b()
  {
    return !this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vij
 * JD-Core Version:    0.7.0.1
 */