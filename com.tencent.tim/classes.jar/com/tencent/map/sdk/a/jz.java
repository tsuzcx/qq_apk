package com.tencent.map.sdk.a;

import com.tencent.tencentmap.io.QStorageManager;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;

public final class jz
{
  public pn a = null;
  public TileOverlay b = null;
  public TileOverlayOptions c;
  public Language d = Language.zh;
  public volatile boolean e = false;
  
  public jz(pn parampn)
  {
    this.a = parampn;
    on.c(QStorageManager.getStorageRootPath(this.a.ay) + "/tencentmapsdk/rastermap/unmainland");
    on.c(QStorageManager.getInstance(this.a.ay).getDataDir().getPath() + "/rastermap/taiwan");
  }
  
  public final void a()
  {
    if (this.c != null) {
      ((ka)this.c.getTileProvider()).a();
    }
    if (this.b != null) {
      this.b.reload();
    }
  }
  
  public final void b()
  {
    if ((this.a == null) || (this.a.az == null) || (this.a.az.b == null) || (this.b == null)) {
      return;
    }
    pm localpm = this.a.az;
    lw locallw = localpm.b;
    locallw.d(localpm.e);
    locallw.e(true);
    this.b.remove();
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jz
 * JD-Core Version:    0.7.0.1
 */