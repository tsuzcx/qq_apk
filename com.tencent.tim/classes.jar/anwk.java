import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class anwk
{
  public JSONObject data = new JSONObject();
  
  public boolean azh()
  {
    JSONObject localJSONObject = this.data.optJSONObject("plugin");
    if (localJSONObject != null) {
      return localJSONObject.optInt("preload", 0) == 1;
    }
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "StudyRoomConfBean{data=" + this.data + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwk
 * JD-Core Version:    0.7.0.1
 */