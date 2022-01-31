package com.tencent.token.ui;

import android.content.Intent;
import com.tencent.token.ui.base.dh;
import com.tencent.token.utils.s;

final class adu
  implements dh
{
  adu(adt paramadt) {}
  
  public final void a(int paramInt)
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
    s.b(this.a.a, this.a.a.getString(2131361976));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adu
 * JD-Core Version:    0.7.0.1
 */