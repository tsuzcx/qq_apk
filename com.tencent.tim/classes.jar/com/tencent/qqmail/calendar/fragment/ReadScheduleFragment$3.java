package com.tencent.qqmail.calendar.fragment;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.thread.Threads;

class ReadScheduleFragment$3
  implements CalendarMainFragment.CreditCardDetailCallback
{
  ReadScheduleFragment$3(ReadScheduleFragment paramReadScheduleFragment, String paramString) {}
  
  public void callback(JSONObject paramJSONObject)
  {
    Threads.runOnMainThread(new ReadScheduleFragment.3.1(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.3
 * JD-Core Version:    0.7.0.1
 */