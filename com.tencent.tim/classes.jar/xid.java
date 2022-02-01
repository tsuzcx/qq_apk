import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class xid
  extends xeh.a
{
  private wzp a;
  private wzb jdField_b_of_type_Wzb;
  private wzj jdField_b_of_type_Wzj;
  
  xid(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
  
  protected wko c(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    int j = 1;
    int i = j;
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
      i = j;
      if (paramChatMessage.ark_app_message != null)
      {
        localConfig.fromString(paramChatMessage.ark_app_message.config);
        i = j;
        if (localConfig.showSender != null)
        {
          i = j;
          if (localConfig.showSender.intValue() == 0) {
            i = 0;
          }
        }
      }
    }
    if ((this.jdField_b_of_type_Xeh.d.cZ == 1008) || (this.jdField_b_of_type_Xeh.d.cZ == 1038))
    {
      if (this.a == null) {
        this.a = new wzp(this.jdField_b_of_type_Xeh.app, paramBaseAdapter, this.jdField_b_of_type_Xeh.mContext, this.jdField_b_of_type_Xeh.d, this.jdField_b_of_type_Xeh.e);
      }
      return this.jdField_b_of_type_Xeh.a(this.a, paramBaseAdapter);
    }
    if ((i == 0) || (this.jdField_b_of_type_Xeh.d.cZ == 9501))
    {
      if (this.jdField_b_of_type_Wzj == null) {
        this.jdField_b_of_type_Wzj = new wzj(this.jdField_b_of_type_Xeh.app, paramBaseAdapter, this.jdField_b_of_type_Xeh.mContext, this.jdField_b_of_type_Xeh.d, this.jdField_b_of_type_Xeh.e);
      }
      return this.jdField_b_of_type_Xeh.a(this.jdField_b_of_type_Wzj, paramBaseAdapter);
    }
    if (this.jdField_b_of_type_Wzb == null) {
      this.jdField_b_of_type_Wzb = new wzb(this.jdField_b_of_type_Xeh.app, paramBaseAdapter, this.jdField_b_of_type_Xeh.mContext, this.jdField_b_of_type_Xeh.d, this.jdField_b_of_type_Xeh.e);
    }
    return this.jdField_b_of_type_Xeh.a(this.jdField_b_of_type_Wzb, paramBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xid
 * JD-Core Version:    0.7.0.1
 */