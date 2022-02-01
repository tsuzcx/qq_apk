package com.tencent.mobileqq.activity;

import acbn;
import accn;
import acdv;
import acfd;
import acff;
import achq;
import acrp;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import anzd;
import aoij;
import apuh;
import aqdj;
import aqft;
import aqgv;
import aqha;
import aqiw;
import aqju;
import aqmr;
import aqnm;
import ausj;
import auss;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import uez;
import ufa;
import ufb;
import ufc;
import ufd;
import ufe;
import uff;
import ufg;
import ufh;
import ufi;
import ufj;
import ufk;

public class AddRequestActivity
  extends DialogBaseActivity
  implements acbn, View.OnClickListener
{
  TextView BR;
  private TextView BS;
  private TextView BT;
  private TextView BU;
  TextView BV;
  private TextView BW;
  private long Fg;
  private long Fh;
  private long Fi;
  public long Fj = 0L;
  private acfd jdField_a_of_type_Acfd = new ufj(this);
  private achq jdField_a_of_type_Achq = new ufa(this);
  public CardHandler a;
  public structmsg.StructMsg a;
  public String aKN;
  private String aKO = "";
  private String aKP = "";
  String aKQ = null;
  private boolean aRn;
  URLImageView af;
  acdv b = new ufc(this);
  private int bDN;
  private int bDO = 3999;
  private final int bDP = 0;
  public int bDQ;
  private Serializable c;
  Button cR;
  Button cS;
  Button cT;
  View.OnClickListener cZ = new ufg(this);
  accn cardObserver = new ufb(this);
  String dF = null;
  View.OnClickListener da = new ufh(this);
  View.OnClickListener db = new ufi(this);
  public Dialog k;
  public long lToMobile;
  protected float oS;
  protected float of;
  View rq;
  public String strNickName;
  byte[] vSig;
  TextView vU;
  public aqju y;
  
  public AddRequestActivity()
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  }
  
  /* Error */
  private void bFK()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc 161
    //   4: invokevirtual 165	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   7: putfield 167	com/tencent/mobileqq/activity/AddRequestActivity:rq	Landroid/view/View;
    //   10: aload_0
    //   11: aload_0
    //   12: ldc 168
    //   14: invokevirtual 165	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   17: checkcast 170	com/tencent/image/URLImageView
    //   20: putfield 172	com/tencent/mobileqq/activity/AddRequestActivity:af	Lcom/tencent/image/URLImageView;
    //   23: aload_0
    //   24: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   27: ifnull +321 -> 348
    //   30: aload_0
    //   31: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   34: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   37: getfield 184	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   40: invokevirtual 189	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   43: ifeq +305 -> 348
    //   46: aload_0
    //   47: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   50: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   53: getfield 193	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   59: ifeq +289 -> 348
    //   62: aload_0
    //   63: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   66: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   69: ifnull +284 -> 353
    //   72: aload_0
    //   73: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   76: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   79: getfield 200	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   82: invokevirtual 206	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   85: ifnull +268 -> 353
    //   88: aload_0
    //   89: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   92: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   95: getfield 200	tencent/mobileim/structmsg/structmsg$SystemMsg:actions	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   98: invokevirtual 206	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull +250 -> 353
    //   106: aload_3
    //   107: invokeinterface 212 1 0
    //   112: ifle +241 -> 353
    //   115: iconst_1
    //   116: istore_1
    //   117: aload_0
    //   118: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   121: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   124: getfield 193	tencent/mobileim/structmsg/structmsg$SystemMsg:card_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: iconst_1
    //   131: if_icmpne +217 -> 348
    //   134: iload_1
    //   135: ifeq +213 -> 348
    //   138: new 216	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   141: dup
    //   142: invokespecial 217	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   145: astore 4
    //   147: aload 4
    //   149: aload_0
    //   150: getfield 86	com/tencent/mobileqq/activity/AddRequestActivity:jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg	Ltencent/mobileim/structmsg/structmsg$StructMsg;
    //   153: getfield 178	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   156: getfield 184	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_business_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   159: invokevirtual 220	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   162: invokevirtual 226	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   165: invokevirtual 230	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   168: pop
    //   169: new 232	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   172: dup
    //   173: invokespecial 233	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   176: astore_3
    //   177: aload_3
    //   178: aload 4
    //   180: invokestatic 238	adyr:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   183: aload_0
    //   184: ldc 239
    //   186: invokevirtual 165	com/tencent/mobileqq/activity/AddRequestActivity:findViewById	(I)Landroid/view/View;
    //   189: checkcast 241	android/widget/LinearLayout
    //   192: astore 4
    //   194: aload_3
    //   195: ifnull +140 -> 335
    //   198: aload_3
    //   199: getfield 244	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   202: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifne +130 -> 335
    //   208: aload 4
    //   210: ldc 251
    //   212: invokevirtual 255	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   215: aload_0
    //   216: getfield 167	com/tencent/mobileqq/activity/AddRequestActivity:rq	Landroid/view/View;
    //   219: iconst_0
    //   220: invokevirtual 260	android/view/View:setVisibility	(I)V
    //   223: aload_0
    //   224: getfield 172	com/tencent/mobileqq/activity/AddRequestActivity:af	Lcom/tencent/image/URLImageView;
    //   227: iconst_0
    //   228: invokevirtual 261	com/tencent/image/URLImageView:setVisibility	(I)V
    //   231: aload_0
    //   232: invokevirtual 265	com/tencent/mobileqq/activity/AddRequestActivity:getResources	()Landroid/content/res/Resources;
    //   235: invokevirtual 271	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   238: getfield 276	android/util/DisplayMetrics:widthPixels	I
    //   241: aload_0
    //   242: ldc_w 277
    //   245: invokestatic 283	aqcx:dip2px	(Landroid/content/Context;F)I
    //   248: iconst_2
    //   249: imul
    //   250: isub
    //   251: istore_1
    //   252: iload_1
    //   253: sipush 600
    //   256: imul
    //   257: sipush 1000
    //   260: idiv
    //   261: istore_2
    //   262: aload_0
    //   263: getfield 172	com/tencent/mobileqq/activity/AddRequestActivity:af	Lcom/tencent/image/URLImageView;
    //   266: invokevirtual 287	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   269: checkcast 289	android/widget/LinearLayout$LayoutParams
    //   272: astore 4
    //   274: aload 4
    //   276: iload_1
    //   277: putfield 292	android/widget/LinearLayout$LayoutParams:width	I
    //   280: aload 4
    //   282: iload_2
    //   283: putfield 295	android/widget/LinearLayout$LayoutParams:height	I
    //   286: aload_0
    //   287: getfield 172	com/tencent/mobileqq/activity/AddRequestActivity:af	Lcom/tencent/image/URLImageView;
    //   290: aload 4
    //   292: invokevirtual 299	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   295: aload_3
    //   296: getfield 244	com/tencent/mobileqq/businessCard/data/BusinessCard:picUrl	Ljava/lang/String;
    //   299: aload_0
    //   300: getfield 172	com/tencent/mobileqq/activity/AddRequestActivity:af	Lcom/tencent/image/URLImageView;
    //   303: sipush 1000
    //   306: sipush 600
    //   309: invokestatic 304	adzx:a	(Ljava/lang/String;Lcom/tencent/image/URLImageView;II)V
    //   312: return
    //   313: astore_3
    //   314: aconst_null
    //   315: astore_3
    //   316: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +13 -> 332
    //   322: ldc_w 311
    //   325: iconst_2
    //   326: ldc_w 313
    //   329: invokestatic 317	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto -149 -> 183
    //   335: aload 4
    //   337: ldc 251
    //   339: invokevirtual 255	android/widget/LinearLayout:setBackgroundResource	(I)V
    //   342: return
    //   343: astore 4
    //   345: goto -29 -> 316
    //   348: aconst_null
    //   349: astore_3
    //   350: goto -167 -> 183
    //   353: iconst_0
    //   354: istore_1
    //   355: goto -238 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	AddRequestActivity
    //   116	239	1	i	int
    //   261	22	2	j	int
    //   101	195	3	localObject1	Object
    //   313	1	3	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   315	35	3	localObject2	Object
    //   145	191	4	localObject3	Object
    //   343	1	4	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   147	177	313	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   177	183	343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void bFL()
  {
    String str;
    if (!TextUtils.isEmpty(this.strNickName))
    {
      this.vU.setText(this.strNickName);
      if (TextUtils.isEmpty(this.aKQ)) {
        break label80;
      }
      str = this.aKQ;
      label37:
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, "0"))) {
        break label89;
      }
      this.BV.setVisibility(8);
    }
    label80:
    label89:
    int i;
    int j;
    int m;
    do
    {
      return;
      this.vU.setText(this.aKN);
      break;
      str = this.aKN;
      break label37;
      this.BV.setVisibility(0);
      str = "(" + aoij.M(18, str) + ")";
      this.BV.setText(str);
      i = (int)Layout.getDesiredWidth(this.BV.getText(), this.BV.getPaint());
      j = (int)Layout.getDesiredWidth(this.vU.getText(), this.vU.getPaint());
      m = aqnm.getScreenWidth() - aqnm.dip2px(130.0F);
    } while (j + i <= m);
    this.vU.setMaxWidth(m - i);
    this.BV.setMinWidth(i);
  }
  
  private void vJ(boolean paramBoolean)
  {
    bFM();
    this.BS = ((TextView)findViewById(2131364063));
    this.BT = ((TextView)findViewById(2131364061));
    this.BU = ((TextView)findViewById(2131364062));
    TextView localTextView = (TextView)findViewById(2131372033);
    Object localObject2 = (LinearLayout)findViewById(2131381502);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131372034);
    ImageView localImageView = (ImageView)findViewById(2131366624);
    this.vU = ((TextView)findViewById(2131372384));
    this.BV = ((TextView)findViewById(2131372367));
    Object localObject3 = (TextView)findViewById(2131381511);
    this.cR = ((Button)findViewById(2131362354));
    this.cS = ((Button)findViewById(2131377045));
    this.cT = ((Button)findViewById(2131377157));
    this.BR = ((TextView)findViewById(2131378251));
    this.BR.setOnClickListener(this.da);
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))) {
      this.aKO = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    }
    TextPaint localTextPaint = ((TextView)localObject3).getPaint();
    Object localObject1 = localTextPaint;
    if (localTextPaint == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.mDensity;
    }
    float f = ((TextPaint)localObject1).measureText(this.aKO);
    if (this.oS - f > 30.0F)
    {
      ((TextView)localObject3).setText(this.aKO);
      localObject1 = localObject3;
      ((LinearLayout)localObject2).setVisibility(0);
      this.cT.setOnClickListener(this.db);
      if ((this.aKO == null) || (this.aKO.equals(""))) {
        break label629;
      }
      if ((this.aKP == null) || (this.aKP.equals(""))) {
        break label605;
      }
      ((LinearLayout)localObject2).setBackgroundResource(2130839700);
      if (((LinearLayout)localObject2).getVisibility() != 0) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      s(localTextView);
      if (localLinearLayout.getVisibility() != 0) {
        localLinearLayout.setVisibility(0);
      }
      localLinearLayout.setBackgroundResource(2130839700);
      label427:
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null)) {
        break label1838;
      }
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label788;
      }
      i = 0;
      label492:
      if (i >= ((List)localObject2).size()) {
        break label806;
      }
      ((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get();
      if (i != 0) {
        break label748;
      }
      this.cR.setVisibility(0);
      this.cR.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
    }
    for (;;)
    {
      i += 1;
      break label492;
      localObject2 = (LinearLayout)findViewById(2131381501);
      localObject1 = (TextView)findViewById(2131381500);
      this.cT = ((Button)findViewById(2131377136));
      break;
      label605:
      ((LinearLayout)localObject2).setBackgroundResource(2130839642);
      ((LinearLayout)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
      break label427;
      label629:
      if ((this.aKO != null) && (!this.aKO.equals(""))) {
        break label427;
      }
      if ((this.aKP != null) && (!this.aKP.equals("")))
      {
        ((LinearLayout)localObject2).setVisibility(8);
        s(localTextView);
        if (localLinearLayout.getVisibility() != 0) {
          localLinearLayout.setVisibility(0);
        }
        localLinearLayout.setBackgroundResource(2130839642);
        break label427;
      }
      localObject3 = (ViewGroup)findViewById(2131364064);
      ((View)localObject3).setBackgroundResource(2130839682);
      ((View)localObject3).setVisibility(0);
      ((LinearLayout)localObject2).setVisibility(8);
      localLinearLayout.setVisibility(8);
      break label427;
      label748:
      if (i == 1)
      {
        this.cS.setVisibility(0);
        this.cS.setText(((structmsg.SystemMsgAction)((List)localObject2).get(i)).detail_name.get());
      }
    }
    label788:
    this.cR.setVisibility(8);
    this.cS.setVisibility(8);
    label806:
    localObject2 = (TextView)findViewById(2131379722);
    if ((this.bDO == 3014) || (this.bDO == 2014))
    {
      ((TextView)localObject2).setVisibility(0);
      label844:
      localObject2 = (TextView)findViewById(2131372011);
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has())) {
        break label1869;
      }
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();
      label903:
      if ((i & 0x20) == 32)
      {
        ((TextView)localObject2).setText(2131689647);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setOnClickListener(this);
        anot.a(this.app, "CliOper", "", "", "0X800AA3D", "0X800AA3D", 0, 0, "", "", "", "");
      }
      QLog.d("Q.systemmsg.AddRequestActivity", 1, new Object[] { "uint32_source_flag=", Integer.valueOf(i) });
      ((TextView)findViewById(2131361951)).setOnClickListener(this.cZ);
      localObject2 = (TextView)findViewById(2131361950);
      if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.get() == null) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() <= 1) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.has()) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get().length() <= 0) || (((acff)this.app.getManager(51)).isFriend(this.aKN)))) {
        break label1974;
      }
      this.BR.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      this.BR.setTag(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_blacklist.get());
      anot.a(this.app, "CliOper", "", "", "0X800AA43", "0X800AA43", 0, 0, "", "", "", "");
    }
    label1838:
    label1974:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.BR.setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
      }
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())) {}
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
      {
      case 4: 
      case 5: 
      default: 
        this.cT.setVisibility(8);
        label1373:
        this.BW = ((TextView)findViewById(2131365102));
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.has() == true))
        {
          this.BW.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.friend_info.msg_joint_friend.get());
          this.BW.setVisibility(0);
          label1471:
          localObject2 = ((acff)this.app.getManager(51)).e(this.aKN);
          if ((localObject2 == null) || (((Friends)localObject2).alias == null) || (((Friends)localObject2).alias.length() == 0))
          {
            localObject2 = this.app;
            localObject3 = this.app;
            ((FriendListHandler)((QQAppInterface)localObject2).getBusinessHandler(1)).DG(this.aKN);
          }
          bFL();
          i = 0;
          if ((this.bDO == 3007) || (this.bDO == 3019) || (this.bDO == 2007) || (this.bDO == 4007) || (this.bDO == 2019))
          {
            localObject2 = (acff)this.app.getManager(51);
            if ((localObject2 == null) || (!((acff)localObject2).isFriend(this.aKN))) {
              break label1923;
            }
            i = 0;
          }
          label1633:
          if (i == 0) {
            break label1928;
          }
          localObject2 = aqdj.a(this.app, 200, this.aKN, true);
          label1654:
          localImageView.setBackgroundDrawable((Drawable)localObject2);
          ((ViewGroup)findViewById(2131364064)).setOnClickListener(new ufd(this));
          ((TextView)localObject1).setText(aqmr.trimUnreadableInFriendRequest(this.aKO));
          if (this.bDN != 2) {
            break label1945;
          }
          this.cS.setVisibility(8);
        }
        break;
      }
      for (;;)
      {
        this.cR.setOnClickListener(this);
        this.cS.setOnClickListener(this);
        if (this.cR.getVisibility() == 0) {
          anot.a(this.app, "CliOper", "", "", "0X800AA40", "0X800AA40", 0, 0, "", "", "", "");
        }
        if (this.cS.getVisibility() == 0) {
          anot.a(this.app, "CliOper", "", "", "0X800AD03", "0X800AD03", 0, 0, "", "", "", "");
        }
        anot.a(this.app, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", "", "");
        return;
        this.cR.setVisibility(8);
        this.cS.setVisibility(8);
        break;
        ((TextView)localObject2).setVisibility(8);
        break label844;
        label1869:
        i = 0;
        break label903;
        this.cT.setVisibility(0);
        break label1373;
        this.cT.setVisibility(8);
        break label1373;
        this.BW.setVisibility(8);
        ThreadManager.post(new AddRequestActivity.1(this), 5, null, true);
        break label1471;
        i = 1;
        break label1633;
        localObject2 = aqdj.a(this.app, 1, this.aKN);
        break label1654;
        if ((this.aKO == null) || ("".equals(this.aKO))) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
  }
  
  void a(Card paramCard)
  {
    if (paramCard != null)
    {
      int j = -1;
      localObject1 = "";
      int i = j;
      if (paramCard != null) {
        if (paramCard.shGender != 0)
        {
          i = j;
          if (paramCard.shGender != 1) {}
        }
        else
        {
          i = paramCard.shGender;
        }
      }
      if (i == 0)
      {
        localObject1 = getString(2131695654);
        this.BS.setVisibility(0);
        this.BS.setText((CharSequence)localObject1);
        i = paramCard.age;
        localObject1 = "";
        if (i <= 0) {
          break label383;
        }
        localObject1 = i + getString(2131720665);
        this.BT.setVisibility(0);
        label115:
        this.BT.setText((CharSequence)localObject1);
        Object localObject2 = "";
        localObject1 = localObject2;
        if (paramCard.strProvince != null)
        {
          localObject1 = localObject2;
          if (paramCard.strProvince.length() > 0) {
            localObject1 = "" + paramCard.strProvince;
          }
        }
        localObject2 = localObject1;
        if (paramCard.strCity != null)
        {
          localObject2 = localObject1;
          if (paramCard.strCity.length() > 0) {
            localObject2 = (String)localObject1 + "" + paramCard.strCity;
          }
        }
        this.BU.setText((CharSequence)localObject2);
        if (this.c != null)
        {
          this.BT.setVisibility(8);
          this.BU.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          if ("age:" + paramCard.age + "gender:" + paramCard.shGender + ",isFromWzry=" + this.c == null) {
            break label395;
          }
        }
      }
      label395:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, new Object[] { Boolean.valueOf(bool) });
        return;
        if (i == 1)
        {
          localObject1 = getString(2131693477);
          this.BS.setVisibility(0);
          break;
        }
        this.BS.setVisibility(8);
        break;
        label383:
        this.BT.setVisibility(8);
        break label115;
      }
    }
    paramCard = this.app;
    Object localObject1 = this.app;
    ((FriendListHandler)paramCard.getBusinessHandler(1)).DG(this.aKN);
  }
  
  public void aL(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).show(getTitleBarHeight());
    finish();
  }
  
  public void bFM()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.of = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131297492);
    this.oS = (this.of - i * 1 - 175.0F * this.mDensity);
  }
  
  public void bFN()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(getString(2131691293), 3);
    localausj.a(new ufe(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public void bFO()
  {
    ausj localausj = (ausj)auss.a(this, null);
    if ((this.BR.getTag() instanceof String)) {}
    for (String str = (String)this.BR.getTag();; str = getString(2131719651))
    {
      localausj.setMainTitle(str);
      localausj.addButton(getString(2131720220), 3);
      localausj.a(new uff(this, localausj));
      localausj.addCancelButton(2131721058);
      localausj.show();
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l = anzd.a().hf();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = anzd.a().a(Long.valueOf(l));
    this.Fg = getIntent().getLongExtra("infoid", 0L);
    this.aKN = getIntent().getStringExtra("infouin");
    this.Fh = getIntent().getLongExtra("infotime", 0L);
    this.aKO = getIntent().getStringExtra("verify_msg");
    this.bDN = getIntent().getIntExtra("verify_type", 1);
    this.aKP = getIntent().getStringExtra("msg_source");
    this.bDO = getIntent().getIntExtra("msg_source_id", 3041);
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get() == 8)) {
      this.Fj = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
    }
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has())) {
      this.aKQ = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());
    }
    this.bDQ = getIntent().getIntExtra("msg_type", -1006);
    this.vSig = getIntent().getByteArrayExtra("sig");
    this.lToMobile = getIntent().getLongExtra("lToMobile", 0L);
    this.strNickName = getIntent().getStringExtra("strNickName");
    paramBundle = getIntent().getStringExtra("info_dealwith_msg");
    this.Fi = getIntent().getLongExtra("msg_troopuin", 0L);
    String str = getIntent().getStringExtra("msg_title");
    if (getIntent().hasExtra("param_wzry_data")) {
      this.c = getIntent().getSerializableExtra("param_wzry_data");
    }
    super.setContentView(2131561716);
    Object localObject = findViewById(2131363711);
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130838901);
    }
    localObject = (TextView)findViewById(2131372004);
    if ((paramBundle != null) && (!paramBundle.equals("")))
    {
      ((TextView)localObject).setText(paramBundle);
      ((TextView)localObject).setVisibility(0);
    }
    setTitle(str);
    vJ(true);
    bFK();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(2));
    if (this.Fj != 0L) {
      addObserver(this.b, true);
    }
    addObserver(this.jdField_a_of_type_Achq);
    addObserver(this.cardObserver);
    addObserver(this.jdField_a_of_type_Acfd);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_Achq != null) {
      removeObserver(this.jdField_a_of_type_Achq);
    }
    if (this.cardObserver != null) {
      removeObserver(this.cardObserver);
    }
    if (this.jdField_a_of_type_Acfd != null) {
      removeObserver(this.jdField_a_of_type_Acfd);
    }
    if (this.Fj != 0L) {
      removeObserver(this.b);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this)) {
      QQToast.a(this, getString(2131696270), 0).show(getTitleBarHeight());
    }
    label105:
    label1011:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int m = 0;
      int j = 0;
      int i = 0;
      if (paramView == this.cR) {
        if (this.bDQ == -1011)
        {
          ((FriendListHandler)this.app.getBusinessHandler(1)).a(0, Long.parseLong(this.aKN), this.lToMobile, this.vSig, (byte)0, this.strNickName, this.Fh, this.Fg);
          i = 1;
          anot.a(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
          if (this.c != null) {
            anot.a(this.app, "CliOper", "", "", "0X800843F", "0X800843F", 0, 0, "", "", "", "");
          }
          anot.a(this.app, "CliOper", "", "", "0X800AA41", "0X800AA41", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label1011;
        }
        j(2131719519, 1000L, false);
        break;
        long l1 = anzd.a().hf();
        Object localObject1 = anzd.a().a(Long.valueOf(l1));
        long l2;
        int n;
        int i1;
        Object localObject2;
        if (localObject1 != null)
        {
          i = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
          l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
          j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
          m = ((structmsg.StructMsg)localObject1).msg.src_id.get();
          n = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
          i1 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
          localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
            this.app.a().a().a(i, l1, l2, j, m, n, i1, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
            i = 1;
            break label105;
          }
          localObject1 = new StringBuilder().append("agree, ");
          if (localObject2 != null) {}
          for (i = ((List)localObject2).size();; i = -1)
          {
            QLog.d("Q.systemmsg.AddRequestActivity", 1, i);
            i = 0;
            break;
          }
        }
        QLog.d("Q.systemmsg.AddRequestActivity", 1, "agree");
        break label105;
        if (paramView == this.cS)
        {
          l1 = anzd.a().hf();
          this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = anzd.a().a(Long.valueOf(l1));
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
          {
            i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
            l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
            l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
            m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
            i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
            int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((localObject1 != null) && (1 < ((List)localObject1).size()))
            {
              this.app.a().a().a(i, l1, l2, m, n, i1, i2, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject1).get(1)).action_info.get(), 1, null, false);
              i = 1;
            }
          }
          for (;;)
          {
            anot.a(this.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
            if (this.c != null) {
              anot.a(this.app, "CliOper", "", "", "0X8008440", "0X8008440", 0, 0, "", "", "", "");
            }
            anot.a(this.app, "CliOper", "", "", "0X800AD04", "0X800AD04", 0, 0, "", "", "", "");
            break;
            localObject2 = new StringBuilder().append("refuse, ");
            if (localObject1 != null) {}
            for (i = ((List)localObject1).size();; i = -1)
            {
              QLog.d("Q.systemmsg.AddRequestActivity", 1, i);
              i = j;
              break;
            }
            QLog.d("Q.systemmsg.AddRequestActivity", 1, "refuse");
            i = j;
          }
        }
        i = m;
        if (paramView.getId() == 2131372011)
        {
          i = m;
          if (QQBrowserActivity.bs(1500L))
          {
            localObject1 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&adtag=cloneAddRequest#clone_setting");
            startActivity((Intent)localObject1);
            anot.a(this.app, "CliOper", "", "", "0X800AA3E", "0X800AA3E", 0, 0, "", "", "", "");
            i = m;
          }
        }
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      this.y = aqha.a(this, 230).setTitle(getString(2131691282)).setMessage(2131691280).setPositiveButton(2131691281, new uez(this)).setNegativeButton(2131691040, new ufk(this));
      return this.y;
    }
    this.k = new ReportDialog(this, 2131756467);
    this.k.setContentView(2131558460);
    ((TextView)this.k.findViewById(2131365863)).setText(2131691295);
    return this.k;
  }
  
  protected void s(TextView paramTextView)
  {
    if (paramTextView == null) {}
    Resources localResources;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      paramTextView.setSingleLine(false);
      localResources = paramTextView.getContext().getResources();
      localObject1 = this.aKP;
      localObject2 = localObject1;
      if (this.Fj != 0L)
      {
        this.dF = aqgv.u(this.app, String.valueOf(this.Fj));
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.dF))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(this.aKP)) {
            localObject2 = String.format(Locale.getDefault(), "%s-%s", new Object[] { this.aKP, this.dF });
          }
        }
      }
    } while (aqft.equalsWithNullCheck(localObject2, paramTextView.getText().toString()));
    SpannableString localSpannableString;
    int j;
    label427:
    label718:
    int m;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localSpannableString = new SpannableString((CharSequence)localObject2);
      Bundle localBundle = null;
      Object localObject4 = null;
      Object localObject3 = localObject4;
      localObject1 = localBundle;
      long l;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
      {
        localObject3 = localObject4;
        localObject1 = localBundle;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
        {
          localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
          l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
          if (l == 0L) {
            break label936;
          }
          localObject1 = Long.toString(l);
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
      {
        i = ((String)localObject2).indexOf((String)localObject3);
        j = ((String)localObject3).length();
        localSpannableString.setSpan(new a(1, "Q.systemmsg.AddRequestActivity", TroopInfoActivity.c((String)localObject1, 101)), i, j + i, 33);
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (QLog.isColorLevel())) {
          QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(1), localObject3, localObject1, Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), localObject2 }));
        }
      }
      localObject3 = this.dF;
      if (this.Fj != 0L)
      {
        localObject1 = Long.toString(this.Fj);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
        {
          i = ((String)localObject2).indexOf((String)localObject3);
          j = ((String)localObject3).length();
          localBundle = new Bundle();
          localBundle.putString("uin", (String)localObject1);
          localBundle.putString("uinname", this.dF);
          localBundle.putInt("uintype", 3000);
          localSpannableString.setSpan(new a(2, "Q.systemmsg.AddRequestActivity", localBundle), i, j + i, 33);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null) && (QLog.isColorLevel())) {
            QLog.i("Q.systemmsg.AddRequestActivity", 2, String.format("setMsgSourceInfo [type:%s, tag:%s, param:%s, src_id:%s, sub_src_id:%s, str:%s]", new Object[] { Integer.valueOf(2), localObject3, localObject1, Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), localObject2 }));
          }
        }
        localBundle = null;
        localObject4 = null;
        localObject3 = localBundle;
        localObject1 = localObject4;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
        {
          localObject3 = localBundle;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
          {
            localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
            l = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get();
            if (l == 0L) {
              break label948;
            }
            localObject1 = Long.toString(l);
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
        {
          j = ((String)localObject2).indexOf((String)localObject3);
          m = ((String)localObject3).length();
          if (!((acff)this.app.getManager(51)).isFriend((String)localObject1)) {
            break label963;
          }
        }
      }
    }
    label936:
    label948:
    label963:
    for (int i = 1;; i = 25)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_profile_uin", (String)localObject1);
      ((Bundle)localObject2).putInt("key_profile_pa", i);
      ((Bundle)localObject2).putInt("key_profile_chatability", 1);
      localSpannableString.setSpan(new a(3, "Q.systemmsg.AddRequestActivity", (Bundle)localObject2), j, j + m, 33);
      paramTextView.setClickable(true);
      paramTextView.setFocusable(true);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      paramTextView.setLinkTextColor(localResources.getColorStateList(2131167355));
      for (;;)
      {
        localObject1 = paramTextView.getText().toString();
        localObject2 = this.app;
        paramTextView = (TextView)localObject1;
        if (localObject1 == null) {
          paramTextView = "null";
        }
        anot.a((QQAppInterface)localObject2, "CliOper", "", "", "0X800AA3F", "0X800AA3F", 0, 0, "", "", paramTextView, "");
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label427;
        localObject1 = null;
        break label718;
        paramTextView.setText((CharSequence)localObject2);
      }
    }
  }
  
  class a
    extends ClickableSpan
  {
    public Bundle extras;
    public String tag;
    public int type;
    
    public a(int paramInt, String paramString, Bundle paramBundle)
    {
      this.type = paramInt;
      this.tag = paramString;
      this.extras = paramBundle;
    }
    
    public void onClick(View paramView)
    {
      if (paramView != null) {}
      for (paramView = paramView.getContext(); paramView == null; paramView = null) {
        return;
      }
      Object localObject;
      switch (this.type)
      {
      default: 
        return;
      case 1: 
        apuh.a(paramView, this.extras, 2);
        return;
      case 2: 
        try
        {
          localObject = new Intent(paramView, DiscussionInfoCardActivity.class);
          ((Intent)localObject).putExtras(this.extras);
          paramView.startActivity((Intent)localObject);
          return;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
      try
      {
        localObject = new ProfileActivity.AllInOne(this.extras.getString("key_profile_uin"), this.extras.getInt("key_profile_pa", 25));
        ((ProfileActivity.AllInOne)localObject).bJa = 109;
        ((ProfileActivity.AllInOne)localObject).bIW = this.extras.getInt("key_profile_chatability");
        ProfileActivity.b(paramView, (ProfileActivity.AllInOne)localObject);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(-14782465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity
 * JD-Core Version:    0.7.0.1
 */