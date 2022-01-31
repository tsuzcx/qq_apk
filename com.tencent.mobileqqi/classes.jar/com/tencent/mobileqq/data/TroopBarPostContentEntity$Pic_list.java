package com.tencent.mobileqq.data;

import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPostContentEntity$Pic_list
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_H = "h";
  protected static final String JSON_KEY_URL = "url";
  protected static final String JSON_KEY_W = "w";
  protected static final long serialVersionUID = 10008L;
  public int h;
  public String url;
  public int w;
  
  public TroopBarPostContentEntity$Pic_list() {}
  
  public TroopBarPostContentEntity$Pic_list(String paramString, int paramInt1, int paramInt2)
  {
    this.url = paramString;
    this.w = paramInt1;
    this.h = paramInt2;
  }
  
  public TroopBarPostContentEntity$Pic_list(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.url = TroopBarUtils.a(paramJSONObject, "url");
    this.w = TroopBarUtils.a(paramJSONObject, "w");
    this.h = TroopBarUtils.a(paramJSONObject, "h");
  }
  
  public JSONObject getJsonObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", this.url);
      localJSONObject.put("w", this.w);
      localJSONObject.put("h", this.h);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.url = paramObjectInput.readUTF();
    this.w = paramObjectInput.readInt();
    this.h = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.url);
    paramObjectOutput.writeInt(this.w);
    paramObjectOutput.writeInt(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list
 * JD-Core Version:    0.7.0.1
 */