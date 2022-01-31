package com.tencent.mobileqq.richstatus;

import PersonalState.RespGetSameStateList;
import android.os.Bundle;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class StatusObserver
  implements BusinessObserver
{
  static final int jdField_a_of_type_Int = 1;
  static final String jdField_a_of_type_JavaLangString = "k_sync_ss";
  static final int jdField_b_of_type_Int = 2;
  static final String jdField_b_of_type_JavaLangString = "k_resp_mate";
  static final int jdField_c_of_type_Int = 3;
  static final String jdField_c_of_type_JavaLangString = "k_is_first";
  static final int jdField_d_of_type_Int = 4;
  static final String jdField_d_of_type_JavaLangString = "k_fetch_sex";
  static final int jdField_e_of_type_Int = 5;
  static final String jdField_e_of_type_JavaLangString = "k_data";
  static final int jdField_f_of_type_Int = 6;
  static final String jdField_f_of_type_JavaLangString = "k_status_key";
  static final String g = "k_error_code";
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (paramBoolean) {
        bool1 = paramBundle.getBoolean("k_sync_ss", false);
      }
      a(paramBoolean, bool1);
      return;
    case 2: 
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = paramBundle.getBoolean("k_sync_ss", false);
      }
      b(paramBoolean, bool1);
      return;
    case 3: 
      bool1 = paramBundle.getBoolean("k_is_first");
      paramInt = paramBundle.getInt("k_fetch_sex");
      if (paramBoolean)
      {
        paramBundle = (RespGetSameStateList)paramBundle.getSerializable("k_resp_mate");
        a(paramBoolean, bool1, paramInt, paramBundle.vCookie, paramBundle.vUserInfos);
        return;
      }
      a(false, bool1, paramInt, null, null);
      return;
    case 4: 
      paramBundle = (StatusServlet.RspGetHistory)paramBundle.getSerializable("k_data");
      a(paramBoolean, paramBundle.startTime, paramBundle.endTime, paramBundle.over, paramBundle.richStatus, paramBundle.isAddFromCard);
      return;
    case 5: 
      a(paramBoolean, paramBundle.getByteArray("k_status_key"), paramBundle.getInt("k_error_code", 0));
      return;
    }
    a(paramBoolean, (ArrayList)paramBundle.get("k_resp_hot_status"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusObserver
 * JD-Core Version:    0.7.0.1
 */