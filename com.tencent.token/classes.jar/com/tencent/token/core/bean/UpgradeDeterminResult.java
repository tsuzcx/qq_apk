package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.List;

public class UpgradeDeterminResult
  implements Serializable
{
  public static final int BINDTYPE_APPEAL = 7;
  public static final int BINDTYPE_DIR = 2;
  public static final int BINDTYPE_DNA = 1;
  public static final int BINDTYPE_NOCHECK_NOAUTH = 5;
  public static final int BINDTYPE_NOCHECK_NONEPHONE = 3;
  public static final int BINDTYPE_NOCHECK_VERFIYPHONE = 6;
  public static final int BINDTYPE_NOCHECK_WITHAUTH = 4;
  public static final int BINDTYPE_REALNAME = 8;
  public static final int BINDTYPE_REALNAME_H5 = 9;
  private static final long serialVersionUID = 1229246620832794524L;
  private int bindType = 0;
  public int mHaveMobile = 0;
  public int mMobileAppear = 0;
  public String mMobileMask = "";
  public int mQqtokenAppear = 0;
  public int mQuesAppear = 0;
  public List<QuesInfoItem> mQuesInfo = null;
  public long mServerTime;
  public String mSmsPort;
  public String mSmsPrefix = "";
  public String mUin = "";
  
  public boolean a()
  {
    return this.mHaveMobile == 1;
  }
  
  public String b()
  {
    return this.mMobileMask;
  }
  
  public boolean c()
  {
    return this.mMobileAppear == 1;
  }
  
  public boolean d()
  {
    return this.mQqtokenAppear == 1;
  }
  
  public boolean e()
  {
    return this.mQuesAppear == 1;
  }
  
  public int f()
  {
    return this.bindType;
  }
  
  public class QuesInfoItem
    implements Serializable
  {
    private static final long serialVersionUID = -6303479941324604162L;
    public String mContent;
    public int mId;
    public int mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.UpgradeDeterminResult
 * JD-Core Version:    0.7.0.1
 */