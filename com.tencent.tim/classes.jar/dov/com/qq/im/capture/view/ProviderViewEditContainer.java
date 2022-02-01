package dov.com.qq.im.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import axqg;
import ayoo.a;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import rpq;

public class ProviderViewEditContainer
  extends FrameLayout
{
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private VideoCoverPickerProviderView.a jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$a;
  private VideoSegmentPickerProviderView.a jdField_a_of_type_DovComQqImCaptureViewVideoSegmentPickerProviderView$a;
  private axqg c;
  private ProviderView.a d;
  private HashMap<Integer, ProviderView> jx = new HashMap();
  private int mCurrentState = 100;
  private int mType = 0;
  private RelativeLayout oa;
  private int[] uh = { 103, 109, 111, 113 };
  
  public ProviderViewEditContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProviderViewEditContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private ProviderView b(int paramInt)
  {
    switch (paramInt)
    {
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 112: 
    default: 
      return null;
    case 103: 
      return new StaticStickerProviderView(getContext());
    case 109: 
      localObject = new MusicFragmentProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    case 110: 
      localObject = new BgmRecognitionProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    case 111: 
      localObject = new VideoSegmentPickerProviderView(getContext());
      ((ProviderView)localObject).setNeedTabBar(false);
      return localObject;
    }
    Object localObject = new VideoCoverPickerProviderView(getContext());
    ((ProviderView)localObject).setNeedTabBar(false);
    return localObject;
  }
  
  private boolean d(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (this.jx.containsKey(Integer.valueOf(paramInt))) {
      localObject1 = (ProviderView)this.jx.get(Integer.valueOf(paramInt));
    }
    Object localObject2;
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProviderViewEditContainer", 2, new Object[] { "openContainerProviderView view not exsist, id:", Integer.valueOf(paramInt) });
      }
      return false;
      localObject2 = b(paramInt);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.jx.put(Integer.valueOf(paramInt), localObject2);
        addView((View)localObject2);
        localObject1 = localObject2;
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject1);
    switch (paramInt)
    {
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 112: 
    default: 
    case 103: 
    case 109: 
    case 110: 
      for (;;)
      {
        return true;
        localObject1 = (StaticStickerProviderView)localObject1;
        if (!((StaticStickerProviderView)localObject1).isInit())
        {
          ((StaticStickerProviderView)localObject1).onCreate(null);
          ((StaticStickerProviderView)localObject1).setOnFaceSelectedListener(this.c);
        }
        ((StaticStickerProviderView)localObject1).setCaptureScene(this.mType);
        ((StaticStickerProviderView)localObject1).ePl();
        ((StaticStickerProviderView)localObject1).dKI();
        if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
          ((StaticStickerProviderView)localObject1).b((ayoo.a)paramVarArgs[0]);
        }
        paramVarArgs = getLayoutParams();
        paramInt = rpq.dip2px(getContext(), 206.0F);
        if (paramVarArgs.height != paramInt)
        {
          paramVarArgs.height = paramInt;
          setLayoutParams(paramVarArgs);
        }
        this.mCurrentState = 103;
        continue;
        localObject1 = (MusicFragmentProviderView)localObject1;
        if (!((MusicFragmentProviderView)localObject1).isInit())
        {
          ((MusicFragmentProviderView)localObject1).TZ(250);
          ((MusicFragmentProviderView)localObject1).onCreate(null);
          if (this.d != null) {
            ((MusicFragmentProviderView)localObject1).setProviderViewListener(this.d);
          }
        }
        ((MusicFragmentProviderView)localObject1).setCaptureScene(this.mType);
        if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
          ((MusicFragmentProviderView)localObject1).setMusicProviderView((MusicItemInfo)paramVarArgs[0]);
        }
        paramVarArgs = getLayoutParams();
        paramInt = rpq.dip2px(getContext(), 250.0F);
        if (paramVarArgs.height != paramInt)
        {
          paramVarArgs.height = paramInt;
          setLayoutParams(paramVarArgs);
        }
        paramVarArgs = getLayoutParams();
        if (this.oa != null)
        {
          paramVarArgs.height += this.oa.getHeight();
          setLayoutParams(paramVarArgs);
        }
        this.mCurrentState = 109;
        continue;
        paramVarArgs = (BgmRecognitionProviderView)localObject1;
        if (!paramVarArgs.isInit())
        {
          paramVarArgs.TZ(250);
          paramVarArgs.onCreate(null);
          if (this.d != null) {
            paramVarArgs.setProviderViewListener(this.d);
          }
        }
        paramVarArgs.setCaptureScene(this.mType);
        paramVarArgs.dKI();
        paramVarArgs = getLayoutParams();
        paramInt = rpq.dip2px(getContext(), 250.0F);
        if (paramVarArgs.height != paramInt)
        {
          paramVarArgs.height = paramInt;
          setLayoutParams(paramVarArgs);
        }
        this.mCurrentState = 110;
      }
    case 111: 
      localObject1 = (VideoSegmentPickerProviderView)localObject1;
      if (!((VideoSegmentPickerProviderView)localObject1).isInit())
      {
        ((VideoSegmentPickerProviderView)localObject1).setCaptureScene(this.mType);
        ((VideoSegmentPickerProviderView)localObject1).setListener(this.jdField_a_of_type_DovComQqImCaptureViewVideoSegmentPickerProviderView$a);
        ((VideoSegmentPickerProviderView)localObject1).onCreate(null);
      }
      if ((this.oa == null) || (this.oa.getVisibility() != 0)) {
        break;
      }
    }
    for (paramInt = ((VideoSegmentPickerProviderView)localObject1).Ry() + this.oa.getHeight();; paramInt = 0)
    {
      localObject2 = getLayoutParams();
      int i = rpq.dip2px(getContext(), 95.0F);
      if (paramInt > 0) {}
      for (((ViewGroup.LayoutParams)localObject2).height = paramInt;; ((ViewGroup.LayoutParams)localObject2).height = i)
      {
        setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof ayoo.a)))
        {
          ((VideoSegmentPickerProviderView)localObject1).setItems((ayoo.a)paramVarArgs[0]);
          ((VideoSegmentPickerProviderView)localObject1).dKI();
        }
        this.mCurrentState = 111;
        break;
      }
      localObject1 = (VideoCoverPickerProviderView)localObject1;
      if (!((VideoCoverPickerProviderView)localObject1).isInit())
      {
        ((VideoCoverPickerProviderView)localObject1).setCaptureScene(this.mType);
        ((VideoCoverPickerProviderView)localObject1).setListener(this.jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$a);
        ((VideoCoverPickerProviderView)localObject1).onCreate(null);
      }
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof Long))) {
        ((VideoCoverPickerProviderView)localObject1).setCoverFrameTime(((Long)paramVarArgs[0]).longValue());
      }
      paramVarArgs = getLayoutParams();
      i = rpq.dip2px(getContext(), 185.0F);
      paramInt = i;
      if (this.oa != null) {
        paramInt = i + this.oa.getHeight();
      }
      paramVarArgs.height = paramInt;
      setLayoutParams(paramVarArgs);
      this.mCurrentState = 113;
      break;
    }
  }
  
  public ProviderView a(int paramInt)
  {
    if (this.jx.containsKey(Integer.valueOf(paramInt))) {
      return (ProviderView)this.jx.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean aOc()
  {
    if ((this.mCurrentState == 100) || (getVisibility() != 0)) {
      return false;
    }
    if (this.jx == null) {
      return false;
    }
    ProviderView localProviderView = (ProviderView)this.jx.get(Integer.valueOf(this.mCurrentState));
    if (localProviderView != null) {
      return localProviderView.aOc();
    }
    return false;
  }
  
  public void aeQ(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void apk()
  {
    Iterator localIterator = this.jx.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).apk();
    }
  }
  
  public boolean au(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null) && (getVisibility() == 0)) {
      return this.jdField_a_of_type_DovComQqImCaptureViewProviderView.au(paramMotionEvent);
    }
    return false;
  }
  
  public void dLp()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      if ((this.oa != null) && (this.mCurrentState == 111)) {
        setBackgroundColor(2131165397);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.dLs();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.mCurrentState = 100;
  }
  
  public void s(int paramInt, Object... paramVarArgs)
  {
    if (!d(paramInt, paramVarArgs)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_DovComQqImCaptureViewProviderView == null);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
      setVisibility(0);
    } while ((this.oa == null) || (this.mCurrentState != 111));
    setBackgroundColor(0);
  }
  
  public void setLiuHaiParentView(RelativeLayout paramRelativeLayout)
  {
    this.oa = paramRelativeLayout;
  }
  
  public void setProviderViewListener(ProviderView.a parama)
  {
    this.d = parama;
  }
  
  public void setStickerListener(axqg paramaxqg)
  {
    this.c = paramaxqg;
  }
  
  public void setVideoCoverPickerListener(VideoCoverPickerProviderView.a parama)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$a = parama;
  }
  
  public void setVideoSegmentPickerListener(VideoSegmentPickerProviderView.a parama)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewVideoSegmentPickerProviderView$a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ProviderViewEditContainer
 * JD-Core Version:    0.7.0.1
 */