import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloResponseManager.1.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class abik
  implements View.OnClickListener
{
  abik(abij paramabij) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.a.mApp == null) || (this.a.fj == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.a.fj.get();
      if (localBaseChatPie != null)
      {
        Object localObject1 = paramView.getTag(2131362812);
        Object localObject2 = paramView.getTag(2131362813);
        if ((localObject1 != null) && (localObject2 != null))
        {
          int i = ((Integer)localObject1).intValue();
          int j = ((Integer)localObject2).intValue();
          Object localObject3 = ((abxk)this.a.mApp.getManager(155)).a(i);
          if (localObject3 == null)
          {
            QLog.e("ApolloResponseManager", 1, "on click action is null!");
          }
          else
          {
            VipUtils.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(this.a.mSenderUin), ApolloUtil.gi(this.a.mSessionType), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject3).feeType) });
            if (!ApolloUtil.aF(((ApolloActionData)localObject3).actionId, ((ApolloActionData)localObject3).personNum))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResponseManager", 2, "download action data");
              }
              ThreadManager.post(new ApolloResponseManager.1.1(this, (ApolloActionData)localObject3), 5, null, false);
            }
            localObject1 = new acad(this.a.mApp.getCurrentUin());
            ((abzy)localObject1).c = ((ApolloActionData)localObject3);
            ((ApolloActionData)localObject3).atNickName = "";
            ((ApolloActionData)localObject3).inputText = "";
            localObject2 = localBaseChatPie.sessionInfo;
            if (((SessionInfo)localObject2).cZ == 0)
            {
              ((ApolloActionData)localObject3).peerUin = ((SessionInfo)localObject2).aTl;
              if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
                ((ApolloActionData)localObject3).inputText = aofy.iF(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              }
            }
            for (;;)
            {
              if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
              {
                localObject3 = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
                if ((localObject3 != null) && (((String)localObject3).length() > 99) && (localBaseChatPie.app != null))
                {
                  ChatActivityUtils.h(localBaseChatPie.app.getApplication(), 2131719509, 1);
                  break;
                  if (((((SessionInfo)localObject2).cZ != 1) && (((SessionInfo)localObject2).cZ != 3000)) || (localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.mActivity == null)) {
                    continue;
                  }
                  ArrayList localArrayList = new ArrayList();
                  if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    appb.a(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
                  }
                  if (((ApolloActionData)localObject3).personNum == 1)
                  {
                    if ((localArrayList.size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin) && (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
                    {
                      String str = aofy.iF(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                      try
                      {
                        ((ApolloActionData)localObject3).atNickName = str.substring(0, ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen);
                        if (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1) {}
                        for (((ApolloActionData)localObject3).inputText = "";; ((ApolloActionData)localObject3).inputText = str.substring(((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen))
                        {
                          ((ApolloActionData)localObject3).peerUin = (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin + "");
                          localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                          break;
                        }
                      }
                      catch (Exception localException)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("ApolloResponseManager", 2, "inputText err:" + localException.getMessage());
                          }
                          ((ApolloActionData)localObject3).inputText = "";
                        }
                      }
                    }
                    if (TextUtils.isEmpty(this.a.mSenderUin)) {
                      continue;
                    }
                    localObject2 = aqgv.b(this.a.mApp, this.a.mSenderUin, true);
                    localObject2 = new StringBuilder("@").append((String)localObject2);
                    ((abzy)localObject1).c.peerUin = this.a.mSenderUin;
                    ((abzy)localObject1).c.atNickName = ((StringBuilder)localObject2).toString();
                    ((abzy)localObject1).c.inputText = aofy.iF(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                    localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                    localBaseChatPie.a((abzy)localObject1);
                    localBaseChatPie.jdField_a_of_type_Abzy = ((abzy)localObject1);
                    this.a.cCc();
                    break;
                  }
                  if ((((ApolloActionData)localObject3).personNum != 0) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
                    continue;
                  }
                  ((ApolloActionData)localObject3).inputText = aofy.iF(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                  continue;
                }
                if ((((SessionInfo)localObject2).cZ != 1) && (((SessionInfo)localObject2).cZ != 3000)) {
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                }
              }
            }
            if (localBaseChatPie != null) {
              localBaseChatPie.a((abzy)localObject1);
            }
            this.a.cCc();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abik
 * JD-Core Version:    0.7.0.1
 */