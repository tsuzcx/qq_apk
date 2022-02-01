import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public abstract class awux<K extends awuo>
{
  public static volatile awux b;
  public awux.a b;
  public WeakReference<K> bu;
  public AlbumListBaseData mAlbumListData;
  protected PhotoCommonBaseData mPhotoCommonData;
  
  protected awux(K paramK)
  {
    this.bu = new WeakReference(paramK);
    paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true);
    this.mPhotoCommonData = PhotoCommonBaseData.getInstance();
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.mPhotoCommonData.addHoldNember();
    this.mAlbumListData = new AlbumListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.bu + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "AlbumListLogic new，fragment = " + this.bu.get() + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
    this.mPhotoCommonData.releaseCommonData();
    b = null;
  }
  
  public abstract void initData(Intent paramIntent);
  
  public abstract boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent);
  
  public abstract void postInitUI();
  
  public static abstract interface a
  {
    public abstract String adapterGenerateSelection();
    
    public abstract List<QQAlbumInfo> compact(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt);
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract void queryAlbumList(int paramInt);
    
    public abstract List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awux
 * JD-Core Version:    0.7.0.1
 */