package com.tencent.qqmail.account;

import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

final class MailServiceManager$2
  implements Runnable
{
  public void run()
  {
    if (!SharedPreferenceUtil.hasInitLocalDomainConfig())
    {
      MailServiceManager.getInstance().prepareLocalDomainConfig();
      SharedPreferenceUtil.setInitLocalDomainConfig();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.MailServiceManager.2
 * JD-Core Version:    0.7.0.1
 */