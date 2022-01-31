import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.io.File;

public abstract interface vvh
{
  public abstract void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean);
  
  public abstract void a(VideoViewVideoHolder paramVideoViewVideoHolder, vwa paramvwa);
  
  public abstract boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, vwa paramvwa, int paramInt, Object paramObject);
  
  public abstract boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, vwa paramvwa, boolean paramBoolean);
  
  public abstract void b(VideoViewVideoHolder paramVideoViewVideoHolder, vwa paramvwa);
  
  public abstract void c(VideoViewVideoHolder paramVideoViewVideoHolder, vwa paramvwa);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvh
 * JD-Core Version:    0.7.0.1
 */