import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import java.util.List;

class olv
  implements oie.b<stFeed>
{
  olv(olu paramolu, long paramLong, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      ((omg)this.a.b()).setData(paramList);
      return;
    }
    ((omg)this.a.b()).r(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    ((omg)this.a.b()).hideLoading();
    long l = System.currentTimeMillis() - this.ze;
    ooz.i("weishi-beacon", "请求关注流耗时：" + l + "毫秒");
    onk.a().a(true, l, "focus", 9, "focus", this.uk);
    if (paramBoolean1) {
      ((omg)this.a.b()).qy(paramBoolean2);
    }
    if (!paramBoolean2)
    {
      ((omg)this.a.b()).ah(false, true);
      ((omg)this.a.b()).ag(this.uk, paramBoolean1);
    }
    label210:
    for (;;)
    {
      return;
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (oor.v(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label210;
        }
        ((omg)this.a.b()).ah(true, true);
        if (!this.uk) {
          break;
        }
        ((omg)this.a.b()).ag(true, paramBoolean1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olv
 * JD-Core Version:    0.7.0.1
 */