package org.slf4j.helpers;

import java.io.PrintStream;

public final class Util
{
  private static ClassContextSecurityManager SECURITY_MANAGER;
  private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;
  
  public static Class<?> getCallingClass()
  {
    Object localObject = getSecurityManager();
    if (localObject == null) {
      return null;
    }
    localObject = ((ClassContextSecurityManager)localObject).getClassContext();
    String str = Util.class.getName();
    int i = 0;
    for (;;)
    {
      if ((i >= localObject.length) || (str.equals(localObject[i].getName())))
      {
        if ((i < localObject.length) && (i + 2 < localObject.length)) {
          break;
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
      }
      i += 1;
    }
    return localObject[(i + 2)];
  }
  
  private static ClassContextSecurityManager getSecurityManager()
  {
    if (SECURITY_MANAGER != null) {
      return SECURITY_MANAGER;
    }
    if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
      return null;
    }
    SECURITY_MANAGER = safeCreateSecurityManager();
    SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
    return SECURITY_MANAGER;
  }
  
  public static final void report(String paramString)
  {
    System.err.println("SLF4J: " + paramString);
  }
  
  public static final void report(String paramString, Throwable paramThrowable)
  {
    System.err.println(paramString);
    System.err.println("Reported exception:");
    paramThrowable.printStackTrace();
  }
  
  private static ClassContextSecurityManager safeCreateSecurityManager()
  {
    try
    {
      ClassContextSecurityManager localClassContextSecurityManager = new ClassContextSecurityManager(null);
      return localClassContextSecurityManager;
    }
    catch (SecurityException localSecurityException) {}
    return null;
  }
  
  public static boolean safeGetBooleanSystemProperty(String paramString)
  {
    paramString = safeGetSystemProperty(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.equalsIgnoreCase("true");
  }
  
  public static String safeGetSystemProperty(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input");
    }
    try
    {
      paramString = System.getProperty(paramString);
      return paramString;
    }
    catch (SecurityException paramString) {}
    return null;
  }
  
  static final class ClassContextSecurityManager
    extends SecurityManager
  {
    protected Class<?>[] getClassContext()
    {
      return super.getClassContext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.helpers.Util
 * JD-Core Version:    0.7.0.1
 */