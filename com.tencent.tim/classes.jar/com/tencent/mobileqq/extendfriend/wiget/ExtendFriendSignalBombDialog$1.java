package com.tencent.mobileqq.extendfriend.wiget;

import aftd;
import aftr;
import afys;
import aine;
import aizy;
import anaz;
import android.content.Context;
import android.content.Intent;

public class ExtendFriendSignalBombDialog$1
  implements Runnable
{
  public ExtendFriendSignalBombDialog$1(afys paramafys) {}
  
  public void run()
  {
    if ((afys.a(this.this$0) != null) && (aine.n(afys.a(this.this$0), afys.a(this.this$0).uin, 1044)))
    {
      localObject = aftd.a(afys.a(this.this$0));
      ((aftr)localObject).timeStamp = anaz.gQ();
      aine.a(afys.a(this.this$0), (aftr)localObject, ((aftr)localObject).timeStamp, 2);
    }
    Object localObject = aizy.f(this.this$0.getContext(), afys.a(this.this$0).uin);
    this.this$0.getContext().startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1
 * JD-Core Version:    0.7.0.1
 */