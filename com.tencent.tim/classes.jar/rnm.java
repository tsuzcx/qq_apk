import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class rnm
  extends rru<Integer>
{
  public rnm.b a = new rnm.b();
  private boolean aGB;
  private boolean aIX;
  private LruCache<Integer, Drawable> mCache = new LruCache(180);
  private int mDuration;
  private int mFrameHeight;
  private int mFrameWidth;
  private int mInterval;
  private MediaMetadataRetriever mRetriever;
  private String mVideoPath;
  
  public rnm(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramString);
    this.mFrameWidth = paramInt1;
    this.mFrameHeight = paramInt2;
    this.aGB = paramBoolean;
  }
  
  public rrv a(ImageView paramImageView, Integer paramInteger)
  {
    return new rnm.a(paramImageView, this.mRetriever, paramInteger, this.mFrameWidth, this.mFrameHeight, this.mDuration, this.mInterval, this.aGB, this.a, this.aIX);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.a == null) {
      return;
    }
    rar.b("upload_local_video", "get_frame_cost", 0, 0, new String[] { String.valueOf(this.a.btv), this.a.toString(), QQStoryFlowCallback.a(paramLocalMediaInfo) });
  }
  
  public LruCache<Integer, Drawable> c()
  {
    return this.mCache;
  }
  
  @TargetApi(10)
  public void release()
  {
    super.release();
    this.mCache.evictAll();
    if (this.mRetriever != null) {
      this.mRetriever.release();
    }
  }
  
  @TargetApi(10)
  public void y(String paramString, int paramInt1, int paramInt2)
  {
    this.mDuration = paramInt1;
    ram.b("Q.qqstory.frameWidget.FrameLoader", "initVideo,duration=%s,path=%s", Integer.valueOf(paramInt1), paramString);
    try
    {
      if (this.aGB)
      {
        aaut.a(paramString, this.mFrameHeight, this.mFrameWidth, 0, 0, this.mFrameHeight, this.mFrameWidth);
        this.aIX = true;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.mRetriever = new MediaMetadataRetriever();
          this.mRetriever.setDataSource(paramString);
          if (Build.VERSION.SDK_INT >= 26) {
            this.aIX = false;
          }
          this.mVideoPath = paramString;
          this.mInterval = paramInt2;
          prepare();
          return;
          aaut.a(paramString, this.mFrameWidth, this.mFrameHeight, 0, 0, this.mFrameWidth, this.mFrameHeight);
          continue;
          localException1 = localException1;
          this.aIX = false;
          ram.e("Q.qqstory.frameWidget.FrameLoader", "ThumbnailUtils init failed! e:%s", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ram.e("Q.qqstory.frameWidget.FrameLoader", qwr.b(new Object[] { "MediaMetadataRetriever init failed! mVideoPath = ", paramString, "  e=", localException2 }));
          rar.b("story_local_video", "frame_loader", 0, 0, new String[] { paramString, localException2.getMessage() });
          this.mRetriever = null;
        }
      }
    }
  }
  
  public static class a
    extends rrv
  {
    private rnm.b a;
    private boolean aGB;
    private boolean aIX;
    private Integer index;
    private long mDuration;
    private int mFrameHeight;
    private int mFrameWidth;
    private int mInterval;
    private MediaMetadataRetriever mRetriever;
    
    public a(ImageView paramImageView, MediaMetadataRetriever paramMediaMetadataRetriever, Integer paramInteger, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean1, rnm.b paramb, boolean paramBoolean2)
    {
      super();
      this.index = paramInteger;
      this.mRetriever = paramMediaMetadataRetriever;
      this.mFrameWidth = paramInt1;
      this.mFrameHeight = paramInt2;
      this.mDuration = paramLong;
      this.mInterval = paramInt3;
      this.aGB = paramBoolean1;
      this.a = paramb;
      this.aIX = paramBoolean2;
    }
    
    @TargetApi(10)
    public void bri()
    {
      ram.w("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround:%s", new Object[] { key() });
      long l3 = System.currentTimeMillis();
      if ((rpq.LQ()) && (this.aIX)) {
        ram.w("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative:%s", new Object[] { key() });
      }
      long l1;
      Object localObject;
      Bitmap localBitmap2;
      for (;;)
      {
        try
        {
          Bitmap localBitmap1;
          if (this.aGB)
          {
            localBitmap1 = Bitmap.createBitmap(this.mFrameHeight, this.mFrameWidth, Bitmap.Config.ARGB_8888);
            l1 = this.index.intValue() * this.mInterval;
            long l2 = (this.index.intValue() + 1) * this.mInterval;
            l1 = l2;
            if (l2 > this.mDuration) {
              l1 = this.mDuration;
            }
            if (TrimNative.getThumbnail(0L, l1, localBitmap1) == 0)
            {
              Bitmap localBitmap3 = localBitmap1.copy(Bitmap.Config.RGB_565, true);
              localObject = localBitmap3;
              if (this.aGB) {
                localObject = rpq.rotateBitmap(localBitmap3, 90.0F);
              }
              L(new BitmapDrawable((Bitmap)localObject));
              localBitmap1.recycle();
              l1 = System.currentTimeMillis() - l3;
              ram.w("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), key() });
              this.a.S(this.index.intValue(), l1);
            }
          }
          else
          {
            localBitmap1 = Bitmap.createBitmap(this.mFrameWidth, this.mFrameHeight, Bitmap.Config.ARGB_8888);
            continue;
          }
          if ((localBitmap1 == null) || (localBitmap1.isRecycled())) {
            continue;
          }
          localBitmap1.recycle();
        }
        catch (Exception localException)
        {
          ram.e("Q.qqstory.frameWidget.FrameLoader", "create bitmap width=%s,height=%s,error:%s", new Object[] { Integer.valueOf(this.mFrameWidth), Integer.valueOf(this.mFrameHeight), localException });
          continue;
          localBitmap2 = this.mRetriever.getFrameAtTime(this.index.intValue() * this.mInterval * 1000L);
          if (localBitmap2 != null) {
            continue;
          }
          ram.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever return null!");
          return;
          localObject = new Matrix();
          if (!this.aGB) {
            break;
          }
        }
        if (this.mRetriever == null)
        {
          ram.e("Q.qqstory.frameWidget.FrameLoader", "mRetriever is null!");
          return;
          ram.e("Q.qqstory.frameWidget.FrameLoader", "TrimNative return error!");
        }
        else
        {
          float f1 = this.mFrameWidth / localBitmap2.getHeight();
          float f2 = this.mFrameHeight / localBitmap2.getWidth();
          ((Matrix)localObject).postRotate(90.0F);
          ((Matrix)localObject).postScale(f1, f2);
        }
      }
      for (;;)
      {
        localObject = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (Matrix)localObject, true);
        localBitmap2.recycle();
        L(new BitmapDrawable((Bitmap)localObject));
        l1 = System.currentTimeMillis() - l3;
        ram.w("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: mRetriever 完成时间:%s,key=%s", new Object[] { Long.valueOf(l1), key() });
        this.a.S(this.index.intValue(), l1);
        return;
        ((Matrix)localObject).postScale(this.mFrameWidth / localBitmap2.getWidth(), this.mFrameHeight / localBitmap2.getHeight());
      }
    }
    
    public String key()
    {
      return String.valueOf(this.index);
    }
  }
  
  public static class b
  {
    public long Cn;
    public int btv;
    public int btw = -1;
    private Map<Integer, Long> gk = new ConcurrentHashMap();
    
    public void S(int paramInt, long paramLong)
    {
      this.gk.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
      if (this.Cn < paramLong)
      {
        this.Cn = paramLong;
        this.btw = paramInt;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.gk.entrySet().iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((Long)((Map.Entry)localIterator.next()).getValue()).longValue() + l) {}
      if (this.gk.size() == 0) {
        return "there_is_no_frame";
      }
      this.btv = ((int)l / this.gk.size());
      localStringBuilder.append("avg:").append(this.btv).append("|max:").append(this.Cn).append("|maxId:").append(this.btw);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnm
 * JD-Core Version:    0.7.0.1
 */