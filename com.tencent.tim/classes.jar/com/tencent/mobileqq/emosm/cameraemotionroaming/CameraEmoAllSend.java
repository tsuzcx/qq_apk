package com.tencent.mobileqq.emosm.cameraemotionroaming;

import acef;
import acon;
import axol;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CameraEmoAllSend
  extends LinearGroup
  implements acon
{
  public static boolean bXW;
  public static boolean bXX;
  private boolean bXY;
  private int cQN;
  private int cQO;
  private List<CustomEmotionBase> jl;
  private int repeatCount;
  private int successCount;
  
  public AsyncStep a(CustomEmotionBase paramCustomEmotionBase)
  {
    CameraEmoSingleSend localCameraEmoSingleSend = null;
    if ((paramCustomEmotionBase instanceof CameraEmotionData)) {
      localCameraEmoSingleSend = new CameraEmoSingleSend((CameraEmotionData)paramCustomEmotionBase, false);
    }
    while (!(paramCustomEmotionBase instanceof CustomEmotionData)) {
      return localCameraEmoSingleSend;
    }
    paramCustomEmotionBase = new FavEmoSingleSend((CustomEmotionData)paramCustomEmotionBase, false);
    paramCustomEmotionBase.a = this;
    return paramCustomEmotionBase;
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    if ((this.bXY) && ((paramAsyncStep instanceof FavEmoSingleSend)) && (((FavEmoSingleSend)paramAsyncStep).isSuccess)) {
      this.successCount += 1;
    }
  }
  
  public void h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    acef localacef = (acef)((QQAppInterface)axol.getAppInterface()).getBusinessHandler(72);
    if ((paramInt3 < paramInt2) || ((paramInt4 > 0) && (paramInt5 > 0))) {
      if (paramInt3 == 0) {
        paramInt1 = 5;
      }
    }
    for (;;)
    {
      localacef.notifyUI(2, false, Integer.valueOf(paramInt1));
      return;
      paramInt1 = 6;
      continue;
      if (paramInt4 > 0)
      {
        if (paramInt4 == paramInt1) {
          paramInt1 = 1;
        } else {
          paramInt1 = 2;
        }
      }
      else if (paramInt5 > 0)
      {
        if (paramInt5 == paramInt1) {
          paramInt1 = 3;
        } else {
          paramInt1 = 4;
        }
      }
      else {
        paramInt1 = 0;
      }
    }
  }
  
  public int od()
  {
    Iterator localIterator;
    if (!this.jl.isEmpty()) {
      localIterator = this.jl.iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (CustomEmotionBase)localIterator.next();
        if (this.mResult != 8) {
          break label126;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraEmoAllSend", 1, new Object[] { "doStep interrupted, index:", Integer.valueOf(this.jl.indexOf(localObject)) });
        }
      }
      if (this.bXY) {
        h(this.cQN, this.jl.size(), this.successCount, this.cQO, this.repeatCount);
      }
      return 7;
      label126:
      Object localObject = a((CustomEmotionBase)localObject);
      if (localObject != null) {
        ((AsyncStep)localObject).run();
      }
    }
  }
  
  public void onCreate()
  {
    this.jl = ((List)this.mParams[0]);
    if (!this.jl.isEmpty())
    {
      if (!(this.jl.get(0) instanceof CameraEmotionData)) {
        break label82;
      }
      bXW = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoAllSend", 1, new Object[] { "onCreate, size:", Integer.valueOf(this.jl.size()) });
      }
      return;
      label82:
      if ((this.jl.get(0) instanceof CustomEmotionData))
      {
        bXX = false;
        this.bXY = true;
        this.cQN = ((Integer)this.mParams[1]).intValue();
        this.cQO = ((Integer)this.mParams[2]).intValue();
        this.repeatCount = ((Integer)this.mParams[3]).intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend
 * JD-Core Version:    0.7.0.1
 */