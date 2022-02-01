package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import jpa.b;
import pjq;
import pjt;

public class StoryAlbumResourceDownloader$3
  implements Runnable
{
  public StoryAlbumResourceDownloader$3(pjq parampjq) {}
  
  public void run()
  {
    new jpa.b(QQStoryContext.c().getApp().getBaseContext(), "https://3408?_bid=3408", new pjt(this)).ayS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */