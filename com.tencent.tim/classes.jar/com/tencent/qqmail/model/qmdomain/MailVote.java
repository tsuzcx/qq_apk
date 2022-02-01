package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MailVote
  extends QMDomain
{
  private static final long serialVersionUID = 49777590619543337L;
  private MailVoteInformation information;
  private ArrayList<MailVoteOption> options;
  private MailVoteStatus status;
  
  public MailVoteInformation getInformation()
  {
    return this.information;
  }
  
  public ArrayList<MailVoteOption> getOptions()
  {
    return this.options;
  }
  
  public MailVoteStatus getStatus()
  {
    return this.status;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = bool2;
    label259:
    do
    {
      for (;;)
      {
        try
        {
          Object localObject = paramJSONObject.getJSONObject("inf");
          if (localObject != null)
          {
            bool3 = bool2;
            if (getInformation() != null)
            {
              bool3 = bool2;
              bool1 = false | getInformation().parseWithDictionary((JSONObject)localObject);
            }
          }
          else
          {
            bool3 = bool1;
            localObject = paramJSONObject.getJSONObject("st");
            bool2 = bool1;
            if (localObject != null)
            {
              bool3 = bool1;
              if (getStatus() == null) {
                break label259;
              }
              bool3 = bool1;
              bool2 = bool1 | getStatus().parseWithDictionary((JSONObject)localObject);
            }
            bool3 = bool2;
            localObject = new ArrayList();
            bool3 = bool2;
            if (!(paramJSONObject.get("opt") instanceof HashMap)) {
              break;
            }
            bool3 = bool2;
            ((ArrayList)localObject).add(paramJSONObject.getJSONObject("opt"));
            if (localObject == null) {
              break label344;
            }
            bool3 = bool2;
            setOptions(null);
            bool3 = bool2;
            setOptions(new ArrayList());
            bool3 = bool2;
            paramJSONObject = ((ArrayList)localObject).iterator();
            bool3 = bool2;
            if (!paramJSONObject.hasNext()) {
              break label344;
            }
            bool3 = bool2;
            localObject = (JSONObject)paramJSONObject.next();
            bool3 = bool2;
            MailVoteOption localMailVoteOption = new MailVoteOption();
            bool3 = bool2;
            localMailVoteOption.parseWithDictionary((JSONObject)localObject);
            bool3 = bool2;
            getOptions().add(localMailVoteOption);
            continue;
          }
          try
          {
            setInformation((MailVoteInformation)MailVoteInformation.fromDictionary((JSONObject)localObject, new MailVoteInformation()));
            bool1 = true;
          }
          catch (Exception paramJSONObject) {}
        }
        catch (Exception paramJSONObject)
        {
          return bool3;
        }
        setStatus((MailVoteStatus)MailVoteStatus.fromDictionary((JSONObject)localObject, new MailVoteStatus()));
        bool2 = true;
      }
      bool3 = bool2;
    } while (!(paramJSONObject.get("opt") instanceof JSONArray));
    bool3 = bool2;
    paramJSONObject = paramJSONObject.getJSONArray("opt").iterator();
    for (;;)
    {
      bool3 = bool2;
      if (!paramJSONObject.hasNext()) {
        break;
      }
      bool3 = bool2;
      ((ArrayList)localObject).add((JSONObject)paramJSONObject.next());
    }
    label344:
    return bool2;
    return true;
  }
  
  public void setInformation(MailVoteInformation paramMailVoteInformation)
  {
    this.information = paramMailVoteInformation;
  }
  
  public void setOptions(ArrayList<MailVoteOption> paramArrayList)
  {
    this.options = paramArrayList;
  }
  
  public void setStatus(MailVoteStatus paramMailVoteStatus)
  {
    this.status = paramMailVoteStatus;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailVote\",");
    if (getInformation() != null) {
      localStringBuffer.append("\"inf\":" + getInformation().toString() + ",");
    }
    if (getStatus() != null) {
      localStringBuffer.append("\"st\":" + getStatus().toString() + ",");
    }
    if ((this.options != null) && (this.options.size() > 0))
    {
      localStringBuffer.append("\"opt\":[");
      Iterator localIterator = this.options.iterator();
      while (localIterator.hasNext())
      {
        MailVoteOption localMailVoteOption = (MailVoteOption)localIterator.next();
        localStringBuffer.append(localMailVoteOption.toString() + ",");
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localStringBuffer.append("],");
    }
    int i = localStringBuffer.length() - 1;
    if (localStringBuffer.charAt(i) == ',') {
      localStringBuffer.deleteCharAt(i);
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailVote
 * JD-Core Version:    0.7.0.1
 */