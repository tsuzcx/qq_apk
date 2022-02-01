package dov.com.tencent.biz.qqstory.takevideo;

import aaza;
import aaza.c;
import android.app.Activity;
import ayiq;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(ayiq paramayiq, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    ayiq.a(this.this$0, null);
    this.this$0.bqC = 0;
    ayiq.a(this.this$0, this.this$0.a.getDoubleExtra("extra_bless_latitude", 0.0D));
    ayiq.b(this.this$0, this.this$0.a.getDoubleExtra("extra_bless_longitude", 0.0D));
    boolean bool;
    if ((this.b instanceof EditRecordVideoSource))
    {
      ayiq.a(this.this$0);
      bool = false;
    }
    for (;;)
    {
      aaza localaaza = new aaza(this.val$context, this.a.fakeVid, bool, ayiq.a(this.this$0), true);
      localaaza.b(ayiq.a(this.this$0));
      localaaza.execute(new Void[0]);
      return;
      if ((this.b instanceof EditTakeVideoSource))
      {
        int i = ayiq.a(this.this$0, this.a);
        if (i != 0) {
          ayiq.a(this.this$0).onError(i);
        }
        bool = true;
      }
      else
      {
        ayiq.a(this.this$0).onError(-13);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */