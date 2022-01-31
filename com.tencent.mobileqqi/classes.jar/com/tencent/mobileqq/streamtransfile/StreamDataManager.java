package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StreamDataManager
{
  private static final String a = "StreamDataManager";
  
  public static int a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.a();
        if ((paramString != null) && (paramString.size() > 0)) {
          return ((StreamDataInfo)paramString.get(0)).a();
        }
      }
    }
    return -1;
  }
  
  public static int a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        if (paramShort <= paramString.a().size()) {
          return ((StreamDataInfo)paramString.a().get(paramShort - 1)).a();
        }
        QLog.w("StreamDataManager", 2, "getRecordedSize error shPackSeq: " + paramShort + "sfi.getStreamData().size(): " + paramString.a().size());
      }
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return -1L;
  }
  
  public static File a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return null;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StreamFileInfo localStreamFileInfo = (StreamFileInfo)localHashMap.get(str);
        if ((localStreamFileInfo.b() == paramInt1) && (localStreamFileInfo.a() == paramInt2)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public static short a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.c();
      }
    }
    return -1;
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a();
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramLong);
      }
    }
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong)
  {
    a(paramString1, paramQQAppInterface, paramString2, paramLong, false);
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong, boolean paramBoolean)
  {
    Object localObject = StreamMemoryPool.a();
    short s;
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString1)))
    {
      localObject = (StreamFileInfo)((HashMap)localObject).get(paramString1);
      ((StreamFileInfo)localObject).a = paramBoolean;
      if (localObject != null)
      {
        if (((StreamFileInfo)localObject).a() != 0) {
          break label202;
        }
        localObject = ((StreamFileInfo)localObject).a();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label202;
        }
        localObject = ((List)localObject).iterator();
        s = -1;
        if (((Iterator)localObject).hasNext())
        {
          StreamDataInfo localStreamDataInfo = (StreamDataInfo)((Iterator)localObject).next();
          if ((localStreamDataInfo.a() == 800) && (!localStreamDataInfo.b()))
          {
            s = localStreamDataInfo.a();
            localStreamDataInfo.b(true);
          }
          for (;;)
          {
            break;
            if ((localStreamDataInfo.b()) || (!localStreamDataInfo.a())) {
              break label199;
            }
            s = localStreamDataInfo.a();
            localStreamDataInfo.b(true);
          }
        }
      }
    }
    for (;;)
    {
      if ((s != -1) && (paramLong != 0L)) {
        paramQQAppInterface.a().a(paramString2, paramString1, paramLong, s);
      }
      return;
      label199:
      break;
      label202:
      s = -1;
    }
  }
  
  public static void a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.c(paramShort);
      }
    }
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +240 -> 241
    //   4: new 160	java/io/File
    //   7: dup
    //   8: aload_2
    //   9: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 8
    //   14: aload 8
    //   16: invokevirtual 165	java/io/File:exists	()Z
    //   19: ifeq +222 -> 241
    //   22: invokestatic 19	com/tencent/mobileqq/streamtransfile/StreamMemoryPool:a	()Ljava/util/HashMap;
    //   25: astore 7
    //   27: aload 7
    //   29: ifnull +212 -> 241
    //   32: aload_2
    //   33: invokestatic 168	com/tencent/mobileqq/streamtransfile/StreamDataManager:a	(Ljava/lang/String;)Z
    //   36: pop
    //   37: aload 7
    //   39: aload_2
    //   40: invokevirtual 25	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   43: ifne +198 -> 241
    //   46: new 31	com/tencent/mobileqq/streamtransfile/StreamFileInfo
    //   49: dup
    //   50: aload_2
    //   51: iconst_0
    //   52: iconst_1
    //   53: invokespecial 171	com/tencent/mobileqq/streamtransfile/StreamFileInfo:<init>	(Ljava/lang/String;IZ)V
    //   56: astore 9
    //   58: aload 9
    //   60: lload_3
    //   61: l2i
    //   62: invokevirtual 174	com/tencent/mobileqq/streamtransfile/StreamFileInfo:b	(I)V
    //   65: aload 7
    //   67: monitorenter
    //   68: aload 7
    //   70: aload_2
    //   71: aload 9
    //   73: invokevirtual 178	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload 7
    //   79: monitorexit
    //   80: new 180	java/io/FileInputStream
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore 7
    //   91: sipush 800
    //   94: newarray byte
    //   96: astore 8
    //   98: iconst_0
    //   99: istore 5
    //   101: aload 7
    //   103: aload 8
    //   105: invokevirtual 189	java/io/InputStream:read	([B)I
    //   108: istore 6
    //   110: iload 6
    //   112: ifle +53 -> 165
    //   115: iload 5
    //   117: iload 6
    //   119: iadd
    //   120: istore 6
    //   122: iload 6
    //   124: istore 5
    //   126: iload 6
    //   128: sipush 800
    //   131: if_icmplt -30 -> 101
    //   134: aload_2
    //   135: aload 8
    //   137: aload 8
    //   139: arraylength
    //   140: iconst_0
    //   141: iconst_1
    //   142: invokestatic 192	com/tencent/mobileqq/streamtransfile/StreamDataManager:a	(Ljava/lang/String;[BISZ)Z
    //   145: pop
    //   146: aload_2
    //   147: aload_0
    //   148: aload_1
    //   149: lload_3
    //   150: invokestatic 194	com/tencent/mobileqq/streamtransfile/StreamDataManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;J)V
    //   153: iconst_0
    //   154: istore 5
    //   156: goto -55 -> 101
    //   159: astore_0
    //   160: aload 7
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    //   165: iload 5
    //   167: ifle +32 -> 199
    //   170: iload 5
    //   172: newarray byte
    //   174: astore 9
    //   176: aload 8
    //   178: iconst_0
    //   179: aload 9
    //   181: iconst_0
    //   182: iload 5
    //   184: invokestatic 200	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   187: aload_2
    //   188: aload 9
    //   190: aload 9
    //   192: arraylength
    //   193: iconst_0
    //   194: iconst_1
    //   195: invokestatic 192	com/tencent/mobileqq/streamtransfile/StreamDataManager:a	(Ljava/lang/String;[BISZ)Z
    //   198: pop
    //   199: aload_2
    //   200: invokestatic 202	com/tencent/mobileqq/streamtransfile/StreamDataManager:b	(Ljava/lang/String;)V
    //   203: aload_2
    //   204: aload_0
    //   205: aload_1
    //   206: lload_3
    //   207: invokestatic 194	com/tencent/mobileqq/streamtransfile/StreamDataManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;J)V
    //   210: aload 7
    //   212: ifnull +8 -> 220
    //   215: aload 7
    //   217: invokevirtual 205	java/io/InputStream:close	()V
    //   220: iconst_1
    //   221: ireturn
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 208	java/lang/Exception:printStackTrace	()V
    //   227: aload_2
    //   228: invokestatic 168	com/tencent/mobileqq/streamtransfile/StreamDataManager:a	(Ljava/lang/String;)Z
    //   231: pop
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   239: iconst_1
    //   240: ireturn
    //   241: iconst_0
    //   242: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramQQAppInterface	QQAppInterface
    //   0	243	1	paramString1	String
    //   0	243	2	paramString2	String
    //   0	243	3	paramLong	long
    //   99	84	5	i	int
    //   108	24	6	j	int
    //   25	191	7	localObject1	Object
    //   12	165	8	localObject2	Object
    //   56	135	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   68	80	159	finally
    //   160	163	159	finally
    //   80	98	222	java/lang/Exception
    //   101	110	222	java/lang/Exception
    //   134	153	222	java/lang/Exception
    //   170	199	222	java/lang/Exception
    //   199	210	222	java/lang/Exception
    //   215	220	234	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      try
      {
        localHashMap.remove(paramString);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (!localHashMap.containsKey(paramString)))
    {
      StreamFileInfo localStreamFileInfo = new StreamFileInfo(paramString, paramInt1, false);
      localStreamFileInfo.b(paramInt2);
      try
      {
        localHashMap.put(paramString, localStreamFileInfo);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    return (localHashMap == null) || (!localHashMap.containsKey(paramString)) || (((StreamFileInfo)localHashMap.get(paramString)).b() != paramShort);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    return a(paramString, paramArrayOfByte, paramInt, paramShort, false);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort, boolean paramBoolean)
  {
    Object localObject1 = StreamMemoryPool.a();
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
    {
      localObject1 = (StreamFileInfo)((HashMap)localObject1).get(paramString);
      if (!paramBoolean) {}
      try
      {
        ((StreamFileInfo)localObject1).a().write(paramArrayOfByte);
        if (((StreamFileInfo)localObject1).a() == 0)
        {
          paramString = ((StreamFileInfo)localObject1).a();
          if (paramString.size() == 0)
          {
            localObject2 = new StreamDataInfo();
            System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject2).a(), 0, paramInt);
            ((StreamDataInfo)localObject2).a(paramInt);
            paramShort = ((StreamFileInfo)localObject1).b();
            s = (short)(paramShort + 1);
            ((StreamDataInfo)localObject2).a(paramShort);
            paramString.add(localObject2);
            ((StreamFileInfo)localObject1).b(s);
            return true;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject2;
          short s;
          if (QLog.isColorLevel())
          {
            QLog.d("StreamDataManager", 2, "write fail", paramString);
            continue;
            localObject2 = (StreamDataInfo)paramString.get(paramString.size() - 1);
            int i;
            if (((StreamDataInfo)localObject2).a() < 800)
            {
              i = 800 - ((StreamDataInfo)localObject2).a();
              if (i >= paramInt)
              {
                System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject2).a(), ((StreamDataInfo)localObject2).a(), paramInt);
                ((StreamDataInfo)localObject2).a(((StreamDataInfo)localObject2).a() + paramInt);
              }
              else
              {
                if (paramArrayOfByte.length <= i)
                {
                  System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject2).a(), ((StreamDataInfo)localObject2).a(), paramArrayOfByte.length);
                  ((StreamDataInfo)localObject2).a(((StreamDataInfo)localObject2).a() + paramArrayOfByte.length);
                  return true;
                }
                System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject2).a(), ((StreamDataInfo)localObject2).a(), i);
                ((StreamDataInfo)localObject2).a(800);
                paramInt = Math.min(paramArrayOfByte.length, paramInt) - i;
                localObject2 = new StreamDataInfo();
                System.arraycopy(paramArrayOfByte, i, ((StreamDataInfo)localObject2).a(), 0, paramInt);
                ((StreamDataInfo)localObject2).a(paramInt);
                paramShort = ((StreamFileInfo)localObject1).b();
                s = (short)(paramShort + 1);
                ((StreamDataInfo)localObject2).a(paramShort);
                paramString.add(localObject2);
                ((StreamFileInfo)localObject1).b(s);
              }
            }
            else
            {
              localObject2 = new StreamDataInfo();
              System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject2).a(), 0, paramInt);
              ((StreamDataInfo)localObject2).a(paramInt);
              paramShort = ((StreamFileInfo)localObject1).b();
              s = (short)(paramShort + 1);
              ((StreamDataInfo)localObject2).a(paramShort);
              paramString.add(localObject2);
              ((StreamFileInfo)localObject1).b(s);
              continue;
              if (((StreamFileInfo)localObject1).a() == 1)
              {
                localObject2 = ((StreamFileInfo)localObject1).a();
                paramInt = paramArrayOfByte.length;
                if (paramInt > 800)
                {
                  QLog.w("StreamDataManager", 2, "c2c ptt stream.segment len:" + paramInt);
                  StatisticCollector.a(BaseApplication.getContext()).a(null, "actStreamPttSegTooLong", false, 0L, 0L, null, "");
                }
                i = 0;
                if (paramInt > 0)
                {
                  if ((((List)localObject2).size() == 0) || (800 - ((StreamDataInfo)((List)localObject2).get(((List)localObject2).size() - 1)).a() <= 0))
                  {
                    paramString = new StreamDataInfo();
                    ((List)localObject2).add(paramString);
                  }
                  for (;;)
                  {
                    int k = 800 - paramString.a();
                    int j = k;
                    if (k >= paramInt) {
                      j = paramInt;
                    }
                    System.arraycopy(paramArrayOfByte, i, paramString.a(), paramString.a(), j);
                    i += j;
                    paramInt -= j;
                    paramString.a(j + paramString.a());
                    paramString.a(paramShort);
                    break;
                    paramString = (StreamDataInfo)((List)localObject2).get(((List)localObject2).size() - 1);
                  }
                }
                ((StreamFileInfo)localObject1).b((short)(paramShort + 1));
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public static byte[] a(String paramString, short paramShort)
  {
    Object localObject = StreamMemoryPool.a();
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      paramString = (StreamFileInfo)((HashMap)localObject).get(paramString);
      if (paramString != null)
      {
        int i = ((StreamDataInfo)paramString.a().get(paramShort - 1)).a();
        if (i != 800)
        {
          localObject = new byte[i];
          System.arraycopy(((StreamDataInfo)paramString.a().get(paramShort - 1)).a(), 0, localObject, 0, i);
          return localObject;
        }
        return ((StreamDataInfo)paramString.a().get(paramShort - 1)).a();
      }
    }
    return null;
  }
  
  public static int b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a().size();
      }
    }
    return 0;
  }
  
  public static short b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return 0;
  }
  
  public static void b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        int i = paramString.a().size();
        paramString.a((short)i);
        if (i >= 1) {
          ((StreamDataInfo)paramString.a().get(paramString.a().size() - 1)).a(true);
        }
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a;
      }
    }
    return false;
  }
  
  public static int c(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b();
      }
    }
    return -1;
  }
  
  public static short c(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b();
      }
    }
    return 0;
  }
  
  public static void c(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    List localList = StreamMemoryPool.a();
    if ((localList != null) && (!localList.contains(paramString)))
    {
      localList.add(paramString);
      return true;
    }
    return false;
  }
  
  public static int d(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    int i;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        i = paramString.a().size();
        if ((i < 1) || (((StreamDataInfo)paramString.a().get(i - 1)).b())) {
          return i;
        }
        return i - 1;
      }
    }
    return 0;
    return i;
  }
  
  public static boolean d(String paramString)
  {
    List localList = StreamMemoryPool.a();
    if ((localList != null) && (localList.contains(paramString)))
    {
      localList.remove(paramString);
      return true;
    }
    return false;
  }
  
  public static int e(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return -1;
  }
  
  public static boolean e(String paramString)
  {
    List localList = StreamMemoryPool.a();
    return (localList != null) && (localList.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamDataManager
 * JD-Core Version:    0.7.0.1
 */