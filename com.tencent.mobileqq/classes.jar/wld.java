import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.1;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.2;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import mqq.os.MqqHandler;

public class wld
  implements IEventReceiver
{
  private static wld jdField_a_of_type_Wld;
  public Bundle a;
  public StoryVideoItem a;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  
  private wld()
  {
    vli.a().registerSubscriber(new wle(this));
  }
  
  public static wld a()
  {
    if (jdField_a_of_type_Wld == null) {
      jdField_a_of_type_Wld = new wld();
    }
    return jdField_a_of_type_Wld;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData");
    }
    Object localObject = ForwardUtils.sessionFromIntent(paramIntent);
    if ((((SessionInfo)localObject).curType == 1) && (((bfbz)paramQQAppInterface.getManager(48)).a(((SessionInfo)localObject).curFriendUin, true).jdField_a_of_type_Boolean)) {
      QQToast.a(paramQQAppInterface.getApp(), 2131696866, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076));
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
    if (((SessionInfo)localObject).curType == 9501) {
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
      localObject = bbqf.a(3, i);
      ((bbqx)localObject).a(bbqf.a(i, paramIntent, (bbqx)localObject));
      bbqf.a((bbqx)localObject, paramQQAppInterface);
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
      arrayOfInt = bafi.a(paramStoryVideoItem.mLocalVideoPath);
      if ((arrayOfInt[0] <= 0) || (arrayOfInt[1] <= 0)) {
        xvv.e("SendVideoToFriendHelper", "getVideoSize error, localPath:%s, width:%s, height:%s", new Object[] { paramStoryVideoItem.mLocalVideoPath, Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      xvv.e("SendVideoToFriendHelper", "start forward activity failed.");
      a();
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
    a();
  }
  
  public void a(Activity paramActivity, String paramString, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)) || (paramStoryVideoItem == null) || (paramInt <= 0))
    {
      xvv.e("SendVideoToFriendHelper", "start forward activity failed.");
      a();
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    paramStoryVideoItem = new Bundle();
    paramStoryVideoItem.putInt("forward_type", 21);
    paramStoryVideoItem.putString("forward_thumb", paramString);
    paramStoryVideoItem.putBoolean("forward_need_sendmsg", true);
    paramStoryVideoItem.putBoolean("is_need_show_toast", false);
    paramString = new Intent();
    paramString.putExtras(paramStoryVideoItem);
    atky.a(paramActivity, paramString, paramInt);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      xvv.e("SendVideoToFriendHelper", "start forward activity failed.");
      a();
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
  
  public void a(Bundle paramBundle, StoryVideoItem paramStoryVideoItem, String paramString1, String paramString2)
  {
    if ((paramBundle == null) || (paramStoryVideoItem == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131712934), 0).a();
      xvv.e("SendVideoToFriendHelper", "send video to friend failed because data is not validate.");
      a();
      return;
    }
    String str1 = bhzn.a(paramString2);
    String str2 = bhzn.a(paramString1);
    paramBundle.putInt("forward_type", 21);
    paramBundle.putString("from_uin", wkp.a().getCurrentUin());
    paramBundle.putString("file_uuid", paramStoryVideoItem.mVid);
    paramBundle.putString("file_send_path", paramString2);
    paramBundle.putString("file_shortvideo_md5", str1);
    paramBundle.putInt("file_send_size", (int)paramStoryVideoItem.mVideoBytes);
    if (paramStoryVideoItem.mVideoDuration <= 100L) {}
    for (int i = (int)paramStoryVideoItem.mVideoDuration;; i = (int)(paramStoryVideoItem.mVideoDuration / 1000L))
    {
      paramBundle.putInt("file_send_duration", i);
      paramBundle.putString("file_name", ShortVideoUtils.getShortVideoPath(str1, "mp4"));
      paramBundle.putString("thumbfile_send_path", paramString1);
      paramBundle.putString("thumbfile_md5", str2);
      paramBundle.putInt("thumbfile_send_width", paramStoryVideoItem.mVideoWidth);
      paramBundle.putInt("thumbfile_send_height", paramStoryVideoItem.mVideoHeight);
      paramString1 = AIOUtils.setOpenAIOIntent(new Intent(BaseApplicationImpl.getContext(), SplashActivity.class), null);
      paramString1.putExtras(paramBundle);
      a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1);
      QQToast.a(BaseApplicationImpl.getContext(), 2, amtj.a(2131712935), 0).a();
      xwa.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      a();
      return;
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new SendVideoToFriendHelper.3(this, paramStoryVideoItem), 10, null, false);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, String paramString)
  {
    a();
    long l = System.currentTimeMillis();
    xvv.d("SendVideoToFriendHelper", "generateShareThumb start: %d.", new Object[] { Long.valueOf(l) });
    ThreadManager.post(new SendVideoToFriendHelper.1(this, l, paramStoryVideoItem, paramString), 10, null, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wld
 * JD-Core Version:    0.7.0.1
 */