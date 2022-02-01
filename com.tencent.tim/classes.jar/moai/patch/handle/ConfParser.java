package moai.patch.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfParser
{
  private static void checkConfLinesNotEmpty(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new RuntimeException("no config lines found");
    }
  }
  
  private static void handleCmd(PatchConfig paramPatchConfig, List<String> paramList)
  {
    paramList = (String)paramList.get(0);
    if ((!paramList.equals("patch")) && (!paramList.equals("revert"))) {
      throw new RuntimeException("new patch command? :" + paramList);
    }
    paramPatchConfig.setCmd(paramList);
  }
  
  private static void handleConf(PatchConfig paramPatchConfig, String paramString, BufferedReader paramBufferedReader)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.equals(""))) {
        break;
      }
      localArrayList.add(str);
    }
    checkConfLinesNotEmpty(localArrayList);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("patch_cmd"))
        {
          i = 0;
          continue;
          if (paramString.equals("old_dex_merge_file"))
          {
            i = 1;
            continue;
            if (paramString.equals("new_dex_merge_file"))
            {
              i = 2;
              continue;
              if (paramString.equals("old_res_merge_file"))
              {
                i = 3;
                continue;
                if (paramString.equals("new_res_merge_file"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("native")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    handleCmd(paramPatchConfig, localArrayList);
    return;
    paramPatchConfig.setOld_dex_merge_file_adler32(Long.parseLong((String)localArrayList.get(0)));
    return;
    paramPatchConfig.setNew_dex_merge_file_adler32(Long.parseLong((String)localArrayList.get(0)));
    return;
    paramPatchConfig.setOld_res_merge_file_adler32(Long.parseLong((String)localArrayList.get(0)));
    return;
    paramPatchConfig.setNew_res_merge_file_adler32(Long.parseLong((String)localArrayList.get(0)));
    return;
    handleNative(paramPatchConfig, localArrayList);
  }
  
  private static void handleNative(PatchConfig paramPatchConfig, List<String> paramList)
  {
    checkConfLinesNotEmpty(paramList);
    paramList = (String)paramList.get(0);
    if ((paramList != null) && (!paramList.equals("")))
    {
      paramList = paramList.split(";");
      int j = paramList.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramList[i];
        if (!localObject.equals("")) {
          paramPatchConfig.getNatives().add(localObject);
        }
        i += 1;
      }
    }
  }
  
  public static PatchConfig parse(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new RuntimeException("not conf file found at:" + paramFile.getAbsolutePath());
    }
    PatchConfig localPatchConfig = new PatchConfig();
    paramFile = new BufferedReader(new FileReader(paramFile));
    for (;;)
    {
      String str = paramFile.readLine();
      if (str == null) {
        break;
      }
      if ((!str.equals("")) && (!str.startsWith("#")) && (str.startsWith("[")) && (str.endsWith("]"))) {
        handleConf(localPatchConfig, str.substring(1, str.length() - 1), paramFile);
      }
    }
    paramFile.close();
    return localPatchConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.ConfParser
 * JD-Core Version:    0.7.0.1
 */