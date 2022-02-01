import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import dov.com.qq.im.aeeditor.AEEditorActivity;

public class axjh
{
  public static boolean L(Bundle paramBundle)
  {
    return a(paramBundle, 0);
  }
  
  public static boolean M(Bundle paramBundle)
  {
    return a(paramBundle, 1);
  }
  
  public static void a(Activity paramActivity, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    int i;
    Intent localIntent;
    if (paramInt1 == 0)
    {
      i = 10000;
      localIntent = new Intent(paramActivity, AEEditorActivity.class);
      if (paramBundle == null) {
        break label121;
      }
    }
    label121:
    for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
    {
      paramBundle.putInt("editorType", paramInt1);
      paramBundle.putInt("editorFrom", paramInt2);
      if (paramActivity.getIntent() != null)
      {
        paramBundle.putString("editor_filter_id", paramActivity.getIntent().getStringExtra("editor_filter_id"));
        paramActivity.getIntent().putExtra("editor_filter_id", "");
      }
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, i);
      return;
      if (paramInt1 == 1)
      {
        i = 10001;
        break;
      }
      throw new IllegalArgumentException("wrong editor type");
    }
  }
  
  private static boolean a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    while ((!paramBundle.containsKey("editorType")) || (paramBundle.getInt("editorType") != paramInt)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjh
 * JD-Core Version:    0.7.0.1
 */