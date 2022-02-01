package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

public abstract class MiniAppProxy
{
  public abstract boolean VerifyFile(int paramInt, String paramString);
  
  public abstract boolean addShortcut(Context paramContext, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult);
  
  public abstract boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult);
  
  public abstract boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract String getA2();
  
  public abstract String getAccount();
  
  public abstract String getAmsAppId();
  
  public abstract String getAppId();
  
  public abstract String getAppName();
  
  public abstract String getAppVersion();
  
  public abstract Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable);
  
  public abstract String getImei();
  
  public abstract boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract byte[] getLoginSig();
  
  public abstract int getLoginType();
  
  public abstract OnMoreItemSelectedListener getMoreItemSelectedListener();
  
  public abstract ArrayList<MoreItem> getMoreItems(MoreItemList.Builder paramBuilder);
  
  public abstract String getNickName();
  
  public abstract String getPayAccessToken();
  
  public abstract String getPayOpenId();
  
  public abstract String getPayOpenKey();
  
  public abstract String getPlatformId();
  
  public abstract String getPlatformQUA();
  
  public abstract String getSoPath();
  
  public abstract int getTbsVersion();
  
  public abstract boolean isDebugVersion();
  
  public abstract void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void muteAudioFocus(Context paramContext, boolean paramBoolean);
  
  public abstract void notifyMiniAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo);
  
  public abstract boolean onCapsuleButtonCloseClick(IMiniAppContext paramIMiniAppContext);
  
  public abstract boolean onCapsuleButtonMoreClick(IMiniAppContext paramIMiniAppContext);
  
  public abstract boolean openChoosePhotoActivity(Context paramContext, int paramInt, IChoosePhotoListner paramIChoosePhotoListner);
  
  public abstract boolean openImagePreview(Context paramContext, int paramInt, List<String> paramList);
  
  public abstract boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2);
  
  public abstract boolean openSchema(Context paramContext, String paramString, ResultReceiver paramResultReceiver);
  
  public abstract void sendData(byte[] paramArrayOfByte, SenderListener paramSenderListener);
  
  public abstract void setDrawableCallback(Drawable paramDrawable, IDrawableLoadedCallBack paramIDrawableLoadedCallBack);
  
  public abstract boolean startBrowserActivity(Context paramContext, Intent paramIntent);
  
  public static abstract interface IChoosePhotoListner
  {
    public abstract void onResult(ArrayList<String> paramArrayList);
  }
  
  public static abstract interface IDrawableLoadedCallBack
  {
    public abstract void onLoadSuccessed(Drawable paramDrawable);
  }
  
  public static abstract interface SenderListener
  {
    public abstract boolean onReply(int paramInt, byte[] paramArrayOfByte, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
 * JD-Core Version:    0.7.0.1
 */