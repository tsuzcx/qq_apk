import android.text.TextUtils;

class aejf
{
  public String action;
  public String app;
  public String icon;
  public String jumpUrl;
  public String tag;
  public String title;
  public String view;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.app)) && (!TextUtils.isEmpty(this.view));
  }
  
  public String key()
  {
    return this.app + this.view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejf
 * JD-Core Version:    0.7.0.1
 */