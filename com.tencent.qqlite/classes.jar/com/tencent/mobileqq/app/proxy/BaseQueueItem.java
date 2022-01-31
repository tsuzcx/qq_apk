package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;

public class BaseQueueItem
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public ContentValues a;
  ProxyListener a;
  public Entity a;
  public String a;
  public String[] a;
  public String b;
  public String c;
  public int h;
  public int i;
  
  public BaseQueueItem(String paramString1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.h = paramInt1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_AndroidContentContentValues = paramContentValues;
    this.i = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener = paramProxyListener;
  }
  
  public BaseQueueItem(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.h = paramInt1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = paramEntity;
    this.i = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener = paramProxyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseQueueItem
 * JD-Core Version:    0.7.0.1
 */