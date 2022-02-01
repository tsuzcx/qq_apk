package com.tencent.mobileqq.data.fts;

import com.tencent.mobileqq.data.FTSMessageDelete;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FTSMessageForDel
  extends FTSMessage
{
  public static final int MODE_DEL_ALL = 3;
  public static final int MODE_DEL_ENTIRE_CONTENT = 4;
  public static final int MODE_DEL_ONE = 1;
  public static final int MODE_DEL_PATCH = 2;
  private static final String TAG = "FTSMessageForDel";
  public String mExt1Key;
  private ArrayList<String> mOIdList = new ArrayList(30);
  public int mode = 1;
  
  private String createDelForEntire()
  {
    try
    {
      String str = "DELETE FROM IndexContent;";
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FTSMessageForDel", 2, "createDeleteSQL failure: ", localThrowable);
      }
    }
    return null;
  }
  
  private String createDelForOne()
  {
    try
    {
      Object localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("DELETE FROM IndexContent WHERE IndexContent MATCH 'ext1:").append(this.mExt1Key);
      ((StringBuilder)localObject).append(" oid:");
      int i = 0;
      while (i < this.mOIdList.size())
      {
        if (i > 0) {
          ((StringBuilder)localObject).append(" OR ");
        }
        ((StringBuilder)localObject).append((String)this.mOIdList.get(i));
        i += 1;
      }
      ((StringBuilder)localObject).append("';");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FTSMessageForDel", 2, "createDeleteSQL failure: ", localThrowable);
      }
    }
    return null;
  }
  
  private String createDelForPatch()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    String str = getExt1(this.uin, this.istroop);
    localStringBuilder.append("DELETE FROM IndexContent WHERE IndexContent MATCH 'ext4:").append(this.msgCounter).append(" ext1:").append(str).append("';");
    return localStringBuilder.toString();
  }
  
  public void appendOId(FTSMessageDelete paramFTSMessageDelete)
  {
    this.mOIdList.add(String.valueOf(paramFTSMessageDelete.mOId));
  }
  
  public String createDeleteSQL()
  {
    if (this.mode == 2) {
      return createDelForPatch();
    }
    if (this.mode == 4) {
      return createDelForEntire();
    }
    return createDelForOne();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.fts.FTSMessageForDel
 * JD-Core Version:    0.7.0.1
 */