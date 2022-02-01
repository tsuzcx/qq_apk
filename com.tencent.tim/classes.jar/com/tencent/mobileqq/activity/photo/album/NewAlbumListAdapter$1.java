package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import zsz;
import ztr;
import ztr.a;

public class NewAlbumListAdapter$1
  implements Runnable
{
  public NewAlbumListAdapter$1(ztr paramztr) {}
  
  public void run()
  {
    ztr.a locala = new ztr.a();
    Object localObject1 = this.this$0.getDataInfos();
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QQAlbumInfo)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((QQAlbumInfo)localObject2).mCoverInfo != null))
      {
        String str1 = AlbumListAdapter.getFileDirectoryOf(((QQAlbumInfo)localObject2).mCoverInfo.path);
        String str2 = ((QQAlbumInfo)localObject2).name;
        if ((str1 != null) && (str2 != null) && (!str2.equals("最近照片")) && (!str2.equals("空间照片")))
        {
          str1 = str1.toLowerCase(Locale.US);
          if (str1.contains("/tencent/")) {
            ztr.c(locala, str1, (QQAlbumInfo)localObject2);
          } else {
            ztr.d(locala, str1, (QQAlbumInfo)localObject2);
          }
        }
      }
    }
    zsz.a(locala.ceV, locala.ceW, locala.ceX, locala.ceY, locala.ceZ, locala.cfa, locala.cfb, locala.cfc, locala.cfd, locala.cfe, locala.cff);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1
 * JD-Core Version:    0.7.0.1
 */