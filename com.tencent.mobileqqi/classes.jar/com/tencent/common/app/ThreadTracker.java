package com.tencent.common.app;

import android.os.SystemClock;
import android.util.Log;
import bpu;
import bpw;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ThreadTracker
{
  private static final int jdField_a_of_type_Int = 20000;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  public static Vector a;
  private static boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_JavaUtilVector = new Vector(400);
  }
  
  public static Iterable a(Iterable paramIterable, boolean paramBoolean)
  {
    return new bpu(paramIterable, paramBoolean);
  }
  
  public static void a(String paramString)
  {
    try
    {
      Log.d("ThreadTracker", "start Thread tracking");
      jdField_a_of_type_Long = SystemClock.uptimeMillis();
      jdField_a_of_type_Boolean = true;
      jdField_a_of_type_JavaLangString = paramString;
      paramString = Thread.currentThread().getThreadGroup();
      Object localObject1 = paramString.getClass().getDeclaredField("threadRefs");
      ((Field)localObject1).setAccessible(true);
      Object localObject2 = new ThreadTracker.1((List)((Field)localObject1).get(paramString));
      ((Field)localObject1).set(paramString, localObject2);
      localObject1 = a((Iterable)localObject2, true);
      localObject2 = paramString.getClass().getDeclaredField("threads");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(paramString, localObject1);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static bpw b(long paramLong, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bpw localbpw = (bpw)paramList.next();
      if (bpw.a(localbpw) == paramLong) {
        return localbpw;
      }
    }
    return null;
  }
  
  public static void b(String paramString)
  {
    PrintStream localPrintStream;
    ArrayList localArrayList;
    Object localObject2;
    int j;
    try
    {
      localObject1 = new File(paramString);
      Log.d("ThreadTracker", "outputing " + paramString);
      localPrintStream = new PrintStream(new BufferedOutputStream(new FileOutputStream((File)localObject1, false)));
      localArrayList = new ArrayList(jdField_a_of_type_JavaUtilVector);
      localObject1 = Thread.currentThread().getThreadGroup();
      for (paramString = (String)localObject1; paramString != null; paramString = (String)localObject2)
      {
        localObject2 = paramString.getParent();
        localObject1 = paramString;
      }
      localObject2 = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
      i = ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
      paramString = new Thread[i];
      System.arraycopy(localObject2, 0, paramString, 0, i);
      j = paramString.length;
      i = 0;
      if (i < j)
      {
        localObject1 = paramString[i];
        localObject2 = b(((Thread)localObject1).getId(), localArrayList);
        if (localObject2 != null) {
          bpw.a((bpw)localObject2, ((Thread)localObject1).getName());
        } else {
          localArrayList.add(new bpw(((Thread)localObject1).getId(), ((Thread)localObject1).getName(), 0L, null));
        }
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    localPrintStream.println("Threads:");
    Object localObject1 = localArrayList.iterator();
    int i = 0;
    label220:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bpw)((Iterator)localObject1).next();
      if (!bpw.a((bpw)localObject2).startsWith("SharedPreferencesImpl"))
      {
        localPrintStream.println(i + "," + ((bpw)localObject2).toString());
        i += 1;
        break label575;
      }
    }
    else
    {
      localPrintStream.println("Stacks:");
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bpw)((Iterator)localObject1).next();
        if ((bpw.a((bpw)localObject2) != null) && (!bpw.a((bpw)localObject2).startsWith("SharedPreferencesImpl")))
        {
          localPrintStream.println("id:" + bpw.a((bpw)localObject2));
          localPrintStream.println("name:" + bpw.a((bpw)localObject2));
          bpw.a((bpw)localObject2).printStackTrace(localPrintStream);
          localPrintStream.println();
        }
      }
      localPrintStream.println("Running Threads.");
      localPrintStream.println();
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject1 = b(paramString[i].getId(), localArrayList);
        if (localObject1 != null)
        {
          localPrintStream.println("id:" + bpw.a((bpw)localObject1));
          localPrintStream.println("name:" + bpw.a((bpw)localObject1));
          if (bpw.a((bpw)localObject1) != null) {
            bpw.a((bpw)localObject1).printStackTrace(localPrintStream);
          }
          for (;;)
          {
            localPrintStream.println();
            break;
            localPrintStream.println("No Stack..");
          }
        }
      }
      else
      {
        localPrintStream.flush();
        localPrintStream.close();
        Log.d("ThreadTracker", "outputing done.");
        return;
        break label575;
        i += 1;
        break;
        label575:
        break label220;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.ThreadTracker
 * JD-Core Version:    0.7.0.1
 */