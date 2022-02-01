package com.tencent.mobileqq.activity;

import accv;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import anot;
import aqek;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class JobSelectionActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  private a a;
  private boolean aXA;
  private boolean aXB;
  private int bHL;
  private ListView mListView;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561385);
    setTitle(2131695143);
    setLeftViewName(2131690700);
    this.bHL = getIntent().getIntExtra("param_id", -1);
    this.aXA = getIntent().getBooleanExtra("param_need_no_limit", false);
    this.aXB = getIntent().getBooleanExtra("param_from_consearch", false);
    this.mListView = ((ListView)findViewById(2131370573));
    this.mListView.setOnItemClickListener(this);
    this.a = new a(null);
    this.mListView.setAdapter(this.a);
    return true;
  }
  
  int eM(int paramInt)
  {
    if (this.aXA)
    {
      int i = paramInt;
      if (paramInt >= accv.kh[0]) {
        i = paramInt + 2;
      }
      return i;
    }
    return paramInt + 1;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.bHL = eM(paramInt);
    this.a.notifyDataSetChanged();
    if (this.aXB) {
      anot.a(this.app, "CliOper", "", "", "0X8006F0A", "0X8006F0A", 0, 0, this.bHL + "", "", "", "");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("param_id", this.bHL);
    if (!this.aXB)
    {
      localIntent.putExtra("param_tag", aqek.cq[this.bHL]);
      localIntent.putExtra("param_name", aqek.cp[this.bHL]);
      localIntent.putExtra("param_tag_bg", aqek.oT[this.bHL]);
    }
    setResult(-1, localIntent);
    finish();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  class a
    extends BaseAdapter
  {
    private String[] cp;
    private String[] cq;
    private int[] fr;
    
    private a()
    {
      if (JobSelectionActivity.a(JobSelectionActivity.this))
      {
        this$1 = accv.dU;
        this.cp = JobSelectionActivity.this;
        if (!JobSelectionActivity.a(JobSelectionActivity.this)) {
          break label74;
        }
        this$1 = accv.dV;
        label42:
        this.cq = JobSelectionActivity.this;
        if (!JobSelectionActivity.a(JobSelectionActivity.this)) {
          break label81;
        }
      }
      label74:
      label81:
      for (this$1 = accv.kf;; this$1 = aqek.oT)
      {
        this.fr = JobSelectionActivity.this;
        return;
        this$1 = aqek.cp;
        break;
        this$1 = aqek.cq;
        break label42;
      }
    }
    
    public int getCount()
    {
      if (JobSelectionActivity.b(JobSelectionActivity.this)) {
        return this.cp.length - 2;
      }
      return this.cp.length - 1;
    }
    
    public Object getItem(int paramInt)
    {
      paramInt = JobSelectionActivity.this.eM(paramInt);
      return this.cp[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      JobSelectionActivity.b localb;
      if (paramView == null)
      {
        paramView = JobSelectionActivity.this.getLayoutInflater().inflate(2131561384, paramViewGroup, false);
        localb = new JobSelectionActivity.b(null);
        localb.a = ((InterestLabelTextView)paramView.findViewById(2131379178));
        localb.name = ((TextView)paramView.findViewById(2131372190));
        localb.qh = ((ImageView)paramView.findViewById(2131364582));
        paramView.setTag(localb);
      }
      for (;;)
      {
        localb = (JobSelectionActivity.b)paramView.getTag();
        int i = JobSelectionActivity.this.eM(paramInt);
        Drawable localDrawable = JobSelectionActivity.this.getResources().getDrawable(this.fr[i]);
        ProfileActivity.a(JobSelectionActivity.this.app, localDrawable);
        localb.a.setText(this.cq[i]);
        localb.a.setBackgroundDrawable(localDrawable);
        int j = wja.dp2px(4.0F, JobSelectionActivity.a(JobSelectionActivity.this).getResources());
        localb.a.setPadding(j, 0, j, 0);
        if (i < this.cp.length - 1)
        {
          localb.a.setVisibility(0);
          if ((JobSelectionActivity.b(JobSelectionActivity.this)) && (i == 0)) {
            localb.a.setVisibility(4);
          }
          localb.name.setText(this.cp[i]);
          if (JobSelectionActivity.a(JobSelectionActivity.this) != i) {
            break label292;
          }
          localb.qh.setVisibility(0);
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localb.a.setVisibility(4);
          break;
          label292:
          localb.qh.setVisibility(4);
        }
      }
    }
  }
  
  static class b
  {
    public InterestLabelTextView a;
    public TextView name;
    public ImageView qh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity
 * JD-Core Version:    0.7.0.1
 */