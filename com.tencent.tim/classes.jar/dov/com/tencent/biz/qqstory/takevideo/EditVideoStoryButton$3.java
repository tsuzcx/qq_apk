package dov.com.tencent.biz.qqstory.takevideo;

import ayia;

public class EditVideoStoryButton$3
  implements Runnable
{
  public EditVideoStoryButton$3(ayia paramayia) {}
  
  public void run()
  {
    if (this.this$0.aGH) {
      return;
    }
    ayia localayia;
    if (this.this$0.progress < 50.0F) {
      localayia = this.this$0;
    }
    for (localayia.progress += this.this$0.Fy; this.this$0.progress > 99.0F; localayia.progress += 1.0F)
    {
      this.this$0.progress = 99.0F;
      this.this$0.updateProgress((int)this.this$0.progress);
      return;
      localayia = this.this$0;
    }
    this.this$0.updateProgress((int)this.this$0.progress);
    this.this$0.adc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.3
 * JD-Core Version:    0.7.0.1
 */