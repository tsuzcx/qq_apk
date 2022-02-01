import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class aqcy
{
  public static long asy;
  public static boolean cTz;
  public static int[] oR = { 2, 3, 5, 0, 4, 6, 1 };
  public static Object sPauseLock = new Object();
  public URLDrawable N;
  public advr b;
  public boolean bRs;
  public WeakReference<DynamicAvatarView> bb;
  public WeakReference<aqcy> bc;
  public boolean cTA;
  public boolean cTB;
  public boolean cTC;
  public boolean cTD;
  public boolean cTy = true;
  public int csn;
  public int dYr;
  public int dYs;
  public int dYt;
  public Drawable fR;
  public String mBigUrl;
  public String mId;
  public String mKey;
  public int mSource;
  public String mUrl;
  
  public aqcy() {}
  
  public aqcy(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.fR = new aqdk(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean4);; this.fR = new aqeh(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean4))
    {
      this.bc = new WeakReference(this);
      a(paramBoolean4, null);
      return;
    }
  }
  
  public aqcy(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 0, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
    this.bc = new WeakReference(this);
    a(paramBoolean3, paramDynamicAvatar);
  }
  
  public static void D(AppInterface paramAppInterface)
  {
    synchronized (sPauseLock)
    {
      cTz = true;
      AbstractVideoImage.pauseAll();
      paramAppInterface = (advr)paramAppInterface.getManager(180);
      if (paramAppInterface != null)
      {
        paramAppInterface.pauseAll();
        ThreadManager.getSubThreadHandler().removeCallbacks(paramAppInterface.ge);
      }
      return;
    }
  }
  
  public static void E(AppInterface paramAppInterface)
  {
    int i;
    if (asy <= 0L)
    {
      i = aqgz.getCpuNumber();
      if (i < 8) {
        break label50;
      }
      asy = 100L;
    }
    for (;;)
    {
      paramAppInterface = (advr)paramAppInterface.getManager(180);
      ThreadManager.getSubThreadHandler().postDelayed(paramAppInterface.ge, asy);
      return;
      label50:
      if (i >= 4) {
        asy = 200L;
      } else if (i >= 3) {
        asy = 400L;
      } else if (i >= 2) {
        asy = 800L;
      } else {
        asy = 1000L;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DynamicAvatar paramDynamicAvatar, boolean paramBoolean5)
  {
    this.mId = paramString;
    this.csn = paramInt4;
    this.mSource = paramInt5;
    this.cTB = paramBoolean3;
    this.cTA = paramBoolean4;
    this.cTD = paramBoolean2;
    this.fR = paramDrawable;
    if (paramInt2 == 200)
    {
      this.dYs = 17;
      if (paramInt1 != 32) {
        break label144;
      }
    }
    label144:
    for (this.dYr = 18;; this.dYr = 17)
    {
      this.dYt = paramInt3;
      this.bRs = paramBoolean1;
      this.mUrl = "";
      this.mBigUrl = "";
      this.cTC = false;
      this.mKey = advr.b(paramInt1, paramInt2, paramString, paramInt3);
      if (!paramBoolean5) {
        this.N = null;
      }
      this.b = ((advr)paramAppInterface.getManager(180));
      return;
      this.dYs = 18;
      break;
    }
  }
  
  public void a(boolean paramBoolean, DynamicAvatar paramDynamicAvatar)
  {
    this.b.a(this);
    if ((paramBoolean) && (this.b.iQ(this.mSource)))
    {
      paramBoolean = true;
      this.cTy = paramBoolean;
      if (this.cTy) {
        break label46;
      }
    }
    label46:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
      } while ((!this.cTD) && (!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) && (this.cTB));
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "getDynamicAvatar uin: " + this.mId + " source: " + this.mSource);
      }
      if ((this.cTD) || (paramDynamicAvatar == null))
      {
        this.b.b(this);
        return;
      }
      if (paramDynamicAvatar != null)
      {
        this.mUrl = advr.a(this.dYr, this.dYt, paramDynamicAvatar);
        this.mBigUrl = advr.a(this.dYr, 640, paramDynamicAvatar);
        if ((this.cTA) && (TextUtils.isEmpty(this.mUrl)))
        {
          this.mUrl = advr.a(17, this.dYt, paramDynamicAvatar);
          this.mBigUrl = advr.a(17, 640, paramDynamicAvatar);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
          this.cTC = true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "initValue url: " + this.mUrl);
        }
      }
    } while (TextUtils.isEmpty(this.mUrl));
    this.b.b(this);
  }
  
  public boolean aBS()
  {
    return getCurrDrawable() == this.N;
  }
  
  public boolean aBT()
  {
    if ((this.bb == null) || (this.bb.get() == null)) {
      return false;
    }
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)this.bb.get();
    if (localDynamicAvatarView.b != this)
    {
      QLog.e("Q.dynamicAvatar", 1, "mDynamicFaceDrawable is changed : " + this + " " + localDynamicAvatarView.b);
      return false;
    }
    return true;
  }
  
  public boolean b(URLDrawable paramURLDrawable)
  {
    if (!aBT()) {
      return false;
    }
    if (this.mUrl.equals(((DynamicAvatarView)this.bb.get()).YP))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setVideoDrawable url equals currentUrl");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "truly setVideoDrawable");
    }
    ((DynamicAvatarView)this.bb.get()).YP = this.mUrl;
    this.N = paramURLDrawable;
    if (!cTz)
    {
      edp();
      return true;
    }
    return false;
  }
  
  public void edp()
  {
    if (!aBT()) {}
    while (this.bb.get() == null) {
      return;
    }
    ((DynamicAvatarView)this.bb.get()).cUN();
  }
  
  public Drawable getCurrDrawable()
  {
    if (this.cTy)
    {
      if (this.N == null) {
        return this.fR;
      }
      return this.N;
    }
    return this.fR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcy
 * JD-Core Version:    0.7.0.1
 */