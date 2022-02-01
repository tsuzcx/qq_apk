import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.io.IOException;

public class adzq
  extends AsyncTask<Void, Void, String>
{
  public adzq(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.x.saveTo(this.val$targetPath);
      if (paramVarArgs != null)
      {
        aqhu.cn(this.a, paramVarArgs);
        return this.a.getString(2131696988) + " " + paramVarArgs;
      }
      paramVarArgs = this.a.getString(2131696986);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      return this.a.getString(2131696986);
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.a.getString(2131696986);
  }
  
  protected void onPostExecute(String paramString)
  {
    QQToast.a(this.a, paramString, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzq
 * JD-Core Version:    0.7.0.1
 */