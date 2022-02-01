package com.tencent.mobileqq.qcall;

import acdu;
import acdv;
import acfd;
import acff;
import acfp;
import acle;
import ajdo;
import aljw;
import alkb;
import alkf;
import alkh;
import alki;
import alkj;
import alkk;
import alkl;
import alkm;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqdj;
import aqft;
import aqgv;
import aqqj;
import aqwu;
import aqxb;
import aqxf;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jqs;
import mqq.app.MobileQQ;
import wja;

public class QCallDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private ImageView CK;
  private ImageView CL;
  private View Gj;
  private String OD;
  private TextView XA;
  private TextView XB;
  private TextView XC;
  private TextView XD;
  private acfd jdField_a_of_type_Acfd = new alkh(this);
  aqxb jdField_a_of_type_Aqxb = new alkl(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private a jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a;
  private String aPT;
  private acdv b = new alki(this);
  private String bWT;
  private alkm d;
  private int duO;
  private int duP = -1;
  private int[] fp;
  private Button gY;
  private RelativeLayout gc;
  Runnable ho = new QCallDetailActivity.3(this);
  private RelativeLayout lC;
  private RelativeLayout lD;
  private RelativeLayout lE;
  private byte[] lock = new byte[0];
  private int mBindType;
  private String mFriendUin;
  private LinearLayout mHeaderView;
  private XListView mListView;
  private String mPhoneNumber;
  private int mUinType;
  private String peerUin;
  private String phoneNum;
  
  private void NQ(boolean paramBoolean)
  {
    if ((this.lE == null) || (this.lD == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.lD.setVisibility(0);
      this.lE.setVisibility(8);
      return;
    }
    this.lD.setVisibility(8);
    this.lE.setVisibility(0);
  }
  
  private void Tc()
  {
    this.mHeaderView = ((LinearLayout)LayoutInflater.from(this).inflate(2131563204, null));
    this.CK = ((ImageView)this.mHeaderView.findViewById(2131368375));
    this.XB = ((TextView)this.mHeaderView.findViewById(2131372190));
    this.XC = ((TextView)this.mHeaderView.findViewById(2131368128));
    this.CL = ((ImageView)this.mHeaderView.findViewById(2131372270));
    this.XD = ((TextView)this.mHeaderView.findViewById(2131372269));
    this.gc = ((RelativeLayout)this.mHeaderView.findViewById(2131370250));
    this.lC = ((RelativeLayout)this.mHeaderView.findViewById(2131370178));
    this.gY = ((Button)findViewById(2131364184));
    this.gY.setOnClickListener(this);
    this.lE = ((RelativeLayout)this.mHeaderView.findViewById(2131370215));
    this.lD = ((RelativeLayout)this.mHeaderView.findViewById(2131372406));
    this.XA = ((TextView)this.mHeaderView.findViewById(2131364923));
    this.Gj = this.mHeaderView.findViewById(2131374865);
    int i = getResources().getColor(2131166713);
    this.Gj.setBackgroundColor(i);
    Object localObject1 = this.mHeaderView.findViewById(2131374866);
    ((View)localObject1).setBackgroundColor(i);
    this.XB.setText(this.aPT);
    Object localObject3 = (TextView)this.mHeaderView.findViewById(2131368422);
    Object localObject2 = (ImageView)this.mHeaderView.findViewById(2131377282);
    switch (this.mUinType)
    {
    default: 
      this.CK.setImageDrawable(aqdj.a(this.app, 1, this.mFriendUin));
    case 3000: 
    case 1001: 
    case 1010: 
    case 2016: 
    case 56938: 
      for (;;)
      {
        localObject1 = (TextView)this.mHeaderView.findViewById(2131364638);
        ((TextView)localObject1).setContentDescription(getString(2131700799));
        ((TextView)localObject1).setOnClickListener(this);
        ThreadManager.post(new QCallDetailActivity.4(this), 8, null, true);
        NP(true);
        this.lC.setOnClickListener(this);
        this.gc.setOnClickListener(this);
        this.XD.setOnClickListener(this);
        this.XD.setOnTouchListener(new alkj(this));
        if (this.duP == -1) {
          break label1273;
        }
        localObject1 = this.app.a().createEntityManager().query(PhoneContact.class, false, "contactID = " + this.duP, null, null, null, null, null);
        anot.a(this.app, "CliOper", "", "", "0X8005AF4", "0X8005AF4", 0, 0, "", "", "", "");
        if (this.mUinType != 26) {
          break;
        }
        localObject1 = new ArrayList();
        localObject2 = new PhoneContact();
        ((PhoneContact)localObject2).mobileNo = this.mFriendUin;
        ((PhoneContact)localObject2).type = 0;
        ((PhoneContact)localObject2).label = "电话";
        ((List)localObject1).add(localObject2);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          this.mHeaderView.findViewById(2131374867).setVisibility(0);
          localObject2 = (NoScrollListView)this.mHeaderView.findViewById(2131373058);
          ((NoScrollListView)localObject2).setVisibility(0);
          ((NoScrollListView)localObject2).setAdapter(new alkb(this, (List)localObject1));
          ((NoScrollListView)localObject2).setOnItemClickListener(new alkk(this));
        }
        return;
        localObject3 = aqdj.g(1001, 1);
        this.CK.setImageDrawable(aqdj.a(this.app, 1001, this.mFriendUin, 1, (Drawable)localObject3, (Drawable)localObject3));
        this.XB.setText(aqgv.w(this.app, this.mFriendUin));
        i = aqgv.p(this.app, this.mFriendUin);
        if (i > 0)
        {
          localObject3 = "(" + i + ")";
          this.XC.setText((CharSequence)localObject3);
        }
        if ((this.lC != null) && (localObject1 != null))
        {
          this.lC.setVisibility(8);
          ((View)localObject1).setVisibility(8);
        }
        ((ImageView)localObject2).setVisibility(0);
        findViewById(2131374860).setVisibility(0);
        this.gY.setVisibility(8);
        continue;
        this.CK.setImageDrawable(aqdj.a(this.app, 200, this.mFriendUin, true));
        continue;
        this.CK.setImageResource(2130842937);
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(aqgv.pu(this.aPT));
        ((ImageView)localObject2).setVisibility(8);
        this.XD.setText(2131701525);
        ((View)localObject1).setVisibility(8);
        this.lC.setVisibility(8);
        findViewById(2131374860).setVisibility(8);
      }
    case 25: 
      label547:
      label600:
      localObject2 = (ajdo)this.app.getManager(11);
      if (localObject2 == null) {
        break;
      }
    }
    for (localObject1 = ((ajdo)localObject2).c(this.mPhoneNumber);; localObject1 = null)
    {
      if ((localObject2 != null) && (this.mPhoneNumber != null)) {
        localObject1 = ((ajdo)localObject2).c(this.mPhoneNumber);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCallDetailActivity", 2, "getFaceBitmap contact = " + localObject1);
        }
        if (localObject1 != null)
        {
          localObject2 = aqdj.b(this.app, this.mPhoneNumber, (byte)3);
          this.XB.setText(((PhoneContact)localObject1).name);
          if (localObject2 == null) {
            break;
          }
          this.CK.setImageDrawable((Drawable)localObject2);
          break;
        }
        localObject1 = this.app.getFaceBitmap(16, this.mFriendUin, (byte)3, true, 16);
        localObject2 = ((alkf)this.app.getManager(140)).a(this.mFriendUin);
        if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
          this.XB.setText(((QCallCardInfo)localObject2).nickname);
        }
        if (localObject1 == null) {
          break;
        }
        this.CK.setImageBitmap((Bitmap)localObject1);
        break;
        this.bWT = null;
        PhoneContact localPhoneContact = aljw.a(this.app, this.mFriendUin);
        if (localPhoneContact != null) {
          this.bWT = localPhoneContact.uin;
        }
        if (this.bWT == null)
        {
          ((ImageView)localObject2).setVisibility(8);
          this.CK.setImageResource(2130842937);
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText(aqgv.pu(this.aPT));
        }
        for (;;)
        {
          findViewById(2131374860).setVisibility(8);
          this.gY.setVisibility(0);
          ((View)localObject1).setVisibility(8);
          this.lC.setVisibility(8);
          break;
          ((ImageView)localObject2).setVisibility(0);
          this.CK.setImageDrawable(aljw.a(this.app, this.mFriendUin));
        }
        break label600;
        label1273:
        localObject1 = null;
        break label547;
      }
    }
  }
  
  private void bFq()
  {
    if (this.mUinType == 3000)
    {
      this.CL.setVisibility(8);
      this.XD.setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataFriends == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 68104) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType == 65805))
      {
        this.CL.setVisibility(8);
        this.XD.setVisibility(8);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCallDetailActivity", 2, "friend.getNetWorkType()：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() + ", friend.detalStatusFlag：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag + ", friend.iTermType：" + this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
      }
    } while (aqgv.aU(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType) == 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 2)
      {
        this.CL.setVisibility(8);
        this.XD.setText(2131700820);
        this.XD.setContentDescription(getString(2131700820));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 3)
      {
        this.CL.setVisibility(8);
        this.XD.setText(2131700821);
        this.XD.setContentDescription(getString(2131700821));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.getNetWorkType() == 4)
      {
        this.CL.setVisibility(8);
        this.XD.setText(2131700822);
        this.XD.setContentDescription(getString(2131700822));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 7)
      {
        this.CL.setVisibility(8);
        this.XD.setText(getString(2131700825));
        this.XD.setContentDescription(getString(2131700825));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 8)
      {
        this.CL.setVisibility(8);
        this.XD.setText(getString(2131700823));
        this.XD.setContentDescription(getString(2131700823));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 9)
      {
        this.CL.setVisibility(8);
        this.XD.setText(getString(2131700824));
        this.XD.setContentDescription(getString(2131700824));
        return;
      }
      this.CL.setVisibility(0);
      this.CL.setBackgroundResource(2130845932);
      this.XD.setText(2131700826);
      this.XD.setContentDescription(getString(2131700826));
      return;
    }
    this.CL.setVisibility(8);
  }
  
  private void bKH()
  {
    if (this.duO == 1024)
    {
      jqs.a(this, null, this.mFriendUin, false, -1, true, 2000);
      return;
    }
    if (this.duO == 1008)
    {
      localObject = new Intent(this, AccountDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.mFriendUin);
      ((Intent)localObject).putExtra("uintype", 1008);
      ((Intent)localObject).putExtra("source", 113);
      startActivityForResult((Intent)localObject, 2000);
      return;
    }
    Object localObject = new ProfileActivity.AllInOne(this.mFriendUin, 46);
    ((ProfileActivity.AllInOne)localObject).pa = 19;
    ((ProfileActivity.AllInOne)localObject).nickname = aqgv.s(this.app, this.mFriendUin);
    label284:
    label350:
    Intent localIntent;
    switch (this.duO)
    {
    default: 
      if ((this.duO != 1001) && (this.duO != 10002) && (this.duO != 10004) && (this.duO != 1010)) {
        break label651;
      }
      if ((this.duO == 1001) || (this.duO == 10002))
      {
        ((ProfileActivity.AllInOne)localObject).bJa = 12;
        localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!aqft.equalsWithNullCheck(this.mFriendUin, this.app.getCurrentAccountUin())) {
          break label639;
        }
        localIntent.putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      ((ProfileActivity.AllInOne)localObject).pa = 1;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 20;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 86;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 42;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 76;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 22;
      ((ProfileActivity.AllInOne)localObject).troopUin = this.OD;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 70;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 47;
      ((ProfileActivity.AllInOne)localObject).discussUin = this.OD;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 2;
      break label284;
      if (TextUtils.isEmpty(this.bWT)) {
        break;
      }
      if (this.bWT.equals("0"))
      {
        ((ProfileActivity.AllInOne)localObject).pa = 34;
        break label284;
      }
      ((ProfileActivity.AllInOne)localObject).pa = 1;
      ((ProfileActivity.AllInOne)localObject).uin = this.bWT;
      ((ProfileActivity.AllInOne)localObject).nickname = aqgv.s(this.app, this.bWT);
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 34;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 57;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 72;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 74;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 27;
      break label284;
      ((ProfileActivity.AllInOne)localObject).pa = 58;
      break label284;
      dGu();
      return;
      if (this.duO != 1010) {
        break label350;
      }
      ((ProfileActivity.AllInOne)localObject).bJa = 13;
      break label350;
      label639:
      localIntent.putExtra("param_mode", 3);
    }
    label651:
    ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
  }
  
  private void dF(Intent paramIntent)
  {
    if (paramIntent == null) {
      finish();
    }
    do
    {
      return;
      this.mFriendUin = paramIntent.getStringExtra("uin");
      this.OD = paramIntent.getStringExtra("troop_uin");
      this.mUinType = paramIntent.getIntExtra("uintype", 0);
      if (this.mUinType == 8) {
        this.mUinType = paramIntent.getIntExtra("extra_type", 0);
      }
      this.aPT = paramIntent.getStringExtra("uinname");
      this.mBindType = paramIntent.getIntExtra("bind_type", 0);
      this.mPhoneNumber = paramIntent.getStringExtra("phonenum");
      if (this.mBindType == 2) {
        anot.a(this.app, "CliOper", "", "", "0X8004E95", "0X8004E95", 0, 0, "", "", "", "");
      }
      this.rightViewImg.setVisibility(8);
      this.duO = this.mUinType;
      if ((this.duO == 0) && (!hf(this.mFriendUin))) {
        this.duO = 1003;
      }
      this.duP = paramIntent.getIntExtra("contactID", -1);
    } while (this.duP != -1);
    paramIntent = (ajdo)this.app.getManager(11);
    switch (this.mUinType)
    {
    default: 
      paramIntent = paramIntent.a(this.mFriendUin);
    }
    while (paramIntent != null)
    {
      this.duP = paramIntent.contactID;
      return;
      paramIntent = paramIntent.c(this.mFriendUin);
      continue;
      paramIntent = paramIntent.b(this.mFriendUin);
    }
  }
  
  private void dGr()
  {
    acff localacff = (acff)this.app.getManager(51);
    if (QLog.isColorLevel()) {
      QLog.d("QCallDetailActivity", 2, "updateOnlineStatus mFriendUin : " + this.mFriendUin + " , uinType = " + this.mUinType);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = localacff.e(this.mFriendUin);
  }
  
  private void dGs()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131374863);
    Button localButton1 = (Button)localLinearLayout1.findViewById(2131381048);
    localLinearLayout1.setOnClickListener(this);
    localButton1.setTag(Integer.valueOf(2131374863));
    localButton1.setOnClickListener(this);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131374862);
    Object localObject = (Button)localLinearLayout2.findViewById(2131381048);
    localLinearLayout2.setOnClickListener(this);
    ((Button)localObject).setTag(Integer.valueOf(2131374862));
    ((Button)localObject).setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131374861);
    Button localButton2 = (Button)((LinearLayout)localObject).findViewById(2131381048);
    ((LinearLayout)localObject).setOnClickListener(this);
    localButton2.setTag(Integer.valueOf(2131374861));
    localButton2.setOnClickListener(this);
    localButton1.setText(2131719495);
    if (this.mUinType == 3000)
    {
      localButton1.setContentDescription(acfp.m(2131710985));
      localButton2.setText(2131694852);
      localButton2.setContentDescription(localButton2.getResources().getString(2131694847));
      localLinearLayout2.setVisibility(8);
    }
    for (;;)
    {
      if (this.mUinType != 0)
      {
        ((LinearLayout)localObject).setVisibility(8);
        localLinearLayout2.setVisibility(8);
      }
      return;
      if (this.mUinType == 1008)
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton2.setText(2131694847);
        localButton2.setContentDescription(getString(2131700792));
        this.lC.setVisibility(8);
      }
      else if ((this.mBindType == 2) || (this.mBindType == 3) || (this.mUinType == 25))
      {
        localLinearLayout2.setVisibility(8);
        localLinearLayout1.setVisibility(8);
        localButton2.setText(2131694847);
        localButton2.setContentDescription(getString(2131700792));
      }
      else
      {
        localLinearLayout2.setVisibility(8);
        localButton1.setContentDescription(acfp.m(2131710984));
        localButton2.setText(2131694847);
        localButton2.setContentDescription(localButton2.getResources().getString(2131694847));
      }
    }
  }
  
  private void dGt()
  {
    if (this.mUinType == 3000)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004068", "0X8004068", 0, 0, "", "", "", "");
      anot.a(this.app, "CliOper", "", "", "0X8004F91", "0X8004F91", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.app, this, this.mUinType, this.peerUin, true, true, null, null);
      return;
    }
    anot.a(this.app, "CliOper", "", this.mFriendUin, "Two_video_call", "Tvc_msg_info_launch", 0, 0, "", "", "", "");
    anot.a(this.app, "CliOper", "", "", "0X8004F8A", "0X8004F8A", 0, 0, "", "", "", "");
    if (this.mUinType == 1024)
    {
      jqs.a(this.app, this, this.aPT, this.peerUin, "IvrCallDetailEngineFalse");
      return;
    }
    ChatActivityUtils.a(this.app, this, this.mUinType, this.peerUin, this.aPT, this.phoneNum, true, this.OD, true, true, null, "from_internal");
  }
  
  private void dGu()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.mFriendUin, 80);
    QCallCardInfo localQCallCardInfo = ((alkf)this.app.getManager(140)).a(this.mFriendUin);
    Object localObject = (ajdo)this.app.getManager(11);
    if ((localObject != null) && (this.mPhoneNumber != null)) {}
    for (localObject = ((ajdo)localObject).c(this.mPhoneNumber);; localObject = null)
    {
      if (localQCallCardInfo != null)
      {
        localAllInOne.nickname = localQCallCardInfo.nickname;
        localAllInOne.gender = ((byte)localQCallCardInfo.gender);
        if (QLog.isColorLevel()) {
          QLog.i("startQCallProfileCardActivity ", 2, "QCallCardInfo.uin = " + localQCallCardInfo.uin + "QCallCardInfo.nickname = " + localQCallCardInfo.nickname + "mPhoneNumber = " + this.mPhoneNumber + "mFriendUin = " + this.mFriendUin);
        }
      }
      if (localObject != null) {
        localAllInOne.nickname = ((PhoneContact)localObject).name;
      }
      if (((localObject != null) || (localQCallCardInfo != null)) && (this.mPhoneNumber != null))
      {
        localAllInOne.pa = 80;
        localObject = new ProfileActivity.CardContactInfo(acfp.m(2131710983), this.mPhoneNumber, "");
        if (localAllInOne.pr == null)
        {
          localAllInOne.pr = new ArrayList();
          localAllInOne.pr.add(localObject);
        }
        ProfileActivity.b(this.app.getApplication().getApplicationContext(), localAllInOne);
        if (this.mUinType != 25) {
          break label304;
        }
        anot.a(null, "CliOper", "", "", "0X8006251", "0X8006251", 0, 0, "", "", "", "");
      }
      label304:
      while ((this.mUinType != 24) && (this.mBindType != 2) && (this.mBindType != 3)) {
        return;
      }
      anot.a(null, "CliOper", "", "", "0X8006250", "0X8006250", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private String eM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  private boolean hf(String paramString)
  {
    return ((acff)this.app.getManager(51)).isFriend(paramString);
  }
  
  private void initListView()
  {
    this.mListView = ((XListView)findViewById(2131374864));
    this.mListView.addHeaderView(this.mHeaderView);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a = new a();
    this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a);
  }
  
  private void refreshList()
  {
    ThreadManager.post(this.ho, 8, null, false);
  }
  
  void NP(boolean paramBoolean)
  {
    int i = aqwu.a(this.app, this.mFriendUin, 6, true, null);
    if ((i == 0) && (paramBoolean) && (this.app != null)) {}
    try
    {
      Object localObject1 = (aqxf)this.app.getBusinessHandler(46);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("uin", Long.parseLong(this.mFriendUin));
      ((Bundle)localObject2).putString("phone", "");
      this.app.addObserver(this.jdField_a_of_type_Aqxb, true);
      ((aqxf)localObject1).J(2, localObject2);
      if (i == 0)
      {
        localObject1 = getResources().getString(2131691236);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131691236);
        }
        this.XA.setText((CharSequence)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QCallDetailActivity", 1, "VipSetFunCallHandler Error:" + localException.getMessage());
        continue;
        String str = aqwu.b(this.app, i, -1, "name");
      }
    }
  }
  
  public void Oo(String paramString)
  {
    if (isFinishing()) {}
    acdu localacdu;
    DiscussionInfo localDiscussionInfo;
    do
    {
      do
      {
        return;
        localacdu = (acdu)this.app.getManager(53);
      } while (localacdu == null);
      localDiscussionInfo = localacdu.a(paramString);
    } while ((localDiscussionInfo == null) || (localDiscussionInfo.discussionName == null));
    this.aPT = localDiscussionInfo.discussionName;
    this.CK.setImageDrawable(aqdj.a(this.app, 101, paramString));
    int i = localacdu.cn(paramString);
    this.XB.setText(this.aPT);
    paramString = "";
    if (i > 0) {
      paramString = "(" + i + ")";
    }
    this.XC.setText(paramString);
  }
  
  public void dGv()
  {
    Intent localIntent = new Intent(this, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.mFriendUin);
    localIntent.putExtra("uinname", this.aPT);
    localIntent.putExtra("uintype", this.duO);
    startActivityForResult(localIntent, 2000);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    boolean bool1;
    do
    {
      return;
      boolean bool2 = false;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
    } while (!bool1);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561250);
    paramBundle = getString(2131700836);
    setTitle(paramBundle, paramBundle + getString(2131698130));
    setLeftViewName(2131697624);
    this.d = ((alkm)this.app.getManager(38));
    dF(getIntent());
    Tc();
    dGs();
    initListView();
    addObserver(this.jdField_a_of_type_Acfd);
    addObserver(this.b);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    if ((this.mUinType == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.ZY()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.ZZ())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.bE(this.mFriendUin, false);
    }
    this.fp = new int[3];
    if (this.mUinType == 25) {
      anot.a(null, "CliOper", "", "", "0X800624F", "0X800624F", 0, 0, "", "", "", "");
    }
    while ((this.mUinType != 24) && (this.mBindType != 2) && (this.mBindType != 3)) {
      return true;
    }
    anot.a(null, "CliOper", "", "", "0X800624E", "0X800624E", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    this.peerUin = null;
    this.phoneNum = null;
    label28:
    int i;
    if (this.mUinType == 1006)
    {
      this.phoneNum = this.mFriendUin;
      i = paramView.getId();
      if (2131381048 != i) {
        break label1110;
      }
    }
    label1110:
    for (;;)
    {
      try
      {
        int j = ((Integer)paramView.getTag()).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        continue;
        finish();
        continue;
        if (this.mUinType != 3000) {
          continue;
        }
        anot.a(this.app, "CliOper", "", "", "0X8004069", "0X8004069", 0, 0, "", "", "", "");
        anot.a(this.app, "CliOper", "", "", "0X8004F90", "0X8004F90", 0, 0, "", "", "", "");
        Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
        localIntent.putExtra("uin", this.mFriendUin);
        localIntent.putExtra("uintype", this.mUinType);
        localIntent.putExtra("uinname", this.aPT);
        localIntent.putExtra("entrance", 0);
        startActivity(localIntent);
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8004F89", "0X8004F89", 0, 0, "", "", "", "");
        continue;
        anot.a(this.app, "CliOper", "", this.mFriendUin, "Two_call", "Two_call_launch", 0, 0, "15", eM(this.mUinType), "", "");
        anot.a(this.app, "CliOper", "", "", "0X8004F8B", "0X8004F8B", 0, 0, "", "", "", "");
        if (this.mUinType != 1024) {
          continue;
        }
        if (!jqs.c(this.app, this.peerUin, this.mUinType)) {
          continue;
        }
        jqs.a(this.app, this, this.aPT, this.peerUin, "IvrCallDetailEngineFalse");
        anot.a(this.app, "CliOper", "", "", "0X80049D6", "0X80049D6", 0, 0, "", "", "", "");
        continue;
        QQToast.a(paramView.getContext(), 2131697893, 1).show(paramView.getContext().getResources().getDimensionPixelSize(2131299627));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QCallDetailActivity", 2, "Don't support ivr");
        continue;
        ChatActivityUtils.a(this.app, this, this.mUinType, this.peerUin, this.aPT, this.phoneNum, false, this.OD, true, true, null, "from_internal");
        continue;
        dGt();
        continue;
        if (this.mUinType != 26) {
          continue;
        }
        aljw.f(this.app, this, this.mFriendUin);
        continue;
        i = ((acle)this.app.getBusinessHandler(13)).AX();
        if (i != 2) {
          continue;
        }
        i = 0;
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("individuation_url_type", 40304);
        VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.o(this, "call", "mvip.gongneng.anroid.individuation.web"), 524288L, localIntent, true, -1);
        anot.a(this.app, "CliOper", "", "", "0X8004A1F", "0X8004A1F", 0, 0, "" + i, "", "", "");
        continue;
        if (i != 3) {
          continue;
        }
        i = 2;
        continue;
        switch (this.mUinType)
        {
        case 2016: 
        case 56938: 
        default: 
          bKH();
          anot.a(this.app, "CliOper", "", "", "0X8004F8C", "0X8004F8C", 0, 0, "", "", "", "");
          break;
        case 3000: 
          anot.a(this.app, "CliOper", "", "", "0X8004F92", "0X8004F92", 0, 0, "", "", "", "");
          dGv();
          continue;
          anot.a(this.app, "CliOper", "", this.mFriendUin, "Two_call", "Tc_msg_dinfo", 0, 0, "", "", "", "");
          if (this.mUinType == 3000)
          {
            anot.a(this.app, "CliOper", "", "", "0X8004F93", "0X8004F93", 0, 0, "", "", "", "");
            if ((this.mBindType == 2) || (this.mBindType == 3) || (this.mUinType == 25))
            {
              this.d.fD(this.mFriendUin, 8);
              NQ(true);
              this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a.records.clear();
              this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a.notifyDataSetChanged();
            }
          }
          else
          {
            anot.a(this.app, "CliOper", "", "", "0X8004F8D", "0X8004F8D", 0, 0, "", "", "", "");
            continue;
          }
          this.d.fD(this.mFriendUin, this.mUinType);
          break;
        }
        continue;
      }
      switch (i)
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.peerUin = this.mFriendUin;
        break label28;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Aqxb);
    }
    ChatActivityUtils.bJr();
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a.records = null;
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity$a = null;
    }
    ThreadManager.remove(this.ho);
    this.ho = null;
    removeObserver(this.jdField_a_of_type_Acfd);
    removeObserver(this.b);
  }
  
  public void onResume()
  {
    super.onResume();
    refreshList();
  }
  
  class a
    extends BaseAdapter
  {
    public List<QCallRecord> records = new CopyOnWriteArrayList();
    
    public a() {}
    
    private int a(QCallRecord paramQCallRecord)
    {
      if (paramQCallRecord.isSender()) {
        return 2130845941;
      }
      if ((paramQCallRecord.isMissCall()) || (paramQCallRecord.state == 1) || ((paramQCallRecord.uinType == 3000) && (paramQCallRecord.state == 8))) {
        return 2130845947;
      }
      return 2130845936;
    }
    
    private String a(QCallRecord paramQCallRecord)
    {
      if (paramQCallRecord.uinType == 3000)
      {
        switch (paramQCallRecord.state)
        {
        default: 
          paramQCallRecord = QCallDetailActivity.this.getString(2131700805);
        case 1: 
        case 2: 
        case 8: 
        case 3: 
        case 4: 
          String str;
          do
          {
            return paramQCallRecord;
            return QCallDetailActivity.this.getString(2131700805);
            return QCallDetailActivity.this.getString(2131700807);
            paramQCallRecord = paramQCallRecord.getTalkTimeMinute();
            return QCallDetailActivity.this.getString(2131700804, new Object[] { paramQCallRecord });
            str = paramQCallRecord.getTalkTimeMinute();
            paramQCallRecord = QCallDetailActivity.this.getString(2131700806);
          } while (TextUtils.isEmpty(str));
          return QCallDetailActivity.this.getString(2131700804, new Object[] { str });
        }
        if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
          return String.format(QCallDetailActivity.this.getString(2131700800), new Object[] { paramQCallRecord.getTalkTimeMinute() });
        }
        return QCallDetailActivity.this.getString(2131700797);
      }
      switch (paramQCallRecord.state)
      {
      default: 
        return "";
      case 0: 
      case 9: 
      case 15: 
        if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
          return String.format(QCallDetailActivity.this.getString(2131700800), new Object[] { paramQCallRecord.getTalkTimeMinute() });
        }
        return QCallDetailActivity.this.getString(2131700801);
      case 2: 
      case 24: 
        if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
          return String.format(QCallDetailActivity.this.getString(2131700800), new Object[] { paramQCallRecord.getTalkTimeMinute() });
        }
        return QCallDetailActivity.this.getString(2131700832);
      case 1: 
        return QCallDetailActivity.this.getString(2131700807);
      case 3: 
        return QCallDetailActivity.this.getString(2131721723);
      case 10: 
        return QCallDetailActivity.this.getString(2131700807);
      case 7: 
        return QCallDetailActivity.this.getString(2131721724);
      case 12: 
        if (paramQCallRecord.isSender()) {
          return QCallDetailActivity.this.getString(2131700797);
        }
        return QCallDetailActivity.this.getString(2131700807);
      case 42: 
      case 43: 
        return QCallDetailActivity.this.getString(2131700797);
      case 46: 
      case 47: 
      case 48: 
        if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
          return String.format(QCallDetailActivity.this.getString(2131700800), new Object[] { paramQCallRecord.getTalkTimeMinute() });
        }
        return QCallDetailActivity.this.getString(2131700801);
      case 49: 
        return QCallDetailActivity.this.getString(2131721725);
      case 6: 
        return QCallDetailActivity.this.getString(2131700807);
      case 58: 
        return QCallDetailActivity.this.getString(2131700829);
      }
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(QCallDetailActivity.this.getString(2131700800), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return QCallDetailActivity.this.getString(2131700797);
    }
    
    public int getCount()
    {
      if (this.records == null) {
        this.records = new CopyOnWriteArrayList();
      }
      return this.records.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.records.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (((QCallRecord)this.records.get(paramInt)).type == QCallRecord.TYPE_DATE) {
        return QCallRecord.TYPE_DATE;
      }
      return QCallRecord.TYPE_REALRECORD;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      QCallDetailActivity.b localb;
      if (paramView == null)
      {
        localb = new QCallDetailActivity.b();
        if (i == QCallRecord.TYPE_DATE)
        {
          paramView = LayoutInflater.from(QCallDetailActivity.this).inflate(2131561249, null);
          localb.time = ((TextView)paramView.findViewById(2131365598));
          localb.image = ((ImageView)paramView.findViewById(2131370458));
          paramView.setTag(localb);
        }
      }
      for (;;)
      {
        localb = (QCallDetailActivity.b)paramView.getTag();
        QCallRecord localQCallRecord = (QCallRecord)this.records.get(paramInt);
        if (i == QCallRecord.TYPE_DATE)
        {
          localb.time.setText(localQCallRecord.getDateString());
          i = QCallDetailActivity.this.getResources().getColor(2131166713);
          localb.image.setBackgroundColor(i);
        }
        label429:
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          paramView = LayoutInflater.from(QCallDetailActivity.this).inflate(2131561253, null);
          localb.time = ((TextView)paramView.findViewById(2131379661));
          localb.image = ((ImageView)paramView.findViewById(2131378717));
          localb.XE = ((TextView)paramView.findViewById(2131378741));
          localb.text = ((TextView)paramView.findViewById(2131378725));
          break;
          String str1 = localQCallRecord.getTime();
          localb.time.setText(str1);
          localb.image.setImageResource(a(localQCallRecord));
          String str2 = a(localQCallRecord);
          localb.text.setText(str2);
          if (localQCallRecord.isVideo())
          {
            localb.XE.setText(2131700835);
            localb.XE.setVisibility(0);
          }
          for (;;)
          {
            if (!AppSetting.enableTalkBack) {
              break label429;
            }
            paramView.setContentDescription(str1 + str2);
            break;
            if ((localQCallRecord.state == 58) || (localQCallRecord.state == 57) || (localQCallRecord.uinType == 26))
            {
              localb.XE.setVisibility(8);
            }
            else if (localQCallRecord.uinType == 8)
            {
              localb.XE.setText("");
              localb.XE.setVisibility(0);
            }
            else
            {
              localb.XE.setVisibility(8);
            }
          }
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
  }
  
  static class b
  {
    TextView XE;
    ImageView image;
    TextView text;
    TextView time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity
 * JD-Core Version:    0.7.0.1
 */