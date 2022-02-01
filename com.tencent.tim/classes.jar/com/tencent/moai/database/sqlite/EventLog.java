package com.tencent.moai.database.sqlite;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.HashMap;

public class EventLog
{
  private static final String COMMENT_PATTERN = "^\\s*(#.*)?$";
  private static final String TAG = "EventLog";
  private static final String TAGS_FILE = "/system/etc/event-log-tags";
  private static final String TAG_PATTERN = "^\\s*(\\d+)\\s+(\\w+)\\s*(\\(.*\\))?\\s*$";
  private static HashMap<String, Integer> sTagCodes = null;
  private static HashMap<Integer, String> sTagNames = null;
  
  public static int getTagCode(String paramString)
  {
    readTagsFile();
    paramString = (Integer)sTagCodes.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public static String getTagName(int paramInt)
  {
    readTagsFile();
    return (String)sTagNames.get(Integer.valueOf(paramInt));
  }
  
  public static native void readEvents(int[] paramArrayOfInt, Collection<Event> paramCollection)
    throws IOException;
  
  /* Error */
  private static void readTagsFile()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	com/tencent/moai/database/sqlite/EventLog:sTagCodes	Ljava/util/HashMap;
    //   6: ifnull +15 -> 21
    //   9: getstatic 31	com/tencent/moai/database/sqlite/EventLog:sTagNames	Ljava/util/HashMap;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: new 42	java/util/HashMap
    //   24: dup
    //   25: invokespecial 67	java/util/HashMap:<init>	()V
    //   28: putstatic 29	com/tencent/moai/database/sqlite/EventLog:sTagCodes	Ljava/util/HashMap;
    //   31: new 42	java/util/HashMap
    //   34: dup
    //   35: invokespecial 67	java/util/HashMap:<init>	()V
    //   38: putstatic 31	com/tencent/moai/database/sqlite/EventLog:sTagNames	Ljava/util/HashMap;
    //   41: ldc 11
    //   43: invokestatic 73	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   46: astore_3
    //   47: ldc 20
    //   49: invokestatic 73	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   52: astore 4
    //   54: new 75	java/io/BufferedReader
    //   57: dup
    //   58: new 77	java/io/FileReader
    //   61: dup
    //   62: ldc 17
    //   64: invokespecial 80	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   67: sipush 256
    //   70: invokespecial 83	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   73: astore_2
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: invokevirtual 87	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull +204 -> 288
    //   87: aload_2
    //   88: astore_1
    //   89: aload_3
    //   90: aload 5
    //   92: invokevirtual 91	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   95: invokevirtual 97	java/util/regex/Matcher:matches	()Z
    //   98: ifne -24 -> 74
    //   101: aload_2
    //   102: astore_1
    //   103: aload 4
    //   105: aload 5
    //   107: invokevirtual 91	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   110: astore 6
    //   112: aload_2
    //   113: astore_1
    //   114: aload 6
    //   116: invokevirtual 97	java/util/regex/Matcher:matches	()Z
    //   119: ifne +59 -> 178
    //   122: aload_2
    //   123: astore_1
    //   124: ldc 14
    //   126: new 99	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   133: ldc 102
    //   135: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 5
    //   140: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 115	com/tencent/moai/database/sqlite/SQLiteDebug$Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -75 -> 74
    //   152: astore_3
    //   153: aload_2
    //   154: astore_1
    //   155: ldc 14
    //   157: ldc 117
    //   159: aload_3
    //   160: invokestatic 120	com/tencent/moai/database/sqlite/SQLiteDebug$Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: ifnull -147 -> 17
    //   167: aload_2
    //   168: invokevirtual 123	java/io/BufferedReader:close	()V
    //   171: goto -154 -> 17
    //   174: astore_1
    //   175: goto -158 -> 17
    //   178: aload_2
    //   179: astore_1
    //   180: aload 6
    //   182: iconst_1
    //   183: invokevirtual 126	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   186: invokestatic 129	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   189: istore_0
    //   190: aload_2
    //   191: astore_1
    //   192: aload 6
    //   194: iconst_2
    //   195: invokevirtual 126	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   198: astore 6
    //   200: aload_2
    //   201: astore_1
    //   202: getstatic 29	com/tencent/moai/database/sqlite/EventLog:sTagCodes	Ljava/util/HashMap;
    //   205: aload 6
    //   207: iload_0
    //   208: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: aload_2
    //   216: astore_1
    //   217: getstatic 31	com/tencent/moai/database/sqlite/EventLog:sTagNames	Ljava/util/HashMap;
    //   220: iload_0
    //   221: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: aload 6
    //   226: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: goto -156 -> 74
    //   233: astore 6
    //   235: aload_2
    //   236: astore_1
    //   237: ldc 14
    //   239: new 99	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   246: ldc 135
    //   248: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 5
    //   253: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aload 6
    //   261: invokestatic 120	com/tencent/moai/database/sqlite/SQLiteDebug$Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -190 -> 74
    //   267: astore_3
    //   268: aload_1
    //   269: astore_2
    //   270: aload_3
    //   271: astore_1
    //   272: aload_2
    //   273: ifnull +7 -> 280
    //   276: aload_2
    //   277: invokevirtual 123	java/io/BufferedReader:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: ldc 2
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: aload_2
    //   289: ifnull -272 -> 17
    //   292: aload_2
    //   293: invokevirtual 123	java/io/BufferedReader:close	()V
    //   296: goto -279 -> 17
    //   299: astore_1
    //   300: goto -283 -> 17
    //   303: astore_2
    //   304: goto -24 -> 280
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -38 -> 272
    //   313: astore_3
    //   314: aconst_null
    //   315: astore_2
    //   316: goto -163 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   189	32	0	i	int
    //   12	143	1	localObject1	Object
    //   174	1	1	localIOException1	IOException
    //   179	102	1	localObject2	Object
    //   282	5	1	localObject3	Object
    //   299	1	1	localIOException2	IOException
    //   307	1	1	localObject4	Object
    //   73	220	2	localObject5	Object
    //   303	1	2	localIOException3	IOException
    //   309	7	2	localObject6	Object
    //   46	44	3	localPattern1	java.util.regex.Pattern
    //   152	8	3	localIOException4	IOException
    //   267	4	3	localObject7	Object
    //   313	1	3	localIOException5	IOException
    //   52	52	4	localPattern2	java.util.regex.Pattern
    //   80	172	5	str	String
    //   110	115	6	localObject8	Object
    //   233	27	6	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   76	82	152	java/io/IOException
    //   89	101	152	java/io/IOException
    //   103	112	152	java/io/IOException
    //   114	122	152	java/io/IOException
    //   124	149	152	java/io/IOException
    //   180	190	152	java/io/IOException
    //   192	200	152	java/io/IOException
    //   202	215	152	java/io/IOException
    //   217	230	152	java/io/IOException
    //   237	264	152	java/io/IOException
    //   167	171	174	java/io/IOException
    //   180	190	233	java/lang/NumberFormatException
    //   192	200	233	java/lang/NumberFormatException
    //   202	215	233	java/lang/NumberFormatException
    //   217	230	233	java/lang/NumberFormatException
    //   76	82	267	finally
    //   89	101	267	finally
    //   103	112	267	finally
    //   114	122	267	finally
    //   124	149	267	finally
    //   155	163	267	finally
    //   180	190	267	finally
    //   192	200	267	finally
    //   202	215	267	finally
    //   217	230	267	finally
    //   237	264	267	finally
    //   3	13	282	finally
    //   21	54	282	finally
    //   167	171	282	finally
    //   276	280	282	finally
    //   280	282	282	finally
    //   292	296	282	finally
    //   292	296	299	java/io/IOException
    //   276	280	303	java/io/IOException
    //   54	74	307	finally
    //   54	74	313	java/io/IOException
  }
  
  public static native int writeEvent(int paramInt1, int paramInt2);
  
  public static native int writeEvent(int paramInt, long paramLong);
  
  public static native int writeEvent(int paramInt, String paramString);
  
  public static native int writeEvent(int paramInt, Object... paramVarArgs);
  
  public static final class Event
  {
    private static final int DATA_START = 24;
    private static final byte INT_TYPE = 0;
    private static final int LENGTH_OFFSET = 0;
    private static final byte LIST_TYPE = 3;
    private static final byte LONG_TYPE = 1;
    private static final int NANOSECONDS_OFFSET = 16;
    private static final int PAYLOAD_START = 20;
    private static final int PROCESS_OFFSET = 4;
    private static final int SECONDS_OFFSET = 12;
    private static final byte STRING_TYPE = 2;
    private static final int TAG_OFFSET = 20;
    private static final int THREAD_OFFSET = 8;
    private final ByteBuffer mBuffer;
    
    Event(byte[] paramArrayOfByte)
    {
      this.mBuffer = ByteBuffer.wrap(paramArrayOfByte);
      this.mBuffer.order(ByteOrder.nativeOrder());
    }
    
    private Object decodeObject()
    {
      int i = this.mBuffer.get();
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Unknown entry type: " + i);
      case 0: 
        return Integer.valueOf(this.mBuffer.getInt());
      case 1: 
        return Long.valueOf(this.mBuffer.getLong());
      case 2: 
        try
        {
          i = this.mBuffer.getInt();
          j = this.mBuffer.position();
          this.mBuffer.position(j + i);
          String str = new String(this.mBuffer.array(), j, i, "UTF-8");
          return str;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          SQLiteDebug.Log.e("EventLog", "UTF-8 is not supported", localUnsupportedEncodingException);
          return null;
        }
      }
      int j = this.mBuffer.get();
      i = j;
      if (j < 0) {
        i = j + 256;
      }
      Object[] arrayOfObject = new Object[i];
      j = 0;
      while (j < i)
      {
        arrayOfObject[j] = decodeObject();
        j += 1;
      }
      return arrayOfObject;
    }
    
    /* Error */
    public Object getData()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 46	com/tencent/moai/database/sqlite/EventLog$Event:mBuffer	Ljava/nio/ByteBuffer;
      //   8: aload_0
      //   9: getfield 46	com/tencent/moai/database/sqlite/EventLog$Event:mBuffer	Ljava/nio/ByteBuffer;
      //   12: iconst_0
      //   13: invokevirtual 141	java/nio/ByteBuffer:getShort	(I)S
      //   16: bipush 20
      //   18: iadd
      //   19: invokevirtual 144	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
      //   22: pop
      //   23: aload_0
      //   24: getfield 46	com/tencent/moai/database/sqlite/EventLog$Event:mBuffer	Ljava/nio/ByteBuffer;
      //   27: bipush 24
      //   29: invokevirtual 111	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   32: pop
      //   33: aload_0
      //   34: invokespecial 134	com/tencent/moai/database/sqlite/EventLog$Event:decodeObject	()Ljava/lang/Object;
      //   37: astore_2
      //   38: aload_2
      //   39: astore_1
      //   40: aload_0
      //   41: monitorexit
      //   42: aload_1
      //   43: areturn
      //   44: astore_2
      //   45: ldc 124
      //   47: new 69	java/lang/StringBuilder
      //   50: dup
      //   51: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   54: ldc 146
      //   56: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: aload_0
      //   60: invokevirtual 149	com/tencent/moai/database/sqlite/EventLog$Event:getTag	()I
      //   63: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   66: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   69: aload_2
      //   70: invokestatic 132	com/tencent/moai/database/sqlite/SQLiteDebug$Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   73: goto -33 -> 40
      //   76: astore_1
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      //   81: astore_2
      //   82: ldc 124
      //   84: new 69	java/lang/StringBuilder
      //   87: dup
      //   88: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   91: ldc 151
      //   93: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   96: aload_0
      //   97: invokevirtual 149	com/tencent/moai/database/sqlite/EventLog$Event:getTag	()I
      //   100: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   103: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   106: aload_2
      //   107: invokestatic 132	com/tencent/moai/database/sqlite/SQLiteDebug$Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   110: goto -70 -> 40
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	this	Event
      //   1	42	1	localObject1	Object
      //   76	4	1	localObject2	Object
      //   37	2	2	localObject3	Object
      //   44	26	2	localIllegalArgumentException	IllegalArgumentException
      //   81	26	2	localBufferUnderflowException	java.nio.BufferUnderflowException
      // Exception table:
      //   from	to	target	type
      //   4	38	44	java/lang/IllegalArgumentException
      //   4	38	76	finally
      //   45	73	76	finally
      //   82	110	76	finally
      //   4	38	81	java/nio/BufferUnderflowException
    }
    
    public int getProcessId()
    {
      return this.mBuffer.getInt(4);
    }
    
    public int getTag()
    {
      return this.mBuffer.getInt(20);
    }
    
    public int getThreadId()
    {
      return this.mBuffer.getInt(8);
    }
    
    public long getTimeNanos()
    {
      return this.mBuffer.getInt(12) * 1000000000L + this.mBuffer.getInt(16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.EventLog
 * JD-Core Version:    0.7.0.1
 */