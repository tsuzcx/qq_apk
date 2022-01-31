package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.io.Serializable;
import java.util.ArrayList;

final class mv
  implements AdapterView.OnItemClickListener
{
  mv(JLAppealListActivity paramJLAppealListActivity) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new Intent(this.a, JLAppealListDetailActivity.class);
    paramAdapterView.putExtra("content", (Serializable)JLAppealListActivity.access$000(this.a).get(paramInt));
    this.a.startActivity(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mv
 * JD-Core Version:    0.7.0.1
 */