package com.tencent.mobileqq.activity.voip;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.utils.ContactUtils;
import ewu;
import ewv;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class VoipHistoryInterface
  extends Observable
{
  private static VoipHistoryInterface jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface = null;
  public QQAppInterface a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public String a;
  
  private VoipHistoryInterface(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = new VoipHistoryData().getTableName();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a();
    }
  }
  
  public static VoipHistoryInterface a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface == null) {
      jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface = new VoipHistoryInterface(paramQQAppInterface);
    }
    return jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryInterface;
  }
  
  private EntityManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager();
  }
  
  @Deprecated
  public VoipHistoryData a(long paramLong)
  {
    return (VoipHistoryData)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, paramLong);
  }
  
  public ArrayList a(Context paramContext)
  {
    ewu localewu = new ewu(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Object localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    localArrayList.clear();
    localObject2 = ((SQLiteDatabase)localObject2).a("SELECT * FROM " + this.jdField_a_of_type_JavaLangString + " ORDER BY startTime DESC LIMIT 99", null);
    Object localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    Object localObject5 = new ArrayList();
    if (localObject2 != null)
    {
      ((Cursor)localObject2).moveToFirst();
      while (!((Cursor)localObject2).isAfterLast())
      {
        VoipHistoryData localVoipHistoryData = (VoipHistoryData)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, (Cursor)localObject2);
        if (localVoipHistoryData.contactLookupId == null) {
          if (localVoipHistoryData.uin != "")
          {
            if (((ArrayList)localObject3).contains(localVoipHistoryData.uin))
            {
              ((Cursor)localObject2).moveToNext();
              continue;
            }
            ((ArrayList)localObject3).add(localVoipHistoryData.uin);
          }
        }
        for (;;)
        {
          Object localObject6 = new VoipHistoryAllType();
          ((VoipHistoryAllType)localObject6).time = localVoipHistoryData.startTime;
          ((VoipHistoryAllType)localObject6).obj = localVoipHistoryData;
          ((VoipHistoryAllType)localObject6).type = 0;
          localArrayList.add(localObject6);
          break;
          if (((ArrayList)localObject4).contains(localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry)) {
            break;
          }
          ((ArrayList)localObject4).add(localVoipHistoryData.countryCode + localVoipHistoryData.phoneNumberWithoutCountry);
          continue;
          localObject6 = ((PhoneContactManager)localObject1).a(localVoipHistoryData.contactLookupId);
          if ((localObject6 == null) || (((ArrayList)localObject5).contains(((PhoneContact)localObject6).lookupID))) {
            break;
          }
          ((ArrayList)localObject5).add(((PhoneContact)localObject6).lookupID);
        }
      }
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a().iterator();
    label383:
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (QCallRecent)((Iterator)localObject2).next();
      localObject4 = new VoipHistoryAllType();
      localObject5 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject5 == null) {}
      for (localObject1 = null;; localObject1 = ((FriendManager)localObject5).c(((QCallRecent)localObject3).uin)) {
        switch (((QCallRecent)localObject3).type)
        {
        default: 
          ((QCallRecent)localObject3).displayName = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QCallRecent)localObject3).uin, true);
        case 3000: 
          if (((QCallRecent)localObject3).type == 3000) {
            break label383;
          }
          ((VoipHistoryAllType)localObject4).time = (((QCallRecent)localObject3).lastCallTime * 1000L);
          ((VoipHistoryAllType)localObject4).obj = localObject3;
          ((VoipHistoryAllType)localObject4).type = 1;
          localArrayList.add(localObject4);
          break label383;
        }
      }
      localObject1 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 == null) {
        break label1189;
      }
    }
    label1189:
    for (localObject1 = ((PublicAccountDataManager)localObject1).a(((QCallRecent)localObject3).uin); localObject1 != null; localObject1 = null)
    {
      ((QCallRecent)localObject3).displayName = ((PublicAccountInfo)localObject1).name;
      break;
      localObject5 = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QCallRecent)localObject3).uin);
      localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject1 != null) {}
      for (localObject1 = ((PhoneContactManager)localObject1).f(((QCallRecent)localObject3).uin);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          ((QCallRecent)localObject3).displayName = ((PhoneContact)localObject1).name;
          break;
        }
        if (localObject5 != null)
        {
          ((QCallRecent)localObject3).displayName = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject5, true);
          break;
        }
        ((QCallRecent)localObject3).displayName = ((QCallRecent)localObject3).uin;
        break;
        localObject1 = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
        localObject5 = ((CircleManager)localObject1).a(((QCallRecent)localObject3).uin);
        if ((localObject1 != null) && (localObject5 != null))
        {
          ((QCallRecent)localObject3).displayName = ((CircleManager)localObject1).a((CircleBuddy)localObject5);
          break;
        }
        ((QCallRecent)localObject3).displayName = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QCallRecent)localObject3).uin, true);
        break;
        if (AppConstants.U.equals(((QCallRecent)localObject3).uin))
        {
          ((QCallRecent)localObject3).displayName = paramContext.getString(2131562249);
          break;
        }
        if (AppConstants.W.equals(((QCallRecent)localObject3).uin))
        {
          ((QCallRecent)localObject3).displayName = paramContext.getString(2131562677);
          break;
        }
        if (AppConstants.V.equals(((QCallRecent)localObject3).uin))
        {
          ((QCallRecent)localObject3).displayName = paramContext.getString(2131562371);
          break;
        }
        if (AppConstants.N.equals(((QCallRecent)localObject3).uin))
        {
          ((QCallRecent)localObject3).displayName = paramContext.getString(2131562365);
          break;
        }
        if (AppConstants.S.equals(((QCallRecent)localObject3).uin))
        {
          ((QCallRecent)localObject3).displayName = paramContext.getString(2131563212);
          break;
        }
        if (((QCallRecent)localObject3).type == 1000)
        {
          if (localObject5 == null) {
            break;
          }
          localObject1 = ((FriendManager)localObject5).g(((QCallRecent)localObject3).troopUin);
          ((QCallRecent)localObject3).displayName = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QCallRecent)localObject3).uin, (String)localObject1, ((QCallRecent)localObject3).troopUin, true);
          break;
        }
        if (localObject1 != null) {
          if (!TextUtils.isEmpty(((Friends)localObject1).remark)) {
            localObject1 = ((Friends)localObject1).remark;
          }
        }
        label1088:
        for (((QCallRecent)localObject3).displayName = ((String)localObject1); (TextUtils.isEmpty(((QCallRecent)localObject3).displayName)) || (((QCallRecent)localObject3).displayName.equals(((QCallRecent)localObject3).uin)); ((QCallRecent)localObject3).displayName = "")
        {
          ((QCallRecent)localObject3).displayName = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QCallRecent)localObject3).uin, true);
          break;
          localObject1 = ((Friends)localObject1).name;
          break label1088;
        }
        ((QCallRecent)localObject3).displayName = paramContext.getString(2131560604);
        break;
        Collections.sort(localArrayList, localewu);
        return localArrayList;
      }
    }
  }
  
  public List a(VoipContact paramVoipContact)
  {
    Object localObject3 = new ewv(this);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((ArrayList)localObject2).clear();
    Object localObject4 = ((SQLiteDatabase)localObject1).a("SELECT * FROM " + this.jdField_a_of_type_JavaLangString + " ORDER BY startTime DESC LIMIT 99", null);
    ((Cursor)localObject4).moveToFirst();
    Object localObject5;
    if (!((Cursor)localObject4).isAfterLast())
    {
      localObject5 = (VoipHistoryData)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, (Cursor)localObject4);
      if (((VoipHistoryData)localObject5).countryCode != null)
      {
        localObject1 = new VoipContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, ((VoipHistoryData)localObject5).contactLookupId, ((VoipHistoryData)localObject5).countryCode + ((VoipHistoryData)localObject5).phoneNumberWithoutCountry);
        label157:
        if (!paramVoipContact.isSameContact((VoipContact)localObject1)) {
          break label236;
        }
        localObject1 = new VoipHistoryAllType();
        ((VoipHistoryAllType)localObject1).time = ((VoipHistoryData)localObject5).startTime;
        ((VoipHistoryAllType)localObject1).obj = localObject5;
        ((VoipHistoryAllType)localObject1).type = 0;
        ((ArrayList)localObject2).add(localObject1);
      }
      for (;;)
      {
        ((Cursor)localObject4).moveToNext();
        break;
        localObject1 = new VoipContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, ((VoipHistoryData)localObject5).contactLookupId, ((VoipHistoryData)localObject5).phoneNumberWithoutCountry);
        break label157;
        label236:
        if ((paramVoipContact.phoneNumber != null) && (((VoipContact)localObject1).phoneNumber != null) && (paramVoipContact.phoneNumber.jdField_a_of_type_JavaLangString != null) && (((VoipContact)localObject1).phoneNumber.jdField_a_of_type_JavaLangString != null) && (!paramVoipContact.phoneNumber.jdField_a_of_type_JavaLangString.equals("")) && (paramVoipContact.phoneNumber.jdField_a_of_type_JavaLangString.equals(((VoipContact)localObject1).phoneNumber.jdField_a_of_type_JavaLangString)))
        {
          localObject1 = new VoipHistoryAllType();
          ((VoipHistoryAllType)localObject1).time = ((VoipHistoryData)localObject5).startTime;
          ((VoipHistoryAllType)localObject1).obj = localObject5;
          ((VoipHistoryAllType)localObject1).type = 0;
          ((ArrayList)localObject2).add(localObject1);
        }
      }
    }
    if (paramVoipContact.uin != null)
    {
      localObject1 = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramVoipContact.uin, 0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (QCallRecord)((Iterator)localObject1).next();
        localObject5 = new VoipHistoryAllType();
        ((VoipHistoryAllType)localObject5).time = (((QCallRecord)localObject4).time * 1000L);
        ((VoipHistoryAllType)localObject5).obj = localObject4;
        ((VoipHistoryAllType)localObject5).type = 1;
        ((ArrayList)localObject2).add(localObject5);
      }
    }
    if ((paramVoipContact.relationship == 5) || (paramVoipContact.relationship == 2))
    {
      localObject1 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      localObject4 = ((QCallFacade)localObject1).a(paramVoipContact.uin, 1000);
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1006));
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1001));
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1000));
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1020));
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1003));
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1004));
      ((List)localObject4).addAll(((QCallFacade)localObject1).a(paramVoipContact.uin, 1023));
      paramVoipContact = ((List)localObject4).iterator();
      while (paramVoipContact.hasNext())
      {
        localObject1 = (QCallRecord)paramVoipContact.next();
        localObject4 = new VoipHistoryAllType();
        ((VoipHistoryAllType)localObject4).time = (((QCallRecord)localObject1).time * 1000L);
        ((VoipHistoryAllType)localObject4).obj = localObject1;
        ((VoipHistoryAllType)localObject4).type = 1;
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    Collections.sort((List)localObject2, (Comparator)localObject3);
    localObject3 = new ArrayList();
    paramVoipContact = "";
    localObject2 = ((ArrayList)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (VoipHistoryAllType)((Iterator)localObject2).next();
      localObject1 = new Date(((VoipHistoryAllType)localObject4).time);
      localObject1 = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject1);
      if (paramVoipContact.equals(localObject1)) {
        break label807;
      }
      paramVoipContact = new VoipHistoryAllType();
      paramVoipContact.type = 2;
      paramVoipContact.obj = localObject1;
      ((ArrayList)localObject3).add(paramVoipContact);
      paramVoipContact = (VoipContact)localObject1;
    }
    label807:
    for (;;)
    {
      ((ArrayList)localObject3).add(localObject4);
      break;
      return localObject3;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a();
  }
  
  public void a(VoipHistoryData paramVoipHistoryData)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramVoipHistoryData);
    setChanged();
    notifyObservers(this);
  }
  
  public boolean a(VoipHistoryData paramVoipHistoryData)
  {
    boolean bool = false;
    int i = 0;
    if (paramVoipHistoryData.contactLookupId != null) {
      paramVoipHistoryData = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, false, "contactLookupId =?", new String[] { String.valueOf(paramVoipHistoryData.contactLookupId) }, null, null, null, null);
    }
    while (paramVoipHistoryData != null)
    {
      for (;;)
      {
        if (i < paramVoipHistoryData.size())
        {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((VoipHistoryData)paramVoipHistoryData.get(i));
          i += 1;
          continue;
          if (paramVoipHistoryData.countryCode != null)
          {
            paramVoipHistoryData = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, false, "countryCode =? and phoneNumberWithoutCountry=?", new String[] { paramVoipHistoryData.countryCode, paramVoipHistoryData.phoneNumberWithoutCountry }, null, null, null, null);
            break;
          }
          paramVoipHistoryData = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, false, "phoneNumberWithoutCountry =?", new String[] { paramVoipHistoryData.phoneNumberWithoutCountry }, null, null, null, null);
          break;
        }
      }
      setChanged();
      notifyObservers(this);
      bool = true;
    }
    return bool;
  }
  
  @Deprecated
  public boolean a(String paramString)
  {
    int i = 0;
    paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VoipHistoryData.class, false, "uin =?", new String[] { paramString }, null, null, null, null);
    while (i < paramString.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((VoipHistoryData)paramString.get(i));
      i += 1;
    }
    setChanged();
    notifyObservers(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipHistoryInterface
 * JD-Core Version:    0.7.0.1
 */