package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JLFinditemsResult
  extends BaseActivity
{
  private Button btn;
  private long getStealTime;
  private ImageView iv_icon;
  private long lastLoginTime;
  private Handler mHandler = new nm(this);
  private int result = -999;
  private int roleID;
  private String roleName;
  private int serverID;
  private String serverName;
  private TextView tv_content;
  private TextView tv_title;
  private int zoneID;
  private String zoneName;
  
  private void initUI(Intent paramIntent)
  {
    this.result = paramIntent.getIntExtra("result", -1);
    if (this.result == 0)
    {
      this.iv_icon.setImageResource(2130837574);
      this.tv_title.setText(paramIntent.getStringExtra("title"));
      this.tv_content.setText(paramIntent.getStringExtra("desc"));
      this.btn.setText(2131362282);
      return;
    }
    if (this.result == -1)
    {
      this.iv_icon.setImageResource(2130837569);
      this.tv_title.setText(paramIntent.getStringExtra("title"));
      this.tv_content.setText(paramIntent.getStringExtra("desc"));
      this.btn.setText(2131362283);
      return;
    }
    this.iv_icon.setImageResource(2130837569);
    this.tv_title.setText(paramIntent.getStringExtra("title"));
    this.tv_content.setText(paramIntent.getStringExtra("desc"));
    this.btn.setText(2131362281);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903121);
    this.iv_icon = ((ImageView)findViewById(2131296766));
    this.tv_title = ((TextView)findViewById(2131296767));
    this.tv_content = ((TextView)findViewById(2131296768));
    this.btn = ((Button)findViewById(2131296769));
    this.roleID = getIntent().getIntExtra("roleID", -1);
    this.roleName = getIntent().getStringExtra("roleName");
    this.zoneID = getIntent().getIntExtra("zoneID", -1);
    this.zoneName = getIntent().getStringExtra("zoneName");
    this.serverID = getIntent().getIntExtra("serverID", -1);
    this.serverName = getIntent().getStringExtra("serverName");
    this.lastLoginTime = getIntent().getLongExtra("lastLoginTime", -1L);
    this.getStealTime = getIntent().getLongExtra("getStealTime", -1L);
    this.btn.setOnClickListener(new nl(this));
    initUI(getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.JLFinditemsResult
 * JD-Core Version:    0.7.0.1
 */