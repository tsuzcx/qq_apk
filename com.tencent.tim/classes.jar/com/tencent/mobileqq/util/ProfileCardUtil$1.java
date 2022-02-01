package com.tencent.mobileqq.util;

import aqhq;
import aqhu;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.qphone.base.util.BaseApplication;

public final class ProfileCardUtil$1
  implements Runnable
{
  public ProfileCardUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = CardHandler.ac(this.csv, CardHandler.ap(BaseApplication.getContext()));
    int i = CardHandler.aq(BaseApplication.getContext());
    String str2 = CardHandler.ac(this.csv, i);
    aqhu.in(this.val$path, str1);
    aqhu.n(this.val$path, str2, i, i);
    aqhq.delete(this.val$path, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1
 * JD-Core Version:    0.7.0.1
 */