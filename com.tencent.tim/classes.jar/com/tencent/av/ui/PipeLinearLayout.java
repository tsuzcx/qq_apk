package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class PipeLinearLayout
  extends FrameLayout
{
  private final int[] cJ = { 2131374111, 2131374112, 2131374113 };
  private RelativeLayout eh;
  private final ArrayList<Long> iQ = new ArrayList();
  private final ArrayList<Long> iR = new ArrayList();
  private volatile boolean mCancelled;
  private TextView mT;
  private Runnable mTask = new PipeLinearLayout.1(this);
  private Handler mUIHandler;
  private Handler mWorkHandler;
  
  public PipeLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PipeLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PipeLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean aB(long paramLong)
  {
    return false;
  }
  
  private void atw()
  {
    int i = 0;
    while ((i < this.cJ.length) && (i < this.iQ.size()))
    {
      if (aB(((Long)this.iQ.get(i)).longValue())) {
        this.iR.add(this.iQ.get(i));
      }
      i += 1;
    }
  }
  
  private Bitmap b(long paramLong)
  {
    return null;
  }
  
  private String getFriendName()
  {
    return "";
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131559930, this);
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mCancelled = true;
    this.mWorkHandler.removeCallbacks(this.mTask);
    this.mWorkHandler = null;
  }
  
  public void setHeadView(TextView paramTextView)
  {
    this.mT = paramTextView;
    addView(this.mT);
  }
  
  public void setMemberList(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      this.iQ.clear();
      this.iR.clear();
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        Long localLong = paramArrayOfLong[i];
        this.iQ.add(localLong);
        i += 1;
      }
      this.mWorkHandler.removeCallbacks(this.mTask);
      this.mWorkHandler.post(this.mTask);
    }
  }
  
  public void setRelationShipViewParent(RelativeLayout paramRelativeLayout)
  {
    this.eh = paramRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout
 * JD-Core Version:    0.7.0.1
 */