package com.tencent.token.ui;

import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;

class jn
  implements Runnable
{
  jn(jl paramjl, DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult) {}
  
  public void run()
  {
    QQUser localQQUser = new QQUser();
    localQQUser.mRealUin = FindPasswdActivity.access$100(this.b.a);
    localQQUser.mIsZzb = true;
    abi.a().a(localQQUser);
    abi.a().a(this.b.a, this.a, FindPasswdActivity.access$200(this.b.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jn
 * JD-Core Version:    0.7.0.1
 */