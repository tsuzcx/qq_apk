package com.tencent.mobileqq.earlydownload.xmldata;

import afel;
import affq;
import com.tencent.mobileqq.persistence.Entity;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class XmlData
  extends Entity
{
  public static final int STATE_LOADING = 2;
  public static final int STATE_NONE = 0;
  public static final int STATE_SUCCESS = 1;
  @affq(aje=true, save=false)
  public String MD5;
  @affq(aje=true, save=true)
  public boolean StoreBackup;
  @affq(aje=true, save=true)
  public int Version;
  public long downSize;
  @affq(aje=false, save=true)
  public boolean hasResDownloaded;
  public boolean isUserClick;
  @affq(aje=true, save=true)
  public boolean load2G;
  @affq(aje=true, save=true)
  public boolean load3G;
  @affq(aje=false, save=true)
  public int loadState;
  @affq(aje=true, save=true)
  public boolean loadWifi;
  @affq(aje=true, save=true)
  public boolean net_2_2G;
  @affq(aje=true, save=true)
  public boolean net_2_3G;
  @affq(aje=true, save=true)
  public boolean net_2_wifi;
  @affq(aje=true, save=true)
  public boolean notPreDownloadInLowEndPhone;
  public int reqLoadCount;
  public String strLog;
  @affq(aje=true, save=true)
  public String strPkgName;
  @affq(aje=true, save=true)
  public String strResName;
  @affq(aje=true, save=false)
  public String strResURL_big;
  @affq(aje=true, save=false)
  public String strResURL_small;
  @affq(aje=false, save=true)
  public long tLoadFail;
  public long tStart;
  public long totalSize;
  
  public abstract String getSharedPreferencesName();
  
  public abstract String getStrResName();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (Class localClass = getClass(); localClass != Entity.class; localClass = localClass.getSuperclass())
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        if (Modifier.isStatic(((Field)localObject).getModifiers())) {}
        for (;;)
        {
          i += 1;
          break;
          if (((Field)localObject).isAnnotationPresent(affq.class))
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            String str = ((Field)localObject).getName();
            try
            {
              localObject = ((Field)localObject).get(this);
              localStringBuilder.append(',');
              localStringBuilder.append(str);
              localStringBuilder.append('=');
              localStringBuilder.append(localObject);
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void updateServerInfo(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    Field[] arrayOfField;
    do
    {
      return;
      arrayOfField = afel.b(paramXmlData.getClass());
    } while ((arrayOfField == null) || (arrayOfField.length == 0));
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((localField.isAnnotationPresent(affq.class)) && (((affq)localField.getAnnotation(affq.class)).aje())) {}
      try
      {
        localField.set(this, localField.get(paramXmlData));
        i += 1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.XmlData
 * JD-Core Version:    0.7.0.1
 */