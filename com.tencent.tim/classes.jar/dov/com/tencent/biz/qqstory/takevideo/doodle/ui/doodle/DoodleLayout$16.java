package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import ayjn.b;
import ayjv;
import ayjw.c;
import ayoo.a;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    ayoo.a locala;
    if ((this.this$0.a.a.c != null) && (this.qV != null))
    {
      locala = this.this$0.a.a.c;
      if (!(locala instanceof ayjn.b)) {
        break label97;
      }
      ((ayjn.b)locala).qU = this.qV;
    }
    for (;;)
    {
      locala.eKr = 3;
      this.this$0.a.a.c = null;
      if (this.this$0.b != null) {
        this.this$0.b.eNw();
      }
      return;
      label97:
      if ((locala instanceof ayjw.c)) {
        ((ayjw.c)locala).qU = this.qV;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */