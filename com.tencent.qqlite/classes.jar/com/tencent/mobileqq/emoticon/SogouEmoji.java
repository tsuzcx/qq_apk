package com.tencent.mobileqq.emoticon;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import ddy;
import ddz;
import deb;
import dec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SogouEmoji
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public EmosmHandler a;
  public EmojiManager a;
  public SogouEmoji.OnEmojiJsonBackSogou a;
  public SogouEmojiTaskController a;
  public EmoticonManager a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = SogouEmoji.class.getSimpleName();
  }
  
  public SogouEmoji(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji$OnEmojiJsonBackSogou = new ddy(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji constructor begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getManager(13));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getManager(39));
    this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler = ((EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.a(11));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController = new SogouEmojiTaskController(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji constructor ends");
    }
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func" + paramString + " ends, maybe chatActivity is finished.");
      }
      return false;
    }
    return true;
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getInvalidKeyEmoticon begins");
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.next();
      if (!localEmoticon.hasEncryptKey()) {
        localArrayList.add(localEmoticon);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getInvalidKeyEmoticon ends, size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji destructor begins");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      EmosmHandler.EmosmHandlerListener localEmosmHandlerListener = (EmosmHandler.EmosmHandlerListener)localIterator.next();
      if (localEmosmHandlerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(localEmosmHandlerListener);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji destructor ends");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func trySend begins, packId:" + paramInt + ",exprId:" + paramString);
    }
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getApplicationContext())) {
      QQToast.a(BaseApplicationImpl.a, 2131362916, 0).a();
    }
    do
    {
      Emoticon localEmoticon;
      do
      {
        return;
        localEmoticon = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(Integer.toString(paramInt), paramString);
        if ((localEmoticon != null) && (localEmoticon.hasEncryptKey())) {
          break;
        }
        a(Integer.toString(paramInt), paramString, true);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func trySend ends, emotion has invalid key. Call func pullSingleEmojiKey");
      return;
      a(localEmoticon);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func trySend ends, everything is ok.");
  }
  
  public void a(Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func sendEmoji begins, mCurTaskId:" + this.b + ",emoticon:" + paramEmoticon);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.c();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.b);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.b();
    if (!a("sendEmoji")) {
      return;
    }
    PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.a());
    localPicEmoticonInfo.c = 6;
    localPicEmoticonInfo.a = paramEmoticon;
    paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(paramEmoticon.epId);
    if (paramEmoticon != null) {}
    for (localPicEmoticonInfo.h = paramEmoticon.type;; localPicEmoticonInfo.h = 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localPicEmoticonInfo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func sendEmoji ends, type:" + localPicEmoticonInfo.h);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new ddz(this, paramString1, paramString2, paramBoolean);
    ThreadManager.a().post(paramString1);
  }
  
  public void a(String paramString, ArrayList paramArrayList, SogouEmoji.OnEmojiKeyBackSogou paramOnEmojiKeyBackSogou)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPackEmojiKey begins, packId:" + paramString + ",callback:" + paramOnEmojiKeyBackSogou);
    }
    if (!a("getPackEmojiKey")) {}
    do
    {
      return;
      paramOnEmojiKeyBackSogou = new dec(this, paramArrayList, paramOnEmojiKeyBackSogou);
      String str = Integer.toString(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnEmojiKeyBackSogou);
      this.jdField_a_of_type_Int += 1;
      if (EmosmUtils.isNumeral(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.a(paramOnEmojiKeyBackSogou);
        this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.a(Integer.parseInt(paramString), paramArrayList, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPackEmojiKey ends");
  }
  
  public void a(List paramList)
  {
    paramList = new deb(this, paramList);
    ThreadManager.a().post(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji
 * JD-Core Version:    0.7.0.1
 */