package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;

class abj
  implements Runnable
{
  abj(abi paramabi, Activity paramActivity, Class paramClass, QQUser paramQQUser, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, DeterminVerifyFactorsResult.VerifyTypeItem paramVerifyTypeItem, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a, this.b);
    localIntent.putExtra("intent.qquser", this.c);
    localIntent.putExtra("intent.determin_factors_result", this.d);
    localIntent.putExtra("intent.determin_verify_type", this.e);
    localIntent.putExtra("intent.determin_verify_factor_id", this.f);
    localIntent.putExtra("intent.determin_first_verify_factor", this.g);
    boolean bool = false;
    if ((this.a instanceof NetActiveVryOtherListActivity)) {
      bool = true;
    }
    localIntent.putExtra("intent.determin_from_list", bool);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abj
 * JD-Core Version:    0.7.0.1
 */