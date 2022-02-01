package cooperation.qlink;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avik;
import com.tencent.qphone.base.util.QLog;

public class SendMsg
  implements Parcelable
{
  public static final Parcelable.Creator<SendMsg> CREATOR = new avik();
  public final Bundle extraData = new Bundle();
  int requestId;
  long sendTime = -1L;
  public String serviceCmd;
  long timeout = -1L;
  
  public SendMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  private void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.requestId = paramParcel.readInt();
      this.serviceCmd = paramParcel.readString();
      this.timeout = paramParcel.readLong();
      this.extraData.clear();
      this.extraData.putAll(paramParcel.readBundle(Thread.currentThread().getContextClassLoader()));
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "readFromParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public String toString()
  {
    return "SendMsg appSeq:" + this.requestId + " serviceCmd:" + this.serviceCmd + " timeout:" + this.timeout;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.requestId);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeLong(this.timeout);
      paramParcel.writeBundle(this.extraData);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.SendMsg
 * JD-Core Version:    0.7.0.1
 */