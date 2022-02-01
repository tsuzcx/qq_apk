package com.dataline.activities;

import acde;
import acfp;
import acir;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cg;
import ch;
import co;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cp;
import cp.a;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  List<String> K = new ArrayList();
  public List<a> M = new ArrayList();
  b a;
  public acde b;
  private cp.a b;
  String bI;
  boolean bt = false;
  LayoutInflater mInflater = null;
  public XListView mListView;
  
  public PrinterSubOptionActivity()
  {
    this.jdField_b_of_type_Acde = null;
    this.jdField_b_of_type_Cp$a = new cg(this);
  }
  
  private void bZ()
  {
    if (this.jdField_b_of_type_Acde.b != null)
    {
      int j = 0;
      int k = 0;
      this.M.clear();
      List localList = this.jdField_b_of_type_Acde.b.i();
      int i1 = localList.size();
      int i = 0;
      if (i < i1)
      {
        co localco = (co)localList.get(i);
        int n;
        int m;
        if ((localco.dB == 1) && (j == 0))
        {
          this.M.add(new a(1, 0L, "PC绑定的打印机"));
          n = 1;
          m = k;
        }
        for (;;)
        {
          this.M.add(new a(2, localco.ai, localco.bJ));
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (localco.dB == 2)
          {
            m = k;
            n = j;
            if (k == 0)
            {
              this.M.add(new a(1, 0L, "QQ物联打印机"));
              m = 1;
              n = j;
            }
          }
        }
      }
      this.a.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mInflater = LayoutInflater.from(this);
    this.jdField_b_of_type_Acde = ((acde)this.app.getBusinessHandler(8));
    this.jdField_b_of_type_Acde.a.K = null;
    getWindow().setBackgroundDrawableResource(2131165572);
    setContentView(2131559193);
    setTitle(2131692401);
    getWindow().setBackgroundDrawable(null);
    this.a = new b();
    this.mListView = ((XListView)findViewById(2131373595));
    this.mListView.setTag(2131361821, "n/a");
    this.mListView.setAdapter(this.a);
    if (!this.jdField_b_of_type_Acde.b.Y())
    {
      paramBundle = findViewById(2131366421);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(acfp.m(2131709891));
      ((TextView)findViewById(2131380040)).setText(getString(2131692393));
      ((TextView)findViewById(2131363705)).setText(getString(2131692392));
      this.mListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131691039);
      this.mListView.setTag(2131361821, "n/a");
      return true;
      bZ();
      this.jdField_b_of_type_Acde.b.a(this.jdField_b_of_type_Cp$a);
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_Acde.b.ch();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.bI = getString(2131692394);
    this.M.clear();
    bZ();
    acir localacir = (acir)this.app.getBusinessHandler(74);
    this.bt = localacir.abe();
    localacir.cKX();
  }
  
  public boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
  
  public class a
  {
    public long din;
    public String name;
    public int type;
    
    a(int paramInt, long paramLong, String paramString)
    {
      this.type = paramInt;
      this.din = paramLong;
      this.name = paramString;
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private View.OnClickListener mBtnClickListener = new ch(this);
    
    public b() {}
    
    public int getCount()
    {
      if ((PrinterSubOptionActivity.this.M != null) && (PrinterSubOptionActivity.this.M.size() > 0)) {
        return PrinterSubOptionActivity.this.M.size();
      }
      return 1;
    }
    
    public Object getItem(int paramInt)
    {
      if ((PrinterSubOptionActivity.this.M != null) && (paramInt < PrinterSubOptionActivity.this.M.size())) {
        return PrinterSubOptionActivity.this.M.get(paramInt);
      }
      return new PrinterSubOptionActivity.a(PrinterSubOptionActivity.this, 1, 0L, PrinterSubOptionActivity.this.bI);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((PrinterSubOptionActivity.this.M != null) && (PrinterSubOptionActivity.this.M.size() > 0)) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      String str = ((PrinterSubOptionActivity.a)getItem(paramInt)).name;
      Object localObject;
      if (getItemViewType(paramInt) == 0)
      {
        localObject = (PrinterSubOptionActivity.a)getItem(paramInt);
        if (((PrinterSubOptionActivity.a)localObject).type == 1)
        {
          paramView = PrinterSubOptionActivity.this.mInflater.inflate(2131559782, null);
          localObject = (TextView)paramView.findViewById(2131379419);
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((TextView)localObject).setText(str);
          ((TextView)localObject).setTag(Integer.valueOf(paramInt));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (((PrinterSubOptionActivity.a)localObject).type == 2)
        {
          paramView = PrinterSubOptionActivity.this.mInflater.inflate(2131559783, null);
          View localView = paramView.findViewById(2131364341);
          localObject = (TextView)paramView.findViewById(2131364342);
          localView.setClickable(true);
          localView.setEnabled(true);
          localView.setOnClickListener(this.mBtnClickListener);
          continue;
          paramView = PrinterSubOptionActivity.this.mInflater.inflate(2131559207, null);
          paramView.findViewById(2131370598).setVisibility(8);
          localObject = (TextView)paramView.findViewById(2131370599);
          ((TextView)localObject).setTextSize(19.0F);
          ((TextView)localObject).setTextColor(-16777216);
        }
        else
        {
          localObject = null;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */