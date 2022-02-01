package com.tencent.feedback.eup.jni;

import android.content.Context;
import com.tencent.feedback.eup.b;
import com.tencent.feedback.proguard.s;
import com.tencent.feedback.proguard.t;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements s
{
  public final String a;
  private String b;
  private File c;
  private long d;
  private int e;
  private int f;
  private Context g;
  
  public d(Context paramContext, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3)
  {
    this.c = new File(paramString1);
    this.d = paramLong;
    this.e = paramInt;
    this.g = paramContext;
    this.a = paramString2;
    this.b = paramString3;
  }
  
  private static void a(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      com.tencent.feedback.common.e.c("rqdp{  fileNameList == null || fileNameList.length <= 0}", new Object[0]);
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
          com.tencent.feedback.common.e.b("rqdp{  file delete} %s", new Object[] { localFile.getPath() });
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public final void d() {}
  
  public final void e()
  {
    com.tencent.feedback.common.e.a("on query end clear", new Object[0]);
    this.f = 0;
    if ((this.c == null) || (!this.c.exists()) || (!this.c.isDirectory()))
    {
      if (this.c == null) {}
      for (localObject = "null";; localObject = this.c.getAbsolutePath())
      {
        com.tencent.feedback.common.e.c("rqdp{  TombFilesCleanTask end for dir not avaliable %s}", new Object[] { localObject });
        return;
      }
    }
    com.tencent.feedback.common.e.a("rqdp{ start to find native record}", new Object[0]);
    Object localObject = c.a(this.g, this.c.getAbsolutePath());
    final int i;
    final int j;
    String[] arrayOfString;
    if (localObject != null)
    {
      com.tencent.feedback.common.e.a("found a record insert %s", new Object[] { ((com.tencent.feedback.eup.e)localObject).e() });
      ((com.tencent.feedback.eup.e)localObject).c(true);
      if (((com.tencent.feedback.eup.e)localObject).i() > this.d)
      {
        com.tencent.feedback.common.e.a("avail add", new Object[0]);
        b.a(this.g, (com.tencent.feedback.eup.e)localObject);
      }
    }
    else
    {
      c.a(this.c.getAbsolutePath());
      com.tencent.feedback.common.e.a("rqdp{  start to clean} %s.* rqdp{  in dir} %s rqdp{  which time <} %s rqdp{  and max file nums should <} %s", new Object[] { this.a, this.c.getAbsolutePath(), Long.valueOf(this.d), Integer.valueOf(this.e) });
      localObject = new LinkedList();
      i = this.a.length();
      j = this.b.length();
      arrayOfString = this.c.list(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          com.tencent.feedback.common.e.b("rqdp{  check dir} %s rqdp{  , filename} %s", new Object[] { paramAnonymousFile, paramAnonymousString });
          if (paramAnonymousString.startsWith(d.this.a))
          {
            d.a(d.this);
            com.tencent.feedback.common.e.b("rqdp{  accept }%s", new Object[] { paramAnonymousString });
          }
          try
          {
            long l = Long.parseLong(paramAnonymousString.substring(i, paramAnonymousString.length() - j));
            com.tencent.feedback.common.e.b("rqdp{  mRemoveBeforeDate }%d", new Object[] { Long.valueOf(d.b(d.this)) });
            if (l <= d.b(d.this))
            {
              com.tencent.feedback.common.e.b("rqdp{  recordTime} %d rqdp{  is old}", new Object[] { Long.valueOf(l) });
              return true;
            }
            com.tencent.feedback.common.e.b("rqdp{  newFileTimeList add} %d", new Object[] { Long.valueOf(l) });
            this.c.add(Long.valueOf(l));
            return false;
          }
          catch (Throwable paramAnonymousFile)
          {
            com.tencent.feedback.common.e.c("rqdp{  filename is not formatted ,shoud do delete! \n path:}%s", new Object[] { paramAnonymousString });
            if (!com.tencent.feedback.common.e.a(paramAnonymousFile)) {
              paramAnonymousFile.printStackTrace();
            }
          }
          return true;
        }
      });
      if (arrayOfString == null) {
        break label462;
      }
      i = arrayOfString.length;
      label270:
      if (i > 0)
      {
        com.tencent.feedback.common.e.b("rqdp{  delete old num} %d", new Object[] { Integer.valueOf(i) });
        a(this.c.getAbsolutePath(), arrayOfString);
      }
      i = this.f - i - this.e;
      j = ((List)localObject).size();
      if ((i <= 0) || (j <= 0)) {
        break label503;
      }
      com.tencent.feedback.common.e.a("rqdp{  should delete not too old file num} %d", new Object[] { Integer.valueOf(i) });
      Collections.sort((List)localObject);
      if (j <= i) {
        break label467;
      }
    }
    for (;;)
    {
      arrayOfString = new String[i];
      StringBuffer localStringBuffer = new StringBuffer();
      i = 0;
      while ((i < ((List)localObject).size()) && (i < arrayOfString.length))
      {
        localStringBuffer.append(this.a);
        localStringBuffer.append(((List)localObject).get(i));
        localStringBuffer.append(".txt");
        arrayOfString[i] = localStringBuffer.toString();
        localStringBuffer.delete(0, localStringBuffer.length());
        i += 1;
      }
      com.tencent.feedback.common.e.a("unavail drop", new Object[0]);
      break;
      label462:
      i = 0;
      break label270;
      label467:
      i = j;
    }
    com.tencent.feedback.common.e.b("rqdp{  delete not too old files} %d", new Object[] { Integer.valueOf(arrayOfString.length) });
    a(this.c.getAbsolutePath(), arrayOfString);
    label503:
    t.a(this.g).b(this);
    com.tencent.feedback.common.e.a("rqdp{  clean end!}", new Object[0]);
  }
  
  public final void f()
  {
    com.tencent.feedback.common.e.a("on app first run delete record file", new Object[0]);
    c.a(this.c.getAbsolutePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.d
 * JD-Core Version:    0.7.0.1
 */