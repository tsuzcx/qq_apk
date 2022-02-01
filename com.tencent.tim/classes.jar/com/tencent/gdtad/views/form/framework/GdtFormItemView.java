package com.tencent.gdtad.views.form.framework;

import acfp;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import java.lang.ref.WeakReference;
import tkw;

public abstract class GdtFormItemView
  extends TableRow
{
  private AdFormItemData data;
  private WeakReference<AdFormErrorListener> listener;
  
  public GdtFormItemView(Context paramContext, AdFormItemData paramAdFormItemData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    super(paramContext);
    this.listener = paramWeakReference;
    init(paramContext, paramAdFormItemData);
  }
  
  private View createTitleView(Context paramContext)
  {
    if ((getData() == null) || (!getData().isValid()))
    {
      tkw.e("GdtFormItemView", "createTitleView error");
      return null;
    }
    if (getData().required) {}
    for (String str = getData().title.text;; str = getData().title.text + acfp.m(2131706870))
    {
      paramContext = new TextView(paramContext);
      paramContext.setGravity(16);
      paramContext.setText(str);
      paramContext.setTextColor(getData().title.color);
      paramContext.setTextSize(0, getData().title.size);
      return paramContext;
    }
  }
  
  private void init(Context paramContext, AdFormItemData paramAdFormItemData)
  {
    if ((paramAdFormItemData == null) || (!paramAdFormItemData.isValid()))
    {
      tkw.e("GdtFormItemView", "init error");
      return;
    }
    this.data = paramAdFormItemData;
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    if ((getData() == null) || (!getData().isValid()))
    {
      tkw.e("GdtFormItemView", "initViews error");
      return;
    }
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(-2, -2);
    View localView = createTitleView(paramContext);
    Object localObject = localView;
    if (localView == null)
    {
      tkw.e("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(getData().titlePaddingLeft, getData().paddingTop, getData().titlePaddingRight, getData().paddingBottom);
    localLayoutParams = new TableRow.LayoutParams(-1, -2);
    localView = createContentView(paramContext);
    localObject = localView;
    if (localView == null)
    {
      tkw.e("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(getData().contentPaddingLeft, getData().paddingTop, getData().contentPaddingRight, getData().paddingBottom);
  }
  
  protected abstract View createContentView(Context paramContext);
  
  protected AdFormItemData getData()
  {
    return this.data;
  }
  
  protected abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormItemView
 * JD-Core Version:    0.7.0.1
 */