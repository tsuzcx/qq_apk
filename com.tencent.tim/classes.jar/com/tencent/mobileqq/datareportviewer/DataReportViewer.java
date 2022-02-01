package com.tencent.mobileqq.datareportviewer;

import afbn;
import afbo;
import afbs;
import afbt;
import afbu;
import afbv;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import aqgz;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class DataReportViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  protected CheckBox L;
  public TextView Rh;
  protected a a;
  public boolean bXc = true;
  protected Button fU;
  protected Button fV;
  protected Button fW;
  public LinearLayout iD;
  public RelativeLayout jP;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  public ArrayList<ReportData> mList = new ArrayList(10);
  protected ListView mListView;
  protected Path mPath;
  public float mRadius;
  
  public DataReportViewer(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131559811, this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131373762);
    this.iD = ((LinearLayout)findViewById(2131370561));
    this.Rh = ((TextView)findViewById(2131373761));
    this.fU = ((Button)findViewById(2131371849));
    this.fV = ((Button)findViewById(2131364641));
    this.fW = ((Button)findViewById(2131378121));
    this.L = ((CheckBox)findViewById(2131363134));
    this.mListView = ((ListView)findViewById(2131370536));
    localLinearLayout.setBackgroundColor(getResources().getColor(2131165446));
    int i = 0;
    while (i < localLinearLayout.getChildCount())
    {
      View localView = localLinearLayout.getChildAt(i);
      if ((localView instanceof TextView))
      {
        ((TextView)localView).setTextColor(-1);
        ((TextView)localView).setTypeface(Typeface.defaultFromStyle(1));
      }
      i += 1;
    }
    this.a = new a();
    new DefaultItemAnimator().setRemoveDuration(500L);
    this.mListView.setAdapter(this.a);
    setWillNotDraw(false);
    this.mPath = new Path();
    this.Rh.setVisibility(8);
    this.Rh.setOnClickListener(this);
    this.fU.setOnClickListener(this);
    this.fV.setOnClickListener(this);
    this.fW.setOnClickListener(this);
    this.L.setOnCheckedChangeListener(new afbn(this));
    this.mListView.setOnItemClickListener(new afbo(this, paramContext));
  }
  
  public void a(ReportData paramReportData)
  {
    this.mList.add(paramReportData);
    this.Rh.setText(String.valueOf(this.mList.size()));
    this.a.notifyDataSetChanged();
    if (this.mList.size() == 1)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      cYm();
    }
    while (this.mList.size() <= 1) {
      return;
    }
    if (!((ReportData)this.mList.get(this.mList.size() - 2)).isLightBlueBg) {}
    for (boolean bool = true;; bool = false)
    {
      paramReportData.isLightBlueBg = bool;
      return;
    }
  }
  
  public void cYm()
  {
    if (this.bXc) {
      this.mHandler.postDelayed(new DataReportViewer.3(this), 3000L);
    }
  }
  
  protected void cYn()
  {
    Object localObject = ValueAnimator.ofFloat(new float[] { aqcx.dip2px(getContext(), 25.0F), (float)aqgz.getWidth() });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).addUpdateListener(new afbs(this));
    ((ValueAnimator)localObject).setTarget(this);
    ((ValueAnimator)localObject).start();
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setAnimationListener(new afbt(this));
    this.Rh.startAnimation((Animation)localObject);
  }
  
  protected void cYo()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)aqgz.getWidth(), aqcx.dip2px(getContext(), 25.0F) });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new afbu(this));
    localValueAnimator.setTarget(this);
    localValueAnimator.start();
    localValueAnimator.addListener(new afbv(this));
  }
  
  public void cYp() {}
  
  public void cYq() {}
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    this.mPath.reset();
    Path localPath = this.mPath;
    float f2 = aqcx.dip2px(getContext(), 25.0F);
    float f3 = aqcx.dip2px(getContext(), 25.0F);
    if (this.mRadius == 0.0F) {}
    for (float f1 = getWidth();; f1 = this.mRadius)
    {
      localPath.addCircle(f2, f3, f1, Path.Direction.CW);
      paramCanvas.clipPath(this.mPath);
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      cYo();
      continue;
      cYn();
      continue;
      this.mHandler.removeCallbacksAndMessages(null);
      this.mList.clear();
      this.Rh.setText(String.valueOf(this.mList.size()));
      this.a.notifyDataSetChanged();
      this.mHandler.postDelayed(new DataReportViewer.8(this), 3000L);
      continue;
      PublicFragmentActivity.b.start(getContext(), PublicFragmentActivity.class, DataReportSettingFragment.class);
    }
  }
  
  public class a
    extends BaseAdapter
  {
    protected a() {}
    
    public int getCount()
    {
      return DataReportViewer.this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      return DataReportViewer.this.mList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = LayoutInflater.from(DataReportViewer.this.getContext()).inflate(2131559810, paramViewGroup, false);
        paramView = new DataReportViewer.b(DataReportViewer.this, localView);
        localView.setTag(paramView);
        localObject = (ReportData)DataReportViewer.this.mList.get(paramInt);
        paramView.Ri.setText(((ReportData)localObject).table);
        paramView.Rj.setText(((ReportData)localObject).mainAction);
        paramView.Rk.setText(((ReportData)localObject).subAction);
        paramView.Rl.setText(((ReportData)localObject).actionName);
        paramView.Rm.setText(String.valueOf(((ReportData)localObject).opType));
        paramView.nz.setText(String.valueOf(((ReportData)localObject).result));
        paramView.Rn.setText(((ReportData)localObject).r2);
        paramView.Ro.setText(((ReportData)localObject).r3);
        paramView.Rp.setText(((ReportData)localObject).r4);
        paramView.Rq.setText(((ReportData)localObject).r5);
        if (!((ReportData)localObject).isLightBlueBg) {
          break label249;
        }
        localView.setBackgroundColor(DataReportViewer.this.getContext().getResources().getColor(2131166849));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (DataReportViewer.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label249:
        localView.setBackgroundColor(DataReportViewer.this.getContext().getResources().getColor(2131167654));
      }
    }
  }
  
  public class b
  {
    public TextView Ri;
    public TextView Rj;
    public TextView Rk;
    public TextView Rl;
    public TextView Rm;
    public TextView Rn;
    public TextView Ro;
    public TextView Rp;
    public TextView Rq;
    public TextView nz;
    
    public b(View paramView)
    {
      this.Ri = ((TextView)paramView.findViewById(2131379175));
      this.Rj = ((TextView)paramView.findViewById(2131371088));
      this.Rk = ((TextView)paramView.findViewById(2131378907));
      this.Rl = ((TextView)paramView.findViewById(2131361993));
      this.Rm = ((TextView)paramView.findViewById(2131372650));
      this.nz = ((TextView)paramView.findViewById(2131377215));
      this.Rn = ((TextView)paramView.findViewById(2131376596));
      this.Ro = ((TextView)paramView.findViewById(2131376597));
      this.Rp = ((TextView)paramView.findViewById(2131376598));
      this.Rq = ((TextView)paramView.findViewById(2131376599));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer
 * JD-Core Version:    0.7.0.1
 */