package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.utilities.sharedpreference.SPManager.OnChangedListener;

class MLogConfiguration$1
  implements SPManager.OnChangedListener
{
  MLogConfiguration$1(MLogConfiguration paramMLogConfiguration) {}
  
  public void onChanged(String paramString)
  {
    int i = MLogConfiguration.access$000();
    if (MLogConfiguration.access$100(this.this$0) != i)
    {
      MLogConfiguration.access$102(this.this$0, i);
      MLogConfiguration.access$200(this.this$0);
    }
    boolean bool = MLogConfiguration.access$300(true);
    if (MLogConfiguration.access$400(this.this$0) != bool)
    {
      MLogConfiguration.access$402(this.this$0, bool);
      MLogConfiguration.access$500(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.MLogConfiguration.1
 * JD-Core Version:    0.7.0.1
 */