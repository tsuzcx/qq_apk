package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ComposeData
  extends QMDomain
{
  private static final long serialVersionUID = 3482587131639678359L;
  private int accountId;
  private ArrayList<Object> alias_set;
  private int count;
  private Date datetime;
  private String defaultName;
  private String defaultNick;
  private ArrayList<ComposeDataSender> items;
  
  public ComposeData()
  {
    setDefaultName("");
    setAlias_set(new ArrayList());
    this.items = new ArrayList();
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public ArrayList<Object> getAlias_set()
  {
    this.alias_set = new ArrayList();
    if (this.items != null)
    {
      int i = 0;
      while (i < this.items.size())
      {
        this.alias_set.add(((ComposeDataSender)this.items.get(i)).getAlias());
        i += 1;
      }
    }
    return this.alias_set;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public Date getDatetime()
  {
    return this.datetime;
  }
  
  public String getDefaultName()
  {
    return this.defaultName;
  }
  
  public String getDefaultNick()
  {
    return this.defaultNick;
  }
  
  public ArrayList<Object> getFilterAliasSet()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.items != null)
    {
      int i = 0;
      while (i < this.items.size())
      {
        if (!"2".equals(((ComposeDataSender)this.items.get(i)).getType())) {
          localArrayList.add(((ComposeDataSender)this.items.get(i)).getAlias());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public ArrayList<ComposeDataSender> getItems()
  {
    return this.items;
  }
  
  public boolean isOutDate()
  {
    if (this.datetime == null) {}
    while (new Date().getTime() - this.datetime.getTime() >= 60000L) {
      return true;
    }
    return false;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try
    {
      Object localObject = paramJSONObject.getString("default");
      bool1 = bool3;
      if (!StringUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        setDefaultName((String)localObject);
        bool2 = true;
      }
      bool1 = bool2;
      localObject = paramJSONObject.getString("defaultnickname");
      bool3 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        setDefaultNick((String)localObject);
        bool3 = true;
      }
      bool1 = bool3;
      localObject = paramJSONObject.getString("count");
      bool2 = bool3;
      bool1 = bool3;
      if (!StringUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        setCount(Integer.parseInt((String)localObject));
        bool2 = true;
      }
      bool1 = bool2;
      localObject = paramJSONObject.getString("datetime");
      bool3 = bool2;
      bool1 = bool2;
      if (!StringUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool2;
        setDatetime(new Date(Long.parseLong((String)localObject)));
        bool3 = true;
      }
      bool1 = bool3;
      paramJSONObject = paramJSONObject.getJSONArray("item");
      bool1 = bool3;
      if (this.items == null)
      {
        bool1 = bool3;
        this.items = new ArrayList();
      }
      while (paramJSONObject != null)
      {
        bool1 = bool3;
        if (paramJSONObject.size() <= 0) {
          break;
        }
        bool1 = bool3;
        paramJSONObject = paramJSONObject.iterator();
        for (;;)
        {
          bool1 = bool3;
          if (!paramJSONObject.hasNext()) {
            break;
          }
          bool1 = bool3;
          localObject = paramJSONObject.next();
          bool1 = bool3;
          ComposeDataSender localComposeDataSender = new ComposeDataSender();
          bool1 = bool3;
          localComposeDataSender.parseWithDictionary((JSONObject)localObject);
          bool1 = bool3;
          this.items.add(localComposeDataSender);
        }
        bool1 = bool3;
        this.items.clear();
      }
      return bool3;
    }
    catch (Exception paramJSONObject) {}
    return bool1;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAlias_set(ArrayList<Object> paramArrayList)
  {
    this.alias_set = paramArrayList;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setDatetime(Date paramDate)
  {
    this.datetime = paramDate;
  }
  
  public void setDefaultName(String paramString)
  {
    this.defaultName = paramString;
  }
  
  public void setDefaultNick(String paramString)
  {
    this.defaultNick = paramString;
  }
  
  public void setItems(ArrayList<ComposeDataSender> paramArrayList)
  {
    this.items = paramArrayList;
  }
  
  public String toString()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("class", "ComposeData");
    if ((this.items != null) && (this.items.size() > 0))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        ComposeDataSender localComposeDataSender = (ComposeDataSender)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("class", "ComposeData");
        localJSONObject2.put("nick", localComposeDataSender.getNick());
        localJSONObject2.put("alias", localComposeDataSender.getAlias());
        localJSONObject2.put("type", localComposeDataSender.getType());
        localJSONObject2.put("signvalid", localComposeDataSender.getSignvalid());
        localJSONArray.add(localJSONObject2);
      }
      localJSONObject1.put("item", localJSONArray);
    }
    localJSONObject1.put("default", getDefaultName());
    localJSONObject1.put("defaultnickname", getDefaultNick());
    if (getDatetime() != null) {
      localJSONObject1.put("datetime", Long.valueOf(getDatetime().getTime()));
    }
    localJSONObject1.put("count", Integer.valueOf(getCount()));
    return localJSONObject1.toString();
  }
  
  public class ComposeDataSender
  {
    private String alias = "";
    private String nick = "";
    private String signvalid = "0";
    private String type = "";
    
    public ComposeDataSender() {}
    
    public String getAlias()
    {
      return this.alias;
    }
    
    public String getNick()
    {
      return this.nick;
    }
    
    public String getSignvalid()
    {
      return this.signvalid;
    }
    
    public String getType()
    {
      return this.type;
    }
    
    public boolean parseWithDictionary(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null) {}
      try
      {
        if ((paramJSONObject.get("nick") != null) && (!paramJSONObject.get("nick").equals(""))) {
          setNick((String)paramJSONObject.get("nick"));
        }
        if ((paramJSONObject.get("alias") != null) && (!paramJSONObject.get("alias").equals(""))) {
          setAlias((String)paramJSONObject.get("alias"));
        }
        if ((paramJSONObject.get("type") != null) && (!paramJSONObject.get("type").equals(""))) {
          setType((String)paramJSONObject.get("type"));
        }
        if ((paramJSONObject.get("signvalid") != null) && (!paramJSONObject.get("signvalid").equals(""))) {
          setSignvalid((String)paramJSONObject.get("signvalid"));
        }
        return true;
      }
      catch (Exception paramJSONObject) {}
      return true;
    }
    
    public void setAlias(String paramString)
    {
      this.alias = paramString;
    }
    
    public void setNick(String paramString)
    {
      this.nick = paramString;
    }
    
    public void setSignvalid(String paramString)
    {
      this.signvalid = paramString;
    }
    
    public void setType(String paramString)
    {
      this.type = paramString;
    }
    
    public String toString()
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("class", "ComposeData");
      localJSONObject.put("nick", getNick());
      localJSONObject.put("alias", getAlias());
      localJSONObject.put("type", getType());
      localJSONObject.put("signvalid", getSignvalid());
      return localJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ComposeData
 * JD-Core Version:    0.7.0.1
 */