package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import siy;

public class ContentElement
  extends RichTextElement
{
  public static final Parcelable.Creator<ContentElement> CREATOR = new siy();
  public String content;
  
  public ContentElement()
  {
    super(4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ContentElement [content=" + this.content + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.richtext.element.ContentElement
 * JD-Core Version:    0.7.0.1
 */