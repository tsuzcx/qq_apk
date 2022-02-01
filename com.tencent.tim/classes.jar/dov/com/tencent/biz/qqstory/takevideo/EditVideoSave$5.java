package dov.com.tencent.biz.qqstory.takevideo;

import ayhs;

public class EditVideoSave$5
  implements Runnable
{
  public EditVideoSave$5(ayhs paramayhs) {}
  
  public void run()
  {
    if (this.this$0.aGH) {
      return;
    }
    ayhs localayhs;
    if (this.this$0.progress < 50.0F) {
      localayhs = this.this$0;
    }
    for (localayhs.progress += this.this$0.Fy; this.this$0.progress > 99.0F; localayhs.progress += 1.0F)
    {
      this.this$0.progress = 99.0F;
      this.this$0.updateProgress((int)this.this$0.progress);
      return;
      localayhs = this.this$0;
    }
    this.this$0.updateProgress((int)this.this$0.progress);
    this.this$0.adc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5
 * JD-Core Version:    0.7.0.1
 */