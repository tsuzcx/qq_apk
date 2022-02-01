import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import cooperation.qqreader.QRBridgeActivity;

public class aece
  implements aebx
{
  private Bundle mBundle;
  
  public aece() {}
  
  public aece(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public void b(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent = new Intent(paramContext, QRBridgeActivity.class);
    localIntent.putExtra("readtype", "16");
    localIntent.putExtra("stay", "1");
    if (this.mBundle != null) {
      localIntent.putExtras(this.mBundle);
    }
    paramColorNote = paramColorNote.getSubType().split("_");
    if (paramColorNote.length > 1)
    {
      localIntent.putExtra("nbid", paramColorNote[0]);
      if (paramColorNote[0].startsWith("-")) {
        localIntent.putExtra("isLocal", true);
      }
    }
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aece
 * JD-Core Version:    0.7.0.1
 */