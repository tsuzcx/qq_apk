import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;

class vmb
  extends IAIOImageProviderCallBack.Stub
{
  vmb(vma paramvma) {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new vmd(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new vmc(this, paramBoolean, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.a.a.runOnUiThread(new vme(this, paramArrayOfAIORichMediaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vmb
 * JD-Core Version:    0.7.0.1
 */