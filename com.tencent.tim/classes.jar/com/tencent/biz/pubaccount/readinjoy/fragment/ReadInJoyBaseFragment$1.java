package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import kbp;
import org.json.JSONObject;

class ReadInJoyBaseFragment$1
  implements Runnable
{
  ReadInJoyBaseFragment$1(ReadInJoyBaseFragment paramReadInJoyBaseFragment, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    for (;;)
    {
      long l2;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        long l3 = -1L;
        Object localObject = ((MessageForStructing)this.a).structingMsg;
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mArticleIds))
          {
            String[] arrayOfString = ((MessageForStructing)this.a).structingMsg.mArticleIds.split("\\|");
            l1 = l3;
            if (arrayOfString.length > 0) {
              l1 = Long.parseLong(arrayOfString[0]);
            }
          }
          l2 = l1;
          if (!TextUtils.isEmpty(((AbsStructMsg)localObject).reportEventFolderStatusValue))
          {
            localObject = ((MessageForStructing)this.a).structingMsg.reportEventFolderStatusValue;
            localJSONObject.put("inside_kd_tab_red_pnt_push_articleId", l1);
            localJSONObject.put("folder_status", localObject);
            kbp.a(null, "", "0X800952D", "0X800952D", 0, 0, localJSONObject.toString(), "", "", "", false);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str = "";
      long l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */