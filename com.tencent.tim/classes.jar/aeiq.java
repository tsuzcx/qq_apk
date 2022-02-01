import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class aeiq
  extends aehv<aeiq.a>
{
  @NonNull
  public aeiq.a a(int paramInt)
  {
    return new aeiq.a();
  }
  
  @Nullable
  public aeiq.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0].content;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfaeic);
      }
      return aeiq.a.a(paramArrayOfaeic);
    }
    return new aeiq.a();
  }
  
  public void a(aeiq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    anqs.a().b(parama);
  }
  
  public Class clazz()
  {
    return aeiq.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 537;
  }
  
  public static class a
  {
    public boolean bUd;
    public boolean bUe;
    public boolean bUf;
    public boolean bUg;
    public boolean bUh;
    
    public a() {}
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      this.bUd = paramBoolean1;
      this.bUe = paramBoolean2;
      this.bUf = paramBoolean3;
      this.bUg = paramBoolean4;
      this.bUh = paramBoolean5;
    }
    
    public static a a(String paramString)
    {
      boolean bool6 = false;
      if (paramString == null) {
        return null;
      }
      boolean bool1;
      try
      {
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        localNodeList = paramString.getElementsByTagName("shortvideo_troop_auto_play");
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label489;
        }
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label453;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        NodeList localNodeList;
        label152:
        label212:
        QLog.e("AIOVideoPlayConfigProcessor", 1, "onParsed failed" + paramString);
        return null;
      }
      localNodeList = paramString.getElementsByTagName("shortvideo_not_troop_auto_play");
      if ((localNodeList != null) && (localNodeList.getLength() > 0)) {
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() > 0)
        {
          bool1 = true;
          break label499;
          localNodeList = paramString.getElementsByTagName("shortvideo_real_troop_auto_play");
          if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
            break label478;
          }
          if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label463;
          }
          bool1 = true;
          break label504;
          localNodeList = paramString.getElementsByTagName("shortvideo_real_not_troop_auto_play");
          if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
            break label473;
          }
          if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label468;
          }
          bool1 = true;
          break label510;
        }
      }
      label453:
      label463:
      label468:
      label473:
      label478:
      label489:
      label494:
      label499:
      label504:
      label510:
      for (;;)
      {
        paramString = paramString.getElementsByTagName("auto_del_bad_cache");
        boolean bool5 = bool6;
        if (paramString != null)
        {
          bool5 = bool6;
          if (localNodeList.getLength() > 0)
          {
            bool5 = bool6;
            if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
              bool5 = true;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoPlayConfigProcessor", 2, "parse, shortvideo_troop_auto_play = " + bool2 + ", shortvideo_not_troop_auto_play = " + bool3 + ", shortvideo_real_troop_auto_play = " + bool4 + ", shortvideo_real_not_troop_auto_play = " + bool1 + ", auto_del_bad_cache = " + bool5);
        }
        paramString = new a(bool2, bool3, bool4, bool1, bool5);
        return paramString;
        bool1 = false;
        break label494;
        bool1 = false;
        break label499;
        bool1 = false;
        break label504;
        bool1 = false;
        break label510;
        bool1 = true;
        continue;
        boolean bool4 = true;
        break label212;
        boolean bool3 = true;
        break label152;
        boolean bool2 = true;
        break;
        bool2 = bool1;
        break;
        bool3 = bool1;
        break label152;
        bool4 = bool1;
        break label212;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeiq
 * JD-Core Version:    0.7.0.1
 */