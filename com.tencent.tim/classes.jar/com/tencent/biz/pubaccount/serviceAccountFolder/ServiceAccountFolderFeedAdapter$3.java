package com.tencent.biz.pubaccount.serviceAccountFolder;

import anot;
import com.tencent.qphone.base.util.QLog;
import nyi;
import nyj;

public class ServiceAccountFolderFeedAdapter$3
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$3(nyj paramnyj, nyi paramnyi) {}
  
  public void run()
  {
    try
    {
      if (nyj.a(this.this$0, this.a.mUin))
      {
        String str2 = this.a.mUin;
        String str3 = this.a.mTitleName;
        if (this.a.v == null) {}
        for (String str1 = "";; str1 = this.a.v.toString())
        {
          anot.a(null, "dc00898", "", str2, "auth_page", "left_delete", 0, 0, "", "", str3, str1);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ServiceAccountFolderFeedAdapter", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.3
 * JD-Core Version:    0.7.0.1
 */