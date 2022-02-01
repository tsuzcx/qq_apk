package com.tencent.token;

import android.content.Context;
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

public final class aah
  implements aag
{
  private static final Comparator<File> a = new b();
  private static final FilenameFilter b = new c();
  private static final Object f = new Object();
  private final Context c;
  private final Map<String, SoftReference<a>> d;
  private int e;
  
  public aah(Context paramContext)
  {
    this.c = paramContext;
    this.d = new HashMap();
    this.e = -1;
  }
  
  private void a()
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
  
  private aag.a b(aai paramaai)
  {
    for (;;)
    {
      synchronized (f)
      {
        String str = paramaai.c();
        localObject1 = (SoftReference)this.d.get(str);
        if (localObject1 != null)
        {
          Object localObject2 = (a)((SoftReference)localObject1).get();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            this.d.remove(str);
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = c(paramaai);
          }
          if (localObject2 != null)
          {
            paramaai = new aag.a();
            System.currentTimeMillis();
            paramaai.a = false;
            paramaai.b = ((a)localObject2).b;
            paramaai.c = ((a)localObject2).c;
            return paramaai;
          }
          return null;
        }
      }
      Object localObject1 = null;
    }
  }
  
  private a c(aai paramaai)
  {
    Object localObject = d(paramaai);
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
        ((a)localObject).b = paramaai.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (ClassNotFoundException paramaai)
    {
      paramaai.printStackTrace();
      return null;
    }
    catch (IOException paramaai)
    {
      paramaai.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramaai)
    {
      paramaai.printStackTrace();
      return null;
    }
    catch (StreamCorruptedException paramaai)
    {
      paramaai.printStackTrace();
    }
    return null;
  }
  
  private File d(aai paramaai)
  {
    paramaai = aad.c(paramaai.c());
    return new File(this.c.getCacheDir(), "TOKEN_".concat(String.valueOf(paramaai)));
  }
  
  public final aag.a a(aai paramaai)
  {
    return b(paramaai);
  }
  
  public final void a(aai paramaai, aas paramaas)
  {
    synchronized (f)
    {
      a locala = new a();
      locala.b = paramaas;
      locala.c = null;
      locala.a = System.currentTimeMillis();
      paramaas = paramaai.c();
      Object localObject2 = new SoftReference(locala);
      this.d.put(paramaas, localObject2);
      a();
      paramaas = d(paramaai);
      try
      {
        try
        {
          localObject2 = new ObjectOutputStream(new FileOutputStream(paramaas));
          ((ObjectOutputStream)localObject2).writeInt(1);
          ((ObjectOutputStream)localObject2).writeLong(locala.a);
          if (locala.b != null)
          {
            Serializable localSerializable = paramaai.a(locala.b);
            if (localSerializable != null)
            {
              ((ObjectOutputStream)localObject2).writeBoolean(true);
              ((ObjectOutputStream)localObject2).writeObject(localSerializable);
            }
            else
            {
              ((ObjectOutputStream)localObject2).writeBoolean(false);
            }
          }
          else
          {
            ((ObjectOutputStream)localObject2).writeBoolean(false);
          }
          if (locala.c != null)
          {
            ((ObjectOutputStream)localObject2).writeBoolean(true);
            ((ObjectOutputStream)localObject2).writeObject(locala.c);
          }
          else
          {
            ((ObjectOutputStream)localObject2).writeBoolean(false);
          }
          ((ObjectOutputStream)localObject2).flush();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          paramaas.delete();
          paramaas = new StringBuilder();
          paramaas.append(paramaai.c());
          paramaas.append(": writting error:");
          paramaas.append(localIOException);
          xb.c(paramaas.toString());
        }
      }
      catch (FileNotFoundException paramaas)
      {
        label263:
        break label263;
      }
      paramaas = new StringBuilder();
      paramaas.append(paramaai.c());
      paramaas.append(": can't open cache file to write");
      xb.c(paramaas.toString());
      return;
    }
  }
  
  final class a
  {
    public long a;
    public aas b;
    public Serializable c;
    
    a() {}
  }
  
  static final class b
    implements Comparator<File>
  {}
  
  static final class c
    implements FilenameFilter
  {
    public final boolean accept(File paramFile, String paramString)
    {
      return paramString.startsWith("TOKEN_");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aah
 * JD-Core Version:    0.7.0.1
 */