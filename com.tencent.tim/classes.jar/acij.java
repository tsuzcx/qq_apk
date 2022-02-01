import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public abstract class acij
{
  private static final String TAG = "OidbWrapper";
  
  public static int parseOIDBPkg(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    return parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_sso.OIDBSSOPkg(), paramMessageMicro);
  }
  
  /* Error */
  public static int parseOIDBPkg(FromServiceMsg paramFromServiceMsg, Object paramObject, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 29	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: invokestatic 35	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   9: ifeq +298 -> 307
    //   12: new 37	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   19: astore 6
    //   21: iload 4
    //   23: sipush 1000
    //   26: if_icmpne +248 -> 274
    //   29: aload_1
    //   30: ifnull +205 -> 235
    //   33: aload_2
    //   34: aload_1
    //   35: checkcast 40	[B
    //   38: checkcast 40	[B
    //   41: invokevirtual 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: checkcast 17	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +64 -> 113
    //   52: aload_1
    //   53: getfield 48	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: invokevirtual 53	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   59: istore 5
    //   61: iload 5
    //   63: istore 4
    //   65: iload 5
    //   67: ifeq +46 -> 113
    //   70: aload_1
    //   71: getfield 57	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   74: invokevirtual 62	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 66	com/tencent/qphone/base/remote/FromServiceMsg:extraData	Landroid/os/Bundle;
    //   82: ldc 67
    //   84: aload_2
    //   85: invokevirtual 73	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload 5
    //   90: istore 4
    //   92: aload 6
    //   94: ifnull +19 -> 113
    //   97: aload 6
    //   99: ldc 75
    //   101: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: iload 5
    //   111: istore 4
    //   113: iload 4
    //   115: istore 5
    //   117: aload_1
    //   118: ifnull +182 -> 300
    //   121: iload 4
    //   123: istore 5
    //   125: aload_1
    //   126: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   129: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   132: ifeq +168 -> 300
    //   135: iload 4
    //   137: istore 5
    //   139: aload_1
    //   140: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 91	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: ifnull +154 -> 300
    //   149: iload 4
    //   151: istore 5
    //   153: aload_3
    //   154: ifnull +146 -> 300
    //   157: aload_3
    //   158: aload_1
    //   159: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   162: invokevirtual 91	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   165: invokevirtual 97	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   168: invokevirtual 100	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   171: pop
    //   172: aload 6
    //   174: ifnull +28 -> 202
    //   177: aload 6
    //   179: invokevirtual 103	java/lang/StringBuilder:length	()I
    //   182: ifle +20 -> 202
    //   185: invokestatic 35	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   188: ifeq +14 -> 202
    //   191: ldc 105
    //   193: iconst_4
    //   194: aload 6
    //   196: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: iload 4
    //   204: ireturn
    //   205: astore_1
    //   206: aload 6
    //   208: ifnull +18 -> 226
    //   211: aload 6
    //   213: ldc 114
    //   215: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 115	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   230: aload_2
    //   231: astore_1
    //   232: goto -184 -> 48
    //   235: aload_2
    //   236: astore_1
    //   237: aload 6
    //   239: ifnull -191 -> 48
    //   242: aload 6
    //   244: ldc 120
    //   246: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: astore_1
    //   252: goto -204 -> 48
    //   255: astore_0
    //   256: aload 6
    //   258: ifnull +13 -> 271
    //   261: aload 6
    //   263: aload_0
    //   264: invokevirtual 115	java/lang/Exception:toString	()Ljava/lang/String;
    //   267: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: goto -99 -> 172
    //   274: iload 4
    //   276: istore 5
    //   278: aload 6
    //   280: ifnull +20 -> 300
    //   283: aload 6
    //   285: ldc 122
    //   287: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload 4
    //   292: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: iload 4
    //   298: istore 5
    //   300: iload 5
    //   302: istore 4
    //   304: goto -132 -> 172
    //   307: aconst_null
    //   308: astore 6
    //   310: goto -289 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramFromServiceMsg	FromServiceMsg
    //   0	313	1	paramObject	Object
    //   0	313	2	paramOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    //   0	313	3	paramMessageMicro	MessageMicro
    //   4	299	4	i	int
    //   59	242	5	j	int
    //   19	290	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   33	48	205	java/lang/Exception
    //   157	172	255	java/lang/Exception
  }
  
  public static String proto2String(MessageMicro paramMessageMicro)
  {
    return proto2String(paramMessageMicro, true);
  }
  
  public static String proto2String(MessageMicro paramMessageMicro, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    int i = paramInt;
    while (i > 0)
    {
      str = str + "    ";
      i -= 1;
    }
    Field[] arrayOfField;
    int j;
    Field localField;
    boolean bool1;
    Object localObject2;
    if (paramMessageMicro != null)
    {
      try
      {
        arrayOfField = paramMessageMicro.getClass().getFields();
        j = arrayOfField.length;
        i = 0;
      }
      catch (Throwable paramMessageMicro)
      {
        boolean bool2;
        localStringBuilder.append("***ERROR***").append("\n").append(paramMessageMicro);
      }
      localField.setAccessible(true);
      localObject1 = localField.getType();
      if (!PBBoolField.class.isAssignableFrom((Class)localObject1)) {
        break label257;
      }
      localObject1 = (PBBoolField)localField.get(paramMessageMicro);
      if (localObject1 == null) {
        break label2592;
      }
      bool1 = ((PBBoolField)localObject1).has();
      bool2 = ((PBBoolField)localObject1).get();
      localObject2 = localField.getName();
      if (!bool1) {
        break label250;
      }
      localObject1 = Boolean.valueOf(bool2);
      localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
      if ((paramBoolean) && (!bool1)) {
        break label2592;
      }
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject1);
    }
    label194:
    label244:
    label250:
    long l;
    for (;;)
    {
      if (localField != arrayOfField[(arrayOfField.length - 1)]) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("\n");
      break label2592;
      return localStringBuilder.toString();
      localObject1 = "NA";
      break;
      label257:
      if (PBBytesField.class.isAssignableFrom((Class)localObject1))
      {
        localObject1 = (PBBytesField)localField.get(paramMessageMicro);
        if (localObject1 == null) {
          break label2592;
        }
        bool1 = ((PBBytesField)localObject1).has();
        localObject2 = localField.getName();
        if (!bool1) {
          break label2601;
        }
        localObject1 = "<…bytes…>";
        label306:
        localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
        if ((paramBoolean) && (!bool1)) {
          break label2592;
        }
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject1);
      }
      else if (PBDoubleField.class.isAssignableFrom((Class)localObject1))
      {
        localObject1 = (PBDoubleField)localField.get(paramMessageMicro);
        if (localObject1 == null) {
          break label2592;
        }
        bool1 = ((PBDoubleField)localObject1).has();
        double d = ((PBDoubleField)localObject1).get();
        localObject2 = localField.getName();
        if (!bool1) {
          break label2608;
        }
        localObject1 = Double.valueOf(d);
        label412:
        localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
        if ((paramBoolean) && (!bool1)) {
          break label2592;
        }
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject1);
      }
      else
      {
        int k;
        if (PBEnumField.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBEnumField)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBEnumField)localObject1).has();
          k = ((PBEnumField)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2615;
          }
          localObject1 = Integer.valueOf(k);
          label520:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBFixed32Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBFixed32Field)localField.get(paramMessageMicro);
          bool1 = ((PBFixed32Field)localObject1).has();
          k = ((PBFixed32Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2622;
          }
          localObject1 = Integer.valueOf(k);
          label623:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBFixed64Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBFixed64Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBFixed64Field)localObject1).has();
          l = ((PBFixed64Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2629;
          }
          localObject1 = Long.valueOf(l);
          label731:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBFloatField.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBFloatField)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBFloatField)localObject1).has();
          float f = ((PBFloatField)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2636;
          }
          localObject1 = Float.valueOf(f);
          label839:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBInt32Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBInt32Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBInt32Field)localObject1).has();
          k = ((PBInt32Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2643;
          }
          localObject1 = Integer.valueOf(k);
          label947:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBInt64Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBInt64Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBInt64Field)localObject1).has();
          l = ((PBInt64Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2650;
          }
          localObject1 = Long.valueOf(l);
          label1055:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBSFixed32Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBSFixed32Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBSFixed32Field)localObject1).has();
          k = ((PBSFixed32Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2657;
          }
          localObject1 = Integer.valueOf(k);
          label1163:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBSFixed64Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBSFixed64Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBSFixed64Field)localObject1).has();
          l = ((PBSFixed64Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2664;
          }
          localObject1 = Long.valueOf(l);
          label1272:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBSInt32Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBSInt32Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBSInt32Field)localObject1).has();
          k = ((PBSInt32Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2671;
          }
          localObject1 = Integer.valueOf(k);
          label1381:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBSInt64Field.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBSInt64Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBSInt64Field)localObject1).has();
          l = ((PBSInt64Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2678;
          }
          localObject1 = Long.valueOf(l);
          label1490:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else if (PBStringField.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBStringField)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBStringField)localObject1).has();
          localObject1 = ((PBStringField)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2685;
          }
          label1591:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
        else
        {
          if (!PBUInt32Field.class.isAssignableFrom((Class)localObject1)) {
            break label1748;
          }
          localObject1 = (PBUInt32Field)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBUInt32Field)localObject1).has();
          k = ((PBUInt32Field)localObject1).get();
          localObject2 = localField.getName();
          if (!bool1) {
            break label2692;
          }
          localObject1 = Integer.valueOf(k);
          label1699:
          localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject1);
        }
      }
    }
    label1748:
    if (PBUInt64Field.class.isAssignableFrom((Class)localObject1))
    {
      localObject1 = (PBUInt64Field)localField.get(paramMessageMicro);
      if (localObject1 == null) {
        break label2592;
      }
      bool1 = ((PBUInt64Field)localObject1).has();
      l = ((PBUInt64Field)localObject1).get();
      localObject2 = localField.getName();
      if (!bool1) {
        break label2699;
      }
    }
    label2692:
    label2699:
    for (Object localObject1 = Long.valueOf(l);; localObject1 = "NA")
    {
      localObject1 = String.format("%s: %s", new Object[] { localObject2, localObject1 });
      if ((!paramBoolean) || (bool1))
      {
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject1);
        break label194;
        Object localObject3;
        if (PBRepeatField.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBRepeatField)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBRepeatField)localObject1).has();
          localObject1 = ((PBRepeatField)localObject1).get();
          if ((paramBoolean) && ((!bool1) || (((List)localObject1).isEmpty()))) {
            break label2592;
          }
          if (!bool1)
          {
            localObject1 = String.format("%s: [NA]", new Object[] { localField.getName() });
            localStringBuilder.append(str);
            localStringBuilder.append((String)localObject1);
            break label194;
          }
          localStringBuilder.append(str).append(String.format("%s: [\n", new Object[] { localField.getName() }));
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            localStringBuilder.append(str).append("    ").append(localObject3);
            if (localObject3 != ((List)localObject1).get(((List)localObject1).size() - 1)) {
              localStringBuilder.append(",");
            }
            localStringBuilder.append("\n");
          }
          localStringBuilder.append(str).append("]");
          break label194;
        }
        if (PBRepeatMessageField.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (PBRepeatMessageField)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((PBRepeatMessageField)localObject1).has();
          localObject1 = ((PBRepeatMessageField)localObject1).get();
          if ((paramBoolean) && ((!bool1) || (((List)localObject1).isEmpty()))) {
            break label2592;
          }
          if (!bool1)
          {
            localObject1 = String.format("%s: [NA]", new Object[] { localField.getName() });
            localStringBuilder.append(str);
            localStringBuilder.append((String)localObject1);
            break label194;
          }
          localStringBuilder.append(str).append(String.format("%s: [\n", new Object[] { localField.getName() }));
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MessageMicro)((Iterator)localObject2).next();
            localStringBuilder.append(str).append("    ").append("{\n");
            localStringBuilder.append(proto2String((MessageMicro)localObject3, paramInt + 2, paramBoolean));
            localStringBuilder.append(str).append("    ").append("}");
            if (localObject3 != ((List)localObject1).get(((List)localObject1).size() - 1)) {
              localStringBuilder.append(",");
            }
            localStringBuilder.append("\n");
          }
          localStringBuilder.append(str).append("]");
          break label194;
        }
        if (MessageMicro.class.isAssignableFrom((Class)localObject1))
        {
          localObject1 = (MessageMicro)localField.get(paramMessageMicro);
          if (localObject1 == null) {
            break label2592;
          }
          bool1 = ((MessageMicro)localObject1).has();
          localObject1 = ((MessageMicro)localObject1).get();
          if ((paramBoolean) && (!bool1)) {
            break label2592;
          }
          if (!bool1)
          {
            localObject1 = String.format("%s: NA", new Object[] { localField.getName() });
            localStringBuilder.append(str);
            localStringBuilder.append((String)localObject1);
            break label194;
          }
          localStringBuilder.append(str).append(localField.getName()).append(": {\n");
          localStringBuilder.append(proto2String((MessageMicro)localObject1, paramInt + 1, paramBoolean));
          localStringBuilder.append(str).append("}");
          break label194;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OidbWrapper", 2, "unknown type {" + localField.getName() + "|" + localField.getType() + "}");
        }
      }
      for (;;)
      {
        if (i >= j) {
          break label2599;
        }
        localField = arrayOfField[i];
        if (localField != null) {
          break;
        }
        label2592:
        i += 1;
      }
      label2599:
      break label244;
      label2601:
      localObject1 = "NA";
      break label306;
      label2608:
      localObject1 = "NA";
      break label412;
      label2615:
      localObject1 = "NA";
      break label520;
      label2622:
      localObject1 = "NA";
      break label623;
      label2629:
      localObject1 = "NA";
      break label731;
      label2636:
      localObject1 = "NA";
      break label839;
      label2643:
      localObject1 = "NA";
      break label947;
      label2650:
      localObject1 = "NA";
      break label1055;
      label2657:
      localObject1 = "NA";
      break label1163;
      label2664:
      localObject1 = "NA";
      break label1272;
      label2671:
      localObject1 = "NA";
      break label1381;
      label2678:
      localObject1 = "NA";
      break label1490;
      label2685:
      localObject1 = "NA";
      break label1591;
      localObject1 = "NA";
      break label1699;
    }
  }
  
  public static String proto2String(MessageMicro paramMessageMicro, boolean paramBoolean)
  {
    return proto2String(paramMessageMicro, 0, paramBoolean);
  }
  
  protected abstract void addBusinessObserver(ToServiceMsg paramToServiceMsg, acci paramacci, boolean paramBoolean);
  
  public abstract ToServiceMsg createToServiceMsg(String paramString);
  
  public ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return makeOIDBPkg(paramString, paramInt1, paramInt2, paramArrayOfByte, 30000L);
  }
  
  public ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong)
  {
    return makeOIDBPkg(paramString, paramInt1, paramInt2, paramArrayOfByte, paramLong, null, false);
  }
  
  public ToServiceMsg makeOIDBPkg(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong, acci paramacci, boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.str_client_version.set(AppSetting.getVersion());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = createToServiceMsg(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(paramLong);
    addBusinessObserver(paramString, paramacci, paramBoolean);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acij
 * JD-Core Version:    0.7.0.1
 */