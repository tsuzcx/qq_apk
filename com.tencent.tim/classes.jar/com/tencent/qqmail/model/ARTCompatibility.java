package com.tencent.qqmail.model;

import android.util.Log;
import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protocol.ARTConvert;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.utilities.QMUtilities;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ARTCompatibility
{
  private static final String TAG = ARTCompatibility.class.getSimpleName();
  
  public static OnProtocolListener wrap(OnProtocolListener paramOnProtocolListener)
  {
    OnProtocolListener localOnProtocolListener;
    if (paramOnProtocolListener == null) {
      localOnProtocolListener = null;
    }
    do
    {
      return localOnProtocolListener;
      localOnProtocolListener = paramOnProtocolListener;
    } while (!QMUtilities.isOldART());
    return new ARTCompatibility.1(paramOnProtocolListener);
  }
  
  private static void wrap(Object paramObject)
  {
    if (paramObject == null) {}
    Field[] arrayOfField;
    int k;
    int i;
    do
    {
      return;
      arrayOfField = paramObject.getClass().getDeclaredFields();
      k = arrayOfField.length;
      i = 0;
    } while (i >= k);
    Field localField = arrayOfField[i];
    localField.setAccessible(true);
    ConvertFromProtobuf localConvertFromProtobuf;
    Object localObject1;
    int m;
    int j;
    label72:
    Object localObject5;
    if (localField.isAnnotationPresent(ConvertFromProtobuf.class))
    {
      localConvertFromProtobuf = (ConvertFromProtobuf)localField.getAnnotation(ConvertFromProtobuf.class);
      localObject1 = (byte[][])null;
      m = arrayOfField.length;
      j = 0;
      if (j >= m) {
        break label950;
      }
      localObject5 = arrayOfField[j];
      if (!((Field)localObject5).getName().equals("pb_" + localField.getName())) {
        break label334;
      }
    }
    label643:
    label934:
    label950:
    for (;;)
    {
      boolean bool;
      for (;;)
      {
        Object localObject6;
        StringBuilder localStringBuilder;
        try
        {
          bool = ((Field)localObject5).getType().getName().equals("[[B");
          if (!bool) {}
        }
        catch (Exception localException3)
        {
          Object localObject2;
          bool = false;
        }
        try
        {
          localObject2 = (byte[][])((Field)localObject5).get(paramObject);
          localObject1 = null;
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject6;
          localObject6 = TAG;
          localStringBuilder = new StringBuilder().append("replacing: ").append(localField.getName()).append(" from ");
          if (localObject5 == null) {
            break label341;
          }
          localObject5 = ((Field)localObject5).getName();
          Log.d((String)localObject6, (String)localObject5);
          if ((localObject2 != null) || (localObject1 != null)) {
            break label347;
          }
          Log.w(TAG, "buffer: " + localObject2 + ", buffers: " + localObject1);
          i += 1;
        }
        catch (Exception localException4)
        {
          Object localObject3;
          BaseProtoBuf localBaseProtoBuf3;
          BaseProtoBuf localBaseProtoBuf1;
          BaseProtoBuf localBaseProtoBuf2;
          break label315;
        }
      }
      localObject2 = (byte[])((Field)localObject5).get(paramObject);
      localObject6 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject6;
      continue;
      label315:
      QMLog.log(6, TAG, localException3.toString());
      localObject3 = null;
      continue;
      label334:
      j += 1;
      break label72;
      label341:
      localObject5 = null;
      continue;
      label347:
      if (bool) {}
      try
      {
        localObject5 = localField.getType().getComponentType();
        for (;;)
        {
          if ((!bool) || (localObject1 == null)) {
            break label764;
          }
          Log.d(TAG, "field is array: " + localObject1.length + ", " + localField.getName() + ", " + localConvertFromProtobuf.isConvert());
          if (!localConvertFromProtobuf.isConvert()) {
            break label643;
          }
          m = localObject1.length;
          localObject3 = Array.newInstance((Class)localObject5, m);
          j = 0;
          label454:
          if (j < m)
          {
            localObject6 = (ARTConvert)((Class)localObject5).newInstance();
            localStringBuilder = localObject1[j];
            Log.v(TAG, "isconvert buffer size: " + localStringBuilder.length);
            localBaseProtoBuf3 = (BaseProtoBuf)localConvertFromProtobuf.getProtoType().newInstance();
            try
            {
              localBaseProtoBuf3.parseFrom(localStringBuilder);
              ((ARTConvert)localObject6).ART_ParseProto(localBaseProtoBuf3);
              Log.d(TAG, "IsConvert BaseProtoBuf#parseFrom " + localField.getName() + " success.");
              Array.set(localObject3, j, localObject6);
              j += 1;
              break label454;
              localObject5 = localField.getType();
            }
            catch (Exception localException6)
            {
              for (;;)
              {
                QMLog.log(6, TAG, localException6.toString());
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        QMLog.log(6, TAG, localException1.toString());
      }
      localField.set(paramObject, localObject3);
      continue;
      m = localException1.length;
      localObject3 = Array.newInstance((Class)localObject5, m);
      j = 0;
      for (;;)
      {
        if (j < m)
        {
          localObject6 = (BaseProtoBuf)((Class)localObject5).newInstance();
          localConvertFromProtobuf = localException1[j];
          try
          {
            ((BaseProtoBuf)localObject6).parseFrom(localConvertFromProtobuf);
            Array.set(localObject3, j, localObject6);
            j += 1;
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              QMLog.log(6, TAG, "BaseProtoBuf#parseFrom " + localField.getName() + " exception: " + localException5.getMessage());
            }
          }
        }
      }
      localField.set(paramObject, localObject3);
      continue;
      label764:
      if (localObject3 != null)
      {
        Log.v(TAG, "buffer is object, " + localField.getName());
        if (localException5.isConvert()) {}
        for (localBaseProtoBuf1 = (BaseProtoBuf)localException5.getProtoType().newInstance();; localBaseProtoBuf2 = (BaseProtoBuf)((Class)localObject5).newInstance())
        {
          try
          {
            localBaseProtoBuf1.parseFrom((byte[])localObject3);
            if (!localException5.isConvert()) {
              break label934;
            }
            localObject3 = (ARTConvert)((Class)localObject5).newInstance();
            ((ARTConvert)localObject3).ART_ParseProto(localBaseProtoBuf1);
            localField.set(paramObject, localObject3);
          }
          catch (Exception localException2)
          {
            QMLog.log(6, TAG, "BaseProtoBuf#parseFrom " + localField.getName() + " exception: " + localException2.getMessage());
          }
          break;
        }
        localField.set(paramObject, localBaseProtoBuf2);
        continue;
        Object localObject4 = null;
        localObject5 = null;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.ARTCompatibility
 * JD-Core Version:    0.7.0.1
 */