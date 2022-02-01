import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.ICloudAVEngine.d;
import com.tencent.util.Pair;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlSerializer;

final class asyi
  extends asye.a.b
{
  private XmlSerializer jdField_b_of_type_OrgXmlpullV1XmlSerializer;
  private OutputStream h;
  File mOutputFile;
  
  public asyi(asye.a parama, File paramFile)
  {
    super(null);
    this.mOutputFile = paramFile;
  }
  
  public boolean a(String paramString, ICloudAVEngine.d paramd)
  {
    try
    {
      if (this.jdField_b_of_type_OrgXmlpullV1XmlSerializer == null)
      {
        IvParameterSpec localIvParameterSpec = new IvParameterSpec(asye.a.access$200());
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(asye.a.access$300(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        localCipher.init(1, localSecretKeySpec, localIvParameterSpec);
        this.h = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.mOutputFile)), localCipher);
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer = Xml.newSerializer();
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.setOutput(this.h, "UTF-8");
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.startTag(null, "AVCloudCache");
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.attribute(null, "Ver", Integer.toString(1));
      }
      asye.a.a(this.jdField_b_of_type_Asye$a, paramString, paramd, this.jdField_b_of_type_OrgXmlpullV1XmlSerializer);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.jdField_b_of_type_OrgXmlpullV1XmlSerializer = null;
    }
    return false;
  }
  
  public void esq()
  {
    try
    {
      Object localObject1;
      Object localObject2;
      if (this.jdField_b_of_type_OrgXmlpullV1XmlSerializer == null)
      {
        localObject1 = new IvParameterSpec(asye.a.access$200());
        localObject2 = new SecretKeySpec(asye.a.access$300(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        localCipher.init(1, (Key)localObject2, (AlgorithmParameterSpec)localObject1);
        this.h = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(this.mOutputFile)), localCipher);
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer = Xml.newSerializer();
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.setOutput(this.h, "UTF-8");
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.startTag(null, "AVCloudCache");
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.attribute(null, "Ver", Integer.toString(1));
      }
      if (asye.a.a(this.jdField_b_of_type_Asye$a).size() > 0)
      {
        localObject1 = asye.a.a(this.jdField_b_of_type_Asye$a).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Pair)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Add new cache entry: " + ((ICloudAVEngine.d)((Pair)localObject2).second).toString());
          }
          asye.a.a(this.jdField_b_of_type_Asye$a, (String)((Pair)localObject2).first, (ICloudAVEngine.d)((Pair)localObject2).second, this.jdField_b_of_type_OrgXmlpullV1XmlSerializer);
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      for (;;)
      {
        if (this.h != null) {}
        try
        {
          this.h.close();
          return;
        }
        catch (Exception localException2) {}
        asye.a.a(this.jdField_b_of_type_Asye$a).clear();
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.endTag(null, "AVCloudCache");
        this.jdField_b_of_type_OrgXmlpullV1XmlSerializer.endDocument();
        asye.a.a(this.jdField_b_of_type_Asye$a).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyi
 * JD-Core Version:    0.7.0.1
 */