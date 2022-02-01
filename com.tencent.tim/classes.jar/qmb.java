import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.util.Map;

public class qmb
  implements qlz
{
  private Map<String, String> fX;
  private Uri i;
  private Context mContext;
  private Map<String, String> mHeaders;
  private Uri mUri;
  
  public qmb(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.mContext = paramContext;
    this.mUri = paramUri;
    this.mHeaders = paramMap;
  }
  
  public qlx a()
    throws IOException
  {
    qlx localqlx = new qlx();
    localqlx.setDataSource(this.mContext, this.mUri, this.mHeaders);
    return localqlx;
  }
  
  public qlx b()
    throws IOException
  {
    if (this.i != null)
    {
      qlx localqlx = new qlx();
      localqlx.setDataSource(this.mContext, this.i, this.fX);
      return localqlx;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmb
 * JD-Core Version:    0.7.0.1
 */