package com.tencent.open.agent.datamodel;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.open.adapter.CommonDataAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendDataManager
{
  protected static final int a = 5;
  protected static FriendDataManager a;
  protected static final String a = "FriendDataManager";
  protected static byte[] a;
  protected static final int b = 20;
  protected List a;
  protected List b = new ArrayList(5);
  public int c;
  protected List c;
  public int d = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected FriendDataManager()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(20);
  }
  
  public static FriendDataManager a()
  {
    if (jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager == null) {
        jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = new FriendDataManager();
      }
      return jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager;
    }
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public int a(int paramInt)
  {
    List localList = ((FriendGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Friend a(int paramInt)
  {
    return (Friend)this.b.get(paramInt);
  }
  
  public Friend a(String paramString)
  {
    Friend localFriend;
    do
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((FriendGroup)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
      }
      localFriend = (Friend)localIterator2.next();
    } while (!paramString.equals(localFriend.jdField_a_of_type_JavaLangString));
    return localFriend;
    return null;
  }
  
  public String a(int paramInt)
  {
    return ((FriendGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public List a(int paramInt)
  {
    return ((FriendGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_c_of_type_JavaUtilList.contains(paramString)) {
      this.jdField_c_of_type_JavaUtilList.add(paramString);
    }
  }
  
  public void a(List paramList, int paramInt1, int paramInt2)
  {
    label9:
    String str2;
    Iterator localIterator1;
    if (paramList.size() <= 0)
    {
      return;
    }
    else
    {
      this.jdField_c_of_type_Int = paramInt1;
      this.d = paramInt2;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.b.clear();
      this.jdField_c_of_type_JavaUtilList.clear();
      str2 = CommonDataAdapter.a().a().getResources().getString(2131362123);
      localIterator1 = paramList.iterator();
    }
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramList = (FriendGroup)localIterator1.next();
        if (str2.equals(paramList.jdField_a_of_type_JavaLangString)) {
          this.b.addAll(paramList.jdField_a_of_type_JavaUtilList);
        }
      }
      else
      {
        break label9;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramList);
      paramList = paramList.jdField_a_of_type_JavaUtilList;
      if (paramList == null) {
        break;
      }
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        Friend localFriend = (Friend)localIterator2.next();
        String str1 = localFriend.c;
        if (str1 != null)
        {
          paramList = str1;
          if (!"".equals(str1)) {}
        }
        else
        {
          paramList = localFriend.b;
        }
        localFriend.e = ChnToSpell.a(paramList, 2);
        localFriend.f = ChnToSpell.a(paramList, 1);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_c_of_type_JavaUtilList.contains(paramString);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilList.contains(paramString)) {
      this.jdField_c_of_type_JavaUtilList.remove(paramString);
    }
  }
  
  public int c()
  {
    return this.jdField_c_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.FriendDataManager
 * JD-Core Version:    0.7.0.1
 */