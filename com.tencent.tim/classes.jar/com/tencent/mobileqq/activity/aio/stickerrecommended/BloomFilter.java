package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class BloomFilter
  implements Serializable
{
  private final int DEFAULT_SIZE = 4194304;
  private BitSet bits = new BitSet(4194304);
  private SimpleHash[] func = new SimpleHash[this.seeds.length];
  private final int[] seeds = { 5, 31, 1061, 5683, 17239, 25261, 49537 };
  public String version;
  
  public BloomFilter()
  {
    int i = 0;
    while (i < this.seeds.length)
    {
      this.func[i] = new SimpleHash(4194304, this.seeds[i]);
      i += 1;
    }
  }
  
  private String hC(String paramString)
  {
    try
    {
      String str = String.format("%032x", new Object[] { new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes())) });
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return paramString;
  }
  
  public void add(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = hC(paramString);
      SimpleHash[] arrayOfSimpleHash = this.func;
      int j = arrayOfSimpleHash.length;
      int i = 0;
      while (i < j)
      {
        SimpleHash localSimpleHash = arrayOfSimpleHash[i];
        this.bits.set(localSimpleHash.hash(paramString), true);
        i += 1;
      }
    }
  }
  
  public boolean contains(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = hC(paramString);
    SimpleHash[] arrayOfSimpleHash = this.func;
    int j = arrayOfSimpleHash.length;
    int i = 0;
    boolean bool = true;
    if (i < j)
    {
      SimpleHash localSimpleHash = arrayOfSimpleHash[i];
      if ((bool) && (this.bits.get(localSimpleHash.hash(paramString)))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    return bool;
  }
  
  public static class SimpleHash
    implements Serializable
  {
    private int cap;
    private int seed;
    
    public SimpleHash(int paramInt1, int paramInt2)
    {
      this.cap = paramInt1;
      this.seed = paramInt2;
    }
    
    public int hash(String paramString)
    {
      int i = 0;
      int k = paramString.length();
      int j = 0;
      while (i < k)
      {
        j = j * this.seed + paramString.charAt(i);
        i += 1;
      }
      return this.cap - 1 & j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter
 * JD-Core Version:    0.7.0.1
 */