package com.tencent.qqmail.pushconfig;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class QMCommonPushConfig
  extends QMPushConfig
{
  public static final int QMPUSHCONFIGDISPLAY_TYPE_DEFAULT = 0;
  public static final int QMPUSHCONFIGDISPLAY_TYPE_DIALOG = 2;
  public static final int QMPUSHCONFIGDISPLAY_TYPE_NOTIFICATION = 1;
  private String action;
  private ArrayList<QMPushConfigItem> items;
  private boolean sound;
  private String subject;
  private String title;
  private int type;
  private boolean vibra;
  
  public QMCommonPushConfig(QMPushConfig paramQMPushConfig)
  {
    super(paramQMPushConfig);
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public ArrayList<QMPushConfigItem> getItems()
  {
    return this.items;
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
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean getVibra()
  {
    return this.vibra;
  }
  
  public void parseWithDictionary()
  {
    try
    {
      if (!StringUtils.isBlank(this.content))
      {
        Object localObject2 = JSONObject.parseObject(this.content);
        if (localObject2 != null)
        {
          Object localObject1 = "";
          if (((JSONObject)localObject2).getJSONObject("title") != null) {
            localObject1 = ((JSONObject)localObject2).getString("title");
          }
          setTitle((String)localObject1);
          localObject1 = "";
          if (((JSONObject)localObject2).getJSONObject("subject") != null) {
            localObject1 = ((JSONObject)localObject2).getString("subject");
          }
          setSubject((String)localObject1);
          if (((JSONObject)localObject2).getJSONObject("vibra") != null) {
            setVibra(((JSONObject)localObject2).getBoolean("vibra").booleanValue());
          }
          if (((JSONObject)localObject2).getJSONObject("sound") != null) {
            setSound(((JSONObject)localObject2).getBoolean("sound").booleanValue());
          }
          if (((JSONObject)localObject2).getJSONObject("type") != null) {
            setType(((JSONObject)localObject2).getInteger("type").intValue());
          }
          localObject1 = "";
          if (((JSONObject)localObject2).getJSONObject("action") != null) {
            localObject1 = ((JSONObject)localObject2).getString("action");
          }
          setAction((String)localObject1);
          localObject1 = ((JSONObject)localObject2).getJSONArray("item");
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((JSONArray)localObject1).size() > 0))
          {
            int i = 0;
            while (i < ((JSONArray)localObject1).size())
            {
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
              QMPushConfigItem localQMPushConfigItem = new QMPushConfigItem();
              localQMPushConfigItem.parseWithDictionary(localJSONObject);
              ((ArrayList)localObject2).add(localQMPushConfigItem);
              i += 1;
            }
          }
          setItems((ArrayList)localObject2);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setItems(ArrayList<QMPushConfigItem> paramArrayList)
  {
    this.items = paramArrayList;
  }
  
  public void setSound(boolean paramBoolean)
  {
    this.sound = paramBoolean;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setVibra(boolean paramBoolean)
  {
    this.vibra = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMCommonPushConfig
 * JD-Core Version:    0.7.0.1
 */