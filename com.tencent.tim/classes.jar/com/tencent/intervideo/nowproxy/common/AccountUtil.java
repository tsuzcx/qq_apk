package com.tencent.intervideo.nowproxy.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public class AccountUtil
{
  public static final String DEVICE_ID_FILE = "DEVICE_ID";
  public static String sDeviceId = "";
  
  public static int getAccountType(LoginType paramLoginType)
  {
    switch (AccountUtil.1.$SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[paramLoginType.ordinal()])
    {
    case 1: 
    default: 
      return 2;
    case 2: 
      return 4;
    case 3: 
      return 5;
    case 4: 
      return 8;
    }
    return 9;
  }
  
  public static String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDeviceId)) {
      return sDeviceId;
    }
    paramContext = new File(paramContext.getFilesDir(), "DEVICE_ID");
    try
    {
      if (paramContext.exists()) {
        sDeviceId = readDeviceIdFromFile(paramContext);
      }
      for (;;)
      {
        return sDeviceId;
        sDeviceId = UUID.randomUUID().toString();
        paramContext.createNewFile();
        writeDeviceIdToFile(paramContext, sDeviceId);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static int getOriginalAccountType(LoginType paramLoginType)
  {
    if (paramLoginType == null) {
      return 0;
    }
    switch (AccountUtil.1.$SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[paramLoginType.ordinal()])
    {
    default: 
      return 0;
    case 4: 
      return 8;
    }
    return 9;
  }
  
  private static String readDeviceIdFromFile(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile.readFully(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte);
  }
  
  private static void writeDeviceIdToFile(File paramFile, String paramString)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramString.getBytes());
    paramFile.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.AccountUtil
 * JD-Core Version:    0.7.0.1
 */