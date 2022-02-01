import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import java.io.File;
import java.io.IOException;

public class aotv
  extends AsyncTask<Void, Void, String>
{
  public aotv(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    try
    {
      str1 = this.x.saveTo(this.val$targetPath);
      if (str1 != null)
      {
        paramVarArgs = null;
        try
        {
          String str2 = MimeTypeMap.getFileExtensionFromUrl(str1);
          if (str2 != null) {
            paramVarArgs = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
          }
          if ((paramVarArgs != null) && (paramVarArgs.startsWith("image/"))) {
            aqhu.b(this.this$0, new File(str1));
          }
        }
        catch (IllegalArgumentException paramVarArgs)
        {
          for (;;)
          {
            QLog.e("TroopAvatarWallPreviewActivity", 2, new Object[] { "savePic2SystemMedia illegalArgumentException ex", paramVarArgs.getMessage() });
          }
        }
        aqhu.cn(this.this$0, str1);
        if (this.this$0.getIntent().getBooleanExtra("from_photo_wall", false)) {
          return acfp.m(2131715570);
        }
      }
    }
    catch (IOException paramVarArgs)
    {
      String str1;
      return this.this$0.getString(2131696986);
      return this.this$0.getString(2131696988) + " " + str1;
      paramVarArgs = this.this$0.getString(2131696986);
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.this$0.getString(2131696986);
  }
  
  protected void onPostExecute(String paramString)
  {
    QQToast.a(this.this$0, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotv
 * JD-Core Version:    0.7.0.1
 */