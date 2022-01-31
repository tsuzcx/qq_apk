package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.JLRoleInfo;
import com.tencent.token.core.bean.JLZone;
import com.tencent.token.core.bean.JLZone.JLZoneServer;
import com.tencent.token.global.e;
import java.util.ArrayList;

final class ni
  implements AdapterView.OnItemClickListener
{
  ni(JLFinditemsChooseZone paramJLFinditemsChooseZone) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (JLFinditemsChooseZone.access$000(this.a) == 0)
    {
      this.a.setTitle(2131362266);
      JLFinditemsChooseZone.access$102(this.a, ((JLZone)this.a.adapter.a.get(paramInt)).name);
      JLFinditemsChooseZone.access$202(this.a, ((JLZone)this.a.adapter.a.get(paramInt)).id);
      JLFinditemsChooseZone.access$002(this.a, 1);
      JLFinditemsChooseZone.access$302(this.a, paramInt);
      JLFinditemsChooseZone.access$400(this.a, JLFinditemsChooseZone.access$300(this.a));
      return;
    }
    if (JLFinditemsChooseZone.access$000(this.a) == 1)
    {
      JLFinditemsChooseZone.access$502(this.a, ((JLZone.JLZoneServer)((JLZone)this.a.adapter.a.get(this.a.adapter.c)).serverList.get(paramInt)).serverID);
      JLFinditemsChooseZone.access$602(this.a, ((JLZone.JLZoneServer)((JLZone)this.a.adapter.a.get(this.a.adapter.c)).serverList.get(paramInt)).serverName);
      JLFinditemsChooseZone.access$800(this.a).d(0L, JLFinditemsChooseZone.access$500(this.a), JLFinditemsChooseZone.access$700(this.a));
      JLFinditemsChooseZone.access$902(this.a, paramInt);
      return;
    }
    paramAdapterView = new Intent();
    JLFinditemsChooseZone.access$1002(this.a, ((JLRoleInfo)this.a.adapter.b.get(paramInt)).id);
    JLFinditemsChooseZone.access$1102(this.a, ((JLRoleInfo)this.a.adapter.b.get(paramInt)).name);
    e.a("get role id=" + JLFinditemsChooseZone.access$1000(this.a) + " name =" + JLFinditemsChooseZone.access$1100(this.a));
    paramAdapterView.putExtra("roleID", JLFinditemsChooseZone.access$1000(this.a));
    paramAdapterView.putExtra("roleName", JLFinditemsChooseZone.access$1100(this.a));
    paramAdapterView.putExtra("zoneID", JLFinditemsChooseZone.access$200(this.a));
    paramAdapterView.putExtra("zoneName", JLFinditemsChooseZone.access$100(this.a));
    paramAdapterView.putExtra("serverID", JLFinditemsChooseZone.access$500(this.a));
    paramAdapterView.putExtra("serverName", JLFinditemsChooseZone.access$600(this.a));
    this.a.setResult(1, paramAdapterView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ni
 * JD-Core Version:    0.7.0.1
 */