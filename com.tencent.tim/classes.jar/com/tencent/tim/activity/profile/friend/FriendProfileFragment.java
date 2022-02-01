package com.tencent.tim.activity.profile.friend;

import acff;
import acfp;
import adzx;
import afxx;
import aizg;
import ajnn;
import ajoh;
import ajok;
import ajos;
import alcn;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import anot;
import anov;
import aqae;
import aqaf;
import aqep;
import aqfp;
import aqft;
import aqgv;
import aqha;
import aqju;
import asgx;
import atbe;
import atbo;
import atbp;
import atbq;
import atbr;
import atbs;
import atbt;
import atbu;
import atbv;
import atbz;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.activity.profile.BaseProfileFragment;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.util.List;
import java.util.Locale;
import jln;
import jqs;
import wja;

public class FriendProfileFragment
  extends BaseProfileFragment
{
  private boolean PF()
  {
    switch (this.jdField_a_of_type_Alcn.e.pa)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (acff)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = null; (localObject != null) && (((Friends)localObject).gathtertype == 1); localObject = ((acff)localObject).a(this.jdField_a_of_type_Alcn.e.uin)) {
        return true;
      }
    }
  }
  
  private void bOC()
  {
    Object localObject = adzx.a(this.app, this.jdField_a_of_type_Alcn);
    localObject = aqep.a(new Intent(getActivity(), ProfileCardMoreActivity.class), this.jdField_a_of_type_Alcn.e.uin, this.app, this.jdField_a_of_type_Alcn.e, (BusinessCard)localObject);
    if ((this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf != null) && (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.size() > 0)) {
      ((Intent)localObject).putExtra("SHARE_NICK_NAME", ((aqae)this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.get(0)).value);
    }
    if ((this.jdField_a_of_type_Alcn.d != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.addSrcName))) {
      ((Intent)localObject).putExtra("cur_add_source", this.jdField_a_of_type_Alcn.d.addSrcName);
    }
    if (this.jdField_a_of_type_Alcn.d != null) {
      ((Intent)localObject).putExtra("key_nick_name", this.jdField_a_of_type_Alcn.d.strNick);
    }
    ((Intent)localObject).addFlags(536870912);
    startActivityForResult((Intent)localObject, 1012);
  }
  
  private void bOG()
  {
    Intent localIntent = wja.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_Alcn.e.uin);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_Alcn.e.uin);
    Object localObject = (acff)this.app.getManager(51);
    if ((this.jdField_a_of_type_Alcn.c.isFriend) || ((localObject != null) && (((acff)localObject).isFriend(this.jdField_a_of_type_Alcn.e.uin))))
    {
      localIntent.putExtra("uintype", 0);
      String str = aqgv.p(this.app, this.jdField_a_of_type_Alcn.troopUin, this.jdField_a_of_type_Alcn.e.uin);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_Alcn.c.nick;
      }
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_Alcn.troopUin);
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null) {
        break label237;
      }
      ((TroopManager)localObject).a(this.jdField_a_of_type_Alcn.troopUin, new atbu(this, localIntent));
    }
    label237:
    while (!QLog.isColorLevel())
    {
      return;
      localIntent.putExtra("uintype", 1000);
      break;
    }
    QLog.e("FriendProfileFragment", 2, "enterChatByTroopMember, troopManager is null");
  }
  
  private void c(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = this.jdField_a_of_type_Alcn.e;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.gk(localAllInOne.pa)) && (TextUtils.isEmpty(localAllInOne.troopUin)))
    {
      localAllInOne.troopUin = paramTroopInfo.troopcode;
      localAllInOne.troopcode = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileFragment", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  private void czx()
  {
    if (this.jdField_a_of_type_Alcn.e.bJa == 126) {
      aqha.a(getActivity(), 230, "", getString(2131693374), getString(2131693955), getString(2131693373), new atbr(this), new atbs(this)).show();
    }
    do
    {
      return;
      bOF();
    } while (!this.jdField_a_of_type_Alcn.cwc);
    new anov(this.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.jdField_a_of_type_Alcn.troopUin }).report();
  }
  
  private void esZ()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Alcn.e == null) {}
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_Alcn.cwc) {
          break;
        }
        new anov(this.app).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { this.jdField_a_of_type_Alcn.troopUin }).report();
        localObject1 = (TroopManager)this.app.getManager(52);
        localObject2 = ((TroopManager)localObject1).b(this.jdField_a_of_type_Alcn.troopUin);
      } while (localObject2 == null);
      c((TroopInfo)localObject2);
    } while (this.jdField_a_of_type_Alcn.d == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("troopUin", this.jdField_a_of_type_Alcn.troopUin);
    localIntent.putExtra("memberUin", this.jdField_a_of_type_Alcn.d.uin);
    localIntent.putExtra("fromFlag", this.jdField_a_of_type_Alcn.drN);
    localIntent.putExtra("troopMemberCard", this.jdField_a_of_type_Alcn.c);
    localIntent.putExtra("troopCode", ((TroopInfo)localObject2).troopcode);
    localIntent.putExtra("troopName", ((TroopInfo)localObject2).getTroopName());
    localIntent.putExtra("hwCard", ((TroopManager)localObject1).a(this.jdField_a_of_type_Alcn.troopUin, this.jdField_a_of_type_Alcn.d.uin));
    localIntent.putExtra("qidian_private_troop", TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Alcn.troopUin));
    if (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.nickname)) {
      this.jdField_a_of_type_Alcn.e.nickname = aqgv.n(this.app, this.jdField_a_of_type_Alcn.e.uin);
    }
    localIntent.putExtra("AllInOne", this.jdField_a_of_type_Alcn.e);
    localIntent.putExtra("detailProfileUrl", aqep.a(this.jdField_a_of_type_Alcn, this.app, getActivity()));
    localIntent.putExtra("qidianshowUin", asgx.I(this.app, this.jdField_a_of_type_Alcn.e.uin));
    Object localObject1 = (acff)this.app.getManager(51);
    boolean bool3 = ((acff)localObject1).isFriend(this.jdField_a_of_type_Alcn.e.uin);
    localIntent.putExtra("isFriend", bool3);
    localIntent.putExtra("isQidianMaster", ((asgx)this.app.getManager(165)).sM(this.jdField_a_of_type_Alcn.e.uin));
    Object localObject2 = ((acff)localObject1).b(this.jdField_a_of_type_Alcn.e.uin);
    Groups localGroups;
    if (localObject2 != null)
    {
      localIntent.putExtra("specialFlag", ((Friends)localObject2).cSpecialFlag);
      if (((Friends)localObject2).isFriend())
      {
        localIntent.putExtra("key_remark", ((Friends)localObject2).remark);
        localIntent.putExtra("key_group_id", ((Friends)localObject2).groupid);
        localIntent.putExtra("key_current_nick", aqgv.A(this.app, this.app.getCurrentAccountUin()));
        localGroups = ((acff)localObject1).a(String.valueOf(((Friends)localObject2).groupid));
        if (localGroups != null) {
          break label1148;
        }
        localIntent.putExtra("key_group_name", "");
        localIntent.putExtra("key_not_disturb", FriendsStatusUtil.g(this.jdField_a_of_type_Alcn.e.uin, this.app));
        localIntent.putExtra("key_is_shield", ((acff)localObject1).ke(this.jdField_a_of_type_Alcn.e.uin));
        localIntent.putExtra("key_type_gather", ((Friends)localObject2).gathtertype);
        localIntent.putExtra("key_is_has_interaction", ajnn.c(this.app, this.jdField_a_of_type_Alcn.e.uin, true));
        localObject1 = ((acff)localObject1).a(this.jdField_a_of_type_Alcn.e.uin);
        if ((localObject1 == null) || (((SpecialCareInfo)localObject1).globalSwitch == 0)) {
          break label1165;
        }
        bool1 = true;
        label720:
        localIntent.putExtra("key_is_specialcare", bool1);
      }
    }
    localIntent.putExtra("businessCard", adzx.a(this.app, this.jdField_a_of_type_Alcn));
    if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf != null) && (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC != null) && (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.size() > 0)) {
      localIntent.putExtra("SHARE_NICK_NAME", ((aqae)this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.get(0)).value);
    }
    if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.d != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.addSrcName))) {
      localIntent.putExtra("cur_add_source", this.jdField_a_of_type_Alcn.d.addSrcName);
    }
    if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.d != null)) {
      localIntent.putExtra("key_nick_name", this.jdField_a_of_type_Alcn.d.strNick);
    }
    localIntent.putExtra("title", getString(2131701668));
    label950:
    int i;
    if (bool3)
    {
      if (!ajok.nx(this.app.getCurrentUin())) {
        break label1170;
      }
      bool1 = true;
      localIntent.putExtra("friend_intimate_open", bool1);
      localIntent.putExtra("friend_intimate_bind_url", ajok.mn(this.jdField_a_of_type_Alcn.e.uin));
      localObject1 = "";
      localObject2 = ajnn.a(this.app, this.jdField_a_of_type_Alcn.e.uin, true);
      if (localObject2 == null) {
        break label1228;
      }
      if (((ajoh)localObject2).type != 1L) {
        break label1175;
      }
      localObject1 = getString(2131695048);
      label1030:
      i = ((ajoh)localObject2).iconResId;
    }
    for (boolean bool1 = ((ajoh)localObject2).arj();; bool1 = bool2)
    {
      localIntent.putExtra("friend_intimate_bind_name", (String)localObject1);
      localIntent.putExtra("friend_intimate_isExtinguish", bool1);
      localIntent.putExtra("friend_intimate_bind_res_icon", i);
      localIntent.putExtra("isMsgShielded", PE());
      localIntent.putExtra("isGather", PF());
      localObject1 = TroopBaseProxyActivity.a(getActivity());
      TroopMemberCardProxyActivity.a(this.app, "troop_member_card_plugin.apk", acfp.m(2131706592), TroopMemberCardProxyActivity.class, getActivity(), localIntent, (Dialog)localObject1, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.app.getCurrentAccountUin(), 8);
      return;
      label1148:
      localIntent.putExtra("key_group_name", localGroups.group_name);
      break;
      label1165:
      bool1 = false;
      break label720;
      label1170:
      bool1 = false;
      break label950;
      label1175:
      if (((ajoh)localObject2).type == 2L)
      {
        localObject1 = getString(2131695046);
        break label1030;
      }
      if (((ajoh)localObject2).type != 3L) {
        break label1030;
      }
      localObject1 = getString(2131695047);
      break label1030;
      bOC();
      return;
      label1228:
      i = 0;
    }
  }
  
  private void eta()
  {
    int[] arrayOfInt = new int[5];
    jln localjln = jln.a(getActivity());
    localjln.setMainTitle(2131689654);
    localjln.addButton(2131721238);
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
    localjln.addButton(2131721260);
    localjln.addCancelButton(2131691246);
    localjln.a(new atbp(this));
    localjln.a(new atbq(this, arrayOfInt, localjln));
    localjln.show();
    anot.a(this.app, "CliOper", "", "", "0X8008404", "0X8008404", 0, 0, "", "", "", "");
  }
  
  boolean PE()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool2 = false;
    switch (this.jdField_a_of_type_Alcn.e.pa)
    {
    default: 
      localObject2 = (acff)this.app.getManager(51);
      if ((localObject2 != null) && (((acff)localObject2).isFriend(this.jdField_a_of_type_Alcn.e.uin)))
      {
        bool1 = ((acff)localObject2).ke(this.jdField_a_of_type_Alcn.e.uin);
        return bool1;
      }
      break;
    case 41: 
    case 42: 
    case 86: 
      localObject1 = (acff)this.app.getManager(51);
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((acff)localObject1).a(this.jdField_a_of_type_Alcn.e.uin))
      {
        bool1 = bool2;
        if (localObject1 == null) {
          break;
        }
        bool1 = bool2;
        if (((Friends)localObject1).groupid != -1002) {
          break;
        }
        return true;
      }
    case 1: 
      localObject1 = (acff)this.app.getManager(51);
      if (localObject1 == null) {}
      break;
    }
    for (boolean bool1 = ((acff)localObject1).ke(this.jdField_a_of_type_Alcn.e.uin);; bool1 = false)
    {
      return bool1;
      localObject2 = (aizg)this.app.getManager(16);
      bool1 = bool2;
      if (localObject2 == null) {
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e)) {
        localObject1 = this.jdField_a_of_type_Alcn.e.uin;
      }
      for (;;)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        return ((aizg)localObject2).nf((String)localObject1);
        if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Alcn.e)) {
          localObject1 = oP();
        }
      }
    }
  }
  
  void YF(String paramString)
  {
    this.jdField_a_of_type_Atbo.d(13, paramString, null);
    String str2 = getClass().getSimpleName();
    String str1 = "";
    if (str2.equals(FriendProfileFragment.class.getSimpleName())) {
      str1 = ((atbv)this.jdField_a_of_type_Atbo).rn(paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileFragment", 2, "updateRemark strRemark : " + paramString + ", titleName: " + str1);
      }
      if (!TextUtils.isEmpty(str1)) {
        YE(str1);
      }
      return;
      if (str2.equals(TroopFriendProfileFragment.class.getSimpleName())) {
        str1 = ((atbz)this.jdField_a_of_type_Atbo).rn(paramString);
      }
    }
  }
  
  protected String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = this.jdField_a_of_type_Atbo.a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).aOM + ((ProfileActivity.CardContactInfo)localObject1).phoneNumber;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.uin;
      }
      return localObject2;
    }
  }
  
  public void a(atbe paramatbe)
  {
    super.a(paramatbe);
    if (paramatbe.id == 12)
    {
      paramatbe = "https://ti.qq.com/qcard/edu?qq=" + this.jdField_a_of_type_Alcn.e.uin;
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramatbe);
      startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileFragment", 2, "onProfileItemClick url: " + paramatbe);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn)
  {
    int i = aqep.b(paramalcn.e);
    String str3 = this.jdField_a_of_type_Atbo.getNickName();
    String str1;
    String str2;
    if (ProfileActivity.AllInOne.g(paramalcn.e))
    {
      str1 = paramalcn.e.uin;
      str2 = null;
      if (i == 1000)
      {
        paramalcn = paramalcn.e.troopUin;
        label56:
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
        }
        ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, i, str1, str3, str2, true, paramalcn, true, true, null, "from_internal");
      }
    }
    else
    {
      if ((paramalcn.e.pa != 53) || (paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard == null) || (TextUtils.isEmpty(paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))) {
        break label176;
      }
      str1 = paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
      i = 0;
    }
    for (;;)
    {
      str2 = a(paramalcn.e);
      break;
      if (i == 1004)
      {
        paramalcn = paramalcn.e.discussUin;
        break label56;
      }
      paramalcn = null;
      break label56;
      label176:
      str1 = null;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn, String paramString, int paramInt)
  {
    boolean bool = false;
    if (paramBaseActivity.getIntent() != null) {
      bool = paramBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false) | paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);
    }
    Object localObject;
    Intent localIntent;
    if (bool)
    {
      localObject = ChatActivity.class;
      localIntent = wja.a(new Intent(paramBaseActivity, (Class)localObject), null);
      localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
      localIntent.putExtra("PREVIOUS_UIN", paramalcn.e.uin);
      if (paramBaseActivity.getIntent().getExtras() != null) {
        localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
      }
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("aio_msg_source", 3);
      if (paramalcn.e.bJc != 0) {
        localIntent.putExtra("entrance", paramalcn.e.bJc);
      }
      localObject = this.jdField_a_of_type_Atbo.getNickName();
      if (localObject != null) {
        break label490;
      }
      paramString = "";
      label195:
      localIntent.putExtra("uinname", paramString);
      if (TextUtils.isEmpty(paramalcn.e.troopUin)) {
        break label497;
      }
      localIntent.putExtra("troop_uin", paramalcn.e.troopUin);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramalcn.e.troopcode)) {
        localIntent.putExtra("troop_code", paramalcn.e.troopcode);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", paramalcn.e.cf);
      }
      if (paramInt == 1001) {
        localIntent.putExtra("rich_accost_sig", paramalcn.e.cf);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("FriendProfileFragment", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { aqft.pl(paramalcn.e.uin), aqft.pl((String)localObject), aqft.bytesToHexString(paramalcn.e.cf) }));
      }
      paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramalcn.e.uin);
        if ((paramQQAppInterface != null) && ((jqs.cU(paramQQAppInterface.cSpecialFlag)) || (asgx.mS(paramQQAppInterface.cSpecialFlag)))) {
          localIntent.putExtra("chat_subType", 1);
        }
      }
      localIntent.putExtra("hidden_aio_msg_source", 2);
      if ((paramalcn.e.pa != 70) || (paramalcn.e.bIZ != 101)) {
        break label529;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      paramBaseActivity.startActivityForResult(localIntent, 1010);
      return;
      localObject = SplashActivity.class;
      break;
      label490:
      paramString = (String)localObject;
      break label195;
      label497:
      if (!TextUtils.isEmpty(paramalcn.e.discussUin)) {
        localIntent.putExtra("troop_uin", paramalcn.e.discussUin);
      }
    }
    label529:
    paramBaseActivity.startActivity(localIntent);
  }
  
  public void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn)
  {
    aqfp.Sz(true);
    ProfileActivity.AllInOne localAllInOne = paramalcn.e;
    int i = aqep.b(localAllInOne);
    if ((localAllInOne.aOF != null) && (localAllInOne.aOF.length() > 0) && (localAllInOne.bIX != 3000) && (localAllInOne.bIX != 1) && (localAllInOne.bIX != 2) && (localAllInOne.bIX != 1033) && (localAllInOne.bIX != 1034) && (localAllInOne.bIX != 1044) && (localAllInOne.bIX != 1045) && (localAllInOne.aOF.equals(localAllInOne.uin)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.uin;
    if (ProfileActivity.AllInOne.i(localAllInOne)) {
      if (localAllInOne.pa == 53) {
        if ((paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          i = 0;
          str = paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramalcn, str, i);
      return;
      i = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.pa == 3) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.bIZ == 102) {
        anot.a(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.bIZ == 103) {
        anot.a(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void bOF()
  {
    if (this.jdField_a_of_type_Alcn.cwc)
    {
      bOG();
      return;
    }
    if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Alcn.e))
    {
      afxx.a(this.app).a(this.app, this.jdField_a_of_type_Alcn.e, new atbt(this));
      return;
    }
    b(this.app, getActivity(), this.jdField_a_of_type_Alcn);
  }
  
  public void biN()
  {
    this.jdField_a_of_type_Atbo = ((atbo)ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment).get(atbv.class));
  }
  
  public void esV()
  {
    aqep.a(this.app, getActivity(), this.EH, this.jdField_a_of_type_Alcn.e.uin, 0, 0);
  }
  
  public void initView()
  {
    super.initView();
    TextView localTextView = (TextView)this.mContentView.findViewById(2131369612);
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    this.Kk.setVisibility(0);
    this.mContentView.findViewById(2131363936).setVisibility(0);
    this.mContentView.findViewById(2131363936).setOnClickListener(this);
    this.mContentView.findViewById(2131363990).setVisibility(0);
    this.mContentView.findViewById(2131363990).setOnClickListener(this);
  }
  
  String oP()
  {
    try
    {
      String str = ((PhoneContactManagerImp)this.app.getManager(11)).c(a(this.jdField_a_of_type_Alcn.e)).uin;
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
      }
    }
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1040) {
      this.jdField_a_of_type_Atbo.refreshList();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        if (paramInt1 != 1012) {
          break;
        }
      } while (paramIntent == null);
      if (paramIntent.getBooleanExtra("finchat", false))
      {
        getActivity().finish();
        return;
      }
      paramIntent = paramIntent.getStringExtra("remark");
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileFragment", 2, "onActivityResult REQUEST_FOR_PROFILECARD_MORE str: " + paramIntent);
      }
      YF(paramIntent);
      return;
    } while ((paramInt1 != 8) || (paramIntent == null));
    paramIntent = paramIntent.getStringExtra("remark");
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileFragment", 2, "onActivityResult REQUEST_CODE_OPEN_MORE str: " + paramIntent);
    }
    YF(paramIntent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      esZ();
      continue;
      eta();
      continue;
      czx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.friend.FriendProfileFragment
 * JD-Core Version:    0.7.0.1
 */