import android.app.Activity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleProfile.CheckBindGroupRsp;

class vcu
  implements aaav<QQCircleProfile.CheckBindGroupRsp>
{
  vcu(vcn paramvcn, List paramList) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.CheckBindGroupRsp paramCheckBindGroupRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramCheckBindGroupRsp == null))
    {
      QLog.e("QCircleDataEditContentP", 1, "requestCheckBindGroup error:" + paramLong + "  errorMsg:" + paramString);
      vcn.a(this.jdField_a_of_type_Vcn).h();
      vcn.a(this.jdField_a_of_type_Vcn).c(this.jdField_a_of_type_Vcn.a().getString(2131694098));
      QQToast.a(this.jdField_a_of_type_Vcn.a(), 1, paramString, 0).a();
      return;
    }
    QLog.d("QCircleDataEditContentP", 1, "requestCheckBindGroup success:" + paramLong);
    vcn.a(this.jdField_a_of_type_Vcn).h();
    vcn.a(this.jdField_a_of_type_Vcn).c(this.jdField_a_of_type_Vcn.a().getString(2131694098));
    vcn.a(this.jdField_a_of_type_Vcn).a("");
    vcn.a(this.jdField_a_of_type_Vcn).b(null);
    vcn.a(this.jdField_a_of_type_Vcn).dismiss();
    if (vcn.a(this.jdField_a_of_type_Vcn) == null) {
      vcn.a(this.jdField_a_of_type_Vcn, new ArrayList());
    }
    paramString = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      paramLong = ((Long)paramString.next()).longValue();
      if (!vcn.a(this.jdField_a_of_type_Vcn).contains(Long.valueOf(paramLong))) {
        vcn.a(this.jdField_a_of_type_Vcn).add(Long.valueOf(paramLong));
      }
    }
    vcn.a(this.jdField_a_of_type_Vcn);
    QQToast.a(this.jdField_a_of_type_Vcn.a(), 2, this.jdField_a_of_type_Vcn.a().getString(2131697351), 0).a();
    vtq.a(vcn.a(this.jdField_a_of_type_Vcn).id.get(), 11, 25, 6, "", String.valueOf(this.jdField_a_of_type_JavaUtilList.get(0)), "", "", "", this.jdField_a_of_type_Vcn.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */