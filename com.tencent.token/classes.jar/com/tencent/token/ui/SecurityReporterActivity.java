package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.SecurityReporterResult;
import com.tencent.token.core.bean.SecurityReporterResult.ChartAreas;
import com.tencent.token.ui.base.bb;
import com.tencent.token.ui.base.ce;
import com.tencent.token.ui.base.ch;
import com.tencent.token.ui.base.ci;
import com.tencent.token.ui.base.cj;
import com.tencent.token.ui.base.ck;
import java.util.ArrayList;
import org.json.JSONArray;

public class SecurityReporterActivity
  extends BaseActivity
{
  private Button btn_return;
  private ImageView iv_loginCity;
  private ImageView iv_loginCount;
  private ImageView iv_loginMap;
  private ImageView iv_loginPlatform;
  private ImageView iv_loginTime;
  private ImageView iv_paymentRange;
  private LinearLayout ll_loginCity;
  private LinearLayout ll_loginCount;
  private LinearLayout ll_loginMap;
  private LinearLayout ll_loginPlatform;
  private LinearLayout ll_loginTime;
  private LinearLayout ll_paymentRange;
  private View noLoginMsgView;
  private SecurityReporterResult result;
  private TextView tv_loginCity_title;
  private TextView tv_loginCount_title;
  private TextView tv_loginMap_title;
  private TextView tv_loginPlatform_title;
  private TextView tv_loginTime_title;
  private TextView tv_noLoginTip;
  private TextView tv_paymentRange_title;
  
  private void getAndrSetAreaDrawable(SecurityReporterResult.ChartAreas paramChartAreas)
  {
    Object localObject1;
    int i;
    Object localObject2;
    int[] arrayOfInt;
    Object localObject3;
    int j;
    switch (paramChartAreas.type)
    {
    default: 
    case 3: 
    case 6: 
    case 5: 
      JSONArray localJSONArray;
      for (;;)
      {
        return;
        for (;;)
        {
          try
          {
            localObject1 = new JSONArray(paramChartAreas.table);
            i = ((JSONArray)localObject1).length();
            localObject2 = new String[i];
            arrayOfInt = new int[i];
            i = 0;
            if (i >= ((JSONArray)localObject1).length()) {
              break label158;
            }
            localObject3 = ((JSONArray)localObject1).getJSONArray(i);
            if (((JSONArray)localObject3).length() % 2 != 0) {
              break;
            }
            j = 0;
            if (j < ((JSONArray)localObject3).length()) {
              if (j == 0) {
                localObject2[i] = ((JSONArray)localObject3).getString(j);
              } else {
                arrayOfInt[i] = ((JSONArray)localObject3).getInt(j);
              }
            }
          }
          catch (Exception paramChartAreas)
          {
            paramChartAreas.printStackTrace();
            return;
          }
          i += 1;
        }
        localObject1 = new bb(this, (String[])localObject2, arrayOfInt);
        this.ll_loginCount.setVisibility(0);
        this.tv_loginCount_title.setText(paramChartAreas.title);
        this.iv_loginCount.setBackgroundDrawable((Drawable)localObject1);
        this.iv_loginCount.postDelayed(new zf(this, (bb)localObject1), 500L);
        return;
        for (;;)
        {
          try
          {
            localObject1 = new JSONArray(paramChartAreas.table);
            localObject2 = new String[((JSONArray)localObject1).length()];
            arrayOfInt = new int[((JSONArray)localObject1).length()];
            i = 0;
            if (i >= ((JSONArray)localObject1).length()) {
              break label332;
            }
            localObject3 = ((JSONArray)localObject1).getJSONArray(i);
            if (((JSONArray)localObject3).length() < 2) {
              break;
            }
            j = 0;
            if (j < 2) {
              if (j == 0) {
                localObject2[i] = ((JSONArray)localObject3).getString(j);
              } else {
                arrayOfInt[i] = ((JSONArray)localObject3).getInt(j);
              }
            }
          }
          catch (Exception paramChartAreas)
          {
            paramChartAreas.printStackTrace();
            return;
          }
          i += 1;
        }
        localObject1 = new cj(this, (String[])localObject2, arrayOfInt);
        this.ll_loginCity.setVisibility(0);
        this.tv_loginCity_title.setText(paramChartAreas.title);
        this.iv_loginCity.setBackgroundDrawable((Drawable)localObject1);
        this.iv_loginCity.postDelayed(new zg(this, (cj)localObject1), 500L);
        return;
        try
        {
          localObject1 = new JSONArray(paramChartAreas.table);
          i = ((JSONArray)localObject1).length();
          localObject2 = new String[i];
          arrayOfInt = new int[i];
          localObject3 = new int[i];
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label525;
          }
          localJSONArray = ((JSONArray)localObject1).getJSONArray(i);
          if (localJSONArray.length() % 3 == 0)
          {
            j = 0;
            if (j >= localJSONArray.length()) {
              break label1098;
            }
            if (j == 0) {
              localObject2[i] = localJSONArray.getString(j);
            } else if (j == 1) {
              arrayOfInt[i] = localJSONArray.getInt(j);
            }
          }
        }
        catch (Exception paramChartAreas)
        {
          paramChartAreas.printStackTrace();
          return;
        }
      }
      localObject3[i] = localJSONArray.getInt(j);
      break;
      localObject1 = new ch(this, (String[])localObject2, arrayOfInt, (int[])localObject3);
      this.ll_loginMap.setVisibility(0);
      this.tv_loginMap_title.setText(Html.fromHtml(paramChartAreas.title));
      this.iv_loginMap.setBackgroundDrawable((Drawable)localObject1);
      this.iv_loginMap.postDelayed(new zh(this, (ch)localObject1), 500L);
      return;
    case 4: 
      for (;;)
      {
        try
        {
          label106:
          localObject1 = new JSONArray(paramChartAreas.table);
          label158:
          label332:
          label462:
          localObject2 = new String[((JSONArray)localObject1).length()];
          label284:
          label433:
          arrayOfInt = new int[((JSONArray)localObject1).length()];
          label525:
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label704;
          }
          localObject3 = ((JSONArray)localObject1).getJSONArray(i);
          if (((JSONArray)localObject3).length() < 2) {
            break;
          }
          j = 0;
          label656:
          if (j < 2) {
            if (j == 0) {
              localObject2[i] = ((JSONArray)localObject3).getString(j);
            } else {
              arrayOfInt[i] = ((JSONArray)localObject3).getInt(j);
            }
          }
        }
        catch (Exception paramChartAreas)
        {
          paramChartAreas.printStackTrace();
          return;
        }
        i += 1;
      }
      label704:
      localObject1 = new ck(this, arrayOfInt, (String[])localObject2, Integer.parseInt(paramChartAreas.subTtitle));
      this.ll_paymentRange.setVisibility(0);
      this.tv_paymentRange_title.setText(paramChartAreas.title);
      this.iv_paymentRange.setBackgroundDrawable((Drawable)localObject1);
      this.iv_paymentRange.postDelayed(new zi(this, (ck)localObject1), 500L);
      return;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject1 = new JSONArray(paramChartAreas.table);
          i = ((JSONArray)localObject1).length();
          localObject2 = new int[i];
          arrayOfInt = new int[i];
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label887;
          }
          localObject3 = ((JSONArray)localObject1).getJSONArray(i);
          if (((JSONArray)localObject3).length() % 2 != 0) {
            break;
          }
          j = 0;
          if (j < ((JSONArray)localObject3).length()) {
            if (j == 0) {
              localObject2[i] = ((JSONArray)localObject3).getInt(j);
            } else {
              arrayOfInt[i] = ((JSONArray)localObject3).getInt(j);
            }
          }
        }
        catch (Exception paramChartAreas)
        {
          paramChartAreas.printStackTrace();
          return;
        }
        i += 1;
        continue;
        label887:
        localObject1 = new ce(this, (int[])localObject2, arrayOfInt);
        this.ll_loginPlatform.setVisibility(0);
        this.tv_loginPlatform_title.setText(paramChartAreas.title);
        this.iv_loginPlatform.setBackgroundDrawable((Drawable)localObject1);
        this.iv_loginPlatform.postDelayed(new zj(this, (ce)localObject1), 500L);
        return;
        try
        {
          localObject1 = new JSONArray(paramChartAreas.table);
          if (((JSONArray)localObject1).length() <= 0) {
            break;
          }
          localObject1 = ((JSONArray)localObject1).getJSONArray(0);
          if (((JSONArray)localObject1).length() < 3) {
            break;
          }
          localObject1 = new ci(this, ((JSONArray)localObject1).getInt(0), ((JSONArray)localObject1).getInt(1), ((JSONArray)localObject1).getInt(2), paramChartAreas.subTtitle);
          this.ll_loginTime.setVisibility(0);
          this.tv_loginTime_title.setText(paramChartAreas.title);
          this.iv_loginTime.setBackgroundDrawable((Drawable)localObject1);
          this.iv_loginTime.postDelayed(new zk(this, (ci)localObject1), 500L);
          return;
        }
        catch (Exception paramChartAreas)
        {
          paramChartAreas.printStackTrace();
          return;
        }
      }
      j += 1;
      break label106;
      j += 1;
      break label284;
      j += 1;
      break label462;
      label1098:
      i += 1;
      break label433;
      j += 1;
      break label656;
      j += 1;
    }
  }
  
  private void initUI()
  {
    int i = 0;
    if (this.result.chart.size() == 0)
    {
      this.noLoginMsgView = findViewById(2131296847);
      this.noLoginMsgView.setVisibility(0);
      this.tv_noLoginTip = ((TextView)findViewById(2131296735));
      if (!TextUtils.isEmpty(this.result.noDataTip))
      {
        this.tv_noLoginTip.setText(this.result.noDataTip);
        this.btn_return = ((Button)findViewById(2131296848));
        this.btn_return.setOnClickListener(new ze(this));
      }
    }
    for (;;)
    {
      return;
      this.tv_noLoginTip.setText(getResources().getString(2131362463));
      break;
      this.ll_loginMap = ((LinearLayout)findViewById(2131297044));
      this.ll_loginCount = ((LinearLayout)findViewById(2131297047));
      this.ll_loginCity = ((LinearLayout)findViewById(2131297050));
      this.ll_loginPlatform = ((LinearLayout)findViewById(2131297053));
      this.ll_loginTime = ((LinearLayout)findViewById(2131297056));
      this.ll_paymentRange = ((LinearLayout)findViewById(2131297059));
      this.tv_loginMap_title = ((TextView)findViewById(2131297045));
      this.tv_loginCount_title = ((TextView)findViewById(2131297048));
      this.tv_loginCity_title = ((TextView)findViewById(2131297051));
      this.tv_loginPlatform_title = ((TextView)findViewById(2131297054));
      this.tv_loginTime_title = ((TextView)findViewById(2131297057));
      this.tv_paymentRange_title = ((TextView)findViewById(2131297060));
      this.iv_loginMap = ((ImageView)findViewById(2131297046));
      this.iv_loginCount = ((ImageView)findViewById(2131297049));
      this.iv_loginCity = ((ImageView)findViewById(2131297052));
      this.iv_loginPlatform = ((ImageView)findViewById(2131297055));
      this.iv_loginTime = ((ImageView)findViewById(2131297058));
      this.iv_paymentRange = ((ImageView)findViewById(2131297061));
      while (i < this.result.chart.size())
      {
        getAndrSetAreaDrawable((SecurityReporterResult.ChartAreas)this.result.chart.get(i));
        i += 1;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903192);
    this.result = ((SecurityReporterResult)getIntent().getSerializableExtra("result"));
    if (this.result == null)
    {
      finish();
      return;
    }
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SecurityReporterActivity
 * JD-Core Version:    0.7.0.1
 */