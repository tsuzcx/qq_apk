package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONArray;
import org.json.JSONObject;

public class QPayReminderActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private TextView EH;
  private int bJj;
  private Button jdField_do;
  private ImageView qI;
  
  private boolean vz()
  {
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        Object localObject1 = getIntent();
        if (((Intent)localObject1).getIntExtra("URGENCY", 1) == 1)
        {
          this.qI.setImageResource(2130848123);
          this.bJj = ((Intent)localObject1).getIntExtra("TEMPLATE", 1);
          localObject1 = new JSONObject(((Intent)localObject1).getStringExtra("CONTENT"));
          setTitle(((JSONObject)localObject1).getJSONObject("title").getString("text"));
          localObject2 = ((JSONObject)localObject1).getJSONObject("footnote").getString("text");
          this.jdField_do.setText((CharSequence)localObject2);
          this.jdField_do.setContentDescription((CharSequence)localObject2);
          localObject1 = ((JSONObject)localObject1).getJSONArray("para");
          localObject2 = new SpannableStringBuilder();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            if (!(((JSONArray)localObject1).get(i) instanceof JSONObject)) {
              break label279;
            }
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i).getJSONObject("span");
            int j = ((SpannableStringBuilder)localObject2).length();
            ((SpannableStringBuilder)localObject2).append(localJSONObject.getString("text"));
            int k = ((SpannableStringBuilder)localObject2).length();
            ((SpannableStringBuilder)localObject2).setSpan(new AbsoluteSizeSpan(localJSONObject.getInt("fontsize"), true), j, k, 33);
            ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor(localJSONObject.getString("color"))), j, k, 33);
            break label279;
          }
        }
        else
        {
          this.qI.setImageResource(2130848122);
          continue;
        }
        this.EH.setText((CharSequence)localObject2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      this.EH.setContentDescription(((SpannableStringBuilder)localObject2).toString());
      return true;
      label279:
      i += 1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131562164);
    setLeftButton(2131721059, this);
    this.jdField_do = ((Button)findViewById(2131372929));
    this.jdField_do.setOnClickListener(this);
    this.EH = ((TextView)findViewById(2131372921));
    this.qI = ((ImageView)findViewById(2131372920));
    if (!vz()) {
      finish();
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 2130772369);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.jdField_do)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://imgcache.qq.com/club/mqq/wallet/webank/qf/index.html?_wv=1027&pvsrc=1");
      startActivity((Intent)localObject);
      localObject = this.app;
      if (paramView != this.jdField_do) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8004B3F", "0X8004B3F", 0, i, String.valueOf(this.bJj), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QPayReminderActivity
 * JD-Core Version:    0.7.0.1
 */