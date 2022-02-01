package com.tencent.mobileqq.nearby.now.view.widget;

import akbf;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import jll;

public class TopicLabelListView
  extends LinearLayout
{
  private List<String> DI;
  private final String TAG = "TopicLabelListView";
  private BaseAdapter g = new akbf(this);
  private Context mContext;
  private HorizontalListView v;
  
  public TopicLabelListView(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public TopicLabelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  public TopicLabelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public final class a
  {
    public String text;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView
 * JD-Core Version:    0.7.0.1
 */