package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class de
  implements dd
{
  private static final Comparator<File> a = new b();
  private static final FilenameFilter b = new c();
  private static final Object f = new Object();
  private final Context c;
  private final Map<String, SoftReference<a>> d;
  private int e;
  
  public de(Context paramContext)
  {
    this.c = paramContext;
    this.d = new HashMap();
    this.e = -1;
  }
  
  public dd.a a(df paramdf)
  {
    return a(paramdf, 0L);
  }
  
  public dd.a a(df paramdf, long paramLong)
  {
    synchronized (f)
    {
      a locala2 = b(paramdf);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = c(paramdf);
      }
      if (locala1 != null)
      {
        paramdf = new dd.a();
        long l = System.currentTimeMillis();
        if ((paramLong > 0L) && (l - locala1.a > paramLong))
        {
          paramdf.a = true;
          return paramdf;
        }
        paramdf.a = false;
        paramdf.b = locala1.b;
        paramdf.c = locala1.c;
        return paramdf;
      }
      return null;
    }
  }
  
  void a()
  {
    int i = this.e;
    if ((i < 0) || (i > 100))
    {
      File[] arrayOfFile = this.c.getCacheDir().listFiles(b);
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      this.e = j;
      if (j >= 100)
      {
        Arrays.sort(arrayOfFile, a);
        i = 0;
        while ((i < j) && (this.e > 75))
        {
          if (arrayOfFile[i].delete()) {
            this.e -= 1;
          }
          i += 1;
        }
      }
    }
  }
  
  void a(df paramdf, a parama)
  {
    paramdf = paramdf.d();
    parama = new SoftReference(parama);
    this.d.put(paramdf, parama);
  }
  
  public void a(df paramdf, dp paramdp, Serializable paramSerializable)
  {
    synchronized (f)
    {
      a locala = new a();
      locala.b = paramdp;
      locala.c = paramSerializable;
      locala.a = System.currentTimeMillis();
      a(paramdf, locala);
      b(paramdf, locala);
      return;
    }
  }
  
  a b(df paramdf)
  {
    String str = paramdf.d();
    paramdf = (SoftReference)this.d.get(str);
    if (paramdf != null)
    {
      a locala = (a)paramdf.get();
      paramdf = locala;
      if (locala == null)
      {
        this.d.remove(str);
        return locala;
      }
    }
    else
    {
      paramdf = null;
    }
    return paramdf;
  }
  
  void b(df paramdf, a parama)
  {
    a();
    Object localObject = d(paramdf);
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream((File)localObject));
      localObjectOutputStream.writeInt(1);
      localObjectOutputStream.writeLong(parama.a);
      if (parama.b != null)
      {
        Serializable localSerializable = paramdf.a(parama.b);
        if (localSerializable != null)
        {
          localObjectOutputStream.writeBoolean(true);
          localObjectOutputStream.writeObject(localSerializable);
        }
        else
        {
          localObjectOutputStream.writeBoolean(false);
        }
      }
      else
      {
        localObjectOutputStream.writeBoolean(false);
      }
      if (parama.c != null)
      {
        localObjectOutputStream.writeBoolean(true);
        localObjectOutputStream.writeObject(parama.c);
      }
      else
      {
        localObjectOutputStream.writeBoolean(false);
      }
      localObjectOutputStream.flush();
      return;
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
      ((File)localObject).delete();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramdf.d());
      ((StringBuilder)localObject).append(": writting error:");
      ((StringBuilder)localObject).append(parama);
      g.c(((StringBuilder)localObject).toString());
      return;
      parama = new StringBuilder();
      parama.append(paramdf.d());
      parama.append(": can't open cache file to write");
      g.c(parama.toString());
      return;
    }
    catch (FileNotFoundException parama)
    {
      label184:
      break label184;
    }
  }
  
  a c(df paramdf)
  {
    Object localObject = d(paramdf);
    if (!((File)localObject).exists()) {
      return null;
    }
    try
    {
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream((File)localObject));
      if (localObjectInputStream.readInt() != 1)
      {
        ((File)localObject).delete();
        return null;
      }
      localObject = new a();
      ((a)localObject).a = localObjectInputStream.readLong();
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).b = paramdf.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (ClassNotFoundException paramdf)
    {
      paramdf.printStackTrace();
      return null;
    }
    catch (IOException paramdf)
    {
      paramdf.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramdf)
    {
      paramdf.printStackTrace();
      return null;
    }
    catch (StreamCorruptedException paramdf)
    {
      paramdf.printStackTrace();
    }
    return null;
  }
  
  File d(df paramdf)
  {
    paramdf = l.b(paramdf.d());
    File localFile = this.c.getCacheDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TOKEN_");
    localStringBuilder.append(paramdf);
    return new File(localFile, localStringBuilder.toString());
  }
  
  class a
  {
    public long a;
    public dp b;
    public Serializable c;
    
    a() {}
  }
  
  static class b
    implements Comparator<File>
  {
    public int a(File paramFile1, File paramFile2)
    {
      if (paramFile1.lastModified() > paramFile2.lastModified()) {
        return -1;
      }
      return 1;
    }
  }
  
  static class c
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      return paramString.startsWith("TOKEN_");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.de
 * JD-Core Version:    0.7.0.1
 */