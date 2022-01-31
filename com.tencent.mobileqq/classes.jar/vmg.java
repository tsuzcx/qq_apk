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

public class vmg
  implements IEventReceiver
{
  private static vmg jdField_a_of_type_Vmg;
  public Bundle a;
  public StoryVideoItem a;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  
  private vmg()
  {
    umc.a().registerSubscriber(new vmh(this));
  }
  
  public static vmg a()
  {
    if (jdField_a_of_type_Vmg == null) {
      jdField_a_of_type_Vmg = new vmg();
    }
    return jdField_a_of_type_Vmg;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData");
    }
    Object localObject = ForwardUtils.a(paramIntent);
    if ((((SessionInfo)localObject).jdField_a_of_type_Int == 1) && (((bcnu)paramQQAppInterface.getManager(48)).a(((SessionInfo)localObject).jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)) {
      QQToast.a(paramQQAppInterface.getApp(), 2131697834, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
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
    if (((SessionInfo)localObject).jdField_a_of_type_Int == 9501) {
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
      localObject = azdd.a(3, i);
      ((azdx)localObject).a(azdd.a(i, paramIntent, (azdx)localObject));
      azdd.a((azdx)localObject, paramQQAppInterface);
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
      arrayOfInt = axut.a(paramStoryVideoItem.mLocalVideoPath);
      if ((arrayOfInt[0] <= 0) || (arrayOfInt[1] <= 0)) {
        wxe.e("SendVideoToFriendHelper", "getVideoSize error, localPath:%s, width:%s, height:%s", new Object[] { paramStoryVideoItem.mLocalVideoPath, Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
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
      wxe.e("SendVideoToFriendHelper", "start forward activity failed.");
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
      wxe.e("SendVideoToFriendHelper", "start forward activity failed.");
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
    aryv.a(paramActivity, paramString, paramInt);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      wxe.e("SendVideoToFriendHelper", "start forward activity failed.");
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
      QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131714221), 0).a();
      wxe.e("SendVideoToFriendHelper", "send video to friend failed because data is not validate.");
      a();
      return;
    }
    String str1 = bflq.a(paramString2);
    String str2 = bflq.a(paramString1);
    paramBundle.putInt("forward_type", 21);
    paramBundle.putString("from_uin", vls.a().c());
    paramBundle.putString("file_uuid", paramStoryVideoItem.mVid);
    paramBundle.putString("file_send_path", paramString2);
    paramBundle.putString("file_shortvideo_md5", str1);
    paramBundle.putInt("file_send_size", (int)paramStoryVideoItem.mVideoBytes);
    if (paramStoryVideoItem.mVideoDuration <= 100L) {}
    for (int i = (int)paramStoryVideoItem.mVideoDuration;; i = (int)(paramStoryVideoItem.mVideoDuration / 1000L))
    {
      paramBundle.putInt("file_send_duration", i);
      paramBundle.putString("file_name", ShortVideoUtils.b(str1, "mp4"));
      paramBundle.putString("thumbfile_send_path", paramString1);
      paramBundle.putString("thumbfile_md5", str2);
      paramBundle.putInt("thumbfile_send_width", paramStoryVideoItem.mVideoWidth);
      paramBundle.putInt("thumbfile_send_height", paramStoryVideoItem.mVideoHeight);
      paramString1 = aepi.a(new Intent(BaseApplicationImpl.getContext(), SplashActivity.class), null);
      paramString1.putExtras(paramBundle);
      a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1);
      QQToast.a(BaseApplicationImpl.getContext(), 2, alud.a(2131714222), 0).a();
      wxj.a("play_video", "suc_friend", 0, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
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
    wxe.d("SendVideoToFriendHelper", "generateShareThumb start: %d.", new Object[] { Long.valueOf(l) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmg
 * JD-Core Version:    0.7.0.1
 */