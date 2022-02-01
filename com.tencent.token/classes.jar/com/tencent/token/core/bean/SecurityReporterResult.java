package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;

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
  public ArrayList<ChartAreas> chart;
  public String noDataTip;
  public int type;
  public String userDesc;
  
  public class ChartAreas
    implements Serializable
  {
    private static final long serialVersionUID = -2239427414631374725L;
    public String subTtitle;
    public String table;
    public String title;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.SecurityReporterResult
 * JD-Core Version:    0.7.0.1
 */