package com.tencent.mobileqq.activity.aio.item;

import aoiz;
import com.tencent.image.URLDrawable;

public final class ReplyTextItemBuilder$12
  implements Runnable
{
  public ReplyTextItemBuilder$12(String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((aoiz.hasFile(this.Iq)) && (this.s.getStatus() != 1)) {}
    try
    {
      this.s.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */