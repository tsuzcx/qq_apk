package com.tencent.mobileqq.activity.aio;

import acfp;
import afpt;
import altq;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wja;

public class PanelAdapter
  extends PagerAdapter
{
  int TL = 4;
  afpt a = new afpt();
  String aTc;
  int bPm = 2;
  boolean bef = false;
  public SparseArray<List<PlusPanel.a>> bt = new SparseArray();
  ViewGroup container;
  View.OnClickListener dI;
  public boolean isAnonymous;
  private View.OnLongClickListener itemOnLongClickListener;
  QQAppInterface mApp;
  Context mContext;
  ArrayList<PlusPanel.a> qe;
  
  public PanelAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
  }
  
  private void a(int paramInt, IconLinearLayout paramIconLinearLayout)
  {
    int n = this.TL;
    int i1 = this.bPm;
    paramIconLinearLayout.setPage(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.bPm)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramIconLinearLayout.getChildAt(j);
      int k = 0;
      if (k < this.TL)
      {
        View localView = localLinearLayout.getChildAt(k);
        a locala = (a)localView.getTag();
        int m = n * i1 * paramInt + i;
        PlusPanel.a locala1;
        Object localObject;
        if (m < this.qe.size())
        {
          locala1 = (PlusPanel.a)this.qe.get(m);
          locala.sk.setVisibility(0);
          locala.sk.setBackgroundDrawable(locala1.drawable);
          if ((locala1.drawable instanceof URLDrawable))
          {
            localObject = (URLDrawable)locala1.drawable;
            if (((URLDrawable)localObject).getStatus() == 2) {
              ((URLDrawable)localObject).restartDownload();
            }
          }
          locala.Il.setText(locala1.text);
          locala.B.setVisibility(0);
          locala.B.dGB();
          if (!TextUtils.isEmpty(locala1.aTd))
          {
            locala.sl.setVisibility(8);
            localObject = ((altq)this.mApp.getManager(36)).a(10, String.valueOf(locala1.aTd));
            if (localObject != null) {
              locala.B.e((BusinessInfoCheckUpdate.AppInfo)localObject);
            }
            locala.actionId = locala1.actionId;
            locala.actionType = locala1.actionType;
            locala.action = locala1.action;
            locala.appid = locala1.appid;
            locala.aTd = locala1.aTd;
            locala.beg = locala1.beg;
            localView.setContentDescription(locala1.text + acfp.m(2131709392));
            localView.setOnClickListener(this.dI);
            localView.setOnLongClickListener(this.itemOnLongClickListener);
            localView.setEnabled(true);
            aqcl.Q(localView, true);
          }
        }
        for (;;)
        {
          aqcl.Q(locala.Il, false);
          i += 1;
          k += 1;
          break;
          localObject = locala.sl;
          if (locala1.beg) {}
          for (m = 0;; m = 8)
          {
            ((ImageView)localObject).setVisibility(m);
            break;
          }
          locala.sk.setVisibility(4);
          locala.sk.setBackgroundDrawable(null);
          locala.B.setVisibility(4);
          locala.sl.setVisibility(8);
          locala.Il.setText(null);
          locala.actionId = 0;
          locala.actionType = "";
          locala.action = "";
          locala.appid = 0;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          aqcl.Q(localView, false);
        }
      }
      j += 1;
    }
  }
  
  public List<PlusPanel.a> C(int paramInt)
  {
    int i = this.TL;
    i = this.bPm * i;
    int j = i * paramInt;
    List localList2 = (List)this.bt.get(paramInt, null);
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList2 = Collections.emptyList();
      localList1 = localList2;
      if (j >= 0)
      {
        localList1 = localList2;
        if (j < this.qe.size()) {
          localList1 = this.qe.subList(j, Math.min(this.qe.size(), i + j));
        }
      }
      this.bt.put(paramInt, localList1);
    }
    return localList1;
  }
  
  public void cW(ArrayList<PlusPanel.a> paramArrayList)
  {
    this.qe = paramArrayList;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    IconLinearLayout localIconLinearLayout = (IconLinearLayout)paramObject;
    ((ViewGroup)paramView).removeView(localIconLinearLayout);
    localIconLinearLayout.clear();
    this.a.gx((View)paramObject);
    this.bt.remove(paramInt);
  }
  
  public int getColumnNum()
  {
    return this.TL;
  }
  
  public int getCount()
  {
    if ((this.TL == 0) || (this.bPm == 0) || (this.qe == null)) {
      return 0;
    }
    return (this.qe.size() + this.TL * this.bPm - 1) / (this.TL * this.bPm);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.isAnonymous) {
      return -2;
    }
    if (((paramObject instanceof IconLinearLayout)) && (((IconLinearLayout)paramObject).page >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public int getRowNum()
  {
    return this.bPm;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    IconLinearLayout localIconLinearLayout = (IconLinearLayout)this.a.bW();
    Object localObject;
    if (localIconLinearLayout != null)
    {
      localObject = localIconLinearLayout.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localIconLinearLayout.getTag()).intValue() != XPanelContainer.evb))
      {
        this.a.dbs();
        localIconLinearLayout = null;
      }
    }
    for (;;)
    {
      this.container = ((ViewGroup)paramView);
      localObject = localIconLinearLayout;
      if (localIconLinearLayout == null) {
        localObject = new IconLinearLayout(this.mContext, null);
      }
      ((IconLinearLayout)localObject).setPage(paramInt);
      a(paramInt, (IconLinearLayout)localObject);
      if ((((IconLinearLayout)localObject).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject);
      }
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.itemOnLongClickListener = paramOnLongClickListener;
  }
  
  public void update(int paramInt)
  {
    if (this.container == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.container.getChildCount())
        {
          IconLinearLayout localIconLinearLayout = (IconLinearLayout)this.container.getChildAt(i);
          if ((localIconLinearLayout != null) && (paramInt == localIconLinearLayout.page))
          {
            a(paramInt, localIconLinearLayout);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void w(View.OnClickListener paramOnClickListener)
  {
    this.dI = paramOnClickListener;
  }
  
  public void xr(String paramString)
  {
    this.aTc = paramString;
  }
  
  class IconLinearLayout
    extends RelativeLayout
  {
    private TextView Ik;
    private LayoutInflater mInflater;
    int page;
    
    public IconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.mInflater = LayoutInflater.from(paramContext);
      int k = PanelAdapter.this.getColumnNum();
      int m = PanelAdapter.this.getRowNum();
      int i = wja.dp2px(15.0F, getContext().getResources());
      int n = (XPanelContainer.euZ - i) / m;
      int i1 = XPanelContainer.aLe - XPanelContainer.euZ;
      i = 0;
      while (i < m)
      {
        paramAttributeSet = new LinearLayout(paramContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, n);
        localLayoutParams.leftMargin = wja.dp2px(20.0F, getContext().getResources());
        localLayoutParams.rightMargin = wja.dp2px(20.0F, getContext().getResources());
        paramAttributeSet.setOrientation(0);
        localLayoutParams.topMargin = j(i, i1, n);
        if (QLog.isColorLevel()) {
          QLog.i("IconLinearLayout", 2, "top margin: " + localLayoutParams.topMargin + "addedHeight: " + i1 + ", row height: " + n + ", i: " + i);
        }
        int j = 0;
        while (j < k)
        {
          Object localObject = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
          if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(paramContext);
          }
          View localView = LayoutInflater.from(paramContext).inflate(2131558934, null);
          paramAttributeSet.addView(localView, (ViewGroup.LayoutParams)localObject);
          localObject = new PanelAdapter.a();
          ((PanelAdapter.a)localObject).sk = ((ImageView)localView.findViewById(2131368847));
          ((PanelAdapter.a)localObject).B = new RedTouch(paramContext, ((PanelAdapter.a)localObject).sk).a(8388661).a();
          ((PanelAdapter.a)localObject).sl = ((ImageView)localView.findViewById(2131367211));
          ((PanelAdapter.a)localObject).Il = ((TextView)localView.findViewById(2131379420));
          localView.setTag(localObject);
          j += 1;
        }
        addView(paramAttributeSet, localLayoutParams);
        i += 1;
      }
      if (PanelAdapter.this.bef) {
        di(paramContext);
      }
      setTag(Integer.valueOf(XPanelContainer.evb));
    }
    
    private int j(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0) {
        return paramInt2 * 3 / 10;
      }
      return paramInt2 * 5 / 10 + paramInt3;
    }
    
    public void clear()
    {
      int i = 0;
      while (i < getChildCount())
      {
        Object localObject = getChildAt(i);
        if (localObject != null)
        {
          localObject = (PanelAdapter.a)((View)localObject).getTag();
          if ((localObject != null) && (((PanelAdapter.a)localObject).sk != null)) {
            ((PanelAdapter.a)localObject).sk.setBackgroundDrawable(null);
          }
        }
        i += 1;
      }
      this.page = -1;
    }
    
    protected void di(Context paramContext)
    {
      if (this.Ik == null)
      {
        int i = wja.dp2px(18.0F, getContext().getResources());
        int j = wja.dp2px(18.0F, getContext().getResources());
        this.Ik = new TextView(paramContext);
        this.Ik.setTextColor(-4473925);
        this.Ik.setTextSize(8.0F);
        paramContext = new LinearLayout(paramContext);
        paramContext.setOrientation(0);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.gravity = 83;
        this.Ik.setGravity(83);
        this.Ik.setPadding(0, 0, 0, 0);
        localLayoutParams.leftMargin = i;
        paramContext.addView(this.Ik, localLayoutParams);
        addView(paramContext, new RelativeLayout.LayoutParams(-1, j));
      }
    }
    
    public void setPage(int paramInt)
    {
      this.page = paramInt;
      if (PanelAdapter.this.bef)
      {
        di(getContext());
        this.Ik.setText(PanelAdapter.this.aTc);
        this.Ik.setVisibility(0);
      }
      while (this.Ik == null) {
        return;
      }
      this.Ik.setVisibility(8);
    }
  }
  
  public static class a
  {
    RedTouch B;
    TextView Il;
    public String aTd;
    public String action;
    public int actionId;
    public String actionType;
    public int appid;
    public boolean beg;
    ImageView sk;
    ImageView sl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */