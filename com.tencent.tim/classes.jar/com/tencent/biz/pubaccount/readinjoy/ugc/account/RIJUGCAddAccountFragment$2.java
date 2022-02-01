package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import com.tencent.qphone.base.util.QLog;
import kbp;
import kxm;
import kxm.b;
import org.json.JSONException;

final class RIJUGCAddAccountFragment$2
  implements Runnable
{
  public void run()
  {
    try
    {
      kbp.a(null, "CliOper", "", "", "0X800AF12", "0X800AF12", 0, 0, "", "", "", kxm.a().a("uin", kxm.getAccount()).build(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(RIJUGCAddAccountFragment.access$100(), 1, "[deliverTipsExposureReport] error, e = " + localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */