import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class yam
{
  private final QQAppInterface a;
  
  public yam(QQAppInterface paramQQAppInterface)
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
    blir localblir = blir.a(paramContext);
    localblir.a(anzj.a(2131698798), 5);
    localblir.a(anzj.a(2131698796) + win.a + anzj.a(2131698797), 5);
    localblir.c(2131690580);
    localblir.a(new yan(this, localblir, paramContext, paramInt1, paramString1, paramString2, paramLong, paramInt2, paramInt3));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  public void a(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    yuk.d("AddVideoController", "addVideoByRecord %s %s %s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("please indicate the share group id");
    }
    zmq localzmq = zmq.a();
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
      localzmq.a(paramContext, localBundle, paramInt2);
      paramContext.overridePendingTransition(2130772242, 2130772039);
      return;
    }
    localzmq.a(paramContext, localBundle);
  }
  
  public void b(Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3)
  {
    yuk.d("AddVideoController", "addVideoByExist %s %s", new Object[] { paramString1, paramString2 });
    Bundle localBundle = new Bundle();
    localBundle.putString("shareGroupId", paramString1);
    localBundle.putString("shareGroupName", paramString2);
    localBundle.putInt("add_video_source", paramInt3);
    StoryTransitionActivity.a(paramContext, yao.class.getName(), localBundle, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yam
 * JD-Core Version:    0.7.0.1
 */