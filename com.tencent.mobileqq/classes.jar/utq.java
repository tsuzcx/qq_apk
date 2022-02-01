import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

class utq
  implements unf<stFeed>
{
  utq(utp paramutp, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    ((uud)this.jdField_a_of_type_Utp.a()).a(this.jdField_a_of_type_Boolean, paramBoolean1, paramList, paramBoolean2);
    if (!paramBoolean1)
    {
      ((uud)this.jdField_a_of_type_Utp.a()).a(paramList);
      return;
    }
    ((uud)this.jdField_a_of_type_Utp.a()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    ((uud)this.jdField_a_of_type_Utp.a()).e();
    if (paramBoolean2) {
      ((uud)this.jdField_a_of_type_Utp.a()).a(paramBoolean3);
    }
    if (!paramBoolean3)
    {
      ((uud)this.jdField_a_of_type_Utp.a()).b(false, true);
      ((uud)this.jdField_a_of_type_Utp.a()).a(paramBoolean1, paramBoolean2);
    }
    label145:
    label312:
    label323:
    for (;;)
    {
      return;
      Object localObject;
      if ((paramBoolean1) && ((paramObject instanceof stFollowFeedsRsp)))
      {
        localObject = (stFollowFeedsRsp)paramObject;
        utp.a(this.jdField_a_of_type_Utp, ((stFollowFeedsRsp)localObject).config);
        StringBuilder localStringBuilder = new StringBuilder().append("[WSFollowPresenter.java][onRequestFinish] showMute:");
        if (utp.a(this.jdField_a_of_type_Utp) == null) {
          break label312;
        }
        localObject = Boolean.valueOf(utp.a(this.jdField_a_of_type_Utp).showMute);
        uya.e("WSFollowPresenter", localObject);
        if ((((uud)this.jdField_a_of_type_Utp.a()).a() != null) && (utp.a(this.jdField_a_of_type_Utp) != null)) {
          ((uud)this.jdField_a_of_type_Utp.a()).a().a(utp.a(this.jdField_a_of_type_Utp).showMute);
        }
        if ((this.jdField_a_of_type_Utp.a() instanceof WSFollowFragment)) {
          ((WSFollowFragment)this.jdField_a_of_type_Utp.a()).c(true);
        }
      }
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (uxr.a(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label323;
        }
        ((uud)this.jdField_a_of_type_Utp.a()).b(true, true);
        if (!paramBoolean1) {
          break;
        }
        ((uud)this.jdField_a_of_type_Utp.a()).a(true, paramBoolean2);
        return;
        localObject = "mFollowFeedsConfig  is null!";
        break label145;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */