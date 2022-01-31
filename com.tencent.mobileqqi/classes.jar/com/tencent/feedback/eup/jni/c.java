package com.tencent.feedback.eup.jni;

import com.tencent.feedback.common.e;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements Runnable
{
  private File a;
  private long b;
  private int c;
  private int d;
  
  public c(String paramString, long paramLong, int paramInt)
  {
    this.a = new File(paramString);
    this.b = paramLong;
    this.c = paramInt;
  }
  
  private static void a(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      e.c("rqdp{  fileNameList == null || fileNameList.length <= 0}", new Object[0]);
    }
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramString, paramArrayOfString[i]);
        if ((localFile.exists()) && (localFile.canWrite()))
        {
          e.b("rqdp{  file delete} %s", new Object[] { localFile.getPath() });
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public final void run()
  {
    this.d = 0;
    if ((this.a == null) || (!this.a.exists()) || (!this.a.isDirectory()))
    {
      e.c("rqdp{  TombFilesCleanTask mDir == null || !mDir.exists() || !mDir.isDirectory() ,pls check!}", new Object[0]);
      return;
    }
    e.a("rqdp{  start to clean} %s.* rqdp{  in dir} %s rqdp{  which time <} %s rqdp{  and max file nums should <} %s", new Object[] { "tomb_", this.a.getAbsolutePath(), Long.valueOf(this.b), Integer.valueOf(this.c) });
    final LinkedList localLinkedList = new LinkedList();
    String[] arrayOfString = this.a.list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        e.b("rqdp{  check dir} %s rqdp{  , filename} %s", new Object[] { paramAnonymousFile, paramAnonymousString });
        if (paramAnonymousString.startsWith("tomb_"))
        {
          c.a(c.this);
          e.b("rqdp{  accept }%s", new Object[] { paramAnonymousString });
        }
        try
        {
          long l = Long.parseLong(paramAnonymousString.substring(this.a, paramAnonymousString.length() - this.b));
          e.b("rqdp{  mRemoveBeforeDate }%d", new Object[] { Long.valueOf(c.b(c.this)) });
          if (l <= c.b(c.this))
          {
            e.b("rqdp{  recordTime} %d rqdp{  is old}", new Object[] { Long.valueOf(l) });
            return true;
          }
          e.b("rqdp{  newFileTimeList add} %d", new Object[] { Long.valueOf(l) });
          localLinkedList.add(Long.valueOf(l));
          return false;
        }
        catch (Throwable paramAnonymousFile)
        {
          e.c("rqdp{  filename is not formatted ,shoud do delete! \n path:}%s", new Object[] { paramAnonymousString });
          paramAnonymousFile.printStackTrace();
        }
        return true;
      }
    });
    int i;
    int j;
    if (arrayOfString != null)
    {
      i = arrayOfString.length;
      if (i > 0)
      {
        e.b("rqdp{  delete old num} %d", new Object[] { Integer.valueOf(i) });
        a(this.a.getAbsolutePath(), arrayOfString);
      }
      i = this.d - i - this.c;
      j = localLinkedList.size();
      if ((i <= 0) || (j <= 0)) {
        break label338;
      }
      e.a("rqdp{  should delete not too old file num} %d", new Object[] { Integer.valueOf(i) });
      Collections.sort(localLinkedList);
      if (j <= i) {
        break label303;
      }
    }
    for (;;)
    {
      arrayOfString = new String[i];
      StringBuffer localStringBuffer = new StringBuffer();
      i = 0;
      while ((i < localLinkedList.size()) && (i < arrayOfString.length))
      {
        localStringBuffer.append("tomb_");
        localStringBuffer.append(localLinkedList.get(i));
        localStringBuffer.append(".txt");
        arrayOfString[i] = localStringBuffer.toString();
        localStringBuffer.delete(0, localStringBuffer.length());
        i += 1;
      }
      i = 0;
      break;
      label303:
      i = j;
    }
    e.b("rqdp{  delete not too old files} %d", new Object[] { Integer.valueOf(arrayOfString.length) });
    a(this.a.getAbsolutePath(), arrayOfString);
    label338:
    e.a("rqdp{  clean end!}", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.c
 * JD-Core Version:    0.7.0.1
 */