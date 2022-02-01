package com.tencent.open.appstore.dl;

import arzk;
import arzx;

public class DownloadManagerV2$18
  implements Runnable
{
  public void run()
  {
    if (arzx.PN()) {
      arzx.a().destroy();
    }
    if (arzk.PN()) {
      arzk.a().onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.18
 * JD-Core Version:    0.7.0.1
 */