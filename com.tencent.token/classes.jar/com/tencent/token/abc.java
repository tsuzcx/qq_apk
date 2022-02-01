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

public final class abc
  implements abb
{
  private static final Comparator<File> a = new b();
  private static final FilenameFilter b = new c();
  private static final Object f = new Object();
  private final Context c;
  private final Map<String, SoftReference<a>> d;
  private int e;
  
  public abc(Context paramContext)
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
  
  private abb.a b(abd paramabd)
  {
    for (;;)
    {
      synchronized (f)
      {
        String str = paramabd.c();
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
            localObject2 = c(paramabd);
          }
          if (localObject2 != null)
          {
            paramabd = new abb.a();
            System.currentTimeMillis();
            paramabd.a = false;
            paramabd.b = ((a)localObject2).b;
            paramabd.c = ((a)localObject2).c;
            return paramabd;
          }
          return null;
        }
      }
      Object localObject1 = null;
    }
  }
  
  private a c(abd paramabd)
  {
    Object localObject = d(paramabd);
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
        ((a)localObject).b = paramabd.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((a)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (ClassNotFoundException paramabd)
    {
      paramabd.printStackTrace();
      return null;
    }
    catch (IOException paramabd)
    {
      paramabd.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramabd)
    {
      paramabd.printStackTrace();
      return null;
    }
    catch (StreamCorruptedException paramabd)
    {
      paramabd.printStackTrace();
    }
    return null;
  }
  
  private File d(abd paramabd)
  {
    paramabd = aay.c(paramabd.c());
    return new File(this.c.getCacheDir(), "TOKEN_".concat(String.valueOf(paramabd)));
  }
  
  public final abb.a a(abd paramabd)
  {
    return b(paramabd);
  }
  
  public final void a(abd paramabd, abn paramabn)
  {
    synchronized (f)
    {
      a locala = new a();
      locala.b = paramabn;
      locala.c = null;
      locala.a = System.currentTimeMillis();
      paramabn = paramabd.c();
      Object localObject2 = new SoftReference(locala);
      this.d.put(paramabn, localObject2);
      a();
      paramabn = d(paramabd);
      try
      {
        try
        {
          localObject2 = new ObjectOutputStream(new FileOutputStream(paramabn));
          ((ObjectOutputStream)localObject2).writeInt(1);
          ((ObjectOutputStream)localObject2).writeLong(locala.a);
          if (locala.b != null)
          {
            Serializable localSerializable = paramabd.a(locala.b);
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
          paramabn.delete();
          paramabn = new StringBuilder();
          paramabn.append(paramabd.c());
          paramabn.append(": writting error:");
          paramabn.append(localIOException);
          xv.c(paramabn.toString());
        }
      }
      catch (FileNotFoundException paramabn)
      {
        label263:
        break label263;
      }
      paramabn = new StringBuilder();
      paramabn.append(paramabd.c());
      paramabn.append(": can't open cache file to write");
      xv.c(paramabn.toString());
      return;
    }
  }
  
  final class a
  {
    public long a;
    public abn b;
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
 * Qualified Name:     com.tencent.token.abc
 * JD-Core Version:    0.7.0.1
 */