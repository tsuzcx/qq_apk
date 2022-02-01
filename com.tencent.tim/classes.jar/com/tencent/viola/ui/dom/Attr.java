package com.tencent.viola.ui.dom;

import android.support.annotation.NonNull;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class Attr
  implements Cloneable, Map<String, Object>
{
  public static String TAG = "Attr";
  @NonNull
  private final Map<String, Object> attr = new HashMap();
  
  public Attr() {}
  
  public Attr(@NonNull Map<String, Object> paramMap)
  {
    this();
    this.attr.putAll(paramMap);
  }
  
  public Attr(@NonNull JSONObject paramJSONObject)
  {
    this();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      try
      {
        String str = (String)localIterator.next();
        put(str, paramJSONObject.get(str));
      }
      catch (JSONException localJSONException)
      {
        ViolaLogUtils.e(TAG, "JSONException e:" + localJSONException.getMessage());
      }
    }
  }
  
  public boolean canRecycled()
  {
    Object localObject = get("recycle");
    if (localObject == null) {
      return true;
    }
    try
    {
      boolean bool = Boolean.parseBoolean(String.valueOf(localObject));
      return bool;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("ATTR", "recycle:" + localException);
    }
    return true;
  }
  
  public void clear()
  {
    this.attr.clear();
  }
  
  protected Attr clone()
  {
    Attr localAttr = new Attr();
    localAttr.attr.putAll(this.attr);
    return localAttr;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.attr.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.attr.containsValue(paramObject);
  }
  
  @NonNull
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.attr.entrySet();
  }
  
  public Object get(Object paramObject)
  {
    return this.attr.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.attr.isEmpty();
  }
  
  @NonNull
  public Set<String> keySet()
  {
    return this.attr.keySet();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return this.attr.put(paramString, paramObject);
  }
  
  public void putAll(@NonNull Map<? extends String, ?> paramMap)
  {
    this.attr.putAll(paramMap);
  }
  
  public Object remove(Object paramObject)
  {
    return this.attr.remove(paramObject);
  }
  
  public int size()
  {
    return this.attr.size();
  }
  
  @NonNull
  public Collection<Object> values()
  {
    return this.attr.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.dom.Attr
 * JD-Core Version:    0.7.0.1
 */