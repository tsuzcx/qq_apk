import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.biz.widgets.ScannerView.b;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONObject;

public class rwf
  implements Handler.Callback
{
  private adjn jdField_a_of_type_Adjn;
  private ScannerView.b jdField_a_of_type_ComTencentBizWidgetsScannerView$b;
  private String aCK = "QR_CODE";
  private Handler by;
  private Context mContext;
  private Handler mUiHandler;
  
  public rwf(Context paramContext, ScannerView.b paramb)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b = paramb;
    this.jdField_a_of_type_Adjn = adjn.a();
    this.jdField_a_of_type_Adjn.h(paramContext, hashCode(), "QrImageScan");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      j = paramMessage.arg1;
      localObject = new SparseArray(2);
      if (!(paramMessage.obj instanceof Uri)) {
        break;
      }
    }
    for (int i = rvx.a((Uri)paramMessage.obj, this.mContext, j, (SparseArray)localObject);; i = 0)
    {
      boolean bool1 = rvx.fa(i);
      boolean bool2 = rvx.fb(i);
      if ((bool1) || (bool2))
      {
        if (bool1)
        {
          paramMessage = (Pair)((SparseArray)localObject).get(1);
          this.aCK = String.valueOf(paramMessage.second).trim();
          if (this.mUiHandler == null) {
            break;
          }
          this.mUiHandler.obtainMessage(3, 1, j, paramMessage.first).sendToTarget();
          return true;
        }
        paramMessage = (String)((SparseArray)localObject).get(2);
        if (this.mUiHandler == null) {
          break;
        }
        this.mUiHandler.obtainMessage(3, 2, j, paramMessage).sendToTarget();
        return true;
      }
      if (this.mUiHandler == null) {
        break;
      }
      this.mUiHandler.obtainMessage(4, j, 0).sendToTarget();
      return true;
      int k = paramMessage.arg1;
      localObject = null;
      if ((paramMessage.obj instanceof String)) {
        localObject = (String)paramMessage.obj;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        try
        {
          paramMessage = new JSONObject((String)localObject);
          if ((!rvx.fa(k)) || (paramMessage == null)) {
            break label350;
          }
          i = 1;
          if ((!rvx.fb(k)) || (paramMessage == null)) {
            break label355;
          }
          j = 1;
          if ((i == 0) && (j == 0)) {
            break label391;
          }
          if (i == 0) {
            break label360;
          }
          this.aCK = paramMessage.optString("scannerType");
          paramMessage = paramMessage.optString("scannerResult");
          if (this.mUiHandler == null) {
            break;
          }
          this.mUiHandler.obtainMessage(3, 1, k, paramMessage).sendToTarget();
          return true;
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
        }
        paramMessage = null;
        continue;
        label350:
        i = 0;
        continue;
        label355:
        j = 0;
      }
      label360:
      paramMessage = paramMessage.optString("strMini");
      if (this.mUiHandler == null) {
        break;
      }
      this.mUiHandler.obtainMessage(3, 2, k, paramMessage).sendToTarget();
      return true;
      label391:
      if (this.mUiHandler == null) {
        break;
      }
      this.mUiHandler.obtainMessage(4, k, 0).sendToTarget();
      return true;
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b.z(String.valueOf(paramMessage.obj), i, j);
      return true;
      i = paramMessage.arg1;
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b.yc(i);
      return true;
    }
  }
  
  public String ni()
  {
    return this.aCK;
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.by != null)
      {
        this.by.removeCallbacksAndMessages(null);
        this.by = null;
      }
      if (this.mUiHandler != null)
      {
        this.mUiHandler.removeCallbacksAndMessages(null);
        this.mUiHandler = null;
      }
      if (this.jdField_a_of_type_Adjn != null) {
        this.jdField_a_of_type_Adjn.ak(hashCode(), "QrImageScan");
      }
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$b = null;
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  public void x(String paramString1, int paramInt, String paramString2)
  {
    if (this.mContext == null) {
      return;
    }
    paramString1 = Uri.parse("file://" + paramString1);
    if (this.by == null) {}
    try
    {
      this.by = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.mUiHandler = new Handler(this.mContext.getMainLooper(), this);
      if (TextUtils.isEmpty(paramString2))
      {
        this.by.obtainMessage(1, paramInt, 0, paramString1).sendToTarget();
        return;
      }
    }
    finally {}
    this.by.obtainMessage(2, paramInt, 0, paramString2).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwf
 * JD-Core Version:    0.7.0.1
 */