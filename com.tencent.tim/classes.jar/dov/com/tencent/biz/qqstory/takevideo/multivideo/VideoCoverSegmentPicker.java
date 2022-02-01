package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCoverSegmentPicker
  extends RelativeLayout
  implements VideoCoverSegmentRangeView.a
{
  private VideoCoverSegmentRangeView a;
  private WeakReference<a> mListenerRef;
  
  public VideoCoverSegmentPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoCoverSegmentPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoCoverSegmentPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new VideoCoverSegmentRangeView(paramContext, null);
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
  
  public void onSeekTo(long paramLong)
  {
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.of(paramLong);
    }
  }
  
  public void setCoverFrameTime(long paramLong)
  {
    if (this.a != null) {
      this.a.setCoverFrameTime(paramLong);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker
 * JD-Core Version:    0.7.0.1
 */