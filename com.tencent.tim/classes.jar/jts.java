import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jts
{
  public jtt a;
  public jtu a;
  public jtv a;
  public boolean isExposured;
  public String picture;
  public String title;
  public String video;
  
  private void F(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("title")) {
      this.title = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("video")) {
      this.video = paramJSONObject.getString("video");
    }
    if (paramJSONObject.has("picture")) {
      this.picture = paramJSONObject.getString("picture");
    }
    if (paramJSONObject.has("picture_attr")) {
      H(paramJSONObject.getJSONObject("picture_attr"));
    }
    if (paramJSONObject.has("video_attr")) {
      I(paramJSONObject.getJSONObject("video_attr"));
    }
  }
  
  private void G(JSONObject paramJSONObject)
    throws JSONException
  {
    this.jdField_a_of_type_Jtt = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Jtt = new jtt();
      if (paramJSONObject.has("articleid")) {
        this.jdField_a_of_type_Jtt.qJ = paramJSONObject.getLong("articleid");
      }
      if (paramJSONObject.has("id")) {
        this.jdField_a_of_type_Jtt.id = paramJSONObject.getLong("id");
      }
      if (paramJSONObject.has("jumpurl")) {
        this.jdField_a_of_type_Jtt.jumpurl = paramJSONObject.getString("jumpurl");
      }
      if (paramJSONObject.has("msgtype")) {
        this.jdField_a_of_type_Jtt.msgtype = paramJSONObject.getInt("msgtype");
      }
      if (paramJSONObject.has("tasktype")) {
        this.jdField_a_of_type_Jtt.aDr = paramJSONObject.getInt("tasktype");
      }
      if (paramJSONObject.has("time")) {
        this.jdField_a_of_type_Jtt.time = paramJSONObject.getLong("time");
      }
      if (paramJSONObject.has("uniqueid")) {
        this.jdField_a_of_type_Jtt.qK = paramJSONObject.getLong("uniqueid");
      }
      if (paramJSONObject.has("rowkey")) {
        this.jdField_a_of_type_Jtt.rowkey = paramJSONObject.getString("rowkey");
      }
    }
  }
  
  private void H(JSONObject paramJSONObject)
    throws JSONException
  {
    this.jdField_a_of_type_Jtu = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Jtu = new jtu();
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_Jtu.cover = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.jdField_a_of_type_Jtu.Un = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("large")) {
        this.jdField_a_of_type_Jtu.large = paramJSONObject.getInt("large");
      }
    }
  }
  
  private void I(JSONObject paramJSONObject)
    throws JSONException
  {
    this.jdField_a_of_type_Jtv = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Jtv = new jtv();
      if (paramJSONObject.has("busitype")) {
        this.jdField_a_of_type_Jtv.aDs = paramJSONObject.getInt("busitype");
      }
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_Jtv.cover = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.jdField_a_of_type_Jtv.Un = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("fulltime")) {
        this.jdField_a_of_type_Jtv.aDt = paramJSONObject.getInt("fulltime");
      }
      if (paramJSONObject.has("h5url")) {
        this.jdField_a_of_type_Jtv.h5url = paramJSONObject.getString("h5url");
      }
      if (paramJSONObject.has("preheight")) {
        this.jdField_a_of_type_Jtv.aDu = paramJSONObject.getInt("preheight");
      }
      if (paramJSONObject.has("prewidth")) {
        this.jdField_a_of_type_Jtv.aDv = paramJSONObject.getInt("prewidth");
      }
      if (paramJSONObject.has("vid")) {
        this.jdField_a_of_type_Jtv.vid = paramJSONObject.getString("vid");
      }
      if (paramJSONObject.has("large")) {
        this.jdField_a_of_type_Jtv.large = paramJSONObject.getInt("large");
      }
    }
  }
  
  public void lo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          Object localObject = paramString.getJSONObject("msg");
          if (((JSONObject)localObject).has("item"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("item");
            int i;
            JSONArray localJSONArray;
            if (localObject == null)
            {
              i = 0;
              break label189;
              if (j >= i) {
                continue;
              }
              localJSONArray = ((JSONArray)localObject).getJSONArray(j);
              if (localJSONArray == null)
              {
                k = 0;
                break label194;
                if (m >= k) {
                  break label200;
                }
                F(localJSONArray.getJSONObject(m));
                m += 1;
                continue;
              }
            }
            else
            {
              i = ((JSONArray)localObject).length();
              break label189;
            }
            int k = localJSONArray.length();
            break label194;
          }
        }
        if (!paramString.has("msg_attr")) {
          break;
        }
        G(paramString.getJSONObject("msg_attr"));
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DynamicInfo", 2, "DynamicInfo Exception:" + paramString.getMessage());
      return;
      label189:
      int j = 0;
      continue;
      label194:
      int m = 0;
      continue;
      label200:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jts
 * JD-Core Version:    0.7.0.1
 */