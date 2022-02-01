package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import wja;

public class AEGridView
  extends RecyclerView
{
  private int eEo;
  private int itemHeight;
  private Context mContext;
  
  public AEGridView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    int i = wja.dp2px(60.0F, this.mContext.getResources());
    int j = wja.dp2px(12.0F, this.mContext.getResources());
    int k = wja.dp2px(10.0F, this.mContext.getResources());
    int m = this.mContext.getResources().getDisplayMetrics().widthPixels;
    this.eEo = ((m - k) / (i + k));
    setPadding((m - this.eEo * i) / (this.eEo + 1), 0, 0, j * 4);
    setClipToPadding(false);
    setLayoutManager(new GridLayoutManager(getContext(), this.eEo));
    addItemDecoration(new a(this.eEo, k));
    this.itemHeight = i;
  }
  
  public void adF(int paramInt)
  {
    int i = wja.dp2px(10.0F, this.mContext.getResources());
    paramInt /= this.eEo;
    i = (i + this.itemHeight) * (paramInt - 1);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    smoothScrollBy(0, paramInt);
  }
  
  class a
    extends RecyclerView.ItemDecoration
  {
    private int spacing;
    private int spanCount;
    
    public a(int paramInt1, int paramInt2)
    {
      this.spanCount = paramInt1;
      this.spacing = paramInt2;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.top = this.spacing;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEGridView
 * JD-Core Version:    0.7.0.1
 */