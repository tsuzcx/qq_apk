import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class zrv
{
  PhotoCropActivity a;
  String[] cY;
  
  public zrv(PhotoCropActivity paramPhotoCropActivity)
  {
    this.a = paramPhotoCropActivity;
  }
  
  public void C(String[] paramArrayOfString)
  {
    this.cY = paramArrayOfString;
  }
  
  public void Ft(int paramInt) {}
  
  public void Qq()
  {
    if ((this.cY != null) && (this.cY.length > 0))
    {
      ausj localausj = (ausj)auss.a(this.a, null);
      int i = 0;
      while (i < this.cY.length)
      {
        localausj.addButton(this.cY[i], 1);
        i += 1;
      }
      localausj.addCancelButton(2131721058);
      localausj.a(new zrw(this, localausj));
      localausj.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrv
 * JD-Core Version:    0.7.0.1
 */