import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class npj
  implements ComplementFileStringLoader
{
  private npn a;
  private String basePath;
  private Context context;
  
  public npj(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.basePath = paramString;
    this.a = new npn(paramContext, paramString);
  }
  
  public String loadFileAsString(String paramString)
  {
    AssetManager localAssetManager = this.context.getAssets();
    try
    {
      InputStream localInputStream = this.a.a(paramString);
      Object localObject = localInputStream;
      if (localInputStream == null) {
        localObject = localAssetManager.open(this.basePath + "/" + paramString);
      }
      localObject = npv.readInputStreamAsString((InputStream)localObject);
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AssetsComplementFileStringLoader", 2, "loadFileAsString: fail to include - " + paramString);
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npj
 * JD-Core Version:    0.7.0.1
 */