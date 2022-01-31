package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import eff;
import efg;
import java.io.File;
import java.net.URL;

public class PicItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  public static long a = 0L;
  public static float b = 0.0F;
  static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "PicItemBuilder";
  public static float c;
  static long c;
  public static int e;
  protected final float a;
  private boolean d = false;
  
  static
  {
    jdField_a_of_type_Long = 1500L;
    jdField_b_of_type_Float = 0.5F;
    jdField_c_of_type_Float = 1.0F;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 1000L;
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    Object localObject1 = URLDrawableHelper.a(paramMessageForPic, 65537, null);
    Object localObject3 = ((URL)localObject1).toString();
    Object localObject2 = paramContext.getResources();
    if (paramChatThumbView != null) {
      paramChatThumbView.jdField_a_of_type_Boolean = false;
    }
    if (BaseApplicationImpl.a.get(localObject3) != null)
    {
      paramContext = URLDrawable.getDrawable((URL)localObject1, false);
      paramContext.setTag(paramMessageForPic);
      return paramContext;
    }
    localObject3 = AbsDownloader.a((String)localObject3);
    int k;
    int m;
    int i;
    float f1;
    int j;
    label379:
    float f2;
    label395:
    label412:
    int n;
    if (localObject3 != null)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(((File)localObject3).getAbsolutePath(), (BitmapFactory.Options)localObject2);
      int i1 = paramContext.getResources().getDisplayMetrics().densityDpi;
      k = ((BitmapFactory.Options)localObject2).outWidth;
      m = ((BitmapFactory.Options)localObject2).outHeight;
      i = URLDrawableHelper.a(((File)localObject3).getAbsolutePath());
      if ((i == 90) || (i == 270))
      {
        k = ((BitmapFactory.Options)localObject2).outHeight;
        m = ((BitmapFactory.Options)localObject2).outWidth;
      }
      if ((k < URLDrawableHelper.f) || (m < URLDrawableHelper.f)) {
        if (k < m)
        {
          f1 = URLDrawableHelper.f / k;
          k = URLDrawableHelper.f;
          m = (int)(m * f1 + 0.5F);
          i = m;
          j = k;
          if (m > URLDrawableHelper.g)
          {
            i = URLDrawableHelper.g;
            j = k;
          }
        }
      }
      do
      {
        for (;;)
        {
          localObject1 = URLDrawable.getDrawable((URL)localObject1, new EmptyDrawable((j * i1 + 80) / 160, (i * i1 + 80) / 160), URLDrawableHelper.b, false);
          ((URLDrawable)localObject1).setIgnorePause(true);
          ((URLDrawable)localObject1).setFadeInImage(true);
          paramContext = (Context)localObject1;
          if (paramChatThumbView == null) {
            break;
          }
          paramChatThumbView.jdField_a_of_type_Boolean = true;
          paramContext = (Context)localObject1;
          break;
          j = (int)(URLDrawableHelper.f / m * k + 0.5F);
          i = j;
          if (j > URLDrawableHelper.g) {
            i = URLDrawableHelper.g;
          }
          k = URLDrawableHelper.f;
          j = i;
          i = k;
        }
        if (k >= URLDrawableHelper.g) {
          break label379;
        }
        i = m;
        j = k;
      } while (m < URLDrawableHelper.g);
      if (k > m)
      {
        f1 = URLDrawableHelper.g / k;
        if (k <= m) {
          break label508;
        }
        f2 = URLDrawableHelper.f / m;
        if (f1 <= f2) {
          break label521;
        }
      }
      label521:
      for (float f3 = f1;; f3 = f2)
      {
        i = m;
        j = k;
        if (f1 >= f2) {
          break;
        }
        n = k;
        if (k > m) {
          n = (int)(URLDrawableHelper.g / f3 + 0.5F);
        }
        i = m;
        j = n;
        if (n > m) {
          break;
        }
        i = (int)(URLDrawableHelper.g / f3 + 0.5F);
        j = n;
        break;
        f1 = URLDrawableHelper.g / m;
        break label395;
        label508:
        f2 = URLDrawableHelper.f / k;
        break label412;
      }
    }
    if (!URLDrawableHelper.a(paramContext))
    {
      k = 1;
      label538:
      j = paramMessageForPic.thumbWidth;
      i = paramMessageForPic.thumbHeight;
      if ((j <= 0) || (i <= 0)) {
        break label993;
      }
      if ((j >= URLDrawableHelper.f) && (i >= URLDrawableHelper.f)) {
        break label806;
      }
      if (j >= i) {
        break label755;
      }
      f1 = URLDrawableHelper.f / j;
      m = URLDrawableHelper.f;
      n = (int)(f1 * i + 0.5F);
      i = n;
      j = m;
      if (n > URLDrawableHelper.g)
      {
        i = URLDrawableHelper.g;
        j = m;
      }
      label633:
      f1 = ((Resources)localObject2).getDisplayMetrics().densityDpi / 160.0F;
      j = (int)(j * f1 + 0.5F);
      i = (int)(i * f1 + 0.5F);
      if (!(URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof SkinnableBitmapDrawable)) {
        break label1046;
      }
      paramContext = URLDrawable.getDrawable((URL)localObject1, new BitmapDrawableWithMargin((Resources)localObject2, ((SkinnableBitmapDrawable)URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), j, i, -921103), URLDrawableHelper.b, false);
      label714:
      if ((!PicContants.b) && (k == 0)) {
        break label1111;
      }
      paramContext.setAutoDownload(true);
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.jdField_a_of_type_AndroidGraphicsBitmap, 0, false));
      break;
      k = 0;
      break label538;
      label755:
      j = (int)(URLDrawableHelper.f / i * j + 0.5F);
      i = j;
      if (j > URLDrawableHelper.g) {
        i = URLDrawableHelper.g;
      }
      m = URLDrawableHelper.f;
      j = i;
      i = m;
      break label633;
      label806:
      if ((j < URLDrawableHelper.g) && (i < URLDrawableHelper.g)) {
        break label633;
      }
      if (j > i)
      {
        f1 = URLDrawableHelper.g / j;
        label841:
        if (j <= i) {
          break label911;
        }
        f2 = URLDrawableHelper.f / i;
        label858:
        Math.max(f1, f2);
        if (f1 >= f2) {
          break label940;
        }
        if (j <= i) {
          break label924;
        }
      }
      label911:
      label924:
      for (j = URLDrawableHelper.g;; j = URLDrawableHelper.f)
      {
        if (i <= j) {
          break label932;
        }
        i = URLDrawableHelper.g;
        break;
        f1 = URLDrawableHelper.g / i;
        break label841;
        f2 = URLDrawableHelper.f / j;
        break label858;
      }
      label932:
      i = URLDrawableHelper.f;
      break label633;
      label940:
      if (j > i) {}
      for (f1 = URLDrawableHelper.g / j;; f1 = URLDrawableHelper.g / i)
      {
        j = (int)(j * f1 + 0.5F);
        i = (int)(f1 * i + 0.5F);
        break;
      }
      label993:
      if (QLog.isColorLevel()) {
        QLog.d("PicItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + j + ", height = " + i);
      }
      j = 99;
      i = 99;
      break label633;
      label1046:
      if ((URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))
      {
        paramContext = URLDrawable.getDrawable((URL)localObject1, new BitmapDrawableWithMargin((Resources)localObject2, ((BitmapDrawable)URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap(), j, i, -921103), URLDrawableHelper.b, false);
        break label714;
      }
      paramContext = URLDrawable.getDrawable((URL)localObject1, URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable, URLDrawableHelper.b, false);
      break label714;
      label1111:
      paramContext.setAutoDownload(false);
    }
  }
  
  public static void a(Context paramContext, View paramView, MessageForPic paramMessageForPic, SessionInfo paramSessionInfo)
  {
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic), AIOGalleryUtils.a(paramMessageForPic));
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2)
  {
    a(paramMessageForPic, paramString1, paramString2, null);
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2, Throwable paramThrowable)
  {
    RichMediaUtil.a(paramMessageForPic.istroop, paramMessageForPic.isSendFromLocal(), 65537, String.valueOf(paramMessageForPic.uniseq), "PicItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, PicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)paramIHttpCommunicatorListener.c();
      if ((i != 1004) || (!paramIHttpCommunicatorListener.b()) || (!paramIHttpCommunicatorListener.c())) {
        break label743;
      }
      i = 1006;
    }
    label743:
    for (;;)
    {
      Object localObject;
      switch (i)
      {
      default: 
        if (PicItemBuilder.Holder.a(paramHolder) != null)
        {
          PicItemBuilder.Holder.a(paramHolder).clearAnimation();
          PicItemBuilder.Holder.a(paramHolder).setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(PicItemBuilder.Holder.a(paramHolder));
          PicItemBuilder.Holder.a(paramHolder, null);
        }
        if (PicItemBuilder.Holder.a(paramHolder) == null) {
          break;
        }
        PicItemBuilder.Holder.a(paramHolder).setVisibility(8);
        return;
      case 1006: 
        if (this.d) {
          break;
        }
        if (PicItemBuilder.Holder.a(paramHolder) == null)
        {
          paramIHttpCommunicatorListener = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          paramIHttpCommunicatorListener.setImageResource(2130839623);
          paramIHttpCommunicatorListener.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131231604);
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131231604);
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131231604);
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131231604);
          if (paramHolder.jdField_a_of_type_AndroidViewView != null) {
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(paramIHttpCommunicatorListener, (ViewGroup.LayoutParams)localObject);
          }
          PicItemBuilder.Holder.a(paramHolder, paramIHttpCommunicatorListener);
        }
        PicItemBuilder.Holder.a(paramHolder).setVisibility(0);
        if (PicItemBuilder.Holder.a(paramHolder) == null) {
          break;
        }
        PicItemBuilder.Holder.a(paramHolder).clearAnimation();
        PicItemBuilder.Holder.a(paramHolder).setProcessor(null);
        ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(PicItemBuilder.Holder.a(paramHolder));
        PicItemBuilder.Holder.a(paramHolder, null);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1004: 
      case 4001: 
        if (PicItemBuilder.Holder.a(paramHolder) != null) {
          PicItemBuilder.Holder.a(paramHolder).setVisibility(8);
        }
        if (PicItemBuilder.Holder.a(paramHolder) == null)
        {
          localObject = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          ((MessageProgressTextView)localObject).setTextColor(-1);
          ((MessageProgressTextView)localObject).setTextSize(2, 15.0F);
          ((MessageProgressTextView)localObject).setGravity(17);
          if (jdField_a_of_type_Boolean) {
            ((MessageProgressTextView)localObject).setDisplayInTextView(false, (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), -1);
          }
          ((MessageProgressTextView)localObject).setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_a_of_type_Float * 12.0F));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(6, 2131231604);
          localLayoutParams.addRule(8, 2131231604);
          localLayoutParams.addRule(5, 2131231604);
          localLayoutParams.addRule(7, 2131231604);
          if (paramHolder.jdField_a_of_type_AndroidViewView != null) {
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView((View)localObject, localLayoutParams);
          }
          PicItemBuilder.Holder.a(paramHolder, (MessageProgressTextView)localObject);
        }
        PicItemBuilder.Holder.a(paramHolder).setProcessor(paramIHttpCommunicatorListener);
        PicItemBuilder.Holder.a(paramHolder).setVisibility(0);
        if (i != 1002) {
          if ((e == 0) || (e == 2))
          {
            paramIHttpCommunicatorListener = new AlphaAnimation(jdField_b_of_type_Float, jdField_c_of_type_Float);
            paramIHttpCommunicatorListener.setDuration(jdField_a_of_type_Long);
            paramIHttpCommunicatorListener.setRepeatCount(-1);
            paramIHttpCommunicatorListener.setRepeatMode(2);
            PicItemBuilder.Holder.a(paramHolder).startAnimation(paramIHttpCommunicatorListener);
            switch (i)
            {
            }
          }
        }
        for (;;)
        {
          PicItemBuilder.Holder.a(paramHolder).a();
          return;
          PicItemBuilder.Holder.a(paramHolder).clearAnimation();
          break;
          PicItemBuilder.Holder.a(paramHolder).clearAnimation();
          break;
          PicItemBuilder.Holder.a(paramHolder).setProgress(0);
          return;
          PicItemBuilder.Holder.a(paramHolder).setProgress(0);
        }
        if (PicItemBuilder.Holder.a(paramHolder) != null)
        {
          PicItemBuilder.Holder.a(paramHolder).clearAnimation();
          PicItemBuilder.Holder.a(paramHolder).setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(PicItemBuilder.Holder.a(paramHolder));
          PicItemBuilder.Holder.a(paramHolder, null);
        }
        if (PicItemBuilder.Holder.a(paramHolder) == null) {
          break;
        }
        PicItemBuilder.Holder.a(paramHolder).setVisibility(8);
        return;
      }
    }
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.a(paramMessageForPic.path);
    localBuilder.d(5);
    localBuilder.d(paramMessageForPic.frienduin);
    localBuilder.c(TranDbRecord.PicDbRecord.e);
    localBuilder.e(paramMessageForPic.senderuin);
    localBuilder.c(paramMessageForPic.selfuin);
    localBuilder.e(paramMessageForPic.istroop);
    PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
    localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
    localRetryInfo.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
    localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
    localBuilder.a(localRetryInfo);
    paramMessageForPic = PicBusiManager.a(3, 5);
    paramMessageForPic.a(localBuilder.a());
    PicBusiManager.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void c(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new PicFowardInfo();
    Object localObject2 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject2).d(1009);
    ((PicUploadInfo.Builder)localObject2).a(paramMessageForPic.path);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.istroop);
    ((PicUploadInfo.Builder)localObject2).c(paramMessageForPic.selfuin);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.senderuin);
    ((PicUploadInfo.Builder)localObject2).d(paramMessageForPic.frienduin);
    ((PicUploadInfo.Builder)localObject2).c(TranDbRecord.PicDbRecord.g);
    ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = ((PicUploadInfo.Builder)localObject2).a();
    if ((!FileUtils.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)paramMessageForPic.picExtraObject;
      PicDownloadInfo.Builder localBuilder = new PicDownloadInfo.Builder();
      localBuilder.a(1009);
      localBuilder.a(paramMessageForPic.selfuin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).jdField_a_of_type_JavaLangString);
      localBuilder.b(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Int);
      localBuilder.d(((PicFowardDbRecordData)localObject2).b);
      localBuilder.a(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Long);
      localBuilder.e(paramMessageForPic.md5);
      localBuilder.f(paramMessageForPic.issend);
      ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = localBuilder.a();
    }
    paramMessageForPic = PicBusiManager.a(2, 1009);
    paramMessageForPic.a((PicFowardInfo)localObject1);
    PicBusiManager.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PicItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131231604);
      paramView.setAdjustViewBounds(true);
      paramView.setMaxWidth((int)(this.jdField_a_of_type_Float * 100.0F + 0.5F));
      paramView.setMaxHeight((int)(this.jdField_a_of_type_Float * 100.0F + 0.5F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramViewHolder.addView(paramView, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      PicItemBuilder.Holder.a(paramBaseChatItemLayout, paramView);
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramViewHolder, this);
    }
    if (!paramChatMessage.isSendFromLocal())
    {
      if (PicItemBuilder.Holder.a(paramBaseChatItemLayout) != null)
      {
        PicItemBuilder.Holder.a(paramBaseChatItemLayout).setVisibility(8);
        PicItemBuilder.Holder.a(paramBaseChatItemLayout).clearAnimation();
        PicItemBuilder.Holder.a(paramBaseChatItemLayout).setProcessor(null);
        ((RelativeLayout)paramBaseChatItemLayout.jdField_a_of_type_AndroidViewView).removeView(PicItemBuilder.Holder.a(paramBaseChatItemLayout));
        PicItemBuilder.Holder.a(paramBaseChatItemLayout, null);
      }
      if (PicItemBuilder.Holder.a(paramBaseChatItemLayout) != null) {
        PicItemBuilder.Holder.a(paramBaseChatItemLayout).setVisibility(8);
      }
      paramView = URLDrawableHelper.a(paramChatMessage, 65537);
      if ((PicItemBuilder.Holder.a(paramBaseChatItemLayout) == null) || (!PicItemBuilder.Holder.a(paramBaseChatItemLayout).getURL().equals(paramView)))
      {
        paramView = a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, PicItemBuilder.Holder.a(paramBaseChatItemLayout));
        PicItemBuilder.Holder.a(paramBaseChatItemLayout).setImageDrawable(paramView);
        PicItemBuilder.Holder.a(paramBaseChatItemLayout, paramView);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage, 2);
      }
      return paramViewHolder;
    }
    paramView = URLDrawableHelper.a(paramChatMessage, 65537);
    if ((PicItemBuilder.Holder.a(paramBaseChatItemLayout) == null) || (!PicItemBuilder.Holder.a(paramBaseChatItemLayout).getURL().equals(paramView)))
    {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, PicItemBuilder.Holder.a(paramBaseChatItemLayout));
      PicItemBuilder.Holder.a(paramBaseChatItemLayout).setImageDrawable(paramView);
      PicItemBuilder.Holder.a(paramBaseChatItemLayout, paramView);
    }
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewView = paramViewHolder;
    a(paramChatMessage, paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PicItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558898);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localObject2 = (MessageForPic)paramChatMessage;
      if (paramInt != 2131231190) {
        break label524;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      paramChatMessage = new Intent(paramContext, ForwardRecentActivity.class);
      paramChatMessage.putExtra("forward_filepath", ((MessageForPic)localObject2).path);
      paramContext = ((MessageForPic)localObject2).frienduin + ((MessageForPic)localObject2).uniseq + ((MessageForPic)localObject2).istroop;
      paramChatMessage.putExtra("BUSI_TYPE", 1009);
      paramChatMessage.putExtra("forward_download_image_task_key", paramContext);
      paramChatMessage.putExtra("forward_download_image_org_uin", ((MessageForPic)localObject2).frienduin);
      paramChatMessage.putExtra("forward_download_image_org_uin_type", ((MessageForPic)localObject2).istroop);
      paramChatMessage.putExtra("forward_download_image_server_path", ((MessageForPic)localObject2).uuid);
      paramChatMessage.putExtra("forward_download_image_item_id", ((MessageForPic)localObject2).uniseq);
      paramChatMessage.putExtra("forward_photo_isSend", ((MessageForPic)localObject2).issend);
      paramChatMessage.putExtra("forward_photo_md5", ((MessageForPic)localObject2).md5);
      paramChatMessage.putExtra("forward_photo_group_fileid", ((MessageForPic)localObject2).groupFileID);
      paramChatMessage.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", ((MessageForPic)localObject2).fileSizeFlag);
      paramChatMessage.putExtras(localBundle);
      if ((!ActionMsgUtil.a(((MessageForPic)localObject2).msgtype)) && (((MessageForPic)localObject2).msgtype != -3001) && (((MessageForPic)localObject2).msgtype != -30002) && (((MessageForPic)localObject2).msgtype != -30003)) {
        break label436;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label441;
      }
      paramInt = 65537;
      label289:
      paramContext = URLDrawableHelper.a((PicUiInterface)localObject2, paramInt);
      paramChatMessage.putExtra("forward_urldrawable", true);
      paramChatMessage.putExtra("forward_urldrawable_thumb_url", paramContext.toString());
      paramChatMessage.putExtra("FORWARD_URL_KEY", ((MessageForPic)localObject2).localUUID);
      paramContext = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2);
      paramChatMessage.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      if (!new File(((MessageForPic)localObject2).path).exists()) {
        break label446;
      }
      paramChatMessage.putExtra("forward_extra", ((MessageForPic)localObject2).path);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    }
    label436:
    label441:
    label446:
    do
    {
      return;
      paramInt = 0;
      break;
      paramInt = 1;
      break label289;
      paramContext = paramContext.getURL().toString();
      if (AbsDownloader.a(paramContext)) {
        paramContext = AbsDownloader.a(paramContext).getAbsolutePath();
      }
      for (;;)
      {
        paramChatMessage.putExtra("forward_extra", paramContext);
        break;
        localObject2 = AbsDownloader.a(URLDrawableHelper.a((PicUiInterface)localObject2, 65537).toString());
        paramContext = localObject1;
        if (localObject2 != null)
        {
          paramContext = localObject1;
          if (((File)localObject2).exists()) {
            paramContext = ((File)localObject2).getAbsolutePath();
          }
        }
      }
      if (paramInt == 2131230764)
      {
        paramContext = URLDrawable.getDrawable(URLDrawableHelper.a((PicUiInterface)localObject2, 1), -1, -1, null, null, false);
        paramContext.setTag(localObject2);
        AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, ((MessageForPic)localObject2).frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
        return;
      }
      if (paramInt == 2131234872)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131234875)
      {
        a((MessageForPic)localObject2);
        return;
      }
      if (paramInt == 2131231192)
      {
        QfavBuilder.a((Entity)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
        return;
      }
      if (paramInt == 2131234873)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((ChatActivity)paramContext).a(paramChatMessage);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 2131234874);
    label524:
    paramContext = new eff(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramContext);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForPic)((PicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131562859, 5);
      localActionSheet.d(2131561746);
      localActionSheet.a(new efg(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((localMessageForPic.uniseq == paramFileMsg.jdField_c_of_type_Long) && (localMessageForPic.isSendFromLocal()))
    {
      a(localMessageForPic, "transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + localMessageForPic.uniseq + ",file.uniseq:" + paramFileMsg.jdField_c_of_type_Long);
      switch (paramFileMsg.e)
      {
      }
    }
    do
    {
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
    } while (paramInt1 != 1005);
    a();
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    if (FileUtils.b(paramMessageForPic.path)) {
      b(paramMessageForPic);
    }
    for (;;)
    {
      a();
      return;
      if (paramMessageForPic.picExtraFlag == TranDbRecord.PicDbRecord.g) {
        c(paramMessageForPic);
      }
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = (MessageForPic)paramChatMessage;
      if (paramChatMessage.size <= 0L)
      {
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if ((paramChatMessage instanceof BaseTransProcessor)) {
          return ((BaseTransProcessor)paramChatMessage).c() == 1005L;
        }
        return true;
      }
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = new QQCustomMenu();
    this.d = true;
    if (!localMessageForPic.isSendFromLocal())
    {
      if (PicItemBuilder.Holder.a((PicItemBuilder.Holder)localObject).getStatus() == 1)
      {
        paramView.a(2131230764, this.jdField_a_of_type_AndroidContentContext.getString(2131561605));
        paramView.a(2131231190, this.jdField_a_of_type_AndroidContentContext.getString(2131562129));
        paramView.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      return paramView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localMessageForPic.size > 0L)
    {
      paramView.a(2131230764, this.jdField_a_of_type_AndroidContentContext.getString(2131561605));
      paramView.a(2131231190, this.jdField_a_of_type_AndroidContentContext.getString(2131562129));
      paramView.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
      ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    for (;;)
    {
      return paramView.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        if (((BaseTransProcessor)localObject).c() == 1005L)
        {
          paramView.a(2131234875, this.jdField_a_of_type_AndroidContentContext.getString(2131562860));
          paramView.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
          ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        else if ((((BaseTransProcessor)localObject).c() != 1003L) && (((BaseTransProcessor)localObject).d() != 1003L))
        {
          paramView.a(2131234873, this.jdField_a_of_type_AndroidContentContext.getString(2131561759));
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            paramView.a(2131234874, this.jdField_a_of_type_AndroidContentContext.getString(2131561644));
          }
        }
      }
      else
      {
        paramView.a(2131234875, this.jdField_a_of_type_AndroidContentContext.getString(2131562860));
        paramView.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.d = false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131230779)
    {
      paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
      MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      Object localObject = PicItemBuilder.Holder.a(paramView);
      if (!localMessageForPic.isSendFromLocal()) {
        switch (((URLDrawable)localObject).getStatus())
        {
        }
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
          ((URLDrawable)localObject).restartDownload();
          return;
        } while (((URLDrawable)localObject).isDownloadStarted());
        ((URLDrawable)localObject).startDownload();
        return;
        a(this.jdField_a_of_type_AndroidContentContext, PicItemBuilder.Holder.a(paramView), localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
        if (((URLDrawable)localObject).getStatus() != 2) {
          break;
        }
      } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
      ((URLDrawable)localObject).restartDownload();
      return;
      if (localMessageForPic.size <= 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
        if ((localObject instanceof BaseTransProcessor))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((((BaseTransProcessor)localObject).b()) && (((BaseTransProcessor)localObject).c()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageForPic.frienduin, String.valueOf(localMessageForPic.uniseq));
            return;
          }
        }
      }
      a(this.jdField_a_of_type_AndroidContentContext, PicItemBuilder.Holder.a(paramView), localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder
 * JD-Core Version:    0.7.0.1
 */