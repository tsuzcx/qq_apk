import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;

public class xoz
  extends xvd<Integer>
{
  private int jdField_a_of_type_Int;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private LruCache<Integer, Drawable> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(180);
  private String jdField_a_of_type_JavaLangString;
  public xpb a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public xoz(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramString);
    this.jdField_a_of_type_Xpb = new xpb();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public LruCache<Integer, Drawable> a()
  {
    return this.jdField_a_of_type_AndroidSupportV4UtilLruCache;
  }
  
  public xve a(ImageView paramImageView, Integer paramInteger)
  {
    return new xpa(paramImageView, this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever, paramInteger, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.d, this.c, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Xpb, this.jdField_b_of_type_Boolean);
  }
  
  @TargetApi(10)
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever != null) {
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Xpb == null) {
      return;
    }
    wxj.b("upload_local_video", "get_frame_cost", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Xpb.jdField_a_of_type_Int), this.jdField_a_of_type_Xpb.toString(), QQStoryFlowCallback.a(paramLocalMediaInfo) });
  }
  
  @TargetApi(10)
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    wxe.a("Q.qqstory.frameWidget.FrameLoader", "initVideo,duration=%s,path=%s", Integer.valueOf(paramInt1), paramString);
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ajvq.a(paramString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, 0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
          this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.setDataSource(paramString);
          if (Build.VERSION.SDK_INT >= 26) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_JavaLangString = paramString;
          this.c = paramInt2;
          c();
          return;
          ajvq.a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          continue;
          localException1 = localException1;
          this.jdField_b_of_type_Boolean = false;
          wxe.c("Q.qqstory.frameWidget.FrameLoader", "ThumbnailUtils init failed! e:%s", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          wxe.e("Q.qqstory.frameWidget.FrameLoader", wrm.a(new Object[] { "MediaMetadataRetriever init failed! mVideoPath = ", paramString, "  e=", localException2 }));
          wxj.b("story_local_video", "frame_loader", 0, 0, new String[] { paramString, localException2.getMessage() });
          this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoz
 * JD-Core Version:    0.7.0.1
 */