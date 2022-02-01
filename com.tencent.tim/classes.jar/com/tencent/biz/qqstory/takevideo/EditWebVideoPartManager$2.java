package com.tencent.biz.qqstory.takevideo;

import aaza;
import aaza.c;
import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import ren;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(ren paramren, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    ren.a(this.this$0, null);
    this.this$0.bqC = 0;
    ren.a(this.this$0, this.this$0.a.getDoubleExtra("extra_bless_latitude", 0.0D));
    ren.b(this.this$0, this.this$0.a.getDoubleExtra("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.b instanceof EditRecordVideoSource))
    {
      ren.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      aaza localaaza = new aaza(this.val$context, this.a.fakeVid, bool1, ren.a(this.this$0));
      localaaza.b(ren.a(this.this$0));
      localaaza.execute(new Void[0]);
      return;
      if ((this.b instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = ren.a(this.this$0, this.a);
        bool1 = bool2;
        if (i != 0)
        {
          ren.a(this.this$0).onError(i);
          bool1 = bool2;
        }
      }
      else
      {
        ren.a(this.this$0).onError(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */