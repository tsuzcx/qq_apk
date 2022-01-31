package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.manager.Manager;

public class DiscussionMemberManager
  implements Manager
{
  float jdField_a_of_type_Float = 0.75F;
  private final int jdField_a_of_type_Int = 5;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = DiscussionMemberManager.class.getSimpleName();
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = null;
  
  public DiscussionMemberManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new DiscussionMemberManager.1(this, 5, this.jdField_a_of_type_Float, true);
  }
  
  /* Error */
  public DiscussionMemberManager.CacheData a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/managers/DiscussionMemberManager:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: ifnull +26 -> 32
    //   9: aload_1
    //   10: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +19 -> 32
    //   16: aload_0
    //   17: getfield 27	com/tencent/mobileqq/managers/DiscussionMemberManager:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual 53	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 55	com/tencent/mobileqq/managers/DiscussionMemberManager$CacheData
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: aconst_null
    //   33: astore_1
    //   34: goto -6 -> 28
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	DiscussionMemberManager
    //   0	42	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	28	37	finally
  }
  
  public void a(List paramList, ArrayList paramArrayList, String paramString)
  {
    try
    {
      DiscussionMemberManager.CacheData localCacheData = new DiscussionMemberManager.CacheData();
      localCacheData.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localCacheData.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      localCacheData.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, localCacheData);
      }
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DiscussionMemberManager
 * JD-Core Version:    0.7.0.1
 */