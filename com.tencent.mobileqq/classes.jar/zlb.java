import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class zlb
{
  public static <PB extends MessageMicro<PB>> String a(PB paramPB)
  {
    if (paramPB == null) {
      return String.valueOf(paramPB);
    }
    return a(paramPB).toString();
  }
  
  private static <PB extends PBPrimitiveField<PB>> String a(PB paramPB)
  {
    if ((paramPB instanceof PBBytesField)) {
      return ((PBBytesField)paramPB).get().toStringUtf8();
    }
    if ((paramPB instanceof PBStringField)) {
      return ((PBStringField)paramPB).get();
    }
    if ((paramPB instanceof PBBoolField)) {
      return String.valueOf(((PBBoolField)paramPB).get());
    }
    if ((paramPB instanceof PBFixed32Field)) {
      return String.valueOf(((PBFixed32Field)paramPB).get());
    }
    if ((paramPB instanceof PBFixed64Field)) {
      return String.valueOf(((PBFixed64Field)paramPB).get());
    }
    if ((paramPB instanceof PBFloatField)) {
      return String.valueOf(((PBFloatField)paramPB).get());
    }
    if ((paramPB instanceof PBInt32Field)) {
      return String.valueOf(((PBInt32Field)paramPB).get());
    }
    if ((paramPB instanceof PBInt64Field)) {
      return String.valueOf(((PBInt64Field)paramPB).get());
    }
    if ((paramPB instanceof PBSFixed32Field)) {
      return String.valueOf(((PBSFixed32Field)paramPB).get());
    }
    if ((paramPB instanceof PBSInt32Field)) {
      return String.valueOf(((PBSInt32Field)paramPB).get());
    }
    if ((paramPB instanceof PBSInt64Field)) {
      return String.valueOf(((PBSInt64Field)paramPB).get());
    }
    if ((paramPB instanceof PBUInt32Field)) {
      return String.valueOf(((PBUInt32Field)paramPB).get());
    }
    if ((paramPB instanceof PBUInt64Field)) {
      return String.valueOf(((PBUInt64Field)paramPB).get());
    }
    if ((paramPB instanceof PBEnumField)) {
      return String.valueOf(((PBEnumField)paramPB).get());
    }
    return "(null)";
  }
  
  public static <PB extends MessageMicro<PB>> JSONObject a(PB paramPB)
  {
    JSONObject localJSONObject = new JSONObject();
    a(paramPB, localJSONObject);
    return localJSONObject;
  }
  
  private static <PB extends MessageMicro<PB>> void a(PB paramPB, JSONObject paramJSONObject)
  {
    Field[] arrayOfField = paramPB.getClass().getDeclaredFields();
    for (;;)
    {
      int i;
      Object localObject1;
      String str;
      try
      {
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localObject1 = arrayOfField[i];
          str = ((Field)localObject1).getName();
          if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {
            break label343;
          }
          localObject1 = ((Field)localObject1).get(paramPB);
          if ((!(localObject1 instanceof MessageMicro)) || (!((MessageMicro)localObject1).has())) {
            break label98;
          }
          paramJSONObject.put(str, a((MessageMicro)localObject1));
        }
      }
      catch (Exception paramPB)
      {
        paramPB.printStackTrace();
      }
      return;
      label98:
      if (((localObject1 instanceof PBPrimitiveField)) && (((PBPrimitiveField)localObject1).has()))
      {
        paramJSONObject.put(str, a((PBPrimitiveField)localObject1));
      }
      else
      {
        Object localObject2;
        if ((localObject1 instanceof PBRepeatField))
        {
          localObject2 = ((PBRepeatField)localObject1).get();
          localObject1 = new JSONArray();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            if ((localObject3 instanceof PBPrimitiveField)) {
              ((JSONArray)localObject1).put(a((PBPrimitiveField)localObject3));
            } else if ((localObject3 instanceof ByteStringMicro)) {
              ((JSONArray)localObject1).put(((ByteStringMicro)localObject3).toStringUtf8());
            } else {
              ((JSONArray)localObject1).put(String.valueOf(localObject3));
            }
          }
          paramJSONObject.put(str, localObject1);
        }
        else if ((localObject1 instanceof PBRepeatMessageField))
        {
          localObject2 = ((PBRepeatMessageField)localObject1).get();
          localObject1 = new JSONArray();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(a((MessageMicro)((Iterator)localObject2).next()));
          }
          paramJSONObject.put(str, localObject1);
        }
      }
      label343:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlb
 * JD-Core Version:    0.7.0.1
 */