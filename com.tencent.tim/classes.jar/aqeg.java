import AvatarInfo.QQHeadInfo;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.a;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aqeg
  extends FaceDecodeTask
{
  NearbyAppInterface b;
  
  public aqeg(NearbyAppInterface paramNearbyAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.a parama)
  {
    super(paramNearbyAppInterface, paramFaceInfo, parama);
    this.b = paramNearbyAppInterface;
  }
  
  public void edq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap bengin.faceInfo=" + this.a);
    }
    this.a.Xq(FaceInfo.dYH);
    do
    {
      for (;;)
      {
        try
        {
          aqdm localaqdm = (aqdm)this.b.getManager(216);
          if (!localaqdm.a(this.a))
          {
            bool = true;
            this.cTE = bool;
            if (!this.cTE) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap file not exist.. needDownload.faceInfo=" + this.a);
            }
            if (this.a.b != null) {
              localaqdm.e(this.a);
            }
            this.a.Xq(FaceInfo.dYI);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          boolean bool;
          Object localObject3;
          Object localObject2;
          int i;
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap OutOfMemoryError. uin=" + this.a.uin, localOutOfMemoryError);
          this.a.Xq(FaceInfo.dYI);
          try
          {
            tQ.add(this);
            if (g == null) {
              continue;
            }
            g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
            return;
          }
          catch (Exception localException6) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException6);
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap exception. uin=" + this.a.uin, localThrowable);
          this.a.Xq(FaceInfo.dYI);
          try
          {
            tQ.add(this);
            if (g == null) {
              continue;
            }
            g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
            return;
          }
          catch (Exception localException7) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException7);
          return;
        }
        finally
        {
          this.a.Xq(FaceInfo.dYI);
          try
          {
            tQ.add(this);
            if (g != null) {
              g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
            }
            throw localObject1;
          }
          catch (Exception localException8)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException8);
            continue;
          }
          continue;
        }
        try
        {
          tQ.add(this);
          if (g != null) {
            g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
          }
          return;
          bool = false;
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException1);
          return;
        }
        localObject3 = "stranger_" + Integer.toString(this.a.idType) + "_" + this.a.uin;
        localObject2 = localException1.getFaceSetting((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap key=" + (String)localObject3 + ",faceinfo=" + this.a + ",setting=" + localObject2);
        }
        if (localObject2 == null) {
          continue;
        }
        if (this.a.b == null) {
          continue;
        }
        if (this.a.b.dwTimestamp > ((Setting)localObject2).headImgTimestamp)
        {
          this.cTE = true;
          localException1.e(this.a);
          this.a.Xq(FaceInfo.dYI);
          try
          {
            tQ.add(this);
            if (g == null) {
              continue;
            }
            g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
            return;
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException2);
          }
        }
        else
        {
          if (!this.a.cTH) {
            continue;
          }
          localObject3 = (advr)this.b.getManager(180);
          if (!((advr)localObject3).a(((advr)localObject3).a(this.a.idType, this.a.uin), (Setting)localObject2, this.a.aRY)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
          }
          this.cTE = true;
          localException2.e(this.a);
          this.a.Xq(FaceInfo.dYI);
          try
          {
            tQ.add(this);
            if (g != null)
            {
              g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
              return;
            }
          }
          catch (Exception localException3) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException3);
    return;
    if (Math.abs(System.currentTimeMillis() - ((Setting)localObject2).updateTimestamp) > 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap need to checkupdate.faceInfo=" + this.a);
      }
      this.a.bA = 1;
      ((acpp)this.b.getBusinessHandler(4)).c(this.a);
    }
    localObject2 = new aqcu.a();
    localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inPreferredConfig = aqdc.e;
    i = 0;
    do
    {
      aqcu.a(localException3.a(this.a), (BitmapFactory.Options)localObject3, (aqcu.a)localObject2);
      if (((aqcu.a)localObject2).iResult == 1)
      {
        NearbyAppInterface localNearbyAppInterface = this.b;
        NearbyAppInterface.freePartBitmapCache();
      }
      i += 1;
    } while ((i < 2) && (((aqcu.a)localObject2).iResult == 1));
    if ((QLog.isColorLevel()) || (((aqcu.a)localObject2).iResult != 0)) {
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 1, "doDecodeBitmap decode bitmap.faceInfo=" + this.a + ",result=" + ((aqcu.a)localObject2).iResult + ", bmp=" + ((aqcu.a)localObject2).bmp);
    }
    if (((aqcu.a)localObject2).bmp != null) {}
    switch (this.a.shape)
    {
    case 2: 
    case 1: 
    case 3: 
      for (((aqcu.a)localObject2).bmp = aqhu.r(((aqcu.a)localObject2).bmp, 50, 50);; ((aqcu.a)localObject2).bmp = aqhu.getCircleFaceBitmap(((aqcu.a)localObject2).bmp, 50, 50))
      {
        for (;;)
        {
          for (;;)
          {
            this.bitmap = ((aqcu.a)localObject2).bmp;
            localException3.a(this.a.BL(), ((aqcu.a)localObject2).bmp, (byte)1);
            if (this.bitmap == null) {
              QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + this.a.uin);
            }
            this.a.Xq(FaceInfo.dYI);
            try
            {
              tQ.add(this);
              if (g == null) {
                break;
              }
              g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
              return;
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException4);
          return;
          this.cTE = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap setting is null. faceInfo=" + this.a);
          }
          if (this.a.b != null) {
            localException4.e(this.a);
          }
          this.a.Xq(FaceInfo.dYI);
          try
          {
            tQ.add(this);
            if (g == null) {
              break;
            }
            g.sendMessageAtFrontOfQueue(g.obtainMessage(dYu, this));
            return;
          }
          catch (Exception localException5) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqhead.NearByFaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + this.a.uin, localException5);
        return;
      }
    }
  }
  
  public boolean isExpired()
  {
    return this.b == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqeg
 * JD-Core Version:    0.7.0.1
 */