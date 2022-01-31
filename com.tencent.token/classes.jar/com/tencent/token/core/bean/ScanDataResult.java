package com.tencent.token.core.bean;

import com.tencent.token.utils.bugscanuitl.BugObject;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScanDataResult
  implements Serializable
{
  private static final long serialVersionUID = 7403688842799494496L;
  private ArrayList app_list;
  private String tip_text;
  private String worm_desc;
  private String worm_name;
  private int worm_type;
  
  public ScanDataResult(JSONObject paramJSONObject)
  {
    this.worm_name = paramJSONObject.getString("worm_name");
    this.worm_type = paramJSONObject.getInt("worm_type");
    this.worm_desc = paramJSONObject.getString("worm_desc");
    this.tip_text = paramJSONObject.getString("result_subtitle");
    paramJSONObject = paramJSONObject.getJSONArray("app_list");
    this.app_list = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      BugObject localBugObject = new BugObject(paramJSONObject.getJSONObject(i));
      this.app_list.add(localBugObject);
      i += 1;
    }
  }
  
  public final int a()
  {
    return this.worm_type;
  }
  
  public final String b()
  {
    return this.worm_name;
  }
  
  public final String c()
  {
    return this.worm_desc;
  }
  
  public final String d()
  {
    return this.tip_text;
  }
  
  public final ArrayList e()
  {
    return this.app_list;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.ScanDataResult
 * JD-Core Version:    0.7.0.1
 */