package org.apache.commons.lang3.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class ExceptionUtils
{
  private static final String[] CAUSE_METHOD_NAMES = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  static final String WRAPPED_MARKER = " [wrapped] ";
  
  @Deprecated
  public static Throwable getCause(Throwable paramThrowable)
  {
    return getCause(paramThrowable, CAUSE_METHOD_NAMES);
  }
  
  @Deprecated
  public static Throwable getCause(Throwable paramThrowable, String[] paramArrayOfString)
  {
    if (paramThrowable == null) {}
    for (;;)
    {
      return null;
      String[] arrayOfString = paramArrayOfString;
      if (paramArrayOfString == null) {
        arrayOfString = CAUSE_METHOD_NAMES;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfString = arrayOfString[i];
        if (paramArrayOfString != null)
        {
          paramArrayOfString = getCauseUsingMethodName(paramThrowable, paramArrayOfString);
          if (paramArrayOfString != null) {
            return paramArrayOfString;
          }
        }
        i += 1;
      }
    }
  }
  
  private static Throwable getCauseUsingMethodName(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, new Class[0]);
      if ((paramString == null) || (!Throwable.class.isAssignableFrom(paramString.getReturnType()))) {}
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        try
        {
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, new Object[0]);
          return paramThrowable;
        }
        catch (InvocationTargetException paramThrowable)
        {
          return null;
        }
        catch (IllegalArgumentException paramThrowable)
        {
          continue;
        }
        catch (IllegalAccessException paramThrowable)
        {
          continue;
        }
        paramString = paramString;
        paramString = null;
      }
    }
    catch (SecurityException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  @Deprecated
  public static String[] getDefaultCauseMethodNames()
  {
    return (String[])ArrayUtils.clone(CAUSE_METHOD_NAMES);
  }
  
  public static String getMessage(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    String str = ClassUtils.getShortClassName(paramThrowable, null);
    paramThrowable = paramThrowable.getMessage();
    return str + ": " + StringUtils.defaultString(paramThrowable);
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    paramThrowable = getThrowableList(paramThrowable);
    if (paramThrowable.size() < 2) {
      return null;
    }
    return (Throwable)paramThrowable.get(paramThrowable.size() - 1);
  }
  
  public static String getRootCauseMessage(Throwable paramThrowable)
  {
    Throwable localThrowable = getRootCause(paramThrowable);
    if (localThrowable == null) {}
    for (;;)
    {
      return getMessage(paramThrowable);
      paramThrowable = localThrowable;
    }
  }
  
  public static String[] getRootCauseStackTrace(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
    int j = arrayOfThrowable.length;
    ArrayList localArrayList = new ArrayList();
    paramThrowable = getStackFrameList(arrayOfThrowable[(j - 1)]);
    int i = j;
    int k = i - 1;
    Object localObject;
    if (k >= 0)
    {
      if (k == 0) {
        break label189;
      }
      localObject = getStackFrameList(arrayOfThrowable[(k - 1)]);
      removeCommonFrames(paramThrowable, (List)localObject);
    }
    for (;;)
    {
      if (k == j - 1) {
        localArrayList.add(arrayOfThrowable[k].toString());
      }
      for (;;)
      {
        i = 0;
        while (i < paramThrowable.size())
        {
          localArrayList.add(paramThrowable.get(i));
          i += 1;
        }
        localArrayList.add(" [wrapped] " + arrayOfThrowable[k].toString());
      }
      i = k;
      paramThrowable = (Throwable)localObject;
      break;
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      label189:
      localObject = paramThrowable;
    }
  }
  
  static List<String> getStackFrameList(Throwable paramThrowable)
  {
    paramThrowable = new StringTokenizer(getStackTrace(paramThrowable), SystemUtils.LINE_SEPARATOR);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    do
    {
      for (;;)
      {
        if (!paramThrowable.hasMoreTokens()) {
          return localArrayList;
        }
        String str = paramThrowable.nextToken();
        int j = str.indexOf("at");
        if ((j == -1) || (!str.substring(0, j).trim().isEmpty())) {
          break;
        }
        i = 1;
        localArrayList.add(str);
      }
    } while (i == 0);
    return localArrayList;
  }
  
  static String[] getStackFrames(String paramString)
  {
    paramString = new StringTokenizer(paramString, SystemUtils.LINE_SEPARATOR);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] getStackFrames(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    return getStackFrames(getStackTrace(paramThrowable));
  }
  
  public static String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static int getThrowableCount(Throwable paramThrowable)
  {
    return getThrowableList(paramThrowable).size();
  }
  
  public static List<Throwable> getThrowableList(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    while ((paramThrowable != null) && (!localArrayList.contains(paramThrowable)))
    {
      localArrayList.add(paramThrowable);
      paramThrowable = getCause(paramThrowable);
    }
    return localArrayList;
  }
  
  public static Throwable[] getThrowables(Throwable paramThrowable)
  {
    paramThrowable = getThrowableList(paramThrowable);
    return (Throwable[])paramThrowable.toArray(new Throwable[paramThrowable.size()]);
  }
  
  private static int indexOf(Throwable paramThrowable, Class<?> paramClass, int paramInt, boolean paramBoolean)
  {
    if ((paramThrowable == null) || (paramClass == null))
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramThrowable = getThrowables(paramThrowable);
    if (i >= paramThrowable.length) {
      return -1;
    }
    paramInt = i;
    if (paramBoolean) {
      for (;;)
      {
        if (i >= paramThrowable.length) {
          break label101;
        }
        paramInt = i;
        if (paramClass.isAssignableFrom(paramThrowable[i].getClass())) {
          break;
        }
        i += 1;
      }
    }
    do
    {
      paramInt += 1;
      if (paramInt >= paramThrowable.length) {
        break;
      }
    } while (!paramClass.equals(paramThrowable[paramInt].getClass()));
    return paramInt;
    label101:
    return -1;
  }
  
  public static int indexOfThrowable(Throwable paramThrowable, Class<?> paramClass)
  {
    return indexOf(paramThrowable, paramClass, 0, false);
  }
  
  public static int indexOfThrowable(Throwable paramThrowable, Class<?> paramClass, int paramInt)
  {
    return indexOf(paramThrowable, paramClass, paramInt, false);
  }
  
  public static int indexOfType(Throwable paramThrowable, Class<?> paramClass)
  {
    return indexOf(paramThrowable, paramClass, 0, true);
  }
  
  public static int indexOfType(Throwable paramThrowable, Class<?> paramClass, int paramInt)
  {
    return indexOf(paramThrowable, paramClass, paramInt, true);
  }
  
  public static void printRootCauseStackTrace(Throwable paramThrowable)
  {
    printRootCauseStackTrace(paramThrowable, System.err);
  }
  
  public static void printRootCauseStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    if (paramThrowable == null) {
      return;
    }
    if (paramPrintStream == null) {
      throw new IllegalArgumentException("The PrintStream must not be null");
    }
    paramThrowable = getRootCauseStackTrace(paramThrowable);
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      paramPrintStream.println(paramThrowable[i]);
      i += 1;
    }
    paramPrintStream.flush();
  }
  
  public static void printRootCauseStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    if (paramThrowable == null) {
      return;
    }
    if (paramPrintWriter == null) {
      throw new IllegalArgumentException("The PrintWriter must not be null");
    }
    paramThrowable = getRootCauseStackTrace(paramThrowable);
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      paramPrintWriter.println(paramThrowable[i]);
      i += 1;
    }
    paramPrintWriter.flush();
  }
  
  public static void removeCommonFrames(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      throw new IllegalArgumentException("The List must not be null");
    }
    int i = paramList1.size();
    int j = paramList2.size() - 1;
    i -= 1;
    while ((i >= 0) && (j >= 0))
    {
      if (((String)paramList1.get(i)).equals((String)paramList2.get(j))) {
        paramList1.remove(i);
      }
      j -= 1;
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.exception.ExceptionUtils
 * JD-Core Version:    0.7.0.1
 */