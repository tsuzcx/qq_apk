package dov.com.tencent.biz.qqstory.takevideo;

import ayde;
import aygz;
import ayhm;
import ayih;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class EditVideoTransfer$1
  implements Runnable
{
  public void run()
  {
    if (ayih.a(this.this$0))
    {
      localObject = (ayhm)this.this$0.a(ayhm.class);
      if (localObject != null) {
        ((ayhm)localObject).setTransferData(ayih.a(this.this$0));
      }
    }
    ayih.a(this.this$0, ((EditTakeVideoSource)this.this$0.b.a.a).d.mDuration);
    Object localObject = (ayde)this.this$0.a(ayde.class);
    if (this.this$0.RQ() != 0) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoTransfer.1
 * JD-Core Version:    0.7.0.1
 */