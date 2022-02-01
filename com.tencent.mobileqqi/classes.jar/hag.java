import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.util.FaceDecoder;

public class hag
  extends FriendListObserver
{
  private hag(FaceDecoder paramFaceDecoder) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    FaceDecoder.a(this.a, paramBoolean, (byte)1, paramString);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    FaceDecoder.a(this.a, paramBoolean, (byte)11, paramString);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    FaceDecoder.a(this.a, paramBoolean, (byte)4, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hag
 * JD-Core Version:    0.7.0.1
 */