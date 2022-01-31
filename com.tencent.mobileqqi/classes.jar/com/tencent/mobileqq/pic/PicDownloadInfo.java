package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.net.URL;

public class PicDownloadInfo
  extends PicBaseInfo
{
  public static final int l = 0;
  public static final int m = -1;
  public static final int n = -2;
  public ReportInfo a;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public long e;
  public int f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public String l;
  
  String a()
  {
    int i1 = 65537;
    if ("chatthumb".equals(this.jdField_e_of_type_JavaLangString)) {}
    while (this.jdField_a_of_type_Boolean)
    {
      localObject = new PicUploadInfo();
      ((PicUploadInfo)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      ((PicUploadInfo)localObject).jdField_e_of_type_Int = this.jdField_e_of_type_Int;
      ((PicUploadInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((PicUploadInfo)localObject).jdField_f_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      localObject = URLDrawableHelper.a((PicUploadInfo)localObject, i1, null);
      if (localObject == null) {
        break label129;
      }
      return ((URL)localObject).toString();
      if ("chatimg".equals(this.jdField_e_of_type_JavaLangString)) {
        i1 = 1;
      } else if ("chatraw".equals(this.jdField_e_of_type_JavaLangString)) {
        i1 = 131075;
      }
    }
    Object localObject = URLDrawableHelper.a(this, i1, null);
    if (localObject != null) {
      return ((URL)localObject).toString();
    }
    label129:
    return null;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.g))
    {
      a("PicDownloadInfo.check", "uuid invaid:" + this.g);
      return false;
    }
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      a("checkPicInfo", "selfUin invalid,selfUin:" + this.jdField_b_of_type_JavaLangString);
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_e_of_type_Long == 0L))
    {
      a("PicDownloadInfo.check", "groupFileID invaid:" + this.jdField_e_of_type_Long);
      return false;
    }
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("uuid:").append(this.g);
    localStringBuilder.append("\n |-").append("groupFileID:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n |-").append("subMsgId:").append(this.jdField_i_of_type_Int);
    localStringBuilder.append("\n |-").append("subVersion:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("protocol:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("fileSizeFlag:").append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbMsgUrl:").append(this.h);
    localStringBuilder.append("\n |-").append("bigMsgUrl:").append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("rawMsgUrl").append(this.j);
    localStringBuilder.append("\n |-").append("isMixed:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n |-").append("shareAppID:").append(this.jdField_e_of_type_Long);
    localStringBuilder.append("\n |-").append("action:").append(this.k);
    localStringBuilder.append("\n |-").append("actMsgContentValue:").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n |-").append("picExtraFlag:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-").append("picExtraObject:").append(this.jdField_a_of_type_JavaLangObject);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicDownloadInfo
 * JD-Core Version:    0.7.0.1
 */