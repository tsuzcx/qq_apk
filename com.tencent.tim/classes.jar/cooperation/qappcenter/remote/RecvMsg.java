package cooperation.qappcenter.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avgw;
import com.tencent.qphone.base.util.QLog;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new avgw();
  public Bundle extraData = new Bundle();
  public int reqSeq;
  public int resultCode;
  public String serviceCmd;
  
  public RecvMsg() {}
  
  public RecvMsg(int paramInt, String paramString)
  {
    this.resultCode = 1001;
    this.reqSeq = paramInt;
    this.serviceCmd = paramString;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getRequestSsoSeq()
  {
    return this.extraData.getInt("_ssoSeqKey", -1);
  }
  
  /* Error */
  public void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 63	android/os/Parcel:readInt	()I
    //   5: putfield 39	cooperation/qappcenter/remote/RecvMsg:reqSeq	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 63	android/os/Parcel:readInt	()I
    //   13: putfield 37	cooperation/qappcenter/remote/RecvMsg:resultCode	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 67	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 41	cooperation/qappcenter/remote/RecvMsg:serviceCmd	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 34	cooperation/qappcenter/remote/RecvMsg:extraData	Landroid/os/Bundle;
    //   28: invokevirtual 70	android/os/Bundle:clear	()V
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: invokevirtual 80	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokevirtual 84	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 90	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokestatic 96	cooperation/qzone/QzonePluginProxyActivity:c	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   50: invokevirtual 100	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   53: aload_0
    //   54: getfield 34	cooperation/qappcenter/remote/RecvMsg:extraData	Landroid/os/Bundle;
    //   57: aload_1
    //   58: invokevirtual 104	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   61: return
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   67: goto -14 -> 53
    //   70: astore_1
    //   71: ldc 109
    //   73: iconst_1
    //   74: ldc 111
    //   76: aload_1
    //   77: invokestatic 117	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	RecvMsg
    //   0	82	1	paramParcel	Parcel
    //   62	2	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	53	62	java/lang/Exception
    //   0	43	70	java/lang/RuntimeException
    //   43	53	70	java/lang/RuntimeException
    //   53	61	70	java/lang/RuntimeException
    //   63	67	70	java/lang/RuntimeException
  }
  
  public void setBusinessFail(int paramInt, String paramString)
  {
    this.resultCode = paramInt;
    this.extraData.putString("error", paramString);
  }
  
  public String toString()
  {
    return "RecvMsg ssoseq:" + getRequestSsoSeq() + " resultCode:" + this.resultCode + " serviceCmd:" + this.serviceCmd + " appSeq:" + this.reqSeq;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.reqSeq);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeBundle(this.extraData);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qappcenter.remote.RecvMsg
 * JD-Core Version:    0.7.0.1
 */