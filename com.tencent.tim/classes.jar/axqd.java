import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axqd
  implements Cloneable
{
  public List<MusicItemInfo> Fv;
  public int cVe;
  public String categoryName;
  public boolean dvY;
  public boolean enabled = true;
  
  public axqd() {}
  
  public axqd(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("categoryName")) {
      this.categoryName = paramJSONObject.getString("categoryName");
    }
    if (paramJSONObject.has("tagid")) {
      this.cVe = paramJSONObject.getInt("tagid");
    }
    if (paramJSONObject.has("enabled")) {
      this.enabled = paramJSONObject.getBoolean("enabled");
    }
    this.dvY = "1".equals(paramJSONObject.optString("random_position"));
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MusicItemInfo localMusicItemInfo = new MusicItemInfo(paramJSONObject.optString(i));
        localMusicItemInfo.mTagName = this.categoryName;
        if (localMusicItemInfo.isWsBanner()) {}
        localArrayList.add(localMusicItemInfo);
        i += 1;
      }
      this.Fv = localArrayList;
    }
  }
  
  public axqd a()
  {
    try
    {
      axqd localaxqd = (axqd)super.clone();
      return localaxqd;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public MusicItemInfo a(int paramInt)
  {
    if (this.Fv != null)
    {
      Iterator localIterator = this.Fv.iterator();
      while (localIterator.hasNext())
      {
        MusicItemInfo localMusicItemInfo = (MusicItemInfo)localIterator.next();
        if (localMusicItemInfo.mItemId == paramInt) {
          return localMusicItemInfo;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqd
 * JD-Core Version:    0.7.0.1
 */