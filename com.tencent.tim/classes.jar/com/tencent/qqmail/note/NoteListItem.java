package com.tencent.qqmail.note;

public class NoteListItem
{
  private String mContent;
  private String mSubject;
  private String mThumbUrl;
  private String mTime;
  
  public NoteListItem() {}
  
  public NoteListItem(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mThumbUrl = paramString1;
    this.mTime = paramString4;
    this.mContent = paramString3;
    this.mSubject = paramString2;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public String getSubject()
  {
    return this.mSubject;
  }
  
  public String getThumbUrl()
  {
    return this.mThumbUrl;
  }
  
  public String getTime()
  {
    return this.mTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListItem
 * JD-Core Version:    0.7.0.1
 */