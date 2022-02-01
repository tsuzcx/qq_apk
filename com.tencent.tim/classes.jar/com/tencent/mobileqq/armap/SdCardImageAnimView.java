package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class SdCardImageAnimView
  extends ImageView
  implements FrameBmpCache.a
{
  FrameBmpCache.a jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a = null;
  private FrameBmpCache jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache;
  private Runnable aI = new SdCardImageAnimView.1(this);
  public boolean bQY;
  private boolean bQZ;
  private boolean bRa;
  private Bitmap eV;
  private Runnable gd = new SdCardImageAnimView.2(this);
  private boolean hasData;
  
  public SdCardImageAnimView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SdCardImageAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SdCardImageAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void cUA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.stop();
    }
    this.bQZ = false;
    this.bQY = false;
    this.eV = null;
  }
  
  private void cUy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache != null) && (this.bQZ))
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.getCurrentBitmap();
      if (QLog.isColorLevel()) {
        QLog.i("SdCardImageAnimView", 2, "bgUpdate cb=" + localBitmap + ", cbm=" + this.eV);
      }
      if (this.eV != localBitmap)
      {
        this.eV = localBitmap;
        setImageBitmap(this.eV);
      }
      int i = 32;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.fps > 0) {
        i = 1000 / this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.fps;
      }
      this.bQY = true;
      postDelayed(this.aI, i);
    }
  }
  
  private void cUz()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.startDecode();
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.cUw();
    this.bQZ = true;
  }
  
  private void init()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache = new FrameBmpCache(getResources());
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.setEndListener(this);
    new HandlerThread("sub_thread").start();
  }
  
  public void a(SdCardImageAnimView paramSdCardImageAnimView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a.a(this);
    }
  }
  
  public boolean afC()
  {
    if (!this.hasData) {
      return false;
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.gd);
    removeCallbacks(this.aI);
    cUA();
    return true;
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList)
  {
    setAnimationData(paramArrayList, false);
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    setAnimationData(paramArrayList, paramBoolean, false);
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {}
    for (this.hasData = true;; this.hasData = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.setRepeat(paramBoolean1);
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.GK(paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.jD(paramArrayList);
      return;
    }
  }
  
  public void setDefaultImg()
  {
    ThreadManager.getSubThreadHandler().post(this.gd);
  }
  
  public void setEndListener(FrameBmpCache.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache$a = parama;
  }
  
  public void setFPS(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.setFps(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.bRa = afC();
    }
    while (!this.bRa) {
      return;
    }
    startAnim();
  }
  
  public void startAnim()
  {
    if (!this.hasData)
    {
      QLog.i("SdCardImageAnimView", 1, "startAnim has no data, return ");
      return;
    }
    if (this.bQZ)
    {
      QLog.i("SdCardImageAnimView", 1, "startAnim isAnimStarted, return");
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.gd);
    removeCallbacks(this.aI);
    cUz();
    post(this.aI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SdCardImageAnimView
 * JD-Core Version:    0.7.0.1
 */