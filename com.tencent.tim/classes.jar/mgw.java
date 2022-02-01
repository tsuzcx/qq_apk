import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.channel_button.channel_button.Section;

public class mgw
{
  public List<TabChannelCoverInfo> iK = new ArrayList();
  public long id;
  public String name;
  public String text;
  
  public mgw(long paramLong, String paramString1, String paramString2)
  {
    this.id = paramLong;
    this.name = paramString1;
    this.text = paramString2;
  }
  
  public mgw(channel_button.Section paramSection)
  {
    this.id = paramSection.uint64_section_id.get();
    this.name = paramSection.str_section_name.get();
    this.text = paramSection.str_note_text.get();
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("name", this.name);
      localJSONObject.put("text", this.text);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgw
 * JD-Core Version:    0.7.0.1
 */