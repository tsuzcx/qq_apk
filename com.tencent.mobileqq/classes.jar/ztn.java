import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ztn
  extends zrx
{
  private bafb jdField_a_of_type_Bafb;
  private begr jdField_a_of_type_Begr;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull zrt paramzrt)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
      paramString = this.jdField_a_of_type_Zrw.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Bafb = babr.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bafb.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_Bafb.setMessage(paramString);
      }
      paramString = new ztp(paramzrt);
      paramzrt = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramzrt)) {
        this.jdField_a_of_type_Bafb.setPositiveButton(paramzrt, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.jdField_a_of_type_Bafb.setNegativeButton(paramJSONObject, paramString);
      }
      this.jdField_a_of_type_Bafb.setOnCancelListener(paramString);
      this.jdField_a_of_type_Bafb.show();
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
        this.jdField_a_of_type_Begr.dismiss();
      }
      paramString = this.jdField_a_of_type_Zrw.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.jdField_a_of_type_Begr = begr.a(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        zva.a(paramzrt, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.jdField_a_of_type_Begr.c(str);
          i += 1;
        }
        paramString = new zto(this.jdField_a_of_type_Begr, paramzrt);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.jdField_a_of_type_Begr.d(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_Begr.a(paramString);
          this.jdField_a_of_type_Begr.setOnCancelListener(paramString);
          this.jdField_a_of_type_Begr.a(paramString);
          this.jdField_a_of_type_Begr.show();
        }
        else
        {
          zva.a(paramzrt, -1, "param error");
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      this.jdField_a_of_type_Begr.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ztn
 * JD-Core Version:    0.7.0.1
 */