package com.tencent.ttpic.openapi.initializer;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.Coffee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class RapidnetModelManager
{
  public static final int MODEL_ID_GENDER_DETECT = 5;
  public static final int MODEL_ID_GENDER_SWITCH = 0;
  public static final int MODEL_ID_HAIR_SEG = 1;
  public static final int MODEL_ID_HAND_DETECT = 3;
  public static final int MODEL_ID_HUMAN_SEG = 4;
  public static final int MODEL_ID_SKY_SEG = 2;
  public static final int MODEL_ID_STYLE_CHILD = 6;
  public static final int MODEL_TYPE_GENDER_DETECT = 3;
  public static final int MODEL_TYPE_GENDER_SWITCH = 1;
  public static final int MODEL_TYPE_HAND_DETECT = 2;
  public static final int MODEL_TYPE_SEG = 0;
  private static final String TAG = "RapidnetModelManager";
  private Map<Integer, Boolean> rapidnetModelMap = new HashMap();
  
  public static String copyIfInAssets(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.startsWith("assets://"))
    {
      paramString3 = new File(paramString3, "tmp_" + paramString2);
      paramString3.deleteOnExit();
      paramString3 = paramString3.getPath();
      FileUtils.delete(paramString3);
      paramString1 = FileUtils.getRealPath(FileUtils.genSeperateFileDir(paramString1) + paramString2);
      FileUtils.copyAssets(AEModule.getContext(), paramString1, paramString3);
      return paramString3;
    }
    return FileUtils.genSeperateFileDir(paramString1) + paramString2;
  }
  
  public static String decryptRapidNetFile(String paramString1, String paramString2)
  {
    Object localObject = FileUtils.genSeperateFileDir(paramString1) + paramString2;
    paramString1 = FileUtils.genSeperateFileDir(paramString1) + "decrypt_" + paramString2;
    paramString2 = new File((String)localObject);
    localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      FileUtils.delete((File)localObject);
    }
    try
    {
      if ((paramString2.isFile()) && (paramString2.exists()))
      {
        localObject = new FileInputStream(paramString2);
        paramString2 = Coffee.drinkACupOfCoffee((InputStream)localObject, false);
        IOUtils.closeQuietly((InputStream)localObject);
        localObject = new FileOutputStream(paramString1);
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramString2.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
        }
      }
      return paramString1;
    }
    catch (FileNotFoundException paramString2)
    {
      paramString2.printStackTrace();
      LogUtils.e("RapidnetModelManager", "protoFile Not found: " + paramString2.getMessage());
      return paramString1;
      IOUtils.closeQuietly(paramString2);
      IOUtils.closeQuietly((OutputStream)localObject);
      return paramString1;
    }
    catch (IOException paramString2)
    {
      paramString2.printStackTrace();
      LogUtils.e("RapidnetModelManager", "drinkACupOfCoffee IOException : " + paramString2.getMessage());
    }
  }
  
  public void clear()
  {
    this.rapidnetModelMap.clear();
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    if (this.rapidnetModelMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.rapidnetModelMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return false;
  }
  
  public void toggleRapidModel(int paramInt, boolean paramBoolean)
  {
    this.rapidnetModelMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidnetModelManager
 * JD-Core Version:    0.7.0.1
 */