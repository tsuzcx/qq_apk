package com.tencent.qqmail.activity.setting.tableactivity.model;

public class DetailTableItem
  extends TableItem
{
  private String detail;
  private boolean isHideArrow = true;
  int style;
  
  public DetailTableItem(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2);
    this.detail = paramString;
  }
  
  public DetailTableItem(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    super(paramInt1, paramInt2);
    this.detail = paramString;
    this.style = paramInt3;
    this.isHideArrow = paramBoolean;
  }
  
  public DetailTableItem(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
    this.detail = paramString2;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public int getStyle()
  {
    return this.style;
  }
  
  public boolean isHideArrow()
  {
    return this.isHideArrow;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.model.DetailTableItem
 * JD-Core Version:    0.7.0.1
 */