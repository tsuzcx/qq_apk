package com.tencent.mobileqq.nearby.gameroom;

import ajss;
import ajst;
import ajtw.b;
import android.widget.LinearLayout;
import anot;
import java.util.Iterator;
import java.util.List;

public class GameRoomInviteActivity$21$1$1
  implements Runnable
{
  public GameRoomInviteActivity$21$1$1(ajst paramajst, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.a.this$0.jq.setVisibility(0);
    this.a.a.this$0.a.av(this.val$list, this.mt);
    int j;
    int i;
    ajtw.b localb;
    int k;
    if (this.val$list.size() > 0)
    {
      Iterator localIterator = this.val$list.iterator();
      j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        localb = (ajtw.b)localIterator.next();
        if (localb.uinType == 1)
        {
          k = j;
          j = i + 1;
          i = k;
        }
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (localb.uinType == 0)
      {
        k = j + 1;
        j = i;
        i = k;
        continue;
        anot.a(this.a.a.this$0.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_invite", 0, 0, "" + i, "" + j, "", "");
        if (this.mt) {
          anot.a(this.a.a.this$0.app, "dc00899", "Grp_wolf", "", "invite_page", "exp_more", 0, 0, "", "", "", "");
        }
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.21.1.1
 * JD-Core Version:    0.7.0.1
 */