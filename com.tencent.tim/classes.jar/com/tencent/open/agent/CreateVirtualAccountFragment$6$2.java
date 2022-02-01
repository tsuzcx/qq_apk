package com.tencent.open.agent;

import acfp;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import arqn;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$2
  implements Runnable
{
  public CreateVirtualAccountFragment$6$2(arqn paramarqn, boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Arqn.this$0.jf();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.val$isSuccess);
    Intent localIntent;
    if (this.val$isSuccess)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null)
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.val$isSuccess + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.awT + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.headUrl);
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Arqn.this$0, acfp.m(2131704520), true);
        localIntent = new Intent();
        localIntent.putExtra("createVirtualAccount", 1);
        localIntent.putExtra("createVirtualVid", this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.awT);
        if (this.jdField_a_of_type_Arqn.this$0.getActivity() != null)
        {
          this.jdField_a_of_type_Arqn.this$0.getActivity().setResult(101, localIntent);
          this.jdField_a_of_type_Arqn.this$0.getActivity().finish();
        }
      }
      return;
    }
    if (this.val$code == 151)
    {
      CreateVirtualAccountFragment.a(this.jdField_a_of_type_Arqn.this$0, acfp.m(2131709372), false);
      localIntent = new Intent();
      localIntent.putExtra("createVirtualAccount", 2);
      if (this.jdField_a_of_type_Arqn.this$0.getActivity() != null)
      {
        this.jdField_a_of_type_Arqn.this$0.getActivity().setResult(101, localIntent);
        this.jdField_a_of_type_Arqn.this$0.getActivity().finish();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult != null) {
        QLog.d("CreateVirtualAccountFragment", 2, "========> onCreateVirtual isSuccess = " + this.val$isSuccess + " vi == virtualId ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.awT + " headUrl ==" + this.jdField_a_of_type_ComTencentOpenModelCreateVirtualResult.headUrl);
      }
      QLog.d("CreateVirtualAccountFragment", 1, "========> onCreateVirtual Failed code = " + this.val$code);
      return;
      if (this.val$code == 10670) {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Arqn.this$0, acfp.m(2131709377), false);
      } else {
        CreateVirtualAccountFragment.a(this.jdField_a_of_type_Arqn.this$0, acfp.m(2131704522) + this.val$code, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.2
 * JD-Core Version:    0.7.0.1
 */