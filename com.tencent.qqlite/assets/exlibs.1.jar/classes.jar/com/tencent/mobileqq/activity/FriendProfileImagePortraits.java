package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import apt;
import apu;
import apv;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.transfile.PortraitTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FriendProfileImagePortraits
  extends FriendProfileImageModel
{
  protected static final long a = 300L;
  protected static final int c = 1;
  protected static final int d = 2;
  int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new apu(this);
  protected TransProcessorHandler a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  protected List a;
  private Stack jdField_a_of_type_JavaUtilStack;
  int jdField_b_of_type_Int;
  private Stack jdField_b_of_type_JavaUtilStack;
  private int e;
  
  public FriendProfileImagePortraits(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new apt(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, String paramString2)
  {
    paramProfileImageInfo.jdField_a_of_type_JavaLangString = paramString1;
    paramProfileImageInfo.e = paramString2;
    paramProfileImageInfo.jdField_b_of_type_JavaLangString = HexUtil.a(paramProfileImageInfo.jdField_a_of_type_JavaLangString);
    paramProfileImageInfo.c = CardHandler.a(paramProfileImageInfo.jdField_b_of_type_JavaLangString, paramInt2);
    paramProfileImageInfo.d = CardHandler.a(paramProfileImageInfo.jdField_b_of_type_JavaLangString, paramInt1);
    if (FileUtils.b(paramProfileImageInfo.d))
    {
      paramProfileImageInfo.h = 6;
      paramProfileImageInfo.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      f(paramProfileImageInfo);
      return;
      if (FileUtils.b(paramProfileImageInfo.c)) {
        paramProfileImageInfo.h = 3;
      }
    }
  }
  
  private void f(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo == null) {}
    do
    {
      return;
      if ((paramProfileImageInfo.h == 0) || (paramProfileImageInfo.h == 1))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.jdField_b_of_type_JavaLangString + this.e) instanceof PortraitTransfileProcessor))
        {
          paramProfileImageInfo.h = 1;
          return;
        }
        paramProfileImageInfo.h = 0;
        return;
      }
    } while ((paramProfileImageInfo.h != 3) && (paramProfileImageInfo.h != 4));
    IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Int);
    if ((localIHttpCommunicatorListener != null) && ((localIHttpCommunicatorListener instanceof PortraitTransfileProcessor)))
    {
      paramProfileImageInfo.h = 4;
      paramProfileImageInfo.jdField_a_of_type_Boolean = true;
      return;
    }
    paramProfileImageInfo.h = 3;
  }
  
  private void g(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", toUin = ").append(paramProfileImageInfo.e).append(", state = ").append(paramProfileImageInfo.h).append(", showProgress = ").append(paramProfileImageInfo.jdField_a_of_type_Boolean).append(", progress = ").append(paramProfileImageInfo.i).append(", filekey = ").append(paramProfileImageInfo.jdField_a_of_type_JavaLangString).append(", path = ").append(paramProfileImageInfo.d).append(", thumbnail = ").append(paramProfileImageInfo.c);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.PhotoWall", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void h(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramProfileImageInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramProfileImageInfo.jdField_a_of_type_JavaLangString, paramProfileImageInfo);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public FriendProfileImageModel.ProfileImageInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        return (FriendProfileImageModel.ProfileImageInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "index = " + paramInt);
      }
      e(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
      g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
      c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = a(paramInt - 1);
      if (localProfileImageInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "index = " + (paramInt - 1));
        }
        g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        b(localProfileImageInfo);
      }
      localProfileImageInfo = a(paramInt + 1);
      if (localProfileImageInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "index = " + (paramInt + 1));
        }
        g(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
        b(localProfileImageInfo);
      }
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    Object localObject1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_b_of_type_JavaLangString);
    if (localObject1 != null)
    {
      Object localObject2 = CardHandler.a(((Card)localObject1).getStrJoinHexAlbumFileKey());
      a();
      this.jdField_b_of_type_Int = ((Card)localObject1).getPicCountInAlbum();
      localObject1 = ((LinkedList)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = new FriendProfileImageModel.ProfileImageInfo();
        a((String)localObject2, this.jdField_a_of_type_Int, this.e, localProfileImageInfo, this.jdField_b_of_type_JavaLangString);
        if ((paramProfileImageInfo != null) && (localProfileImageInfo.jdField_a_of_type_JavaLangString.equals(paramProfileImageInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = localProfileImageInfo;
          this.h = i;
        }
        h(localProfileImageInfo);
        i += 1;
      }
      if ((paramProfileImageInfo == null) || (paramProfileImageInfo.jdField_a_of_type_JavaLangString == null)) {
        this.h = 0;
      }
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, int paramInt)
  {
    String str = CardHandler.a(paramProfileImageInfo.jdField_b_of_type_JavaLangString, paramInt);
    if ((!FileUtils.b(str)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.jdField_b_of_type_JavaLangString + paramInt) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "start download " + paramProfileImageInfo.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.e, str, paramProfileImageInfo.jdField_b_of_type_JavaLangString, (short)paramInt, 0, 1);
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.hasMessages(0)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.removeMessages(0);
    }
    paramBaseActivity.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    paramBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void a(BaseActivity paramBaseActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.jdField_a_of_type_Int = CardHandler.b(paramBaseActivity);
    this.e = CardHandler.c(paramBaseActivity);
    if (paramProfileImageInfo.jdField_a_of_type_JavaLangString != null)
    {
      a(paramProfileImageInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.e, paramProfileImageInfo, this.jdField_b_of_type_JavaLangString);
      a();
      h(paramProfileImageInfo);
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo = paramProfileImageInfo;
    }
    for (;;)
    {
      paramProfileImageInfo.jdField_a_of_type_Boolean = false;
      this.h = 0;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "firstKey:" + paramProfileImageInfo.jdField_a_of_type_JavaLangString + "" + paramProfileImageInfo.c);
      }
      return;
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        bool = this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      if (bool)
      {
        if (this.h == this.jdField_a_of_type_JavaUtilList.size()) {
          this.h -= 1;
        }
        this.jdField_b_of_type_Int -= 1;
        a(this.h);
      }
    }
  }
  
  boolean a(int paramInt, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo == null) {}
    while (((paramInt == 2001) || (paramInt == 2002)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.jdField_b_of_type_JavaLangString + this.e) == null)) {
      return true;
    }
    return false;
  }
  
  protected void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    int j = 0;
    if (paramProfileImageInfo != null) {}
    for (;;)
    {
      String str;
      try
      {
        if (TextUtils.isEmpty(paramProfileImageInfo.jdField_a_of_type_JavaLangString)) {
          break label262;
        }
        if ((this.jdField_a_of_type_JavaUtilStack == null) || (this.jdField_a_of_type_AndroidOsHandler == null))
        {
          this.jdField_a_of_type_JavaUtilStack = new Stack();
          this.jdField_a_of_type_AndroidOsHandler = new apv(this);
        }
        if (this.jdField_a_of_type_JavaUtilStack.size() < 2) {
          break label227;
        }
        if (this.jdField_b_of_type_JavaUtilStack == null)
        {
          this.jdField_b_of_type_JavaUtilStack = new Stack();
          break label303;
          if ((i < 2) && (!this.jdField_a_of_type_JavaUtilStack.isEmpty()))
          {
            str = (String)this.jdField_a_of_type_JavaUtilStack.pop();
            if ((str == null) || (str.equals(paramProfileImageInfo.jdField_a_of_type_JavaLangString))) {
              break label308;
            }
            this.jdField_b_of_type_JavaUtilStack.push(str);
            break label308;
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilStack.clear();
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilStack.clear();
      int i = j;
      while ((i < 2) && (!this.jdField_b_of_type_JavaUtilStack.isEmpty()))
      {
        str = (String)this.jdField_b_of_type_JavaUtilStack.pop();
        if (TextUtils.isEmpty(str))
        {
          i += 1;
          this.jdField_a_of_type_JavaUtilStack.push(str);
        }
      }
      this.jdField_b_of_type_JavaUtilStack.clear();
      label227:
      this.jdField_a_of_type_JavaUtilStack.push(paramProfileImageInfo.jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300L);
      }
      label262:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.PhotoWall", 2, "preLoadImage() needLoadImageStack.size = " + this.jdField_a_of_type_JavaUtilStack.size());
      }
      return;
      label303:
      i = 0;
      continue;
      label308:
      i += 1;
    }
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, int paramInt)
  {
    PortraitTransfileProcessor localPortraitTransfileProcessor = (PortraitTransfileProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.jdField_b_of_type_JavaLangString + paramInt);
    if ((localPortraitTransfileProcessor != null) && (localPortraitTransfileProcessor.c() != 2003L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "stop download " + paramProfileImageInfo.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramProfileImageInfo.jdField_b_of_type_JavaLangString, (short)paramInt);
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { PortraitTransfileProcessor.class });
    paramBaseActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    paramBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  /* Error */
  public void e(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 164
    //   10: iconst_2
    //   11: new 112	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 368
    //   21: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: getfield 69	com/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 102	com/tencent/mobileqq/activity/FriendProfileImagePortraits:f	(Lcom/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo;)V
    //   42: aload_1
    //   43: getfield 95	com/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo:h	I
    //   46: ifne +20 -> 66
    //   49: aload_0
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 119	com/tencent/mobileqq/activity/FriendProfileImagePortraits:e	I
    //   55: invokevirtual 370	com/tencent/mobileqq/activity/FriendProfileImagePortraits:a	(Lcom/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo;I)V
    //   58: aload_1
    //   59: iconst_1
    //   60: putfield 95	com/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo:h	I
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_1
    //   67: getfield 95	com/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo:h	I
    //   70: iconst_3
    //   71: if_icmpne -8 -> 63
    //   74: aload_0
    //   75: aload_1
    //   76: aload_0
    //   77: getfield 135	com/tencent/mobileqq/activity/FriendProfileImagePortraits:jdField_a_of_type_Int	I
    //   80: invokevirtual 370	com/tencent/mobileqq/activity/FriendProfileImagePortraits:a	(Lcom/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo;I)V
    //   83: aload_1
    //   84: iconst_4
    //   85: putfield 95	com/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo:h	I
    //   88: aload_1
    //   89: iconst_1
    //   90: putfield 98	com/tencent/mobileqq/activity/FriendProfileImageModel$ProfileImageInfo:jdField_a_of_type_Boolean	Z
    //   93: goto -30 -> 63
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	FriendProfileImagePortraits
    //   0	101	1	paramProfileImageInfo	FriendProfileImageModel.ProfileImageInfo
    // Exception table:
    //   from	to	target	type
    //   2	37	96	finally
    //   37	63	96	finally
    //   66	93	96	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImagePortraits
 * JD-Core Version:    0.7.0.1
 */