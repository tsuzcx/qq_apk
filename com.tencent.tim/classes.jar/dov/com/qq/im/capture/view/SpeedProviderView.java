package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SpeedProviderView
  extends ProviderView
  implements View.OnClickListener
{
  protected View MV;
  protected View MW;
  protected View MX;
  protected View MY;
  private a a;
  
  public SpeedProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected int QW()
  {
    return 2131561140;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.aeU(i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      continue;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561140, this, false);
    }
    addContentView(this.mContentView);
    this.MV = this.mContentView.findViewById(2131373393);
    this.MV.setOnClickListener(this);
    this.MW = this.mContentView.findViewById(2131373392);
    this.MW.setOnClickListener(this);
    this.MX = this.mContentView.findViewById(2131373394);
    this.MX.setOnClickListener(this);
    this.MY = this.mContentView.findViewById(2131373395);
    this.MY.setOnClickListener(this);
  }
  
  public void setEditSpeedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aeU(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.SpeedProviderView
 * JD-Core Version:    0.7.0.1
 */