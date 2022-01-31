package com.tencent.token.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import java.util.Date;

final class ne
  implements View.OnClickListener
{
  ne(JLFindItems paramJLFindItems) {}
  
  public final void onClick(View paramView)
  {
    if (JLFindItems.access$200(this.a).isChecked())
    {
      if (JLFindItems.access$300(this.a).getText().length() < JLFindItems.access$400(this.a)) {
        this.a.showUserDialog(this.a.getResources().getString(2131362274));
      }
      do
      {
        return;
        if (this.a.getStealTime.before(this.a.lastLoginTime))
        {
          this.a.showUserDialog(this.a.getResources().getString(2131362287));
          return;
        }
        af.a().a(0L, JLFindItems.access$500(this.a), JLFindItems.access$600(this.a), JLFindItems.access$700(this.a), JLFindItems.access$800(this.a), JLFindItems.access$900(this.a), this.a.lastLoginTime.getTime(), this.a.getStealTime.getTime(), JLFindItems.access$1000(this.a));
      } while (ax.a().e() == null);
      JLFindItems.access$1200(this.a, ax.a().e().mUin, JLFindItems.access$500(this.a), JLFindItems.access$700(this.a), JLFindItems.access$800(this.a), JLFindItems.access$600(this.a), JLFindItems.access$1100(this.a), JLFindItems.access$900(this.a));
      return;
    }
    this.a.showUserDialog(this.a.getResources().getString(2131362285));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ne
 * JD-Core Version:    0.7.0.1
 */