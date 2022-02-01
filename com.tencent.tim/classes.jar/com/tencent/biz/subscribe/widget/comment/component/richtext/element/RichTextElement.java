package com.tencent.biz.subscribe.widget.comment.component.richtext.element;

import android.os.Parcelable;

public abstract class RichTextElement
  implements Parcelable, Comparable<RichTextElement>
{
  public int endPosition;
  public int startPosition;
  protected int type;
  
  public RichTextElement(int paramInt)
  {
    this.type = paramInt;
  }
  
  public int a(RichTextElement paramRichTextElement)
  {
    if (paramRichTextElement == null) {
      return 1;
    }
    return this.startPosition - paramRichTextElement.startPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.comment.component.richtext.element.RichTextElement
 * JD-Core Version:    0.7.0.1
 */