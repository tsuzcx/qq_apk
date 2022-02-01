package com.tencent.qqmail.utilities.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import java.io.File;
import java.util.ArrayList;

public class ShareUtil
{
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String QQ_SHARE_CLASS_NAME = "com.tencent.mobileqq.activity.JumpActivity";
  private static final String RTX_PACKAGE_NAME = "com.tencent.wework";
  private static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
  private static final String WEWORK_SHARE_CLASS_NAME = "com.tencent.wework.launch.AppSchemeLaunchActivity";
  
  public static Intent createIntentForShareToMailAttach(String[] paramArrayOfString)
  {
    return ComposeMailActivity.createIntentForDownloadManager(QMActivityManager.shareInstance().getVisibleActivity(), paramArrayOfString);
  }
  
  public static Intent createIntentForShareToMailContent(String paramString)
  {
    paramString = ComposeMailActivity.createIntentWithInlineImage(paramString);
    paramString.putExtra("toController", "CONTROLLER_SCREENSHOT_REPLY");
    return paramString;
  }
  
  public static void saveToGallery(String paramString, ShareCallback paramShareCallback)
  {
    Threads.runInBackground(new ShareUtil.4(paramString, QMApplicationContext.sharedInstance(), paramShareCallback));
  }
  
  public static void saveToGallery(ArrayList<String> paramArrayList, ShareCallback paramShareCallback)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    Threads.runInBackground(new ShareUtil.5(paramArrayList, QMApplicationContext.sharedInstance(), paramShareCallback));
  }
  
  private static void shareImageByIntent(Uri paramUri, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramString1, paramString2));
    localIntent.setAction("android.intent.action.SEND");
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.STREAM", paramUri);
    QMActivityManager.shareInstance().getVisibleActivity().startActivity(localIntent);
  }
  
  public static void shareImageToQQ(String paramString)
  {
    shareImageByIntent(Uri.fromFile(new File(paramString)), "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
  }
  
  public static void shareImageToWeWork(String paramString)
  {
    shareImageByIntent(Uri.fromFile(new File(paramString)), "com.tencent.wework", "com.tencent.wework.launch.AppSchemeLaunchActivity");
  }
  
  public static void shareToOtherApp(Context paramContext, String paramString)
  {
    new QMShareFileDialogHelper(paramContext, paramContext.getString(2131695203), paramString, QMShareFileDialogHelper.SHARE_TYPE_IMG, QMShareFileDialogHelper.FROM_SHARE_MAIL_OR_NOTE_CONTENT, new ShareUtil.3()).createDialog().show();
  }
  
  public static void shareToTimeLine(String paramString, ShareCallback paramShareCallback)
  {
    WXEntryActivity.shareImageToTimeLine(QMApplicationContext.sharedInstance(), paramString, 1, new ShareUtil.2(paramShareCallback));
  }
  
  public static void shareToWeChatFriend(String paramString, ShareCallback paramShareCallback)
  {
    WXEntryActivity.shareImageToFriend(QMApplicationContext.sharedInstance(), paramString, 1, new ShareUtil.1(paramShareCallback));
  }
  
  public static abstract interface ShareCallback
  {
    public abstract void isSuccess(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.share.ShareUtil
 * JD-Core Version:    0.7.0.1
 */