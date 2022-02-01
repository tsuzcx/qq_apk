import android.text.TextUtils;

public final class thi
{
  public String appName;
  public String appView;
  public String minVersion;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.appName)) && (!TextUtils.isEmpty(this.appView)) && (!TextUtils.isEmpty(this.minVersion));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thi
 * JD-Core Version:    0.7.0.1
 */