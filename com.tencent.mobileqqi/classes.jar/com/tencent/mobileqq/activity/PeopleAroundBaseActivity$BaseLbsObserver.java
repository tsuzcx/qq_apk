package com.tencent.mobileqq.activity;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import cza;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeopleAroundBaseActivity$BaseLbsObserver
  extends LBSObserver
{
  public PeopleAroundBaseActivity$BaseLbsObserver(PeopleAroundBaseActivity paramPeopleAroundBaseActivity) {}
  
  public void a(boolean paramBoolean1, String paramString, int paramInt1, RespGetEncounterV2 paramRespGetEncounterV2, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    Object localObject;
    boolean bool;
    if (paramBoolean1)
    {
      this.a.b.b(true, true);
      if (paramRespGetEncounterV2 != null)
      {
        this.a.t = paramRespGetEncounterV2.stUserData.iLat;
        this.a.u = paramRespGetEncounterV2.stUserData.iLon;
      }
      if (paramInt1 == this.a.c())
      {
        if (paramBoolean2)
        {
          this.a.a(paramRespGetEncounterV2.nearbyGroupResp);
          this.a.b(paramRespGetEncounterV2.nearbyPublicAcctResp);
        }
        if ((this.a.p != 4) && (paramRespGetEncounterV2 != null))
        {
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter;
          if (paramRespGetEncounterV2.stUserData.lNextGrid != -1L)
          {
            bool = true;
            ((PeopleAroundAdapter)localObject).a = bool;
          }
        }
        else
        {
          localObject = null;
          if (paramRespGetEncounterV2 != null) {
            localObject = paramRespGetEncounterV2.vEncounterInfos;
          }
          if (paramBoolean2)
          {
            this.a.jdField_a_of_type_JavaUtilList = new ArrayList(((List)localObject).size());
            this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
          }
          if (localObject == null) {
            break label528;
          }
          paramRespGetEncounterV2 = ((List)localObject).iterator();
          label213:
          if (!paramRespGetEncounterV2.hasNext()) {
            break label528;
          }
          localObject = (RespEncounterInfo)paramRespGetEncounterV2.next();
          paramInt1 = 0;
          label237:
          if (paramInt1 >= this.a.jdField_a_of_type_JavaUtilList.size()) {
            break label700;
          }
          RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localRespEncounterInfo == null) || (TextUtils.isEmpty(localRespEncounterInfo.enc_id)) || (!localRespEncounterInfo.enc_id.equals(((RespEncounterInfo)localObject).enc_id))) {
            break label422;
          }
        }
      }
    }
    label422:
    label700:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if (this.a.p == 1)
      {
        paramInt2 = paramInt1;
        if (((RespEncounterInfo)localObject).cSex != 0) {
          paramInt2 = 0;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (!String.valueOf(((RespEncounterInfo)localObject).lEctID).equals(paramString)) {
            break label473;
          }
          ((RespEncounterInfo)localObject).strNick = this.a.b.e();
          if (((RespEncounterInfo)localObject).vIntroContent == null) {
            break label461;
          }
          try
          {
            this.a.d = new String(((RespEncounterInfo)localObject).vIntroContent, "utf-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            this.a.d = new String(((RespEncounterInfo)localObject).vIntroContent);
          }
        }
        break label213;
        bool = false;
        break;
        paramInt1 += 1;
        break label237;
        paramInt2 = paramInt1;
        if (this.a.p == 2)
        {
          paramInt2 = paramInt1;
          if (((RespEncounterInfo)localObject).cSex != 1)
          {
            paramInt2 = 0;
            continue;
            label461:
            this.a.d = "";
            break label213;
          }
        }
      }
      label473:
      if (paramInt2 == 0) {
        break label213;
      }
      if (this.a.jdField_a_of_type_JavaUtilList.size() > 30000) {
        this.a.jdField_a_of_type_JavaUtilList.remove(0);
      }
      this.a.jdField_a_of_type_JavaUtilList.add(localObject);
      break label213;
      if ((!this.a.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramBoolean2) && (this.a.p != 4))
      {
        paramRespGetEncounterV2 = this.a.jdField_a_of_type_JavaUtilList;
        localObject = this.a.d;
        this.a.b.a(new cza(this, paramString, paramRespGetEncounterV2, (String)localObject));
      }
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      this.a.a(paramBoolean1, this.a.jdField_a_of_type_JavaUtilList, paramBoolean2, paramInt3);
      for (;;)
      {
        this.a.b(paramBoolean1, paramBoolean2);
        return;
        if ((paramInt3 == 4) || (paramInt3 == 7))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a = false;
          this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
        }
        this.a.a(paramBoolean1, null, paramBoolean2, paramInt3);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_AndroidViewView.getVisibility() != 8) {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramBoolean1)
    {
      this.a.finish();
      return;
    }
    this.a.a(1, 2131562448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PeopleAroundBaseActivity.BaseLbsObserver
 * JD-Core Version:    0.7.0.1
 */