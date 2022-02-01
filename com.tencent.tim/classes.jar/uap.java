import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uap
  extends tzh
{
  private ausj mActionSheet;
  private aqju mDialog;
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    int j = 0;
    switch (paramInt)
    {
    default: 
      return false;
    case 29: 
      if ((this.mDialog != null) && (this.mDialog.isShowing())) {
        this.mDialog.dismiss();
      }
      paramString = this.b.getActivity();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show dialog activity is null or finish");
        return false;
      }
      this.mDialog = aqha.a(paramString, 230);
      paramString = paramJSONObject.optString("title");
      if (!TextUtils.isEmpty(paramString)) {
        this.mDialog.setTitle(paramString);
      }
      paramString = paramJSONObject.optString("content");
      if (!TextUtils.isEmpty(paramString)) {
        this.mDialog.setMessage(paramString);
      }
      paramString = new uap.b(paramtzd);
      paramtzd = paramJSONObject.optString("confirmText");
      if (!TextUtils.isEmpty(paramtzd)) {
        this.mDialog.setPositiveButton(paramtzd, paramString);
      }
      paramJSONObject = paramJSONObject.optString("cancelText");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.mDialog.setNegativeButton(paramJSONObject, paramString);
      }
      this.mDialog.setOnCancelListener(paramString);
      this.mDialog.show();
    }
    for (;;)
    {
      return true;
      if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
        this.mActionSheet.dismiss();
      }
      paramString = this.b.getActivity();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("DoraemonOpenAPI.widget", 1, "execute show action sheet activity is null or finish");
        return false;
      }
      this.mActionSheet = ausj.b(paramString);
      paramString = paramJSONObject.optJSONArray("itemList");
      if (paramString == null)
      {
        ubu.a(paramtzd, -1, "param error");
      }
      else
      {
        int k = paramString.length();
        int i = 0;
        for (paramInt = j; i < k; paramInt = 1)
        {
          String str = paramString.optString(i, "");
          this.mActionSheet.addButton(str);
          i += 1;
        }
        paramString = new uap.a(this.mActionSheet, paramtzd);
        paramJSONObject = paramJSONObject.optString("cancelText");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.mActionSheet.addCancelButton(paramJSONObject);
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          this.mActionSheet.a(paramString);
          this.mActionSheet.setOnCancelListener(paramString);
          this.mActionSheet.a(paramString);
          this.mActionSheet.show();
        }
        else
        {
          ubu.a(paramtzd, -1, "param error");
        }
      }
    }
  }
  
  public void destroy()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing())) {
      this.mDialog.dismiss();
    }
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
      this.mActionSheet.dismiss();
    }
  }
  
  static class a
    implements DialogInterface.OnCancelListener, ausj.a, ausj.c
  {
    ausj O;
    tzd e;
    
    public a(ausj paramausj, tzd paramtzd)
    {
      this.O = paramausj;
      this.e = paramtzd;
    }
    
    public void OnClick(View paramView, int paramInt)
    {
      this.O.dismiss();
      paramView = new JSONObject();
      try
      {
        paramView.put("cancel", false);
        paramView.put("tapIndex", paramInt);
        ubu.a(this.e, paramView);
        return;
      }
      catch (JSONException paramView)
      {
        String str = paramView.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
        }
        tzd localtzd = this.e;
        paramView = str;
        if (str == null) {
          paramView = "";
        }
        ubu.a(localtzd, -2, paramView);
      }
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("cancel", true);
        paramDialogInterface.put("tapIndex", -1);
        ubu.a(this.e, paramDialogInterface);
        return;
      }
      catch (JSONException paramDialogInterface)
      {
        String str = paramDialogInterface.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
        }
        tzd localtzd = this.e;
        paramDialogInterface = str;
        if (str == null) {
          paramDialogInterface = "";
        }
        ubu.a(localtzd, -2, paramDialogInterface);
      }
    }
    
    public void onDismiss()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("cancel", true);
        localJSONObject.put("tapIndex", -1);
        ubu.a(this.e, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        String str = localJSONException.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
        }
        tzd localtzd = this.e;
        Object localObject = str;
        if (str == null) {
          localObject = "";
        }
        ubu.a(localtzd, -2, (String)localObject);
      }
    }
  }
  
  static class b
    implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
  {
    tzd e;
    
    public b(tzd paramtzd)
    {
      this.e = paramtzd;
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("confirm", false);
        paramDialogInterface.put("cancel", true);
        ubu.a(this.e, paramDialogInterface);
        return;
      }
      catch (JSONException paramDialogInterface)
      {
        String str = paramDialogInterface.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
        }
        tzd localtzd = this.e;
        paramDialogInterface = str;
        if (str == null) {
          paramDialogInterface = "";
        }
        ubu.a(localtzd, -1, paramDialogInterface);
      }
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      boolean bool2 = true;
      paramDialogInterface = new JSONObject();
      boolean bool1;
      if (paramInt == 1) {
        bool1 = true;
      }
      try
      {
        paramDialogInterface.put("confirm", bool1);
        if (paramInt != 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramDialogInterface.put("cancel", bool1);
          ubu.a(this.e, paramDialogInterface);
          return;
          bool1 = false;
          break;
        }
        String str;
        tzd localtzd;
        return;
      }
      catch (JSONException paramDialogInterface)
      {
        str = paramDialogInterface.getMessage();
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
        }
        localtzd = this.e;
        paramDialogInterface = str;
        if (str == null) {
          paramDialogInterface = "";
        }
        ubu.a(localtzd, -1, paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uap
 * JD-Core Version:    0.7.0.1
 */