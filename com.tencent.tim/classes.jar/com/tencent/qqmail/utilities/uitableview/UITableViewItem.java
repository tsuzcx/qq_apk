package com.tencent.qqmail.utilities.uitableview;

public class UITableViewItem
{
  private int arrowVisibility = 0;
  private int checkbox = -1;
  private String detail;
  private boolean disable;
  private int drawable = -1;
  private boolean isOpen;
  private String summary;
  private String title;
  
  public UITableViewItem(int paramInt, String paramString1, String paramString2)
  {
    this.drawable = paramInt;
    this.title = paramString1;
    this.summary = paramString2;
    this.detail = null;
  }
  
  public UITableViewItem(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.checkbox = paramInt;
    this.title = paramString1;
    this.summary = paramString2;
    this.isOpen = paramBoolean;
  }
  
  public UITableViewItem(String paramString)
  {
    this.title = paramString;
    this.summary = null;
    this.detail = null;
  }
  
  public UITableViewItem(String paramString1, String paramString2)
  {
    this.title = paramString1;
    this.summary = paramString2;
    this.detail = null;
  }
  
  public UITableViewItem(String paramString1, String paramString2, String paramString3)
  {
    this.title = paramString1;
    this.summary = paramString2;
    this.detail = paramString3;
  }
  
  public UITableViewItem(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.title = paramString1;
    this.summary = paramString2;
    this.detail = paramString3;
    this.disable = paramBoolean;
    if (paramBoolean) {
      i = 8;
    }
    setArrowVisibility(i);
  }
  
  public int getArrowVisibility()
  {
    return this.arrowVisibility;
  }
  
  public int getCheckbox()
  {
    return this.checkbox;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public int getDrawable()
  {
    return this.drawable;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isDisable()
  {
    return this.disable;
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  public void setArrowVisibility(int paramInt)
  {
    this.arrowVisibility = paramInt;
  }
  
  public void setCheckbox(int paramInt)
  {
    this.checkbox = paramInt;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
  
  public void setDisable(boolean paramBoolean)
  {
    this.disable = paramBoolean;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setArrowVisibility(i);
      return;
    }
  }
  
  public void setDrawable(int paramInt)
  {
    this.drawable = paramInt;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
  }
  
  public void setSummary(String paramString)
  {
    this.summary = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableViewItem
 * JD-Core Version:    0.7.0.1
 */