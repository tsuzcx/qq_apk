package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class PhotoCommonBaseData<O extends OtherCommonData>
{
  public static final String FROM_PHOTO_LIST = "FROM_PHOTO_LIST";
  public static final String FROM_QZONE_PHOTO_LIST = "FROM_QZONE_PHOTO_LIST";
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final int MAX_RECENT_PHOTO_NUM = 100;
  public static final String MY_UIN = "peak.myUin";
  public static final String NEED_NEW_PHOTO_COMMON_DATA = "NEED_NEW_PHOTO_COMMON_DATA";
  public static final String TAG = "AlbumModule";
  public static final int TYPE_SLIDESHOW = 1;
  private static volatile int holdLogicNumber = 0;
  private static volatile PhotoCommonBaseData instance;
  public String albumId;
  public String albumName;
  public HashMap<String, LocalMediaInfo> allMediaInfoHashMap = new HashMap();
  public int currentQualityType = 0;
  public boolean isShowQzoneAlbum = false;
  public boolean mIsAwlaysShowNumber = false;
  public boolean mIsDisableTroopAlbum = false;
  private O mOtherCommonData = null;
  public int maxSelectNum = 1;
  public ArrayList<String> mediaPathsList = new ArrayList();
  public String myUin;
  public boolean needMediaInfo = false;
  public ArrayList<Integer> selectedIndex = new ArrayList();
  public HashMap<String, LocalMediaInfo> selectedMediaInfoHashMap = new HashMap();
  public ArrayList<String> selectedPhotoList = new ArrayList();
  public long videoDurationLimit;
  public long videoSizeLimit;
  
  public static PhotoCommonBaseData getInstance()
  {
    return getInstance(false);
  }
  
  static <O extends OtherCommonData> PhotoCommonBaseData<O> getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      instance = new PhotoCommonBaseData();
      return instance;
    }
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new PhotoCommonBaseData();
      }
      return instance;
    }
    finally {}
  }
  
  public void addHoldNember()
  {
    try
    {
      holdLogicNumber += 1;
      return;
    }
    finally {}
  }
  
  protected O bindCommonData(O paramO)
  {
    if (this.mOtherCommonData == null) {}
    try
    {
      if (this.mOtherCommonData == null) {
        this.mOtherCommonData = paramO;
      }
      return this.mOtherCommonData;
    }
    finally {}
  }
  
  /* Error */
  protected O bindCommonData(java.lang.Class<O> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   4: ifnonnull +29 -> 33
    //   7: ldc 108
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 65	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +14 -> 30
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 120	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   24: checkcast 108	com/tencent/mobileqq/activity/photo/album/OtherCommonData
    //   27: putfield 65	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   30: ldc 108
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 65	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   37: areturn
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 123	java/lang/IllegalAccessException:printStackTrace	()V
    //   43: goto -13 -> 30
    //   46: astore_1
    //   47: ldc 108
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 124	java/lang/InstantiationException:printStackTrace	()V
    //   57: goto -27 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	PhotoCommonBaseData
    //   0	60	1	paramClass	java.lang.Class<O>
    //   14	2	2	localOtherCommonData	OtherCommonData
    // Exception table:
    //   from	to	target	type
    //   19	30	38	java/lang/IllegalAccessException
    //   10	15	46	finally
    //   19	30	46	finally
    //   30	33	46	finally
    //   39	43	46	finally
    //   47	50	46	finally
    //   53	57	46	finally
    //   19	30	52	java/lang/InstantiationException
  }
  
  public boolean containNetImage()
  {
    Iterator localIterator = this.selectedPhotoList.iterator();
    while (localIterator.hasNext()) {
      if (QAlbumUtil.isNetUrl((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public void releaseCommonData()
  {
    try
    {
      holdLogicNumber -= 1;
      if (holdLogicNumber == 0)
      {
        instance = null;
        this.mOtherCommonData = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData
 * JD-Core Version:    0.7.0.1
 */