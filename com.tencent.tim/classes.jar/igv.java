import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class igv
{
  public static String TAG = "AvSessionMgr";
  static volatile igv jdField_a_of_type_Igv;
  private iiv jdField_a_of_type_Iiv = new iiv();
  private Map<String, iiv> cM = new HashMap();
  
  public static igv a()
  {
    if (jdField_a_of_type_Igv == null) {}
    try
    {
      if (jdField_a_of_type_Igv == null) {
        jdField_a_of_type_Igv = new igv();
      }
      return jdField_a_of_type_Igv;
    }
    finally {}
  }
  
  public static String a(int paramInt, String paramString, int... paramVarArgs)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("+")) {
        str = paramString.substring(1);
      }
    }
    str = String.valueOf(paramInt) + "-" + str;
    paramString = str;
    if (paramInt == 1)
    {
      paramString = str;
      if (paramVarArgs != null)
      {
        paramString = str;
        if (paramVarArgs.length == 1) {
          paramString = str + "-" + paramVarArgs[0];
        }
      }
    }
    return paramString;
  }
  
  public static boolean a(iiv paramiiv)
  {
    boolean bool = true;
    if (paramiiv == null) {}
    do
    {
      do
      {
        return false;
        if (paramiiv.uinType != -1)
        {
          if ((paramiiv.uinType != 3000) && (paramiiv.uinType != 1)) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
        if (paramiiv.relationType == 0) {
          break;
        }
      } while ((paramiiv.relationType != 3) && (paramiiv.relationType != 100) && (paramiiv.relationType != 4));
      return true;
      if (paramiiv.Qw) {
        return true;
      }
    } while (!paramiiv.QH);
    return false;
  }
  
  public static int cn(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1011: 
    default: 
      return 3;
    case 3000: 
      return 2;
    }
    return 1;
  }
  
  public void N(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!this.cM.containsKey(paramString)) {
          break label236;
        }
        Object localObject = (iiv)this.cM.get(paramString);
        if (localObject == null)
        {
          i = 1;
          j = -1;
          if ((QLog.isColorLevel()) || (j != paramInt) || (i != 0))
          {
            localObject = TAG;
            StringBuilder localStringBuilder = new StringBuilder().append("setSessionStatus, sessionId[").append(paramString).append("], status[");
            if (i != 0) {
              continue;
            }
            paramString = j + "->" + paramInt;
            QLog.w((String)localObject, 1, paramString + "]");
          }
        }
        else
        {
          j = ((iiv)localObject).amH;
          if (((iiv)localObject).amH != paramInt)
          {
            if (paramInt == 2) {
              this.jdField_a_of_type_Iiv = ((iiv)localObject);
            }
            ((iiv)localObject).amH = paramInt;
            i = 0;
            continue;
          }
          if ((paramInt != 2) || (this.jdField_a_of_type_Iiv == localObject)) {
            break label231;
          }
          this.jdField_a_of_type_Iiv = ((iiv)localObject);
          i = 2;
          continue;
        }
        paramString = paramInt + "], step[" + i;
        continue;
        i = 0;
      }
      finally {}
      label231:
      continue;
      label236:
      int i = 0;
      int j = -1;
    }
  }
  
  public iiv a()
  {
    try
    {
      iiv localiiv = this.jdField_a_of_type_Iiv;
      return localiiv;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public iiv a(String paramString)
  {
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2) {
      try
      {
        Iterator localIterator = this.cM.keySet().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = (iiv)this.cM.get(localObject2);
          if ((localObject2 != null) && (((iiv)localObject2).peerUin != null) && (((iiv)localObject2).peerUin.equals(paramString)))
          {
            if (localObject1 != null)
            {
              boolean bool = a((iiv)localObject2);
              if (bool) {}
            }
          }
          else {
            localObject2 = localObject1;
          }
        }
        else
        {
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public iiv a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "createSession with null sessionId ");
          }
          localiiv = null;
          return localiiv;
        }
        if (this.cM.get(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "createSession already exist sessionId : " + paramString);
          }
          localiiv = (iiv)this.cM.get(paramString);
          continue;
        }
        if (this.cM.isEmpty())
        {
          localiiv = this.jdField_a_of_type_Iiv;
          this.cM.put(paramString, localiiv);
          localiiv.aP("createSession", paramString);
          QLog.w(TAG, 1, "createSession, sessionId[" + paramString + "], TAG[" + localiiv.TAG + "]");
          if ((this.cM.size() != 1) && (!paramBoolean)) {
            break label213;
          }
          N(paramString, 2);
          continue;
        }
        iiv localiiv = new iiv();
      }
      finally {}
      continue;
      label213:
      N(paramString, 1);
    }
  }
  
  public iiv b(String paramString)
  {
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2) {
      try
      {
        Iterator localIterator = this.cM.keySet().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          localObject2 = (iiv)this.cM.get(localObject2);
          if ((localObject2 != null) && (TextUtils.equals(paramString, ((iiv)localObject2).peerUin)))
          {
            if ((localObject1 == null) && (!((iiv)localObject2).Qw)) {
              continue;
            }
            if (a((iiv)localObject2))
            {
              boolean bool = ((iiv)localObject2).Qw;
              if (!bool) {
                continue;
              }
            }
          }
          localObject2 = localObject1;
        }
        else
        {
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public iiv c(String paramString)
  {
    try
    {
      if ((!this.cM.containsKey(paramString)) && (QLog.isColorLevel())) {
        QLog.e(TAG, 2, "getSession not exist sessionId : " + paramString);
      }
      paramString = (iiv)this.cM.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public boolean c(long paramLong, String paramString)
  {
    boolean bool;
    iiv localiiv;
    try
    {
      bool = this.cM.containsKey(paramString);
      QLog.w(TAG, 1, "removeSession, sessionId[" + paramString + "], size[" + this.cM.size() + "], contains[" + bool + "], seq[" + paramLong + "]");
      if (bool)
      {
        localiiv = (iiv)this.cM.remove(paramString);
        if (this.cM.size() == 1)
        {
          Iterator localIterator = this.cM.keySet().iterator();
          while (localIterator.hasNext()) {
            cj((String)localIterator.next());
          }
        }
      }
      else
      {
        bool = false;
      }
    }
    finally {}
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_Iiv == localiiv)
      {
        this.jdField_a_of_type_Iiv = new iiv();
        QLog.i(TAG, 1, "removeSession, active is cur need remove one. id[" + paramString + "]");
      }
      bool = true;
    }
  }
  
  public boolean ci(String paramString)
  {
    try
    {
      boolean bool = this.cM.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean cj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +43 -> 48
    //   8: getstatic 18	igv:TAG	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 57	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   19: ldc 225
    //   21: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 117
    //   30: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: new 227	java/lang/Throwable
    //   39: dup
    //   40: ldc 229
    //   42: invokespecial 232	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   45: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_0
    //   49: getfield 32	igv:cM	Ljava/util/Map;
    //   52: aload_1
    //   53: invokeinterface 99 2 0
    //   58: ifeq +15 -> 73
    //   61: aload_0
    //   62: aload_1
    //   63: iconst_2
    //   64: invokevirtual 189	igv:N	(Ljava/lang/String;I)V
    //   67: iconst_1
    //   68: istore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: iload_2
    //   72: ireturn
    //   73: iconst_0
    //   74: istore_2
    //   75: goto -6 -> 69
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	igv
    //   0	83	1	paramString	String
    //   68	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	48	78	finally
    //   48	67	78	finally
  }
  
  public int kv()
  {
    int i;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.cM.keySet().iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (String)localIterator.next();
        iiv localiiv = (iiv)this.cM.get(localObject2);
        int j = i;
        if (!localiiv.sY()) {
          j = i + 1;
        }
        i = j;
        if (QLog.isColorLevel())
        {
          String str = TAG;
          localObject2 = new StringBuilder().append("getAliveSessionCount, count[").append(j).append("], key[").append((String)localObject2).append("], main[");
          boolean bool;
          if (localiiv == this.jdField_a_of_type_Iiv)
          {
            bool = true;
            QLog.w(str, 1, bool + "], session[" + localiiv + "]");
            i = j;
          }
          else
          {
            bool = false;
          }
        }
      }
      finally {}
    }
    return i;
  }
  
  /* Error */
  public boolean sk()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 253	igv:kv	()I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmple +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	igv
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  /* Error */
  public boolean sl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	igv:cM	Ljava/util/Map;
    //   6: invokeinterface 132 1 0
    //   11: invokeinterface 138 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 143 1 0
    //   23: ifeq +40 -> 63
    //   26: aload_2
    //   27: invokeinterface 147 1 0
    //   32: checkcast 47	java/lang/String
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 32	igv:cM	Ljava/util/Map;
    //   40: aload_3
    //   41: invokeinterface 103 2 0
    //   46: checkcast 24	iiv
    //   49: invokevirtual 239	iiv:sY	()Z
    //   52: istore_1
    //   53: iload_1
    //   54: ifne -37 -> 17
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -6 -> 59
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	igv
    //   52	13	1	bool	boolean
    //   16	11	2	localIterator	Iterator
    //   68	4	2	localObject	Object
    //   35	6	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   17	53	68	finally
  }
  
  /* Error */
  @java.lang.Deprecated
  public boolean u(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: getstatic 18	igv:TAG	Ljava/lang/String;
    //   11: iconst_2
    //   12: new 57	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 259
    //   22: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 261
    //   32: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: getfield 32	igv:cM	Ljava/util/Map;
    //   49: aload_1
    //   50: invokeinterface 99 2 0
    //   55: ifne +25 -> 80
    //   58: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +13 -> 74
    //   64: getstatic 18	igv:TAG	Ljava/lang/String;
    //   67: iconst_2
    //   68: ldc_w 263
    //   71: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: iconst_0
    //   75: istore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: iload_3
    //   79: ireturn
    //   80: aload_0
    //   81: getfield 32	igv:cM	Ljava/util/Map;
    //   84: aload_1
    //   85: invokeinterface 103 2 0
    //   90: checkcast 24	iiv
    //   93: astore 4
    //   95: aload 4
    //   97: ldc_w 265
    //   100: aload_2
    //   101: invokevirtual 178	iiv:aP	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 32	igv:cM	Ljava/util/Map;
    //   108: aload_1
    //   109: invokeinterface 214 2 0
    //   114: pop
    //   115: aload_0
    //   116: getfield 32	igv:cM	Ljava/util/Map;
    //   119: aload_2
    //   120: aload 4
    //   122: invokeinterface 172 3 0
    //   127: pop
    //   128: iconst_1
    //   129: istore_3
    //   130: goto -54 -> 76
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	igv
    //   0	138	1	paramString1	String
    //   0	138	2	paramString2	String
    //   75	55	3	bool	boolean
    //   93	28	4	localiiv	iiv
    // Exception table:
    //   from	to	target	type
    //   2	45	133	finally
    //   45	74	133	finally
    //   80	128	133	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igv
 * JD-Core Version:    0.7.0.1
 */