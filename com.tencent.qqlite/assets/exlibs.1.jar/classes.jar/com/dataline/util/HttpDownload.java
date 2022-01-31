package com.dataline.util;

import dj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.methods.HttpGet;

public class HttpDownload
{
  public static final int a = 5000;
  public static final int b = 60000;
  public static final int c = 20000;
  public static final int d = 60000;
  private static final int i = 10;
  public Map a = new HashMap();
  public int e = 3;
  public int f = 20000;
  public int g = 60000;
  public int h = 0;
  
  public HttpDownload(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e = 3;
      this.f = 5000;
      this.g = 60000;
      return;
    }
    this.e = 5;
    this.f = 20000;
    this.g = 60000;
  }
  
  private void b()
  {
    synchronized (this.a)
    {
      if ((this.h == this.a.size()) || (this.h >= 10)) {
        return;
      }
      Object localObject2 = this.a.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        HttpDownload.HttpTar localHttpTar = (HttpDownload.HttpTar)((Iterator)localObject2).next();
        if (localHttpTar.jdField_a_of_type_JavaLangThread == null)
        {
          this.h += 1;
          localObject2 = new dj();
          ((dj)localObject2).jdField_a_of_type_ComDatalineUtilHttpDownload = this;
          ((dj)localObject2).jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar = localHttpTar;
          localHttpTar.jdField_a_of_type_JavaLangThread = new Thread((Runnable)localObject2, "download thread");
          localHttpTar.jdField_a_of_type_JavaLangThread.start();
          return;
        }
      }
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject5;
    for (;;)
    {
      synchronized (this.a)
      {
        localObject4 = this.a.values().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (HttpDownload.HttpTar)((Iterator)localObject4).next();
        if (((HttpDownload.HttpTar)localObject5).jdField_a_of_type_JavaLangThread != null) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
      localObject2.add(localObject5);
    }
    Object localObject4 = localObject2.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (HttpDownload.HttpTar)((Iterator)localObject4).next();
      this.a.remove(((HttpDownload.HttpTar)localObject5).jdField_c_of_type_JavaLangString);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (HttpDownload.HttpTar)((Iterator)localObject3).next();
      ((HttpDownload.HttpTar)localObject4).jdField_b_of_type_Boolean = true;
      if (((HttpDownload.HttpTar)localObject4).jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet != null) {
        ((HttpDownload.HttpTar)localObject4).jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet.abort();
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      HttpDownload.HttpTar localHttpTar = (HttpDownload.HttpTar)((Iterator)???).next();
      localObject3 = localHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        localObject5 = (Long)((Map.Entry)localObject4).getKey();
        ((HttpDownload.HttpDownloadListener)((Map.Entry)localObject4).getValue()).a(((Long)localObject5).longValue(), false, localHttpTar.d, localHttpTar.jdField_a_of_type_Int, localHttpTar.jdField_b_of_type_Int, localHttpTar.jdField_c_of_type_Int, localHttpTar.jdField_b_of_type_JavaLangString, localHttpTar.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(HttpDownload.HttpTar paramHttpTar)
  {
    Iterator localIterator = paramHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong = (Long)localEntry.getKey();
      ((HttpDownload.HttpDownloadListener)localEntry.getValue()).a(localLong.longValue(), paramHttpTar.jdField_a_of_type_JavaLangString, paramHttpTar.jdField_b_of_type_Long);
    }
  }
  
  public void a(HttpDownload.HttpTar paramHttpTar, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      if (this.a.get(paramHttpTar.jdField_c_of_type_JavaLangString) == null) {
        return;
      }
      this.a.remove(paramHttpTar.jdField_c_of_type_JavaLangString);
      this.h -= 1;
      ??? = paramHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
        Long localLong = (Long)localEntry.getKey();
        ((HttpDownload.HttpDownloadListener)localEntry.getValue()).a(localLong.longValue(), paramBoolean, paramHttpTar.d, paramHttpTar.jdField_a_of_type_Int, paramHttpTar.jdField_b_of_type_Int, paramHttpTar.jdField_c_of_type_Int, paramHttpTar.jdField_b_of_type_JavaLangString, paramHttpTar.jdField_a_of_type_JavaLangString);
      }
    }
    b();
  }
  
  public boolean a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, HttpDownload.HttpDownloadListener paramHttpDownloadListener)
  {
    HttpDownload.HttpDownloadListenerPack localHttpDownloadListenerPack = new HttpDownload.HttpDownloadListenerPack(this, paramHttpDownloadListener);
    synchronized (this.a)
    {
      paramHttpDownloadListener = (HttpDownload.HttpTar)this.a.get(paramString1);
      if (paramHttpDownloadListener == null)
      {
        paramHttpDownloadListener = new HttpDownload.HttpTar(this);
        paramHttpDownloadListener.jdField_a_of_type_Long = paramLong1;
        paramHttpDownloadListener.jdField_a_of_type_JavaLangString = paramString2;
        paramHttpDownloadListener.jdField_c_of_type_JavaLangString = paramString1;
        paramHttpDownloadListener.jdField_b_of_type_JavaLangString = paramString3;
        paramHttpDownloadListener.jdField_b_of_type_Long = 0L;
        paramHttpDownloadListener.jdField_c_of_type_Long = paramLong2;
        paramHttpDownloadListener.d = 0L;
        paramHttpDownloadListener.jdField_a_of_type_JavaLangThread = null;
        paramHttpDownloadListener.jdField_a_of_type_Int = 0;
        paramHttpDownloadListener.jdField_b_of_type_Int = 200;
        paramHttpDownloadListener.jdField_c_of_type_Int = 0;
        paramHttpDownloadListener.jdField_a_of_type_Boolean = false;
        paramHttpDownloadListener.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localHttpDownloadListenerPack);
        this.a.put(paramString1, paramHttpDownloadListener);
        b();
        paramString1 = null;
        j = 0;
        if ((j != 0) && (paramString1.jdField_a_of_type_Boolean)) {
          localHttpDownloadListenerPack.a(paramLong1, paramString2, paramString1.jdField_b_of_type_Long);
        }
        return true;
      }
      paramHttpDownloadListener.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localHttpDownloadListenerPack);
      int j = 1;
      paramString1 = paramHttpDownloadListener;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    HttpDownload.HttpTar localHttpTar;
    synchronized (this.a)
    {
      localHttpTar = (HttpDownload.HttpTar)this.a.get(paramString);
      if (localHttpTar == null) {
        return false;
      }
    }
    if (localHttpTar.jdField_a_of_type_JavaLangThread != null)
    {
      localHttpTar.jdField_b_of_type_Boolean = true;
      if (localHttpTar.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet == null) {
        break label184;
      }
      localHttpTar.jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet.abort();
      paramString = null;
    }
    for (;;)
    {
      if ((localObject != null) && (paramString != null)) {
        paramString.a(paramLong, false, ((HttpDownload.HttpTar)localObject).d, 8, 0, 0, ((HttpDownload.HttpTar)localObject).jdField_b_of_type_JavaLangString, ((HttpDownload.HttpTar)localObject).jdField_a_of_type_JavaLangString);
      }
      return true;
      localObject = (HttpDownload.HttpDownloadListener)localHttpTar.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      localHttpTar.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      if (localHttpTar.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        this.a.remove(paramString);
      }
      paramString = (String)localObject;
      localObject = localHttpTar;
      continue;
      label184:
      paramString = null;
    }
  }
  
  public void b(HttpDownload.HttpTar paramHttpTar)
  {
    Iterator localIterator = paramHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong = (Long)localEntry.getKey();
      ((HttpDownload.HttpDownloadListener)localEntry.getValue()).b(localLong.longValue(), paramHttpTar.jdField_b_of_type_Long, paramHttpTar.jdField_c_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.HttpDownload
 * JD-Core Version:    0.7.0.1
 */