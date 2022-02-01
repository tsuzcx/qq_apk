import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

class angk
  implements angp.a
{
  angk(angj paramangj) {}
  
  public void cu(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadConfigNoLogin onConfigResult | result=").append(paramInt1).append("serverError=").append(paramInt2);
    VideoEnvironment.k(angj.access$000(), ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.k(angj.access$000(), "startDownloadConfigNoLogin onConfigResult| uncompress config error=" + paramInt2, null);
        angj.b(this.a);
        return;
      }
      localObject = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(angj.a(this.a), (List)localObject);
      if (paramInt1 == 0)
      {
        VideoEnvironment.k(angj.access$000(), "startDownloadConfigNoLogin onConfigResult| check config success...", null);
        angj.a(this.a).dPn();
        aiaq.a().aoI();
        return;
      }
      VideoEnvironment.k(angj.access$000(), "startDownloadConfigNoLogin onConfigResult| check config error=" + paramInt1, null);
      angj.b(this.a);
      return;
    }
    VideoEnvironment.k(angj.access$000(), "startDownloadConfigNoLogin onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    angj.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angk
 * JD-Core Version:    0.7.0.1
 */