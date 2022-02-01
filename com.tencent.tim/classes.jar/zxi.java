import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class zxi
{
  public String baZ;
  public String bba;
  public String bbb;
  @Deprecated
  public boolean bul;
  public long expireTime;
  public String extStr;
  public boolean isFinish;
  public boolean isOpen;
  public String redBagId;
  public String redBagIndex;
  public int type;
  private List<Integer> uO;
  
  public zxi() {}
  
  public zxi(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.redBagId = paramString1;
    this.redBagIndex = paramString2;
    this.baZ = paramString3;
    this.expireTime = paramLong;
    this.bba = paramString4;
    this.isOpen = paramBoolean1;
    this.isFinish = paramBoolean2;
    this.bul = paramBoolean3;
    this.type = paramInt;
  }
  
  public zxi(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
    this.bbb = paramString5;
  }
  
  public zxi(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString5);
    this.extStr = paramString6;
  }
  
  public static String hU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    if (paramString.length < 2) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        localJSONArray.put(Integer.parseInt(paramString[i]));
        label53:
        i += 1;
        continue;
        if (localJSONArray.length() > 0) {
          return localJSONArray.toString();
        }
        return "";
      }
      catch (Throwable localThrowable)
      {
        break label53;
      }
    }
  }
  
  public boolean VU()
  {
    return this.expireTime < NetConnInfoCenter.getServerTime();
  }
  
  /* Error */
  public List<Integer> dt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 110	zxi:uO	Ljava/util/List;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 110	zxi:uO	Ljava/util/List;
    //   13: astore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_3
    //   17: areturn
    //   18: aload_0
    //   19: new 112	java/util/LinkedList
    //   22: dup
    //   23: invokespecial 113	java/util/LinkedList:<init>	()V
    //   26: putfield 110	zxi:uO	Ljava/util/List;
    //   29: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +31 -> 63
    //   35: ldc 120
    //   37: iconst_2
    //   38: new 122	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   45: ldc 125
    //   47: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 57	zxi:extStr	Ljava/lang/String;
    //   54: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: new 136	org/json/JSONObject
    //   66: dup
    //   67: aload_0
    //   68: getfield 57	zxi:extStr	Ljava/lang/String;
    //   71: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   74: ldc 141
    //   76: invokevirtual 144	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifne +67 -> 151
    //   87: new 79	org/json/JSONArray
    //   90: dup
    //   91: aload_3
    //   92: invokespecial 145	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +87 -> 184
    //   100: aload_3
    //   101: invokevirtual 94	org/json/JSONArray:length	()I
    //   104: ifle +80 -> 184
    //   107: iconst_0
    //   108: istore_1
    //   109: aload_3
    //   110: invokevirtual 94	org/json/JSONArray:length	()I
    //   113: istore_2
    //   114: iload_1
    //   115: iload_2
    //   116: if_icmpge +68 -> 184
    //   119: aload_3
    //   120: iload_1
    //   121: invokevirtual 149	org/json/JSONArray:optInt	(I)I
    //   124: istore_2
    //   125: iload_2
    //   126: iconst_1
    //   127: if_icmple +17 -> 144
    //   130: aload_0
    //   131: getfield 110	zxi:uO	Ljava/util/List;
    //   134: iload_2
    //   135: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokeinterface 159 2 0
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -39 -> 109
    //   151: aconst_null
    //   152: astore_3
    //   153: goto -57 -> 96
    //   156: astore 4
    //   158: ldc 120
    //   160: iconst_1
    //   161: aload 4
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   170: goto -26 -> 144
    //   173: astore_3
    //   174: ldc 120
    //   176: iconst_1
    //   177: aload_3
    //   178: invokestatic 167	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   181: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: getfield 110	zxi:uO	Ljava/util/List;
    //   188: invokeinterface 172 1 0
    //   193: ifgt +17 -> 210
    //   196: aload_0
    //   197: getfield 110	zxi:uO	Ljava/util/List;
    //   200: iconst_0
    //   201: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: invokeinterface 159 2 0
    //   209: pop
    //   210: aload_0
    //   211: getfield 110	zxi:uO	Ljava/util/List;
    //   214: astore_3
    //   215: goto -201 -> 14
    //   218: astore_3
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_3
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	zxi
    //   108	40	1	i	int
    //   113	22	2	j	int
    //   13	140	3	localObject1	Object
    //   173	5	3	localThrowable1	Throwable
    //   214	1	3	localList	List
    //   218	4	3	localObject2	Object
    //   156	6	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   119	125	156	java/lang/Throwable
    //   130	144	156	java/lang/Throwable
    //   29	63	173	java/lang/Throwable
    //   63	96	173	java/lang/Throwable
    //   100	107	173	java/lang/Throwable
    //   109	114	173	java/lang/Throwable
    //   158	170	173	java/lang/Throwable
    //   2	14	218	finally
    //   18	29	218	finally
    //   29	63	218	finally
    //   63	96	218	finally
    //   100	107	218	finally
    //   109	114	218	finally
    //   119	125	218	finally
    //   130	144	218	finally
    //   158	170	218	finally
    //   174	184	218	finally
    //   184	210	218	finally
    //   210	215	218	finally
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof zxi))
    {
      paramObject = (zxi)paramObject;
      if (!TextUtils.isEmpty(this.redBagId)) {
        break label24;
      }
    }
    label24:
    while (!this.redBagId.equals(paramObject.redBagId)) {
      return false;
    }
    return true;
  }
  
  public boolean hs(int paramInt)
  {
    boolean bool1 = false;
    try
    {
      List localList = dt();
      if (!localList.contains(Integer.valueOf(paramInt)))
      {
        boolean bool2 = localList.contains(Integer.valueOf(0));
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  public int ys()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("passwdredinfo", 2, "[getWordChainSubChannel] " + this.extStr);
      }
      int i = new JSONObject(this.extStr).optInt("key_sub_channel");
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, QLog.getStackTraceString(localThrowable));
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxi
 * JD-Core Version:    0.7.0.1
 */