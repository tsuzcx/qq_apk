import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.provider.MediaStore.Video.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.1;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.2;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.3;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class awuy<K extends awuo>
  extends awux<K>
  implements awux.a
{
  protected awul b;
  
  protected awuy(K paramK)
  {
    super(paramK);
    this.jdField_b_of_type_Awux$a = this;
  }
  
  protected awul a()
  {
    return new awul((awuo)this.bu.get());
  }
  
  public String adapterGenerateSelection()
  {
    Object localObject = this.mAlbumListData.filter;
    boolean bool1 = ((MediaFileFilter)localObject).isSupportHeif();
    boolean bool2 = ((MediaFileFilter)localObject).isSupportWebp();
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png'");
    if (bool1) {
      ((StringBuffer)localObject).append(" or mime_type='image/heif' or mime_type='image/heic'");
    }
    if (bool2) {
      ((StringBuffer)localObject).append(" or mime_type='image/webp'");
    }
    ((StringBuffer)localObject).append(")) GROUP BY (1");
    return ((StringBuffer)localObject).toString();
  }
  
  protected awul b()
  {
    return this.jdField_b_of_type_Awul;
  }
  
  boolean checkAlbumChange(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.mPhotoCommonData.albumName))) || ((str2 != null) && (!str2.equals(this.mPhotoCommonData.albumId)))) {}
    for (boolean bool = true; needUpdateAlbum(bool, paramQQAlbumInfo); bool = false)
    {
      this.mPhotoCommonData.albumName = str1;
      this.mPhotoCommonData.albumId = str2;
      this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      return true;
    }
    return false;
  }
  
  public List<QQAlbumInfo> compact(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    if ((this.bu.get() == null) || (((awuo)this.bu.get()).getActivity() == null)) {
      return null;
    }
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      for (;;)
      {
        aqip.beginPile();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label557;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (awul.isCameraDir(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if (paramList1 != null) {
          break;
        }
        localObject = paramList2;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label259:
    label674:
    label680:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo._id.equals(((QQAlbumInfo)localObject)._id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label680;
        }
        localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate)
          {
            j = 1;
            paramList1.add(i, localObject);
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label674;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label259;
          boolean bool;
          if (paramInt == -1)
          {
            paramList1 = b().queryRecentMediaBucket(((awuo)this.bu.get()).getActivity(), this.mAlbumListData.recentImagesLimitSize, this.mAlbumListData.recentImagesMaxCount, this.mAlbumListData.filter, this.mAlbumListData.recentImagesLimitWidth, this.mAlbumListData.isBothwidthheight, this.mAlbumListData.recentImagesBlockPaths);
            ((List)localObject).add(0, paramList1);
            if ((this.mAlbumListData.filter != null) && (this.mAlbumListData.filter.showVideo()))
            {
              paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              paramList1 = alld.query(((awuo)this.bu.get()).getActivity().getContentResolver(), paramList1, new String[] { "_id" }, "_size>0 ", null, null);
              i = 0;
              if (paramList1 != null)
              {
                i = paramList1.getCount();
                paramList1.close();
              }
              bool = false;
              if (i <= 0) {
                break label603;
              }
              bool = true;
              label508:
              b().mIsShowVideoAlbum = bool;
              if (bool)
              {
                if (paramInt != -1) {
                  break label634;
                }
                paramList1 = b().queryAllVideoBucket(((awuo)this.bu.get()).getActivity());
              }
            }
          }
          for (;;)
          {
            ((List)localObject).add(1, paramList1);
            label557:
            aqip.endPile("PEAK", "compact.queryRecentBucket");
            return localObject;
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$RecentAlbumId";
            paramList1.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            paramList1.mCoverInfo = new LocalMediaInfo();
            break;
            label603:
            paramList1 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
            i = 0;
            if (paramList1 != null) {
              i = paramList1.getMediaScannerInfosCount();
            }
            if (i <= 0) {
              break label508;
            }
            bool = true;
            break label508;
            label634:
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$VideoAlbumId";
            paramList1.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
            paramList1.mCoverInfo = new LocalMediaInfo();
          }
        }
        break;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((awuo)this.bu.get()).getResources();
    awul localawul = b();
    View localView;
    QQAlbumInfo localQQAlbumInfo;
    Object localObject;
    if (paramView == null)
    {
      localView = ((awuo)this.bu.get()).getActivity().getLayoutInflater().inflate(2131561212, null);
      paramViewGroup = (TextView)localView;
      localQQAlbumInfo = localawul.getItem(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      paramViewGroup.setText(paramView);
      localObject = paramViewGroup.getCompoundDrawables()[0];
      if (localawul.getItemViewType(paramInt) != 1) {
        break label396;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label381;
      }
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label210:
      LocalMediaInfo localLocalMediaInfo = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      localLocalMediaInfo.thumbWidth = 200;
      if ((localObject == null) || (!URLDrawable.class.isInstance(localObject))) {
        break label413;
      }
      localObject = (URLDrawable)localObject;
      if (!paramView.equals(((URLDrawable)localObject).getURL())) {
        break label413;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = aoop.getDrawable(paramView, awul.COLOR_DRAWABLE, awul.COLOR_DRAWABLE);
        ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
        ((URLDrawable)localObject).setBounds(0, 0, localawul.mCoverWidth, localawul.mCoverHeight);
        if (!localQQAlbumInfo._id.equals(this.mPhotoCommonData.albumId)) {
          break label408;
        }
        paramView = localawul.mRightArrow.newDrawable(localResources);
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
      }
      for (;;)
      {
        paramViewGroup.setCompoundDrawables((Drawable)localObject, null, paramView, null);
        return localView;
        paramViewGroup = (TextView)paramView;
        localView = paramView;
        break;
        label381:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label210;
        label396:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
        break label210;
        label408:
        paramView = null;
      }
      label413:
      localObject = null;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.mAlbumListData.filter = MediaFileFilter.getFilter(i);
    this.mAlbumListData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.mAlbumListData.filterVideoGif)
    {
      this.mAlbumListData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
      this.mAlbumListData.showMediaType = 1;
    }
    this.mPhotoCommonData.mIsAwlaysShowNumber = paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.mPhotoCommonData.mIsAwlaysShowNumber);
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (paramIntent != null)
    {
      if ((this.mPhotoCommonData.selectedMediaInfoHashMap != null) && (!this.mPhotoCommonData.selectedMediaInfoHashMap.isEmpty())) {
        break label178;
      }
      this.mPhotoCommonData.selectedMediaInfoHashMap = paramIntent;
    }
    for (;;)
    {
      this.jdField_b_of_type_Awul = a();
      ((awuo)this.bu.get()).a = this.jdField_b_of_type_Awul;
      ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.1(this));
      return;
      label178:
      this.mPhotoCommonData.selectedMediaInfoHashMap.putAll(paramIntent);
    }
  }
  
  boolean needUpdateAlbum(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo._id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = ((awuo)this.bu.get()).mListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    View localView = localXListView.getChildAt(0);
    if (localView == null) {}
    for (paramInt = 0;; paramInt = localView.getTop())
    {
      paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "save Scroll Position,index:" + localXListView.getFirstVisiblePosition() + " top:" + paramInt);
      }
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
  }
  
  public void postInitUI() {}
  
  public void queryAlbumList(int paramInt)
  {
    int k = 0;
    int j = 1;
    awul localawul = b();
    MediaFileFilter localMediaFileFilter = this.mAlbumListData.filter;
    List localList1;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      aqip.beginPile();
      localList1 = localawul.queryImageBuckets(((awuo)this.bu.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList1 != null) && (localList1.size() == paramInt))
      {
        i = 1;
        aqip.endPile("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      List localList2;
      if ((localMediaFileFilter != null) && (localMediaFileFilter.showVideo()))
      {
        aqip.beginPile();
        localList2 = localawul.queryVideoBuckets(((awuo)this.bu.get()).getActivity(), paramInt, localMediaFileFilter);
        if ((paramInt != -1) && (localList2 != null) && (localList2.size() == paramInt))
        {
          i = 1;
          aqip.endPile("PEAK", "queryVideoBuckets");
        }
      }
      for (;;)
      {
        aqip.beginPile();
        localList1 = this.jdField_b_of_type_Awux$a.compact(localList1, localList2, paramInt);
        if (localList1 != null) {
          while (j < localList1.size())
          {
            k += ((QQAlbumInfo)localList1.get(j)).mMediaFileCount;
            j += 1;
          }
        }
        aqip.endPile("PEAK", "compact: medias ==null");
        do
        {
          return;
          aqip.endPile("PEAK", "compact(" + (localList1.size() - 1) + "," + k + ")");
          localawul.gp(localList1);
        } while (paramInt == -1);
        if (i != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.2(this, localawul));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AEAlbumListLogicBase.3(this, localawul, localMediaFileFilter));
        return;
        break;
        localList2 = null;
      }
      i = 0;
      break;
      localList1 = null;
      i = 0;
    }
  }
  
  public List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return QAlbumUtil.queryRecentImages(paramContext, paramInt3, paramInt2, paramMediaFileFilter, paramBoolean, paramInt1, paramArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuy
 * JD-Core Version:    0.7.0.1
 */