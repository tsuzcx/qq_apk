package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import cav;
import caw;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TipsManager
  implements Handler.Callback, TipsConstants
{
  private static final String jdField_a_of_type_JavaLangString = TipsManager.class.getSimpleName();
  protected final Handler a;
  private AIOTipsController jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
  private TipsBarTask jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  
  public TipsManager(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOTipsController paramAIOTipsController, XPanelContainer paramXPanelContainer, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = paramAIOTipsController;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [Unknow] ";
    case 4: 
      return " [TIPS_BAR_TYPE_DISC_FREQ_CALL] ";
    case 0: 
      return " [TIPS_BAR_TYPE_FRAUD] ";
    case 5: 
      return " [TIPS_BAR_TYPE_HOT_FRIEND_CALL] ";
    case 2: 
      return " [TIPS_BAR_TYPE_VIDEO_STATUS] ";
    case 3: 
      return " [TIPS_BAR_TYPE_TROOP_ASSIST] ";
    case 6: 
      return "[TIPS_QQ_OPERATE] ";
    case 7: 
      return " [TIPS_BAR_TYPE_PUB_ACCOUNT_ASSIT] ";
    case 1: 
      return " [TIPS_BAR_TYPE_READER] ";
    case 8: 
      return " [TIPS_BAR_TYPE_COLOR_RING] ";
    case 1001: 
      return " [GRAY_TIPS_DISC_FREQ_PTT] ";
    case 1000: 
      return " [GRAY_TIPS_FRIEND_FREQ] ";
    case 1002: 
      return " [GRAY_TIPS_SOUGOU_INPUT] ";
    }
    return " [GRAY_TIPS_GATHER_CONTACTS] ";
  }
  
  private boolean a(TipsTask paramTipsTask)
  {
    boolean bool3 = false;
    Object localObject1 = a(paramTipsTask.a());
    int[] arrayOfInt = paramTipsTask.a();
    boolean bool2;
    if (arrayOfInt != null)
    {
      int i = -1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a();
      }
      bool2 = true;
      int j = 0;
      Object localObject2 = localObject1;
      if (j < arrayOfInt.length)
      {
        switch (arrayOfInt[j])
        {
        default: 
          bool1 = bool2;
          localObject1 = localObject2;
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          bool2 = bool1;
          break;
          localObject1 = localObject2;
          bool1 = bool2;
          if (i == arrayOfInt[j])
          {
            localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_COLOR_RING ";
            bool1 = false;
            continue;
            localObject1 = localObject2;
            bool1 = bool2;
            if (i == arrayOfInt[j])
            {
              localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_DISC_ACTIVE ";
              bool1 = false;
              continue;
              localObject1 = localObject2;
              bool1 = bool2;
              if (i == arrayOfInt[j])
              {
                localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_FRAUD ";
                bool1 = false;
                continue;
                localObject1 = localObject2;
                bool1 = bool2;
                if (i == arrayOfInt[j])
                {
                  localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_FRIEND_HOT ";
                  bool1 = false;
                  continue;
                  localObject1 = localObject2;
                  bool1 = bool2;
                  if (i == arrayOfInt[j])
                  {
                    localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_READER ";
                    bool1 = false;
                    continue;
                    localObject1 = localObject2;
                    bool1 = bool2;
                    if (i == arrayOfInt[j])
                    {
                      localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_TROOP_ASSIST ";
                      bool1 = false;
                      continue;
                      localObject1 = localObject2;
                      bool1 = bool2;
                      if (i == arrayOfInt[j])
                      {
                        localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_VIDEO_STATUS ";
                        bool1 = false;
                        continue;
                        localObject1 = localObject2;
                        bool1 = bool2;
                        if (i == arrayOfInt[j])
                        {
                          localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_QQ_OPERATE ";
                          bool1 = false;
                          continue;
                          localObject1 = localObject2;
                          bool1 = bool2;
                          if (i == arrayOfInt[j])
                          {
                            localObject1 = localObject2 + ", not allowed by excludeType: TIPS_TYPE_BAR_PUB_ACCOUNT_ASSIST ";
                            bool1 = false;
                            continue;
                            localObject1 = localObject2;
                            bool1 = bool2;
                            if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
                            {
                              localObject1 = localObject2;
                              bool1 = bool2;
                              if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
                              {
                                localObject1 = localObject2 + ", not allowed by excludeType: EXCLUDE_TYPE_EXT_PANEL ";
                                bool1 = false;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      localObject1 = localObject2;
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if ((bool1) && ((paramTipsTask instanceof TipsBarTask)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.b() > ((TipsBarTask)paramTipsTask).b()))
      {
        localObject1 = (String)localObject1 + ", not allowed: priority is low ";
        bool1 = bool3;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "allowShow(): result = " + bool1 + " | " + (String)localObject1);
        }
        return bool1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask.a();
    }
    return -1;
  }
  
  public TipsBarTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask;
  }
  
  public void a()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask = null;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    caw localcaw = new caw(this);
    this.jdField_a_of_type_AndroidOsHandler.post(localcaw);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((TipsTask)localIterator.next()).a(paramInt, paramVarArgs);
      }
    }
  }
  
  public void a(TipsTask paramTipsTask)
  {
    if (paramTipsTask == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramTipsTask));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTipsTask);
  }
  
  public boolean a(GrayTipsTask paramGrayTipsTask, Object... paramVarArgs)
  {
    if (paramGrayTipsTask != null)
    {
      if (a(paramGrayTipsTask)) {
        break label29;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "showGrayTips() failure: mTipsMgr not allow");
      }
    }
    label29:
    do
    {
      return false;
      paramVarArgs = paramGrayTipsTask.a(paramVarArgs);
      if (paramVarArgs != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramVarArgs, paramVarArgs.selfuin);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showGrayTips() success: from " + a(paramGrayTipsTask.a()));
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "showGrayTips() failure: MessageRecord null, from " + a(paramGrayTipsTask.a()));
    return false;
  }
  
  public boolean a(TipsBarTask paramTipsBarTask, Object... paramVarArgs)
  {
    if (paramTipsBarTask != null) {
      if (!a(paramTipsBarTask)) {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showTipsBar() failure: mTipsMgr not allow");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return false;
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramVarArgs = paramTipsBarTask.a(paramVarArgs);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(paramVarArgs);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsBarTask = paramTipsBarTask;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showTipsBar() success: from " + a(paramTipsBarTask.a()));
        }
        return true;
        paramVarArgs = new cav(this, paramTipsBarTask, paramVarArgs);
        this.jdField_a_of_type_AndroidOsHandler.post(paramVarArgs);
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "showTipsBar() failure: tipsBar == null");
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TipsManager
 * JD-Core Version:    0.7.0.1
 */