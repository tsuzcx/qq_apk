package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopCreateAdvanceData;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AddButtonStatusListener;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import gxp;
import gxq;
import gxr;
import gxs;
import gxt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;

public class TroopCreateAvatarActivity
  extends IphoneTitleBarActivity
  implements AvatarWallAdapter.AddButtonStatusListener
{
  public static final int a = 14;
  public static final String a = "TroopCreateAvatarActivity";
  public static final int b = 15;
  public static final int c = 10;
  public Intent a;
  public Handler a;
  protected TextView a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gxt(this);
  public AvatarWallAdapter a;
  public AvatarWallView a;
  public ArrayList a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new gxs(this);
  public boolean a;
  protected TextView b;
  public String b;
  public boolean b;
  public String c;
  protected boolean c;
  public String d;
  
  public TroopCreateAvatarActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new gxp(this);
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramIntent = paramIntent.getStringArrayListExtra("del_list");
      if (paramIntent != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramIntent.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((str != null) && (AvatarTroopUtil.b(str))) {
            localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
          }
        }
        if (localArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_b_of_type_JavaLangString, 2, localArrayList);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramIntent);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void d()
  {
    Object localObject = getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("isShowCommit", false);
    this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAstrict", false);
    if (bool == true) {}
    for (int i = 2131560422;; i = 2131560420)
    {
      setContentView(2130903411);
      setTitle(2131560419);
      c(i, new gxq(this));
      localObject = (TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      if (localObject == null) {
        break label157;
      }
      localObject = ((TroopCreateLogic)localObject).a().a;
      if (localObject != null) {
        break;
      }
      finish();
      return;
    }
    this.d = ("" + ((TroopCreateAdvanceData)localObject).jdField_a_of_type_Long);
    this.jdField_b_of_type_JavaLangString = ("" + ((TroopCreateAdvanceData)localObject).b);
    this.jdField_c_of_type_JavaLangString = ((TroopCreateAdvanceData)localObject).jdField_a_of_type_JavaLangString;
    label157:
    if (this.jdField_a_of_type_Boolean) {
      this.m.setEnabled(false);
    }
    for (;;)
    {
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      i = (((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(2131427553)) / 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView = ((AvatarWallView)findViewById(2131230904));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setColumnWidth(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, true, this.jdField_a_of_type_AndroidOsHandler, true, "Grp_Admin_data");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230976));
      localObject = getString(2131560421);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232530));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new gxr(this));
      this.k.setText(getString(2131561692));
      return;
      this.m.setEnabled(true);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopCreateAvatarActivity", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      a(paramInt2, paramIntent);
      return;
    } while (AvatarWallAdapter.jdField_a_of_type_AndroidNetUri == null);
    paramIntent = ImageUtil.c(this, AvatarWallAdapter.jdField_a_of_type_AndroidNetUri);
    paramInt1 = ProfileCardUtil.a(this);
    PhotoUtils.a(new Intent(), this, TroopCreateAvatarActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    d();
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidContentIntent.putExtra("isBack", 0);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_b_of_type_Boolean = true;
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
    {
      localObject1 = paramIntent.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b((String)localObject2);
      }
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject2 = (AccountManager)getAppRuntime().getManager(0);
    Object localObject1 = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject1 == null)
    {
      ((AccountManager)localObject2).updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("groupsig", this.jdField_c_of_type_JavaLangString);
    TroopUtils.a((String)localObject1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.d, paramIntent, (HashMap)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    TroopAvatarManger.a = 0;
    e();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_b_of_type_JavaLangString);
  }
  
  protected void e()
  {
    ArrayList localArrayList = new ArrayList();
    AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
    localAvatarInfo.jdField_b_of_type_JavaLangString = "-5";
    localAvatarInfo.jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";
    localArrayList.add(localAvatarInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, 23, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity
 * JD-Core Version:    0.7.0.1
 */