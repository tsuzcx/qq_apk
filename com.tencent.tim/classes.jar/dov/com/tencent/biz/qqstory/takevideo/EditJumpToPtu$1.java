package dov.com.tencent.biz.qqstory.takevideo;

import aydm;
import aydm.a;
import aydw;
import ram;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(aydm paramaydm) {}
  
  public void run()
  {
    aydm.a(this.this$0, aydw.azs + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.um(aydm.a(this.this$0)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    aydm.a(this.this$0, null);
    ram.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */