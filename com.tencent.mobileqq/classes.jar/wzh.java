import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import org.json.JSONException;
import org.json.JSONObject;

public class wzh
{
  public long a;
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("didRead", this.jdField_a_of_type_Boolean);
      localJSONObject.put("vid", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("videoIndex", this.jdField_a_of_type_Long);
      localJSONObject.put("isLocal", this.jdField_b_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("didRead");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("feedId");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("vid");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("videoIndex");
      this.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("isLocal");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String toString()
  {
    return "MsgTabVideoData{didRead=" + this.jdField_a_of_type_Boolean + ", feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", videoIndex='" + this.jdField_a_of_type_Long + '\'' + ", storyVideoItem=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + ", isLocal=" + this.jdField_b_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzh
 * JD-Core Version:    0.7.0.1
 */