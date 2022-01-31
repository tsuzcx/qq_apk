import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
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

public class tip
  extends tie<tjm>
  implements tjl
{
  private static String jdField_b_of_type_JavaLangString = "";
  private static String c = "";
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  public tip()
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
  
  public static void a(String paramString, int paramInt, byte paramByte1, byte paramByte2, WSRedDotPushMsg paramWSRedDotPushMsg, List<stSimpleMetaFeed> paramList, tgt paramtgt)
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
      c("");
    }
    paramString = new the(new tkn(paramString, paramByte1, paramByte2, localArrayList, paramInt, jdField_b_of_type_JavaLangString, "", c, paramList), null, paramtgt, 1001);
    tgx.a().a(paramString);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    tlo.b("WSRecommendFragmentPresenter", "doPlanDefaultLoad");
    a(false, true, false, paramString);
    a(false, paramBoolean);
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
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
      arrayOfByte = bdcs.a(((oye)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).b());
    } while (arrayOfByte == null);
    tlo.a("weishi-report", "load map passback length:" + arrayOfByte.length);
    tlo.b("weishi-report", "load map passback:" + tlv.a(arrayOfByte));
    paramArrayList.map_pass_back.put(Integer.valueOf(1), arrayOfByte);
    paramArrayList.map_ext.put("recmd_feed_key", new Gson().toJson(paramArrayList.map_pass_back));
  }
  
  private void a(the paramthe, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
      tju.a(302, new Object[] { Integer.valueOf(paramthe.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void a(the paramthe, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    tlo.b("WSRecommendFragmentPresenter", "onTaskResponse-resultCode:" + paramthe.b + " | resultBean:" + paramthe.jdField_a_of_type_JavaLangObject + " | thread" + Thread.currentThread().getName());
    this.jdField_b_of_type_Boolean = true;
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)a();
    if ((localWSRecommendFragment == null) || (localWSRecommendFragment.getActivity().isFinishing())) {
      return;
    }
    if (paramthe.a())
    {
      if (((paramthe.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
      {
        tgu localtgu = paramthe.jdField_a_of_type_Tgu;
        stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject;
        if (paramthe.jdField_a_of_type_Tgu != null) {
          tee.a().a(localstSimpleGetFeedListRsp.trace_id, paramthe.jdField_a_of_type_Tgu.a);
        }
        if (paramBoolean1)
        {
          tee.a().a(localstSimpleGetFeedListRsp.config);
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
          tlo.b("weishi-report", "请求瀑布流耗时：" + this.jdField_a_of_type_Long + "毫秒");
          tjz.a().b(true, this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_JavaLangString = ((stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject).attach_info;
        paramthe = localstSimpleGetFeedListRsp.feeds;
        a(paramthe);
        b(paramthe);
        tlo.b("WSRecommendFragmentPresenter", "size=" + paramthe.size());
        stSimpleMetaFeed localstSimpleMetaFeed = a(paramthe);
        tlo.b("WSRecommendFragmentPresenter", "lastfeed desc:" + localstSimpleMetaFeed.feed_desc + ",videoUrl:" + localstSimpleMetaFeed.video_url);
        if ((localWSRecommendFragment.getActivity() != null) && (!localWSRecommendFragment.getActivity().isFinishing()))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localQQAppInterface != null) {
            ((oye)localQQAppInterface.getManager(274)).a(localstSimpleMetaFeed);
          }
        }
        d(localstSimpleGetFeedListRsp.session);
        if (!localstSimpleGetFeedListRsp.is_finished) {}
        for (;;)
        {
          localWSRecommendFragment.a(paramthe, localtgu, paramBoolean1, paramBoolean2, bool, paramBoolean3);
          return;
          bool = false;
        }
      }
      localWSRecommendFragment.a(paramthe.b, alpo.a(2131717392), paramBoolean1, paramBoolean2);
      a(paramthe, paramBoolean1, paramLong);
      return;
    }
    localWSRecommendFragment.a(paramthe.jdField_a_of_type_Int, paramthe.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
    a(paramthe, paramBoolean1, paramLong);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    tlo.d("WSRecommendFragmentPresenter", "getCacheData");
    tcq.a().a(new tir(this, paramBoolean1, paramBoolean2));
  }
  
  private void b(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.next();
        localstSimpleMetaFeed.feed_desc = tlv.a(localstSimpleMetaFeed.feed_desc);
      }
    }
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
      aanp.d("WSRecommendFragmentPresenter", "onResult", paramJSONObject1);
    }
  }
  
  private void c()
  {
    tlo.b("WSRecommendFragmentPresenter", "doPlanRedDotPreload");
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
        aanp.d("WSRecommendFragmentPresenter", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSRecommendFragmentPresenter.4());
      return;
      jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public static void d(String paramString)
  {
    c = paramString;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(String paramString)
  {
    paramString = new the(new tki(paramString), this.jdField_a_of_type_AndroidOsHandler, new tiq(this), 2001);
    tgx.a().a(paramString);
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
      localWSRecommendFragment.a(true);
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
        tlo.d("WSAioLog", "rowKey:" + str1 + ", magActionData:" + paramString);
        localObject2 = tlv.a();
        str2 = tlv.jdField_a_of_type_JavaLangString;
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject1 = str2;
          if (TextUtils.isEmpty(str2)) {
            localObject1 = ((oye)localObject2).c();
          }
        }
        tlo.a("WSAioLog", "getFeedList lastFeedId:" + (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
        localObject1 = paramString;
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    tlo.a("WSAioLog", "getFeedList isFirstFromService:" + paramBoolean2 + ", contentFeedIds:" + localArrayList);
    paramString = this.jdField_a_of_type_JavaLangString;
    byte b1;
    if (paramBoolean1)
    {
      i = 1;
      b1 = (byte)i;
      if (!paramBoolean2) {
        break label350;
      }
    }
    label350:
    for (int i = 1;; i = 0)
    {
      paramString = new the(new tkn(paramString, b1, (byte)i, localArrayList, 1, jdField_b_of_type_JavaLangString, str1, c, (String)localObject1), this.jdField_a_of_type_AndroidOsHandler, new tis(this, paramBoolean2, l, paramBoolean1, paramBoolean3), 1001);
      tgx.a().a(paramString);
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
    oye localoye = tlv.a();
    if (localoye != null) {
      bool = tlv.a(localoye);
    }
    tlo.b("WSRecommendFragmentPresenter", "isFromWeiShiPush = " + bool);
    if ((bool) && (tcq.a().a()) && (tcq.a().a() >= 8) && (tcq.a().b()))
    {
      c();
      return;
    }
    a(paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tip
 * JD-Core Version:    0.7.0.1
 */