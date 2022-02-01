import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class abnn
  implements aqdf.a
{
  acfd jdField_a_of_type_Acfd = new abno(this);
  private aqdf jdField_a_of_type_Aqdf;
  private Map<String, Integer> iV = new HashMap();
  private Map<String, Integer> iW = new HashMap();
  WeakReference<QQAppInterface> mAppRef;
  
  public abnn(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Aqdf = new aqdf(paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qwe", 2, "onDecodeTaskCompleted:" + paramString);
      }
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      if ((this.iW != null) && (this.iW.get(paramString + "head") != null))
      {
        paramInt1 = ((Integer)this.iW.remove(paramString + "head")).intValue();
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", 2);
        localBundle.putString("uin", paramString);
        localBundle.putParcelable("head", paramBitmap);
        paramString = EIPCResult.createResult(0, localBundle);
        abmm.a().callbackResult(paramInt1, paramString);
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("apollochannel_CmGameAccountHandler", 1, "onDestroy");
    this.mAppRef = null;
    this.iV.clear();
    this.iW.clear();
    this.iV = null;
    this.iW = null;
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
  }
  
  public void u(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.mAppRef == null) || (this.mAppRef.get() == null)) {}
    do
    {
      return;
      switch (paramInt2)
      {
      default: 
        return;
      case 1: 
        localObject = aqgv.c((QQAppInterface)this.mAppRef.get(), paramString, true);
        if ((!apqw.isNumeric((String)localObject)) || (!((String)localObject).equals(paramString))) {
          break label147;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_CmGameAccountHandler", 2, "nickName.equals(uin):" + paramString);
        }
        break;
      }
    } while (this.iV == null);
    this.iV.put(paramString + "nick", Integer.valueOf(paramInt1));
    return;
    label147:
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_CmGameAccountHandler", 2, "nickName != null:" + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1);
    localBundle.putString("uin", paramString);
    localBundle.putString("nickName", (String)localObject);
    paramString = EIPCResult.createResult(0, localBundle);
    abmm.a().callbackResult(paramInt1, paramString);
    return;
    Object localObject = this.jdField_a_of_type_Aqdf.a(1, String.valueOf(paramString), 0, (byte)1);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qwe", 2, "bm != null:" + paramString);
      }
      localObject = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, true);
      localBundle = new Bundle();
      localBundle.putInt("type", 2);
      localBundle.putString("uin", paramString);
      localBundle.putParcelable("head", (Parcelable)localObject);
      paramString = EIPCResult.createResult(0, localBundle);
      abmm.a().callbackResult(paramInt1, paramString);
      return;
    }
    if (this.iW != null) {
      this.iW.put(paramString + "head", Integer.valueOf(paramInt1));
    }
    this.jdField_a_of_type_Aqdf.a(paramString, 200, false, 1, true, (byte)0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abnn
 * JD-Core Version:    0.7.0.1
 */