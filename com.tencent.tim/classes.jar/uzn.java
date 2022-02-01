import QQService.PrivilegeInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.30.1;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.30.2;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.30.7;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopMemberCardProxyActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class uzn
  implements View.OnClickListener
{
  long Gh = 0L;
  
  public uzn(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    int j;
    long l;
    label749:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((paramView.getTag() instanceof albb))
        {
          j = acny.e(this.this$0.app, this.this$0.app.getCurrentUin(), false);
          localObject4 = (albb)paramView.getTag();
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((albb)localObject4).nType);
          }
          l = System.currentTimeMillis();
          if ((((albb)localObject4).nType == 10) || (Math.abs(l - this.Gh) >= 1000L))
          {
            this.Gh = l;
            if ((this.this$0.aWo) || (!this.this$0.gc(((albb)localObject4).nType))) {
              switch (((albb)localObject4).nType)
              {
              case 2: 
              case 9: 
              case 11: 
              case 12: 
              case 14: 
              case 15: 
              case 18: 
              case 19: 
              case 21: 
              case 22: 
              case 25: 
              case 27: 
              case 28: 
              case 30: 
              case 31: 
              case 33: 
              case 35: 
              case 36: 
              case 37: 
              case 38: 
              case 39: 
              case 40: 
              case 42: 
              case 43: 
              case 46: 
              case 48: 
              case 49: 
              case 50: 
              case 51: 
              case 52: 
              case 53: 
              case 54: 
              case 55: 
              case 56: 
              case 57: 
              case 58: 
              case 60: 
              case 63: 
              case 64: 
              case 66: 
              case 67: 
              case 70: 
              case 71: 
              case 72: 
              case 74: 
              case 75: 
              case 76: 
              case 82: 
              case 84: 
              case 89: 
              case 91: 
              default: 
                break;
              case 1: 
                if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
                  break label1286;
                }
                localObject1 = new Intent(this.this$0, AvatarPendantActivity.class);
                ((Intent)localObject1).putExtra("AllInOne", this.this$0.jdField_a_of_type_Alcn.e);
                this.this$0.startActivity((Intent)localObject1);
                if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
                {
                  localObject1 = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_avatar_pendant");
                  l = this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.pendantId;
                  if ((ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e)) && (localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (l != 0L)) {
                    anot.a(this.this$0.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoHeadClick", 0, 0, "", "", "", "");
                  }
                }
                anot.a(this.this$0.app, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), "", "", "");
                if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
                  break label2114;
                }
                anot.a(this.this$0.app, "CliOper", "", "", "0X8006A77", "0X8006A77", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
    } while ((!ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e)) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 80) || (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0)
    {
      this.this$0.bOs();
      anot.a(this.this$0.app, "dc00898", "", "", "0X8007EC1", "0X8007EC1", 0, 0, "", "", "", "");
      localObject4 = this.this$0.app.getCurrentAccountUin();
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.bHA == 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject4, "defaultcard", "click_mydefaultcard", "", 1, 0, 0, "", (String)localObject1, "");
        label1009:
        localObject1 = this.this$0.app;
        if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
          break label1281;
        }
        i = 1;
        label1036:
        anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A889", "0X800A889", i, 0, "", "", "", "");
        break;
      }
    }
    Object localObject1 = new Intent(this.this$0, CardPicGalleryActivity.class);
    Object localObject4 = new ArrayList();
    if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mCoverUrl)) {
      ((Intent)localObject1).putExtra("extra_default", 2130846645);
    }
    ((ArrayList)localObject4).add(this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mCoverUrl);
    ((Intent)localObject1).putExtra("extra_mode", 2);
    ((Intent)localObject1).putStringArrayListExtra("business_card_pics", (ArrayList)localObject4);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.bHA == 0) {}
    for (int i = this.this$0.jdField_a_of_type_Alcn.d.defaultCardId;; i = 0)
    {
      ((Intent)localObject1).putExtra("default_card_id", i);
      this.this$0.startActivity((Intent)localObject1);
      this.this$0.overridePendingTransition(2130772376, 0);
      anot.a(this.this$0.app, "CliOper", "", "", "0X8006A97", "0X8006A97", 0, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "defaultcard", "click_othersdefaultcard", "", 1, 0, 0, "", Integer.toString(i), "");
      break label1009;
      label1281:
      i = 2;
      break label1036;
      label1286:
      if ((this.this$0.jdField_a_of_type_Alcn.e.pa == 33) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 80)) {
        break;
      }
      if (!ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e))
      {
        localObject1 = FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e);
        if (((this.this$0.jdField_a_of_type_Alcn.e.pa == 53) && (!this.this$0.jdField_a_of_type_Alcn.e.bindQQ)) || (localObject1 == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
          break label749;
        }
        localObject4 = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_face");
        if (localObject4 == null) {
          break label749;
        }
        aqep.a(this.this$0, (View)localObject4, (String)localObject1);
        break label749;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label749;
      }
      localObject1 = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_face");
      if (localObject1 == null)
      {
        localObject1 = null;
        label1481:
        localObject4 = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_avatar_pendant");
        l = this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.pendantId;
        if ((this.this$0.jdField_a_of_type_Alcn.e.pa == 0) || (!ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e)) || (localObject4 == null) || (localObject1 == null) || (((View)localObject4).getVisibility() != 0) || (l == 0L)) {
          break label1900;
        }
        i = 0;
        if (this.this$0.jdField_a_of_type_Alcn.e.pa != 1) {
          break label1710;
        }
        i = 1;
      }
      for (;;)
      {
        anot.a(this.this$0.app, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
        if (!(localObject1 instanceof DynamicAvatarView)) {
          break;
        }
        localObject4 = (DynamicAvatarView)localObject1;
        if (((DynamicAvatarView)localObject4).b == null) {
          break;
        }
        localObject4 = ((DynamicAvatarView)localObject4).b;
        if ((!((aqcy)localObject4).cTy) || (((aqcy)localObject4).N == null) || (TextUtils.isEmpty(((aqcy)localObject4).mBigUrl))) {
          break label1850;
        }
        aqep.b(this.this$0, (View)localObject1, ((aqcy)localObject4).mBigUrl);
        break;
        localObject1 = ((AvatarLayout)localObject1).Q(0);
        break label1481;
        label1710:
        if (this.this$0.jdField_a_of_type_Alcn.e.pa == 20) {
          i = 2;
        } else if (this.this$0.jdField_a_of_type_Alcn.e.pa == 21) {
          i = 3;
        } else if (this.this$0.jdField_a_of_type_Alcn.e.pa == 45) {
          i = 4;
        } else if (this.this$0.jdField_a_of_type_Alcn.e.pa == 46) {
          i = 5;
        } else if (this.this$0.jdField_a_of_type_Alcn.e.pa == 41) {
          i = 6;
        } else if (this.this$0.jdField_a_of_type_Alcn.e.pa == 42) {
          i = 7;
        }
      }
      label1850:
      localObject4 = new ProfileActivity.AllInOne(this.this$0.app.getAccount(), 1);
      aqep.a(this.this$0, (View)localObject1, this.this$0.jdField_a_of_type_Alcn.e.uin, l, i, (ProfileActivity.AllInOne)localObject4);
      break label749;
      label1900:
      if ((localObject1 == null) || (!(localObject1 instanceof DynamicAvatarView))) {
        break label749;
      }
      localObject4 = (DynamicAvatarView)localObject1;
      if (((DynamicAvatarView)localObject4).b == null) {
        break label749;
      }
      localObject4 = ((DynamicAvatarView)localObject4).b;
      if ((((aqcy)localObject4).cTy) && (((aqcy)localObject4).N != null) && (!TextUtils.isEmpty(((aqcy)localObject4).mBigUrl)))
      {
        aqep.b(this.this$0, (View)localObject1, ((aqcy)localObject4).mBigUrl);
        break label749;
      }
      if ((this.this$0.jdField_a_of_type_Alcn.e.pa == 41) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.uin)) && (this.this$0.jdField_a_of_type_Alcn.e.uin.equals("0")))
      {
        aqep.a(this.this$0, (View)localObject1, this.this$0.jdField_a_of_type_Alcn.e.uid, false, false, null);
        break label749;
      }
      localObject4 = new ProfileActivity.AllInOne(this.this$0.app.getAccount(), 1);
      aqep.a(this.this$0, (View)localObject1, this.this$0.jdField_a_of_type_Alcn.e.uin, false, false, (ProfileActivity.AllInOne)localObject4);
      break label749;
      label2114:
      anot.a(this.this$0.app, "CliOper", "", "", "0X8006A8B", "0X8006A8B", 0, 0, "", "", "", "");
      break;
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((albb)localObject4).data);
      if (this.this$0.fp == null) {
        this.this$0.fp = new int[5];
      }
      this.this$0.fp[0] = 7;
      this.this$0.fp[1] = 8;
      if (ProfileActivity.AllInOne.b(this.this$0.jdField_a_of_type_Alcn.e))
      {
        this.this$0.fp[2] = 9;
        this.this$0.fp[3] = 16;
      }
      for (;;)
      {
        i = 4;
        while (i < 5)
        {
          this.this$0.fp[i] = -1;
          i += 1;
        }
        this.this$0.fp[2] = 16;
        this.this$0.fp[3] = -1;
      }
      this.this$0.d(this.this$0.fp, ((albb)localObject4).nType);
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005AFD", "0X8005AFD", 0, 0, "", "", "", "");
      break;
      this.this$0.bOH();
      anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), "", "", "");
      break;
      this.this$0.bOI();
      ThreadManager.post(new FriendProfileCardActivity.30.1(this), 8, null, true);
      anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), "", "", "");
      if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0) {
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
      }
      while (this.this$0.jdField_a_of_type_Alcn.cwc)
      {
        new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("zone_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
        break;
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
      }
      localObject1 = new Intent(this.this$0, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.this$0.jdField_a_of_type_Alcn.d.presentCustourl);
      this.this$0.startActivity((Intent)localObject1);
      ThreadManager.getFileThreadHandler().post(new FriendProfileCardActivity.30.2(this));
      if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0)
      {
        anot.a(this.this$0.app, "", "", "", "0X800A1C7", "0X800A1C7", 0, 0, "", "", "", "");
        break;
      }
      anot.a(this.this$0.app, "", "", "", "0X800A1C9", "0X800A1C9", 0, 0, "", "", "", "");
      break;
      localObject4 = this.this$0.jdField_a_of_type_Alcn.e.uin;
      localObject1 = new Date(System.currentTimeMillis());
      Object localObject5 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject1);
      Object localObject6 = QzoneConfig.getInstance().getConfig("H5Url", "give_gift_button_in_profile_url", "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&from=card&friends={to_uin}");
      localObject1 = null;
      if (!TextUtils.isEmpty((CharSequence)localObject6)) {
        localObject1 = ((String)localObject6).replace("{to_uin}", (String)localObject4 + "_" + (String)localObject5);
      }
      localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
      ((Intent)localObject4).putExtra("url", (String)localObject1);
      this.this$0.startActivity((Intent)localObject4);
      anot.a(this.this$0.app, "", "", "", "0X800A1C5", "0X800A1C5", 0, 0, "", "", "", "");
      break;
      if (QSecFramework.a().c(1001).booleanValue()) {
        QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(6), "addfriend", null }, null);
      }
      FriendProfileCardActivity.b(this.this$0);
      anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), Integer.toString(this.this$0.jdField_a_of_type_Alcn.e.bJd), "", "");
      if (this.this$0.jdField_a_of_type_Alcn.e.bJa == 119) {
        anot.a(this.this$0.app, "dc01160", "", "", "0X800A410", "0X800A410", 0, 0, "", "", "", "");
      }
      if (aqft.rj(this.this$0.jdField_a_of_type_Alcn.e.uin)) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X8008274", "0X8008274", 0, 0, "", "", "", "");
      }
      if ((this.this$0.jdField_a_of_type_Alcn.e.pa == 82) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 81) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 83) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 101) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 103) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 102) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 107) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 110))
      {
        localObject6 = this.this$0.getIntent().getBundleExtra("profile_extres");
        if (localObject6 != null) {
          i = 0;
        }
      }
      switch (this.this$0.jdField_a_of_type_Alcn.e.pa)
      {
      default: 
        label3488:
        localObject1 = ((Bundle)localObject6).getString("recommend_entry_type", "");
        localObject4 = ((Bundle)localObject6).getString("recommend_reason", "");
        j = ((Bundle)localObject6).getInt("key_display_type", 0);
        int k = ((Bundle)localObject6).getInt("recommend_pos", 0);
        localObject5 = ((Bundle)localObject6).getByteArray("recommend_algh_id");
        localObject6 = ((Bundle)localObject6).getString("recommend_label", "");
        ContactReportUtils.a(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin, "frd_list_add", i, 2, (String)localObject4, k, (byte[])localObject5, (String)localObject6, j, (String)localObject1);
        if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.e != null))
        {
          if (87 == this.this$0.jdField_a_of_type_Alcn.e.bJa) {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8006F0D", "0X8006F0D", 0, 0, "", "", "", "");
          }
        }
        else {
          label3667:
          if (this.this$0.jdField_a_of_type_Alcn.e.pa == 53)
          {
            if (this.this$0.bHa != 1) {
              break label4260;
            }
            anot.a(this.this$0.app, "CliOper", "", "", "0X8007162", "0X8007162", 0, 0, "", "", "", "");
          }
        }
        break;
      }
      for (;;)
      {
        if (this.this$0.jdField_a_of_type_Alcn.cwc) {
          new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("addfri_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
        }
        if (this.this$0.jdField_a_of_type_Alcn.e.pa != 122) {
          break;
        }
        localObject1 = this.this$0.jdField_a_of_type_Alcn.e.data;
        if (localObject1 == null) {
          break;
        }
        i = ((Bundle)localObject1).getInt("key_troop_recommend_position", 0);
        localObject1 = (RecommendPerson)((Bundle)localObject1).getSerializable("key_troop_recommend_person");
        ajkn.a(this.this$0.app, i, 2, (RecommendPerson)localObject1);
        break;
        i = 21;
        break label3488;
        i = 23;
        break label3488;
        i = 3;
        break label3488;
        i = 24;
        break label3488;
        i = 20;
        break label3488;
        i = 25;
        break label3488;
        i = 28;
        break label3488;
        i = ((Bundle)localObject6).getInt("tabID", 0);
        break label3488;
        if ((101 == this.this$0.jdField_a_of_type_Alcn.e.bJa) || (102 == this.this$0.jdField_a_of_type_Alcn.e.bJa) || (103 == this.this$0.jdField_a_of_type_Alcn.e.bJa))
        {
          if (((ajdo)this.this$0.app.getManager(11)).Uv()) {}
          for (localObject1 = "0X80077D4";; localObject1 = "0X80077CE")
          {
            anot.a(this.this$0.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
            if (101 != this.this$0.jdField_a_of_type_Alcn.e.bJa) {
              break label4105;
            }
            anot.a(this.this$0.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
            break;
          }
          label4105:
          if (102 == this.this$0.jdField_a_of_type_Alcn.e.bJa)
          {
            anot.a(this.this$0.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
            break label3667;
          }
          if (103 != this.this$0.jdField_a_of_type_Alcn.e.bJa) {
            break label3667;
          }
          anot.a(this.this$0.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 3, 0, "", "", "", "");
          break label3667;
        }
        if (104 != this.this$0.jdField_a_of_type_Alcn.e.bJa) {
          break label3667;
        }
        anot.a(this.this$0.app, "dc00898", "", "", "0X80077D1", "0X80077D1", 0, 0, "", "", "", "");
        break label3667;
        label4260:
        if (this.this$0.bHa == 2) {
          anot.a(this.this$0.app, "CliOper", "", "", "0X8007163", "0X8007163", 0, 0, "", "", "", "");
        }
      }
      if (this.this$0.jdField_a_of_type_Alcn.e.bJa == 126)
      {
        aqha.a(this.this$0, 230, "", this.this$0.getString(2131693374), this.this$0.getString(2131693955), this.this$0.getString(2131693373), new uzo(this), new uzp(this)).show();
        break;
      }
      this.this$0.bOF();
      anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), Integer.toString(this.this$0.jdField_a_of_type_Alcn.e.bJd), "", "");
      if (!this.this$0.jdField_a_of_type_Alcn.cwc) {
        break;
      }
      new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
      break;
      anot.a(null, "dc00898", "", "", "qq_vip", "0X8009E3B", 2, 0, "", "", "", "");
      if (this.this$0.jdField_a_of_type_Alcn.cwc) {
        VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      localObject1 = paramView.findViewById(2131381235);
      localObject5 = paramView.getParent();
      if ((localObject5 instanceof View)) {
        localObject1 = ((View)localObject5).findViewById(2131381235);
      }
      i = 1;
      if (localObject1 != null) {
        if (((View)localObject1).getVisibility() != 0) {
          break label4960;
        }
      }
      label4960:
      for (i = 0;; i = 1)
      {
        ((View)localObject1).setVisibility(8);
        FriendProfileCardActivity.c(this.this$0);
        this.this$0.bOw();
        localObject1 = "";
        if (((albb)localObject4).nType == 92) {
          localObject1 = "profileType=custom";
        }
        aqep.a(this.this$0, this.this$0.app.getCurrentAccountUin(), "inside.myCardButton", i, 3, 1, (String)localObject1, true);
        anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X8006681", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "dc00898", "", "", "0X8007EB5", "0X8007EB5", 0, 0, "", "", "", "");
        if (this.this$0.jdField_a_of_type_Alcn.cwc) {
          VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "group_card", "click_cardbt", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        if ((this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agm) && (this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agl)) {
          break;
        }
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkcard_owner", "0", 1, 0, 0, jqc.hS(), String.valueOf(this.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), String.valueOf(this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId));
        break;
      }
      j = ((Integer)((albb)localObject4).data).intValue();
      if ((j == 101107) || (j == 101108))
      {
        if (j != 101108) {
          break label5140;
        }
        i = 5;
        label5000:
        if (j != 101108) {
          break label5145;
        }
        VipUtils.c(this.this$0, 3, aqep.gb(i));
      }
      for (;;)
      {
        if (this.this$0.jdField_a_of_type_Alcn.cwc) {
          VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "group_card", "guide_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        anot.a(this.this$0.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), "", "", "");
        break;
        label5140:
        i = 2;
        break label5000;
        label5145:
        VipUtils.b(this.this$0, 3, aqep.gb(i));
      }
      if ((((albb)localObject4).data instanceof Card))
      {
        this.this$0.b((Card)((albb)localObject4).data);
        break;
      }
      this.this$0.b(null);
      break;
      this.this$0.bOE();
      anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.eP(this.this$0.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), "", "", "");
      break;
      if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
        break;
      }
      this.this$0.xo(false);
      if (FriendProfileCardActivity.b(this.this$0)) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X80081C1", "0X80081C1", 0, 0, "", "", "", "");
      }
      new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("edit_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
      break;
      if (this.this$0.jdField_a_of_type_Alcn.cwc)
      {
        new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("more_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
        localObject1 = (TroopManager)this.this$0.app.getManager(52);
        localObject5 = ((TroopManager)localObject1).b(this.this$0.jdField_a_of_type_Alcn.troopUin);
        if (localObject5 == null) {
          break;
        }
        this.this$0.c((TroopInfo)localObject5);
        localObject4 = new Intent();
        ((Intent)localObject4).putExtra("troopUin", this.this$0.jdField_a_of_type_Alcn.troopUin);
        ((Intent)localObject4).putExtra("memberUin", this.this$0.jdField_a_of_type_Alcn.d.uin);
        ((Intent)localObject4).putExtra("fromFlag", this.this$0.jdField_a_of_type_Alcn.drN);
        ((Intent)localObject4).putExtra("troopMemberCard", this.this$0.jdField_a_of_type_Alcn.c);
        ((Intent)localObject4).putExtra("troopCode", ((TroopInfo)localObject5).troopcode);
        ((Intent)localObject4).putExtra("troopName", ((TroopInfo)localObject5).getTroopName());
        ((Intent)localObject4).putExtra("hwCard", ((TroopManager)localObject1).a(this.this$0.jdField_a_of_type_Alcn.troopUin, this.this$0.jdField_a_of_type_Alcn.d.uin));
        ((Intent)localObject4).putExtra("qidian_private_troop", TroopInfo.isQidianPrivateTroop(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.troopUin));
        if (this.this$0.jdField_a_of_type_Alcn.e == null) {
          break;
        }
        if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.nickname)) {
          this.this$0.jdField_a_of_type_Alcn.e.nickname = aqgv.n(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin);
        }
        ((Intent)localObject4).putExtra("AllInOne", this.this$0.jdField_a_of_type_Alcn.e);
        ((Intent)localObject4).putExtra("detailProfileUrl", aqep.a(this.this$0.jdField_a_of_type_Alcn, this.this$0.app, this.this$0));
        ((Intent)localObject4).putExtra("qidianshowUin", asgx.I(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin));
        localObject1 = (acff)this.this$0.app.getManager(51);
        boolean bool2 = ((acff)localObject1).isFriend(this.this$0.jdField_a_of_type_Alcn.e.uin);
        ((Intent)localObject4).putExtra("isFriend", bool2);
        ((Intent)localObject4).putExtra("isQidianMaster", ((asgx)this.this$0.app.getManager(165)).sM(this.this$0.jdField_a_of_type_Alcn.e.uin));
        localObject5 = ((acff)localObject1).b(this.this$0.jdField_a_of_type_Alcn.e.uin);
        if (localObject5 != null)
        {
          ((Intent)localObject4).putExtra("specialFlag", ((Friends)localObject5).cSpecialFlag);
          if (((Friends)localObject5).isFriend())
          {
            ((Intent)localObject4).putExtra("key_remark", ((Friends)localObject5).remark);
            ((Intent)localObject4).putExtra("key_group_id", ((Friends)localObject5).groupid);
            ((Intent)localObject4).putExtra("key_current_nick", aqgv.A(this.this$0.app, this.this$0.app.getCurrentAccountUin()));
            localObject6 = ((acff)localObject1).a(String.valueOf(((Friends)localObject5).groupid));
            if (localObject6 != null) {
              break label6758;
            }
            ((Intent)localObject4).putExtra("key_group_name", "");
            label6083:
            ((Intent)localObject4).putExtra("key_not_disturb", FriendsStatusUtil.g(this.this$0.jdField_a_of_type_Alcn.e.uin, this.this$0.app));
            ((Intent)localObject4).putExtra("key_is_shield", ((acff)localObject1).ke(this.this$0.jdField_a_of_type_Alcn.e.uin));
            ((Intent)localObject4).putExtra("key_type_gather", ((Friends)localObject5).gathtertype);
            ((Intent)localObject4).putExtra("key_is_has_interaction", ajnn.c(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin, true));
            localObject1 = ((acff)localObject1).a(this.this$0.jdField_a_of_type_Alcn.e.uin);
            if ((localObject1 == null) || (((SpecialCareInfo)localObject1).globalSwitch == 0)) {
              break label6775;
            }
            bool1 = true;
            label6225:
            ((Intent)localObject4).putExtra("key_is_specialcare", bool1);
          }
        }
        ((Intent)localObject4).putExtra("businessCard", adzx.a(this.this$0.app, this.this$0.jdField_a_of_type_Alcn));
        if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.a != null) && (this.this$0.jdField_a_of_type_Alcn.a.IC != null) && (this.this$0.jdField_a_of_type_Alcn.a.IC.size() > 0)) {
          ((Intent)localObject4).putExtra("SHARE_NICK_NAME", ((aqae)this.this$0.jdField_a_of_type_Alcn.a.IC.get(0)).value);
        }
        if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.d.addSrcName))) {
          ((Intent)localObject4).putExtra("cur_add_source", this.this$0.jdField_a_of_type_Alcn.d.addSrcName);
        }
        if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d != null)) {
          ((Intent)localObject4).putExtra("key_nick_name", this.this$0.jdField_a_of_type_Alcn.d.strNick);
        }
        if ((paramView instanceof TextView))
        {
          localObject1 = ((TextView)paramView).getText().toString();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((Intent)localObject4).putExtra("title", (String)localObject1);
          }
        }
        if (bool2)
        {
          if (!ajok.nx(this.this$0.app.getCurrentUin())) {
            break label6781;
          }
          bool1 = true;
          label6529:
          ((Intent)localObject4).putExtra("friend_intimate_open", bool1);
          ((Intent)localObject4).putExtra("friend_intimate_bind_url", ajok.mn(this.this$0.jdField_a_of_type_Alcn.e.uin));
          i = 0;
          localObject1 = "";
          localObject5 = ajnn.a(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin, true);
          if (localObject5 == null) {
            break label13257;
          }
          if (((ajoh)localObject5).type != 1L) {
            break label6787;
          }
          localObject1 = this.this$0.getString(2131695048);
          label6624:
          i = ((ajoh)localObject5).iconResId;
        }
      }
      for (boolean bool1 = ((ajoh)localObject5).arj();; bool1 = false)
      {
        ((Intent)localObject4).putExtra("friend_intimate_bind_name", (String)localObject1);
        ((Intent)localObject4).putExtra("friend_intimate_isExtinguish", bool1);
        ((Intent)localObject4).putExtra("friend_intimate_bind_res_icon", i);
        ((Intent)localObject4).putExtra("isMsgShielded", this.this$0.PE());
        ((Intent)localObject4).putExtra("isGather", FriendProfileCardActivity.c(this.this$0));
        localObject1 = TroopBaseProxyActivity.a(this.this$0);
        TroopMemberCardProxyActivity.a(this.this$0.app, "troop_member_card_plugin.apk", acfp.m(2131706592), TroopMemberCardProxyActivity.class, this.this$0, (Intent)localObject4, (Dialog)localObject1, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.this$0.app.getCurrentAccountUin(), 8);
        break;
        label6758:
        ((Intent)localObject4).putExtra("key_group_name", ((Groups)localObject6).group_name);
        break label6083;
        label6775:
        bool1 = false;
        break label6225;
        label6781:
        bool1 = false;
        break label6529;
        label6787:
        if (((ajoh)localObject5).type == 2L)
        {
          localObject1 = this.this$0.getString(2131695046);
          break label6624;
        }
        if (((ajoh)localObject5).type != 3L) {
          break label6624;
        }
        localObject1 = this.this$0.getString(2131695047);
        break label6624;
        FriendProfileCardActivity.a(this.this$0);
        break;
        if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
          break;
        }
        if (this.this$0.fp == null) {
          this.this$0.fp = new int[5];
        }
        this.this$0.fp[0] = 31;
        this.this$0.fp[1] = 32;
        this.this$0.fp[2] = 16;
        this.this$0.fp[3] = -1;
        this.this$0.fp[4] = -1;
        this.this$0.d(this.this$0.fp, ((albb)localObject4).nType);
        j = 2;
        i = j;
        if (this.this$0.n != null)
        {
          i = j;
          if (this.this$0.n.aux()) {
            i = 1;
          }
        }
        anot.a(this.this$0.app, "dc00898", "", "", "0X800A97C", "0X800A97C", i, 0, "0", "0", "", "");
        break;
        aqep.fw(this.this$0);
        break;
        if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0) {
          aqnl.a(this.this$0, this.this$0.app, 0, "signature_ziliaoka");
        }
        for (;;)
        {
          if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
            break label7213;
          }
          anot.a(this.this$0.app, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
          break;
          localObject1 = new Intent(this.this$0, PublicFragmentActivity.class);
          ((Intent)localObject1).putExtra("key_uin", this.this$0.jdField_a_of_type_Alcn.e.uin);
          ((Intent)localObject1).putExtra("key_uin_name", this.this$0.jdField_a_of_type_Alcn.a.a.value);
          ((Intent)localObject1).putExtra("key_open_via", "history-kerentaiziliaoka");
          PublicFragmentActivity.b.start(this.this$0, (Intent)localObject1, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        }
        label7213:
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
        break;
        localObject1 = (Pair)((albb)localObject4).data;
        amin.u(this.this$0, amin.K(((Integer)((Pair)localObject1).first).intValue(), (String)((Pair)localObject1).second), -1);
        paramView.setVisibility(8);
        aldf.a().dE(this.this$0.app);
        anot.a(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "1", "0", "", "");
        break;
        localObject1 = new int[5];
        localObject4 = jln.a(this.this$0);
        ((jln)localObject4).setMainTitle(2131689654);
        ((jln)localObject4).addButton(2131721238);
        localObject1[0] = 1;
        localObject1[1] = 2;
        ((jln)localObject4).addButton(2131721260);
        ((jln)localObject4).addCancelButton(2131721058);
        ((jln)localObject4).a(new uzq(this));
        ((jln)localObject4).a(new uzr(this, (int[])localObject1, (jln)localObject4));
        ((jln)localObject4).show();
        anot.a(this.this$0.app, "CliOper", "", "", "0X8008404", "0X8008404", 0, 0, "", "", "", "");
        break;
        localObject1 = new FriendProfileCardActivity.30.7(this);
        localObject4 = new uzs(this);
        localObject4 = new DenyRunnable(this.this$0, (DenyRunnable.b)localObject4);
        yuw.a(this.this$0, this.this$0.app, (Runnable)localObject1, (Runnable)localObject4);
        if (this.this$0.bHa == 2)
        {
          anot.a(this.this$0.app, "CliOper", "", "", "0X8007164", "0X8007164", 0, 0, "", "", "", "");
          break;
        }
        if (this.this$0.bHa != 3) {
          break;
        }
        anot.a(this.this$0.app, "CliOper", "", "", "0X8007165", "0X8007165", 0, 0, "", "", "", "");
        break;
        localObject4 = this.this$0.jdField_a_of_type_Alcn.d.privilegeJumpUrl;
        localObject1 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
            break label7841;
          }
        }
        label7841:
        for (localObject1 = "https://mc.vip.qq.com/privilegelist/index";; localObject1 = "https://mc.vip.qq.com/privilegelist/other?friend=" + this.this$0.jdField_a_of_type_Alcn.e.uin)
        {
          localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject1);
          ((Intent)localObject4).putExtra("hide_operation_bar", true);
          ((Intent)localObject4).putExtra("hide_more_button", true);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.this$0.startActivity((Intent)localObject4);
          anot.b(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
          if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
            break label7878;
          }
          anot.a(this.this$0.app, "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
          anot.a(this.this$0.app, "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
          break;
        }
        label7878:
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(j), "", "", "");
        break;
        if (!(((albb)localObject4).data instanceof alda)) {
          break;
        }
        localObject1 = (alda)((albb)localObject4).data;
        localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
        if (((alda)localObject1).serviceType == 2) {
          ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_qqmusic");
        }
        for (;;)
        {
          ((Intent)localObject4).putExtra("url", ((alda)localObject1).bVJ);
          this.this$0.startActivity((Intent)localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("remilelei", 2, "hobby go to :" + ((alda)localObject1).bVJ);
          }
          this.this$0.AO(((alda)localObject1).serviceType);
          break;
          if (((alda)localObject1).serviceType == 4) {
            ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_feeds_buluo");
          }
        }
        if (!(((albb)localObject4).data instanceof aldb)) {
          break;
        }
        localObject1 = (aldb)((albb)localObject4).data;
        localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
        switch (((aldb)localObject1).serviceType)
        {
        }
        for (;;)
        {
          ((Intent)localObject4).putExtra("url", ((aldb)localObject1).strJmpUrl);
          this.this$0.startActivity((Intent)localObject4);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("remilelei", 2, "hobby go to :" + ((aldb)localObject1).strJmpUrl);
          break;
          if (((aldb)localObject1).drY == 0)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X80070B2", "0X80070B2", 0, 0, "", "", "", "");
          }
          else
          {
            ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_feeds_buluo");
            anot.a(this.this$0.app, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
            continue;
            ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_qqmusic");
            anot.a(this.this$0.app, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
          }
        }
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
          break;
        }
        localObject1 = this.this$0.app.getCurrentAccountUin();
        if (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(localObject1))
        {
          anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X8004435", 0, 0, Long.toString(this.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), "", "", VipUtils.d(this.this$0.app, this.this$0.app.getCurrentAccountUin()));
          if ((this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agm) || (this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agl)) {
            VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_owner", "0", 1, 0, 0, jqc.hS(), String.valueOf(this.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), String.valueOf(this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId));
          }
          if (this.this$0.jdField_a_of_type_Alcn.cwc)
          {
            localObject1 = this.this$0.app.getCurrentAccountUin();
            localObject4 = new StringBuilder().append("");
            if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
              break label8710;
            }
          }
          label8710:
          for (i = 1;; i = 2)
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject1, "group_card", "click_cover", "", 0, 0, 0, "", "", i, "", "", "", "", 0, 0, 0, 0);
            aqep.a(this.this$0, this.this$0.app.getCurrentAccountUin(), "inside.myCardBackground", 1, 0, 1, "", true);
            break;
          }
        }
        if ((((albb)localObject4).data instanceof String)) {}
        for (localObject1 = (String)((albb)localObject4).data;; localObject3 = "CLICK_HEADER_BG")
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                if ("CLICK_HEADER_BG".equals(localObject1))
                {
                  anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "1", "", "", VipUtils.d(this.this$0.app, this.this$0.app.getCurrentAccountUin()));
                  if ((this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agm) || (this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agl)) {
                    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clkbkgd_visitor", "0", 1, 0, 0, jqc.hS(), String.valueOf(this.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), String.valueOf(this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId));
                  }
                }
                for (;;)
                {
                  anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80047F0", 0, 0, Integer.toString(ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e)), Long.toString(this.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId), "", VipUtils.d(this.this$0.app, this.this$0.app.getCurrentAccountUin()));
                  if ((this.this$0.mActionSheet == null) || (!this.this$0.mActionSheet.isShowing())) {
                    break label9057;
                  }
                  break;
                  if ("CLICK_BANNER".equals(localObject1)) {
                    anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80047F1", 0, 0, "2", "", "", VipUtils.d(this.this$0.app, this.this$0.app.getCurrentAccountUin()));
                  }
                }
                label9057:
                localObject5 = this.this$0.getString(2131717269);
                anot.a(this.this$0.app, "dc00898", "", "", "", "0X800A4C0", 0, 0, "", "", "", "");
                localObject4 = ausj.b(this.this$0);
                ((ausj)localObject4).addButton(2131717464, 1);
                ((ausj)localObject4).addButton((CharSequence)localObject5, 1);
                ((ausj)localObject4).addButton(2131721058, 1);
                ((ausj)localObject4).a(new uzt(this, (String)localObject1, (ausj)localObject4));
                try
                {
                  ((ausj)localObject4).show();
                  this.this$0.mActionSheet = ((ausj)localObject4);
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    localException1.printStackTrace();
                  }
                }
              }
              anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
              Intent localIntent1 = new Intent(this.this$0, ProfileLabelEditorActivity.class);
              localIntent1.putExtra("uin", this.this$0.jdField_a_of_type_Alcn.e.uin);
              try
              {
                this.this$0.startActivityForResult(localIntent1, 1004);
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
              }
            }
            break;
            anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
            Intent localIntent2 = new Intent(this.this$0, ProfileLabelEditorActivity.class);
            localIntent2.putExtra("uin", this.this$0.jdField_a_of_type_Alcn.e.uin);
            try
            {
              this.this$0.startActivityForResult(localIntent2, 1004);
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
            }
          }
          break;
          if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d == null)) {
            break;
          }
          if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0) {
            anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "0", "", "", "");
          }
          for (;;)
          {
            aqep.i(this.this$0, this.this$0.jdField_a_of_type_Alcn.d.lCurrentBgId, this.this$0.jdField_a_of_type_Alcn.d.strActiveUrl);
            break;
            anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X8007A48", 0, 0, "1", "", "", "");
          }
          if (this.this$0.aNf == null) {
            break;
          }
          anot.a(this.this$0.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Ftemplateinto", "0X8005B97", 0, 0, "", "", "", "");
          if (this.this$0.mFollowType == 1)
          {
            localObject2 = new Intent(this.this$0, ChatActivity.class);
            if (TextUtils.isEmpty(this.this$0.aNf))
            {
              if (QLog.isColorLevel()) {
                QLog.w("FriendProfileCardActivity", 2, "onItemClick - uin = null");
              }
              break;
            }
            ((Intent)localObject2).putExtra("uin", this.this$0.aNf);
            ((Intent)localObject2).putExtra("uintype", 1008);
            ((Intent)localObject2).putExtra("uinname", this.this$0.aNg);
            ((Intent)localObject2).putExtra("selfSet_leftViewText", this.this$0.getString(2131697387));
            this.this$0.startActivity((Intent)localObject2);
            break;
          }
          Object localObject2 = null;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("report_src_param_type", "gouwu_follow");
            if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView)) {
              break label9785;
            }
            ((Intent)localObject2).putExtra("report_src_param_name", "0X8005D5A");
          }
          for (;;)
          {
            ocp.a((Intent)localObject2, this.this$0.app, this.this$0, this.this$0.aNf, this.this$0.bdV);
            break;
            label9785:
            ((Intent)localObject2).putExtra("report_src_param_name", "0X8005D59");
          }
          if ((this.this$0.jdField_a_of_type_Alcn.e.pa != 32) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 31) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 50) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 51) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 34) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 53)) {
            break;
          }
          this.this$0.bOt();
          break;
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((albb)localObject4).data);
          if (this.this$0.fp == null) {
            this.this$0.fp = new int[5];
          }
          this.this$0.fp[0] = 7;
          this.this$0.fp[1] = 8;
          if ((ProfileActivity.AllInOne.b(this.this$0.jdField_a_of_type_Alcn.e)) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.aOL)))
          {
            this.this$0.fp[2] = 9;
            this.this$0.fp[3] = 16;
          }
          for (;;)
          {
            i = 4;
            while (i < 5)
            {
              this.this$0.fp[i] = -1;
              i += 1;
            }
            this.this$0.fp[2] = 16;
            this.this$0.fp[3] = -1;
          }
          this.this$0.d(this.this$0.fp, ((albb)localObject4).nType);
          if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
            break;
          }
          anot.a(this.this$0.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
          break;
          localObject2 = new Intent(this.this$0, QRDisplayActivity.class);
          localObject4 = this.this$0.getResources().getString(2131717228);
          localObject5 = this.this$0.app.getCurrentAccountUin();
          localObject6 = aqgv.n(this.this$0.app, (String)localObject5);
          ((Intent)localObject2).putExtra("title", (String)localObject4);
          ((Intent)localObject2).putExtra("uin", (String)localObject5);
          ((Intent)localObject2).putExtra("nick", (String)localObject6);
          ((Intent)localObject2).putExtra("type", 1);
          ((Intent)localObject2).putExtra("reportFlag", 1);
          this.this$0.startActivity((Intent)localObject2);
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
          break;
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((albb)localObject4).data);
          if (this.this$0.fp == null) {
            this.this$0.fp = new int[5];
          }
          this.this$0.fp[0] = 7;
          this.this$0.fp[1] = 8;
          if ((ProfileActivity.AllInOne.b(this.this$0.jdField_a_of_type_Alcn.e)) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.aOL)))
          {
            this.this$0.fp[2] = 9;
            this.this$0.fp[3] = 16;
          }
          for (;;)
          {
            i = 4;
            while (i < 5)
            {
              this.this$0.fp[i] = -1;
              i += 1;
            }
            this.this$0.fp[2] = 16;
            this.this$0.fp[3] = -1;
          }
          this.this$0.d(this.this$0.fp, ((albb)localObject4).nType);
          if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0)
          {
            anot.a(this.this$0.app, "CliOper", "", "", "0X8006A7E", "0X8006A7E", 0, 0, "", "", "", "");
            break;
          }
          anot.a(this.this$0.app, "CliOper", "", "", "0X8006A92", "0X8006A92", 0, 0, "", "", "", "");
          break;
          localObject2 = (aqrc)this.this$0.app.getManager(235);
          if (((aqrc)localObject2).aFy())
          {
            this.this$0.mContentView.findViewById(2131372297).setVisibility(8);
            ((aqrc)localObject2).SQ(false);
          }
          this.this$0.AP(0);
          if (this.this$0.jdField_a_of_type_Alcn.d != null) {
            if (this.this$0.jdField_a_of_type_Alcn.d.mQQLevelType == 0) {
              i = 99999;
            }
          }
          for (;;)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X800A8C1", "0X800A8C1", j, 0, String.valueOf(j), "", "", "");
            if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
              break label10826;
            }
            anot.a(this.this$0.app, "CliOper", "", "", "0X8006A7A", "0X8006A7A", 0, 0, "", "", "", "");
            anot.a(null, "dc00898", "", "", "qq_vip", "0X800A775", i, 0, "", "", "", "");
            break;
            i = this.this$0.jdField_a_of_type_Alcn.d.mQQLevelType;
            continue;
            i = 99999;
          }
          label10826:
          anot.a(this.this$0.app, "CliOper", "", "", "0X8006A8E", "0X8006A8E", 0, 0, "", "", "", "");
          anot.a(null, "dc00898", "", "", "qq_vip", "0X800A774", i, 0, "", "", "", "");
          anot.a(this.this$0.app, "dc00898", "", "", "0X800A8C2", "0X800A8C2", j, 0, String.valueOf(j), "", "", "");
          break;
          this.this$0.bOD();
          if ((((albb)localObject4).data instanceof View)) {
            ((View)((albb)localObject4).data).setVisibility(8);
          }
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008119", "", 1, 0, 0, jqc.hS(), "", "");
          break;
          ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.jdField_a_of_type_Alcn.troopUin, this.this$0.jdField_a_of_type_Alcn.d.uin);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("troop_uin", this.this$0.jdField_a_of_type_Alcn.troopUin);
          ((Intent)localObject2).putExtra("member_uin", this.this$0.jdField_a_of_type_Alcn.d.uin);
          PublicFragmentActivity.start(this.this$0, (Intent)localObject2, TroopMemberHistoryFragment.class);
          new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("recent_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
          anot.a(this.this$0.app, "CliOper", "", "", "0X800A596", "0X800A596", 2, 0, "", "", "", "");
          break;
          localObject2 = snf.a(this.this$0, 1);
          if (localObject2 == null)
          {
            localObject2 = null;
            label11196:
            if (localObject2 == null) {
              break label11363;
            }
          }
          label11363:
          for (localObject2 = ((sna.c)localObject2).jumpUrl;; localObject2 = "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=0")
          {
            localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("url", (String)localObject2);
            ((Intent)localObject4).putExtra("url", (String)localObject2);
            this.this$0.startActivity((Intent)localObject4);
            anot.a(this.this$0.app, "dc00899", "Grp_flower", "", "gift_exch", "entry_clk", 0, 0, "", "", "", "");
            new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("point_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
            break;
            localObject2 = ((snf)localObject2).a;
            break label11196;
          }
          localObject2 = aptl.a();
          localObject4 = ((aptl)localObject2).getUrl("troop_rank");
          if (TextUtils.isEmpty((CharSequence)localObject4)) {}
          for (localObject2 = aptm.bR(this.this$0.jdField_a_of_type_Alcn.d.uin, this.this$0.jdField_a_of_type_Alcn.troopUin);; localObject2 = ((aptl)localObject2).a((String)localObject4, (aptl.a)localObject5))
          {
            localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("url", (String)localObject2);
            ((Intent)localObject4).putExtra("uin", this.this$0.app.getCurrentUin());
            ((Intent)localObject4).putExtra("portraitOnly", true);
            ((Intent)localObject4).putExtra("hide_more_button", true);
            ((Intent)localObject4).putExtra("hide_operation_bar", true);
            ((Intent)localObject4).putExtra("isShowAd", false);
            this.this$0.startActivity((Intent)localObject4);
            anot.a(this.this$0.app, "dc00899", "Grp_grade", "", "mber_card", "clk_grade", 0, 0, this.this$0.jdField_a_of_type_Alcn.troopUin, "", "", "");
            new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("grade_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
            break;
            localObject5 = new aptl.a();
            ((aptl.a)localObject5).from = "31";
            ((aptl.a)localObject5).uin = this.this$0.jdField_a_of_type_Alcn.d.uin;
            ((aptl.a)localObject5).crf = this.this$0.jdField_a_of_type_Alcn.troopUin;
          }
          for (;;)
          {
            try
            {
              localObject2 = aqgv.a(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.d.uin, this.this$0.jdField_a_of_type_Alcn.troopUin, 1, 0);
              localObject4 = new HashMap();
              ((Map)localObject4).put("big_brother_ref_source_key", "biz_src_hdsp_liwu");
              aptj.a(this.this$0, this.this$0.jdField_a_of_type_Alcn.troopUin, this.this$0.jdField_a_of_type_Alcn.d.uin, (String)localObject2, "profilecard", this.this$0.app, (Map)localObject4);
              localObject2 = ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.jdField_a_of_type_Alcn.troopUin);
              if (localObject2 == null) {
                break;
              }
              if (!((TroopInfo)localObject2).isTroopOwner(this.this$0.app.getCurrentAccountUin())) {
                break label12048;
              }
              i = 0;
              anot.a(this.this$0.app, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, this.this$0.jdField_a_of_type_Alcn.troopUin, i + "", "", "");
              anot.a(this.this$0.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, this.this$0.jdField_a_of_type_Alcn.troopUin, "4", aldj.eK(aldj.a((TroopInfo)localObject2, this.this$0.jdField_a_of_type_Alcn.d.uin)), "");
              new anov(this.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("flower_clk").a(new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin }).report();
            }
            catch (Exception localException4)
            {
              QLog.e("FriendProfileCardActivity", 1, "onClick DATA_TYPE_TROOP_MEM_SEND_GIFT fail.", localException4);
            }
            break;
            label12048:
            bool1 = localException4.isAdmin();
            if (bool1) {
              i = 1;
            } else {
              i = 2;
            }
          }
          if ((this.this$0.jdField_a_of_type_Alcn == null) || (this.this$0.jdField_a_of_type_Alcn.c == null)) {
            break;
          }
          localObject3 = this.this$0.jdField_a_of_type_Alcn.c.mMemberGameInfo;
          if (localObject3 == null) {
            break;
          }
          localObject4 = ((TroopMemberCard.MemberGameInfo)localObject3).gameUrl;
          localObject5 = new Intent(this.this$0, QQBrowserActivity.class);
          ((Intent)localObject5).putExtra("url", (String)localObject4);
          this.this$0.startActivity((Intent)localObject5);
          aqfr.b("Grp_game", "Mber_data", "game_clk", 0, 0, new String[] { this.this$0.jdField_a_of_type_Alcn.troopUin, ((TroopMemberCard.MemberGameInfo)localObject3).gameName });
          break;
          if ((((albb)localObject4).data == null) || (!(((albb)localObject4).data instanceof PhotoWallView))) {
            break;
          }
          ((PhotoWallView)((albb)localObject4).data).ein();
          break;
          if ((((albb)localObject4).data == null) || (!(((albb)localObject4).data instanceof PersonalityLabelBoard))) {
            break;
          }
          ((PersonalityLabelBoard)((albb)localObject4).data).NB(false);
          break;
          if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d == null)) {
            break;
          }
          if (this.this$0.app.getCurrentUin().equals(this.this$0.jdField_a_of_type_Alcn.d.uin))
          {
            if (this.this$0.PA())
            {
              if (this.this$0.aWx) {}
              for (i = 2;; i = 1)
              {
                anot.a(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
                break;
              }
            }
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.this$0.jdField_a_of_type_Alcn.d));
            PublicFragmentActivity.startForResult(this.this$0, (Intent)localObject3, ExtendFriendEditFragment.class, 4097);
            break;
          }
          if (this.this$0.aWy) {
            break;
          }
          ExtendFriendPublicFragmentActivity.ek(this.this$0);
          break;
          if (((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d == null)) || (aqft.rj(this.this$0.jdField_a_of_type_Alcn.e.uin))) {
            break;
          }
          FriendProfileCardActivity.d(this.this$0);
          break;
          if (!this.this$0.b(this.this$0.jdField_a_of_type_Alcn)) {
            break;
          }
          localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("hide_more_button", true);
          ((Intent)localObject3).putExtra("hide_operation_bar", true);
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_hdsp_dtzbj");
          ((Intent)localObject3).putExtra("url", this.this$0.jdField_a_of_type_Alcn.d.mNowShowJumpUrl);
          paramView.getContext().startActivity((Intent)localObject3);
          anot.a(this.this$0.app, "dc00899", "NOW", "", "qq_zlk", "logo_click", 0, 0, this.this$0.jdField_a_of_type_Alcn.d.uin, "", "", "");
          if (this.this$0.jdField_a_of_type_Alcn.e != null) {
            if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0) {
              i = 1;
            }
          }
          for (;;)
          {
            anot.a(this.this$0.app, "dc00898", "", "", "0X800999B", "0X800999B", i, 0, "", "", "", "");
            break;
            i = 2;
            continue;
            i = 2;
          }
          if (!(((albb)localObject4).data instanceof PrivilegeInfo))
          {
            QLog.e("DIYProfileTemplate.FriendProfileCardActivity", 1, "DATA_TYPE_BIG_DIAMOND url is not string:" + ((albb)localObject4).data);
            break;
          }
          localObject5 = (PrivilegeInfo)((albb)localObject4).data;
          localObject3 = ((PrivilegeInfo)localObject5).strJumpUrl;
          localObject4 = new Intent(this.this$0, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("hide_operation_bar", true);
          ((Intent)localObject4).putExtra("hide_more_button", true);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.this$0.startActivity((Intent)localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("DIYProfileTemplate.FriendProfileCardActivity", 1, "DATA_TYPE_BIG_DIAMOND click");
          }
          label12937:
          if (this.this$0.jdField_a_of_type_Alcn.e.pa == 0)
          {
            i = 1;
            label12888:
            switch (((PrivilegeInfo)localObject5).iType)
            {
            default: 
              if (i != 0)
              {
                localObject3 = "0X800A137";
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break;
                }
                if (((PrivilegeInfo)localObject5).iIsBig != 1) {
                  break label13115;
                }
                if (!((PrivilegeInfo)localObject5).isOpen) {
                  break label13110;
                }
                i = 1;
              }
              break;
            }
          }
          for (;;)
          {
            localObject4 = "";
            if (((PrivilegeInfo)localObject5).iType == 1) {
              localObject4 = String.valueOf(acny.e(this.this$0.app, this.this$0.app.getCurrentUin(), false));
            }
            anot.a(this.this$0.app, "dc00898", "", "", "qvip", (String)localObject3, i, 0, (String)localObject4, "", "", "");
            break;
            i = 0;
            break label12888;
            if (i != 0) {}
            for (localObject3 = "0X800A133";; localObject3 = "0X800A12B") {
              break;
            }
            if (i != 0) {}
            for (localObject3 = "0X800A135";; localObject3 = "0X800A12D") {
              break;
            }
            if (i != 0) {}
            for (localObject3 = "0X800A131";; localObject3 = "0X800A129") {
              break;
            }
            localObject3 = "0X800A12F";
            break label12937;
            label13110:
            i = 2;
            continue;
            label13115:
            if (((PrivilegeInfo)localObject5).isOpen) {
              i = 3;
            } else {
              i = 4;
            }
          }
          localObject5 = new LaunchParam();
          ((LaunchParam)localObject5).scene = 2062;
          bool1 = ((Boolean)((albb)localObject4).data).booleanValue();
          MiniAppUtils.reportProfileCardClick(this.this$0.jdField_a_of_type_Alcn.d, bool1);
          localObject4 = paramView.getContext();
          if (bool1) {}
          for (localObject3 = this.this$0.jdField_a_of_type_Alcn.d.tabJumpUrl;; localObject3 = this.this$0.jdField_a_of_type_Alcn.d.guestJumpUrl)
          {
            MiniAppController.startAppByLink((Context)localObject4, (String)localObject3, 2, (LaunchParam)localObject5, null);
            break;
          }
          this.this$0.bPa();
          break;
        }
        label13257:
        Object localObject3 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzn
 * JD-Core Version:    0.7.0.1
 */