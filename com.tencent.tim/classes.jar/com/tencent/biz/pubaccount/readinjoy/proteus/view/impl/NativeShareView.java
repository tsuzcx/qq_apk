package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.screendetect.ScreenShotFragment.b;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ltl;
import ltm;
import oeg;

public class NativeShareView
  extends LinearLayout
  implements IView
{
  private Runnable cG;
  private Context context;
  protected AdapterView.c f = new ltm(this);
  
  public NativeShareView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public NativeShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  protected static String G(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    Object localObject1 = inflate(getContext(), 2131560345, this);
    int j = aqnm.dpToPx(44.0F);
    localObject1 = (GridView)((View)localObject1).findViewById(2131368140);
    List localList = a(paramContext)[0];
    Object localObject2 = new TextPaint();
    ((TextPaint)localObject2).setTextSize(paramContext.getResources().getDimensionPixelSize(2131299551));
    new StaticLayout(G(q(localList), 6), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_CENTER, 1.0F, 0, true);
    localObject2 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility != 0) {
        break label267;
      }
      i += 1;
    }
    label267:
    for (;;)
    {
      break;
      int k = aqnm.dpToPx(14.0F);
      j = k + (k + j);
      ((GridView)localObject1).setColumnWidth(j);
      ((GridView)localObject1).setNumColumns(i);
      localObject2 = ((GridView)localObject1).getLayoutParams();
      ((GridView)localObject1).setPadding(16, ((GridView)localObject1).getPaddingTop(), 16, ((GridView)localObject1).getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject2).width = (j * i + 0 + 0);
      ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((GridView)localObject1).setAdapter(new a(paramContext, localList));
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setOnItemClickListener(this.f);
      ((GridView)localObject1).setOnTouchListener(new ltl(this));
      oeg.bdN();
      return;
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.icon = 2130843653;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 47;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698630);
    localActionSheetItem.icon = 2130843655;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698643);
    localActionSheetItem.icon = 2130843656;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698652);
    localActionSheetItem.icon = 2130843657;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698633);
    localActionSheetItem.icon = 2130843654;
    localActionSheetItem.iconNeedBg = false;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    oeg.destroy();
  }
  
  protected String q(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label54;
      }
      localObject = str;
    }
    label54:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public void setCurrentPath(String paramString)
  {
    oeg.setCurrentPath(paramString);
  }
  
  public void setInitRunnable(Runnable paramRunnable)
  {
    this.cG = paramRunnable;
  }
  
  public void setScreenBitmap(Bitmap paramBitmap)
  {
    oeg.setBitmap(paramBitmap);
  }
  
  public static class a
    extends BaseAdapter
    implements AdapterView.c
  {
    private int OE;
    private a a;
    private LayoutInflater inflater;
    private List<ShareActionSheetBuilder.ActionSheetItem> items;
    private Resources mRes;
    
    public a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
    {
      this.items = paramList;
      this.inflater = LayoutInflater.from(paramContext);
    }
    
    public ShareActionSheetBuilder.ActionSheetItem c(int paramInt)
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.items == null) || (paramInt < 0))
      {
        localActionSheetItem = null;
        return localActionSheetItem;
      }
      int j = -1;
      int i = 0;
      for (;;)
      {
        if (i >= this.items.size()) {
          break label89;
        }
        localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.items.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          break;
        }
        i += 1;
        j = k;
      }
      label89:
      return null;
    }
    
    public int getCount()
    {
      if (this.items == null) {
        return 0;
      }
      Iterator localIterator = this.items.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
        if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
          break label60;
        }
        i += 1;
      }
      label60:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      if (this.mRes == null) {
        this.mRes = paramViewGroup.getContext().getResources();
      }
      if (this.OE == 0) {
        this.OE = ((int)this.mRes.getDimension(2131296957));
      }
      if (this.a == null) {
        this.a = new a(paramViewGroup.getContext());
      }
      if (paramView == null)
      {
        paramView = this.inflater.inflate(2131560181, paramViewGroup, false);
        localObject1 = new ScreenShotFragment.b();
        ((ScreenShotFragment.b)localObject1).vIcon = ((ImageView)paramView.findViewById(2131378172));
        ((ScreenShotFragment.b)localObject1).vLabel = ((TextView)paramView.findViewById(2131378173));
        paramView.setTag(localObject1);
        paramView.setFocusable(true);
      }
      for (;;)
      {
        ((ScreenShotFragment.b)localObject1).b = c(paramInt);
        if (((ScreenShotFragment.b)localObject1).b != null) {
          break;
        }
        QLog.e("NativeShareView", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (ScreenShotFragment.b)paramView.getTag();
      }
      paramView.setId(((ScreenShotFragment.b)localObject1).b.id);
      Object localObject2 = ((ScreenShotFragment.b)localObject1).vLabel;
      Object localObject3 = ((ScreenShotFragment.b)localObject1).b.label;
      int i;
      if (((ScreenShotFragment.b)localObject1).b.firstLineCount > 0)
      {
        i = ((ScreenShotFragment.b)localObject1).b.firstLineCount;
        label254:
        ((TextView)localObject2).setText(NativeShareView.G((String)localObject3, i));
        i = -16578534;
        localObject2 = ((ScreenShotFragment.b)localObject1).vLabel;
        if (!((ScreenShotFragment.b)localObject1).b.enable) {
          break label505;
        }
        label288:
        ((TextView)localObject2).setTextColor(i);
        if (!((ScreenShotFragment.b)localObject1).b.iconNeedBg) {
          break label575;
        }
        if (((ScreenShotFragment.b)localObject1).b.iconDrawable == null) {
          break label513;
        }
        localObject2 = ((ScreenShotFragment.b)localObject1).b.iconDrawable;
        label327:
        i = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        if (this.OE <= i) {
          break label533;
        }
        i = (int)((this.OE - i) / 2.0F);
        label363:
        if (this.OE > k) {
          j = (int)((this.OE - k) / 2.0F);
        }
        localObject2 = this.a.a((Drawable)localObject2, i, j);
        if (!((ScreenShotFragment.b)localObject1).b.enable) {
          break label539;
        }
        localObject3 = a.a(this.a, (Drawable)localObject2);
        localObject2 = this.a.a((Drawable)localObject2, (Drawable)localObject3);
        ((ScreenShotFragment.b)localObject1).vIcon.setImageDrawable((Drawable)localObject2);
        label445:
        if (Build.VERSION.SDK_INT < 16) {
          break label563;
        }
        ((ScreenShotFragment.b)localObject1).vIcon.setBackground(null);
        label462:
        if (AppSetting.enableTalkBack) {
          if (((ScreenShotFragment.b)localObject1).b.label == null) {
            break label662;
          }
        }
      }
      label513:
      label533:
      label662:
      for (Object localObject1 = ((ScreenShotFragment.b)localObject1).b.label;; localObject1 = "")
      {
        paramView.setContentDescription((CharSequence)localObject1);
        break;
        i = 6;
        break label254;
        label505:
        i = 2130905114;
        break label288;
        localObject2 = this.mRes.getDrawable(((ScreenShotFragment.b)localObject1).b.icon);
        break label327;
        i = 0;
        break label363;
        label539:
        localObject2 = a.b(this.a, (Drawable)localObject2);
        ((ScreenShotFragment.b)localObject1).vIcon.setImageDrawable((Drawable)localObject2);
        break label445;
        label563:
        ((ScreenShotFragment.b)localObject1).vIcon.setBackgroundDrawable(null);
        break label462;
        label575:
        ((ScreenShotFragment.b)localObject1).vIcon.setImageResource(2130837636);
        if (((ScreenShotFragment.b)localObject1).b.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            ((ScreenShotFragment.b)localObject1).vIcon.setBackground(((ScreenShotFragment.b)localObject1).b.iconDrawable);
            break label462;
          }
          ((ScreenShotFragment.b)localObject1).vIcon.setBackgroundDrawable(((ScreenShotFragment.b)localObject1).b.iconDrawable);
          break label462;
        }
        ((ScreenShotFragment.b)localObject1).vIcon.setBackgroundResource(((ScreenShotFragment.b)localObject1).b.icon);
        break label462;
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
    
    static class a
    {
      private final Drawable cy;
      private final Drawable cz;
      
      a(Context paramContext)
      {
        paramContext = paramContext.getResources();
        this.cy = paramContext.getDrawable(2130837635);
        this.cz = paramContext.getDrawable(2130837639);
      }
      
      private Drawable A(Drawable paramDrawable)
      {
        return new LayerDrawable(new Drawable[] { paramDrawable, this.cz });
      }
      
      private Drawable B(Drawable paramDrawable)
      {
        paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
        paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
        return paramDrawable;
      }
      
      Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
      {
        paramDrawable = new LayerDrawable(new Drawable[] { this.cy, paramDrawable });
        paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
        return paramDrawable;
      }
      
      StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
      {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
        localStateListDrawable.addState(new int[0], paramDrawable1);
        return localStateListDrawable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView
 * JD-Core Version:    0.7.0.1
 */