import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class wvw
  implements aiqr.a
{
  wvw(wvv paramwvv) {}
  
  public void a(LocationRoom.b paramb, int paramInt)
  {
    if ((wvv.a(this.this$0) == wvv.a(this.this$0).a().a()) && (wvv.a(this.this$0, paramb.getSessionType(), paramb.xc()))) {
      wvv.a(this.this$0).a().ciA();
    }
  }
  
  public void a(LocationRoom.b paramb, int paramInt1, int paramInt2) {}
  
  public void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramb.xc() + " itemList: " + paramList.size());
    }
    paramVenue = aivd.a(wvv.a(this.this$0).app).a().b();
    if ((paramVenue != null) && (paramVenue.equals(paramb))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramb, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!wvv.a(this.this$0, paramb.getSessionType(), paramb.xc()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (wvv.a(this.this$0) != wvv.a(this.this$0).a().a());
    wvv.a(this.this$0).a().ciA();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((aiqn)paramList.get(i)).getUin());
      i += 1;
    }
    boolean bool = paramVenue.contains(wvv.a(this.this$0).app.getCurrentUin());
    wvv.a(this.this$0).b(bool, wvv.a(this.this$0, paramb, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    wvv.a(this.this$0).a().a(wvv.a(this.this$0), new Object[0]);
  }
  
  public void b(LocationRoom.b paramb, int paramInt)
  {
    if ((wvv.a(this.this$0) == wvv.a(this.this$0).a().a()) && (wvv.a(this.this$0, paramb.getSessionType(), paramb.xc()))) {
      wvv.a(this.this$0).a().ciA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvw
 * JD-Core Version:    0.7.0.1
 */