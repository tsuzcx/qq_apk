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
    for (;;)
    {
      Object localObject1;
      synchronized (f)
      {
        localObject1 = b(paramdf);
        if (localObject1 != null) {
          break label109;
        }
        paramdf = c(paramdf);
        if (paramdf == null) {
          break label107;
        }
        localObject1 = new dd.a();
        long l = System.currentTimeMillis();
        if ((paramLong > 0L) && (l - paramdf.a > paramLong))
        {
          ((dd.a)localObject1).a = true;
          return localObject1;
        }
      }
      ((dd.a)localObject1).a = false;
      ((dd.a)localObject1).b = paramdf.b;
      ((dd.a)localObject1).c = paramdf.c;
      return localObject1;
      label107:
      return null;
      label109:
      paramdf = (df)localObject1;
    }
  }
  
  void a()
  {
    File[] arrayOfFile;
    if ((this.e < 0) || (this.e > 100))
    {
      arrayOfFile = this.c.getCacheDir().listFiles(b);
      if (arrayOfFile != null) {
        break label35;
      }
    }
    for (;;)
    {
      return;
      label35:
      int j = arrayOfFile.length;
      this.e = j;
      if (j >= 100)
      {
        Arrays.sort(arrayOfFile, a);
        int i = 0;
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
    paramdf = paramdf.d();
    Object localObject = (SoftReference)this.d.get(paramdf);
    if (localObject != null)
    {
      localObject = (a)((SoftReference)localObject).get();
      if (localObject == null) {
        this.d.remove(paramdf);
      }
      return localObject;
    }
    return null;
  }
  
  void b(df paramdf, a parama)
  {
    a();
    File localFile = d(paramdf);
    ObjectOutputStream localObjectOutputStream;
    try
    {
      localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(localFile));
      localObjectOutputStream.writeInt(1);
      localObjectOutputStream.writeLong(parama.a);
      if (parama.b == null) {
        break label145;
      }
      Serializable localSerializable = paramdf.a(parama.b);
      if (localSerializable == null) {
        break label107;
      }
      localObjectOutputStream.writeBoolean(true);
      localObjectOutputStream.writeObject(localSerializable);
    }
    catch (FileNotFoundException parama)
    {
      for (;;)
      {
        g.c(paramdf.d() + ": can't open cache file to write");
        return;
        localObjectOutputStream.writeBoolean(false);
      }
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
      localFile.delete();
      g.c(paramdf.d() + ": writting error:" + parama);
      return;
    }
    if (parama.c != null)
    {
      localObjectOutputStream.writeBoolean(true);
      localObjectOutputStream.writeObject(parama.c);
    }
    for (;;)
    {
      localObjectOutputStream.flush();
      return;
      label107:
      localObjectOutputStream.writeBoolean(false);
      break;
      label145:
      localObjectOutputStream.writeBoolean(false);
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
    catch (StreamCorruptedException paramdf)
    {
      paramdf.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramdf)
    {
      for (;;)
      {
        paramdf.printStackTrace();
      }
    }
    catch (IOException paramdf)
    {
      for (;;)
      {
        paramdf.printStackTrace();
      }
    }
    catch (ClassNotFoundException paramdf)
    {
      for (;;)
      {
        paramdf.printStackTrace();
      }
    }
  }
  
  File d(df paramdf)
  {
    paramdf = l.b(paramdf.d());
    return new File(this.c.getCacheDir(), "TOKEN_" + paramdf);
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