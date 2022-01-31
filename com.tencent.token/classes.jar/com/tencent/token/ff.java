package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
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

public final class ff
  implements fd
{
  private static final Comparator a = new fh();
  private static final FilenameFilter b = new fi();
  private static final Object f = new Object();
  private final Context c;
  private final Map d;
  private int e;
  
  public ff(Context paramContext)
  {
    this.c = paramContext;
    this.d = new HashMap();
    this.e = -1;
  }
  
  private void a()
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
  
  private fe b(fj paramfj)
  {
    for (;;)
    {
      synchronized (f)
      {
        String str = paramfj.d();
        localObject1 = (SoftReference)this.d.get(str);
        if (localObject1 == null) {
          break label170;
        }
        fg localfg = (fg)((SoftReference)localObject1).get();
        localObject1 = localfg;
        if (localfg == null)
        {
          this.d.remove(str);
          localObject1 = localfg;
        }
        if (localObject1 != null) {
          break label164;
        }
        paramfj = c(paramfj);
        if (paramfj == null) {
          break label162;
        }
        localObject1 = new fe();
        long l = System.currentTimeMillis();
        if ((0L > 0L) && (l - paramfj.a > 0L))
        {
          ((fe)localObject1).a = true;
          return localObject1;
        }
      }
      ((fe)localObject1).a = false;
      ((fe)localObject1).b = paramfj.b;
      ((fe)localObject1).c = paramfj.c;
      return localObject1;
      label162:
      return null;
      label164:
      paramfj = (fj)localObject1;
      continue;
      label170:
      Object localObject1 = null;
    }
  }
  
  private fg c(fj paramfj)
  {
    Object localObject = d(paramfj);
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
      localObject = new fg(this);
      ((fg)localObject).a = localObjectInputStream.readLong();
      if (localObjectInputStream.readBoolean()) {
        ((fg)localObject).b = paramfj.a((Serializable)localObjectInputStream.readObject());
      }
      if (localObjectInputStream.readBoolean()) {
        ((fg)localObject).c = ((Serializable)localObjectInputStream.readObject());
      }
      return localObject;
    }
    catch (StreamCorruptedException paramfj)
    {
      paramfj.printStackTrace();
      return null;
    }
    catch (FileNotFoundException paramfj)
    {
      for (;;)
      {
        paramfj.printStackTrace();
      }
    }
    catch (IOException paramfj)
    {
      for (;;)
      {
        paramfj.printStackTrace();
      }
    }
    catch (ClassNotFoundException paramfj)
    {
      for (;;)
      {
        paramfj.printStackTrace();
      }
    }
  }
  
  private File d(fj paramfj)
  {
    paramfj = s.c(paramfj.d());
    return new File(this.c.getCacheDir(), "TOKEN_" + paramfj);
  }
  
  public final fe a(fj paramfj)
  {
    return b(paramfj);
  }
  
  public final void a(fj paramfj, ft paramft)
  {
    synchronized (f)
    {
      fg localfg = new fg(this);
      localfg.b = paramft;
      localfg.c = null;
      localfg.a = System.currentTimeMillis();
      paramft = paramfj.d();
      localObject2 = new SoftReference(localfg);
      this.d.put(paramft, localObject2);
      a();
      paramft = d(paramfj);
      try
      {
        localObject2 = new ObjectOutputStream(new FileOutputStream(paramft));
        ((ObjectOutputStream)localObject2).writeInt(1);
        ((ObjectOutputStream)localObject2).writeLong(localfg.a);
        if (localfg.b == null) {
          break label226;
        }
        Serializable localSerializable = paramfj.a(localfg.b);
        if (localSerializable == null) {
          break label181;
        }
        ((ObjectOutputStream)localObject2).writeBoolean(true);
        ((ObjectOutputStream)localObject2).writeObject(localSerializable);
      }
      catch (FileNotFoundException paramft)
      {
        for (;;)
        {
          e.c(paramfj.d() + ": can't open cache file to write");
          continue;
          paramfj = finally;
          throw paramfj;
          ((ObjectOutputStream)localObject2).writeBoolean(false);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          label181:
          localIOException.printStackTrace();
          paramft.delete();
          e.c(paramfj.d() + ": writting error:" + localIOException);
          continue;
          ((ObjectOutputStream)localObject2).writeBoolean(false);
        }
      }
      if (localfg.c != null)
      {
        ((ObjectOutputStream)localObject2).writeBoolean(true);
        ((ObjectOutputStream)localObject2).writeObject(localfg.c);
        ((ObjectOutputStream)localObject2).flush();
        return;
        ((ObjectOutputStream)localObject2).writeBoolean(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ff
 * JD-Core Version:    0.7.0.1
 */