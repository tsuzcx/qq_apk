package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private Bundle a(String paramString, Bundle paramBundle, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    a(paramString, paramObject, localBundle);
    paramBundle.putBundle("_next_item_", localBundle);
    return localBundle;
  }
  
  private Object a(Field paramField, Bundle paramBundle)
  {
    String str = paramField.getName();
    Object localObject = paramBundle.get(str);
    paramBundle = localObject;
    if ((localObject instanceof Bundle)) {
      try
      {
        paramBundle = (Bundle)localObject;
        int i = paramBundle.getInt("_val_type_", -1);
        if (i == 1) {
          return a(paramField.getGenericType(), paramBundle);
        }
        paramBundle = localObject;
        if (i == 0)
        {
          paramField = (IMessageEntity)paramField.getType().newInstance();
          paramField = a((Bundle)localObject, paramField);
          return paramField;
        }
      }
      catch (Exception paramField)
      {
        Log.e("MessageCodec", "decode, read value of the field exception, field name: " + str);
        paramBundle = null;
      }
    }
    return paramBundle;
  }
  
  private void a(IMessageEntity paramIMessageEntity, Field paramField, Bundle paramBundle)
    throws IllegalAccessException
  {
    paramBundle = a(paramField, paramBundle);
    if (paramBundle != null)
    {
      boolean bool = paramField.isAccessible();
      paramField.setAccessible(true);
      paramField.set(paramIMessageEntity, paramBundle);
      paramField.setAccessible(bool);
    }
  }
  
  private void b(IMessageEntity paramIMessageEntity, Field paramField, Bundle paramBundle)
    throws IllegalAccessException
  {
    boolean bool = paramField.isAccessible();
    paramField.setAccessible(true);
    a(paramField.getName(), paramField.get(paramIMessageEntity), paramBundle);
    paramField.setAccessible(bool);
  }
  
  private boolean b(String paramString, Object paramObject, Bundle paramBundle)
  {
    if ((paramObject instanceof String)) {
      paramBundle.putString(paramString, (String)paramObject);
    }
    for (;;)
    {
      return true;
      if ((paramObject instanceof Integer))
      {
        paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
      }
      else if ((paramObject instanceof Short))
      {
        paramBundle.putShort(paramString, ((Short)paramObject).shortValue());
      }
      else if ((paramObject instanceof Long))
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      }
      else if ((paramObject instanceof Float))
      {
        paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
      }
      else if ((paramObject instanceof Double))
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      }
    }
    return false;
  }
  
  public Bundle a(IMessageEntity paramIMessageEntity, Bundle paramBundle)
  {
    Class localClass = paramIMessageEntity.getClass();
    for (;;)
    {
      if (localClass != null)
      {
        Field[] arrayOfField = localClass.getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        Field localField;
        if (i < j)
        {
          localField = arrayOfField[i];
          if (!localField.isAnnotationPresent(Packed.class)) {}
        }
        try
        {
          b(paramIMessageEntity, localField, paramBundle);
          i += 1;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            Log.e("MessageCodec", "encode, get value of the field exception, field name: " + localField.getName());
          }
          localClass = localClass.getSuperclass();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          label64:
          break label64;
        }
      }
    }
    return paramBundle;
  }
  
  public IMessageEntity a(Bundle paramBundle, IMessageEntity paramIMessageEntity)
  {
    if (paramBundle == null) {
      return paramIMessageEntity;
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    Class localClass = paramIMessageEntity.getClass();
    while (localClass != null)
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      Field localField;
      if (i < j)
      {
        localField = arrayOfField[i];
        if (!localField.isAnnotationPresent(Packed.class)) {}
      }
      try
      {
        a(paramIMessageEntity, localField, paramBundle);
        i += 1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.e("MessageCodec", "decode, set value of the field exception, field name:" + localField.getName());
        }
        localClass = localClass.getSuperclass();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label81:
        break label81;
      }
    }
  }
  
  protected List<Object> a(Type paramType, Bundle paramBundle)
    throws InstantiationException, IllegalAccessException
  {
    ArrayList localArrayList = new ArrayList();
    paramBundle = paramBundle.getBundle("_next_item_");
    if (paramBundle != null)
    {
      Object localObject = paramBundle.get("_value_");
      if ((localObject.getClass().isPrimitive()) || ((localObject instanceof String)) || ((localObject instanceof Serializable))) {
        localArrayList.add(localObject);
      }
      for (;;)
      {
        paramBundle = paramBundle.getBundle("_next_item_");
        break;
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          int i = ((Bundle)localObject).getInt("_val_type_", -1);
          if (i == 1) {
            throw new InstantiationException("Nested List can not be supported");
          }
          if (i != 0) {
            break label155;
          }
          localArrayList.add(a((Bundle)localObject, (IMessageEntity)((Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance()));
        }
      }
      label155:
      throw new InstantiationException("Unknown type can not be supported");
    }
    return localArrayList;
  }
  
  protected void a(String paramString, Object paramObject, Bundle paramBundle)
  {
    if (paramObject == null) {}
    while (b(paramString, paramObject, paramBundle)) {
      return;
    }
    if ((paramObject instanceof CharSequence))
    {
      paramBundle.putCharSequence(paramString, (CharSequence)paramObject);
      return;
    }
    if ((paramObject instanceof Parcelable))
    {
      paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramBundle.putByteArray(paramString, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof List))
    {
      a(paramString, (List)paramObject, paramBundle);
      return;
    }
    if ((paramObject instanceof Serializable))
    {
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
      return;
    }
    if ((paramObject instanceof IMessageEntity))
    {
      paramObject = a((IMessageEntity)paramObject, new Bundle());
      paramObject.putInt("_val_type_", 0);
      paramBundle.putBundle(paramString, paramObject);
      return;
    }
    Log.e("MessageCodec", "cannot support type, " + paramString);
  }
  
  protected void a(String paramString, List paramList, Bundle paramBundle)
  {
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    for (paramList = (List)localObject1; localIterator.hasNext(); paramList = a("_value_", (Bundle)localObject1, localObject2))
    {
      localObject2 = localIterator.next();
      localObject1 = paramList;
      if (paramList == null)
      {
        localObject1 = new Bundle();
        paramBundle.putBundle(paramString, (Bundle)localObject1);
        ((Bundle)localObject1).putInt("_val_type_", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.core.aidl.e
 * JD-Core Version:    0.7.0.1
 */