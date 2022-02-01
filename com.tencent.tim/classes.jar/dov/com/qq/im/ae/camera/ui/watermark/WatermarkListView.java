package dov.com.qq.im.ae.camera.ui.watermark;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.ttpic.openapi.model.WMElement;
import java.util.ArrayList;
import java.util.List;

public class WatermarkListView
  extends ScrollView
{
  private List<RecyclerView.ViewHolder> Ml;
  private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
  private LinearLayout mContainer;
  
  public WatermarkListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public WatermarkListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public WatermarkListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    this.mContainer = new LinearLayout(paramContext);
    this.mContainer.setOrientation(1);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.mContainer, paramContext);
  }
  
  public int QY()
  {
    if (this.Ml != null) {
      return this.Ml.size();
    }
    return 0;
  }
  
  public RecyclerView.ViewHolder a(int paramInt)
  {
    return (RecyclerView.ViewHolder)this.Ml.get(paramInt);
  }
  
  public RecyclerView.Adapter<RecyclerView.ViewHolder> getAdapter()
  {
    return this.mAdapter;
  }
  
  public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter, List<WMElement> paramList)
  {
    this.mAdapter = paramAdapter;
    this.Ml = new ArrayList();
    this.mContainer.removeAllViews();
    int i = 0;
    while (i < paramAdapter.getItemCount())
    {
      paramList = paramAdapter.onCreateViewHolder(this.mContainer, 0);
      paramAdapter.onBindViewHolder(paramList, i);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      this.mContainer.addView(paramList.itemView, localLayoutParams);
      this.Ml.add(paramList);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkListView
 * JD-Core Version:    0.7.0.1
 */