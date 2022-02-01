import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.Window;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleUtil.1;
import com.tencent.biz.qqcircle.QCircleUtil.2;
import com.tencent.biz.qqcircle.QCircleUtil.3;
import com.tencent.biz.qqcircle.QCircleUtil.4;
import com.tencent.biz.qqcircle.QCircleUtil.5;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lfeedcloud.FeedCloudMeta.StComment;>;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class uxx
{
  private static final String a = uxx.class.getSimpleName();
  
  public static int a()
  {
    return b(aaaf.a());
  }
  
  public static int a(int paramInt)
  {
    int i = 2;
    if (paramInt == 0) {
      i = 5;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt == 2) {
      return 1;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("https://")) {
        return 0;
      }
      if (paramString.startsWith("mqqapi://")) {
        return 1;
      }
    }
    return -1;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int i = Color.parseColor(paramJSONObject.getString(paramString));
        return i;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static long a()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  public static Bundle a(Bundle paramBundle, String paramString)
  {
    localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("selectedLabel");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          if (localJSONObject != null)
          {
            paramBundle.add(localJSONObject.getString("id"));
            localArrayList.add(localJSONObject.getString("name"));
          }
          i += 1;
        }
      }
      return localBundle;
    }
    catch (Exception paramString)
    {
      QLog.e(a, 1, "jsonToLabel error.", paramString);
      localBundle.putString("key_parse_data_error_msg", paramString.getMessage());
      localBundle.putStringArrayList("key_selected_label_id", paramBundle);
      localBundle.putStringArrayList("key_selected_label_name", localArrayList);
    }
  }
  
  public static QCircleInitBean a(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if ((paramContext.getIntent() != null) && (paramContext.getIntent().hasExtra("key_bundle_common_init_bean"))) {
        return (QCircleInitBean)paramContext.getIntent().getSerializableExtra("key_bundle_common_init_bean");
      }
    }
    return null;
  }
  
  public static QCircleBaseFragment a(Context paramContext)
  {
    if (((paramContext instanceof PublicFragmentActivity)) && ((((PublicFragmentActivity)paramContext).a() instanceof QCircleBaseFragment))) {
      return (QCircleBaseFragment)((QCircleFragmentActivity)paramContext).a();
    }
    return null;
  }
  
  public static AppInterface a(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity)) {
      return ((BaseActivity)paramContext).getAppInterface();
    }
    return null;
  }
  
  public static QQAppInterface a(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext instanceof QQAppInterface)) {
      return (QQAppInterface)paramContext;
    }
    return null;
  }
  
  public static Pair<Integer, Integer> a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    Pair localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    if (paramStFeed != null)
    {
      if (paramStFeed.type.get() == 3)
      {
        int i = ImmersiveUtils.a();
        float f = paramInt1 / paramInt2;
        if (f >= 1.777778F) {
          paramInt1 = (int)(i / 1.777778F);
        }
        for (;;)
        {
          return new Pair(Integer.valueOf(i), Integer.valueOf(paramInt1));
          if ((f > 0.75F) && (f <= 1.777778F)) {
            paramInt1 = (int)(i / f);
          } else {
            paramInt1 = (int)(i / 0.75F);
          }
        }
      }
      if (paramStFeed.type.get() == 2)
      {
        paramStFeed = paramStFeed.images.get();
        paramInt1 = ImmersiveUtils.a();
        if (paramStFeed.size() > 0)
        {
          paramStFeed = (FeedCloudMeta.StImage)paramStFeed.get(0);
          if ((paramStFeed.width.get() != 0) && (paramStFeed.height.get() != 0)) {
            return new Pair(Integer.valueOf(paramInt1), Integer.valueOf((int)(Math.max(Math.min(paramStFeed.height.get() / paramStFeed.width.get(), 1.333333F), 0.5625F) * paramInt1)));
          }
        }
      }
    }
    return localPair;
  }
  
  public static FeedCloudMeta.StComment a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null)
    {
      QLog.e(a, 1, "getSimpleComment param comment is null");
      return null;
    }
    FeedCloudMeta.StComment localStComment = new FeedCloudMeta.StComment();
    localStComment.id.set(paramStComment.id.get());
    if (localStComment.postUser != null)
    {
      paramStComment = new FeedCloudMeta.StUser();
      paramStComment.id.set(localStComment.postUser.id.get());
      localStComment.postUser.set(paramStComment);
      return localStComment;
    }
    QLog.e(a, 1, "getSimpleComment poster is null");
    return localStComment;
  }
  
  public static FeedCloudMeta.StFeed a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e(a, 1, "getSimpleFeed param feed is null");
      return null;
    }
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramStFeed.id.get());
    localStFeed.createTime.set(paramStFeed.createTime.get());
    if (paramStFeed.poster != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramStFeed.poster.id.get());
      localStFeed.poster.set(localStUser);
      return localStFeed;
    }
    QLog.e(a, 1, "getSimpleFeed poster is null");
    return localStFeed;
  }
  
  public static FeedCloudMeta.StLike a(FeedCloudMeta.StLike paramStLike)
  {
    FeedCloudMeta.StLike localStLike = new FeedCloudMeta.StLike();
    if (paramStLike == null) {
      return localStLike;
    }
    try
    {
      localStLike.mergeFrom(paramStLike.toByteArray());
      return localStLike;
    }
    catch (InvalidProtocolBufferMicroException paramStLike)
    {
      paramStLike.printStackTrace();
    }
    return localStLike;
  }
  
  public static FeedCloudMeta.StReply a(FeedCloudMeta.StReply paramStReply)
  {
    FeedCloudMeta.StReply localStReply = new FeedCloudMeta.StReply();
    if (paramStReply == null) {
      return localStReply;
    }
    try
    {
      localStReply.mergeFrom(paramStReply.toByteArray());
      return localStReply;
    }
    catch (InvalidProtocolBufferMicroException paramStReply)
    {
      paramStReply.printStackTrace();
    }
    return localStReply;
  }
  
  public static String a(int paramInt)
  {
    int i;
    if (paramInt < 1) {
      i = 1;
    }
    for (;;)
    {
      return "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qqcircle/user_auth_lv{authTalentLevel}.png".replace("{authTalentLevel}", String.valueOf(i));
      i = paramInt;
      if (paramInt > 8) {
        i = 8;
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    Time localTime1;
    Time localTime2;
    int i;
    StringBuilder localStringBuilder;
    if (paramLong == 0L)
    {
      localObject1 = new Date();
      localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
      localTime1 = new Time();
      localTime1.set(paramLong);
      paramLong = System.currentTimeMillis();
      localTime2 = new Time();
      localTime2.set(paramLong);
      i = localTime2.yearDay - 1;
      localStringBuilder = new StringBuilder().append(" ").append(localTime1.hour).append(":");
      if (localTime1.minute >= 10) {
        break label191;
      }
    }
    label191:
    for (Object localObject1 = "0" + localTime1.minute;; localObject1 = Integer.valueOf(localTime1.minute))
    {
      localObject1 = localObject1;
      if (localTime1.year != localTime2.year) {
        break label358;
      }
      if (localTime2.yearDay >= localTime1.yearDay) {
        break label203;
      }
      return localObject2;
      localObject1 = new Date(paramLong);
      break;
    }
    label203:
    if (localTime2.yearDay == localTime1.yearDay) {
      localObject1 = anni.a(2131718632) + (String)localObject1;
    }
    for (;;)
    {
      return localObject1;
      if (localTime1.yearDay == i)
      {
        localObject1 = anni.a(2131719211) + (String)localObject1;
      }
      else if (localTime1.yearDay + 1 == i)
      {
        localObject1 = anni.a(2131690491) + (String)localObject1;
      }
      else
      {
        localObject1 = localTime1.month + 1 + "-" + localTime1.monthDay + (String)localObject1;
        continue;
        label358:
        localObject1 = localObject2;
      }
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = anni.a(2131697120); paramLong < 1000L; localObject = "W") {
      return String.valueOf(paramLong);
    }
    if (paramLong < 10000L)
    {
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).setMaximumFractionDigits(1);
      ((DecimalFormat)localObject).setGroupingSize(0);
      ((DecimalFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
      return ((DecimalFormat)localObject).format(paramLong / 1000.0D) + "K";
    }
    if (paramLong < 1000000L)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat();
      localDecimalFormat.setMaximumFractionDigits(1);
      localDecimalFormat.setGroupingSize(0);
      localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
      return localDecimalFormat.format(paramLong / 10000.0D) + (String)localObject;
    }
    if (paramLong < 100000000L) {
      return paramLong / 10000L + (String)localObject;
    }
    return "9999" + (String)localObject;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.getUser() != null)) {
      return paramContext.getUser().id.get();
    }
    return "";
  }
  
  public static String a(Bundle paramBundle)
  {
    ArrayList localArrayList1 = paramBundle.getStringArrayList("key_selected_label_id");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("key_selected_label_name");
    paramBundle = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if ((localArrayList1 != null) && (localArrayList2 != null)) {}
    try
    {
      if (localArrayList1.size() == localArrayList2.size())
      {
        int i = 0;
        while (i < localArrayList1.size())
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localArrayList1.get(i));
          localJSONObject.put("name", localArrayList2.get(i));
          localJSONArray.put(localJSONObject);
          i += 1;
        }
      }
      paramBundle.put("selectedLabel", localJSONArray);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(a, 1, "labelToJson error.", localException);
      }
    }
    return paramBundle.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return a(paramList, paramString, "");
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (paramList != null)
    {
      localObject = paramString2;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        do
        {
          localObject = paramString2;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (FeedCloudCommon.Entry)paramList.next();
        } while (!((FeedCloudCommon.Entry)localObject).key.get().equals(paramString1));
        localObject = ((FeedCloudCommon.Entry)localObject).value.get();
      }
    }
    return localObject;
  }
  
  public static List<FeedCloudMeta.StComment> a(String paramString, List<FeedCloudMeta.StComment> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = null;
    Object localObject1 = paramList;
    if (paramList.size() > 0)
    {
      if ((paramList.get(0) != null) && (((FeedCloudMeta.StComment)paramList.get(0)).typeFlag.get() == 1)) {
        ((FeedCloudMeta.StComment)paramList.get(0)).typeFlag.set(0);
      }
      Iterator localIterator = paramList.iterator();
      paramList = localObject2;
      while (localIterator.hasNext())
      {
        localObject1 = (FeedCloudMeta.StComment)localIterator.next();
        if (((FeedCloudMeta.StComment)localObject1).id.get().equals(paramString))
        {
          ((FeedCloudMeta.StComment)localObject1).typeFlag.set(1);
          paramList = (List<FeedCloudMeta.StComment>)localObject1;
        }
        else
        {
          localLinkedList.add(localObject1);
        }
      }
      if (paramList != null) {
        localLinkedList.add(0, paramList);
      }
      localObject1 = localLinkedList;
    }
    return localObject1;
  }
  
  public static QQCircleBase.StUserBusiData a(FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.busiData.get() != null)) {
      try
      {
        QQCircleBase.StUserBusiData localStUserBusiData = new QQCircleBase.StUserBusiData();
        localStUserBusiData.mergeFrom(paramStUser.busiData.get().toByteArray());
        return localStUserBusiData;
      }
      catch (Exception paramStUser)
      {
        paramStUser.printStackTrace();
      }
    }
    return null;
  }
  
  public static QQCircleDitto.StItemContainer a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    QQCircleDitto.StItemContainer localStItemContainer = new QQCircleDitto.StItemContainer();
    if (paramStItemContainer == null) {
      return localStItemContainer;
    }
    try
    {
      localStItemContainer.mergeFrom(paramStItemContainer.toByteArray());
      return localStItemContainer;
    }
    catch (InvalidProtocolBufferMicroException paramStItemContainer) {}
    return localStItemContainer;
  }
  
  public static QQCircleFeedBase.StPolyLike a(String paramString)
  {
    Object localObject = vpp.a().a();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      if (((QQCircleFeedBase.StPolyLike)((List)localObject).get(i)).polyLikeID.get().equals(paramString)) {
        return a((QQCircleFeedBase.StPolyLike)((List)localObject).get(i));
      }
      i += 1;
    }
    localObject = new QQCircleFeedBase.StPolyLike();
    ((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.set(paramString);
    return localObject;
  }
  
  public static QQCircleFeedBase.StPolyLike a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = new QQCircleFeedBase.StPolyLike();
    if (paramStPolyLike == null) {
      return localStPolyLike;
    }
    try
    {
      localStPolyLike.mergeFrom(paramStPolyLike.toByteArray());
      return localStPolyLike;
    }
    catch (InvalidProtocolBufferMicroException paramStPolyLike)
    {
      paramStPolyLike.printStackTrace();
    }
    return localStPolyLike;
  }
  
  public static void a()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleUtil.1());
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, a());
    ImmersiveUtils.a(true, paramActivity.getWindow());
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramActivity = paramActivity.getWindow();
        paramActivity.clearFlags(67108864);
        paramActivity.getDecorView().setSystemUiVisibility(1280);
        paramActivity.addFlags(-2147483648);
        paramActivity.setStatusBarColor(paramInt);
        return;
      }
    } while (Build.VERSION.SDK_INT < 19);
    paramActivity.getWindow().addFlags(67108864);
  }
  
  public static void a(@NonNull Context paramContext)
  {
    ThreadManager.getSubThreadHandler().post(new QCircleUtil.4(paramContext));
  }
  
  public static void a(Context paramContext, FeedCloudMeta.StFeed paramStFeed, zxa<FeedCloudWrite.StDoLikeRsp> paramzxa, boolean paramBoolean)
  {
    int i = 1;
    if (!nmd.a(paramContext))
    {
      QQToast.a(paramContext, anni.a(2131693951), 0).a();
      return;
    }
    try
    {
      paramContext = new QQCircleFeedBase.StLikeBusiData();
      paramContext.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      QQCircleFeedBase.StPolyLike localStPolyLike1 = paramContext.curPolyLikeInfo;
      FeedCloudMeta.StLike localStLike = a(paramStFeed.likeInfo);
      QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData localStDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData();
      localStDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(paramContext.curPolyLikeInfo);
      QQCircleFeedBase.StPolyLike localStPolyLike2 = a("6");
      localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(localStPolyLike2);
      String str = paramContext.curPolyLikeInfo.polyLikeID.get();
      if (TextUtils.isEmpty(str)) {
        a(paramStFeed, 1, localStPolyLike1, localStPolyLike2);
      }
      boolean bool;
      do
      {
        for (;;)
        {
          VSNetworkHelper.a().a(new QCircleDoLikeRequest(paramStFeed, i, localStLike, localStDoLikeReqDoPolyLikeBusiReqData, paramBoolean, false), new uxy(paramzxa));
          return;
          if (str.equals("6")) {
            break;
          }
          i = 2;
          a(paramStFeed, 2, localStPolyLike1, localStPolyLike2);
        }
        bool = paramContext.curPolyLikeInfo.polyLikeID.get().equals("6");
      } while (!bool);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    int j = paramStFeed.likeInfo.count.get();
    int i;
    if (paramInt == 1) {
      i = j + 1;
    }
    for (;;)
    {
      paramStFeed.likeInfo.count.set(i);
      paramStFeed.likeInfo.status.set(paramInt);
      if (paramInt != 0) {
        break;
      }
      zwp.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, new QQCircleFeedBase.StPolyLike(), paramInt, i));
      return;
      i = j;
      if (paramInt == 0) {
        i = j - 1;
      }
    }
    zwp.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, paramStPolyLike2, paramInt, i));
  }
  
  public static void a(ArrayList<QQCircleBase.UserCircleInfo> paramArrayList, int paramInt, String paramString)
  {
    if ((paramArrayList == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localUserCircleInfo = (QQCircleBase.UserCircleInfo)paramArrayList.get(i);
      if ((!paramString.equals(localUserCircleInfo.name.get())) || (localUserCircleInfo.circleTab.get() == 1))
      {
        i += 1;
      }
      else
      {
        localUserCircleInfo.circleTab.set(paramInt);
        return;
      }
    }
    QQCircleBase.UserCircleInfo localUserCircleInfo = new QQCircleBase.UserCircleInfo();
    localUserCircleInfo.name.set(paramString);
    localUserCircleInfo.circleTab.set(paramInt);
    paramArrayList.add(localUserCircleInfo);
  }
  
  public static void a(zws paramzws, List<FeedCloudMeta.StFeed> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localIterator.next();
      if ((localStFeed.type.get() == 3) && (localStFeed != paramList.get(0))) {
        paramzws.a(localStFeed.video);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return a(a(paramContext));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((!(paramContext instanceof BaseActivity)) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return a(((BaseActivity)paramContext).app, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return ((anmw)paramQQAppInterface.getManager(51)).b(paramString);
  }
  
  public static boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return false;
    }
    if (paramStFeed.isRecomFd.get()) {
      return a((FeedCloudMeta.StUser)paramStFeed.recomForward.poster.get());
    }
    return a((FeedCloudMeta.StUser)paramStFeed.poster.get());
  }
  
  public static boolean a(FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStUser.id.get()));
  }
  
  public static boolean a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramString);
  }
  
  public static boolean a(List<Integer> paramList)
  {
    return (paramList != null) && (paramList.contains(Integer.valueOf(1)));
  }
  
  public static int b(int paramInt)
  {
    return (int)((0xFFFFFF & paramInt) * 0.6D) | 0xFF000000;
  }
  
  public static int b(boolean paramBoolean)
  {
    int j = BaseApplicationImpl.getContext().getResources().getColor(2131166233);
    int i = j;
    if (paramBoolean) {
      i = b(j);
    }
    return i;
  }
  
  public static FeedCloudMeta.StComment b(FeedCloudMeta.StComment paramStComment)
  {
    FeedCloudMeta.StComment localStComment = new FeedCloudMeta.StComment();
    if (paramStComment == null) {
      return localStComment;
    }
    try
    {
      localStComment.mergeFrom(paramStComment.toByteArray());
      return localStComment;
    }
    catch (InvalidProtocolBufferMicroException paramStComment)
    {
      paramStComment.printStackTrace();
    }
    return localStComment;
  }
  
  public static FeedCloudMeta.StFeed b(FeedCloudMeta.StFeed paramStFeed)
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    if (paramStFeed == null) {
      return localStFeed;
    }
    try
    {
      localStFeed.mergeFrom(paramStFeed.toByteArray());
      return localStFeed;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return localStFeed;
  }
  
  public static String b(long paramLong)
  {
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    if (paramLong == 0L) {}
    Time localTime;
    int i;
    for (Object localObject1 = new Date();; localObject1 = new Date(paramLong))
    {
      localObject1 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
      localObject2 = new Time();
      ((Time)localObject2).set(paramLong);
      paramLong = System.currentTimeMillis();
      localTime = new Time();
      localTime.set(paramLong);
      i = localTime.yearDay - 1;
      if ((((Time)localObject2).year == localTime.year) && (localTime.yearDay >= ((Time)localObject2).yearDay)) {
        break;
      }
      return localObject1;
    }
    if (localTime.yearDay == ((Time)localObject2).yearDay) {
      return anni.a(2131718632);
    }
    if (((Time)localObject2).yearDay == i) {
      return anni.a(2131719211);
    }
    if (((Time)localObject2).yearDay + 1 == i) {
      return anni.a(2131690491);
    }
    return ((Time)localObject2).month + 1 + "-" + ((Time)localObject2).monthDay;
  }
  
  public static void b()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleUtil.2());
  }
  
  public static void b(@NonNull Context paramContext)
  {
    ThreadManager.getSubThreadHandler().post(new QCircleUtil.5(paramContext));
  }
  
  public static boolean b(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.video.fileId.get()));
  }
  
  public static boolean b(FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (!a(paramStUser)) && ((paramStUser.followState.get() == 1) || (paramStUser.followState.get() == 2));
  }
  
  public static boolean b(List<Integer> paramList)
  {
    return (paramList != null) && (paramList.contains(Integer.valueOf(3)));
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 1: 
      return 4;
    case 5: 
      return 5;
    case 4: 
      return 3;
    }
    return 6;
  }
  
  public static String c(long paramLong)
  {
    Object localObject = new Time();
    ((Time)localObject).set(paramLong);
    paramLong = System.currentTimeMillis();
    new Time().set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder().append(" ").append(((Time)localObject).hour).append(":");
    if (((Time)localObject).minute < 10) {}
    for (localObject = "0" + ((Time)localObject).minute;; localObject = Integer.valueOf(((Time)localObject).minute)) {
      return localObject;
    }
  }
  
  public static void c()
  {
    ThreadManager.getSubThreadHandler().post(new QCircleUtil.3());
  }
  
  public static boolean c(FeedCloudMeta.StUser paramStUser)
  {
    paramStUser = a(paramStUser);
    return (paramStUser != null) && (paramStUser.certification.get() == 1);
  }
  
  public static boolean c(List<Integer> paramList)
  {
    return (paramList != null) && (paramList.contains(Integer.valueOf(4)));
  }
  
  public static String d(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static void d()
  {
    vja.b();
    vtj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */