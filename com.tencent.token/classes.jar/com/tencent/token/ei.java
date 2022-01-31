package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
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

public class ei
  implements eg
{
  private static final Comparator a = new ek();
  private static final FilenameFilter b = new el();
  private static final Object f = new Object();
  private final Context c;
  private final Map d;
  private int e;
  
  public ei(Context paramContext)
  {
    this.c = paramContext;
    this.d = new HashMap();
    this.e = -1;
  }
  
  public eh a(em paramem)
  {
    return a(paramem, 0L);
  }
  
  public eh a(em paramem, long paramLong)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (f)
      {
        localObject1 = b(paramem);
        if (localObject1 != null) {
          break label109;
        }
        paramem = c(paramem);
        if (paramem == null) {
          break label107;
        }
        localObject1 = new eh();
        long l = System.currentTimeMillis();
        if ((paramLong > 0L) && (l - paramem.a > paramLong))
        {
          ((eh)localObject1).a = true;
          return localObject1;
        }
      }
      ((eh)localObject1).a = false;
      ((eh)localObject1).b = paramem.b;
      ((eh)localObject1).c = paramem.c;
      return localObject1;
      label107:
      return null;
      label109:
      paramem = (em)localObject1;
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
  
  void a(em paramem, ej paramej)
  {
    paramem = paramem.d();
    paramej = new SoftReference(paramej);
    this.d.put(paramem, paramej);
  }
  
  public void a(em paramem, ew paramew, Serializable paramSerializable)
  {
    synchronized (f)
    {
      ej localej = new ej(this);
      localej.b = paramew;
      localej.c = paramSerializable;
      localej.a = System.currentTimeMillis();
      a(paramem, localej);
      b(paramem, localej);
      return;
    }
  }
  
  ej b(em paramem)
  {
    paramem = paramem.d();
    Object localObject = (SoftReference)this.d.get(paramem);
    if (localObject != null)
    {
      localObject = (ej)((SoftReference)localObject).get();
      if (localObject == null) {
        this.d.remove(paramem);
      }
      return localObject;
    }
    return null;
  }
  
  void b(em paramem, ej paramej)
  {
    a();
    File localFile = d(paramem);
    ObjectOutputStream localObjectOutputStream;
    try
    {
      localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(localFile));
      localObjectOutputStream.writeInt(1);
      localObjectOutputStream.writeLong(paramej.a);
      if (paramej.b == null) {
        break label145;
      }
      Serializable localSerializable = paramem.a(paramej.b);
      if (localSerializable == null) {
        break label107;
      }
      localObjectOutputStream.writeBoolean(true);
      localObjectOutputStream.writeObject(localSerializable);
    }
    catch (FileNotFoundException paramej)
    {
      for (;;)
      {
        h.c(paramem.d() + ": can't open cache file to write");
        return;
        localObjectOutputStream.writeBoolean(false);
      }
    }
    catch (IOException paramej)
    {
      paramej.printStackTrace();
      localFile.delete();
      h.c(paramem.d() + ": writting error:" + paramej);
      return;
    }
    if (paramej.c != null)
    {
      localObjectOutputStream.writeBoolean(true);
      localObjectOutputStream.writeObject(paramej.c);
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
  
  ej c(em paramem)
  {
    Object localObject = d(paramem);
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
      localObject = new ej(this);
      ((ej)localObject).a = localObjectInputStream.readLong();
      if (localObjectInputStream.readBoolean()) {
        ((ej)localObject).b = paramem.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((ej)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (StreamCorruptedException paramem)
    {
      paramem.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramem)
    {
      for (;;)
      {
        paramem.printStackTrace();
      }
    }
    catch (IOException paramem)
    {
      for (;;)
      {
        paramem.printStackTrace();
      }
    }
    catch (ClassNotFoundException paramem)
    {
      for (;;)
      {
        paramem.printStackTrace();
      }
    }
  }
  
  File d(em paramem)
  {
    paramem = w.b(paramem.d());
    return new File(this.c.getCacheDir(), "TOKEN_" + paramem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ei
 * JD-Core Version:    0.7.0.1
 */