package com.tencent.qqmail.view.sectionlist;

public class SectionListItem
{
  public Object item;
  public String section;
  
  public SectionListItem(Object paramObject, String paramString)
  {
    this.item = paramObject;
    this.section = paramString;
  }
  
  public String toString()
  {
    return this.item.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.sectionlist.SectionListItem
 * JD-Core Version:    0.7.0.1
 */