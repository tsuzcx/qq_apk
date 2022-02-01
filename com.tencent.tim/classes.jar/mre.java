import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class mre
  implements ShortVideoResourceManager.c
{
  mre(mra parammra) {}
  
  public void aFW()
  {
    anfv.jw(3, -1500);
  }
  
  public void f(String paramString, long paramLong1, long paramLong2) {}
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label62;
      }
      anfv.jw(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label62:
      mra.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mre
 * JD-Core Version:    0.7.0.1
 */