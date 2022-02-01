package com.tencent.shadow.core.manager.installplugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginConfig
{
  public String UUID;
  public String UUID_NickName;
  public int[] compact_version;
  public FileInfo pluginLoader;
  public Map<String, PluginFileInfo> plugins = new HashMap();
  public FileInfo runTime;
  public File storageDir;
  public int version;
  
  private static String[] getArrayStringByName(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new String[paramJSONObject.length()];
      while (i < paramJSONObject.length())
      {
        paramString[i] = paramJSONObject.getString(i);
        i += 1;
      }
      return paramString;
    }
    return new String[0];
  }
  
  private static FileInfo getFileInfo(JSONObject paramJSONObject, File paramFile)
  {
    String str = paramJSONObject.getString("apkName");
    paramJSONObject = paramJSONObject.getString("hash");
    return new FileInfo(new File(paramFile, str), paramJSONObject);
  }
  
  private static PluginFileInfo getPluginFileInfo(JSONObject paramJSONObject, File paramFile)
  {
    return new PluginFileInfo(paramJSONObject.optString("businessName", ""), getFileInfo(paramJSONObject, paramFile), getArrayStringByName(paramJSONObject, "dependsOn"), getArrayStringByName(paramJSONObject, "hostWhiteList"));
  }
  
  public static PluginConfig parseFromJson(String paramString, File paramFile)
  {
    int j = 0;
    Object localObject1 = new JSONObject(paramString);
    paramString = new PluginConfig();
    paramString.version = ((JSONObject)localObject1).getInt("version");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("compact_version");
    int i;
    if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
    {
      paramString.compact_version = new int[((JSONArray)localObject2).length()];
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.compact_version[i] = ((JSONArray)localObject2).getInt(i);
        i += 1;
      }
    }
    paramString.UUID = ((JSONObject)localObject1).getString("UUID");
    paramString.UUID_NickName = ((JSONObject)localObject1).getString("UUID_NickName");
    localObject2 = ((JSONObject)localObject1).optJSONObject("pluginLoader");
    if (localObject2 != null) {
      paramString.pluginLoader = getFileInfo((JSONObject)localObject2, paramFile);
    }
    localObject2 = ((JSONObject)localObject1).optJSONObject("runtime");
    if (localObject2 != null) {
      paramString.runTime = getFileInfo((JSONObject)localObject2, paramFile);
    }
    localObject1 = ((JSONObject)localObject1).optJSONArray("plugins");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      i = j;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        String str = ((JSONObject)localObject2).getString("partKey");
        paramString.plugins.put(str, getPluginFileInfo((JSONObject)localObject2, paramFile));
        i += 1;
      }
    }
    paramString.storageDir = paramFile;
    return paramString;
  }
  
  static class FileInfo
  {
    File file;
    String hash;
    
    FileInfo(File paramFile, String paramString)
    {
      this.file = paramFile;
      this.hash = paramString;
    }
  }
  
  static class PluginFileInfo
    extends PluginConfig.FileInfo
  {
    final String businessName;
    final String[] dependsOn;
    final String[] hostWhiteList;
    
    PluginFileInfo(String paramString, PluginConfig.FileInfo paramFileInfo, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      this(paramString, paramFileInfo.file, paramFileInfo.hash, paramArrayOfString1, paramArrayOfString2);
    }
    
    PluginFileInfo(String paramString1, File paramFile, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      super(paramString2);
      this.businessName = paramString1;
      this.dependsOn = paramArrayOfString1;
      this.hostWhiteList = paramArrayOfString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.PluginConfig
 * JD-Core Version:    0.7.0.1
 */