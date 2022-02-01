import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;

public class alkw
{
  public static ClipData a(ClipboardManager paramClipboardManager)
  {
    alkv.aM("ClipboardMonitor.getPrimaryClip", "getPrimaryClip", "");
    return paramClipboardManager.getPrimaryClip();
  }
  
  public static ClipDescription a(ClipboardManager paramClipboardManager)
  {
    alkv.aM("ClipboardMonitor.getPrimaryClipDescription", "getPrimaryClipDescription", "");
    return paramClipboardManager.getPrimaryClipDescription();
  }
  
  public static void a(ClipboardManager paramClipboardManager, ClipData paramClipData)
  {
    paramClipboardManager.setPrimaryClip(paramClipData);
    alkv.aM("ClipboardMonitor.setPrimaryClip", "setPrimaryClip", "");
  }
  
  public static void a(ClipboardManager paramClipboardManager, CharSequence paramCharSequence)
  {
    alkv.aM("ClipboardMonitor.setText", "setText", "");
    paramClipboardManager.setText(paramCharSequence);
  }
  
  public static boolean a(ClipboardManager paramClipboardManager)
  {
    alkv.aM("ClipboardMonitor.hasPrimaryClip", "hasPrimaryClip", "");
    return paramClipboardManager.hasPrimaryClip();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkw
 * JD-Core Version:    0.7.0.1
 */