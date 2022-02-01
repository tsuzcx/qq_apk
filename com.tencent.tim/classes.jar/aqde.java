import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.a;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aqde
  extends FaceDecodeTask
{
  QQAppInterface app;
  
  public aqde(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.a parama)
  {
    super(paramQQAppInterface, paramFaceInfo, parama);
    this.app = paramQQAppInterface;
  }
  
  public boolean aBU()
  {
    Object localObject;
    if ((this.a.aRY == 101) || (this.a.aRY == 1001))
    {
      localObject = (acdt)this.app.getBusinessHandler(6);
      if (this.a.aRY == 1001)
      {
        this.bitmap = ((acdt)localObject).f(GroupIconHelper.jy(this.a.uin), false);
        this.cTE = false;
      }
    }
    label244:
    do
    {
      do
      {
        return true;
        this.bitmap = ((acdt)localObject).f(this.a.uin, false);
        break;
        if ((this.a.aRY != 4) && (this.a.aRY != 113)) {
          break label291;
        }
        if (!((HotChatManager)this.app.getManager(60)).kj(this.a.uin)) {
          break label244;
        }
        localObject = this.app.getFaceBitmapCacheKey(this.a.aRY, this.a.uin, (byte)this.a.shape, this.a.idType);
        this.bitmap = this.app.getBitmapFromCache((String)localObject);
      } while (this.bitmap != null);
      int i = HotChatManager.d(this.a.uin, this.app);
      this.bitmap = aqhu.g(BaseApplicationImpl.sApplication.getResources(), i);
      this.app.putBitmapToCache((String)localObject, this.bitmap, (byte)1);
      return true;
      if (!apuh.ra(this.a.uin))
      {
        this.bitmap = ((acms)this.app.getBusinessHandler(20)).h(this.a.uin, false);
        this.cTE = false;
        return true;
      }
      if ((Setting)this.app.getQQHeadSetting(this.a.aRY, this.a.uin, this.a.idType).second != null) {
        break label372;
      }
      this.cTE = true;
    } while (!QLog.isColorLevel());
    label291:
    QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-settingNull, faceInfo=" + this.a.toString());
    return true;
    label372:
    if (!this.app.isFaceFileExist(this.a.aRY, this.a.uin, this.a.idType)) {}
    for (boolean bool = true;; bool = false)
    {
      this.cTE = bool;
      if (!this.cTE) {
        break label461;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap, needdown-fileNotExit, faceInfo=" + this.a.toString());
      return true;
    }
    label461:
    return false;
  }
  
  public void edq()
  {
    this.a.Xq(FaceInfo.dYH);
    for (;;)
    {
      try
      {
        boolean bool = aBU();
        if (!bool) {
          continue;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Pair localPair;
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.a.uin, localOutOfMemoryError);
        this.a.Xq(FaceInfo.dYI);
        try
        {
          if (g == null) {
            continue;
          }
          g.sendMessage(g.obtainMessage(dYu, this));
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException3);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap exception. uin=" + this.a.uin, localThrowable);
        this.a.Xq(FaceInfo.dYI);
        try
        {
          if (g == null) {
            continue;
          }
          g.sendMessage(g.obtainMessage(dYu, this));
          return;
        }
        catch (Exception localException4)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException4);
          return;
        }
      }
      finally
      {
        this.a.Xq(FaceInfo.dYI);
      }
      try
      {
        if (g != null) {
          g.sendMessage(g.obtainMessage(dYu, this));
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException1);
        return;
      }
    }
    if (this.a.aRY != 101)
    {
      localPair = this.app.getQQHeadSetting(this.a.aRY, this.a.uin, this.a.idType);
      if ((localPair == null) || (!((Boolean)localPair.first).booleanValue())) {
        break label326;
      }
      this.a.bA = 1;
      aqdf.a(this.app, this.a);
    }
    for (;;)
    {
      for (;;)
      {
        this.bitmap = this.app.a(this.a.aRY, this.a.uin, (byte)this.a.shape, 100, false, this.a.d(), this.a.idType);
        if ((QLog.isColorLevel()) && (this.bitmap == null)) {
          QLog.d("Q.qqhead.FaceDecodeTaskImpl", 2, "doDecodeBitmap fail. uin=" + this.a.uin);
        }
        this.a.Xq(FaceInfo.dYI);
        try
        {
          if (g == null) {
            break;
          }
          g.sendMessage(g.obtainMessage(dYu, this));
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException2);
          return;
        }
      }
      label326:
      if ((this.a.cTH) && (localException2 != null) && ((this.a.aRY == 1) || (this.a.aRY == 32)))
      {
        advr localadvr = (advr)this.app.getManager(180);
        if (localadvr.a(localadvr.b(this.a.idType, this.a.uin), (Setting)localException2.second, this.a.aRY))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "FaceDecodeTaskImpl isNeed2UpdateSettingInfo.");
          }
          this.a.bA = 1;
          aqdf.a(this.app, this.a);
        }
      }
    }
    try
    {
      if (g != null) {
        g.sendMessage(g.obtainMessage(dYu, this));
      }
      throw localObject;
    }
    catch (Exception localException5)
    {
      for (;;)
      {
        QLog.e("Q.qqhead.FaceDecodeTaskImpl", 1, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException5);
      }
    }
  }
  
  public boolean isExpired()
  {
    return (this.app == null) || (this.app.isReleased);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqde
 * JD-Core Version:    0.7.0.1
 */