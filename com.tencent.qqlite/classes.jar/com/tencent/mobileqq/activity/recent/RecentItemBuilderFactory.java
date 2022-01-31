package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;

public class RecentItemBuilderFactory
{
  public static final int a = 0;
  public static final Long a;
  public static final String a = "RECENT_BLANK_VIEW";
  protected static final int[] a;
  public static final int b = 1;
  protected static final int[] b = { 0, 1, 2 };
  public static final int c = 4;
  protected static final int[] c = { 0, 1, 2 };
  public static final int d = 5;
  protected static final int[] d = { 0, 1, 2, 3 };
  public static final int e = 6;
  protected static final int[] e = { 0, 1, 2 };
  public static final int f = 7;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 3;
  public static final int m = 5;
  protected static final int n = 0;
  protected static final int o = 1;
  protected static final int p = 2;
  protected static final int q = 1;
  protected static final int r = 2;
  protected static final int s = 1;
  protected static final int t = 2;
  protected static final int u = 3;
  protected RecentAdapter a;
  protected RecentBlankItemBuilder a;
  protected RecentDefaultItemBuilder a;
  protected RecentEmptyItemBuilder a;
  protected TroopAssistantEmptyItemBuilder a;
  protected int[] f;
  protected int v;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.v = paramInt;
    if (this.v == 0)
    {
      this.f = b;
      return;
    }
    if (this.v == 1)
    {
      this.f = c;
      return;
    }
    if (this.v == 5)
    {
      this.f = e;
      return;
    }
    this.f = jdField_a_of_type_ArrayOfInt;
  }
  
  public int a()
  {
    return this.v;
  }
  
  public int a(Object paramObject)
  {
    int i1 = this.f[0];
    switch (this.v)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return i1;
                if ((paramObject instanceof Integer)) {
                  return this.f[1];
                }
                if ((paramObject instanceof RecentUserBaseData)) {
                  return this.f[2];
                }
                if ((paramObject instanceof String)) {
                  return this.f[0];
                }
              } while (!(paramObject instanceof RecentMsgBoxItem));
              return this.f[2];
              if (!(paramObject instanceof Integer)) {
                break;
              }
              paramObject = (Integer)paramObject;
              if (paramObject.intValue() == 4) {
                return this.f[1];
              }
            } while (paramObject.intValue() != 5);
            return this.f[1];
          } while (!(paramObject instanceof RecentBaseData));
          return this.f[2];
          if (!(paramObject instanceof Integer)) {
            break;
          }
          paramObject = (Integer)paramObject;
          if (paramObject.intValue() == 8) {
            return this.f[3];
          }
          if (paramObject.intValue() == 9) {
            return this.f[1];
          }
        } while (paramObject.intValue() != 10);
        return this.f[1];
      } while (!(paramObject instanceof RecentBaseData));
      return this.f[2];
      if ((paramObject instanceof Integer)) {
        return this.f[1];
      }
    } while (!(paramObject instanceof RecentBaseData));
    return this.f[2];
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    Object localObject = null;
    int i1 = a(paramObject);
    if (this.v == 0) {
      if (i1 == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder = new RecentEmptyItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder;
      }
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder = new RecentBlankItemBuilder();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder;
      }
      ((RecentItemBaseBuilder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      return localObject;
      paramObject = localObject;
      if (i1 == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
        continue;
        if (this.v == 1)
        {
          if (i1 == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder = new TroopAssistantEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder;
          }
          else
          {
            paramObject = localObject;
            if (i1 == 2)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
            }
          }
        }
        else
        {
          paramObject = localObject;
          if (this.v != 3)
          {
            paramObject = localObject;
            if (this.v == 5)
            {
              paramObject = localObject;
              if (i1 == 2)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
                }
                paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
  
  public int b()
  {
    return this.f.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */