package com.tencent.qqmini.sdk.utils;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
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
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtJsonPbUtil
{
  private static final String TAG = "GdtJsonPbUtil";
  
  private static void addOfPB(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
    {
      QMLog.e("GdtJsonPbUtil", "addOfPB error");
      return;
    }
    Method localMethod = null;
    for (;;)
    {
      try
      {
        if ((paramObject1 instanceof PBRepeatMessageField))
        {
          localMethod = PBRepeatMessageField.class.getDeclaredMethod("add", new Class[] { MessageMicro.class });
          if (localMethod != null) {
            break;
          }
          QMLog.e("GdtJsonPbUtil", "addOfPB error");
          return;
        }
      }
      catch (Throwable paramObject1)
      {
        QMLog.e("GdtJsonPbUtil", "addOfPB", paramObject1);
        return;
      }
      if ((paramObject1 instanceof PBRepeatField)) {
        localMethod = PBRepeatField.class.getDeclaredMethod("add", new Class[] { Object.class });
      }
    }
    localMethod.invoke(paramObject1, new Object[] { paramObject2 });
  }
  
  private static Object getOfPB(Object paramObject)
  {
    if (paramObject == null)
    {
      QMLog.e("GdtJsonPbUtil", "getOfPB error");
      return null;
    }
    try
    {
      paramObject = paramObject.getClass().getMethod("get", new Class[] { Void.class }).invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QMLog.e("GdtJsonPbUtil", "getOfPB", paramObject);
    }
    return null;
  }
  
  private static Class getValueClassOfPBField(Class paramClass)
  {
    if (paramClass == null)
    {
      QMLog.e("GdtJsonPbUtil", "getValueClassOfPBField error");
      return null;
    }
    try
    {
      paramClass = paramClass.getMethod("get", new Class[0]).getReturnType();
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      QMLog.e("GdtJsonPbUtil", "getValueClassOfPBField", paramClass);
    }
    return null;
  }
  
  private static boolean isPBMessage(Class paramClass)
  {
    return (paramClass != null) && (paramClass.getSuperclass() == MessageMicro.class) && (!isPBRepeat(paramClass));
  }
  
  private static boolean isPBPrimitive(Class paramClass)
  {
    return (paramClass == PBBoolField.class) || (paramClass == PBDoubleField.class) || (paramClass == PBEnumField.class) || (paramClass == PBFixed32Field.class) || (paramClass == PBFixed64Field.class) || (paramClass == PBFloatField.class) || (paramClass == PBInt32Field.class) || (paramClass == PBInt64Field.class) || (paramClass == PBSFixed32Field.class) || (paramClass == PBSFixed64Field.class) || (paramClass == PBSInt32Field.class) || (paramClass == PBSInt64Field.class) || (paramClass == PBStringField.class) || (paramClass == PBUInt32Field.class) || (paramClass == PBUInt64Field.class);
  }
  
  private static boolean isPBRepeat(Class paramClass)
  {
    return (paramClass == PBRepeatField.class) || (paramClass == PBRepeatMessageField.class);
  }
  
  public static PBField pbFromJson(PBField paramPBField, Object paramObject)
  {
    if ((paramPBField == null) || (paramPBField.getClass() == PBBytesField.class) || (paramObject == null) || (paramObject == JSONObject.NULL))
    {
      QMLog.e("GdtJsonPbUtil", "pbFromJson error");
      return null;
    }
    if (isPBPrimitive(paramPBField.getClass())) {
      return pbPrimitiveFromJsonPrimitive((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField), paramObject);
    }
    if ((isPBRepeat(paramPBField.getClass())) && ((paramObject instanceof JSONArray))) {
      return pbRepeatFromJsonArray(paramPBField, (JSONArray)JSONArray.class.cast(paramObject));
    }
    if ((isPBMessage(paramPBField.getClass())) && ((paramObject instanceof JSONObject))) {
      return pbMessageFromJsonObject((MessageMicro)MessageMicro.class.cast(paramPBField), (JSONObject)JSONObject.class.cast(paramObject));
    }
    QMLog.e("GdtJsonPbUtil", "pbFromJson error");
    return null;
  }
  
  /* Error */
  private static MessageMicro pbMessageFromJsonObject(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +24 -> 25
    //   4: aload_0
    //   5: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: invokestatic 145	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:isPBMessage	(Ljava/lang/Class;)Z
    //   11: ifeq +14 -> 25
    //   14: aload_1
    //   15: ifnull +10 -> 25
    //   18: aload_1
    //   19: getstatic 124	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   22: if_acmpne +12 -> 34
    //   25: ldc 8
    //   27: ldc 159
    //   29: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   38: invokevirtual 163	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 167	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   46: astore_3
    //   47: aload_3
    //   48: invokeinterface 173 1 0
    //   53: ifeq +230 -> 283
    //   56: ldc 175
    //   58: aload_3
    //   59: invokeinterface 178 1 0
    //   64: invokevirtual 133	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 175	java/lang/String
    //   70: astore 5
    //   72: aload 5
    //   74: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifeq +35 -> 112
    //   80: ldc 8
    //   82: ldc 186
    //   84: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -40 -> 47
    //   90: astore_0
    //   91: ldc 8
    //   93: ldc 187
    //   95: aload_0
    //   96: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: ldc 8
    //   104: ldc 187
    //   106: aload_0
    //   107: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: aconst_null
    //   111: areturn
    //   112: aload_1
    //   113: aload 5
    //   115: invokevirtual 190	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   118: astore 4
    //   120: aload 4
    //   122: ifnull -75 -> 47
    //   125: aload 4
    //   127: getstatic 124	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   130: if_acmpeq -83 -> 47
    //   133: aload_0
    //   134: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   137: aload 5
    //   139: invokevirtual 194	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   142: astore 6
    //   144: aload 6
    //   146: invokevirtual 199	java/lang/reflect/Field:isAccessible	()Z
    //   149: istore_2
    //   150: aload 6
    //   152: iconst_1
    //   153: invokevirtual 203	java/lang/reflect/Field:setAccessible	(Z)V
    //   156: aload 6
    //   158: aload_0
    //   159: invokevirtual 205	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: astore 5
    //   164: aload 6
    //   166: iload_2
    //   167: invokevirtual 203	java/lang/reflect/Field:setAccessible	(Z)V
    //   170: aload 5
    //   172: instanceof 207
    //   175: ifne +55 -> 230
    //   178: ldc 8
    //   180: ldc 186
    //   182: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -138 -> 47
    //   188: astore 4
    //   190: ldc 8
    //   192: ldc 187
    //   194: aload 4
    //   196: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: goto -152 -> 47
    //   202: astore 4
    //   204: ldc 8
    //   206: ldc 187
    //   208: aload 4
    //   210: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: goto -166 -> 47
    //   216: astore 4
    //   218: ldc 8
    //   220: ldc 187
    //   222: aload 4
    //   224: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: goto -180 -> 47
    //   230: ldc 207
    //   232: aload 5
    //   234: invokevirtual 133	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: checkcast 207	com/tencent/mobileqq/pb/PBField
    //   240: aload 4
    //   242: invokestatic 209	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:pbFromJson	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   245: astore 4
    //   247: aload 4
    //   249: ifnonnull +13 -> 262
    //   252: ldc 8
    //   254: ldc 186
    //   256: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -212 -> 47
    //   262: aload 5
    //   264: aload 4
    //   266: invokestatic 211	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:getOfPB	(Ljava/lang/Object;)Ljava/lang/Object;
    //   269: aload 5
    //   271: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   274: invokestatic 213	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:getValueClassOfPBField	(Ljava/lang/Class;)Ljava/lang/Class;
    //   277: invokestatic 217	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:setOfPB	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)V
    //   280: goto -233 -> 47
    //   283: aload_0
    //   284: instanceof 33
    //   287: ifeq +13 -> 300
    //   290: ldc 33
    //   292: aload_0
    //   293: invokevirtual 133	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: checkcast 33	com/tencent/mobileqq/pb/MessageMicro
    //   299: areturn
    //   300: ldc 8
    //   302: ldc 186
    //   304: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramMessageMicro	MessageMicro
    //   0	309	1	paramJSONObject	JSONObject
    //   149	18	2	bool	boolean
    //   46	13	3	localIterator	Iterator
    //   118	8	4	localObject1	Object
    //   188	7	4	localJSONException	JSONException
    //   202	7	4	localNoSuchFieldException	NoSuchFieldException
    //   216	25	4	localIllegalAccessException	IllegalAccessException
    //   245	20	4	localPBField	PBField
    //   70	200	5	localObject2	Object
    //   142	23	6	localField	Field
    // Exception table:
    //   from	to	target	type
    //   34	42	90	java/lang/InstantiationException
    //   34	42	101	java/lang/IllegalAccessException
    //   112	120	188	org/json/JSONException
    //   133	170	202	java/lang/NoSuchFieldException
    //   133	170	216	java/lang/IllegalAccessException
  }
  
  private static JSONObject pbMessageToJson(MessageMicro paramMessageMicro)
  {
    if (paramMessageMicro == null) {}
    Field[] arrayOfField;
    do
    {
      return null;
      arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    } while (arrayOfField == null);
    JSONObject localJSONObject = new JSONObject();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {}
      for (;;)
      {
        i += 1;
        break;
        boolean bool = ((Field)localObject1).isAccessible();
        ((Field)localObject1).setAccessible(true);
        String str = ((Field)localObject1).getName();
        Object localObject2;
        try
        {
          localObject2 = ((Field)localObject1).get(paramMessageMicro);
          ((Field)localObject1).setAccessible(bool);
          if (((Modifier.isStatic(((Field)localObject1).getModifiers())) || (Modifier.isFinal(((Field)localObject1).getModifiers()))) && (localObject2 != null) && ((localObject2.getClass() == Integer.TYPE) || (localObject2.getClass() == Integer.class))) {
            continue;
          }
          if ((localObject2 instanceof PBField)) {
            break label177;
          }
          QMLog.e("GdtJsonPbUtil", "pbMessagebToJson error");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          QMLog.e("GdtJsonPbUtil", "pbMessagebToJson", localIllegalAccessException);
        }
        continue;
        label177:
        localObject1 = pbToJson((PBField)PBField.class.cast(localObject2));
        if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
          try
          {
            localJSONObject.put(localIllegalAccessException, localObject1);
          }
          catch (JSONException localJSONException)
          {
            QMLog.e("GdtJsonPbUtil", "pbMessagebToJson", localJSONException);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private static Object pbPrimitiveFieldToJson(PBPrimitiveField<?> paramPBPrimitiveField)
  {
    Object localObject1;
    if ((paramPBPrimitiveField == null) || ((paramPBPrimitiveField instanceof PBBytesField)) || (!paramPBPrimitiveField.has())) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = getOfPB(paramPBPrimitiveField);
      if (((paramPBPrimitiveField instanceof PBFixed64Field)) || ((paramPBPrimitiveField instanceof PBInt64Field)) || ((paramPBPrimitiveField instanceof PBSFixed64Field)) || ((paramPBPrimitiveField instanceof PBSInt64Field))) {
        break;
      }
      localObject1 = localObject2;
    } while (!(paramPBPrimitiveField instanceof PBUInt64Field));
    if (localObject2 == null) {
      return "";
    }
    try
    {
      paramPBPrimitiveField = String.valueOf(localObject2);
      return paramPBPrimitiveField;
    }
    catch (Throwable paramPBPrimitiveField)
    {
      QMLog.e("GdtJsonPbUtil", "pbPrimitiveFieldToJson", paramPBPrimitiveField);
    }
    return "";
  }
  
  private static PBPrimitiveField pbPrimitiveFromJsonPrimitive(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    if ((paramPBPrimitiveField == null) || (!isPBPrimitive(paramPBPrimitiveField.getClass())) || (paramObject == null) || (paramObject == JSONObject.NULL))
    {
      QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
      return null;
    }
    try
    {
      if ((paramPBPrimitiveField instanceof PBBoolField)) {
        paramObject = PBField.initBool(Boolean.parseBoolean(paramObject.toString()));
      }
      for (;;)
      {
        if ((paramObject != null) && (paramObject.getClass() == paramPBPrimitiveField.getClass())) {
          return paramObject;
        }
        QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
        return null;
        if ((paramPBPrimitiveField instanceof PBDoubleField))
        {
          paramObject = PBField.initDouble(Double.parseDouble(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBEnumField))
        {
          paramObject = PBField.initEnum(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBFixed32Field))
        {
          paramObject = PBField.initFixed32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBFixed64Field))
        {
          paramObject = PBField.initFixed64(Long.parseLong(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBFloatField))
        {
          paramObject = PBField.initFloat(Float.parseFloat(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBInt32Field))
        {
          paramObject = PBField.initInt32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBInt64Field))
        {
          paramObject = PBField.initInt64(Long.parseLong(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSFixed32Field))
        {
          paramObject = PBField.initSFixed32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSFixed64Field))
        {
          paramObject = PBField.initSFixed64(Long.parseLong(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSInt32Field))
        {
          paramObject = PBField.initSInt32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSInt64Field))
        {
          paramObject = PBField.initSInt64(Long.parseLong(paramObject.toString()));
        }
        else if (((paramPBPrimitiveField instanceof PBStringField)) && (paramObject.getClass() == String.class))
        {
          paramObject = PBField.initString((String)String.class.cast(paramObject));
        }
        else if ((paramPBPrimitiveField instanceof PBUInt32Field))
        {
          paramObject = PBField.initUInt32(Integer.parseInt(paramObject.toString()));
        }
        else
        {
          if (!(paramPBPrimitiveField instanceof PBUInt64Field)) {
            break;
          }
          paramObject = PBField.initUInt64(Long.parseLong(paramObject.toString()));
        }
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive", paramObject);
        paramObject = null;
      }
    }
    return paramObject;
  }
  
  private static PBField pbRepeatFromJsonArray(PBField paramPBField, JSONArray paramJSONArray)
  {
    if ((paramPBField == null) || (paramJSONArray == null) || (paramJSONArray == JSONObject.NULL))
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
      return null;
    }
    try
    {
      localField = paramPBField.getClass().getDeclaredField("helper");
      bool = localField.isAccessible();
      localField.setAccessible(true);
      paramPBField = localField.get(paramPBField);
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      for (;;)
      {
        Field localField;
        boolean bool;
        paramPBField = null;
        QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", localNoSuchFieldException1);
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      for (;;)
      {
        label79:
        paramPBField = null;
        QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", localIllegalAccessException1);
        continue;
        if ((!(paramPBField instanceof Class)) || (((Class)paramPBField).getSuperclass() != MessageMicro.class)) {
          break label433;
        }
        try
        {
          paramPBField = ((Class)Class.class.cast(paramPBField)).newInstance();
          if (!(paramPBField instanceof MessageMicro)) {
            break label433;
          }
          paramPBField = (PBField)MessageMicro.class.cast(paramPBField);
        }
        catch (InstantiationException paramPBField)
        {
          for (;;)
          {
            QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
            paramPBField = null;
          }
        }
        catch (IllegalAccessException paramPBField)
        {
          for (;;)
          {
            QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
            paramPBField = null;
          }
        }
      }
      if (isPBPrimitive(paramPBField.getClass())) {}
      PBRepeatMessageField localPBRepeatMessageField;
      for (;;)
      {
        try
        {
          Object localObject1 = paramPBField.getClass().getField("__repeatHelper__").get(paramPBField);
          if (!(localObject1 instanceof PBField)) {
            break label427;
          }
          localObject1 = PBField.initRepeat((PBField)PBField.class.cast(localObject1));
          if (localObject1 != null) {
            break;
          }
          QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
          return null;
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", localNoSuchFieldException2);
          Object localObject2 = null;
          continue;
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", localIllegalAccessException2);
          localPBRepeatMessageField = null;
          continue;
        }
        if (!isPBMessage(paramPBField.getClass())) {
          break label421;
        }
        localPBRepeatMessageField = PBField.initRepeatMessage(((MessageMicro)MessageMicro.class.cast(paramPBField)).getClass());
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONArray.length()) {
          break label408;
        }
        try
        {
          Object localObject4 = paramJSONArray.get(i);
          if (localObject4 != null) {
            if (localObject4 != JSONObject.NULL) {
              break;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", localJSONException);
            continue;
            addOfPB(localPBRepeatMessageField, getOfPB(pbFromJson(paramPBField, localJSONException)));
          }
        }
        i += 1;
      }
      return localPBRepeatMessageField;
    }
    try
    {
      localField.setAccessible(bool);
      if (!(paramPBField instanceof PBField)) {
        break label127;
      }
      paramPBField = (PBField)PBField.class.cast(paramPBField);
    }
    catch (IllegalAccessException localIllegalAccessException3)
    {
      break label114;
    }
    catch (NoSuchFieldException localNoSuchFieldException3)
    {
      break label97;
      Object localObject3 = null;
      break label258;
      localObject3 = null;
      break label258;
      paramPBField = null;
      break label79;
    }
    if (paramPBField == null)
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
      return null;
    }
  }
  
  private static JSONArray pbRepeatToJson(PBField paramPBField)
  {
    if ((paramPBField == null) || (!isPBRepeat(paramPBField.getClass()))) {
      return null;
    }
    paramPBField = getOfPB(paramPBField);
    if (paramPBField == null) {
      return null;
    }
    if (!(paramPBField instanceof List))
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    paramPBField = (List)List.class.cast(paramPBField);
    if (paramPBField == null)
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramPBField.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      paramPBField = localObject;
      if ((localObject instanceof PBField)) {
        paramPBField = pbToJson((PBField)PBField.class.cast(localObject));
      }
      if ((paramPBField != null) && (paramPBField != JSONObject.NULL)) {
        localJSONArray.put(paramPBField);
      }
    }
    return localJSONArray;
  }
  
  public static Object pbToJson(PBField paramPBField)
  {
    if (paramPBField == null)
    {
      QMLog.e("GdtJsonPbUtil", "pbToJson error");
      return null;
    }
    if (isPBPrimitive(paramPBField.getClass())) {
      return pbPrimitiveFieldToJson((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField));
    }
    if (isPBRepeat(paramPBField.getClass())) {
      return pbRepeatToJson(paramPBField);
    }
    if (isPBMessage(paramPBField.getClass())) {
      return pbMessageToJson((MessageMicro)MessageMicro.class.cast(paramPBField));
    }
    QMLog.e("GdtJsonPbUtil", "pbToJson error, " + paramPBField.getClass().getName() + " is not supported");
    return null;
  }
  
  private static void setOfPB(Object paramObject1, Object paramObject2, Class paramClass)
  {
    if ((paramObject1 == null) || (paramObject2 == null) || (paramClass == null))
    {
      QMLog.e("GdtJsonPbUtil", "setOfPB error");
      return;
    }
    try
    {
      paramObject1.getClass().getMethod("set", new Class[] { paramClass }).invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Throwable paramObject1)
    {
      QMLog.e("GdtJsonPbUtil", "setOfPB", paramObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.GdtJsonPbUtil
 * JD-Core Version:    0.7.0.1
 */