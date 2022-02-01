package com.tencent.map.tools.net;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.sdk.a.qa;
import com.tencent.map.sdk.a.qb;
import com.tencent.map.sdk.a.qc;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public class NetManager
{
  private static qa a;
  private static qa b;
  private static NetManager e;
  private NetAdapter c = new qb();
  private boolean d = false;
  
  public static NetAdapter buildAdapter(AdapterType paramAdapterType)
  {
    return buildAdapter(paramAdapterType, null);
  }
  
  public static NetAdapter buildAdapter(AdapterType paramAdapterType, Bundle paramBundle)
  {
    switch (NetManager.1.a[paramAdapterType.ordinal()])
    {
    default: 
      if (b == null)
      {
        paramAdapterType = new qb();
        b = paramAdapterType;
        paramAdapterType.a(paramBundle);
      }
      return b;
    }
    if (a == null)
    {
      paramAdapterType = new qc();
      a = paramAdapterType;
      paramAdapterType.a(paramBundle);
    }
    return a;
  }
  
  public static NetManager getInstance()
  {
    try
    {
      if (e == null) {
        e = new NetManager();
      }
      NetManager localNetManager = e;
      return localNetManager;
    }
    finally {}
  }
  
  public NetResponse doGet(String paramString)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString);
  }
  
  public NetResponse doGet(String paramString, int paramInt, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString, paramInt, paramHttpCanceler);
  }
  
  public NetResponse doGet(String paramString1, String paramString2)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString1, paramString2);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString1, paramString2, paramInt);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString1, paramString2, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString1, paramString2, paramInt, paramHttpCanceler);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doGet(paramString1, paramString2, paramInt, paramHashMap, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString1, paramString2, paramArrayOfByte);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString1, paramString2, paramArrayOfByte, paramInt);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramHashMap, null);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString1, paramString2, paramArrayOfByte, paramInt, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString1, paramString2, paramArrayOfByte, paramInt, paramHashMap, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString, paramArrayOfByte);
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPost(paramString, paramArrayOfByte, paramInt, paramHttpCanceler);
  }
  
  public NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.doPostNoBuffer(paramString1, paramString2, paramArrayOfByte);
  }
  
  public void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    if (this.c != null) {
      this.c.doRangePost(paramString1, paramArrayOfByte, paramString2, paramString3, paramString4, paramString5, paramHttpCanceler);
    }
  }
  
  public void setAdapter(Context paramContext, NetAdapter paramNetAdapter)
  {
    if (paramNetAdapter == null) {}
    do
    {
      do
      {
        return;
      } while (this.c == paramNetAdapter);
      this.d = false;
      this.c = paramNetAdapter;
    } while (this.d);
    if (this.c == null) {
      this.c = new qb();
    }
    this.c.initNet(paramContext.getApplicationContext());
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.NetManager
 * JD-Core Version:    0.7.0.1
 */