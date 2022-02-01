package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QMLockTipsView
  extends RelativeLayout
{
  private Context context;
  private View convertView;
  private TextView tipsView;
  
  public QMLockTipsView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.convertView = LayoutInflater.from(paramContext).inflate(2131559494, this, false);
    this.tipsView = ((TextView)this.convertView.findViewById(2131370873));
    addView(this.convertView);
  }
  
  public void hide()
  {
    setVisibility(8);
    if (this.convertView != null) {
      this.convertView.setVisibility(8);
    }
  }
  
  public void setTips(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      if (paramInt == 1) {
        str = this.context.getString(2131690603);
      }
    }
    for (;;)
    {
      this.tipsView.setText(str);
      return;
      str = String.format(this.context.getResources().getString(2131690606), new Object[] { Integer.valueOf(paramInt) });
      continue;
      str = String.format(this.context.getResources().getString(2131695608), new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public void setTips(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.tipsView.setText(paramString);
  }
  
  public void show()
  {
    setVisibility(0);
    if (this.convertView != null) {
      this.convertView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMLockTipsView
 * JD-Core Version:    0.7.0.1
 */