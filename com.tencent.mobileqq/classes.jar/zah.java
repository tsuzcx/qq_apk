import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.statistics.ReportController;

class zah
  implements Runnable
{
  zah(zag paramzag) {}
  
  public void run()
  {
    if ((this.a.a.getActivity() == null) || (this.a.a.getActivity().app == null)) {}
    for (;;)
    {
      return;
      Object localObject = (LocalRedTouchManager)this.a.a.getActivity().app.getManager(159);
      RedTouchItem localRedTouchItem1 = ((LocalRedTouchManager)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((LocalRedTouchManager)localObject).a(100500);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((LocalRedTouchManager)localObject).a();
        localObject = null;
        switch (i)
        {
        }
        while (localObject != null)
        {
          ReportController.b(this.a.a.getActivity().app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          return;
          localObject = "0X80073B1";
          continue;
          localObject = "0X80073B3";
          continue;
          localObject = "0X80073B7";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zah
 * JD-Core Version:    0.7.0.1
 */