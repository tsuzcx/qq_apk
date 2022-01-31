package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;
import java.util.Hashtable;
import java.util.List;

public class AfterSyncMsg
  extends AsyncStep
{
  private void c()
  {
    if (this.a.f) {
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a();
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b();
    e();
    ((CircleManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();
  }
  
  private void d()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    ((SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).d();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.j = true;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
    if (this.a.f) {
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a();
    }
    e();
    ((PhoneContactManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    Object localObject = (RecommendTroopManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
    if (localObject != null) {
      ((RecommendTroopManagerImp)localObject).a();
    }
    localObject = new QvipSpecialSoundManager(BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((QvipSpecialSoundManager)localObject).a();
    ((QvipSpecialSoundManager)localObject).b();
    ((CircleManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h();
  }
  
  private void e()
  {
    Object localObject = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    f();
    ((DiscussionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).e();
    ((FriendListHandler)localObject).d();
    ((FriendListHandler)localObject).a();
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!this.a.g) {}
    for (boolean bool = true;; bool = false)
    {
      ((MessageHandler)localObject).d(bool);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
      return;
    }
  }
  
  private void f()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0)) {
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label315;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label180;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label180:
          label204:
          int j;
          label206:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(j, (String)localObject1);
            str2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(j, (String)localObject1);
            if (((Setting)localObject2).bHeadType != 0) {
              break label326;
            }
          }
          label315:
          label326:
          for (localObject1 = "s_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label335;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label204;
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label206;
          }
          label335:
          if (((File)localObject2).exists())
          {
            com.tencent.mobileqq.transfile.filebrowser.FileUtils.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.a();
    Object localObject1 = new File(AppConstants.an + "head/" + "_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    localObject1 = new File(SystemUtil.a + "head/" + "_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  protected int a()
  {
    switch (this.h)
    {
    default: 
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
      this.a.a(6008, false, null, true);
    }
    for (;;)
    {
      return 7;
      d();
      continue;
      c();
      continue;
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */