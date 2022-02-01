package com.tencent.mobileqq.minigame.publicaccount;

import acbn;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;

public class MiniGamePublicAccountIPCModule
  extends QIPCModule
{
  public static final String ACTION_DO_ON_RESUME = "action_do_on_resume";
  public static final String ACTION_GET_MINI_GAME_PUBLIC_MSG = "action_get_mini_game_public_account_msg";
  public static final String KEY_MSG_LIST = "key_msg_list";
  public static final String MODULE_NAME = "MiniGamePublicAccountIPCModule";
  private static final String TAG = "MiniGamePublicAccountIPCModule";
  private static MiniGamePublicAccountIPCModule instance;
  
  private MiniGamePublicAccountIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static MiniGamePublicAccountIPCModule getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MiniGamePublicAccountIPCModule("MiniGamePublicAccountIPCModule");
      }
      return instance;
    }
    finally {}
  }
  
  private void handleGetMiniGamePublicAccountMsg(QQAppInterface paramQQAppInterface, int paramInt)
  {
    try
    {
      int j = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountMsgListCount", 4);
      Object localObject1 = paramQQAppInterface.b().i(acbn.blT, 1008, 10);
      paramQQAppInterface = new ArrayList();
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        i = ((List)localObject1).size() - 1;
      }
      for (;;)
      {
        if (i >= 0)
        {
          Object localObject2 = (MessageRecord)((List)localObject1).get(i);
          if ((acbn.blT.equals(((MessageRecord)localObject2).frienduin)) && ((localObject2 instanceof MessageForArkApp)))
          {
            localObject2 = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject2);
            if (localObject2 != null) {
              paramQQAppInterface.add(localObject2);
            }
          }
          if (paramQQAppInterface.size() != j) {}
        }
        else
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putSerializable("key_msg_list", paramQQAppInterface);
          callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject1));
          return;
        }
        i -= 1;
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("MiniGamePublicAccountIPCModule", 1, "handleGetMiniGamePublicAccountMsg error", paramQQAppInterface);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if (!(paramBundle instanceof QQAppInterface)) {}
    do
    {
      return null;
      QQAppInterface localQQAppInterface = (QQAppInterface)paramBundle;
      if ("action_get_mini_game_public_account_msg".equals(paramString))
      {
        handleGetMiniGamePublicAccountMsg(localQQAppInterface, paramInt);
        return null;
      }
    } while (!"action_do_on_resume".equals(paramString));
    ((QQAppInterface)paramBundle).b().a(acbn.blT, 1008, true, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule
 * JD-Core Version:    0.7.0.1
 */