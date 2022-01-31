package com.tencent.lbsapi.a;

import android.os.Environment;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.lbsapi.model.WifiInfo;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class b
{
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1970, 0, 1, 8, 0, 0);
    return (Calendar.getInstance().getTimeInMillis() - localCalendar.getTimeInMillis()) / 1000L;
  }
  
  /* Error */
  public static ArrayList a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 33
    //   5: invokevirtual 39	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   8: astore_1
    //   9: new 41	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 44	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 48	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: checkcast 50	java/util/ArrayList
    //   25: astore_3
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 56	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: ldc 33
    //   45: invokevirtual 60	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   48: pop
    //   49: aload_3
    //   50: areturn
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   56: goto -22 -> 34
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   64: goto -22 -> 42
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 56	java/io/FileInputStream:close	()V
    //   88: aload_0
    //   89: ldc 33
    //   91: invokevirtual 60	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   94: pop
    //   95: aconst_null
    //   96: areturn
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   102: goto -22 -> 80
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   110: goto -22 -> 88
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 56	java/io/FileInputStream:close	()V
    //   132: aload_0
    //   133: ldc 33
    //   135: invokevirtual 60	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   138: pop
    //   139: aload_2
    //   140: athrow
    //   141: astore_3
    //   142: aload_3
    //   143: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   146: goto -22 -> 124
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   154: goto -22 -> 132
    //   157: astore_2
    //   158: goto -42 -> 116
    //   161: astore 4
    //   163: aload_2
    //   164: astore_3
    //   165: aload 4
    //   167: astore_2
    //   168: goto -52 -> 116
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_3
    //   174: aload_1
    //   175: astore_2
    //   176: aload_3
    //   177: astore_1
    //   178: goto -106 -> 72
    //   181: astore_3
    //   182: aload_1
    //   183: astore_3
    //   184: aload_2
    //   185: astore_1
    //   186: aload_3
    //   187: astore_2
    //   188: goto -116 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramContext	android.content.Context
    //   8	31	1	localFileInputStream	java.io.FileInputStream
    //   59	2	1	localIOException1	java.io.IOException
    //   67	1	1	localException1	Exception
    //   69	8	1	localObject1	Object
    //   97	2	1	localIOException2	java.io.IOException
    //   105	2	1	localIOException3	java.io.IOException
    //   115	14	1	localObject2	Object
    //   149	26	1	localIOException4	java.io.IOException
    //   177	9	1	localObject3	Object
    //   17	14	2	localObjectInputStream	java.io.ObjectInputStream
    //   51	2	2	localIOException5	java.io.IOException
    //   71	14	2	localObject4	Object
    //   113	27	2	localObject5	Object
    //   157	7	2	localObject6	Object
    //   167	1	2	localObject7	Object
    //   171	1	2	localException2	Exception
    //   175	13	2	localObject8	Object
    //   1	120	3	localArrayList	ArrayList
    //   141	2	3	localIOException6	java.io.IOException
    //   164	13	3	localObject9	Object
    //   181	1	3	localException3	Exception
    //   183	4	3	localObject10	Object
    //   161	5	4	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   30	34	51	java/io/IOException
    //   38	42	59	java/io/IOException
    //   2	9	67	java/lang/Exception
    //   76	80	97	java/io/IOException
    //   84	88	105	java/io/IOException
    //   2	9	113	finally
    //   120	124	141	java/io/IOException
    //   128	132	149	java/io/IOException
    //   9	18	157	finally
    //   18	26	161	finally
    //   9	18	171	java/lang/Exception
    //   18	26	181	java/lang/Exception
  }
  
  public static ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String[] arrayOfString = ((WifiInfo)paramArrayList.next()).mac.split(":");
      byte[] arrayOfByte = new byte[8];
      byte[] tmp61_59 = arrayOfByte;
      tmp61_59[0] = 0;
      byte[] tmp66_61 = tmp61_59;
      tmp66_61[1] = 0;
      byte[] tmp71_66 = tmp66_61;
      tmp71_66[2] = 0;
      byte[] tmp76_71 = tmp71_66;
      tmp76_71[3] = 0;
      byte[] tmp81_76 = tmp76_71;
      tmp81_76[4] = 0;
      byte[] tmp86_81 = tmp81_76;
      tmp86_81[5] = 0;
      byte[] tmp91_86 = tmp86_81;
      tmp91_86[6] = 0;
      byte[] tmp97_91 = tmp91_86;
      tmp97_91[7] = 0;
      tmp97_91;
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfByte[(5 - i)] = ((byte)Integer.parseInt(arrayOfString[i], 16));
        i += 1;
      }
      localArrayList.add(Long.valueOf(c(arrayOfByte)));
    }
    return localArrayList;
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ifnull +10 -> 15
    //   8: aload_1
    //   9: invokevirtual 121	java/util/ArrayList:size	()I
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: ldc 33
    //   19: iconst_0
    //   20: invokevirtual 125	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   23: astore_0
    //   24: new 127	java/io/ObjectOutputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 130	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_3
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 134	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_0
    //   39: ifnull +7 -> 46
    //   42: aload_0
    //   43: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   46: aload_3
    //   47: ifnull -32 -> 15
    //   50: aload_3
    //   51: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   54: return
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   60: return
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   66: goto -20 -> 46
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_3
    //   73: astore_1
    //   74: aload_2
    //   75: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   86: aload_0
    //   87: ifnull -72 -> 15
    //   90: aload_0
    //   91: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   94: return
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   100: return
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   106: goto -20 -> 86
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   135: goto -15 -> 120
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   143: goto -15 -> 128
    //   146: astore_1
    //   147: goto -35 -> 112
    //   150: astore_1
    //   151: aload_3
    //   152: astore_2
    //   153: goto -41 -> 112
    //   156: astore_2
    //   157: aload_1
    //   158: astore_3
    //   159: aload_2
    //   160: astore_1
    //   161: aload_0
    //   162: astore_2
    //   163: aload_3
    //   164: astore_0
    //   165: goto -53 -> 112
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_0
    //   172: astore_1
    //   173: aload_3
    //   174: astore_0
    //   175: goto -101 -> 74
    //   178: astore_2
    //   179: aload_0
    //   180: astore_1
    //   181: aload_3
    //   182: astore_0
    //   183: goto -109 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	android.content.Context
    //   0	186	1	paramArrayList	ArrayList
    //   1	1	2	localObject1	Object
    //   69	56	2	localException1	Exception
    //   152	1	2	localObject2	Object
    //   156	4	2	localObject3	Object
    //   162	1	2	localContext	android.content.Context
    //   168	1	2	localException2	Exception
    //   178	1	2	localException3	Exception
    //   3	179	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   50	54	55	java/io/IOException
    //   42	46	61	java/io/IOException
    //   16	24	69	java/lang/Exception
    //   90	94	95	java/io/IOException
    //   82	86	101	java/io/IOException
    //   16	24	109	finally
    //   116	120	130	java/io/IOException
    //   124	128	138	java/io/IOException
    //   24	33	146	finally
    //   33	38	150	finally
    //   74	78	156	finally
    //   24	33	168	java/lang/Exception
    //   33	38	178	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 136	java/io/FileOutputStream
    //   5: dup
    //   6: new 142	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   13: invokestatic 149	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   16: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 155
    //   21: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_0
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 169	java/io/FileOutputStream:write	([B)V
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   50: return
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   56: return
    //   57: astore_3
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_3
    //   63: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   66: aload_1
    //   67: ifnull -17 -> 50
    //   70: aload_1
    //   71: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   74: return
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   80: return
    //   81: astore_0
    //   82: aload_3
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   99: goto -7 -> 92
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: goto -23 -> 84
    //   110: astore_3
    //   111: aload_2
    //   112: astore_1
    //   113: goto -53 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   0	116	1	paramArrayOfByte	byte[]
    //   34	13	2	localFileOutputStream	java.io.FileOutputStream
    //   102	10	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   57	26	3	localException1	Exception
    //   110	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   46	50	51	java/io/IOException
    //   2	35	57	java/lang/Exception
    //   70	74	75	java/io/IOException
    //   2	35	81	finally
    //   88	92	94	java/io/IOException
    //   37	42	102	finally
    //   62	66	102	finally
    //   37	42	110	java/lang/Exception
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    JceOutputStream localJceOutputStream = new JceOutputStream();
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 186	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: sipush 4096
    //   10: invokespecial 189	java/io/ByteArrayOutputStream:<init>	(I)V
    //   13: astore 5
    //   15: new 127	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 130	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 134	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_2
    //   33: astore_1
    //   34: aload 5
    //   36: invokevirtual 190	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: astore_0
    //   40: aload 5
    //   42: ifnull +8 -> 50
    //   45: aload 5
    //   47: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   50: aload_0
    //   51: astore_1
    //   52: aload_2
    //   53: ifnull +9 -> 62
    //   56: aload_2
    //   57: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   60: aload_0
    //   61: astore_1
    //   62: aload_1
    //   63: areturn
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   73: aload 5
    //   75: ifnull +8 -> 83
    //   78: aload 5
    //   80: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   83: aload 4
    //   85: astore_1
    //   86: aload_0
    //   87: ifnull -25 -> 62
    //   90: aload_0
    //   91: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_1
    //   102: aload 5
    //   104: ifnull +8 -> 112
    //   107: aload 5
    //   109: invokevirtual 191	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_1
    //   123: goto -73 -> 50
    //   126: astore_1
    //   127: aload_0
    //   128: areturn
    //   129: astore_1
    //   130: goto -47 -> 83
    //   133: astore_2
    //   134: goto -22 -> 112
    //   137: astore_1
    //   138: goto -18 -> 120
    //   141: astore_0
    //   142: goto -40 -> 102
    //   145: astore_3
    //   146: aload_2
    //   147: astore_0
    //   148: goto -81 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramObject	Object
    //   26	91	1	localObject1	Object
    //   122	1	1	localIOException1	java.io.IOException
    //   126	1	1	localIOException2	java.io.IOException
    //   129	1	1	localIOException3	java.io.IOException
    //   137	1	1	localIOException4	java.io.IOException
    //   24	33	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   133	14	2	localIOException5	java.io.IOException
    //   64	6	3	localIOException6	java.io.IOException
    //   145	1	3	localIOException7	java.io.IOException
    //   1	83	4	localObject2	Object
    //   13	95	5	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   15	25	64	java/io/IOException
    //   90	94	96	java/io/IOException
    //   15	25	99	finally
    //   45	50	122	java/io/IOException
    //   56	60	126	java/io/IOException
    //   78	83	129	java/io/IOException
    //   107	112	133	java/io/IOException
    //   116	120	137	java/io/IOException
    //   27	32	141	finally
    //   34	40	141	finally
    //   69	73	141	finally
    //   27	32	145	java/io/IOException
    //   34	40	145	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 194	java/io/File
    //   3: dup
    //   4: new 142	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 149	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   14: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: ldc 155
    //   19: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 198	java/io/File:exists	()Z
    //   37: ifne +5 -> 42
    //   40: aconst_null
    //   41: areturn
    //   42: aload_0
    //   43: invokevirtual 201	java/io/File:length	()J
    //   46: ldc2_w 202
    //   49: ladd
    //   50: l2i
    //   51: newarray byte
    //   53: astore_2
    //   54: new 55	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 210	java/io/FileInputStream:read	([B)I
    //   70: pop
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 56	java/io/FileInputStream:close	()V
    //   79: aload_2
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   86: goto -7 -> 79
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: aload_2
    //   95: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   98: aload_1
    //   99: ifnull -59 -> 40
    //   102: aload_1
    //   103: invokevirtual 56	java/io/FileInputStream:close	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 56	java/io/FileInputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   133: goto -7 -> 126
    //   136: astore_1
    //   137: goto -19 -> 118
    //   140: astore_2
    //   141: goto -49 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   62	41	1	localFileInputStream	java.io.FileInputStream
    //   115	12	1	localObject1	Object
    //   136	1	1	localObject2	Object
    //   53	27	2	arrayOfByte	byte[]
    //   89	6	2	localException1	Exception
    //   140	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   75	79	81	java/io/IOException
    //   54	63	89	java/lang/Exception
    //   102	106	108	java/io/IOException
    //   54	63	115	finally
    //   122	126	128	java/io/IOException
    //   65	71	136	finally
    //   94	98	136	finally
    //   65	71	140	java/lang/Exception
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeShort(65535);
      localDataOutputStream.writeShort(1);
      localDataOutputStream.write(paramArrayOfByte);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label75:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label75;
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    int i = 0;
    paramString2 = c(paramString2);
    paramString1 = paramString1 + paramString2;
    try
    {
      paramString2 = MessageDigest.getInstance("MD5");
      paramString2.update(paramString1.getBytes());
      paramString1 = paramString2.digest();
      paramString2 = new char[16];
      String tmp51_50 = paramString2;
      tmp51_50[0] = 48;
      String tmp56_51 = tmp51_50;
      tmp56_51[1] = 49;
      String tmp61_56 = tmp56_51;
      tmp61_56[2] = 50;
      String tmp66_61 = tmp61_56;
      tmp66_61[3] = 51;
      String tmp71_66 = tmp66_61;
      tmp71_66[4] = 52;
      String tmp76_71 = tmp71_66;
      tmp76_71[5] = 53;
      String tmp81_76 = tmp76_71;
      tmp81_76[6] = 54;
      String tmp87_81 = tmp81_76;
      tmp87_81[7] = 55;
      String tmp93_87 = tmp87_81;
      tmp93_87[8] = 56;
      String tmp99_93 = tmp93_87;
      tmp99_93[9] = 57;
      String tmp105_99 = tmp99_93;
      tmp105_99[10] = 65;
      String tmp111_105 = tmp105_99;
      tmp111_105[11] = 66;
      String tmp117_111 = tmp111_105;
      tmp117_111[12] = 67;
      String tmp123_117 = tmp117_111;
      tmp123_117[13] = 68;
      String tmp129_123 = tmp123_117;
      tmp129_123[14] = 69;
      String tmp136_129 = tmp129_123;
      tmp136_129[15] = 70;
      tmp136_129;
      int k = paramString1.length;
      char[] arrayOfChar = new char[k * 2];
      int j = 0;
      while (i < k)
      {
        int m = paramString1[i];
        int n = j + 1;
        arrayOfChar[j] = paramString2[(m >> 4 & 0xF)];
        j = n + 1;
        arrayOfChar[n] = paramString2[(m & 0xF)];
        i += 1;
      }
      return new a().b(paramArrayOfByte, paramString1);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
  }
  
  /* Error */
  public static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 267	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 269	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore 4
    //   12: new 41	java/io/ObjectInputStream
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 44	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 48	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_0
    //   31: aload 4
    //   33: ifnull +8 -> 41
    //   36: aload 4
    //   38: invokevirtual 270	java/io/ByteArrayInputStream:close	()V
    //   41: aload_0
    //   42: astore_2
    //   43: aload_1
    //   44: ifnull +9 -> 53
    //   47: aload_1
    //   48: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   51: aload_0
    //   52: astore_2
    //   53: aload_2
    //   54: areturn
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   64: aload 4
    //   66: ifnull +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 270	java/io/ByteArrayInputStream:close	()V
    //   74: aload_3
    //   75: astore_2
    //   76: aload_1
    //   77: ifnull -24 -> 53
    //   80: aload_1
    //   81: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_0
    //   92: aload 4
    //   94: ifnull +8 -> 102
    //   97: aload 4
    //   99: invokevirtual 270	java/io/ByteArrayInputStream:close	()V
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 53	java/io/ObjectInputStream:close	()V
    //   110: aload_1
    //   111: athrow
    //   112: astore_2
    //   113: goto -72 -> 41
    //   116: astore_1
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: goto -46 -> 74
    //   123: astore_2
    //   124: goto -22 -> 102
    //   127: astore_0
    //   128: goto -18 -> 110
    //   131: astore_1
    //   132: goto -40 -> 92
    //   135: astore_2
    //   136: goto -78 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfByte	byte[]
    //   21	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   89	22	1	localObject1	Object
    //   116	1	1	localIOException1	java.io.IOException
    //   131	1	1	localObject2	Object
    //   28	26	2	localObject3	Object
    //   55	6	2	localException1	Exception
    //   75	1	2	localObject4	Object
    //   112	1	2	localIOException2	java.io.IOException
    //   123	1	2	localIOException3	java.io.IOException
    //   135	1	2	localException2	Exception
    //   1	74	3	localObject5	Object
    //   10	88	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   12	22	55	java/lang/Exception
    //   80	84	86	java/io/IOException
    //   12	22	89	finally
    //   36	41	112	java/io/IOException
    //   47	51	116	java/io/IOException
    //   69	74	119	java/io/IOException
    //   97	102	123	java/io/IOException
    //   106	110	127	java/io/IOException
    //   24	29	131	finally
    //   60	64	131	finally
    //   24	29	135	java/lang/Exception
  }
  
  public static void b(String paramString)
  {
    paramString = new File(Environment.getExternalStorageDirectory() + "//" + paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    int i = 0;
    paramString2 = c(paramString2);
    paramString1 = paramString1 + paramString2;
    try
    {
      paramString2 = MessageDigest.getInstance("MD5");
      paramString2.update(paramString1.getBytes());
      paramString1 = paramString2.digest();
      paramString2 = new char[16];
      String tmp51_50 = paramString2;
      tmp51_50[0] = 48;
      String tmp56_51 = tmp51_50;
      tmp56_51[1] = 49;
      String tmp61_56 = tmp56_51;
      tmp61_56[2] = 50;
      String tmp66_61 = tmp61_56;
      tmp66_61[3] = 51;
      String tmp71_66 = tmp66_61;
      tmp71_66[4] = 52;
      String tmp76_71 = tmp71_66;
      tmp76_71[5] = 53;
      String tmp81_76 = tmp76_71;
      tmp81_76[6] = 54;
      String tmp87_81 = tmp81_76;
      tmp87_81[7] = 55;
      String tmp93_87 = tmp87_81;
      tmp93_87[8] = 56;
      String tmp99_93 = tmp93_87;
      tmp99_93[9] = 57;
      String tmp105_99 = tmp99_93;
      tmp105_99[10] = 65;
      String tmp111_105 = tmp105_99;
      tmp111_105[11] = 66;
      String tmp117_111 = tmp111_105;
      tmp117_111[12] = 67;
      String tmp123_117 = tmp117_111;
      tmp123_117[13] = 68;
      String tmp129_123 = tmp123_117;
      tmp129_123[14] = 69;
      String tmp136_129 = tmp129_123;
      tmp136_129[15] = 70;
      tmp136_129;
      int k = paramString1.length;
      char[] arrayOfChar = new char[k * 2];
      int j = 0;
      while (i < k)
      {
        int m = paramString1[i];
        int n = j + 1;
        arrayOfChar[j] = paramString2[(m >> 4 & 0xF)];
        j = n + 1;
        arrayOfChar[n] = paramString2[(m & 0xF)];
        i += 1;
      }
      return new a().a(paramArrayOfByte, paramString1);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
  }
  
  public static long c(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[7] & 0xFF) << 56;
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp95_88 = tmp88_82;
    tmp95_88[15] = 70;
    tmp95_88;
    for (;;)
    {
      Object localObject;
      int k;
      int j;
      try
      {
        paramString = paramString.getBytes();
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString);
        paramString = ((MessageDigest)localObject).digest();
        k = paramString.length;
        localObject = new char[k * 2];
        j = 0;
      }
      catch (Exception paramString)
      {
        return "";
      }
      paramString = new String((char[])localObject);
      return paramString;
      while (i < k)
      {
        int m = paramString[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.a.b
 * JD-Core Version:    0.7.0.1
 */