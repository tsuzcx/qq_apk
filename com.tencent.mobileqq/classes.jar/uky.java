import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsRsp;
import java.util.List;

class uky
  implements ugm<stFeed>
{
  uky(ukx paramukx, long paramLong, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    ((ull)this.jdField_a_of_type_Ukx.a()).a(this.jdField_a_of_type_Boolean, paramBoolean1, paramList, paramBoolean2);
    if (!paramBoolean1)
    {
      ((ull)this.jdField_a_of_type_Ukx.a()).a(paramList);
      return;
    }
    ((ull)this.jdField_a_of_type_Ukx.a()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    ((ull)this.jdField_a_of_type_Ukx.a()).e();
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    upe.a("weishi-beacon", "请求关注流耗时：" + l + "毫秒");
    unb.a().a(true, l, "focus", 9, "focus", this.jdField_a_of_type_Boolean);
    if (paramBoolean1) {
      ((ull)this.jdField_a_of_type_Ukx.a()).a(paramBoolean2);
    }
    if (!paramBoolean2)
    {
      ((ull)this.jdField_a_of_type_Ukx.a()).b(false, true);
      ((ull)this.jdField_a_of_type_Ukx.a()).a(this.jdField_a_of_type_Boolean, paramBoolean1);
    }
    label210:
    for (;;)
    {
      return;
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (uov.a(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label210;
        }
        ((ull)this.jdField_a_of_type_Ukx.a()).b(true, true);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        ((ull)this.jdField_a_of_type_Ukx.a()).a(true, paramBoolean1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uky
 * JD-Core Version:    0.7.0.1
 */