package eipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mqq.app.MobileQQ;

public class EIPCResult
  implements Parcelable
{
  public static final int CODE_CONNECTION_INVALID = -2;
  public static final int CODE_CONNECT_FAILED = -105;
  public static final int CODE_ERR = -102;
  public static final int CODE_HAS_EXCEPTION = -101;
  public static final int CODE_NO_CONNECT = -1;
  public static final int CODE_NO_ERR = 0;
  public static final int CODE_UNKOWN = -100;
  public static final Parcelable.Creator<EIPCResult> CREATOR = new EIPCResult.1();
  static final String KEY_CODE = "code";
  public static EIPCResult UNKNOW_RESULT = new EIPCResult();
  public int code;
  public Bundle data;
  public Throwable e;
  
  static
  {
    UNKNOW_RESULT.code = -100;
  }
  
  public EIPCResult() {}
  
  private EIPCResult(Parcel paramParcel)
  {
    this.code = paramParcel.readInt();
    this.data = paramParcel.readBundle();
    if (this.data != null) {
      this.data.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
  }
  
  public static EIPCResult createExceptionResult(Throwable paramThrowable)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.code = -101;
    localEIPCResult.e = paramThrowable;
    return localEIPCResult;
  }
  
  public static EIPCResult createResult(int paramInt, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.code = paramInt;
    localEIPCResult.data = paramBundle;
    return localEIPCResult;
  }
  
  public static EIPCResult createSuccessResult(Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.code = 0;
    localEIPCResult.data = paramBundle;
    return localEIPCResult;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isSuccess()
  {
    return this.code == 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.code);
    paramParcel.writeBundle(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     eipc.EIPCResult
 * JD-Core Version:    0.7.0.1
 */