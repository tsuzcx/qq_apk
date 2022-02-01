package com.tencent.mobileqq.troop.createNewTroop;

import aeqz;
import aeru;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import anot;
import aoyk;
import aozp;
import aozp.a;
import aptl;
import aptl.a;
import apyh;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import smw;

public class NewTroopCateView
  extends AbsNewTroopBaseView
{
  protected aoyk a;
  protected int mFrom = 0;
  public ListView w;
  
  public NewTroopCateView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void cAb()
  {
    this.mFrom = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getIntent().getIntExtra("create_source", 0);
  }
  
  private void ie()
  {
    Object localObject2 = aozp.a().dR();
    Object localObject1 = (TroopManager)this.app.getManager(52);
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (aozp.a)((Iterator)localObject2).next();
      if ((!aoyk.cnw.equals(((aozp.a)localObject3).name)) && (!aoyk.cnx.equals(((aozp.a)localObject3).name))) {
        localArrayList.add(localObject3);
      }
    }
    if (!((TroopManager)localObject1).a.aMd)
    {
      localObject2 = localArrayList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (aozp.a)((Iterator)localObject2).next();
        if (!aoyk.cnw.equals(((aozp.a)localObject1).name)) {
          break label164;
        }
        localArrayList.remove(localObject1);
      }
    }
    for (;;)
    {
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_Aoyk.setData(localArrayList);
      }
      return;
      label164:
      if (!aoyk.cnx.equals(((aozp.a)localObject1).name)) {
        break;
      }
      localObject2 = new ArrayList();
      localObject3 = ((aozp.a)localObject1).list.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        aozp.a locala = (aozp.a)((Iterator)localObject3).next();
        if ((!TextUtils.equals(locala.id, "20001")) && (!TextUtils.equals(locala.id, "20002"))) {
          ((ArrayList)localObject2).add(locala);
        }
      }
      ((aozp.a)localObject1).list = ((ArrayList)localObject2);
      continue;
      if (aeqz.c().bWb) {
        anot.a(this.app, "dc00898", "", "", "qq_vip", "0X800A581", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void initViews()
  {
    setContentView(2131560779);
    this.w = ((ListView)findViewById(2131381179));
    this.jdField_a_of_type_Aoyk = new aoyk(this, this.app);
    this.w.setAdapter(this.jdField_a_of_type_Aoyk);
    this.w.setDivider(null);
    this.w.setDividerHeight(0);
    this.w.setOverScrollMode(2);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      findViewById(2131372394).setVisibility(0);
    }
  }
  
  public void SC(String paramString)
  {
    String str = "";
    if (paramString.equals("20001")) {
      str = aeqz.c().tI();
    }
    for (;;)
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString.putExtra("url", str);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString);
      return;
      if (paramString.equals("20002")) {
        str = aeqz.c().tJ();
      }
    }
  }
  
  public void a(NewTroopCreateActivity paramNewTroopCreateActivity)
  {
    super.a(paramNewTroopCreateActivity);
    cAb();
    initViews();
    ie();
    anot.a(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_category", 0, 0, "", "" + this.mFrom, "", "");
  }
  
  public void hS(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    if (paramString1 == null) {
      str1 = "";
    }
    String str2 = paramString2;
    if (paramString2 == null) {
      str2 = "";
    }
    aptl localaptl = aptl.a();
    paramString2 = localaptl.getUrl("troop_create");
    if ("32".equals(str1)) {
      paramString1 = localaptl.getUrl("troop_create_for_school");
    }
    for (;;)
    {
      paramString2 = new aptl.a();
      paramString2.crg = str1;
      paramString2.subId = str2;
      paramString2.from = (this.mFrom + "");
      paramString1 = localaptl.a(paramString1, paramString2);
      paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.startActivity(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("createNewTroop.NewTroopCateView", 2, "openCreateTroopPage " + paramString1);
      }
      return;
      paramString1 = paramString2;
      if ("25".equals(str1))
      {
        paramString1 = paramString2;
        if (this.app != null)
        {
          SharedPreferences localSharedPreferences = this.app.getPreferences();
          paramString1 = paramString2;
          if (localSharedPreferences != null)
          {
            paramString1 = paramString2;
            if (localSharedPreferences.getBoolean("key_game_troop_bind_config_switch", false)) {
              paramString1 = localaptl.getUrl("troop_create_for_game");
            }
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    apyh.a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity).clear();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView
 * JD-Core Version:    0.7.0.1
 */