import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

public class axmc
  extends BroadcastReceiver
{
  public axmc(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) {}
    do
    {
      return;
      paramContext = AEEditorMusicHelper.a(paramIntent);
    } while (paramContext == null);
    AEEditorVideoEditFragment.a(this.this$0, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmc
 * JD-Core Version:    0.7.0.1
 */