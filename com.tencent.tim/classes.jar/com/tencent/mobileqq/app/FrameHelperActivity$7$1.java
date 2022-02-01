package com.tencent.mobileqq.app;

import acez;
import akjp;
import android.support.v4.app.FragmentActivity;
import anot;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class FrameHelperActivity$7$1
  implements Runnable
{
  public FrameHelperActivity$7$1(acez paramacez) {}
  
  public void run()
  {
    if ((this.a.this$0.getActivity() == null) || (this.a.this$0.getActivity().app == null)) {}
    for (;;)
    {
      return;
      Object localObject = (akjp)this.a.this$0.getActivity().app.getManager(160);
      RedTouchItem localRedTouchItem1 = ((akjp)localObject).a(10015);
      RedTouchItem localRedTouchItem2 = ((akjp)localObject).a(10016);
      RedTouchItem localRedTouchItem3 = ((akjp)localObject).a(-7);
      if ((localRedTouchItem3 != null) && (localRedTouchItem3.unReadFlag) && ((localRedTouchItem1 != null) || (localRedTouchItem2 != null)))
      {
        int i = ((akjp)localObject).GR();
        localObject = null;
        switch (i)
        {
        }
        while (localObject != null)
        {
          anot.a(this.a.this$0.getActivity().app, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.7.1
 * JD-Core Version:    0.7.0.1
 */