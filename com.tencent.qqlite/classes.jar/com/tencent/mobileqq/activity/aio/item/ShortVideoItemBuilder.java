package com.tencent.mobileqq.activity.aio.item;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bwx;
import bwy;
import bwz;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.net.URL;

public class ShortVideoItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  static long jdField_a_of_type_Long = 0L;
  static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "ShortVideoItemBuilder";
  protected final float a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new bwz(this);
  boolean c = false;
  int e;
  
  static
  {
    b = 1000L;
  }
  
  public ShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static Drawable a(Context paramContext, int paramInt1, int paramInt2)
  {
    return new RoundRectColorDrawable(-16777216, 12.0F * paramContext.getResources().getDisplayMetrics().density, paramInt1, paramInt2);
  }
  
  private void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    BaseChatItemLayout localBaseChatItemLayout = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    Object localObject;
    if (ShortVideoItemBuilder.Holder.a(paramHolder) == null)
    {
      ShortVideoItemBuilder.Holder.a(paramHolder, (ProgressBar)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903095, null));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131296305);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131296305);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296305);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.k;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.k;
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(-2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localBaseChatItemLayout.addView(ShortVideoItemBuilder.Holder.a(paramHolder), (ViewGroup.LayoutParams)localObject);
    }
    while (ShortVideoItemBuilder.Holder.a(paramHolder) == null)
    {
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject).setId(2131296392);
      ((ImageView)localObject).setImageResource(2130837548);
      ((ImageView)localObject).setContentDescription("取消");
      ((ImageView)localObject).setOnClickListener(this);
      int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((ImageView)localObject).setPadding(i, i, i, i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131296747);
      localLayoutParams.addRule(3, 2131296305);
      localLayoutParams.topMargin = (-(BaseChatItemLayout.i + i));
      localLayoutParams.leftMargin = (-i);
      localBaseChatItemLayout.addView((View)localObject, localLayoutParams);
      ShortVideoItemBuilder.Holder.a(paramHolder, (ImageView)localObject);
      return;
      ShortVideoItemBuilder.Holder.a(paramHolder).setVisibility(0);
    }
    ShortVideoItemBuilder.Holder.a(paramHolder).setImageResource(2130837548);
    ShortVideoItemBuilder.Holder.a(paramHolder).setVisibility(0);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startDownloadVideo");
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label88;
      }
    }
    label88:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label93;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131363510, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
      return;
      i = 0;
      break;
    }
    label93:
    localObject = ShortVideoBusiManager.a(2, 0);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo();
    localShortVideoDownloadInfo.jdField_g_of_type_JavaLangString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.c(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if (paramMessageForShortVideo.istroop == 0)
    {
      localShortVideoDownloadInfo.jdField_g_of_type_Int = 1001;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localShortVideoDownloadInfo.jdField_g_of_type_Int);
      }
      ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
      ((ShortVideoReq)localObject).a(paramMessageForShortVideo);
      ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramMessageForShortVideo.istroop == 3000)
      {
        localShortVideoDownloadInfo.jdField_g_of_type_Int = 1005;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      }
      else if (paramMessageForShortVideo.istroop == 1)
      {
        localShortVideoDownloadInfo.jdField_g_of_type_Int = 1003;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
      }
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    a(paramMessageForShortVideo, paramString1, paramString2, null);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2, Throwable paramThrowable)
  {
    RichMediaUtil.a(paramMessageForShortVideo.istroop, paramMessageForShortVideo.isSendFromLocal(), 65537, String.valueOf(paramMessageForShortVideo.uniseq), "ShortVideoItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  private void b(ShortVideoItemBuilder.Holder paramHolder)
  {
    if (ShortVideoItemBuilder.Holder.a(paramHolder) != null) {
      ShortVideoItemBuilder.Holder.a(paramHolder).setVisibility(8);
    }
    if (ShortVideoItemBuilder.Holder.a(paramHolder) != null) {
      ShortVideoItemBuilder.Holder.a(paramHolder).setVisibility(8);
    }
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo");
    }
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(1, 0);
    localShortVideoReq.a(ShortVideoBusiManager.a(0, paramMessageForShortVideo, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramChatMessage, this);
    }
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    int k = 1;
    paramBaseChatItemLayout = (ShortVideoItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131297050);
      paramView.setAdjustViewBounds(true);
      paramView.setMinimumWidth((int)(this.jdField_a_of_type_Float * 100.0F + 0.5F));
      paramView.setMinimumHeight((int)(this.jdField_a_of_type_Float * 100.0F + 0.5F));
      paramView.setMaxWidth((int)(this.jdField_a_of_type_Float * 220.0F + 0.5F));
      paramView.setMaxHeight((int)(this.jdField_a_of_type_Float * 220.0F + 0.5F));
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout, paramView);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903094, null, false);
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnLongClickAndTouchListener.addRule(5, 2131297050);
      paramOnLongClickAndTouchListener.addRule(6, 2131297050);
      paramOnLongClickAndTouchListener.addRule(8, 2131297050);
      paramOnLongClickAndTouchListener.addRule(7, 2131297050);
      paramViewHolder.addView(paramView, paramOnLongClickAndTouchListener);
      ShortVideoItemBuilder.Holder.b(paramBaseChatItemLayout, (ImageView)paramView.findViewById(2131296744));
      ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout, (TextView)paramView.findViewById(2131296745));
      ShortVideoItemBuilder.Holder.b(paramBaseChatItemLayout, (TextView)paramView.findViewById(2131296746));
      ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout, paramView);
    }
    paramView = (MessageForShortVideo)paramChatMessage;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, " getBubbleView " + paramView.toLogString() + "\n" + paramView.toString());
    }
    ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView.videoFileSize));
    ShortVideoItemBuilder.Holder.b(paramBaseChatItemLayout).setText(ShortVideoUtils.a(paramView.videoFileTime * 1000));
    Object localObject1 = ShortVideoUtils.a(paramView.md5, "jpg");
    paramOnLongClickAndTouchListener = ShortVideoUtils.a(paramView, "mp4");
    label454:
    Object localObject2;
    if (paramView.thumbWidth > 0)
    {
      i = paramView.thumbWidth;
      if (paramView.thumbHeight <= 0) {
        break label632;
      }
      j = paramView.thumbHeight;
      localObject2 = ShortVideoUtils.a(new int[] { i, j });
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      i = (int)(this.jdField_a_of_type_Float * localObject2[0] + 0.5F);
      float f = this.jdField_a_of_type_Float;
      localObject2 = a(localContext, i, (int)(localObject2[1] * f + 0.5F));
      if (paramView.isSendFromLocal()) {
        break label1210;
      }
      if (!FileUtils.b((String)localObject1)) {
        break label639;
      }
      localObject1 = ShortVideoUtils.a((String)localObject1);
      if ((ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout) == null) || (!ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).getURL().equals(localObject1)))
      {
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (Drawable)localObject2, (Drawable)localObject2);
        ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).setImageDrawable((Drawable)localObject1);
        ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout, (URLDrawable)localObject1);
      }
      if (!FileUtils.b(paramOnLongClickAndTouchListener)) {
        break label808;
      }
      ShortVideoItemBuilder.Holder.b(paramBaseChatItemLayout).setImageResource(2130839173);
      b(paramBaseChatItemLayout);
    }
    label632:
    label639:
    do
    {
      do
      {
        do
        {
          do
          {
            return paramViewHolder;
            i = 100;
            break;
            j = 100;
            break label454;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图 ");
            }
            ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).setImageDrawable((Drawable)localObject2);
            localObject1 = ShortVideoBusiManager.a(2, 0);
            localObject2 = paramView.getDownloadInfo();
            ((ShortVideoDownloadInfo)localObject2).h = ShortVideoUtils.a(paramView.md5, "jpg");
            if (paramView.istroop == 0) {
              ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1002;
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType=" + ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int);
              }
              ((ShortVideoReq)localObject1).a((ShortVideoDownloadInfo)localObject2);
              ((ShortVideoReq)localObject1).a(paramView);
              ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              break;
              if (paramView.istroop == 3000) {
                ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1006;
              } else if (paramView.istroop == 1) {
                ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1004;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits && not SendFromLocal: fileType:" + ShortVideoUtils.a(paramView.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramView.videoFileStatus));
            }
            ShortVideoItemBuilder.Holder.b(paramBaseChatItemLayout).setImageResource(2130839175);
            b(paramBaseChatItemLayout);
          } while ((paramView.fileType != 6) && (paramView.fileType != 17) && (paramView.fileType != 9));
          switch (paramView.videoFileStatus)
          {
          default: 
            b(paramBaseChatItemLayout);
            return paramViewHolder;
          case 2001: 
            a(paramBaseChatItemLayout);
            j = paramView.videoFileProgress;
            paramChatMessage = ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout);
            i = j;
            if (j == 0) {
              i = 1;
            }
            paramChatMessage.setProgress(i);
            return paramViewHolder;
          case 2004: 
            a(paramBaseChatItemLayout);
            i = paramView.videoFileProgress;
            paramChatMessage = ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout);
            if (i == 0) {
              i = k;
            }
            for (;;)
            {
              paramChatMessage.setProgress(i);
              ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).setImageResource(2130837549);
              return paramViewHolder;
            }
          case 2002: 
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
            if (paramChatMessage != null) {
              break label1109;
            }
            b(paramBaseChatItemLayout);
          }
        } while (!QLog.isColorLevel());
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : SHORT_VIDEO <-- STATUS_RECV_PROCESS, 下载过程中被杀进程然后恢复");
        return paramViewHolder;
        a(paramBaseChatItemLayout);
        j = paramView.videoFileProgress;
        paramView = ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout);
        if (j == 0) {}
        for (i = m;; i = j)
        {
          paramView.setProgress(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : SHORT_VIDEO <-- STATUS_RECV_PROCESS, 正在下载，progress:" + j + ",processor:" + paramChatMessage);
          return paramViewHolder;
        }
        b(paramBaseChatItemLayout);
        return paramViewHolder;
        b(paramBaseChatItemLayout);
        return paramViewHolder;
        ShortVideoItemBuilder.Holder.b(paramBaseChatItemLayout).setImageResource(2130839173);
        paramOnLongClickAndTouchListener = ShortVideoUtils.a((String)localObject1);
        if ((ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout) == null) || (!ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).getURL().equals(paramOnLongClickAndTouchListener)))
        {
          paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramOnLongClickAndTouchListener, (Drawable)localObject2, (Drawable)localObject2);
          ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).setImageDrawable(paramOnLongClickAndTouchListener);
          ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView SendFromLocal: fileType:" + ShortVideoUtils.a(paramView.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramView.videoFileStatus) + ",videoFileProgress:" + paramView.videoFileProgress);
        }
        if ((paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768)) {
          break label1688;
        }
      } while ((paramView.fileType != 6) && (paramView.fileType != 17) && (paramView.fileType != 9));
      switch (paramView.videoFileStatus)
      {
      default: 
        return paramViewHolder;
      case 1001: 
        a(paramBaseChatItemLayout);
        i = paramView.videoFileProgress;
        paramChatMessage = ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout);
        if (i == 0) {
          i = n;
        }
        for (;;)
        {
          paramChatMessage.setProgress(i);
          return paramViewHolder;
        }
      case 1004: 
        a(paramBaseChatItemLayout);
        i = paramView.videoFileProgress;
        paramChatMessage = ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout);
        if (i == 0) {
          i = i1;
        }
        for (;;)
        {
          paramChatMessage.setProgress(i);
          ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout).setImageResource(2130837549);
          return paramViewHolder;
        }
      case 1002: 
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
        if (paramChatMessage != null) {
          break label1577;
        }
        b(paramBaseChatItemLayout);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    } while (!QLog.isColorLevel());
    label808:
    label1109:
    QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复");
    label1210:
    return paramViewHolder;
    label1577:
    a(paramBaseChatItemLayout);
    int j = paramView.videoFileProgress;
    paramView = ShortVideoItemBuilder.Holder.a(paramBaseChatItemLayout);
    if (j == 0) {}
    for (int i = i2;; i = j)
    {
      paramView.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : SHORT_VIDEO --> STATUS_SEND_PROCESS, 正在上传， progress:" + j + ",processor:" + paramChatMessage);
      return paramViewHolder;
    }
    b(paramBaseChatItemLayout);
    return paramViewHolder;
    b(paramBaseChatItemLayout);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    return paramViewHolder;
    label1688:
    b(paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "视频消息";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      paramContext = (MessageForShortVideo)paramChatMessage;
      this.jdField_e_of_type_Int = paramInt;
      if (paramInt == 2131298983) {
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShortVideo)((ShortVideoItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624119);
      localActionSheet.a(2131363070, 5);
      localActionSheet.d(2131362790);
      localActionSheet.a(new bwy(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((MessageForShortVideo)localObject1).uniseq != paramFileMsg.c) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + ((MessageForShortVideo)localObject1).uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.jdField_e_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.B));
                }
                if ((paramFileMsg.jdField_e_of_type_Int != 6) && (paramFileMsg.jdField_e_of_type_Int != 17) && (paramFileMsg.jdField_e_of_type_Int != 9)) {
                  break;
                }
                switch (paramFileMsg.B)
                {
                case 1004: 
                case 2004: 
                default: 
                  return;
                case 1001: 
                  a(paramView);
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                  return;
                case 1003: 
                  b(paramView);
                  return;
                case 1005: 
                  b(paramView);
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                  return;
                }
              } while (!((MessageForShortVideo)localObject1).isSendFromLocal());
              if (paramFileMsg.jdField_a_of_type_Long != 0L)
              {
                paramInt2 = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
                if ((ShortVideoItemBuilder.Holder.a(paramView) == null) || (ShortVideoItemBuilder.Holder.a(paramView).getVisibility() != 0)) {
                  a(paramView);
                }
                paramView = ShortVideoItemBuilder.Holder.a(paramView);
                if (paramInt2 == 0) {}
                for (paramInt1 = 1;; paramInt1 = paramInt2)
                {
                  paramView.setProgress(paramInt1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=" + paramInt2);
                  return;
                }
              }
            } while (!QLog.isColorLevel());
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            return;
            if (ShortVideoItemBuilder.Holder.b(paramView) != null) {
              ShortVideoItemBuilder.Holder.b(paramView).setImageResource(2130839175);
            }
            a(paramView);
            return;
            if (ShortVideoItemBuilder.Holder.b(paramView) != null) {
              ShortVideoItemBuilder.Holder.b(paramView).setImageResource(2130839173);
            }
            b(paramView);
            paramView = ShortVideoUtils.a(((MessageForShortVideo)localObject1).md5, "jpg");
          } while (FileUtils.b(paramView));
          paramFileMsg = ShortVideoBusiManager.a(2, 0);
          localObject2 = ((MessageForShortVideo)localObject1).getDownloadInfo();
          ((ShortVideoDownloadInfo)localObject2).h = paramView;
          if (((MessageForShortVideo)localObject1).istroop == 0) {
            ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1002;
          }
          for (;;)
          {
            paramFileMsg.a((ShortVideoDownloadInfo)localObject2);
            paramFileMsg.a((MessageForShortVideo)localObject1);
            ShortVideoBusiManager.a(paramFileMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
            if (((MessageForShortVideo)localObject1).istroop == 3000) {
              ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1006;
            } else if (((MessageForShortVideo)localObject1).istroop == 1) {
              ((ShortVideoDownloadInfo)localObject2).jdField_g_of_type_Int = 1004;
            }
          }
          b(paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364433, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
          return;
          b(paramView);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364434, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
          return;
        } while (((MessageForShortVideo)localObject1).isSendFromLocal());
        if (ShortVideoItemBuilder.Holder.b(paramView) != null) {
          ShortVideoItemBuilder.Holder.b(paramView).setImageResource(2130839175);
        }
        if (paramFileMsg.jdField_a_of_type_Long != 0L)
        {
          paramInt2 = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
          if ((ShortVideoItemBuilder.Holder.a(paramView) == null) || (ShortVideoItemBuilder.Holder.a(paramView).getVisibility() != 0)) {
            a(paramView);
          }
          paramView = ShortVideoItemBuilder.Holder.a(paramView);
          if (paramInt2 == 0) {}
          for (paramInt1 = 1;; paramInt1 = paramInt2)
          {
            paramView.setProgress(paramInt1);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: progress=" + paramInt2);
            return;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: fileSize == 0 ");
      return;
    } while ((paramFileMsg.jdField_e_of_type_Int != 7) && (paramFileMsg.jdField_e_of_type_Int != 18) && (paramFileMsg.jdField_e_of_type_Int != 16));
    switch (paramFileMsg.B)
    {
    case 2001: 
    case 2002: 
    default: 
      return;
    }
    paramFileMsg = ShortVideoUtils.a(ShortVideoUtils.a(((MessageForShortVideo)localObject1).md5, "jpg"));
    if (((MessageForShortVideo)localObject1).thumbWidth > 0)
    {
      paramInt1 = ((MessageForShortVideo)localObject1).thumbWidth;
      label854:
      if (((MessageForShortVideo)localObject1).thumbHeight <= 0) {
        break label986;
      }
    }
    label986:
    for (paramInt2 = ((MessageForShortVideo)localObject1).thumbHeight;; paramInt2 = 100)
    {
      localObject1 = ShortVideoUtils.a(new int[] { paramInt1, paramInt2 });
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      paramInt1 = (int)(this.jdField_a_of_type_Float * localObject1[0] + 0.5F);
      float f = this.jdField_a_of_type_Float;
      localObject1 = a((Context)localObject2, paramInt1, (int)(localObject1[1] * f + 0.5F));
      if ((ShortVideoItemBuilder.Holder.a(paramView) != null) && (ShortVideoItemBuilder.Holder.a(paramView).getURL().equals(paramFileMsg))) {
        break;
      }
      paramFileMsg = URLDrawable.getDrawable(paramFileMsg, (Drawable)localObject1, (Drawable)localObject1);
      ShortVideoItemBuilder.Holder.a(paramView).setImageDrawable(paramFileMsg);
      ShortVideoItemBuilder.Holder.a(paramView, paramFileMsg);
      return;
      paramInt1 = 100;
      break label854;
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus != 1005)
      {
        bool1 = bool2;
        if (paramChatMessage.extraflag != 32768) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForShortVideo)((ShortVideoItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.c = true;
    return paramView.a();
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("cancelpic", 2, "mMenuClickedID:" + this.jdField_e_of_type_Int);
    }
    if ((this.jdField_e_of_type_Int != 2131298984) && (this.jdField_e_of_type_Int != 2131298985)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_e_of_type_Int = -1;
    this.c = false;
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = 0;
    long l = System.currentTimeMillis();
    if ((l - jdField_a_of_type_Long < b) && (l > jdField_a_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
      return;
    }
    jdField_a_of_type_Long = l;
    ShortVideoItemBuilder.Holder localHolder;
    MessageForShortVideo localMessageForShortVideo;
    String str;
    if (paramView.getId() == 2131296305)
    {
      localHolder = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
      localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "click bubble, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131364442, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
        return;
      }
      if (!localMessageForShortVideo.isSendFromLocal())
      {
        str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
        if (!FileUtils.b(str)) {
          if ((ShortVideoItemBuilder.Holder.a(localHolder) == null) || (ShortVideoItemBuilder.Holder.a(localHolder).getVisibility() != 0)) {
            a(localMessageForShortVideo);
          }
        }
      }
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      boolean bool2 = ShortVideoUtils.a(str, localMessageForShortVideo.lastModified);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = ShortVideoUtils.a(str, localMessageForShortVideo.md5);
      }
      Intent localIntent;
      if (bool1)
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.class);
        localIntent.putExtra("file_send_path", str);
        localIntent.putExtra("file_send_duration", localMessageForShortVideo.videoFileTime);
        localIntent.putExtra("file_shortvideo_md5", localMessageForShortVideo.md5);
        localIntent.putExtra("uintype", localMessageForShortVideo.istroop);
        localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(ShortVideoItemBuilder.Holder.a(localHolder)));
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
      }
      else
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, this.jdField_a_of_type_AndroidContentContext.getString(2131364435), null, new bwx(this, str, localHolder), null).show();
        continue;
        str = localMessageForShortVideo.videoFileName;
        if (!FileUtils.b(str))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131364425, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
        }
        else
        {
          localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.class);
          localIntent.putExtra("file_send_path", str);
          localIntent.putExtra("file_send_duration", localMessageForShortVideo.videoFileTime);
          localIntent.putExtra("file_shortvideo_md5", localMessageForShortVideo.md5);
          localIntent.putExtra("uintype", localMessageForShortVideo.istroop);
          localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(ShortVideoItemBuilder.Holder.a(localHolder)));
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
          continue;
          if (paramView.getId() == 2131296392)
          {
            localHolder = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
            localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "click cancleBtn msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
            }
            if (!localMessageForShortVideo.isSendFromLocal())
            {
              if (((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9)) && (localMessageForShortVideo.videoFileStatus == 2004)) {}
              for (;;)
              {
                if (i == 0) {
                  break label762;
                }
                ShortVideoItemBuilder.Holder.a(localHolder).setImageResource(2130837548);
                a(localMessageForShortVideo);
                break;
                i = 0;
              }
              label762:
              if (localMessageForShortVideo.videoFileStatus == 2005)
              {
                b(localHolder);
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364433, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
              }
              else if (localMessageForShortVideo.videoFileStatus == 5001)
              {
                b(localHolder);
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364434, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
              }
              else
              {
                ShortVideoItemBuilder.Holder.a(localHolder).setImageResource(2130837549);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
              }
            }
            else
            {
              i = j;
              if (localMessageForShortVideo.videoFileStatus == 1004) {
                i = 1;
              }
              if (i != 0)
              {
                ShortVideoItemBuilder.Holder.a(localHolder).setImageResource(2130837548);
                b(localMessageForShortVideo);
              }
              else if (localMessageForShortVideo.videoFileStatus == 1005)
              {
                b(localHolder);
                localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              }
              else
              {
                ShortVideoItemBuilder.Holder.a(localHolder).setImageResource(2130837549);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */