package com.tencent.mobileqq.activity.photo.album;

import aqip;

class AlbumListLogicBase$1
  implements Runnable
{
  AlbumListLogicBase$1(AlbumListLogicBase paramAlbumListLogicBase) {}
  
  public void run()
  {
    aqip.beginPile();
    this.this$0.mAlbumListAdapterCallBack.queryAlbumList(100);
    aqip.endPile("PEAK", "queryAlbumList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase.1
 * JD-Core Version:    0.7.0.1
 */