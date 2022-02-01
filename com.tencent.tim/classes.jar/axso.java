import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.qq.im.capture.paster.CaptureComboNormalPaster.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class axso
  extends axpn
  implements IEventReceiver
{
  public static HashMap<String, Drawable> rv = new HashMap();
  private float Eu;
  private float Ev;
  private axso.a a;
  public ayne a;
  private final String cVY;
  private String mName;
  int mState = 2;
  private float mWidthScale;
  
  public axso(ayne paramayne, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.cVY = paramString1;
    this.mName = paramString2;
    this.jdField_a_of_type_Ayne = paramayne;
    this.Eu = paramFloat1;
    this.Ev = paramFloat2;
    this.mWidthScale = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  private static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    new File(paramString).getName();
    URLDrawable localURLDrawable = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
    if (localURLDrawable != null)
    {
      int i = localURLDrawable.getStatus();
      if (i == 1) {
        return localURLDrawable;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "urlDrawable is not  SUCCESSED :" + i);
      }
      localURLDrawable.setURLDrawableListener(paramURLDrawableListener);
      if (i != 2) {
        break label107;
      }
      localURLDrawable.restartDownload();
    }
    for (;;)
    {
      rv.put(paramString, localURLDrawable);
      return null;
      label107:
      localURLDrawable.startDownload();
    }
    return localURLDrawable;
  }
  
  private static void a(Drawable paramDrawable, String paramString1, String paramString2, ayne paramayne, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, axqg paramaxqg, int paramInt3)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      int i = paramDrawable.getIntrinsicWidth();
      paramFloat3 = paramInt1 * paramFloat3 / i;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "applyNormalPaster w=" + i + " scale=" + paramFloat3 + " px=" + paramFloat1 + " py=" + paramFloat2);
      }
      paramaxqg.a(new aykk(paramayne.name, paramString1, paramDrawable, paramInt3), paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, paramString2, paramSegmentKeeper);
      return;
    }
    ram.e("QComboNPaster", "can not create drawable from name:" + paramString1);
  }
  
  public static void a(ayne paramayne, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, axqg paramaxqg)
  {
    if (paramaxqg == null) {
      throw new IllegalStateException("applyNormalPaster listener is null!");
    }
    int i = paramayne.gq(paramString);
    paramString = paramayne.sR(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    try
    {
      rox.fA(paramayne.aAG);
      label43:
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "applyNormalPaster uriString error!");
      }
      for (;;)
      {
        return;
        paramString = Uri.parse(paramString).getPath();
        String str = new File(paramString).getName();
        axsp localaxsp = new axsp(str, paramString, paramayne, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramaxqg, i);
        if (i != 1) {
          try
          {
            a(Drawable.createFromPath(paramString), str, paramString, paramayne, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramaxqg, i);
            return;
          }
          catch (OutOfMemoryError paramayne)
          {
            ram.e("QComboNPaster", "createFromPath error", paramayne);
            return;
          }
        }
        File localFile = new File(paramString);
        try
        {
          if (!ApngDrawable.isApngFile(localFile))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QComboNPaster", 2, "applyNormalPaster isApngFile not valid path=" + paramString);
            return;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          a(a(paramString, localaxsp), str, paramString, paramayne, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, paramaxqg, i);
          return;
        }
      }
    }
    catch (Exception paramayne)
    {
      break label43;
    }
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_Ayne.oT == null) || (this.jdField_a_of_type_Ayne.oT.size() == 0)) {
      this.jdField_a_of_type_Ayne.oQ(this.jdField_a_of_type_Ayne.hY());
    }
    paramActivity = this.jdField_a_of_type_Ayne.sR(this.mName);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "unApply id=" + this.cVY + " name=" + this.mName + "url=" + paramActivity);
    }
    if (TextUtils.isEmpty(paramActivity)) {}
    for (;;)
    {
      return;
      try
      {
        paramActivity = new File(Uri.parse(paramActivity).getPath()).getName();
        DoodleLayout localDoodleLayout = axvy.a().a(paramInt);
        if (localDoodleLayout != null)
        {
          localDoodleLayout.a().jR(this.jdField_a_of_type_Ayne.name, paramActivity);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public String Ie()
  {
    return this.jdField_a_of_type_Ayne.sR(this.mName);
  }
  
  public int Rq()
  {
    try
    {
      ((aykn)psx.a(39)).s(this.cVY, false);
      eNI();
      Dispatcher localDispatcher = pmi.a();
      axso.a locala = new axso.a(this);
      this.jdField_a_of_type_Axso$a = locala;
      localDispatcher.registerSubscriber(locala);
      this.mState = 1;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "create mState=" + this.mState + " id=" + this.cVY);
      }
      int i = this.mState;
      return i;
    }
    finally {}
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_Ayne.oT == null) || (this.jdField_a_of_type_Ayne.oT.size() == 0)) {
      this.jdField_a_of_type_Ayne.oQ(this.jdField_a_of_type_Ayne.hY());
    }
    ThreadManager.excute(new CaptureComboNormalPaster.1(this, paramInt), 64, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "apply id=" + this.cVY + " name=" + this.mName);
    }
    return 0;
  }
  
  public float getProgress()
  {
    float f = 1.0F;
    for (;;)
    {
      try
      {
        if (!aqmr.isEmpty(this.jdField_a_of_type_Ayne.aAG))
        {
          getState();
          return f;
        }
        if ((this.jdField_a_of_type_Ayne.brW != 100.0F) && (this.jdField_a_of_type_Ayne.brW > 0.0F))
        {
          f = this.jdField_a_of_type_Ayne.brX;
          int i = this.jdField_a_of_type_Ayne.brW;
          f = 1.0F * f / i;
        }
        else
        {
          f = 0.0F;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public int getState()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	axso:jdField_a_of_type_Ayne	Layne;
    //   6: getfield 217	ayne:aAG	Ljava/lang/String;
    //   9: invokestatic 359	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   12: ifne +17 -> 29
    //   15: aload_0
    //   16: iconst_3
    //   17: putfield 39	axso:mState	I
    //   20: aload_0
    //   21: getfield 39	axso:mState	I
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: aload_0
    //   30: getfield 45	axso:jdField_a_of_type_Ayne	Layne;
    //   33: getfield 373	ayne:isDownloading	Z
    //   36: ifeq -16 -> 20
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 39	axso:mState	I
    //   44: goto -24 -> 20
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	axso
    //   24	4	1	i	int
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	47	finally
    //   20	25	47	finally
    //   29	44	47	finally
  }
  
  public boolean isValidate()
  {
    return this.mState == 1;
  }
  
  public String toString()
  {
    return "NP@" + this.cVY + "@" + hashCode();
  }
  
  public static class a
    extends QQUIEventReceiver<axso, aykn.a>
  {
    public a(@NonNull axso paramaxso)
    {
      super();
    }
    
    public void a(@NonNull axso paramaxso, @NonNull aykn.a parama)
    {
      if (parama.b.pack_id.equals(axso.b(paramaxso)))
      {
        if (parama.mErrorCode != 0) {
          break label296;
        }
        if (!parama.aBq) {
          break label155;
        }
        ram.d(this.TAG, "notify ui we finish downloading");
        paramaxso.a.isDownloading = false;
        paramaxso.a.aAG = parama.b.getLocalEmojiFolderPath();
        paramaxso.a.brW = 0;
        paramaxso.a.brX = 0;
        paramaxso.mState = 3;
        paramaxso.eNJ();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "download finished id=" + axso.b(paramaxso) + " name=" + axso.a(paramaxso));
        }
        if (axso.a(paramaxso) != null) {
          pmi.a().unRegisterSubscriber(axso.a(paramaxso));
        }
      }
      label155:
      label296:
      do
      {
        do
        {
          return;
          ram.v(this.TAG, "notify ui we new progress : " + parama.Ca + " / " + parama.BZ);
          paramaxso.a.isDownloading = true;
          paramaxso.a.aAG = null;
          paramaxso.a.brW = ((int)parama.BZ);
          paramaxso.a.brX = ((int)parama.Ca);
          paramaxso.mState = 1;
        } while (!QLog.isColorLevel());
        QLog.d(this.TAG, 2, "downloading=" + paramaxso.a.brX + " max=" + paramaxso.a.brW);
        return;
        paramaxso.a.isDownloading = false;
        paramaxso.a.aAG = null;
        paramaxso.a.brW = 0;
        paramaxso.a.brX = 0;
        ram.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parama.mErrorCode);
        ras.so("0X80076C9");
        ras.sp("0X80075DE");
        paramaxso.mState = 2;
        paramaxso.aeD(parama.mErrorCode);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "download error id=" + axso.b(paramaxso) + " name=" + axso.a(paramaxso));
        }
      } while (axso.a(paramaxso) == null);
      pmi.a().unRegisterSubscriber(axso.a(paramaxso));
    }
    
    public Class acceptEventClass()
    {
      return aykn.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axso
 * JD-Core Version:    0.7.0.1
 */