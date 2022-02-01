package com.tencent.mobileqq.activity;

import abby;
import acbn;
import accn;
import acfd;
import acff;
import acfp;
import achq;
import aclp;
import adyp;
import adyq;
import ahgq;
import ahpp;
import aizg;
import ajnn;
import ajoh;
import ajok;
import alcp;
import anaz;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import anqu;
import anqv;
import ansr;
import antd;
import anug;
import anux;
import aqep;
import aqfe;
import aqft;
import aqgv;
import aqiw;
import arhz;
import asgx;
import ausj;
import avpw;
import avpw.d;
import awcy;
import awcy.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.IntimateInfoFragment;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import jou;
import mqq.os.MqqHandler;
import stj;
import vbv;
import vbv.a;
import vmf;
import vmg;
import vmh;
import vmi;
import vmj;
import vmk;
import vml;
import vmm;
import vmn;
import vmo;
import wja;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, vbv.a
{
  public arhz B;
  TextView EB;
  TextView EC;
  public Intent L;
  Boolean V = null;
  public FormSimpleItem Y;
  FormSimpleItem Z;
  achq jdField_a_of_type_Achq = new vmk(this);
  adyp jdField_a_of_type_Adyp;
  adyq jdField_a_of_type_Adyq = new vmn(this);
  ahpp jdField_a_of_type_Ahpp = new vmf(this);
  private alcp jdField_a_of_type_Alcp;
  public BusinessCard a;
  public vbv a;
  String aON;
  String aOO;
  public String aOP;
  public String aOQ;
  String aOR = "";
  private boolean aWW;
  private boolean aWX;
  private boolean aWY;
  private boolean aWZ;
  private boolean aXa;
  boolean aZf;
  private boolean aZg;
  private boolean aZh;
  private boolean aZi;
  private boolean aZj;
  private boolean aZk;
  public Bundle aa;
  FormSimpleItem aa;
  FormSimpleItem ab;
  FormSimpleItem ac;
  FormSimpleItem ad;
  FormSimpleItem ae;
  FormSimpleItem af;
  public FormSwitchItem aw;
  public FormSwitchItem ax;
  public FormSwitchItem ay;
  public FormSwitchItem az;
  aclp jdField_b_of_type_Aclp = new vml(this);
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = new vmi(this);
  public int bFB = 0;
  private int bHp = -1;
  private int bHq = -1;
  private int bHr = -1;
  private int bHs = -1;
  private int bHt = -1;
  private int bJe = -1;
  private int bJf = -1;
  private int bJg = -1;
  private int bJh = -1;
  acfd c = new vmm(this);
  accn cardObserver = new vmo(this);
  public ProfileActivity.AllInOne d;
  public ProfileActivity.AllInOne e;
  String from = "";
  int[] fx;
  FormItemRelativeLayout h;
  boolean mIsShield;
  String mNickName;
  FormSimpleItem t;
  
  private void C(int paramInt, Intent paramIntent)
  {
    if (paramIntent.hasExtra("param_interest_switch")) {
      this.bHp = paramIntent.getIntExtra("param_interest_switch", 0);
    }
    if (!this.aWW) {
      this.aWW = paramIntent.getBooleanExtra("param_interest_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_music_switch")) {
      this.bHq = paramIntent.getIntExtra("param_music_switch", 0);
    }
    if (!this.aWX) {
      this.aWX = paramIntent.getBooleanExtra("param_music_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_present_switch")) {
      this.bHt = paramIntent.getIntExtra("param_present_switch", 0);
    }
    if (!this.aXa) {
      this.aXa = paramIntent.getBooleanExtra("param_present_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_extendfriend_switch")) {
      this.bHs = paramIntent.getIntExtra("param_extendfriend_switch", 0);
    }
    if (!this.aWZ) {
      this.aWZ = paramIntent.getBooleanExtra("param_extendfriend_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_personlabel_switch")) {
      this.bHr = paramIntent.getIntExtra("param_personlabel_switch", 0);
    }
    if (!this.aWY) {
      this.aWY = paramIntent.getBooleanExtra("param_personlabel_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_miniapp_switch")) {
      this.bJe = paramIntent.getIntExtra("param_miniapp_switch", 0);
    }
    if (!this.aZg) {
      this.aZg = paramIntent.getBooleanExtra("param_miniapp_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_musicbox_switch")) {
      this.bJf = paramIntent.getIntExtra("param_musicbox_switch", 0);
    }
    if (!this.aZh) {
      this.aZh = paramIntent.getBooleanExtra("param_musicbox_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_sticky_note_switch")) {
      this.bJg = paramIntent.getIntExtra("param_sticky_note_switch", 0);
    }
    if (!this.aZi) {
      this.aZi = paramIntent.getBooleanExtra("param_sticky_note_switch_changed", false);
    }
    if (!this.aZj) {
      this.aZj = paramIntent.getBooleanExtra("param_qqcircle_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_life_achievement_switch")) {
      this.bJh = paramIntent.getIntExtra("param_life_achievement_switch", 0);
    }
    if (!this.aZk) {
      this.aZk = paramIntent.getBooleanExtra("param_life_achievement_changed", false);
    }
  }
  
  private boolean PH()
  {
    return (this.aWW) || (this.aWX) || (this.aWZ) || (this.aWY) || (this.aXa) || (this.aZg) || (this.aZh) || (this.aZi) || (this.aZj) || (this.aZk);
  }
  
  private static anqv a(String paramString)
  {
    anug localanug = new anug();
    localanug.Vs(1);
    localanug.Rn(paramString);
    return localanug;
  }
  
  private void bKO()
  {
    boolean bool = FriendsStatusUtil.g(this.e.uin, this.app);
    if (this.aw != null)
    {
      this.aw.setOnCheckedChangeListener(null);
      this.aw.setChecked(bool);
      this.aw.setOnCheckedChangeListener(this);
      if (AppSetting.enableTalkBack) {
        this.aw.setContentDescription(getString(2131691044));
      }
    }
  }
  
  private void bPo()
  {
    Intent localIntent = new Intent(this, InterestSwitchEditActivity.class);
    if (-1 != this.bHp) {
      localIntent.putExtra("param_interest_switch", this.bHp);
    }
    if (-1 != this.bHq) {
      localIntent.putExtra("param_music_switch", this.bHq);
    }
    if (-1 != this.bHs) {
      localIntent.putExtra("param_extendfriend_switch", this.bHs);
    }
    if (-1 != this.bHr) {
      localIntent.putExtra("param_personlabel_switch", this.bHr);
    }
    if (-1 != this.bHt) {
      localIntent.putExtra("param_present_switch", this.bHt);
    }
    if (-1 != this.bJe) {
      localIntent.putExtra("param_miniapp_switch", this.bJe);
    }
    if (-1 != this.bJf) {
      localIntent.putExtra("param_musicbox_switch", this.bJf);
    }
    if (-1 != this.bJg) {
      localIntent.putExtra("param_sticky_note_switch", this.bJg);
    }
    if (-1 != this.bJh) {
      localIntent.putExtra("param_life_achievement_switch", this.bJh);
    }
    startActivityForResult(localIntent, 1008);
  }
  
  private void bSx()
  {
    boolean bool = false;
    Object localObject;
    ajoh localajoh;
    int i;
    if (this.ac.getVisibility() == 0)
    {
      localObject = "";
      localajoh = ajnn.a(this.app, this.e.uin, true);
      if (localajoh == null) {
        break label195;
      }
      if (localajoh.type != 1L) {
        break label122;
      }
      localObject = getString(2131695048);
      i = localajoh.iconResId;
      bool = localajoh.arj();
    }
    for (;;)
    {
      this.ac.setRightText((CharSequence)localObject);
      if (i != 0)
      {
        localObject = getResources().getDrawable(i);
        if ((localObject instanceof SkinnableBitmapDrawable))
        {
          localObject = ((SkinnableBitmapDrawable)localObject).mutate2();
          label103:
          if (!bool) {
            break label176;
          }
          ((Drawable)localObject).setAlpha(102);
        }
        for (;;)
        {
          this.ac.setRightIcon((Drawable)localObject);
          return;
          label122:
          if (localajoh.type == 2L)
          {
            localObject = getString(2131695046);
            break;
          }
          if (localajoh.type != 3L) {
            break;
          }
          localObject = getString(2131695047);
          break;
          localObject = ((Drawable)localObject).mutate();
          break label103;
          label176:
          ((Drawable)localObject).setAlpha(255);
        }
      }
      this.ac.setRightIcon(null);
      return;
      label195:
      i = 0;
    }
  }
  
  private void xN(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      bSA();
      return;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    try
    {
      l = Long.parseLong(this.e.uin);
      if (l > 0L) {
        if (!paramBoolean)
        {
          bool1 = true;
          localFriendListHandler.ai(l, bool1);
          i = 1;
          if (i == 0) {
            break label127;
          }
          if (paramBoolean) {
            break label122;
          }
          paramBoolean = bool2;
          this.mIsShield = paramBoolean;
          this.bFB |= 0x2;
          bPf();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
        continue;
        boolean bool1 = false;
        continue;
        label122:
        paramBoolean = false;
        continue;
        label127:
        if (paramBoolean) {
          cf(2131720205, 1);
        }
        for (;;)
        {
          bSA();
          return;
          cf(2131720207, 1);
        }
        int i = 0;
      }
    }
  }
  
  boolean PE()
  {
    aizg localaizg = null;
    Object localObject = null;
    switch (this.e.pa)
    {
    default: 
      localaizg = (aizg)this.app.getManager(16);
      if (localaizg == null) {
        break label162;
      }
      if (ProfileActivity.AllInOne.g(this.e)) {
        localObject = this.e.uin;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localaizg.nf((String)localObject);
      localObject = (acff)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = localaizg; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((acff)localObject).e(this.e.uin)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.i(this.e)) {
        localObject = oP();
      }
    }
    label162:
    return false;
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.e != null)
    {
      localObject1 = localObject2;
      if (this.e.pr != null)
      {
        localObject1 = localObject2;
        if (this.e.pr.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.e.pr.get(0);
        }
      }
    }
    return localObject1;
  }
  
  void a(int paramInt1, RelativeLayout paramRelativeLayout, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.fx.length) || (paramRelativeLayout == null)) {
      return;
    }
    if (this.fx[paramInt1] == 1)
    {
      paramRelativeLayout.setVisibility(0);
      paramRelativeLayout.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839682));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839701));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839689));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130839695));
      return;
    }
    paramRelativeLayout.setVisibility(8);
  }
  
  void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.fx.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.fx[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSimpleItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSimpleItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  void a(int paramInt1, FormSwitchItem paramFormSwitchItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.fx.length) || (paramFormSwitchItem == null)) {
      return;
    }
    if (this.fx[paramInt1] == 1)
    {
      paramFormSwitchItem.setVisibility(0);
      paramFormSwitchItem.setOnCheckedChangeListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSwitchItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSwitchItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSwitchItem.setBgType(3);
        return;
      }
      paramFormSwitchItem.setBgType(2);
      return;
    }
    paramFormSwitchItem.setVisibility(8);
  }
  
  void a(TextView paramTextView, Drawable paramDrawable)
  {
    if (paramTextView != null)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
      }
    }
    else {
      return;
    }
    paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    int j = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (acff)this.app.getManager(51);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((Friends)localObject2).remark != null)
        {
          localObject1 = str;
          if (((Friends)localObject2).isRemark == 1) {
            localObject1 = ((Friends)localObject2).remark;
          }
        }
      }
      if (TextUtils.isEmpty(paramBusinessCard.picUrl)) {
        break label242;
      }
      a(this.EB, getResources().getDrawable(2130846675));
    }
    int i;
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (!TextUtils.isEmpty(paramBusinessCard.company))
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append(paramBusinessCard.company);
      }
      if ((paramBusinessCard.mobilesNum == null) || (paramBusinessCard.mobilesNum.isEmpty())) {
        break label254;
      }
      i = 0;
      while (i < paramBusinessCard.mobilesNum.size())
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append((String)paramBusinessCard.mobilesNum.get(i));
        i += 1;
      }
      localObject2 = ((acff)localObject1).e(this.e.uin);
      break;
      label242:
      a(this.EB, null);
    }
    label254:
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      i = j;
      if (((StringBuilder)localObject2).length() != 0)
      {
        ((StringBuilder)localObject2).append("，");
        i = j;
      }
      while (i < paramBusinessCard.descs.size())
      {
        ((StringBuilder)localObject2).append((String)paramBusinessCard.descs.get(i));
        i += 1;
      }
    }
    this.aOR = ((StringBuilder)localObject2).toString();
    vx((String)localObject1);
  }
  
  public void aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    bJs();
    if ((this.bFB & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label112;
      }
      if (paramBoolean2) {
        cf(2131720206, 2);
      }
    }
    else
    {
      this.bFB &= 0xFFFFFFFD;
      if (!ProfileActivity.AllInOne.b(this.e)) {
        break label146;
      }
      acff localacff = (acff)this.app.getManager(51);
      if ((localacff == null) || (TextUtils.isEmpty(this.e.uin))) {
        break label138;
      }
      this.mIsShield = localacff.ke(this.e.uin);
    }
    for (;;)
    {
      bSA();
      return;
      cf(2131720219, 2);
      break;
      label112:
      if (paramBoolean2)
      {
        cf(2131720205, 1);
        break;
      }
      cf(2131720207, 1);
      break;
      label138:
      this.mIsShield = false;
      continue;
      label146:
      this.mIsShield = PE();
    }
  }
  
  public void ai(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      ak(paramArrayOfByte);
    }
  }
  
  public void aj(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      ak(paramArrayOfByte);
    }
  }
  
  public void ak(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Vbv != null) {
      this.jdField_a_of_type_Vbv.ak(paramArrayOfByte);
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      d(null);
      return;
    }
    runOnUiThread(new ProfileCardMoreActivity.4(this));
  }
  
  /* Error */
  int bF(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 630	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 631	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 263	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 634	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   23: invokevirtual 640	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3446 -> 3476
    //   33: aload 11
    //   35: ldc_w 642
    //   38: aload_1
    //   39: invokevirtual 648	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   42: checkcast 642	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   45: astore 15
    //   47: aload 11
    //   49: ifnull +8 -> 57
    //   52: aload 11
    //   54: invokevirtual 651	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   57: aload 15
    //   59: ifnonnull +5 -> 64
    //   62: iconst_m1
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 653	com/tencent/mobileqq/activity/ProfileCardMoreActivity:aOO	Ljava/lang/String;
    //   68: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +877 -> 948
    //   74: aload_0
    //   75: getfield 653	com/tencent/mobileqq/activity/ProfileCardMoreActivity:aOO	Ljava/lang/String;
    //   78: astore 12
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore 4
    //   85: aconst_null
    //   86: astore 13
    //   88: aload_0
    //   89: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   92: astore 11
    //   94: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   97: astore 16
    //   99: new 542	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 665
    //   109: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 12
    //   114: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 667
    //   120: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 14
    //   128: aload 11
    //   130: aload 16
    //   132: iconst_4
    //   133: anewarray 567	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: ldc_w 669
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: ldc_w 671
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: ldc_w 673
    //   153: aastore
    //   154: dup
    //   155: iconst_3
    //   156: ldc_w 675
    //   159: aastore
    //   160: aload 14
    //   162: aconst_null
    //   163: aconst_null
    //   164: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   167: astore 11
    //   169: iconst_0
    //   170: istore_3
    //   171: lconst_0
    //   172: lstore 8
    //   174: iload 4
    //   176: istore_2
    //   177: aload 11
    //   179: ifnull +3284 -> 3463
    //   182: aload 11
    //   184: invokeinterface 686 1 0
    //   189: istore 10
    //   191: iload 10
    //   193: ifeq +3270 -> 3463
    //   196: aload 11
    //   198: iconst_0
    //   199: invokeinterface 690 2 0
    //   204: lstore 6
    //   206: iload_2
    //   207: istore 4
    //   209: aload 15
    //   211: getfield 693	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnull +873 -> 1091
    //   221: aconst_null
    //   222: astore 14
    //   224: aload_0
    //   225: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   228: astore 17
    //   230: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   233: astore 16
    //   235: new 542	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 695
    //   245: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: lload 6
    //   250: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: ldc_w 700
    //   256: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 673
    //   262: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 702
    //   268: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 704
    //   274: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc_w 706
    //   280: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 675
    //   286: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 702
    //   292: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 15
    //   297: getfield 693	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   300: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 706
    //   306: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 708
    //   312: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 702
    //   318: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iconst_2
    //   322: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: ldc_w 667
    //   328: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore 13
    //   336: aload 17
    //   338: aload 16
    //   340: iconst_5
    //   341: anewarray 567	java/lang/String
    //   344: dup
    //   345: iconst_0
    //   346: ldc_w 669
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: ldc_w 671
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: ldc_w 673
    //   361: aastore
    //   362: dup
    //   363: iconst_3
    //   364: ldc_w 675
    //   367: aastore
    //   368: dup
    //   369: iconst_4
    //   370: ldc_w 708
    //   373: aastore
    //   374: aload 13
    //   376: aconst_null
    //   377: aconst_null
    //   378: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   381: astore 13
    //   383: aload 13
    //   385: ifnull +594 -> 979
    //   388: aload 13
    //   390: invokeinterface 714 1 0
    //   395: istore 10
    //   397: iload 10
    //   399: ifeq +580 -> 979
    //   402: iconst_1
    //   403: istore_3
    //   404: iconst_1
    //   405: istore_2
    //   406: aload 13
    //   408: invokeinterface 715 1 0
    //   413: iconst_0
    //   414: ifeq +3042 -> 3456
    //   417: new 717	java/lang/NullPointerException
    //   420: dup
    //   421: invokespecial 718	java/lang/NullPointerException:<init>	()V
    //   424: athrow
    //   425: iload_3
    //   426: istore 5
    //   428: lload 6
    //   430: lstore 8
    //   432: iload_2
    //   433: istore 4
    //   435: aload 11
    //   437: ifnull +3006 -> 3443
    //   440: aload 11
    //   442: invokeinterface 715 1 0
    //   447: iload_3
    //   448: ifne +668 -> 1116
    //   451: iconst_1
    //   452: istore_3
    //   453: iconst_0
    //   454: istore_2
    //   455: new 720	android/content/ContentValues
    //   458: dup
    //   459: invokespecial 721	android/content/ContentValues:<init>	()V
    //   462: astore 13
    //   464: iload_3
    //   465: iconst_1
    //   466: if_icmpne +668 -> 1134
    //   469: aload_0
    //   470: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   473: getstatic 724	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   476: aload 13
    //   478: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   481: invokestatic 736	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   484: lstore 6
    //   486: aload 12
    //   488: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   491: ifne +55 -> 546
    //   494: aload 13
    //   496: invokevirtual 739	android/content/ContentValues:clear	()V
    //   499: aload 13
    //   501: ldc_w 669
    //   504: lload 6
    //   506: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   512: aload 13
    //   514: ldc_w 673
    //   517: ldc_w 749
    //   520: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload 13
    //   525: ldc_w 675
    //   528: aload 12
    //   530: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   537: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   540: aload 13
    //   542: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   545: pop
    //   546: aload 15
    //   548: getfield 755	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   551: ifnonnull +11 -> 562
    //   554: aload 15
    //   556: getfield 758	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   559: ifnull +99 -> 658
    //   562: aload 13
    //   564: invokevirtual 739	android/content/ContentValues:clear	()V
    //   567: aload 13
    //   569: ldc_w 669
    //   572: lload 6
    //   574: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   577: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   580: aload 13
    //   582: ldc_w 673
    //   585: ldc_w 760
    //   588: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: aload 15
    //   593: getfield 758	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   596: ifnull +16 -> 612
    //   599: aload 13
    //   601: ldc_w 675
    //   604: aload 15
    //   606: getfield 758	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   609: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: aload 15
    //   614: getfield 755	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   617: ifnull +16 -> 633
    //   620: aload 13
    //   622: ldc_w 762
    //   625: aload 15
    //   627: getfield 755	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   630: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 13
    //   635: ldc_w 708
    //   638: iconst_1
    //   639: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   645: aload_0
    //   646: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   649: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   652: aload 13
    //   654: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   657: pop
    //   658: aload 15
    //   660: getfield 693	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   663: ifnull +70 -> 733
    //   666: aload 13
    //   668: invokevirtual 739	android/content/ContentValues:clear	()V
    //   671: aload 13
    //   673: ldc_w 669
    //   676: lload 6
    //   678: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   681: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   684: aload 13
    //   686: ldc_w 673
    //   689: ldc_w 704
    //   692: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload 13
    //   697: ldc_w 675
    //   700: aload 15
    //   702: getfield 693	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   705: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload 13
    //   710: ldc_w 708
    //   713: iconst_2
    //   714: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   720: aload_0
    //   721: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   724: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   727: aload 13
    //   729: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   732: pop
    //   733: aload 15
    //   735: getfield 773	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   738: ifnull +70 -> 808
    //   741: aload 13
    //   743: invokevirtual 739	android/content/ContentValues:clear	()V
    //   746: aload 13
    //   748: ldc_w 669
    //   751: lload 6
    //   753: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   756: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   759: aload 13
    //   761: ldc_w 673
    //   764: ldc_w 704
    //   767: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: aload 13
    //   772: ldc_w 675
    //   775: aload 15
    //   777: getfield 773	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   780: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload 13
    //   785: ldc_w 708
    //   788: iconst_3
    //   789: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   795: aload_0
    //   796: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   799: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   802: aload 13
    //   804: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   807: pop
    //   808: aload 15
    //   810: getfield 776	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   813: ifnull +70 -> 883
    //   816: aload 13
    //   818: invokevirtual 739	android/content/ContentValues:clear	()V
    //   821: aload 13
    //   823: ldc_w 669
    //   826: lload 6
    //   828: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   831: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   834: aload 13
    //   836: ldc_w 673
    //   839: ldc_w 778
    //   842: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload 13
    //   847: ldc_w 675
    //   850: aload 15
    //   852: getfield 776	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   855: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload 13
    //   860: ldc_w 708
    //   863: iconst_2
    //   864: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   870: aload_0
    //   871: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   874: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   877: aload 13
    //   879: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   882: pop
    //   883: aload 13
    //   885: invokevirtual 739	android/content/ContentValues:clear	()V
    //   888: aload 13
    //   890: ldc_w 669
    //   893: lload 6
    //   895: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   898: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   901: aload 13
    //   903: ldc_w 673
    //   906: ldc_w 780
    //   909: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: aload 13
    //   914: ldc_w 675
    //   917: aload_1
    //   918: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   921: aload 13
    //   923: ldc_w 708
    //   926: iconst_2
    //   927: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   930: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   933: aload_0
    //   934: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   937: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   940: aload 13
    //   942: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   945: pop
    //   946: iconst_0
    //   947: ireturn
    //   948: aload 15
    //   950: getfield 783	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   953: ifnull +13 -> 966
    //   956: aload 15
    //   958: getfield 783	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   961: astore 12
    //   963: goto -883 -> 80
    //   966: aload_1
    //   967: invokestatic 442	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   970: ifne +2500 -> 3470
    //   973: aload_1
    //   974: astore 12
    //   976: goto -896 -> 80
    //   979: iconst_0
    //   980: istore_2
    //   981: iconst_0
    //   982: istore 4
    //   984: iload_2
    //   985: istore_3
    //   986: aload 13
    //   988: ifnull +2494 -> 3482
    //   991: iload 4
    //   993: istore_3
    //   994: aload 13
    //   996: invokeinterface 715 1 0
    //   1001: iload_2
    //   1002: istore_3
    //   1003: goto +2479 -> 3482
    //   1006: iload_2
    //   1007: istore_3
    //   1008: aload 13
    //   1010: ifnull +2472 -> 3482
    //   1013: iload_2
    //   1014: istore_3
    //   1015: aload 13
    //   1017: invokeinterface 715 1 0
    //   1022: iload_2
    //   1023: istore_3
    //   1024: goto +2458 -> 3482
    //   1027: astore 13
    //   1029: iload_3
    //   1030: istore_2
    //   1031: iconst_1
    //   1032: istore_3
    //   1033: iload_3
    //   1034: istore 5
    //   1036: lload 6
    //   1038: lstore 8
    //   1040: iload_2
    //   1041: istore 4
    //   1043: aload 11
    //   1045: ifnull +2398 -> 3443
    //   1048: aload 11
    //   1050: invokeinterface 715 1 0
    //   1055: goto -608 -> 447
    //   1058: astore 13
    //   1060: aload 14
    //   1062: ifnull +13 -> 1075
    //   1065: iload_2
    //   1066: istore 4
    //   1068: aload 14
    //   1070: invokeinterface 715 1 0
    //   1075: iload_2
    //   1076: istore 4
    //   1078: aload 13
    //   1080: athrow
    //   1081: astore 13
    //   1083: iconst_1
    //   1084: istore_3
    //   1085: iload 4
    //   1087: istore_2
    //   1088: goto -55 -> 1033
    //   1091: iconst_0
    //   1092: istore_2
    //   1093: iconst_1
    //   1094: istore_3
    //   1095: goto -670 -> 425
    //   1098: astore 11
    //   1100: aload 13
    //   1102: astore_1
    //   1103: aload_1
    //   1104: ifnull +9 -> 1113
    //   1107: aload_1
    //   1108: invokeinterface 715 1 0
    //   1113: aload 11
    //   1115: athrow
    //   1116: iload_2
    //   1117: ifne +10 -> 1127
    //   1120: iconst_1
    //   1121: istore_3
    //   1122: iconst_0
    //   1123: istore_2
    //   1124: goto -669 -> 455
    //   1127: iconst_1
    //   1128: istore_2
    //   1129: iconst_0
    //   1130: istore_3
    //   1131: goto -676 -> 455
    //   1134: iload_2
    //   1135: iconst_1
    //   1136: if_icmpne +2163 -> 3299
    //   1139: aload 15
    //   1141: getfield 693	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1144: ifnull +131 -> 1275
    //   1147: aload 13
    //   1149: invokevirtual 739	android/content/ContentValues:clear	()V
    //   1152: aload 13
    //   1154: ldc_w 673
    //   1157: ldc_w 704
    //   1160: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: aload 13
    //   1165: ldc_w 675
    //   1168: aload 15
    //   1170: getfield 693	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1173: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: aload 13
    //   1178: ldc_w 708
    //   1181: iconst_2
    //   1182: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1188: aload_0
    //   1189: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1192: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1195: aload 13
    //   1197: new 542	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1204: ldc_w 695
    //   1207: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: lload 6
    //   1212: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1215: ldc_w 700
    //   1218: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: ldc_w 673
    //   1224: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: ldc_w 702
    //   1230: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: ldc_w 704
    //   1236: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: ldc_w 706
    //   1242: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: ldc_w 708
    //   1248: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: ldc_w 702
    //   1254: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: iconst_2
    //   1258: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1261: ldc_w 667
    //   1264: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: aconst_null
    //   1271: invokevirtual 787	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1274: pop
    //   1275: aload 15
    //   1277: getfield 755	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1280: ifnull +293 -> 1573
    //   1283: aconst_null
    //   1284: astore 11
    //   1286: aload_0
    //   1287: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1290: astore 12
    //   1292: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1295: astore 16
    //   1297: new 542	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1304: ldc_w 695
    //   1307: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: lload 6
    //   1312: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1315: ldc_w 700
    //   1318: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: ldc_w 673
    //   1324: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: ldc_w 702
    //   1330: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: ldc_w 760
    //   1336: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: ldc_w 706
    //   1342: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: ldc_w 708
    //   1348: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: ldc_w 702
    //   1354: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: iconst_1
    //   1358: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: ldc_w 667
    //   1364: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: astore 14
    //   1372: aload 12
    //   1374: aload 16
    //   1376: iconst_5
    //   1377: anewarray 567	java/lang/String
    //   1380: dup
    //   1381: iconst_0
    //   1382: ldc_w 669
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_1
    //   1388: ldc_w 671
    //   1391: aastore
    //   1392: dup
    //   1393: iconst_2
    //   1394: ldc_w 673
    //   1397: aastore
    //   1398: dup
    //   1399: iconst_3
    //   1400: ldc_w 762
    //   1403: aastore
    //   1404: dup
    //   1405: iconst_4
    //   1406: ldc_w 708
    //   1409: aastore
    //   1410: aload 14
    //   1412: aconst_null
    //   1413: aconst_null
    //   1414: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1417: astore 12
    //   1419: aload 12
    //   1421: astore 11
    //   1423: aload 11
    //   1425: invokeinterface 714 1 0
    //   1430: ifeq +1364 -> 2794
    //   1433: aload 13
    //   1435: invokevirtual 739	android/content/ContentValues:clear	()V
    //   1438: aload 13
    //   1440: ldc_w 673
    //   1443: ldc_w 760
    //   1446: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1449: aload 13
    //   1451: ldc_w 762
    //   1454: aload 15
    //   1456: getfield 755	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1459: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1462: aload 13
    //   1464: ldc_w 708
    //   1467: iconst_1
    //   1468: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1471: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1474: aload_0
    //   1475: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1478: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1481: aload 13
    //   1483: new 542	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1490: ldc_w 695
    //   1493: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: lload 6
    //   1498: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1501: ldc_w 700
    //   1504: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: ldc_w 673
    //   1510: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1513: ldc_w 702
    //   1516: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: ldc_w 760
    //   1522: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: ldc_w 706
    //   1528: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: ldc_w 708
    //   1534: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: ldc_w 702
    //   1540: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: iconst_1
    //   1544: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1547: ldc_w 667
    //   1550: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: aconst_null
    //   1557: invokevirtual 787	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1560: pop
    //   1561: aload 11
    //   1563: ifnull +10 -> 1573
    //   1566: aload 11
    //   1568: invokeinterface 715 1 0
    //   1573: aload 15
    //   1575: getfield 758	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1578: ifnull +293 -> 1871
    //   1581: aconst_null
    //   1582: astore 11
    //   1584: aload_0
    //   1585: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1588: astore 16
    //   1590: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1593: astore 14
    //   1595: new 542	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1602: ldc_w 695
    //   1605: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: lload 6
    //   1610: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1613: ldc_w 700
    //   1616: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: ldc_w 673
    //   1622: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: ldc_w 702
    //   1628: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: ldc_w 760
    //   1634: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: ldc_w 706
    //   1640: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: ldc_w 708
    //   1646: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: ldc_w 702
    //   1652: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: iconst_1
    //   1656: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1659: ldc_w 667
    //   1662: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: astore 12
    //   1670: aload 16
    //   1672: aload 14
    //   1674: iconst_5
    //   1675: anewarray 567	java/lang/String
    //   1678: dup
    //   1679: iconst_0
    //   1680: ldc_w 669
    //   1683: aastore
    //   1684: dup
    //   1685: iconst_1
    //   1686: ldc_w 671
    //   1689: aastore
    //   1690: dup
    //   1691: iconst_2
    //   1692: ldc_w 673
    //   1695: aastore
    //   1696: dup
    //   1697: iconst_3
    //   1698: ldc_w 675
    //   1701: aastore
    //   1702: dup
    //   1703: iconst_4
    //   1704: ldc_w 708
    //   1707: aastore
    //   1708: aload 12
    //   1710: aconst_null
    //   1711: aconst_null
    //   1712: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1715: astore 12
    //   1717: aload 12
    //   1719: astore 11
    //   1721: aload 11
    //   1723: invokeinterface 714 1 0
    //   1728: ifeq +1168 -> 2896
    //   1731: aload 13
    //   1733: invokevirtual 739	android/content/ContentValues:clear	()V
    //   1736: aload 13
    //   1738: ldc_w 673
    //   1741: ldc_w 760
    //   1744: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1747: aload 13
    //   1749: ldc_w 675
    //   1752: aload 15
    //   1754: getfield 758	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1757: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1760: aload 13
    //   1762: ldc_w 708
    //   1765: iconst_1
    //   1766: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1769: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1772: aload_0
    //   1773: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1776: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1779: aload 13
    //   1781: new 542	java/lang/StringBuilder
    //   1784: dup
    //   1785: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1788: ldc_w 695
    //   1791: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: lload 6
    //   1796: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1799: ldc_w 700
    //   1802: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: ldc_w 673
    //   1808: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: ldc_w 702
    //   1814: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: ldc_w 760
    //   1820: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: ldc_w 706
    //   1826: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: ldc_w 708
    //   1832: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: ldc_w 702
    //   1838: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1841: iconst_1
    //   1842: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1845: ldc_w 667
    //   1848: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1854: aconst_null
    //   1855: invokevirtual 787	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1858: pop
    //   1859: aload 11
    //   1861: ifnull +10 -> 1871
    //   1864: aload 11
    //   1866: invokeinterface 715 1 0
    //   1871: aload 15
    //   1873: getfield 773	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1876: ifnull +306 -> 2182
    //   1879: aconst_null
    //   1880: astore 11
    //   1882: aload_0
    //   1883: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1886: astore 16
    //   1888: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1891: astore 14
    //   1893: new 542	java/lang/StringBuilder
    //   1896: dup
    //   1897: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1900: ldc_w 695
    //   1903: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: lload 6
    //   1908: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1911: ldc_w 700
    //   1914: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 673
    //   1920: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: ldc_w 702
    //   1926: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: ldc_w 704
    //   1932: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: ldc_w 706
    //   1938: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: ldc_w 708
    //   1944: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: ldc_w 702
    //   1950: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: iconst_3
    //   1954: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1957: ldc_w 667
    //   1960: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1966: astore 12
    //   1968: aload 16
    //   1970: aload 14
    //   1972: iconst_5
    //   1973: anewarray 567	java/lang/String
    //   1976: dup
    //   1977: iconst_0
    //   1978: ldc_w 669
    //   1981: aastore
    //   1982: dup
    //   1983: iconst_1
    //   1984: ldc_w 671
    //   1987: aastore
    //   1988: dup
    //   1989: iconst_2
    //   1990: ldc_w 673
    //   1993: aastore
    //   1994: dup
    //   1995: iconst_3
    //   1996: ldc_w 675
    //   1999: aastore
    //   2000: dup
    //   2001: iconst_4
    //   2002: ldc_w 708
    //   2005: aastore
    //   2006: aload 12
    //   2008: aconst_null
    //   2009: aconst_null
    //   2010: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2013: astore 12
    //   2015: aload 12
    //   2017: astore 11
    //   2019: aload 11
    //   2021: invokeinterface 714 1 0
    //   2026: ifeq +972 -> 2998
    //   2029: aload 13
    //   2031: invokevirtual 739	android/content/ContentValues:clear	()V
    //   2034: aload 13
    //   2036: ldc_w 669
    //   2039: lload 6
    //   2041: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2044: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2047: aload 13
    //   2049: ldc_w 673
    //   2052: ldc_w 704
    //   2055: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2058: aload 13
    //   2060: ldc_w 675
    //   2063: aload 15
    //   2065: getfield 773	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2068: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2071: aload 13
    //   2073: ldc_w 708
    //   2076: iconst_3
    //   2077: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2080: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2083: aload_0
    //   2084: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2087: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2090: aload 13
    //   2092: new 542	java/lang/StringBuilder
    //   2095: dup
    //   2096: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2099: ldc_w 695
    //   2102: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: lload 6
    //   2107: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2110: ldc_w 700
    //   2113: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: ldc_w 673
    //   2119: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: ldc_w 702
    //   2125: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: ldc_w 704
    //   2131: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: ldc_w 706
    //   2137: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2140: ldc_w 708
    //   2143: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: ldc_w 702
    //   2149: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: iconst_3
    //   2153: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: ldc_w 667
    //   2159: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2165: aconst_null
    //   2166: invokevirtual 787	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2169: pop
    //   2170: aload 11
    //   2172: ifnull +10 -> 2182
    //   2175: aload 11
    //   2177: invokeinterface 715 1 0
    //   2182: aload 15
    //   2184: getfield 776	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2187: ifnull +306 -> 2493
    //   2190: aconst_null
    //   2191: astore 11
    //   2193: aload_0
    //   2194: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2197: astore 12
    //   2199: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2202: astore 16
    //   2204: new 542	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2211: ldc_w 695
    //   2214: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: lload 6
    //   2219: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2222: ldc_w 700
    //   2225: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: ldc_w 673
    //   2231: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: ldc_w 702
    //   2237: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: ldc_w 778
    //   2243: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: ldc_w 706
    //   2249: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: ldc_w 708
    //   2255: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: ldc_w 702
    //   2261: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: iconst_2
    //   2265: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2268: ldc_w 667
    //   2271: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2277: astore 14
    //   2279: aload 12
    //   2281: aload 16
    //   2283: iconst_5
    //   2284: anewarray 567	java/lang/String
    //   2287: dup
    //   2288: iconst_0
    //   2289: ldc_w 669
    //   2292: aastore
    //   2293: dup
    //   2294: iconst_1
    //   2295: ldc_w 671
    //   2298: aastore
    //   2299: dup
    //   2300: iconst_2
    //   2301: ldc_w 673
    //   2304: aastore
    //   2305: dup
    //   2306: iconst_3
    //   2307: ldc_w 675
    //   2310: aastore
    //   2311: dup
    //   2312: iconst_4
    //   2313: ldc_w 708
    //   2316: aastore
    //   2317: aload 14
    //   2319: aconst_null
    //   2320: aconst_null
    //   2321: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2324: astore 12
    //   2326: aload 12
    //   2328: astore 11
    //   2330: aload 11
    //   2332: invokeinterface 714 1 0
    //   2337: ifeq +763 -> 3100
    //   2340: aload 13
    //   2342: invokevirtual 739	android/content/ContentValues:clear	()V
    //   2345: aload 13
    //   2347: ldc_w 669
    //   2350: lload 6
    //   2352: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2355: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2358: aload 13
    //   2360: ldc_w 673
    //   2363: ldc_w 778
    //   2366: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2369: aload 13
    //   2371: ldc_w 675
    //   2374: aload 15
    //   2376: getfield 776	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2379: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2382: aload 13
    //   2384: ldc_w 708
    //   2387: iconst_2
    //   2388: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2391: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2394: aload_0
    //   2395: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2398: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2401: aload 13
    //   2403: new 542	java/lang/StringBuilder
    //   2406: dup
    //   2407: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2410: ldc_w 695
    //   2413: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2416: lload 6
    //   2418: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2421: ldc_w 700
    //   2424: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2427: ldc_w 673
    //   2430: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: ldc_w 702
    //   2436: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2439: ldc_w 778
    //   2442: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: ldc_w 706
    //   2448: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2451: ldc_w 708
    //   2454: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: ldc_w 702
    //   2460: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2463: iconst_2
    //   2464: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2467: ldc_w 667
    //   2470: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2476: aconst_null
    //   2477: invokevirtual 787	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2480: pop
    //   2481: aload 11
    //   2483: ifnull +10 -> 2493
    //   2486: aload 11
    //   2488: invokeinterface 715 1 0
    //   2493: aconst_null
    //   2494: astore 11
    //   2496: aload_0
    //   2497: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2500: astore 12
    //   2502: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2505: astore 14
    //   2507: new 542	java/lang/StringBuilder
    //   2510: dup
    //   2511: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2514: ldc_w 695
    //   2517: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: lload 6
    //   2522: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2525: ldc_w 700
    //   2528: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: ldc_w 673
    //   2534: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: ldc_w 702
    //   2540: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: ldc_w 780
    //   2546: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: ldc_w 706
    //   2552: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: ldc_w 708
    //   2558: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: ldc_w 702
    //   2564: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: iconst_2
    //   2568: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2571: ldc_w 667
    //   2574: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2577: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2580: astore 15
    //   2582: aload 12
    //   2584: aload 14
    //   2586: iconst_5
    //   2587: anewarray 567	java/lang/String
    //   2590: dup
    //   2591: iconst_0
    //   2592: ldc_w 669
    //   2595: aastore
    //   2596: dup
    //   2597: iconst_1
    //   2598: ldc_w 671
    //   2601: aastore
    //   2602: dup
    //   2603: iconst_2
    //   2604: ldc_w 673
    //   2607: aastore
    //   2608: dup
    //   2609: iconst_3
    //   2610: ldc_w 675
    //   2613: aastore
    //   2614: dup
    //   2615: iconst_4
    //   2616: ldc_w 708
    //   2619: aastore
    //   2620: aload 15
    //   2622: aconst_null
    //   2623: aconst_null
    //   2624: invokestatic 681	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2627: astore 12
    //   2629: aload 12
    //   2631: astore 11
    //   2633: aload 11
    //   2635: invokeinterface 714 1 0
    //   2640: ifeq +562 -> 3202
    //   2643: aload 13
    //   2645: invokevirtual 739	android/content/ContentValues:clear	()V
    //   2648: aload 13
    //   2650: ldc_w 669
    //   2653: lload 6
    //   2655: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2658: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2661: aload 13
    //   2663: ldc_w 673
    //   2666: ldc_w 780
    //   2669: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2672: aload 13
    //   2674: ldc_w 675
    //   2677: aload_1
    //   2678: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2681: aload 13
    //   2683: ldc_w 708
    //   2686: iconst_2
    //   2687: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2690: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2693: aload_0
    //   2694: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2697: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2700: aload 13
    //   2702: new 542	java/lang/StringBuilder
    //   2705: dup
    //   2706: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2709: ldc_w 695
    //   2712: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2715: lload 6
    //   2717: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2720: ldc_w 700
    //   2723: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: ldc_w 673
    //   2729: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2732: ldc_w 702
    //   2735: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2738: ldc_w 780
    //   2741: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: ldc_w 706
    //   2747: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: ldc_w 708
    //   2753: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: ldc_w 702
    //   2759: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2762: iconst_2
    //   2763: invokevirtual 711	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2766: ldc_w 667
    //   2769: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2772: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2775: aconst_null
    //   2776: invokevirtual 787	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2779: pop
    //   2780: aload 11
    //   2782: ifnull +10 -> 2792
    //   2785: aload 11
    //   2787: invokeinterface 715 1 0
    //   2792: iconst_1
    //   2793: ireturn
    //   2794: aload 13
    //   2796: invokevirtual 739	android/content/ContentValues:clear	()V
    //   2799: aload 13
    //   2801: ldc_w 669
    //   2804: lload 6
    //   2806: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2809: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2812: aload 13
    //   2814: ldc_w 673
    //   2817: ldc_w 760
    //   2820: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2823: aload 13
    //   2825: ldc_w 762
    //   2828: aload 15
    //   2830: getfield 755	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2833: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2836: aload 13
    //   2838: ldc_w 708
    //   2841: iconst_1
    //   2842: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2845: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2848: aload_0
    //   2849: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2852: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2855: aload 13
    //   2857: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2860: pop
    //   2861: goto -1300 -> 1561
    //   2864: astore 12
    //   2866: aload 11
    //   2868: ifnull -1295 -> 1573
    //   2871: aload 11
    //   2873: invokeinterface 715 1 0
    //   2878: goto -1305 -> 1573
    //   2881: astore_1
    //   2882: aload 11
    //   2884: ifnull +10 -> 2894
    //   2887: aload 11
    //   2889: invokeinterface 715 1 0
    //   2894: aload_1
    //   2895: athrow
    //   2896: aload 13
    //   2898: invokevirtual 739	android/content/ContentValues:clear	()V
    //   2901: aload 13
    //   2903: ldc_w 669
    //   2906: lload 6
    //   2908: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2911: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2914: aload 13
    //   2916: ldc_w 673
    //   2919: ldc_w 760
    //   2922: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2925: aload 13
    //   2927: ldc_w 675
    //   2930: aload 15
    //   2932: getfield 758	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2935: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2938: aload 13
    //   2940: ldc_w 708
    //   2943: iconst_1
    //   2944: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2947: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2950: aload_0
    //   2951: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2954: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2957: aload 13
    //   2959: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2962: pop
    //   2963: goto -1104 -> 1859
    //   2966: astore 12
    //   2968: aload 11
    //   2970: ifnull -1099 -> 1871
    //   2973: aload 11
    //   2975: invokeinterface 715 1 0
    //   2980: goto -1109 -> 1871
    //   2983: astore_1
    //   2984: aload 11
    //   2986: ifnull +10 -> 2996
    //   2989: aload 11
    //   2991: invokeinterface 715 1 0
    //   2996: aload_1
    //   2997: athrow
    //   2998: aload 13
    //   3000: invokevirtual 739	android/content/ContentValues:clear	()V
    //   3003: aload 13
    //   3005: ldc_w 669
    //   3008: lload 6
    //   3010: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3013: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3016: aload 13
    //   3018: ldc_w 673
    //   3021: ldc_w 704
    //   3024: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3027: aload 13
    //   3029: ldc_w 675
    //   3032: aload 15
    //   3034: getfield 773	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   3037: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3040: aload 13
    //   3042: ldc_w 708
    //   3045: iconst_3
    //   3046: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3049: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3052: aload_0
    //   3053: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3056: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3059: aload 13
    //   3061: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3064: pop
    //   3065: goto -895 -> 2170
    //   3068: astore 12
    //   3070: aload 11
    //   3072: ifnull -890 -> 2182
    //   3075: aload 11
    //   3077: invokeinterface 715 1 0
    //   3082: goto -900 -> 2182
    //   3085: astore_1
    //   3086: aload 11
    //   3088: ifnull +10 -> 3098
    //   3091: aload 11
    //   3093: invokeinterface 715 1 0
    //   3098: aload_1
    //   3099: athrow
    //   3100: aload 13
    //   3102: invokevirtual 739	android/content/ContentValues:clear	()V
    //   3105: aload 13
    //   3107: ldc_w 669
    //   3110: lload 6
    //   3112: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3115: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3118: aload 13
    //   3120: ldc_w 673
    //   3123: ldc_w 778
    //   3126: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3129: aload 13
    //   3131: ldc_w 675
    //   3134: aload 15
    //   3136: getfield 776	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   3139: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3142: aload 13
    //   3144: ldc_w 708
    //   3147: iconst_2
    //   3148: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3151: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3154: aload_0
    //   3155: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3158: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3161: aload 13
    //   3163: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3166: pop
    //   3167: goto -686 -> 2481
    //   3170: astore 12
    //   3172: aload 11
    //   3174: ifnull -681 -> 2493
    //   3177: aload 11
    //   3179: invokeinterface 715 1 0
    //   3184: goto -691 -> 2493
    //   3187: astore_1
    //   3188: aload 11
    //   3190: ifnull +10 -> 3200
    //   3193: aload 11
    //   3195: invokeinterface 715 1 0
    //   3200: aload_1
    //   3201: athrow
    //   3202: aload 13
    //   3204: invokevirtual 739	android/content/ContentValues:clear	()V
    //   3207: aload 13
    //   3209: ldc_w 669
    //   3212: lload 6
    //   3214: invokestatic 743	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3217: invokevirtual 747	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3220: aload 13
    //   3222: ldc_w 673
    //   3225: ldc_w 780
    //   3228: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3231: aload 13
    //   3233: ldc_w 675
    //   3236: aload_1
    //   3237: invokevirtual 752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3240: aload 13
    //   3242: ldc_w 708
    //   3245: iconst_2
    //   3246: invokestatic 767	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3249: invokevirtual 770	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3252: aload_0
    //   3253: invokevirtual 657	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3256: getstatic 663	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3259: aload 13
    //   3261: invokevirtual 730	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3264: pop
    //   3265: goto -485 -> 2780
    //   3268: astore_1
    //   3269: aload 11
    //   3271: ifnull -479 -> 2792
    //   3274: aload 11
    //   3276: invokeinterface 715 1 0
    //   3281: goto -489 -> 2792
    //   3284: astore_1
    //   3285: aload 11
    //   3287: ifnull +10 -> 3297
    //   3290: aload 11
    //   3292: invokeinterface 715 1 0
    //   3297: aload_1
    //   3298: athrow
    //   3299: iconst_m1
    //   3300: ireturn
    //   3301: astore_1
    //   3302: goto -17 -> 3285
    //   3305: astore_1
    //   3306: aconst_null
    //   3307: astore 11
    //   3309: goto -40 -> 3269
    //   3312: astore_1
    //   3313: goto -125 -> 3188
    //   3316: astore 11
    //   3318: aconst_null
    //   3319: astore 11
    //   3321: goto -149 -> 3172
    //   3324: astore_1
    //   3325: goto -239 -> 3086
    //   3328: astore 11
    //   3330: aconst_null
    //   3331: astore 11
    //   3333: goto -263 -> 3070
    //   3336: astore_1
    //   3337: goto -353 -> 2984
    //   3340: astore 11
    //   3342: aconst_null
    //   3343: astore 11
    //   3345: goto -377 -> 2968
    //   3348: astore_1
    //   3349: goto -467 -> 2882
    //   3352: astore 11
    //   3354: aconst_null
    //   3355: astore 11
    //   3357: goto -491 -> 2866
    //   3360: astore 12
    //   3362: aload 11
    //   3364: astore_1
    //   3365: aload 12
    //   3367: astore 11
    //   3369: goto -2266 -> 1103
    //   3372: astore 11
    //   3374: aconst_null
    //   3375: astore 11
    //   3377: iconst_0
    //   3378: istore_3
    //   3379: lconst_0
    //   3380: lstore 6
    //   3382: goto -2349 -> 1033
    //   3385: astore 13
    //   3387: lload 8
    //   3389: lstore 6
    //   3391: goto -2358 -> 1033
    //   3394: astore 13
    //   3396: iconst_1
    //   3397: istore_3
    //   3398: lload 8
    //   3400: lstore 6
    //   3402: goto -2369 -> 1033
    //   3405: astore 16
    //   3407: aload 13
    //   3409: astore 14
    //   3411: aload 16
    //   3413: astore 13
    //   3415: goto -2355 -> 1060
    //   3418: astore 16
    //   3420: aload 13
    //   3422: astore 14
    //   3424: iconst_1
    //   3425: istore_2
    //   3426: aload 16
    //   3428: astore 13
    //   3430: goto -2370 -> 1060
    //   3433: astore 14
    //   3435: goto -2429 -> 1006
    //   3438: astore 14
    //   3440: goto -2434 -> 1006
    //   3443: lload 8
    //   3445: lstore 6
    //   3447: iload 5
    //   3449: istore_3
    //   3450: iload 4
    //   3452: istore_2
    //   3453: goto -3006 -> 447
    //   3456: iconst_1
    //   3457: istore_2
    //   3458: iconst_1
    //   3459: istore_3
    //   3460: goto -3035 -> 425
    //   3463: lload 8
    //   3465: lstore 6
    //   3467: goto -3042 -> 425
    //   3470: aconst_null
    //   3471: astore 12
    //   3473: goto -3393 -> 80
    //   3476: aconst_null
    //   3477: astore 15
    //   3479: goto -3432 -> 47
    //   3482: iload_3
    //   3483: istore_2
    //   3484: iconst_1
    //   3485: istore_3
    //   3486: lload 6
    //   3488: lstore 8
    //   3490: goto -3313 -> 177
    //   3493: astore 13
    //   3495: aconst_null
    //   3496: astore 13
    //   3498: goto -2492 -> 1006
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3501	0	this	ProfileCardMoreActivity
    //   0	3501	1	paramString	String
    //   81	3403	2	i	int
    //   170	3316	3	j	int
    //   83	3368	4	k	int
    //   426	3022	5	m	int
    //   204	3283	6	l1	long
    //   172	3317	8	l2	long
    //   189	209	10	bool	boolean
    //   26	1023	11	localObject1	Object
    //   1098	16	11	localObject2	Object
    //   1284	2024	11	localObject3	Object
    //   3316	1	11	localException1	Exception
    //   3319	1	11	localObject4	Object
    //   3328	1	11	localException2	Exception
    //   3331	1	11	localObject5	Object
    //   3340	1	11	localException3	Exception
    //   3343	1	11	localObject6	Object
    //   3352	1	11	localException4	Exception
    //   3355	13	11	localObject7	Object
    //   3372	1	11	localException5	Exception
    //   3375	1	11	localObject8	Object
    //   78	2552	12	localObject9	Object
    //   2864	1	12	localException6	Exception
    //   2966	1	12	localException7	Exception
    //   3068	1	12	localException8	Exception
    //   3170	1	12	localException9	Exception
    //   3360	6	12	localObject10	Object
    //   3471	1	12	localObject11	Object
    //   86	930	13	localObject12	Object
    //   1027	1	13	localException10	Exception
    //   1058	21	13	localObject13	Object
    //   1081	2179	13	localException11	Exception
    //   3385	1	13	localException12	Exception
    //   3394	14	13	localException13	Exception
    //   3413	16	13	localObject14	Object
    //   3493	1	13	localException14	Exception
    //   3496	1	13	localObject15	Object
    //   126	3297	14	localObject16	Object
    //   3433	1	14	localException15	Exception
    //   3438	1	14	localException16	Exception
    //   45	3433	15	localObject17	Object
    //   97	2185	16	localObject18	Object
    //   3405	7	16	localObject19	Object
    //   3418	9	16	localObject20	Object
    //   228	109	17	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   417	425	1027	java/lang/Exception
    //   994	1001	1027	java/lang/Exception
    //   1015	1022	1027	java/lang/Exception
    //   224	383	1058	finally
    //   209	216	1081	java/lang/Exception
    //   1068	1075	1081	java/lang/Exception
    //   1078	1081	1081	java/lang/Exception
    //   88	169	1098	finally
    //   1423	1561	2864	java/lang/Exception
    //   2794	2861	2864	java/lang/Exception
    //   1286	1419	2881	finally
    //   1721	1859	2966	java/lang/Exception
    //   2896	2963	2966	java/lang/Exception
    //   1584	1717	2983	finally
    //   2019	2170	3068	java/lang/Exception
    //   2998	3065	3068	java/lang/Exception
    //   1882	2015	3085	finally
    //   2330	2481	3170	java/lang/Exception
    //   3100	3167	3170	java/lang/Exception
    //   2193	2326	3187	finally
    //   2633	2780	3268	java/lang/Exception
    //   3202	3265	3268	java/lang/Exception
    //   2496	2629	3284	finally
    //   2633	2780	3301	finally
    //   3202	3265	3301	finally
    //   2496	2629	3305	java/lang/Exception
    //   2330	2481	3312	finally
    //   3100	3167	3312	finally
    //   2193	2326	3316	java/lang/Exception
    //   2019	2170	3324	finally
    //   2998	3065	3324	finally
    //   1882	2015	3328	java/lang/Exception
    //   1721	1859	3336	finally
    //   2896	2963	3336	finally
    //   1584	1717	3340	java/lang/Exception
    //   1423	1561	3348	finally
    //   2794	2861	3348	finally
    //   1286	1419	3352	java/lang/Exception
    //   182	191	3360	finally
    //   196	206	3360	finally
    //   209	216	3360	finally
    //   417	425	3360	finally
    //   994	1001	3360	finally
    //   1015	1022	3360	finally
    //   1068	1075	3360	finally
    //   1078	1081	3360	finally
    //   88	169	3372	java/lang/Exception
    //   182	191	3385	java/lang/Exception
    //   196	206	3394	java/lang/Exception
    //   388	397	3405	finally
    //   406	413	3418	finally
    //   388	397	3433	java/lang/Exception
    //   406	413	3438	java/lang/Exception
    //   224	383	3493	java/lang/Exception
  }
  
  public void bJs()
  {
    if ((this.B != null) && (this.B.isShowing())) {}
    try
    {
      this.B.cancel();
      this.B = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void bPf()
  {
    if (this.B == null)
    {
      this.B = new arhz(this, getTitleBarHeight());
      this.B.setMessage(2131719519);
    }
    this.B.show();
  }
  
  public void bSA()
  {
    this.ax.setChecked(this.mIsShield);
    if (this.mIsShield)
    {
      this.t.setVisibility(8);
      this.aw.setVisibility(8);
    }
    while ((!ProfileActivity.AllInOne.b(this.e)) || (aqft.rj(this.e.uin))) {
      return;
    }
    this.t.setVisibility(0);
    this.aw.setVisibility(0);
  }
  
  public void bSB()
  {
    if (!this.aZf)
    {
      this.aZf = true;
      ThreadManager.getFileThreadHandler().post(new ProfileCardMoreActivity.13(this));
    }
  }
  
  protected void bSC()
  {
    Object localObject1 = (acff)this.app.getManager(51);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label148;
      }
    }
    label143:
    label148:
    for (localObject1 = ((Card)localObject1).strReMark;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        localObject2 = localObject1;
        if (this.e.pa == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label143;
          }
        }
      }
      for (Object localObject2 = ((ProfileActivity.CardContactInfo)localObject1).aOL;; localObject2 = null)
      {
        this.aOQ = ((String)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.i("IphoneTitleBarActivity", 4, "initRemark, " + this.aOQ);
        }
        return;
        localObject1 = ((acff)localObject1).b(this.e.uin);
        break;
      }
    }
  }
  
  public void bSD()
  {
    String str1 = this.e.troopcode;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.e.discussUin;
    }
    for (;;)
    {
      String str2;
      Object localObject1;
      int i;
      if (ProfileActivity.AllInOne.b(this.e))
      {
        str2 = "1";
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.e.ae != null)
        {
          localObject1 = localObject2;
          if (this.e.ae.containsKey("chatuin"))
          {
            localObject1 = localObject2;
            if (this.e.ae.containsKey("chattype")) {
              localObject1 = this.e.ae;
            }
          }
        }
        if (this.e.pa != 96) {
          break label302;
        }
        i = 20005;
      }
      label302:
      label489:
      for (;;)
      {
        label119:
        if ((i == 20005) || (i == 20015) || (i == 25020)) {
          stj.a(this, this.e.uin, stj.encrypt(this.e.uin, stj.cm(2)), str2, null, this.app.getCurrentAccountUin(), i, null, (Bundle)localObject1);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("profile-report [%s, %s, %s, %s, %s, %s]", new Object[] { this.e.uin, Integer.valueOf(this.e.pa), Integer.valueOf(i), str2, str1, localObject1 }));
          }
          anot.a(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.eP(this.e.bJa), 0, Integer.toString(ProfileActivity.a(this.e)), "", "", "");
          return;
          str2 = "0";
          break;
          int j;
          if (ProfileActivity.gk(this.e.pa))
          {
            j = 20008;
            i = j;
            if (localObject1 != null) {
              break label489;
            }
            localObject1 = stj.b(this.e.troopcode, 1);
            i = j;
            break label119;
          }
          if (ProfileActivity.gj(this.e.pa))
          {
            j = 20013;
            i = j;
            if (localObject1 != null) {
              break label489;
            }
            localObject1 = stj.b(this.e.discussUin, 3000);
            i = j;
            break label119;
          }
          if (localObject1 != null)
          {
            if (((Bundle)localObject1).containsKey("chattype"))
            {
              i = stj.es(((Bundle)localObject1).getInt("chattype"));
              break label119;
            }
            if (ProfileActivity.AllInOne.b(this.e))
            {
              i = 21000;
              break label119;
            }
            i = 20002;
            break label119;
          }
          if (ProfileActivity.AllInOne.b(this.e))
          {
            i = 21001;
            break label119;
          }
          i = 20001;
          break label119;
          stj.a(this, this.e.uin, null, str2, str1, this.app.getAccount(), i, null, (Bundle)localObject1);
        }
      }
    }
  }
  
  void bSy()
  {
    this.fx = new int[18];
    int i = 0;
    while (i < 18)
    {
      this.fx[i] = 0;
      i += 1;
    }
    if (this.app.getCurrentUin().equals(this.e.uin))
    {
      this.fx[1] = 1;
      this.fx[15] = 1;
      this.fx[16] = 1;
      this.fx[17] = 1;
    }
    for (;;)
    {
      if ("troopMembercard".equals(this.from)) {
        this.fx[4] = 0;
      }
      return;
      if (ProfileActivity.AllInOne.b(this.e))
      {
        this.fx[1] = 1;
        if (aqft.rj(this.e.uin))
        {
          this.fx[2] = 1;
          this.fx[11] = 1;
          this.fx[13] = 1;
        }
        else
        {
          this.fx[0] = 1;
          if ((jou.df(this.e.uin)) || (asgx.ag(this.app, this.e.uin)))
          {
            i = 1;
            label197:
            if (i != 0)
            {
              if (!((asgx)this.app.getManager(165)).sH(this.e.uin)) {
                break label337;
              }
              this.fx[3] = 0;
            }
          }
          for (;;)
          {
            this.fx[4] = 1;
            if (i == 0)
            {
              this.fx[5] = 1;
              this.fx[10] = 1;
            }
            this.fx[6] = 1;
            this.fx[7] = 1;
            if (ajok.nx(this.app.getCurrentUin())) {
              this.fx[8] = 1;
            }
            this.fx[9] = 1;
            this.fx[12] = 1;
            this.fx[13] = 1;
            this.fx[14] = 1;
            break;
            i = 0;
            break label197;
            label337:
            this.fx[3] = 1;
          }
        }
      }
      else if ((this.e.pa == 21) || (this.e.pa == 22) || (this.e.pa == 46) || (this.e.pa == 47) || (this.e.pa == 3) || (this.e.pa == 2) || (this.e.pa == 74))
      {
        this.fx[12] = 1;
        this.fx[14] = 1;
      }
      else if ((this.e.pa == 41) || (this.e.pa == 42) || (this.e.pa == 86) || (this.e.pa == 56) || (this.e.pa == 57) || (this.e.pa == 58))
      {
        this.fx[12] = 1;
        this.fx[14] = 1;
      }
      else if ((this.e.pa == 32) || (this.e.pa == 31) || (this.e.pa == 50) || (this.e.pa == 51) || (this.e.pa == 34))
      {
        this.fx[12] = 1;
        this.fx[14] = 1;
      }
      else if ((this.e.pa == 71) || (this.e.pa == 72) || (this.e.pa == 27))
      {
        this.fx[12] = 1;
        this.fx[14] = 1;
      }
      else if (this.e.pa == 96)
      {
        this.fx[12] = 1;
        this.fx[14] = 1;
      }
      else if (this.e.pa == 78)
      {
        this.fx[14] = 1;
      }
      else if (this.e.pa == 95)
      {
        this.fx[14] = 1;
      }
      else if (ProfileActivity.AllInOne.a(this.e))
      {
        this.fx[14] = 1;
      }
    }
  }
  
  void bSz()
  {
    Object localObject = (acff)this.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((acff)localObject).e(this.e.uin))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.e.uin).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).create(getTitleBarHeight()).show();
  }
  
  void d(Card paramCard)
  {
    if (this.jdField_a_of_type_Vbv != null) {
      this.jdField_a_of_type_Vbv.d(paramCard);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.EC != null) && (this.EC.getVisibility() == 0)) {
      this.EC.setVisibility(8);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt2 == -1) {}
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("result");
        bool = paramIntent.getBooleanExtra("hasChange", false);
      }
      break;
    }
    for (paramIntent = (Intent)localObject;; paramIntent = (Intent)localObject)
    {
      if (paramIntent == null) {
        paramIntent = "";
      }
      for (;;)
      {
        if (aqiw.isNetSupport(BaseApplication.getContext()))
        {
          if ((!bool) && (paramIntent.equals(this.mNickName))) {
            break;
          }
          if (!paramIntent.equals(this.aOO))
          {
            localObject = (FriendListHandler)this.app.getBusinessHandler(1);
            if (localObject != null)
            {
              ((FriendListHandler)localObject).C(this.e.uin, paramIntent, false);
              this.bFB |= 0x1;
              vx(paramIntent);
              paramIntent = new awcy.a();
              paramIntent.cmd = 5;
              awcy.a(this.e.uin).a(paramIntent);
              return;
            }
            cf(2131694914, 1);
            return;
          }
          cf(2131694895, 0);
          return;
        }
        cf(2131696346, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131720735));
        localObject = wja.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
        if (this.jdField_a_of_type_Vbv == null) {
          break;
        }
        this.jdField_a_of_type_Vbv.E(paramInt2, paramIntent);
        return;
        if (paramIntent == null) {
          break;
        }
        C(paramInt2, paramIntent);
        return;
      }
      bool = false;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.e = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
    this.from = getIntent().getStringExtra("from");
    this.mNickName = getIntent().getStringExtra("key_nick_name");
    if ((this.e == null) || (TextUtils.isEmpty(this.e.uin)))
    {
      super.finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, String.format("check params [%s, %s, %s]", new Object[] { Integer.valueOf(this.e.pa), this.e.uin, this.e.ae }));
    }
    try
    {
      bSy();
      initUI();
      this.jdField_a_of_type_Vbv = new vbv(this, this);
      this.jdField_a_of_type_Vbv.bHA = getIntent().getIntExtra("coverTimeStamp", 0);
      this.jdField_a_of_type_Vbv.mCoverUrl = getIntent().getStringExtra("coverUrl");
      this.d = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.d == null) {
        this.d = new ProfileActivity.AllInOne(this.app.getCurrentUin(), 0);
      }
      this.jdField_a_of_type_Adyp = ((adyp)this.app.getManager(112));
      addObserver(this.jdField_a_of_type_Achq);
      addObserver(this.jdField_b_of_type_Aclp);
      addObserver(this.cardObserver);
      addObserver(this.c);
      addObserver(this.jdField_a_of_type_Ahpp);
      this.app.registObserver(this.jdField_a_of_type_Adyq);
      this.app.setHandler(ProfileCardMoreActivity.class, this.jdField_b_of_type_MqqOsMqqHandler);
      if ((this.aOQ == null) || (ProfileActivity.AllInOne.b(this.e))) {
        ThreadManager.excute(new ProfileCardMoreActivity.1(this), 16, null, true);
      }
      abby.bP(this.app);
      return true;
    }
    catch (NoSuchFieldError paramBundle)
    {
      for (;;)
      {
        super.finish();
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Vbv != null)
    {
      this.jdField_a_of_type_Vbv.destroy();
      this.jdField_a_of_type_Vbv = null;
    }
    bJs();
    removeObserver(this.jdField_a_of_type_Achq);
    removeObserver(this.jdField_b_of_type_Aclp);
    removeObserver(this.cardObserver);
    removeObserver(this.c);
    removeObserver(this.jdField_a_of_type_Ahpp);
    this.app.unRegistObserver(this.jdField_a_of_type_Adyq);
    this.app.removeHandler(ProfileCardMoreActivity.class);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Vbv != null)) {
      this.jdField_a_of_type_Vbv.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((acff)this.app.getManager(51)).a(this.e.uin);
    if (this.t.getVisibility() == 0)
    {
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label67;
      }
      this.t.setRightText(getString(2131719368));
    }
    for (;;)
    {
      bSx();
      return;
      label67:
      this.t.setRightText(getString(2131719369));
    }
  }
  
  public void fi(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (PH()) {
      localIntent.putExtra("param_switches_changed", true);
    }
    if (this.jdField_aa_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_aa_of_type_AndroidOsBundle);
    }
    if ((this.jdField_a_of_type_Vbv != null) && (this.jdField_a_of_type_Vbv.aXf))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Vbv.ca);
    }
    if (!TextUtils.isEmpty(this.aOO))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileFragment", 2, "finish putExtra mStrRemark: " + this.aOO);
      }
      localIntent.putExtra("remark", this.aOO);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  void fj(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(aqfe.get(this, "bc_remark_first"))) {}
    while ((this.h == null) || (this.h.getVisibility() == 8)) {
      return;
    }
    if (this.EC == null) {
      this.EC = ((TextView)findViewById(2131366161));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = wja.dp2px(10.0F, getResources()))
    {
      int i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, i, 0, 0);
      this.EC.setLayoutParams(localLayoutParams);
      this.EC.setVisibility(0);
      aqfe.J(this, "bc_remark_first", "false");
      return;
    }
  }
  
  void initUI()
  {
    setContentViewB(2131561566);
    Object localObject1;
    label97:
    int i;
    label129:
    int j;
    int k;
    if ("troopMembercard".equals(this.from))
    {
      setTitle(acfp.m(2131709916));
      if (this.mLeftBackText != null)
      {
        this.mLeftBackText.setText("");
        this.mLeftBackText.setContentDescription(acfp.m(2131709926));
      }
      enableRightHighlight(false);
      localObject1 = findViewById(2131365699);
      if (this.fx[13] != 1) {
        break label180;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131378811);
      if (this.fx[14] != 1) {
        break label190;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      i = 0;
      j = -1;
      k = -1;
      label135:
      if (i > 3) {
        break label200;
      }
      if (this.fx[i] != 1) {
        break label1239;
      }
      if (k >= 0) {
        break label1236;
      }
      k = i;
      label156:
      if (j >= i) {
        break label1233;
      }
      j = i;
    }
    label180:
    label190:
    label200:
    label470:
    label1239:
    for (;;)
    {
      i += 1;
      break label135;
      setTitle(2131697309);
      break;
      ((View)localObject1).setVisibility(8);
      break label97;
      ((View)localObject1).setVisibility(8);
      break label129;
      this.h = ((FormItemRelativeLayout)findViewById(2131369526));
      this.h.setBGType(1);
      this.EB = ((TextView)findViewById(2131377106));
      a(0, this.h, k, j);
      this.Y = ((FormSimpleItem)findViewById(2131369419));
      a(1, this.Y, k, j);
      this.Z = ((FormSimpleItem)findViewById(2131369541));
      a(2, this.Z, k, j);
      this.ab = ((FormSimpleItem)findViewById(2131369411));
      a(3, this.ab, k, j);
      this.jdField_aa_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369490));
      a(4, this.jdField_aa_of_type_ComTencentMobileqqWidgetFormSimpleItem, 4, 4);
      if (this.app.getCurrentUin().equals(this.e.uin))
      {
        this.jdField_aa_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(acfp.m(2131709949));
        this.ad = ((FormSimpleItem)findViewById(2131369414));
        a(15, this.ad, 4, 4);
        this.ae = ((FormSimpleItem)findViewById(2131369425));
        a(16, this.ae, 4, 4);
        d(null);
        this.af = ((FormSimpleItem)findViewById(2131369487));
        a(17, this.af, 4, 4);
        i = 6;
        j = -1;
        k = -1;
        if (i > 12) {
          break label532;
        }
        if (this.fx[i] != 1) {
          break label1230;
        }
        if (k >= 0) {
          break label1227;
        }
        k = i;
        label492:
        if (j >= i) {
          break label1224;
        }
        j = i;
      }
      for (;;)
      {
        i += 1;
        break label470;
        if (!ProfileActivity.AllInOne.b(this.e)) {
          break;
        }
        this.jdField_aa_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(acfp.m(2131709938));
        break;
        this.t = ((FormSimpleItem)findViewById(2131378611));
        a(7, this.t, k, j);
        this.ac = ((FormSimpleItem)findViewById(2131369456));
        this.ay = ((FormSwitchItem)findViewById(2131378078));
        a(10, this.ay, k, j);
        this.aw = ((FormSwitchItem)findViewById(2131378081));
        a(9, this.aw, k, j);
        this.az = ((FormSwitchItem)findViewById(2131372036));
        a(11, this.az, k, j);
        this.ax = ((FormSwitchItem)findViewById(2131378084));
        a(12, this.ax, k, j);
        acff localacff;
        boolean bool;
        if (ProfileActivity.AllInOne.b(this.e))
        {
          localacff = (acff)this.app.getManager(51);
          if (localacff == null)
          {
            localObject1 = null;
            Object localObject2;
            if (localObject1 != null)
            {
              this.aOO = ((Friends)localObject1).remark;
              this.aOQ = this.aOO;
              localObject2 = localacff.a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!aqft.equalsWithNullCheck(this.aOP, ((Groups)localObject2).group_name))) {
                this.aOP = ((Groups)localObject2).group_name;
              }
              if (((Friends)localObject1).gathtertype == 1)
              {
                this.ay.setOnCheckedChangeListener(null);
                this.ay.setChecked(true);
                this.ay.setOnCheckedChangeListener(this);
              }
            }
            if (this.Y.getVisibility() == 0)
            {
              localObject2 = this.Y;
              if (!TextUtils.isEmpty(this.aOP)) {
                break label1163;
              }
              localObject1 = "";
              ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            }
            if (this.h.getVisibility() == 0)
            {
              a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
              this.h.post(new ProfileCardMoreActivity.2(this));
            }
            if (this.az.getVisibility() == 0)
            {
              if (localacff != null) {
                break label1172;
              }
              localObject1 = null;
              localObject2 = this.az;
              if ((localObject1 == null) || (!((Card)localObject1).babyQSwitch)) {
                break label1185;
              }
              bool = true;
              ((FormSwitchItem)localObject2).setChecked(bool);
              ((CardHandler)this.app.getBusinessHandler(2)).cHJ();
            }
            if (this.ax.getVisibility() == 0)
            {
              if ((localacff == null) || (TextUtils.isEmpty(this.e.uin))) {
                break label1191;
              }
              this.mIsShield = localacff.ke(this.e.uin);
              label983:
              bSA();
            }
            if ((localacff != null) && (localacff.isFriend(this.e.uin))) {
              bKO();
            }
          }
        }
        for (;;)
        {
          if (AppSetting.enableTalkBack)
          {
            this.ay.setContentDescription(getString(2131719555));
            this.ay.setFocusable(true);
            this.t.setContentDescription(getString(2131717467));
            this.ac.setContentDescription(getString(2131697240));
            this.jdField_aa_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(acfp.m(2131709899));
            this.aw.setContentDescription(getString(2131691044));
            this.aw.setFocusable(true);
            this.ax.setContentDescription(acfp.m(2131709909));
            this.ax.setFocusable(true);
            this.az.setContentDescription(getString(2131697333));
            this.az.setFocusable(true);
          }
          return;
          localObject1 = localacff.e(this.e.uin);
          break;
          localObject1 = this.aOP;
          break label837;
          localObject1 = localacff.c(acbn.blz);
          break label896;
          bool = false;
          break label918;
          this.mIsShield = false;
          break label983;
          if (this.ax.getVisibility() == 0)
          {
            this.mIsShield = PE();
            bSA();
          }
        }
        continue;
        break label492;
      }
      continue;
      break label156;
    }
  }
  
  public String oP()
  {
    Object localObject = null;
    try
    {
      String str = aqgv.x(this.app, this.aON);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    int i = 1;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    if (paramCompoundButton == this.ax.a())
    {
      localObject1 = this.app;
      if (paramBoolean)
      {
        i = 1;
        anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, i, "0", "0", "", "");
        if (this.mIsShield != paramBoolean) {
          break label92;
        }
      }
    }
    label92:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i = 2;
        break;
        if (ProfileActivity.AllInOne.b(this.e))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            xN(bool1);
            break;
            bool1 = false;
          }
        }
        if (!paramBoolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          shieldMsg(bool1);
          break;
        }
        if (paramCompoundButton != this.ay.a()) {
          break label332;
        }
        if (!aqiw.isNetSupport(BaseApplication.getContext())) {
          break label278;
        }
        localObject1 = (FriendListHandler)this.app.getBusinessHandler(1);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(this.e.uin);
        ((FriendListHandler)localObject1).a((short)1, (List)localObject2, paramBoolean);
        if (paramBoolean) {
          anot.a(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
        } else {
          anot.a(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
        }
      }
      cf(2131693404, 1);
      this.ay.setOnCheckedChangeListener(null);
      localObject1 = this.ay;
      if (!paramBoolean) {}
      for (bool1 = bool3;; bool1 = false)
      {
        ((FormSwitchItem)localObject1).setChecked(bool1);
        this.ay.setOnCheckedChangeListener(this);
        break;
      }
      if (paramCompoundButton == this.az.a())
      {
        if (aqiw.isNetSupport(BaseApplication.getContext()))
        {
          ((CardHandler)this.app.getBusinessHandler(2)).EC(paramBoolean);
          localObject1 = this.app;
          if (paramBoolean) {}
          for (;;)
          {
            anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(i), "", "", "");
            break;
            i = 0;
          }
        }
        cf(2131693404, 1);
        this.az.setOnCheckedChangeListener(null);
        localObject1 = this.az;
        if (!paramBoolean) {}
        for (bool1 = bool4;; bool1 = false)
        {
          ((FormSwitchItem)localObject1).setChecked(bool1);
          this.az.setOnCheckedChangeListener(this);
          break;
        }
      }
    } while ((this.aw == null) || (this.aw.a() != paramCompoundButton));
    label278:
    label332:
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      this.aw.setOnCheckedChangeListener(null);
      localObject1 = this.aw;
      if (!paramCompoundButton.isChecked()) {}
      for (bool1 = bool5;; bool1 = false)
      {
        ((FormSwitchItem)localObject1).setChecked(bool1);
        this.aw.setOnCheckedChangeListener(this);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
    }
    Object localObject1 = this.app;
    Object localObject2 = this.e.uin;
    long l;
    if (paramCompoundButton.isChecked())
    {
      l = anaz.gQ();
      label613:
      FriendsStatusUtil.b((QQAppInterface)localObject1, (String)localObject2, 0, l, true, false);
      localObject1 = this.app;
      if (!paramCompoundButton.isChecked()) {
        break label679;
      }
    }
    label679:
    for (i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, i, "0", "0", "", "");
      break;
      l = 0L;
      break label613;
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null)
    {
      i = 0;
      switch (i)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, "case default do nothing");
        }
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = paramView.getId();
      break;
      aqep.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.e);
      anot.a(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.eP(this.e.bJa), 0, Integer.toString(ProfileActivity.a(this.e)), "", "", "");
      anot.a(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
      continue;
      bSz();
      anot.a(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.eP(this.e.bJa), 0, Integer.toString(ProfileActivity.a(this.e)), "", "", "");
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.WRITE_CONTACTS") != 0) {
          requestPermissions(new vmg(this, this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        } else {
          bSB();
        }
      }
      else
      {
        bSB();
        continue;
        String str1;
        if (((asgx)this.app.getManager(165)).sM(this.e.uin))
        {
          if (TextUtils.isEmpty(this.e.nickname)) {
            this.e.nickname = aqgv.n(this.app, this.e.uin);
          }
          String str2 = getIntent().getStringExtra("key_nick_name");
          str1 = str2;
          if (str2 == null) {
            str1 = this.e.nickname;
          }
          x(this.e.uin, str1, 14);
        }
        for (;;)
        {
          anot.a(null, "dc00898", "", "", "0X800A4FC", "0X800A4FC", 0, 0, "", "0", "0", "");
          break;
          if (this.jdField_a_of_type_Alcp == null) {
            this.jdField_a_of_type_Alcp = new alcp(this, this.app, 0, new vmh(this));
          }
          if (TextUtils.isEmpty(this.e.nickname)) {
            this.e.nickname = aqgv.n(this.app, this.e.uin);
          }
          this.jdField_a_of_type_Alcp.gW(this.e.uin, this.e.nickname);
        }
        label625:
        avpw.d locald;
        for (;;)
        {
          try
          {
            if (this.e == null) {
              break label625;
            }
            str1 = this.e.uin;
            vT(str1);
          }
          catch (Exception localException1) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("IphoneTitleBarActivity", 2, localException1, new Object[0]);
          break;
          locald = null;
        }
        bSD();
        continue;
        try
        {
          locald = avpw.d.a();
          locald.cMP = this.app.getCurrentAccountUin();
          locald.nickname = this.app.getCurrentNickname();
          avpw.a(this, locald, Long.valueOf(this.e.uin).longValue(), -1);
          anot.a(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.eP(this.e.bJa), 0, Integer.toString(ProfileActivity.a(this.e)), "", "", "");
        }
        catch (Exception localException2) {}
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, localException2.toString());
          continue;
          abby.m(this, this.e.uin, 3);
          anot.a(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
          continue;
          anot.a(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
          Object localObject = ((acff)this.app.getManager(51)).a(this.e.uin);
          if (localObject != null) {
            if ((((ExtensionInfo)localObject).intimate_type == 2) || (((ExtensionInfo)localObject).intimate_type == 3) || (((ExtensionInfo)localObject).intimate_type == 1))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("FORWARD_PEER_UIN", this.e.uin);
              PublicFragmentActivity.b.start(this, (Intent)localObject, PublicFragmentActivity.class, IntimateInfoFragment.class);
              if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "jumpIntimatePage");
              }
            }
            else
            {
              localObject = ajok.mn(this.e.uin);
              if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "click item_friend_intimate url:" + (String)localObject);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject));
                continue;
                localObject = new Intent(this, AvatarPendantActivity.class);
                ((Intent)localObject).putExtra("AllInOne", this.d);
                ((Intent)localObject).putExtra("showActionSheet", true);
                startActivity((Intent)localObject);
                anot.a(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
                continue;
                if (this.jdField_a_of_type_Vbv != null)
                {
                  localObject = this.jdField_a_of_type_Vbv;
                  if (this.jdField_a_of_type_Vbv.bHA != 0) {
                    break label1161;
                  }
                }
                label1161:
                for (boolean bool = true;; bool = false)
                {
                  ((vbv)localObject).xr(bool);
                  anot.a(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
                  break;
                }
                bPo();
                anot.a(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
    }
  }
  
  void shieldMsg(boolean paramBoolean)
  {
    boolean bool = true;
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      aizg localaizg = (aizg)this.app.getManager(16);
      if (localaizg != null) {}
      for (;;)
      {
        int i;
        try
        {
          Object localObject = this.e.uin;
          if (ProfileActivity.AllInOne.i(this.e)) {
            localObject = oP();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          i = aqep.b(this.e);
          if (paramBoolean)
          {
            localaizg.U(i, (List)localObject);
            i = 1;
          }
          switch (this.e.pa)
          {
          default: 
            j = i;
            if (j == 0) {
              break label314;
            }
            if (paramBoolean) {
              break label309;
            }
            paramBoolean = bool;
            this.mIsShield = paramBoolean;
            this.bFB |= 0x2;
            bPf();
            return;
            localaizg.T(i, (List)localObject);
            continue;
            i = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int j = i;
        if (this.e.uin != null)
        {
          j = i;
          if (this.e.uin.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().Ek(this.e.uin);
            }
            for (;;)
            {
              j = 1;
              break;
              this.app.a().Ej(this.e.uin);
            }
            label309:
            paramBoolean = false;
          }
        }
      }
      label314:
      if (paramBoolean) {
        cf(2131720205, 1);
      }
      for (;;)
      {
        bSA();
        return;
        cf(2131720207, 1);
      }
    }
    cf(2131693404, 1);
    bSA();
  }
  
  void vT(String paramString)
  {
    ausj localausj = ausj.b(this);
    if (aqft.rj(paramString)) {
      localausj.setMainTitle(2131690834);
    }
    for (;;)
    {
      localausj.addButton(2131692515, 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new vmj(this, paramString, localausj));
      localausj.show();
      return;
      if ((this.V != null) && (this.V.booleanValue())) {
        localausj.setMainTitle(2131690836);
      } else {
        localausj.setMainTitle(2131690835);
      }
    }
  }
  
  public void vx(String paramString)
  {
    this.aOO = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileFragment", 2, "setNewRemark strRemark: " + paramString);
    }
    if (!TextUtils.isEmpty(this.aOR))
    {
      localTextView = this.EB;
      if (TextUtils.isEmpty(this.aOO)) {}
      for (paramString = "" + this.aOR;; paramString = this.aOO + "，" + this.aOR)
      {
        localTextView.setText(paramString);
        if (this.L == null) {
          this.L = new Intent();
        }
        this.L.putExtra("remark", this.aOO);
        setResult(-1, this.L);
        return;
      }
    }
    TextView localTextView = this.EB;
    if (TextUtils.isEmpty(this.aOO)) {}
    for (paramString = "";; paramString = this.aOO)
    {
      localTextView.setText(paramString);
      break;
    }
  }
  
  public void x(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((acff)this.app.getManager(51)).b(paramString1);
    int i = 17;
    if (localObject1 != null) {
      i = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + i;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + i;
    String str2 = "https://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + i;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((AbsShareMsg.a)localObject2).c(14).a(2).a(1).a(acfp.m(2131709901) + paramString2).a("plugin", str2, "", (String)localObject3, str1).d(getResources().getString(2131718642)).a();
    localObject3 = new antd();
    ((anqv)localObject3).Vs(1);
    ((anqv)localObject3).a(new ansr((String)localObject1));
    ((anqv)localObject3).a(new StructMsgItemTitle(paramString2));
    ((anqv)localObject3).a(new anux(acfp.m(2131709898) + asgx.I(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a(acfp.m(2131709946)));
    ((AbsShareMsg)localObject2).addItem((anqu)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    ahgq.f(this, paramString2, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */