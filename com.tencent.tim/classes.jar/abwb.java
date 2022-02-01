import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.qphone.base.util.QLog;

class abwb
  implements asrt.a
{
  abwb(abwa paramabwa, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    QLog.e(abwa.TAG, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onError  identifier=" + this.jdField_a_of_type_Abwa.startParam_.identifier + ", nAppid=" + this.jdField_a_of_type_Abwa.startParam_.sdkAppId + ", nGameID=" + ((abvp)this.jdField_a_of_type_Abwa.startParam_).ctd + ", lGameRoomID=" + ((abvp)this.jdField_a_of_type_Abwa.startParam_).ON + ", UserRequestData.length" + this.cN.length + ", s info=" + paramString);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onError(paramInt, paramString);
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    QLog.e(abwa.TAG, 2, "ACTION_NOTICE_SERVICE_REQUEST_SSOCHANNEL:onSuccess  startParam_.identifier=" + this.jdField_a_of_type_Abwa.startParam_.identifier + ", nAppid=" + this.jdField_a_of_type_Abwa.startParam_.sdkAppId + ", nGameID=" + ((abvp)this.jdField_a_of_type_Abwa.startParam_).ctd + ", lGameRoomID=" + ((abvp)this.jdField_a_of_type_Abwa.startParam_).ON + ", UserRequestData.length" + paramArrayOfByte.length + ", bytes.length=" + this.cN.length);
    this.jdField_a_of_type_ComTencentTMGChannelAVAppChannel$CsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwb
 * JD-Core Version:    0.7.0.1
 */