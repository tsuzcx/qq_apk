import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.List;

class vib
  implements vbf<stFeed>
{
  vib(via paramvia, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, List<stFeed> paramList, boolean paramBoolean2)
  {
    ((viq)this.jdField_a_of_type_Via.a()).a(this.jdField_a_of_type_Boolean, paramBoolean1, paramList, paramBoolean2);
    if (!paramBoolean1)
    {
      ((viq)this.jdField_a_of_type_Via.a()).a(paramList);
      return;
    }
    ((viq)this.jdField_a_of_type_Via.a()).a(paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    ((viq)this.jdField_a_of_type_Via.a()).e();
    if (paramBoolean2) {
      ((viq)this.jdField_a_of_type_Via.a()).a(paramBoolean3);
    }
    if (!paramBoolean3)
    {
      ((viq)this.jdField_a_of_type_Via.a()).b(false, true);
      ((viq)this.jdField_a_of_type_Via.a()).a(paramBoolean1, paramBoolean2);
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
        via.a(this.jdField_a_of_type_Via, ((stFollowFeedsRsp)localObject).config);
        StringBuilder localStringBuilder = new StringBuilder().append("[WSFollowPresenter.java][onRequestFinish] showMute:");
        if (via.a(this.jdField_a_of_type_Via) == null) {
          break label312;
        }
        localObject = Boolean.valueOf(via.a(this.jdField_a_of_type_Via).showMute);
        vmp.e("WSFollowPresenter", localObject);
        if ((((viq)this.jdField_a_of_type_Via.a()).a() != null) && (via.a(this.jdField_a_of_type_Via) != null)) {
          ((viq)this.jdField_a_of_type_Via.a()).a().a(via.a(this.jdField_a_of_type_Via).showMute);
        }
        if ((this.jdField_a_of_type_Via.a() instanceof WSFollowFragment)) {
          ((WSFollowFragment)this.jdField_a_of_type_Via.a()).c(true);
        }
      }
      if ((!(paramObject instanceof stFollowFeedsRsp)) || (vmg.a(((stFollowFeedsRsp)paramObject).feeds))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label323;
        }
        ((viq)this.jdField_a_of_type_Via.a()).b(true, true);
        if (!paramBoolean1) {
          break;
        }
        ((viq)this.jdField_a_of_type_Via.a()).a(true, paramBoolean2);
        return;
        localObject = "mFollowFeedsConfig  is null!";
        break label145;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vib
 * JD-Core Version:    0.7.0.1
 */