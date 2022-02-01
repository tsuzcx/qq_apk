import android.content.res.Resources;
import java.io.InputStream;

public final class tud
  extends tua<InputStream>
{
  private final tsg a;
  private final Resources res;
  
  public tud(Resources paramResources, tsg paramtsg)
  {
    this.res = paramResources;
    this.a = paramtsg;
  }
  
  protected trx a(InputStream... paramVarArgs)
  {
    return trx.a.a(this.res, paramVarArgs[0]);
  }
  
  protected void c(trx paramtrx)
  {
    this.a.a(paramtrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tud
 * JD-Core Version:    0.7.0.1
 */