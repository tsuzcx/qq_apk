import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.2;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.3;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.5;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import cooperation.qzone.share.QZoneShareActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import mqq.os.MqqHandler;

@ProxyService(proxy=ShareProxy.class)
public class aswo
  implements ShareProxy
{
  private Bitmap X(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + localObject.length);
    int i = 0;
    while ((i < 10) && (localObject.length > 32768))
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(0.7F, 0.7F);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + localObject.length);
      i += 1;
    }
    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + localObject.length);
    return BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3)
  {
    if (paramInt == 3) {
      WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), paramString1, paramBitmap, "QQ小程序 · " + paramString2, paramString3);
    }
    while (paramInt != 4) {
      return;
    }
    WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), "QQ小程序 · " + paramString2 + ": " + paramString1, paramBitmap, "", paramString3);
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(paramInt, paramString1, paramString2, ImageUtil.drawableToBitmap(paramActivity.getResources().getDrawable(2130849280)), paramString3);
  }
  
  private void downloadImageByURLDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label44;
      }
      ram.d("ShareProxyImpl", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramString.downloadImediatly();
      return;
      label44:
      ram.d("ShareProxyImpl", "start load URLDrawable.");
    }
  }
  
  private void e(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null) {
      return;
    }
    MiniProgramShareUtils.shareUpdatableMsg(paramInnerShareData.fromActivity, paramInnerShareData.getMiniAppId(), paramInnerShareData.getMiniAppInfo().verType, paramInnerShareData.templateId, paramInnerShareData.event, paramInnerShareData.callbackId);
  }
  
  private void shareLocalPicMessage(InnerShareData paramInnerShareData)
  {
    if (paramInnerShareData == null) {
      return;
    }
    switch (paramInnerShareData.shareTarget)
    {
    case 2: 
    default: 
      return;
    case 0: 
      ShareUtils.startSharePicToQQ(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath);
      return;
    case 1: 
      ShareUtils.startSharePicToQzone(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath, paramInnerShareData.getMiniAppInfo().name);
      return;
    case 3: 
      ShareUtils.startSharePicToWeChat(paramInnerShareData.fromActivity, ShareUtils.getFileUri(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath), true);
      return;
    }
    ShareUtils.startSharePicToWeChat(paramInnerShareData.fromActivity, ShareUtils.getFileUri(paramInnerShareData.fromActivity, paramInnerShareData.sharePicPath), false);
  }
  
  public void a(InnerShareData paramInnerShareData)
  {
    if ((paramInnerShareData == null) || (paramInnerShareData.fromActivity == null))
    {
      QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. shareData or activity is null");
      return;
    }
    if (!(paramInnerShareData.fromActivity instanceof GameActivity1)) {
      QLog.e("ShareProxyImpl", 1, "shareQQArk. not GameActivity1");
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. miniAppInfo is null");
      return;
    }
    aswp localaswp = new aswp(this, paramInnerShareData);
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel;
    if (paramInnerShareData.entryModel != null)
    {
      localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramInnerShareData.entryModel.type, paramInnerShareData.entryModel.uin, paramInnerShareData.entryModel.name, paramInnerShareData.entryModel.isAdmin);
      if (paramInnerShareData.shareChatModel == null) {
        break label308;
      }
    }
    label308:
    for (com.tencent.mobileqq.mini.sdk.ShareChatModel localShareChatModel = new com.tencent.mobileqq.mini.sdk.ShareChatModel(paramInnerShareData.shareChatModel.type, paramInnerShareData.shareChatModel.uin, paramInnerShareData.shareChatModel.name);; localShareChatModel = null)
    {
      MiniProgramShareUtils.shareAsArkMessage(paramInnerShareData.fromActivity, new MiniArkShareModelBuilder().setAppId(localMiniAppInfo.appId).setTitle(localMiniAppInfo.name).setDescription(paramInnerShareData.summary).setShareScene(1).setShareTemplateType(1).setShareBusinessType(localMiniAppInfo.getReportType()).setPicUrl(paramInnerShareData.sharePicPath).setVidUrl(null).setJumpUrl(paramInnerShareData.entryPath).setIconUrl(localMiniAppInfo.iconUrl).setVersionType(localMiniAppInfo.verType).setVersionId(localMiniAppInfo.versionId).setWebURL(paramInnerShareData.webURL).setTemplateId(paramInnerShareData.templateId).setTemplateData(paramInnerShareData.templateData).setEntryModel(localEntryModel).setShareChatModel(localShareChatModel).setShareTarget(paramInnerShareData.shareTarget).setRcvOpenId(paramInnerShareData.recvOpenId).createMiniArkShareModel(), paramInnerShareData.withShareTicket, paramInnerShareData.shareSource, localaswp);
      return;
      localEntryModel = null;
      break;
    }
  }
  
  public void b(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    String str;
    Intent localIntent;
    if (aqmr.isEmpty(paramInnerShareData.summary))
    {
      str = localMiniAppInfo.desc;
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
      localIntent.putExtra("isSharedFromMiniProgram", true);
      localIntent.putExtra("miniShareParamAppId", localMiniAppInfo.appId);
      localIntent.putExtra("miniShareParamTitle", localMiniAppInfo.name);
      localIntent.putExtra("miniShareParamDescription", str);
      localIntent.putExtra("miniShareParamShareScene", 1);
      localIntent.putExtra("miniShareParamTemplateType", 1);
      localIntent.putExtra("miniShareParamBusinessType", localMiniAppInfo.getReportType());
      localIntent.putExtra("miniShareParamPicUrl", paramInnerShareData.sharePicPath);
      localIntent.putExtra("miniShareParamJumpUrl", paramInnerShareData.entryPath);
      localIntent.putExtra("miniShareParamIconUrl", localMiniAppInfo.iconUrl);
      localIntent.putExtra("miniShareParamVersionType", localMiniAppInfo.verType);
      localIntent.putExtra("miniShareParamVersionId", localMiniAppInfo.versionId);
      if (paramInnerShareData.shareSource != 11) {
        break label239;
      }
    }
    label239:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("miniShareIsFromInnerButton", bool);
      localActivity.startActivity(localIntent);
      return;
      str = paramInnerShareData.summary;
      break;
    }
  }
  
  public void c(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    if (!WXShareHelper.a().isWXinstalled())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.2(this, localActivity));
      return;
    }
    if (!WXShareHelper.a().isWXsupportApi())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareProxyImpl.3(this, localActivity));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startShareToWeChat. title=" + paramInnerShareData.summary + ",sharePicPath=" + paramInnerShareData.sharePicPath + ",entryPath=" + paramInnerShareData.entryPath);
    }
    MiniAppInfo localMiniAppInfo = paramInnerShareData.getMiniAppInfo();
    if (localMiniAppInfo == null)
    {
      QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    String str2 = paramInnerShareData.summary;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localMiniAppInfo.desc;
    }
    int i = paramInnerShareData.getShareType();
    MiniProgramShareUtils.shareAsWeChatMsg(localMiniAppInfo.appId, localMiniAppInfo.name, str1, 1, 1, localMiniAppInfo.getReportType(), paramInnerShareData.sharePicPath, null, paramInnerShareData.entryPath, localMiniAppInfo.iconUrl, localMiniAppInfo.verType, localMiniAppInfo.versionId, null, i, new aswq(this, localActivity, paramInnerShareData, i, str1, localMiniAppInfo));
  }
  
  public void d(InnerShareData paramInnerShareData)
  {
    Activity localActivity = paramInnerShareData.fromActivity;
    ThreadManager.getUIHandler().post(new ShareProxyImpl.5(this, localActivity, paramInnerShareData));
  }
  
  public int getDefaultShareTarget()
  {
    return 0;
  }
  
  public boolean isShareTargetAvailable(Context paramContext, int paramInt)
  {
    return true;
  }
  
  public void onJsShareAppMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QLog.w("ShareProxyImpl", 1, "onJsShareAppMessage. Unknown type of data");
      return;
    }
    QLog.d("ShareProxyImpl", 1, "onJsShareAppMessage. data = " + paramObject);
    paramObject = (InnerShareData)paramObject;
    switch (paramObject.shareTarget)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      a(paramObject);
      return;
    case 1: 
      b(paramObject);
      return;
    case 3: 
    case 4: 
      c(paramObject);
      return;
    }
    e(paramObject);
  }
  
  public void onJsShareAppPictureMessage(Object paramObject)
  {
    if (!(paramObject instanceof InnerShareData))
    {
      QLog.w("ShareProxyImpl", 1, "onJsShareAppPictureMessage. Unknown type of data");
      return;
    }
    QLog.d("ShareProxyImpl", 1, "onJsShareAppMessage. data = " + paramObject);
    paramObject = (InnerShareData)paramObject;
    if (paramObject.isLocalPic)
    {
      shareLocalPicMessage(paramObject);
      return;
    }
    d(paramObject);
  }
  
  public void onShareActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void share(Activity paramActivity, ShareData paramShareData) {}
  
  public void sharePic(Activity paramActivity, ShareData paramShareData)
  {
    if ((paramActivity == null) || (paramShareData == null) || (TextUtils.isEmpty(paramShareData.sharePicPath))) {
      return;
    }
    switch (paramShareData.shareTarget)
    {
    default: 
      return;
    }
    ShareUtils.startSharePicToQQ(paramActivity, paramShareData.sharePicPath);
  }
  
  public void showSharePanel(IMiniAppContext paramIMiniAppContext)
  {
    ((MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class)).onCapsuleButtonMoreClick(paramIMiniAppContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswo
 * JD-Core Version:    0.7.0.1
 */