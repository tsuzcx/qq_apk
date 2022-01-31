package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import cqo;
import cqp;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatBackgroundManagerImp
  implements ChatBackgroundManager
{
  public static final String a = "http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/xydata.js";
  public static final String b = "http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/";
  public static final String c = AppConstants.bb + "ChatBgJson.txt";
  public static final String d = "CHATBACKGROUNG";
  public static final String e = "CHATBACKGROUNDVERSION";
  private static final String f = "ChatBackgroundManagerImp";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ChatBackgroundManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    a();
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChatBackgroundInfo.class);
    if (localArrayList != null)
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        ChatBackgroundInfo localChatBackgroundInfo = (ChatBackgroundInfo)localIterator.next();
        try
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localChatBackgroundInfo);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChatBackgroundInfo.class);
  }
  
  public void a(ChatBackgroundInfo paramChatBackgroundInfo)
  {
    ThreadManager.a(new cqp(this, paramChatBackgroundInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.a(new cqo(this));
    }
  }
  
  public ArrayList b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ChatBackgroundManagerImp
 * JD-Core Version:    0.7.0.1
 */