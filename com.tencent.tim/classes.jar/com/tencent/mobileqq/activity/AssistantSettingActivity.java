package com.tencent.mobileqq.activity;

import accn;
import acff;
import acfp;
import acof;
import aeif;
import aemd;
import afdw;
import ajik;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anlm;
import anwa;
import aqju;
import arhz;
import awit;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jsp;
import plr;
import pmb;
import rar;
import uft;
import ufu;
import ufv;
import ufw;
import ufx;
import ufy;
import ufz;
import uga;
import ugb;
import ugc;
import ugd;
import uge;
import ugf;
import yhf;
import zbm;
import zbp;
import zbq;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  protected aqju A;
  TextView BZ;
  private TextView Ca;
  TextView Cb;
  private acof jdField_a_of_type_Acof;
  public a a;
  FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  public HeightAdaptableListView a;
  private zbp jdField_a_of_type_Zbp = new ufz(this);
  public zbq a;
  private boolean aRp;
  FormMultiLineSwitchItem b;
  BounceScrollView jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private accn cardObserver = new uft(this);
  private String currentUin = "";
  FormMultiLineSwitchItem d;
  public FormMultiLineSwitchItem e;
  private FormMultiLineSwitchItem f;
  private FormMultiLineSwitchItem g;
  private FormMultiLineSwitchItem h;
  public Handler handler = new ufu(this);
  private FormMultiLineSwitchItem i;
  public FormMultiLineSwitchItem j;
  private FormMultiLineSwitchItem jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  FormSwitchItem jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem l;
  private CompoundButton.OnCheckedChangeListener jdField_m_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ufv(this);
  FormSwitchItem jdField_m_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  CompoundButton.OnCheckedChangeListener jdField_n_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ufx(this);
  FormSwitchItem jdField_n_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_o_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ufy(this);
  private FormSimpleItem jdField_o_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_o_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem jdField_p_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_p_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem q;
  public FormSwitchItem r;
  private View rr;
  private View rs;
  public arhz v;
  protected aqju z;
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new ufw(this));
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.h != null)
    {
      this.h.setOnCheckedChangeListener(null);
      this.h.setChecked(paramBoolean);
      this.h.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void bFS()
  {
    if (anwa.aze())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.Cb.setVisibility(8);
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Zbq != null)
      {
        List localList = this.jdField_a_of_type_Zbq.dk();
        if ((localList != null) && (localList.size() > 0))
        {
          this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
          this.Cb.setVisibility(0);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.i("AssistantSettingActivity", 2, "updateCTEntrySetting visible: " + this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
        return;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.Cb.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.Cb.setVisibility(8);
      }
    }
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  private void fw(List<zbm> paramList)
  {
    boolean bool2 = true;
    if (anwa.aze()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        zbm localzbm = (zbm)((Iterator)localObject).next();
        if (localzbm.id == 3)
        {
          if (!localzbm.bqy) {
            break label102;
          }
          this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a;
    if (this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).vM(bool1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a.setData(paramList);
      return;
      label102:
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      if (!this.jdField_a_of_type_Zbq.Vf()) {}
      for (bool1 = true;; bool1 = false)
      {
        vK(bool1);
        break;
      }
    }
  }
  
  private void initUI()
  {
    anlm.ayn();
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372550));
    this.rr = super.findViewById(2131373547);
    this.l = ((FormSwitchItem)super.findViewById(2131373727));
    this.jdField_m_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131373731));
    this.Ca = ((TextView)super.findViewById(2131381106));
    this.b = ((FormMultiLineSwitchItem)super.findViewById(2131362944));
    this.jdField_o_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374983));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131374982));
    this.jdField_n_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131367214));
    this.rs = super.findViewById(2131362945);
    this.f = ((FormMultiLineSwitchItem)super.findViewById(2131378776));
    this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.g = ((FormMultiLineSwitchItem)super.findViewById(2131366051));
    this.h = ((FormMultiLineSwitchItem)super.findViewById(2131366372));
    this.i = ((FormMultiLineSwitchItem)super.findViewById(2131382434));
    this.d = ((FormMultiLineSwitchItem)findViewById(2131370019));
    this.jdField_p_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372081));
    this.q = ((FormSwitchItem)findViewById(2131380326));
    Object localObject = (aemd)aeif.a().o(442);
    if (localObject != null)
    {
      bool = ((aemd)localObject).isOpen();
      if (QLog.isColorLevel()) {
        QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool);
      }
    }
    this.e = ((FormMultiLineSwitchItem)findViewById(2131373739));
    this.BZ = ((TextView)findViewById(2131373740));
    this.app.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin(), false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)findViewById(2131362739));
    this.j = ((FormMultiLineSwitchItem)findViewById(2131362027));
    this.j.setChecked(this.jdField_a_of_type_Acof.aX(true));
    this.j.setOnCheckedChangeListener(new uga(this));
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.a().abu);
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(getText(2131696494));
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(acfp.m(2131702906) + plr.asY + acfp.m(2131702910));
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new ugb(this));
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130839682);
    this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    if ((!pmb.Ir()) || (this.app.a().b == '0') || (this.app.a().b == '1'))
    {
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.r = ((FormSwitchItem)super.findViewById(2131377731));
      bool = SettingCloneUtil.readValue(this, null, super.getString(2131697091), "qqsetting_screenshot_key", false);
      this.r.setChecked(bool);
      this.r.setOnCheckedChangeListener(new ugc(this));
      this.b.setVisibility(8);
      ((acff)this.app.getManager(51)).aah();
      ((TroopManager)this.app.getManager(52)).abP();
      bool = awit.aMG();
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new ugd(this));
      localObject = (ajik)this.app.getManager(325);
      this.rr.setOnClickListener(new uge(this));
      bool = yhf.a(this.app).TC();
      this.h.setChecked(bool);
      this.h.setContentDescription(getResources().getString(2131693121));
      this.h.setOnCheckedChangeListener(this.jdField_m_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      localObject = (afdw)this.app.getManager(214);
      this.jdField_p_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131375078));
      this.jdField_p_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new ugf(this));
      this.Cb = ((TextView)this.mContentView.findViewById(2131365244));
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131365234));
      if (this.jdField_a_of_type_Zbq.Vf()) {
        break label1078;
      }
    }
    label1078:
    for (boolean bool = true;; bool = false)
    {
      vK(bool);
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365255));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a = new a(this, this.jdField_n_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_Zbq != null) {
        fw(this.jdField_a_of_type_Zbq.dk());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a);
      bFS();
      this.jdField_o_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364911));
      if (AppSetting.enableTalkBack)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(acfp.m(2131702903));
        this.r.setContentDescription(acfp.m(2131702913));
        this.jdField_o_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(acfp.m(2131691747));
        this.rs.setContentDescription(getString(2131690466));
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131377550));
      this.jdField_c_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingActivity.18(this));
      return;
      rar.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break;
    }
  }
  
  private void vK(boolean paramBoolean)
  {
    if (this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
    {
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_k_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_o_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void vL(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str1 = "businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin();
    String str2 = "businessinfo_ptt_auto_change_time_" + this.app.getCurrentAccountUin();
    String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + this.app.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putBoolean(str1, paramBoolean);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      localEditor.putLong(str2, l1);
      localSharedPreferences.edit().putBoolean(str3, true);
      xla.bhA = true;
    }
    for (;;)
    {
      localEditor.commit();
      xla.bhz = paramBoolean;
      xla.Jb = l1;
      return;
      localEditor.putLong(str2, 9223372036854775807L);
    }
  }
  
  protected void bFT()
  {
    if (this.A != null) {
      this.A.dismiss();
    }
  }
  
  protected void bFU()
  {
    if (this.z != null) {
      this.z.dismiss();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558753);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131697046);
    this.currentUin = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    this.jdField_a_of_type_Acof = ((acof)this.app.getManager(85));
    addObserver(this.cardObserver);
    this.jdField_a_of_type_Zbq = ((zbq)this.app.getManager(295));
    if (this.jdField_a_of_type_Zbq != null)
    {
      this.jdField_a_of_type_Zbq.a(this.jdField_a_of_type_Zbp);
      this.jdField_a_of_type_Zbq.Bu(false);
      this.jdField_a_of_type_Zbq.cnS();
    }
    initUI();
    paramBundle = (CardHandler)this.app.getBusinessHandler(2);
    if (paramBundle != null) {
      paramBundle.cHM();
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.v != null) && (this.v.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.cardObserver != null) {
      removeObserver(this.cardObserver);
    }
    if (this.jdField_a_of_type_Zbq != null) {
      this.jdField_a_of_type_Zbq.b(this.jdField_a_of_type_Zbp);
    }
    bFU();
    bFT();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.v = null;
    this.v = new arhz(this, super.getTitleBarHeight());
    this.v.setMessage(getString(2131691516));
    this.v.setBackAndSearchFilter(true);
    this.v.showTipImageView(false);
    this.v.showProgerss(true);
    return this.v;
  }
  
  public String setLastActivityName()
  {
    return super.getString(2131697046);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
  
  public static class a
    extends BaseAdapter
  {
    private boolean aRr;
    private Context mContext;
    private final List<zbm> mData;
    private CompoundButton.OnCheckedChangeListener p;
    
    public a(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
    {
      this.mContext = paramContext;
      this.mData = new ArrayList();
      this.p = paramOnCheckedChangeListener;
    }
    
    private void fx(List<zbm> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {}
      for (;;)
      {
        return;
        int i = paramList.size() - 1;
        while (i >= 0)
        {
          zbm localzbm = (zbm)paramList.get(i);
          if (((localzbm == null) || (localzbm.id == 1) || (localzbm.id == 2)) && (localzbm != null)) {
            paramList.remove(localzbm);
          }
          i -= 1;
        }
      }
    }
    
    public zbm a(short paramShort)
    {
      int i = 0;
      while (i < this.mData.size())
      {
        if (((zbm)this.mData.get(i)).K == paramShort) {
          return (zbm)this.mData.get(i);
        }
        i += 1;
      }
      return null;
    }
    
    public boolean a(short[] paramArrayOfShort)
    {
      int i = 0;
      boolean bool = false;
      if ((!bool) && (paramArrayOfShort != null)) {}
      label90:
      for (;;)
      {
        try
        {
          if (i < paramArrayOfShort.length)
          {
            int j = 0;
            if (j >= this.mData.size()) {
              break label90;
            }
            int k = paramArrayOfShort[i];
            int m = ((zbm)this.mData.get(j)).K;
            if (k == m)
            {
              bool = true;
              i += 1;
              break;
            }
            j += 1;
            continue;
          }
          return bool;
        }
        catch (Throwable paramArrayOfShort)
        {
          paramArrayOfShort.printStackTrace();
        }
      }
    }
    
    public int getCount()
    {
      return this.mData.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < getCount())) {
        return (zbm)this.mData.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      zbm localzbm = (zbm)getItem(paramInt);
      if (localzbm == null) {
        return 0L;
      }
      return localzbm.id;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      Object localObject2;
      boolean bool;
      label58:
      label99:
      int i;
      if (!(paramView instanceof FormSwitchItem))
      {
        localObject1 = new FormMultiLineSwitchItem(this.mContext);
        paramView = (View)localObject1;
        localObject2 = (zbm)getItem(paramInt);
        if (localObject2 != null)
        {
          paramView.setText(((zbm)localObject2).title);
          if (((zbm)localObject2).bqy) {
            break label174;
          }
          bool = true;
          paramView.setChecked(bool);
          if ((((zbm)localObject2).id != 3) || (!((zbm)localObject2).bqy)) {
            break label180;
          }
          paramView.setSecendLineText(this.mContext.getString(2131701328));
          paramView.setSecondLineTextViewVisibility(0);
        }
        i = getCount();
        if ((paramInt != 0) || (i != 1)) {
          break label203;
        }
        if (!this.aRr) {
          break label195;
        }
        paramView.setBgType(2);
      }
      for (;;)
      {
        paramView.setTag(localObject2);
        paramView.setOnCheckedChangeListener(this.p);
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (FormMultiLineSwitchItem)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
        label174:
        bool = false;
        break label58;
        label180:
        paramView.setSecendLineText("");
        paramView.setSecondLineTextViewVisibility(8);
        break label99;
        label195:
        paramView.setBgType(0);
        continue;
        label203:
        if (paramInt == 0) {
          paramView.setBgType(1);
        } else if (paramInt == i - 1)
        {
          if (this.aRr) {
            paramView.setBgType(2);
          } else {
            paramView.setBgType(3);
          }
        }
        else if ((paramInt > 0) && (paramInt < i - 1)) {
          paramView.setBgType(2);
        }
      }
    }
    
    public void setData(List<zbm> paramList)
    {
      this.mData.clear();
      if (paramList != null)
      {
        fx(paramList);
        this.mData.addAll(paramList);
      }
      notifyDataSetChanged();
    }
    
    public void vM(boolean paramBoolean)
    {
      this.aRr = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */