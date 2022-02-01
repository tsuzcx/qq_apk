package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import ihm;
import iiv;
import jkn;
import jll;
import mqq.util.WeakReference;

class TraeHelper$4
  implements Runnable
{
  TraeHelper$4(TraeHelper paramTraeHelper) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    Object localObject;
    do
    {
      return;
      if (this.this$0.n != null)
      {
        localObject = (Button)this.this$0.n.get();
        if (localObject != null)
        {
          ((Button)localObject).setClickable(true);
          if ((!TraeHelper.b(this.this$0)) || (!jkn.xE())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          jll.b((View)localObject, ((Button)localObject).getResources().getString(2131690642));
        }
      }
      this.this$0.a.b().P("handFreeJob", TraeHelper.a(this.this$0).QB);
      TraeHelper.a(this.this$0);
      localObject = this.this$0.a.mApp.a();
    } while (localObject == null);
    ((ihm)localObject).amk();
    return;
    ((Button)localObject).setSelected(TraeHelper.a(this.this$0).QB);
    Resources localResources = ((Button)localObject).getResources();
    if (TraeHelper.a(this.this$0).QB) {}
    for (int i = 2131690643;; i = 2131690644)
    {
      jll.b((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */