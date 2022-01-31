package com.tencent.token;

import android.content.Intent;
import android.net.NetworkInfo;

final class az
  implements Runnable
{
  private Intent a;
  
  az(ax paramax, Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public final void run()
  {
    NetworkInfo localNetworkInfo = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
    this.b.a(localNetworkInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.az
 * JD-Core Version:    0.7.0.1
 */