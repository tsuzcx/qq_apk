package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import axxx;
import axxy;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentPicker.a;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoCoverPickerProviderView
  extends ProviderView
  implements VideoCoverSegmentPicker.a
{
  private VideoCoverSegmentPicker a;
  private long aCA;
  private long aCB;
  private long aCz;
  private boolean dxn;
  private long mEndTime;
  private WeakReference<a> mListenerRef;
  private int mPlayMode = 0;
  private long mStartTime;
  
  public VideoCoverPickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected int QW()
  {
    return 2131561138;
  }
  
  public void apk()
  {
    super.apk();
    this.mListenerRef = null;
    if (this.a != null)
    {
      this.a.unInit();
      this.a = null;
    }
  }
  
  public void oL(List<Long> paramList)
  {
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.oM(paramList);
    }
  }
  
  public void of(long paramLong)
  {
    this.aCA = paramLong;
    long l;
    if (this.dxn)
    {
      l = 30L;
      if (Math.abs(paramLong - this.aCB) >= l) {
        break label38;
      }
    }
    label38:
    a locala;
    do
    {
      return;
      l = 90L;
      break;
      this.aCB = paramLong;
      locala = null;
      if (this.mListenerRef != null) {
        locala = (a)this.mListenerRef.get();
      }
    } while (locala == null);
    locala.og(paramLong);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561138, this, false);
    }
    addContentView(this.mContentView);
    this.a = ((VideoCoverSegmentPicker)this.mContentView.findViewById(2131366266));
    setPlayMode(this.mPlayMode);
    paramBundle = (TextView)this.mContentView.findViewById(2131364228);
    ((TextView)this.mContentView.findViewById(2131367109)).setOnClickListener(new axxx(this));
    paramBundle.setOnClickListener(new axxy(this));
    if (this.mListenerRef != null)
    {
      paramBundle = (a)this.mListenerRef.get();
      if (paramBundle != null) {
        paramBundle.ePn();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mListenerRef = null;
    if (this.a != null)
    {
      this.a.unInit();
      this.a = null;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setCoverFrameTime(long paramLong)
  {
    if (this.a != null)
    {
      this.aCB = paramLong;
      this.aCz = paramLong;
      this.a.setCoverFrameTime(paramLong);
    }
  }
  
  public void setListener(a parama)
  {
    this.mListenerRef = new WeakReference(parama);
  }
  
  public void setPlayMode(int paramInt)
  {
    this.mPlayMode = paramInt;
    switch (paramInt)
    {
    default: 
      if (this.a != null) {
        this.a.ZK(false);
      }
      break;
    }
    do
    {
      return;
    } while (this.a == null);
    this.a.ZK(true);
  }
  
  public void setUseIFrameVideo(boolean paramBoolean)
  {
    this.dxn = paramBoolean;
  }
  
  public void setVideo(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mEndTime = paramLong2;
    this.mStartTime = paramLong1;
    if (this.a != null) {
      this.a.a(paramString, this.mStartTime, this.mEndTime, paramInt3, paramInt1, paramInt2, paramBoolean1, this, paramBoolean2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aF(long paramLong, boolean paramBoolean);
    
    public abstract void ePn();
    
    public abstract void oM(List<Long> paramList);
    
    public abstract void og(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoCoverPickerProviderView
 * JD-Core Version:    0.7.0.1
 */