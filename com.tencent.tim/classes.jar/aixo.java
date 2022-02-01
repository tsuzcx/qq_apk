import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aixo
{
  private aixq a(String paramString1, String paramString2)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      localaixq = new aixq();
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has("num")) {
          localaixq.dge = paramString1.getInt("num");
        }
        if (paramString1.has("process_frame"))
        {
          localObject = paramString1.getJSONObject("process_frame");
          if (((JSONObject)localObject).has("repeat")) {
            localaixq.cBJ = ((JSONObject)localObject).getInt("repeat");
          }
          if (((JSONObject)localObject).has("frame_delay")) {
            localaixq.mDuration = ((JSONObject)localObject).getInt("frame_delay");
          }
          localObject = ((JSONObject)localObject).getJSONArray("seq_array");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            localaixq.fq = new String[((JSONArray)localObject).length()];
            i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              localaixq.fq[i] = (afnu.bEC.replace("[epId]", paramString2) + ((JSONArray)localObject).getString(i));
              i += 1;
            }
          }
        }
        Object localObject = paramString1.getJSONArray("result_frame");
        paramString1 = localaixq;
        if (localObject == null) {
          continue;
        }
        paramString1 = localaixq;
        if (((JSONArray)localObject).length() <= 0) {
          continue;
        }
        localaixq.fr = new String[((JSONArray)localObject).length()];
        int i = j;
        for (;;)
        {
          paramString1 = localaixq;
          if (i >= ((JSONArray)localObject).length()) {
            break;
          }
          localaixq.fr[i] = (afnu.bEC.replace("[epId]", paramString2) + ((JSONArray)localObject).getString(i));
          i += 1;
        }
        return localaixq;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static int dr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (!paramString.contains("rscType"));
      i = paramString.indexOf("rscType") + "rscType".length() + 1;
    } while (i + 1 >= paramString.length());
    paramString = paramString.substring(i, i + 1);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public static int ds(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return 0;
      } while (!paramString.contains("value"));
      i = paramString.indexOf("value") + "value".length() + 1;
    } while (i >= paramString.length());
    paramString = paramString.substring(i);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static int il(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return Math.abs(new Random().nextInt(paramInt));
  }
  
  private String lG(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(afnu.bEC.replace("[epId]", paramString));
    localStringBuffer.append("config.json");
    paramString = new File(localStringBuffer.toString());
    if (!paramString.exists()) {
      return null;
    }
    return aqhq.readFileContent(paramString);
  }
  
  public static boolean nd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + paramString.getAbsolutePath() + "].");
      }
      return false;
    }
    Object localObject1 = new File(paramString, "config.json");
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + ((File)localObject1).getAbsolutePath() + "].");
      }
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(aqhq.readFileContent((File)localObject1));
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("process_frame");
        if (((JSONObject)localObject2).has("seq_array"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("seq_array");
          if (((JSONArray)localObject2).length() > 0)
          {
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              File localFile = new File(paramString, (String)((JSONArray)localObject2).get(i));
              if (localFile.exists()) {
                break label383;
              }
              if (!QLog.isColorLevel()) {
                break label381;
              }
              QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + localFile.getAbsolutePath() + "].");
              break label381;
            }
          }
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("result_frame");
        if (((JSONArray)localObject1).length() > 0)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = new File(paramString, (String)((JSONArray)localObject1).get(i));
            if (!((File)localObject2).exists())
            {
              if (QLog.isColorLevel()) {
                QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + ((File)localObject2).getAbsolutePath() + "].");
              }
              return false;
            }
            i += 1;
            continue;
          }
        }
        return true;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PngFrameUtil", 2, "func checkRandomPngExist, exception:" + paramString.getMessage());
        }
        return false;
      }
      label381:
      return false;
      label383:
      i += 1;
    }
  }
  
  public aixq c(String paramString)
  {
    return a(lG(paramString), paramString);
  }
  
  public int e(File paramFile)
  {
    paramFile = aqhq.readFileContent(paramFile);
    if (!TextUtils.isEmpty(paramFile)) {
      try
      {
        paramFile = new JSONObject(paramFile);
        if (paramFile.has("rscType"))
        {
          int i = paramFile.getInt("rscType");
          if (QLog.isColorLevel()) {
            QLog.d("PngFrameUtil", 2, "func getRscType(from local json file),type:" + i);
          }
          return i;
        }
        return 0;
      }
      catch (JSONException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixo
 * JD-Core Version:    0.7.0.1
 */