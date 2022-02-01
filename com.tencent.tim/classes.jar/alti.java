import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class alti
  extends alth
{
  public ResultReceiver fromReceiver;
  
  public static alti a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("redpoint.fromReceiverIPCCode", -1);
    Object localObject = (Class)dm.get(i);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseReq getReq", 2, "class name is " + ((Class)localObject).getName());
      }
      try
      {
        localObject = (alti)((Class)localObject).newInstance();
        ((alti)localObject).fromBundle(paramBundle);
        return localObject;
      }
      catch (Exception paramBundle)
      {
        return null;
      }
    }
    return null;
  }
  
  public final boolean doCallback(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.fromReceiver == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseReq doCallback", 2, "bundle == null or fromReceiver == null");
      }
      return false;
    }
    this.fromReceiver.send(0, paramBundle);
    return true;
  }
  
  public abstract void e(QQAppInterface paramQQAppInterface, Bundle paramBundle);
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.fromReceiver = ((ResultReceiver)paramBundle.getParcelable("redpoint.fromReceiverKey"));
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    if (this.fromReceiver != null)
    {
      Parcel localParcel = Parcel.obtain();
      this.fromReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ResultReceiver localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("redpoint.fromReceiverKey", localResultReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alti
 * JD-Core Version:    0.7.0.1
 */