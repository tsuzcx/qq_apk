import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class xlt
  extends BaseBubbleBuilder
{
  public static final String TAG = xlt.class.getSimpleName();
  private static int bUF;
  private static int bUG;
  private static int bUH;
  protected aacb a = new xlv(this);
  final String aVA = "pay";
  final String aVB = "pfa";
  protected String aVz = "";
  protected final int bUI = 2131375553;
  protected int bUJ;
  protected int bUK;
  protected int bUL;
  protected int bUM;
  protected int bUN;
  protected int bUO;
  protected int bUP;
  protected final int bUT = 2131375534;
  protected final int bUU = 2131375563;
  protected final int bUV = 2131375551;
  protected final int bUW = 2131375558;
  protected final int bUX = 2131375550;
  protected final int bUY = 2131375549;
  protected int bUZ;
  protected int bVa;
  protected int bVb;
  long dr;
  protected HashMap<String, SparseArray<WeakReference<xlt.a>>> gN = new HashMap();
  private View.OnClickListener onClickListener = new xlu(this);
  protected float scale = 1.0F;
  
  public xlt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.aVz = paramContext.getString(2131717318);
    this.scale = paramContext.getResources().getDisplayMetrics().density;
    this.bUJ = ((int)(42.0F * this.scale + 0.5F));
    this.bVa = ((int)(21.0F * this.scale + 0.5F));
    this.bVb = ((int)(15.0F * this.scale + 0.5F));
    this.bUK = ((int)(10.0F * this.scale + 0.5F));
    this.bUL = ((int)(9.0F * this.scale + 0.5F));
    this.bUM = ((int)(6.5F * this.scale + 0.5F));
    this.bUN = ((int)(4.0F * this.scale + 0.5F));
    this.bUO = ((int)(this.scale * 1.0F + 0.5F));
    this.bUZ = (this.bUK * 23);
    this.bUP = ((int)(7.0F * this.scale + 0.5F));
    bUF = this.bUO * 2;
    bUG = this.bUO * 2;
    bUH = this.bUP;
  }
  
  private RelativeLayout a(xlt.a parama, Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.bUZ, this.bVb * 5));
    localQQWalletTransferBubbleView.setId(2131375534);
    ImageView localImageView = new ImageView(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.bUJ, this.bUJ);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setId(2131375563);
    localQQWalletTransferBubbleView.addView(localImageView);
    Object localObject2 = new LinearLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131375563);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.bUM;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject1).setTextSize(24.0F);
    ((TextView)localObject1).setId(2131375551);
    ((LinearLayout)localObject2).addView((View)localObject1);
    TextView localTextView = new TextView(paramContext);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.bUO;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localTextView.setSingleLine();
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextSize(13.0F);
    localTextView.setId(2131375558);
    ((LinearLayout)localObject2).addView(localTextView);
    localQQWalletTransferBubbleView.addView((View)localObject2);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localObject2 = new QQWalletTransferBubbleView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(this.bUZ, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131375534);
    ((QQWalletTransferBubbleView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((QQWalletTransferBubbleView)localObject2).setBackgroundResource(2130848115);
    ((QQWalletTransferBubbleView)localObject2).setId(2131375550);
    paramContext = new TextView(paramContext);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = this.bVa;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.bVb;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.bVb;
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131375549);
    ((QQWalletTransferBubbleView)localObject2).addView(paramContext);
    localRelativeLayout.addView((View)localObject2);
    parama.title = ((TextView)localObject1);
    parama.xW = localTextView;
    parama.icon = localImageView;
    parama.lA = paramContext;
    parama.a = ((QQWalletTransferBubbleView)localObject2);
    parama.b = localQQWalletTransferBubbleView;
    return localRelativeLayout;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.bUK;
    localLayoutParams.bottomMargin = this.bUM;
    localLayoutParams.leftMargin = (this.bUJ + this.bUN);
    localLayoutParams.rightMargin = (this.bUJ + this.bUN);
    localLayoutParams.addRule(3, 2131364503);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130845675);
    paramContext.setPadding(this.bUL, this.bUN, this.bUL, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.bUN, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131375553);
    return paramContext;
  }
  
  private void a(xlt.a parama, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, boolean paramBoolean, wlz paramwlz)
  {
    if (paramMessageForQQWalletMsg.messageType == 16) {}
    for (int i = 1;; i = 0)
    {
      j(parama.title, paramQQWalletTransferMsgElem.title);
      parama.title.setTextColor(paramQQWalletTransferMsgElem.titleColor);
      parama.xW.setText(paramQQWalletTransferMsgElem.subTitle);
      parama.xW.setTextColor(paramQQWalletTransferMsgElem.subtitleColor);
      parama.lA.setText(paramQQWalletTransferMsgElem.content);
      if (i != 0)
      {
        Object localObject = this.mContext.getResources().getDrawable(aE(paramQQWalletTransferMsgElem.icon));
        if (!TextUtils.isEmpty(paramQQWalletTransferMsgElem.iconUrl)) {
          localObject = aoop.getDrawable(paramQQWalletTransferMsgElem.iconUrl, (int)aqho.convertDpToPixel(this.mContext, this.bUJ), (int)aqho.convertDpToPixel(this.mContext, this.bUJ), null, null);
        }
        parama.icon.setImageDrawable((Drawable)localObject);
      }
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().waitAppRuntime(null), false, null))
      {
        parama.b.setBubbleNightBackground(2130848114, Color.parseColor("#FF19BAFF"), paramBoolean);
        parama.a.setBubbleBackground(2130848115, Color.parseColor("#A4A5A8"), paramBoolean);
        parama.title.setTextColor(Color.parseColor("#B2B2B2"));
        parama.xW.setTextColor(Color.parseColor("#B2B2B2"));
        parama.lA.setTextColor(Color.parseColor("#5D616B"));
      }
      for (;;)
      {
        parama.layout.setContentDescription(paramQQWalletTransferMsgElem.title + paramQQWalletTransferMsgElem.subTitle + this.aVz);
        parama.layout.setOnClickListener(this.onClickListener);
        parama.layout.setOnLongClickListener(paramwlz);
        parama.layout.setOnTouchListener(paramwlz);
        if (i != 0) {
          a(parama, paramMessageForQQWalletMsg, paramQQWalletTransferMsgElem);
        }
        return;
        if (anlm.ayn())
        {
          parama.b.setBubbleBackground(2130848114, Color.parseColor("#FF19BAFF"), paramBoolean);
          parama.a.setBubbleBackground(2130848115, Color.parseColor("#FFECEDF2"), paramBoolean);
          parama.lA.setTextColor(Color.parseColor("#FF878B99"));
        }
        else
        {
          parama.b.setBubbleBackground(2130848114, paramQQWalletTransferMsgElem.background, paramBoolean);
          if (paramQQWalletTransferMsgElem.contentBgColor != 0) {
            parama.a.setBubbleBackground(2130848115, paramQQWalletTransferMsgElem.contentBgColor, paramBoolean);
          }
          if (paramQQWalletTransferMsgElem.contentColor != 0) {
            parama.lA.setTextColor(paramQQWalletTransferMsgElem.contentColor);
          }
        }
      }
    }
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    paramString2 = paramString1.split("\\?");
    paramString3 = paramString2[0];
    if (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    if (paramString2.length > 1) {
      paramString2 = paramMessageForQQWalletMsg.parseUrlParams(paramString2[1]);
    }
    while (paramString3.equals("pay"))
    {
      paramString1 = (String)paramString2.get("payData");
      paramString2 = (String)paramString2.get("reqCode");
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
      {
        return false;
        paramString2 = new HashMap();
      }
      else
      {
        paramMessageForQQWalletMsg = new Bundle();
        paramMessageForQQWalletMsg.putString("json", paramString1);
        paramMessageForQQWalletMsg.putString("callbackSn", "0");
        paramString1 = new Intent(paramContext, PayBridgeActivity.class);
        paramString1.putExtras(paramMessageForQQWalletMsg);
        paramString1.putExtra("pay_requestcode", Integer.valueOf(paramString2).intValue());
      }
    }
    label595:
    for (;;)
    {
      try
      {
        paramContext.startActivity(paramString1);
        return true;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "QQWalletMsgItemBuilder failed to startActivity : " + paramString3, paramContext);
        return false;
      }
      if (paramString3.equals("pfa"))
      {
        paramSessionInfo = (String)paramString2.get("data");
        paramMessageForQQWalletMsg = (String)paramString2.get("tokenid");
        if ((TextUtils.isEmpty(paramMessageForQQWalletMsg)) || (TextUtils.isEmpty(paramSessionInfo))) {
          return false;
        }
        paramString2 = new JSONObject();
        try
        {
          paramString2.put("userId", this.app.getCurrentAccountUin());
          paramString2.put("viewTag", "payByFriendConfirm");
          paramString2.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#paymsg");
          paramString2.put("comeForm", 2);
          paramSessionInfo = new JSONObject();
          paramSessionInfo.put("pfa_req", paramString1);
          paramSessionInfo.put("token_id", paramMessageForQQWalletMsg);
          paramString2.put("extra_data", paramSessionInfo);
          paramMessageForQQWalletMsg = new Bundle();
          paramMessageForQQWalletMsg.putString("json", paramString2.toString());
          paramMessageForQQWalletMsg.putString("callbackSn", "0");
          paramString1 = new Intent(paramContext, PayBridgeActivity.class);
          paramString1.putExtras(paramMessageForQQWalletMsg);
          paramString1.putExtra("pay_requestcode", 5);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          continue;
        }
      }
      else
      {
        try
        {
          paramString1 = xlt.class.getClassLoader();
          if (paramString1 == null) {
            return false;
          }
          paramString1 = paramString1.loadClass(paramString3);
        }
        catch (Exception paramString1)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          paramString1.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(TAG, 2, "QQWalletTransMsgItemBuilder failed to find Class : " + paramString3, paramString1);
          paramString1 = null;
          continue;
          paramString1 = new Intent(paramContext, paramString1);
          paramString2 = paramString2.entrySet().iterator();
          if (!paramString2.hasNext()) {
            break label595;
          }
        }
        if (paramString1 == null) {
          return false;
        }
        paramMessageForQQWalletMsg = (Map.Entry)paramString2.next();
        paramString1.putExtra((String)paramMessageForQQWalletMsg.getKey(), (String)paramMessageForQQWalletMsg.getValue());
      }
    }
  }
  
  private void j(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (paramString == null)) {
      return;
    }
    paramTextView.setTextSize(24.0F);
    TextPaint localTextPaint = paramTextView.getPaint();
    float f;
    if (localTextPaint != null)
    {
      f = localTextPaint.measureText(paramString);
      if (this.bUZ <= BaseChatItemLayout.bNS) {
        break label73;
      }
      if (f > BaseChatItemLayout.bNS - this.bUK * 9) {
        paramTextView.setTextSize(14.0F);
      }
    }
    for (;;)
    {
      paramTextView.setText(paramString);
      return;
      label73:
      if (f > this.bUK * 14) {
        paramTextView.setTextSize(14.0F);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xlt.a locala = (xlt.a)parame;
    parame = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      parame = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((parame == null) || (parame.mQQWalletTransferMsg == null)) {
      return null;
    }
    if ((locala.layout == null) || ((locala.layout != null) && (locala.uniseq != paramChatMessage.uniseq)))
    {
      locala.layout = a(locala, this.mContext);
      paramBaseChatItemLayout.addView(a(this.mContext));
    }
    locala.uniseq = paramChatMessage.uniseq;
    paramView = parame.mQQWalletTransferMsg.elem;
    if (paramView == null) {
      return locala.layout;
    }
    boolean bool;
    if (!paramChatMessage.isSend())
    {
      bool = true;
      a(locala, parame, paramView, bool, paramwlz);
      anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, "" + parame.mQQWalletTransferMsg.templateId, "", "", "");
      paramChatMessage = (TextView)paramBaseChatItemLayout.findViewById(2131375553);
      if (paramChatMessage != null)
      {
        if ((paramView == null) || (TextUtils.isEmpty(paramView.blackStripe))) {
          break label346;
        }
        paramChatMessage.setText(paramView.blackStripe);
        paramChatMessage.setVisibility(0);
      }
    }
    for (;;)
    {
      if (parame.messageType == 16)
      {
        this.app.registObserver(this.a);
        if (!TextUtils.isEmpty(parame.mQQWalletTransferMsg.listId))
        {
          paramView = (SparseArray)this.gN.get(parame.mQQWalletTransferMsg.listId);
          paramChatMessage = paramView;
          if (paramView == null)
          {
            paramChatMessage = new SparseArray();
            this.gN.put(parame.mQQWalletTransferMsg.listId, paramChatMessage);
          }
          paramChatMessage.put((int)parame.uniseq, new WeakReference(locala));
        }
      }
      return locala.layout;
      bool = false;
      break;
      label346:
      paramChatMessage.setVisibility(8);
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xlt.a();
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
    super.m(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bUG, bUH, bUF, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(bUF, bUH, bUG, paramView.getResources().getDimensionPixelSize(2131296405));
      return;
    }
    paramView.setPadding(bUF, bUH, bUG, 0);
  }
  
  protected void a(xlt.a parama, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletTransferMsgElem paramQQWalletTransferMsgElem)
  {
    int j;
    boolean bool;
    if (paramMessageForQQWalletMsg.messageType == 16)
    {
      String str = paramQQWalletTransferMsgElem.title;
      j = -12727643;
      if ((paramMessageForQQWalletMsg.isSend()) || (paramQQWalletTransferMsgElem.isInAAPayer(this.app.getLongAccountUin()))) {
        break label132;
      }
      paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717311);
      i = 2130848092;
      j(parama.title, paramQQWalletTransferMsgElem);
      if ((i != 0) && (parama.icon != null))
      {
        paramQQWalletTransferMsgElem = this.mContext.getResources().getDrawable(i);
        parama.icon.setImageDrawable(paramQQWalletTransferMsgElem);
      }
      if (parama.b != null)
      {
        parama = parama.b;
        if (paramMessageForQQWalletMsg.isSend()) {
          break label337;
        }
        bool = true;
        label120:
        parama.setBubbleBackground(2130848114, j, bool);
      }
    }
    return;
    label132:
    paramQQWalletTransferMsgElem = aaca.a(1, paramMessageForQQWalletMsg.mQQWalletTransferMsg.listId, paramMessageForQQWalletMsg);
    if (paramQQWalletTransferMsgElem != null) {}
    for (int i = paramQQWalletTransferMsgElem.S("state", -1);; i = -1)
    {
      if (i == -1)
      {
        paramQQWalletTransferMsgElem = paramMessageForQQWalletMsg.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramQQWalletTransferMsgElem)) {}
      }
      for (;;)
      {
        try
        {
          int k = Integer.valueOf(paramQQWalletTransferMsgElem).intValue();
          i = k;
          if (i != 1) {
            break label236;
          }
          paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717317);
          i = 2130848093;
          j = -7676215;
        }
        catch (Exception paramQQWalletTransferMsgElem)
        {
          if (QLog.isColorLevel()) {
            paramQQWalletTransferMsgElem.printStackTrace();
          }
        }
      }
      label236:
      if (i == 2)
      {
        paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717312);
        i = 2130848090;
        j = -7676215;
        break;
      }
      if (i == 3)
      {
        paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717314);
        i = 2130848090;
        j = -7676215;
        break;
      }
      if (paramMessageForQQWalletMsg.isSend())
      {
        paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717315);
        i = 2130848091;
        break;
      }
      paramQQWalletTransferMsgElem = BaseApplicationImpl.getContext().getString(2131717313);
      i = 2130848091;
      break;
      label337:
      bool = false;
      break label120;
    }
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  protected int aE(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2130848113;
    case 1: 
      return 2130848116;
    case 3: 
      return 2130848117;
    case 4: 
      return 2130848101;
    case 5: 
      return 2130848100;
    }
    return 2130848099;
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    Object localObject = null;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
      localObject = (MessageForQQWalletMsg)paramChatMessage;
    }
    if ((localObject == null) || (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null)) {
      return paramChatMessage.msg;
    }
    localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (aqiu.ms(paramChatMessage.issend))
      {
        localStringBuilder.append("发出");
        if ((((QQWalletTransferMsgElem)localObject).content == null) || (!((QQWalletTransferMsgElem)localObject).content.contains("QQ转账"))) {
          break label125;
        }
        localStringBuilder.append("QQ转账").append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("发来");
        break;
        label125:
        localStringBuilder.append("QQ转账").append(((QQWalletTransferMsgElem)localObject).title).append(((QQWalletTransferMsgElem)localObject).content).append("按钮");
      }
    }
    return paramChatMessage.msg;
  }
  
  public void destroy()
  {
    this.app.unRegistObserver(this.a);
    this.gN.clear();
    super.destroy();
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public QQWalletTransferBubbleView a;
    public QQWalletTransferBubbleView b;
    public ImageView icon;
    public TextView lA;
    public RelativeLayout layout;
    public TextView title;
    public long uniseq;
    public TextView xW;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlt
 * JD-Core Version:    0.7.0.1
 */