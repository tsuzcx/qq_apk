import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.1;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.2;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import mqq.os.MqqHandler;

public class qeu
  implements IEventReceiver
{
  private static qeu a;
  private boolean aCV;
  public Bundle bundle;
  public StoryVideoItem f;
  public String localThumbPath;
  
  private qeu()
  {
    pmi.a().registerSubscriber(new qeu.a(this));
  }
  
  public static qeu a()
  {
    if (a == null) {
      a = new qeu();
    }
    return a;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData");
    }
    Object localObject = ForwardUtils.a(paramIntent);
    if ((((SessionInfo)localObject).cZ == 1) && (((apsw)paramQQAppInterface.getManager(48)).a(((SessionInfo)localObject).aTl, true).cSk)) {
      QQToast.a(paramQQAppInterface.getApp(), 2131699615, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    do
    {
      return false;
      i = paramIntent.getIntExtra("forward_type", 2147483647);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "handleForwardData() forwardType" + i);
      }
    } while (i == 2147483647);
    paramIntent.removeExtra("forward_type");
    paramIntent.getStringExtra("forward_filepath");
    if (((SessionInfo)localObject).cZ == 9501) {
      return true;
    }
    if (paramIntent.getBooleanExtra("isFromFavorite", false)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoToFriendHelper", 2, "handleForwardData(): ShortVideo => " + paramIntent.getExtras());
    }
    int i = paramIntent.getIntExtra("from_busi_type", 0);
    if (i == 1) {
      i = 2;
    }
    for (;;)
    {
      localObject = anfr.a(3, i);
      ((angi)localObject).b(anfr.a(i, paramIntent, (angi)localObject));
      anfr.a((angi)localObject, paramQQAppInterface);
      return true;
      if (i == 2) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  private void b(StoryVideoItem paramStoryVideoItem)
  {
    int[] arrayOfInt;
    if ((paramStoryVideoItem.mVideoWidth <= 0) || (paramStoryVideoItem.mVideoHeight <= 0))
    {
      arrayOfInt = alzu.m(paramStoryVideoItem.mLocalVideoPath);
      if ((arrayOfInt[0] <= 0) || (arrayOfInt[1] <= 0)) {
        ram.e("SendVideoToFriendHelper", "getVideoSize error, localPath:%s, width:%s, height:%s", new Object[] { paramStoryVideoItem.mLocalVideoPath, Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      }
    }
    else
    {
      return;
    }
    paramStoryVideoItem.mVideoWidth = arrayOfInt[0];
    paramStoryVideoItem.mVideoHeight = arrayOfInt[1];
    ThreadManager.getSubThreadHandler().post(new SendVideoToFriendHelper.2(this, paramStoryVideoItem));
  }
  
  public boolean Jr()
  {
    return this.aCV;
  }
  
  public void a(Activity paramActivity, String paramString, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || (paramStoryVideoItem == null) || (paramInt <= 0))
    {
      ram.e("SendVideoToFriendHelper", "start forward activity failed.");
      reset();
      return;
    }
    this.localThumbPath = paramString;
    this.f = paramStoryVideoItem;
    paramStoryVideoItem = new Bundle();
    paramStoryVideoItem.putInt("forward_type", 21);
    paramStoryVideoItem.putString("forward_thumb", paramString);
    paramStoryVideoItem.putBoolean("forward_need_sendmsg", true);
    paramStoryVideoItem.putBoolean("is_need_show_toast", false);
    paramString = new Intent();
    paramString.putExtras(paramStoryVideoItem);
    ahgq.f(paramActivity, paramString, paramInt);
  }
  
  public void a(Bundle paramBundle, StoryVideoItem paramStoryVideoItem, String paramString1, String paramString2)
  {
    if ((paramBundle == null) || (paramStoryVideoItem == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131714303), 0).show();
      ram.e("SendVideoToFriendHelper", "send video to friend failed because data is not validate.");
      reset();
      return;
    }
    String str1 = arwu.toMD5(paramString2);
    String str2 = arwu.toMD5(paramString1);
    paramBundle.putInt("forward_type", 21);
    paramBundle.putString("from_uin", qem.getQQAppInterface().getCurrentUin());
    paramBundle.putString("file_uuid", paramStoryVideoItem.mVid);
    paramBundle.putString("file_send_path", paramString2);
    paramBundle.putString("file_shortvideo_md5", str1);
    paramBundle.putInt("file_send_size", (int)paramStoryVideoItem.mVideoBytes);
    if (paramStoryVideoItem.mVideoDuration <= 100L) {}
    for (int i = (int)paramStoryVideoItem.mVideoDuration;; i = (int)(paramStoryVideoItem.mVideoDuration / 1000L))
    {
      paramBundle.putInt("file_send_duration", i);
      paramBundle.putString("file_name", ShortVideoUtils.bx(str1, "mp4"));
      paramBundle.putString("thumbfile_send_path", paramString1);
      paramBundle.putString("thumbfile_md5", str2);
      paramBundle.putInt("thumbfile_send_width", paramStoryVideoItem.mVideoWidth);
      paramBundle.putInt("thumbfile_send_height", paramStoryVideoItem.mVideoHeight);
      paramString1 = wja.a(new Intent(BaseApplicationImpl.getContext(), SplashActivity.class), null);
      paramString1.putExtras(paramBundle);
      a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1);
      QQToast.a(BaseApplicationImpl.getContext(), 2, acfp.m(2131714304), 0).show();
      rar.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      reset();
      return;
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    reset();
    long l = System.currentTimeMillis();
    ram.w("SendVideoToFriendHelper", "generateShareThumb start: %d.", new Object[] { Long.valueOf(l) });
    ThreadManager.post(new SendVideoToFriendHelper.1(this, l, paramStoryVideoItem, paramString), 10, null, false);
  }
  
  public void aU(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      ram.e("SendVideoToFriendHelper", "start forward activity failed.");
      reset();
      return;
    }
    this.bundle = paramBundle;
    c(this.f);
  }
  
  public void c(StoryVideoItem paramStoryVideoItem)
  {
    this.aCV = true;
    ThreadManager.post(new SendVideoToFriendHelper.3(this, paramStoryVideoItem), 10, null, false);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void reset()
  {
    this.bundle = null;
    this.f = null;
    this.localThumbPath = null;
    this.aCV = false;
  }
  
  public void v(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      ram.e("SendVideoToFriendHelper", "start forward activity failed.");
      reset();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_thumb", paramString);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_extra", paramString);
    localBundle.putBoolean("k_favorites", false);
    localBundle.putBoolean("isFromFavorites", true);
    localBundle.putBoolean("isFromShare", true);
    paramString = new Intent(paramActivity, ForwardRecentActivity.class);
    paramString.putExtras(localBundle);
    paramActivity.startActivity(paramString);
    reset();
  }
  
  public static class a
    extends QQUIEventReceiver<qeu, qem.a>
  {
    public a(@NonNull qeu paramqeu)
    {
      super();
    }
    
    public void a(@NonNull qeu paramqeu, @NonNull qem.a parama)
    {
      if (TextUtils.equals("SendVideoToFriendHelper", parama.key)) {}
      switch (parama.status)
      {
      default: 
        return;
      }
      ram.b(this.TAG, "download video or picture finish. videoLocalPath = %s.", parama.outputPath);
      qeu.a(paramqeu, false);
      paramqeu.a(paramqeu.bundle, paramqeu.f, paramqeu.localThumbPath, parama.outputPath);
    }
    
    public Class acceptEventClass()
    {
      return qem.a.class;
    }
  }
  
  public static class b
    extends plt
  {
    public String axf;
    public String axg;
    public StoryVideoItem f;
    
    public b(ErrorMessage paramErrorMessage, String paramString)
    {
      this.b = paramErrorMessage;
      this.axg = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qeu
 * JD-Core Version:    0.7.0.1
 */