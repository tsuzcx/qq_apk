package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class IAutoDBItem
  implements MDBItem
{
  public static final String COL_ROWID = "rowid";
  public static final String FIELD_PREFIX = "field_";
  public static final String SYSTEM_ROWID_FIELD = "rowid";
  public long systemRowid = -1L;
  
  private static String[] a(Field[] paramArrayOfField)
  {
    String[] arrayOfString = new String[paramArrayOfField.length + 1];
    int i = 0;
    if (i < paramArrayOfField.length)
    {
      arrayOfString[i] = getColName(paramArrayOfField[i]);
      String str = "getFullColumns failed:" + paramArrayOfField[i].getName();
      if (!Util.isNullOrNil(arrayOfString[i])) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(str, bool);
        i += 1;
        break;
      }
    }
    arrayOfString[paramArrayOfField.length] = "rowid";
    return arrayOfString;
  }
  
  private static Map<String, String> b(Field[] paramArrayOfField)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramArrayOfField.length)
    {
      Object localObject = paramArrayOfField[i];
      String str = CursorFieldHelper.type(((Field)localObject).getType());
      if (str == null) {
        Log.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + ((Field)localObject).getName() + ", skipped");
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = getColName((Field)localObject);
        if (!Util.isNullOrNil((String)localObject)) {
          localHashMap.put(localObject, str);
        }
      }
    }
    return localHashMap;
  }
  
  private static String c(Field[] paramArrayOfField)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Field localField;
    Object localObject;
    String str2;
    String str1;
    if (i < paramArrayOfField.length)
    {
      localField = paramArrayOfField[i];
      localObject = CursorFieldHelper.type(localField.getType());
      if (localObject == null) {
        Log.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + localField.getName() + ", skipped");
      }
      do
      {
        i += 1;
        break;
        str2 = getColName(localField);
      } while (Util.isNullOrNil(str2));
      if (!localField.isAnnotationPresent(MAutoDBFieldAnnotation.class)) {
        break label241;
      }
      str1 = " default '" + ((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).defValue() + "' ";
    }
    for (int j = ((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey();; j = 0)
    {
      localObject = new StringBuilder().append(str2).append(" ").append((String)localObject).append(str1);
      if (j == 1)
      {
        str1 = " PRIMARY KEY ";
        label187:
        localStringBuilder.append(str1);
        if (i != paramArrayOfField.length - 1) {
          break label229;
        }
      }
      label229:
      for (str1 = "";; str1 = ", ")
      {
        localStringBuilder.append(str1);
        break;
        str1 = "";
        break label187;
      }
      return localStringBuilder.toString();
      label241:
      str1 = "";
    }
  }
  
  public static boolean checkIOEqual(ContentValues paramContentValues, Cursor paramCursor)
  {
    if (paramContentValues == null) {
      return paramCursor == null;
    }
    if ((paramCursor == null) || (paramCursor.getCount() != 1)) {
      return false;
    }
    paramCursor.moveToFirst();
    int k = paramCursor.getColumnCount();
    int j = paramContentValues.size();
    int i = j;
    if (paramContentValues.containsKey("rowid")) {
      i = j - 1;
    }
    j = k;
    if (paramCursor.getColumnIndex("rowid") != -1) {
      j = k - 1;
    }
    if (i != j) {
      return false;
    }
    label216:
    label346:
    label353:
    label356:
    for (;;)
    {
      Object localObject;
      byte[] arrayOfByte;
      try
      {
        Iterator localIterator = paramContentValues.valueSet().iterator();
        if (localIterator.hasNext())
        {
          localObject = (String)((Map.Entry)localIterator.next()).getKey();
          if (((String)localObject).equals("rowid")) {
            continue;
          }
          i = paramCursor.getColumnIndex((String)localObject);
          if (i == -1) {
            return false;
          }
          if ((paramContentValues.get((String)localObject) instanceof byte[]))
          {
            localObject = (byte[])paramContentValues.get((String)localObject);
            arrayOfByte = paramCursor.getBlob(i);
            if (localObject != null) {
              break label308;
            }
            if (arrayOfByte == null) {
              break label353;
            }
            break label308;
            if (localObject.length == arrayOfByte.length) {
              break label341;
            }
            i = 0;
            break label320;
            if (i >= localObject.length) {
              break label353;
            }
            if (localObject[i] == arrayOfByte[i]) {
              break label346;
            }
            i = 0;
            break label320;
          }
          if ((paramCursor.getString(i) == null) && (paramContentValues.get((String)localObject) != null)) {
            return false;
          }
          if (paramContentValues.get((String)localObject) == null) {
            return false;
          }
          boolean bool = paramContentValues.get((String)localObject).toString().equals(paramCursor.getString(i));
          if (bool) {
            continue;
          }
          return false;
        }
      }
      catch (Exception paramContentValues)
      {
        paramContentValues.printStackTrace();
        return false;
      }
      return true;
      if ((localObject == null) && (arrayOfByte != null)) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label356;
        }
        return false;
        if ((localObject == null) || (arrayOfByte != null)) {
          break;
        }
        i = 0;
        continue;
        i = 0;
        break label216;
        i += 1;
        break label216;
        i = 1;
      }
    }
  }
  
  public static String getColName(Field paramField)
  {
    if (paramField == null) {}
    do
    {
      return null;
      paramField = paramField.getName();
    } while ((paramField == null) || (paramField.length() <= 0));
    if (paramField.startsWith("field_")) {
      return paramField.substring(6);
    }
    return paramField;
  }
  
  public static Cursor getCursorForProjection(ContentValues paramContentValues, String[] paramArrayOfString)
  {
    Object[] arrayOfObject = new Object[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramContentValues.get(paramArrayOfString[i]);
      i += 1;
    }
    paramContentValues = new MatrixCursor(paramArrayOfString);
    paramContentValues.addRow(arrayOfObject);
    return paramContentValues;
  }
  
  public static Field[] getValidFields(Class<?> paramClass)
  {
    return initAutoDBInfo(paramClass).fields;
  }
  
  public static MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    MAutoDBInfo localMAutoDBInfo = new MAutoDBInfo();
    LinkedList localLinkedList = new LinkedList();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Field localField = arrayOfField[i];
      int k = localField.getModifiers();
      String str = localField.getName();
      if ((str != null) && (Modifier.isPublic(k)) && (!Modifier.isFinal(k)))
      {
        if (!str.startsWith("field_")) {
          break label166;
        }
        paramClass = str.substring(6);
        label91:
        if (!localField.isAnnotationPresent(MAutoDBFieldAnnotation.class)) {
          break label172;
        }
        if (((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey() == 1) {
          localMAutoDBInfo.primaryKey = paramClass;
        }
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramClass))
        {
          if (paramClass.equals("rowid")) {
            Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
          }
          localLinkedList.add(localField);
        }
        label166:
        label172:
        do
        {
          i += 1;
          break;
          paramClass = str;
          break label91;
        } while (!str.startsWith("field_"));
      }
    }
    localMAutoDBInfo.fields = ((Field[])localLinkedList.toArray(new Field[0]));
    localMAutoDBInfo.columns = a(localMAutoDBInfo.fields);
    localMAutoDBInfo.colsMap = b(localMAutoDBInfo.fields);
    localMAutoDBInfo.sql = c(localMAutoDBInfo.fields);
    return localMAutoDBInfo;
  }
  
  public abstract void convertFrom(Cursor paramCursor);
  
  public abstract ContentValues convertTo();
  
  protected abstract MAutoDBInfo getDBInfo();
  
  public static class MAutoDBInfo
  {
    public Map<String, String> colsMap = new HashMap();
    public String[] columns;
    public Field[] fields;
    public String primaryKey;
    public String sql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.IAutoDBItem
 * JD-Core Version:    0.7.0.1
 */