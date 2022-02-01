package com.tencent.pts.ui;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PTSNodeInfo
{
  private final String TAG = "PTSNodeInfo";
  private PTSNodeAttribute attributes;
  private List<PTSNodeInfo> children;
  private String content;
  private HashMap<String, String> eventInfo;
  private boolean isRootNode;
  private String nodeType;
  private String parentID;
  private PTSNodeStyle style;
  private String uniqueID;
  
  public void addChild(int paramInt, PTSNodeInfo paramPTSNodeInfo)
  {
    if (this.children == null) {
      this.children = new ArrayList();
    }
    if ((paramInt >= 0) && (paramInt < this.children.size()))
    {
      this.children.add(paramInt, paramPTSNodeInfo);
      return;
    }
    this.children.add(paramPTSNodeInfo);
  }
  
  public void addChild(PTSNodeInfo paramPTSNodeInfo)
  {
    if (this.children == null) {
      this.children = new ArrayList();
    }
    this.children.add(paramPTSNodeInfo);
  }
  
  public void addChildren(List<PTSNodeInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (this.children == null) {
      this.children = new ArrayList();
    }
    this.children.addAll(paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof PTSNodeInfo)) {
      return TextUtils.equals(this.uniqueID, ((PTSNodeInfo)paramObject).getUniqueID());
    }
    return false;
  }
  
  public PTSNodeAttribute getAttributes()
  {
    return this.attributes;
  }
  
  public int getChildCount()
  {
    if (this.children == null) {
      return 0;
    }
    return this.children.size();
  }
  
  public List<PTSNodeInfo> getChildren()
  {
    if (this.children == null) {
      return new ArrayList();
    }
    return new ArrayList(this.children);
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public HashMap<String, String> getEventInfo()
  {
    return this.eventInfo;
  }
  
  public String getNodeType()
  {
    return this.nodeType;
  }
  
  public String getParentID()
  {
    return this.parentID;
  }
  
  public PTSNodeStyle getStyle()
  {
    return this.style;
  }
  
  public String getUniqueID()
  {
    return this.uniqueID;
  }
  
  public boolean hasChildren()
  {
    return (this.children != null) && (this.children.size() > 0);
  }
  
  public boolean hasParent()
  {
    return !TextUtils.isEmpty(this.parentID);
  }
  
  public boolean isContainer()
  {
    return ("view".equals(this.nodeType)) || ("page".equals(this.nodeType)) || ("block".equals(this.nodeType)) || ("swiper-item".equals(this.nodeType));
  }
  
  public boolean isRootNode()
  {
    return this.isRootNode;
  }
  
  public void removeChild(PTSNodeInfo paramPTSNodeInfo)
  {
    if (this.children != null) {
      this.children.remove(paramPTSNodeInfo);
    }
  }
  
  public void setChild(int paramInt, PTSNodeInfo paramPTSNodeInfo)
  {
    if ((this.children == null) || (paramInt < 0) || (paramInt >= this.children.size())) {
      return;
    }
    this.children.set(paramInt, paramPTSNodeInfo);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PTSNodeInfo: \n").append("uniqueID: ").append(this.uniqueID).append("\n").append("nodeType: ").append(this.nodeType).append("\n").append("isRootNode: ").append(this.isRootNode).append("\n").append("parentID: ").append(this.parentID).append("\n").append("content: ").append(this.content).append("\n");
    localStringBuilder.append("\n").append("Styles: ").append("\n");
    Object localObject = this.style.entrySet().iterator();
    Map.Entry localEntry;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("style [").append((String)localEntry.getKey()).append("] = ").append(localEntry.getValue()).append("\n");
    }
    localStringBuilder.append("\n").append("Attributes: ").append("\n");
    localObject = this.attributes.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("attribute [").append((String)localEntry.getKey()).append("] = ").append(localEntry.getValue()).append("\n");
    }
    localStringBuilder.append("\n").append("EventInfo: ").append("\n");
    localObject = this.eventInfo.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append("eventInfo [").append((String)localEntry.getKey()).append("] = ").append((String)localEntry.getValue()).append("\n");
    }
    if (hasChildren())
    {
      localStringBuilder.append("\n").append("child count = ").append(getChildCount()).append("\n");
      localStringBuilder.append("\n").append("Children: ").append("\n");
      localObject = getChildren();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        localStringBuilder.append("child [").append(i).append("] = \n").append(((List)localObject).get(i)).append("\n");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static class Builder
  {
    private PTSNodeAttribute attributes;
    private List<PTSNodeInfo> children;
    private String content;
    private HashMap<String, String> eventInfo;
    private boolean isRootNode;
    private String nodeType;
    private String parentID;
    private PTSNodeStyle style;
    private String uniqueID;
    
    private void check(PTSNodeInfo paramPTSNodeInfo)
    {
      if (paramPTSNodeInfo.style == null) {
        PTSNodeInfo.access$002(paramPTSNodeInfo, new PTSNodeStyle());
      }
      if (paramPTSNodeInfo.attributes == null) {
        PTSNodeInfo.access$102(paramPTSNodeInfo, new PTSNodeAttribute());
      }
      if (paramPTSNodeInfo.eventInfo == null) {
        PTSNodeInfo.access$202(paramPTSNodeInfo, new HashMap());
      }
    }
    
    public PTSNodeInfo build()
    {
      if ((TextUtils.isEmpty(this.nodeType)) || (TextUtils.isEmpty(this.uniqueID))) {
        throw new IllegalArgumentException("PTSNode info is wrong, there is no id or nodeType.");
      }
      PTSNodeInfo localPTSNodeInfo = new PTSNodeInfo(null);
      PTSNodeInfo.access$402(localPTSNodeInfo, this.nodeType);
      PTSNodeInfo.access$502(localPTSNodeInfo, this.uniqueID);
      PTSNodeInfo.access$602(localPTSNodeInfo, this.isRootNode);
      PTSNodeInfo.access$702(localPTSNodeInfo, this.parentID);
      PTSNodeInfo.access$802(localPTSNodeInfo, this.content);
      PTSNodeInfo.access$002(localPTSNodeInfo, this.style);
      PTSNodeInfo.access$102(localPTSNodeInfo, this.attributes);
      PTSNodeInfo.access$902(localPTSNodeInfo, this.children);
      PTSNodeInfo.access$202(localPTSNodeInfo, this.eventInfo);
      check(localPTSNodeInfo);
      return localPTSNodeInfo;
    }
    
    public Builder withChildren(List<PTSNodeInfo> paramList)
    {
      this.children = paramList;
      return this;
    }
    
    public Builder withContent(String paramString)
    {
      this.content = paramString;
      return this;
    }
    
    public Builder withEventInfo(HashMap<String, String> paramHashMap)
    {
      this.eventInfo = paramHashMap;
      return this;
    }
    
    public Builder withIsRootNode(boolean paramBoolean)
    {
      this.isRootNode = paramBoolean;
      return this;
    }
    
    public Builder withNodeType(String paramString)
    {
      this.nodeType = paramString;
      return this;
    }
    
    public Builder withPTSAttribute(PTSNodeAttribute paramPTSNodeAttribute)
    {
      this.attributes = new PTSNodeAttribute(paramPTSNodeAttribute);
      return this;
    }
    
    public Builder withPTSAttribute(JSONObject paramJSONObject)
    {
      this.attributes = new PTSNodeAttribute(paramJSONObject);
      return this;
    }
    
    public Builder withPTSStyle(PTSNodeStyle paramPTSNodeStyle)
    {
      this.style = new PTSNodeStyle(paramPTSNodeStyle);
      return this;
    }
    
    public Builder withPTSStyle(JSONObject paramJSONObject)
    {
      this.style = new PTSNodeStyle(paramJSONObject);
      return this;
    }
    
    public Builder withParentID(String paramString)
    {
      this.parentID = paramString;
      return this;
    }
    
    public Builder withUniqueID(String paramString)
    {
      this.uniqueID = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeInfo
 * JD-Core Version:    0.7.0.1
 */