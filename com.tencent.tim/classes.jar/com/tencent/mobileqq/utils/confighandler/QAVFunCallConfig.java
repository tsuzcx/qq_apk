package com.tencent.mobileqq.utils.confighandler;

import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class QAVFunCallConfig
  extends ConfigInfo
{
  public static final String TAG = "QAVConfig_382";
  final TreeMap<Integer, FCItem> fcItems = new TreeMap();
  
  public int getActivityFCId()
  {
    Iterator localIterator = this.fcItems.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (ConfigUtil.isActivity(((FCItem)localEntry.getValue()).begin, ((FCItem)localEntry.getValue()).end)) {
        return ((FCItem)localEntry.getValue()).fcid;
      }
    }
    return 0;
  }
  
  public FCItem getFCItem(int paramInt)
  {
    Iterator localIterator = this.fcItems.values().iterator();
    while (localIterator.hasNext())
    {
      FCItem localFCItem = (FCItem)localIterator.next();
      if (localFCItem.fcid == paramInt) {
        return localFCItem;
      }
    }
    return null;
  }
  
  protected boolean parse(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    ConfigHandler.checkUin("QAVConfig_382", this.mUin);
    for (;;)
    {
      boolean bool1;
      int i;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        paramJSONObject = paramJSONObject.optJSONArray("list");
        bool1 = bool2;
        if (paramJSONObject != null)
        {
          bool1 = bool2;
          if (paramJSONObject.length() > 0)
          {
            i = 0;
            bool1 = bool2;
            if (i < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
              if ((!localJSONObject.has("fcid")) || (!localJSONObject.has("begin")) || (!localJSONObject.has("end")) || (!localJSONObject.has("media")))
              {
                QLog.w("QAVConfig_382", 1, "parse, 缺少字段，[" + localJSONObject.toString() + "]");
              }
              else
              {
                FCItem localFCItem = new FCItem();
                localFCItem.fcid = localJSONObject.optInt("fcid");
                localFCItem.begin = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
                localFCItem.end = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
                localFCItem.media = localJSONObject.optString("media");
                this.fcItems.put(Integer.valueOf(localFCItem.fcid), localFCItem);
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        this.fcItems.clear();
        QLog.w("QAVConfig_382", 1, "parseJson, Exception", paramJSONObject);
        bool1 = false;
      }
      return bool1;
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("Size[").append(this.fcItems.size()).append("]");
    Iterator localIterator = this.fcItems.values().iterator();
    while (localIterator.hasNext())
    {
      FCItem localFCItem = (FCItem)localIterator.next();
      localStringBuilder.append("\n").append(localFCItem);
    }
    return localStringBuilder.toString();
  }
  
  public static class FCItem
  {
    long begin = 0L;
    int downloadStatus = 0;
    long end = 0L;
    int fcid = 0;
    String media = null;
    
    public String toString()
    {
      return "fcid[" + this.fcid + "], begin[" + this.begin + "], end[" + this.end + "], media[" + this.media + "], edownloadStatusnd[" + this.downloadStatus + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig
 * JD-Core Version:    0.7.0.1
 */