import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.album.adapter.AEAlbumListAdapter.1;
import dov.com.qq.im.ae.album.adapter.AEAlbumListAdapter.2;
import dov.com.qq.im.ae.album.adapter.AEAlbumListAdapter.3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class awul
  extends BaseAdapter
{
  static final String BUCKET_SELECTION_FOR_SLIDESHOW;
  public static final ColorDrawable COLOR_DRAWABLE = new ColorDrawable(-2141891243);
  static final String[] PROJECTION_BUCKET = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static final String[] VIDEO_COLUMNS;
  static final String[] VIDEO_PROJECTION_BUCKET;
  static String[] columns;
  awux.a a;
  public int mCoverHeight;
  public int mCoverWidth;
  public List<QQAlbumInfo> mDataInfos = new ArrayList();
  public boolean mIsShowVideoAlbum;
  public Resources mResources;
  public Drawable.ConstantState mRightArrow;
  Handler mUiHandler = new Handler();
  
  static
  {
    BUCKET_SELECTION_FOR_SLIDESHOW = "_size>0 and ( _size < " + QAlbumUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (" + "width" + ">= 240 or " + "width" + " IS NULL) and (" + "height" + ">= 240 or " + "height" + " IS NULL )  and " + "height" + "  * 1.0 / " + "width" + ">= 0.45 and " + "height" + "  * 1.0 / " + "width" + "<= 2.2 and (" + "mime_type" + "='" + "image/jpeg" + "' or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.jpeg%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.bmp%' )  or (" + "mime_type" + "='" + "*/*" + "' and " + "_display_name" + " LIKE'%.png%' )  or " + "mime_type" + " LIKE'%" + "bmp" + "%' or " + "mime_type" + " LIKE'%" + "bitmap" + "%' or " + "mime_type" + "='" + "image/png" + "'";
    if (Build.VERSION.SDK_INT >= 16) {}
    for (columns = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; columns = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      VIDEO_PROJECTION_BUCKET = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public awul(awuo paramawuo)
  {
    this.a = paramawuo.a.b;
    this.mResources = paramawuo.getResources();
    this.mRightArrow = this.mResources.getDrawable(2130839517).getConstantState();
    this.mCoverWidth = this.mResources.getDimensionPixelSize(2131296491);
    this.mCoverHeight = this.mCoverWidth;
  }
  
  public static String getFileDirectoryOf(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i < 0);
    return paramString.substring(0, i + 1);
  }
  
  public static boolean isCameraDir(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo)
  {
    if (this.mDataInfos == null) {
      return;
    }
    if (this.mDataInfos.isEmpty()) {
      this.mDataInfos.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      b(paramQQAlbumInfo);
      notifyDataSetChanged();
      return;
      if (((QQAlbumInfo)this.mDataInfos.get(0))._id.equals("$RecentAlbumId")) {
        this.mDataInfos.set(0, paramQQAlbumInfo);
      }
    }
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo) {}
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.mUiHandler.post(new AEAlbumListAdapter.2(this, paramQQAlbumInfo));
  }
  
  public void d(QQAlbumInfo paramQQAlbumInfo)
  {
    int k = 0;
    if (this.mDataInfos == null) {
      return;
    }
    if (this.mDataInfos.size() < 2) {
      this.mDataInfos.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < this.mDataInfos.size())
        {
          if (((QQAlbumInfo)this.mDataInfos.get(i))._id.equals("$VideoAlbumId")) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label132;
          }
          if (paramQQAlbumInfo.mMediaFileCount <= 0) {
            break label118;
          }
          this.mDataInfos.set(i, paramQQAlbumInfo);
          break;
        }
        i += 1;
      }
      label118:
      this.mDataInfos.remove(i);
      continue;
      label132:
      if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.mDataInfos.add(1, paramQQAlbumInfo);
      }
    }
  }
  
  public void e(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d(paramQQAlbumInfo);
      return;
    }
    this.mUiHandler.post(new AEAlbumListAdapter.3(this, paramQQAlbumInfo));
  }
  
  public void eGw()
  {
    this.a.queryAlbumList(-1);
  }
  
  public int getCount()
  {
    return this.mDataInfos.size();
  }
  
  public QQAlbumInfo getItem(int paramInt)
  {
    return (QQAlbumInfo)this.mDataInfos.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.mDataInfos.get(paramInt)).mCoverInfo);
  }
  
  List<LocalMediaInfo> getVideoList(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label298;
            }
            str1 = paramCursor.getString(i2);
            if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.filter(str1))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AlbumListAdapter", 2, "Filter mime type:" + str1);
            }
          }
          str2 = paramCursor.getString(m);
        } while ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()));
        long l = paramCursor.getLong(n);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo._id = paramCursor.getLong(k);
        localLocalMediaInfo.path = str2;
        localLocalMediaInfo.mMimeType = str1;
        localLocalMediaInfo.modifiedDate = l;
        localLocalMediaInfo.mDuration = paramCursor.getLong(i1);
        localLocalMediaInfo.fileSize = paramCursor.getLong(i3);
        localArrayList.add(localLocalMediaInfo);
        j = i + 1;
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    label298:
    return localArrayList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.a.getView(paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
  
  public void gp(List<QQAlbumInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setData(paramList);
      return;
    }
    this.mUiHandler.post(new AEAlbumListAdapter.1(this, paramList));
  }
  
  /* Error */
  public QQAlbumInfo queryAllVideoBucket(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 252	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 441	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 291
    //   16: putfield 254	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   19: aload 4
    //   21: getstatic 446	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:VIDEO_ALBUM_NAME	Ljava/lang/String;
    //   24: putfield 449	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   27: aload 4
    //   29: iconst_0
    //   30: putfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   33: getstatic 455	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 461	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_2
    //   42: getstatic 149	awul:VIDEO_COLUMNS	[Ljava/lang/String;
    //   45: ldc_w 463
    //   48: aconst_null
    //   49: ldc_w 465
    //   52: invokestatic 471	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: iconst_2
    //   59: invokestatic 475	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +14 -> 80
    //   69: aload_2
    //   70: astore_1
    //   71: aload_0
    //   72: aload_2
    //   73: iconst_m1
    //   74: aload 5
    //   76: invokevirtual 477	awul:getVideoList	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   79: astore_3
    //   80: aload_2
    //   81: astore_1
    //   82: invokestatic 483	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   85: invokestatic 488	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   88: iconst_0
    //   89: iconst_m1
    //   90: invokevirtual 492	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   93: astore 5
    //   95: aload_3
    //   96: ifnull +50 -> 146
    //   99: aload_2
    //   100: astore_1
    //   101: aload_3
    //   102: invokeinterface 237 1 0
    //   107: ifne +39 -> 146
    //   110: aload_2
    //   111: astore_1
    //   112: aload 4
    //   114: aload 4
    //   116: getfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   119: aload_3
    //   120: invokeinterface 289 1 0
    //   125: iadd
    //   126: putfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   129: aload_2
    //   130: astore_1
    //   131: aload 4
    //   133: aload_3
    //   134: iconst_0
    //   135: invokeinterface 250 2 0
    //   140: checkcast 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   143: putfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   146: aload 5
    //   148: ifnull +181 -> 329
    //   151: aload_2
    //   152: astore_1
    //   153: aload 5
    //   155: invokevirtual 493	java/util/ArrayList:isEmpty	()Z
    //   158: ifne +171 -> 329
    //   161: aload_2
    //   162: astore_1
    //   163: aload 4
    //   165: aload 4
    //   167: getfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   170: aload 5
    //   172: invokevirtual 494	java/util/ArrayList:size	()I
    //   175: iadd
    //   176: putfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   179: aload_2
    //   180: astore_1
    //   181: aload 5
    //   183: iconst_0
    //   184: invokevirtual 495	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   187: checkcast 497	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   190: astore_3
    //   191: aload_2
    //   192: astore_1
    //   193: aload 4
    //   195: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   198: ifnull +21 -> 219
    //   201: aload_2
    //   202: astore_1
    //   203: aload 4
    //   205: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   208: getfield 393	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   211: aload_3
    //   212: getfield 498	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   215: lcmp
    //   216: ifge +113 -> 329
    //   219: aload_2
    //   220: astore_1
    //   221: aload 4
    //   223: new 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   226: dup
    //   227: invokespecial 381	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   230: putfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   233: aload_2
    //   234: astore_1
    //   235: aload 4
    //   237: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   240: aload_3
    //   241: getfield 501	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   244: i2l
    //   245: putfield 384	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   248: aload_2
    //   249: astore_1
    //   250: aload 4
    //   252: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   255: aload_3
    //   256: getfield 503	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   259: putfield 396	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   262: aload_2
    //   263: astore_1
    //   264: aload 4
    //   266: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   269: aload_3
    //   270: getfield 504	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   273: putfield 399	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   276: aload_2
    //   277: astore_1
    //   278: aload 4
    //   280: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   283: aload_3
    //   284: getfield 505	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   287: putfield 387	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   290: aload_2
    //   291: astore_1
    //   292: aload 4
    //   294: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   297: aload_3
    //   298: getfield 498	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   301: putfield 393	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   304: aload_2
    //   305: astore_1
    //   306: aload 4
    //   308: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   311: aload_3
    //   312: getfield 508	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   315: putfield 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   318: aload_2
    //   319: astore_1
    //   320: aload 4
    //   322: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   325: iconst_0
    //   326: putfield 511	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   329: aload_2
    //   330: ifnull +9 -> 339
    //   333: aload_2
    //   334: invokeinterface 514 1 0
    //   339: aload 4
    //   341: areturn
    //   342: astore_3
    //   343: aconst_null
    //   344: astore_2
    //   345: aload_2
    //   346: astore_1
    //   347: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +17 -> 367
    //   353: aload_2
    //   354: astore_1
    //   355: ldc_w 356
    //   358: iconst_2
    //   359: aload_3
    //   360: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   363: aload_3
    //   364: invokestatic 520	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload_2
    //   368: ifnull -29 -> 339
    //   371: aload_2
    //   372: invokeinterface 514 1 0
    //   377: aload 4
    //   379: areturn
    //   380: astore_2
    //   381: aconst_null
    //   382: astore_1
    //   383: aload_1
    //   384: ifnull +9 -> 393
    //   387: aload_1
    //   388: invokeinterface 514 1 0
    //   393: aload_2
    //   394: athrow
    //   395: astore_2
    //   396: goto -13 -> 383
    //   399: astore_3
    //   400: goto -55 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	awul
    //   0	403	1	paramContext	Context
    //   36	336	2	localObject1	java.lang.Object
    //   380	14	2	localObject2	java.lang.Object
    //   395	1	2	localObject3	java.lang.Object
    //   1	311	3	localObject4	java.lang.Object
    //   342	22	3	localException1	java.lang.Exception
    //   399	1	3	localException2	java.lang.Exception
    //   9	369	4	localQQAlbumInfo	QQAlbumInfo
    //   62	120	5	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   33	56	342	java/lang/Exception
    //   33	56	380	finally
    //   58	64	395	finally
    //   71	80	395	finally
    //   82	95	395	finally
    //   101	110	395	finally
    //   112	129	395	finally
    //   131	146	395	finally
    //   153	161	395	finally
    //   163	179	395	finally
    //   181	191	395	finally
    //   193	201	395	finally
    //   203	219	395	finally
    //   221	233	395	finally
    //   235	248	395	finally
    //   250	262	395	finally
    //   264	276	395	finally
    //   278	290	395	finally
    //   292	304	395	finally
    //   306	318	395	finally
    //   320	329	395	finally
    //   347	353	395	finally
    //   355	367	395	finally
    //   58	64	399	java/lang/Exception
    //   71	80	399	java/lang/Exception
    //   82	95	399	java/lang/Exception
    //   101	110	399	java/lang/Exception
    //   112	129	399	java/lang/Exception
    //   131	146	399	java/lang/Exception
    //   153	161	399	java/lang/Exception
    //   163	179	399	java/lang/Exception
    //   181	191	399	java/lang/Exception
    //   193	201	399	java/lang/Exception
    //   203	219	399	java/lang/Exception
    //   221	233	399	java/lang/Exception
    //   235	248	399	java/lang/Exception
    //   250	262	399	java/lang/Exception
    //   264	276	399	java/lang/Exception
    //   278	290	399	java/lang/Exception
    //   292	304	399	java/lang/Exception
    //   306	318	399	java/lang/Exception
    //   320	329	399	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> queryImageBuckets(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +63 -> 64
    //   4: getstatic 525	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 12
    //   9: aload_1
    //   10: invokevirtual 461	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 12
    //   15: getstatic 60	awul:PROJECTION_BUCKET	[Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 176	awul:a	Lawux$a;
    //   22: invokeinterface 528 1 0
    //   27: aconst_null
    //   28: ldc_w 530
    //   31: invokestatic 471	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 12
    //   36: aload 12
    //   38: ifnonnull +57 -> 95
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_1
    //   44: astore 13
    //   46: aload 12
    //   48: ifnull +13 -> 61
    //   51: aload 12
    //   53: invokeinterface 514 1 0
    //   58: aload_1
    //   59: astore 13
    //   61: aload 13
    //   63: areturn
    //   64: getstatic 525	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   67: invokevirtual 536	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   70: astore 12
    //   72: aload 12
    //   74: ldc_w 538
    //   77: iload_2
    //   78: invokestatic 541	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   81: invokevirtual 547	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   84: pop
    //   85: aload 12
    //   87: invokevirtual 551	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   90: astore 12
    //   92: goto -83 -> 9
    //   95: aload 12
    //   97: astore 13
    //   99: new 553	java/util/LinkedList
    //   102: dup
    //   103: invokespecial 554	java/util/LinkedList:<init>	()V
    //   106: astore_1
    //   107: aload 12
    //   109: astore 13
    //   111: aload 12
    //   113: ldc 44
    //   115: invokeinterface 557 2 0
    //   120: istore_2
    //   121: aload 12
    //   123: astore 13
    //   125: aload 12
    //   127: ldc 46
    //   129: invokeinterface 557 2 0
    //   134: istore_3
    //   135: aload 12
    //   137: astore 13
    //   139: aload 12
    //   141: ldc 52
    //   143: invokeinterface 557 2 0
    //   148: istore 4
    //   150: aload 12
    //   152: astore 13
    //   154: aload 12
    //   156: ldc 50
    //   158: invokeinterface 557 2 0
    //   163: istore 5
    //   165: aload 12
    //   167: astore 13
    //   169: aload 12
    //   171: ldc 141
    //   173: invokeinterface 557 2 0
    //   178: istore 6
    //   180: aload 12
    //   182: astore 13
    //   184: aload 12
    //   186: ldc 54
    //   188: invokeinterface 557 2 0
    //   193: istore 7
    //   195: aload 12
    //   197: astore 13
    //   199: aload 12
    //   201: ldc 56
    //   203: invokeinterface 557 2 0
    //   208: istore 8
    //   210: aload 12
    //   212: astore 13
    //   214: aload 12
    //   216: ldc_w 559
    //   219: invokeinterface 557 2 0
    //   224: istore 9
    //   226: aload 12
    //   228: astore 13
    //   230: aload 12
    //   232: invokeinterface 340 1 0
    //   237: ifeq +326 -> 563
    //   240: aload 12
    //   242: astore 13
    //   244: aload 12
    //   246: iload_2
    //   247: invokeinterface 344 2 0
    //   252: astore 16
    //   254: aload 12
    //   256: astore 13
    //   258: aload 12
    //   260: iload_3
    //   261: invokeinterface 344 2 0
    //   266: astore 17
    //   268: aload 12
    //   270: astore 13
    //   272: aload 16
    //   274: invokestatic 367	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne -51 -> 226
    //   280: aload 12
    //   282: astore 13
    //   284: aload 17
    //   286: invokestatic 367	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne -63 -> 226
    //   292: aload 12
    //   294: astore 13
    //   296: aload 12
    //   298: iload 4
    //   300: invokeinterface 344 2 0
    //   305: astore 14
    //   307: aload 12
    //   309: astore 13
    //   311: aload 12
    //   313: iload 5
    //   315: invokeinterface 378 2 0
    //   320: lstore 10
    //   322: aload 12
    //   324: astore 13
    //   326: new 252	com/tencent/mobileqq/data/QQAlbumInfo
    //   329: dup
    //   330: invokespecial 441	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   333: astore 15
    //   335: aload 12
    //   337: astore 13
    //   339: aload 15
    //   341: aload 17
    //   343: putfield 449	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   346: aload 12
    //   348: astore 13
    //   350: aload 15
    //   352: aload 16
    //   354: putfield 254	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   357: aload 12
    //   359: astore 13
    //   361: aload 15
    //   363: lload 10
    //   365: putfield 562	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   368: aload 12
    //   370: astore 13
    //   372: aload 15
    //   374: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   377: astore 16
    //   379: aload 12
    //   381: astore 13
    //   383: aload 16
    //   385: aload 14
    //   387: putfield 387	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   390: aload 12
    //   392: astore 13
    //   394: aload 16
    //   396: aload 12
    //   398: iload 6
    //   400: invokeinterface 378 2 0
    //   405: putfield 384	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   408: aload 12
    //   410: astore 13
    //   412: aload 16
    //   414: lload 10
    //   416: putfield 393	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   419: aload 12
    //   421: astore 13
    //   423: aload 16
    //   425: aload 12
    //   427: iload 7
    //   429: invokeinterface 565 2 0
    //   434: putfield 567	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   437: aload 12
    //   439: astore 13
    //   441: aload 16
    //   443: aload 12
    //   445: iload 8
    //   447: invokeinterface 344 2 0
    //   452: putfield 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   455: aload 12
    //   457: astore 13
    //   459: ldc 104
    //   461: aload 16
    //   463: getfield 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   466: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +15 -> 484
    //   472: aload 12
    //   474: astore 13
    //   476: aload 16
    //   478: ldc_w 569
    //   481: putfield 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   484: aload 12
    //   486: astore 13
    //   488: aload 15
    //   490: aload 12
    //   492: iload 9
    //   494: invokeinterface 565 2 0
    //   499: putfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   502: aload 12
    //   504: astore 13
    //   506: aload_1
    //   507: aload 15
    //   509: invokeinterface 241 2 0
    //   514: pop
    //   515: goto -289 -> 226
    //   518: astore 14
    //   520: aload 12
    //   522: astore 13
    //   524: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +19 -> 546
    //   530: aload 12
    //   532: astore 13
    //   534: ldc_w 571
    //   537: iconst_2
    //   538: ldc_w 573
    //   541: aload 14
    //   543: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   546: aload_1
    //   547: astore 13
    //   549: aload 12
    //   551: ifnull -490 -> 61
    //   554: aload 12
    //   556: invokeinterface 514 1 0
    //   561: aload_1
    //   562: areturn
    //   563: aload_1
    //   564: astore 13
    //   566: aload 12
    //   568: ifnull -507 -> 61
    //   571: aload 12
    //   573: invokeinterface 514 1 0
    //   578: aload_1
    //   579: areturn
    //   580: astore_1
    //   581: aconst_null
    //   582: astore 13
    //   584: aload 13
    //   586: ifnull +10 -> 596
    //   589: aload 13
    //   591: invokeinterface 514 1 0
    //   596: aload_1
    //   597: athrow
    //   598: astore_1
    //   599: goto -15 -> 584
    //   602: astore 14
    //   604: aconst_null
    //   605: astore 12
    //   607: aconst_null
    //   608: astore_1
    //   609: goto -89 -> 520
    //   612: astore 14
    //   614: aconst_null
    //   615: astore_1
    //   616: goto -96 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	awul
    //   0	619	1	paramContext	Context
    //   0	619	2	paramInt	int
    //   134	127	3	i	int
    //   148	151	4	j	int
    //   163	151	5	k	int
    //   178	221	6	m	int
    //   193	235	7	n	int
    //   208	238	8	i1	int
    //   224	269	9	i2	int
    //   320	95	10	l	long
    //   7	599	12	localObject1	java.lang.Object
    //   44	546	13	localObject2	java.lang.Object
    //   305	81	14	str1	String
    //   518	24	14	localException1	java.lang.Exception
    //   602	1	14	localException2	java.lang.Exception
    //   612	1	14	localException3	java.lang.Exception
    //   333	175	15	localQQAlbumInfo	QQAlbumInfo
    //   252	225	16	localObject3	java.lang.Object
    //   266	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   111	121	518	java/lang/Exception
    //   125	135	518	java/lang/Exception
    //   139	150	518	java/lang/Exception
    //   154	165	518	java/lang/Exception
    //   169	180	518	java/lang/Exception
    //   184	195	518	java/lang/Exception
    //   199	210	518	java/lang/Exception
    //   214	226	518	java/lang/Exception
    //   230	240	518	java/lang/Exception
    //   244	254	518	java/lang/Exception
    //   258	268	518	java/lang/Exception
    //   272	280	518	java/lang/Exception
    //   284	292	518	java/lang/Exception
    //   296	307	518	java/lang/Exception
    //   311	322	518	java/lang/Exception
    //   326	335	518	java/lang/Exception
    //   339	346	518	java/lang/Exception
    //   350	357	518	java/lang/Exception
    //   361	368	518	java/lang/Exception
    //   372	379	518	java/lang/Exception
    //   383	390	518	java/lang/Exception
    //   394	408	518	java/lang/Exception
    //   412	419	518	java/lang/Exception
    //   423	437	518	java/lang/Exception
    //   441	455	518	java/lang/Exception
    //   459	472	518	java/lang/Exception
    //   476	484	518	java/lang/Exception
    //   488	502	518	java/lang/Exception
    //   506	515	518	java/lang/Exception
    //   4	9	580	finally
    //   9	36	580	finally
    //   64	92	580	finally
    //   99	107	598	finally
    //   111	121	598	finally
    //   125	135	598	finally
    //   139	150	598	finally
    //   154	165	598	finally
    //   169	180	598	finally
    //   184	195	598	finally
    //   199	210	598	finally
    //   214	226	598	finally
    //   230	240	598	finally
    //   244	254	598	finally
    //   258	268	598	finally
    //   272	280	598	finally
    //   284	292	598	finally
    //   296	307	598	finally
    //   311	322	598	finally
    //   326	335	598	finally
    //   339	346	598	finally
    //   350	357	598	finally
    //   361	368	598	finally
    //   372	379	598	finally
    //   383	390	598	finally
    //   394	408	598	finally
    //   412	419	598	finally
    //   423	437	598	finally
    //   441	455	598	finally
    //   459	472	598	finally
    //   476	484	598	finally
    //   488	502	598	finally
    //   506	515	598	finally
    //   524	530	598	finally
    //   534	546	598	finally
    //   4	9	602	java/lang/Exception
    //   9	36	602	java/lang/Exception
    //   64	92	602	java/lang/Exception
    //   99	107	612	java/lang/Exception
  }
  
  QQAlbumInfo queryRecentImageBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    paramArrayList = this.a.queryRecentImageList(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = QAlbumUtil.queryRecentVideos(paramContext, 0, paramInt2, paramMediaFileFilter, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) {}
    for (localQQAlbumInfo.mMediaFileCount += paramContext.size();; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  public QQAlbumInfo queryRecentMediaBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (paramMediaFileFilter == null) {
      return null;
    }
    if (paramMediaFileFilter.showImage()) {
      return queryRecentImageBucket(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    }
    return queryRecentVideoBucket(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
  }
  
  /* Error */
  QQAlbumInfo queryRecentVideoBucket(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 604	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 606
    //   17: invokespecial 607	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 252	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 441	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 256
    //   35: putfield 254	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   38: aload 8
    //   40: getstatic 581	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:RECENT_ALBUM_NAME	Ljava/lang/String;
    //   43: putfield 449	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   46: iload_3
    //   47: ifle +143 -> 190
    //   50: getstatic 455	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 536	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 538
    //   63: iload_3
    //   64: invokestatic 541	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 547	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 551	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   76: astore 5
    //   78: aload_1
    //   79: invokevirtual 461	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: aload 5
    //   84: getstatic 149	awul:VIDEO_COLUMNS	[Ljava/lang/String;
    //   87: ldc_w 463
    //   90: aconst_null
    //   91: ldc_w 465
    //   94: invokestatic 471	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore_1
    //   98: aload 4
    //   100: ifnull +16 -> 116
    //   103: aload_1
    //   104: astore 5
    //   106: aload_0
    //   107: aload_1
    //   108: iload_3
    //   109: aload 4
    //   111: invokevirtual 477	awul:getVideoList	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +59 -> 177
    //   121: aload_1
    //   122: astore 5
    //   124: aload 6
    //   126: invokeinterface 237 1 0
    //   131: ifne +46 -> 177
    //   134: aload_1
    //   135: astore 5
    //   137: aload 6
    //   139: invokeinterface 289 1 0
    //   144: istore_2
    //   145: aload_1
    //   146: astore 5
    //   148: aload 8
    //   150: iload_2
    //   151: putfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   154: iload_2
    //   155: ifle +22 -> 177
    //   158: aload_1
    //   159: astore 5
    //   161: aload 8
    //   163: aload 6
    //   165: iconst_0
    //   166: invokeinterface 250 2 0
    //   171: checkcast 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   174: putfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   177: aload_1
    //   178: ifnull +9 -> 187
    //   181: aload_1
    //   182: invokeinterface 514 1 0
    //   187: aload 8
    //   189: areturn
    //   190: getstatic 455	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   193: astore 5
    //   195: goto -117 -> 78
    //   198: astore 4
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: astore 5
    //   205: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +20 -> 228
    //   211: aload_1
    //   212: astore 5
    //   214: ldc_w 356
    //   217: iconst_2
    //   218: aload 4
    //   220: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   223: aload 4
    //   225: invokestatic 520	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: ifnull -42 -> 187
    //   232: aload_1
    //   233: invokeinterface 514 1 0
    //   238: aload 8
    //   240: areturn
    //   241: astore_1
    //   242: aload 7
    //   244: astore 4
    //   246: aload 4
    //   248: ifnull +10 -> 258
    //   251: aload 4
    //   253: invokeinterface 514 1 0
    //   258: aload_1
    //   259: athrow
    //   260: astore_1
    //   261: aload 5
    //   263: astore 4
    //   265: goto -19 -> 246
    //   268: astore 4
    //   270: goto -68 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	awul
    //   0	273	1	paramContext	Context
    //   0	273	2	paramInt1	int
    //   0	273	3	paramInt2	int
    //   0	273	4	paramMediaFileFilter	MediaFileFilter
    //   56	206	5	localObject1	java.lang.Object
    //   4	160	6	localList	List
    //   1	242	7	localObject2	java.lang.Object
    //   28	211	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   50	78	198	java/lang/Exception
    //   78	98	198	java/lang/Exception
    //   190	195	198	java/lang/Exception
    //   50	78	241	finally
    //   78	98	241	finally
    //   190	195	241	finally
    //   106	116	260	finally
    //   124	134	260	finally
    //   137	145	260	finally
    //   148	154	260	finally
    //   161	177	260	finally
    //   205	211	260	finally
    //   214	228	260	finally
    //   106	116	268	java/lang/Exception
    //   124	134	268	java/lang/Exception
    //   137	145	268	java/lang/Exception
    //   148	154	268	java/lang/Exception
    //   161	177	268	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> queryVideoBuckets(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +51 -> 52
    //   4: getstatic 455	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 461	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 151	awul:VIDEO_PROJECTION_BUCKET	[Ljava/lang/String;
    //   16: ldc_w 611
    //   19: aconst_null
    //   20: ldc_w 530
    //   23: invokestatic 471	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull +51 -> 79
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: astore 12
    //   36: aload_3
    //   37: ifnull +12 -> 49
    //   40: aload_3
    //   41: invokeinterface 514 1 0
    //   46: aload_1
    //   47: astore 12
    //   49: aload 12
    //   51: areturn
    //   52: getstatic 455	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: invokevirtual 536	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 538
    //   63: iload_2
    //   64: invokestatic 541	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 547	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 551	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   75: astore_3
    //   76: goto -68 -> 8
    //   79: aload_3
    //   80: astore 12
    //   82: new 553	java/util/LinkedList
    //   85: dup
    //   86: invokespecial 554	java/util/LinkedList:<init>	()V
    //   89: astore_1
    //   90: aload_3
    //   91: astore 12
    //   93: aload_3
    //   94: ldc 44
    //   96: invokeinterface 557 2 0
    //   101: istore_2
    //   102: aload_3
    //   103: astore 12
    //   105: aload_3
    //   106: ldc 141
    //   108: invokeinterface 557 2 0
    //   113: istore 4
    //   115: aload_3
    //   116: astore 12
    //   118: aload_3
    //   119: ldc 46
    //   121: invokeinterface 557 2 0
    //   126: istore 5
    //   128: aload_3
    //   129: astore 12
    //   131: aload_3
    //   132: ldc 52
    //   134: invokeinterface 557 2 0
    //   139: istore 6
    //   141: aload_3
    //   142: astore 12
    //   144: aload_3
    //   145: ldc 50
    //   147: invokeinterface 557 2 0
    //   152: istore 7
    //   154: aload_3
    //   155: astore 12
    //   157: aload_3
    //   158: ldc 56
    //   160: invokeinterface 557 2 0
    //   165: istore 8
    //   167: aload_3
    //   168: astore 12
    //   170: aload_3
    //   171: ldc_w 559
    //   174: invokeinterface 557 2 0
    //   179: istore 9
    //   181: aload_3
    //   182: astore 12
    //   184: aload_3
    //   185: invokeinterface 340 1 0
    //   190: ifeq +245 -> 435
    //   193: aload_3
    //   194: astore 12
    //   196: aload_3
    //   197: iload_2
    //   198: invokeinterface 344 2 0
    //   203: astore 14
    //   205: aload_3
    //   206: astore 12
    //   208: aload_3
    //   209: iload 5
    //   211: invokeinterface 344 2 0
    //   216: astore 15
    //   218: aload_3
    //   219: astore 12
    //   221: aload 14
    //   223: invokestatic 367	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne -45 -> 181
    //   229: aload_3
    //   230: astore 12
    //   232: aload 15
    //   234: invokestatic 367	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne -56 -> 181
    //   240: aload_3
    //   241: astore 12
    //   243: aload_3
    //   244: iload 7
    //   246: invokeinterface 378 2 0
    //   251: lstore 10
    //   253: aload_3
    //   254: astore 12
    //   256: new 252	com/tencent/mobileqq/data/QQAlbumInfo
    //   259: dup
    //   260: invokespecial 441	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   263: astore 13
    //   265: aload_3
    //   266: astore 12
    //   268: aload 13
    //   270: aload 15
    //   272: putfield 449	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   275: aload_3
    //   276: astore 12
    //   278: aload 13
    //   280: aload 14
    //   282: putfield 254	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   285: aload_3
    //   286: astore 12
    //   288: aload 13
    //   290: lload 10
    //   292: putfield 562	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   295: aload_3
    //   296: astore 12
    //   298: aload 13
    //   300: getfield 324	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   303: astore 14
    //   305: aload_3
    //   306: astore 12
    //   308: aload 14
    //   310: aload_3
    //   311: iload 6
    //   313: invokeinterface 344 2 0
    //   318: putfield 387	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   321: aload_3
    //   322: astore 12
    //   324: aload 14
    //   326: aload_3
    //   327: iload 4
    //   329: invokeinterface 378 2 0
    //   334: putfield 384	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   337: aload_3
    //   338: astore 12
    //   340: aload 14
    //   342: lload 10
    //   344: putfield 393	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   347: aload_3
    //   348: astore 12
    //   350: aload 14
    //   352: aload_3
    //   353: iload 8
    //   355: invokeinterface 344 2 0
    //   360: putfield 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   363: aload_3
    //   364: astore 12
    //   366: aload 13
    //   368: aload_3
    //   369: iload 9
    //   371: invokeinterface 565 2 0
    //   376: putfield 294	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   379: aload_3
    //   380: astore 12
    //   382: aload_1
    //   383: aload 13
    //   385: invokeinterface 241 2 0
    //   390: pop
    //   391: goto -210 -> 181
    //   394: astore 13
    //   396: aload_3
    //   397: astore 12
    //   399: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +18 -> 420
    //   405: aload_3
    //   406: astore 12
    //   408: ldc_w 571
    //   411: iconst_2
    //   412: ldc_w 613
    //   415: aload 13
    //   417: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload_1
    //   421: astore 12
    //   423: aload_3
    //   424: ifnull -375 -> 49
    //   427: aload_3
    //   428: invokeinterface 514 1 0
    //   433: aload_1
    //   434: areturn
    //   435: aload_1
    //   436: astore 12
    //   438: aload_3
    //   439: ifnull -390 -> 49
    //   442: aload_3
    //   443: invokeinterface 514 1 0
    //   448: aload_1
    //   449: areturn
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 12
    //   454: aload 12
    //   456: ifnull +10 -> 466
    //   459: aload 12
    //   461: invokeinterface 514 1 0
    //   466: aload_1
    //   467: athrow
    //   468: astore_1
    //   469: goto -15 -> 454
    //   472: astore 13
    //   474: aconst_null
    //   475: astore_3
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -82 -> 396
    //   481: astore 13
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -89 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	awul
    //   0	488	1	paramContext	Context
    //   0	488	2	paramInt	int
    //   0	488	3	paramMediaFileFilter	MediaFileFilter
    //   113	215	4	i	int
    //   126	84	5	j	int
    //   139	173	6	k	int
    //   152	93	7	m	int
    //   165	189	8	n	int
    //   179	191	9	i1	int
    //   251	92	10	l	long
    //   34	426	12	localObject1	java.lang.Object
    //   263	121	13	localQQAlbumInfo	QQAlbumInfo
    //   394	22	13	localException1	java.lang.Exception
    //   472	1	13	localException2	java.lang.Exception
    //   481	1	13	localException3	java.lang.Exception
    //   203	148	14	localObject2	java.lang.Object
    //   216	55	15	str	String
    // Exception table:
    //   from	to	target	type
    //   93	102	394	java/lang/Exception
    //   105	115	394	java/lang/Exception
    //   118	128	394	java/lang/Exception
    //   131	141	394	java/lang/Exception
    //   144	154	394	java/lang/Exception
    //   157	167	394	java/lang/Exception
    //   170	181	394	java/lang/Exception
    //   184	193	394	java/lang/Exception
    //   196	205	394	java/lang/Exception
    //   208	218	394	java/lang/Exception
    //   221	229	394	java/lang/Exception
    //   232	240	394	java/lang/Exception
    //   243	253	394	java/lang/Exception
    //   256	265	394	java/lang/Exception
    //   268	275	394	java/lang/Exception
    //   278	285	394	java/lang/Exception
    //   288	295	394	java/lang/Exception
    //   298	305	394	java/lang/Exception
    //   308	321	394	java/lang/Exception
    //   324	337	394	java/lang/Exception
    //   340	347	394	java/lang/Exception
    //   350	363	394	java/lang/Exception
    //   366	379	394	java/lang/Exception
    //   382	391	394	java/lang/Exception
    //   4	8	450	finally
    //   8	27	450	finally
    //   52	76	450	finally
    //   82	90	468	finally
    //   93	102	468	finally
    //   105	115	468	finally
    //   118	128	468	finally
    //   131	141	468	finally
    //   144	154	468	finally
    //   157	167	468	finally
    //   170	181	468	finally
    //   184	193	468	finally
    //   196	205	468	finally
    //   208	218	468	finally
    //   221	229	468	finally
    //   232	240	468	finally
    //   243	253	468	finally
    //   256	265	468	finally
    //   268	275	468	finally
    //   278	285	468	finally
    //   288	295	468	finally
    //   298	305	468	finally
    //   308	321	468	finally
    //   324	337	468	finally
    //   340	347	468	finally
    //   350	363	468	finally
    //   366	379	468	finally
    //   382	391	468	finally
    //   399	405	468	finally
    //   408	420	468	finally
    //   4	8	472	java/lang/Exception
    //   8	27	472	java/lang/Exception
    //   52	76	472	java/lang/Exception
    //   82	90	481	java/lang/Exception
  }
  
  public void setData(List<QQAlbumInfo> paramList)
  {
    this.mDataInfos.clear();
    if (paramList != null) {
      this.mDataInfos.addAll(paramList);
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awul
 * JD-Core Version:    0.7.0.1
 */