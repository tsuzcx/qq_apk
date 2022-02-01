package com.tencent.qqmail.calendar.provider;

class CalendarProviderConversionManager$2
  implements Runnable
{
  CalendarProviderConversionManager$2(CalendarProviderConversionManager paramCalendarProviderConversionManager, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (CalendarProviderConversionManager.access$200(this.this$0))
    {
      if (this.val$toDisplay)
      {
        CalendarProviderConversionManager.access$100(this.this$0);
        return;
      }
      CalendarProviderConversionManager.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.CalendarProviderConversionManager.2
 * JD-Core Version:    0.7.0.1
 */