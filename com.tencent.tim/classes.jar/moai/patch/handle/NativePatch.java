package moai.patch.handle;

import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import moai.patch.log.PatchLog;
import moai.patch.natives.CpuArch;
import moai.patch.util.ExtractUtil;
import moai.patch.util.PatchUtil;

class NativePatch
{
  private static List<Pair<String, String>> makeSoList(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject.length == 2) && (!TextUtils.isEmpty(localObject[0])) && (!TextUtils.isEmpty(localObject[1]))) {
          localArrayList.add(Pair.create(localObject[0].toLowerCase(), localObject[1]));
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean patch(PatchConfig paramPatchConfig, String paramString, File paramFile, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      PatchLog.e(5001, "native patch cpu arch unknown:");
      return false;
    }
    paramPatchConfig = paramPatchConfig.getNatives();
    if ((paramPatchConfig != null) && (paramPatchConfig.size() <= 0)) {
      return true;
    }
    long l;
    int i;
    try
    {
      l = System.currentTimeMillis();
      i = 0;
      PatchLog.i(5004, "original so list:" + paramPatchConfig);
      localObject1 = makeSoList(paramPatchConfig);
      if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
        throw new RuntimeException("no valid so");
      }
    }
    catch (Exception paramPatchConfig)
    {
      PatchLog.e(5002, "native patch fail:" + paramPatchConfig.toString());
      throw new RuntimeException(paramPatchConfig);
    }
    CpuArch.sortSoList((List)localObject1);
    paramPatchConfig = new StringBuilder();
    HashSet localHashSet = new HashSet();
    Object localObject1 = ((List)localObject1).iterator();
    Pair localPair;
    int k;
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      localPair = (Pair)((Iterator)localObject1).next();
      if (!localHashSet.contains(localPair.second))
      {
        k = paramArrayOfString.length;
        j = 0;
      }
    }
    for (;;)
    {
      if (j < k)
      {
        String str = paramArrayOfString[j];
        if (!((String)localPair.first).equals(str)) {
          break label458;
        }
        paramPatchConfig.append(" [").append((String)localPair.first).append(", ").append((String)localPair.second).append("]");
        localHashSet.add(localPair.second);
        Object localObject2 = new File(paramFile, "so");
        PatchUtil.forceMkdir((File)localObject2);
        localObject2 = ((File)localObject2).getAbsolutePath() + File.separator + (String)localPair.second;
        ExtractUtil.extractFile(paramString, "lib" + File.separator + str + File.separator + (String)localPair.second, (String)localObject2);
        i += 1;
        break label455;
        PatchLog.i(5000, "native patch count:" + i + ",copied:" + paramPatchConfig.toString(), System.currentTimeMillis() - l);
        return true;
      }
      label455:
      break;
      label458:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.NativePatch
 * JD-Core Version:    0.7.0.1
 */