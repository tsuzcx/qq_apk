package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;

final class pd$2
  implements Runnable
{
  pd$2(pd parampd) {}
  
  public final void run()
  {
    if (pd.a(this.a) == null) {
      return;
    }
    pd.a(this.a).onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pd.2
 * JD-Core Version:    0.7.0.1
 */