package com.tencent.mobileqq.activity;

import afke;
import ajdg;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public final class ChatActivityFacade$18
  implements Runnable
{
  public ChatActivityFacade$18(Emoticon paramEmoticon, ajdg paramajdg, afke paramafke) {}
  
  public void run()
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 0)
    {
      localArrayList = (ArrayList)this.b.e(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.jdField_a_of_type_Afke.u(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, try fetch normal emotion keys. epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + ",cur emo id:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 4));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      this.jdField_a_of_type_Afke.u(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, localArrayList);
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, try fetch magic emotion key. epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + ",cur emo id:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.18
 * JD-Core Version:    0.7.0.1
 */