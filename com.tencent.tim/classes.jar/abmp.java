import android.os.Bundle;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.5;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

public class abmp
  implements abto.c
{
  public abmp(CmGameServerQIPCModule.5 param5) {}
  
  public void e(boolean paramBoolean, String paramString, List<abto.a> paramList)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.crd = 6;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.mIsSend = true;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.mSenderUin = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.mSelfUin;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.crb >= 1) {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.bbE = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.mFriendUin;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.mTaskId = this.a.cqa;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.cri = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowRenderView$PlayActionConfig.cri;
      paramString = absk.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam, this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext, this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowRenderView$PlayActionConfig);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.bhx = paramString;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowRenderView$PlayActionConfig.mLoop)
      {
        paramString.crj = i;
        paramString = new Bundle();
        paramString.putParcelable("IPCSpriteContext", this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext);
        paramString.putParcelable("SpriteTaskParam", this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam);
        paramString = EIPCResult.createSuccessResult(paramString);
        this.a.this$0.callbackResult(this.a.val$callbackId, paramString);
      }
    }
    for (;;)
    {
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
      i = 0;
      break;
      paramString = EIPCResult.createResult(-1, null);
      this.a.this$0.callbackResult(this.a.val$callbackId, paramString);
    }
  }
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString = EIPCResult.createResult(paramInt1, null);
      this.a.this$0.callbackResult(this.a.val$callbackId, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmp
 * JD-Core Version:    0.7.0.1
 */