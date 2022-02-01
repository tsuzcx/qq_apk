package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import zvz;

public class AlbumListFragment
  extends AbstractAlbumListFragment
{
  protected AlbumListLogic generateLogic()
  {
    int i = getActivity().getIntent().getIntExtra("enter_from", 0);
    AlbumListLogic localAlbumListLogic = zvz.a(i, this);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "generateLogic:" + localAlbumListLogic.getClass().getName() + " enterFrom:" + i);
    }
    return localAlbumListLogic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListFragment
 * JD-Core Version:    0.7.0.1
 */