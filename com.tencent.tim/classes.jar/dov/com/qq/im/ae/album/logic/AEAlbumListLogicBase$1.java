package dov.com.qq.im.ae.album.logic;

import aqip;
import awux.a;
import awuy;

public class AEAlbumListLogicBase$1
  implements Runnable
{
  public AEAlbumListLogicBase$1(awuy paramawuy) {}
  
  public void run()
  {
    aqip.beginPile();
    this.this$0.b.queryAlbumList(100);
    aqip.endPile("PEAK", "queryAlbumList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.1
 * JD-Core Version:    0.7.0.1
 */