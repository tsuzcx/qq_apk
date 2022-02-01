package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import ngj;
import ngj.a;
import ngl;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private boolean Yp;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$b;
  private ngj b;
  private ViewGroup bD;
  private GridView e;
  private View iX;
  private List<ChannelCoverInfo> jX;
  
  public ReadInJoyNavigationGridview(Context paramContext, b paramb)
  {
    super(paramContext);
    initUI(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$a = new a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$b = paramb;
    this.Yp = false;
  }
  
  private void aWR()
  {
    if ((this.jX != null) && (this.jX.size() > 0)) {
      this.b.cX(this.jX);
    }
  }
  
  private void initUI(Context paramContext)
  {
    this.bD = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560431, this));
    this.e = ((GridView)this.bD.findViewById(2131372219));
    this.iX = this.bD.findViewById(2131372220);
    this.b = new ngj(paramContext);
    this.e.setPadding(this.e.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(paramContext), this.e.getPaddingRight(), this.e.getPaddingBottom());
    this.e.setAdapter(this.b);
    this.iX.setOnTouchListener(new ngl(this));
  }
  
  public View ap()
  {
    return this.e;
  }
  
  public void destroy()
  {
    this.Yp = true;
    this.jX = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$a.removeMessages(1);
  }
  
  public List<ChannelCoverInfo> getChannels()
  {
    return this.jX;
  }
  
  public boolean isDestroy()
  {
    return this.Yp;
  }
  
  public int qA()
  {
    return this.b.getCount();
  }
  
  public void setChannelButtonListener(ngj.a parama)
  {
    this.b.setChannelButtonListener(parama);
  }
  
  public void setNaviBarAdapterDataSet(List<ChannelCoverInfo> paramList)
  {
    this.jX = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$a.sendEmptyMessage(1);
  }
  
  static class a
    extends Handler
  {
    private WeakReference<ReadInJoyNavigationGridview> ct;
    
    public a(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview)
    {
      this.ct = new WeakReference(paramReadInJoyNavigationGridview);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ReadInJoyNavigationGridview localReadInJoyNavigationGridview = (ReadInJoyNavigationGridview)this.ct.get();
      if ((localReadInJoyNavigationGridview == null) || (ReadInJoyNavigationGridview.a(localReadInJoyNavigationGridview))) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      ReadInJoyNavigationGridview.a(localReadInJoyNavigationGridview);
    }
  }
  
  public static abstract interface b
  {
    public abstract void aDt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */