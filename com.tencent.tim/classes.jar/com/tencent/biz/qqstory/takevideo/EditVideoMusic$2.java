package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import rdc;
import rek;
import rmw;
import rmw.a;

class EditVideoMusic$2
  implements Runnable
{
  EditVideoMusic$2(EditVideoMusic paramEditVideoMusic) {}
  
  public void run()
  {
    if ((!this.this$0.aGZ) && (this.this$0.aHa))
    {
      this.this$0.aGZ = true;
      localObject = this.this$0.a(rek.class);
      if (localObject == null) {
        break label145;
      }
    }
    label145:
    for (Object localObject = ((rek)localObject).a(this.this$0.b.tj());; localObject = null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((rmw)localObject).a.type == 1) {
          bool1 = true;
        }
      }
      new EditVideoMusicDialog(this.this$0.getContext(), this.this$0, this.this$0.mIsTakePhoto, (int)this.this$0.b.x(this.this$0.b.tj()), this.this$0.b.a, true, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic.2
 * JD-Core Version:    0.7.0.1
 */