package com.tencent.qqmail.utilities;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class QMUtilities
{
  private static final String LIB_ART = "libart.so";
  private static final String LIB_ART_D = "libartd.so";
  private static final String LIB_DALVIK = "libdvm.so";
  private static final String SELECT_RUNTIME_PROPERTY = "persist.sys.dalvik.vm.lib";
  private static boolean isART;
  public static boolean isFadeBackground = false;
  private static boolean isOldART;
  
  static
  {
    reCheckIsART();
  }
  
  /* Error */
  public static boolean checkIsART()
  {
    // Byte code:
    //   0: ldc 42
    //   2: invokestatic 48	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: ldc 50
    //   9: iconst_2
    //   10: anewarray 44	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 52
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 52
    //   22: aastore
    //   23: invokevirtual 56	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +49 -> 77
    //   31: aload_2
    //   32: aload_1
    //   33: iconst_2
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: ldc 17
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc 58
    //   46: aastore
    //   47: invokevirtual 64	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 52	java/lang/String
    //   53: astore_1
    //   54: ldc 8
    //   56: aload_1
    //   57: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +14 -> 74
    //   63: ldc 11
    //   65: aload_1
    //   66: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: istore_0
    //   70: iload_0
    //   71: ifeq +6 -> 77
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_1
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_1
    //   80: goto -3 -> 77
    //   83: astore_1
    //   84: goto -7 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   69	2	0	bool	boolean
    //   5	61	1	localObject	Object
    //   76	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   79	1	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   83	1	1	localException	java.lang.Exception
    //   26	6	2	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   0	6	76	java/lang/ClassNotFoundException
    //   6	27	76	java/lang/ClassNotFoundException
    //   31	70	76	java/lang/ClassNotFoundException
    //   6	27	79	java/lang/NoSuchMethodException
    //   31	70	79	java/lang/NoSuchMethodException
    //   31	70	83	java/lang/Exception
  }
  
  public static boolean checkIsOldART()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!Build.VERSION.RELEASE.startsWith("4.4")) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      String[] arrayOfString = Build.VERSION.RELEASE.split("\\.");
      bool1 = bool2;
      if (arrayOfString.length >= 3) {
        try
        {
          int i = Integer.parseInt(arrayOfString[2]);
          bool1 = bool2;
          if (i >= 4) {
            return false;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    return true;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt) != -1;
  }
  
  public static String getCPUInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (new File("/proc/cpuinfo").exists()) {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          localStringBuffer.append(str + "\n");
        }
        return localStringBuffer.toString();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    for (;;)
    {
      if (localIOException != null) {
        localIOException.close();
      }
      localStringBuffer.append("isART: " + isART() + "\n");
      localStringBuffer.append("isOldART: " + isOldART() + "\n");
    }
  }
  
  @Deprecated
  public static String getFromActivity()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("fromActivity", "folderList");
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static boolean isART()
  {
    return isART;
  }
  
  public static boolean isOldART()
  {
    return (isART) && (isOldART);
  }
  
  public static int length(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static int randInt(int paramInt1, int paramInt2)
  {
    return new Random().nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
  }
  
  public static void reCheckIsART()
  {
    isART = checkIsART();
    isOldART = checkIsOldART();
  }
  
  @Deprecated
  public static void setFromActivity(String paramString)
  {
    if (paramString == null) {
      return;
    }
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putString("fromActivity", paramString).commit();
  }
  
  public static List<Object> uniqueContact(List<List<Object>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (List)paramList.next();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if ((localObject2 instanceof MailContact))
          {
            localObject2 = (MailContact)localObject2;
            Iterator localIterator = localArrayList.iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                MailContact localMailContact = (MailContact)localIterator.next();
                if (((MailContact)localObject2).getAddress().equals(localMailContact.getAddress())) {
                  break;
                }
              }
            }
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUtilities
 * JD-Core Version:    0.7.0.1
 */