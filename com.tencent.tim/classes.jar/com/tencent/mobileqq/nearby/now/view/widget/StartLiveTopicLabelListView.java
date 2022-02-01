package com.tencent.mobileqq.nearby.now.view.widget;

import akba;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import jll;

public class StartLiveTopicLabelListView
  extends LinearLayout
{
  private List<String> DI;
  private final String TAG = "TopicLabelListView";
  private a a;
  private int dme = 2130846411;
  private int dmf = 2130846410;
  private int dmg = -1;
  private BaseAdapter g = new akba(this);
  private int gT = -1;
  private Context mContext;
  private HorizontalListView v;
  
  public StartLiveTopicLabelListView(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public StartLiveTopicLabelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  public StartLiveTopicLabelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI(paramContext);
  }
  
  private void initUI(Context paramContext)
  {
    this.mContext = paramContext;
    this.v = new HorizontalListView(paramContext);
    this.v.setDividerWidth((int)jll.dp2px(paramContext, 5.0F));
    this.v.setAdapter(this.g);
    addView(this.v, -1, -1);
  }
  
  public void setData(List<String> paramList)
  {
    this.DI = paramList;
    this.g.notifyDataSetChanged();
  }
  
  public void setItemAddLabelResId(int paramInt)
  {
    this.dmf = paramInt;
  }
  
  public void setItemAddLabelTextColor(int paramInt)
  {
    this.dmg = paramInt;
  }
  
  public void setItemResId(int paramInt)
  {
    this.dme = paramInt;
  }
  
  public void setItemTextColor(int paramInt)
  {
    this.gT = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void tf();
  }
  
  public final class b
  {
    public String text;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView
 * JD-Core Version:    0.7.0.1
 */