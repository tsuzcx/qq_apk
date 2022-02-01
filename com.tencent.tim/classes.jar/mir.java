import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class mir
{
  @NotNull
  public static final ArrayList<mir.a> d(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplication.getContext().getContentResolver();
    Object localObject2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    String str = "date_modified DESC limit " + paramInt2 + " offset " + paramInt1;
    localObject1 = alld.query((ContentResolver)localObject1, (Uri)localObject2, new String[] { "_id", "_data", "_size", "date_modified", "duration", "resolution", "title", "mime_type" }, "duration>0", null, str);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      paramInt1 = 0;
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new mir.a();
        ((mir.a)localObject2).isVideo = true;
        ((mir.a)localObject2).vX = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_id"));
        ((mir.a)localObject2).path = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("_data"));
        ((mir.a)localObject2).fileSize = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_size"));
        ((mir.a)localObject2).videoDuration = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("duration"));
        ((mir.a)localObject2).aiV = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("resolution"));
        ((mir.a)localObject2).modifiedDate = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_modified"));
        ((mir.a)localObject2).videoFileName = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("title"));
        ((mir.a)localObject2).mimeType = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        ((mir.a)localObject2).thumbPath = ((mir.a)localObject2).path;
        localArrayList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
        QLog.d("AlbumUtils", 2, "queryVideoList index:" + paramInt1);
        paramInt1 += 1;
      }
    }
    return localArrayList;
  }
  
  @NotNull
  public static final ArrayList<mir.a> e(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplication.getContext().getContentResolver();
    Object localObject2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    Object localObject3 = "date_modified DESC limit " + paramInt2 + " offset " + paramInt1;
    localObject1 = alld.query((ContentResolver)localObject1, (Uri)localObject2, new String[] { "_id", "_data", "_size", "date_modified", "mime_type" }, null, null, (String)localObject3);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new mir.a();
        ((mir.a)localObject2).isVideo = false;
        ((mir.a)localObject2).vX = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_id"));
        ((mir.a)localObject2).path = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("_data"));
        ((mir.a)localObject2).fileSize = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_size"));
        ((mir.a)localObject2).modifiedDate = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_modified"));
        ((mir.a)localObject2).mimeType = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        ((mir.a)localObject2).coverPath = ((mir.a)localObject2).path;
        ((mir.a)localObject2).thumbPath = ((mir.a)localObject2).coverPath;
        localObject3 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject3).mediaWidth = ((mir.a)localObject2).getWidth();
        ((LocalMediaInfo)localObject3).mediaHeight = ((mir.a)localObject2).getHeight();
        ((LocalMediaInfo)localObject3).path = ((mir.a)localObject2).path;
        ((mir.a)localObject2).c = ((LocalMediaInfo)localObject3);
        localArrayList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
    }
    return localArrayList;
  }
  
  public static final class a
  {
    public int aTo;
    public int aTp;
    public String aiV;
    private String aiW;
    private boolean amR;
    public LocalMediaInfo c;
    @NotNull
    public String coverPath = "";
    private int[] dl = new int[2];
    public long fileSize;
    public boolean isVideo = true;
    @Nullable
    public String mimeType;
    public long modifiedDate;
    @Nullable
    public String path;
    public String thumbPath = "";
    public long vX;
    public long videoDuration;
    public String videoFileName;
    
    private void aPd()
    {
      for (int i = 0;; i = 1) {
        for (;;)
        {
          try
          {
            if (this.amR) {
              return;
            }
            MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
            localMediaMetadataRetriever.setDataSource(this.path);
            int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
            int k = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
            if (Build.VERSION.SDK_INT >= 17)
            {
              int m = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
              if ((m == 90) || (m == 270)) {
                break;
              }
              if (i != 0)
              {
                this.aiW = (k + "x" + j);
                this.amR = true;
              }
            }
            else
            {
              QLog.e("LocalMediaInfo", 1, "checkAndSetExifResolution can't get rotation...");
              continue;
            }
            this.aiW = (j + "x" + k);
          }
          catch (Throwable localThrowable)
          {
            QLog.e("LocalMediaInfo", 1, "checkAndSetExifResolution", localThrowable);
            return;
          }
        }
      }
    }
    
    private void aPe()
    {
      if ((this.dl[0] == 0) || (this.dl[1] == 0))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.path, localOptions);
        this.dl[0] = localOptions.outWidth;
        this.dl[1] = localOptions.outHeight;
      }
    }
    
    private int f(String paramString, boolean paramBoolean)
    {
      int j = 0;
      try
      {
        paramString = paramString.split("x");
        if (paramBoolean) {}
        for (int i = 0;; i = 1)
        {
          if (paramString.length >= 2) {
            j = Integer.parseInt(paramString[i]);
          }
          return j;
        }
        return 0;
      }
      catch (Throwable paramString)
      {
        QLog.e("LocalMediaInfo", 1, "getWidth error", paramString);
      }
    }
    
    public int getHeight()
    {
      if (!this.isVideo)
      {
        aPe();
        return this.dl[1];
      }
      aPd();
      if (TextUtils.isEmpty(this.aiW)) {
        return f(this.aiV, false);
      }
      return f(this.aiW, false);
    }
    
    public int getWidth()
    {
      if (!this.isVideo)
      {
        aPe();
        return this.dl[0];
      }
      aPd();
      if (TextUtils.isEmpty(this.aiW)) {
        return f(this.aiV, true);
      }
      return f(this.aiW, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mir
 * JD-Core Version:    0.7.0.1
 */