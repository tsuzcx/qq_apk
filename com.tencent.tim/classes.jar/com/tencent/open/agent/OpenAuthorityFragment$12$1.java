package com.tencent.open.agent;

import acfp;
import arrh;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenAuthorityFragment$12$1
  implements Runnable
{
  public OpenAuthorityFragment$12$1(arrh paramarrh, boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.val$isSuccess)
    {
      Iterator localIterator;
      if ((this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null) && (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.list != null) && (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.list.size() > 0)) {
        localIterator = this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.list.iterator();
      }
      while (localIterator.hasNext())
      {
        Object localObject = (VirtualInfo)localIterator.next();
        if ((((VirtualInfo)localObject).avatarUrl != null) && (((VirtualInfo)localObject).nickName != null))
        {
          localObject = new OpenCardContainer.f(((VirtualInfo)localObject).awT, ((VirtualInfo)localObject).nickName, ((VirtualInfo)localObject).avatarUrl);
          if ((((OpenCardContainer.f)localObject).awp == this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.awU) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).ia() == 0L)) {
            ((OpenCardContainer.f)localObject).dcU = true;
          }
          localArrayList.add(localObject);
          continue;
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onGetVirtualList result == null || result.list == null && result.list.size() <= 0");
        }
      }
      if ((OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0) != null) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).a != null))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList setData accountInfoList.size=", Integer.valueOf(localArrayList.size()) });
        OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).a.setData(localArrayList, OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).getAccount());
        if (OpenAuthorityFragment.j(this.jdField_a_of_type_Arrh.this$0) != 0L) {
          OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).a.mr(OpenAuthorityFragment.j(this.jdField_a_of_type_Arrh.this$0));
        }
        OpenAuthorityFragment.d(this.jdField_a_of_type_Arrh.this$0, 0L);
      }
    }
    do
    {
      return;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onGetVirtualList mCardContainer == null || mCardContainer.mVirtualAccountAdapter == null");
      break;
      if (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null)
      {
        OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0, acfp.m(2131709370) + this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.errorCode, false);
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getVirtualList error errorcode ===", Integer.valueOf(this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.errorCode) });
      }
    } while ((OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0) == null) || (OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).a == null) || ((OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).getAccount() != null) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).getAccount().equals(OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).a.currentUin))));
    OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).a.setData(localArrayList, OpenAuthorityFragment.a(this.jdField_a_of_type_Arrh.this$0).getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.12.1
 * JD-Core Version:    0.7.0.1
 */