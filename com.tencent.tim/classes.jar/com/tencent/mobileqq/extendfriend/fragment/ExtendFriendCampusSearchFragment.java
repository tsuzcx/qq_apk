package com.tencent.mobileqq.extendfriend.fragment;

import afsi;
import afvv;
import afvv.a;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendCampusSearchFragment
  extends ExtendFriendSearchBaseFragment
  implements afvv.a
{
  private afsi jdField_a_of_type_Afsi;
  private afvv jdField_a_of_type_Afvv;
  
  private void dcu()
  {
    String str = this.jdField_a_of_type_Afsi.uC();
    List localList1 = this.jdField_a_of_type_Afsi.Z(1);
    List localList2 = this.jdField_a_of_type_Afvv.eP();
    Ip(str);
    ef((ArrayList)localList1);
    ee((ArrayList)localList2);
  }
  
  void Im(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_Afvv.Ir(paramString);
  }
  
  void N(ViewGroup paramViewGroup)
  {
    TextView localTextView = new TextView(this.mActivity);
    localTextView.setGravity(17);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(40.0F);
    localTextView.setText("搜索内容");
    paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  void dcs()
  {
    this.jdField_a_of_type_Afvv.clear();
  }
  
  public void dct()
  {
    ee((ArrayList)this.jdField_a_of_type_Afvv.eP());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Afsi = ((afsi)this.mApp.getManager(264));
    this.jdField_a_of_type_Afvv = this.jdField_a_of_type_Afsi.b();
    this.jdField_a_of_type_Afvv.a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    dcu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusSearchFragment
 * JD-Core Version:    0.7.0.1
 */