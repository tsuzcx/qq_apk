import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tencent.biz.qqstory.playvideo.entrance.MemorySelectVideoPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class xho
{
  public static void a(Activity paramActivity, OpenPlayerBuilder.Data paramData)
  {
    a(paramActivity, paramData, null);
  }
  
  public static void a(Activity paramActivity, Serializable paramSerializable, int paramInt, @Nullable View paramView)
  {
    paramSerializable = new OpenPlayerBuilder(paramSerializable, paramInt).a();
    paramSerializable.mReportData.startActivityTimeStamp = SystemClock.uptimeMillis();
    Intent localIntent = new Intent(paramActivity, StoryPlayerActivity.class);
    localIntent.putExtra("story_data", paramSerializable);
    if (paramView != null) {
      localIntent.putExtra("AnimationParam", new AnimationParam(paramView));
    }
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    a(paramActivity, new OpenPlayerBuilder(new SingleFeedPlayInfo(paramString, paramString, "", 1), paramInt).a(), null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = new OpenPlayerBuilder(new VidListPlayInfo(paramString2, paramString1), paramInt).a();
    paramString1.mUIStyle.mPlayerRepeatMode = 1;
    b(paramActivity, paramString1);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, @Nullable View paramView)
  {
    ShareFromMemoryPlayInfo localShareFromMemoryPlayInfo = new ShareFromMemoryPlayInfo();
    localShareFromMemoryPlayInfo.uid = paramString1;
    localShareFromMemoryPlayInfo.feedId = paramString2;
    localShareFromMemoryPlayInfo.identify = paramInt1;
    localShareFromMemoryPlayInfo.videoListOrder = paramInt3;
    localShareFromMemoryPlayInfo.shareFromType = paramInt2;
    xfe.a(localShareFromMemoryPlayInfo, new xhq(localShareFromMemoryPlayInfo, paramInt2, paramActivity, paramView));
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, @Nullable View paramView)
  {
    ShareFromMemoryPlayInfo localShareFromMemoryPlayInfo = new ShareFromMemoryPlayInfo();
    localShareFromMemoryPlayInfo.uid = paramString1;
    localShareFromMemoryPlayInfo.feedId = paramString3;
    localShareFromMemoryPlayInfo.identify = paramInt3;
    localShareFromMemoryPlayInfo.shareFromType = paramInt2;
    localShareFromMemoryPlayInfo.collectionKey = paramString2;
    localShareFromMemoryPlayInfo.shareTimeZone = paramInt1;
    xfe.a(localShareFromMemoryPlayInfo, new xhr(localShareFromMemoryPlayInfo, paramInt2, paramActivity, paramView));
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, ArrayList<String> paramArrayList1, int paramInt1, int paramInt2, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, View paramView, boolean paramBoolean, int paramInt3, String paramString3)
  {
    paramString1 = new OpenPlayerBuilder(new MemorySelectVideoPlayInfo(paramString1, (String)paramArrayList2.get(paramInt1), paramString2, paramString3, paramArrayList1, paramBoolean, 0), paramInt3).d().e().a().b().a(false).a();
    paramString1.mBundle.putStringArrayList("EXTRA_VIDEO_ID_LIST", paramArrayList3);
    paramString1.mBundle.putInt("EXTRA_INT_MAX_SELECT_COUNT", 20);
    a(paramActivity, paramString1, paramView);
  }
  
  public static void a(Context paramContext, OpenPlayerBuilder.Data paramData, @Nullable View paramView)
  {
    paramData.mReportData.startActivityTimeStamp = SystemClock.uptimeMillis();
    Intent localIntent = new Intent(paramContext, StoryPlayerActivity.class);
    localIntent.putExtra("story_data", paramData);
    if (paramView != null) {
      localIntent.putExtra("AnimationParam", new AnimationParam(paramView));
    }
    paramContext.startActivity(localIntent);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramString1, paramString1, paramString2, 1, true), 31).a();
    paramString1.mReportData.startActivityTimeStamp = SystemClock.uptimeMillis();
    paramString2 = new Intent(paramContext, StoryPlayerActivity.class);
    paramString2.putExtra("story_data", paramString1);
    paramString2.addFlags(268435456);
    paramContext.startActivity(paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = new OpenPlayerBuilder(new VidListPlayInfo(paramString2, paramString1), paramInt).a();
    paramString1.mUIStyle.mPlayerRepeatMode = 1;
    a(paramContext, paramString1, null);
  }
  
  public static void b(Activity paramActivity, OpenPlayerBuilder.Data paramData)
  {
    paramData.mReportData.startActivityTimeStamp = SystemClock.uptimeMillis();
    Intent localIntent = new Intent(paramActivity, StoryPlayerActivity.class);
    localIntent.putExtra("story_data", paramData);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771981, 2130771983);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    StoryVideoItem localStoryVideoItem = ((wpj)wpm.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (localStoryVideoItem.mInteractStatus != -1) && (new File(localStoryVideoItem.mLocalVideoPath).length() > 0L))
    {
      paramString1 = new OpenPlayerBuilder(new VidListPlayInfo(paramString2, paramString1), paramInt).a();
      paramString2 = paramString1.mUIStyle;
      if (localStoryVideoItem.mInteractStatus == 1) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramString2.bottomWidgetShowFlag = paramInt;
        paramString1.mUIStyle.mPlayerRepeatMode = 1;
        a(paramContext, paramString1, null);
        return;
      }
    }
    xfe.a(xfe.a(), paramString1, new xhp(paramString2, paramString1, paramInt, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xho
 * JD-Core Version:    0.7.0.1
 */