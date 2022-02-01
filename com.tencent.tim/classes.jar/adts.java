import org.json.JSONObject;

public abstract interface adts
{
  public abstract boolean needProcess(JSONObject paramJSONObject);
  
  public abstract void process(JSONObject paramJSONObject, adtt paramadtt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adts
 * JD-Core Version:    0.7.0.1
 */