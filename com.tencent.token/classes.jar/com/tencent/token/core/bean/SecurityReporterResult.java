package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SecurityReporterResult
  implements Serializable
{
  public static final int CHART_TYPE_BAR = 3;
  public static final int CHART_TYPE_CITY = 6;
  public static final int CHART_TYPE_MAP = 5;
  public static final int CHART_TYPE_PIE = 4;
  public static final int CHART_TYPE_PLAT = 7;
  public static final int CHART_TYPE_TIME = 8;
  public static final int REPORTER_TYPE_ALL = 1;
  public static final int REPORTER_TYPE_USER_DESC = 2;
  private static final long serialVersionUID = -7875994227423532556L;
  public ArrayList chart = new ArrayList();
  public String noDataTip;
  public int type;
  public String userDesc;
  
  public SecurityReporterResult(JSONObject paramJSONObject)
  {
    this.type = paramJSONObject.getInt("type");
    this.userDesc = paramJSONObject.getString("user_desc");
    this.noDataTip = paramJSONObject.getString("no_data_tip");
    paramJSONObject = paramJSONObject.getJSONArray("chart");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.chart.clear();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        SecurityReporterResult.ChartAreas localChartAreas = new SecurityReporterResult.ChartAreas(this);
        localChartAreas.type = localJSONObject.getInt("type");
        localChartAreas.title = localJSONObject.getString("title");
        localChartAreas.subTtitle = localJSONObject.getString("subtitle");
        localChartAreas.table = localJSONObject.getJSONArray("table").toString();
        this.chart.add(localChartAreas);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.SecurityReporterResult
 * JD-Core Version:    0.7.0.1
 */