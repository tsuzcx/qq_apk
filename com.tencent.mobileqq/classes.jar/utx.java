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
import com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.6;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class utx
  extends utm<uuz>
  implements uuy
{
  private static String jdField_b_of_type_JavaLangString = "";
  private static String jdField_c_of_type_JavaLangString = "";
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public utx()
  {
    this.jdField_a_of_type_Long = -1L;
    c("");
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
  
  private void a(LikeRspEvent paramLikeRspEvent, ukg paramukg, List<stSimpleMetaFeed> paramList)
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
      paramukg.notifyItemChanged(i);
      return;
    }
  }
  
  private void a(WSAddCommentEvent paramWSAddCommentEvent, List<stSimpleMetaFeed> paramList)
  {
    uya.b("WSRecommendFragmentPresenter", "WSAddCommentEvent feedId = " + paramWSAddCommentEvent.getFeedId() + "; position = " + paramWSAddCommentEvent.getPosition() + "; num = " + paramWSAddCommentEvent.getCommentNum());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (TextUtils.equals(localstSimpleMetaFeed.id, paramWSAddCommentEvent.getFeedId())) {
        localstSimpleMetaFeed.total_comment_num = ((int)paramWSAddCommentEvent.getCommentNum());
      }
    }
  }
  
  public static void a(String paramString, int paramInt, byte paramByte1, byte paramByte2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, uqy paramuqy)
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
    paramString = new urj(new uwt(paramString, paramByte1, paramByte2, localArrayList, paramInt, jdField_b_of_type_JavaLangString, "", jdField_c_of_type_JavaLangString, paramList), null, paramuqy, 1001);
    urc.a().a(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    uya.b("WSRecommendFragmentPresenter", "doPlanDefaultLoad");
    a(false, true, false, paramString);
    a(false, paramBoolean);
  }
  
  private void a(urj paramurj, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
      uvr.a(302, new Object[] { Integer.valueOf(paramurj.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void a(urj paramurj, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    uya.b("WSRecommendFragmentPresenter", "onTaskResponse-resultCode:" + paramurj.b + " | resultBean:" + paramurj.jdField_a_of_type_JavaLangObject + " | thread" + Thread.currentThread().getName());
    this.jdField_c_of_type_Boolean = true;
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)a();
    if ((localWSRecommendFragment == null) || (localWSRecommendFragment.getActivity().isFinishing())) {
      return;
    }
    Observable.create(new uuc(this, paramurj, paramLong, paramBoolean1, localWSRecommendFragment)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new uub(this, localWSRecommendFragment, paramBoolean1, paramBoolean2, paramurj, paramLong, paramBoolean3));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    uya.d("WSRecommendFragmentPresenter", "getCacheData");
    ulf.a().a(new utz(this, paramBoolean1, paramBoolean2));
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
      abrl.d("WSRecommendFragmentPresenter", "onResult", paramJSONObject1);
    }
  }
  
  private void c()
  {
    uya.b("WSRecommendFragmentPresenter", "doPlanRedDotPreload");
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
        abrl.d("WSRecommendFragmentPresenter", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSRecommendFragmentPresenter.6());
      return;
      jdField_b_of_type_JavaLangString = paramString;
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
    Object localObject;
    if (a() != null)
    {
      localObject = ((uuz)a()).b();
      if ((localObject instanceof ukg)) {
        break label28;
      }
    }
    label28:
    List localList;
    do
    {
      do
      {
        return;
        localObject = (ukg)localObject;
        localList = ((ukg)localObject).a();
      } while (localList == null);
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        a((LikeRspEvent)paramWSSimpleBaseEvent, (ukg)localObject, localList);
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
    paramString = new urj(new uwm(paramString), this.jdField_a_of_type_AndroidOsHandler, new uty(this), 2001);
    urc.a().a(paramString);
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
        uya.d("WSAioLog", "rowKey:" + str1 + ", magActionData:" + paramString);
        localObject2 = uyo.a();
        str2 = uyo.jdField_a_of_type_JavaLangString;
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject1 = ((plv)localObject2).c();
          }
        }
        uya.a("WSAioLog", "getFeedList lastFeedId:" + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = paramString;
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    uya.a("WSAioLog", "getFeedList isFirstFromService:" + paramBoolean2 + ", contentFeedIds:" + localArrayList);
    paramString = this.jdField_a_of_type_JavaLangString;
    byte b1;
    if (paramBoolean1)
    {
      i = 1;
      b1 = (byte)i;
      if (!paramBoolean2) {
        break label349;
      }
    }
    label349:
    for (int i = 1;; i = 0)
    {
      paramString = new urj(new uwt(paramString, b1, (byte)i, localArrayList, 1, jdField_b_of_type_JavaLangString, str1, jdField_c_of_type_JavaLangString, (String)localObject1), this.jdField_a_of_type_AndroidOsHandler, new uua(this, paramBoolean2, l, paramBoolean1, paramBoolean3), 1001);
      urc.a().a(paramString);
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
    plv localplv = uyo.a();
    if (localplv != null) {
      bool = uyo.a(localplv);
    }
    uya.b("WSRecommendFragmentPresenter", "isFromWeiShiPush = " + bool);
    if ((bool) && (ulf.a().a()) && (ulf.a().a() >= 8) && (ulf.a().b()))
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
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */