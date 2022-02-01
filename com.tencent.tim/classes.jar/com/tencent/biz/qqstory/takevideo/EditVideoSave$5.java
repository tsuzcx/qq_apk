package com.tencent.biz.qqstory.takevideo;

import ram;
import rdz;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(rdz paramrdz) {}
  
  public void run()
  {
    if (this.this$0.aGH)
    {
      ram.d("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.this$0.aGH);
      return;
    }
    rdz localrdz;
    if (this.this$0.progress < 50) {
      localrdz = this.this$0;
    }
    for (localrdz.progress += this.this$0.bpE; this.this$0.progress > 99; localrdz.progress += 1)
    {
      this.this$0.progress = 99;
      this.this$0.updateProgress(this.this$0.progress);
      return;
      localrdz = this.this$0;
    }
    this.this$0.updateProgress(this.this$0.progress);
    this.this$0.adc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */