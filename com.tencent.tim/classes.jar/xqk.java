import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.4;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public abstract class xqk
  extends BaseBubbleBuilder
{
  protected int bWn;
  protected int bWo;
  protected int bWp;
  protected int bWq;
  protected int bWr;
  protected int bWs = 12303291;
  protected int bWt;
  
  public xqk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.bWn = aqcx.dip2px(paramContext, 151.5F);
    this.bWo = aqcx.dip2px(paramContext, 125.5F);
    this.bWp = aqcx.dip2px(paramContext, 152.0F);
    this.bWq = aqcx.dip2px(this.mContext, 14.0F);
    this.bWr = aqcx.dip2px(this.mContext, 10.0F);
    this.bWt = aqcx.dip2px(this.mContext, 50.0F);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131377133: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, BaseChatItemLayout.bNV, 0, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  public void a(xqk.a parama, BaseChatItemLayout paramBaseChatItemLayout)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)parama.mMessage;
    Resources localResources;
    Object localObject1;
    TextView localTextView;
    Object localObject2;
    Drawable localDrawable;
    if (parama.be == null)
    {
      localResources = this.mContext.getResources();
      parama.be = new FrameLayout(this.mContext);
      localObject1 = new FrameLayout.LayoutParams(-2, -2);
      localTextView = new TextView(this.mContext);
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setBackgroundResource(2130843454);
      parama.be.addView(localTextView, (ViewGroup.LayoutParams)localObject1);
      parama.Jw = localTextView;
      parama.Jw.setText(localMessageForTroopSign.srcName);
      if (!TextUtils.isEmpty(localMessageForTroopSign.srcIconUrl))
      {
        localObject2 = localMessageForTroopSign.srcIconUrl;
        localDrawable = localResources.getDrawable(2130851467);
        localDrawable.setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
        localObject1 = new ColorDrawable(15790320);
        ((Drawable)localObject1).setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
      }
    }
    else
    {
      try
      {
        localObject2 = URLDrawable.getDrawable((String)localObject2, localDrawable, (Drawable)localObject1);
        if (aoop.bD(this.mContext)) {
          break label399;
        }
        bool = true;
        ((URLDrawable)localObject2).setAutoDownload(bool);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          label296:
          if (QLog.isColorLevel()) {
            QLog.e("TroopSignItemBuilder", 2, "setSourceView exception" + localException.toString());
          }
        }
      }
      ((Drawable)localObject1).setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
      localTextView.setCompoundDrawablePadding(wja.dp2px(3.0F, localResources));
      localTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView.setPadding(wja.dp2px(5.0F, localResources), 0, wja.dp2px(5.0F, localResources), 0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364503);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364503);
      paramBaseChatItemLayout.addView(parama.be, (ViewGroup.LayoutParams)localObject1);
      parama.be.setOnClickListener(this);
      paramBaseChatItemLayout = (FrameLayout.LayoutParams)parama.Jw.getLayoutParams();
      if (!localMessageForTroopSign.isSend()) {
        break label458;
      }
    }
    label399:
    label458:
    for (paramBaseChatItemLayout.leftMargin = BaseChatItemLayout.bNY;; paramBaseChatItemLayout.leftMargin = this.bWr)
    {
      parama.Jw.setLayoutParams(paramBaseChatItemLayout);
      return;
      bool = false;
      break;
      localTextView.setCompoundDrawables(null, null, null, null);
      break label296;
    }
  }
  
  public void a(xqk.a parama, MessageForTroopSign paramMessageForTroopSign)
  {
    boolean bool = paramMessageForTroopSign.isSend();
    if ((paramMessageForTroopSign.markType == 1) || (paramMessageForTroopSign.markType == 2)) {
      if (TextUtils.isEmpty(paramMessageForTroopSign.markIconUrl)) {}
    }
    for (;;)
    {
      try
      {
        Object localObject = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.bWt;
        localURLDrawableOptions.mRequestHeight = this.bWt;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramMessageForTroopSign.markIconUrl, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        parama.tI.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(localException));
        continue;
      }
      if (paramMessageForTroopSign.markType != 1) {
        break;
      }
      parama.wY.setVisibility(4);
      parama.wX.setVisibility(0);
      parama.Kf.setVisibility(4);
      d(parama.wX, paramMessageForTroopSign.positonType, bool);
      return;
      parama.tI.setImageDrawable(null);
      continue;
      parama.tI.setImageDrawable(null);
    }
    if (paramMessageForTroopSign.markType == 2)
    {
      parama.wY.setVisibility(4);
      parama.wX.setVisibility(0);
      parama.Kf.setVisibility(0);
      parama.Kf.setText(paramMessageForTroopSign.markDesc);
      d(parama.wX, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 3)
    {
      parama.wY.setVisibility(0);
      parama.wX.setVisibility(4);
      parama.Kg.setText(paramMessageForTroopSign.markWord);
      parama.Kh.setText(paramMessageForTroopSign.markDesc);
      d(parama.wY, paramMessageForTroopSign.positonType, bool);
      return;
    }
    parama.wY.setVisibility(4);
    parama.wX.setVisibility(4);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = (MessageForTroopSign)((wko.a)wja.a(paramView)).mMessage;
    super.a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopSign)paramChatMessage).getSummaryMsg();
  }
  
  public void d(View paramView, int paramInt, boolean paramBoolean)
  {
    int i = this.bWq / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (paramInt == 7)
    {
      localLayoutParams.topMargin = this.bWq;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.addRule(10, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = i;
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, 0);
      localLayoutParams.addRule(10, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = (i + this.bWr);
      } else {
        localLayoutParams.rightMargin = i;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (Rk()) {}
    while (((this.mContext instanceof MultiForwardActivity)) || (this.sessionInfo.beB))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject1 = (xqk.a)wja.a(paramView);
    Object localObject3 = (MessageForTroopSign)((xqk.a)localObject1).mMessage;
    if (paramView == ((xqk.a)localObject1).be)
    {
      localObject3 = ((MessageForTroopSign)localObject3).srcAction;
      anot.a(this.app, "dc00899", "Grp_checkin", "", "entry", "clk_obj_graybar", 0, 0, "", "", "", "");
      localObject1 = localObject3;
      if (!QLog.isColorLevel()) {
        break label291;
      }
      QLog.d("TroopSignItemBuilder", 2, "onSrcClick actionURL:" + (String)localObject3);
      localObject1 = localObject3;
    }
    for (;;)
    {
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label294;
        }
        try
        {
          localObject3 = new Intent(this.mContext, QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("url", (String)localObject1);
          ocp.f((Intent)localObject3, (String)localObject1);
          this.mContext.startActivity((Intent)localObject3);
        }
        catch (Exception localException) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("TroopSignItemBuilder", 2, "onClick exp:", localException);
      break;
      if (paramView == localException.E)
      {
        localObject3 = ((MessageForTroopSign)localObject3).msgAction;
        anot.a(this.app, "dc00899", "Grp_checkin", "", "entry", "clk_obj", 0, 0, "", "", "", "");
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopSignItemBuilder", 2, "onContentClick actionURL:" + (String)localObject3);
          localObject2 = localObject3;
        }
        label291:
        continue;
        label294:
        super.onClick(paramView);
        break;
      }
      Object localObject2 = "";
    }
  }
  
  public static abstract class a
    extends BaseBubbleBuilder.e
  {
    public TextView Jw;
    public TextView Kf;
    public TextView Kg;
    public TextView Kh;
    public RelativeLayout X;
    public FrameLayout be;
    public TextView summary;
    public ImageView tI;
    public View wX;
    public View wY;
  }
  
  public static class b
    extends xqk
  {
    public b(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
    {
      super(paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    }
    
    public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
    {
      parame = (xqk.b.a)parame;
      boolean bool1 = paramChatMessage.isSend();
      MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
      localMessageForTroopSign.parse();
      if (paramView == null)
      {
        paramChatMessage = LayoutInflater.from(this.mContext).inflate(2131563120, paramBaseChatItemLayout, false);
        paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.bWn + BaseChatItemLayout.bNY + aqcx.dip2px(this.mContext, 10.0F), this.bWp + BaseChatItemLayout.bNV + BaseChatItemLayout.bNW));
        parame.X = ((RelativeLayout)paramChatMessage);
        parame.m = ((BubbleImageView)parame.X.findViewById(2131365477));
        parame.c = ((EllipsizingTextView)parame.X.findViewById(2131379769));
        parame.summary = ((TextView)parame.X.findViewById(2131379009));
        parame.tI = ((ImageView)parame.X.findViewById(2131371129));
        parame.Kf = ((TextView)parame.X.findViewById(2131371132));
        parame.wX = parame.X.findViewById(2131371130);
        parame.Kg = ((TextView)parame.X.findViewById(2131371134));
        parame.Kh = ((TextView)parame.X.findViewById(2131371128));
        parame.wY = parame.X.findViewById(2131371133);
        parame.m.TD(false);
        parame.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
        parame.m.TE(false);
        parame.m.setFocusable(false);
        parame.m.setFocusableInTouchMode(false);
        parame.m.setClickable(false);
        paramChatMessage.setOnClickListener(this);
        paramChatMessage.setOnLongClickListener(paramwlz);
        paramChatMessage.setOnTouchListener(paramwlz);
        paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
        paramView.setShape(0);
        paramView.setGradientType(0);
        parame.m.setImageDrawable(paramView);
      }
      for (;;)
      {
        boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
        paramView = (RelativeLayout.LayoutParams)parame.m.getLayoutParams();
        if (!bool2)
        {
          paramView.height = this.bWo;
          if (!bool1) {
            break label844;
          }
          paramView.leftMargin = 0;
          paramView.rightMargin = aqcx.dip2px(this.mContext, 10.0F);
          label395:
          parame.m.setLayoutParams(paramView);
          paramView = new ColorDrawable(this.bWs);
          parame.m.setImageDrawable(paramView);
          if (TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {}
        }
        for (;;)
        {
          try
          {
            paramwlz = URLDrawable.URLDrawableOptions.obtain();
            paramwlz.mFailedDrawable = paramView;
            paramwlz.mLoadingDrawable = paramwlz.mFailedDrawable;
            paramwlz.mRequestWidth = this.bWn;
            if (bool2) {
              continue;
            }
            paramwlz.mRequestHeight = this.bWo;
            paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramwlz);
            if (paramView.getStatus() == 2) {
              paramView.restartDownload();
            }
            parame.m.setImageDrawable(paramView);
          }
          catch (Exception paramView)
          {
            label844:
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
            continue;
            parame.m.setRadius(14.0F);
            continue;
            paramView.leftMargin = this.bWr;
            paramView.rightMargin = 0;
            continue;
            parame.summary.setVisibility(8);
            continue;
            paramView.leftMargin = this.bWr;
            paramView.rightMargin = 0;
            continue;
            if ((TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) || (!localMessageForTroopSign.msgCoverUrl.endsWith("e8e22512720843268d733a5f30f22d7f.png"))) {
              continue;
            }
            paramView.addRule(12, 0);
            paramView.addRule(15, -1);
            continue;
            paramView.addRule(12, -1);
            paramView.addRule(15, 0);
            continue;
            parame.c.setText("");
            continue;
          }
          if (bool2) {
            continue;
          }
          parame.m.setRadiusTop(14.0F);
          if (parame.m.mIsSend != bool1)
          {
            parame.m.mIsSend = bool1;
            if (parame.m.mDrawMode == 1) {
              parame.m.onResize(parame.m.getWidth(), parame.m.getHeight());
            }
            parame.m.invalidate();
          }
          if (bool2) {
            continue;
          }
          parame.summary.setVisibility(0);
          paramView = (RelativeLayout.LayoutParams)parame.summary.getLayoutParams();
          if (!bool1) {
            continue;
          }
          paramView.leftMargin = 0;
          paramView.rightMargin = this.bWr;
          parame.summary.setLayoutParams(paramView);
          parame.summary.setText(localMessageForTroopSign.msgContent);
          parame.summary.setMaxLines(1);
          parame.summary.setEllipsize(TextUtils.TruncateAt.END);
          parame.summary.setGravity(19);
          paramView = (RelativeLayout.LayoutParams)parame.c.getLayoutParams();
          if (!bool1) {
            continue;
          }
          paramView.leftMargin = 0;
          paramView.rightMargin = this.bWr;
          if (bool2) {
            continue;
          }
          paramView.addRule(12, 0);
          paramView.addRule(15, 0);
          parame.c.setLayoutParams(paramView);
          if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
            continue;
          }
          parame.c.setText(localMessageForTroopSign.msgTitle);
          parame.c.setMaxLines(2);
          parame.c.setEllipsize(TextUtils.TruncateAt.END);
          a(parame, localMessageForTroopSign);
          if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
            paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
          }
          a(parame, paramBaseChatItemLayout);
          return paramChatMessage;
          paramView.height = this.bWp;
          break;
          paramView.leftMargin = aqcx.dip2px(this.mContext, 10.0F);
          paramView.rightMargin = 0;
          break label395;
          paramwlz.mRequestHeight = this.bWp;
        }
        paramChatMessage = paramView;
      }
    }
    
    public BaseBubbleBuilder.e a()
    {
      return new xqk.b.a();
    }
    
    public static class a
      extends xqk.a
    {
      public EllipsizingTextView c;
      public BubbleImageView m;
    }
  }
  
  public static class c
    extends xqk
  {
    protected static long Jn;
    protected static HashMap<ChatMessage, xqk.c.a> gS = new HashMap(5);
    public TroopChatPie b;
    
    public c(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
    {
      super(paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      this.b = paramTroopChatPie;
    }
    
    public static void cem()
    {
      if (System.currentTimeMillis() - Jn < 600000L) {
        return;
      }
      Jn = System.currentTimeMillis();
      jpa.init();
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      String str = jpa.dL("2833");
      if (QLog.isColorLevel()) {
        QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
      }
      jpa.a("2833", localQQAppInterface, new xqo(), true, 0, true);
    }
    
    public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
    {
      xqk.c.b localb = (xqk.c.b)parame;
      MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
      localMessageForTroopSign.parse();
      if (paramView == null)
      {
        parame = LayoutInflater.from(this.mContext).inflate(2131563288, paramBaseChatItemLayout, false);
        localb.X = ((RelativeLayout)parame);
        localb.a = ((TroopSignVideoView)localb.X.findViewById(2131365477));
        localb.summary = ((TextView)localb.X.findViewById(2131379009));
        localb.tI = ((ImageView)localb.X.findViewById(2131371129));
        localb.Kf = ((TextView)localb.X.findViewById(2131371132));
        localb.wX = localb.X.findViewById(2131371130);
        localb.Kg = ((TextView)localb.X.findViewById(2131371134));
        localb.Kh = ((TextView)localb.X.findViewById(2131371128));
        localb.wY = localb.X.findViewById(2131371133);
        localb.loadingView = localb.X.findViewById(2131370787);
        localb.wZ = localb.X.findViewById(2131370811);
        localb.a.setFocusable(false);
        localb.a.setFocusableInTouchMode(false);
        localb.a.setClickable(false);
        localb.a.setFps(30);
        parame.setOnClickListener(this);
        parame.setOnLongClickListener(paramwlz);
        parame.setOnTouchListener(paramwlz);
        if (this.b != null) {
          this.b.a(new xql(this, localb, paramBaseChatItemLayout));
        }
        localb.a.setOnPlayedListener(new xqm(this, localb));
      }
      for (;;)
      {
        boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
        if (!bool)
        {
          localb.summary.setText(localMessageForTroopSign.msgContent);
          localb.a.setShowCover(true);
          paramView = localMessageForTroopSign.dynamicSource;
          if (paramView.equals(localb.a.getTag())) {
            break label694;
          }
          localb.loadingView.setVisibility(0);
          localb.a.setTag(paramView);
          localb.a.stop();
          paramwlz = jpe.dO("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
          if (!new File(paramwlz).exists()) {
            break label649;
          }
          if ((this.b == null) || (!this.b.isScrolling)) {
            break label636;
          }
          localb.a.setFilePath(paramwlz);
          label479:
          localb.wZ.setVisibility(8);
          label489:
          a(localb.loadingView, "2833", paramView, bool);
          label503:
          a(localb, localMessageForTroopSign);
          if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
            parame.setContentDescription("" + localMessageForTroopSign.msgTitle);
          }
          a(localb, paramBaseChatItemLayout);
          paramChatMessage = (FrameLayout.LayoutParams)localb.Jw.getLayoutParams();
          if (!localMessageForTroopSign.isSend()) {
            break label751;
          }
        }
        label649:
        label694:
        label751:
        for (paramChatMessage.leftMargin = (BaseChatItemLayout.bNY + aqcx.dip2px(this.mContext, 10.0F));; paramChatMessage.leftMargin = aqcx.dip2px(this.mContext, 10.0F))
        {
          localb.Jw.setLayoutParams(paramChatMessage);
          return parame;
          localb.summary.setText("");
          localb.a.setShowCover(false);
          break;
          label636:
          localb.a.play(paramwlz);
          break label479;
          if (!gS.containsKey(paramChatMessage))
          {
            gS.put(paramChatMessage, new xqn(this, paramwlz, localb));
            cem();
          }
          localb.wZ.setVisibility(0);
          break label489;
          if ((this.b != null) && (!this.b.isScrolling))
          {
            sHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localb), 200L);
            break label503;
          }
          a(localb.loadingView, "2833", paramView, bool);
          break label503;
        }
        parame = paramView;
      }
    }
    
    public BaseBubbleBuilder.e a()
    {
      return new xqk.c.b();
    }
    
    protected void a(View paramView, String paramString1, String paramString2, boolean paramBoolean)
    {
      paramString2 = new StringBuilder().append(jpe.dO(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
      if (paramBoolean) {}
      for (paramString1 = "_no_summary";; paramString1 = "")
      {
        paramString1 = new File(paramString1 + ".png");
        if (!paramString1.exists()) {
          break;
        }
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(0);
        paramString2.mFailedDrawable = localColorDrawable;
        paramString2.mLoadingDrawable = localColorDrawable;
        try
        {
          paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString1.toURL(), paramString2));
          return;
        }
        catch (MalformedURLException paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramString1.mFailedDrawable = paramString2;
      paramString1.mLoadingDrawable = paramString2;
      paramString1 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/troop_sign_loading.png", paramString1);
      paramString1.setTag(aqbn.d(287, 287, aqcx.dip2px(this.mContext, 5.0F)));
      paramString1.setDecodeHandler(aqbn.a);
      paramView.setBackgroundDrawable(paramString1);
    }
    
    public void d(View paramView, int paramInt, boolean paramBoolean) {}
    
    public void destroy()
    {
      gS.clear();
      super.destroy();
    }
    
    public static abstract interface a
    {
      public abstract void N(int paramInt);
    }
    
    public static class b
      extends xqk.a
    {
      public TroopSignVideoView a;
      public View loadingView;
      public View wZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqk
 * JD-Core Version:    0.7.0.1
 */