import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public final class uys
  implements Runnable
{
  public uys(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        } while (localObject2 == null);
        localObject1 = ((ApolloDaoManager)localObject2).d();
        if ((localObject1 == null) || (((List)localObject1).size() < 143)) {
          break;
        }
        ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131438212), 1, this.jdField_a_of_type_AndroidContentContext);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloItemBuilder", 2, "fav number is 144");
      return;
      if (((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId) != null) {
        break;
      }
      ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131438213), 1, this.jdField_a_of_type_AndroidContentContext);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "cant find the add aciton id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
    return;
    Object localObject1 = ((ApolloDaoManager)localObject2).d();
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (ApolloFavActionData)((Iterator)localObject1).next();
      } while (this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId != ((ApolloFavActionData)localObject3).acitonId);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131438214), 1, this.jdField_a_of_type_AndroidContentContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "the add aciton is exist id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.favId = l;
      ((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData);
      ApolloItemBuilder.a(this.jdField_a_of_type_AndroidContentContext.getString(2131438211), 2, this.jdField_a_of_type_AndroidContentContext);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      String str = "" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text)) {}
      for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text)
      {
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "add_action", i, 0, new String[] { str, "", localObject1 });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, " add aciton success id=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject3 == null) {
          break;
        }
        localObject1 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloDaoManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.acitonId);
        ((ApolloInfo)localObject1).b = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.text;
        ((ApolloInfo)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.textType;
        ((ApolloInfo)localObject1).e = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.audioId;
        ((ApolloInfo)localObject1).f = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.playOriginalAudio;
        ((ApolloInfo)localObject1).jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataApolloFavActionData.audioStartTime;
        localObject2 = ((MqqHandler)localObject3).obtainMessage(66);
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).sendToTarget();
        if (((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "add action download res " + ((ApolloInfo)localObject1).toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        localObject2 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        localObject3 = new ArrayList();
        ((List)localObject3).add(((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        ((ApolloManager)localObject2).a((List)localObject3, "apollo_key");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uys
 * JD-Core Version:    0.7.0.1
 */