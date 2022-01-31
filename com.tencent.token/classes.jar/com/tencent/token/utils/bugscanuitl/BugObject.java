package com.tencent.token.utils.bugscanuitl;

import java.io.Serializable;
import org.json.JSONObject;

public class BugObject
  implements Serializable
{
  private static final long serialVersionUID = 3882592292910895694L;
  private int id;
  private String name;
  private String packagename;
  private String version;
  
  public BugObject(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.getInt("id");
    this.name = paramJSONObject.getString("name");
    this.packagename = paramJSONObject.getString("package");
    this.version = paramJSONObject.getString("version");
  }
  
  public final String a()
  {
    return this.packagename;
  }
  
  public final String b()
  {
    return this.version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.BugObject
 * JD-Core Version:    0.7.0.1
 */