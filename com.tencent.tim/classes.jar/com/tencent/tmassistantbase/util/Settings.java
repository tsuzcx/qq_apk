package com.tencent.tmassistantbase.util;

import com.tencent.tmdownloader.f;
import com.tencent.tmdownloader.internal.storage.table.e;

public class Settings
{
  private e mSetting = new e();
  
  private Settings()
  {
    this.mSetting.a();
  }
  
  public static Settings getInstance()
  {
    return z.a;
  }
  
  public byte[] getBlob(String paramString)
  {
    if (!s.a()) {
      return f.a().a(paramString);
    }
    return this.mSetting.e(paramString);
  }
  
  public boolean getBoolean(String paramString)
  {
    if (!s.a()) {
      return f.a().e(paramString);
    }
    return this.mSetting.a(paramString);
  }
  
  public int getInt(String paramString)
  {
    if (!s.a()) {
      return f.a().d(paramString);
    }
    return this.mSetting.b(paramString);
  }
  
  public long getLong(String paramString)
  {
    if (!s.a()) {
      return f.a().c(paramString);
    }
    return this.mSetting.c(paramString);
  }
  
  public String getString(String paramString)
  {
    if (!s.a()) {
      return f.a().b(paramString);
    }
    return this.mSetting.d(paramString);
  }
  
  public void setBlob(String paramString, byte[] paramArrayOfByte)
  {
    if (!s.a())
    {
      f.a().a(paramString, paramArrayOfByte);
      return;
    }
    this.mSetting.a(paramString, paramArrayOfByte);
  }
  
  public void setBoolean(String paramString, boolean paramBoolean)
  {
    if (!s.a())
    {
      f.a().a(paramString, paramBoolean);
      return;
    }
    this.mSetting.a(paramString, paramBoolean);
  }
  
  public void setInt(String paramString, int paramInt)
  {
    if (!s.a())
    {
      f.a().a(paramString, paramInt);
      return;
    }
    this.mSetting.a(paramString, paramInt);
  }
  
  public void setLong(String paramString, long paramLong)
  {
    if (!s.a())
    {
      f.a().a(paramString, paramLong);
      return;
    }
    this.mSetting.a(paramString, paramLong);
  }
  
  public void setString(String paramString1, String paramString2)
  {
    if (!s.a())
    {
      f.a().a(paramString1, paramString2);
      return;
    }
    this.mSetting.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.Settings
 * JD-Core Version:    0.7.0.1
 */