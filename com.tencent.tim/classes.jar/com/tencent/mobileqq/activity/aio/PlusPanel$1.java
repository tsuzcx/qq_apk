package com.tencent.mobileqq.activity.aio;

class PlusPanel$1
  implements Runnable
{
  PlusPanel$1(PlusPanel paramPlusPanel) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.b.getCount())
    {
      this.this$0.b.update(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel.1
 * JD-Core Version:    0.7.0.1
 */