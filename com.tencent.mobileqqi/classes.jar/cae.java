import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class cae
  extends AsyncTask
{
  public cae(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    for (;;)
    {
      int j;
      String str;
      Object localObject;
      int k;
      try
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        j = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).intValue();
        str = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
        localObject = paramVarArgs.a(RecentEmotionData.class, false, null, null, null, null, null, null);
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          localObject = new RecentEmotionData();
          ChatActivityFacade.a((RecentEmotionData)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0, 5, j, str);
          paramVarArgs.a((Entity)localObject);
          paramVarArgs.a();
          return Integer.valueOf(0);
        }
        int i = ChatActivityFacade.a((List)localObject, 5, j, str);
        RecentEmotionData localRecentEmotionData;
        if (i >= 0)
        {
          localRecentEmotionData = (RecentEmotionData)((List)localObject).get(i);
          ((List)localObject).remove(localRecentEmotionData);
          paramVarArgs.b(localRecentEmotionData);
        }
        k = ((List)localObject).size();
        if (k == 8)
        {
          i = 0;
          if (i < k - 1)
          {
            localRecentEmotionData = (RecentEmotionData)((List)localObject).get(i);
            localRecentEmotionData.type = ((RecentEmotionData)((List)localObject).get(i + 1)).type;
            localRecentEmotionData.emoIndex = ((RecentEmotionData)((List)localObject).get(i + 1)).emoIndex;
            localRecentEmotionData.emoPath = ((RecentEmotionData)((List)localObject).get(i + 1)).emoPath;
            paramVarArgs.a(localRecentEmotionData);
            i += 1;
            continue;
          }
          localObject = (RecentEmotionData)((List)localObject).get(k - 1);
          ChatActivityFacade.a((RecentEmotionData)localObject, ((RecentEmotionData)localObject).uin, ((RecentEmotionData)localObject).emoId, 5, j, str);
          paramVarArgs.a((Entity)localObject);
          continue;
        }
        localObject = new RecentEmotionData();
      }
      catch (Exception paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.e(ChatActivityFacade.a(), 2, paramVarArgs.getMessage());
        }
        return Integer.valueOf(1);
      }
      ChatActivityFacade.a((RecentEmotionData)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), k, 5, j, str);
      paramVarArgs.b((Entity)localObject);
    }
  }
  
  protected void a(Integer paramInteger) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cae
 * JD-Core Version:    0.7.0.1
 */