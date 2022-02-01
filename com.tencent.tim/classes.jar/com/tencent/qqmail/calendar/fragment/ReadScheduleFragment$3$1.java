package com.tencent.qqmail.calendar.fragment;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class ReadScheduleFragment$3$1
  implements Runnable
{
  ReadScheduleFragment$3$1(ReadScheduleFragment.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.val$json == null)
    {
      SharedPreferenceUtil.setNormalCreditCardBill(this.this$1.val$localKey);
      ReadScheduleFragment.access$700(this.this$1.this$0, false);
      return;
    }
    SharedPreferenceUtil.setCreditCardBillDetail(this.this$1.val$localKey, this.val$json.toString());
    ReadScheduleFragment.access$802(this.this$1.this$0, CreditCardBill.parse(this.val$json));
    Log.i("ReadScheduleFragment", "creditCardBill " + ReadScheduleFragment.access$800(this.this$1.this$0) + " thread " + Thread.currentThread());
    if (ReadScheduleFragment.access$800(this.this$1.this$0) == null)
    {
      ReadScheduleFragment.access$700(this.this$1.this$0, false);
      return;
    }
    ReadScheduleFragment.access$700(this.this$1.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.3.1
 * JD-Core Version:    0.7.0.1
 */