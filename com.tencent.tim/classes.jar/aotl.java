import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class aotl
  extends AsyncTask<Void, Void, String>
{
  public aotl(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    try
    {
      String str2 = this.x.saveTo(this.val$targetPath);
      if (str2 != null)
      {
        aqhu.cn(this.this$0, str2);
        String str1 = this.this$0.getString(2131696988) + " " + str2;
        paramVarArgs = str1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "savePhoto:" + str2);
          return str1;
        }
      }
      else
      {
        paramVarArgs = this.this$0.getString(2131696986);
        return paramVarArgs;
      }
    }
    catch (IOException paramVarArgs)
    {
      return this.this$0.getString(2131696986);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      paramVarArgs = this.this$0.getString(2131696986);
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(String paramString)
  {
    QQToast.a(this.this$0, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotl
 * JD-Core Version:    0.7.0.1
 */