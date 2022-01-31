package com.tencent.token.ui;

import android.content.Intent;
import com.tencent.token.ui.base.da;
import com.tencent.token.utils.w;

class aci
  implements da
{
  aci(ach paramach) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Intent localIntent = new Intent(this.a.a, AssistantRecommendFriendQrcode.class);
      localIntent.putExtra("page_id", 9);
      this.a.a.startActivity(localIntent);
      return;
    }
    w.b(this.a.a, this.a.a.getString(2131231483));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aci
 * JD-Core Version:    0.7.0.1
 */