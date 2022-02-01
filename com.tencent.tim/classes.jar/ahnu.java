import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahnu
  extends acih
{
  public ahnu(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  protected void L(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    QLog.e("nearby.NearbyHybridFragment", 2, "onNearbyLiveFeedAnchor isSucc:" + paramBoolean);
    if ((paramBoolean) && (paramList.size() > 0))
    {
      this.this$0.jdField_a_of_type_Ajpu.lz(paramList);
      return;
    }
    this.this$0.jdField_a_of_type_Ajpu.lz(null);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onSetFilterList");
    }
    ajph localajph = new ajph();
    localajph.gender = paramInt1;
    localajph.time = paramInt2;
    localajph.age = paramInt3;
    localajph.dke = paramInt4;
    localajph.dkf = paramInt9;
    localajph.career = paramInt5;
    localajph.fx[0] = String.valueOf(paramInt6);
    localajph.fx[1] = String.valueOf(paramInt7);
    localajph.fx[2] = String.valueOf(paramInt8);
    localajph.country = paramString1;
    localajph.province = paramString2;
    localajph.city = paramString3;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append("-").append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append("-").append(paramString3);
    }
    paramString2 = localStringBuilder.toString();
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "不限";
    }
    localajph.bRX = paramString1;
    if (!localajph.equals(this.this$0.jdField_a_of_type_Ajph)) {
      localajph.cpF = true;
    }
    this.this$0.jdField_a_of_type_Ajph = localajph;
    if ((((aehy)this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(210)).Cn() == 0) && (this.this$0.jdField_a_of_type_Ajph != null) && (this.this$0.jdField_a_of_type_Ajph.cpF)) {
      ajph.a(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), this.this$0.jdField_a_of_type_Ajph);
    }
  }
  
  public void cKT()
  {
    this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
    this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.overridePendingTransition(0, 0);
  }
  
  public void jb(List<nearbyPeopleRecommend.QueryRspItem> paramList)
  {
    if ((this.this$0.iZ.getVisibility() == 0) && (paramList != null))
    {
      paramList = (nearbyPeopleRecommend.QueryRspItem)paramList.get(0);
      akjr.O(paramList.msg_id.get(), paramList.rd_people.get());
      NearbyHybridFragment.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnu
 * JD-Core Version:    0.7.0.1
 */