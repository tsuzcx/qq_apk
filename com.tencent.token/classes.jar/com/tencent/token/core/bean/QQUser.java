package com.tencent.token.core.bean;

import java.io.Serializable;

public class QQUser
  implements Serializable
{
  private static final long serialVersionUID = -191631782648221847L;
  public String mEmail;
  public long mHeadImageUpdateTime;
  public boolean mIsBinded = false;
  public boolean mIsCurrentUser;
  public boolean mIsLoadingHeadImage = false;
  public boolean mIsRegisterFacePwd = false;
  public boolean mIsSupperQQ;
  public boolean mIsZzb = false;
  public String mMobileMask;
  public String mNickName;
  public long mRealUin;
  public long mUin;
  public String mUinMask;
  public int verify_sms;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.QQUser
 * JD-Core Version:    0.7.0.1
 */