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

public final class aag
  implements aaf
{
  private static final Comparator<File> a = new b();
  private static final FilenameFilter b = new c();
  private static final Object f = new Object();
  private final Context c;
  private final Map<String, SoftReference<a>> d;
  private int e;
  
  public aag(Context paramContext)
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
  
  private aaf.a b(aah paramaah)
  {
    for (;;)
    {
      synchronized (f)
      {
        String str = paramaah.c();
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
            localObject2 = c(paramaah);
          }
          if (localObject2 != null)
          {
            paramaah = new aaf.a();
            System.currentTimeMillis();
            paramaah.a = false;
            paramaah.b = ((a)localObject2).b;
            paramaah.c = ((a)localObject2).c;
            return paramaah;
          }
          return null;
        }
      }
      Object localObject1 = null;
    }
  }
  
  private a c(aah paramaah)
  {
    Object localObject = d(paramaah);
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
        ((a)localObject).b = paramaah.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (ClassNotFoundException paramaah)
    {
      paramaah.printStackTrace();
      return null;
    }
    catch (IOException paramaah)
    {
      paramaah.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramaah)
    {
      paramaah.printStackTrace();
      return null;
    }
    catch (StreamCorruptedException paramaah)
    {
      paramaah.printStackTrace();
    }
    return null;
  }
  
  private File d(aah paramaah)
  {
    paramaah = aac.c(paramaah.c());
    return new File(this.c.getCacheDir(), "TOKEN_".concat(String.valueOf(paramaah)));
  }
  
  public final aaf.a a(aah paramaah)
  {
    return b(paramaah);
  }
  
  public final void a(aah paramaah, aar paramaar)
  {
    synchronized (f)
    {
      a locala = new a();
      locala.b = paramaar;
      locala.c = null;
      locala.a = System.currentTimeMillis();
      paramaar = paramaah.c();
      Object localObject2 = new SoftReference(locala);
      this.d.put(paramaar, localObject2);
      a();
      paramaar = d(paramaah);
      try
      {
        try
        {
          localObject2 = new ObjectOutputStream(new FileOutputStream(paramaar));
          ((ObjectOutputStream)localObject2).writeInt(1);
          ((ObjectOutputStream)localObject2).writeLong(locala.a);
          if (locala.b != null)
          {
            Serializable localSerializable = paramaah.a(locala.b);
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
          paramaar.delete();
          paramaar = new StringBuilder();
          paramaar.append(paramaah.c());
          paramaar.append(": writting error:");
          paramaar.append(localIOException);
          xa.c(paramaar.toString());
        }
      }
      catch (FileNotFoundException paramaar)
      {
        label263:
        break label263;
      }
      paramaar = new StringBuilder();
      paramaar.append(paramaah.c());
      paramaar.append(": can't open cache file to write");
      xa.c(paramaar.toString());
      return;
    }
  }
  
  final class a
  {
    public long a;
    public aar b;
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
 * Qualified Name:     com.tencent.token.aag
 * JD-Core Version:    0.7.0.1
 */