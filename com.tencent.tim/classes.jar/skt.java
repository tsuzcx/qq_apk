import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;

public class skt
  extends accd
{
  public skt(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void ar(Object paramObject)
  {
    paramObject = (apcy)paramObject;
    Bundle localBundle = new Bundle();
    localBundle.putLong("ProgressTotal", paramObject.ProgressTotal);
    localBundle.putLong("ProgressValue", paramObject.ProgressValue);
    localBundle.putString("FileName", paramObject.FileName);
    localBundle.putString("FilePath", paramObject.FilePath);
    localBundle.putString("LocalFile", paramObject.LocalFile);
    localBundle.putString("ThumbnailFile_Middle", paramObject.coc);
    localBundle.putString("ThumbnailFile_Large", paramObject.ThumbnailFile_Large);
    localBundle.putInt("Status", paramObject.Status);
    if ((paramObject.Status == 8) || ((paramObject.Status == 11) && (aqhq.fileExists(paramObject.FilePath)))) {
      this.d.j(57, localBundle);
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramObject.ThumbnailFile_Large))
      {
        localBundle.putInt("size", 640);
        this.d.j(58, localBundle);
        return;
      }
    } while (TextUtils.isEmpty(paramObject.coc));
    localBundle.putInt("size", 383);
    this.d.j(58, localBundle);
  }
  
  protected void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 30);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", Boolean.valueOf(paramBoolean2));
    localBundle.putSerializable("observer_type", Integer.valueOf(4));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.d.j(3, localBundle);
  }
  
  protected void n(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("type", 36);
      localBundle.putBoolean("isSuccess", paramBoolean);
      localBundle.putSerializable("data", (Object[])paramObject);
      localBundle.putSerializable("observer_type", Integer.valueOf(4));
      this.d.j(3, localBundle);
    }
  }
  
  protected void o(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("type", 44);
      localBundle.putBoolean("isSuccess", paramBoolean);
      localBundle.putSerializable("data", (Object[])paramObject);
      localBundle.putSerializable("observer_type", Integer.valueOf(4));
      this.d.j(3, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skt
 * JD-Core Version:    0.7.0.1
 */