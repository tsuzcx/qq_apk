import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import cooperation.qqreader.QRBridgeActivity;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class avlx
{
  private static final avlx a = new avlx();
  private long azE = 100L;
  private boolean dnp = true;
  private boolean dnq = true;
  private boolean dnr = true;
  private int uA = 100;
  private int uy = 300;
  private int uz = 300;
  
  private avlx()
  {
    ZU(avog.bM(BaseApplicationImpl.getContext()));
    eAF();
  }
  
  private void ZU(String paramString)
  {
    label155:
    label158:
    label161:
    do
    {
      for (;;)
      {
        int i;
        try
        {
          JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("configs");
          paramString = null;
          i = 0;
          if (i >= localJSONArray.length()) {
            break label158;
          }
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          String str = localJSONObject.getString("version");
          if ("*".equals(str))
          {
            paramString = localJSONObject;
            break label161;
          }
          if (!str.contains("3.4.4")) {
            break label155;
          }
          paramString = localJSONObject;
        }
        catch (Exception paramString)
        {
          avoc.e("QRLocalManager", "json parse err", paramString);
          return;
        }
        this.dnp = paramString.optBoolean("aioEntryEnable");
        this.dnq = paramString.optBoolean("previewEntryEnable");
        this.dnr = paramString.optBoolean("moreEntryEnable");
        this.azE = paramString.optInt("aioFileSizeLimit");
        this.uy = paramString.optInt("addBookshelfDuration");
        this.uz = paramString.optInt("goBookshelfDuration");
        this.uA = paramString.optInt("splitChapterParaMaxNum");
        return;
        break label161;
        break;
        i += 1;
      }
    } while (paramString != null);
  }
  
  public static avlx a()
  {
    return a;
  }
  
  private boolean aKI()
  {
    if (!avlz.a().EU())
    {
      avlz.a().installPlugin();
      return false;
    }
    return true;
  }
  
  private void eAF()
  {
    avop.a(avop.q, new avly(this), true);
  }
  
  public boolean E(@NonNull FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.status != 1) || (TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return false;
    }
    return L(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize);
  }
  
  public boolean F(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while (!paramFileManagerEntity.fileName.toLowerCase().endsWith(".txt")) {
      return false;
    }
    return this.dnr;
  }
  
  public void L(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent1 = new Intent(paramContext, QRBridgeActivity.class);
    localIntent1.putExtra("readtype", "31");
    localIntent1.putExtra("stay", "1");
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("com.qqreader.pureader.FILE_PATH", paramString);
    if (paramBoolean) {
      localIntent2.putExtra("ChannelID", "100328");
    }
    for (;;)
    {
      localIntent1.putExtras(localIntent2);
      paramContext.startActivity(localIntent1);
      return;
      localIntent2.putExtra("ChannelID", "100330");
    }
  }
  
  public boolean L(String paramString, long paramLong)
  {
    if (paramLong < this.azE * 1024L) {}
    while ((!this.dnp) || (!aKI()) || (TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return false;
    }
    return paramString.toLowerCase().endsWith(".txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlx
 * JD-Core Version:    0.7.0.1
 */