package com.tencent.qqmail.activity.setting.tableactivity.model;

import com.tencent.qqmail.utilities.uitableview.UITableView;
import java.util.ArrayList;
import java.util.List;

public class Table
{
  private int level;
  private int resid;
  private List<TableItem> tableItems;
  private UITableView tableView;
  private String value;
  
  public Table(int paramInt)
  {
    this.resid = paramInt;
  }
  
  public Table(int paramInt, String paramString)
  {
    this(paramInt);
    this.value = paramString;
  }
  
  public Table add(TableItem paramTableItem)
  {
    if (this.tableItems == null) {
      this.tableItems = new ArrayList();
    }
    this.tableItems.add(paramTableItem);
    return this;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getResid()
  {
    return this.resid;
  }
  
  public List<TableItem> getTableItems()
  {
    return this.tableItems;
  }
  
  public UITableView getTableView()
  {
    return this.tableView;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setTableView(UITableView paramUITableView)
  {
    this.tableView = paramUITableView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.model.Table
 * JD-Core Version:    0.7.0.1
 */