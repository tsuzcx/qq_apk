package com.tencent.ttpic.openapi.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.time.DateUtils;
import com.tencent.ttpic.model.WMLogicPair;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WMLogic
{
  private static final String TAG = WMLogic.class.getSimpleName();
  private static final String TYPE_CASE = "case";
  public static final String TYPE_COUNTDOWN = "countdown";
  private static final String TYPE_RANGE = "range";
  public static final String TYPE_SINCE = "since";
  public String compare;
  public String data;
  private int mDays;
  public List<WMLogicPair> range;
  public String type;
  public List<WMLogicPair> wmcase;
  
  public int getDays()
  {
    return this.mDays;
  }
  
  public String getValue(String paramString, WMElement paramWMElement)
  {
    Object localObject = "";
    if (this.type.equals("case"))
    {
      paramString = LogicDataManager.getInstance().getValue(this.data, paramWMElement);
      paramWMElement = this.wmcase.iterator();
      do
      {
        if (!paramWMElement.hasNext()) {
          break;
        }
        localObject = (WMLogicPair)paramWMElement.next();
      } while (!((WMLogicPair)localObject).key.equals(paramString));
    }
    for (paramString = ((WMLogicPair)localObject).value;; paramString = "")
    {
      paramWMElement = paramString;
      int i;
      int j;
      label351:
      do
      {
        for (;;)
        {
          return paramWMElement;
          if (this.type.equals("range")) {
            try
            {
              paramString = LogicDataManager.getInstance().getValue(this.data, paramWMElement);
              i = this.range.size() - 1;
              for (;;)
              {
                paramWMElement = (WMElement)localObject;
                if (i < 0) {
                  break;
                }
                if ((Integer.parseInt(paramString) >= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == 0))
                {
                  paramString = ((WMLogicPair)this.range.get(i)).value;
                  return paramString;
                }
                i -= 1;
              }
              if (!this.type.equals("since")) {
                break label351;
              }
            }
            catch (NumberFormatException paramString)
            {
              LogUtils.e(TAG, paramString.getMessage());
              return "";
            }
          }
        }
        paramWMElement = new SimpleDateFormat("yyyy-MM-dd");
        if (!TextUtils.isEmpty(paramString))
        {
          j = DateUtils.daysBetween(paramString, paramWMElement.format(new Date()));
          i = 0;
        }
        for (;;)
        {
          paramString = (String)localObject;
          if (i < this.range.size())
          {
            if ((j <= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == this.range.size() - 1)) {
              paramString = ((WMLogicPair)this.range.get(i)).value;
            }
          }
          else
          {
            this.mDays = j;
            return String.format(paramString, new Object[] { Integer.valueOf(j) });
            paramString = this.compare;
            break;
          }
          i += 1;
        }
        paramWMElement = (WMElement)localObject;
      } while (!this.type.equals("countdown"));
      paramWMElement = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      if (!TextUtils.isEmpty(paramString))
      {
        j = DateUtils.daysBetween(paramWMElement, paramString);
        i = 0;
      }
      for (;;)
      {
        paramString = (String)localObject;
        if (i < this.range.size())
        {
          if ((j <= Integer.parseInt(((WMLogicPair)this.range.get(i)).key)) || (i == this.range.size() - 1)) {
            paramString = ((WMLogicPair)this.range.get(i)).value;
          }
        }
        else
        {
          this.mDays = j;
          return String.format(paramString, new Object[] { Integer.valueOf(j) });
          paramString = this.compare;
          break;
        }
        i += 1;
      }
    }
  }
  
  public void setCompare(String paramString1, String paramString2)
  {
    if (this.type.equals("since"))
    {
      paramString2 = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_since_" + paramString2, "");
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2;
      }
      this.compare = paramString1;
      return;
    }
    if (this.type.equals("countdown"))
    {
      paramString2 = VideoPrefsUtil.getDefaultPrefs().getString("prefs_key_watermark_countdown_" + paramString2, "");
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2;
      }
      this.compare = paramString1;
      return;
    }
    this.compare = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.WMLogic
 * JD-Core Version:    0.7.0.1
 */