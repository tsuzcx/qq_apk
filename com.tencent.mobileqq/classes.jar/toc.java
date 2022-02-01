import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class toc
  implements blna
{
  toc(toa paramtoa, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    int i = 0;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      QQToast.a(toa.a(this.jdField_a_of_type_Toa), 0, 2131694621, 0).a();
      if (toa.a(this.jdField_a_of_type_Toa) != null) {
        toa.a(this.jdField_a_of_type_Toa).d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label359;
      }
    }
    label356:
    label359:
    for (long l = ((DislikeInfo)paramObject).a;; l = 0L)
    {
      paramView = "";
      paramInt = i;
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label356;
        }
        paramObject = paramView + paramObject.a;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f = l;
          paramArrayList = nzq.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(toa.a(this.jdField_a_of_type_Toa))) {
            nzq.a(new tlx().a(toa.a(this.jdField_a_of_type_Toa)).a(nzq.c).b(nzq.R).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramView).a());
          }
        }
        else
        {
          return;
        }
        nzq.a(new tlx().a(toa.a(this.jdField_a_of_type_Toa)).a(nzq.c).b(nzq.P).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     toc
 * JD-Core Version:    0.7.0.1
 */