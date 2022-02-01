import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aisk
  implements aiqr.a
{
  aisk(aisj paramaisj) {}
  
  public void a(LocationRoom.b paramb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramb + " mRoomKey: " + aisj.a(this.this$0));
    }
    QQToast.a(aisj.a(this.this$0), "已在其他设备进行共享", 0).show();
    aisj.a(this.this$0).setResult(1);
    aisj.a(this.this$0).finish();
  }
  
  public void a(LocationRoom.b paramb, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramb, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramb.equals(aisj.a(this.this$0))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((aisj.a(this.this$0) == null) || (aisj.a(this.this$0).isFinishing()));
      aisj.a(this.this$0).setResult(1);
      airk.bV(aisj.a(this.this$0));
      return;
    } while ((paramInt1 != 10101) || (aisj.a(this.this$0) == null) || (aisj.a(this.this$0).isFinishing()));
    aisj.a(this.this$0).setResult(1);
    airk.bW(aisj.a(this.this$0));
  }
  
  public void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList)
  {
    if ((!paramb.equals(aisj.a(this.this$0))) || (aisj.a(this.this$0).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (aiqn)paramVenue.next();
      Bitmap localBitmap = this.this$0.E(paramList.getUin());
      if (localBitmap != null)
      {
        localBitmap = aqhu.r(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        aisj.a(this.this$0).u(paramList.getUin(), localBitmap);
      }
    }
    aisj.a(this.this$0).g(paramb);
  }
  
  public void b(LocationRoom.b paramb, int paramInt)
  {
    if (!paramb.equals(aisj.a(this.this$0))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    aisj.a(this.this$0).setResult(1);
    airk.bV(aisj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisk
 * JD-Core Version:    0.7.0.1
 */