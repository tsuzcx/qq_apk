import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class cdi
  extends TroopObserver
{
  public cdi(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((paramInt != 2) && (paramInt != 9)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562571, 1500);
    this.a.finish();
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      for (;;)
      {
        return;
        if (paramInt == 2)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          if (paramByte == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, 2131562988, 1500);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562571, 1500);
          return;
        }
        if (paramInt != 3) {
          break;
        }
        if (paramByte == 0)
        {
          paramString = (FriendManager)this.a.b.getManager(8);
          if (paramString == null) {}
          for (paramString = null; (paramString != null) && (paramString.wMemberNum != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int); paramString = paramString.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramString.Administrator, paramString.wMemberNum, this.a.b.a(), this.a.getResources());
            this.a.a(5, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h, true);
            return;
          }
        }
      }
    } while (paramInt != 9);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    if (paramByte == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, 2131562988, 1500);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562571, 1500);
  }
  
  protected void a(String paramString, int paramInt1, List paramList, int paramInt2)
  {
    TroopInfo localTroopInfo = ((FriendManager)this.a.b.getManager(8)).a(paramString);
    Message localMessage = new Message();
    localMessage.what = 10;
    Bundle localBundle = localMessage.getData();
    if (localTroopInfo != null) {
      if (localTroopInfo.mTroopPicList != null) {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)localTroopInfo.mTroopPicList);
      }
    }
    for (;;)
    {
      localBundle.putInt("newSeq", paramInt1);
      localBundle.putString("troopUin", paramString);
      localBundle.putInt("CMD_TYPE", paramInt2);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      localBundle.putStringArrayList("AVATAR_WALL_LIST", null);
      continue;
      if (paramList != null) {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)paramList);
      } else {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", null);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, String.valueOf(paramLong)));
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          if (paramBoolean)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, this.a.getString(2131562396), 1000);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, this.a.getString(2131562400), 1000);
          ChatSettingForTroop.a(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramTroopInfo, this.a.b.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.r();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r = paramTroopInfo.joinTroopQuestion;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = ((short)(byte)paramTroopInfo.cGroupOption);
      ChatSettingForTroop.b(this.a);
      return;
    }
    this.a.b(2131561435, 1);
  }
  
  protected void a(boolean paramBoolean, RespBatchProcess paramRespBatchProcess)
  {
    if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      if (ChatSettingForTroop.a(this.a) != null) {
        ChatSettingForTroop.b(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onBatchGetTroopInfoResp");
    }
    if ((paramRespBatchProcess == null) || (paramRespBatchProcess.batch_response_list == null) || (paramRespBatchProcess.batch_response_list.size() == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    int j;
    do
    {
      return;
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        BatchResponse localBatchResponse = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localBatchResponse == null) || (localBatchResponse.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (localBatchResponse.type == 1) {
            this.a.a(localBatchResponse);
          } else if (localBatchResponse.type == 2) {
            this.a.b(localBatchResponse);
          }
        }
      }
    } while (j <= 0);
    this.a.t();
    this.a.a(true);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString)));
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((FriendManager)this.a.b.getManager(8)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramString, this.a.getResources(), this.a.b.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.c) {}
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString)));
      if (paramInt1 == 0)
      {
        a(paramString1, paramInt2, paramList, 0);
        return;
      }
      if (paramString2 != null)
      {
        QQToast.a(this.a, paramString2, 1).b(this.a.d());
        return;
      }
      if ((paramInt1 == 1) && (paramInt1 == 2))
      {
        QQToast.a(this.a, this.a.getString(2131560633), 1).b(this.a.d());
        return;
      }
      if (paramInt1 == 19)
      {
        QQToast.a(this.a, this.a.getString(2131560634), 1).b(this.a.d());
        return;
      }
    } while (paramInt1 != 65);
    QQToast.a(this.a, this.a.getString(2131560635), 1).b(this.a.d());
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    Object localObject = null;
    paramArrayList = localObject;
    TroopMemberInfo localTroopMemberInfo;
    if (this.a.b != null)
    {
      paramArrayList = localObject;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
      {
        paramArrayList = DBUtils.a().a(this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.a.b.a());
        if (paramArrayList != null) {
          break label148;
        }
        localTroopMemberInfo = DBUtils.a().a(this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.a.b.a());
        paramArrayList = localObject;
        if (localTroopMemberInfo == null) {}
      }
    }
    label148:
    for (paramArrayList = localTroopMemberInfo.troopnick;; paramArrayList = paramArrayList.name)
    {
      if (!TextUtils.isEmpty(paramArrayList))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g = paramArrayList;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return;
    }
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    int i = 0;
    Object localObject = null;
    if ((localObject == null) && (i < paramArrayList.size()))
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
      if (localTroopMemberCardInfo == null) {
        localObject = localTroopMemberCardInfo;
      }
      for (;;)
      {
        i += 1;
        break;
        if (Utils.a(localTroopMemberCardInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
        {
          localObject = localTroopMemberCardInfo;
          if (Utils.a(localTroopMemberCardInfo.memberuin, this.a.b.a())) {}
        }
        else
        {
          localObject = null;
        }
      }
    }
    paramArrayList = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g;
    if (localObject != null) {
      paramArrayList = localObject.name;
    }
    if (!Utils.a(paramArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g = localObject.name;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
    return localObject != null;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    View localView;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList = TroopInfo.getTags(paramString);
      paramString = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[15].findViewById(2131232646);
      if (!TextUtils.isEmpty(paramString)) {
        break label70;
      }
      localView.setVisibility(8);
    }
    for (;;)
    {
      localView.setVisibility(8);
      return;
      label70:
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131230941)).setText(paramString);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    TroopAvatarManger.a -= 1;
    if (this.a.c) {
      return;
    }
    if (paramInt1 == 0)
    {
      a(paramString1, 23, paramList, 1);
      return;
    }
    a(paramString1, 23, paramList, 0);
    if (paramString2 != null)
    {
      QQToast.a(this.a, paramString2, 1).b(this.a.d());
      return;
    }
    if (paramInt1 == 1)
    {
      QQToast.a(this.a, this.a.getString(2131560633), 1).b(this.a.d());
      return;
    }
    if (paramInt1 == 2)
    {
      QQToast.a(this.a, this.a.getString(2131560634), 1).b(this.a.d());
      return;
    }
    if (paramInt1 == 3)
    {
      QQToast.a(this.a, this.a.getString(2131560637), 1).b(this.a.d());
      return;
    }
    if (paramInt1 == 4)
    {
      QQToast.a(this.a, this.a.getString(2131560638), 1).b(this.a.d());
      return;
    }
    QQToast.a(this.a, this.a.getString(2131560639), 1).b(this.a.d());
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0));
      int i = 0;
      localObject = null;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(localObject, this.a.getResources(), this.a.b.a());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    try
    {
      long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      long l2 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.d);
      TroopNotificationHelper.a(this.a.b, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false);
      return;
    }
    catch (Exception paramArrayList) {}
  }
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    boolean bool;
    do
    {
      return;
      if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
      for (bool = false;; bool = a(paramArrayList))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
        }
        if ((paramBoolean) || ((this.a.an & 0x1) != 1)) {
          break;
        }
        paramArrayList = this.a;
        paramArrayList.an &= 0xFFFFFFFE;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562399, 1000);
        return;
      }
    } while ((!bool) || ((this.a.an & 0x1) != 1));
    paramArrayList = this.a;
    paramArrayList.an &= 0xFFFFFFFE;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, 2131562395, 1000);
  }
  
  protected void d(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (paramArrayList == null)) {
      return;
    }
    a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cdi
 * JD-Core Version:    0.7.0.1
 */