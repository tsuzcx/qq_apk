package wf7;

import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.a;

class fp$e
  implements a
{
  private fp$e(fp paramfp) {}
  
  public void a(CurrentSessionItem paramCurrentSessionItem)
  {
    switch (paramCurrentSessionItem.eW)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 1: 
      fp.a(this.ra, paramCurrentSessionItem);
      return;
    case 0: 
      fp.b(this.ra, paramCurrentSessionItem);
      return;
    }
    fp.a(this.ra, -9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fp.e
 * JD-Core Version:    0.7.0.1
 */