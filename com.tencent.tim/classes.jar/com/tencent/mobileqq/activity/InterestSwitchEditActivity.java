package com.tencent.mobileqq.activity;

import accn;
import acff;
import afsi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anot;
import aqiw;
import arho;
import arie;
import avsn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.Locale;
import veb;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private FormSwitchItem H;
  private FormSwitchItem I;
  private FormSwitchItem J;
  private FormSwitchItem K;
  private FormSwitchItem L;
  private FormSwitchItem M;
  private FormSwitchItem N;
  private FormSwitchItem O;
  private FormSwitchItem P;
  private FormSwitchItem Q;
  private accn a = new veb(this);
  private boolean aXy;
  private arho jdField_b_of_type_Arho;
  private Card jdField_b_of_type_ComTencentMobileqqDataCard;
  private CardHandler c;
  private View tv;
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!aqiw.isNetSupport(this)) {
      cf(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("InterestSwitchEditActivity", 2, String.format("setDetailUserInfo bundle=%s", new Object[] { paramBundle }));
    }
    ((CardHandler)this.app.getBusinessHandler(2)).cg(paramBundle);
    return true;
  }
  
  public static Intent b(Context paramContext)
  {
    paramContext = new Intent(paramContext, InterestSwitchEditActivity.class);
    paramContext.putExtra("param_notfromprofile", false);
    return paramContext;
  }
  
  private void bPO()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_interest == 0) {
      this.H.setChecked(true);
    }
    label36:
    label54:
    label73:
    label91:
    label109:
    label127:
    do
    {
      break label163;
      if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.I.setChecked(true);
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label != 0) {
          break label208;
        }
        this.J.setChecked(true);
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_present) {
          break label230;
        }
        this.K.setChecked(true);
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_miniapp != 0) {
          break label251;
        }
        this.L.setChecked(true);
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_musicbox != 0) {
          break label273;
        }
        this.M.setChecked(true);
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_sticky_note != 0) {
          break label295;
        }
        this.N.setChecked(true);
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_qqcircle != 0) {
          break label317;
        }
        this.O.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_life_achievement != 0) {
          break label339;
        }
        this.P.setChecked(true);
        return;
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_interest) {
          break;
        }
        this.H.setChecked(false);
        break;
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_music) {
          break label36;
        }
        this.I.setChecked(false);
        break label36;
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label) {
          break label54;
        }
        this.J.setChecked(false);
        break label54;
        if (this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_present != 0) {
          break label73;
        }
        this.K.setChecked(false);
        break label73;
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_miniapp) {
          break label91;
        }
        this.L.setChecked(false);
        break label91;
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_musicbox) {
          break label109;
        }
        this.M.setChecked(false);
        break label109;
        if (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_sticky_note) {
          break label127;
        }
        this.N.setChecked(false);
        break label127;
        if (1 == this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_qqcircle) {
          this.O.setChecked(false);
        }
      }
    } while (1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_life_achievement);
    label163:
    label208:
    label230:
    label251:
    this.P.setChecked(false);
    label273:
    label295:
    label317:
    label339:
    return;
  }
  
  private void bPP()
  {
    Card localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    if (localCard != null)
    {
      afsi localafsi = (afsi)this.app.getManager(264);
      if ((localCard.extendFriendEntryAddFriend == 1) && (localafsi.isResourceReady()))
      {
        this.tv.setVisibility(0);
        this.Q.setChecked(localCard.isShowCard);
      }
    }
  }
  
  private void bPQ()
  {
    this.H.setOnCheckedChangeListener(this);
    this.I.setOnCheckedChangeListener(this);
    this.J.setOnCheckedChangeListener(this);
    this.K.setOnCheckedChangeListener(this);
    this.L.setOnCheckedChangeListener(this);
    this.M.setOnCheckedChangeListener(this);
    this.N.setOnCheckedChangeListener(this);
    this.Q.setOnCheckedChangeListener(this);
    this.O.setOnCheckedChangeListener(this);
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561563);
    this.app.addObserver(this.a);
    setTitle(getString(2131697239));
    this.H = ((FormSwitchItem)findViewById(2131369324));
    this.I = ((FormSwitchItem)findViewById(2131372099));
    this.J = ((FormSwitchItem)findViewById(2131373024));
    this.K = ((FormSwitchItem)findViewById(2131373552));
    this.L = ((FormSwitchItem)findViewById(2131371821));
    this.M = ((FormSwitchItem)findViewById(2131372128));
    this.N = ((FormSwitchItem)findViewById(2131378778));
    this.O = ((FormSwitchItem)findViewById(2131375024));
    this.P = ((FormSwitchItem)findViewById(2131370420));
    this.tv = findViewById(2131366598);
    this.tv.setVisibility(8);
    this.Q = ((FormSwitchItem)findViewById(2131366597));
    this.jdField_b_of_type_Arho = new arho(this.app, null);
    boolean bool = this.jdField_b_of_type_Arho.mI(5);
    paramBundle = this.H;
    int i;
    label251:
    int j;
    label278:
    label306:
    label334:
    label359:
    label370:
    int k;
    label395:
    label406:
    label434:
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i5;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_b_of_type_Arho.mI(4);
      paramBundle = this.I;
      if (!bool) {
        break label881;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_b_of_type_Arho.mI(3);
      paramBundle = this.J;
      if (!bool) {
        break label887;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_b_of_type_Arho.mI(6);
      paramBundle = this.K;
      if (!bool) {
        break label893;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_b_of_type_Arho.mI(7);
      paramBundle = this.L;
      if (!bool) {
        break label899;
      }
      i = 0;
      paramBundle.setVisibility(i);
      if ((!this.jdField_b_of_type_Arho.mI(8)) || (!avsn.aLx())) {
        break label905;
      }
      i = 1;
      paramBundle = this.N;
      if (i == 0) {
        break label910;
      }
      i = 0;
      paramBundle.setVisibility(i);
      if ((!this.jdField_b_of_type_Arho.mI(9)) || (!QzoneConfig.isQQCircleShowProfileCardEntrance())) {
        break label916;
      }
      i = 1;
      paramBundle = this.O;
      if (i == 0) {
        break label921;
      }
      i = 0;
      paramBundle.setVisibility(i);
      bool = this.jdField_b_of_type_Arho.mI(10);
      paramBundle = this.P;
      if (!bool) {
        break label927;
      }
      i = 0;
      paramBundle.setVisibility(i);
      i = getIntent().getIntExtra("param_interest_switch", -1);
      j = getIntent().getIntExtra("param_music_switch", -1);
      k = getIntent().getIntExtra("param_personlabel_switch", -1);
      m = getIntent().getIntExtra("param_present_switch", -1);
      n = getIntent().getIntExtra("param_miniapp_switch", -1);
      i1 = getIntent().getIntExtra("param_musicbox_switch", -1);
      i2 = getIntent().getIntExtra("param_sticky_note_switch", -1);
      i3 = getIntent().getIntExtra("param_qqcircle_switch", -1);
      int i4 = getIntent().getIntExtra("param_extendfriend_switch", -1);
      i5 = getIntent().getIntExtra("param_life_achievement_switch", -1);
      if ((-1 == i) && (-1 == j) && (-1 == k) && (-1 == m) && (-1 == n) && (-1 == i1) && (-1 == i2) && (-1 == i3) && (-1 == i4) && (-1 == i5)) {
        break label988;
      }
      if (QLog.isColorLevel()) {
        QLog.d("InterestSwitchEditActivity", 2, String.format(Locale.getDefault(), "doOnCreate switch_interest=%s switch_music=%s switch_personality_label=%s switch_present=%s switch_miniapp=%s switch_musicbox=%s switch_sticky_note=%s switch_qq_circle=%s switch_life_achievement=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5) }));
      }
    }
    label899:
    label905:
    label910:
    label916:
    label921:
    label927:
    label988:
    for (bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_b_of_type_ComTencentMobileqqDataCard = new Card();
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)i);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_music = ((short)j);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label = ((short)k);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_present = ((short)m);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_miniapp = ((short)n);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_musicbox = ((short)i1);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_sticky_note = ((short)i2);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_qqcircle = ((short)i3);
        this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_life_achievement = ((short)i5);
        bPO();
        bPP();
        bPQ();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate hasSwitchState=%s", new Object[] { Boolean.valueOf(bool) }));
        }
        return true;
        i = 8;
        break;
        label881:
        i = 8;
        break label251;
        label887:
        i = 8;
        break label278;
        label893:
        i = 8;
        break label306;
        i = 8;
        break label334;
        i = 0;
        break label359;
        i = 8;
        break label370;
        i = 0;
        break label395;
        i = 8;
        break label406;
        i = 8;
        break label434;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplicationImpl.sApplication, 2131696270, 0).show(getTitleBarHeight());
        }
        else
        {
          this.c = ((CardHandler)this.app.getBusinessHandler(2));
          this.c.cHr();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_Arho != null)
    {
      this.jdField_b_of_type_Arho.destroy();
      this.jdField_b_of_type_Arho = null;
    }
    this.app.removeObserver(this.a);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    label96:
    Card localCard;
    if (this.jdField_b_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.H.isChecked()) {
        break label716;
      }
      i = 0;
      localIntent.putExtra("param_interest_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_interest) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_interest))
      {
        localIntent.putExtra("param_interest_switch_changed", true);
        localBundle.putShort("key_interest_switch", (short)i);
      }
      if (!this.I.isChecked()) {
        break label721;
      }
      i = 0;
      localIntent.putExtra("param_music_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_music) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_music))
      {
        localIntent.putExtra("param_music_switch_changed", true);
        localBundle.putShort("key_music_switch", (short)i);
      }
      if (!this.J.isChecked()) {
        break label726;
      }
      i = 0;
      label157:
      localIntent.putExtra("param_personlabel_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_disable_personality_label))
      {
        localIntent.putExtra("param_personlabel_switch_changed", true);
        localBundle.putShort("key_personality_label_switch", (short)i);
      }
      if (!this.K.isChecked()) {
        break label731;
      }
      i = 1;
      label218:
      localIntent.putExtra("param_present_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_present) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_present))
      {
        localIntent.putExtra("param_present_switch_changed", true);
        localBundle.putShort("key_present_switch", (short)i);
      }
      if (!this.L.isChecked()) {
        break label736;
      }
      i = 0;
      label279:
      localIntent.putExtra("param_miniapp_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_miniapp) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_miniapp))
      {
        localIntent.putExtra("param_miniapp_switch_changed", true);
        localBundle.putShort("key_miniapp_playing_switch", (short)i);
      }
      if (!this.M.isChecked()) {
        break label741;
      }
      i = 0;
      label340:
      localIntent.putExtra("param_musicbox_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_musicbox) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_musicbox))
      {
        localIntent.putExtra("param_musicbox_switch_changed", true);
        localBundle.putShort("key_musicbox_switch", (short)i);
        if (!this.M.isChecked()) {
          QQPlayerService.eG(BaseApplicationImpl.getContext());
        }
      }
      if (!this.N.isChecked()) {
        break label746;
      }
      i = 0;
      label417:
      localIntent.putExtra("param_sticky_note_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_sticky_note) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_sticky_note))
      {
        localIntent.putExtra("param_sticky_note_switch_changed", true);
        localBundle.putShort("key_sticky_note_switch", (short)i);
      }
      if (!this.O.isChecked()) {
        break label751;
      }
      i = 0;
      label478:
      localIntent.putExtra("param_qqcircle_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_qqcircle) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_qqcircle))
      {
        localIntent.putExtra("param_qqcircle_switch_changed", true);
        localBundle.putShort("key_qqcircle_switch", (short)i);
      }
      if (!this.P.isChecked()) {
        break label756;
      }
      i = 0;
      label539:
      localIntent.putExtra("param_life_achievement_switch", i);
      if ((i != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_life_achievement) && (-1 != this.jdField_b_of_type_ComTencentMobileqqDataCard.switch_life_achievement))
      {
        localIntent.putExtra("param_life_achievement_changed", true);
        localBundle.putShort("key_life_achievement_switch", (short)i);
      }
      localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
      if (localCard != null) {
        if (!this.Q.isChecked()) {
          break label761;
        }
      }
    }
    label716:
    label721:
    label726:
    label731:
    label736:
    label741:
    label746:
    label751:
    label756:
    label761:
    for (int i = 0;; i = 1)
    {
      localIntent.putExtra("param_extendfriend_switch", i);
      if (this.Q.isChecked() != localCard.isShowCard)
      {
        localIntent.putExtra("param_extendfriend_switch_changed", true);
        localBundle.putShort("key_extend_friend_switch", (short)i);
        localCard.isShowCard = this.Q.isChecked();
      }
      if (!this.aXy)
      {
        a(localBundle, 2131696272, 0);
        this.aXy = true;
      }
      setResult(-1, localIntent);
      super.finish();
      return;
      i = 1;
      break;
      i = 1;
      break label96;
      i = 1;
      break label157;
      i = 0;
      break label218;
      i = 1;
      break label279;
      i = 1;
      break label340;
      i = 1;
      break label417;
      i = 1;
      break label478;
      i = 1;
      break label539;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.Q.a()) {
      if (paramBoolean) {
        anot.a(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      anot.a(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      continue;
      QQAppInterface localQQAppInterface;
      int i;
      if (paramCompoundButton == this.J.a())
      {
        localQQAppInterface = this.app;
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          anot.a(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
          break;
        }
      }
      if (paramCompoundButton == this.M.a())
      {
        localQQAppInterface = this.app;
        if (paramBoolean) {}
        for (i = 1;; i = 2)
        {
          anot.a(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
          break;
        }
      }
      if (paramCompoundButton == this.N.a()) {
        anot.a(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */