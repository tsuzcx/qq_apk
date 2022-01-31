package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.token.core.bean.JLProtectionInfo;
import com.tencent.token.core.bean.JLProtectionInfo.ActivityItem;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.ArrayList;

final class nr
  implements AdapterView.OnItemClickListener
{
  nr(JianLingActivity paramJianLingActivity) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    e.c("jl activity: " + paramAdapterView + ", " + paramView + ", " + paramInt + ", " + paramLong);
    if ((this.a.mInfo != null) && (this.a.mInfo.activityItem != null) && (paramInt < this.a.mInfo.activityItem.size()))
    {
      paramAdapterView = (JLProtectionInfo.ActivityItem)this.a.mInfo.activityItem.get(paramInt);
      s.a(this.a, paramAdapterView.jumpURL, this.a.getResources().getString(2131362456));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nr
 * JD-Core Version:    0.7.0.1
 */