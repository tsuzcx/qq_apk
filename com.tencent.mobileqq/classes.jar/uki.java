import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class uki
{
  private final QQAppInterface a;
  
  public uki(QQAppInterface paramQQAppInterface)
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
    bfol localbfol = bfol.a(paramContext);
    localbfol.a(ajyc.a(2131699873), 5);
    localbfol.a(ajyc.a(2131699871) + ssi.a + ajyc.a(2131699872), 5);
    localbfol.c(2131690596);
    localbfol.a(new ukj(this, localbfol, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    veg.d("AddVideoController", "addVideoByRecord %s %s %s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    vwm localvwm = vwm.a();
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
      localvwm.a(paramContext, localBundle, paramInt2);
      paramContext.overridePendingTransition(2130772217, 2130772038);
      return;
    }
    localvwm.a(paramContext, localBundle);
  }
  
  public void b(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    veg.d("AddVideoController", "addVideoByExist %s %s", new Object[] { paramString1, paramString2 });
    Bundle localBundle = new Bundle();
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    StoryTransitionActivity.a(paramContext, ukk.class.getName(), localBundle, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uki
 * JD-Core Version:    0.7.0.1
 */