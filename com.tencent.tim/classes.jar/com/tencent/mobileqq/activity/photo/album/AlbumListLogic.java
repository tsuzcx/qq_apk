package com.tencent.mobileqq.activity.photo.album;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class AlbumListLogic<K extends AbstractAlbumListFragment, O extends OtherCommonData>
{
  protected IalbumListAdapterCallBack mAlbumListAdapterCallBack = null;
  protected AlbumListBaseData mAlbumListData;
  public K mFragment;
  public O mOtherCommonData;
  protected PhotoCommonBaseData<O> mPhotoCommonData;
  
  protected AlbumListLogic(K paramK)
  {
    this.mFragment = paramK;
    this.mPhotoCommonData = PhotoCommonBaseData.getInstance(paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.mOtherCommonData = this.mPhotoCommonData.bindCommonData(getOtherData());
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.mPhotoCommonData.addHoldNember();
    this.mAlbumListData = new AlbumListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic new，activity = " + this.mFragment + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic close，activity = " + this.mFragment + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
    this.mPhotoCommonData.releaseCommonData();
  }
  
  protected OtherCommonData getOtherData()
  {
    return new AlbumListLogic.1(this);
  }
  
  public Class<? extends OtherCommonData> getOtherDataClass()
  {
    return OtherCommonData.class;
  }
  
  protected abstract void initData(Intent paramIntent);
  
  protected abstract boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  protected abstract void postInitUI();
  
  public static abstract interface IalbumListAdapterCallBack
  {
    public abstract String adapterGenerateSelection();
    
    public abstract List<QQAlbumInfo> compact(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt);
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract void queryAlbumList(int paramInt);
    
    public abstract List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListLogic
 * JD-Core Version:    0.7.0.1
 */