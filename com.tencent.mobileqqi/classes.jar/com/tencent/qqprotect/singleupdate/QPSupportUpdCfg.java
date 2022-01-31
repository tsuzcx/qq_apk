package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class QPSupportUpdCfg
  implements Serializable
{
  static String CFG_FILEPATH = null;
  public QPSupportUpdCfg.QPUpdFileItem[] fileItem;
  public int iConfigFileVersion = 0;
  public int iRequestTime = 24;
  
  QPSupportUpdCfg()
  {
    Object localObject = BaseApplication.getContext();
    CFG_FILEPATH = ((Context)localObject).getFilesDir().getAbsoluteFile() + "/TxSingleUpd/SupportUpd.cfg";
    localObject = new File(CFG_FILEPATH);
    if (!((File)localObject).exists())
    {
      this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[1];
      this.fileItem[0] = new QPSupportUpdCfg.QPUpdFileItem(this);
      this.fileItem[0].strFilePath = new String(CFG_FILEPATH);
      this.fileItem[0].strFileHash = new String("");
    }
    try
    {
      ((File)localObject).createNewFile();
      WriteConfigFile();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public boolean CheckFileState()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.fileItem == null)
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        if (i >= this.fileItem.length) {
          break label96;
        }
        Object localObject = new File(this.fileItem[i].strFilePath);
        bool1 = bool2;
        if (!((File)localObject).exists()) {
          break;
        }
        try
        {
          localObject = MD5FileUtil.a((File)localObject);
          String str = this.fileItem[i].strFileHash;
          bool1 = bool2;
          if (localObject != str) {
            break;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      i += 1;
    }
    label96:
    return true;
  }
  
  public boolean IsFileInConfigFile(String paramString)
  {
    paramString = QPUpdFileOperation.a(paramString);
    if (this.fileItem == null) {}
    for (;;)
    {
      return false;
      int j = this.fileItem.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(QPUpdFileOperation.a(this.fileItem[i].strFilePath))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean ReadConfigFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    try
    {
      paramString = new FileInputStream(paramString);
      DataInputStream localDataInputStream = new DataInputStream(paramString);
      this.iConfigFileVersion = localDataInputStream.readInt();
      this.iRequestTime = localDataInputStream.readInt();
      int j = localDataInputStream.readInt();
      if (j != 0)
      {
        this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[j];
        int i = 0;
        while (i < j)
        {
          this.fileItem[i] = new QPSupportUpdCfg.QPUpdFileItem(this);
          Object localObject = new byte[512];
          int k = localDataInputStream.readInt();
          localDataInputStream.read((byte[])localObject, 0, k);
          localObject = new String((byte[])localObject);
          this.fileItem[i].strFilePath = ((String)localObject).substring(0, k);
          localObject = new byte[''];
          k = localDataInputStream.readInt();
          localDataInputStream.read((byte[])localObject, 0, k);
          localObject = new String((byte[])localObject);
          this.fileItem[i].strFileHash = ((String)localObject).substring(0, k);
          i += 1;
        }
      }
      paramString.close();
      return true;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean WriteConfigFile()
  {
    int i = 0;
    Object localObject = new File(CFG_FILEPATH);
    if ((((File)localObject).exists()) && (!((File)localObject).delete())) {
      return false;
    }
    try
    {
      localObject = new FileOutputStream(CFG_FILEPATH);
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(this.iConfigFileVersion);
      localDataOutputStream.writeInt(this.iRequestTime);
      if (this.fileItem == null) {
        localDataOutputStream.writeInt(0);
      }
      for (;;)
      {
        ((FileOutputStream)localObject).close();
        break;
        localDataOutputStream.writeInt(this.fileItem.length);
        while (i < this.fileItem.length)
        {
          localDataOutputStream.writeInt(this.fileItem[i].strFilePath.length());
          localDataOutputStream.write(this.fileItem[i].strFilePath.getBytes());
          localDataOutputStream.writeInt(this.fileItem[i].strFileHash.length());
          localDataOutputStream.write(this.fileItem[i].strFileHash.getBytes());
          i += 1;
        }
      }
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void addFileItem(File paramFile, String paramString)
  {
    if (this.fileItem == null) {}
    for (int i = 1;; i = this.fileItem.length + 1)
    {
      QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
      this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[i];
      int j = 0;
      while (j < i - 1)
      {
        this.fileItem[j] = arrayOfQPUpdFileItem[j];
        j += 1;
      }
    }
    this.fileItem[(i - 1)] = new QPSupportUpdCfg.QPUpdFileItem(this);
    this.fileItem[(i - 1)].strFilePath = paramString;
    this.fileItem[(i - 1)].strFileHash = MD5FileUtil.a(paramFile);
  }
  
  public boolean addFileItem(File paramFile)
  {
    boolean bool = false;
    int k = 0;
    if (paramFile.exists()) {
      if (this.fileItem == null) {
        break label133;
      }
    }
    label133:
    for (int i = this.fileItem.length;; i = 0)
    {
      QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = new QPSupportUpdCfg.QPUpdFileItem[i + 1];
      int j = 0;
      while (j < arrayOfQPUpdFileItem.length)
      {
        arrayOfQPUpdFileItem[j] = new QPSupportUpdCfg.QPUpdFileItem(this);
        j += 1;
      }
      if (this.fileItem != null)
      {
        j = k;
        while (j < i)
        {
          arrayOfQPUpdFileItem[j] = this.fileItem[j];
          j += 1;
        }
      }
      arrayOfQPUpdFileItem[i].strFileHash = MD5FileUtil.a(paramFile);
      arrayOfQPUpdFileItem[i].strFilePath = paramFile.getAbsolutePath();
      this.fileItem = arrayOfQPUpdFileItem;
      WriteConfigFile();
      bool = true;
      return bool;
    }
  }
  
  public String getFileDstPath(String paramString)
  {
    paramString = QPUpdFileOperation.a(paramString);
    if (this.fileItem == null) {}
    for (;;)
    {
      return null;
      int j = this.fileItem.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(QPUpdFileOperation.a(this.fileItem[i].strFilePath))) {
          return this.fileItem[i].strFilePath;
        }
        i += 1;
      }
    }
  }
  
  public String getFileHash(String paramString)
  {
    int i = getFileIndexInConfigFile(paramString);
    if (i == -1) {
      return null;
    }
    return this.fileItem[i].strFileHash;
  }
  
  public int getFileIndexInConfigFile(String paramString)
  {
    paramString = QPUpdFileOperation.a(paramString);
    if (this.fileItem == null) {}
    for (;;)
    {
      return -1;
      int j = this.fileItem.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(QPUpdFileOperation.a(this.fileItem[i].strFilePath)))
        {
          paramString = this.fileItem[i].strFilePath;
          return i;
        }
        i += 1;
      }
    }
  }
  
  public int getFileItemCount()
  {
    if (this.fileItem == null) {
      return 0;
    }
    return this.fileItem.length;
  }
  
  public void updateCfgHash()
  {
    if (this.fileItem == null) {
      return;
    }
    int i = 0;
    label10:
    if (i < this.fileItem.length) {
      if (!QPUpdFileOperation.a(this.fileItem[i].strFilePath).equalsIgnoreCase("SupportUpd.cfg")) {
        break label46;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label46:
      File localFile = new File(this.fileItem[i].strFilePath);
      if (localFile.exists()) {
        this.fileItem[i].strFileHash = MD5FileUtil.a(localFile);
      } else {
        this.fileItem[i].strFileHash = "00000000000000000000000000000000";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSupportUpdCfg
 * JD-Core Version:    0.7.0.1
 */