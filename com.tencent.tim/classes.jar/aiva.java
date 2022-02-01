import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aiva
  implements aiqr.a
{
  aiva(aiuz paramaiuz) {}
  
  public void a(LocationRoom.b paramb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramb + " mRoomKey: " + aiuz.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).show();
  }
  
  public void a(LocationRoom.b paramb, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramb, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramb.equals(aiuz.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramb = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramb == null) || (paramb.isFinishing()));
      airk.bV(paramb);
      return;
    } while ((paramInt1 != 10101) || (paramb == null) || (paramb.isFinishing()));
    airk.bW(paramb);
  }
  
  public void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList)
  {
    if (!paramb.equals(aiuz.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramb, " mRoomKey: ", aiuz.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (aiqn)paramVenue.next();
      Bitmap localBitmap = this.a.E(paramList.getUin());
      if (localBitmap != null)
      {
        localBitmap = aqhu.r(localBitmap, 16, 16);
        aiuz.a(this.a).u(paramList.getUin(), localBitmap);
      }
    }
    aiuz.a(this.a).g(paramb);
  }
  
  public void b(LocationRoom.b paramb, int paramInt)
  {
    if (!paramb.equals(aiuz.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    airk.bV(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiva
 * JD-Core Version:    0.7.0.1
 */