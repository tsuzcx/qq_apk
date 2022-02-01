package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MutiMemberThumbList$1$1
  implements Runnable
{
  MutiMemberThumbList$1$1(MutiMemberThumbList.1 param1, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (MutiMemberThumbList.b(this.a.this$0)) {
      QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
    }
    Object localObject1;
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = String.format("%d名成员被邀请", new Object[] { Integer.valueOf(this.a.awM) });
      localObject2 = (TextView)this.a.this$0.findViewById(2131369360);
      ((TextView)localObject2).setTextColor(MutiMemberThumbList.b(this.a.this$0));
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setVisibility(0);
      localObject1 = this.a.this$0.findViewById(2131364939);
      if (this.a.awM <= 0) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      i = 0;
      if (i < MutiMemberThumbList.a(this.a.this$0).length)
      {
        localObject1 = this.a.this$0.findViewById(MutiMemberThumbList.a(this.a.this$0)[i]);
        localObject2 = (ImageView)((View)localObject1).findViewById(2131374006);
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131374008);
        localTextView.setVisibility(8);
        ((ImageView)localObject2).setImageDrawable(null);
        if ((!this.Xr) || (i != MutiMemberThumbList.a(this.a.this$0).length - 1)) {
          break label340;
        }
        localTextView.setText(String.format("%d+", new Object[] { Integer.valueOf(this.a.awM - MutiMemberThumbList.a(this.a.this$0).length + 1) }));
        localTextView.setVisibility(0);
        ((ImageView)((View)localObject1).findViewById(2131374006)).setImageDrawable(MutiMemberThumbList.a(this.a.this$0));
        ((View)localObject1).setVisibility(0);
      }
      this.a.this$0.setVisibility(0);
    } while (MutiMemberThumbList.a(this.a.this$0) == null);
    MutiMemberThumbList.a(this.a.this$0).setVisibility(0);
    return;
    ((View)localObject1).setVisibility(4);
    this.a.this$0.setVisibility(4);
    return;
    label340:
    if ((i < this.a.awM) && (i < this.iP.size()))
    {
      ((ImageView)localObject2).setImageBitmap((Bitmap)this.iP.get(i));
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break;
      ((View)localObject1).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList.1.1
 * JD-Core Version:    0.7.0.1
 */