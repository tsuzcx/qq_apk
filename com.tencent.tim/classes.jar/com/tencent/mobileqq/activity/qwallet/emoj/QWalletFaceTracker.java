package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import irl;
import irl.a;
import irl.b;
import java.util.Iterator;
import java.util.List;

public class QWalletFaceTracker
{
  public static final String TAG = QWalletFaceTracker.class.getSimpleName();
  public static volatile QWalletFaceTracker sInstance;
  public List<ExpressionInfo> expressionItemList;
  public volatile boolean hasSDkInit;
  public boolean hasSoInit;
  private QQFilterRenderManager mQQFilterRenderManager;
  public String[] modelPathsAlign = { "align.stb", "align583.rpdm", "align583_bin.rpdc", "eye.rpdm", "eye_bin.rpdc", "eyebrow.rpdm", "eyebrow_bin.rpdc", "mouth.rpdm", "mouth_bin.rpdc", "refine1.rmd", "refine2.rmd" };
  public String[] modelPathsDetector = { "net_1_bin.rpnproto", "net_1.rpnmodel", "net_2_bin.rpnproto", "net_2.rpnmodel", "net_3_bin.rpnproto", "net_3.rpnmodel" };
  public String[] modelPathsPose = { "meshBasis.bin", "rotBasis.bin", "pdm.txt", "pdm_82.txt" };
  private long nativePtr;
  public irl.a normalFaceExpression;
  public final String[] soFileNames = { "libYTIllumination.so", "libfacetrackwrap.so" };
  public final String[] soNames = { "YTIllumination", "facetrackwrap" };
  
  private boolean checkMoreLikeNormalFaceExpression(float paramFloat, double paramDouble, double[] paramArrayOfDouble, int[] paramArrayOfInt, irl.a parama, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    parama.expressionWeight = paramArrayOfDouble;
    parama.cB = paramArrayOfInt;
    return irl.a(parama, paramList, paramArrayOfFloat).score * paramDouble - paramFloat > 0.0D;
  }
  
  public static QWalletFaceTracker getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QWalletFaceTracker();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void init(Context paramContext, String paramString, IBaseRecognizer paramIBaseRecognizer)
  {
    for (;;)
    {
      try
      {
        this.mQQFilterRenderManager = EffectsCameraCaptureView.b();
        if (this.mQQFilterRenderManager != null) {
          this.mQQFilterRenderManager.setFaceDetectFlags(true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[init] configPath=" + paramString + ",baseRecognizer=" + paramIBaseRecognizer);
        }
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        this.hasSDkInit = true;
        if (this.expressionItemList == null) {
          this.expressionItemList = FaceDetector.getInstance().parseExpressionConfigFromJson(paramContext, paramString, "expression");
        }
        if ((this.normalFaceExpression == null) && (this.expressionItemList != null) && (this.expressionItemList.size() > 0))
        {
          paramContext = this.expressionItemList.iterator();
          if (paramContext.hasNext())
          {
            paramString = (ExpressionInfo)paramContext.next();
            if (!paramString.expressionItem.expressionID.equals("99")) {
              continue;
            }
            this.normalFaceExpression = paramString.expressionItem;
          }
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e(TAG, 1, " occur an error: " + paramContext);
        this.hasSDkInit = false;
        continue;
      }
      finally {}
      if (paramIBaseRecognizer != null) {
        paramIBaseRecognizer.OnInitResultCallback(this.hasSDkInit);
      }
      return;
      this.hasSDkInit = false;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "configPath invalid");
      }
    }
  }
  
  /* Error */
  public void onPreviewFrameHandler(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 204	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker:hasSDkInit	Z
    //   6: ifne +22 -> 28
    //   9: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +13 -> 25
    //   15: getstatic 48	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker:TAG	Ljava/lang/String;
    //   18: iconst_2
    //   19: ldc_w 266
    //   22: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 268	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$1
    //   31: dup
    //   32: aload_0
    //   33: iload 5
    //   35: iload_2
    //   36: aload 6
    //   38: invokespecial 271	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$1:<init>	(Lcom/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker;IILcom/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$OnPreviewFrameHandlerListener;)V
    //   41: bipush 16
    //   43: aconst_null
    //   44: iconst_1
    //   45: invokestatic 277	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   48: goto -23 -> 25
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	QWalletFaceTracker
    //   0	56	1	paramArrayOfByte	byte[]
    //   0	56	2	paramInt1	int
    //   0	56	3	paramInt2	int
    //   0	56	4	paramInt3	int
    //   0	56	5	paramInt4	int
    //   0	56	6	paramOnPreviewFrameHandlerListener	OnPreviewFrameHandlerListener
    // Exception table:
    //   from	to	target	type
    //   2	25	51	finally
    //   28	48	51	finally
  }
  
  public void unInit() {}
  
  public static class ExpressionInfo
  {
    public double coolValue;
    public irl.a expressionItem;
    public int perfectValue;
  }
  
  public static class FaceStatus
  {
    public double illumination_score;
    public float pitch;
    public float[] pointsVis;
    public float roll;
    public float[] xys;
    public float yaw;
  }
  
  public static class FaceStatus3d
  {
    public float[] denseFaceModel;
    public float[] expression;
    public float pitch;
    public float roll;
    public float[] transform;
    public float yaw;
  }
  
  public static abstract interface OnPreviewFrameHandlerListener
  {
    public abstract void getFaceRecognizeResult(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker
 * JD-Core Version:    0.7.0.1
 */