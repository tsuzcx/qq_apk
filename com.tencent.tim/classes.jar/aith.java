import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aith
  implements aiqr.a
{
  aith(aitg paramaitg) {}
  
  public void a(LocationRoom.b paramb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramb + " mRoomKey: " + aitg.a(this.b));
    }
    QQToast.a(aitg.a(this.b), "已在其他设备进行共享", 0).show();
    aitg.a(this.b).finish();
  }
  
  public void a(LocationRoom.b paramb, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramb, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramb.equals(aitg.a(this.b))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 10100) {
            break;
          }
          if ((paramInt2 == 2) && (aitg.a(this.b).getFrom() == 1))
          {
            if (aitg.a(this.b) != null)
            {
              aitg.a(this.b).a.G(1, aitg.a(this.b).getSessionType(), aitg.a(this.b).xc());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((aitg.a(this.b) == null) || (aitg.a(this.b).isFinishing()));
        airk.bV(aitg.a(this.b));
        return;
      } while (paramInt1 != 10101);
      if ((aitg.a(this.b) != null) && (!aitg.a(this.b).isFinishing()))
      {
        airk.bW(aitg.a(this.b));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramb });
  }
  
  public void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList)
  {
    if ((!paramb.equals(aitg.a(this.b))) || (aitg.a(this.b).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      aiqn localaiqn = (aiqn)paramVenue.next();
      Bitmap localBitmap = this.b.E(localaiqn.getUin());
      if (localBitmap != null)
      {
        localBitmap = aqhu.r(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        aitg.a(this.b).u(localaiqn.getUin(), localBitmap);
      }
    }
    aitg.a(this.b).lj(paramList);
    aitg.a(this.b).g(paramb);
  }
  
  public void b(LocationRoom.b paramb, int paramInt)
  {
    if (!paramb.equals(aitg.a(this.b))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    airk.bV(aitg.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aith
 * JD-Core Version:    0.7.0.1
 */