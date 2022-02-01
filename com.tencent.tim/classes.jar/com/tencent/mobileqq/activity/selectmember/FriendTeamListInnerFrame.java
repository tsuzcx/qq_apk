package com.tencent.mobileqq.activity.selectmember;

import aaxc;
import aaxd;
import aaxe;
import aaxf;
import aaxg;
import aayg;
import acfd;
import acms;
import acnd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aoyd;
import aozi;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import wja;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private TextView OE;
  private aayg a;
  public aozi a;
  acnd jdField_b_of_type_Acnd = new aaxg(this);
  private PinnedFooterExpandableListView jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  public boolean bAG = false;
  boolean bAH = false;
  private Button fp;
  private Button fq;
  private Button fr;
  private Button fs;
  private Button ft;
  private Button fw;
  private RelativeLayout iU;
  private LinearLayout ia;
  private String mTroopUin;
  private acfd p;
  List<Entity> vy = new ArrayList();
  
  public FriendTeamListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ContactSearchFragment a()
  {
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.uy() == 0)
    {
      this.bAG = true;
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAN)
    {
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAM) {
        j = 5;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAK) {
        i = j | 0x100;
      }
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAL) {
        j = i | 0x400000;
      }
    }
    return ContactSearchFragment.a(-1, j, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.sr, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt)
  {
    super.a(paramResultRecord, paramInt);
    this.jdField_a_of_type_Aozi.b(paramResultRecord, paramInt);
  }
  
  public void be(Bundle paramBundle)
  {
    super.be(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719436), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mTitleString);
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_b_of_type_Acnd);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mType == 1))
    {
      paramBundle = (acms)this.e.getBusinessHandler(20);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      paramBundle.a(true, str, ((TroopManager)this.e.getManager(52)).c(str).troopcode, true, 7, System.currentTimeMillis(), 0);
    }
  }
  
  public void notifyDataSetChanged()
  {
    System.out.println("----->notifyDataSetChanged");
    if (this.jdField_a_of_type_Aayg != null) {
      this.jdField_a_of_type_Aayg.cnv();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.fp)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(1);
      this.bAH = false;
      anot.a(this.e, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 11) {
        anot.a(this.e, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    label150:
    Object localObject;
    int i;
    label345:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            if (paramView == this.fq)
            {
              this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(3);
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG == 0)
              {
                anot.a(this.e, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 12)
                {
                  anot.a(this.e, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
                  anot.a(this.e, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG != 1) {
                  continue;
                }
                localObject = ((TroopManager)this.e.getManager(52)).c(this.mTroopUin);
                if (localObject == null) {
                  continue;
                }
                str = this.e.getCurrentUin();
                if (!((TroopInfo)localObject).isTroopOwner(str)) {
                  break label345;
                }
                i = 0;
              }
              for (;;)
              {
                anot.a(this.e, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.mTroopUin, String.valueOf(i), "", "");
                break;
                anot.a(this.e, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
                break label150;
                if (((TroopInfo)localObject).isTroopAdmin(str)) {
                  i = 1;
                } else {
                  i = 2;
                }
              }
            }
            else if (paramView == this.fr)
            {
              aoyd.fp(getContext());
              anot.a(this.e, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
            }
            else if (paramView == this.fs)
            {
              startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
              anot.a(this.e, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.eK == 12) {
                anot.a(this.e, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
              }
            }
            else
            {
              if (paramView != this.fw) {
                break;
              }
              this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(8);
            }
          }
        } while (paramView != this.ft);
        localObject = new Intent(getContext(), Face2FaceAddFriendActivity.class);
        ((Intent)localObject).putExtra("activity_from_type", 1);
        ((Intent)localObject).putExtra("activity_troop_uin", this.mTroopUin);
        startActivity((Intent)localObject);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bGG != 1);
      localObject = ((TroopManager)this.e.getManager(52)).c(this.mTroopUin);
    } while (localObject == null);
    String str = this.e.getCurrentUin();
    if (((TroopInfo)localObject).isTroopOwner(str)) {
      i = 0;
    }
    for (;;)
    {
      anot.a(this.e, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.mTroopUin, String.valueOf(i), "", "");
      break;
      if (((TroopInfo)localObject).isTroopAdmin(str)) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getActivity();
    this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)((Activity)localObject).getLayoutInflater().inflate(2131560608, null));
    this.bAG = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameNew", 2, "firstUserClicked is " + this.bAG);
    }
    boolean bool;
    if (!this.bAG)
    {
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new aaxc(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131560610, null);
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, wja.dp2px(12.0F, getResources()));
      View localView = new View(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localView);
      QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("isExpandFirst", true);
      this.jdField_a_of_type_Aayg = new aayg((Context)localObject, this.e, this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView, new aaxd(this), bool);
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Aayg);
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167595);
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(getActivity().getResources().getDrawable(2130839740));
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Aayg);
      setContentView(this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView);
      this.jdField_a_of_type_Aozi = new aozi(this.e, this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView, new aaxe(this));
      this.jdField_a_of_type_Aayg.a(this.jdField_a_of_type_Aozi);
      this.ia = ((LinearLayout)paramBundle.findViewById(2131364136));
      this.fp = ((Button)paramBundle.findViewById(2131363830));
      this.OE = ((TextView)paramBundle.findViewById(2131379449));
      this.iU = ((RelativeLayout)paramBundle.findViewById(2131363831));
      this.fq = ((Button)paramBundle.findViewById(2131363875));
      this.fr = ((Button)paramBundle.findViewById(2131363879));
      this.fw = ((Button)paramBundle.findViewById(2131363874));
      localObject = (PhoneContactManagerImp)this.e.getManager(11);
      if (((localObject != null) && (!((PhoneContactManagerImp)localObject).Ur()) && (((PhoneContactManagerImp)localObject).xy() == 8)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAN)) {
        break label812;
      }
      this.ia.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAX) {
        break label800;
      }
      this.fw.setVisibility(0);
      this.fw.setOnClickListener(this);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.fp.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689899));
        this.fq.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689902));
      }
      this.fs = ((Button)paramBundle.findViewById(2131363834));
      this.fs.setOnClickListener(this);
      this.fs.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689891));
      this.fs.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689891));
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.fs.setVisibility(8);
        this.fr.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAL) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAM)) {
        this.fq.setVisibility(8);
      }
      this.p = new aaxf(this);
      this.e.addObserver(this.p);
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("param_face_to_face_invite", false);
      this.mTroopUin = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      if (TextUtils.isEmpty(this.mTroopUin)) {
        this.mTroopUin = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.aRJ;
      }
      if (bool)
      {
        this.ft = ((Button)paramBundle.findViewById(2131363833));
        this.ft.setVisibility(0);
        this.ft.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131689890));
        this.ft.setOnClickListener(this);
      }
      return;
      this.jdField_b_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
      break;
      label800:
      this.fw.setVisibility(8);
    }
    label812:
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.bAK) {
      this.iU.setVisibility(8);
    }
    for (;;)
    {
      this.fq.setOnClickListener(this);
      this.fr.setOnClickListener(this);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences(this.e.getCurrentAccountUin(), 0).getInt("select_member_contacts_flag", 0) == 1) {
        this.fp.setOnClickListener(this);
      } else {
        this.iU.setVisibility(8);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aayg != null) {
      this.jdField_a_of_type_Aayg.destroy();
    }
    this.e.removeObserver(this.p);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.bAH) && (this.e != null))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.e.getManager(11);
      if (localPhoneContactManagerImp != null)
      {
        int i = localPhoneContactManagerImp.xy();
        if ((i != 8) && (i != 9)) {}
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.yW(1);
      return;
    }
    finally
    {
      this.bAH = false;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_b_of_type_Acnd);
  }
  
  public String qN()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */