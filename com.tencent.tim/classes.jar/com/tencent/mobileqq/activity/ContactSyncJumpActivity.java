package com.tencent.mobileqq.activity;

import acfd;
import acff;
import aevy;
import aewd;
import akwl;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdj;
import aqgv;
import aqiw;
import asgx;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import jqs;
import urt;
import uru;
import urv;
import urw;
import urx;
import wja;

public class ContactSyncJumpActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public Dialog H = null;
  private String MO;
  private aevy a;
  private String aMx;
  private String aMy;
  private String aMz;
  private akwl jdField_b_of_type_Akwl = new urx(this);
  private ChatActivityUtils.c jdField_b_of_type_ComTencentMobileqqActivityChatActivityUtils$c = new urt(this);
  private PhoneContactManagerImp jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private int bFZ;
  public int bGa;
  private DialogInterface.OnCancelListener d = new urw(this);
  private acfd h = new uru(this);
  private Handler mHandler = new urv(this);
  private String mMimeType;
  private String peerUin;
  
  private boolean Pq()
  {
    boolean bool2 = true;
    this.app.registObserver(this.jdField_b_of_type_Akwl);
    Uri localUri = getIntent().getData();
    if (!TextUtils.isEmpty(this.aMx)) {}
    for (Object localObject = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.aMx);; localObject = null)
    {
      boolean bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("dealWithBindOK | getTargetPhoneContact | uri = ").append(localUri).append(" | mobileNo = ").append(aevy.kq(this.aMx)).append(" | pc = ");
        if (localObject != null)
        {
          bool1 = true;
          QLog.d("ContactSync.JumpActivity", 2, bool1);
        }
      }
      else
      {
        if (localObject == null) {
          break label211;
        }
        this.peerUin = ((PhoneContact)localObject).uin;
        this.aMy = ((PhoneContact)localObject).nationCode;
        this.aMz = ((PhoneContact)localObject).mobileCode;
        this.MO = ((PhoneContact)localObject).name;
        this.bFZ = ((PhoneContact)localObject).ability;
        label154:
        if (((TextUtils.isEmpty(this.peerUin)) || (this.peerUin.equals("0"))) && (TextUtils.isEmpty(this.aMz))) {
          break label366;
        }
        if (!this.mMimeType.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) {
          break label297;
        }
        bMa();
        bool1 = false;
      }
      label211:
      do
      {
        return bool1;
        bool1 = false;
        break;
        localObject = this.a.a(localUri);
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "dealWithBindOK | pc is null | simplePc = " + localObject);
        }
        if (localObject == null) {
          break label154;
        }
        this.peerUin = "0";
        this.aMy = ((aewd)localObject).nationCode;
        this.aMz = ((aewd)localObject).mobileCode;
        this.MO = ((aewd)localObject).name;
        this.bFZ = ((aewd)localObject).ability;
        break label154;
        be(2, null);
        bool1 = bool2;
      } while (!aqiw.isNetSupport(this));
      label297:
      localObject = (FriendListHandler)this.app.getBusinessHandler(1);
      this.app.addObserver(this.h);
      ((FriendListHandler)localObject).bE(this.aMy + this.aMz, true);
      return true;
      label366:
      localObject = String.format(getResources().getString(2131700854), new Object[] { this.MO });
      this.a.HB(this.aMx);
      be(1, (String)localObject);
      return true;
    }
  }
  
  private Dialog a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365903);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView4 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramString);
    if (paramInt2 == 0) {
      localTextView3.setVisibility(8);
    }
    for (;;)
    {
      localTextView4.setText(paramInt3);
      localTextView3.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return localReportDialog;
      localTextView3.setText(paramInt2);
    }
  }
  
  private boolean aj(boolean paramBoolean)
  {
    Object localObject = getIntent();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "doJump | intent = " + localObject);
    }
    if (localObject != null) {
      try
      {
        if ((!TextUtils.isEmpty(((Intent)localObject).getAction())) || (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false)) || (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))) {
          if (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false))
          {
            if (!((Intent)localObject).getBooleanExtra("key_change", false))
            {
              finish();
              return false;
            }
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
          }
        }
        while ((paramBoolean) && (!this.app.isLogin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is not login");
          }
          localObject = new Intent(this, LoginActivity.class);
          ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
          ((Intent)localObject).putExtra("key_orginal_intent", getIntent());
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(536870912);
          startActivity((Intent)localObject);
          finish();
          return false;
          if (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))
          {
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
            continue;
            return false;
          }
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump", localException1);
        }
      }
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      Intent localIntent = new Intent(this, GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_req_by_contact_sync", true);
      localIntent.putExtra("key_orginal_intent", getIntent());
      startActivity(localIntent);
      finish();
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.a = ((aevy)this.app.getManager(41));
    int i;
    String str;
    try
    {
      this.mMimeType = this.a.c(getIntent().getData());
      if ((this.mMimeType == null) || ((!this.mMimeType.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) && (!this.mMimeType.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | error mimeType = " + this.mMimeType);
        }
        finish();
        return false;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", localException2);
        }
      }
      this.aMx = this.a.d(getIntent().getData());
      i = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.xy();
      str = this.a.ui();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is login | bind state is " + i + " | currentUin = " + aevy.kp(this.app.getCurrentAccountUin()) + " | syncUin = " + aevy.kp(str));
      }
      if (i != 0) {
        break label667;
      }
    }
    if (str.equals(this.app.getCurrentAccountUin())) {
      return Pq();
    }
    for (;;)
    {
      return gb(i);
      label667:
      do
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Ur()) || (str.equals(this.app.getCurrentAccountUin()))) {
          return Pq();
        }
        paramBoolean = gb(i);
        return paramBoolean;
        if ((i == 5) || (i == 1)) {
          break;
        }
      } while (i != 0);
    }
  }
  
  private void bMa()
  {
    anot.a(this.app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
    if (!this.peerUin.equals("0"))
    {
      localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtra("uin", this.peerUin);
      localObject = (acff)this.app.getManager(51);
      if (localObject != null)
      {
        localObject = ((acff)localObject).e(this.peerUin);
        if (localObject != null)
        {
          localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
          localIntent.putExtra("uinname", aqgv.c((Friends)localObject));
          if ((jqs.cU(((Friends)localObject).cSpecialFlag)) || (asgx.mS(((Friends)localObject).cSpecialFlag)))
          {
            localIntent.setClass(this, SplashActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("key_req_by_contact_sync", true);
      startActivity(localIntent);
      finish();
      return;
    }
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("entrance", 0);
    localIntent.putExtra("uin", this.aMy + this.aMz);
    localIntent.putExtra("uintype", 1006);
    localIntent.putExtra("uinname", this.MO);
    Object localObject = new ProfileActivity.AllInOne(this.aMy + this.aMz, 31);
    ((ProfileActivity.AllInOne)localObject).pr = new ArrayList();
    ((ProfileActivity.AllInOne)localObject).contactName = this.MO;
    ((ProfileActivity.AllInOne)localObject).pr.add(new ProfileActivity.CardContactInfo(this.MO, this.aMz, this.aMy));
    ((ProfileActivity.AllInOne)localObject).bIW = this.bFZ;
    ((ProfileActivity.AllInOne)localObject).bJa = 59;
    localIntent.putExtra("AIO_INFO", (Parcelable)localObject);
    localIntent.putExtra("key_req_by_contact_sync", true);
    startActivity(localIntent);
    finish();
  }
  
  private void bMb()
  {
    String str;
    if (!this.peerUin.equals("0"))
    {
      i = 1;
      QQAppInterface localQQAppInterface = this.app;
      if (i == 0) {
        break label130;
      }
      str = "0";
      label26:
      anot.a(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", str, "", "");
      if (i == 0) {
        break label137;
      }
    }
    label130:
    label137:
    for (int i = 0;; i = 1006)
    {
      str = this.aMy + this.aMz;
      if (ChatActivityUtils.a(this.app, this, i, this.peerUin, this.MO, str, true, null, true, true, this.jdField_b_of_type_ComTencentMobileqqActivityChatActivityUtils$c, "from_app_contact")) {
        finish();
      }
      return;
      i = 0;
      break;
      str = "3";
      break label26;
    }
  }
  
  private void be(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "showAlertDialog | type = " + paramInt + " | current type = " + this.bGa);
    }
    if (this.H != null)
    {
      this.H.dismiss();
      this.H = null;
    }
    this.bGa = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.H != null)
      {
        this.H.setOnCancelListener(this.d);
        this.H.show();
      }
      return;
      this.H = a(2131700870, paramString, 2131700867, 2131700869);
      continue;
      this.H = a(2131700856, paramString, 0, 2131700855);
      continue;
      this.H = c();
    }
  }
  
  private Dialog c()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561287);
    Object localObject2 = (ImageView)localReportDialog.findViewById(2131365886);
    if (this.peerUin.equals("0")) {}
    for (Object localObject1 = aqdj.a(this.app, 11, this.aMy + this.aMz);; localObject1 = aqdj.a(this.app, 1, this.peerUin))
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      Object localObject3 = (TextView)localReportDialog.findViewById(2131365892);
      localObject1 = (TextView)localReportDialog.findViewById(2131365900);
      TextView localTextView = (TextView)localReportDialog.findViewById(2131365889);
      localObject2 = (TextView)localReportDialog.findViewById(2131365895);
      ((TextView)localObject3).setText(this.MO);
      localTextView.setText(2131700867);
      localTextView.setOnClickListener(this);
      ((TextView)localObject2).setText(String.format(getResources().getString(2131700863), new Object[] { "" }));
      if (!aqiw.isNetSupport(this)) {
        break;
      }
      localObject3 = getResources().getDrawable(2130839657);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, null, null, null);
      ((TextView)localObject1).setCompoundDrawablePadding(10);
      ((Animatable)localObject3).start();
      ((TextView)localObject2).setOnClickListener(this);
      return localReportDialog;
    }
    ((TextView)localObject1).setText(2131700865);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131165758));
    ((TextView)localObject2).setEnabled(false);
    return localReportDialog;
  }
  
  private boolean gb(int paramInt)
  {
    String str2 = this.a.ui();
    String str3 = this.app.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "dealWithUnbind | syncUin = " + aevy.kp(str2) + " | loginUin = " + aevy.kp(str3) + " | bindState = " + paramInt);
    }
    if ((paramInt == 5) || (paramInt == 1) || (paramInt == 0)) {}
    for (String str1 = getResources().getString(2131700871);; str1 = getResources().getString(2131700872))
    {
      be(0, String.format(str1, new Object[] { aevy.ks(str3), aevy.ks(str2) }));
      return true;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return aj(true);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mHandler.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.h);
    this.app.unRegistObserver(this.jdField_b_of_type_Akwl);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.mHandler.removeCallbacksAndMessages(null);
    this.app.unRegistObserver(this.jdField_b_of_type_Akwl);
    setIntent(paramIntent);
    aj(true);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    finish();
  }
  
  public void finish()
  {
    if ((this.H != null) && (this.H.isShowing()) && (this.H.getWindow() != null)) {
      this.H.dismiss();
    }
    super.finish();
  }
  
  public boolean isScreenLocked()
  {
    return ((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.bGa == 0)
      {
        this.H.dismiss();
        finish();
      }
      else if (this.bGa == 2)
      {
        finish();
        continue;
        if (this.bGa == 0)
        {
          this.H.dismiss();
          Intent localIntent = new Intent();
          localIntent.setPackage(getPackageName());
          localIntent.setClass(this, LoginActivity.class);
          localIntent.putExtra("IS_ADD_ACCOUNT", true);
          localIntent.putExtra("key_req_by_contact_sync", true);
          localIntent.putExtra("key_uin_to_login", this.a.ui());
          localIntent.putExtra("key_orginal_intent", getIntent());
          localIntent.addFlags(67108864);
          localIntent.addFlags(536870912);
          startActivity(localIntent);
          finish();
        }
        else if (this.bGa == 2)
        {
          bMb();
        }
        else
        {
          finish();
        }
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity
 * JD-Core Version:    0.7.0.1
 */