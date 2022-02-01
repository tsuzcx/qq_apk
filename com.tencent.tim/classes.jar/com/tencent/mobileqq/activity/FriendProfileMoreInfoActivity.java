package com.tencent.mobileqq.activity;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import accn;
import accv;
import accv.b;
import acfd;
import acff;
import acfp;
import adyp;
import adyq;
import alcs;
import alcy;
import aldd;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofe;
import apqz;
import aqek;
import aqep;
import aqgv;
import aqha;
import aqiw;
import aqju;
import aqmj;
import aqnl;
import aqpm;
import arho;
import arhz;
import arie;
import auru;
import ausj;
import auss;
import awcy;
import awcy.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.PhotoWallView.c;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import vbj;
import vbk;
import vbl;
import vbm;
import vbn;
import vbo;
import vbp;
import vbq;
import vbr;
import vbs;
import vbt;
import vbu;
import vbv;
import vbv.a;
import wja;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements Handler.Callback, View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener, vbv.a
{
  private TextView DA;
  private TextView DB;
  private TextView DC;
  private TextView DD;
  TextView Du;
  private TextView Dv;
  TextView Dw;
  private TextView Dx;
  private TextView Dy;
  private TextView Dz;
  public arhz I = null;
  public accn a;
  private accv.b jdField_a_of_type_Accv$b = new vbq(this);
  accv jdField_a_of_type_Accv;
  private acfd jdField_a_of_type_Acfd = new vbp(this);
  private adyq jdField_a_of_type_Adyq = new vbo(this);
  arho jdField_a_of_type_Arho;
  public auru a;
  public a a;
  private CardHandler.d jdField_a_of_type_ComTencentMobileqqAppCardHandler$d = new vbr(this);
  public BusinessCard a;
  private PhotoWallView.c jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c = new PhotoWallView.c();
  public vbv a;
  public EditText aC;
  EditText aD;
  EditText aE;
  public EditText aF;
  private byte aM;
  private String aNp;
  private String aNq;
  String aNr = "";
  public boolean aWO = false;
  public boolean aWP = false;
  public boolean aWQ = false;
  public boolean aWR = false;
  public boolean aWS = false;
  public boolean aWT = false;
  public boolean aWU = false;
  public boolean aWV = false;
  private boolean aWW;
  private boolean aWX;
  private boolean aWY;
  private boolean aWZ;
  private boolean aXa;
  public boolean aXb = false;
  private boolean aXc;
  public Bundle aa;
  public a b;
  ColorNickTextView b;
  public int bHl = 0;
  private int bHm;
  private int bHn;
  private int bHo;
  private int bHp = -1;
  private int bHq = -1;
  private int bHr = -1;
  private int bHs = -1;
  private int bHt = -1;
  private int bHu;
  private int bHv;
  private int bHw;
  private int bHx;
  public a c;
  CardHandler jdField_c_of_type_ComTencentMobileqqAppCardHandler;
  private IphonePickerView jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  BounceScrollView jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ViewGroup cU;
  String[] cn;
  String[] co;
  public a d;
  public ProfileActivity.AllInOne d;
  LinearLayout dE;
  LinearLayout gc;
  private LinearLayout gd;
  public ausj mActionSheet;
  private int mAge;
  private Drawable mDefaultDrawable;
  String mMemberUin = "";
  private ArrayList<ProfilePhotoWall> mPhotoList = new ArrayList();
  protected BroadcastReceiver mReceiver = new vbn(this);
  private String mSign;
  TextView mTitleText;
  public String mTroopUin = "";
  private ArrayList<ProfilePhotoWall> pk = new ArrayList();
  private ImageView qc;
  private ImageView qd;
  View sH;
  private View sI;
  private View sJ;
  private View sK;
  private View sL;
  private View sM;
  private View sN;
  private View sO;
  private View sP;
  private View sQ;
  private View sR;
  private View sS;
  private View sT;
  private View sU;
  private View sV;
  private View sW;
  arhz u = null;
  
  public FriendProfileMoreInfoActivity()
  {
    this.jdField_a_of_type_Accn = new vbj(this);
  }
  
  private void AU(int paramInt)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, paramInt + "", "", "", "");
  }
  
  private void AV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.10(this));
      return;
    case 2: 
      Intent localIntent = new Intent(this, AgeSelectionActivity.class);
      localIntent.putExtra("param_birthday", this.bHm);
      startActivityForResult(localIntent, 1003);
      return;
    case 3: 
      this.jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.11(this));
      AX(1);
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.12(this));
  }
  
  private void AX(int paramInt)
  {
    int i = this.jdField_a_of_type_Accv.Ai();
    if (i != 0)
    {
      i = this.jdField_a_of_type_Accv.q(i, true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + i);
      }
      if (i == 2)
      {
        QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
        return;
      }
      if (i == 0)
      {
        bg(paramInt, getString(2131691966));
        this.jdField_a_of_type_Accv.addListener(this.jdField_a_of_type_Accv$b);
        return;
      }
      bg(paramInt, getString(2131691966));
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Object localObject1;
    if (paramInt == 1)
    {
      i = 2;
      if (paramInt != 1) {
        break label274;
      }
      localObject1 = this.cn;
      label149:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length == 4) {}
      }
      else
      {
        localObject2 = new String[4];
        localObject2[0] = "0";
        localObject2[1] = "0";
        localObject2[2] = "0";
        localObject2[3] = "0";
      }
      localObject1 = new Intent(this, LocationSelectActivity.class);
      ((Intent)localObject1).putExtra("param_is_popup", false);
      ((Intent)localObject1).putExtra("param_req_type", i);
      ((Intent)localObject1).putExtra("param_location", (String[])localObject2);
      ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_Accv.e((String[])localObject2));
      if (paramInt != 1) {
        break label282;
      }
    }
    label274:
    label282:
    for (paramInt = 1005;; paramInt = 1006)
    {
      startActivityForResult((Intent)localObject1, paramInt);
      return;
      i = 3;
      break;
      localObject1 = this.co;
      break label149;
    }
  }
  
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
      this.bHt = paramIntent.getIntExtra("param_present_switch_changed", 0);
    }
    if (!this.aXa) {
      this.aXa = paramIntent.getBooleanExtra("param_present_switch", false);
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
    if (PH()) {
      bPp();
    }
  }
  
  private void CA()
  {
    if ((this.u != null) && (this.u.isShowing())) {
      this.u.dismiss();
    }
  }
  
  private void F(List<ProfilePhotoWall> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("updatePhotoWall curSize=%s totalSize=%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramInt) }));
    }
    this.gc.removeAllViews();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.Du.setText("");
      return;
    }
    this.Du.setText(String.format("%s张", new Object[] { Integer.valueOf(paramInt) }));
    int j = this.gc.getWidth();
    int k = paramList.size();
    int i = 0;
    paramInt = 0;
    label117:
    Object localObject1;
    if (i < k)
    {
      localObject1 = (ProfilePhotoWall)paramList.get(i);
      if (localObject1 == null) {
        break label393;
      }
    }
    label393:
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (this.mDefaultDrawable == null)
          {
            localObject2 = getResources();
            this.mDefaultDrawable = new ColorDrawable(((Resources)localObject2).getColor(2131165887));
            this.bHw = ((Resources)localObject2).getDimensionPixelSize(2131298792);
            this.bHx = ((Resources)localObject2).getDimensionPixelSize(2131298791);
          }
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mDefaultDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mDefaultDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.bHw;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.bHw;
          localObject2 = URLDrawable.getDrawable(((ProfilePhotoWall)localObject1).getThumbUrl(this.bHv), (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = new ImageView(getBaseContext());
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).width = this.bHw;
          ((LinearLayout.LayoutParams)localObject2).height = this.bHw;
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.bHx;
          this.gc.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          m = this.bHw;
          n = this.bHx;
          paramInt = m + n + paramInt;
        }
        catch (Exception localException1)
        {
          int m;
          int n;
          continue;
        }
        try
        {
          m = this.bHw;
          n = this.bHx;
          if (m + paramInt + n > j) {
            break;
          }
        }
        catch (Exception localException2) {}
      }
      i += 1;
      break label117;
      break;
    }
  }
  
  private boolean PH()
  {
    return (this.aWW) || (this.aWX) || (this.aWZ) || (this.aWY) || (this.aXa);
  }
  
  private boolean PI()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) || (this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) || (this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) || (this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) || (this.aWQ) || (this.aWR) || (this.aWS) || (this.aWT) || (this.aWU) || (this.aWV);
  }
  
  private boolean PJ()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe)
    {
      localObject1 = this.aC.getText().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(((String)localObject1).trim()))) {}
    }
    else
    {
      if (this.aWQ) {
        localBundle.putByte("sex", this.aM);
      }
      if (this.aWR)
      {
        localBundle.putInt("birthday", this.bHm);
        localBundle.putInt("age", this.mAge);
        localBundle.putInt("key_constellation", this.bHn);
      }
      if (this.aWS) {
        localBundle.putInt("profession", this.bHo);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) {
        localBundle.putString("company", this.aD.getText().toString());
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) {
        localBundle.putString("college", this.aE.getText().toString());
      }
      if (this.aWT)
      {
        localObject1 = this.DB.getText().toString();
        localBundle.putStringArray("location", this.cn);
        localBundle.putString("locationo_desc", (String)localObject1);
        localObject1 = null;
      }
    }
    label390:
    try
    {
      localObject2 = this.jdField_a_of_type_Accv.d(this.cn);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label231:
      break label231;
    }
    localBundle.putStringArray("location_name", (String[])localObject1);
    if (this.aWU)
    {
      localObject1 = this.DC.getText().toString();
      localBundle.putStringArray("hometown", this.co);
      localBundle.putString("hometown_desc", (String)localObject1);
    }
    if (this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe)
    {
      localObject1 = this.aF.getText().toString();
      localObject2 = SearchBaseActivity.Q.matcher((CharSequence)localObject1);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((Matcher)localObject2).matches())) {
        break label390;
      }
    }
    for (;;)
    {
      if (this.aWV) {
        localBundle.putString("personalNote", this.aNp);
      }
      return a(localBundle, 2131696272, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new awcy.a();
      ((awcy.a)localObject1).cmd = 5;
      awcy.a(getAppRuntime().getAccount()).a((awcy.a)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
    }
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!aqiw.isNetSupport(this)) {
      cf(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.cg(paramBundle);
    return true;
  }
  
  private void as(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.mPhotoList.clear();
      this.mPhotoList.addAll(paramMessage);
      if (this.pk.size() != 0) {
        f(this.mPhotoList, this.pk);
      }
    }
  }
  
  private void b(Card paramCard, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramCard == null) {
      return;
    }
    if (paramCard.lCurrentStyleId != alcs.agc) {}
    this.aNq = paramCard.strNick;
    a(paramCard.getRichStatus());
    Object localObject1 = this.aC.getText().toString();
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
      vD(paramCard.strNick);
      label90:
      if (!this.aWQ) {
        aD(paramCard.shGender, false);
      }
      if (!this.aWR) {
        ak((int)paramCard.lBirthday, paramCard.age, paramCard.constellation);
      }
      if (!this.aWS) {
        AW(paramCard.iProfession);
      }
      localObject1 = this.aD.getText().toString();
      if ((!this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
        vE(paramCard.strCompany);
      }
      localObject1 = this.aE.getText().toString();
      if ((!this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
      {
        this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
        vF(paramCard.strSchool);
      }
      if (!this.aWT) {
        if (TextUtils.isEmpty(paramCard.strLocationCodes)) {
          break label457;
        }
      }
    }
    label457:
    for (localObject1 = paramCard.strLocationCodes.split("-");; localObject1 = null)
    {
      this.cn = ((String[])localObject1);
      vG(paramCard.strLocationDesc);
      if (!this.aWU)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
          localObject1 = paramCard.strHometownCodes.split("-");
        }
        this.co = ((String[])localObject1);
        vH(paramCard.strHometownDesc);
      }
      localObject1 = this.aF.getText().toString();
      if ((!this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
        vI(paramCard.strEmail);
      }
      if (!this.aWV) {
        vJ(paramCard.strPersonalNote);
      }
      if ((this.jdField_a_of_type_Vbv == null) || (!this.jdField_a_of_type_Vbv.aXf)) {
        break;
      }
      d(paramCard);
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break label90;
      }
      this.aC.setHint(paramCard.strNick);
      break label90;
    }
  }
  
  private void b(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FriendProfileMoreInfoActivity", 2, "onDeleteOldSchoolResult:" + paramBoolean);
    }
    this.aXc = false;
    if (paramBoolean) {
      cO(((adyp)this.app.getManager(112)).cN());
    }
  }
  
  private boolean b(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool = true;
    if (paramArrayOfString1 == paramArrayOfString2) {}
    for (;;)
    {
      return bool;
      try
      {
        int i;
        if (paramArrayOfString1.length == paramArrayOfString2.length) {
          i = 0;
        }
        for (;;)
        {
          if ((i >= paramArrayOfString1.length) || (!paramArrayOfString1[i].equals(paramArrayOfString2[i])))
          {
            int j = paramArrayOfString1.length;
            if (i == j) {
              break;
            }
            bool = false;
            break;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramArrayOfString1) {}
    }
  }
  
  private void bPh()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("college", "");
    if (a(localBundle, 2131696272, 0)) {
      this.aXc = true;
    }
  }
  
  private void bPi()
  {
    this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.hi(this.app.getLongAccountUin());
  }
  
  private void bPj()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(2131697186, 0);
    localausj.addButton(2131697188, 0);
    localausj.addButton(2131697187, 0);
    localausj.addCancelButton(2131721058);
    localausj.a(new vbu(this, localausj));
    localausj.show();
  }
  
  private void bPk()
  {
    if (PI())
    {
      if (this.I == null)
      {
        this.I = new arhz(this, getTitleBarHeight());
        this.I.setMessage(acfp.m(2131706586));
      }
      if (this.aWO)
      {
        this.I.dismiss();
        this.aWP = true;
        if (!isFinishing()) {
          finish();
        }
      }
    }
    while (isFinishing())
    {
      do
      {
        return;
        if (PJ())
        {
          this.aWO = true;
          this.I.show();
          return;
        }
      } while (isFinishing());
      finish();
      return;
    }
    finish();
  }
  
  private void bPm()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
      return;
    }
    aqnl.a(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void bPn()
  {
    if (this.mActionSheet == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561390, null));
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new vbk(this));
      this.mActionSheet = ausj.d(this);
      this.mActionSheet.setCloseAutoRead(true);
      this.mActionSheet.setActionContentView(this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.mActionSheet.findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject).cZW = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.mActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new vbl(this));
    }
    if ((this.aM != 0) && (this.aM != 1))
    {
      this.aM = 0;
      this.aWQ = true;
    }
    aD(this.aM, true);
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    if (this.aM != 1) {}
    for (int i = 0;; i = 1)
    {
      ((IphonePickerView)localObject).setSelection(0, i);
      try
      {
        this.mActionSheet.setOnDismissListener(new vbm(this));
        this.mActionSheet.show();
        return;
      }
      catch (Exception localException) {}
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
    startActivityForResult(localIntent, 1008);
  }
  
  private void bPp()
  {
    Bundle localBundle = new Bundle();
    if (this.aWW) {
      localBundle.putShort("key_interest_switch", (short)this.bHp);
    }
    if (this.aWX) {
      localBundle.putShort("key_music_switch", (short)this.bHq);
    }
    if (this.aXa) {
      localBundle.putShort("key_present_switch", (short)this.bHt);
    }
    if (this.aWZ) {
      localBundle.putShort("key_extend_friend_switch", (short)this.bHs);
    }
    if (this.aWY) {
      localBundle.putShort("key_personality_label_switch", (short)this.bHr);
    }
  }
  
  private void bg(int paramInt, String paramString)
  {
    this.bHl = paramInt;
    if (this.u == null) {
      this.u = new arhz(this, getTitleBarHeight());
    }
    this.u.setMessage(paramString);
    this.u.show();
  }
  
  private void c(Card paramCard)
  {
    if ((paramCard != null) && (!this.aXb) && (aqep.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = acfp.m(2131706609);
      aqha.a(this, acfp.m(2131706588), str, null, 2131697189, 2131697190, new vbs(this), new vbt(this)).show();
      aqep.a(paramCard, this.app);
      anot.a(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private void cO(ArrayList<aldd> paramArrayList)
  {
    if ((paramArrayList != null) && (this.sW.getVisibility() == 0) && (this.gd != null))
    {
      this.gd.removeAllViews();
      Object localObject1;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject1 = (aldd)paramArrayList.next();
        } while (TextUtils.isEmpty(((aldd)localObject1).bVO));
        View localView = View.inflate(this, 2131561568, null);
        TextView localTextView = (TextView)localView.findViewById(2131377718);
        Object localObject2;
        if (((aldd)localObject1).cwh)
        {
          localTextView.setText(((aldd)localObject1).bVO);
          localObject2 = getResources().getDrawable(2130846054);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          localTextView.setCompoundDrawablePadding(wja.dp2px(4.5F, localTextView.getResources()));
          label161:
          localTextView = (TextView)localView.findViewById(2131366288);
          localObject2 = ((aldd)localObject1).xR();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label252;
          }
          localTextView.setVisibility(8);
          label194:
          localTextView = (TextView)localView.findViewById(2131366289);
          if (!((aldd)localObject1).cwg) {
            break label262;
          }
          localTextView.setVisibility(0);
        }
        for (;;)
        {
          localView.setOnClickListener(this);
          localView.setTag(localObject1);
          this.gd.addView(localView);
          break;
          localTextView.setText(((aldd)localObject1).bVO);
          break label161;
          label252:
          localTextView.setText((CharSequence)localObject2);
          break label194;
          label262:
          localTextView.setVisibility(8);
        }
      }
      paramArrayList = ((acff)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
      {
        localObject1 = View.inflate(this, 2131561568, null);
        ((TextView)((View)localObject1).findViewById(2131377718)).setText(paramArrayList.strSchool);
        ((TextView)((View)localObject1).findViewById(2131366288)).setVisibility(8);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(paramArrayList);
        this.gd.addView((View)localObject1);
      }
      if (this.gd.getChildCount() < 2)
      {
        this.sW.findViewById(2131377710).setVisibility(0);
        this.sW.findViewById(2131377714).setVisibility(0);
        this.sW.findViewById(2131377712).setVisibility(0);
        this.sW.findViewById(2131377708).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.sW.findViewById(2131377710).setVisibility(8);
    this.sW.findViewById(2131377714).setVisibility(8);
    this.sW.findViewById(2131377712).setVisibility(8);
    this.sW.findViewById(2131377708).setVisibility(0);
  }
  
  public static List<ProfilePhotoWall> f(List<ProfilePhotoWall> paramList1, List<ProfilePhotoWall> paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int j = 0;
    int i = 0;
    label34:
    if (j < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(j);
      label56:
      if (i >= paramList1.size()) {
        break label123;
      }
      ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(i);
      if (localProfilePhotoWall1.time >= localProfilePhotoWall2.time) {
        break label116;
      }
      int k = i + 1;
      paramList1.add(i, localProfilePhotoWall1);
      i = k;
    }
    label116:
    label123:
    for (;;)
    {
      j += 1;
      break label34;
      break;
      i += 1;
      break label56;
    }
  }
  
  private void initViews()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377563));
    this.mTitleText = ((TextView)findViewById(2131369627));
    this.mTitleText.setText(2131694845);
    this.mTitleText.setContentDescription(getString(2131694845));
    Object localObject = (TextView)findViewById(2131369579);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(acfp.m(2131706632));
    ((TextView)localObject).setOnClickListener(this);
    this.dE = ((LinearLayout)findViewById(2131365382));
    this.sH = findViewById(2131373207);
    this.sH.setContentDescription(getString(2131697343));
    this.sH.setOnClickListener(this);
    this.gc = ((LinearLayout)findViewById(2131373110));
    this.Du = ((TextView)findViewById(2131373111));
    this.sI = findViewById(2131363199);
    this.sI.setContentDescription(getString(2131693350));
    this.sI.setOnClickListener(this);
    this.qc = ((ImageView)findViewById(2131363195));
    this.sJ = findViewById(2131378406);
    this.sJ.setOnClickListener(this);
    this.Dv = ((TextView)findViewById(2131378408));
    a(null);
    this.sK = findViewById(2131365487);
    this.sK.setOnClickListener(this);
    d(null);
    this.sL = findViewById(2131380342);
    if (this.aXb)
    {
      this.sL.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131380345));
      this.Dw = ((TextView)findViewById(2131380343));
      localObject = findViewById(2131380341);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.mTroopUin);
      if (localTroopInfo != null)
      {
        if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.mMemberUin, this.app.getCurrentAccountUin())))
        {
          this.sL.setClickable(true);
          this.sL.setOnClickListener(this);
          ((View)localObject).setVisibility(0);
        }
        bPl();
      }
    }
    else
    {
      this.cU = ((ViewGroup)findViewById(2131372377));
      if (this.sL.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.cU.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.cU.setClickable(true);
      this.cU.setOnClickListener(this);
      this.aC = ((EditText)findViewById(2131372376));
      this.qd = ((ImageView)findViewById(2131372378));
      if (!aqmj.aR(this, this.app.getCurrentAccountUin())) {
        this.qd.setVisibility(0);
      }
      this.aC.setOnFocusChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a = new a(36, this.aC);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
      vD(null);
      this.sM = findViewById(2131378157);
      this.sM.setOnClickListener(this);
      this.Dx = ((TextView)findViewById(2131378158));
      aD(-1, false);
      this.sN = findViewById(2131363514);
      this.sN.setOnClickListener(this);
      this.Dy = ((TextView)findViewById(2131363515));
      ak(0, 0, 0);
      if (aqep.aBZ())
      {
        i = this.sM.getPaddingLeft();
        int j = this.sM.getPaddingTop();
        int k = this.sM.getPaddingRight();
        int m = this.sM.getPaddingBottom();
        this.sM.setBackgroundResource(2130839689);
        this.sM.setPadding(i, j, k, m);
        this.sN.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
        }
      }
      this.sO = findViewById(2131373627);
      this.sO.setOnClickListener(this);
      this.Dz = ((TextView)findViewById(2131373626));
      this.DA = ((TextView)findViewById(2131373628));
      AW(-1);
      this.sP = findViewById(2131365110);
      this.sP.setClickable(false);
      this.aD = ((EditText)findViewById(2131365109));
      this.aD.setOnFocusChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a = new a(120, this.aD);
      this.aD.addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a);
      this.jdField_b_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
      vE(null);
      this.sQ = findViewById(2131377717);
      this.sQ.setClickable(false);
      this.aE = ((EditText)findViewById(2131377715));
      this.aE.setOnFocusChangeListener(this);
      this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a = new a(40, this.aE);
      this.aE.addTextChangedListener(this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a);
      this.jdField_c_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
      vF(null);
      this.sR = findViewById(2131370853);
      this.sR.setOnClickListener(this);
      this.DB = ((TextView)findViewById(2131370865));
      vG(null);
      this.sS = findViewById(2131368579);
      this.sS.setOnClickListener(this);
      this.DC = ((TextView)findViewById(2131368580));
      vH(null);
      this.sT = findViewById(2131366305);
      this.sT.setClickable(false);
      this.aF = ((EditText)findViewById(2131366304));
      this.aF.setOnFocusChangeListener(this);
      this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a = new a(50, this.aF);
      this.aF.addTextChangedListener(this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a);
      this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXd = true;
      vI(null);
      this.sU = findViewById(2131373020);
      this.sU.setOnClickListener(this);
      this.DD = ((TextView)findViewById(2131373021));
      vJ(null);
      this.sV = findViewById(2131369326);
      this.sV.setContentDescription(getString(2131697239));
      this.sV.setOnClickListener(this);
      this.sW = findViewById(2131366291);
      this.gd = ((LinearLayout)findViewById(2131362249));
      findViewById(2131377709).setOnClickListener(this);
      findViewById(2131377713).setOnClickListener(this);
      findViewById(2131377711).setOnClickListener(this);
      findViewById(2131377707).setOnClickListener(this);
      if ((this.jdField_a_of_type_Arho != null) && (!this.jdField_a_of_type_Arho.mI(3)) && (!this.jdField_a_of_type_Arho.mI(5)) && (!this.jdField_a_of_type_Arho.mI(4)) && (!this.jdField_a_of_type_Arho.mI(6)) && (!this.jdField_a_of_type_Arho.mI(7)))
      {
        localObject = getIntent();
        if (localObject != null) {
          break label1556;
        }
        i = -1;
        label1378:
        if ((i == -1) || (i == 1)) {
          break label1569;
        }
      }
    }
    label1556:
    label1569:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        this.sV.setVisibility(8);
      }
      if ((this.aXb) && (TroopInfo.isQidianPrivateTroop(this.app, this.mTroopUin)))
      {
        this.sH.setVisibility(8);
        this.sJ.setVisibility(8);
        this.sO.setVisibility(8);
        this.sP.setVisibility(8);
        this.sQ.setVisibility(8);
        this.sS.setVisibility(8);
        this.sT.setVisibility(8);
        this.sU.setVisibility(8);
        this.sV.setVisibility(8);
      }
      if (!this.aXb)
      {
        this.sQ.setVisibility(8);
        this.sW.setVisibility(0);
      }
      return;
      this.sL.setClickable(false);
      this.sL.setOnClickListener(null);
      ((View)localObject).setVisibility(8);
      break;
      i = ((Intent)localObject).getIntExtra("extendFriendEntryAddFriend", -1);
      break label1378;
    }
  }
  
  private void vC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "gotoSchoolWeb " + paramString);
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    startActivityForResult(localIntent, 1012);
  }
  
  void AW(int paramInt)
  {
    boolean bool = false;
    Object localObject2;
    Object localObject1;
    label67:
    TextView localTextView;
    String str;
    if (aqek.ay(paramInt))
    {
      this.bHo = paramInt;
      localObject2 = aqek.ga(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.bHo = -1;
        localObject1 = getString(2131697271);
      }
      if ((paramInt < aqek.cq.length - 1) && (paramInt > 0)) {
        break label137;
      }
      this.Dz.setVisibility(8);
      localObject2 = this.DA;
      if (this.bHo == -1) {
        bool = true;
      }
      a((TextView)localObject2, (CharSequence)localObject1, bool);
      localObject2 = this.sO;
      localTextView = this.DA;
      str = getString(2131697272);
      if (paramInt == -1) {
        break label192;
      }
    }
    for (;;)
    {
      a((View)localObject2, localTextView, str, (String)localObject1);
      return;
      this.bHo = -1;
      break;
      label137:
      localObject2 = getResources().getDrawable(aqek.oT[paramInt]);
      ProfileActivity.a(this.app, (Drawable)localObject2);
      this.Dz.setVisibility(0);
      this.Dz.setBackgroundDrawable((Drawable)localObject2);
      this.Dz.setText(aqek.cq[paramInt]);
      break label67;
      label192:
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ArrayList<PhotoWall> paramArrayList, List<ProfilePhotoWall> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.totalPic = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.hasMore = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.attachInfo = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        QZonePhotoInfo localQZonePhotoInfo = new QZonePhotoInfo();
        localQZonePhotoInfo.uin = this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.uin;
        localQZonePhotoInfo.time = paramArrayList.ctime;
        localQZonePhotoInfo.photoId = paramArrayList.photoId;
        localQZonePhotoInfo.photoUrls = paramArrayList.photoUrls;
        paramList.add(localQZonePhotoInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.eho = paramList.size();
    }
  }
  
  void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    paramView1 = str;
    if ((paramView2 instanceof EditText)) {
      paramView1 = paramString1 + acfp.m(2131706613) + paramString2 + ",";
    }
    paramView2.setContentDescription(paramView1);
  }
  
  void a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    paramTextView.setTextColor(getResources().getColor(paramInt));
    paramTextView.setText(paramCharSequence);
  }
  
  void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2131167385;; i = 2131167304)
    {
      a(paramTextView, paramCharSequence, i);
      return;
    }
  }
  
  void a(RichStatus paramRichStatus)
  {
    boolean bool = false;
    if (paramRichStatus != null) {
      paramRichStatus = paramRichStatus.toSpannableString("").toString();
    }
    for (this.mSign = paramRichStatus;; this.mSign = "")
    {
      a(this.Dv, paramRichStatus, bool);
      a(this.sJ, this.Dv, getString(2131694960), paramRichStatus);
      return;
      paramRichStatus = acfp.m(2131706621);
      bool = true;
    }
  }
  
  public void aD(int paramInt, boolean paramBoolean)
  {
    this.aM = ((byte)paramInt);
    String str = getString(2131697279);
    if (paramInt == 0)
    {
      str = getString(2131695654);
      if (!paramBoolean) {
        break label88;
      }
      a(this.Dx, str, 2131167312);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.sM, this.Dx, getString(2131697280), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131693477);
      break;
      label88:
      TextView localTextView = this.Dx;
      if ((paramInt != 0) && (paramInt != 1)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(localTextView, str, paramBoolean);
        break;
      }
      label121:
      str = "";
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
  
  void ak(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.bHm = paramInt1;
    this.mAge = paramInt2;
    this.bHn = paramInt3;
    String str1 = getString(2131697180);
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.Dy;
    TextView localTextView;
    String str2;
    if (paramInt1 == 0)
    {
      a((TextView)localObject, str1, bool);
      localObject = this.sN;
      localTextView = this.Dy;
      str2 = getString(2131697181);
      if (paramInt1 == 0) {
        break label149;
      }
    }
    for (;;)
    {
      a((View)localObject, localTextView, str2, str1);
      return;
      bool = false;
      break;
      label149:
      str1 = "";
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
    runOnUiThread(new FriendProfileMoreInfoActivity.17(this));
  }
  
  void bPl()
  {
    String str = aqgv.r(this.app, this.mTroopUin, this.mMemberUin);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.mMemberUin)))
    {
      str = "";
      this.Dw.setVisibility(0);
    }
    for (;;)
    {
      SpannableString localSpannableString = new aofe(str, 16).k();
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
      aqpm.a(this.app, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
      a(this.sL, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131699785), str);
      return;
      this.Dw.setVisibility(8);
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void d(Card paramCard)
  {
    if (this.jdField_a_of_type_Vbv != null) {
      this.jdField_a_of_type_Vbv.d(paramCard);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      paramIntent = this.jdField_a_of_type_Auru.obtainMessage(1001);
      paramIntent.obj = null;
      this.jdField_a_of_type_Auru.sendMessage(paramIntent);
    }
    label254:
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
                Object localObject;
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
                            int i;
                            do
                            {
                              do
                              {
                                do
                                {
                                  return;
                                  if (paramInt1 != 1002) {
                                    break;
                                  }
                                } while (paramInt2 == 1001);
                                this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.cHq();
                                return;
                                if (paramInt1 != 1003) {
                                  break;
                                }
                              } while (paramIntent == null);
                              i = paramIntent.getShortExtra("param_year", (short)1990);
                              int j = paramIntent.getByteExtra("param_month", (byte)1);
                              int k = paramIntent.getByteExtra("param_day", (byte)1);
                              paramInt1 = paramIntent.getIntExtra("param_age", 0);
                              paramInt2 = paramIntent.getIntExtra("param_constellation_id", 0);
                              i = i << 16 | j << 8 | k;
                            } while (i == this.bHm);
                            this.aWR = true;
                            ak(i, paramInt1, paramInt2);
                            return;
                            if (paramInt1 != 1004) {
                              break;
                            }
                          } while (paramIntent == null);
                          paramInt1 = paramIntent.getIntExtra("param_id", -1);
                        } while (paramInt1 == this.bHo);
                        this.aWS = true;
                        AW(paramInt1);
                        return;
                        if (paramInt1 != 1005) {
                          break;
                        }
                      } while (paramIntent == null);
                      localObject = paramIntent.getStringArrayExtra("param_location");
                    } while (b(this.cn, (String[])localObject));
                    this.aWT = true;
                    this.cn = ((String[])localObject);
                    paramIntent = null;
                    try
                    {
                      localObject = this.jdField_a_of_type_Accv.d((String[])localObject);
                      paramIntent = (Intent)localObject;
                    }
                    catch (Exception localException2)
                    {
                      break label254;
                    }
                    if (!TextUtils.isEmpty(paramIntent))
                    {
                      localObject = paramIntent;
                      if (!paramIntent.equals("不限")) {}
                    }
                    else
                    {
                      localObject = "";
                    }
                    vG((String)localObject);
                    return;
                    if (paramInt1 != 1006) {
                      break;
                    }
                  } while (paramIntent == null);
                  localObject = paramIntent.getStringArrayExtra("param_location");
                } while (b(this.co, (String[])localObject));
                this.aWU = true;
                this.co = ((String[])localObject);
                paramIntent = null;
                try
                {
                  localObject = this.jdField_a_of_type_Accv.d((String[])localObject);
                  paramIntent = (Intent)localObject;
                }
                catch (Exception localException1)
                {
                  break label345;
                }
                if (!TextUtils.isEmpty(paramIntent))
                {
                  localObject = paramIntent;
                  if (!paramIntent.equals("不限")) {}
                }
                else
                {
                  localObject = "";
                }
                vH((String)localObject);
                return;
                if (paramInt1 != 1007) {
                  break;
                }
              } while (paramIntent == null);
              paramIntent = paramIntent.getStringExtra("result");
            } while (paramIntent.equals(this.aNp));
            this.aWV = true;
            vJ(paramIntent);
            return;
            if (paramInt1 != 1008) {
              break;
            }
          } while (paramIntent == null);
          C(paramInt2, paramIntent);
          return;
          if (paramInt1 == 1011)
          {
            bPl();
            return;
          }
          if (paramInt1 != 1024) {
            break;
          }
        } while (this.jdField_a_of_type_Vbv == null);
        this.jdField_a_of_type_Vbv.E(paramInt2, paramIntent);
        return;
      } while (paramInt1 != 1012);
      if (QLog.isDevelopLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
      }
    } while (this.jdField_c_of_type_ComTencentMobileqqAppCardHandler == null);
    label345:
    paramIntent = this.app.getCurrentAccountUin();
    this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    bPi();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1735	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: ldc_w 1736
    //   10: invokespecial 1739	com/tencent/mobileqq/activity/ProfileActivity:setContentView	(I)V
    //   13: aload_0
    //   14: new 940	vbv
    //   17: dup
    //   18: aload_0
    //   19: aload_0
    //   20: invokespecial 1742	vbv:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lvbv$a;)V
    //   23: putfield 938	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Vbv	Lvbv;
    //   26: aload_0
    //   27: new 354	auru
    //   30: dup
    //   31: invokestatic 1630	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   34: aload_0
    //   35: invokespecial 1745	auru:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   38: putfield 350	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Auru	Lauru;
    //   41: aload_0
    //   42: invokevirtual 1494	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   45: astore_1
    //   46: aload_0
    //   47: aload_1
    //   48: ldc_w 1747
    //   51: iconst_0
    //   52: invokevirtual 409	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   55: putfield 187	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aXb	Z
    //   58: aload_0
    //   59: aload_1
    //   60: ldc_w 1749
    //   63: invokevirtual 1717	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 191	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mTroopUin	Ljava/lang/String;
    //   69: aload_0
    //   70: aload_1
    //   71: ldc_w 1751
    //   74: invokevirtual 1717	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: putfield 193	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mMemberUin	Ljava/lang/String;
    //   80: aload_0
    //   81: aload_1
    //   82: ldc_w 1753
    //   85: invokevirtual 1717	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 195	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aNr	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 938	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Vbv	Lvbv;
    //   95: aload_1
    //   96: ldc_w 1755
    //   99: iconst_0
    //   100: invokevirtual 401	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   103: putfield 1758	vbv:bHA	I
    //   106: aload_0
    //   107: getfield 938	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Vbv	Lvbv;
    //   110: aload_1
    //   111: ldc_w 1760
    //   114: invokevirtual 1717	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 1763	vbv:mCoverUrl	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 195	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aNr	Ljava/lang/String;
    //   124: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +92 -> 219
    //   130: new 1765	org/json/JSONObject
    //   133: dup
    //   134: aload_0
    //   135: getfield 195	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aNr	Ljava/lang/String;
    //   138: invokespecial 1767	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore_3
    //   142: aload_0
    //   143: aload_3
    //   144: ldc_w 1749
    //   147: invokevirtual 1770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 191	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mTroopUin	Ljava/lang/String;
    //   153: aload_0
    //   154: aload_3
    //   155: ldc_w 1751
    //   158: invokevirtual 1770	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: putfield 193	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mMemberUin	Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 191	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mTroopUin	Ljava/lang/String;
    //   168: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne +18 -> 189
    //   174: aload_0
    //   175: getfield 193	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mMemberUin	Ljava/lang/String;
    //   178: invokestatic 628	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +8 -> 189
    //   184: aload_0
    //   185: iconst_1
    //   186: putfield 187	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aXb	Z
    //   189: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +27 -> 219
    //   195: ldc_w 317
    //   198: iconst_2
    //   199: ldc_w 1772
    //   202: iconst_1
    //   203: anewarray 456	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_0
    //   209: getfield 195	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aNr	Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 471	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   224: iconst_2
    //   225: invokevirtual 1776	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   228: checkcast 796	com/tencent/mobileqq/app/CardHandler
    //   231: putfield 794	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_ComTencentMobileqqAppCardHandler	Lcom/tencent/mobileqq/app/CardHandler;
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: bipush 59
    //   241: invokevirtual 961	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   244: checkcast 301	accv
    //   247: putfield 299	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Accv	Laccv;
    //   250: aload_0
    //   251: new 1486	arho
    //   254: dup
    //   255: aload_0
    //   256: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: aconst_null
    //   260: invokespecial 1779	arho:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Larho$a;)V
    //   263: putfield 1484	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Arho	Larho;
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 202	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Accn	Laccn;
    //   271: invokevirtual 1783	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lacci;)V
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 212	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Acfd	Lacfd;
    //   279: invokevirtual 1783	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lacci;)V
    //   282: aload_0
    //   283: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   286: aload_0
    //   287: getfield 207	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Adyq	Ladyq;
    //   290: invokevirtual 1787	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   293: aload_0
    //   294: getfield 299	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Accv	Laccv;
    //   297: aload_0
    //   298: invokevirtual 1790	accv:aV	(Ljava/lang/Object;)V
    //   301: new 1792	android/content/IntentFilter
    //   304: dup
    //   305: invokespecial 1793	android/content/IntentFilter:<init>	()V
    //   308: astore_3
    //   309: aload_3
    //   310: ldc_w 1795
    //   313: invokevirtual 1798	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 227	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:mReceiver	Landroid/content/BroadcastReceiver;
    //   321: aload_3
    //   322: invokevirtual 1802	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   325: pop
    //   326: aload_0
    //   327: ldc_w 1803
    //   330: invokespecial 1804	com/tencent/mobileqq/activity/ProfileActivity:findViewById	(I)Landroid/view/View;
    //   333: checkcast 475	android/widget/LinearLayout
    //   336: astore_3
    //   337: invokestatic 1809	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   340: iconst_1
    //   341: if_icmpne +19 -> 360
    //   344: aload_3
    //   345: iconst_1
    //   346: invokevirtual 1812	android/widget/LinearLayout:setFitsSystemWindows	(Z)V
    //   349: aload_3
    //   350: iconst_0
    //   351: aload_0
    //   352: invokestatic 1816	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   355: iconst_0
    //   356: iconst_0
    //   357: invokevirtual 1817	android/widget/LinearLayout:setPadding	(IIII)V
    //   360: aload_0
    //   361: invokespecial 1819	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:initViews	()V
    //   364: aload_0
    //   365: invokevirtual 506	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getResources	()Landroid/content/res/Resources;
    //   368: invokevirtual 1823	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   371: astore_3
    //   372: aload_3
    //   373: getfield 1828	android/util/DisplayMetrics:widthPixels	I
    //   376: aload_3
    //   377: getfield 1831	android/util/DisplayMetrics:heightPixels	I
    //   380: invokestatic 1837	java/lang/Math:max	(II)I
    //   383: istore_2
    //   384: iload_2
    //   385: sipush 240
    //   388: if_icmpgt +243 -> 631
    //   391: aload_0
    //   392: bipush 60
    //   394: putfield 546	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:bHv	I
    //   397: aload_0
    //   398: aload_0
    //   399: invokevirtual 1494	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   402: ldc_w 1839
    //   405: invokevirtual 1843	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   408: checkcast 1554	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   411: putfield 1032	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   414: aload_0
    //   415: aload_0
    //   416: invokevirtual 1494	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   419: ldc_w 1845
    //   422: invokevirtual 1843	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   425: checkcast 1847	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   428: putfield 1849	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   431: aload_0
    //   432: getfield 1032	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   435: ifnonnull +22 -> 457
    //   438: aload_0
    //   439: new 1554	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   442: dup
    //   443: aload_0
    //   444: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   447: invokevirtual 1852	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   450: iconst_0
    //   451: invokespecial 1854	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   454: putfield 1032	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   457: aload_0
    //   458: getfield 1849	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   461: ifnonnull +14 -> 475
    //   464: aload_0
    //   465: aload_0
    //   466: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: invokestatic 1859	adzx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   472: putfield 1849	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   475: new 1861	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 1862	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileMoreInfoActivity;)V
    //   483: iconst_5
    //   484: aconst_null
    //   485: iconst_1
    //   486: invokestatic 1867	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   489: aload_0
    //   490: getfield 187	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:aXb	Z
    //   493: ifne +26 -> 519
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   501: bipush 112
    //   503: invokevirtual 961	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   506: checkcast 963	adyp
    //   509: invokevirtual 967	adyp:cN	()Ljava/util/ArrayList;
    //   512: invokespecial 778	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:cO	(Ljava/util/ArrayList;)V
    //   515: aload_0
    //   516: invokespecial 1729	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:bPi	()V
    //   519: aload_1
    //   520: ldc_w 1869
    //   523: iconst_0
    //   524: invokevirtual 401	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   527: istore_2
    //   528: iload_2
    //   529: ifle +41 -> 570
    //   532: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +30 -> 565
    //   538: ldc_w 317
    //   541: iconst_2
    //   542: new 240	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1871
    //   552: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload_2
    //   556: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_0
    //   566: iload_2
    //   567: invokespecial 1873	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:AV	(I)V
    //   570: aload_0
    //   571: getfield 234	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   574: ldc 236
    //   576: ldc 189
    //   578: ldc 189
    //   580: ldc_w 1875
    //   583: ldc_w 1875
    //   586: iconst_0
    //   587: iconst_0
    //   588: ldc 189
    //   590: ldc 189
    //   592: ldc 189
    //   594: ldc 189
    //   596: invokestatic 257	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   599: iconst_1
    //   600: ireturn
    //   601: astore_1
    //   602: aload_1
    //   603: invokevirtual 1878	java/lang/Exception:printStackTrace	()V
    //   606: aload_0
    //   607: invokevirtual 1026	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:finish	()V
    //   610: iconst_0
    //   611: ireturn
    //   612: astore_3
    //   613: aload_3
    //   614: invokevirtual 1879	org/json/JSONException:printStackTrace	()V
    //   617: ldc_w 317
    //   620: iconst_1
    //   621: aload_3
    //   622: invokevirtual 1882	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   625: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: goto -439 -> 189
    //   631: iload_2
    //   632: sipush 320
    //   635: if_icmpgt +12 -> 647
    //   638: aload_0
    //   639: bipush 100
    //   641: putfield 546	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:bHv	I
    //   644: goto -247 -> 397
    //   647: aload_0
    //   648: sipush 160
    //   651: putfield 546	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:bHv	I
    //   654: goto -257 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	this	FriendProfileMoreInfoActivity
    //   0	657	1	paramBundle	Bundle
    //   383	253	2	i	int
    //   141	236	3	localObject	Object
    //   612	10	3	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   6	13	601	java/lang/Exception
    //   130	189	612	org/json/JSONException
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Arho != null)
    {
      this.jdField_a_of_type_Arho.destroy();
      this.jdField_a_of_type_Arho = null;
    }
    if (this.jdField_a_of_type_Vbv != null)
    {
      this.jdField_a_of_type_Vbv.destroy();
      this.jdField_a_of_type_Vbv = null;
    }
    if (this.jdField_a_of_type_Accv != null)
    {
      this.jdField_a_of_type_Accv.aW(this);
      this.jdField_a_of_type_Accv.removeListener(this.jdField_a_of_type_Accv$b);
      this.jdField_a_of_type_Accv = null;
    }
    if (!this.aWP) {
      removeObserver(this.jdField_a_of_type_Accn);
    }
    removeObserver(this.jdField_a_of_type_Acfd);
    this.app.unRegistObserver(this.jdField_a_of_type_Adyq);
    try
    {
      unregisterReceiver(this.mReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + localIllegalArgumentException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + localException.getMessage());
    }
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
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (PH()) {
      localIntent.putExtra("param_switches_changed", true);
    }
    if (this.aa != null) {
      localIntent.putExtra("result", this.aa);
    }
    if ((this.jdField_a_of_type_Vbv != null) && (this.jdField_a_of_type_Vbv.aXf))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Vbv.ca);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
          } while ((this.bHl != 1) && (this.bHl != 2));
          CA();
          QQToast.a(this, 2131691963, 0).show(getTitleBarHeight());
          return true;
          as(paramMessage);
          F(this.mPhotoList, this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.totalPic);
          this.bHu = 0;
          try
          {
            long l = Long.parseLong(this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.uin);
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.eD(this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.uin, "");
            this.jdField_c_of_type_ComTencentMobileqqAppCardHandler.a(l, this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$d);
            return true;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("FriendProfileMoreInfoActivity", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FROM_DATABASE fail!", paramMessage);
        return true;
        this.bHu |= 0x1;
        as(paramMessage);
      } while (this.bHu != 17);
      F(this.mPhotoList, this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.totalPic);
      return true;
      this.bHu |= 0x10;
      f(this.mPhotoList, this.pk);
    } while (this.bHu != 17);
    F(this.mPhotoList, this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$c.totalPic);
    return true;
  }
  
  public boolean onBackEvent()
  {
    try
    {
      if (this.dE != null) {
        this.dE.requestFocus();
      }
      label15:
      bPk();
      return true;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.dE != null) {}
    try
    {
      this.dE.requestFocus();
      switch (paramView.getId())
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("FriendProfileMoreInfoActivity", 1, "onClick fail.", localThrowable);
        continue;
        bPk();
        continue;
        Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/photowall/index.html?_wv=1027");
        ((Intent)localObject).putExtra("leftViewText", getString(2131690700));
        startActivityForResult((Intent)localObject, 1001);
        anot.a(this.app, "dc00898", "", "", "0X8007EC4", "0X8007EC4", 0, 0, "", "", "", "");
        continue;
        localObject = new Intent(this, AvatarPendantActivity.class);
        ((Intent)localObject).putExtra("AllInOne", this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        ((Intent)localObject).putExtra("showActionSheet", true);
        startActivity((Intent)localObject);
        anot.a(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
        continue;
        bPm();
        anot.a(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
        continue;
        bPn();
        continue;
        localObject = ((TroopManager)this.app.getManager(52)).b(this.mTroopUin);
        if (localObject != null) {
          if ((((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) || (((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.uin, this.app.getCurrentAccountUin())))
          {
            w(this.mTroopUin, this.jdField_d_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.uin, 1011);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
            continue;
            localObject = new Intent(this, AgeSelectionActivity.class);
            ((Intent)localObject).putExtra("param_birthday", this.bHm);
            startActivityForResult((Intent)localObject, 1003);
            continue;
            localObject = new Intent(this, JobSelectionActivity.class);
            ((Intent)localObject).putExtra("param_id", this.bHo);
            startActivityForResult((Intent)localObject, 1004);
            continue;
            AX(1);
            continue;
            AX(2);
            continue;
            localObject = new Intent(this, EditActivity.class);
            ((Intent)localObject).putExtra("title", 2131697267).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131697266).putExtra("multiLine", true).putExtra("current", this.aNp).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
            startActivityForResult((Intent)localObject, 1007);
            continue;
            bPo();
            anot.a(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
            continue;
            if (this.jdField_a_of_type_Vbv != null)
            {
              localObject = this.jdField_a_of_type_Vbv;
              if (this.jdField_a_of_type_Vbv.bHA != 0) {
                break label829;
              }
            }
            label829:
            for (boolean bool = true;; bool = false)
            {
              ((vbv)localObject).xr(bool);
              anot.a(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
              break;
            }
            if (this.qd.getVisibility() == 0)
            {
              this.qd.setVisibility(4);
              aqmj.B(this, this.app.getCurrentAccountUin(), true);
            }
            alcy.e(this.app, this, this.aC.getText().toString());
            continue;
            AU(1);
            vC(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
            continue;
            AU(2);
            vC(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
            continue;
            AU(3);
            vC(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
            continue;
            AU(4);
            bPj();
            continue;
            anot.a(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
            if ((paramView.getTag() instanceof aldd))
            {
              localObject = (aldd)paramView.getTag();
              vC(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(((aldd)localObject).dsa), Integer.valueOf(((aldd)localObject).drZ) }));
            }
            else if ((paramView.getTag() instanceof Card))
            {
              vC("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
            }
          }
        }
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != this.aC) {
        break label70;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe)
      {
        paramView = this.aC.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label70:
    Matcher localMatcher;
    do
    {
      QQToast.a(this, acfp.m(2131706587), 0).show(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.aF) || (!this.jdField_d_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe));
      paramView = this.aF.getText().toString();
      localMatcher = SearchBaseActivity.Q.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    QQToast.a(this, acfp.m(2131706611), 0).show(getTitleBarHeight());
  }
  
  public void vD(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131697246);
    }
    for (;;)
    {
      this.aC.setText(str);
      this.aC.setHint(paramString);
      a(this.cU, this.aC, getString(2131697247), str);
      return;
      str = paramString;
    }
  }
  
  void vE(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.aD.setText(str);
    this.aD.setHint(2131697195);
    a(this.sP, this.aD, getString(2131697196), str);
  }
  
  void vF(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.aE.setText(str);
    this.aE.setHint(2131697277);
    a(this.sQ, this.aE, getString(2131697278), str);
  }
  
  void vG(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131697241);
      bool = true;
    }
    a(this.DB, str1, bool);
    paramString = this.sR;
    TextView localTextView = this.DB;
    String str2 = getString(2131697242);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  void vH(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131697237);
      bool = true;
    }
    a(this.DC, str1, bool);
    paramString = this.sS;
    TextView localTextView = this.DC;
    String str2 = getString(2131697238);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  void vI(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.aF.setText(str);
    this.aF.setHint(2131697228);
    a(this.sT, this.aF, getString(2131697229), str);
  }
  
  void vJ(String paramString)
  {
    this.aNp = paramString;
    int i;
    if (TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    for (String str1 = getString(2131697266);; str1 = paramString)
    {
      a(this.DD, str1, TextUtils.isEmpty(paramString));
      paramString = this.sU;
      TextView localTextView = this.DD;
      String str2 = getString(2131697267);
      if (i == 0) {}
      for (;;)
      {
        a(paramString, localTextView, str2, str1);
        return;
        str1 = "";
      }
      i = 0;
    }
  }
  
  public void w(String paramString1, String paramString2, int paramInt)
  {
    if (TroopInfo.isHomeworkTroop(this.app, paramString1))
    {
      apqz.p(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramString1 = "";
    if (paramInt == 1011)
    {
      paramString1 = getString(2131699789);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_text", this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", acfp.m(2131706594));
    }
    for (;;)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      localIntent.putExtra("default_text", "");
    }
  }
  
  public class a
    implements TextWatcher
  {
    boolean aXd = false;
    public boolean aXe = false;
    private int bHy;
    private int bHz;
    private EditText mEditText;
    private int mMaxBytes;
    
    public a(int paramInt, EditText paramEditText)
    {
      this.mMaxBytes = paramInt;
      this.mEditText = paramEditText;
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = this.mEditText.getText().toString();
      localObject1 = paramEditable;
      if (paramEditable.getBytes().length > this.mMaxBytes) {
        localEditable = paramEditable;
      }
      try
      {
        String str1 = paramEditable.substring(0, this.bHy);
        localEditable = paramEditable;
        String str2 = paramEditable.substring(this.bHy + this.bHz, paramEditable.length());
        localEditable = paramEditable;
        Object localObject2 = paramEditable.substring(this.bHy, this.bHy + this.bHz);
        localObject1 = paramEditable;
        localEditable = paramEditable;
        if (str1.getBytes().length + str2.getBytes().length <= this.mMaxBytes)
        {
          localObject1 = localObject2;
          for (;;)
          {
            localEditable = paramEditable;
            if (paramEditable.getBytes().length <= this.mMaxBytes) {
              break;
            }
            localEditable = paramEditable;
            if (((String)localObject1).length() <= 0) {
              break;
            }
            localEditable = paramEditable;
            localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
            localEditable = paramEditable;
            paramEditable = str1 + (String)localObject1 + str2;
          }
          localEditable = paramEditable;
          this.mEditText.setText(paramEditable);
          localEditable = paramEditable;
          localObject2 = this.mEditText;
          localEditable = paramEditable;
          int i = str1.length();
          localEditable = paramEditable;
          ((EditText)localObject2).setSelection(((String)localObject1).length() + i);
          localObject1 = paramEditable;
        }
      }
      catch (Exception paramEditable)
      {
        for (;;)
        {
          label292:
          localObject1 = localEditable;
        }
      }
      if (this.aXd)
      {
        this.aXd = false;
        if (this.mEditText != FriendProfileMoreInfoActivity.this.aC) {
          break label292;
        }
        FriendProfileMoreInfoActivity.this.a(FriendProfileMoreInfoActivity.a(FriendProfileMoreInfoActivity.this), FriendProfileMoreInfoActivity.this.aC, FriendProfileMoreInfoActivity.this.getString(2131697247), (String)localObject1);
      }
      do
      {
        return;
        this.aXe = true;
        break;
        if (this.mEditText == FriendProfileMoreInfoActivity.this.aD)
        {
          FriendProfileMoreInfoActivity.this.a(FriendProfileMoreInfoActivity.d(FriendProfileMoreInfoActivity.this), FriendProfileMoreInfoActivity.this.aD, FriendProfileMoreInfoActivity.this.getString(2131697196), (String)localObject1);
          return;
        }
        if (this.mEditText == FriendProfileMoreInfoActivity.this.aE)
        {
          FriendProfileMoreInfoActivity.this.a(FriendProfileMoreInfoActivity.e(FriendProfileMoreInfoActivity.this), FriendProfileMoreInfoActivity.this.aE, FriendProfileMoreInfoActivity.this.getString(2131697278), (String)localObject1);
          return;
        }
      } while (this.mEditText != FriendProfileMoreInfoActivity.this.aF);
      FriendProfileMoreInfoActivity.this.a(FriendProfileMoreInfoActivity.f(FriendProfileMoreInfoActivity.this), FriendProfileMoreInfoActivity.this.aF, FriendProfileMoreInfoActivity.this.getString(2131697229), (String)localObject1);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.bHy = paramInt1;
      this.bHz = paramInt3;
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */