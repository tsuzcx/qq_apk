import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.QQGlRender;
import com.tencent.av.opengl.QQGlRender.QQGLRenderListener;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bly
  implements QQGlRender.QQGLRenderListener
{
  public int a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public bly(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  QQGlRender a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  public void a(QQGlRender paramQQGlRender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 41
    //   10: iconst_2
    //   11: new 43	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   18: ldc 46
    //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 19	bly:jdField_a_of_type_Int	I
    //   27: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 19	bly:jdField_a_of_type_Int	I
    //   40: ifne +33 -> 73
    //   43: aload_0
    //   44: getfield 14	bly:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   47: getfield 66	com/tencent/av/ui/VideoLayerUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   50: aload_1
    //   51: invokevirtual 71	com/tencent/av/VideoController:b	(Lcom/tencent/av/opengl/QQGlRender;)V
    //   54: aload_1
    //   55: invokevirtual 74	com/tencent/av/opengl/QQGlRender:requestRender	()V
    //   58: aload_0
    //   59: new 25	java/lang/ref/WeakReference
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 77	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   67: putfield 23	bly:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: getfield 14	bly:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   77: getfield 66	com/tencent/av/ui/VideoLayerUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   80: aload_1
    //   81: invokevirtual 79	com/tencent/av/VideoController:a	(Lcom/tencent/av/opengl/QQGlRender;)V
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual 83	com/tencent/av/opengl/QQGlRender:showBackground	(Z)V
    //   89: goto -31 -> 58
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	bly
    //   0	97	1	paramQQGlRender	QQGlRender
    // Exception table:
    //   from	to	target	type
    //   2	36	92	finally
    //   36	58	92	finally
    //   58	70	92	finally
    //   73	89	92	finally
  }
  
  public void a(QQGlRender paramQQGlRender, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onRenderInfoNotify type = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt3 == 0) || (paramInt3 == 2))
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        paramQQGlRender.SetDisplayMode(false, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b = paramInt3;
      paramInt1 = paramQQGlRender.getGlRotation();
      if ((paramInt1 == 0) || (paramInt1 == 180)) {}
      for (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = false;; this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = true)
      {
        paramQQGlRender.SetDisplayMode(false, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f);
        return;
      }
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      paramQQGlRender.SetDisplayMode(false, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b = paramInt3;
    paramInt1 = paramQQGlRender.getGlRotation();
    if ((paramInt1 == 0) || (paramInt1 == 180)) {}
    for (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = true;; this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f = false)
    {
      paramQQGlRender.SetDisplayMode(false, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f);
      return;
    }
  }
  
  /* Error */
  public void b(QQGlRender paramQQGlRender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 41
    //   10: iconst_2
    //   11: new 43	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   18: ldc 105
    //   20: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 19	bly:jdField_a_of_type_Int	I
    //   27: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 19	bly:jdField_a_of_type_Int	I
    //   40: ifne +27 -> 67
    //   43: aload_0
    //   44: getfield 14	bly:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   47: getfield 66	com/tencent/av/ui/VideoLayerUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   50: ifnull +14 -> 64
    //   53: aload_0
    //   54: getfield 14	bly:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   57: getfield 66	com/tencent/av/ui/VideoLayerUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   60: aconst_null
    //   61: invokevirtual 71	com/tencent/av/VideoController:b	(Lcom/tencent/av/opengl/QQGlRender;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield 14	bly:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   71: getfield 66	com/tencent/av/ui/VideoLayerUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   74: ifnull -10 -> 64
    //   77: aload_0
    //   78: getfield 14	bly:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   81: getfield 66	com/tencent/av/ui/VideoLayerUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   84: aconst_null
    //   85: invokevirtual 79	com/tencent/av/VideoController:a	(Lcom/tencent/av/opengl/QQGlRender;)V
    //   88: goto -24 -> 64
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	bly
    //   0	96	1	paramQQGlRender	QQGlRender
    // Exception table:
    //   from	to	target	type
    //   2	36	91	finally
    //   36	64	91	finally
    //   67	88	91	finally
  }
  
  public void c(QQGlRender paramQQGlRender)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onRenderFlush type = " + this.jdField_a_of_type_Int);
    }
  }
  
  public void d(QQGlRender paramQQGlRender)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.b(paramQQGlRender);
      paramQQGlRender.requestRender();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvVideoController.a(paramQQGlRender);
    paramQQGlRender.requestRender();
  }
  
  public void e(QQGlRender paramQQGlRender)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      paramQQGlRender = new Intent(QQGlRender.SHOW1STFRAME_BROADCAST);
      paramQQGlRender.setPackage(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramQQGlRender);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bly
 * JD-Core Version:    0.7.0.1
 */