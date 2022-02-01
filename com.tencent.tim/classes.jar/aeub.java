import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeub
{
  private long WH;
  private String bBA = "";
  private String bBB = "";
  private String bBy = "";
  private String bBz = "";
  
  public static aeub a(aeic[] paramArrayOfaeic)
  {
    int j = 0;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aeub localaeub = new aeub();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      if (!paramArrayOfaeic.has("DocsImportFileInfo")) {
        break label412;
      }
      paramArrayOfaeic = paramArrayOfaeic.getJSONObject("DocsImportFileInfo");
      if (paramArrayOfaeic.has("importFileMaxSize"))
      {
        localObject1 = paramArrayOfaeic.getString("importFileMaxSize");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localaeub.WH = Long.parseLong((String)localObject1);
        }
      }
      if (!paramArrayOfaeic.has("importFileType")) {
        break label245;
      }
      localObject1 = paramArrayOfaeic.getJSONArray("importFileType");
      localStringBuilder = new StringBuilder();
      localObject2 = new StringBuilder();
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label227;
      }
      i = 0;
    }
    catch (JSONException paramArrayOfaeic)
    {
      label412:
      for (;;)
      {
        Object localObject1;
        StringBuilder localStringBuilder;
        Object localObject2;
        int i;
        JSONObject localJSONObject;
        label227:
        label245:
        if (QLog.isColorLevel())
        {
          QLog.e("TencentDocImportFileInfoBean", 1, "exception = " + paramArrayOfaeic.toString());
          continue;
          i += 1;
          continue;
          i += 1;
        }
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
      if (localJSONObject.has("suffix"))
      {
        localStringBuilder.append(localJSONObject.getString("suffix"));
        ((StringBuilder)localObject2).append(localJSONObject.getString("suffix"));
        if (localJSONObject.has("maxSize")) {
          ((StringBuilder)localObject2).append("_").append(localJSONObject.getString("maxSize")).append("#");
        }
      }
    }
    else
    {
      localaeub.bBz = ((StringBuilder)localObject2).toString();
      localaeub.bBA = localStringBuilder.toString();
      if (paramArrayOfaeic.has("fileGroupType"))
      {
        localObject1 = paramArrayOfaeic.getJSONArray("fileGroupType");
        localStringBuilder = new StringBuilder();
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = j;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
            if ((!((JSONObject)localObject2).has("group")) || (!((JSONObject)localObject2).has("suffix"))) {
              break label459;
            }
            localStringBuilder.append(((JSONObject)localObject2).getString("group") + "_" + ((JSONObject)localObject2).getString("suffix") + "&");
            break label459;
          }
        }
        localaeub.bBB = localStringBuilder.toString();
      }
      if (paramArrayOfaeic.has("importFileTips"))
      {
        paramArrayOfaeic = paramArrayOfaeic.getString("importFileTips");
        if (!TextUtils.isEmpty(paramArrayOfaeic)) {
          localaeub.bBy = paramArrayOfaeic;
        }
      }
      return localaeub;
    }
  }
  
  public void Hv(String paramString)
  {
    this.bBy = paramString;
  }
  
  public long fy()
  {
    return this.WH;
  }
  
  public String ub()
  {
    return this.bBy;
  }
  
  public String uc()
  {
    return this.bBz;
  }
  
  public String ud()
  {
    return this.bBA;
  }
  
  public String ue()
  {
    return this.bBB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeub
 * JD-Core Version:    0.7.0.1
 */