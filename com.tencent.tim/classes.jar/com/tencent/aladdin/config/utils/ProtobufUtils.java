package com.tencent.aladdin.config.utils;

import android.util.Log;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.json.JSONArray;
import org.json.JSONObject;

class ProtobufUtils
{
  private static final String TAG = "ProtobufUtils";
  
  static JSONObject getDebugPBMessage(byte[] paramArrayOfByte, Class<? extends MessageMicro> paramClass)
  {
    try
    {
      paramClass = (MessageMicro)paramClass.newInstance();
      paramClass.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = printMessageMicro(paramClass);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("ProtobufUtils", "getDebugPBMessage: ", paramArrayOfByte);
    }
    return new JSONObject();
  }
  
  private static boolean isNumeric(Class paramClass)
  {
    return (Integer.TYPE.isAssignableFrom(paramClass)) || (Float.TYPE.isAssignableFrom(paramClass)) || (Double.TYPE.isAssignableFrom(paramClass)) || (Boolean.TYPE.isAssignableFrom(paramClass)) || (Short.TYPE.isAssignableFrom(paramClass)) || (Byte.TYPE.isAssignableFrom(paramClass)) || (Long.TYPE.isAssignableFrom(paramClass));
  }
  
  private static boolean isPrimitiveJava(Class paramClass)
  {
    return (Number.class.isAssignableFrom(paramClass)) || (Boolean.class.isAssignableFrom(paramClass)) || (Enum.class.isAssignableFrom(paramClass)) || (String.class.isAssignableFrom(paramClass));
  }
  
  private static JSONObject printMessageMicro(MessageMicro paramMessageMicro)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i;
      Field localField;
      Class localClass;
      try
      {
        Field[] arrayOfField = paramMessageMicro.getClass().getFields();
        i = 0;
        if (i < arrayOfField.length)
        {
          localField = arrayOfField[i];
          localClass = localField.getType();
          if (Modifier.isStatic(localField.getModifiers())) {
            break label316;
          }
          if (MessageMicro.class.isAssignableFrom(localClass))
          {
            localJSONObject.put(localField.getName(), printMessageMicro((MessageMicro)localField.get(paramMessageMicro)));
          }
          else if (PBPrimitiveField.class.isAssignableFrom(localClass))
          {
            if (!((PBPrimitiveField)localField.get(paramMessageMicro)).has()) {
              break label316;
            }
            putPrimitiveMessageField(localJSONObject, null, localClass, localField, localField.get(paramMessageMicro));
          }
        }
      }
      catch (Exception paramMessageMicro)
      {
        paramMessageMicro.printStackTrace();
      }
      return localJSONObject;
      if (PBRepeatField.class.isAssignableFrom(localClass))
      {
        if (((PBRepeatField)localField.get(paramMessageMicro)).has()) {
          localJSONObject.put(localField.getName(), printRepeatField(localField.get(paramMessageMicro)));
        }
      }
      else if (PBRepeatMessageField.class.isAssignableFrom(localClass))
      {
        if (((PBRepeatMessageField)localField.get(paramMessageMicro)).has()) {
          localJSONObject.put(localField.getName(), printRepeatMessageField(localField.get(paramMessageMicro)));
        }
      }
      else if (isPrimitiveJava(localClass)) {
        putPrimitiveJavaField(localJSONObject, null, localClass, localField, localField.get(paramMessageMicro));
      } else if (isNumeric(localClass)) {
        putNumericField(localJSONObject, null, localClass, localField, localField.get(paramMessageMicro));
      } else {
        localJSONObject.put(localField.getName(), "\"unknown type\":\"" + localClass.getSimpleName() + "\"");
      }
      label316:
      i += 1;
    }
  }
  
  private static JSONArray printRepeatField(Object paramObject)
  {
    JSONArray localJSONArray = new JSONArray();
    paramObject = (PBRepeatField)paramObject;
    int i = 0;
    if (i < paramObject.size())
    {
      Object localObject = paramObject.get(i);
      if (MessageMicro.class.isAssignableFrom(localObject.getClass())) {
        localJSONArray.put(printMessageMicro((MessageMicro)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if (PBPrimitiveField.class.isAssignableFrom(localObject.getClass()))
        {
          if (((PBPrimitiveField)localObject).has()) {
            putPrimitiveMessageField(null, localJSONArray, localObject.getClass(), null, localObject);
          }
        }
        else if (PBRepeatField.class.isAssignableFrom(localObject.getClass()))
        {
          if (((PBRepeatField)localObject).has()) {
            localJSONArray.put(printRepeatMessageField(localObject));
          }
        }
        else if (PBRepeatMessageField.class.isAssignableFrom(localObject.getClass()))
        {
          if (((PBRepeatMessageField)localObject).has()) {
            localJSONArray.put(printRepeatMessageField(localObject));
          }
        }
        else if (isPrimitiveJava(localObject.getClass())) {
          putPrimitiveJavaField(null, localJSONArray, localObject.getClass(), null, localObject);
        } else if (isNumeric(localObject.getClass())) {
          putNumericField(null, localJSONArray, localObject.getClass(), null, localObject);
        } else {
          localJSONArray.put("\"unknown type\":\"" + localObject.getClass().getSimpleName() + "\"");
        }
      }
    }
    return localJSONArray;
  }
  
  private static JSONArray printRepeatMessageField(Object paramObject)
  {
    JSONArray localJSONArray = new JSONArray();
    paramObject = (PBRepeatMessageField)paramObject;
    int i = 0;
    if (i < paramObject.size())
    {
      MessageMicro localMessageMicro = paramObject.get(i);
      if (MessageMicro.class.isAssignableFrom(localMessageMicro.getClass())) {
        localJSONArray.put(printMessageMicro((MessageMicro)localMessageMicro));
      }
      for (;;)
      {
        i += 1;
        break;
        if (PBPrimitiveField.class.isAssignableFrom(localMessageMicro.getClass()))
        {
          if (((PBPrimitiveField)localMessageMicro).has()) {
            putPrimitiveMessageField(null, localJSONArray, localMessageMicro.getClass(), null, localMessageMicro);
          }
        }
        else if (PBRepeatField.class.isAssignableFrom(localMessageMicro.getClass()))
        {
          if (((PBRepeatField)localMessageMicro).has()) {
            localJSONArray.put(printRepeatField(localMessageMicro));
          }
        }
        else if (PBRepeatMessageField.class.isAssignableFrom(localMessageMicro.getClass()))
        {
          if (((PBRepeatMessageField)localMessageMicro).has()) {
            localJSONArray.put(printRepeatMessageField(localMessageMicro));
          }
        }
        else if (isPrimitiveJava(localMessageMicro.getClass())) {
          putPrimitiveJavaField(null, localJSONArray, localMessageMicro.getClass(), null, localMessageMicro);
        } else if (isNumeric(localMessageMicro.getClass())) {
          putNumericField(null, localJSONArray, localMessageMicro.getClass(), null, localMessageMicro);
        } else {
          localJSONArray.put("\"unknown type\":\"" + localMessageMicro.getClass().getSimpleName() + "\"");
        }
      }
    }
    return localJSONArray;
  }
  
  private static void putNumericField(JSONObject paramJSONObject, JSONArray paramJSONArray, Class paramClass, Field paramField, Object paramObject)
  {
    try
    {
      if (Integer.TYPE.isAssignableFrom(paramClass))
      {
        if (paramField == null)
        {
          paramJSONArray.put((Integer)paramObject);
          return;
        }
        paramJSONObject.put(paramField.getName(), (Integer)paramObject);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    if (Float.TYPE.isAssignableFrom(paramClass))
    {
      if (paramField == null)
      {
        paramJSONArray.put((Float)paramObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), (Float)paramObject);
      return;
    }
    if (Double.TYPE.isAssignableFrom(paramClass))
    {
      if (paramField == null)
      {
        paramJSONArray.put((Double)paramObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), (Double)paramObject);
      return;
    }
    if (Boolean.TYPE.isAssignableFrom(paramClass))
    {
      if (paramField == null)
      {
        paramJSONArray.put((Boolean)paramObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), (Boolean)paramObject);
      return;
    }
    if (Short.TYPE.isAssignableFrom(paramClass))
    {
      if (paramField == null)
      {
        paramJSONArray.put((Short)paramObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), (Short)paramObject);
      return;
    }
    if (Byte.TYPE.isAssignableFrom(paramClass))
    {
      if (paramField == null)
      {
        paramJSONArray.put((Byte)paramObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), (Byte)paramObject);
      return;
    }
    if (Long.TYPE.isAssignableFrom(paramClass))
    {
      if (paramField == null)
      {
        paramJSONArray.put((Long)paramObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), (Long)paramObject);
    }
  }
  
  private static void putPrimitiveJavaField(JSONObject paramJSONObject, JSONArray paramJSONArray, Class paramClass, Field paramField, Object paramObject)
  {
    if (paramField == null) {}
    try
    {
      if ((paramObject instanceof Number)) {}
      for (paramJSONObject = (Number)paramObject;; paramJSONObject = (String)paramObject)
      {
        paramJSONArray.put(paramJSONObject);
        return;
      }
      paramJSONObject.put(paramField.getName(), paramObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    catch (Error paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void putPrimitiveMessageField(JSONObject paramJSONObject, JSONArray paramJSONArray, Class paramClass, Field paramField, Object paramObject)
  {
    try
    {
      if (PBUInt32Field.class.isAssignableFrom(paramClass))
      {
        if (paramField == null)
        {
          paramJSONArray.put(((PBUInt32Field)paramObject).get());
          return;
        }
        paramJSONObject.put(paramField.getName(), ((PBUInt32Field)paramObject).get());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    if (paramClass.isAssignableFrom(PBInt32Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBInt32Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBInt32Field)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBUInt64Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBUInt64Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBUInt64Field)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBInt64Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBInt64Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBInt64Field)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBBytesField.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBBytesField)paramObject).get().toStringUtf8());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBBytesField)paramObject).get().toStringUtf8());
      return;
    }
    if (paramClass.isAssignableFrom(PBBoolField.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBBoolField)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBBoolField)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBDoubleField.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBDoubleField)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBDoubleField)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBEnumField.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBEnumField)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBEnumField)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBStringField.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBStringField)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBStringField)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBFloatField.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBFloatField)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBFloatField)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBSFixed32Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBSFixed32Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBSFixed32Field)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBSFixed64Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBSFixed64Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBSFixed64Field)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBSInt32Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBSInt32Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBSInt32Field)paramObject).get());
      return;
    }
    if (paramClass.isAssignableFrom(PBSInt64Field.class))
    {
      if (paramField == null)
      {
        paramJSONArray.put(((PBSInt64Field)paramObject).get());
        return;
      }
      paramJSONObject.put(paramField.getName(), ((PBSInt64Field)paramObject).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.utils.ProtobufUtils
 * JD-Core Version:    0.7.0.1
 */