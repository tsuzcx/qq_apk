package com.dataline.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.methods.HttpPost;

public class HttpUpload
{
  private static final int b = 3;
  public int a;
  public HashMap a;
  
  public HttpUpload()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if ((this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilHashMap.size()) || (this.jdField_a_of_type_Int >= 3)) {
        return;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        HttpUpload.HttpTar localHttpTar = (HttpUpload.HttpTar)((Iterator)localObject2).next();
        if (localHttpTar.jdField_a_of_type_JavaLangThread == null)
        {
          this.jdField_a_of_type_Int += 1;
          localObject2 = new HttpUploadTask();
          ((HttpUploadTask)localObject2).jdField_a_of_type_ComDatalineUtilHttpUpload = this;
          ((HttpUploadTask)localObject2).jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar = localHttpTar;
          localHttpTar.jdField_a_of_type_JavaLangThread = new Thread((Runnable)localObject2, "upload thread");
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
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localObject4 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (HttpUpload.HttpTar)((Iterator)localObject4).next();
        if (((HttpUpload.HttpTar)localObject5).jdField_a_of_type_JavaLangThread != null) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
      localObject2.add(localObject5);
    }
    Object localObject4 = localObject2.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (HttpUpload.HttpTar)((Iterator)localObject4).next();
      this.jdField_a_of_type_JavaUtilHashMap.remove(((HttpUpload.HttpTar)localObject5).jdField_a_of_type_JavaLangString);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (HttpUpload.HttpTar)((Iterator)localObject3).next();
      ((HttpUpload.HttpTar)localObject4).jdField_b_of_type_Boolean = true;
      if (((HttpUpload.HttpTar)localObject4).jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost != null) {
        ((HttpUpload.HttpTar)localObject4).jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost.abort();
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      HttpUpload.HttpTar localHttpTar = (HttpUpload.HttpTar)((Iterator)???).next();
      localObject3 = localHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        localObject5 = (Long)((Map.Entry)localObject4).getKey();
        ((HttpUpload.HttpUploadListener)((Map.Entry)localObject4).getValue()).a(((Long)localObject5).longValue(), false, localHttpTar.e, 8, 0, 0, localHttpTar.jdField_b_of_type_JavaLangString, localHttpTar.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(HttpUpload.HttpTar paramHttpTar)
  {
    Iterator localIterator = paramHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong = (Long)localEntry.getKey();
      ((HttpUpload.HttpUploadListener)localEntry.getValue()).a(localLong.longValue(), paramHttpTar.jdField_a_of_type_JavaLangString, paramHttpTar.jdField_c_of_type_Long);
    }
  }
  
  void a(HttpUpload.HttpTar paramHttpTar, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.get(paramHttpTar.jdField_a_of_type_JavaLangString) == null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramHttpTar.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int -= 1;
      ??? = paramHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
        Long localLong = (Long)localEntry.getKey();
        ((HttpUpload.HttpUploadListener)localEntry.getValue()).a(localLong.longValue(), paramBoolean, paramHttpTar.e, paramHttpTar.jdField_a_of_type_Int, paramHttpTar.jdField_b_of_type_Int, paramHttpTar.jdField_c_of_type_Int, paramHttpTar.jdField_b_of_type_JavaLangString, paramHttpTar.jdField_a_of_type_JavaLangString);
      }
    }
    b();
  }
  
  public void a(Map.Entry paramEntry, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2) {}
  
  public boolean a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, HttpUpload.HttpUploadListener arg12)
  {
    HttpUpload.HttpUploadListenerPack localHttpUploadListenerPack = new HttpUpload.HttpUploadListenerPack(this, ???);
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      HttpUpload.HttpTar localHttpTar = (HttpUpload.HttpTar)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (localHttpTar == null)
      {
        localHttpTar = new HttpUpload.HttpTar(this);
        localHttpTar.jdField_a_of_type_Long = paramLong1;
        localHttpTar.jdField_a_of_type_JavaLangString = paramString1;
        localHttpTar.jdField_b_of_type_JavaLangString = paramString2;
        localHttpTar.jdField_b_of_type_Long = paramLong2;
        localHttpTar.jdField_a_of_type_Boolean = paramBoolean;
        localHttpTar.jdField_c_of_type_Long = paramLong3;
        localHttpTar.d = paramLong4;
        localHttpTar.jdField_a_of_type_JavaLangThread = null;
        localHttpTar.jdField_a_of_type_Int = 0;
        localHttpTar.jdField_b_of_type_Int = 200;
        localHttpTar.jdField_c_of_type_Int = 0;
        localHttpTar.e = 0L;
        localHttpTar.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localHttpUploadListenerPack);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localHttpTar);
        b();
        return true;
      }
      localHttpTar.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localHttpUploadListenerPack);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    HttpUpload.HttpTar localHttpTar;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      localHttpTar = (HttpUpload.HttpTar)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localHttpTar == null) {
        return false;
      }
    }
    if (localHttpTar.jdField_a_of_type_JavaLangThread != null)
    {
      localHttpTar.jdField_b_of_type_Boolean = true;
      if (localHttpTar.jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost == null) {
        break label178;
      }
      localHttpTar.jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost.abort();
      paramString = null;
    }
    for (;;)
    {
      if ((localObject != null) && (paramString != null)) {
        paramString.a(paramLong, false, ((HttpUpload.HttpTar)localObject).e, 8, 0, 0, ((HttpUpload.HttpTar)localObject).jdField_b_of_type_JavaLangString, ((HttpUpload.HttpTar)localObject).jdField_a_of_type_JavaLangString);
      }
      return true;
      localObject = (HttpUpload.HttpUploadListener)localHttpTar.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      localHttpTar.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
      if (localHttpTar.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      paramString = (String)localObject;
      localObject = localHttpTar;
      continue;
      label178:
      paramString = null;
    }
  }
  
  public void b(HttpUpload.HttpTar paramHttpTar)
  {
    Iterator localIterator = paramHttpTar.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong = (Long)localEntry.getKey();
      ((HttpUpload.HttpUploadListener)localEntry.getValue()).a(localLong.longValue(), paramHttpTar.jdField_c_of_type_Long, paramHttpTar.jdField_b_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.HttpUpload
 * JD-Core Version:    0.7.0.1
 */