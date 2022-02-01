import org.json.JSONObject;

public class kkt
{
  public String aak;
  public String aal;
  public String buttonTxt;
  public String rl;
  
  public kkt(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.aak = paramJSONObject.optString("dest_url");
      this.rl = paramJSONObject.optString("rl");
      this.buttonTxt = paramJSONObject.optString("button_txt");
      this.aal = paramJSONObject.optString("button_bg");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AdPKImageData{");
    localStringBuilder.append("destUrl=").append(this.aak);
    localStringBuilder.append(",rl=").append(this.rl);
    localStringBuilder.append(",buttonTxt=").append(this.buttonTxt);
    localStringBuilder.append(",buttonBg=").append(this.aal);
    localStringBuilder.append("}");
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkt
 * JD-Core Version:    0.7.0.1
 */