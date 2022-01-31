package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.JLAppealInfo;
import com.tencent.token.global.e;
import org.json.JSONArray;
import org.json.JSONException;

public class JLAppealListDetailActivity
  extends BaseActivity
{
  JLAppealInfo appealInfo;
  
  private View createTableCol1(String paramString1, String paramString2)
  {
    View localView = getLayoutInflater().inflate(2130903112, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131296726);
    TextView localTextView2 = (TextView)localView.findViewById(2131296727);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    return localView;
  }
  
  private void insertTableRows(LinearLayout paramLinearLayout)
  {
    for (;;)
    {
      int i;
      String str;
      int j;
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.appealInfo.table);
        i = 0;
        if (i < localJSONArray1.length())
        {
          JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
          localObject = "";
          str = "";
          j = 0;
          if (j >= localJSONArray2.length()) {
            break label132;
          }
          if (j == 0)
          {
            localObject = localJSONArray2.getString(j);
            e.b("temp1 = " + (String)localObject);
          }
          else
          {
            str = localJSONArray2.getString(j);
            e.b("temp2 = " + str);
          }
        }
      }
      catch (JSONException paramLinearLayout)
      {
        paramLinearLayout.printStackTrace();
      }
      return;
      label132:
      paramLinearLayout.addView(createTableCol1((String)localObject, str));
      Object localObject = new ImageView(this);
      ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
      ((ImageView)localObject).setBackgroundResource(2130837708);
      paramLinearLayout.addView((View)localObject);
      i += 1;
      continue;
      j += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903115);
    paramBundle = (TextView)findViewById(2131296736);
    this.appealInfo = ((JLAppealInfo)getIntent().getSerializableExtra("content"));
    paramBundle.setText(this.appealInfo.desc);
    insertTableRows((LinearLayout)findViewById(2131296737));
    ((Button)findViewById(2131296738)).setOnClickListener(new na(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.JLAppealListDetailActivity
 * JD-Core Version:    0.7.0.1
 */