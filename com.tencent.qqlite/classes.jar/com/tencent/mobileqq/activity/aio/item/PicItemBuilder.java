package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bwi;
import bwj;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
  public static boolean e;
  public static int f;
  public static boolean f;
  public static boolean g;
  protected final float a;
  protected final boolean d;
  private boolean h = false;
  
  static
  {
    jdField_e_of_type_Boolean = false;
    f = false;
    g = false;
    jdField_e_of_type_Int = 100;
    jdField_a_of_type_Long = 1000L;
    jdField_b_of_type_Float = 0.3F;
    jdField_c_of_type_Float = 1.0F;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 1000L;
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, false);
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.d = paramBoolean;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    boolean bool = false;
    Object localObject1;
    if (paramMessageForPic.imageType == 3) {
      if (!jdField_e_of_type_Boolean)
      {
        localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 3)
          {
            f = localObject1[0].equals("1");
            g = localObject1[1].equals("1");
          }
        }
      }
    }
    label769:
    label1025:
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      int i1;
      try
      {
        jdField_e_of_type_Int = Integer.parseInt(localObject1[2]);
        if (jdField_e_of_type_Int < 0) {
          jdField_e_of_type_Int = 100;
        }
        com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = jdField_e_of_type_Int;
        jdField_e_of_type_Boolean = true;
        if (!f) {
          break label1331;
        }
        localObject1 = URLDrawableHelper.a(paramMessageForPic, 1, null);
        localObject2 = AbsDownloader.a(((URL)localObject1).toString());
        if (localObject2 == null) {
          break label1331;
        }
        try
        {
          localObject2 = NativeGifImage.getImageSize((File)localObject2, false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          localObject2 = null;
          localURLDrawable = null;
          continue;
          localObject4 = AbsDownloader.a((String)localObject4);
          if (localObject4 == null) {
            break label795;
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = URLDrawableHelper.a(paramMessageForPic, 65537, null);
        }
        localObject4 = ((URL)localObject3).toString();
        localObject1 = paramContext.getResources();
        i1 = ((Resources)localObject1).getDisplayMetrics().densityDpi;
        if (paramChatThumbView != null) {
          paramChatThumbView.jdField_a_of_type_Boolean = false;
        }
        if (BaseApplicationImpl.a.get(localObject4) != null)
        {
          paramContext = URLDrawable.getDrawable((URL)localObject3, 0, 0, null, null, true, 12.0F * (i1 / 160));
          paramContext.setTag(paramMessageForPic);
          return paramContext;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        jdField_e_of_type_Int = 100;
        continue;
      }
      int j;
      int i;
      label296:
      float f1;
      float f2;
      int k;
      if (localObject2 != null)
      {
        j = ((Rect)localObject2).width();
        i = ((Rect)localObject2).height();
        f1 = i1 / 160 * 12.0F;
        if ((j >= URLDrawableHelper.jdField_e_of_type_Int) && (i >= URLDrawableHelper.jdField_e_of_type_Int)) {
          break label634;
        }
        if (j >= i) {
          break label579;
        }
        f2 = URLDrawableHelper.jdField_e_of_type_Int / j;
        j = URLDrawableHelper.jdField_e_of_type_Int;
        k = (int)(i * f2 + 0.5F);
        i = k;
        if (k > URLDrawableHelper.f) {
          i = URLDrawableHelper.f;
        }
        label374:
        k = j;
        f1 = f2 * f1;
        j = i;
        i = k;
        label391:
        i = (i * i1 + 80) / 160;
        j = (j * i1 + 80) / 160;
        if (localObject2 == null) {
          break label1328;
        }
        if (((Rect)localObject2).width() >= i) {
          break label769;
        }
        f1 *= ((Rect)localObject2).width() / i;
      }
      label682:
      label1328:
      for (;;)
      {
        localURLDrawable = URLDrawable.getDrawable((URL)localObject3, i, j, new EmptyDrawable(i, j), URLDrawableHelper.b, true, f1);
        localURLDrawable.setIgnorePause(true);
        localURLDrawable.setFadeInImage(true);
        paramContext = localURLDrawable;
        if (paramChatThumbView == null) {
          break;
        }
        paramChatThumbView.jdField_a_of_type_Boolean = true;
        paramContext = localURLDrawable;
        break;
        paramContext = new BitmapFactory.Options();
        paramContext.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(((File)localObject4).getAbsolutePath(), paramContext);
        j = paramContext.outWidth;
        i = paramContext.outHeight;
        k = URLDrawableHelper.a(((File)localObject4).getAbsolutePath());
        if ((k != 90) && (k != 270)) {
          break label296;
        }
        j = paramContext.outHeight;
        i = paramContext.outWidth;
        break label296;
        label579:
        f2 = URLDrawableHelper.jdField_e_of_type_Int / i;
        j = (int)(j * f2 + 0.5F);
        i = j;
        if (j > URLDrawableHelper.f) {
          i = URLDrawableHelper.f;
        }
        k = URLDrawableHelper.jdField_e_of_type_Int;
        j = i;
        i = k;
        break label374;
        label634:
        if ((j < URLDrawableHelper.f) && (i < URLDrawableHelper.f))
        {
          k = i;
          i = j;
          j = k;
          break label391;
        }
        if (j > i)
        {
          f2 = URLDrawableHelper.f / j;
          if (j <= i) {
            break label756;
          }
        }
        label756:
        for (float f3 = URLDrawableHelper.jdField_e_of_type_Int / i;; f3 = URLDrawableHelper.jdField_e_of_type_Int / j)
        {
          f2 = Math.max(f2, f3);
          j = (int)(j * f2 + 0.5F);
          k = (int)(i * f2 + 0.5F);
          i = j;
          j = k;
          break;
          f2 = URLDrawableHelper.f / i;
          break label682;
        }
        if (((Rect)localObject2).height() < j)
        {
          f1 *= ((Rect)localObject2).height() / j;
          continue;
          int m;
          if (!URLDrawableHelper.a(paramContext))
          {
            k = 1;
            j = paramMessageForPic.thumbWidth;
            i = paramMessageForPic.thumbHeight;
            if ((j <= 0) || (i <= 0)) {
              break label1185;
            }
            if ((j >= URLDrawableHelper.jdField_e_of_type_Int) && (i >= URLDrawableHelper.jdField_e_of_type_Int)) {
              break label1076;
            }
            if (j >= i) {
              break label1025;
            }
            f1 = URLDrawableHelper.jdField_e_of_type_Int / j;
            m = URLDrawableHelper.jdField_e_of_type_Int;
            int n = (int)(f1 * i + 0.5F);
            i = n;
            j = m;
            if (n > URLDrawableHelper.f)
            {
              i = URLDrawableHelper.f;
              j = m;
            }
            f1 = i1 / 160.0F;
            j = (int)(j * f1 + 0.5F);
            i = (int)(i * f1 + 0.5F);
            if (!(URLDrawableHelper.a instanceof SkinnableBitmapDrawable)) {
              break label1240;
            }
            paramContext = URLDrawable.getDrawable((URL)localObject3, j, i, new BitmapDrawableWithMargin(localURLDrawable, ((SkinnableBitmapDrawable)URLDrawableHelper.a).getBitmap(), j, i, -921103), URLDrawableHelper.b, bool, 12.0F);
            label984:
            if ((!PicContants.b) && (k == 0)) {
              break label1320;
            }
            paramContext.setAutoDownload(true);
          }
          for (;;)
          {
            paramContext.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.a(), 0, false));
            break;
            k = 0;
            break label805;
            j = (int)(URLDrawableHelper.jdField_e_of_type_Int / i * j + 0.5F);
            i = j;
            if (j > URLDrawableHelper.f) {
              i = URLDrawableHelper.f;
            }
            m = URLDrawableHelper.jdField_e_of_type_Int;
            j = i;
            i = m;
            break label900;
            label1076:
            if ((j < URLDrawableHelper.f) && (i < URLDrawableHelper.f)) {
              break label900;
            }
            if (j > i)
            {
              f1 = URLDrawableHelper.f / j;
              label1111:
              if (j <= i) {
                break label1172;
              }
            }
            for (f2 = URLDrawableHelper.jdField_e_of_type_Int / i;; f2 = URLDrawableHelper.jdField_e_of_type_Int / j)
            {
              f1 = Math.max(f1, f2);
              j = (int)(j * f1 + 0.5F);
              i = (int)(f1 * i + 0.5F);
              break;
              f1 = URLDrawableHelper.f / i;
              break label1111;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PicItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + j + ", height = " + i);
            }
            j = 99;
            i = 99;
            break label900;
            label1240:
            if ((URLDrawableHelper.a instanceof BitmapDrawable))
            {
              paramContext = URLDrawable.getDrawable((URL)localObject3, j, i, new BitmapDrawableWithMargin(localURLDrawable, ((BitmapDrawable)URLDrawableHelper.a).getBitmap(), j, i, -921103), URLDrawableHelper.b, bool, 12.0F);
              break label984;
            }
            paramContext = URLDrawable.getDrawable((URL)localObject3, j, i, URLDrawableHelper.a, URLDrawableHelper.b, bool, 12.0F);
            break label984;
            paramContext.setAutoDownload(false);
          }
        }
      }
      label795:
      label805:
      label1320:
      label1331:
      Object localObject2 = null;
      label900:
      label1172:
      label1185:
      URLDrawable localURLDrawable = null;
    }
  }
  
  public static void a(Context paramContext, View paramView, MessageForPic paramMessageForPic, SessionInfo paramSessionInfo)
  {
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if (((paramContext instanceof ChatActivity)) && (!(paramContext instanceof MultiForwardActivity))) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((ChatActivity)paramContext).a().d());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForPic.isMultiMsg);
    paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramView.hasNext())
    {
      paramSessionInfo = (ActivityManager.RunningAppProcessInfo)paramView.next();
      if (paramSessionInfo.processName.endsWith("mobileqq")) {
        localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramSessionInfo.pid);
      }
    }
    paramSessionInfo = paramMessageForPic.selfuin;
    paramView = paramSessionInfo;
    if (paramMessageForPic.isMultiMsg) {}
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = paramSessionInfo;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = paramSessionInfo;
      }
    }
    PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic), AIOGalleryUtils.a(paramMessageForPic));
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2)
  {
    a(paramMessageForPic, paramString1, paramString2, null);
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2, Throwable paramThrowable)
  {
    RichMediaUtil.a(paramMessageForPic.istroop, paramMessageForPic.isSendFromLocal(), 65537, String.valueOf(paramMessageForPic.uniseq), "PicItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, Context paramContext, MessageForPic paramMessageForPic)
  {
    if (AnonymousChatHelper.a(paramMessageForPic)) {
      return;
    }
    paramQQCustomMenu.a(2131296656, paramContext.getString(2131362666));
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, PicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.c == null) {}
    int i;
    Object localObject;
    do
    {
      return;
      if (!(paramIHttpCommunicatorListener instanceof BaseTransProcessor)) {
        break;
      }
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)paramIHttpCommunicatorListener.c();
      switch (i)
      {
      default: 
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
          ((RelativeLayout)paramHolder.c).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
        }
        if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        if ((paramIHttpCommunicatorListener.b()) && (!this.h))
        {
          if (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null)
          {
            paramIHttpCommunicatorListener = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramIHttpCommunicatorListener.setImageResource(2130839054);
            paramIHttpCommunicatorListener.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131297046);
            ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131297046);
            ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131297046);
            ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131297046);
            if (paramHolder.c != null) {
              ((RelativeLayout)paramHolder.c).addView(paramIHttpCommunicatorListener, (ViewGroup.LayoutParams)localObject);
            }
            paramHolder.jdField_a_of_type_AndroidWidgetImageView = paramIHttpCommunicatorListener;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
          {
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
            ((RelativeLayout)paramHolder.c).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      }
    } while (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.jdField_a_of_type_Boolean = true;
    return;
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
    {
      localObject = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
      ((MessageProgressTextView)localObject).setTextColor(-1);
      ((MessageProgressTextView)localObject).setTextSize(2, 15.0F);
      ((MessageProgressTextView)localObject).setGravity(17);
      ((MessageProgressTextView)localObject).setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_a_of_type_Float * 12.0F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131297046);
      localLayoutParams.addRule(8, 2131297046);
      localLayoutParams.addRule(5, 2131297046);
      localLayoutParams.addRule(7, 2131297046);
      if (paramHolder.c != null) {
        ((RelativeLayout)paramHolder.c).addView((View)localObject, localLayoutParams);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)localObject);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(paramIHttpCommunicatorListener);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null) && ((1001 == i) || (1002 == i))) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.jdField_a_of_type_Boolean = false;
    }
    if (i != 1002)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
    return;
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
      ((RelativeLayout)paramHolder.c).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
    }
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.a(paramMessageForPic.path);
    localBuilder.d(5);
    localBuilder.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localBuilder.c(TranDbRecord.PicDbRecord.f);
    }
    for (;;)
    {
      localBuilder.e(paramMessageForPic.senderuin);
      localBuilder.c(paramMessageForPic.selfuin);
      localBuilder.e(paramMessageForPic.istroop);
      localBuilder.j = paramMessageForPic.extLong;
      localBuilder.i = paramMessageForPic.extStr;
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
      localRetryInfo.jdField_b_of_type_Long = paramMessageForPic.shmsgseq;
      localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
      localBuilder.a(localRetryInfo);
      paramMessageForPic = PicBusiManager.a(3, 5);
      paramMessageForPic.a(localBuilder.a());
      PicBusiManager.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localBuilder.c(TranDbRecord.PicDbRecord.jdField_e_of_type_Int);
    }
  }
  
  private void c(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
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
    ((PicUploadInfo.Builder)localObject2).j = paramMessageForPic.extLong;
    ((PicUploadInfo.Builder)localObject2).i = paramMessageForPic.extStr;
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
      paramView.setId(2131297046);
      if (!jdField_a_of_type_Boolean) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth(AIOUtils.a(URLDrawableHelper.f, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setMaxHeight(AIOUtils.a(URLDrawableHelper.f, this.jdField_a_of_type_AndroidContentContext.getResources()));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramViewHolder.addView(paramView, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramViewHolder, this);
    }
    if (!paramChatMessage.isSendFromLocal())
    {
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.clearAnimation();
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        ((RelativeLayout)paramBaseChatItemLayout.c).removeView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
      }
      if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramView = URLDrawableHelper.a(paramChatMessage, 65537);
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        paramView = a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramView);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage, 2);
      }
      return paramViewHolder;
    }
    paramView = URLDrawableHelper.a(paramChatMessage, 65537);
    if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
    {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramView);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    }
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    paramBaseChatItemLayout.c = paramViewHolder;
    a(paramChatMessage, paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PicItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了图片";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localObject2 = (MessageForPic)paramChatMessage;
      if (paramInt != 2131296652) {
        break label576;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      paramChatMessage = new Intent(paramContext, ForwardRecentActivity.class);
      paramChatMessage.putExtra("forward_image_width", ((MessageForPic)localObject2).width);
      paramChatMessage.putExtra("forward_image_height", ((MessageForPic)localObject2).height);
      paramChatMessage.putExtra("forward_file_size", ((MessageForPic)localObject2).size);
      paramChatMessage.putExtra("forward_image_type", ((MessageForPic)localObject2).imageType);
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
        break label488;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label493;
      }
      paramInt = 65537;
      label341:
      paramContext = URLDrawableHelper.a((PicUiInterface)localObject2, paramInt);
      paramChatMessage.putExtra("forward_urldrawable", true);
      paramChatMessage.putExtra("forward_urldrawable_thumb_url", paramContext.toString());
      paramChatMessage.putExtra("FORWARD_URL_KEY", ((MessageForPic)localObject2).localUUID);
      paramContext = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2);
      paramChatMessage.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      if (!new File(((MessageForPic)localObject2).path).exists()) {
        break label498;
      }
      paramChatMessage.putExtra("forward_extra", ((MessageForPic)localObject2).path);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    }
    label488:
    label493:
    label498:
    do
    {
      return;
      paramInt = 0;
      break;
      paramInt = 1;
      break label341;
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
      if (paramInt == 2131296289)
      {
        paramContext = URLDrawable.getDrawable(URLDrawableHelper.a((PicUiInterface)localObject2, 1), -1, -1, null, null, false);
        paramContext.setTag(localObject2);
        AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, ((MessageForPic)localObject2).frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
        return;
      }
      if (paramInt == 2131298932)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131298935)
      {
        a((MessageForPic)localObject2);
        return;
      }
      if (paramInt == 2131296656)
      {
        QfavBuilder.a((Entity)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
        return;
      }
      if (paramInt == 2131298933)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((ChatActivity)paramContext).a().a(paramChatMessage);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2131298934)
      {
        paramContext = new bwi(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramContext);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt != 2131298939);
    label576:
    a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((PicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624119);
    localActionSheet.a(2131363073, 5);
    localActionSheet.d(2131362794);
    localActionSheet.a(new bwj(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (((paramFileMsg.jdField_e_of_type_Int != 1) && (paramFileMsg.jdField_e_of_type_Int != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {}
    do
    {
      MessageForPic localMessageForPic;
      do
      {
        do
        {
          return;
          paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
          if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        if (paramView == null)
        {
          QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
          return;
        }
        QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
        return;
        localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while (localMessageForPic.uniseq != paramFileMsg.jdField_c_of_type_Long);
      a(localMessageForPic, "transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + localMessageForPic.uniseq + ",file.uniseq:" + paramFileMsg.jdField_c_of_type_Long);
      if (localMessageForPic.isSendFromLocal())
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        if (paramInt1 == 1005) {
          a();
        }
      }
    } while (paramInt1 != 2003);
    paramFileMsg = a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramFileMsg);
    paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
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
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        return false;
      } while (!paramChatMessage.isSendFromLocal());
      paramChatMessage = (MessageForPic)paramChatMessage;
    } while (paramChatMessage.size > 0L);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
    if ((paramChatMessage instanceof BaseTransProcessor))
    {
      if (((BaseTransProcessor)paramChatMessage).c() == 1005L) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    paramView = (MessageForPic)((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    boolean bool = URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, paramView, 65537);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    this.h = true;
    if (!paramView.isSendFromLocal())
    {
      if (((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        localQQCustomMenu.a(2131296289, this.jdField_a_of_type_AndroidContentContext.getString(2131363932));
        if (bool) {
          localQQCustomMenu.a(2131296652, this.jdField_a_of_type_AndroidContentContext.getString(2131363562));
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
        if ((bool) && (!AnonymousChatHelper.a(paramView))) {
          a(localQQCustomMenu);
        }
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      return localQQCustomMenu.a();
    }
    if (paramView.size > 0L)
    {
      localQQCustomMenu.a(2131296289, this.jdField_a_of_type_AndroidContentContext.getString(2131363932));
      if (bool) {
        localQQCustomMenu.a(2131296652, this.jdField_a_of_type_AndroidContentContext.getString(2131363562));
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
      if ((bool) && (!AnonymousChatHelper.a(paramView))) {
        a(localQQCustomMenu);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        if ((((BaseTransProcessor)localObject).c() == 1005L) || (((BaseTransProcessor)localObject).c() == 1003L) || (((BaseTransProcessor)localObject).d() == 1003L))
        {
          localQQCustomMenu.a(2131296289, this.jdField_a_of_type_AndroidContentContext.getString(2131363932));
          if (bool) {
            localQQCustomMenu.a(2131296652, this.jdField_a_of_type_AndroidContentContext.getString(2131363562));
          }
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
          if ((bool) && (!AnonymousChatHelper.a(paramView))) {
            a(localQQCustomMenu);
          }
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        else
        {
          localQQCustomMenu.a(2131298933, this.jdField_a_of_type_AndroidContentContext.getString(2131363077));
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            localQQCustomMenu.a(2131298934, this.jdField_a_of_type_AndroidContentContext.getString(2131363078));
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localQQCustomMenu.a(2131296289, this.jdField_a_of_type_AndroidContentContext.getString(2131363932));
        if (bool) {
          localQQCustomMenu.a(2131296652, this.jdField_a_of_type_AndroidContentContext.getString(2131363562));
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
        if ((bool) && (!AnonymousChatHelper.a(paramView))) {
          a(localQQCustomMenu);
        }
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.h = false;
  }
  
  public void onClick(View paramView)
  {
    if (super.a()) {}
    MessageForPic localMessageForPic;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() != 2131296305) {
            break label287;
          }
          paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
          localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
          if (localMessageForPic.isSendFromLocal()) {
            break;
          }
          switch (((URLDrawable)localObject).getStatus())
          {
          default: 
            return;
          }
        } while (((URLDrawable)localObject).isDownloadStarted());
        ((URLDrawable)localObject).startDownload();
        return;
      } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
      ((URLDrawable)localObject).restartDownload();
      return;
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
        ((TroopHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return;
    label287:
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder
 * JD-Core Version:    0.7.0.1
 */