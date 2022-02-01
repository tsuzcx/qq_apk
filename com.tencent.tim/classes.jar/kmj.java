import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class kmj
  implements auud.b
{
  kmj(kmh paramkmh, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    int i = 0;
    if (paramInt == this.aKd)
    {
      QQToast.a(kmh.a(this.jdField_a_of_type_Kmh), 0, 2131697390, 0).show();
      if (kmh.a(this.jdField_a_of_type_Kmh) != null) {
        kmh.a(this.jdField_a_of_type_Kmh).m(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label359;
      }
    }
    label356:
    label359:
    for (long l = ((DislikeInfo)paramObject).vf;; l = 0L)
    {
      paramView = "";
      paramInt = i;
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label356;
        }
        paramObject = paramView + paramObject.vf;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b.rv = l;
          paramArrayList = jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j(kmh.a(this.jdField_a_of_type_Kmh))) {
            jzk.a(new kku.a().a(kmh.a(this.jdField_a_of_type_Kmh)).a(jzk.aEL).b(jzk.aFA).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b.rv).a(paramView).a());
          }
        }
        else
        {
          return;
        }
        jzk.a(new kku.a().a(kmh.a(this.jdField_a_of_type_Kmh)).a(jzk.aEL).b(jzk.aFy).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b.rv).a(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmj
 * JD-Core Version:    0.7.0.1
 */