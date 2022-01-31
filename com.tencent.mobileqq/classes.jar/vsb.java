import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;

public class vsb
  implements Runnable
{
  public vsb(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    if (this.a.o) {
      return;
    }
    AIOGalleryScene localAIOGalleryScene = this.a;
    localAIOGalleryScene.h += this.a.i;
    if (this.a.h > 99)
    {
      this.a.h = 99;
      this.a.d(this.a.h);
      return;
    }
    this.a.d(this.a.h);
    this.a.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsb
 * JD-Core Version:    0.7.0.1
 */