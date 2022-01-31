package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import com.tencent.token.af;
import java.util.ArrayList;

public class JLFinditemsChooseZone
  extends BaseActivity
{
  public ahs adapter;
  private int flag = 0;
  private ListView listView;
  private Handler mHandler = new nj(this);
  private af mTokenCore = af.a();
  private int roleID;
  private String roleName;
  private int serverID;
  private String serverName;
  private int serverPosition;
  private int zoneID;
  private String zoneName;
  private int zonePosition;
  
  private void setAdapter(int paramInt)
  {
    if (this.listView != null)
    {
      if (this.adapter == null)
      {
        this.adapter = new ahs(this, this.flag, paramInt);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new ni(this));
      }
    }
    else {
      return;
    }
    this.adapter.a(this.flag, paramInt);
    this.adapter.notifyDataSetChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903117);
    this.listView = ((ListView)findViewById(2131296740));
    setAdapter(0);
    this.mTokenCore.f(this.mHandler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.adapter != null) && (this.adapter.a != null)) {
      this.adapter.a.clear();
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if (this.mBackArrow != null)
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new nk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.JLFinditemsChooseZone
 * JD-Core Version:    0.7.0.1
 */