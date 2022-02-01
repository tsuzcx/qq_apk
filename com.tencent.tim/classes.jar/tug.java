import android.content.res.Resources;
import org.json.JSONObject;

public final class tug
  extends tua<JSONObject>
{
  private final tsg a;
  private final Resources res;
  
  public tug(Resources paramResources, tsg paramtsg)
  {
    this.res = paramResources;
    this.a = paramtsg;
  }
  
  protected trx a(JSONObject... paramVarArgs)
  {
    return trx.a.a(this.res, paramVarArgs[0]);
  }
  
  protected void c(trx paramtrx)
  {
    this.a.a(paramtrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tug
 * JD-Core Version:    0.7.0.1
 */