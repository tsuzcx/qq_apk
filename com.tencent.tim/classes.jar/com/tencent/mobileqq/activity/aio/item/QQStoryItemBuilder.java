package com.tencent.mobileqq.activity.aio.item;

import acfp;
import ahgq;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import angb;
import apsb;
import aqcx;
import aqfv;
import aqha;
import aqhv;
import aqik;
import aqiw;
import aqju;
import aqoa;
import aqob;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import pnj;
import pnj.c;
import pnm;
import psu;
import psx;
import ptw;
import qem;
import ram;
import rar;
import ujt;
import wja;
import wkh;
import wlz;
import xlm;
import xln;
import xlo;
import xlp;
import xlq;

public class QQStoryItemBuilder
  extends BaseBubbleBuilder
{
  public a a = new xlp(this);
  protected boolean aDi;
  protected float[] aO;
  protected String axR;
  protected pnj b = new pnj();
  protected int bUA;
  protected int bUB;
  protected int bUC;
  protected int bUD;
  protected int bUE;
  protected int bUz;
  protected Drawable dR;
  protected Drawable dS;
  private StoryVideoItem e;
  protected Context mContext;
  public View.OnClickListener mOnClickListener = new xlm(this);
  protected final float qo = 15.0F;
  
  public QQStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mContext = paramContext;
    float f = aqcx.dip2px(this.mContext, 15.0F);
    this.aO = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f };
    this.dR = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.dS = new ColorDrawable(Color.parseColor("#00000000"));
    this.bUB = aqcx.dip2px(this.mContext, 135.0F);
    this.bUC = aqcx.dip2px(this.mContext, 19.0F);
    this.bUz = aqcx.dip2px(this.mContext, 137.0F);
    this.bUA = aqcx.dip2px(this.mContext, 218.0F);
    this.bUD = aqcx.dip2px(this.mContext, 7.0F);
    paramBaseAdapter = (pnm)psx.a(6);
    if (!paramBaseAdapter.Iy())
    {
      paramBaseAdapter.blW();
      this.aDi = true;
    }
    this.b.a(this.a);
    ShortVideoUtils.a.initConfig();
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 5);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable) {}
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqhv paramaqhv, boolean paramBoolean)
  {
    int i = 3;
    if (paramInt == 0) {
      i = 1;
    }
    for (;;)
    {
      if (paramaqhv != null) {}
      for (;;)
      {
        try
        {
          str = paramaqhv.getAttribute("unionid");
          paramQQAppInterface = paramaqhv.getAttribute("storyid");
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        try
        {
          paramInt = Integer.valueOf(paramaqhv.getAttribute("contentType")).intValue();
          paramaqhv = str;
        }
        catch (Exception paramaqhv)
        {
          paramInt = -1;
          paramaqhv = str;
          continue;
        }
        if (paramBoolean)
        {
          str = "1";
          rar.a("share_obj", paramString, i, paramInt, new String[] { paramaqhv, paramQQAppInterface, str, "" });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.share", 2, "reportClickEvent: opName=" + paramString + ", fromType=" + i + ", result=" + paramInt + ", extra1=" + paramaqhv + ", extra2=" + paramQQAppInterface + ", extra3=" + str);
          return;
        }
        str = "2";
        continue;
        QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramQQAppInterface);
        return;
        paramInt = -1;
        paramaqhv = "";
        paramQQAppInterface = "";
      }
      return;
      if (paramInt == 1) {
        i = 2;
      } else if (paramInt != 3000) {
        i = -1;
      }
    }
  }
  
  private void v(StoryVideoItem paramStoryVideoItem)
  {
    int i = 1;
    ptw localptw = paramStoryVideoItem.getVideoGameInfo();
    if (localptw != null)
    {
      this.axR = localptw.id;
      if (!paramStoryVideoItem.isMine()) {
        break label45;
      }
      if (localptw.type != 1) {
        break label40;
      }
    }
    for (;;)
    {
      this.bUE = i;
      return;
      label40:
      i = 3;
    }
    label45:
    if (localptw.type == 1) {}
    for (i = 2;; i = 4)
    {
      this.bUE = i;
      return;
    }
  }
  
  protected boolean J(MessageRecord paramMessageRecord)
  {
    if (this.app.a().bL.get() == 2) {}
    while (NetConnInfoCenter.getServerTimeMillis() - paramMessageRecord.time * 1000L > angb.akW) {
      return false;
    }
    return aqiw.isWifiConnected(this.mContext);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    b localb = (b)parame;
    boolean bool = paramChatMessage.isSend();
    parame = paramView;
    int j;
    if (paramView == null)
    {
      parame = LayoutInflater.from(this.mContext).inflate(2131558916, paramBaseChatItemLayout, false);
      localb.X = ((RelativeLayout)parame.findViewById(2131364503));
      localb.Ju = ((TextView)localb.X.findViewById(2131363719));
      localb.Jv = ((TextView)localb.X.findViewById(2131372482));
      localb.tq = ((ImageView)localb.X.findViewById(2131370908));
      localb.tr = ((ImageView)localb.X.findViewById(2131371168));
      localb.dq = ((ViewGroup)localb.X.findViewById(2131367864));
      localb.Jx = ((TextView)localb.X.findViewById(2131367883));
      localb.Jy = ((TextView)localb.X.findViewById(2131367852));
      localb.b = ((AutoStartProgressBar)localb.X.findViewById(2131381737));
      localb.b.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      localb.a = new StoryChatVideoView(this.mContext);
      paramView = new RelativeLayout.LayoutParams(this.bUz, this.bUA);
      localb.a.setLayoutParams(paramView);
      localb.a.TD(false);
      localb.a.setRadius(15.0F);
      localb.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localb.a.TE(true);
      localb.a.setFocusable(false);
      localb.a.setFocusableInTouchMode(false);
      localb.a.setClickable(false);
      localb.a.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      localb.X.addView(localb.a, 0);
      localb.e = new BubbleImageView(this.mContext);
      paramView = new RelativeLayout.LayoutParams(this.bUz, this.bUA);
      localb.e.setLayoutParams(paramView);
      localb.e.TD(false);
      localb.e.setRadius(15.0F);
      localb.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localb.e.TE(true);
      localb.e.setFocusable(false);
      localb.e.setFocusableInTouchMode(false);
      localb.e.setClickable(false);
      localb.e.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      localb.X.addView(localb.e, 1);
      localb.f = new BubbleImageView(this.mContext);
      localb.f.setLayoutParams(new RelativeLayout.LayoutParams(this.bUz, this.bUA));
      localb.f.TD(false);
      localb.f.setRadius(15.0F);
      localb.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localb.f.TE(true);
      localb.f.setFocusable(false);
      localb.f.setFocusableInTouchMode(false);
      localb.f.setClickable(false);
      localb.f.setVisibility(4);
      localb.X.addView(localb.f, 2);
      localb.g = new BubbleImageView(this.mContext);
      localb.g.setLayoutParams(new RelativeLayout.LayoutParams(this.bUz, this.bUA));
      localb.g.TD(false);
      localb.g.setRadius(15.0F);
      localb.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localb.g.TE(true);
      localb.g.setFocusable(false);
      localb.g.setFocusableInTouchMode(false);
      localb.g.setClickable(false);
      localb.g.setVisibility(4);
      localb.X.addView(localb.g, 2);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramView.setShape(0);
      float f = aqcx.dip2px(this.mContext, 15.0F);
      paramView.setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      paramView.setGradientType(0);
      localb.tr.setBackgroundDrawable(paramView);
      localb.b.setRadius(15.0F, true);
      localb.b.setShowCorner(true);
      localb.b.setDrawStatus(1);
      parame.setOnLongClickListener(paramwlz);
      parame.setOnTouchListener(paramwlz);
      localb.X.setOnClickListener(this.mOnClickListener);
      i = this.mContext.getResources().getDimensionPixelSize(2131296410);
      j = this.bUz;
      int k = BaseChatItemLayout.bNY;
      int m = this.bUA;
      int n = BaseChatItemLayout.bNV;
      int i1 = this.bUD;
      paramView = (RelativeLayout.LayoutParams)localb.X.getLayoutParams();
      paramView.width = (j + k + i);
      paramView.height = (i1 + (m + n));
      localb.X.setLayoutParams(paramView);
    }
    localb.b.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
    localb.b.setCornerDirection(bool);
    if (localb.a.mIsSend != bool)
    {
      localb.a.mIsSend = bool;
      localb.e.mIsSend = bool;
      localb.f.mIsSend = bool;
      localb.g.mIsSend = bool;
      if (VersionUtils.isHoneycomb())
      {
        localb.a.onResize(this.bUz, this.bUA);
        localb.e.onResize(this.bUz, this.bUA);
        localb.f.onResize(this.bUz, this.bUA);
        localb.g.onResize(this.bUz, this.bUA);
      }
      localb.a.invalidate();
      localb.e.invalidate();
      localb.f.invalidate();
      localb.g.invalidate();
    }
    int i = aqcx.dip2px(this.mContext, localb.a.AO);
    if ((paramChatMessage instanceof MessageForQQStory))
    {
      paramChatMessage = (MessageForQQStory)paramChatMessage;
      if ((TextUtils.isEmpty(paramChatMessage.storyTitle)) || (TextUtils.isEmpty(paramChatMessage.storyBrief))) {
        break label1520;
      }
      j = 1;
      if (j == 0) {
        break label1539;
      }
      paramView = (RelativeLayout.LayoutParams)localb.dq.getLayoutParams();
      if (bool) {
        break label1526;
      }
      j = i;
      label1258:
      paramView.leftMargin = j;
      if (bool) {
        break label1532;
      }
      j = 0;
      label1272:
      paramView.rightMargin = j;
      paramView.width = (this.bUz - i);
      paramView.height = aqcx.dip2px(this.mContext, 42.0F);
      localb.dq.setLayoutParams(paramView);
      localb.dq.setVisibility(0);
      if ((GradientDrawable)localb.dq.getBackground() == null)
      {
        paramView = new GradientDrawable();
        paramView.setCornerRadii(this.aO);
        paramView.setColor(1929379840);
        localb.dq.setBackgroundDrawable(paramView);
      }
      localb.Jx.setText(paramChatMessage.storyTitle);
      localb.Jy.setText(paramChatMessage.storyBrief);
    }
    for (;;)
    {
      if (bool) {
        break label1552;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localb.Ju.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localb.Ju.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localb.tq.getLayoutParams();
      paramChatMessage.leftMargin = aqcx.dip2px(this.mContext, localb.a.AO + 10);
      paramChatMessage.rightMargin = aqcx.dip2px(this.mContext, 10);
      localb.tq.setLayoutParams(paramChatMessage);
      paramChatMessage = (RelativeLayout.LayoutParams)localb.tr.getLayoutParams();
      paramChatMessage.leftMargin = i;
      paramChatMessage.rightMargin = 0;
      localb.tr.setLayoutParams(paramChatMessage);
      return parame;
      label1520:
      j = 0;
      break;
      label1526:
      j = 0;
      break label1258;
      label1532:
      j = i;
      break label1272;
      label1539:
      localb.dq.setVisibility(8);
    }
    label1552:
    paramChatMessage = (RelativeLayout.LayoutParams)localb.Ju.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localb.Ju.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localb.tq.getLayoutParams();
    paramChatMessage.leftMargin = aqcx.dip2px(this.mContext, 10);
    paramChatMessage.rightMargin = aqcx.dip2px(this.mContext, localb.a.AO + 10);
    localb.tq.setLayoutParams(paramChatMessage);
    paramChatMessage = (RelativeLayout.LayoutParams)localb.tr.getLayoutParams();
    paramChatMessage.leftMargin = 0;
    paramChatMessage.rightMargin = i;
    localb.tr.setLayoutParams(paramChatMessage);
    return parame;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForQQStory)) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
    MessageForQQStory localMessageForQQStory;
    do
    {
      boolean bool;
      Object localObject1;
      do
      {
        do
        {
          do
          {
            return;
            localMessageForQQStory = (MessageForQQStory)paramChatMessage;
            if (apsb.a(paramChatMessage) == null) {
              bool = true;
            }
            for (;;)
            {
              Object localObject2 = null;
              try
              {
                localObject1 = aqik.c(this.app, this.mContext, localMessageForQQStory.msgAction);
                switch (paramInt)
                {
                default: 
                  super.a(paramInt, paramContext, paramChatMessage);
                  return;
                  bool = false;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localObject1 = localObject2;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("Q.qqstory.share", 2, "onMenuItemClicked exp:", localException);
                    localObject1 = localObject2;
                  }
                }
                ujt.b(this.mContext, this.app, paramChatMessage);
                a(this.app, this.sessionInfo.cZ, "delete", (aqhv)localObject1, bool);
                if (localMessageForQQStory.type == 3) {
                  rar.a("mystory", "delete_obj_myday", 0, 0, new String[] { "", "", "", "" });
                }
              }
            }
          } while (localMessageForQQStory.type != 1);
          rar.a("mystory", "delete_obj", 0, 0, new String[] { "", "", "", "" });
          return;
          paramContext = new Bundle();
          if ((localMessageForQQStory.structingMsg.source_puin != null) && (!"".equals(localMessageForQQStory.structingMsg.source_puin))) {
            paramContext.putString("source_puin", localMessageForQQStory.structingMsg.source_puin);
          }
          paramContext.putInt("forward_type", 28);
          localMessageForQQStory.structingMsg.mCommentText = null;
          paramContext.putInt("structmsg_service_id", localMessageForQQStory.structingMsg.mMsgServiceID);
          paramContext.putByteArray("stuctmsg_bytes", localMessageForQQStory.structingMsg.getBytes());
          paramContext.putLong("structmsg_uniseq", localMessageForQQStory.uniseq);
          paramContext.putInt("accostType", localMessageForQQStory.structingMsg.sourceAccoutType);
          paramContext.putInt("selection_mode", this.bOY);
          paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          ahgq.f((Activity)this.mContext, paramChatMessage, 21);
          a(this.app, this.sessionInfo.cZ, "forward", (aqhv)localObject1, bool);
          if (localMessageForQQStory.type == 3) {
            rar.a("mystory", "forward_obj_myday", 0, 0, new String[] { "", "", "", "" });
          }
        } while (localMessageForQQStory.type != 1);
        rar.a("mystory", "forward_obj", 0, 0, new String[] { "", "", "", "" });
        return;
        super.j(paramChatMessage);
        a(this.app, this.sessionInfo.cZ, "withdraw", (aqhv)localObject1, bool);
        if (localMessageForQQStory.type == 3) {
          rar.a("mystory", "withdraw_obj_myday", 0, 0, new String[] { "", "", "", "" });
        }
      } while (localMessageForQQStory.type != 1);
      rar.a("mystory", "withdraw_obj", 0, 0, new String[] { "", "", "", "" });
      return;
      super.a(paramInt, paramContext, paramChatMessage);
      a(this.app, this.sessionInfo.cZ, "reply", (aqhv)localObject1, bool);
      if (localMessageForQQStory.type == 1)
      {
        rar.a("mystory", "reply_obj", 0, 0, new String[] { "", "", "", "" });
        return;
      }
    } while (localMessageForQQStory.type != 2);
    rar.a("ugc_video", "obj_reply", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.mContext.getResources().getDimensionPixelSize(2131296410);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, BaseChatItemLayout.bNV, i, this.bUD);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, this.bUD);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    a((ViewGroup)paramView, paramChatMessage);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForQQStory localMessageForQQStory = (MessageForQQStory)paramChatMessage;
    localMessageForQQStory.parse();
    b localb = (b)paramViewGroup.getTag();
    boolean bool = localMessageForQQStory.isSend();
    if (localb.be == null) {
      a(localb, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localb.Jw.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.bNY;
      localb.Jw.setLayoutParams(paramViewGroup);
      localb.Ju.setText(localMessageForQQStory.brief);
      localb.Jw.setText(localMessageForQQStory.srcName);
      if ((localMessageForQQStory.type != 3) && (localMessageForQQStory.type != 5) && (localMessageForQQStory.type != 8) && (localMessageForQQStory.type != 9)) {
        break label346;
      }
      localb.Jv.setVisibility(0);
      localb.Jv.setText(acfp.m(2131712305));
      label161:
      localb.b.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForQQStory.mVid)) && (ShortVideoUtils.a.bhO)) {
        break label422;
      }
      localb.isPlaying = false;
      localb.b.setDrawStatus(2);
      localb.b.setVisibility(0);
      a(localb.a, localMessageForQQStory.coverImgUrl, this.bUz, this.bUA, this.dR);
      a(localb.tq, localMessageForQQStory.logoImgUrl, this.bUB, this.bUC, this.dS);
      localb.e.setImageDrawable(null);
    }
    for (;;)
    {
      try
      {
        paramViewGroup = aqik.c(this.app, this.mContext, localMessageForQQStory.msgAction);
        if (apsb.a(localMessageForQQStory) != null) {
          continue;
        }
        bool = true;
        a(this.app, this.sessionInfo.cZ, "exp", paramViewGroup, bool);
        return;
      }
      catch (Exception paramViewGroup)
      {
        label346:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label422:
        QLog.w("Q.qqstory.share", 2, "getView report exp:", paramViewGroup);
      }
      paramViewGroup.leftMargin = (aqcx.dip2px(this.mContext, localb.a.AO) + BaseChatItemLayout.bNX);
      break;
      if (localMessageForQQStory.type == 11)
      {
        localb.Jv.setVisibility(0);
        if (!TextUtils.isEmpty(localMessageForQQStory.mHeadTip))
        {
          localb.Jv.setText(localMessageForQQStory.mHeadTip);
          break label161;
        }
        localb.Jv.setText(acfp.m(2131712304));
        break label161;
      }
      localb.Jv.setVisibility(8);
      break label161;
      paramViewGroup = (Long)localb.a.getTag();
      paramChatMessage = ((psu)psx.a(5)).a(localMessageForQQStory.mVid);
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != localMessageForQQStory.uniseq))
      {
        localb.isPlaying = false;
        localb.e.setImageDrawable(null);
        a(localb.a, localMessageForQQStory.coverImgUrl, this.bUz, this.bUA, this.dR);
        if (paramChatMessage != null)
        {
          b(localb, localMessageForQQStory.uniseq, paramChatMessage, false);
          c(localb, localMessageForQQStory.uniseq, paramChatMessage, false);
        }
        a(localb, localMessageForQQStory.coverImgUrl, localMessageForQQStory.mVid, localMessageForQQStory.uniseq, false);
        localb.a.setTag(Long.valueOf(localMessageForQQStory.uniseq));
      }
      else if (paramChatMessage != null)
      {
        b(localb, localMessageForQQStory.uniseq, paramChatMessage, false);
        c(localb, localMessageForQQStory.uniseq, paramChatMessage, false);
        continue;
        bool = false;
      }
    }
  }
  
  public void a(b paramb)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        paramb = (MessageForQQStory)paramb.mMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick:" + paramb.toString());
        }
        if (apsb.a(paramb) == null)
        {
          paramb = aqik.c(this.app, this.mContext, paramb.msgAction);
          paramb.ace();
          a(this.app, this.sessionInfo.cZ, "clk_play", paramb, bool);
          int i = this.bUE;
          String str = this.axR;
          if (this.e == null)
          {
            paramb = "";
            rar.a("video_game", "clk_gamevideo", 0, 0, new String[] { String.valueOf(i), "", str, paramb });
            return;
          }
          paramb = this.e.mVid;
          continue;
        }
        bool = false;
      }
      catch (Exception paramb)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onBubbleOnClick exp:", paramb);
        }
        return;
      }
    }
  }
  
  public void a(b paramb, long paramLong)
  {
    ((Activity)this.mContext).runOnUiThread(new QQStoryItemBuilder.10(this, paramb, paramLong));
  }
  
  public void a(b paramb, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramb, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!aqfv.a().b(paramb.mMessage, "share|auto_play"))
    {
      aqfv.a().g(paramb.mMessage, "share|auto_play");
      if (!(paramb.mMessage instanceof MessageForQQStory)) {
        break label188;
      }
      paramInt1 = ((MessageForQQStory)paramb.mMessage).type;
      if (paramInt1 != 1) {
        break label91;
      }
      paramInt1 = 1;
    }
    label188:
    for (;;)
    {
      rar.a("share", "auto_play", paramInt1, 0, new String[0]);
      return;
      label91:
      if (paramInt1 == 3)
      {
        paramInt1 = 2;
      }
      else if (paramInt1 == 4)
      {
        paramInt1 = 3;
      }
      else if (paramInt1 == 5)
      {
        paramInt1 = 4;
      }
      else if (paramInt1 == 6)
      {
        paramInt1 = 5;
      }
      else if (paramInt1 == 9)
      {
        paramInt1 = 6;
      }
      else if (paramInt1 == 12)
      {
        paramInt1 = 7;
      }
      else if (paramInt1 == 11)
      {
        paramInt1 = 8;
      }
      else
      {
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
      }
    }
  }
  
  public void a(b paramb, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    this.e = paramStoryVideoItem;
    boolean bool = StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "handleGetVideo: isPlayable =" + bool);
    }
    Object localObject;
    if (!bool) {
      if ((J(paramb.mMessage)) || (paramBoolean))
      {
        ((Activity)this.mContext).runOnUiThread(new QQStoryItemBuilder.5(this, paramb));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 1: wifi download");
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramStoryVideoItem);
        this.b.dV((List)localObject);
        this.b.fN(paramStoryVideoItem.mVid);
        this.a.a(paramb, paramStoryVideoItem.mVid, paramLong);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder handleGetVideo 2: no wifi");
      }
      ((Activity)this.mContext).runOnUiThread(new QQStoryItemBuilder.6(this, paramb, paramLong, paramStoryVideoItem));
      return;
      String str = this.b.fN(paramStoryVideoItem.mVid);
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.startsWith("file://")) {
          localObject = str.substring(7);
        }
      }
    } while (!(this.mContext instanceof Activity));
    ((Activity)this.mContext).runOnUiThread(new QQStoryItemBuilder.7(this, (String)localObject, paramb, paramStoryVideoItem, paramLong, paramBoolean));
  }
  
  protected void a(b paramb, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramb.be = new FrameLayout(this.mContext);
    Object localObject = new TextView(this.mContext);
    ((TextView)localObject).setBackgroundResource(2130843454);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131167654));
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setPadding(aqcx.dip2px(this.mContext, 5.0F), 0, aqcx.dip2px(this.mContext, 5.0F), 0);
    paramb.be.setOnClickListener(this.mOnClickListener);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramb.be.addView((View)localObject, localLayoutParams);
    paramb.Jw = ((TextView)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364503);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364503);
    paramViewGroup.addView(paramb.be, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(b paramb, String paramString, long paramLong, boolean paramBoolean)
  {
    qem.a(this.app, paramString, new xlq(this, paramb, paramLong, paramBoolean));
  }
  
  public void a(b paramb, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    ram.b("QQStoryItemBuilder", "setVideoView %s vid %s", paramString1, paramString2);
    ThreadManager.post(new QQStoryItemBuilder.8(this, paramString2, paramb, paramLong, paramString1, paramBoolean), 8, null, true);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    boolean bool;
    if (apsb.a(paramView) == null) {
      bool = true;
    }
    for (;;)
    {
      localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
      a(paramView, localaqoa);
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.app.a().aR(paramView))) {
        a(localaqoa, this.sessionInfo.cZ, paramView);
      }
      a(localaqoa, paramView);
      b(paramView, localaqoa);
      try
      {
        paramView = (MessageForQQStory)paramView;
        paramView = aqik.c(this.app, this.mContext, paramView.msgAction);
        a(this.app, this.sessionInfo.cZ, "press", paramView, bool);
        super.e(localaqoa, this.mContext);
        return localaqoa.a();
        bool = false;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "getMenuItem exp:", paramView);
          }
        }
      }
    }
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void b(b paramb)
  {
    for (;;)
    {
      try
      {
        paramb = (MessageForQQStory)paramb.mMessage;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick:" + paramb.toString());
        }
        if (apsb.a(paramb) == null)
        {
          bool = true;
          aqik.c(this.app, this.mContext, paramb.srcAction).ace();
          paramb = aqik.c(this.app, this.mContext, paramb.msgAction);
          a(this.app, this.sessionInfo.cZ, "clk_tail", paramb, bool);
          return;
        }
      }
      catch (Exception paramb)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqstory.share", 2, "QQStoryItemBuilder onSourceOnClick exp:", paramb);
      }
      bool = false;
    }
  }
  
  public void b(b paramb, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void b(b paramb, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    ram.i("QQStoryItemBuilder", "updateStoryPollLayout");
    String str = paramStoryVideoItem.getPollDescription();
    if (TextUtils.equals(str, (String)paramb.f.getTag()))
    {
      ram.d("QQStoryItemBuilder", "updateStoryPollLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isPollVideo())
    {
      PollContainerLayout localPollContainerLayout = new PollContainerLayout(this.mContext);
      localPollContainerLayout.ac(true);
      localPollContainerLayout.u(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.bUz, this.bUA));
      localFrameLayout.addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.bUz, 1073741824), View.MeasureSpec.makeMeasureSpec(this.bUA, 1073741824));
      localFrameLayout.layout(0, 0, this.bUz, this.bUA);
      localPollContainerLayout.u(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.bUz, this.bUA, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramb.f.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramStoryVideoItem));
      paramb.f.setVisibility(0);
    }
    for (;;)
    {
      paramb.f.setTag(str);
      return;
      paramb.f.setVisibility(4);
    }
  }
  
  public void c(b paramb, long paramLong, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    ram.i("QQStoryItemBuilder", "updateStoryInteractLayout");
    String str = paramStoryVideoItem.getInteractDescription();
    if (TextUtils.equals(str, (String)paramb.g.getTag()))
    {
      ram.d("QQStoryItemBuilder", "updateStoryInteractLayout no need refresh, it is already %s", str);
      return;
    }
    if (paramStoryVideoItem.isInteractVideo())
    {
      InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout(this.mContext);
      localInteractContainerLayout.t(paramStoryVideoItem);
      FrameLayout localFrameLayout = new FrameLayout(this.mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.bUz, this.bUA));
      localFrameLayout.addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.bUz, 1073741824), View.MeasureSpec.makeMeasureSpec(this.bUA, 1073741824));
      localFrameLayout.layout(0, 0, this.bUz, this.bUA);
      localInteractContainerLayout.t(paramStoryVideoItem);
      paramStoryVideoItem = Bitmap.createBitmap(this.bUz, this.bUA, Bitmap.Config.ARGB_8888);
      localFrameLayout.draw(new Canvas(paramStoryVideoItem));
      paramb.g.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramStoryVideoItem));
      paramb.g.setVisibility(0);
    }
    for (;;)
    {
      paramb.g.setTag(str);
      return;
      paramb.g.setVisibility(4);
    }
  }
  
  public void destroy()
  {
    this.b.onDestroy();
    if (this.aDi)
    {
      ((pnm)psx.a(6)).ff(15000L);
      this.aDi = false;
    }
    super.destroy();
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    Object localObject = wja.a(paramView);
    if (!b.class.isInstance(localObject)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = this.mContext;
      localObject = ((b)localObject).mMessage;
      str1 = paramView.getString(2131690230);
      str2 = paramView.getString(2131690231);
    } while (!((ChatMessage)localObject).isSendFromLocal());
    aqha.a(paramView, 230, str1, str2, new xln(this, paramView, (ChatMessage)localObject), new xlo(this)).show();
  }
  
  public static class StoryChatVideoView
    extends BubbleImageView
  {
    public Drawable mLastDrawable;
    
    public StoryChatVideoView(Context paramContext)
    {
      super();
    }
    
    public void setImageDrawable(Drawable paramDrawable)
    {
      if (this.mLastDrawable != paramDrawable)
      {
        this.mLastDrawable = paramDrawable;
        super.setImageDrawable(paramDrawable);
      }
    }
  }
  
  public static class a
    implements pnj.c
  {
    protected long IO;
    protected QQStoryItemBuilder.b c;
    protected String mVid;
    
    public void a(QQStoryItemBuilder.b paramb, String paramString, long paramLong)
    {
      this.c = paramb;
      this.IO = paramLong;
      this.mVid = paramString;
    }
    
    public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt) {}
    
    public void onSuccess(String paramString1, String paramString2, int paramInt) {}
    
    public void p(String paramString1, String paramString2, int paramInt) {}
  }
  
  public static class b
    extends BaseBubbleBuilder.e
  {
    public TextView Ju;
    public TextView Jv;
    public TextView Jw;
    public TextView Jx;
    public TextView Jy;
    public RelativeLayout X;
    public QQStoryItemBuilder.StoryChatVideoView a;
    public AutoStartProgressBar b;
    public FrameLayout be;
    public ViewGroup dq;
    public BubbleImageView e;
    public BubbleImageView f;
    public BubbleImageView g;
    public boolean isPlaying;
    public ImageView tq;
    public ImageView tr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */