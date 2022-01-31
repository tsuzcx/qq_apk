package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.qun.group_activity.group_activity.GroupAct;

public class RecommendTroopManagerImp
  implements Manager
{
  static final int jdField_a_of_type_Int = 60;
  protected static final String a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  long jdField_a_of_type_Long = 0L;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = RecommendTroopManagerImp.class.getSimpleName();
  }
  
  public RecommendTroopManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("recommend_troop_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getRecommendTroopTime", 0L);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(AppConstants.ah, 4000);
    int j;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      j = 0;
      return j;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    int i = 0;
    label40:
    if (paramQQAppInterface.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      String str = localMessageRecord.msg;
      if ((str == null) || (str.length() <= 0) || ((localMessageRecord.msgtype != -1039) && (localMessageRecord.msgtype != -1040)) || (localMessageRecord.extStr == null) || (localMessageRecord.extStr.length() <= 0) || (localMessageRecord.isread)) {
        break label165;
      }
      i += 1;
    }
    label165:
    for (;;)
    {
      break label40;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getRecommendUnreadCount" + i);
      return i;
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.RecommendTroopTab.", 2, paramString);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ag, 9000, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    Object localObject = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    MessageRecord localMessageRecord = a();
    if ((localMessageRecord != null) && (!((RecentManagerFor3rdPart)localObject).a(AppConstants.ag, 9000, localMessageRecord.time))) {
      ((RecentManagerFor3rdPart)localObject).a(AppConstants.ag, 9000, BaseApplicationImpl.getContext().getString(2131559208), localMessageRecord.time, localMessageRecord.time);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (localObject != null) {
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1009));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendTroopView.class);
    if (localObject != null) {
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(105));
    }
  }
  
  private void e()
  {
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 100L);
    }
  }
  
  public MessageRecord a()
  {
    try
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000);
      if ((localList != null) && (localList.size() > 0))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null))
          {
            int j = localMessageRecord.msg.length();
            if (j > 0) {
              return localMessageRecord;
            }
          }
          i -= 1;
        }
      }
      return null;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public String a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0))
          {
            localObject = localMessageRecord.msg;
            return localObject;
          }
          i -= 1;
        }
      }
      return "";
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public List a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000);
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      Object localObject = localMessageRecord.msg;
      RecommendTroopMsg localRecommendTroopMsg;
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if ((localMessageRecord.msgtype != -1039) || (localMessageRecord.extStr == null) || (localMessageRecord.extStr.length() <= 0)) {
          break label241;
        }
        localObject = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, localMessageRecord.extStr);
        if (localObject == null) {
          break label212;
        }
        localRecommendTroopMsg = new RecommendTroopMsg();
        localRecommendTroopMsg.uniseq = localMessageRecord.uniseq;
        localRecommendTroopMsg.msgtype = localMessageRecord.msgtype;
        localRecommendTroopMsg.isRead = localMessageRecord.isread;
        localRecommendTroopMsg.timeStamp = localMessageRecord.time;
        localRecommendTroopMsg.troop = ((RecommendTroopInfo)localObject);
        localArrayList.add(localRecommendTroopMsg);
      }
      for (;;)
      {
        i -= 1;
        break;
        label212:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        continue;
        label241:
        if ((localMessageRecord.msgtype == -1040) && (localMessageRecord.extStr != null) && (localMessageRecord.extStr.length() > 0))
        {
          localObject = (RecTroopBusinessItem)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecTroopBusinessItem.class, localMessageRecord.extStr);
          if (localObject != null)
          {
            localRecommendTroopMsg = new RecommendTroopMsg();
            localRecommendTroopMsg.uniseq = localMessageRecord.uniseq;
            localRecommendTroopMsg.msgtype = localMessageRecord.msgtype;
            localRecommendTroopMsg.isRead = localMessageRecord.isread;
            localRecommendTroopMsg.timeStamp = localMessageRecord.time;
            localRecommendTroopMsg.rtbItem = ((RecTroopBusinessItem)localObject);
            localArrayList.add(localRecommendTroopMsg);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1039);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1040);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000, paramLong);
  }
  
  public void a(long paramLong, List paramList)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("getRecommendTroopTime", this.jdField_a_of_type_Long).commit();
    this.jdField_a_of_type_JavaUtilList = paramList;
    c();
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    paramString = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, paramString);
    if (paramString != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000, paramLong);
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramList != null)
    {
      localObject1 = localObject3;
      if (paramList.size() != 0)
      {
        paramList = (group_activity.GroupAct)paramList.get(0);
        localObject1 = localObject3;
        if (paramList != null)
        {
          localObject1 = new RecTroopBusinessItem();
          ((RecTroopBusinessItem)localObject1).id = String.valueOf(paramList.uint32_act_id.get());
          ((RecTroopBusinessItem)localObject1).title = paramList.string_title.get();
          ((RecTroopBusinessItem)localObject1).des = paramList.string_des.get();
          ((RecTroopBusinessItem)localObject1).jumpType = paramList.uint32_jumptype.get();
          ((RecTroopBusinessItem)localObject1).jumpUrl = paramList.string_url.get();
          ((RecTroopBusinessItem)localObject1).jumpParam = paramList.string_jumpparam.get();
          ((RecTroopBusinessItem)localObject1).iconUrl = paramList.string_iconurl.get();
          ((RecTroopBusinessItem)localObject1).btnText = paramList.string_btntext.get();
          ((RecTroopBusinessItem)localObject1).startTime = paramList.uint32_start_time.get();
          ((RecTroopBusinessItem)localObject1).endTime = paramList.uint32_end_time.get();
          ((RecTroopBusinessItem)localObject1).timeStamp = l;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
        }
      }
    }
    int i;
    EntityTransaction localEntityTransaction;
    if (localObject1 == null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecTroopBusinessItem.class, false, null, null, null, null, "timeStamp desc", null);
      if ((localObject3 != null) && (((List)localObject3).size() != 0))
      {
        paramList = (RecTroopBusinessItem)((List)localObject3).get(0);
        if (((List)localObject3).size() > 60)
        {
          i = ((List)localObject3).size() - 1;
          while (i >= 60)
          {
            localObject1 = (RecTroopBusinessItem)((List)localObject3).get(i);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
            i -= 1;
          }
        }
        if (paramList != null)
        {
          localObject1 = MessageRecordFactory.a(-1040);
          ((MessageRecord)localObject1).extStr = paramList.id;
          ((MessageRecord)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), AppConstants.ah, "0", paramList.title, l, -1040, 4000, 0L);
          localArrayList.add(localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1040);
        }
        localObject3 = new HashMap();
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      }
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        localEntityTransaction.a();
        i = localArrayList.size();
        j = 0;
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject4 = (SearchGroup.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject4 == null) || ((localObject4 != null) && (((SearchGroup.GroupInfo)localObject4).dwGroupUin.get() == 0) && (((SearchGroup.GroupInfo)localObject4).dwGroupCode.get() == 0))) {
            break label1385;
          }
          localObject1 = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupCode.get()));
          if (localObject1 != null) {
            break label1373;
          }
          localObject1 = new RecommendTroopInfo();
          k = 0;
          ((RecommendTroopInfo)localObject1).code = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupUin.get());
          ((RecommendTroopInfo)localObject1).uin = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupCode.get());
          ((RecommendTroopInfo)localObject1).ownerUin = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupOwnerId.get());
          ((RecommendTroopInfo)localObject1).curMemberNum = ((SearchGroup.GroupInfo)localObject4).dwCurMemberNum.get();
          ((RecommendTroopInfo)localObject1).maxMemberNum = ((SearchGroup.GroupInfo)localObject4).dwMaxMemberNum.get();
          ((RecommendTroopInfo)localObject1).name = ((SearchGroup.GroupInfo)localObject4).sGroupName.get();
          ((RecommendTroopInfo)localObject1).fingerMemo = ((SearchGroup.GroupInfo)localObject4).sGroupFingerMem.get();
          ((RecommendTroopInfo)localObject1).faceId = ((SearchGroup.GroupInfo)localObject4).dwGroupFaceId.get();
          ((RecommendTroopInfo)localObject1).faceUrl = ((SearchGroup.GroupInfo)localObject4).sGroupFaceUrl.get();
          ((RecommendTroopInfo)localObject1).tag = ((SearchGroup.GroupInfo)localObject4).sGroupTag.get();
          ((RecommendTroopInfo)localObject1).classId = ((SearchGroup.GroupInfo)localObject4).dwGroupClass.get();
          ((RecommendTroopInfo)localObject1).classText = ((SearchGroup.GroupInfo)localObject4).sGroupClassText.get();
          ((RecommendTroopInfo)localObject1).level = ((SearchGroup.GroupInfo)localObject4).dwGroupLevel.get();
          ((RecommendTroopInfo)localObject1).isSameCity = ((SearchGroup.GroupInfo)localObject4).bSameCity.get();
          ((RecommendTroopInfo)localObject1).isTroopFull = ((SearchGroup.GroupInfo)localObject4).bGroupFull.get();
          ((RecommendTroopInfo)localObject1).isTroopAllow = ((SearchGroup.GroupInfo)localObject4).bGroupAllow.get();
          ((RecommendTroopInfo)localObject1).isTroopIn = ((SearchGroup.GroupInfo)localObject4).bGroupIn.get();
          ((RecommendTroopInfo)localObject1).hotDegree = ((SearchGroup.GroupInfo)localObject4).dwGroupHotDegree.get();
          ((RecommendTroopInfo)localObject1).flagExt = ((SearchGroup.GroupInfo)localObject4).dwGroupFlagExt.get();
          ((RecommendTroopInfo)localObject1).authType = ((SearchGroup.GroupInfo)localObject4).dwAuthGroupType.get();
          ((RecommendTroopInfo)localObject1).location = ((SearchGroup.GroupInfo)localObject4).sGroupLocation.get();
          ((RecommendTroopInfo)localObject1).option = ((short)((SearchGroup.GroupInfo)localObject4).dwGroupOption.get());
          if (k != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
          localObject4 = MessageRecordFactory.a(-1039);
          String str = ((RecommendTroopInfo)localObject1).name;
          ((MessageRecord)localObject4).extStr = ((RecommendTroopInfo)localObject1).uin;
          ((MessageRecord)localObject4).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), AppConstants.ah, "0", str, l, -1039, 4000, 0L);
          localArrayList.add(localObject4);
          ((HashMap)localObject3).put(((RecommendTroopInfo)localObject1).uin, Integer.valueOf(1));
          k = i + 1;
          i = k;
          if (k < 60) {
            break label1385;
          }
        }
        localEntityTransaction.c();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      if ((localArrayList.size() >= 1) || ((localArrayList.size() == 1) && (paramList == null)))
      {
        m = 60 - localArrayList.size();
        if (m <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        e();
        d();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Grp_recom_push", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
        continue;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000);
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = paramList.size() - 1;
        Object localObject2;
        while (i >= 0)
        {
          localObject2 = (MessageRecord)paramList.get(i);
          if ((((MessageRecord)localObject2).msgtype == -1039) && (((HashMap)localObject3).containsKey(((MessageRecord)localObject2).extStr)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
            paramList.remove(i);
          }
          i -= 1;
        }
        j = 0;
        k = paramList.size() - 1;
        while (k >= 0)
        {
          localObject2 = (MessageRecord)paramList.get(k);
          i = j;
          if (((MessageRecord)localObject2).msgtype == -1039)
          {
            j += 1;
            i = j;
            if (j > m)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
              localObject2 = (RecommendTroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class, ((MessageRecord)localObject2).extStr);
              i = j;
              if (localObject2 != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
                i = j;
              }
            }
          }
          k -= 1;
          j = i;
        }
        continue;
        label1373:
        k = 1;
        continue;
        paramList = (List)localObject2;
        break;
        label1385:
        j += 1;
      }
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      long l = NetConnInfoCenter.getServerTime();
      a("check recommend troop time");
      if (l > this.jdField_a_of_type_Long)
      {
        a("start download recommend time");
        l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 10, 0, 8, "", 1, this.jdField_a_of_type_Long);
        return true;
      }
      return false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendTroopInfo.class);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1040);
  }
  
  public void b(List paramList)
  {
    a(paramList);
  }
  
  public boolean b()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ah, 4000);
    if (localList == null) {
      return false;
    }
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if (localMessageRecord == null) {}
      String str;
      do
      {
        i -= 1;
        break;
        str = localMessageRecord.msg;
      } while ((str == null) || (str.length() <= 0) || (localMessageRecord.msgtype != -1039) || (localMessageRecord.isread));
      return true;
    }
    return false;
  }
  
  public void c()
  {
    int i = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecTroopBusinessItem.class, false, null, null, null, null, "timeStamp desc", null);
    if ((localList != null) && (localList.size() != 0)) {}
    for (;;)
    {
      if (i < localList.size())
      {
        RecTroopBusinessItem localRecTroopBusinessItem = (RecTroopBusinessItem)localList.get(i);
        if (localRecTroopBusinessItem != null) {
          localArrayList.add(Integer.valueOf(localRecTroopBusinessItem.id));
        }
        if (i < 60) {}
      }
      else
      {
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a(localArrayList);
        return;
      }
      i += 1;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecommendTroopManagerImp
 * JD-Core Version:    0.7.0.1
 */