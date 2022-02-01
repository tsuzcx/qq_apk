package com.tencent.ad.tangram.ark;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdArkAdapter
{
  public abstract View buildArkView(Params paramParams);
  
  public abstract View buildSelectWindowArkView(Params paramParams);
  
  public abstract String getArkFormData(DataParams paramDataParams);
  
  public abstract Rect getArkInputRect(View paramView);
  
  public abstract void setNotify(WeakReference<ArkNotifyCallback> paramWeakReference);
  
  @Keep
  public static abstract interface ArkNotifyCallback
  {
    public abstract boolean notify(String paramString1, String paramString2, String paramString3);
  }
  
  @Keep
  public static abstract interface Callback
  {
    public abstract void firstPaint(long paramLong);
    
    public abstract void loadSucc();
    
    public abstract void onFocusChanged(View paramView, boolean paramBoolean);
    
    public abstract void onGlobalLayout(View paramView);
    
    public abstract void onHideMenu(View paramView);
    
    public abstract void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  @Keep
  public static class DataParams
  {
    public long advertiser_id;
    public String canvas_json;
    public int dest_type;
    public String form_module_id;
    public int index;
    public String landing_page_report_url;
    public int product_type;
    public String traceid;
  }
  
  @Keep
  public static class Params
  {
    public String appName;
    public WeakReference<AdArkAdapter.Callback> callback;
    public WeakReference<Context> context;
    public String metaData;
    public String viewName;
    
    public boolean isValid()
    {
      return (this.context != null) && (this.context.get() != null) && (!TextUtils.isEmpty(this.metaData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ark.AdArkAdapter
 * JD-Core Version:    0.7.0.1
 */