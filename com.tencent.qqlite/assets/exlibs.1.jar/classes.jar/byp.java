import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;

class byp
  extends IAIOImageProviderCallBack.Stub
{
  byp(byo parambyo) {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    this.a.a.runOnUiThread(new byr(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.a.a.runOnUiThread(new byq(this, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    this.a.a.runOnUiThread(new bys(this, paramArrayOfAIOImageData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byp
 * JD-Core Version:    0.7.0.1
 */