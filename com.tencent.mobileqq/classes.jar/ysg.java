import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineStartParams;
import com.tencent.mobileqq.apollo.tmg_opensdk.SSOChannel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent.CsCmdCallback;

public class ysg
  implements SSOTunnelEvent.CsCmdCallback
{
  public ysg(SSOChannel paramSSOChannel, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    QLog.e(SSOChannel.jdField_a_of_type_JavaLangString, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onError  identifier=" + this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier + ", nAppid=" + this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId + ", nGameID=" + ((AVEngineStartParams)this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int + ", lGameRoomID=" + ((AVEngineStartParams)this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long + ", UserRequestData.length" + this.jdField_a_of_type_ArrayOfByte.length + ", s info=" + paramString);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onError(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.e(SSOChannel.jdField_a_of_type_JavaLangString, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onSuccess  startParam_.identifier=" + this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.identifier + ", nAppid=" + this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam.sdkAppId + ", nGameID=" + ((AVEngineStartParams)this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Int + ", lGameRoomID=" + ((AVEngineStartParams)this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkSSOChannel.jdField_a_of_type_ComTencentTMGSdkAVContext$StartParam).jdField_a_of_type_Long + ", UserRequestData.length" + paramArrayOfByte.length + ", bytes.length=" + this.jdField_a_of_type_ArrayOfByte.length);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysg
 * JD-Core Version:    0.7.0.1
 */