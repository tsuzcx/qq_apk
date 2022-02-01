import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import org.json.JSONObject;

public class zyg
  implements Handler.Callback
{
  private abhw jdField_a_of_type_Abhw;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private apqo jdField_a_of_type_Apqo;
  private String jdField_a_of_type_JavaLangString = "QR_CODE";
  private Handler b;
  
  public zyg(Context paramContext, abhw paramabhw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Abhw = paramabhw;
    this.jdField_a_of_type_Apqo = apqo.a();
    this.jdField_a_of_type_Apqo.a(paramContext, hashCode(), "QrImageScan");
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      if (this.jdField_a_of_type_Apqo != null) {
        this.jdField_a_of_type_Apqo.a(hashCode(), "QrImageScan");
      }
      this.jdField_a_of_type_Abhw = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    paramString1 = Uri.parse("file://" + paramString1);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.b = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper(), this);
      if (TextUtils.isEmpty(paramString2))
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramInt, 0, paramString1).sendToTarget();
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramInt, 0, paramString2).sendToTarget();
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
    for (int i = zxx.a((Uri)paramMessage.obj, this.jdField_a_of_type_AndroidContentContext, j, (SparseArray)localObject);; i = 0)
    {
      boolean bool1 = zxx.a(i);
      boolean bool2 = zxx.b(i);
      if ((bool1) || (bool2))
      {
        if (bool1)
        {
          paramMessage = (Pair)((SparseArray)localObject).get(1);
          this.jdField_a_of_type_JavaLangString = String.valueOf(paramMessage.second).trim();
          if (this.b == null) {
            break;
          }
          this.b.obtainMessage(3, 1, j, paramMessage.first).sendToTarget();
          return true;
        }
        paramMessage = (String)((SparseArray)localObject).get(2);
        if (this.b == null) {
          break;
        }
        this.b.obtainMessage(3, 2, j, paramMessage).sendToTarget();
        return true;
      }
      if (this.b == null) {
        break;
      }
      this.b.obtainMessage(4, j, 0).sendToTarget();
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
          if ((!zxx.a(k)) || (paramMessage == null)) {
            break label350;
          }
          i = 1;
          if ((!zxx.b(k)) || (paramMessage == null)) {
            break label355;
          }
          j = 1;
          if ((i == 0) && (j == 0)) {
            break label391;
          }
          if (i == 0) {
            break label360;
          }
          this.jdField_a_of_type_JavaLangString = paramMessage.optString("scannerType");
          paramMessage = paramMessage.optString("scannerResult");
          if (this.b == null) {
            break;
          }
          this.b.obtainMessage(3, 1, k, paramMessage).sendToTarget();
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
      if (this.b == null) {
        break;
      }
      this.b.obtainMessage(3, 2, k, paramMessage).sendToTarget();
      return true;
      label391:
      if (this.b == null) {
        break;
      }
      this.b.obtainMessage(4, k, 0).sendToTarget();
      return true;
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      if (this.jdField_a_of_type_Abhw == null) {
        break;
      }
      this.jdField_a_of_type_Abhw.a(String.valueOf(paramMessage.obj), i, j);
      return true;
      i = paramMessage.arg1;
      if (this.jdField_a_of_type_Abhw == null) {
        break;
      }
      this.jdField_a_of_type_Abhw.a(i);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyg
 * JD-Core Version:    0.7.0.1
 */