package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.w;

class la
  implements View.OnClickListener
{
  la(GetOtherBarcodeActivity paramGetOtherBarcodeActivity) {}
  
  public void onClick(View paramView)
  {
    if (GetOtherBarcodeActivity.access$000(this.a) != null) {
      GetOtherBarcodeActivity.access$000(this.a).clearFocus();
    }
    paramView = GetOtherBarcodeActivity.access$000(this.a).getText().toString();
    QQUser localQQUser = do.a().e();
    if ((localQQUser != null) && (paramView.contains("qq.com")))
    {
      cp.a(RqdApplication.l()).a("" + localQQUser.mRealUin, GetOtherBarcodeActivity.access$100(this.a), 523005419L, 32);
      return;
    }
    w.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.la
 * JD-Core Version:    0.7.0.1
 */