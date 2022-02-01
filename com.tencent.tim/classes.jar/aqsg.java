import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.avatar.IdleGetDynamic;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader.1;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class aqsg
  implements aqrg.a<String>
{
  private static IdleGetDynamic a = new IdleGetDynamic();
  private static final Drawable fT = new ColorDrawable(16777215);
  public String bZz;
  public boolean cVM;
  public Drawable dQ = fT;
  public int faceId;
  public WeakReference<VasAvatar> iu;
  public int mSource;
  public String uin;
  public long uniseq;
  
  public aqsg(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    this.faceId = paramInt1;
    this.cVM = paramBoolean;
    this.bZz = paramString;
    this.mSource = paramInt2;
  }
  
  public aqsg(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this.uin = paramString1;
    this.uniseq = paramLong;
    this.bZz = paramString2;
    this.mSource = paramInt;
  }
  
  public void B(String paramString, Object paramObject)
  {
    if (paramObject == fT) {
      ST(true);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramString == null)
        {
          QLog.e("Q.qqhead.VasFaceManager", 1, "VasAvatar get null path");
          return;
        }
      } while ((this.mSource == -1) && (aqnl.qR()));
      localObject = (VasAvatar)this.iu.get();
    } while ((localObject == null) || (((VasAvatar)localObject).a != this));
    try
    {
      paramObject = new URL("vasapngdownloader", paramString, "-vas-face-");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mUseMemoryCache = true;
      localURLDrawableOptions.mMemoryCacheKeySuffix = Long.toString(this.uniseq);
      localObject = ((VasAvatar)localObject).dQ;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mExtraInfo = VasFaceManager.a(this.cVM);
      VasFaceManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(paramObject, localURLDrawableOptions);
      paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
      ThreadManager.getUIHandler().post(new VasAvatarLoader.1(this, paramObject));
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getApngDrawable ApngImage err, path:" + paramString, paramObject);
    }
  }
  
  public void ST(boolean paramBoolean)
  {
    Object localObject1 = (VasAvatar)this.iu.get();
    if ((localObject1 == null) || (((VasAvatar)localObject1).a != this)) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject1 instanceof QQAppInterface));
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = ((aqrc)((QQAppInterface)localObject2).getManager(235)).a;
      if (this.faceId > 0)
      {
        ((VasFaceManager)localObject1).a(this.faceId, this.bZz, this, null);
        return;
      }
      localObject2 = ((QQAppInterface)localObject2).a(this.uin, paramBoolean);
      if ((localObject2 == null) || (((ExtensionInfo)localObject2).faceIdUpdateTime == 0L))
      {
        ((VasFaceManager)localObject1).b(this.uin, this, fT);
        return;
      }
    } while (((ExtensionInfo)localObject2).faceId <= 0);
    ((VasFaceManager)localObject1).a(((ExtensionInfo)localObject2).faceId, this.bZz, this, null);
  }
  
  public void a(VasAvatar paramVasAvatar)
  {
    this.iu = new WeakReference(paramVasAvatar);
    if (this.mSource == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.VasFaceManager", 2, "delay getAvatar uin: " + this.uin);
      }
      a.a(this);
      return;
    }
    ST(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsg
 * JD-Core Version:    0.7.0.1
 */