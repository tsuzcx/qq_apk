import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.util.FaceDecoder;

public class ero
  extends FriendListObserver
{
  private ero(FaceDecoder paramFaceDecoder) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    FaceDecoder.a(this.a, paramBoolean, 1, paramString, 0);
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    int i = 200;
    if (paramInt == 3000) {}
    for (;;)
    {
      FaceDecoder.a(this.a, paramBoolean1, 32, paramString, i);
      return;
      if (paramInt == 3001) {
        i = 202;
      } else if (paramInt == 3002) {
        i = 204;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    FaceDecoder.a(this.a, paramBoolean, 11, paramString, 0);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    FaceDecoder.a(this.a, paramBoolean, 4, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ero
 * JD-Core Version:    0.7.0.1
 */