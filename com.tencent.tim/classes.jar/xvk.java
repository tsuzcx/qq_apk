import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.widget.EllipseTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList.a;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class xvk
{
  public static final String TAG = xvk.class.getSimpleName();
  static long dr;
  public static Map<String, MessageForQQWalletMsg> hU = new HashMap();
  TroopUnAccalimedRedPacketList.a a;
  final String aVA = "pay";
  final String aWL = "red";
  private String aWM;
  QQAppInterface app;
  protected int bUK;
  protected int bVb;
  protected int bXA;
  protected int bXB;
  protected int bXC;
  protected int bXH;
  protected int bXI;
  protected int bXJ;
  protected int bXK;
  protected int bXL;
  protected int bXy;
  protected int bXz;
  private View.OnClickListener dY = new xvm(this);
  private View.OnClickListener dZ = new xvn(this);
  BaseChatPie e;
  private View.OnClickListener ea = new xvo(this);
  private View.OnClickListener eb = new xvp(this);
  private View.OnClickListener ec = new xvq(this);
  private View.OnClickListener ed = new xvr(this);
  private View.OnClickListener onClickListener = new xvs(this);
  SessionInfo sessionInfo;
  
  public xvk(Context paramContext)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.bVb = ((int)(15.0F * f + 0.5F));
    this.bUK = ((int)(10.0F * f + 0.5F));
    this.bXL = ((int)(8.0F * f + 0.5F));
    this.bXK = ((int)(23.0F * f + 0.5F));
    this.bXC = ((int)(40.0F * f + 0.5F));
    this.bXA = ((int)(90.0F * f + 0.5F));
    this.bXB = ((int)(17.0F * f + 0.5F));
    this.bXH = ((int)(138.0F * f + 0.5F));
    this.bXI = ((int)(115.0F * f + 0.5F));
    this.bXJ = ((int)(11.0F * f + 0.5F));
    this.bXy = ((int)(160.0F * f + 0.5F));
    this.bXz = ((int)(f * 240.0F + 0.5F));
  }
  
  private static int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.cZ == 0) {
      return 1;
    }
    if (paramSessionInfo.cZ == 3000) {
      return 2;
    }
    if (paramSessionInfo.cZ == 1)
    {
      paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(60);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.kj(paramSessionInfo.aTl))) {
        return 6;
      }
      return 3;
    }
    if (paramSessionInfo.cZ == 1000) {
      return 4;
    }
    if (paramSessionInfo.cZ == 1004) {
      return 5;
    }
    if ((paramSessionInfo.cZ == 1001) || (paramSessionInfo.cZ == 10002) || (paramSessionInfo.cZ == 10004)) {
      return 7;
    }
    return 0;
  }
  
  private boolean a(Context paramContext, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, String paramString1, String paramString2, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    if (paramQQWalletTransferMsgElem != null) {}
    for (Object localObject1 = paramQQWalletTransferMsgElem.nativeAndroid; (paramContext == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (paramMessageForQQWalletMsg == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null); localObject1 = null) {
      return false;
    }
    localObject1 = ((String)localObject1).split("\\?");
    CharSequence localCharSequence = localObject1[0];
    if (TextUtils.isEmpty(localCharSequence)) {
      return false;
    }
    if (localObject1.length > 1) {
      localObject1 = paramMessageForQQWalletMsg.parseUrlParams(localObject1[1]);
    }
    while (localCharSequence.equals("pay"))
    {
      paramQQWalletTransferMsgElem = (String)((HashMap)localObject1).get("payData");
      paramString1 = (String)((HashMap)localObject1).get("reqCode");
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramQQWalletTransferMsgElem)))
      {
        return false;
        localObject1 = new HashMap();
      }
      else
      {
        paramString2 = new Bundle();
        paramString2.putString("json", paramQQWalletTransferMsgElem);
        paramString2.putString("callbackSn", "0");
        paramQQWalletTransferMsgElem = new Intent(paramContext, PayBridgeActivity.class);
        paramQQWalletTransferMsgElem.putExtras(paramString2);
        paramQQWalletTransferMsgElem.putExtra("pay_requestcode", Integer.valueOf(paramString1).intValue());
      }
    }
    label888:
    for (;;)
    {
      try
      {
        if (!(paramContext instanceof Activity)) {
          paramQQWalletTransferMsgElem.addFlags(268435456);
        }
        paramContext.startActivity(paramQQWalletTransferMsgElem);
        return true;
      }
      catch (Exception paramContext)
      {
        String str;
        Object localObject2;
        int i;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramContext.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "QQWalletMsgItemBuilder failed to startActivity : " + localCharSequence, paramContext);
        return false;
      }
      if (localCharSequence.equals("red"))
      {
        str = (String)((HashMap)localObject1).get("id");
        if (TextUtils.isEmpty(str)) {
          return false;
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (paramQQWalletTransferMsgElem != null)
        {
          localObject1 = localObject2;
          if (paramQQWalletTransferMsgElem.themeId > 1)
          {
            localObject1 = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(paramQQWalletTransferMsgElem.themeId);
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((aadw)localObject1).bgUrl;
          }
        }
        localObject2 = aagc.a(this.app, paramSessionInfo, paramMessageForQQWalletMsg.istroop);
        i = ((Bundle)localObject2).getInt("groupType");
        localObject2 = ((Bundle)localObject2).getString("name");
        paramQQWalletTransferMsgElem = aagc.a(this.app, paramMessageForQQWalletMsg, paramQQWalletTransferMsgElem, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, paramSessionInfo, i, (String)localObject2, str, paramString1, paramString2, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", (String)localObject1);
        paramString2 = (acgn)this.app.getManager(131);
        if ((paramString2 == null) || (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid <= 0)) {}
      }
      try
      {
        paramString1 = paramQQWalletTransferMsgElem.getJSONObject("extra_data");
        paramString2 = paramString2.aK(String.valueOf(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeid), paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.envelopeName);
        if (QLog.isColorLevel()) {
          QLog.d("vipBgImage", 2, paramString2);
        }
        paramString1.put("vipBgImage", paramString2);
      }
      catch (Exception paramString1)
      {
        continue;
      }
      paramString1 = new Bundle();
      paramString1.putString("json", paramQQWalletTransferMsgElem.toString());
      paramString1.putString("callbackSn", "0");
      if (localObject1 != null) {
        paramString1.putString("cftImageUrl", (String)localObject1);
      }
      paramQQWalletTransferMsgElem = str;
      if (str != null)
      {
        paramQQWalletTransferMsgElem = str;
        if (str.length() > 4) {
          paramQQWalletTransferMsgElem = "****" + str.substring(4);
        }
      }
      paramString1.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "graphb", "open", "groupType=" + i + "&msgType=" + paramMessageForQQWalletMsg.messageType + "&redId=" + paramQQWalletTransferMsgElem, 0, null));
      paramQQWalletTransferMsgElem = new Intent(paramContext, PayBridgeActivity.class);
      paramQQWalletTransferMsgElem.putExtras(paramString1);
      paramQQWalletTransferMsgElem.putExtra("pay_requestcode", 5);
      continue;
      localObject1 = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + paramQQWalletTransferMsgElem.themeId + "_bg";
      continue;
      try
      {
        paramQQWalletTransferMsgElem = xlr.class.getClassLoader();
        if (paramQQWalletTransferMsgElem == null) {
          return false;
        }
        paramQQWalletTransferMsgElem = paramQQWalletTransferMsgElem.loadClass(localCharSequence);
      }
      catch (Exception paramQQWalletTransferMsgElem)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramQQWalletTransferMsgElem.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "QQWalletMsgItemBuilder failed to find Class : " + localCharSequence, paramQQWalletTransferMsgElem);
        paramQQWalletTransferMsgElem = null;
        continue;
        paramQQWalletTransferMsgElem = new Intent(paramContext, paramQQWalletTransferMsgElem);
        paramString1 = ((HashMap)localObject1).entrySet().iterator();
        if (!paramString1.hasNext()) {
          break label888;
        }
      }
      if (paramQQWalletTransferMsgElem == null) {
        return false;
      }
      paramString2 = (Map.Entry)paramString1.next();
      paramQQWalletTransferMsgElem.putExtra((String)paramString2.getKey(), (String)paramString2.getValue());
    }
  }
  
  private Map<String, String> c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 12) && (this.aWM != null))
    {
      localHashMap.put("pskey_type", "27");
      localHashMap.put("pskey", this.aWM);
      localHashMap.put("recv_uin", this.app.getCurrentUin() + "");
      localHashMap.put("recv_nickname", aqgv.l(this.app, this.sessionInfo.aTl, this.app.getCurrentUin()));
      localHashMap.put("recv_group_type", a(this.app, this.sessionInfo) + "");
      localHashMap.put("recv_group_id", this.sessionInfo.aTl);
    }
    return localHashMap;
  }
  
  public static String cI(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = acfp.m(2131712567);
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return acfp.m(2131721900);
      }
    } while (paramInt != 2);
    return acfp.m(2131721902);
  }
  
  public RelativeLayout a(xvt paramxvt, Context paramContext)
  {
    if ((paramxvt == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout = b(paramxvt, paramContext);
    TextView localTextView = b(paramContext);
    localRelativeLayout.addView(localTextView);
    paramxvt.Kv = localTextView;
    paramContext = c(paramContext);
    localRelativeLayout.addView(paramContext);
    paramxvt.hW = paramContext;
    return localRelativeLayout;
  }
  
  public void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    if (paramRelativeLayout == null) {
      return;
    }
    paramRelativeLayout.setOnClickListener(this.onClickListener);
    paramRelativeLayout.setContentDescription(paramString);
  }
  
  public void a(TroopUnAccalimedRedPacketList.a parama)
  {
    this.a = parama;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, RelativeLayout paramRelativeLayout, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRelativeLayout == null) {}
    do
    {
      return false;
      this.app = paramQQAppInterface;
      this.sessionInfo = paramSessionInfo;
      this.e = paramBaseChatPie;
      paramBaseChatPie = (MessageForQQWalletMsg)paramRelativeLayout.getTag();
    } while (paramBaseChatPie == null);
    avor.a(paramQQAppInterface, "tenpay.com", new xvl(this));
    hU.put(paramBaseChatPie.mQQWalletRedPacketMsg.redPacketId, paramBaseChatPie);
    QLog.i(TAG, 2, "CFT-debug redType = " + paramInt1);
    int i = paramInt1;
    if (paramInt1 == 4)
    {
      i = paramInt1;
      if (paramInt2 > 0) {
        i = 0;
      }
    }
    paramRelativeLayout.setTag(2131379209, Integer.valueOf(i));
    if (i == 1)
    {
      paramRelativeLayout.setContentDescription(acfp.m(2131712579) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712575));
      paramRelativeLayout.setOnClickListener(this.ec);
    }
    for (;;)
    {
      return true;
      if (i == 2)
      {
        paramRelativeLayout.setContentDescription(acfp.m(2131712570) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712586));
        paramRelativeLayout.setOnClickListener(this.eb);
      }
      else if (i == 8)
      {
        paramRelativeLayout.setContentDescription("K歌红包:" + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712582));
        paramRelativeLayout.setOnClickListener(this.ea);
      }
      else if (i == 9)
      {
        paramRelativeLayout.setContentDescription(acfp.m(2131712564) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712580));
        paramRelativeLayout.setOnClickListener(this.dY);
      }
      else if (i == 10)
      {
        paramRelativeLayout.setContentDescription(acfp.m(2131712565) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712569));
        paramRelativeLayout.setOnClickListener(this.ed);
      }
      else if (i == 11)
      {
        paramRelativeLayout.setContentDescription(acfp.m(2131712583) + paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + acfp.m(2131712572));
        paramRelativeLayout.setOnClickListener(this.dZ);
      }
      else
      {
        paramRelativeLayout.setContentDescription(paramBaseChatPie.mQQWalletRedPacketMsg.elem.title + paramString);
        paramRelativeLayout.setOnClickListener(this.onClickListener);
      }
    }
  }
  
  public RelativeLayout b(xvt paramxvt, Context paramContext)
  {
    if ((paramxvt == null) || (paramContext == null)) {
      return null;
    }
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    localRelativeLayout1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localRelativeLayout1.setId(2131375427);
    paramxvt.root = localRelativeLayout1;
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(this.bXy, this.bXz);
    localRelativeLayout2.setId(2131375445);
    localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RoundImageView(paramContext);
    localRelativeLayout2.addView((View)localObject1);
    ((RoundImageView)localObject1).getLayoutParams().width = this.bXy;
    ((RoundImageView)localObject1).getLayoutParams().height = this.bXz;
    paramxvt.hU = localRelativeLayout2;
    localObject1 = new RelativeLayout(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.bXy, this.bXz);
    ((RelativeLayout)localObject1).setBackgroundResource(2130848160);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((RelativeLayout)localObject1).setVisibility(8);
    paramxvt.hV = ((RelativeLayout)localObject1);
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setId(2131375538);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.topMargin = this.bXC;
    localLayoutParams1.addRule(10);
    localLayoutParams1.addRule(14);
    ((LinearLayout)localObject2).setLayoutParams(localLayoutParams1);
    ((LinearLayout)localObject2).setVisibility(8);
    paramxvt.hk = ((LinearLayout)localObject2);
    RelativeLayout localRelativeLayout3 = new RelativeLayout(paramContext);
    localRelativeLayout3.setId(2131375451);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(10);
    localLayoutParams2.addRule(14);
    localLayoutParams2.topMargin = this.bXA;
    localLayoutParams2.leftMargin = this.bXB;
    localLayoutParams2.rightMargin = this.bXB;
    localRelativeLayout3.setLayoutParams(localLayoutParams2);
    Object localObject3 = new EllipseTextView(paramContext);
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13);
    ((TextView)localObject3).setTextSize(18.0F);
    ((TextView)localObject3).setTextColor(Color.parseColor("#FBD49D"));
    ((TextView)localObject3).setLineSpacing(0.0F, 1.1F);
    ((TextView)localObject3).setId(2131375438);
    ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((TextView)localObject3).setGravity(17);
    localRelativeLayout3.addView((View)localObject3);
    paramxvt.titleContainer = localRelativeLayout3;
    paramxvt.title = ((TextView)localObject3);
    localObject4 = new ImageView(paramContext);
    ((ImageView)localObject4).setId(2131375447);
    ((ImageView)localObject4).setVisibility(8);
    ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(this.bXH, this.bXI);
    localLayoutParams3.setMargins(this.bXJ, 0, this.bXJ, 0);
    localLayoutParams3.addRule(12);
    paramxvt.tS = ((ImageView)localObject4);
    RelativeLayout localRelativeLayout4 = new RelativeLayout(paramContext);
    localRelativeLayout4.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
    paramxvt.hX = localRelativeLayout4;
    localObject3 = new AnimationView(paramContext);
    ((AnimationView)localObject3).setPlayer(new xvu((AnimationView)localObject3));
    ((AnimationView)localObject3).setId(2131375437);
    ((AnimationView)localObject3).setVisibility(8);
    ((AnimationView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
    RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(this.bXy, this.bXz);
    localLayoutParams5.addRule(14);
    localLayoutParams5.addRule(12);
    paramxvt.b = ((AnimationView)localObject3);
    localRelativeLayout2.addView((View)localObject4, localLayoutParams3);
    localRelativeLayout2.addView((View)localObject3, localLayoutParams5);
    localRelativeLayout2.addView(localRelativeLayout4, localLayoutParams4);
    localRelativeLayout2.addView(localRelativeLayout3, localLayoutParams2);
    localRelativeLayout2.addView((View)localObject2, localLayoutParams1);
    localRelativeLayout1.addView(localRelativeLayout2);
    localRelativeLayout1.addView((View)localObject1);
    paramContext = new AnimationView(paramContext);
    paramContext.setPlayer(new xvu((AnimationView)localObject3));
    paramContext.setId(2131375456);
    paramContext.setVisibility(8);
    paramxvt.c = paramContext;
    return localRelativeLayout1;
  }
  
  public TextView b(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, this.bXK);
    localLayoutParams.topMargin = this.bXL;
    localLayoutParams.bottomMargin = this.bVb;
    localLayoutParams.addRule(3, 2131375445);
    localLayoutParams.addRule(5, 2131375445);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setMaxWidth(this.bXy);
    paramContext.setTextColor(-8947849);
    paramContext.setBackgroundResource(2130848094);
    paramContext.setPadding(this.bUK, 0, this.bUK, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setSingleLine();
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131375446);
    return paramContext;
  }
  
  public RelativeLayout c(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131375445);
    localLayoutParams.addRule(1, 2131375445);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvk
 * JD-Core Version:    0.7.0.1
 */