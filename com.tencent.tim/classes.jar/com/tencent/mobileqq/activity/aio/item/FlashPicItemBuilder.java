package com.tencent.mobileqq.activity.aio.item;

import acei;
import acfp;
import acfx;
import ahyj;
import akxj;
import akxk;
import akxq;
import akxy.a;
import akxy.b;
import anaz;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anqz;
import aoiz;
import aojn;
import aoko;
import aooh.a;
import aooi;
import aoop;
import aqbn;
import aqhq;
import aqiu;
import aqoa;
import aqob;
import aqoi;
import argt;
import ausj;
import auss;
import avfp;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.BinderWarpper;
import java.net.URL;
import java.util.HashSet;
import sxx;
import ujt;
import wja;
import wla.a;
import wlz;
import xbo;
import xbp;
import xbq;
import xtm;

public class FlashPicItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.d, wla.a
{
  private static final HashSet<String> aC = new HashSet();
  public static Drawable dP;
  private long IQ;
  private RoundRectDrawable a;
  private boolean bgR = true;
  private Drawable dN;
  private Drawable dO;
  boolean mIsPaused = false;
  private View.OnClickListener onClickListener = new xbo(this);
  
  public FlashPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramBaseAdapter = paramContext.getResources();
    float f = paramBaseAdapter.getDisplayMetrics().densityDpi / 160;
    paramQQAppInterface = paramBaseAdapter.getDrawable(2130843394);
    if (paramQQAppInterface == null) {
      return;
    }
    if ((paramQQAppInterface instanceof BitmapDrawable)) {}
    for (paramQQAppInterface = ((BitmapDrawable)paramQQAppInterface).getBitmap();; paramQQAppInterface = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap())
    {
      this.a = new RoundRectDrawable(paramBaseAdapter, new RoundRectBitmap(paramQQAppInterface, 6.0F * f, 0, 0.0F));
      this.dN = new ColorDrawable(637534208);
      this.dO = new ColorDrawable(0);
      return;
      if (!(paramQQAppInterface instanceof SkinnableBitmapDrawable)) {
        break;
      }
    }
  }
  
  public static Drawable a(Resources paramResources)
  {
    if (dP == null) {
      dP = f(paramResources, 2131166643);
    }
    return dP;
  }
  
  private static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = wja.dp2px(130.0F, (Resources)localObject);
    int k = wja.dp2px(130.0F, (Resources)localObject);
    URL localURL = aoop.a(paramMessageForPic, 65537, null);
    String str = localURL.toString();
    if (paramChatThumbView != null) {
      paramChatThumbView.flag = false;
    }
    if (aoiz.getFile(str) != null)
    {
      URLDrawable.removeMemoryCacheByUrl(str);
      float f = i / 160;
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = j;
      paramContext.mRequestHeight = k;
      paramContext.mLoadingDrawable = a((Resources)localObject);
      paramContext.mFailedDrawable = a((Resources)localObject);
      paramContext.mPlayGifImage = false;
      paramContext.mGifRoundCorner = (f * 6.0F);
      paramContext.mMemoryCacheKeySuffix = "flashpic_";
      if (acei.W(paramMessageForPic)) {
        paramContext.isFlashPic = true;
      }
      localObject = URLDrawable.getDrawable(localURL, paramContext);
      ((URLDrawable)localObject).setDecodeHandler(aqbn.n);
      ((URLDrawable)localObject).setIgnorePause(true);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramContext = (Context)localObject;
      if (paramChatThumbView != null)
      {
        paramChatThumbView.flag = true;
        paramContext = (Context)localObject;
      }
    }
    for (;;)
    {
      paramContext.setProgressDrawable(new argt(aoop.aj(), 0, false));
      paramContext.setTag(paramMessageForPic);
      return paramContext;
      if (!aoop.bD(paramContext)) {}
      for (i = 1;; i = 0)
      {
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        paramContext.mRequestWidth = j;
        paramContext.mRequestHeight = k;
        paramContext.mLoadingDrawable = a((Resources)localObject);
        paramContext.mFailedDrawable = a((Resources)localObject);
        paramContext.mGifRoundCorner = 6.0F;
        paramContext.mImgType = paramMessageForPic.imageType;
        paramContext.mMemoryCacheKeySuffix = "flashpic_";
        if (acei.W(paramMessageForPic)) {
          paramContext.isFlashPic = true;
        }
        paramContext = URLDrawable.getDrawable(localURL, paramContext);
        paramContext.setDecodeHandler(aqbn.n);
        if ((!akxk.cuU) && (i == 0)) {
          break label326;
        }
        paramContext.setAutoDownload(true);
        break;
      }
      label326:
      paramContext.setAutoDownload(false);
    }
  }
  
  private void a(aqoi paramaqoi, a parama)
  {
    if ((parama == null) || (parama.E == null)) {}
    while (!(paramaqoi instanceof aojn)) {
      return;
    }
    int i = (int)((aojn)paramaqoi).hh();
    if (parama.bgS)
    {
      switch (i)
      {
      default: 
        if (i == 1003) {
          parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      }
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      return;
    }
    switch (i)
    {
    default: 
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    case 1000: 
    case 1001: 
    case 1002: 
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      return;
    case 1003: 
      parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    parama.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  private void a(MessageForPic paramMessageForPic, View paramView)
  {
    AIOImageProviderService localAIOImageProviderService = new AIOImageProviderService(paramMessageForPic.selfuin, paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic);
    Intent localIntent = new Intent(this.mContext, HotChatFlashPicActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(localAIOImageProviderService.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", xtm.a(paramMessageForPic));
    localBundle.putBoolean("isreaded", false);
    localBundle.putLong("uniseq", paramMessageForPic.uniseq);
    localBundle.putString("md5", paramMessageForPic.md5);
    localBundle.putBoolean("is_send", paramMessageForPic.isSend());
    localBundle.putString("self_uin", paramMessageForPic.selfuin);
    localBundle.putInt("curtype", paramMessageForPic.istroop);
    localBundle.putBoolean("self_identify", acfx.W(paramMessageForPic));
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", sxx.getViewRect(paramView));
    localIntent.putExtras(localBundle);
    this.mContext.startActivity(localIntent);
    if (paramMessageForPic.istroop == 0) {
      anot.a(this.app, "dc00898", "", "", "0X800699D", "0X800699D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (avfp.h != null) {
        avfp.h.dqV();
      }
      return;
      if (paramMessageForPic.istroop == 3000) {
        anot.a(this.app, "dc00898", "", "", "0X800699E", "0X800699E", 0, 0, "", "", "", "");
      } else if (paramMessageForPic.istroop == 1) {
        anot.a(this.app, "dc00898", "", "", "0X800699F", "0X800699F", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static Drawable f(Resources paramResources, int paramInt)
  {
    try
    {
      int i = (int)(paramResources.getDisplayMetrics().densityDpi / 160 * 6.0F);
      paramResources = new anqz(paramResources.getColor(paramInt), wja.dp2px(130.0F, paramResources), wja.dp2px(102.0F, paramResources), i);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashPicItemBuilder", 2, "getReadedDrawable OOM");
      }
    }
    return null;
  }
  
  private void j(MessageForPic paramMessageForPic)
  {
    akxy.a locala;
    int i;
    if (aqhq.fileExistsAndNotEmpty(paramMessageForPic.path))
    {
      this.app.b().t(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        this.app.a().oy(this.app.a().y(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      locala = new akxy.a();
      locala.setLocalPath(paramMessageForPic.path);
      if (!acfx.W(paramMessageForPic)) {
        break label234;
      }
      i = 1039;
      locala.So(i);
      locala.NP(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag != 1) {
        break label241;
      }
      locala.setProtocolType(aooh.a.dQD);
    }
    for (;;)
    {
      locala.NT(paramMessageForPic.senderuin);
      locala.kc(paramMessageForPic.selfuin);
      locala.Sp(paramMessageForPic.istroop);
      locala.extLong = paramMessageForPic.extLong;
      locala.extStr = paramMessageForPic.extStr;
      akxy.b localb = new akxy.b();
      localb.msgseq = paramMessageForPic.msgseq;
      localb.shmsgseq = paramMessageForPic.shmsgseq;
      localb.msgseq = paramMessageForPic.msgseq;
      locala.a(localb);
      paramMessageForPic = akxj.a(4, i);
      paramMessageForPic.c(locala.a());
      akxj.a(paramMessageForPic, this.app);
      notifyDataSetChanged();
      return;
      label234:
      i = 1040;
      break;
      label241:
      locala.setProtocolType(aooh.a.dQC);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject1 = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
    Object localObject2;
    if (!(this.mContext instanceof SplashActivity))
    {
      paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
      if (localObject1 != null)
      {
        localObject2 = this.app.b().a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
        paramBaseChatItemLayout = (BaseChatItemLayout)localObject1;
        if ((localObject2 instanceof MessageForPic)) {
          paramBaseChatItemLayout = (MessageForPic)localObject2;
        }
      }
    }
    boolean bool1 = acei.W(paramBaseChatItemLayout);
    localObject1 = (a)parame;
    parame = paramView;
    if (paramView == null)
    {
      Object localObject3 = this.mContext.getResources();
      parame = new RelativeLayout(this.mContext);
      parame.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView = new FlashPicAIOThumbView(this.mContext);
      paramView.setId(2131373231);
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramView.TE(false);
      paramView.setShowEdge(true);
      paramView.bgJ = false;
      parame.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      localObject2 = new BubbleImageView(this.mContext);
      ((BubbleImageView)localObject2).setAdjustViewBounds(true);
      ((BubbleImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((BubbleImageView)localObject2).setRadius(15.0F);
      ((BubbleImageView)localObject2).TE(false);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131373231);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131373231);
      ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131373231);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131373231);
      parame.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout(this.mContext);
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setId(2131368363);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(14);
      ((RelativeLayout)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.mContext);
      ((TextView)localObject5).setText(((Resources)localObject3).getText(2131694707));
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131167654));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131368363);
      localLayoutParams.addRule(14);
      localLayoutParams.topMargin = wja.dp2px(10.0F, (Resources)localObject3);
      ((RelativeLayout)localObject4).addView((View)localObject5, localLayoutParams);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      parame.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      parame.setOnClickListener(this.onClickListener);
      parame.setOnLongClickListener(paramwlz);
      parame.setOnTouchListener(paramwlz);
      ((a)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView = paramView;
      ((a)localObject1).d = ((BubbleImageView)localObject2);
      ((a)localObject1).icon = localImageView;
      ((a)localObject1).tv = ((TextView)localObject5);
    }
    ((a)localObject1).bgS = bool1;
    ((a)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.zq(bool1);
    boolean bool2;
    if (bool1)
    {
      bool2 = acei.X(paramBaseChatItemLayout);
      bool1 = false;
      paramView = aoop.a(paramBaseChatItemLayout, 65537);
      if ((!bool2) || (!((a)localObject1).isReaded)) {
        break label696;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FlashPicItemBuilder", 4, "isReuse:" + bool1 + ",isReaded:" + bool2);
      }
      a(paramChatMessage, parame, this);
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        ((a)localObject1).E = parame;
        a(this.app.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq), (a)localObject1);
      }
      return parame;
      bool2 = acfx.X(paramBaseChatItemLayout);
      break;
      label696:
      if ((!bool2) && (((a)localObject1).u != null) && (((a)localObject1).u.getURL().equals(paramView)))
      {
        bool1 = true;
      }
      else
      {
        ((a)localObject1).isReaded = bool2;
        if (bool2)
        {
          ((a)localObject1).icon.setImageResource(2130843390);
          ((a)localObject1).tv.setVisibility(0);
          ((a)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(this.a);
          ((a)localObject1).u = null;
        }
        else
        {
          ((a)localObject1).icon.setImageResource(2130843391);
          ((a)localObject1).tv.setVisibility(8);
          paramView = a(this.mContext, paramBaseChatItemLayout, null);
          ((a)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView.setImageDrawable(paramView);
          ((a)localObject1).u = paramView;
        }
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
    }
    for (;;)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
      this.app.a().aZ(paramChatMessage.frienduin, paramChatMessage.uniseq);
      this.app.a().Sd(this.sessionInfo.aTl);
      notifyDataSetChanged();
      return;
      super.j(paramChatMessage);
      return;
      super.m(paramChatMessage);
      return;
      xbp localxbp = new xbp(this);
      this.app.a().a(paramChatMessage.frienduin, localxbp);
    }
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashPicItemBuilder", 2, "status:" + paramInt1 + ",retCode:" + paramInt2);
    }
    if (((paramaoko.fileType != 1) && (paramaoko.fileType != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {
      return;
    }
    if ((paramInt1 == 1001) || (paramInt1 == 1000) || (paramInt1 == 4001) || (paramInt1 == 1002) || (paramInt1 == 1004) || (paramInt1 == 1005)) {}
    for (this.bgR = false;; this.bgR = true) {
      do
      {
        paramView = (a)wja.a(paramView);
        if ((paramView == null) || (paramView.mMessage == null)) {
          break;
        }
        MessageForPic localMessageForPic = (MessageForPic)paramView.mMessage;
        if ((localMessageForPic.uniseq != paramaoko.uniseq) || (!localMessageForPic.isSendFromLocal())) {
          break;
        }
        a(this.app.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
        return;
      } while ((paramInt1 != 1007) && (paramInt1 != 1003));
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (!paramChatMessage.isSendFromLocal()) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        paramChatMessage = (MessageForPic)paramChatMessage;
        if (paramChatMessage.size > 0L) {
          break;
        }
        paramChatMessage = this.app.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      } while (!(paramChatMessage instanceof aojn));
      if (((aojn)paramChatMessage).hh() == 1005L) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    } while (paramChatMessage.extraflag == 32768);
    return false;
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (a)wja.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)paramView.mMessage;
    if (paramView.bgS)
    {
      if (!localMessageForPic.isSendFromLocal())
      {
        if ((paramView.u == null) || (paramView.u.getStatus() == 1))
        {
          a(localaqoa, this.sessionInfo.cZ, localMessageForPic);
          a(localaqoa, localMessageForPic);
          super.c(localaqoa, this.mContext);
          super.e(localaqoa, this.mContext);
        }
        return localaqoa.a();
      }
      if (localMessageForPic.size > 0L)
      {
        if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.app.a().aR(localMessageForPic))) {
          a(localaqoa, this.sessionInfo.cZ, localMessageForPic);
        }
        a(localaqoa, localMessageForPic);
        super.c(localaqoa, this.mContext);
        super.e(localaqoa, this.mContext);
      }
    }
    for (;;)
    {
      return localaqoa.a();
      paramView = this.app.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((paramView instanceof aojn))
      {
        paramView = (aojn)paramView;
        long l = paramView.hh();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramView.hi() == 1003L))
        {
          ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
          super.c(localaqoa, this.mContext);
          super.e(localaqoa, this.mContext);
        }
        else
        {
          localaqoa.Z(2131364237, this.mContext.getString(2131691403), 2130839075);
          if (this.app.a().qm(this.sessionInfo.aTl)) {
            localaqoa.Z(2131364225, this.mContext.getString(2131691402), 2130839074);
          }
          this.mIsPaused = this.app.a().ql(this.sessionInfo.aTl);
        }
      }
      else
      {
        ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
        super.c(localaqoa, this.mContext);
        super.e(localaqoa, this.mContext);
        continue;
        ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
      }
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    if (aqiu.ms(paramChatMessage.issend)) {
      return acfp.m(2131706339);
    }
    return acfp.m(2131706340);
  }
  
  public void bYO()
  {
    super.bYO();
    if (this.mIsPaused)
    {
      this.app.a().Sd(this.sessionInfo.aTl);
      this.mIsPaused = false;
    }
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = wja.a(paramView);
    if (!(paramView instanceof a)) {
      return;
    }
    paramView = (a)paramView;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView.d.setImageDrawable(this.dN);
      return;
    }
    paramView.d.setImageDrawable(this.dO);
  }
  
  public void ei(View paramView)
  {
    paramView = (MessageForPic)((a)wja.a(paramView)).mMessage;
    if (paramView.isSendFromLocal())
    {
      ausj localausj = (ausj)auss.a(this.mContext, null);
      localausj.addButton(2131690230, 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new xbq(this, paramView, localausj));
      localausj.show();
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    paramView = wja.a(paramView);
    if (!(paramView instanceof a)) {
      return;
    }
    paramView = (a)paramView;
    if (paramBoolean)
    {
      paramView.d.setImageDrawable(this.dO);
      return;
    }
    paramView.d.setImageDrawable(this.dN);
  }
  
  public static class FlashPicAIOThumbView
    extends BubbleImageView
  {
    boolean bgS;
    
    public FlashPicAIOThumbView(Context paramContext)
    {
      super();
    }
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      super.onLoadSuccessed(paramURLDrawable);
      ThreadManager.postImmediately(new FlashPicItemBuilder.FlashPicAIOThumbView.1(this), null, true);
    }
    
    void zq(boolean paramBoolean)
    {
      this.bgS = paramBoolean;
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public FlashPicItemBuilder.FlashPicAIOThumbView a;
    public boolean bgS;
    public BubbleImageView d;
    public ImageView icon;
    public boolean isReaded;
    public TextView tv;
    public URLDrawable u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */