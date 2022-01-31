package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import java.io.OutputStream;
import java.net.URL;

public class ChatImageDownloader$DownloadData
{
  int jdField_a_of_type_Int;
  public long a;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public MessageForPic a;
  public PicDownloadInfo a;
  public PicUploadInfo a;
  OutputStream jdField_a_of_type_JavaIoOutputStream;
  String jdField_a_of_type_JavaLangString;
  URL jdField_a_of_type_JavaNetURL;
  boolean jdField_a_of_type_Boolean;
  public int b = 1;
  String b;
  public int c;
  public String c;
  public int d = -1;
  
  public ChatImageDownloader$DownloadData(ChatImageDownloader paramChatImageDownloader)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = PicReq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatImageDownloader.DownloadData
 * JD-Core Version:    0.7.0.1
 */