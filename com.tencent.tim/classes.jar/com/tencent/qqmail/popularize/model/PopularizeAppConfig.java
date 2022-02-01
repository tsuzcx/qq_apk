package com.tencent.qqmail.popularize.model;

import java.util.ArrayList;

public class PopularizeAppConfig
  implements Comparable<PopularizeAppConfig>
{
  private int priority;
  private ArrayList<PopularizeSubItem> subitems;
  
  public int compareTo(PopularizeAppConfig paramPopularizeAppConfig)
  {
    return paramPopularizeAppConfig.getPriority() - getPriority();
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public ArrayList<PopularizeSubItem> getSubitems()
  {
    return this.subitems;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public void setSubitems(ArrayList<PopularizeSubItem> paramArrayList)
  {
    this.subitems = paramArrayList;
  }
  
  public String toString()
  {
    return "PopularizeAppConfig{priority=" + this.priority + ", subitems=" + this.subitems.toString() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.model.PopularizeAppConfig
 * JD-Core Version:    0.7.0.1
 */