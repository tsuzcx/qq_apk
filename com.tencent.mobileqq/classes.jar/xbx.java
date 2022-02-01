import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class xbx
{
  private final QQAppInterface a;
  
  public xbx(QQAppInterface paramQQAppInterface)
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
    bjnw localbjnw = bjnw.a(paramContext);
    localbjnw.a(amtj.a(2131699033), 5);
    localbjnw.a(amtj.a(2131699031) + vkm.a + amtj.a(2131699032), 5);
    localbjnw.c(2131690620);
    localbjnw.a(new xby(this, localbjnw, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    xvv.d("AddVideoController", "addVideoByRecord %s %s %s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    ynm localynm = ynm.a();
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
      localynm.a(paramContext, localBundle, paramInt2);
      paramContext.overridePendingTransition(2130772240, 2130772041);
      return;
    }
    localynm.a(paramContext, localBundle);
  }
  
  public void b(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    xvv.d("AddVideoController", "addVideoByExist %s %s", new Object[] { paramString1, paramString2 });
    Bundle localBundle = new Bundle();
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    StoryTransitionActivity.a(paramContext, xbz.class.getName(), localBundle, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbx
 * JD-Core Version:    0.7.0.1
 */