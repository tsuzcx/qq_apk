package dov.com.qq.im.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import axxz;
import axya;
import ayoo.a;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker.a;
import java.lang.ref.WeakReference;
import java.util.List;
import rpq;

public class VideoSegmentPickerProviderView
  extends ProviderView
  implements SegmentPicker.a
{
  private ayoo.a jdField_a_of_type_Ayoo$a;
  private SegmentPicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker;
  private long mEndTime;
  private WeakReference<a> mListenerRef;
  private long mStartTime;
  
  public VideoSegmentPickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void oN(List<Pair<Long, Long>> paramList)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.setRanges(paramList);
    }
  }
  
  protected int QW()
  {
    return 2131561139;
  }
  
  public int Ry()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mContentView.findViewById(2131379560).getLayoutParams();
    int i = rpq.dip2px(getContext(), 22.0F);
    return localLayoutParams.topMargin + i;
  }
  
  public void apk()
  {
    super.apk();
    this.mListenerRef = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.unInit();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = null;
    }
    this.jdField_a_of_type_Ayoo$a = null;
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
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.og(paramLong);
    }
  }
  
  public void oh(long paramLong)
  {
    a locala = null;
    if (this.mListenerRef != null) {
      locala = (a)this.mListenerRef.get();
    }
    if (locala != null) {
      locala.oi(paramLong);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561139, this, false);
    }
    addContentView(this.mContentView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = ((SegmentPicker)this.mContentView.findViewById(2131366266));
    this.mContentView.findViewById(2131364038).setOnClickListener(new axxz(this));
    this.mContentView.findViewById(2131364039).setOnClickListener(new axya(this));
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
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.unInit();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker = null;
    }
    this.jdField_a_of_type_Ayoo$a = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setItems(ayoo.a parama)
  {
    this.jdField_a_of_type_Ayoo$a = parama;
    if (this.jdField_a_of_type_Ayoo$a != null)
    {
      this.jdField_a_of_type_Ayoo$a.mSegmentKeeper.changeNormalMode(this.mEndTime - this.mStartTime);
      oN(this.jdField_a_of_type_Ayoo$a.mSegmentKeeper.getSegmentList());
    }
  }
  
  public void setListener(a parama)
  {
    this.mListenerRef = new WeakReference(parama);
  }
  
  public void setPlayMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.ZK(false);
      }
      break;
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.ZK(true);
  }
  
  public void setVideo(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mEndTime = paramLong2;
    this.mStartTime = paramLong1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoSegmentPicker.a(paramString, this.mStartTime, this.mEndTime, paramInt3, paramInt1, paramInt2, paramBoolean1, this, paramBoolean2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aS(long paramLong1, long paramLong2);
    
    public abstract void ePn();
    
    public abstract void oM(List<Long> paramList);
    
    public abstract void og(long paramLong);
    
    public abstract void oi(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.VideoSegmentPickerProviderView
 * JD-Core Version:    0.7.0.1
 */