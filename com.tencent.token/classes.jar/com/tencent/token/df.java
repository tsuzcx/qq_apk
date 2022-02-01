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

public class df
  implements de
{
  private static final Comparator<File> a = new b();
  private static final FilenameFilter b = new c();
  private static final Object f = new Object();
  private final Context c;
  private final Map<String, SoftReference<a>> d;
  private int e;
  
  public df(Context paramContext)
  {
    this.c = paramContext;
    this.d = new HashMap();
    this.e = -1;
  }
  
  public de.a a(dg paramdg)
  {
    return a(paramdg, 0L);
  }
  
  public de.a a(dg paramdg, long paramLong)
  {
    synchronized (f)
    {
      a locala2 = b(paramdg);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = c(paramdg);
      }
      if (locala1 != null)
      {
        paramdg = new de.a();
        long l = System.currentTimeMillis();
        if ((paramLong > 0L) && (l - locala1.a > paramLong))
        {
          paramdg.a = true;
          return paramdg;
        }
        paramdg.a = false;
        paramdg.b = locala1.b;
        paramdg.c = locala1.c;
        return paramdg;
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
  
  void a(dg paramdg, a parama)
  {
    paramdg = paramdg.d();
    parama = new SoftReference(parama);
    this.d.put(paramdg, parama);
  }
  
  public void a(dg paramdg, dq paramdq, Serializable paramSerializable)
  {
    synchronized (f)
    {
      a locala = new a();
      locala.b = paramdq;
      locala.c = paramSerializable;
      locala.a = System.currentTimeMillis();
      a(paramdg, locala);
      b(paramdg, locala);
      return;
    }
  }
  
  a b(dg paramdg)
  {
    String str = paramdg.d();
    paramdg = (SoftReference)this.d.get(str);
    if (paramdg != null)
    {
      a locala = (a)paramdg.get();
      paramdg = locala;
      if (locala == null)
      {
        this.d.remove(str);
        return locala;
      }
    }
    else
    {
      paramdg = null;
    }
    return paramdg;
  }
  
  void b(dg paramdg, a parama)
  {
    a();
    Object localObject = d(paramdg);
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream((File)localObject));
      localObjectOutputStream.writeInt(1);
      localObjectOutputStream.writeLong(parama.a);
      if (parama.b != null)
      {
        Serializable localSerializable = paramdg.a(parama.b);
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
      ((StringBuilder)localObject).append(paramdg.d());
      ((StringBuilder)localObject).append(": writting error:");
      ((StringBuilder)localObject).append(parama);
      g.c(((StringBuilder)localObject).toString());
      return;
      parama = new StringBuilder();
      parama.append(paramdg.d());
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
  
  a c(dg paramdg)
  {
    Object localObject = d(paramdg);
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
        ((a)localObject).b = paramdg.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (ClassNotFoundException paramdg)
    {
      paramdg.printStackTrace();
      return null;
    }
    catch (IOException paramdg)
    {
      paramdg.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramdg)
    {
      paramdg.printStackTrace();
      return null;
    }
    catch (StreamCorruptedException paramdg)
    {
      paramdg.printStackTrace();
    }
    return null;
  }
  
  File d(dg paramdg)
  {
    paramdg = l.b(paramdg.d());
    File localFile = this.c.getCacheDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TOKEN_");
    localStringBuilder.append(paramdg);
    return new File(localFile, localStringBuilder.toString());
  }
  
  class a
  {
    public long a;
    public dq b;
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
 * Qualified Name:     com.tencent.token.df
 * JD-Core Version:    0.7.0.1
 */