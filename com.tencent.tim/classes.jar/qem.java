import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.2;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.3;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.4;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.5;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class qem
{
  private static SparseArray<Object> aK = new SparseArray();
  public static final String auW;
  public static final String axb = ppf.fQ("StorySvc.report_comment");
  public static final int[] dL;
  
  static
  {
    auW = ppf.getString(2131701926);
    dL = new int[] { 90 };
  }
  
  public static int Z(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      switch (paramInt1)
      {
      default: 
        return 0;
      case 10: 
        return 74;
      case 11: 
        return 76;
      case 23: 
      case 210: 
      case 220: 
        return 75;
      }
      return 77;
    }
    return paramInt2;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    Object localObject2 = rqj.a(getApplicationContext(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
    }
    Object localObject3 = rqj.e(paramStoryVideoItem);
    Object localObject1 = rqj.d(paramStoryVideoItem);
    String str = rqj.a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str = plr.atr;
      str = str + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!rqj.g((String)localObject3, (String)localObject1, str))
      {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
        return -997;
        localObject1 = str;
      }
      else
      {
        localObject1 = str;
      }
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = localObject2;
      if (rqj.g((String)localObject1, (String)localObject2, (String)localObject2)) {
        break label236;
      }
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "watermarkVideoByMediaCodec() combineTwoImg failed");
      return -997;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    label236:
    long l;
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = new PublishVideoEntry();
      ((PublishVideoEntry)localObject1).doodlePath = ((String)localObject3);
      ((PublishVideoEntry)localObject1).isPicture = false;
      ((PublishVideoEntry)localObject1).mLocalRawVideoDir = paramStoryVideoItem.mLocalVideoPath;
      ((PublishVideoEntry)localObject1).businessId = 1;
      l = SystemClock.elapsedRealtime();
      localObject1 = new alyy.a(2000000, (PublishVideoEntry)localObject1);
      ((alyy.a)localObject1).TV(0);
      localObject2 = new alyy();
      localObject3 = plr.ath + paramStoryVideoItem.mVid + ".mp4";
      paramInt = ((alyy)localObject2).a(paramStoryVideoItem.mLocalVideoPath, (String)localObject3, (alyy.a)localObject1);
      if (paramInt == 0) {
        break label481;
      }
      if (paramInt == -1) {
        break;
      }
      ram.b("Q.qqstory.player.PlayModeUtils", new Throwable("MergeVideoError"), "watermarkVideoByMediaCodec() error after mergeVideo() return, errorCode=%d", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
      localObject1 = localObject2;
    }
    rox.copyFile(paramStoryVideoItem.mLocalVideoPath, paramString);
    label481:
    for (paramInt = 0;; paramInt = rrb.a((String)localObject3, paramStoryVideoItem.mLocalVideoPath, paramString, 0))
    {
      if (paramInt == 0) {
        rox.a(BaseApplication.getContext(), new File(paramString));
      }
      paramStoryVideoItem = new File((String)localObject3);
      if (paramStoryVideoItem.exists()) {
        paramStoryVideoItem.delete();
      }
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "hardware watermar cost:" + (SystemClock.elapsedRealtime() - l) / 1000.0D);
      return paramInt;
    }
  }
  
  public static void a(Context paramContext, CommentEntry paramCommentEntry)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {}
    do
    {
      do
      {
        return;
        if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
          break;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709692), 0).show();
        rar.b("story_net", axb, 0, 99980, new String[] { "", "0", rar.getNetworkType(BaseApplication.getContext()) });
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, "reportVideoCommemt - isNetSupport is false----");
      return;
      paramContext = (ausj)auss.b(paramContext, null);
      paramContext.addButton(acfp.m(2131709684), 5);
      paramContext.addButton(acfp.m(2131709703), 5);
      paramContext.addButton(acfp.m(2131709700), 5);
      paramContext.addButton(acfp.m(2131709688), 5);
      paramContext.addCancelButton(2131721058);
      paramContext.a(new qes(paramCommentEntry, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, QQUserUIItem paramQQUserUIItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709701), 0).show();
    }
    do
    {
      return;
      paramContext = (ausj)auss.b(paramContext, null);
      paramContext.addButton(acfp.m(2131709699), 5);
      paramContext.addButton(acfp.m(2131709693), 5);
      paramContext.addButton(acfp.m(2131709706), 5);
      paramContext.addButton(acfp.m(2131709683), 5);
      paramContext.addCancelButton(2131721058);
      paramContext.a(new qer(paramQQUserUIItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, StoryVideoItem paramStoryVideoItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709686), 0).show();
    }
    do
    {
      return;
      paramContext = (ausj)auss.b(paramContext, null);
      paramContext.addButton(acfp.m(2131709682), 5);
      paramContext.addButton(acfp.m(2131709685), 5);
      paramContext.addButton(acfp.m(2131709704), 5);
      paramContext.addButton(acfp.m(2131709705), 5);
      paramContext.addCancelButton(2131721058);
      paramContext.a(new qet(paramStoryVideoItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Resources paramResources, TextView paramTextView, String paramString, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if ((paramResources == null) || (paramTextView == null) || (!jqc.isValidUrl(paramString))) {
      if (QLog.isColorLevel())
      {
        paramResources = new StringBuilder().append("setAuthIcon fail：textView is null ? ");
        if (paramTextView == null) {
          bool = true;
        }
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, bool + ", url = " + paramString);
      }
    }
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i = wja.dp2px(paramFloat1, paramResources);
        Drawable localDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "StoryPlayModeAuthIcon";
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramString.setBounds(0, 0, i, i);
        paramTextView.setCompoundDrawablePadding(wja.dp2px(paramFloat2, paramResources));
        paramTextView.setCompoundDrawables(null, null, paramString, null);
        return;
      }
      catch (Exception paramResources) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.player.PlayModeUtils", 2, QLog.getStackTraceString(paramResources));
  }
  
  public static void a(Resources paramResources, QQUserUIItem paramQQUserUIItem, ImageView paramImageView, float paramFloat1, TextView paramTextView, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = aqhu.at();
    if (paramQQUserUIItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "setNickNameAndAuthIcon, userItem == null");
      }
      paramImageView.setImageDrawable(localDrawable);
      paramTextView.setText(auW);
      return;
    }
    Object localObject;
    int i;
    if (ppg.d.IE())
    {
      localObject = paramQQUserUIItem.getUserIconUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.player.PlayModeUtils", 2, "fillFriendsData userIconUrl = " + (String)localObject);
        }
        a(paramResources, paramTextView, (String)localObject, paramFloat2, paramFloat3);
        i = wja.dp2px(paramFloat1, paramResources);
        if ((!paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isNotDovUser())) {
          break label255;
        }
        if (!paramBoolean) {
          break label243;
        }
        paramTextView.setText(((ptc)psx.a(23)).a(paramQQUserUIItem, paramString, false, true));
      }
    }
    for (;;)
    {
      a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      return;
      if (!paramQQUserUIItem.isVipButNoFriend()) {
        break;
      }
      localObject = paramResources.getDrawable(2130847706);
      i = wja.dp2px(paramFloat2, paramResources);
      int j = wja.dp2px(paramFloat3, paramResources);
      if (localObject == null) {
        break;
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramTextView.setCompoundDrawablePadding(j);
      paramTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      break;
      paramTextView.setCompoundDrawables(null, null, null, null);
      break;
      label243:
      paramTextView.setText(d(paramQQUserUIItem));
    }
    label255:
    paramTextView.setCompoundDrawables(null, null, null, null);
    if (!TextUtils.isEmpty(paramQQUserUIItem.qq))
    {
      paramResources = aqdj.a(getQQAppInterface(), 1, paramQQUserUIItem.qq, 3, localDrawable, localDrawable);
      if (paramResources == null)
      {
        paramResources = localDrawable;
        paramImageView.setImageDrawable(paramResources);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label366;
      }
      paramTextView.setText(((ptc)psx.a(23)).a(paramQQUserUIItem, paramString, false, true));
      return;
      break;
      if (jqc.isValidUrl(paramQQUserUIItem.headUrl)) {
        a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      } else {
        paramImageView.setImageDrawable(localDrawable);
      }
    }
    label366:
    paramTextView.setText(d(paramQQUserUIItem));
  }
  
  public static final void a(ImageView paramImageView, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (paramImageView == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "[zivon]PlayModeUtils.setQIMIconImage erroe: item = " + paramQQUserUIItem + ", iconView = " + paramImageView);
      }
      return;
    }
    paramQQUserUIItem = ppg.d.a(paramQQUserUIItem);
    if (!TextUtils.isEmpty(paramQQUserUIItem))
    {
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
      localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramQQUserUIItem, localURLDrawableOptions));
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDrawable, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, qem.d paramd)
  {
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramDrawable;
        localURLDrawableOptions.mFailedDrawable = paramDrawable;
        localURLDrawableOptions.mPlayGifImage = false;
        localURLDrawableOptions.mGifRoundCorner = 0.0F;
        if (paramInt1 > 0) {
          localURLDrawableOptions.mRequestWidth = paramInt1;
        }
        if (paramInt2 > 0) {
          localURLDrawableOptions.mRequestHeight = paramInt2;
        }
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
        if (paramBoolean)
        {
          paramString1 = URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions);
          paramString1.setDecodeHandler(paramDecodeHandler);
          paramString1.setTag(paramObject);
          paramImageView.setImageDrawable(paramString1);
          if (paramString1 == null) {
            return;
          }
          if (paramString1.getStatus() != 1) {
            break;
          }
          if (paramd == null) {
            return;
          }
          paramd.bnM();
          return;
        }
        if (jqc.isValidUrl(paramString1))
        {
          paramString1 = URLDrawable.getDrawable(addParameter(paramString1, "dummypara", "666"), localURLDrawableOptions);
          paramString1.setDecodeHandler(paramDecodeHandler);
          paramString1.setTag(paramObject);
          paramString1.startDownload();
          paramImageView.setImageDrawable(paramString1);
          continue;
        }
        paramImageView.setImageDrawable(null);
      }
      catch (IllegalArgumentException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "setImageView2 fail: " + QLog.getStackTraceString(paramString1));
        }
        paramImageView.setImageDrawable(null);
        return;
      }
      paramString1 = null;
    }
    paramString1.setURLDrawableListener(new qen(System.currentTimeMillis(), paramd));
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, qem.d paramd)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, new ColorDrawable(0), paramDecodeHandler, paramObject, paramString2, paramd);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    b(paramImageView, paramString1, paramString2, paramBoolean, null);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean)
    {
      localDecodeHandler = aqbn.b;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = "StoryPlayModeRound";; str = null)
    {
      if (!ahbj.isFileExists(paramString1)) {
        break label53;
      }
      a(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
      localDecodeHandler = null;
      break;
    }
    label53:
    a(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, qem.d paramd)
  {
    String str = null;
    boolean bool = ahbj.isFileExists(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = aqbn.r;
      if (!paramBoolean) {
        break label73;
      }
      arrayOfInt = dL;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label79;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, ankt.SCREEN_WIDTH / 2, ankt.cIE / 2, bool, localDecodeHandler, arrayOfInt, str, paramd);
      return;
      localDecodeHandler = null;
      break;
      label73:
      arrayOfInt = null;
      break label27;
      label79:
      paramString1 = paramString2;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    a(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    ThreadManager.post(new PlayModeUtils.2(paramStoryVideoItem, paramInt, paramString), 5, null, false);
  }
  
  public static void a(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo, qem.c paramc)
  {
    pyp localpyp = new pyp();
    localpyp.avU = paramShareFromMemoryPlayInfo.uid;
    localpyp.avV = "";
    localpyp.count = 20;
    localpyp.blp = paramShareFromMemoryPlayInfo.shareTimeZone;
    localpyp.feedId = paramShareFromMemoryPlayInfo.feedId;
    localpyp.identify = paramShareFromMemoryPlayInfo.identify;
    localpyp.videoListOrder = paramShareFromMemoryPlayInfo.videoListOrder;
    ppv.a().a(localpyp, new qeq(paramc));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, qem.e parame)
  {
    qqstory_service.ReqBatchGetVideoFullInfoList localReqBatchGetVideoFullInfoList = new qqstory_service.ReqBatchGetVideoFullInfoList();
    localReqBatchGetVideoFullInfoList.vid_list.add(ByteStringMicro.copyFromUtf8(paramString));
    localReqBatchGetVideoFullInfoList.source.set(1);
    long l = System.currentTimeMillis();
    paramString = new Bundle();
    paramString.putLong("key_for_start_time", l);
    jnm.a(paramQQAppInterface, parame, localReqBatchGetVideoFullInfoList.toByteArray(), pzl.CMD, paramString);
  }
  
  protected static final void a(rqa paramrqa, String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      qem.b localb = new qem.b(paramString2, paramStoryVideoItem, paramString3);
      paramrqa.sH(paramString2);
      paramrqa.a(rqj.a(getApplicationContext(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt), paramString1, paramString2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, localb);
      return;
    }
    catch (Exception paramrqa)
    {
      paramString1 = new qem.a(paramString3, 3, paramStoryVideoItem);
      pmi.a().dispatch(paramString1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, paramrqa.getMessage());
    }
  }
  
  public static String addParameter(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&" + paramString2 + "=" + paramString3;
    }
    return paramString1 + "?" + paramString2 + "=" + paramString3;
  }
  
  protected static void b(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, aqhu.at(), paramDecodeHandler, paramObject, paramString2);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean)
    {
      localDecodeHandler = aqbn.b;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = "StoryPlayModeRound";; str = null)
    {
      if (!ahbj.isFileExists(paramString1)) {
        break label53;
      }
      b(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
      localDecodeHandler = null;
      break;
    }
    label53:
    b(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, qem.d paramd)
  {
    String str = null;
    boolean bool = ahbj.isFileExists(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = aqbn.r;
      if (!paramBoolean) {
        break label69;
      }
      arrayOfInt = dL;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, ankt.SCREEN_WIDTH, ankt.cIE, bool, localDecodeHandler, arrayOfInt, str, paramd);
      return;
      localDecodeHandler = null;
      break;
      label69:
      arrayOfInt = null;
      break label27;
      label75:
      paramString1 = paramString2;
    }
  }
  
  public static void b(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    b(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  public static void b(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath))
    {
      paramStoryVideoItem = new qem.a(paramString, 3, paramStoryVideoItem);
      pmi.a().dispatch(paramStoryVideoItem);
    }
    for (;;)
    {
      return;
      if (paramStoryVideoItem.mIsPicture == 1)
      {
        c(paramStoryVideoItem, paramInt, paramString);
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      String str2 = k(paramStoryVideoItem.mVid, false);
      try
      {
        i = a(paramStoryVideoItem, paramInt, str2);
        if (i == 0)
        {
          paramString = new qem.a(paramString, 2, paramStoryVideoItem);
          paramString.outputPath = str2;
          pmi.a().dispatch(paramString);
          long l2 = paramStoryVideoItem.mVideoDuration;
          rar.a("play_video", "down_watermark_time", 1, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - l1), String.valueOf(l2) });
          rar.a("play_video", "down_watermark", 1, 0, new String[0]);
          rar.a("play_video", "down_suc", 1, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        int i;
        for (;;)
        {
          QLog.e("Q.qqstory.player.PlayModeUtils", 1, "watermarkVideoByMediaCodec throw a exception, fallback to ffmpeg method...", new IllegalStateException("CatchedException, caused by: ", localIllegalStateException));
          i = -1;
        }
        QLog.e("Q.qqstory.player.PlayModeUtils", 1, "HardWare Encoder Watermark failed. ErroCode:" + i);
        Object localObject1 = plr.ath + paramStoryVideoItem.mVid + ".mp4";
        rqa localrqa = rqa.a(getApplicationContext());
        if (localrqa.LT())
        {
          if (!localrqa.fF(str2))
          {
            paramStoryVideoItem = new qem.a(paramString, 1, paramStoryVideoItem);
            pmi.a().dispatch(paramStoryVideoItem);
          }
        }
        else
        {
          if (rox.fileExistsAndNotEmpty(str2))
          {
            paramStoryVideoItem = new qem.a(paramString, 2, paramStoryVideoItem);
            paramStoryVideoItem.outputPath = str2;
            pmi.a().dispatch(paramStoryVideoItem);
            return;
          }
          if (rox.fileExistsAndNotEmpty((String)localObject1))
          {
            a(localrqa, (String)localObject1, paramStoryVideoItem, str2, paramInt, paramString);
            return;
          }
          if ((paramStoryVideoItem.getVideoMaskType() == 0) && (!paramStoryVideoItem.isPollVideo()) && (!paramStoryVideoItem.isInteractVideo()))
          {
            a(localrqa, paramStoryVideoItem.mLocalVideoPath, paramStoryVideoItem, str2, paramInt, paramString);
            return;
          }
          Object localObject3 = rqj.a(getApplicationContext(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
          }
          Object localObject2 = rqj.e(paramStoryVideoItem);
          localObject1 = rqj.d(paramStoryVideoItem);
          String str1 = rqj.a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
          while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            str1 = plr.atr;
            str1 = str1 + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
            if (!rqj.g((String)localObject2, (String)localObject1, str1))
            {
              paramStoryVideoItem = new qem.a(paramString, 3, paramStoryVideoItem);
              pmi.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
              return;
              localObject1 = str1;
            }
            else
            {
              localObject1 = str1;
            }
          }
          while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            if (!rqj.g((String)localObject1, (String)localObject3, (String)localObject3))
            {
              paramStoryVideoItem = new qem.a(paramString, 3, paramStoryVideoItem);
              pmi.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg failed");
              return;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localObject2;
              }
            }
            else
            {
              localObject2 = localObject3;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = new qem.b(str2, paramStoryVideoItem, paramString);
              localrqa.sH(str2);
              paramInt = rpv.getRotation(paramStoryVideoItem.mLocalVideoPath);
              if ((paramInt != 0) && (paramInt != -1)) {
                break;
              }
              localrqa.a((String)localObject2, paramStoryVideoItem.mLocalVideoPath, str2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, (rqi)localObject1);
              return;
            }
            catch (Exception localException)
            {
              paramStoryVideoItem = new qem.a(paramString, 3, paramStoryVideoItem);
              pmi.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, localException.getMessage());
              return;
            }
            localObject2 = localException;
            if (TextUtils.isEmpty(localException)) {
              localObject2 = localObject3;
            }
          }
          localObject3 = new ArrayList();
          str1 = plr.ath + "hflip" + paramStoryVideoItem.mVid + ".mp4";
          if (!rox.fileExistsAndNotEmpty(str1))
          {
            localObject4 = new rqg();
            ((rqg)localObject4).cmdType = 10;
            ((rqg)localObject4).nL = new PlayModeUtils.3(paramStoryVideoItem, str1);
            ((rqg)localObject4).d = new rqj.a(localException);
            ((ArrayList)localObject3).add(localObject4);
            localObject4 = new qem.a(paramString, 0, paramStoryVideoItem);
            pmi.a().dispatch((Dispatcher.Dispatchable)localObject4);
          }
          Object localObject4 = new rqg();
          ((rqg)localObject4).cmdType = 1;
          ((rqg)localObject4).nL = new PlayModeUtils.4((String)localObject2, str1, str2, paramStoryVideoItem);
          ((rqg)localObject4).d = localException;
          ((ArrayList)localObject3).add(localObject4);
          localrqa.cu((ArrayList)localObject3);
        }
      }
    }
  }
  
  public static boolean b(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (rpq.isFastDoubleClick()) {
      return false;
    }
    ram.b("Q.qqstory.player.PlayModeUtils", "onClickRetryUploadBtn=%s", paramStoryVideoItem);
    rar.a("mystory", "clk_retry", 0, 0, new String[0]);
    if (pnx.d.eB(paramStoryVideoItem.mUpLoadFailedError))
    {
      ram.w("Q.qqstory.player.PlayModeUtils", "video file not exist, vid:%s", new Object[] { paramStoryVideoItem.mVid });
      String str = paramStoryVideoItem.mVid;
      paramContext = aqha.a(paramContext, 230);
      paramContext.setTitle(acfp.m(2131709691));
      if (pnx.d.eC(paramStoryVideoItem.mUpLoadFailedError)) {
        paramContext.setMessage(acfp.m(2131709698));
      }
      for (;;)
      {
        paramContext.setPositiveButton(acfp.m(2131709697), new qep(paramStoryVideoItem, str));
        paramContext.setCancelable(false);
        paramContext.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        paramContext.show();
        return false;
        paramContext.setMessage(acfp.m(2131709694));
      }
    }
    return pnx.a(paramStoryVideoItem, paramContext);
  }
  
  public static final void c(ImageView paramImageView, String paramString)
  {
    Drawable localDrawable = aqhu.aU();
    paramImageView.setImageDrawable(aqdj.a(getQQAppInterface(), 1, paramString, 3, localDrawable, localDrawable));
  }
  
  @TargetApi(10)
  public static void c(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    qem.a locala = new qem.a(paramString, 0, paramStoryVideoItem);
    pmi.a().dispatch(locala);
    ThreadManager.post(new PlayModeUtils.5(paramStoryVideoItem, paramString, paramInt), 5, null, false);
  }
  
  public static boolean c(StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isMine()) || (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid));
  }
  
  public static String d(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return auW;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  public static boolean d(StoryVideoItem paramStoryVideoItem)
  {
    return paramStoryVideoItem.id == -1000L;
  }
  
  public static int dU(int paramInt)
  {
    if ((paramInt == 76) || (paramInt == 77)) {
      return 221;
    }
    return 220;
  }
  
  public static String dw(String paramString)
  {
    paramString = ((ptf)psx.a(2)).b(paramString);
    if (paramString != null) {
      return paramString.headUrl;
    }
    return null;
  }
  
  public static final String e(QQUserUIItem paramQQUserUIItem)
  {
    return ppg.d.b(paramQQUserUIItem);
  }
  
  public static Context getApplicationContext()
  {
    return BaseApplicationImpl.getApplication().getApplicationContext();
  }
  
  public static String getNickName(String paramString)
  {
    paramString = ((ptf)psx.a(2)).b(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getNickName, userItem is null");
      }
      return auW;
    }
    return d(paramString);
  }
  
  public static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new InvalidParameterException("can't get AppInterface");
  }
  
  public static final String k(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(ShortVideoUtils.getCameraPath());
    if (paramBoolean) {}
    for (String str = ".png";; str = ".mp4") {
      return rqj.ak(paramString, str);
    }
  }
  
  public static void n(TextView paramTextView)
  {
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public static final class a
    extends plt
  {
    public StoryVideoItem g;
    public String key;
    public String outputPath;
    public int status;
    
    public a(String paramString, int paramInt, StoryVideoItem paramStoryVideoItem)
    {
      this.key = paramString;
      this.status = paramInt;
      this.g = paramStoryVideoItem;
    }
  }
  
  public static class b
    implements rqi
  {
    public String axe;
    public StoryVideoItem i;
    public String mOutputPath;
    public long mStartTime;
    
    public b(String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2)
    {
      this.mOutputPath = paramString1;
      this.i = paramStoryVideoItem;
      this.axe = paramString2;
    }
    
    public void onFailure(String paramString)
    {
      paramString = new qem.a(this.axe, 3, this.i);
      pmi.a().dispatch(paramString);
      rar.a("play_video", "down_fail", 0, 0, new String[] { "", "", "", this.i.mVid });
      rar.a("play_video", "down_watermark", 0, 1, new String[0]);
    }
    
    public void onFinish(boolean paramBoolean) {}
    
    public void onProgress(String paramString) {}
    
    public void onStart()
    {
      this.mStartTime = SystemClock.uptimeMillis();
      qem.a locala = new qem.a(this.axe, 0, this.i);
      pmi.a().dispatch(locala);
    }
    
    public void onSuccess(String paramString)
    {
      paramString = new qem.a(this.axe, 2, this.i);
      paramString.outputPath = this.mOutputPath;
      pmi.a().dispatch(paramString);
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.mStartTime;
      long l3 = this.i.mVideoDuration;
      rar.a("play_video", "down_suc", 0, 0, new String[] { "", "", "", this.i.mVid });
      rar.a("play_video", "down_watermark_time", 0, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(l3) });
      rar.a("play_video", "down_watermark", 0, 0, new String[0]);
      rox.a(BaseApplication.getContext(), new File(this.mOutputPath));
    }
  }
  
  public static abstract interface c
  {
    public abstract void wg(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bnM();
    
    public abstract void bnN();
  }
  
  public static abstract class e
    extends jnm.b
  {
    public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      long l = paramBundle.getLong("key_for_start_time");
      l = System.currentTimeMillis() - l;
      Object localObject1 = new qqstory_service.RspBatchGetVideoFullInfoList();
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        a(paramInt, null, null);
        rar.b("story_net", pzl.CMD, 0, paramInt, new String[] { "", l + "", rar.getNetworkType(BaseApplication.getContext()) });
        return null;
      }
      for (;;)
      {
        try
        {
          ((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).mergeFrom(paramArrayOfByte);
          paramArrayOfByte = (qqstory_struct.ErrorInfo)((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).result.get();
          Object localObject2 = (qqstory_struct.StoryVideoFullInfo)((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).video_list.get(0);
          paramBundle = paramArrayOfByte.error_desc.get().toStringUtf8();
          paramInt = paramArrayOfByte.error_code.get();
          if (paramInt == 0)
          {
            paramBundle = new StoryVideoItem();
            paramBundle.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject2);
            paramBundle.mInteractStatus = ((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).interact_status.get();
            if (paramBundle.mErrorCode == 0) {
              ((psu)psx.a(5)).a(paramBundle.mVid, paramBundle);
            }
            localObject2 = ((qqstory_struct.StoryVideoFullInfo)localObject2).compressed_video.get();
            if (localObject2 != null)
            {
              localObject1 = new ArrayList(((List)localObject2).size());
              localObject2 = ((List)localObject2).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                qqstory_struct.VideoUrl localVideoUrl = (qqstory_struct.VideoUrl)((Iterator)localObject2).next();
                VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
                localVideoUrlEntry.vid = paramBundle.mVid;
                localVideoUrlEntry.videoUrlLevel = localVideoUrl.video_level.get();
                localVideoUrlEntry.videoUrl = localVideoUrl.video_url.get();
                ((List)localObject1).add(localVideoUrlEntry);
                continue;
              }
            }
          }
          a(paramInt, paramBundle, null);
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getVideoInfo - onResult, InvalidProtocolBufferMicroException, e:" + paramArrayOfByte.getMessage());
          }
          a(-1, null, null);
          return null;
          ((pmq)psx.a(28)).dT((List)localObject1);
          a(paramInt, null, paramBundle);
          rar.b("story_net", pzl.CMD, 0, paramInt, new String[] { "", l + "", rar.getNetworkType(BaseApplication.getContext()) });
          return paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getVideoInfo - onResult, other exception, e:" + paramArrayOfByte.getMessage());
          }
          a(-1, null, null);
          return null;
        }
      }
    }
    
    public abstract void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qem
 * JD-Core Version:    0.7.0.1
 */