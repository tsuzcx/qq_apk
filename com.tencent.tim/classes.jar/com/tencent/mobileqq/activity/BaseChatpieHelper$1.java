package com.tencent.mobileqq.activity;

import acff;
import anpb;
import aqgv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

class BaseChatpieHelper$1
  implements Runnable
{
  BaseChatpieHelper$1(BaseChatpieHelper paramBaseChatpieHelper, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    String str2;
    String str3;
    String str1;
    Object localObject;
    if (this.bEM == -1) {
      if (BaseChatpieHelper.a(this.this$0).cZ == 0)
      {
        str2 = "";
        str3 = "";
        str1 = str2;
        localObject = str3;
        if (this.bEN != 2) {
          break label155;
        }
        localObject = (acff)BaseChatpieHelper.a(this.this$0).getManager(51);
        if (BaseChatpieHelper.a(this.this$0).cZ != 1008) {
          break label74;
        }
      }
    }
    for (;;)
    {
      return;
      label74:
      Friends localFriends = ((acff)localObject).e(BaseChatpieHelper.a(this.this$0).aTl);
      str1 = str2;
      localObject = str3;
      if (localFriends != null)
      {
        str1 = "" + aqgv.c(localFriends);
        localObject = "" + aqgv.a(localFriends, BaseChatpieHelper.a(this.this$0));
      }
      label155:
      anpb.a(BaseChatpieHelper.a(this.this$0), "clt", BaseChatpieHelper.a(this.this$0).getAccount(), BaseChatpieHelper.a(this.this$0).aTl, "msg", this.bEN + "", "", "", str1, (String)localObject, BaseChatpieHelper.a(this.this$0) + "");
      BaseChatpieHelper.a(this.this$0, 0);
      return;
      localObject = null;
      switch (BaseChatpieHelper.a(this.this$0).cZ)
      {
      }
      while (localObject != null)
      {
        anpb.a(BaseChatpieHelper.a(this.this$0), (String)localObject, BaseChatpieHelper.a(this.this$0).getAccount(), BaseChatpieHelper.a(this.this$0).aTl, "pic", "", this.bEM + "", this.aLJ, "", "", "");
        return;
        localObject = "clt";
        continue;
        localObject = "grp";
        continue;
        localObject = "discuss";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper.1
 * JD-Core Version:    0.7.0.1
 */