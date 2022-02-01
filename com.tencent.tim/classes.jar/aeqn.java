import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import org.json.JSONException;
import org.json.JSONObject;

class aeqn
  implements aepo.a
{
  aeqn(aeqj paramaeqj) {}
  
  public void eh(Context paramContext)
  {
    try
    {
      Intent localIntent;
      if (new JSONObject(aeqj.a(this.this$0)).getInt("showlocalfile") == 1)
      {
        localIntent = new Intent(paramContext, LocalFileBrowserActivity.class);
        if (localIntent != null) {}
      }
      else
      {
        return;
      }
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("category", 23);
        localIntent.putExtra("bundle", localBundle);
        localIntent.putExtra("localSdCardfile", 0);
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqn
 * JD-Core Version:    0.7.0.1
 */