import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

final class tkg
  implements bldb
{
  tkg(Context paramContext, BaseData paramBaseData, AdData paramAdData) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
      ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    }
    if (((QQAppInterface)pkh.a() != null) && (paramArrayList != null))
    {
      paramObject = "";
      paramView = "";
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        if (localDislikeInfo == null) {
          break label272;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (paramInt == paramArrayList.size() - 1) {
          break label275;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
    }
    label272:
    label275:
    for (;;)
    {
      paramInt += 1;
      break;
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(3).b(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(ukt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(paramObject).b(paramView).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a());
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, -1, this.jdField_a_of_type_AndroidContentContext.getString(2131699167), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tkg
 * JD-Core Version:    0.7.0.1
 */