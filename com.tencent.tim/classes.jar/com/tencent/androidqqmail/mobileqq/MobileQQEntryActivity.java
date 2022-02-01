package com.tencent.androidqqmail.mobileqq;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.util.ArrayList;

public class MobileQQEntryActivity
{
  private static String APP_ID = "100686947";
  private static final String TAG = "MobileQQEntryActivity";
  public static Tencent mTencent;
  public static IUiListener qqShareListener = new MobileQQEntryActivity.1();
  
  public static void shareImageToQQ(Activity paramActivity, String paramString)
  {
    mTencent = Tencent.createInstance(APP_ID, QMApplicationContext.sharedInstance());
    Bundle localBundle = new Bundle();
    localBundle.putString("imageLocalUrl", paramString);
    localBundle.putInt("req_type", 5);
    if (mTencent != null) {
      mTencent.shareToQQ(paramActivity, localBundle, qqShareListener);
    }
  }
  
  public static void shareImageToQQZone(Activity paramActivity, String paramString)
  {
    mTencent = Tencent.createInstance(APP_ID, QMApplicationContext.sharedInstance());
    Bundle localBundle = new Bundle();
    localBundle.putString("imageLocalUrl", paramString);
    localBundle.putInt("req_type", 5);
    localBundle.putInt("cflag", 1);
    mTencent.shareToQQ(paramActivity, localBundle, qqShareListener);
  }
  
  public static void shareLinkToQQ(String paramString1, String paramString2, String paramString3, String paramString4, Activity paramActivity) {}
  
  public static void shareLinkToQQZone(String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, Activity paramActivity)
  {
    mTencent = Tencent.createInstance(APP_ID, QMApplicationContext.sharedInstance());
    Bundle localBundle = new Bundle();
    localBundle.putInt("req_type", 1);
    localBundle.putString("targetUrl", paramString1);
    localBundle.putString("title", paramString2);
    localBundle.putString("summary", paramString3);
    localBundle.putStringArrayList("imageUrl", paramArrayList);
    mTencent.shareToQzone(paramActivity, localBundle, qqShareListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.mobileqq.MobileQQEntryActivity
 * JD-Core Version:    0.7.0.1
 */