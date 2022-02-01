package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.AssertUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ValueBean
{
  private static final String TAG = "ValueBean";
  private Map<String, ValueNode> attributeDynamicValue = new ArrayMap();
  private Map<String, ValueNode> dataAttributeDynamicValue = new ArrayMap();
  private Map<String, Object> dataAttributeLocalInfo = new ArrayMap();
  private Map<String, Object> dataAttributeRemoteInfo = new ArrayMap();
  public Map<String, Object> dynamicValue = new ArrayMap();
  private Map<String, Node> dynamicValueBinder = new ArrayMap();
  public Map<String, Object> normalValue = new ArrayMap();
  
  private void putTrueDynamicValueAttrbute(String paramString1, Object paramObject, String paramString2)
  {
    ValueNode localValueNode = (ValueNode)this.attributeDynamicValue.get(paramString2);
    if (localValueNode != null) {
      localValueNode.setTrueValue(this.dynamicValue, paramString2, paramString1, paramObject);
    }
  }
  
  private void putTrueDynamicValueDataAttr(String paramString1, Object paramObject, String paramString2)
  {
    Object localObject = (ValueNode)this.dataAttributeDynamicValue.get(paramString2);
    if (localObject != null)
    {
      ((ValueNode)localObject).setTrueValue(this.dataAttributeRemoteInfo, paramString2, paramString1, paramObject);
      if ("$setRemoteInfo:".equals(paramString2))
      {
        paramString1 = this.dataAttributeRemoteInfo.remove("$setRemoteInfo:");
        if ((paramString1 instanceof JSONObject))
        {
          paramString1 = (JSONObject)paramString1;
          paramObject = paramString1.keys();
          while ((paramObject != null) && (paramObject.hasNext()))
          {
            paramString2 = (String)paramObject.next();
            localObject = paramString1.opt(paramString2);
            if (localObject != null) {
              this.dataAttributeRemoteInfo.put(paramString2, localObject);
            }
          }
        }
      }
    }
  }
  
  public ValueBean clone()
  {
    ValueBean localValueBean = new ValueBean();
    localValueBean.normalValue = this.normalValue;
    localValueBean.dynamicValueBinder = this.dynamicValueBinder;
    localValueBean.attributeDynamicValue = this.attributeDynamicValue;
    localValueBean.dataAttributeDynamicValue = this.dataAttributeDynamicValue;
    localValueBean.dataAttributeLocalInfo = this.dataAttributeLocalInfo;
    return localValueBean;
  }
  
  public Object getDataAttribute(String paramString)
  {
    Object localObject = this.dataAttributeRemoteInfo.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    return this.dataAttributeLocalInfo.get(paramString);
  }
  
  public Map<String, Object> getDataAttribute()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.dataAttributeLocalInfo);
    localArrayMap.putAll(this.dataAttributeRemoteInfo);
    return localArrayMap;
  }
  
  public String getVisibleDependeOnBrotherViewId()
  {
    if (this.normalValue.containsKey("visible_depend_on_brother"))
    {
      Object localObject = this.normalValue.get("visible_depend_on_brother");
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  public boolean isDefalutVisible()
  {
    return (this.normalValue.containsKey("default_visible")) && ("YES".equals((String)this.normalValue.get("default_visible")));
  }
  
  public boolean isVisible()
  {
    return "VISIBLE".equals(this.dynamicValue.get("visibility"));
  }
  
  public boolean isVisibleDependeOnChilds()
  {
    return (this.normalValue.containsKey("visible_depend_on_children")) && ("YES".equals(this.normalValue.get("visible_depend_on_children")));
  }
  
  public void putAttributeDynamicValue(String paramString, Object paramObject)
  {
    paramObject = new ValueNode(paramObject);
    this.attributeDynamicValue.put(paramString, paramObject);
  }
  
  public void putDataAttributeDynamicValue(String paramString, Object paramObject)
  {
    paramObject = new ValueNode(paramObject);
    this.dataAttributeDynamicValue.put(paramString, paramObject);
  }
  
  public void putDataAttributeLocalData(String paramString, Object paramObject)
  {
    this.dataAttributeLocalInfo.put(paramString, paramObject);
  }
  
  public void putDynamicValue(String paramString1, String paramString2)
  {
    paramString2 = new Node(paramString2, (Node)this.dynamicValueBinder.get(paramString1));
    this.dynamicValueBinder.put(paramString1, paramString2);
  }
  
  public void putNomalValue(String paramString, Object paramObject)
  {
    this.normalValue.put(paramString, paramObject);
  }
  
  public void putTrueDynamicValue(String paramString, Object paramObject)
  {
    putTrueDynamicValue(paramString, paramObject, true);
  }
  
  public boolean putTrueDynamicValue(String paramString, Object paramObject, boolean paramBoolean)
  {
    Node localNode2 = (Node)this.dynamicValueBinder.get(paramString);
    Node localNode1 = localNode2;
    if (localNode2 == null)
    {
      if (paramBoolean) {
        this.dynamicValue.put(paramString, paramObject);
      }
      return false;
    }
    while (localNode1 != null)
    {
      putTrueDynamicValueAttrbute(paramString, paramObject, localNode1.methodName);
      putTrueDynamicValueDataAttr(paramString, paramObject, localNode1.methodName);
      localNode1 = localNode1.next;
    }
    return true;
  }
  
  public String toString()
  {
    return "normalValueMap : " + this.normalValue.toString() + "\ndynamicValueMap : " + this.dynamicValue.toString() + "\ndynamicValueBinder : " + this.dynamicValueBinder.toString();
  }
  
  static class Node
  {
    String methodName;
    Node next;
    
    public Node(String paramString, Node paramNode)
    {
      this.methodName = paramString;
      this.next = paramNode;
    }
  }
  
  static class ValueNode
  {
    Object styleDynamicValue;
    
    public ValueNode(Object paramObject)
    {
      this.styleDynamicValue = paramObject;
    }
    
    private Object createJsonType(Object paramObject)
    {
      if ((paramObject instanceof JSONObject)) {
        return new JSONObject();
      }
      if ((paramObject instanceof JSONArray)) {
        return new JSONArray();
      }
      return null;
    }
    
    private boolean isDynamicValue(String paramString1, String paramString2)
    {
      return (paramString1.equals(paramString2)) || (("$" + paramString1).equals(paramString2));
    }
    
    private boolean setTrueValue(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
    {
      Object localObject1;
      Object localObject2;
      int i;
      boolean bool2;
      Object localObject3;
      if ((paramObject1 instanceof JSONArray))
      {
        localObject1 = (JSONArray)paramObject1;
        localObject2 = (JSONArray)paramObject2;
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i < ((JSONArray)localObject1).length())
        {
          try
          {
            localObject3 = ((JSONArray)localObject1).get(i);
            if ((localObject3 instanceof String)) {
              if (isDynamicValue(paramString, (String)localObject3))
              {
                ((JSONArray)localObject2).put(i, paramObject3);
                bool2 = true;
              }
              else
              {
                bool2 = bool1;
                if (((JSONArray)localObject2).length() <= i)
                {
                  ((JSONArray)localObject2).put(i, localObject3);
                  bool2 = bool1;
                }
              }
            }
          }
          catch (JSONException paramObject1)
          {
            LogUtil.QLog.e("ValueBean", 2, "setTrueValue: ", paramObject1);
            break label400;
          }
          paramObject1 = null;
          if (i < ((JSONArray)localObject2).length()) {
            paramObject1 = ((JSONArray)localObject2).get(i);
          }
          paramObject2 = paramObject1;
          if (paramObject1 == null) {
            paramObject2 = createJsonType(localObject3);
          }
          ((JSONArray)localObject2).put(i, paramObject2);
          bool2 = setTrueValue(localObject3, paramObject2, paramString, paramObject3);
          bool2 = bool1 | bool2;
          break label396;
        }
      }
      else if ((paramObject1 instanceof JSONObject))
      {
        localObject1 = (JSONObject)paramObject1;
        localObject2 = (JSONObject)paramObject2;
        localObject3 = ((JSONObject)localObject1).keys();
      }
      label396:
      label400:
      label413:
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          Object localObject4;
          try
          {
            localObject4 = ((JSONObject)localObject1).get(str);
            if ((localObject4 instanceof String)) {
              if (isDynamicValue(paramString, (String)localObject4))
              {
                ((JSONObject)localObject2).put(str, paramObject3);
                bool2 = true;
              }
              else
              {
                bool2 = bool1;
                if (!((JSONObject)localObject2).has(str))
                {
                  ((JSONObject)localObject2).put(str, localObject4);
                  bool2 = bool1;
                }
              }
            }
          }
          catch (JSONException paramObject1)
          {
            LogUtil.QLog.e("ValueBean", 2, "setTrueValue: ", paramObject1);
            break label413;
          }
          paramObject2 = ((JSONObject)localObject2).opt(str);
          paramObject1 = paramObject2;
          if (paramObject2 == null)
          {
            paramObject1 = createJsonType(localObject4);
            ((JSONObject)localObject2).put(str, paramObject1);
          }
          bool2 = setTrueValue(localObject4, paramObject1, paramString, paramObject3);
          bool2 = bool1 | bool2;
          continue;
          bool2 = false;
        }
        else
        {
          return bool2;
          bool1 = bool2;
          i += 1;
          break;
        }
      }
    }
    
    public void setTrueValue(Map<String, Object> paramMap, String paramString1, String paramString2, Object paramObject)
    {
      boolean bool;
      if ((this.styleDynamicValue instanceof String))
      {
        if (!isDynamicValue(paramString2, (String)this.styleDynamicValue)) {
          break label108;
        }
        bool = true;
      }
      for (;;)
      {
        if ((bool) && (paramMap != null)) {
          paramMap.put(paramString1, paramObject);
        }
        if (AssertUtil.isDebugVersion()) {
          AssertUtil.assertInValidAttributesBinding(paramString1);
        }
        return;
        Object localObject2 = paramMap.get(paramString1);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = createJsonType(this.styleDynamicValue);
        }
        bool = setTrueValue(this.styleDynamicValue, localObject1, paramString2, paramObject);
        paramObject = localObject1;
        continue;
        label108:
        paramObject = null;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean
 * JD-Core Version:    0.7.0.1
 */