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
    while (i < paramArrayOfField.length)
    {
      arrayOfString[i] = getColName(paramArrayOfField[i]);
      StringBuilder localStringBuilder = new StringBuilder("getFullColumns failed:");
      localStringBuilder.append(paramArrayOfField[i].getName());
      Assert.assertTrue(localStringBuilder.toString(), Util.isNullOrNil(arrayOfString[i]) ^ true);
      i += 1;
    }
    arrayOfString[paramArrayOfField.length] = "rowid";
    return arrayOfString;
  }
  
  private static Map<String, String> b(Field[] paramArrayOfField)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfField.length)
    {
      Object localObject1 = paramArrayOfField[i];
      Object localObject2 = CursorFieldHelper.type(((Field)localObject1).getType());
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder("failed identify on column: ");
        ((StringBuilder)localObject2).append(((Field)localObject1).getName());
        ((StringBuilder)localObject2).append(", skipped");
        Log.e("MicroMsg.SDK.IAutoDBItem", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = getColName((Field)localObject1);
        if (!Util.isNullOrNil((String)localObject1)) {
          localHashMap.put(localObject1, localObject2);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private static String c(Field[] paramArrayOfField)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfField.length)
    {
      Object localObject2 = paramArrayOfField[i];
      String str1 = CursorFieldHelper.type(((Field)localObject2).getType());
      Object localObject1;
      if (str1 == null)
      {
        localObject1 = new StringBuilder("failed identify on column: ");
        ((StringBuilder)localObject1).append(((Field)localObject2).getName());
        ((StringBuilder)localObject1).append(", skipped");
        Log.e("MicroMsg.SDK.IAutoDBItem", ((StringBuilder)localObject1).toString());
      }
      else
      {
        String str2 = getColName((Field)localObject2);
        if (!Util.isNullOrNil(str2))
        {
          localObject1 = "";
          int j;
          if (((Field)localObject2).isAnnotationPresent(MAutoDBFieldAnnotation.class))
          {
            localObject1 = new StringBuilder(" default '");
            ((StringBuilder)localObject1).append(((MAutoDBFieldAnnotation)((Field)localObject2).getAnnotation(MAutoDBFieldAnnotation.class)).defValue());
            ((StringBuilder)localObject1).append("' ");
            localObject1 = ((StringBuilder)localObject1).toString();
            j = ((MAutoDBFieldAnnotation)((Field)localObject2).getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey();
          }
          else
          {
            j = 0;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append((String)localObject1);
          if (j == 1) {
            localObject1 = " PRIMARY KEY ";
          } else {
            localObject1 = "";
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          localStringBuilder.append(((StringBuilder)localObject2).toString());
          if (i == paramArrayOfField.length - 1) {
            localObject1 = "";
          } else {
            localObject1 = ", ";
          }
          localStringBuilder.append((String)localObject1);
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean checkIOEqual(ContentValues paramContentValues, Cursor paramCursor)
  {
    if (paramContentValues == null) {
      return paramCursor == null;
    }
    int i;
    if (paramCursor != null)
    {
      if (paramCursor.getCount() != 1) {
        return false;
      }
      paramCursor.moveToFirst();
      int k = paramCursor.getColumnCount();
      int j = paramContentValues.size();
      i = j;
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
    }
    label304:
    label314:
    label332:
    label337:
    label346:
    do
    {
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
                break label304;
              }
              if (arrayOfByte == null) {
                break;
              }
              break label304;
              if (localObject.length == arrayOfByte.length) {
                break label332;
              }
              break label314;
              if (i >= localObject.length) {
                break;
              }
              if (localObject[i] == arrayOfByte[i]) {
                break label337;
              }
              break label314;
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
          return true;
        }
        catch (Exception paramContentValues)
        {
          paramContentValues.printStackTrace();
        }
        return false;
        if ((localObject == null) && (arrayOfByte != null)) {}
        for (;;)
        {
          i = 0;
          break label346;
          if ((localObject == null) || (arrayOfByte != null)) {
            break;
          }
        }
        i = 0;
        continue;
        i += 1;
      }
      i = 1;
    } while (i != 0);
    return false;
  }
  
  public static String getColName(Field paramField)
  {
    if (paramField == null) {
      return null;
    }
    String str = paramField.getName();
    if (str != null)
    {
      if (str.length() <= 0) {
        return null;
      }
      paramField = str;
      if (str.startsWith("field_")) {
        paramField = str.substring(6);
      }
      return paramField;
    }
    return null;
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
    while (i < j)
    {
      Field localField = arrayOfField[i];
      int k = localField.getModifiers();
      String str = localField.getName();
      if ((str != null) && (Modifier.isPublic(k)) && (!Modifier.isFinal(k)))
      {
        if (str.startsWith("field_")) {
          paramClass = str.substring(6);
        } else {
          paramClass = str;
        }
        if (localField.isAnnotationPresent(MAutoDBFieldAnnotation.class))
        {
          if (((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey() == 1) {
            localMAutoDBInfo.primaryKey = paramClass;
          }
        }
        else {
          if (!str.startsWith("field_")) {
            break label178;
          }
        }
        if (!Util.isNullOrNil(paramClass))
        {
          if (paramClass.equals("rowid")) {
            Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
          }
          localLinkedList.add(localField);
        }
      }
      label178:
      i += 1;
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