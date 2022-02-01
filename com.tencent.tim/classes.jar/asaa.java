import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.YybHandleUtil.1;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.text.DecimalFormat;
import mqq.os.MqqHandler;

public class asaa
{
  public static String TAG = "YybHandleUtil";
  public static String apkPath = "APK/MobileAssistant_main.apk";
  public static final String cDP = acfp.m(2131716993);
  public static String destPath = "yyb.apk";
  
  public static boolean aHC()
  {
    String str = aroi.a().getContext().getFilesDir().getAbsolutePath() + File.separator + destPath;
    return arxn.installApp(aroi.a().getContext(), str);
  }
  
  public static void emn()
  {
    arwt.d(TAG, "---deleteYYBApkPackage--");
    ThreadManager.getSubThreadHandler().post(new YybHandleUtil.1());
  }
  
  public static String gv(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    float f2 = paramInt;
    paramInt = 0;
    float f1;
    String str2;
    String str1;
    if (f2 / 1048576.0F > 1.0F)
    {
      f1 = f2 / 1048576.0F;
      paramInt = 2;
      str2 = new DecimalFormat("#.#").format(f1);
      if (paramInt != 2) {
        break label92;
      }
      str1 = "MB";
    }
    for (;;)
    {
      return str2 + str1;
      f1 = f2;
      if (f2 / 1024.0F <= 1.0F) {
        break;
      }
      f1 = f2 / 1024.0F;
      paramInt = 1;
      break;
      label92:
      if (paramInt == 1) {
        str1 = "KB";
      } else {
        str1 = "B";
      }
    }
  }
  
  public static class a
    extends AsyncTask<Void, Long, Boolean>
  {
    Activity activity;
    ProgressDialog l;
    String via;
    
    public a(Activity paramActivity)
    {
      this.activity = paramActivity;
    }
    
    public a(Activity paramActivity, String paramString)
    {
      this.activity = paramActivity;
      this.via = paramString;
    }
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      return Boolean.valueOf(false);
    }
    
    protected void emo()
    {
      if ((this.l != null) && (this.l.isShowing())) {
        this.l.dismiss();
      }
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
      emo();
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      emo();
      if (paramBoolean.booleanValue())
      {
        if ((asaa.aHC()) && (TextUtils.isEmpty(this.via))) {
          arxt.br("311", this.via, "1101070898");
        }
        return;
      }
      arxa.a().showToast(acfp.m(2131716994), 1);
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      this.l = new ReportProgressDialog(this.activity);
      if ((this.activity != null) && (!this.activity.isFinishing())) {
        this.l.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asaa
 * JD-Core Version:    0.7.0.1
 */