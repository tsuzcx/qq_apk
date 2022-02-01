package com.tencent.qqmail.utilities.qmnetwork.service;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.json.JSONReader;

public class PushSchemaBody
  implements IJsonInterface
{
  private int id;
  private String schema;
  private boolean sound;
  private String subject;
  private String title;
  private boolean vibra;
  
  public JSONObject fromJson(String paramString)
  {
    boolean bool2 = true;
    paramString = (JSONObject)JSONReader.parse(paramString);
    if (paramString != null)
    {
      this.title = paramString.getString("t");
      this.subject = paramString.getString("s");
      if ((paramString.getString("vibra") == null) || (!paramString.getString("vibra").equals("1"))) {
        break label154;
      }
      bool1 = true;
      this.vibra = bool1;
      if ((paramString.getString("sound") == null) || (!paramString.getString("sound").equals("1"))) {
        break label159;
      }
    }
    label154:
    label159:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sound = bool1;
      this.schema = paramString.getString("schema");
      this.id = QMMath.hashInt(this.title + "#" + this.subject + "#" + this.schema);
      return paramString;
      bool1 = false;
      break;
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getSchema()
  {
    return this.schema;
  }
  
  public boolean getSound()
  {
    return this.sound;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean getVibra()
  {
    return this.vibra;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("t", this.title);
    localJSONObject.put("s", this.subject);
    if (this.vibra)
    {
      str = "1";
      localJSONObject.put("vibra", str);
      if (!this.sound) {
        break label88;
      }
    }
    label88:
    for (String str = "1";; str = "0")
    {
      localJSONObject.put("sound", str);
      localJSONObject.put("schema", this.schema);
      return localJSONObject.toString();
      str = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushSchemaBody
 * JD-Core Version:    0.7.0.1
 */