package com.tencent.ad.tangram.canvas.views.form.framework;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

@Keep
public abstract class AdFormItemView
  extends TableRow
{
  private static final String TAG = "GdtFormItemView";
  private AdFormItemData data;
  private WeakReference<AdFormErrorListener> listener;
  
  public AdFormItemView(Context paramContext, AdFormItemData paramAdFormItemData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    super(paramContext);
    this.listener = paramWeakReference;
    init(paramContext, paramAdFormItemData);
  }
  
  private View createTitleView(Context paramContext)
  {
    if ((getData() == null) || (!getData().isValid()))
    {
      AdLog.e("GdtFormItemView", "createTitleView error");
      return null;
    }
    if (getData().required) {}
    for (String str = getData().title.text;; str = getData().title.text + "(选填)")
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
      AdLog.e("GdtFormItemView", "init error");
      return;
    }
    this.data = paramAdFormItemData;
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    if ((getData() == null) || (!getData().isValid()))
    {
      AdLog.e("GdtFormItemView", "initViews error");
      return;
    }
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(-2, -2);
    View localView = createTitleView(paramContext);
    Object localObject = localView;
    if (localView == null)
    {
      AdLog.e("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(getData().titlePaddingLeft, getData().paddingTop, getData().titlePaddingRight, getData().paddingBottom);
    localLayoutParams = new TableRow.LayoutParams(-1, -2);
    localView = createContentView(paramContext);
    localObject = localView;
    if (localView == null)
    {
      AdLog.e("GdtFormItemView", "initViews error");
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
  
  public int getIndex()
  {
    if (!(getParent() instanceof TableLayout))
    {
      AdLog.e("GdtFormItemView", "getIndex error");
      return -1;
    }
    return ((TableLayout)TableLayout.class.cast(getParent())).indexOfChild(this);
  }
  
  public abstract void reset();
  
  public void showError(AdFormError paramAdFormError)
  {
    if ((this.listener != null) && (this.listener.get() != null)) {
      ((AdFormErrorListener)this.listener.get()).onError(paramAdFormError);
    }
  }
  
  public boolean validate()
  {
    if ((getData() == null) || (!getData().isValid())) {
      AdLog.e("GdtFormItemView", "validate error");
    }
    AdFormError localAdFormError;
    do
    {
      return false;
      localAdFormError = getData().validate();
      if (localAdFormError == null)
      {
        AdLog.e("GdtFormItemView", "validate error");
        return false;
      }
      localAdFormError.index = getIndex();
      if (localAdFormError.type == 2) {
        return true;
      }
    } while (localAdFormError.type == 5);
    showError(localAdFormError);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemView
 * JD-Core Version:    0.7.0.1
 */