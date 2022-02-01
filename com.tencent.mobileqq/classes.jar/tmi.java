import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class tmi
  implements ComplementFileStringLoader
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private tmp jdField_a_of_type_Tmp;
  
  public tmi(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Tmp = new tmp(paramContext, paramString);
  }
  
  public String loadFileAsString(String paramString)
  {
    AssetManager localAssetManager = this.jdField_a_of_type_AndroidContentContext.getAssets();
    try
    {
      InputStream localInputStream = this.jdField_a_of_type_Tmp.a(paramString);
      Object localObject = localInputStream;
      if (localInputStream == null) {
        localObject = localAssetManager.open(this.jdField_a_of_type_JavaLangString + "/" + paramString);
      }
      localObject = tmz.a((InputStream)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmi
 * JD-Core Version:    0.7.0.1
 */