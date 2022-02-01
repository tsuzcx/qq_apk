import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class rar
{
  public static final String DEPARTMENT = ppf.getString(2131701924);
  public static ConcurrentHashMap<Class, Integer> cj;
  private static HashMap<String, String> fw = new HashMap();
  private static final List<String> ow = Arrays.asList(new String[] { "time_openshoot", "time_waitshoot", "clk_mode", "start_shoot", "time_shoot", "time_openedit", "time_edit", "clk_function", "time_composite" });
  
  static
  {
    cj = new ConcurrentHashMap();
    cj.put(EditVideoActivity.class, Integer.valueOf(1));
    cj.put(QQStoryMainActivity.class, Integer.valueOf(3));
    cj.put(StoryDetailActivity.class, Integer.valueOf(4));
    cj.put(QQStoryMemoriesActivity.class, Integer.valueOf(5));
    cj.put(StoryMessageListActivity.class, Integer.valueOf(6));
    cj.put(QQStoryShareGroupProfileActivity.class, Integer.valueOf(11));
    cj.put(TroopStoryMainActivity.class, Integer.valueOf(12));
    cj.put(QQStoryWatcherListActivity.class, Integer.valueOf(13));
    cj.put(LocalVideoSelectActivity.class, Integer.valueOf(17));
  }
  
  public static void R(int paramInt, long paramLong)
  {
    paramLong = SystemClock.uptimeMillis() - paramLong;
    if (paramLong > 86400000L) {
      return;
    }
    a("home_page", "time_stay_new", paramInt, (int)paramLong, new String[0]);
  }
  
  public static int a(FeedItem paramFeedItem)
  {
    int i = 3;
    if (paramFeedItem == null) {
      return 0;
    }
    switch (paramFeedItem.type)
    {
    case 4: 
    default: 
      return 1;
    case 1: 
      paramFeedItem = (QQUserUIItem)paramFeedItem.getOwner();
      if (TextUtils.equals(QQStoryContext.a().getCurrentUid(), paramFeedItem.uid)) {
        return 4;
      }
      if (paramFeedItem.getRelationType() == 0) {
        return 1;
      }
      if (paramFeedItem.getRelationType() == 2) {
        return 3;
      }
      if (paramFeedItem.isSubscribe()) {
        return 2;
      }
      return 4;
    case 2: 
      paramFeedItem = (ShareGroupItem)paramFeedItem.getOwner();
      if (paramFeedItem.getRelationType() == 2) {
        return i;
      }
      if (paramFeedItem.isPublic()) {}
      for (i = 6;; i = 5) {
        break;
      }
    case 3: 
      return 7;
    case 5: 
      return 9;
    case 6: 
      return 10;
    }
    return 11;
  }
  
  public static int a(Class<? extends QQStoryBaseActivity> paramClass, int paramInt)
  {
    paramClass = (Integer)cj.get(paramClass);
    if (paramClass == null) {
      return paramInt;
    }
    return paramClass.intValue();
  }
  
  public static int a(@Nullable String paramString, VideoListFeedItem paramVideoListFeedItem)
  {
    puh localpuh = null;
    if (!TextUtils.isEmpty(paramString)) {
      localpuh = puy.a(QQStoryContext.a()).d(paramString);
    }
    if (localpuh != null)
    {
      if (localpuh.nodeType == 12) {
        return 12;
      }
      if (localpuh.nodeType == 13) {
        return 13;
      }
    }
    return a(paramVideoListFeedItem);
  }
  
  @Deprecated
  public static int a(ptq paramptq)
  {
    if (paramptq == null) {
      return 4;
    }
    switch (paramptq.getRelationType())
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  @NonNull
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForStructing paramMessageForStructing, String paramString)
  {
    if (paramMessageForStructing == null) {}
    do
    {
      do
      {
        AbsStructMsg localAbsStructMsg;
        do
        {
          return;
          localAbsStructMsg = paramMessageForStructing.structingMsg;
        } while ((localAbsStructMsg == null) || (TextUtils.isEmpty(localAbsStructMsg.mMsg_A_ActionData)));
        paramContext = aqik.c(paramQQAppInterface, paramContext, localAbsStructMsg.mMsg_A_ActionData);
      } while (paramContext == null);
      paramQQAppInterface = paramContext.getAttribute("usertype");
      paramContext = paramContext.getAttribute("unionid");
    } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(paramContext)));
    try
    {
      i = Integer.parseInt(paramQQAppInterface);
      a("share_uin_obj", paramString, apuh.jP(paramMessageForStructing.istroop), i, new String[] { paramContext });
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, String... paramVarArgs)
  {
    if ((paramInt1 == 10002) || (paramInt1 == 10000) || (paramInt1 == 10001) || (!paramBoolean) || (paramInt1 == axcg.p.getId()) || (paramInt1 == axcg.e.getId()))
    {
      a("video_shoot_new", paramString, paramInt1, paramInt2, paramVarArgs);
      if (ow.contains(paramString))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("op_type", "video_shoot_new");
        localHashMap.put("op_name", String.valueOf(paramString));
        localHashMap.put("op_result", String.valueOf(paramInt2));
        localHashMap.put("op_r1", a(0, paramVarArgs));
        localHashMap.put("op_r2", a(1, paramVarArgs));
        localHashMap.put("op_r3", a(2, paramVarArgs));
        localHashMap.put("op_r4", a(3, paramVarArgs));
        paramString = "video_shoot_new_" + paramString;
        anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    a(paramString, paramInt1, paramInt2, true, paramVarArgs);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (ram.isColorLevel()) {
        ram.d("StoryReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label80:
      anot.a(null, "dc00899", DEPARTMENT, "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public static void a(String paramString1, String paramString2, Intent paramIntent, String... paramVarArgs)
  {
    if (paramIntent == null) {
      return;
    }
    int i;
    if (paramIntent != null)
    {
      EditVideoParams localEditVideoParams = (EditVideoParams)paramIntent.getParcelableExtra(EditVideoParams.class.getName());
      if (localEditVideoParams != null) {
        i = localEditVideoParams.getIntExtra("extra_ablum_type", -1);
      }
    }
    for (;;)
    {
      i = dZ(i);
      paramIntent = new String[paramVarArgs.length + 1];
      paramIntent[0] = (i + "");
      System.arraycopy(paramVarArgs, 0, paramIntent, 1, paramVarArgs.length);
      a(paramString1, paramString2, 0, 0, paramIntent);
      return;
      i = paramIntent.getIntExtra("extra_ablum_type", -1);
      continue;
      i = -1;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (ram.isColorLevel()) {
        ram.d("StoryReportor", "[department]%s;[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label86:
      anot.a(null, "dc00899", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label86;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (paramVarArgs != null)
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        localHashMap.put("op_r" + (i + 1), paramVarArgs[i]);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.StoryReportor", 2, new Object[] { "780, reportToBeacon, ", paramString, ", isSuc:", Boolean.valueOf(paramBoolean), " duration:", Long.valueOf(paramLong), " eventValue:", localHashMap.toString() });
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static int b(FeedItem paramFeedItem)
  {
    if (paramFeedItem == null) {
      return 0;
    }
    int i;
    switch (paramFeedItem.type)
    {
    case 4: 
    default: 
      return 0;
    case 1: 
    case 3: 
    case 5: 
      if (paramFeedItem.getOwner().isMe()) {}
      for (i = 1;; i = 2) {
        return i;
      }
    }
    paramFeedItem = (ShareGroupItem)paramFeedItem.getOwner();
    if (paramFeedItem.isOwner())
    {
      i = 1;
      if (i != 1) {
        break label110;
      }
      i = 3;
    }
    for (;;)
    {
      return i;
      if (paramFeedItem.isSubscribe())
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      label110:
      if (i == 2) {
        i = 4;
      } else if (i == 3) {
        i = 5;
      } else {
        i = 0;
      }
    }
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    int i;
    if ((paramActivity instanceof QIMCameraCaptureActivity))
    {
      i = ea(paramActivity.getIntent().getIntExtra("edit_video_type", 10002));
      if ((i == 10002) || (i == 10000)) {
        a("video_shoot_new", paramString1, i, 0, new String[] { paramString2, paramString3 });
      }
    }
    do
    {
      do
      {
        return;
      } while ((!(paramActivity instanceof EditVideoActivity)) && (!(paramActivity instanceof EditPicActivity)));
      i = paramActivity.getIntent().getIntExtra("capture_operation_in", -1);
    } while ((i != 10002) && (i != 10000));
    a("video_edit_new", paramString1, i, 0, new String[] { paramString2, paramString3 });
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (paramInt1 == 1) {
      a("video_edit_new", paramString, 0, paramInt2, paramVarArgs);
    }
    if ((paramInt1 == 10000) || (paramInt1 == 10001)) {
      a("video_edit_new", paramString, paramInt1, paramInt2, paramVarArgs);
    }
    if (ow.contains(paramString))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("op_type", "video_edit_new");
      localHashMap.put("op_name", String.valueOf(paramString));
      localHashMap.put("op_result", String.valueOf(paramInt2));
      localHashMap.put("op_r1", a(0, paramVarArgs));
      localHashMap.put("op_r2", a(1, paramVarArgs));
      localHashMap.put("op_r3", a(2, paramVarArgs));
      localHashMap.put("op_r4", a(3, paramVarArgs));
      paramString = "video_edit_new_" + paramString;
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (ram.isColorLevel()) {
        ram.d("StoryReportor", "Dev[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label80:
      anot.a(null, "dc00899", "grp_story_engineer", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  private static void b(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    for (paramMap = "事件Code : " + paramString2 + "   上报内容 ----------  \n"; localIterator.hasNext(); paramMap = paramMap + "\n")
    {
      paramString2 = (Map.Entry)localIterator.next();
      paramMap = paramMap + (String)paramString2.getKey();
      paramMap = paramMap + "   :   ";
      paramMap = paramMap + (String)paramString2.getValue();
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static String bX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 10: 
      return "1";
    case 11: 
      return "3";
    case 210: 
      return "2";
    case 211: 
      return "4";
    case 220: 
      return "2";
    case 221: 
      return "4";
    case 23: 
      return "2";
    case 12: 
      return "5";
    case 222: 
      return "6";
    }
    return "5";
  }
  
  public static String bY(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 7: 
    case 8: 
    default: 
      return "";
    case 1: 
      return "1";
    case 2: 
      return "2";
    case 5: 
      return "3";
    case 4: 
      return "4";
    case 6: 
      return "6";
    case 9: 
      return "9";
    }
    return "0";
  }
  
  public static String c(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return "";
    }
    if (paramStoryVideoItem.getPollLayout() == null) {
      return "5";
    }
    boolean bool = paramStoryVideoItem.isMine();
    int i;
    if (paramStoryVideoItem.mPollResult != -1) {
      i = 1;
    }
    while (bool) {
      if (i != 0)
      {
        return "2";
        i = 0;
      }
      else
      {
        return "1";
      }
    }
    if (i != 0) {
      return "4";
    }
    return "3";
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (ram.isColorLevel()) {
        ram.d("StoryReportor", "Dev[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      label80:
      anot.a(null, "dc00899", "PGC_story", "", paramString1, paramString2, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public static void cy(String paramString1, String paramString2)
  {
    fw.put(paramString1, paramString2);
  }
  
  public static void d(int paramInt, long paramLong, String paramString)
  {
    paramLong = SystemClock.uptimeMillis() - paramLong;
    if (paramLong > 86400000L) {
      return;
    }
    a("home_page", "time_stay_new", paramInt, (int)paramLong, new String[] { paramString });
  }
  
  public static boolean d(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 >= paramLong2) && (paramLong1 <= paramLong3);
  }
  
  public static int dZ(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return 6;
    case 1: 
      return 1;
    case 2: 
      return 3;
    case 3: 
      return 5;
    case 4: 
      return 4;
    }
    return 2;
  }
  
  public static int ea(int paramInt)
  {
    switch (paramInt)
    {
    case 10003: 
    case 10004: 
    case 10006: 
    case 10007: 
    case 10008: 
    case 10009: 
    case 10010: 
    case 10011: 
    case 10015: 
    case 10016: 
    default: 
      return 0;
    case 10012: 
      return 2;
    case 10013: 
    case 10017: 
      return 3;
    case 10001: 
      return 4;
    case 10000: 
      return 5;
    }
    return 1;
  }
  
  public static void g(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("op_r1", a(0, paramVarArgs));
    localHashMap.put("op_r2", a(1, paramVarArgs));
    b(localHashMap, "reportALUMB", paramString);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, null);
  }
  
  public static String gc(String paramString)
  {
    return (String)fw.get(paramString);
  }
  
  public static String getNetworkType(Context paramContext)
  {
    int i = 4;
    int j = aqiw.getSystemNetwork(paramContext);
    if (j == 1) {}
    for (;;)
    {
      return "" + i;
      if (j == 2) {
        i = 1;
      } else if (j == 3) {
        i = 2;
      } else if (j == 4) {
        i = 3;
      } else {
        i = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rar
 * JD-Core Version:    0.7.0.1
 */