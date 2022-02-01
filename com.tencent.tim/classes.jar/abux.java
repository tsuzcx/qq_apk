import java.io.File;

class abux
  implements abto.b
{
  abux(abuk paramabuk, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.val$file.exists())
      {
        this.a.M(this.val$callbackId, 0, paramInt2 + acfp.m(2131702652));
        return;
      }
      this.a.M(this.val$callbackId, 2, paramInt2 + acfp.m(2131702628));
      return;
    }
    this.a.M(this.val$callbackId, 2, paramInt2 + acfp.m(2131702649));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abux
 * JD-Core Version:    0.7.0.1
 */