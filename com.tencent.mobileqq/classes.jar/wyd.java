import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;

public class wyd
  extends ajsy
{
  public wyd(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(Object paramObject)
  {
    paramObject = (azqv)paramObject;
    Bundle localBundle = new Bundle();
    localBundle.putLong("ProgressTotal", paramObject.jdField_c_of_type_Long);
    localBundle.putLong("ProgressValue", paramObject.jdField_d_of_type_Long);
    localBundle.putString("FileName", paramObject.g);
    localBundle.putString("FilePath", paramObject.e);
    localBundle.putString("LocalFile", paramObject.a);
    localBundle.putString("ThumbnailFile_Middle", paramObject.jdField_d_of_type_JavaLangString);
    localBundle.putString("ThumbnailFile_Large", paramObject.jdField_c_of_type_JavaLangString);
    localBundle.putInt("Status", paramObject.b);
    if ((paramObject.b == 8) || ((paramObject.b == 11) && (bbdx.a(paramObject.e)))) {
      this.a.a(57, localBundle);
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramObject.jdField_c_of_type_JavaLangString))
      {
        localBundle.putInt("size", 640);
        this.a.a(58, localBundle);
        return;
      }
    } while (TextUtils.isEmpty(paramObject.jdField_d_of_type_JavaLangString));
    localBundle.putInt("size", 383);
    this.a.a(58, localBundle);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("type", 36);
      localBundle.putBoolean("isSuccess", paramBoolean);
      localBundle.putSerializable("data", (Object[])paramObject);
      localBundle.putSerializable("observer_type", Integer.valueOf(4));
      this.a.a(3, localBundle);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 30);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", Boolean.valueOf(paramBoolean2));
    localBundle.putSerializable("observer_type", Integer.valueOf(4));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.a.a(3, localBundle);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("type", 44);
      localBundle.putBoolean("isSuccess", paramBoolean);
      localBundle.putSerializable("data", (Object[])paramObject);
      localBundle.putSerializable("observer_type", Integer.valueOf(4));
      this.a.a(3, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyd
 * JD-Core Version:    0.7.0.1
 */