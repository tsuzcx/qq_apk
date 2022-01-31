import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class fsh
  implements EmosmHandler.EmosmHandlerListener
{
  public fsh(EmoticonController paramEmoticonController, EmoticonController.ProgressHandler paramProgressHandler, EmosmHandler paramEmosmHandler, boolean paramBoolean, ArrayList paramArrayList, Object paramObject) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    int i = paramEmosmResp.epId;
    int j = paramEmosmResp.timestamp;
    Object localObject1 = (ArrayList)paramEmosmResp.data;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.b.equals(paramEmosmResp.keySeq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.h.remove(this);
      if (!paramBoolean) {
        break label272;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)???).hasNext())
        {
          Emoticon localEmoticon = (Emoticon)((Iterator)???).next();
          EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController).a(localEmoticon);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.c = paramEmosmResp.resultcode;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_JavaLangString = paramEmosmResp.timeoutReason;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("fetchEmoticonEncryptKeys|net get key backepId=").append(i).append(" tstamp=").append(j).append(" list.size=");
          if (localObject1 == null)
          {
            localObject1 = "null";
            QLog.d("Q.emoji.EmoDown", 2, localObject1 + " encryptSuccess=" + paramBoolean + " type=" + paramInt + " er.resultCode=" + paramEmosmResp.resultcode);
          }
        }
        else
        {
          return;
          label272:
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController$ProgressHandler.jdField_a_of_type_Boolean = false;
        }
      }
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fsh
 * JD-Core Version:    0.7.0.1
 */