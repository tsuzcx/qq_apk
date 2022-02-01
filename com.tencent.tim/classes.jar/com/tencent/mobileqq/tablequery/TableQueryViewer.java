package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzg;
import anzh;
import anzm;
import anzn;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

public class TableQueryViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  private View HB;
  private b a;
  private anzh jdField_b_of_type_Anzh;
  private TableQueryViewer jdField_b_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
  private boolean cKT = true;
  private boolean cKU = true;
  private int cPZ;
  private List fG = new LinkedList();
  private HorizontalScrollView h;
  private Button hh;
  private Button hi;
  private Button hj;
  private Button hk;
  private LinearLayout kH;
  private boolean mIsDragging;
  private WindowManager mWindowManager;
  private RelativeLayout mc;
  private ListView t;
  
  public TableQueryViewer(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131563156, this);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.h = ((HorizontalScrollView)findViewById(2131375376));
    this.t = ((ListView)findViewById(2131379170));
    this.hh = ((Button)findViewById(2131368523));
    this.hi = ((Button)findViewById(2131364641));
    this.hk = ((Button)findViewById(2131365954));
    Button localButton = this.hk;
    if (anzh.cKQ)
    {
      localObject = paramContext.getString(2131690844);
      localButton.setText((CharSequence)localObject);
      this.hj = ((Button)findViewById(2131376831));
      localButton = this.hj;
      if (!anzh.cKR) {
        break label272;
      }
    }
    label272:
    for (Object localObject = paramContext.getString(2131690846);; localObject = paramContext.getString(2131690847))
    {
      localButton.setText((CharSequence)localObject);
      this.kH = ((LinearLayout)findViewById(2131379172));
      this.kH.setBackgroundColor(getResources().getColor(2131165375));
      int i = 0;
      while (i < this.kH.getChildCount())
      {
        localObject = this.kH.getChildAt(i);
        if ((localObject instanceof TextView))
        {
          ((TextView)localObject).setTextColor(-1);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(1));
        }
        i += 1;
      }
      localObject = paramContext.getString(2131690848);
      break;
    }
    this.HB = findViewById(2131377161);
    this.mc = ((RelativeLayout)findViewById(2131366141));
    this.jdField_b_of_type_Anzh = anzh.a();
    this.a = new b();
    this.t.setAdapter(this.a);
    this.hh.setOnClickListener(this);
    this.hi.setOnClickListener(this);
    this.hj.setOnClickListener(this);
    this.hk.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqTablequeryTableQueryViewer = this;
    this.t.setOnItemLongClickListener(new anzm(this, paramContext));
    this.mc.setOnTouchListener(new anzn(this));
  }
  
  public int a(anzg paramanzg)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.fG.size(); j = k)
    {
      anzg localanzg = (anzg)this.fG.get(i);
      k = j;
      if (paramanzg.reportId.contains(localanzg.ciE))
      {
        this.fG.set(i, paramanzg);
        this.a.notifyDataSetChanged();
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a(anzg paramanzg)
  {
    this.fG.add(0, paramanzg);
    this.a.notifyDataSetChanged();
  }
  
  public void clearData()
  {
    this.fG.clear();
    this.a.notifyDataSetChanged();
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
      if (this.cKU)
      {
        this.h.setVisibility(8);
        this.hh.setText(getContext().getString(2131690854));
        this.h.setEnabled(false);
        this.cKU = false;
      }
      else
      {
        this.h.setVisibility(0);
        this.hh.setText(getContext().getString(2131690845));
        this.h.setEnabled(true);
        this.cKU = true;
        continue;
        clearData();
        continue;
        if (anzh.cKR)
        {
          this.hj.setText(getContext().getString(2131690847));
          anzh.cKR = false;
        }
        else
        {
          this.hj.setText(getContext().getString(2131690846));
          anzh.cKR = true;
          continue;
          if (anzh.cKQ)
          {
            this.hk.setText(getContext().getString(2131690848));
            anzh.cKQ = false;
          }
          else
          {
            this.hk.setText(getContext().getString(2131690844));
            anzh.cKQ = true;
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public class a
  {
    TextView ZA;
    TextView ZB;
    TextView Zz;
    TextView description;
    
    public a(View paramView)
    {
      this.Zz = ((TextView)paramView.findViewById(2131379173));
      this.Zz.setTextSize(10.0F);
      this.ZA = ((TextView)paramView.findViewById(2131379171));
      this.ZA.setTextSize(10.0F);
      this.ZB = ((TextView)paramView.findViewById(2131379176));
      this.ZB.setTextSize(10.0F);
      this.description = ((TextView)paramView.findViewById(2131379168));
      this.description.setTextSize(10.0F);
    }
  }
  
  public class b
    extends BaseAdapter
  {
    protected b() {}
    
    private int af()
    {
      return getList().size();
    }
    
    private List<anzg> getList()
    {
      return TableQueryViewer.a(TableQueryViewer.this);
    }
    
    public int getCount()
    {
      return af();
    }
    
    public Object getItem(int paramInt)
    {
      return getList().get(paramInt);
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
        localView = LayoutInflater.from(TableQueryViewer.this.getContext()).inflate(2131563157, paramViewGroup, false);
        paramView = new TableQueryViewer.a(TableQueryViewer.this, localView);
        localView.setTag(paramView);
        localObject = (anzg)getList().get(paramInt);
        paramView.Zz.setText(((anzg)localObject).reportId);
        paramView.description.setText(((anzg)localObject).description);
        paramView.ZA.setText(((anzg)localObject).ciF);
        paramView.ZB.setText(((anzg)localObject).ciI);
        if (paramInt % 2 != 0) {
          break label168;
        }
        localView.setBackgroundColor(TableQueryViewer.this.getContext().getResources().getColor(2131166849));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (TableQueryViewer.a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label168:
        localView.setBackgroundColor(TableQueryViewer.this.getContext().getResources().getColor(2131167654));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer
 * JD-Core Version:    0.7.0.1
 */