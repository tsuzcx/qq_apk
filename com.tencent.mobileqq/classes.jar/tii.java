import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import java.util.List;

class tii
  implements teo<stFeed>
{
  tii(tih paramtih) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      ((tit)this.a.a()).a(paramList);
      return;
    }
    ((tit)this.a.a()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    ((tit)this.a.a()).d();
    if (paramBoolean1) {
      ((tit)this.a.a()).b(paramBoolean2);
    }
    if (!paramBoolean2) {
      ((tit)this.a.a()).a(false, true);
    }
    for (;;)
    {
      return;
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (tlf.a(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((tit)this.a.a()).a(true, true);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tii
 * JD-Core Version:    0.7.0.1
 */