import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;

public class aebz
  implements aebx
{
  private void a(Intent paramIntent, ColorNote paramColorNote)
  {
    String str = paramIntent.getStringExtra("url");
    if ((!TextUtils.isEmpty(str)) && (str.matches("^https?://fm\\.qzone\\.qq\\.com/.*")))
    {
      paramColorNote = paramColorNote.getReserve();
      if ((paramColorNote != null) && (paramColorNote.length > 0)) {
        paramIntent.putExtra("url", new String(paramColorNote));
      }
    }
  }
  
  public void b(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while (paramColorNote.getServiceType() != 16973824);
      localIntent = QQPlayerService.i();
    } while (localIntent == null);
    a(localIntent, paramColorNote);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebz
 * JD-Core Version:    0.7.0.1
 */