import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

class mrd
  implements angp.a
{
  mrd(mra parammra) {}
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        anfv.jw(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(mra.a(this.a), localArrayList);
      if (paramInt1 == 0)
      {
        ShortVideoResourceManager.a(mra.a(this.a), localArrayList, this.a.a);
        return;
      }
      anfv.jw(1, paramInt1);
      return;
    }
    anfv.jw(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrd
 * JD-Core Version:    0.7.0.1
 */