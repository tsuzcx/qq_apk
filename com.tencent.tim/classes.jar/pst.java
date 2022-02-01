import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM.a;

public class pst
{
  @JsonORM.a(key="disable_revert")
  public pst.a[] a;
  @JsonORM.a(key="story_global_log_level")
  public String auU;
  @JsonORM.a(key="story_auto_play_report_control")
  public String auV;
  @JsonORM.a(key="disable_fast")
  public pst.a[] b;
  @JsonORM.a(key="story_home_preload_count")
  public int bkc;
  @JsonORM.a(key="story_video_preload_duration")
  public int bkd;
  @JsonORM.a(key="disable_slow")
  public pst.a[] c;
  @JsonORM.a(key="disable_hw_encode")
  public pst.a[] d;
  @JsonORM.a(key="disable_flow_decode")
  public pst.a[] e;
  @JsonORM.a(key="use_flow_decode_first")
  public pst.a[] f;
  
  public static class a
  {
    public static a a = new a();
    public static a b = new a();
    @JsonORM.a(key="manufacturer")
    public String manufacturer;
    @JsonORM.a(key="model")
    public String model;
    
    static
    {
      b.manufacturer = Build.MANUFACTURER;
      b.model = Build.MODEL;
      a.manufacturer = "all";
      a.model = "all";
    }
    
    public boolean IS()
    {
      if (a.equals(this)) {}
      while ((b.equals(this)) || ((TextUtils.isEmpty(this.manufacturer)) && (TextUtils.equals(this.model, b.model)))) {
        return true;
      }
      return false;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.manufacturer != null)
        {
          if (this.manufacturer.equals(paramObject.manufacturer)) {}
        }
        else {
          while (paramObject.manufacturer != null) {
            return false;
          }
        }
        if (this.model != null) {
          return this.model.equals(paramObject.model);
        }
      } while (paramObject.model == null);
      return false;
    }
    
    public int hashCode()
    {
      int j = 0;
      if (this.manufacturer != null) {}
      for (int i = this.manufacturer.hashCode();; i = 0)
      {
        if (this.model != null) {
          j = this.model.hashCode();
        }
        return i * 31 + j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pst
 * JD-Core Version:    0.7.0.1
 */