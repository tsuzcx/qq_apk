import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class afuo
  extends afsr
{
  public afuo(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  protected void a(boolean paramBoolean, afua paramafua, int paramInt)
  {
    if ((paramBoolean) && (paramafua != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(ExtendFriendEditFragment.a(this.a).app, paramafua);
    }
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(paramCard);
      if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.bFK)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.url)))
      {
        ExtendFriendEditFragment.a(this.a, true);
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
      }
    }
    for (;;)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      return;
      ExtendFriendEditFragment.a(this.a, false);
      break;
      QQToast.a(ExtendFriendEditFragment.a(this.a), "获取校园扩列信息失败", 0).show();
    }
  }
  
  protected void as(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendProfileEdit", 2, String.format("ExtendFriendEditFragment onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null))
    {
      afsi localafsi = (afsi)this.a.getActivity().app.getManager(264);
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.authState = localafsi.DA();
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.d(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
  }
  
  protected void bl(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      String str1 = paramObject.getString("name");
      String str2 = paramObject.getString("schoolid");
      int i = paramObject.getInt("category");
      int j = paramObject.getInt("idx");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.schoolName = str1;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.schoolId = str2;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.category = i;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.authState = -1L;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.idx = j;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.d(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
      }
    }
  }
  
  protected void xq(boolean paramBoolean)
  {
    super.xq(paramBoolean);
    if (paramBoolean)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      ExtendFriendEditFragment.a(this.a).setResult(8193);
      if (ExtendFriendEditFragment.a(this.a) != null) {
        ExtendFriendEditFragment.a(this.a).finish();
      }
      return;
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuo
 * JD-Core Version:    0.7.0.1
 */