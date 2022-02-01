import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class jzs
{
  public List<jzs.a> fR;
  public int type;
  
  public jzs()
  {
    this.type = 0;
    this.fR = new ArrayList();
  }
  
  public jzs(int paramInt, mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this.type = paramInt;
    if (paramConfigGroupInfo == null) {}
    for (;;)
    {
      return;
      paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
      this.fR = new ArrayList(paramConfigGroupInfo.size());
      paramConfigGroupInfo = paramConfigGroupInfo.iterator();
      while (paramConfigGroupInfo.hasNext()) {
        this.fR.add(new jzs.a((mobileqq_mp.ConfigInfo)paramConfigGroupInfo.next()));
      }
    }
  }
  
  public jzs(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this(0, paramConfigGroupInfo);
  }
  
  public static List<jzs> D(List<mobileqq_mp.ConfigGroupInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new jzs((mobileqq_mp.ConfigGroupInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List<jzs> e(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        int k = paramJSONArray.length();
        int i = 0;
        if (i >= k) {
          break;
        }
        Object localObject = paramJSONArray.getJSONObject(i);
        jzs localjzs = new jzs();
        localjzs.type = ((JSONObject)localObject).optInt("type");
        localObject = ((JSONObject)localObject).getJSONArray("config");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        if (j < m)
        {
          jzs.a locala = jzs.a.a(((JSONArray)localObject).getJSONObject(j));
          if (locala != null) {
            localjzs.fR.add(locala);
          }
        }
        else
        {
          localArrayList.add(localjzs);
          i += 1;
          continue;
        }
        j += 1;
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return localArrayList;
      }
    }
  }
  
  public static class a
  {
    public static final Map<Class<?>, Integer> TYPES = new HashMap();
    public String Vp;
    public String Vq;
    public int aGG;
    public int aGH;
    public int aGI;
    public int aGJ;
    public String content;
    public int height;
    public String icon;
    public String lat;
    public String lng;
    public String pic_url;
    public int state;
    public String title;
    public int type;
    public String url;
    public String vid;
    public int width;
    
    static
    {
      TYPES.put(Boolean.TYPE, Integer.valueOf(1));
      TYPES.put(Integer.TYPE, Integer.valueOf(2));
      TYPES.put(Long.TYPE, Integer.valueOf(3));
      TYPES.put(String.class, Integer.valueOf(4));
      TYPES.put(Double.TYPE, Integer.valueOf(5));
    }
    
    public a() {}
    
    public a(mobileqq_mp.ConfigInfo paramConfigInfo)
    {
      this.type = paramConfigInfo.type.get();
      this.title = paramConfigInfo.title.get();
      this.content = paramConfigInfo.content.get();
      this.aGH = paramConfigInfo.event_id.get();
      this.url = paramConfigInfo.url.get();
      this.state = paramConfigInfo.state.get();
      this.aGI = paramConfigInfo.state_id.get();
      this.aGJ = paramConfigInfo.confirm_flag.get();
      this.Vp = paramConfigInfo.confirm_tips.get();
    }
    
    public static a a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        paramJSONObject = null;
      }
      a locala;
      for (;;)
      {
        return paramJSONObject;
        locala = new a();
        try
        {
          locala.type = paramJSONObject.optInt("type");
          locala.title = paramJSONObject.optString("title");
          locala.content = paramJSONObject.optString("content");
          locala.aGG = paramJSONObject.optInt("follow_handle");
          locala.aGH = paramJSONObject.optInt("event_id");
          locala.state = paramJSONObject.optInt("state");
          locala.aGI = paramJSONObject.optInt("state_id");
          locala.url = paramJSONObject.optString("url");
          locala.aGJ = paramJSONObject.optInt("confirm_flag");
          locala.Vp = paramJSONObject.optString("confirm_tips");
          locala.pic_url = paramJSONObject.optString("pic_url");
          locala.lng = paramJSONObject.optString("lng");
          locala.lat = paramJSONObject.optString("lat");
          locala.Vq = paramJSONObject.optString("phone_number");
          locala.width = paramJSONObject.optInt("width");
          locala.height = paramJSONObject.optInt("height");
          locala.icon = paramJSONObject.optString("icon");
          locala.vid = paramJSONObject.optString("vid");
          paramJSONObject = locala;
          if (locala.type == 3)
          {
            paramJSONObject = locala;
            if (locala.aGH == 23)
            {
              paramJSONObject = locala;
              if (!TextUtils.isEmpty(locala.content))
              {
                jts localjts = new jts();
                localjts.lo(locala.content);
                if ((TextUtils.isEmpty(locala.pic_url)) && (!TextUtils.isEmpty(localjts.a.cover))) {
                  locala.pic_url = localjts.a.cover;
                }
                paramJSONObject = locala;
                if (TextUtils.isEmpty(locala.title))
                {
                  paramJSONObject = locala;
                  if (!TextUtils.isEmpty(localjts.title))
                  {
                    locala.title = localjts.title;
                    return locala;
                  }
                }
              }
            }
          }
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzs
 * JD-Core Version:    0.7.0.1
 */