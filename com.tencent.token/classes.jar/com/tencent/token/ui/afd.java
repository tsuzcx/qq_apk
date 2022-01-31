package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.global.RqdApplication;

class afd
  implements View.OnClickListener
{
  afd(VerifySuccActivity paramVerifySuccActivity) {}
  
  public void onClick(View paramView)
  {
    if (DeterminVerifyFactorsResult.s_SourceId == 2)
    {
      DeterminVerifyFactorsResult.s_SourceId = 0;
      paramView = new Intent(this.a, FreezeStatusActivity.class);
      paramView.addFlags(67108864);
      this.a.startActivity(paramView);
      this.a.finish();
      return;
    }
    paramView = new Intent(this.a, IndexActivity.class);
    paramView.addFlags(67108864);
    if (VerifySuccActivity.access$000(this.a) == 1)
    {
      paramView.putExtra("index_from", 25);
      RqdApplication.i();
      paramView.putExtra("snap", true);
    }
    for (;;)
    {
      Activity localActivity = abi.a().b();
      if ((localActivity != null) && ((localActivity instanceof UtilsActivity))) {
        paramView.putExtra("index_from", 32);
      }
      paramView.putExtra("ish5zzb", VerifySuccActivity.access$100(this.a));
      this.a.startActivity(paramView);
      this.a.finish();
      return;
      paramView.putExtra("index_from", 16);
      paramView.putExtra("snap", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afd
 * JD-Core Version:    0.7.0.1
 */