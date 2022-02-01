package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import abdz;
import acfd;
import acff;
import acfp;
import ahgg.a;
import ahgq;
import ahix;
import ahlr;
import ajdo;
import akwl;
import amxk;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqgv;
import aqhu;
import aqiw;
import asgx;
import ausj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.a;
import cooperation.qqpim.QQPimTipsInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import jqs;
import mqq.app.AppRuntime;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import wja;
import zqi;
import zqj;
import zqk;
import zql;

@SuppressLint({"ViewConstructor"})
public class ContactListView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener, aqdf.a, IndexView.a, AbsListView.e
{
  private static final String baA = acfp.m(2131704393);
  private static final String[] ck = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private XListView H;
  private TextView Ne;
  public ahgq a;
  a jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b;
  public d a;
  private QQPimGetTipsInfoIPC.a jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$a = new zql(this);
  private EditText aQ;
  abdz jdField_b_of_type_Abdz;
  private IndexView jdField_b_of_type_ComTencentMobileqqWidgetIndexView;
  private boolean bsq;
  int ceA;
  private aqdf d;
  private Bitmap dk;
  ausj e;
  private HashMap<String, Integer> hs;
  private int mCurrentScrollState = 0;
  private Handler mWorkerHandler;
  private acfd o = new zqi(this);
  ArrayList<PhoneContact> rH;
  List<List<PhoneContact>> uH;
  private List<String> uI;
  List<PhoneContact> uJ;
  private ImageView vw;
  private View yO;
  private View yP;
  private View yQ;
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setContentView(2131559742);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "ContactListView()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$d = new d(this);
    this.mWorkerHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.H = ((XListView)findViewById(2131365254));
    this.H.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369141));
  }
  
  private void a(c paramc, String paramString, int paramInt)
  {
    Bitmap localBitmap2 = this.d.b(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.d.isPausing()) {
        this.d.i(paramString, paramInt, false);
      }
      if (this.dk == null) {
        this.dk = aqhu.G();
      }
      localBitmap1 = this.dk;
    }
    paramc.vx.setImageBitmap(localBitmap1);
    paramc.baB = paramString;
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int j;
    int i;
    if (this.mCurrentScrollState == 0)
    {
      j = paramListView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        c localc = (c)paramListView.getChildAt(i).getTag();
        if ((localc != null) && (paramString.equals(localc.baB))) {
          localc.vx.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() tipsType " + paramQQPimTipsInfo.tipsType);
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() tipsString " + paramQQPimTipsInfo.cMb);
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() repeatContactNum " + paramQQPimTipsInfo.ext);
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() mTextViewQQPimTips " + this.Ne.getClass().hashCode());
    }
    if (paramQQPimTipsInfo.tipsType == 0)
    {
      this.vw.setVisibility(4);
      this.Ne.setText("");
    }
    while (paramQQPimTipsInfo.tipsType == 3)
    {
      ao(true, paramQQPimTipsInfo.cMb);
      return;
      if ((paramQQPimTipsInfo.tipsType == 1) || (paramQQPimTipsInfo.tipsType == 2) || (paramQQPimTipsInfo.tipsType == 4))
      {
        if (TextUtils.isEmpty(paramQQPimTipsInfo.cMb)) {
          this.Ne.setText("");
        }
        for (;;)
        {
          if (paramQQPimTipsInfo.bF <= 0) {
            break label247;
          }
          this.vw.setVisibility(0);
          break;
          this.Ne.setText(paramQQPimTipsInfo.cMb);
        }
        label247:
        this.vw.setVisibility(4);
      }
    }
    ao(false, null);
  }
  
  private void ao(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "initBlueTipsBar()");
    }
    View localView = null;
    if (paramBoolean) {
      localView = d(paramString);
    }
    if (localView != null)
    {
      this.H.addHeaderView(localView);
      if (this.yP != null)
      {
        this.H.removeHeaderView(this.yP);
        this.H.addHeaderView(this.yP);
      }
    }
  }
  
  private void cri()
  {
    int j = 256;
    if (this.reqType == 3) {
      anot.a(this.app, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    this.app.getApplication();
    int i = 561243;
    if ((this.reqType == 0) || (this.reqType == 5))
    {
      j = 768;
      i = 561246;
      ContactSearchComponentActivity.b(this.mActivity, null, 3, j, i);
      return;
    }
    if (this.reqType == 2) {
      if (!(this.jdField_a_of_type_Ahgq instanceof ahlr)) {
        break label146;
      }
    }
    label146:
    for (i = 32768;; i = 256)
    {
      j = i;
      i = 561248;
      break;
      if (this.reqType == 3)
      {
        i = 561247;
        break;
      }
      j = 0;
      break;
    }
  }
  
  private View d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "generateMergeContactsView()");
    }
    anot.a(this.app, "CliOper", "", "", "0X800670F", "0X800670F", 0, 0, "", "", "", "");
    if (this.yQ == null) {
      this.yQ = LayoutInflater.from(getContext()).inflate(2131563152, this.H, false);
    }
    this.yQ.findViewById(2131379711).setOnClickListener(new zqj(this));
    this.yQ.findViewById(2131379717).setOnClickListener(new zqk(this));
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)this.yQ.findViewById(2131379720)).setText(paramString);
    }
    return this.yQ;
  }
  
  private void fR(View paramView)
  {
    paramView = (c)paramView.getTag();
    Object localObject1 = paramView.b;
    int i = paramView.type;
    Object localObject2 = this.app;
    if (i == 2)
    {
      paramView = "0";
      anot.a((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (i != 2) {
        break label221;
      }
      paramView = wja.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (acff)this.app.getManager(51);
      if (localObject2 != null)
      {
        localObject1 = ((acff)localObject2).e(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ((Friends)localObject1).getFriendNickWithAlias());
          if ((jqs.cU(((Friends)localObject1).cSpecialFlag)) || (asgx.mS(((Friends)localObject1).cSpecialFlag))) {
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      startActivity(paramView);
    }
    label221:
    while (i != 3)
    {
      return;
      paramView = "1";
      break;
    }
    paramView = ((ajdo)this.app.getManager(11)).a();
    localObject2 = paramView.nationCode + paramView.mobileNo;
    paramView = wja.a(new Intent(getContext(), SplashActivity.class), null);
    paramView.putExtra("entrance", 3);
    paramView.putExtra("uin", ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode);
    paramView.putExtra("phonenum", (String)localObject2);
    paramView.putExtra("uintype", 1006);
    paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
    localObject2 = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 31);
    ((ProfileActivity.AllInOne)localObject2).pr = new ArrayList();
    ((ProfileActivity.AllInOne)localObject2).nickname = ((PhoneContact)localObject1).nickName;
    ((ProfileActivity.AllInOne)localObject2).contactName = ((PhoneContact)localObject1).name;
    ((ProfileActivity.AllInOne)localObject2).pr.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
    ((ProfileActivity.AllInOne)localObject2).bIW = ((PhoneContact)localObject1).ability;
    ((ProfileActivity.AllInOne)localObject2).bIZ = 3;
    ((ProfileActivity.AllInOne)localObject2).bJa = 59;
    paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
    startActivity(paramView);
  }
  
  private void fS(View paramView)
  {
    Object localObject = (c)paramView.getTag();
    QQAppInterface localQQAppInterface = this.app;
    int j;
    int i;
    if (((c)localObject).type == 2)
    {
      paramView = "0";
      anot.a(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
      paramView = ((c)localObject).b;
      j = ((c)localObject).type;
      i = 0;
      if (j != 2) {
        break label182;
      }
      i = 0;
    }
    for (;;)
    {
      localObject = paramView.nationCode + paramView.mobileCode;
      ChatActivityUtils.a(this.app, getContext(), i, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, "from_internal");
      anot.a(this.app, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
      return;
      paramView = "1";
      break;
      label182:
      if (j == 3) {
        i = 1006;
      }
    }
  }
  
  private void fT(View paramView)
  {
    anot.a(this.app, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    PhoneContact localPhoneContact = ((c)paramView.getTag()).b;
    startActivity(AddFriendLogicActivity.a(getContext(), 2, localPhoneContact.nationCode + localPhoneContact.mobileCode, null, 3006, 3, localPhoneContact.name, null, null, acfp.m(2131704412), null));
    if (this.reqType != 3) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag(2131374873);
      if (paramView != null)
      {
        int i = ((Integer)paramView).intValue();
        if (i < 5)
        {
          paramView = null;
          switch (i)
          {
          }
          while (paramView != null)
          {
            anot.a(this.app, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            return;
            paramView = "0X80068B7";
            continue;
            paramView = "0X80068B8";
            continue;
            paramView = "0X80068B9";
            continue;
            paramView = "0X80068BA";
            continue;
            paramView = "0X80068BB";
          }
        }
      }
    }
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void onItemClick(View paramView)
  {
    Object localObject = (c)paramView.getTag();
    if ((localObject == null) || (((c)localObject).b == null)) {
      return;
    }
    PhoneContact localPhoneContact = ((c)localObject).b;
    int i = ((c)localObject).type;
    if (this.reqType == 2)
    {
      boolean bool = this.jdField_a_of_type_Ahgq instanceof ahlr;
      label129:
      Bundle localBundle;
      if ((i == 2) && (!bool))
      {
        paramView = new Bundle();
        paramView.putString("uin", localPhoneContact.uin);
        paramView.putInt("uintype", 0);
        paramView.putString("uinname", localPhoneContact.name);
        this.mActivity.getIntent().putExtras(paramView);
        this.jdField_a_of_type_Ahgq.H(ahgg.a.S.intValue(), paramView);
        if (!bool) {
          break label259;
        }
        localBundle = new Bundle();
        localObject = localPhoneContact.mobileCode;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label261;
        }
        paramView = localPhoneContact.mobileNo;
        label164:
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          break label289;
        }
      }
      label259:
      label261:
      label289:
      for (bool = true;; bool = false)
      {
        localBundle.putBoolean("bindContact", bool);
        localBundle.putString("uin", paramView);
        localBundle.putInt("uintype", 1006);
        localBundle.putString("uinname", localPhoneContact.name);
        this.mActivity.getIntent().putExtras(localBundle);
        this.jdField_a_of_type_Ahgq.H(ahgg.a.Y.intValue(), localBundle);
        return;
        if (i != 3) {
          break label129;
        }
        bool = true;
        break label129;
        break;
        i = ((String)localObject).indexOf("|");
        paramView = (View)localObject;
        if (i <= -1) {
          break label164;
        }
        paramView = ((String)localObject).substring(0, i);
        break label164;
      }
    }
    if (this.reqType == 0)
    {
      localObject = this.app;
      if (i == 2)
      {
        paramView = "0";
        anot.a((QQAppInterface)localObject, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
        label349:
        paramView = getContext();
        localObject = new Intent(paramView, QCallDetailActivity.class);
        ((Intent)localObject).putExtra("contactID", localPhoneContact.contactID);
        switch (i)
        {
        default: 
          ((Intent)localObject).putExtra("uin", localPhoneContact.mobileNo);
          ((Intent)localObject).putExtra("uintype", 56938);
          ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
        }
      }
    }
    for (;;)
    {
      paramView.startActivity((Intent)localObject);
      return;
      paramView = "1";
      break;
      if (this.reqType != 3) {
        break label349;
      }
      anot.a(this.app, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
      paramView = paramView.getTag(2131374873);
      if (paramView == null) {
        break label349;
      }
      int j = ((Integer)paramView).intValue();
      if (j >= 5) {
        break label349;
      }
      paramView = null;
      switch (j)
      {
      }
      while (paramView != null)
      {
        anot.a(this.app, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        break;
        paramView = "0X80068B2";
        continue;
        paramView = "0X80068B3";
        continue;
        paramView = "0X80068B4";
        continue;
        paramView = "0X80068B5";
        continue;
        paramView = "0X80068B6";
      }
      ((Intent)localObject).putExtra("uin", localPhoneContact.uin);
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.nickName);
      continue;
      ((Intent)localObject).putExtra("uin", localPhoneContact.nationCode + localPhoneContact.mobileCode);
      ((Intent)localObject).putExtra("uintype", 1006);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
    }
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.H.setSelection(0);
      return;
    }
    XListView localXListView = this.H;
    int i = this.H.getHeaderViewsCount();
    localXListView.setSelection(((Integer)this.hs.get(paramString)).intValue() + i);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onCreate()");
    }
    int i = this.f.xy();
    boolean bool;
    if ((this.reqType != 2) || ((i != 1) && (i != 2) && (i != 6) && (i != 7) && (i != 3)))
    {
      this.yO = LayoutInflater.from(getContext()).inflate(2131563007, this.H, false);
      this.yO.findViewById(2131363801).setVisibility(8);
      this.aQ = ((EditText)this.yO.findViewById(2131366542));
      this.aQ.setFocusableInTouchMode(false);
      this.aQ.setCursorVisible(false);
      this.aQ.setOnClickListener(this);
      this.H.addHeaderView(this.yO);
      bool = true;
      if ((this.reqType == 2) && (this.mActivity != null)) {
        this.jdField_a_of_type_Ahgq = ahix.a(this.mActivity.getIntent(), this.app, this.mActivity);
      }
      if ((this.reqType != 0) && (this.reqType != 2) && (this.reqType != 5)) {
        break label340;
      }
      if (this.yO != null) {
        this.yO.setPadding(0, 0, 40, 0);
      }
    }
    for (;;)
    {
      if (this.mActivity != null)
      {
        paramIntent = this.mActivity.getIntent().getStringArrayExtra("key_reserved_mobile");
        if ((paramIntent != null) && (paramIntent.length > 0)) {
          this.uI = Arrays.asList(paramIntent);
        }
      }
      this.d = new aqdf(getContext(), this.app);
      this.d.a(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(ck, bool, false, false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.f.i(true, false, 19);
      return;
      bool = false;
      break;
      label340:
      this.jdField_b_of_type_Abdz = new abdz(getContext(), this.app, this.H, this.uJ);
      this.H.setAdapter(this.jdField_b_of_type_Abdz);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    c localc = (c)paramView.getTag();
    if (paramBoolean)
    {
      localc.nameText.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
      localc.baB = null;
      localc.b = paramPhoneContact;
      if (!TextUtils.isEmpty(paramPhoneContact.uin)) {
        break label215;
      }
      localc.vx.setVisibility(0);
      localc.Nf.setVisibility(0);
      localc.eJ.setVisibility(8);
      localc.eK.setVisibility(8);
      localc.type = 1;
      localc.vx.setImageResource(2130842937);
      paramPhoneContact = aqgv.ps(paramPhoneContact.name);
      localc.Nf.setText(paramPhoneContact);
      if (!aqgv.mH(paramPhoneContact)) {
        break label192;
      }
      localc.Nf.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131299559));
      label166:
      localc.vy.setVisibility(8);
    }
    for (;;)
    {
      return;
      localc.nameText.setText(paramPhoneContact.name);
      break;
      label192:
      localc.Nf.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131299560));
      break label166;
      label215:
      localc.vx.setVisibility(0);
      localc.Nf.setVisibility(8);
      if ((this.reqType == 0) || (this.reqType == 5))
      {
        localc.eJ.setVisibility(8);
        localc.eK.setVisibility(0);
      }
      localc.eJ.setTag(localc);
      localc.eK.setTag(localc);
      localc.eJ.setContentDescription(acfp.m(2131704392) + paramPhoneContact.name + acfp.m(2131704401));
      localc.eK.setContentDescription(acfp.m(2131704397) + paramPhoneContact.name + acfp.m(2131704399));
      if (!paramPhoneContact.uin.equals("0"))
      {
        localc.type = 2;
        a(localc, paramPhoneContact.uin, 1);
        localc.vy.setVisibility(8);
      }
      while (localc.type != 2)
      {
        localc.eK.setVisibility(8);
        return;
        localc.type = 3;
        a(localc, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 11);
        if (this.reqType == 5)
        {
          if (paramPhoneContact.isHiden)
          {
            localc.vy.setVisibility(0);
            if (AppSetting.enableTalkBack) {
              paramView.setContentDescription(paramPhoneContact.name + acfp.m(2131704414));
            }
          }
          else
          {
            localc.vy.setVisibility(8);
            if (AppSetting.enableTalkBack) {
              paramView.setContentDescription(paramPhoneContact.name + acfp.m(2131704400));
            }
          }
        }
        else {
          localc.vy.setVisibility(8);
        }
      }
    }
  }
  
  void crg()
  {
    boolean bool;
    ArrayList localArrayList;
    if ((this.reqType == 2) && ((this.jdField_a_of_type_Ahgq instanceof ahlr)))
    {
      bool = true;
      if ((this.reqType != 5) && (!bool)) {
        break label84;
      }
      localArrayList = new ArrayList();
      localArrayList.add(this.f.p(bool));
      localArrayList.add(new ArrayList());
    }
    label84:
    for (this.uH = localArrayList;; this.uH = this.f.cZ())
    {
      crh();
      return;
      bool = false;
      break;
    }
  }
  
  void crh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$a = new a(null);
      this.H.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$a);
    }
    if (this.uH == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$d.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.hs = new LinkedHashMap();
    Object localObject1 = ck;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      this.hs.put(localObject2, Integer.valueOf(0));
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = "*";
    Iterator localIterator = ((List)this.uH.get(0)).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      Object localObject3 = localPhoneContact.pinyinFirst;
      localObject1 = localObject3;
      if (this.hs.get(localObject3) == null)
      {
        localObject1 = "#";
        localPhoneContact.pinyinFirst = "#";
      }
      localObject3 = localObject2;
      if (!((String)localObject2).equals(localObject1))
      {
        localArrayList.add(null);
        localObject3 = localObject1;
      }
      localArrayList.add(localPhoneContact);
      this.hs.put(localObject1, Integer.valueOf(((Integer)this.hs.get(localObject1)).intValue() + 1));
      localObject2 = localObject3;
    }
    localObject1 = this.hs.keySet().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      j = ((Integer)this.hs.get(localObject2)).intValue();
      if (j == 0) {
        break label492;
      }
    }
    label492:
    for (j = j + i + 1;; j = i)
    {
      this.hs.put(localObject2, Integer.valueOf(i));
      i = j;
      break;
      if (this.reqType == 0)
      {
        localObject1 = (List)this.uH.get(1);
        if (((List)localObject1).size() > 0)
        {
          this.hs.put(baA, Integer.valueOf(localArrayList.size()));
          localArrayList.add(null);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PhoneContact)((Iterator)localObject1).next();
            ((PhoneContact)localObject2).pinyinFirst = baA;
            localArrayList.add(localObject2);
          }
        }
      }
      this.rH = localArrayList;
      this.ceA = this.rH.size();
      if (this.ceA > 10) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$a.notifyDataSetChanged();
        return;
        this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.mWorkerHandler.removeMessages(7);
      paramMessage = new ArrayList();
      paramMessage.add(this.f.a(this.f.W(), true));
      paramMessage.add(new ArrayList());
      this.uH = paramMessage;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$d.sendEmptyMessage(8);
    }
  }
  
  public void ie()
  {
    int i;
    if ((this.reqType == 0) || (this.reqType == 2) || (this.reqType == 5))
    {
      i = this.f.xy();
      if (QLog.isColorLevel()) {
        QLog.d("ContactListView", 2, "the load contact mode is retype=" + this.reqType + ", state=" + i);
      }
      if ((i == 1) || (i == 2) || (i == 6) || (i == 7) || (i == 3)) {
        this.mWorkerHandler.sendEmptyMessage(7);
      }
    }
    do
    {
      do
      {
        return;
        crg();
        return;
      } while (this.reqType != 3);
      i = this.f.k(this.uI);
    } while (!QLog.isColorLevel());
    QLog.d("ContactListView", 2, "load contact friend result: " + i);
  }
  
  View m()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131559743, null);
    c localc = new c(null);
    localc.vx = ((ImageView)localView.findViewById(2131373519));
    localc.Nf = ((TextView)localView.findViewById(2131373520));
    localc.vy = ((ImageView)localView.findViewById(2131373518));
    localc.nameText = ((TextView)localView.findViewById(2131372208));
    localc.eJ = ((Button)localView.findViewById(2131380187));
    localc.eJ.setOnClickListener(this);
    localc.eK = ((Button)localView.findViewById(2131380186));
    localc.eK.setOnClickListener(this);
    localc.es = ((Button)localView.findViewById(2131362194));
    localc.es.setOnClickListener(this);
    localc.Ng = ((TextView)localView.findViewById(2131362175));
    localc.yR = localView.findViewById(2131377277);
    if (this.reqType == 3)
    {
      localc.eJ.setVisibility(8);
      localc.eK.setVisibility(8);
      localc.yR.setVisibility(8);
    }
    for (;;)
    {
      localView.setTag(localc);
      return localView;
      localc.es.setVisibility(8);
      localc.Ng.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onActivityResult() ");
    }
    Object localObject;
    if (paramInt1 == 1)
    {
      if (paramInt2 == 2)
      {
        localObject = new Intent(getContext(), BindNumberActivity.class);
        ((Intent)localObject).putExtra("kNeedUnbind", true);
        startActivity((Intent)localObject);
      }
    }
    else if (paramInt2 != -1) {}
    switch (paramInt1)
    {
    default: 
    case 561247: 
      do
      {
        return;
        if (paramInt2 == 0)
        {
          int i = this.f.xy();
          if ((i != 1) && (i != 5)) {
            break;
          }
          startActivity(new Intent(getContext(), PhoneLaunchActivity.class));
          break;
        }
        if (paramInt2 == 4002)
        {
          finish();
          break;
        }
        startActivity(new Intent(getContext(), PhoneLaunchActivity.class));
        break;
      } while (paramIntent == null);
      localObject = paramIntent.getStringExtra("contactSearchResultUin");
      paramInt1 = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      String str1 = paramIntent.getStringExtra("contactSearchResultName");
      long l = paramIntent.getLongExtra("contactSearchResultPhoneContactOriginBinder", -1L);
      String str2 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
      String str3 = paramIntent.getStringExtra("contactSearchResultPhoneContactNationCode");
      paramInt2 = paramIntent.getIntExtra("contactSearchResultPhoneContactAbility", -1);
      paramIntent = null;
      if (paramInt1 == 1006) {
        if (l == 3L)
        {
          paramInt1 = 32;
          paramIntent = new ProfileActivity.AllInOne((String)localObject, paramInt1);
          paramIntent.pr = new ArrayList();
          paramIntent.contactName = str1;
          paramIntent.pr.add(new ProfileActivity.CardContactInfo(str1, str2, str3));
          paramIntent.bIW = paramInt2;
          paramIntent.bIZ = 3;
        }
      }
      for (;;)
      {
        ProfileActivity.b(this.mActivity, paramIntent);
        return;
        paramInt1 = 31;
        break;
        if (paramInt1 == 0) {
          paramIntent = new ProfileActivity.AllInOne((String)localObject, 1);
        }
      }
    }
    amxk.a(paramIntent, this.jdField_a_of_type_Ahgq);
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      onItemClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      cri();
      continue;
      if (this.reqType == 2)
      {
        finish();
      }
      else
      {
        Intent localIntent1 = this.mActivity.getIntent();
        Intent localIntent2 = new Intent(getContext(), SettingActivity2.class);
        if (localIntent1.hasExtra("kSrouce")) {
          localIntent2.putExtra("kSrouce", localIntent1.getIntExtra("kSrouce", 6));
        }
        startActivityForResult(localIntent2, 1);
        anot.a(this.app, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
        continue;
        fR(paramView);
        continue;
        fS(paramView);
        continue;
        fT(paramView);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.H, paramString, paramBitmap);
  }
  
  protected void onDestroy()
  {
    QQPimGetTipsInfoIPC.a().clear();
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.onDestroy();
    }
    if (this.mWorkerHandler != null) {
      this.mWorkerHandler.removeMessages(7);
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onResume()");
    }
    super.onResume();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.f.xy() != 9)
    {
      if (!aqiw.isNetSupport(getContext())) {
        break label99;
      }
      if (this.f.Ut()) {
        j(2131719519, 0L, false);
      }
    }
    else
    {
      return;
    }
    this.f.i(true, true, 20);
    hf();
    return;
    label99:
    X(2131696348, 3000L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mCurrentScrollState = paramInt;
    if (paramInt != 0)
    {
      this.d.edu();
      this.d.pause();
      return;
    }
    if (this.d.isPausing()) {
      this.d.resume();
    }
    int j = this.H.getChildCount();
    paramInt = 0;
    label52:
    Bitmap localBitmap;
    if (paramInt < j)
    {
      paramAbsListView = (c)this.H.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.baB)))
      {
        int i = 1;
        if (paramAbsListView.type == 3) {
          i = 11;
        }
        localBitmap = this.d.b(i, paramAbsListView.baB);
        if (localBitmap != null) {
          break label140;
        }
        this.d.i(paramAbsListView.baB, i, false);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label52;
      break;
      label140:
      paramAbsListView.vx.setImageBitmap(localBitmap);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStart()");
    }
    this.app.setHandler(ContactListView.class, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$d);
    if (this.reqType == 2) {
      this.centerView.setText(acfp.m(2131704409));
    }
    int i;
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b = new b(null);
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b);
      }
      this.app.addObserver(this.o);
      ie();
      i = this.f.xy();
      if ((this.reqType != 2) || (!(this.jdField_a_of_type_Ahgq instanceof ahlr))) {
        break;
      }
      this.MZ.setVisibility(8);
      this.d.resume();
      return;
      if ((this.reqType == 0) || (this.reqType == 5)) {
        this.centerView.setText(acfp.m(2131704411));
      } else if (this.reqType == 3) {
        this.centerView.setText(acfp.m(2131704395));
      }
    }
    this.MZ.setOnClickListener(this);
    TextView localTextView = this.MZ;
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      break;
    }
  }
  
  protected void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStop()");
    }
    this.d.pause();
    this.d.destory();
    this.app.removeHandler(ContactListView.class);
    hg();
    dismissProgressDialog();
    if (this.e != null)
    {
      this.e.cancel();
      this.e = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView$b = null;
    }
    this.app.removeObserver(this.o);
    super.onStop();
  }
  
  class a
    extends PinnedDividerListView.a
  {
    private a() {}
    
    public int ag()
    {
      return 2131559745;
    }
    
    public void b(View paramView, int paramInt)
    {
      if ((ContactListView.this.rH == null) || (ContactListView.this.rH.isEmpty()) || (paramInt < 0) || (paramInt >= ContactListView.this.rH.size())) {}
      PhoneContact localPhoneContact1;
      do
      {
        return;
        PhoneContact localPhoneContact2 = (PhoneContact)ContactListView.this.rH.get(paramInt);
        localPhoneContact1 = localPhoneContact2;
        if (localPhoneContact2 == null)
        {
          localPhoneContact1 = localPhoneContact2;
          if (paramInt + 1 < ContactListView.this.rH.size()) {
            localPhoneContact1 = (PhoneContact)ContactListView.this.rH.get(paramInt + 1);
          }
        }
      } while (localPhoneContact1 == null);
      ((TextView)paramView).setText(localPhoneContact1.pinyinFirst);
    }
    
    public int getCount()
    {
      if (ContactListView.this.rH != null) {
        return ContactListView.this.rH.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((ContactListView.this.rH == null) || (ContactListView.this.rH.isEmpty())) {}
      while (ContactListView.this.rH.get(paramInt) == null) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (getItemViewType(paramInt) == 1)
      {
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(ContactListView.this.getContext()).inflate(ag(), paramViewGroup, false);
        }
        b(localView, paramInt);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localView = paramView;
        if (paramView == null)
        {
          localView = ContactListView.this.m();
          localView.setOnClickListener(ContactListView.this);
        }
        paramView = (PhoneContact)ContactListView.this.rH.get(paramInt);
        ContactListView.this.a(localView, paramView, false);
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean t(int paramInt)
    {
      return getItemViewType(paramInt) == 1;
    }
  }
  
  class b
    extends akwl
  {
    private b() {}
    
    public void aI(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean)
      {
        ContactListView.this.hg();
        ContactListView.a(ContactListView.this, true);
        if ((paramInt & 0x1) == 0) {
          ContactListView.this.dismissProgressDialog();
        }
      }
      for (;;)
      {
        if (ContactListView.this.reqType == 6) {
          ContactListView.this.finish();
        }
        return;
        ContactListView.this.dismissProgressDialog();
      }
    }
    
    public void aJ(boolean paramBoolean1, boolean paramBoolean2)
    {
      int i = ContactListView.this.f.xy();
      if (!paramBoolean1)
      {
        ContactListView.this.hg();
        ContactListView.this.dismissProgressDialog();
        if (((i == 0) || (i == 7)) && ((ContactListView.this.reqType != 2) || (!(ContactListView.this.a instanceof ahlr))) && (ContactListView.this.ceA == 0)) {
          ContactListView.this.X(2131718828, 3000L);
        }
      }
      do
      {
        return;
        ContactListView.this.MZ.setEnabled(true);
      } while (!ContactListView.this.f.Ut());
      ContactListView.this.j(2131719519, 0L, false);
    }
    
    public void ao(boolean paramBoolean, int paramInt)
    {
      if ((!paramBoolean) || (!aqiw.isNetSupport(ContactListView.this.getContext())))
      {
        ContactListView.this.hg();
        ContactListView.this.dismissProgressDialog();
      }
    }
    
    public void xp(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactListView", 2, "onHideContact isSuccess=" + paramBoolean);
      }
      if ((paramBoolean) && (ContactListView.this.reqType == 5)) {
        ContactListView.this.ie();
      }
    }
  }
  
  static class c
  {
    public TextView Nf;
    public TextView Ng;
    public PhoneContact b;
    public String baB;
    public Button eJ;
    public Button eK;
    public Button es;
    public TextView nameText;
    public int type;
    public ImageView vx;
    public ImageView vy;
    public View yR;
  }
  
  public static class d
    extends MqqHandler
  {
    private WeakReference<ContactListView> r;
    
    public d(ContactListView paramContactListView)
    {
      this.r = new WeakReference(paramContactListView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ContactListView localContactListView = (ContactListView)this.r.get();
      if (localContactListView == null) {
        if (QLog.isColorLevel()) {
          QLog.i("ContactListView", 2, "UiHandler() handleMessage a == null");
        }
      }
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 3: 
          case 7: 
          default: 
            throw new RuntimeException("Unknown message: " + paramMessage.what);
          case 1: 
            if ((ContactListView.a(localContactListView)) && (!localContactListView.f.Ut()))
            {
              localContactListView.dismissProgressDialog();
              ContactListView.a(localContactListView, false);
            }
            localContactListView.ie();
            return;
          case 2: 
            localContactListView.ie();
          }
        } while (aqiw.isNetSupport(localContactListView.getContext()));
        localContactListView.hg();
        localContactListView.showToast(acfp.m(2131704403));
        return;
        localContactListView.uJ = ((List)paramMessage.obj);
        localContactListView.b.cS(localContactListView.uJ);
        localContactListView.b.notifyDataSetChanged();
        return;
        paramMessage = ContactListView.a(localContactListView).getAccount();
        localObject = (TicketManagerImpl)ContactListView.a(localContactListView).getManager(2);
      } while (localObject == null);
      Object localObject = ((TicketManagerImpl)localObject).getA2(paramMessage);
      if (QLog.isColorLevel()) {
        QLog.i("ContactListView", 2, "a2 = " + (String)localObject);
      }
      QQPimGetTipsInfoIPC.a().a(ContactListView.a(localContactListView), ContactListView.a(localContactListView), paramMessage, (String)localObject);
      return;
      ContactListView.a(localContactListView, (QQPimTipsInfo)paramMessage.obj);
      return;
      localContactListView.hg();
      localContactListView.crh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */