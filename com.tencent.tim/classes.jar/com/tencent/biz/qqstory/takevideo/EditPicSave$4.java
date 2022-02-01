package com.tencent.biz.qqstory.takevideo;

import rbr;

public class EditPicSave$4
  implements Runnable
{
  public EditPicSave$4(rbr paramrbr) {}
  
  public void run()
  {
    if (this.this$0.aGH) {
      return;
    }
    rbr localrbr = this.this$0;
    localrbr.progress += this.this$0.bpE;
    if (this.this$0.progress > 99)
    {
      this.this$0.progress = 99;
      this.this$0.updateProgress(this.this$0.progress);
      return;
    }
    this.this$0.updateProgress(this.this$0.progress);
    this.this$0.adc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.4
 * JD-Core Version:    0.7.0.1
 */