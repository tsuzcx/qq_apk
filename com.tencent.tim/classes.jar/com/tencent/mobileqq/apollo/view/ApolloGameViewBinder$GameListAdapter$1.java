package com.tencent.mobileqq.apollo.view;

import abxi;
import abzq;
import abzq.a;
import android.graphics.Color;
import android.widget.ImageView;
import auvw;
import auvw.a;
import auvw.b;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(abzq.a parama, ImageView paramImageView) {}
  
  public void run()
  {
    if ((abzq.a.a(this.this$0) == null) && (abzq.a.a(this.this$0) != null) && (abzq.a.a(this.this$0).get() != null))
    {
      Object localObject = (abzq)abzq.a.a(this.this$0).get();
      if ((abzq.a((abzq)localObject) != null) && (abzq.a((abzq)localObject).mActivity != null))
      {
        localObject = auvw.a(abzq.a((abzq)abzq.a.a(this.this$0).get()).mActivity).b(8).a(abxi.bjU).a(16.0F).a(-1);
        ((auvw.a)localObject).c(50);
        localObject = new auvw.b((auvw.a)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          abzq.a.a(this.this$0, ((auvw.a)localObject).a());
        }
      }
    }
    if (abzq.a.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.xW.getX() + " " + this.xW.getY());
      }
      abzq.a.a(this.this$0).setAlignMode(83);
      abzq.a.a(this.this$0).abr(2);
      abzq.a.a(this.this$0).L(this.xW, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */