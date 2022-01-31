import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class txm
{
  private final QQAppInterface a;
  
  public txm(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new NullPointerException("appInterface is null");
    }
    this.a = paramQQAppInterface;
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    if ((paramInt1 != 2) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("shareGroupType is error, type=" + paramInt1);
    }
    begr localbegr = begr.a(paramContext);
    localbegr.a(ajjy.a(2131634085), 5);
    localbegr.a(ajjy.a(2131634083) + sfm.a + ajjy.a(2131634084), 5);
    localbegr.c(2131625035);
    localbegr.a(new txn(this, localbegr, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    urk.d("AddVideoController", "addVideoByRecord %s %s %s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    vjq localvjq = vjq.a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("entrance_type", 102);
    localBundle.putInt("shareGroupType", paramInt1);
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    if (paramInt1 == 1) {
      localBundle.putLong("groupUin", paramLong);
    }
    localBundle.putBoolean("ignorePersonalPublish", paramBoolean);
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      localvjq.a(paramContext, localBundle, paramInt2);
      paramContext.overridePendingTransition(2130772217, 2130772038);
      return;
    }
    localvjq.a(paramContext, localBundle);
  }
  
  public void b(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    urk.d("AddVideoController", "addVideoByExist %s %s", new Object[] { paramString1, paramString2 });
    Bundle localBundle = new Bundle();
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    StoryTransitionActivity.a(paramContext, txo.class.getName(), localBundle, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txm
 * JD-Core Version:    0.7.0.1
 */