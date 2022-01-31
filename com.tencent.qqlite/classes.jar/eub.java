import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceInfo;

public class eub
  extends FriendListObserver
{
  private eub(FaceDrawable paramFaceDrawable) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    FaceDrawable.a(this.a, paramBoolean, 1, paramString, FaceDrawable.a(this.a));
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    int i = 200;
    if (paramInt == 3000) {}
    while (i != FaceDrawable.a(this.a).d)
    {
      return;
      if (paramInt == 3001) {
        i = 202;
      } else if (paramInt == 3002) {
        i = 204;
      }
    }
    FaceDrawable.a(this.a, paramBoolean1, 32, paramString, FaceDrawable.a(this.a));
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    FaceDrawable.a(this.a, paramBoolean, 11, paramString, FaceDrawable.a(this.a));
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    FaceDrawable.a(this.a, paramBoolean, 4, paramString, FaceDrawable.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eub
 * JD-Core Version:    0.7.0.1
 */