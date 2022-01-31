package com.tencent.token.ui;

import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;

class kg
  implements Runnable
{
  kg(GeneralVerifyMobileUpActivity paramGeneralVerifyMobileUpActivity) {}
  
  public void run()
  {
    int i = 0;
    if (GeneralVerifyMobileUpActivity.access$000(this.a) != null) {
      i = GeneralVerifyMobileUpActivity.access$000(this.a).a();
    }
    cw.a().a(0L, GeneralVerifyMobileUpActivity.access$100(this.a).mRealUin, 1007, i, GeneralVerifyMobileUpActivity.access$200(this.a));
    GeneralVerifyMobileUpActivity.access$308(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kg
 * JD-Core Version:    0.7.0.1
 */