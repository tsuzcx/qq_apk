package com.tencent.token.ui;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.ba;
import com.tencent.token.core.bean.g;
import com.tencent.token.ui.base.SwitchButton;

final class la
  implements CompoundButton.OnCheckedChangeListener
{
  la(kx paramkx) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (lb)((SwitchButton)paramCompoundButton).getTag();
    if (paramCompoundButton == null) {}
    View localView;
    do
    {
      return;
      localObject = paramCompoundButton.f;
      localView = paramCompoundButton.a;
    } while ((localObject == null) || (localView == null) || (!ba.a().o()) || (paramBoolean != ((g)localObject).c) || (((g)localObject).e));
    ((g)localObject).e = true;
    this.a.a(paramCompoundButton, false);
    Object localObject = this.a;
    UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
    AccountPageActivity.mNeedRefreshEval = true;
    new ky((kx)localObject, paramCompoundButton).a(new g[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.la
 * JD-Core Version:    0.7.0.1
 */