package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.core.bean.JLRoleInfo;
import com.tencent.token.global.e;
import java.util.ArrayList;

final class nj
  extends bo
{
  nj(JLFinditemsChooseZone paramJLFinditemsChooseZone)
  {
    super(paramJLFinditemsChooseZone);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.arg1 != 0);
      this.a.adapter.a = ((ArrayList)paramMessage.obj);
      this.a.adapter.notifyDataSetChanged();
      return;
    } while (paramMessage.arg1 != 0);
    this.a.adapter.b = ((ArrayList)paramMessage.obj);
    if ((this.a.adapter.b == null) || ((this.a.adapter.b != null) && (this.a.adapter.b.size() == 0)))
    {
      this.a.showUserDialog(this.a.getResources().getString(2131362286));
      return;
    }
    if (this.a.adapter.b.size() == 1)
    {
      paramMessage = new Intent();
      JLFinditemsChooseZone.access$1002(this.a, ((JLRoleInfo)this.a.adapter.b.get(0)).id);
      JLFinditemsChooseZone.access$1102(this.a, ((JLRoleInfo)this.a.adapter.b.get(0)).name);
      e.a("get role id=" + JLFinditemsChooseZone.access$1000(this.a) + " name =" + JLFinditemsChooseZone.access$1100(this.a));
      paramMessage.putExtra("roleID", JLFinditemsChooseZone.access$1000(this.a));
      paramMessage.putExtra("roleName", JLFinditemsChooseZone.access$1100(this.a));
      paramMessage.putExtra("zoneID", JLFinditemsChooseZone.access$200(this.a));
      paramMessage.putExtra("zoneName", JLFinditemsChooseZone.access$100(this.a));
      paramMessage.putExtra("serverID", JLFinditemsChooseZone.access$500(this.a));
      paramMessage.putExtra("serverName", JLFinditemsChooseZone.access$600(this.a));
      this.a.setResult(1, paramMessage);
      this.a.finish();
      return;
    }
    this.a.setTitle(2131362267);
    JLFinditemsChooseZone.access$002(this.a, 2);
    JLFinditemsChooseZone.access$400(this.a, JLFinditemsChooseZone.access$900(this.a));
    this.a.adapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nj
 * JD-Core Version:    0.7.0.1
 */