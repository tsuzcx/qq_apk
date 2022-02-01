package com.tencent.mobileqq.activity.aio.item;

import acbn;
import acfp;
import ahgq;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
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
import anot;
import apsb;
import aqcx;
import aqfv;
import aqoa;
import aqob;
import aqul;
import aquz;
import aqva;
import aqvc;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jnl;
import mqq.app.NewIntent;
import org.json.JSONObject;
import pnj;
import pnj.c;
import pnm;
import psx;
import ujt;
import wja;
import wlz;
import xpq;
import xpr;
import xps;

public class TribeShortVideoItemBuilder
  extends BaseBubbleBuilder
{
  public a a = new xps(this);
  protected boolean aDi;
  protected float[] aO;
  protected pnj b = new pnj();
  protected int bUA;
  protected int bUB;
  protected int bUC;
  protected int bUD;
  protected int bUz;
  protected aqvc c;
  protected Drawable dR;
  protected Drawable dS;
  protected Context mContext;
  protected final float mCornerRadius = 15.0F;
  public View.OnClickListener mOnClickListener = new xpq(this);
  
  public TribeShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    this.c = ((aqva)paramQQAppInterface.getManager(47)).a(1);
    this.b.a(this.a);
    ShortVideoUtils.a.initConfig();
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    try
    {
      paramImageView.setImageDrawable(paramDrawable);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "setImageUrl exp: " + paramImageView.toString());
    }
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
    boolean bool = paramChatMessage.isSend();
    parame = (b)parame;
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (localMessageForTribeShortVideo.videoWidth > localMessageForTribeShortVideo.videoHeight)
    {
      this.bUz = aqcx.dip2px(this.mContext, 218.0F);
      this.bUA = aqcx.dip2px(this.mContext, 137.0F);
      if (paramView != null) {
        break label759;
      }
      paramView = LayoutInflater.from(this.mContext).inflate(2131558916, paramBaseChatItemLayout, false);
      parame.X = ((RelativeLayout)paramView.findViewById(2131364503));
      parame.Ju = ((TextView)paramView.findViewById(2131363719));
      parame.Ju.setMaxLines(1);
      parame.Ju.setSingleLine(true);
      parame.tH = ((ImageView)paramView.findViewById(2131371168));
      parame.b = ((AutoStartProgressBar)parame.X.findViewById(2131381737));
      parame.b.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      parame.a = new TribeShortVideoView(this.mContext);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.bUz, this.bUA);
      parame.a.setLayoutParams(paramBaseChatItemLayout);
      parame.a.TD(false);
      parame.a.setRadius(15.0F);
      parame.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      parame.a.TE(true);
      parame.a.setFocusable(false);
      parame.a.setFocusableInTouchMode(false);
      parame.a.setClickable(false);
      parame.a.setSharpCornerCor(BubbleImageView.DEFAULT_EDGE_CORDS);
      parame.X.addView(parame.a, 0);
      paramBaseChatItemLayout = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
      paramBaseChatItemLayout.setShape(0);
      float f = aqcx.dip2px(this.mContext, 15.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      paramBaseChatItemLayout.setGradientType(0);
      parame.tH.setBackgroundDrawable(paramBaseChatItemLayout);
      parame.b.setRadius(15.0F, true);
      parame.b.setShowCorner(true);
      parame.b.setDrawStatus(1);
      paramView.setOnLongClickListener(paramwlz);
      paramView.setOnTouchListener(paramwlz);
      parame.X.setOnClickListener(this.mOnClickListener);
      i = this.mContext.getResources().getDimensionPixelSize(2131296410);
      j = this.bUz;
      k = BaseChatItemLayout.bNY;
      m = this.bUA;
      n = BaseChatItemLayout.bNV;
      i1 = this.bUD;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)parame.X.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      parame.X.setLayoutParams(paramBaseChatItemLayout);
      label526:
      parame.b.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      parame.b.setCornerDirection(bool);
      i = aqcx.dip2px(this.mContext, parame.a.AO);
      if (parame.a.mIsSend != bool)
      {
        parame.a.mIsSend = bool;
        parame.a.onResize(this.bUz - i, this.bUA - aqcx.dip2px(this.mContext, 3.0F));
        parame.a.invalidate();
      }
      if (bool) {
        break label878;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)parame.Ju.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      parame.Ju.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)parame.tH.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      parame.tH.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(parame, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      this.bUz = aqcx.dip2px(this.mContext, 137.0F);
      this.bUA = aqcx.dip2px(this.mContext, 218.0F);
      break;
      label759:
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.bUz, this.bUA);
      parame.a.setLayoutParams(paramBaseChatItemLayout);
      i = this.mContext.getResources().getDimensionPixelSize(2131296410);
      j = this.bUz;
      k = BaseChatItemLayout.bNY;
      m = this.bUA;
      n = BaseChatItemLayout.bNV;
      i1 = this.bUD;
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)parame.X.getLayoutParams();
      paramBaseChatItemLayout.width = (j + k + i);
      paramBaseChatItemLayout.height = (i1 + (m + n));
      parame.X.setLayoutParams(paramBaseChatItemLayout);
      break label526;
      label878:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)parame.Ju.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      parame.Ju.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)parame.tH.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      parame.tH.setLayoutParams(paramBaseChatItemLayout);
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTribeShortVideo))
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
      paramContext = new Bundle();
      if ((localMessageForTribeShortVideo.structingMsg.source_puin != null) && (!"".equals(localMessageForTribeShortVideo.structingMsg.source_puin))) {
        paramContext.putString("source_puin", localMessageForTribeShortVideo.structingMsg.source_puin);
      }
      paramContext.putInt("forward_type", 36);
      localMessageForTribeShortVideo.structingMsg.mCommentText = null;
      paramContext.putInt("structmsg_service_id", localMessageForTribeShortVideo.structingMsg.mMsgServiceID);
      paramContext.putByteArray("stuctmsg_bytes", localMessageForTribeShortVideo.structingMsg.getBytes());
      paramContext.putLong("structmsg_uniseq", localMessageForTribeShortVideo.uniseq);
      paramContext.putString("qqtribeVideoInfoExtra ", localMessageForTribeShortVideo.structingMsg.mTribeShortVideoExtra);
      paramContext.putInt("accostType", localMessageForTribeShortVideo.structingMsg.sourceAccoutType);
      paramContext.putInt("selection_mode", this.bOY);
      paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ahgq.f((Activity)this.mContext, paramChatMessage, 21);
      return;
      super.j(paramChatMessage);
      return;
      super.m(paramChatMessage);
    }
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    b localb = (b)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localb.be == null) {
      a(localb, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localb.Jw.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.bNY;
      localb.Jw.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label294;
      }
      localb.Ju.setText("#" + localMessageForTribeShortVideo.themeName);
      localb.Ju.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label381;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label343;
      }
      localb.Jw.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + acfp.m(2131715449));
      label189:
      localb.b.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (ShortVideoUtils.a.bhO)) {
        break label411;
      }
      localb.isPlaying = false;
      localb.b.setDrawStatus(2);
      localb.b.setVisibility(0);
      a(localb.a, localMessageForTribeShortVideo.coverImgUrl, this.bUz, this.bUA, this.dR);
    }
    label294:
    label343:
    label381:
    do
    {
      return;
      paramViewGroup.leftMargin = (aqcx.dip2px(this.mContext, localb.a.AO) + BaseChatItemLayout.bNX);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localb.Ju.setText(localMessageForTribeShortVideo.brief);
        localb.Ju.setVisibility(0);
        break label126;
      }
      localb.Ju.setVisibility(8);
      break label126;
      localb.Jw.setText(localMessageForTribeShortVideo.srcName + acfp.m(2131715450));
      break label189;
      localb.Jw.setText(this.mContext.getString(2131721951));
      localb.Jw.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localb.a.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label411:
    localb.isPlaying = false;
    a(localb.a, localMessageForTribeShortVideo.coverImgUrl, this.bUz, this.bUA, this.dR);
    a(localb, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localb.a.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  public void a(TribeShortVideoView paramTribeShortVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void a(b paramb)
  {
    try
    {
      paramb = (MessageForTribeShortVideo)paramb.mMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramb.toString());
      }
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramb.jumpUrl);
      this.mContext.startActivity(localIntent);
      anot.a(this.app, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramb.bid, paramb.pid, "", "");
      return;
    }
    catch (Exception paramb)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramb);
    }
  }
  
  public void a(b paramb, long paramLong)
  {
    ((Activity)this.mContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramb, paramLong));
  }
  
  public void a(b paramb, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramb.a, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!aqfv.a().b(paramb.mMessage, "video_play"))
    {
      aqfv.a().g(paramb.mMessage, "video_play");
      if ((paramb.mMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramb.mMessage;
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
        paramString1 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2.bid)) {
          continue;
        }
        paramLong = 0L;
        paramString1.put("bid", paramLong);
        if (!TextUtils.isEmpty(paramString2.pid)) {
          continue;
        }
        paramb = Integer.valueOf(0);
        paramString1.put("pid", paramb);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramb)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramb = new NewIntent(this.mContext, jnl.class);
      paramb.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramb.putExtra("data", paramString2.toByteArray());
      this.app.startServlet(paramb);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramb = paramString2.pid;
    }
  }
  
  public void a(b paramb, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(aqul.getSDKPrivatePath(acbn.bea + paramMessageForTribeShortVideo.mVid + ".mp4"));
    if (((File)localObject).exists())
    {
      if ((this.mContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.mContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramb, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.mContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramb));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramb);
  }
  
  protected void a(b paramb, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramb.be = new FrameLayout(this.mContext);
    Object localObject1 = new TextView(this.mContext);
    ((TextView)localObject1).setBackgroundResource(2130843454);
    Object localObject2 = this.mContext.getResources().getDrawable(2130847257);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131167654));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(aqcx.dip2px(this.mContext, 5.0F), 0, aqcx.dip2px(this.mContext, 5.0F), 0);
    paramb.be.setOnClickListener(this.mOnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramb.be.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramb.Jw = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364503);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364503);
    paramViewGroup.addView(paramb.be, (ViewGroup.LayoutParams)localObject1);
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, b paramb)
  {
    Object localObject1 = new File(aqul.getSDKPrivatePath(acbn.bea));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = acbn.bea + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File(aqul.getSDKPrivatePath((String)localObject1));
    localObject2 = new aquz(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((aquz)localObject2).retryCount = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.c.a((aquz)localObject2, new xpr(this, paramb, paramMessageForTribeShortVideo), localBundle);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    if (apsb.a(paramView) == null) {}
    localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    if ((paramView.extraflag != 32768) && (!this.app.a().aR(paramView))) {
      a(localaqoa, this.sessionInfo.cZ, paramView);
    }
    a(localaqoa, paramView);
    c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void b(b paramb)
  {
    try
    {
      paramb = (MessageForTribeShortVideo)paramb.mMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramb.toString());
      }
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramb.sourceJumpUrl);
      this.mContext.startActivity(localIntent);
      anot.a(this.app, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramb.bid, paramb.pid, "", "");
      return;
    }
    catch (Exception paramb)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramb);
    }
  }
  
  public static class TribeShortVideoView
    extends BubbleImageView
  {
    public Drawable mLastDrawable;
    
    public TribeShortVideoView(Context paramContext)
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
  
  public class a
    implements pnj.c
  {
    protected long Jl;
    protected TribeShortVideoItemBuilder.b b;
    protected String mVid;
    
    public a() {}
    
    public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt) {}
    
    public void onSuccess(String paramString1, String paramString2, int paramInt)
    {
      if (!paramString1.equals(this.mVid)) {}
    }
    
    public void p(String paramString1, String paramString2, int paramInt) {}
  }
  
  public static class b
    extends BaseBubbleBuilder.e
  {
    public TextView Ju;
    public TextView Jw;
    public RelativeLayout X;
    public TribeShortVideoItemBuilder.TribeShortVideoView a;
    public AutoStartProgressBar b;
    public FrameLayout be;
    public boolean isPlaying;
    public ImageView tH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */