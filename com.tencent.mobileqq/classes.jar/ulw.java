import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

class ulw
  implements ugo<stFeed>
{
  ulw(ulv paramulv, long paramLong, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    ((umj)this.jdField_a_of_type_Ulv.a()).a(this.jdField_a_of_type_Boolean, paramBoolean1, paramList, paramBoolean2);
    if (!paramBoolean1)
    {
      ((umj)this.jdField_a_of_type_Ulv.a()).a(paramList);
      return;
    }
    ((umj)this.jdField_a_of_type_Ulv.a()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    ((umj)this.jdField_a_of_type_Ulv.a()).e();
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uqf.a("weishi-beacon", "请求关注流耗时：" + l + "毫秒");
    uoc.a().a(true, l, "focus", 9, "focus", paramBoolean1);
    if (paramBoolean2) {
      ((umj)this.jdField_a_of_type_Ulv.a()).a(paramBoolean3);
    }
    if (!paramBoolean3)
    {
      ((umj)this.jdField_a_of_type_Ulv.a()).b(false, true);
      ((umj)this.jdField_a_of_type_Ulv.a()).a(paramBoolean1, paramBoolean2);
    }
    label201:
    label368:
    label379:
    for (;;)
    {
      return;
      Object localObject;
      if ((paramBoolean1) && ((paramObject instanceof stFollowFeedsRsp)))
      {
        localObject = (stFollowFeedsRsp)paramObject;
        ulv.a(this.jdField_a_of_type_Ulv, ((stFollowFeedsRsp)localObject).config);
        StringBuilder localStringBuilder = new StringBuilder().append("[WSFollowPresenter.java][onRequestFinish] showMute:");
        if (ulv.a(this.jdField_a_of_type_Ulv) == null) {
          break label368;
        }
        localObject = Boolean.valueOf(ulv.a(this.jdField_a_of_type_Ulv).showMute);
        uqf.e("WSFollowPresenter", localObject);
        if ((((umj)this.jdField_a_of_type_Ulv.a()).a() != null) && (ulv.a(this.jdField_a_of_type_Ulv) != null)) {
          ((umj)this.jdField_a_of_type_Ulv.a()).a().a(ulv.a(this.jdField_a_of_type_Ulv).showMute);
        }
        if ((this.jdField_a_of_type_Ulv.a() instanceof WSFollowFragment)) {
          ((WSFollowFragment)this.jdField_a_of_type_Ulv.a()).c(true);
        }
      }
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (upw.a(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label379;
        }
        ((umj)this.jdField_a_of_type_Ulv.a()).b(true, true);
        if (!paramBoolean1) {
          break;
        }
        ((umj)this.jdField_a_of_type_Ulv.a()).a(true, paramBoolean2);
        return;
        localObject = "mFollowFeedsConfig  is null!";
        break label201;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulw
 * JD-Core Version:    0.7.0.1
 */