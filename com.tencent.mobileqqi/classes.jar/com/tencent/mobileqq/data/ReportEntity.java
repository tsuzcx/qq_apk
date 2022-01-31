package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.servlet.ReportServlet;
import mqq.app.NewIntent;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="mTag, mMainAction, mSelfUin, mCommiteUin, mSubAction, mActionName, mFromType, mResult, mReverved1, mReverved2, mReverved3, mReverved4")
public class ReportEntity
  extends Entity
{
  public String mActionName;
  public String mCommiteUin;
  public int mCount;
  public int mFromType;
  public String mMainAction;
  public int mResult;
  public String mReverved1;
  public String mReverved2;
  public String mReverved3;
  public String mReverved4;
  public String mSelfUin;
  public String mSubAction;
  public String mTag;
  
  public void doReport(QQAppInterface paramQQAppInterface)
  {
    String str = getContent();
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", this.mTag);
    localNewIntent.putExtra("content", str);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public String getContent()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.mMainAction != null) && (this.mMainAction.length() > 0)) {
      localStringBuilder.append(this.mMainAction).append('|');
    }
    localStringBuilder.append(this.mSelfUin).append('|');
    localStringBuilder.append(this.mCommiteUin).append('|');
    localStringBuilder.append(this.mSubAction).append('|');
    localStringBuilder.append(this.mActionName).append('|');
    localStringBuilder.append(this.mFromType).append('|');
    localStringBuilder.append(this.mCount).append('|');
    localStringBuilder.append(this.mResult).append('|');
    localStringBuilder.append(this.mReverved1).append('|');
    localStringBuilder.append(this.mReverved2).append('|');
    localStringBuilder.append(this.mReverved3).append('|');
    localStringBuilder.append(this.mReverved4).append('|');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ReportEntity
 * JD-Core Version:    0.7.0.1
 */