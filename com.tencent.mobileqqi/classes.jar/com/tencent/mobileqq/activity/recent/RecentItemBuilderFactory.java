package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.assistant.PubAccountAssistantEmptyItemBuilder;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantGuideBuilder;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantEducationBuilder;

public class RecentItemBuilderFactory
{
  protected static final int A = 2;
  protected static final int B = 0;
  protected static final int C = 1;
  protected static final int D = 2;
  public static final int a = 0;
  public static final String a = "RECENT_BLANK_VIEW";
  protected static final int[] a;
  public static final int b = 1;
  protected static final int[] b = { 0, 1, 2 };
  public static final int c = 3;
  protected static final int[] c = { 0, 1, 2 };
  public static final int d = 4;
  protected static final int[] d = { 0, 1 };
  public static final int e = 5;
  protected static final int[] e = { 0, 1, 2 };
  public static final int f = 6;
  protected static final int[] f = { 0, 1, 2 };
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 5;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  protected static final int q = 0;
  protected static final int r = 1;
  protected static final int s = 2;
  protected static final int t = 0;
  protected static final int u = 1;
  protected static final int v = 0;
  protected static final int w = 1;
  protected static final int x = 2;
  protected static final int y = 0;
  protected static final int z = 1;
  protected int E;
  protected PubAccountAssistantEmptyItemBuilder a;
  protected PubAccountAssistantGuideBuilder a;
  protected RecentAdapter a;
  protected RecentBlankItemBuilder a;
  protected RecentCallItemBuilder a;
  protected RecentDefaultItemBuilder a;
  protected RecentEmptyItemBuilder a;
  protected TroopAssistantEducationBuilder a;
  protected TroopAssistantEmptyItemBuilder a;
  protected QZoneShareAlbumAssistantEducationBuilder a;
  protected int[] g;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[0];
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.E = paramInt;
    if (this.E == 0)
    {
      this.g = b;
      return;
    }
    if (this.E == 1)
    {
      this.g = c;
      return;
    }
    if (this.E == 2)
    {
      this.g = d;
      return;
    }
    if (this.E == 3)
    {
      this.g = e;
      return;
    }
    if (this.E == 4)
    {
      this.g = f;
      return;
    }
    this.g = jdField_a_of_type_ArrayOfInt;
  }
  
  public int a()
  {
    return this.E;
  }
  
  public int a(Object paramObject)
  {
    switch (this.E)
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
                do
                {
                  return -1;
                  if ((paramObject instanceof Integer)) {
                    return this.g[0];
                  }
                  if ((paramObject instanceof RecentUserBaseData)) {
                    return this.g[1];
                  }
                } while (!(paramObject instanceof String));
                return this.g[2];
                if (!(paramObject instanceof Integer)) {
                  break;
                }
                paramObject = (Integer)paramObject;
                if (paramObject.intValue() == 3) {
                  return this.g[2];
                }
                if (paramObject.intValue() == 4) {
                  return this.g[0];
                }
              } while (paramObject.intValue() != 5);
              return this.g[0];
            } while (!(paramObject instanceof RecentBaseData));
            return this.g[1];
            if ((paramObject instanceof Integer))
            {
              if (((Integer)paramObject).intValue() == 5) {
                return this.g[1];
              }
              return this.g[0];
            }
          } while (!(paramObject instanceof RecentBaseData));
          return this.g[0];
          if (!(paramObject instanceof Integer)) {
            break;
          }
          paramObject = (Integer)paramObject;
          if (paramObject.intValue() == 8) {
            return this.g[2];
          }
          if (paramObject.intValue() == 9) {
            return this.g[0];
          }
        } while (paramObject.intValue() != 10);
        return this.g[0];
      } while (!(paramObject instanceof RecentBaseData));
      return this.g[1];
      if ((paramObject instanceof Integer)) {
        return this.g[0];
      }
      if ((paramObject instanceof RecentBaseData)) {
        return this.g[1];
      }
    } while (!(paramObject instanceof String));
    return this.g[2];
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i1;
    if (paramObject != null)
    {
      i1 = a(paramObject);
      if (this.E != 0) {
        break label129;
      }
      if (i1 != 0) {
        break label64;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder = new RecentEmptyItemBuilder();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder;
    }
    label129:
    for (;;)
    {
      if (localObject1 != null) {
        ((RecentItemBaseBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      }
      return localObject1;
      label64:
      if (i1 == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
      }
      else
      {
        localObject1 = localObject2;
        if (i1 == 2)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder = new RecentBlankItemBuilder();
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder;
          continue;
          if (this.E == 1)
          {
            if (i1 == 0)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder = new TroopAssistantEmptyItemBuilder();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder;
            }
            else if (i1 == 1)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
            }
            else
            {
              localObject1 = localObject2;
              if (i1 == 2)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEducationBuilder == null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEducationBuilder = new TroopAssistantEducationBuilder();
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEducationBuilder;
              }
            }
          }
          else if (this.E == 2)
          {
            if (i1 == 0)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new QZoneShareAlbumDefaultItemBuilder();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
            }
            else
            {
              localObject1 = localObject2;
              if (i1 == 1)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantEducationBuilder == null) {
                  this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantEducationBuilder = new QZoneShareAlbumAssistantEducationBuilder();
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantEducationBuilder;
              }
            }
          }
          else if (this.E == 3)
          {
            if (i1 == 0)
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder = new PubAccountAssistantEmptyItemBuilder();
              }
              localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder;
            }
            else if (i1 == 1)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
            }
            else
            {
              localObject1 = localObject2;
              if (i1 == 2)
              {
                if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantGuideBuilder == null) {
                  this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantGuideBuilder = new PubAccountAssistantGuideBuilder();
                }
                localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantGuideBuilder;
              }
            }
          }
          else
          {
            localObject1 = localObject2;
            if (this.E == 4) {
              if (i1 == 0)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder == null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder = new RecentEmptyItemBuilder();
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder;
              }
              else if (i1 == 1)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder == null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder = new RecentCallItemBuilder();
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder;
              }
              else
              {
                localObject1 = localObject2;
                if (i1 == 2)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder == null) {
                    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder = new RecentBlankItemBuilder();
                  }
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder;
                }
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
    return this.g.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */