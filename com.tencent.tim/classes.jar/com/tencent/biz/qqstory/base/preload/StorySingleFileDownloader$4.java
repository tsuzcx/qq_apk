package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import png;
import pno;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(pno parampno, png parampng, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!pno.a(this.this$0).containsKey(this.a.downloadKey)) {
      return;
    }
    pno.a(this.this$0).remove(this.a.downloadKey);
    pno.a(this.this$0, this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */