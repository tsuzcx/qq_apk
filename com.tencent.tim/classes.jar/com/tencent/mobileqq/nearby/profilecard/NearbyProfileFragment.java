package com.tencent.mobileqq.nearby.profilecard;

import acfp;
import aehy;
import ajpb;
import ajpc;
import ajpj;
import ajpp;
import ajrb;
import ajri;
import ajuu;
import akbx;
import akcx;
import akhe;
import akhf;
import akhg;
import akhh;
import akhi;
import akhj;
import akhk;
import akhl;
import akhm;
import akht;
import akkx;
import amhj;
import anaz;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anov;
import aofk;
import apre;
import apsz;
import aqcr;
import aqcu;
import aqcx;
import aqdj;
import aqek;
import aqep;
import aqft;
import aqha;
import aqhv;
import aqik;
import aqju;
import aqmr;
import argi;
import arjh;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NearbyPeopleCard.HiWanItem;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.CustomImgView;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jnm;
import sna.c;
import snf;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import wja;

public class NearbyProfileFragment
  extends ReportV4Fragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private View Fm;
  private RedTouch P;
  private TextView VE;
  private TextView VG;
  private TextView VI;
  TextView VL;
  private TextView VX;
  private TextView VY;
  private TextView VZ;
  private TextView Wa;
  public ajpb a;
  akbx jdField_a_of_type_Akbx;
  akcx jdField_a_of_type_Akcx;
  private akht jdField_a_of_type_Akht;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  public NearbyPeopleProfileActivity a;
  ajuu[] jdField_a_of_type_ArrayOfAjuu;
  akbx b;
  private String bTf;
  protected String bTp;
  protected URLImageView bx;
  public boolean crP;
  boolean csb = false;
  private boolean cse;
  public boolean csl;
  private boolean csn;
  private int dmG;
  private int dmH;
  private byte[] eT;
  private LinearLayout jD;
  private LinearLayout jK;
  RelativeLayout lg;
  RelativeLayout li;
  private RelativeLayout lm;
  RelativeLayout lr;
  RelativeLayout ls;
  private View mRootView;
  private View og;
  
  private byte[] aj()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dms != 51) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().T(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dms == 51) {
        localObject2 = this.eT;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private void bm(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    int i = ((Resources)localObject2).getColor(2131167304);
    int j = ((Resources)localObject2).getColor(2131167385);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 0)
    {
      if (paramArrayOfByte != null)
      {
        localObject2 = RichStatus.parseStatus(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject2 != null) {
          paramArrayOfByte = ((RichStatus)localObject2).toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165381));
        }
        localObject1 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          localObject1 = new SpannableString("");
        }
        this.ls.setVisibility(0);
        if ((localObject2 == null) || (TextUtils.isEmpty(((RichStatus)localObject2).actionText))) {
          break label343;
        }
        localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject1).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a == null) {
          break label326;
        }
      }
      label326:
      for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.i(((RichStatus)localObject2).actionId, 200);; paramArrayOfByte = aqcu.decodeResource(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130850435))
      {
        paramArrayOfByte = new arjh(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
        j = (int)(this.VI.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, j, j);
        paramArrayOfByte = new argi(paramArrayOfByte, 0);
        paramArrayOfByte.a(-0.1F);
        ((SpannableStringBuilder)localObject1).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
        this.VI.setText((CharSequence)localObject1);
        this.VI.setTextColor(i);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        return;
      }
      label343:
      paramArrayOfByte = aqmr.trim(((SpannableString)localObject1).toString());
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        this.VI.setText(paramArrayOfByte.trim());
        this.VI.setTextColor(i);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        this.VI.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131696387));
        this.VI.setTextColor(j);
        return;
      }
      this.ls.setVisibility(8);
      return;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      if (!TextUtils.isEmpty(paramArrayOfByte))
      {
        this.VI.setText(paramArrayOfByte.trim());
        this.VI.setTextColor(i);
        this.ls.setVisibility(0);
        return;
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      QLog.i("NearbyProfileFragment", 1, "setXuanyan wx error, e=" + paramArrayOfByte.toString());
      return;
    }
    this.ls.setVisibility(8);
  }
  
  private void dBq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null))
    {
      i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();
      localObject = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).bytes_jump_url.get().toStringUtf8();
    }
    for (;;)
    {
      this.Fm.setVisibility(0);
      if (i == 0)
      {
        i = 1;
        this.VZ.setText(acfp.m(2131708819));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
          this.Fm.setVisibility(8);
        }
      }
      for (;;)
      {
        if (!aehy.ap(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
          this.Fm.setVisibility(8);
        }
        this.Fm.setOnClickListener(new akhe(this, (String)localObject, i));
        if (this.Fm.getVisibility() != 0) {
          this.mRootView.findViewById(2131370472).setVisibility(8);
        }
        bl(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
        bm(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
        i = ((Resources)localObject).getColor(2131167304);
        int j = ((Resources)localObject).getColor(2131167385);
        localObject = new StringBuilder();
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = aqmr.trim(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
        {
          ((StringBuilder)localObject).append(new aofk(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
          ((StringBuilder)localObject).append("  ");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job < aqek.cp.length))
        {
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
          ((StringBuilder)localObject).append(aqek.cp[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
          ((StringBuilder)localObject).append("  ");
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = aqmr.trim(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
        {
          ((StringBuilder)localObject).append(new aofk(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
        }
        if (((StringBuilder)localObject).length() > 0)
        {
          this.li.setVisibility(0);
          this.VG.setText(((StringBuilder)localObject).toString());
          this.VG.setTextColor(i);
          label573:
          if (this.jdField_a_of_type_Ajpb == null) {
            this.jdField_a_of_type_Ajpb = ajpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
          }
          if (!this.jdField_a_of_type_Ajpb.isExpired()) {
            break label1307;
          }
          ((ajpp)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(204)).a(new akhf(this));
          label631:
          dBa();
          this.lg.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
            break label1399;
          }
          this.lm.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType != 1) {
            break label1318;
          }
          this.lg.setVisibility(8);
          if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
            break label1539;
          }
          this.cse = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
        }
        for (this.bTf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;; this.bTf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips)
        {
          if (this.jdField_a_of_type_Akht != null) {
            this.jdField_a_of_type_Akht.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos() != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos();
            this.b.a(new ajuu[] { localObject });
            this.jdField_a_of_type_Akbx.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getCommonTagInfos());
            ((TextView)this.mRootView.findViewById(2131370180)).setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131701409, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.commonLabels.size()) }));
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "coninterest_exp", 0, 0, "", "", "", "");
          }
          this.jdField_a_of_type_ArrayOfAjuu = new ajuu[akbx.lX.length];
          i = 0;
          while (i < akbx.lX.length)
          {
            this.jdField_a_of_type_ArrayOfAjuu[i] = new ajuu(akbx.lX[i]);
            i += 1;
          }
          new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "1" }).report();
          break;
          if (i == 1)
          {
            i = 3;
            this.VZ.setText(acfp.m(2131708911));
            new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "3" }).report();
            break;
          }
          if (i != 2) {
            break label1699;
          }
          i = 2;
          this.VZ.setText(acfp.m(2131708836));
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
          {
            this.Fm.setVisibility(8);
            break;
          }
          new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "2" }).report();
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
            break label573;
          }
          this.li.setVisibility(0);
          this.VG.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131696387));
          this.VG.setTextColor(j);
          break label573;
          label1307:
          b(this.jdField_a_of_type_Ajpb);
          break label631;
          label1318:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
            this.VE.setText(acfp.m(2131708908));
          }
          for (;;)
          {
            this.lg.setOnClickListener(new akhg(this));
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
              this.VE.setText(acfp.m(2131708843));
            } else {
              this.VE.setText("送TA礼物");
            }
          }
          label1399:
          this.lm.setVisibility(0);
          this.lm.setOnClickListener(new akhh(this));
          localObject = snf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1);
          if (localObject == null)
          {
            localObject = null;
            label1437:
            if (localObject == null) {
              break label1507;
            }
            this.VE.setText(((sna.c)localObject).title);
          }
          for (;;)
          {
            this.lg.setOnClickListener(new akhj(this, (sna.c)localObject));
            anot.a(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
            break;
            localObject = ((snf)localObject).a;
            break label1437;
            label1507:
            ((apsz)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(113)).a(1402, new akhi(this));
          }
          label1539:
          this.cse = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfAjuu);
        this.jdField_a_of_type_Akbx.a(this.jdField_a_of_type_ArrayOfAjuu);
        if (this.mRootView.findViewById(2131370180).getVisibility() != 0) {
          this.mRootView.findViewById(2131370469).setVisibility(8);
        }
        if ((this.ls.getVisibility() != 0) && (this.li.getVisibility() != 0)) {
          this.mRootView.findViewById(2131370480).setVisibility(8);
        }
        if ((this.lr.getVisibility() == 0) || (this.lg.getVisibility() == 0) || (this.lm.getVisibility() == 0)) {
          break;
        }
        this.mRootView.findViewById(2131370480).setVisibility(8);
        return;
        label1699:
        i = -1;
      }
      localObject = "";
      i = 0;
    }
  }
  
  private int getSessionType()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return 1001;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
      return 0;
    }
    return aqep.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e);
  }
  
  private void lC(List<StrangerInfo> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateVistorHeader visitor count:");
      if (paramList != null) {
        break label106;
      }
    }
    label106:
    for (int i = 0;; i = paramList.size())
    {
      QLog.d("Q.nearby.visitor", 2, i);
      localObject1 = akkx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
      this.P.e((BusinessInfoCheckUpdate.AppInfo)localObject1);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jD.setVisibility(8);
      return;
    }
    if (paramList.size() > 3) {}
    int j;
    for (i = 3;; i = paramList.size())
    {
      localObject1 = new ArrayList(3);
      j = 0;
      while (j < i)
      {
        localObject2 = (StrangerInfo)paramList.get(j);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        j += 1;
      }
    }
    int k = ((List)localObject1).size();
    paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jD.getLayoutParams();
    if (((RelativeLayout.LayoutParams)localObject2).width != this.dmG * k + (k - 1) * this.dmH) {
      ((RelativeLayout.LayoutParams)localObject2).width = (this.dmG * k + (k - 1) * this.dmH);
    }
    for (i = 1;; i = 0)
    {
      if ((!this.P.aux()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != wja.dp2px(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(35.0F, paramList);
        j = 1;
      }
      for (;;)
      {
        if (j != 0) {
          this.jD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 0;
        while (i < k)
        {
          localObject2 = new LinearLayout.LayoutParams(wja.dp2px(30.0F, paramList), wja.dp2px(30.0F, paramList));
          ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(5.0F, paramList);
          StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i);
          if (localStrangerInfo != null)
          {
            CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            Drawable localDrawable = localCustomImgView.getDrawable();
            if ((localDrawable != null) && ((localDrawable instanceof aqcr))) {
              ((aqcr)localDrawable).cancel();
            }
            localCustomImgView.setImageDrawable(aqdj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 202, String.valueOf(localStrangerInfo.tinyId), true));
            this.jD.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
          }
          i += 1;
        }
        j = i;
        if (this.P.aux())
        {
          j = i;
          if (((RelativeLayout.LayoutParams)localObject2).rightMargin != wja.dp2px(45.0F, paramList))
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(45.0F, paramList);
            j = 1;
          }
        }
      }
      if (this.jD.getVisibility() == 0) {
        break;
      }
      this.jD.setVisibility(0);
      return;
    }
  }
  
  public int GN()
  {
    int j = 1;
    int i;
    if (this.csl)
    {
      i = 1;
      if (!this.crP) {
        break label32;
      }
    }
    for (;;)
    {
      return i << 7 | j << 1;
      i = 0;
      break;
      label32:
      j = 0;
    }
  }
  
  public void MO(boolean paramBoolean)
  {
    if ((this.cse) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
    {
      if (!TextUtils.isEmpty(this.bTf)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.bTf, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
      }
      return;
    }
    this.crP = true;
    NearbyPeopleProfileActivity.dmy += 1;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin;
    Object localObject2 = aqft.bytesToHexString(aj());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i;
    if (Friends.isValidUin(str1))
    {
      localObject2 = ajri.encode(str1);
      String str2 = ((String)localObject1).toLowerCase();
      if (getSessionType() == 10002)
      {
        i = 6;
        if (!paramBoolean) {
          break label317;
        }
        localObject1 = "near.card.like";
        label138:
        localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str2, Integer.valueOf(i), localObject1, "" });
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        i = aqek.jW(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa);
        if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
          break label342;
        }
        i = 6;
      }
    }
    label317:
    label342:
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", str1, "data_card", "clk_gift", 0, 0, "", "", "", "");
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i, 0, "", "", "", "");
      return;
      i = 1;
      break;
      localObject1 = "near.card.s";
      break label138;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695115));
      return;
    }
  }
  
  public void b(ajpb paramajpb)
  {
    if (paramajpb == null) {
      return;
    }
    label127:
    int i;
    label210:
    label218:
    label228:
    String str1;
    if (!this.csb)
    {
      boolean bool = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).equals("1000");
      if ((!paramajpb.isShowCard) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility == 0)) {
        break label592;
      }
      this.lr.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording)) {
          break label570;
        }
        this.lr.setVisibility(0);
        this.VX.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording);
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor != 0) {
            break label466;
          }
          this.VX.setTextColor(Color.parseColor("#000000"));
        }
        this.VX.setVisibility(0);
        this.bx.setBackgroundResource(2130842148);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)) {
          break label558;
        }
        this.VY.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording);
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor != 0) {
            break label512;
          }
          this.VY.setTextColor(Color.parseColor("#000000"));
        }
        this.VY.setVisibility(0);
        this.jK.setVisibility(0);
        i = 1;
        if (i != 0)
        {
          i = ((Integer)ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
          String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mUin;
          if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
            break label584;
          }
          str1 = "1";
          label284:
          ajpc.b("exp_data", str2, new String[] { str1, i + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
        }
      }
      label363:
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
        break label604;
      }
      this.bTp = paramajpb.bRV;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.bTp)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility != 1)) {
        break label626;
      }
      this.lr.setOnClickListener(null);
      this.jK.setVisibility(8);
      if (this.VX.getVisibility() != 0) {
        break;
      }
      paramajpb = (RelativeLayout.LayoutParams)this.VX.getLayoutParams();
      paramajpb.rightMargin = 15;
      this.VX.setLayoutParams(paramajpb);
      return;
      this.lr.setVisibility(8);
      return;
      label466:
      str1 = "#" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor);
      this.VX.setTextColor(Color.parseColor(str1));
      break label127;
      label512:
      str1 = "#" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor);
      this.VY.setTextColor(Color.parseColor(str1));
      break label210;
      label558:
      this.VY.setVisibility(8);
      break label218;
      label570:
      this.lr.setVisibility(8);
      i = 0;
      break label228;
      label584:
      str1 = "2";
      break label284;
      label592:
      this.lr.setVisibility(8);
      break label363;
      label604:
      if (3 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
        this.bTp = paramajpb.bRW;
      }
    }
    label626:
    this.lr.setOnClickListener(this);
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.csn) {
      dBq();
    }
  }
  
  public void bl(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte == null) {
      return;
    }
    nearby.Cmd0x1RspBody localCmd0x1RspBody = new nearby.Cmd0x1RspBody();
    for (;;)
    {
      try
      {
        localCmd0x1RspBody.mergeFrom(paramArrayOfByte);
        this.eT = localCmd0x1RspBody.bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().t(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.eT);
        if (localCmd0x1RspBody.uint32_if_mask_gift.get() != 1) {
          break label135;
        }
        this.cse = bool;
        if (!localCmd0x1RspBody.bytes_mask_gift_reason.has()) {
          break;
        }
        this.bTf = localCmd0x1RspBody.bytes_mask_gift_reason.get().toStringUtf8();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("NearbyProfileFragment", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
      return;
      label135:
      bool = false;
    }
  }
  
  public void c(akcx paramakcx)
  {
    this.jdField_a_of_type_Akcx = paramakcx;
  }
  
  public void dBa()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentUin())));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_stranger_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_god_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1643);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.getVersion());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    jnm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new akhl(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public View e()
  {
    return this.og;
  }
  
  protected int getLayoutId()
  {
    return 2131561480;
  }
  
  public void kq(long paramLong)
  {
    ((ajpj)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(106)).go.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    Object localObject;
    label103:
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.split(" ")[0];
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
        break label352;
      }
      localObject = "1";
      str = this.bTp + "&tinyid=" + paramLong + "&distance=" + str + "&_from=" + (String)localObject;
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileFragment", 2, "openFaceScorePage, url = " + str);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
      i = ((Integer)ajrb.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mUin;
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
        break label360;
      }
    }
    label352:
    label360:
    for (String str = "1";; str = "2")
    {
      ajpc.b("clk_data", (String)localObject, new String[] { str, i + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance;
      break;
      localObject = "0";
      break label103;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity() instanceof NearbyPeopleProfileActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = ((NearbyPeopleProfileActivity)getActivity());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.lr)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.adP > 0L) {
        break label72;
      }
      ajpp localajpp = (ajpp)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(204);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mUin);
      localajpp.a(l, new akhm(this, l));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label72:
      kq(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.adP);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {
      bool = true;
    }
    this.csb = bool;
    this.dmG = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131297795);
    this.dmH = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131297794);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    this.og = this.mRootView.findViewById(2131363709);
    this.ls = ((RelativeLayout)this.mRootView.findViewById(2131370311));
    this.VI = ((TextView)this.mRootView.findViewById(2131381035));
    this.li = ((RelativeLayout)this.mRootView.findViewById(2131370224));
    this.VG = ((TextView)this.mRootView.findViewById(2131379494));
    this.VE = ((TextView)this.mRootView.findViewById(2131379513));
    this.lg = ((RelativeLayout)this.mRootView.findViewById(2131370236));
    this.lr = ((RelativeLayout)this.mRootView.findViewById(2131370194));
    this.VX = ((TextView)this.mRootView.findViewById(2131379469));
    this.bx = ((URLImageView)this.mRootView.findViewById(2131369012));
    this.jK = ((LinearLayout)this.mRootView.findViewById(2131363877));
    this.VY = ((TextView)this.mRootView.findViewById(2131363878));
    if (this.csb)
    {
      this.lr.setVisibility(8);
      paramLayoutInflater = this.mRootView.findViewById(2131381446);
      paramViewGroup = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      paramViewGroup.height = aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    this.VZ = ((TextView)this.mRootView.findViewById(2131366662));
    this.Fm = this.mRootView.findViewById(2131366660);
    this.Wa = ((TextView)this.mRootView.findViewById(2131366661));
    paramLayoutInflater = (LinearLayout)this.mRootView.findViewById(2131370220);
    paramViewGroup = this.mRootView.findViewById(2131370221);
    this.jdField_a_of_type_Akbx = new akbx();
    this.jdField_a_of_type_Akbx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = (LinearLayout)this.mRootView.findViewById(2131370179);
    paramViewGroup = this.mRootView.findViewById(2131370180);
    this.b = new akbx();
    this.b.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramLayoutInflater, paramViewGroup);
    this.VL = ((TextView)this.mRootView.findViewById(2131379572));
    this.lm = ((RelativeLayout)this.mRootView.findViewById(2131370309));
    this.jD = ((LinearLayout)this.mRootView.findViewById(2131382049));
    this.P = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.lm).a(21).c(30).a();
    this.jD = ((LinearLayout)this.mRootView.findViewById(2131382049));
    this.jdField_a_of_type_Akht = new akht();
    paramLayoutInflater = this.jdField_a_of_type_Akht;
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    paramBundle = this.mRootView;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramLayoutInflater.a(paramViewGroup, paramBundle, bool);
      this.csn = true;
      dBq();
      paramLayoutInflater = this.mRootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof a))
    {
      localObject2 = ((a)paramView.getTag()).a;
      if (((NearbyPeopleCard.HiWanItem)localObject2).type != 101) {
        break label285;
      }
      localObject1 = (apre)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(224);
      if (localObject1 == null) {
        break label189;
      }
      localObject1 = ((apre)localObject1).By();
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.bF()) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().sB())) {
        break label164;
      }
    }
    label164:
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230);
      ((aqju)localObject1).setMessage(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698108));
      ((aqju)localObject1).setNegativeButton(acfp.m(2131708839), new akhk(this));
      ((aqju)localObject1).show();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, (String)localObject1, null, 0);
    label189:
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    label214:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      localObject1 = "1";
      str = "" + ((NearbyPeopleCard.HiWanItem)localObject2).type;
      if (((NearbyPeopleCard.HiWanItem)localObject2).status != 1) {
        break label533;
      }
    }
    label533:
    for (Object localObject2 = "1";; localObject2 = "2")
    {
      anot.a((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "recent_play", "module_click", 0, 0, (String)localObject1, str, (String)localObject2, "");
      break;
      label285:
      if ((((NearbyPeopleCard.HiWanItem)localObject2).type == 102) && (!TextUtils.isEmpty(((NearbyPeopleCard.HiWanItem)localObject2).url)))
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", ((NearbyPeopleCard.HiWanItem)localObject2).url);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        break label189;
      }
      if (((NearbyPeopleCard.HiWanItem)localObject2).status == 1)
      {
        localObject1 = aqik.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ((NearbyPeopleCard.HiWanItem)localObject2).url);
        if (localObject1 == null) {
          break label189;
        }
        ((aqhv)localObject1).ace();
        break label189;
      }
      localObject1 = new StringBuilder("https://now.qq.com/qq/interact/index.html?");
      localObject3 = SosoInterface.c();
      if (localObject3 == null) {
        break label189;
      }
      localObject3 = ((SosoInterface.SosoLbsInfo)localObject3).a;
      if (localObject3 != null) {
        ((StringBuilder)localObject1).append("longitude=").append(((SosoInterface.SosoLocation)localObject3).ce).append("&latitude=").append(((SosoInterface.SosoLocation)localObject3).cd).append("&_wv=536870914").append("&tab=").append(((NearbyPeopleCard.HiWanItem)localObject2).type).append("&_proxy=1");
      }
      localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject3).putExtra("url", ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject3);
      break label189;
      localObject1 = "2";
      break label214;
    }
  }
  
  class a
  {
    public NearbyPeopleCard.HiWanItem a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment
 * JD-Core Version:    0.7.0.1
 */