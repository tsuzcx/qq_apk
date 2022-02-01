package com.tencent.mobileqq.emosm.web;

import acff;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MessengerService$IncomingHandler$11
  implements Runnable
{
  MessengerService$IncomingHandler$11(MessengerService.a parama, QQAppInterface paramQQAppInterface, ArrayList paramArrayList, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    acff localacff = (acff)this.val$qqApp.getManager(51);
    if (localacff != null)
    {
      Iterator localIterator = this.eg.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Friends localFriends = localacff.e(str);
        if (localFriends != null)
        {
          if (!TextUtils.isEmpty(localFriends.remark)) {
            localHashMap.put(str, localFriends.remark);
          } else if (!TextUtils.isEmpty(localFriends.name)) {
            localHashMap.put(str, localFriends.name);
          } else {
            localHashMap.put(str, "");
          }
        }
        else {
          localHashMap.put(str, "");
        }
      }
    }
    localBundle.putSerializable("friendsMap", localHashMap);
    this.val$reqbundle.putBundle("response", localBundle);
    this.val$service.cp(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */