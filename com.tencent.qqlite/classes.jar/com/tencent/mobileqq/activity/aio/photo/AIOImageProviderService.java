package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Handler;
import byr;
import bys;
import byt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class AIOImageProviderService
  extends IAIOImageProvider.Stub
{
  static final String jdField_a_of_type_JavaLangString = "AIOImageProviderService";
  public int a;
  private final long jdField_a_of_type_Long;
  public List a;
  private final boolean jdField_a_of_type_Boolean;
  public String b;
  public String c;
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, MessageForPic paramMessageForPic)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    paramString1 = new ArrayList(1);
    paramString1.add(paramMessageForPic);
    this.jdField_a_of_type_Boolean = paramMessageForPic.isMultiMsg;
    this.jdField_a_of_type_Long = paramMessageForPic.msgseq;
    this.jdField_a_of_type_JavaUtilList = paramString1;
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {
      return;
    }
    ((PicStatisticsManager)paramQQAppInterface.getManager(57)).b(paramMessageForPic.width, paramMessageForPic.height);
    paramQQAppInterface.a().a.a(paramMessageForPic, paramMessageForPic.size);
    paramQQAppInterface.a().d();
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    try
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (MessageForPic)((Iterator)localObject2).next();
        if ((((MessageForPic)localObject1).uniseq == paramLong) && (((MessageForPic)localObject1).subMsgId == paramInt))
        {
          localObject2 = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.b);
          localObject1 = QfavBuilder.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).a();
          return localObject1;
        }
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
    throw new IllegalArgumentException("message not find..");
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilList = null;
    this.b = null;
    this.c = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong, int paramInt)
  {
    ThreadManager.a().post(new byt(this, paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i = 1;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    MessageForPic localMessageForPic;
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPic = (MessageForPic)((Iterator)localObject).next();
      if ((localMessageForPic.uniseq == paramLong) && (localMessageForPic.subMsgId == paramInt1)) {
        switch (paramInt2)
        {
        }
      }
    }
    return;
    int j = 5;
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.a.getAppRuntime(this.b);
        PicReq localPicReq = PicBusiManager.a(j, 1);
        localPicReq.a(localMessageForPic.getPicDownloadInfo());
        localPicReq.a(localMessageForPic);
        String str = AbsDownloader.d(URLDrawableHelper.a(localMessageForPic, i, null).toString().toString());
        localPicReq.a(new byr(this, paramLong, paramInt1, paramInt2, localMessageForPic.size, str));
        PicBusiManager.a(localPicReq, (QQAppInterface)localObject);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      j = 6;
      i = 131075;
      continue;
      j = 4;
      i = 65537;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) {
      return;
    }
    ThreadManager.a().post(new bys(this));
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    MessageForPic localMessageForPic;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageForPic = (MessageForPic)((Iterator)localObject).next();
    } while ((localMessageForPic.uniseq != paramLong) || (localMessageForPic.subMsgId != paramInt1));
    try
    {
      localObject = ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.b)).a().a(TransFileController.a(localMessageForPic.md5, localMessageForPic.uuid, 131075));
      if ((localObject instanceof C2CPicDownloadProcessor))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + localObject);
        }
        ((BaseDownloadProcessor)localObject).g();
      }
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
 * JD-Core Version:    0.7.0.1
 */