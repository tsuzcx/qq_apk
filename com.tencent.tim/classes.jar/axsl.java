import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.paster.CaptureComboInformationPaster.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.HashMap;

public class axsl
  extends axpn
  implements ayna.b, IEventReceiver
{
  public static HashMap<String, Drawable> rv = new HashMap();
  private float Eu;
  private float Ev;
  private axsl.a jdField_a_of_type_Axsl$a;
  private axsz jdField_a_of_type_Axsz;
  private ayna.c jdField_a_of_type_Ayna$c;
  ayna jdField_a_of_type_Ayna;
  private final String cVY;
  private String cVZ;
  private String cWa;
  private String cWb;
  int mState = 2;
  private float mWidthScale;
  
  public axsl(ayna paramayna, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.cVY = paramString2;
    this.jdField_a_of_type_Ayna = paramayna;
    this.mWidthScale = paramFloat3;
    this.cVZ = paramString3;
    this.Eu = paramFloat1;
    this.Ev = paramFloat2;
    this.jdField_a_of_type_Axsz = ((axsz)axov.a().c(12));
    this.jdField_a_of_type_Ayna$c = this.jdField_a_of_type_Ayna.a(paramString3);
    this.cWa = paramString1;
    if (this.jdField_a_of_type_Ayna$c != null)
    {
      this.jdField_a_of_type_Ayna$c.a(this);
      this.cWb = ("CaptureComboInformationPaster_" + this.jdField_a_of_type_Ayna$c.cWb + "_" + this.jdField_a_of_type_Ayna$c.posterId);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "package id=" + paramString2 + " posterId=" + paramString3);
    }
  }
  
  private void a(Drawable paramDrawable, String paramString, int paramInt, axqg paramaxqg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster w=" + paramDrawable.getIntrinsicWidth() + " px=" + this.Eu + " py=" + this.Ev + " scale=" + this.mWidthScale);
    }
    paramDrawable = new aykk(this.jdField_a_of_type_Ayna.name, this.cWb, paramDrawable, paramInt);
    paramInt = azbx.SCREEN_WIDTH;
    int i = azbx.cIE;
    float f1 = paramInt;
    float f2 = this.Eu;
    float f3 = i;
    paramaxqg.b(paramDrawable, f2 * f1, this.Ev * f3, this.mWidthScale, paramString, this.mSegmentKeeper);
  }
  
  private void a(ayna.c paramc, axqg paramaxqg)
  {
    int i = 7;
    Object localObject3 = null;
    Object localObject1 = axsz.b(paramc);
    int j;
    if (paramc.eKF == 8)
    {
      j = Calendar.getInstance().get(7) - 1;
      if (j != 0) {
        break label362;
      }
    }
    label279:
    label311:
    label323:
    label362:
    for (;;)
    {
      for (paramc = (String)localObject1 + File.separator + i + ".apng";; paramc = (String)localObject1 + File.separator + "city" + ".apng")
      {
        localObject1 = new File(paramc);
        try
        {
          if (ApngDrawable.isApngFile((File)localObject1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CaptureComboInformationPaster", 2, "applyNormalPaster isApngFile not valid path=" + paramc);
          }
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          URLDrawable localURLDrawable = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), paramc, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
          Object localObject2 = localObject3;
          if (localURLDrawable == null) {
            break label279;
          }
          i = localURLDrawable.getStatus();
          if (i == 1) {
            break label323;
          }
          if (!QLog.isColorLevel()) {
            break label238;
          }
          QLog.e("CaptureComboInformationPaster", 2, "urlDrawable is not  SUCCESSED :" + i);
          localURLDrawable.setURLDrawableListener(new axsm(this, paramc, localURLDrawable, paramaxqg));
          rv.put(paramc, localURLDrawable);
          if (i != 2) {
            break label311;
          }
          localURLDrawable.restartDownload();
          localObject2 = localObject3;
          while (localObject2 != null)
          {
            localObject2.setBounds(0, 0, localObject2.getIntrinsicWidth(), localObject2.getIntrinsicHeight());
            a(localObject2, paramc, 1, paramaxqg);
            return;
            localURLDrawable.startDownload();
            localObject2 = localObject3;
            continue;
            localObject2 = localURLDrawable;
          }
          ram.e("CaptureComboInformationPaster", "can not create drawable from name:" + this.jdField_a_of_type_Ayna.name);
          return;
        }
      }
      label238:
      i = j;
    }
  }
  
  private void a(DoodleLayout paramDoodleLayout, axqg paramaxqg)
  {
    if (this.jdField_a_of_type_Ayna$c.eKF == 8)
    {
      if (paramDoodleLayout != null) {
        ThreadManager.excute(new CaptureComboInformationPaster.1(this, paramaxqg), 16, null, true);
      }
      return;
    }
    int i = azbx.SCREEN_WIDTH;
    int j = azbx.cIE;
    paramDoodleLayout = this.jdField_a_of_type_Ayna$c;
    String str = this.cWb;
    float f1 = i;
    float f2 = this.Eu;
    float f3 = j;
    paramaxqg.a(paramDoodleLayout, str, f2 * f1, this.Ev * f3, this.mWidthScale);
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_Ayna$c != null)
    {
      paramActivity = axvy.a().a(paramInt);
      if (paramActivity != null) {
        paramActivity.a().jR(this.jdField_a_of_type_Ayna.name, this.cWb);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboInformationPaster", 2, "unApply id=" + this.cVY + " name=" + this.cVZ + " state=" + this.mState);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboInformationPaster", 2, "unApply no item =" + this.cVZ);
      }
    }
  }
  
  /* Error */
  public int Rq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	axsl:jdField_a_of_type_Ayna$c	Layna$c;
    //   6: ifnull +103 -> 109
    //   9: aload_0
    //   10: getfield 321	axsl:jdField_a_of_type_Axsl$a	Laxsl$a;
    //   13: ifnonnull +15 -> 28
    //   16: aload_0
    //   17: new 10	axsl$a
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 324	axsl$a:<init>	(Laxsl;)V
    //   25: putfield 321	axsl:jdField_a_of_type_Axsl$a	Laxsl$a;
    //   28: aload_0
    //   29: getfield 70	axsl:jdField_a_of_type_Axsz	Laxsz;
    //   32: aload_0
    //   33: getfield 77	axsl:jdField_a_of_type_Ayna$c	Layna$c;
    //   36: aload_0
    //   37: getfield 321	axsl:jdField_a_of_type_Axsl$a	Laxsl$a;
    //   40: invokevirtual 327	axsz:a	(Layna$c;Laxsz$a;)V
    //   43: aload_0
    //   44: invokevirtual 330	axsl:eNI	()V
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 45	axsl:mState	I
    //   52: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +45 -> 100
    //   58: ldc 113
    //   60: iconst_2
    //   61: new 86	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 332
    //   71: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: getfield 45	axsl:mState	I
    //   78: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: ldc_w 334
    //   84: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 47	axsl:cVY	Ljava/lang/String;
    //   91: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: getfield 45	axsl:mState	I
    //   104: istore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: iload_1
    //   108: ireturn
    //   109: aload_0
    //   110: iconst_4
    //   111: invokevirtual 338	axsl:aeD	(I)V
    //   114: goto -14 -> 100
    //   117: astore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	axsl
    //   104	4	1	i	int
    //   117	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	117	finally
    //   28	100	117	finally
    //   100	105	117	finally
    //   109	114	117	finally
  }
  
  public void YX(boolean paramBoolean)
  {
    if (!paramBoolean) {
      aeD(0);
    }
  }
  
  public void aeD(int paramInt)
  {
    this.mState = 2;
    super.aeD(paramInt);
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    paramActivity = axvy.a().a(paramInt);
    if ((paramActivity != null) && (this.jdField_a_of_type_Ayna$c != null))
    {
      axqg localaxqg = paramActivity.a();
      if (localaxqg != null)
      {
        a(paramActivity, localaxqg);
        if (QLog.isColorLevel()) {
          QLog.d("CaptureComboInformationPaster", 2, "apply id=" + this.cVY + " name=" + this.cVZ + " state=" + this.mState);
        }
      }
    }
    return 0;
  }
  
  public void eOL()
  {
    if ((this.jdField_a_of_type_Ayna$c == null) || (this.jdField_a_of_type_Ayna$c.eKF != 7)) {}
    axpr localaxpr;
    axqc localaxqc;
    do
    {
      return;
      localaxpr = (axpr)axov.a(5);
      localaxqc = localaxpr.a(this.cWa);
    } while (localaxqc == null);
    localaxqc.getState();
    localaxpr.b(localaxqc);
  }
  
  /* Error */
  public float getProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 321	axsl:jdField_a_of_type_Axsl$a	Laxsl$a;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 321	axsl:jdField_a_of_type_Axsl$a	Laxsl$a;
    //   13: invokevirtual 366	axsl$a:getProgress	()F
    //   16: fstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: fload_1
    //   20: freturn
    //   21: fconst_1
    //   22: fstore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	axsl
    //   16	7	1	f	float
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int getState()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ayna$c != null)
        {
          if (this.jdField_a_of_type_Axsz.a(this.jdField_a_of_type_Ayna$c)) {
            this.mState = 3;
          }
        }
        else
        {
          int i = this.mState;
          return i;
        }
        if (this.jdField_a_of_type_Axsz.c(this.jdField_a_of_type_Ayna$c)) {
          this.mState = 1;
        } else {
          this.mState = 2;
        }
      }
      finally {}
    }
  }
  
  public boolean isValidate()
  {
    return this.mState == 1;
  }
  
  public String toString()
  {
    return "NP@" + this.cVY + "@" + hashCode();
  }
  
  static class a
    implements axsz.a
  {
    private float mProgress;
    private WeakReference<axsl> mRef;
    
    public a(axsl paramaxsl)
    {
      this.mRef = new WeakReference(paramaxsl);
    }
    
    public void a(float paramFloat, String paramString, int paramInt)
    {
      this.mProgress = paramFloat;
    }
    
    public void a(boolean paramBoolean, String paramString, ayna.c paramc)
    {
      if (paramBoolean)
      {
        this.mProgress = 1.0F;
        if (this.mRef.get() != null) {
          ((axsl)this.mRef.get()).eNJ();
        }
      }
      do
      {
        return;
        this.mProgress = 0.0F;
      } while (this.mRef.get() == null);
      ((axsl)this.mRef.get()).aeD(0);
    }
    
    public float getProgress()
    {
      return this.mProgress;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsl
 * JD-Core Version:    0.7.0.1
 */