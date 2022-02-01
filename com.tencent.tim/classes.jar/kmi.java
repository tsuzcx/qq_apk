import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class kmi
  implements auud.b
{
  kmi(kmh paramkmh, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramInt = 0;
    QQToast.a(kmh.a(this.jdField_a_of_type_Kmh), 0, 2131697390, 0).show();
    if ((paramObject != null) && ((paramObject instanceof DislikeInfo))) {}
    for (long l = ((DislikeInfo)paramObject).vf;; l = 0L)
    {
      paramView = "";
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label186;
        }
        paramObject = paramView + paramObject.vf;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      label186:
      for (;;)
      {
        paramInt += 1;
        break;
        jzk.a(new kku.a().a(kmh.a(this.jdField_a_of_type_Kmh)).a(jzk.aEL).b(jzk.aFy).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramView).a());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmi
 * JD-Core Version:    0.7.0.1
 */