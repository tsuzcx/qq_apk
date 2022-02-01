package com.tencent.qqmail.pushconfig;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.trd.guava.Splitter;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMPushConfigDialog
{
  private static final String LINE_SEP = "\n";
  private ArrayList<String> despLines;
  private String despTitle;
  private String tips;
  private String title;
  
  public static QMPushConfigDialog parseFrom(String paramString)
  {
    QMPushConfigDialog localQMPushConfigDialog = new QMPushConfigDialog();
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      Object localObject = paramString.split("\\|", -1);
      if (localObject.length == 4)
      {
        localQMPushConfigDialog.setTitle(localObject[0]);
        localQMPushConfigDialog.setDespTitle(localObject[1]);
        localQMPushConfigDialog.setTips(localObject[2]);
        paramString = new ArrayList();
        localObject = Lists.newArrayList(Splitter.on("\n").trimResults().omitEmptyStrings().split(localObject[3]));
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add((String)((Iterator)localObject).next());
          }
        }
        localQMPushConfigDialog.setDespLines(paramString);
      }
    }
    return localQMPushConfigDialog;
  }
  
  public ArrayList<String> getDespLines()
  {
    return this.despLines;
  }
  
  public String getDespTitle()
  {
    return this.despTitle;
  }
  
  public String getTips()
  {
    return this.tips;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void parseWithDictionary(JSONObject paramJSONObject)
  {
    Object localObject = "";
    try
    {
      if (paramJSONObject.getString("title") != null) {
        localObject = paramJSONObject.getString("title");
      }
      setTitle((String)localObject);
      localObject = "";
      if (paramJSONObject.getString("despTitle") != null) {
        localObject = paramJSONObject.getString("despTitle");
      }
      setDespTitle((String)localObject);
      localObject = "";
      if (paramJSONObject.getString("tips") != null) {
        localObject = paramJSONObject.getString("tips");
      }
      setTips((String)localObject);
      localObject = new ArrayList();
      JSONArray localJSONArray = paramJSONObject.getJSONArray("desp");
      if ((localJSONArray != null) && (localJSONArray.size() > 0))
      {
        int i = 0;
        while (i < localJSONArray.size())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          paramJSONObject = "";
          if (localJSONObject.getString("line") != null) {
            paramJSONObject = localJSONObject.getString("line");
          }
          ((ArrayList)localObject).add(paramJSONObject);
          i += 1;
        }
      }
      setDespLines((ArrayList)localObject);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void setDespLines(ArrayList<String> paramArrayList)
  {
    this.despLines = paramArrayList;
  }
  
  public void setDespTitle(String paramString)
  {
    this.despTitle = paramString;
  }
  
  public void setTips(String paramString)
  {
    this.tips = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    String str = "";
    if (this.despLines != null) {
      str = Joiner.on("\n").skipNulls().join(this.despLines);
    }
    return String.format("%s|%s|%s|%s", new Object[] { this.title, this.despTitle, this.tips, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigDialog
 * JD-Core Version:    0.7.0.1
 */