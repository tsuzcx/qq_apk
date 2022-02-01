package com.tencent.mobileqq.activity.aio.item;

import acfp;
import ahbj;
import amja;
import amjb;
import anaz;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aojn;
import aoko;
import aooi;
import aqiw;
import aqoa;
import aqob;
import arht;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.a;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import ujt;
import wja;
import wla;
import wla.a;
import wlz;
import wsd;
import xlg;
import xmm;
import xmn;
import xmo;

public class ScribbleItemBuilder
  extends xlg
  implements BaseBubbleBuilder.d, DoodleMsgLayout.a, wla.a
{
  public static int bVs;
  public static int bVt;
  protected static int mPaddingBottom;
  public static int mPaddingTop;
  public long IX;
  private Handler mHandler = new Handler();
  protected View.OnClickListener mSourceOnClickListener = new xmm(this);
  
  public ScribbleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (mPaddingTop == 0)
    {
      bVt = BaseChatItemLayout.bNY + paramContext.getResources().getDimensionPixelSize(2131296413);
      bVs = BaseChatItemLayout.bNX + paramContext.getResources().getDimensionPixelSize(2131296414);
      mPaddingBottom = BaseChatItemLayout.bNW + paramContext.getResources().getDimensionPixelSize(2131296415);
      mPaddingTop = BaseChatItemLayout.bNV + paramContext.getResources().getDimensionPixelSize(2131296416);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, a parama, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = ahbj.isFileExists(paramMessageForScribble.localFildPath);
      }
      if (bool)
      {
        int i = paramMessageForScribble.fileUploadStatus;
        if (i == 1)
        {
          QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据已发送成功");
          return 3;
        }
        if (i == 2)
        {
          QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据发送失败");
          return 2;
        }
        if (i == 3)
        {
          QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据发送中");
          parama = (aojn)this.app.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          wla localwla = wla.a(this.app);
          if (localwla != null) {
            localwla.a(paramView, this);
          }
          if (parama != null)
          {
            i = parama.getProgress();
            QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据进行中 progress 为：" + i);
            return 1;
          }
          QLog.d("ScribbleItemBuilder", 2, "status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：" + paramMessageForScribble.uniseq);
          return 2;
        }
        QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据已发送完啦");
        return 3;
      }
      QLog.i("ScribbleItemBuilder", 2, "发送MessageForScribble NOT EXIST");
      parama = wla.a(this.app);
      if (parama != null) {
        parama.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      this.app.a().e(paramMessageForScribble);
      return 4;
    }
    if (amjb.c(paramMessageForScribble) == amjb.dCo)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    parama = wla.a(this.app);
    if (parama != null) {
      parama.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    this.app.a().e(paramMessageForScribble);
    return 4;
  }
  
  private static arht a(Context paramContext, Handler paramHandler)
  {
    arht localarht = new arht(paramContext);
    localarht.YE(wja.dp2px(50.0F, paramContext.getResources()));
    localarht.setDrawImageFillView(true);
    localarht.setShowStroke(false);
    localarht.setTextColor(-1);
    localarht.setBackgroundColor(0);
    localarht.setProgressColor(-15550475);
    localarht.setProgressStrokeWidth(3);
    localarht.dbf = true;
    localarht.mAnimationStep = 2;
    localarht.a(new xmo(paramHandler));
    return localarht;
  }
  
  public static arht a(MessageForScribble paramMessageForScribble, Context paramContext, Handler paramHandler)
  {
    if (paramMessageForScribble.mProgressPie != null) {
      return paramMessageForScribble.mProgressPie;
    }
    paramContext = a(paramContext, paramHandler);
    paramMessageForScribble.mProgressPie = paramContext;
    return paramContext;
  }
  
  private DoodleMsgLayout a(Context paramContext)
  {
    return new DoodleMsgLayout(paramContext, null);
  }
  
  private void a(View paramView, MessageForScribble paramMessageForScribble)
  {
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(2131690230, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new xmn(this, paramView, paramMessageForScribble, localausj));
    localausj.show();
  }
  
  private void a(a parama, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((parama == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      wsd.a().a(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble), parama.pos, parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
    } while (paramBoolean);
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.d(null, 0, false);
  }
  
  private void a(a parama, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((parama == null) || (paramMessageForScribble == null)) {}
    label143:
    label145:
    label148:
    for (;;)
    {
      return;
      wsd.a().a(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble), parama.pos, parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if ((paramInt == 0) || (paramInt == -1))
      {
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        label61:
        if (paramBoolean) {
          break label143;
        }
        if (!wsd.a().t(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.d(amjb.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        return;
        if (paramInt == 1)
        {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbk();
          break label61;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.yR(false);
        break label61;
        break;
      }
    }
  }
  
  private static void a(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((aqiw.isNetSupport(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private static void a(MessageForScribble paramMessageForScribble, aoko paramaoko)
  {
    if ((paramaoko != null) && (paramaoko.fileSize > 0L))
    {
      paramMessageForScribble.mRealProgress = ((int)(paramaoko.transferedSize * 100L / paramaoko.fileSize));
      paramMessageForScribble.mUiProgress = paramMessageForScribble.mRealProgress;
    }
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, a parama, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForScribble.frienduin + paramMessageForScribble.uniseq);
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.stopAnimating();
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramInt = ShortVideoUtils.aL(paramInt, 10);
    if (paramBoolean) {
      paramContext.YF(paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForScribble.uniseq + ", p:" + paramInt + ", current:" + paramContext.getProgress());
      }
      paramContext.setShowText(true);
      paramContext.setShowImage(false);
      paramContext.setBackgroundColor(1426063360);
      paramContext.setText(String.valueOf(paramInt) + "%");
      return;
      paramContext.setProgress(paramInt);
    }
  }
  
  private void b(a parama, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((parama == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      wsd.a().a(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble), parama.pos, parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.yR(false);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    } while (paramBoolean);
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.d(null, 0, false);
  }
  
  private void b(a parama, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((parama == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      wsd.a().a(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble), parama.pos, parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramBoolean) {
          continue;
        }
        if (!wsd.a().t(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.d(amjb.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        return;
        if (paramInt == 1)
        {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbk();
          break;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.yR(false);
        break;
      }
    }
  }
  
  private void b(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {
      return;
    }
    this.mHandler.removeCallbacks(paramMessageForScribble.mUpdateProgressRunnable);
    paramMessageForScribble.mUpdateProgressRunnable = null;
  }
  
  private void c(a parama, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((parama == null) || (paramMessageForScribble == null)) {}
    label171:
    label174:
    for (;;)
    {
      return;
      QLog.d("ScribbleItemBuilder", 2, "onSendOkState:" + paramBoolean);
      wsd.a().a(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble), parama.pos, parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!wsd.a().t(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble))) {
          break label171;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.d(amjb.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label174;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        return;
        if (paramInt == 1)
        {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbk();
          break;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.yR(false);
        break;
      }
    }
  }
  
  private void d(a parama, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((parama == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      wsd.a().a(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble), parama.pos, parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!wsd.a().t(wsd.b(paramMessageForScribble), wsd.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.d(amjb.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbl();
        return;
        if (paramInt == 1)
        {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.cbk();
          break;
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.yR(false);
        break;
      }
    }
  }
  
  public void T(View paramView, int paramInt)
  {
    a locala = (a)wja.a(paramView);
    if (locala == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)locala.mMessage;
    if (locala.mMessage == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage state is: " + paramInt);
    switch (a(localMessageForScribble, locala, paramView))
    {
    default: 
      return;
    case 1: 
      a(locala, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(locala, localMessageForScribble, true, paramInt);
      return;
    case 3: 
      c(locala, localMessageForScribble, true, paramInt);
      return;
    case 4: 
      a(locala, localMessageForScribble, true);
      return;
    case 5: 
      b(locala, localMessageForScribble, true);
      return;
    }
    d(locala, localMessageForScribble, true, paramInt);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.app, paramView, this.sessionInfo, paramChatMessage, this.mSourceOnClickListener);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    try
    {
      paramBaseChatItemLayout = (a)parame;
      if ((paramChatMessage instanceof MessageForScribble))
      {
        localMessageForScribble = (MessageForScribble)paramChatMessage;
        QLog.i("SCRIBBLEMSG", 2, "!!!ScribbleItemBuilder  uniseq:" + localMessageForScribble.uniseq);
        if (localMessageForScribble == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "doodle msg type error!!");
          return paramView;
        }
      }
    }
    catch (Exception parame)
    {
      for (;;)
      {
        QLog.e("ScribbleItemBuilder", 2, "scribbleitem holer Exception e= " + parame);
        paramBaseChatItemLayout = null;
        continue;
        if (paramView == null)
        {
          parame = new RelativeLayout(this.mContext);
          parame.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          paramView = new RelativeLayout(this.mContext);
          paramView.setId(2131362506);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout = a(this.mContext);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setOperateListener(this, paramwlz, paramwlz, this);
          paramView.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
          parame.addView(paramView);
          paramBaseChatItemLayout.hK = paramView;
          paramwlz = new MessageProgressView(this.mContext);
          parame.addView(paramwlz);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramwlz.getLayoutParams();
          localLayoutParams.addRule(8, 2131362506);
          localLayoutParams.addRule(5, 2131362506);
          localLayoutParams.addRule(6, 2131362506);
          localLayoutParams.addRule(7, 2131362506);
          paramwlz.setLayoutParams(localLayoutParams);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramwlz;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
          paramView.setAddStatesFromChildren(true);
          label330:
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setTag(localMessageForScribble);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramChatMessage.isSend());
          if (localMessageForScribble.mUpdateProgressRunnable != null) {
            this.mHandler.removeCallbacks(localMessageForScribble.mUpdateProgressRunnable);
          }
          localMessageForScribble.mUpdateProgressRunnable = new ProgressRunnable(localMessageForScribble, paramBaseChatItemLayout, this.mHandler, this.mContext);
          int i = a(localMessageForScribble, paramBaseChatItemLayout, parame);
          if (QLog.isColorLevel()) {
            QLog.i("ScribbleItemBuilder", 2, "ScribbleItemBuilder pos:" + paramBaseChatItemLayout.pos + " State:" + i);
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramView = parame;
          if (!aTl) {
            break;
          }
          parame.setContentDescription(b(paramChatMessage));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(b(paramChatMessage));
          paramView = parame;
          if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout == null) {
            break;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setTalkBack(b(paramChatMessage));
          return parame;
          paramwlz = (MessageForScribble)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag();
          parame = paramView;
          if (paramwlz == null) {
            break label330;
          }
          parame = paramView;
          if (paramwlz.mUpdateProgressRunnable == null) {
            break label330;
          }
          this.mHandler.removeCallbacks(paramwlz.mUpdateProgressRunnable);
          paramwlz.mUpdateProgressRunnable = null;
          parame = paramView;
          break label330;
          a(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          this.mHandler.post(localMessageForScribble.mUpdateProgressRunnable);
          continue;
          b(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          a(paramBaseChatItemLayout);
          continue;
          c(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          a(paramBaseChatItemLayout);
          continue;
          a(paramBaseChatItemLayout, localMessageForScribble, false);
          this.mHandler.post(localMessageForScribble.mUpdateProgressRunnable);
          continue;
          b(paramBaseChatItemLayout, localMessageForScribble, false);
          a(paramBaseChatItemLayout);
          continue;
          d(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          a(paramBaseChatItemLayout);
        }
        MessageForScribble localMessageForScribble = null;
      }
    }
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    return this;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    super.j(paramChatMessage);
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    paramView = (a)wja.a(paramView);
    if (paramView == null) {
      QLog.e("ScribbleItemBuilder", 2, "handleMessage(): holder is null");
    }
    MessageForScribble localMessageForScribble;
    do
    {
      return;
      localMessageForScribble = (MessageForScribble)paramView.mMessage;
      if (paramView.mMessage == null)
      {
        QLog.e("ScribbleItemBuilder", 2, "handleMessage(): holder.mMessage is null");
        return;
      }
    } while (localMessageForScribble.uniseq != paramaoko.uniseq);
    a(localMessageForScribble, paramaoko);
    QLog.e("ScribbleItemBuilder", 2, "handleMessage begin progress is: " + localMessageForScribble.mRealProgress + " status is: " + paramaoko.status + " uinSeq: " + localMessageForScribble.uniseq);
    paramInt1 = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.getDataState();
    if (localMessageForScribble.isSendFromLocal()) {
      switch (paramaoko.status)
      {
      default: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isSendFromLocal ：" + paramaoko.status);
        a(paramView, localMessageForScribble, true, paramInt1);
      }
    }
    for (;;)
    {
      QLog.i("ScribbleItemBuilder", 2, "Scribble file transfer status = " + paramaoko.status + " issendFromLocal " + localMessageForScribble.isSendFromLocal());
      QLog.i("ScribbleItemBuilder", 2, "handleMessage end");
      return;
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据开始发送");
      a(paramView, localMessageForScribble, true, paramInt1);
      continue;
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送完毕");
      c(paramView, localMessageForScribble, true, paramInt1);
      if (localMessageForScribble.mRealProgress != 100)
      {
        localMessageForScribble.mRealProgress = 100;
        localMessageForScribble.mUiProgress = 100;
        b(localMessageForScribble);
        a(localMessageForScribble, paramView, localMessageForScribble.mUiProgress, true, this.mContext, this.mHandler);
        continue;
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送错误");
        b(paramView, localMessageForScribble, true, paramInt1);
        this.mHandler.removeCallbacks(localMessageForScribble.mUpdateProgressRunnable);
        a(paramView);
        continue;
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送取消");
        b(paramView, localMessageForScribble, true, paramInt1);
        b(localMessageForScribble);
        a(paramView);
        continue;
        switch (paramaoko.status)
        {
        case 2002: 
        case 2004: 
        default: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isNotSendFromLocal：" + paramaoko.status);
          a(paramView, localMessageForScribble, false);
          break;
        case 2001: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载开始");
          a(paramView, localMessageForScribble, true);
          break;
        case 2003: 
          if (ahbj.isFileExists(amjb.b(localMessageForScribble))) {
            d(paramView, localMessageForScribble, false, 1);
          }
          while (localMessageForScribble.mRealProgress != 100)
          {
            localMessageForScribble.mRealProgress = 100;
            localMessageForScribble.mUiProgress = 100;
            b(localMessageForScribble);
            a(localMessageForScribble, paramView, localMessageForScribble.mUiProgress, true, this.mContext, this.mHandler);
            break;
            b(paramView, localMessageForScribble, false);
          }
        case 2005: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载失败");
          b(paramView, localMessageForScribble, false);
          b(localMessageForScribble);
          a(paramView);
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bVt, mPaddingTop, bVs, mPaddingBottom);
      return;
    }
    paramView.setPadding(bVs, mPaddingTop, bVt, mPaddingBottom);
  }
  
  protected void a(a parama)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    parama.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {}
    while (!(parame instanceof a)) {
      return;
    }
    paramContext = (a)parame;
    paramInt1 = parame.E.getPaddingLeft();
    paramInt2 = parame.E.getPaddingRight();
    int i = parame.E.getPaddingTop();
    int j = parame.E.getPaddingBottom();
    paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      paramContext.hK.setBackgroundResource(2130851006);
      paramBaseChatItemLayout.topMargin = wja.dp2px(9.0F, this.mContext.getResources());
      paramBaseChatItemLayout.leftMargin = wja.dp2px(10.0F, this.mContext.getResources());
      paramBaseChatItemLayout.rightMargin = wja.dp2px(4.0F, this.mContext.getResources());
    }
    for (paramBaseChatItemLayout.bottomMargin = wja.dp2px(8.0F, this.mContext.getResources());; paramBaseChatItemLayout.bottomMargin = wja.dp2px(8.0F, this.mContext.getResources()))
    {
      paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramBaseChatItemLayout);
      paramContext.hK.setPadding(paramInt1, i, paramInt2, j);
      paramContext.E.setPadding(0, 0, 0, 0);
      return;
      paramContext.hK.setBackgroundResource(2130850829);
      paramBaseChatItemLayout.topMargin = wja.dp2px(8.0F, this.mContext.getResources());
      paramBaseChatItemLayout.leftMargin = wja.dp2px(4.0F, this.mContext.getResources());
      paramBaseChatItemLayout.rightMargin = wja.dp2px(10.0F, this.mContext.getResources());
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForScribble)paramChatMessage;
    int i = paramChatMessage.fileUploadStatus;
    if (i == 2)
    {
      QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据发送失败");
      return true;
    }
    if (i == 3)
    {
      QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据发送中");
      paramBaseChatItemLayout = (aojn)this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if (paramBaseChatItemLayout != null)
      {
        i = paramBaseChatItemLayout.getProgress();
        QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据进行中 progress 为：" + i);
        return false;
      }
      QLog.d("ScribbleItemBuilder", 2, "isFailed::  status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：" + paramChatMessage.uniseq);
      return true;
    }
    return false;
  }
  
  public aqob[] a(View paramView)
  {
    paramView = wja.a(paramView);
    aqoa localaqoa = new aqoa();
    if ((paramView instanceof MessageForScribble))
    {
      MessageForScribble localMessageForScribble = (MessageForScribble)paramView;
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.app.a().aR(paramView))) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
    }
    if (paramView.istroop == 0) {
      a(paramView, localaqoa);
    }
    a(localaqoa, paramView);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131714072);
  }
  
  public void destroy()
  {
    super.destroy();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent) {}
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    Object localObject;
    int i;
    do
    {
      MessageForScribble localMessageForScribble;
      do
      {
        return;
        localObject = (a)wja.a(paramView);
        localMessageForScribble = (MessageForScribble)((a)localObject).mMessage;
        i = a(localMessageForScribble, (a)localObject, ((a)localObject).E);
        if (!localMessageForScribble.isSendFromLocal()) {
          break;
        }
        if (i == 2)
        {
          a(((a)localObject).E, localMessageForScribble);
          return;
        }
      } while ((i != 1) && (i != 3));
      ((a)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.aGs();
      return;
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = wla.a(this.app);
        if (localObject != null) {
          ((wla)localObject).a(paramView, this);
        }
        this.app.a().e(localMessageForScribble);
        return;
      }
    } while ((i != 4) && (i != 6));
    ((a)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.aGs();
  }
  
  public void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(false);
  }
  
  public void onClick(View paramView)
  {
    if (super.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((paramView instanceof DoodleMsgView)) || ((paramView instanceof URLImageView)))
      {
        a locala = (a)wja.a(paramView);
        if (locala == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
          continue;
        }
        if ((locala.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout != null) && (locala.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.M(paramView)))
        {
          wsd.a().a(locala.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, true);
          continue;
        }
      }
      super.onClick(paramView);
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    paramView = wja.a(paramView);
    Drawable localDrawable;
    if ((paramView instanceof a))
    {
      paramView = (a)paramView;
      if ((paramView != null) && (paramView.hK != null))
      {
        localDrawable = paramView.hK.getBackground();
        if (localDrawable != null) {
          if (!paramBoolean) {
            break label56;
          }
        }
      }
    }
    label56:
    for (paramView = null;; paramView = d)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  static class ProgressRunnable
    implements Runnable
  {
    private WeakReference<MessageForScribble> ek;
    private WeakReference<ScribbleItemBuilder.a> el;
    private WeakReference<Context> mContextRef;
    private WeakReference<Handler> z;
    
    public ProgressRunnable(MessageForScribble paramMessageForScribble, ScribbleItemBuilder.a parama, Handler paramHandler, Context paramContext)
    {
      this.ek = new WeakReference(paramMessageForScribble);
      this.el = new WeakReference(parama);
      this.z = new WeakReference(paramHandler);
      this.mContextRef = new WeakReference(paramContext);
    }
    
    public void run()
    {
      if (this.ek != null) {}
      for (MessageForScribble localMessageForScribble = (MessageForScribble)this.ek.get();; localMessageForScribble = null)
      {
        if (this.el != null) {}
        for (ScribbleItemBuilder.a locala = (ScribbleItemBuilder.a)this.el.get();; locala = null)
        {
          if (this.z != null) {}
          for (Handler localHandler = (Handler)this.z.get();; localHandler = null)
          {
            if (this.mContextRef != null) {}
            for (Context localContext = (Context)this.mContextRef.get();; localContext = null)
            {
              if ((localMessageForScribble == null) || (localHandler == null) || (locala == null) || (localContext == null)) {}
              do
              {
                return;
                ScribbleItemBuilder.c(localMessageForScribble);
                ScribbleItemBuilder.a(localMessageForScribble, locala, localMessageForScribble.mUiProgress, false, localContext, localHandler);
              } while (!locala.a.isShown());
              localHandler.postDelayed(localMessageForScribble.mUpdateProgressRunnable, 50L);
              return;
            }
          }
        }
      }
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public DoodleMsgLayout a;
    public MessageProgressView a;
    public RelativeLayout hK;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder
 * JD-Core Version:    0.7.0.1
 */