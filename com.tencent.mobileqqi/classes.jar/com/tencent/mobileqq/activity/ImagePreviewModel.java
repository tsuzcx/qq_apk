package com.tencent.mobileqq.activity;

import android.net.Uri;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ImagePreviewModel
{
  static final String jdField_a_of_type_JavaLangString = "ImagePreviewModel";
  int jdField_a_of_type_Int;
  ImageInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoImageInfo;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ImageInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoImageInfo;
  }
  
  public ImageInfo a(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (ImageInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoImageInfo = a(paramInt);
  }
  
  public void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, ImageInfo paramImageInfo)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if ((paramImageInfo != null) && (paramImageInfo.jdField_d_of_type_JavaLangString != null)) {
      paramImageInfo.jdField_a_of_type_AndroidNetUri = Uri.parse(paramImageInfo.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoImageInfo = paramImageInfo;
    if (paramImageInfo != null) {
      paramImageInfo.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramImageInfo);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, ImageInfo paramImageInfo)
  {
    int k;
    ArrayList localArrayList;
    int m;
    int i;
    int j;
    label85:
    MessageRecord localMessageRecord;
    Object localObject1;
    int n;
    Object localObject2;
    boolean bool;
    if (paramImageInfo.jdField_c_of_type_JavaLangString.equals(String.valueOf(AppConstants.P)))
    {
      paramQQAppInterface = paramQQAppInterface.a().a();
      if (paramQQAppInterface == null) {
        return false;
      }
      paramQQAppInterface = (List)((ArrayList)paramQQAppInterface).clone();
      k = 1;
      localArrayList = new ArrayList();
      if ((paramQQAppInterface.isEmpty()) && (QLog.isColorLevel())) {
        QLog.d("ImagePreviewModel", 2, "init error,tempList.isEmpty()");
      }
      m = 0;
      i = 0;
      j = -1;
      if (m >= paramQQAppInterface.size()) {
        break label1230;
      }
      localMessageRecord = (MessageRecord)paramQQAppInterface.get(m);
      localObject1 = localMessageRecord.msg;
      n = localMessageRecord.msgtype;
      if ((k != 0) && (n == -2000))
      {
        localObject1 = (DataLineMsgRecord)localMessageRecord;
        localObject2 = "" + '\026';
        localObject1 = (String)localObject2 + ((DataLineMsgRecord)localObject1).path + "|";
        localObject1 = (String)localObject1 + String.valueOf(0) + "|";
        localObject1 = (String)localObject1 + String.valueOf(1) + "|";
        new StringBuilder().append((String)localObject1).append(String.valueOf(1)).toString();
      }
      if (!(localMessageRecord instanceof MessageForPic)) {
        break label735;
      }
      localObject1 = (MessageForPic)localMessageRecord;
      ((MessageForPic)localObject1).doParse();
      localObject2 = new ImageInfo();
      ((ImageInfo)localObject2).jdField_a_of_type_Long = Long.valueOf(((MessageForPic)localObject1).size).longValue();
      ((ImageInfo)localObject2).jdField_d_of_type_JavaLangString = ((MessageForPic)localObject1).path;
      ((ImageInfo)localObject2).jdField_e_of_type_Long = localMessageRecord.uniseq;
      if (localMessageRecord.issend != 2) {
        break label600;
      }
      bool = true;
      label353:
      ((ImageInfo)localObject2).f = bool;
      ((ImageInfo)localObject2).jdField_e_of_type_Int = localMessageRecord.issend;
      ((ImageInfo)localObject2).jdField_c_of_type_JavaLangString = localMessageRecord.frienduin;
      ((ImageInfo)localObject2).jdField_d_of_type_Int = localMessageRecord.istroop;
      if (((ImageInfo)localObject2).jdField_d_of_type_JavaLangString != null) {
        ((ImageInfo)localObject2).jdField_a_of_type_AndroidNetUri = Uri.parse(((ImageInfo)localObject2).jdField_d_of_type_JavaLangString);
      }
      ((ImageInfo)localObject2).jdField_c_of_type_Long = localMessageRecord.time;
      ((ImageInfo)localObject2).jdField_h_of_type_JavaLangString = localMessageRecord.selfuin;
      ((ImageInfo)localObject2).g = localMessageRecord.msgtype;
      ((ImageInfo)localObject2).jdField_h_of_type_Int = localMessageRecord.versionCode;
      ((ImageInfo)localObject2).j = localMessageRecord.msg;
      ((ImageInfo)localObject2).jdField_e_of_type_JavaLangString = ((MessageForPic)localObject1).uuid;
      ((ImageInfo)localObject2).jdField_i_of_type_JavaLangString = ((MessageForPic)localObject1).md5;
      ((ImageInfo)localObject2).jdField_i_of_type_Int = ((MessageForPic)localObject1).fileSizeFlag;
      ((ImageInfo)localObject2).jdField_d_of_type_Long = ((MessageForPic)localObject1).groupFileID;
      ((ImageInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
      if (n == -3000) {
        break label1293;
      }
      if (n != -30003) {
        break label606;
      }
      n = j;
      j = i;
      i = n;
    }
    label1156:
    label1230:
    for (;;)
    {
      m += 1;
      n = j;
      j = i;
      i = n;
      break label85;
      paramQQAppInterface = paramQQAppInterface.a().a(paramImageInfo.jdField_c_of_type_JavaLangString, paramImageInfo.jdField_d_of_type_Int, new int[] { -20000, -2000, -1035 });
      k = 0;
      break;
      label600:
      bool = false;
      break label353;
      label606:
      if (k != 0) {}
      while ((URLDrawableHelper.a(paramBaseActivity, (PicUiInterface)localObject1, 65537)) || (((ImageInfo)localObject2).g == -2001))
      {
        if (localMessageRecord.uniseq == paramImageInfo.jdField_e_of_type_Long)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoImageInfo = ((ImageInfo)localObject2);
          j = i;
        }
        if (((ImageInfo)localObject2).jdField_b_of_type_Boolean) {
          ((ImageInfo)localObject2).jdField_b_of_type_JavaLangString = ((ImageInfo)localObject2).jdField_d_of_type_JavaLangString;
        }
        if ((k != 0) && (n == -2000)) {
          ((ImageInfo)localObject2).jdField_d_of_type_Int = 6000;
        }
        localArrayList.add(localObject2);
        n = i + 1;
        i = j;
        j = n;
        break;
      }
      n = i;
      i = j;
      j = n;
      continue;
      label735:
      if ((localMessageRecord instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localMessageRecord;
        ((MessageForMixedMsg)localObject1).parse();
        int i3 = ((MessageForMixedMsg)localObject1).msgElemList.size();
        n = 0;
        if (n < i3)
        {
          int i1 = i;
          int i2 = j;
          ImageInfo localImageInfo;
          if ((((MessageForMixedMsg)localObject1).msgElemList.get(n) instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)((MessageForMixedMsg)localObject1).msgElemList.get(n);
            localImageInfo = new ImageInfo();
            localImageInfo.jdField_a_of_type_Long = Long.valueOf(((MessageForPic)localObject2).size).longValue();
            localImageInfo.jdField_d_of_type_JavaLangString = ((MessageForPic)localObject2).path;
            localImageInfo.jdField_e_of_type_Long = localMessageRecord.uniseq;
            localImageInfo.jdField_c_of_type_Int = ((MessageForPic)localObject2).subMsgId;
            if (localMessageRecord.issend != 2) {
              break label1150;
            }
          }
          label1150:
          for (bool = true;; bool = false)
          {
            localImageInfo.f = bool;
            localImageInfo.jdField_e_of_type_Int = localMessageRecord.issend;
            localImageInfo.jdField_c_of_type_JavaLangString = localMessageRecord.frienduin;
            localImageInfo.jdField_d_of_type_Int = localMessageRecord.istroop;
            if (localImageInfo.jdField_d_of_type_JavaLangString != null) {
              localImageInfo.jdField_a_of_type_AndroidNetUri = Uri.parse(localImageInfo.jdField_d_of_type_JavaLangString);
            }
            localImageInfo.jdField_c_of_type_Long = localMessageRecord.time;
            localImageInfo.jdField_h_of_type_JavaLangString = localMessageRecord.selfuin;
            localImageInfo.g = localMessageRecord.msgtype;
            localImageInfo.jdField_h_of_type_Int = localMessageRecord.versionCode;
            localImageInfo.j = localMessageRecord.msg;
            localImageInfo.jdField_e_of_type_JavaLangString = ((MessageForPic)localObject2).uuid;
            localImageInfo.jdField_i_of_type_JavaLangString = ((MessageForPic)localObject2).md5;
            localImageInfo.jdField_i_of_type_Int = ((MessageForPic)localObject2).fileSizeFlag;
            localImageInfo.jdField_d_of_type_Long = ((MessageForPic)localObject2).groupFileID;
            if (localImageInfo.jdField_e_of_type_Long == 0L) {
              QLog.d("ImagePreviewModel", 2, "MessageForMixedMsg id==0 ,subMsgid:" + localImageInfo.jdField_c_of_type_Int + ",uuid:" + localImageInfo.jdField_e_of_type_JavaLangString + ",md5:" + localImageInfo.jdField_i_of_type_JavaLangString);
            }
            if ((URLDrawableHelper.a(paramBaseActivity, (PicUiInterface)localObject2, 65537)) || (localImageInfo.g == -2001)) {
              break label1156;
            }
            i2 = j;
            i1 = i;
            n += 1;
            i = i1;
            j = i2;
            break;
          }
          if ((((MessageForPic)localObject2).uniseq == paramImageInfo.jdField_e_of_type_Long) && (((MessageForPic)localObject2).subMsgId == paramImageInfo.jdField_c_of_type_Int))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoImageInfo = localImageInfo;
            j = i;
          }
          for (;;)
          {
            i1 = i + 1;
            if (localImageInfo.jdField_b_of_type_Boolean) {
              localImageInfo.jdField_b_of_type_JavaLangString = localImageInfo.jdField_d_of_type_JavaLangString;
            }
            localArrayList.add(localImageInfo);
            i2 = j;
            break;
            if ((j == -1) || (localArrayList.isEmpty()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ImagePreviewModel", 2, "init error,dataList.isEmpty()");
              }
              return false;
            }
            this.jdField_a_of_type_JavaUtilList = localArrayList;
            this.jdField_a_of_type_Int = j;
            return true;
          }
        }
        n = i;
        i = j;
        j = n;
      }
      else
      {
        n = i;
        i = j;
        j = n;
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ImagePreviewModel
 * JD-Core Version:    0.7.0.1
 */