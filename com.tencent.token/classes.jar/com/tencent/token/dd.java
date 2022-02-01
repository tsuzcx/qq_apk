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

public class dd
  implements dc
{
  private static final Comparator<File> a = new b();
  private static final FilenameFilter b = new c();
  private static final Object f = new Object();
  private final Context c;
  private final Map<String, SoftReference<a>> d;
  private int e;
  
  public dd(Context paramContext)
  {
    this.c = paramContext;
    this.d = new HashMap();
    this.e = -1;
  }
  
  public dc.a a(de paramde)
  {
    return a(paramde, 0L);
  }
  
  public dc.a a(de paramde, long paramLong)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (f)
      {
        localObject1 = b(paramde);
        if (localObject1 != null) {
          break label109;
        }
        paramde = c(paramde);
        if (paramde == null) {
          break label107;
        }
        localObject1 = new dc.a();
        long l = System.currentTimeMillis();
        if ((paramLong > 0L) && (l - paramde.a > paramLong))
        {
          ((dc.a)localObject1).a = true;
          return localObject1;
        }
      }
      ((dc.a)localObject1).a = false;
      ((dc.a)localObject1).b = paramde.b;
      ((dc.a)localObject1).c = paramde.c;
      return localObject1;
      label107:
      return null;
      label109:
      paramde = (de)localObject1;
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
  
  void a(de paramde, a parama)
  {
    paramde = paramde.d();
    parama = new SoftReference(parama);
    this.d.put(paramde, parama);
  }
  
  public void a(de paramde, do paramdo, Serializable paramSerializable)
  {
    synchronized (f)
    {
      a locala = new a();
      locala.b = paramdo;
      locala.c = paramSerializable;
      locala.a = System.currentTimeMillis();
      a(paramde, locala);
      b(paramde, locala);
      return;
    }
  }
  
  a b(de paramde)
  {
    paramde = paramde.d();
    Object localObject = (SoftReference)this.d.get(paramde);
    if (localObject != null)
    {
      localObject = (a)((SoftReference)localObject).get();
      if (localObject == null) {
        this.d.remove(paramde);
      }
      return localObject;
    }
    return null;
  }
  
  void b(de paramde, a parama)
  {
    a();
    File localFile = d(paramde);
    ObjectOutputStream localObjectOutputStream;
    try
    {
      localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(localFile));
      localObjectOutputStream.writeInt(1);
      localObjectOutputStream.writeLong(parama.a);
      if (parama.b == null) {
        break label145;
      }
      Serializable localSerializable = paramde.a(parama.b);
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
        g.c(paramde.d() + ": can't open cache file to write");
        return;
        localObjectOutputStream.writeBoolean(false);
      }
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
      localFile.delete();
      g.c(paramde.d() + ": writting error:" + parama);
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
  
  a c(de paramde)
  {
    Object localObject = d(paramde);
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
        ((a)localObject).b = paramde.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (StreamCorruptedException paramde)
    {
      paramde.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramde)
    {
      for (;;)
      {
        paramde.printStackTrace();
      }
    }
    catch (IOException paramde)
    {
      for (;;)
      {
        paramde.printStackTrace();
      }
    }
    catch (ClassNotFoundException paramde)
    {
      for (;;)
      {
        paramde.printStackTrace();
      }
    }
  }
  
  File d(de paramde)
  {
    paramde = l.b(paramde.d());
    return new File(this.c.getCacheDir(), "TOKEN_" + paramde);
  }
  
  class a
  {
    public long a;
    public do b;
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
 * Qualified Name:     com.tencent.token.dd
 * JD-Core Version:    0.7.0.1
 */