import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qjr
  extends qgy.d
{
  public final boolean aDI;
  public final String axz;
  public final ErrorMessage e;
  
  public qjr(@NonNull ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    super(new qgy.c("ERROR_" + paramErrorMessage));
    this.axz = null;
    this.e = paramErrorMessage;
    this.aDI = paramBoolean;
    this.nv = new ArrayList();
    this.nv.add("ERROR");
    this.fR = new HashMap();
    this.fR.put("ERROR", "ERROR");
  }
  
  public qjr(@NonNull String paramString, boolean paramBoolean)
  {
    super(new qgy.c("LOADING_" + paramString));
    this.axz = paramString;
    this.e = null;
    this.aDI = paramBoolean;
    this.nv = new ArrayList();
    this.nv.add("LOADING");
    this.fR = new HashMap();
    this.fR.put("LOADING", "LOADING");
  }
  
  public boolean JA()
  {
    return this.axz != null;
  }
  
  public boolean Jz()
  {
    return this.e != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjr
 * JD-Core Version:    0.7.0.1
 */