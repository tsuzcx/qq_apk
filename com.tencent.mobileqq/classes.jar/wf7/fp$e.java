package wf7;

import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.a;

class fp$e
  implements a
{
  private fp$e(fp paramfp) {}
  
  public void a(CurrentSessionItem paramCurrentSessionItem)
  {
    int i = paramCurrentSessionItem.eW;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 4) {
          return;
        }
        fp.a(this.ra, -9);
        return;
      }
      fp.a(this.ra, paramCurrentSessionItem);
      return;
    }
    fp.b(this.ra, paramCurrentSessionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fp.e
 * JD-Core Version:    0.7.0.1
 */