package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File mBackupName;
  private final File mBaseName;
  
  public AtomicFile(@NonNull File paramFile)
  {
    this.mBaseName = paramFile;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getPath());
    localStringBuilder.append(".bak");
    this.mBackupName = new File(localStringBuilder.toString());
  }
  
  private static boolean sync(@NonNull FileOutputStream paramFileOutputStream)
  {
    try
    {
      paramFileOutputStream.getFD().sync();
      return true;
    }
    catch (IOException paramFileOutputStream)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public void delete()
  {
    this.mBaseName.delete();
    this.mBackupName.delete();
  }
  
  public void failWrite(@Nullable FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null)
    {
      sync(paramFileOutputStream);
      try
      {
        paramFileOutputStream.close();
        this.mBaseName.delete();
        this.mBackupName.renameTo(this.mBaseName);
        return;
      }
      catch (IOException paramFileOutputStream)
      {
        Log.w("AtomicFile", "failWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  public void finishWrite(@Nullable FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null)
    {
      sync(paramFileOutputStream);
      try
      {
        paramFileOutputStream.close();
        this.mBackupName.delete();
        return;
      }
      catch (IOException paramFileOutputStream)
      {
        Log.w("AtomicFile", "finishWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  @NonNull
  public File getBaseFile()
  {
    return this.mBaseName;
  }
  
  @NonNull
  public FileInputStream openRead()
  {
    if (this.mBackupName.exists())
    {
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
    }
    return new FileInputStream(this.mBaseName);
  }
  
  /* Error */
  @NonNull
  public byte[] readFully()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 99	android/support/v4/util/AtomicFile:openRead	()Ljava/io/FileInputStream;
    //   4: astore 6
    //   6: aload 6
    //   8: invokevirtual 103	java/io/FileInputStream:available	()I
    //   11: newarray byte
    //   13: astore 4
    //   15: iconst_0
    //   16: istore_1
    //   17: aload 6
    //   19: aload 4
    //   21: iload_1
    //   22: aload 4
    //   24: arraylength
    //   25: iload_1
    //   26: isub
    //   27: invokevirtual 107	java/io/FileInputStream:read	([BII)I
    //   30: istore_2
    //   31: iload_2
    //   32: ifgt +11 -> 43
    //   35: aload 6
    //   37: invokevirtual 108	java/io/FileInputStream:close	()V
    //   40: aload 4
    //   42: areturn
    //   43: iload_1
    //   44: iload_2
    //   45: iadd
    //   46: istore_2
    //   47: aload 6
    //   49: invokevirtual 103	java/io/FileInputStream:available	()I
    //   52: istore_3
    //   53: iload_2
    //   54: istore_1
    //   55: iload_3
    //   56: aload 4
    //   58: arraylength
    //   59: iload_2
    //   60: isub
    //   61: if_icmple -44 -> 17
    //   64: iload_3
    //   65: iload_2
    //   66: iadd
    //   67: newarray byte
    //   69: astore 5
    //   71: aload 4
    //   73: iconst_0
    //   74: aload 5
    //   76: iconst_0
    //   77: iload_2
    //   78: invokestatic 114	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   81: aload 5
    //   83: astore 4
    //   85: iload_2
    //   86: istore_1
    //   87: goto -70 -> 17
    //   90: astore 4
    //   92: aload 6
    //   94: invokevirtual 108	java/io/FileInputStream:close	()V
    //   97: aload 4
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	AtomicFile
    //   16	71	1	i	int
    //   30	56	2	j	int
    //   52	15	3	k	int
    //   13	71	4	localObject1	Object
    //   90	8	4	localObject2	Object
    //   69	13	5	arrayOfByte	byte[]
    //   4	89	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   6	15	90	finally
    //   17	31	90	finally
    //   47	53	90	finally
    //   55	81	90	finally
  }
  
  @NonNull
  public FileOutputStream startWrite()
  {
    if (this.mBaseName.exists()) {
      if (!this.mBackupName.exists())
      {
        if (!this.mBaseName.renameTo(this.mBackupName))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Couldn't rename file ");
          ((StringBuilder)localObject).append(this.mBaseName);
          ((StringBuilder)localObject).append(" to backup file ");
          ((StringBuilder)localObject).append(this.mBackupName);
          Log.w("AtomicFile", ((StringBuilder)localObject).toString());
        }
      }
      else {
        this.mBaseName.delete();
      }
    }
    try
    {
      localObject = new FileOutputStream(this.mBaseName);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      label109:
      break label109;
    }
    if (this.mBaseName.getParentFile().mkdirs()) {}
    try
    {
      localObject = new FileOutputStream(this.mBaseName);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      label136:
      break label136;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't create ");
    ((StringBuilder)localObject).append(this.mBaseName);
    throw new IOException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't create directory ");
    ((StringBuilder)localObject).append(this.mBaseName);
    throw new IOException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.AtomicFile
 * JD-Core Version:    0.7.0.1
 */