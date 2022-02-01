package com.tencent.tim.activity.profile.friend;

import acgr;
import afxv;
import ajdo;
import ajos;
import alcn;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import anot;
import aqae;
import aqaf;
import aqep;
import aqft;
import atbo;
import atbw;
import atbx;
import atby;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;

public class StrangerProfileFragment
  extends FriendProfileFragment
{
  private Dialog C;
  
  private void etb()
  {
    if (QSecFramework.a().c(1001).booleanValue()) {
      QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), "addfriend", null }, null);
    }
    a(this.app, getActivity(), this.jdField_a_of_type_Alcn, this.C);
    anot.a(this.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.eP(this.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_Alcn.e)), Integer.toString(this.jdField_a_of_type_Alcn.e.bJd), "", "");
    if (this.jdField_a_of_type_Alcn.e.bJa == 119) {
      anot.a(this.app, "dc01160", "", "", "0X800A410", "0X800A410", 0, 0, "", "", "", "");
    }
    if (aqft.rj(this.jdField_a_of_type_Alcn.e.uin)) {
      anot.a(this.app, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
    }
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_Alcn.e.pa == 82) || (this.jdField_a_of_type_Alcn.e.pa == 81) || (this.jdField_a_of_type_Alcn.e.pa == 83) || (this.jdField_a_of_type_Alcn.e.pa == 101) || (this.jdField_a_of_type_Alcn.e.pa == 103) || (this.jdField_a_of_type_Alcn.e.pa == 102) || (this.jdField_a_of_type_Alcn.e.pa == 107) || (this.jdField_a_of_type_Alcn.e.pa == 110))
    {
      localObject = getActivity().getIntent().getBundleExtra("profile_extres");
      if (localObject != null) {
        i = 0;
      }
    }
    String str1;
    switch (this.jdField_a_of_type_Alcn.e.pa)
    {
    default: 
      str1 = ((Bundle)localObject).getString("recommend_entry_type", "");
      String str2 = ((Bundle)localObject).getString("recommend_reason", "");
      int j = ((Bundle)localObject).getInt("key_display_type", 0);
      int k = ((Bundle)localObject).getInt("recommend_pos", 0);
      byte[] arrayOfByte = ((Bundle)localObject).getByteArray("recommend_algh_id");
      localObject = ((Bundle)localObject).getString("recommend_label", "");
      ContactReportUtils.a(this.app, this.jdField_a_of_type_Alcn.e.uin, "frd_list_add", i, 2, str2, k, arrayOfByte, (String)localObject, j, str1);
      if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.e != null))
      {
        if (87 != this.jdField_a_of_type_Alcn.e.bJa) {
          break label656;
        }
        anot.a(this.app, "CliOper", "", "", "0X8006F0D", "0X8006F0D", 0, 0, "", "", "", "");
      }
      break;
    }
    label656:
    label888:
    do
    {
      do
      {
        return;
        i = 21;
        break;
        i = 23;
        break;
        i = 3;
        break;
        i = 24;
        break;
        i = 20;
        break;
        i = 25;
        break;
        i = 28;
        break;
        i = ((Bundle)localObject).getInt("tabID", 0);
        break;
        if ((101 != this.jdField_a_of_type_Alcn.e.bJa) && (102 != this.jdField_a_of_type_Alcn.e.bJa) && (103 != this.jdField_a_of_type_Alcn.e.bJa)) {
          break label888;
        }
        if (((ajdo)this.app.getManager(11)).Uv()) {}
        for (str1 = "0X80077D4";; str1 = "0X80077CE")
        {
          anot.a(this.app, "dc00898", "", "", str1, str1, 0, 0, "", "", "", "");
          if (101 != this.jdField_a_of_type_Alcn.e.bJa) {
            break;
          }
          anot.a(this.app, "dc00898", "", "", str1, str1, 1, 0, "", "", "", "");
          return;
        }
        if (102 == this.jdField_a_of_type_Alcn.e.bJa)
        {
          anot.a(this.app, "dc00898", "", "", str1, str1, 2, 0, "", "", "", "");
          return;
        }
      } while (103 != this.jdField_a_of_type_Alcn.e.bJa);
      anot.a(this.app, "dc00898", "", "", str1, str1, 3, 0, "", "", "", "");
      return;
    } while (104 != this.jdField_a_of_type_Alcn.e.bJa);
    anot.a(this.app, "dc00898", "", "", "0X80077D1", "0X80077D1", 0, 0, "", "", "", "");
  }
  
  protected void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn, Dialog paramDialog)
  {
    Object localObject = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int k;
    int m;
    int i;
    int j;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("from_babyq", false)))
    {
      bool = true;
      k = 3999;
      m = 0;
      i = m;
      j = k;
      switch (paramalcn.e.pa)
      {
      default: 
        j = k;
        i = m;
      }
    }
    for (;;)
    {
      if (j == 3045) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i), "", "", "");
      }
      if (j == 3094) {
        anot.c(paramQQAppInterface, "dc00898", "", paramalcn.e.uin, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(i), afxv.uQ(), afxv.t(paramQQAppInterface), afxv.uS());
      }
      if ((j != 3007) || (acgr.y(paramQQAppInterface, paramalcn.e.uin))) {
        break label1537;
      }
      localObject = paramDialog;
      if (paramDialog == null) {
        localObject = acgr.a(paramBaseActivity, paramBaseActivity.getString(2131696214), new atbw(this, paramQQAppInterface, paramBaseActivity, paramalcn), new atbx(this));
      }
      if ((!((Dialog)localObject).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject).show();
      }
      return;
      bool = false;
      break;
      i = paramalcn.e.subSourceId;
      j = 3004;
      continue;
      i = 3;
      j = 3004;
      continue;
      i = 1;
      j = 3007;
      continue;
      i = 1;
      j = 3001;
      continue;
      i = paramalcn.e.subSourceId;
      j = 3020;
      continue;
      i = 1;
      j = 3017;
      continue;
      i = paramalcn.e.subSourceId;
      j = 3002;
      continue;
      i = 1;
      j = 3005;
      continue;
      i = 2;
      j = 3007;
      continue;
      i = 0;
      j = 3003;
      continue;
      i = 12;
      j = 3008;
      continue;
      i = 11;
      j = 3008;
      continue;
      i = 12;
      j = 3041;
      continue;
      i = 11;
      j = 3041;
      continue;
      i = 0;
      j = 3999;
      continue;
      i = 1;
      j = 3037;
      continue;
      i = 1;
      j = 3095;
      continue;
      i = 1;
      j = 3096;
      continue;
      i = 1;
      j = 3042;
      continue;
      i = 2;
      j = 3037;
      continue;
      i = 0;
      j = 3009;
      continue;
      j = 3006;
      i = 13;
      if (bool)
      {
        i = 1;
        j = 3084;
        continue;
        j = 3068;
        i = 1;
        if (bool)
        {
          i = 1;
          j = 3084;
          continue;
          if ((paramalcn.e.subSourceId == 16) || (paramalcn.e.subSourceId == 17))
          {
            i = paramalcn.e.subSourceId;
            j = 3006;
          }
          else
          {
            i = 1;
            j = 3075;
            continue;
            i = 1;
            j = 3009;
            continue;
            i = 1;
            j = 3006;
            continue;
            i = 0;
            j = 3013;
            continue;
            i = 1;
            j = 3003;
            continue;
            i = 1;
            j = 3014;
            continue;
            i = 2;
            j = 3003;
            continue;
            j = 3022;
            i = 1;
            if (bool)
            {
              i = 1;
              j = 3083;
              continue;
              i = 0;
              j = 3011;
              continue;
              if (paramalcn.e.bJa == 127)
              {
                i = 1;
                j = 3048;
              }
              else
              {
                i = 1;
                j = 3071;
                continue;
                i = 21;
                j = 3045;
                continue;
                i = 23;
                j = 3045;
                continue;
                j = 3045;
                i = 3;
                if (bool)
                {
                  i = 1;
                  j = 3083;
                  continue;
                  if (localObject != null) {}
                  for (i = ((Bundle)localObject).getInt("tabID", 0);; i = 0)
                  {
                    j = 3045;
                    break;
                  }
                  i = 28;
                  j = 3045;
                  continue;
                  i = 4;
                  j = 3045;
                  continue;
                  i = 24;
                  j = 3045;
                  continue;
                  i = 20;
                  j = 3045;
                  continue;
                  i = 25;
                  j = 3045;
                  continue;
                  i = 1;
                  j = 3092;
                  continue;
                  i = paramalcn.e.subSourceId;
                  j = 3094;
                  continue;
                  i = 11;
                  j = 3072;
                  continue;
                  i = 12;
                  j = 3072;
                  continue;
                  i = 1;
                  j = 3018;
                  continue;
                  i = 15;
                  j = 3041;
                  continue;
                  i = 14;
                  j = 3041;
                  continue;
                  if (paramalcn.e.bJa == 118)
                  {
                    i = 3;
                    j = 3022;
                  }
                  else
                  {
                    i = m;
                    j = k;
                    if (paramalcn.e.bJa == 121)
                    {
                      i = 2;
                      j = 3022;
                      continue;
                      i = 23;
                      j = 3004;
                      continue;
                      i = paramalcn.e.subSourceId;
                      j = 3004;
                      continue;
                      i = 2;
                      j = 3080;
                      continue;
                      i = 4;
                      j = 3076;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1537:
    if (paramalcn.d != null) {}
    for (localObject = aqep.a(paramQQAppInterface.getApp().getApplicationContext(), paramalcn.d.shGender, paramalcn.d.age, paramalcn.d.strCountry, paramalcn.d.strProvince, paramalcn.d.strCity);; localObject = "")
    {
      String str;
      if ((paramalcn.e.pa == 32) || (paramalcn.e.pa == 31) || (paramalcn.e.pa == 51) || (paramalcn.e.pa == 50) || (paramalcn.e.pa == 34) || (paramalcn.e.pa == 36) || (paramalcn.e.pa == 53) || (paramalcn.e.pa == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = this.jdField_a_of_type_Atbo.a(paramalcn.e);
        if ((localCardContactInfo == null) || (localCardContactInfo.phoneNumber == null) || (localCardContactInfo.phoneNumber.length() <= 0)) {
          break;
        }
        str = localCardContactInfo.aOM + localCardContactInfo.phoneNumber;
        paramDialog = localCardContactInfo.aOL;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.aOL))
        {
          if (TextUtils.isEmpty(paramalcn.gh[3])) {
            break label1891;
          }
          paramQQAppInterface = paramalcn.gh[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, str, null, j, i, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131691039), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramalcn.e.pa);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramalcn);
          if (!paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false)) {
            break;
          }
          paramQQAppInterface.putExtra("from_newer_guide", true);
          paramQQAppInterface.removeExtra("param_return_addr");
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1024);
          return;
          label1891:
          if (!TextUtils.isEmpty(paramalcn.gh[0]))
          {
            paramQQAppInterface = paramalcn.gh[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramalcn.a.a.value)) {
              paramQQAppInterface = paramalcn.a.a.value;
            }
          }
        }
        paramBaseActivity.startActivity(paramQQAppInterface);
        return;
      }
      paramQQAppInterface = null;
      if ((3004 == j) && (!TextUtils.isEmpty(paramalcn.e.troopUin)))
      {
        paramDialog = paramalcn.e.troopUin;
        paramQQAppInterface = null;
        if ((paramalcn.e.pa != 71) && (paramalcn.e.pa != 72)) {
          break label2165;
        }
        paramQQAppInterface = paramalcn.gh[2];
        label2017:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2407;
        }
        paramQQAppInterface = paramalcn.gh[0];
      }
      label2404:
      label2407:
      for (;;)
      {
        str = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (str != null)
        {
          localObject = AddContactsActivity.class.getName();
          if (!str.equals(QidianProfileCardActivity.class.getName())) {
            break label2404;
          }
          localObject = str;
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramalcn.e.uin, paramDialog, j, i, paramQQAppInterface, null, (String)localObject, paramBaseActivity.getString(2131691039), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramalcn);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != j) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramalcn.e.discussUin)) {
            break;
          }
          paramDialog = paramalcn.e.discussUin;
          break;
          label2165:
          if ((paramalcn.e.pa != 77) && (paramalcn.e.pa != 82) && (paramalcn.e.pa != 81) && (paramalcn.e.pa != 83) && (paramalcn.e.pa != 84) && (paramalcn.e.pa != 101) && (paramalcn.e.pa != 103) && (paramalcn.e.pa != 102) && (paramalcn.e.pa != 107) && (paramalcn.e.pa != 110)) {
            break label2017;
          }
          paramQQAppInterface = paramalcn.gh[5];
          break label2017;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramalcn.e.uin, paramDialog, j, i, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131691039), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramalcn);
          if (j == 3094)
          {
            paramQQAppInterface.putExtra("entrance", paramBaseActivity.getIntent().getIntExtra("entrance", 2));
            paramQQAppInterface.removeExtra("param_return_addr");
            paramBaseActivity.startActivity(paramQQAppInterface);
            return;
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  public void biN()
  {
    this.jdField_a_of_type_Atbo = ((atbo)ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment).get(atby.class));
  }
  
  public void initView()
  {
    super.initView();
    this.mContentView.findViewById(2131363936).setVisibility(8);
    this.mContentView.findViewById(2131363769).setVisibility(0);
    this.mContentView.findViewById(2131363769).setOnClickListener(this);
    this.mContentView.findViewById(2131363990).setVisibility(0);
    this.mContentView.findViewById(2131363990).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131363769) {
      etb();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.C != null) && (this.C.isShowing()))
    {
      this.C.dismiss();
      this.C = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.friend.StrangerProfileFragment
 * JD-Core Version:    0.7.0.1
 */