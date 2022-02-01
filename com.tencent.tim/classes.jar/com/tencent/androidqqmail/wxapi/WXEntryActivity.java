package com.tencent.androidqqmail.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.OpenWebview.Req;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.ByteArrayOutputStream;

public class WXEntryActivity
  extends Activity
  implements IWXAPIEventHandler
{
  public static final String APP_ID = "wx4b7110bee4d7c9b9";
  public static final int CALENDAR = 3;
  public static final int CARD = 8;
  public static final int CUT_CENTER_SQUARE_THUMB_BMP_COMPRESS_TYPE = 1;
  public static final int DEFAULT_THUMB_BMP_COMPRESS_TYPE = 0;
  public static final int FILE_SHARE = 6;
  public static final int FTN = 1;
  public static final int LONG_BITMAP_THUMB_BMP_COMPRESS_TYPE = 2;
  public static final int NORMAL_WEB = 2;
  public static final int POPULARIZE_FROM_ACTIONSHEET = 4;
  public static final int POPULARIZE_FROM_CONTENT = 5;
  public static final int PULL_POPULARIZE = 9;
  public static final int READMAIL = 7;
  public static final int SHORT_BITMAP_THUMB_BMP_COMPRESS_TYPE = 3;
  public static final int SUBSCTIBE = 0;
  private static final String TAG = "WXEntryActivity";
  private static int entence;
  private static int shareType;
  private static WXShareResultCallback wxCallback;
  private IWXAPI api;
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = ImageUtil.resizeImage(paramBitmap, 240.0F, 240.0F);
    paramBitmap = new ByteArrayOutputStream();
    ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 100, paramBitmap);
    if (paramBoolean) {
      ((Bitmap)localObject).recycle();
    }
    int i = 80;
    while ((paramBitmap.toByteArray().length / 1024 > 32) && (i > 0))
    {
      paramBitmap.reset();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, i, paramBitmap);
      i -= 20;
    }
    localObject = paramBitmap.toByteArray();
    try
    {
      paramBitmap.close();
      return localObject;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return localObject;
  }
  
  public static boolean canShareToWX(Context paramContext)
  {
    paramContext = WXAPIFactory.createWXAPI(paramContext, "wx4b7110bee4d7c9b9", true);
    if (QMNetworkUtils.isNetworkConnected())
    {
      if (paramContext.isWXAppInstalled()) {
        return true;
      }
      Threads.runOnMainThread(new WXEntryActivity.1());
    }
    for (;;)
    {
      return false;
      Threads.runOnMainThread(new WXEntryActivity.2());
    }
  }
  
  public static void openInWechatWebView(Context paramContext, String paramString)
  {
    if (!DeviceUtil.isWeChatInstalled())
    {
      Toast.makeText(paramContext, 2131720197, 0).show();
      return;
    }
    paramContext = WXAPIFactory.createWXAPI(paramContext, "wx4b7110bee4d7c9b9", true);
    OpenWebview.Req localReq = new OpenWebview.Req();
    localReq.url = paramString;
    paramContext.sendReq(localReq);
  }
  
  public static void shareImageToFriend(Context paramContext, String paramString, int paramInt, WXShareResultCallback paramWXShareResultCallback)
  {
    wxCallback = paramWXShareResultCallback;
    shareImageToWeChat(paramContext, paramString, 0, paramInt);
  }
  
  public static void shareImageToFriend(Context paramContext, String paramString, WXShareResultCallback paramWXShareResultCallback)
  {
    wxCallback = paramWXShareResultCallback;
    shareImageToWeChat(paramContext, paramString, 0);
  }
  
  public static void shareImageToTimeLine(Context paramContext, String paramString, int paramInt, WXShareResultCallback paramWXShareResultCallback)
  {
    wxCallback = paramWXShareResultCallback;
    shareImageToWeChat(paramContext, paramString, 1, paramInt);
  }
  
  public static void shareImageToTimeLine(Context paramContext, String paramString, WXShareResultCallback paramWXShareResultCallback)
  {
    wxCallback = paramWXShareResultCallback;
    shareImageToWeChat(paramContext, paramString, 1);
  }
  
  private static void shareImageToWeChat(Context paramContext, String paramString, int paramInt)
  {
    shareImageToWeChat(paramContext, paramString, paramInt, 0);
  }
  
  private static void shareImageToWeChat(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    IWXAPI localIWXAPI = WXAPIFactory.createWXAPI(paramContext, "wx4b7110bee4d7c9b9", true);
    localIWXAPI.registerApp("wx4b7110bee4d7c9b9");
    paramContext = new WXImageObject();
    paramContext.setImagePath(paramString);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = paramContext;
    localWXMediaMessage.description = "QQ邮箱截图";
    Object localObject = null;
    Bitmap localBitmap = ImageUtil.memSafeScaleImage(paramString, ImageUtil.calculateInSampleSize(ImageUtil.getImageOpts(paramString)), 1.0F);
    if (paramInt2 == 0) {
      paramContext = Bitmap.createScaledBitmap(localBitmap, 100, 100, true);
    }
    for (;;)
    {
      localBitmap.recycle();
      localWXMediaMessage.thumbData = bmpToByteArray(paramContext, false);
      localWXMediaMessage.title = "QQ邮箱截图";
      paramContext = new SendMessageToWX.Req();
      paramContext.transaction = ("img" + String.valueOf(System.currentTimeMillis()));
      paramContext.message = localWXMediaMessage;
      paramContext.scene = paramInt1;
      localIWXAPI.sendReq(paramContext);
      return;
      if (1 == paramInt2)
      {
        paramInt2 = localBitmap.getWidth();
        int i = localBitmap.getHeight();
        int j = Resources.getSystem().getDisplayMetrics().widthPixels;
        int k = Resources.getSystem().getDisplayMetrics().heightPixels;
        label226:
        int m;
        if ((j <= 720) || (k <= 1280))
        {
          j = 200;
          Log.i("WXEntryActivity", "Use thumb size :" + j);
          if (paramInt2 <= i) {
            break label327;
          }
          k = paramInt2;
          label262:
          if (paramInt2 <= i) {
            break label334;
          }
          m = i;
          label272:
          k = (k - m) / 2;
          if (i <= paramInt2) {
            break label340;
          }
        }
        label327:
        label334:
        label340:
        for (paramContext = Bitmap.createBitmap(localBitmap, 0, k, m, m);; paramContext = Bitmap.createBitmap(localBitmap, k, 0, m, m))
        {
          paramString = Bitmap.createScaledBitmap(paramContext, j, j, true);
          paramContext.recycle();
          paramContext = paramString;
          break;
          j = 350;
          break label226;
          k = i;
          break label262;
          m = paramInt2;
          break label272;
        }
      }
      paramContext = localObject;
      if (2 != paramInt2)
      {
        paramContext = localObject;
        if (3 == paramInt2) {
          paramContext = localObject;
        }
      }
    }
  }
  
  public static void shareWebpage(Context paramContext, int paramInt1, WXMediaMessage paramWXMediaMessage, int paramInt2)
  {
    paramContext = WXAPIFactory.createWXAPI(paramContext, "wx4b7110bee4d7c9b9", true);
    paramContext.registerApp("wx4b7110bee4d7c9b9");
    SendMessageToWX.Req localReq = new SendMessageToWX.Req();
    localReq.transaction = ("webpage" + System.currentTimeMillis());
    localReq.message = paramWXMediaMessage;
    localReq.scene = paramInt1;
    paramContext.sendReq(localReq);
    entence = paramInt2;
    shareType = paramInt1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("WXEntryActivity", "onCreate " + WXEntryActivity.class.getSimpleName());
    try
    {
      this.api = WXAPIFactory.createWXAPI(this, "wx4b7110bee4d7c9b9", false);
      this.api.handleIntent(getIntent(), this);
      return;
    }
    catch (Exception paramBundle)
    {
      QMLog.log(6, "WXEntryActivity", paramBundle.getMessage());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("WXEntryActivity", "onDestroy " + WXEntryActivity.class.getSimpleName());
    wxCallback = null;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    try
    {
      setIntent(paramIntent);
      this.api.handleIntent(paramIntent, this);
      return;
    }
    catch (Exception paramIntent)
    {
      QMLog.log(6, "WXEntryActivity", paramIntent.getMessage());
    }
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    switch (paramBaseReq.getType())
    {
    }
    finish();
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    int j = 0;
    label88:
    label108:
    int i;
    if (paramBaseResp.errCode == 0)
    {
      QMLog.log(4, "WXEntryActivity", "share wx ok. entrance:" + entence + ",scene:" + shareType);
      if (shareType == 0)
      {
        DataCollector.logDetailEvent("DetailEvent_Share_Friends", 0L, 0L, String.valueOf(entence));
        if (entence != 4) {
          break label231;
        }
        if (shareType != 0) {
          break label215;
        }
        DataCollector.logEvent("Event_Ad_Webview_ActionSheet_ShareSession");
        if (entence == 7)
        {
          if (shareType != 0) {
            break label269;
          }
          DataCollector.logEvent("Event_Share_Mail_To_Wx_Session");
        }
        switch (paramBaseResp.errCode)
        {
        case -3: 
        case -1: 
        default: 
          j = 2131721941;
          i = j;
          if (wxCallback != null)
          {
            wxCallback.isSuccess(false);
            i = j;
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        Toast.makeText(QMApplicationContext.sharedInstance(), i, 1).show();
      }
      finish();
      return;
      if (shareType != 1) {
        break;
      }
      DataCollector.logDetailEvent("DetailEvent_Share_Pyq", 0L, 0L, String.valueOf(entence));
      break;
      label215:
      if (shareType != 1) {
        break label88;
      }
      DataCollector.logEvent("Event_Ad_Webview_ActionSheet_ShareTimeLine");
      break label88;
      label231:
      if (entence != 5) {
        break label88;
      }
      if (shareType == 0)
      {
        DataCollector.logEvent("Event_Ad_Webview_Content_ShareSession");
        break label88;
      }
      if (shareType != 1) {
        break label88;
      }
      DataCollector.logEvent("Event_Ad_Webview_Content_ShareTimeLine");
      break label88;
      label269:
      if (shareType != 1) {
        break label108;
      }
      DataCollector.logEvent("Event_Share_Mail_To_Wx_Timeline");
      break label108;
      QMLog.log(4, "WXEntryActivity", "share wx fail. entrance:" + entence + ", scene:" + shareType + ", retcode:" + paramBaseResp.errCode);
      if (shareType == 0)
      {
        DataCollector.logDetailEvent("DetailEvent_Share_Friends", 0L, 1L, "wx:" + entence + ":" + String.valueOf(paramBaseResp.errCode));
        break label108;
      }
      if (shareType != 1) {
        break label108;
      }
      DataCollector.logDetailEvent("DetailEvent_Share_Pyq", 0L, 1L, "wx:" + entence + ":" + String.valueOf(paramBaseResp.errCode));
      break label108;
      j = 2131721940;
      i = j;
      if (wxCallback != null)
      {
        wxCallback.isSuccess(true);
        i = j;
        continue;
        i = j;
        if (wxCallback != null)
        {
          wxCallback.isSuccess(false);
          i = j;
          continue;
          i = 2131721937;
          if (wxCallback != null)
          {
            wxCallback.isSuccess(false);
            i = 2131721937;
          }
        }
      }
    }
  }
  
  public static abstract interface WXShareResultCallback
  {
    public abstract void isSuccess(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */