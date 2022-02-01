package com.tencent.mobileqq.activity.contact.addcontact;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewFactory
{
  private static ViewFactory a;
  private static final int[] iT = { 80000000, 80000001, 80000002, 80000004, 80000003 };
  private static final int[] iU = { 80000001, 80000000, 80000002, 80000004, 80000003 };
  private static final int[] iV = { 80000002, 80000000, 80000001, 80000004, 80000003 };
  private static Object lock = new Object();
  private HashMap<Integer, WeakReference<View>> hd = new HashMap(5);
  
  public static ViewFactory a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new ViewFactory();
      }
      return a;
    }
  }
  
  public static int fv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131689893;
    case 80000000: 
      return 2131689868;
    case 80000001: 
      return 2131689924;
    case 80000002: 
      if (UniteSearchActivity.dCK == 12) {
        return 2131689920;
      }
      return 2131689918;
    case 80000003: 
      return 2131689875;
    }
    return 2131720732;
  }
  
  public static int[] i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return iT;
    case 80000000: 
      return iT;
    case 80000001: 
      return iU;
    case 80000002: 
      return iV;
    }
    return iT;
  }
  
  private View k(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(acfp.m(2131716493));
    localTextView.setTextSize(0, paramContext.getResources().getDimension(2131299556));
    localTextView.setPadding(0, paramContext.getResources().getDimensionPixelSize(2131298814), 0, 0);
    localTextView.setTextColor(paramContext.getResources().getColor(2131167380));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 1;
    localLinearLayout.addView(localTextView, paramContext);
    localLinearLayout.setContentDescription(acfp.m(2131716494));
    return localLinearLayout;
  }
  
  private View l(Context paramContext)
  {
    return new GuideView(paramContext);
  }
  
  public View a(int paramInt, Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = j;
    if (paramBoolean)
    {
      localObject1 = localObject2;
      i = j;
      if (this.hd.get(Integer.valueOf(paramInt)) != null)
      {
        localObject1 = (View)((WeakReference)this.hd.get(Integer.valueOf(paramInt))).get();
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      switch (paramInt)
      {
      default: 
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (i == 0)) {
        this.hd.put(Integer.valueOf(paramInt), new WeakReference(localObject2));
      }
      return localObject2;
      localObject2 = l(paramContext);
      continue;
      localObject2 = k(paramContext);
    }
  }
  
  public void destory()
  {
    a = null;
    this.hd.clear();
    this.hd = null;
  }
  
  public static class GuideView
    extends LinearLayout
    implements View.OnClickListener
  {
    public static final int car = 2;
    public b a;
    private int bgJ = -1;
    
    public GuideView(Context paramContext)
    {
      super();
      initViews(paramContext);
    }
    
    private void f(ArrayList<a> paramArrayList, String paramString)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        localView.setOnClickListener(this);
        localView.setTag(Integer.valueOf(((a)paramArrayList.get(i)).iconId));
        localView.setTag(((a)paramArrayList.get(i)).iconId, paramString);
        ((ImageView)localView.findViewById(2131368249)).setImageResource(((a)paramArrayList.get(i)).iconId);
        ((TextView)localView.findViewById(2131368272)).setText(localView.getContext().getResources().getString(((a)paramArrayList.get(i)).cas) + ":");
        ((TextView)localView.findViewById(2131368256)).setText(paramString);
        localView.setContentDescription(getResources().getString(((a)paramArrayList.get(i)).cas) + ":" + paramString);
        i += 1;
      }
    }
    
    private void initViews(Context paramContext)
    {
      setOrientation(1);
      paramContext = LayoutInflater.from(paramContext);
      int i = 0;
      while (i < car)
      {
        addView(paramContext.inflate(2131558533, this, false));
        i += 1;
      }
    }
    
    private void yX(String paramString)
    {
      int j = getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = getChildAt(i);
        localView.setTag(((Integer)localView.getTag()).intValue(), paramString);
        ((TextView)localView.findViewById(2131368256)).setText(paramString);
        String str = localView.getContentDescription().toString();
        int k = str.length();
        int m = str.indexOf(":");
        if ((m == -1) || (m == k - 1)) {}
        for (;;)
        {
          i += 1;
          break;
          localView.setContentDescription(str.substring(0, m + 1) + paramString);
        }
      }
    }
    
    public a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 80000000: 
        return new a(2131689871, 2130845624);
      }
      return new a(2131689873, 2130845625);
    }
    
    public void bu(int paramInt, String paramString)
    {
      if (this.bgJ != paramInt)
      {
        ArrayList localArrayList = new ArrayList(3);
        int[] arrayOfInt = ViewFactory.i(paramInt);
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(arrayOfInt[i]));
          i += 1;
        }
        this.bgJ = paramInt;
        f(localArrayList, paramString);
        return;
      }
      yX(paramString);
    }
    
    public void onClick(View paramView)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      String str = (String)paramView.getTag(i);
      switch (i)
      {
      }
      for (;;)
      {
        if (this.a != null) {
          this.a.bj(i, str);
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 80000000;
        continue;
        i = 80000001;
        continue;
        i = 80000002;
      }
    }
    
    public void setListener(b paramb)
    {
      this.a = paramb;
    }
    
    public static class a
    {
      public int cas;
      public int iconId;
      
      public a(int paramInt1, int paramInt2)
      {
        this.cas = paramInt1;
        this.iconId = paramInt2;
      }
    }
    
    public static abstract interface b
    {
      public abstract void bj(int paramInt, String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory
 * JD-Core Version:    0.7.0.1
 */