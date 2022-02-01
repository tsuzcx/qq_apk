package com.tencent.mobileqq.apollo.view;

import acbk;
import acbm.c;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class FrameGifView
  extends ImageView
  implements acbm.c
{
  protected acbk a;
  private DecoderRunnable jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable = new DecoderRunnable();
  a jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$a;
  
  public FrameGifView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Acbk = new acbk(this);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Acbk = new acbk(this);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Acbk = new acbk(this);
  }
  
  public void c(int paramInt, Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public void cGU()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$a.onStop();
    }
  }
  
  public void cGV()
  {
    if (this.jdField_a_of_type_Acbk != null) {
      this.jdField_a_of_type_Acbk.cGV();
    }
  }
  
  public int getState()
  {
    if (this.jdField_a_of_type_Acbk != null) {
      return this.jdField_a_of_type_Acbk.getState();
    }
    return 0;
  }
  
  public void setAnimaListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$a = parama;
  }
  
  public void setGifData(int paramInt, Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (getDrawable() == null) {
      super.setImageDrawable(paramDrawable);
    }
    if (this.jdField_a_of_type_Acbk != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable.a(this.jdField_a_of_type_Acbk, paramInt, paramString1, paramString2, paramBoolean);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable);
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView$DecoderRunnable);
    }
  }
  
  public void setPlayLoop(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Acbk != null) {
      this.jdField_a_of_type_Acbk.setPlayLoop(paramBoolean);
    }
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_Acbk != null) {
      this.jdField_a_of_type_Acbk.stop();
    }
  }
  
  static class DecoderRunnable
    implements Runnable
  {
    private acbk b;
    private String bkm;
    private String bkq;
    private boolean mAutoPlay;
    private int mFrameDelay;
    
    public void a(acbk paramacbk, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.mFrameDelay = paramInt;
      this.bkq = paramString1;
      this.bkm = paramString2;
      this.mAutoPlay = paramBoolean;
      this.b = paramacbk;
    }
    
    public void run()
    {
      if (this.b != null) {
        this.b.c(this.mFrameDelay, this.bkq, this.bkm, this.mAutoPlay);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView
 * JD-Core Version:    0.7.0.1
 */