package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import nry;

public class ReadInJoySelectPositionHeader
  extends RelativeLayout
{
  private a a;
  private RelativeLayout fv;
  private TextView tG;
  private TextView tH;
  
  public ReadInJoySelectPositionHeader(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ReadInJoySelectPositionHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ReadInJoySelectPositionHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131560465, this, true);
    this.tG = ((TextView)localView.findViewById(2131377965));
    this.tH = ((TextView)localView.findViewById(2131368098));
    this.fv = ((RelativeLayout)localView.findViewById(2131368099));
    this.fv.setOnClickListener(new nry(this, paramContext));
  }
  
  public void setGPSCity(String paramString)
  {
    this.tH.setText(paramString);
  }
  
  public void setSelectCityListener(a parama)
  {
    this.a = parama;
  }
  
  public void setSelectedCity(String paramString)
  {
    this.tG.setText(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a(SelectPositionModule.PositionData paramPositionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader
 * JD-Core Version:    0.7.0.1
 */