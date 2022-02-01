import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class kpi
{
  @NotNull
  private final kph jdField_a_of_type_Kph;
  @Nullable
  private kpl jdField_a_of_type_Kpl;
  private final boolean agV;
  private long beginTime;
  @Nullable
  private String name;
  
  public kpi(@NotNull kph paramkph, boolean paramBoolean, @Nullable String paramString)
  {
    this.jdField_a_of_type_Kph = paramkph;
    this.agV = paramBoolean;
    this.name = paramString;
    if (this.name == null) {
      this.name = getClass().getSimpleName();
    }
  }
  
  public boolean Ai()
  {
    this.beginTime = System.currentTimeMillis();
    log("onStart");
    return true;
  }
  
  public abstract boolean Aj();
  
  @NotNull
  public final kph a()
  {
    return this.jdField_a_of_type_Kph;
  }
  
  @Nullable
  public final kpl a()
  {
    return this.jdField_a_of_type_Kpl;
  }
  
  public final void a(@Nullable kpl paramkpl)
  {
    this.jdField_a_of_type_Kpl = paramkpl;
  }
  
  public void aFM()
  {
    this.jdField_a_of_type_Kph.a(this);
  }
  
  public final boolean isRunOnUIThread()
  {
    return this.agV;
  }
  
  protected final void log(@NotNull String paramString)
  {
    kpj localkpj = this.jdField_a_of_type_Kph.a();
    if (localkpj != null)
    {
      localkpj.d("Step(" + this.name + ')', paramString);
      return;
    }
    Log.d("Step(" + this.name + ')', paramString);
  }
  
  public void onEnd()
  {
    log("onEnd, time = " + (System.currentTimeMillis() - this.beginTime));
  }
  
  public void onStop()
  {
    log("onStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpi
 * JD-Core Version:    0.7.0.1
 */