import android.app.Activity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleProfile.CheckBindGroupRsp;

class vbe
  implements zxa<QQCircleProfile.CheckBindGroupRsp>
{
  vbe(vax paramvax, List paramList) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.CheckBindGroupRsp paramCheckBindGroupRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramCheckBindGroupRsp == null))
    {
      QLog.e("QCircleDataEditContentP", 1, "requestCheckBindGroup error:" + paramLong + "  errorMsg:" + paramString);
      vax.a(this.jdField_a_of_type_Vax).h();
      vax.a(this.jdField_a_of_type_Vax).c(this.jdField_a_of_type_Vax.a().getString(2131694081));
      QQToast.a(this.jdField_a_of_type_Vax.a(), 1, paramString, 0).a();
      return;
    }
    QLog.d("QCircleDataEditContentP", 1, "requestCheckBindGroup success:" + paramLong);
    vax.a(this.jdField_a_of_type_Vax).h();
    vax.a(this.jdField_a_of_type_Vax).c(this.jdField_a_of_type_Vax.a().getString(2131694081));
    vax.a(this.jdField_a_of_type_Vax).a("");
    vax.a(this.jdField_a_of_type_Vax).b(null);
    vax.a(this.jdField_a_of_type_Vax).dismiss();
    if (vax.a(this.jdField_a_of_type_Vax) == null) {
      vax.a(this.jdField_a_of_type_Vax, new ArrayList());
    }
    paramString = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      paramLong = ((Long)paramString.next()).longValue();
      if (!vax.a(this.jdField_a_of_type_Vax).contains(Long.valueOf(paramLong))) {
        vax.a(this.jdField_a_of_type_Vax).add(Long.valueOf(paramLong));
      }
    }
    vax.a(this.jdField_a_of_type_Vax);
    QQToast.a(this.jdField_a_of_type_Vax.a(), 2, this.jdField_a_of_type_Vax.a().getString(2131697273), 0).a();
    vrf.a(vax.a(this.jdField_a_of_type_Vax).id.get(), 11, 25, 6, "", String.valueOf(this.jdField_a_of_type_JavaUtilList.get(0)), "", "", "", this.jdField_a_of_type_Vax.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbe
 * JD-Core Version:    0.7.0.1
 */