package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

public class SegmentPicker
  extends RelativeLayout
  implements SegmentRangeView.a
{
  private SegmentRangeView a;
  private WeakReference<a> mListenerRef;
  
  public SegmentPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SegmentPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SegmentPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new SegmentRangeView(paramContext, null);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.a, paramContext);
  }
  
  public void ZK(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.ZK(paramBoolean);
    }
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, a parama, boolean paramBoolean2)
  {
    this.mListenerRef = new WeakReference(parama);
    if (this.a != null) {
      this.a.a(paramString, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramBoolean1, this, paramBoolean2);
    }
    return true;
  }
  
  public List<Pair<Long, Long>> hZ()
  {
    if (this.a != null) {
      return this.a.ia();
    }
    return null;
  }
  
  public void oS(List<Long> paramList)
  {
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.oL(paramList);
    }
  }
  
  public void onSeekEnd(long paramLong)
  {
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.oh(paramLong);
    }
  }
  
  public void op(long paramLong)
  {
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.of(paramLong);
    }
  }
  
  public void setRanges(List<Pair<Long, Long>> paramList)
  {
    if (this.a != null) {
      this.a.setRanges(paramList);
    }
  }
  
  public void unInit()
  {
    this.mListenerRef = null;
    if (this.a != null)
    {
      this.a.unInit();
      this.a = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void oL(List<Long> paramList);
    
    public abstract void of(long paramLong);
    
    public abstract void oh(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker
 * JD-Core Version:    0.7.0.1
 */