package com.tencent.token.ui;

import android.content.Intent;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.ui.base.da;
import com.tencent.token.utils.w;
import com.tmsdk.TMSDKContext;

class abs
  implements da
{
  abs(abr paramabr) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      TMSDKContext.saveActionData(1150076);
    }
    if (do.a().e() == null)
    {
      if (paramInt == 0)
      {
        Intent localIntent = new Intent(this.a.a, WtLoginAccountInput.class);
        localIntent.putExtra("page_id", 4);
        this.a.a.startActivity(localIntent);
        return;
      }
      w.b(this.a.a, this.a.a.getString(2131231287));
      return;
    }
    if (!do.a().e().mIsBinded)
    {
      if (paramInt == 0)
      {
        this.a.a.showNoAccountTipDialog(this.a.a, 13, 1);
        return;
      }
      w.b(this.a.a, this.a.a.getString(2131231287));
      return;
    }
    UtilsActivity.access$400(this.a.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abs
 * JD-Core Version:    0.7.0.1
 */