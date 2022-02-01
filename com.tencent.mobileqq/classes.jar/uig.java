import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class uig
  implements bldb
{
  uig(uif paramuif, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      QQToast.a(uif.a(this.jdField_a_of_type_Uif), 0, 2131694940, 0).a();
      if (uif.a(this.jdField_a_of_type_Uif) != null) {
        uif.a(this.jdField_a_of_type_Uif).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label407;
      }
    }
    label401:
    label404:
    label407:
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramView = "";
      paramInt = 0;
      paramObject = "";
      if (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        if (localDislikeInfo == null) {
          break label401;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (paramInt == paramArrayList.size() - 1) {
          break label404;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f = l;
          paramArrayList = ois.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(uif.a(this.jdField_a_of_type_Uif))) {
            ois.a(new ufy().a(uif.a(this.jdField_a_of_type_Uif)).a(3).b(10).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramObject).b(paramView).a());
          }
        }
        else
        {
          return;
        }
        ois.a(new ufy().a(uif.a(this.jdField_a_of_type_Uif)).a(3).b(5).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramObject).b(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uig
 * JD-Core Version:    0.7.0.1
 */