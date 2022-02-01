package com.tencent.mobileqq.app.automator.step;

import accy;
import anxr;
import aqdj;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import java.util.ArrayList;
import java.util.Iterator;

public class GetSelfInfo
  extends AsyncStep
{
  public int od()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.app.getBusinessHandler(1);
    if (this.a.app.bIR)
    {
      localObject = (anxr)this.a.app.getManager(61);
      if (localObject == null) {
        break label170;
      }
    }
    label170:
    for (Object localObject = ((anxr)localObject).dK();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.a.app.bIR = false;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localFriendListHandler.DG((String)((Iterator)localObject).next());
        }
      }
      localObject = (CardHandler)this.a.app.getBusinessHandler(2);
      if (localObject != null) {
        ((CardHandler)localObject).cHo();
      }
      ((accy)this.a.app.getBusinessHandler(4)).cIc();
      aqdj.a(this.a.app, this.a.app.getAccount(), (byte)1);
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */