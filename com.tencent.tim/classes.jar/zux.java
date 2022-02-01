import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicAECamera.3.1;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicAECamera.3.2;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class zux
  implements sqo.a
{
  zux(zut paramzut, String paramString, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(sqo.b paramb)
  {
    Log.d("Q.videostory.capture", "success");
    paramb = new MediaMetadataRetriever();
    try
    {
      paramb.setDataSource(this.baV);
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.baV;
      localLocalMediaInfo.mDuration = Integer.parseInt(paramb.extractMetadata(9));
      localLocalMediaInfo.mediaWidth = Integer.parseInt(paramb.extractMetadata(18));
      localLocalMediaInfo.mediaHeight = Integer.parseInt(paramb.extractMetadata(19));
      localLocalMediaInfo.rotation = Integer.parseInt(paramb.extractMetadata(24));
      localLocalMediaInfo.mMediaType = 1;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.latitude = this.val$info.latitude;
      localLocalMediaInfo.longitude = this.val$info.longitude;
      localLocalMediaInfo.addedDate = this.val$info.addedDate;
      paramb.release();
      Bitmap localBitmap = aqcu.decodeFile(this.val$info.path);
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      long l2 = 0L;
      long l1 = l2;
      if (localBitmap != null)
      {
        l1 = l2;
        if (!localBitmap.isRecycled())
        {
          Object localObject = sqm.C(localBitmap);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
          localObject = localByteArrayOutputStream.toByteArray();
          l1 = localObject.length;
          localCopyOnWriteArrayList.add(new FrameVideoHelper.FrameBuffer((byte[])localObject));
          localByteArrayOutputStream.close();
          localBitmap.recycle();
        }
      }
      ThreadManager.getUIHandler().post(new PhotoListLogicAECamera.3.1(this, localCopyOnWriteArrayList, l1, localLocalMediaInfo));
      return;
    }
    catch (Exception localException)
    {
      paramb.release();
    }
  }
  
  public void b(sqo.b paramb)
  {
    ThreadManager.getUIHandler().post(new PhotoListLogicAECamera.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zux
 * JD-Core Version:    0.7.0.1
 */