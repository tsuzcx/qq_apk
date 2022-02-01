import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aetp
{
  private String bBf = "https://eim.connect.qq.com/guide/install.html?install=1";
  private String bBg = "";
  private String bBh = "";
  private String bBi = "";
  private String bBj = "";
  private String bBk = "";
  private String bBl = "";
  private String bBm = "";
  private boolean bWm;
  private boolean bWn;
  private boolean bWo;
  private boolean bWp;
  private boolean bWq;
  private boolean bWr;
  private boolean bWs;
  private boolean bWt;
  private int cPb = -1;
  private int cPc = -1;
  private int cPd = -1;
  private int cPe = -1;
  private Map<String, Long> jZ = new HashMap();
  
  public static aetp a(aeic[] paramArrayOfaeic)
  {
    boolean bool2 = false;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aetp localaetp = new aetp();
    for (;;)
    {
      try
      {
        paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
        if (paramArrayOfaeic.has("TIMDocs"))
        {
          paramArrayOfaeic = paramArrayOfaeic.getJSONObject("TIMDocs");
          if (paramArrayOfaeic.has("autoImportToSharedDocSwitch"))
          {
            if (paramArrayOfaeic.getInt("autoImportToSharedDocSwitch") != 1) {
              break label571;
            }
            bool1 = true;
            localaetp.bWm = bool1;
          }
          if (paramArrayOfaeic.has("openWithSharedDocInTimSwitch"))
          {
            if (paramArrayOfaeic.getInt("openWithSharedDocInTimSwitch") != 1) {
              break label576;
            }
            bool1 = true;
            localaetp.bWn = bool1;
          }
          if (paramArrayOfaeic.has("openFileInTimSwitch"))
          {
            if (paramArrayOfaeic.getInt("openFileInTimSwitch") != 1) {
              break label581;
            }
            bool1 = true;
            localaetp.bWo = bool1;
          }
          if (paramArrayOfaeic.has("aioSwitch"))
          {
            if (paramArrayOfaeic.getInt("aioSwitch") != 1) {
              break label586;
            }
            bool1 = true;
            localaetp.bWp = bool1;
          }
          if (paramArrayOfaeic.has("fileViewerMenuSwitch"))
          {
            if (paramArrayOfaeic.getInt("fileViewerMenuSwitch") != 1) {
              break label591;
            }
            bool1 = true;
            localaetp.bWq = bool1;
          }
          if (paramArrayOfaeic.has("openFileInTimEntry")) {
            localaetp.cPb = paramArrayOfaeic.getInt("openFileInTimEntry");
          }
          if (paramArrayOfaeic.has("androidURL")) {
            localaetp.bBf = paramArrayOfaeic.getString("androidURL");
          }
          if (paramArrayOfaeic.has("insertGrayTipAfterOpenWithSharedDocInTim"))
          {
            if (paramArrayOfaeic.getInt("insertGrayTipAfterOpenWithSharedDocInTim") != 1) {
              break label596;
            }
            bool1 = true;
            localaetp.bWr = bool1;
          }
          if (paramArrayOfaeic.has("timVersion")) {
            localaetp.cPc = paramArrayOfaeic.getInt("timVersion");
          }
          if (paramArrayOfaeic.has("saveTipLine0")) {
            localaetp.bBg = paramArrayOfaeic.getString("saveTipLine0");
          }
          if (paramArrayOfaeic.has("saveTipLine1")) {
            localaetp.bBh = paramArrayOfaeic.getString("saveTipLine1");
          }
          if (paramArrayOfaeic.has("saveAndCloseTipLine0")) {
            localaetp.bBi = paramArrayOfaeic.getString("saveAndCloseTipLine0");
          }
          if (paramArrayOfaeic.has("saveAndCloseTipLine1")) {
            localaetp.bBj = paramArrayOfaeic.getString("saveAndCloseTipLine1");
          }
          if (paramArrayOfaeic.has("saveTipCount")) {
            localaetp.cPd = paramArrayOfaeic.getInt("saveTipCount");
          }
          if (paramArrayOfaeic.has("contentEditedTipLine0")) {
            localaetp.bBk = paramArrayOfaeic.getString("contentEditedTipLine0");
          }
          if (paramArrayOfaeic.has("contentEditedTipLine1")) {
            localaetp.bBl = paramArrayOfaeic.getString("contentEditedTipLine1");
          }
          if (paramArrayOfaeic.has("contentEditedTipCount")) {
            localaetp.cPe = paramArrayOfaeic.getInt("contentEditedTipCount");
          }
          if (paramArrayOfaeic.has("docListEntryInFileSwitch"))
          {
            if (paramArrayOfaeic.getInt("docListEntryInFileSwitch") != 1) {
              break label601;
            }
            bool1 = true;
            localaetp.bWs = bool1;
          }
          if (paramArrayOfaeic.has("hideDocAuthoritySettingEntry"))
          {
            bool1 = bool2;
            if (paramArrayOfaeic.getInt("hideDocAuthoritySettingEntry") == 1) {
              bool1 = true;
            }
            localaetp.bWt = bool1;
          }
          if (paramArrayOfaeic.has("docListUrl")) {
            localaetp.bBm = paramArrayOfaeic.getString("docListUrl");
          }
          if (paramArrayOfaeic.has("editSupport"))
          {
            paramArrayOfaeic = paramArrayOfaeic.getJSONObject("editSupport");
            Iterator localIterator = paramArrayOfaeic.keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localaetp.jZ.put(str, Long.valueOf(paramArrayOfaeic.getLong(str)));
              continue;
            }
          }
        }
        return localaetp;
      }
      catch (JSONException paramArrayOfaeic)
      {
        QLog.e("TencentDocConvertConfigBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
      }
      label571:
      boolean bool1 = false;
      continue;
      label576:
      bool1 = false;
      continue;
      label581:
      bool1 = false;
      continue;
      label586:
      bool1 = false;
      continue;
      label591:
      bool1 = false;
      continue;
      label596:
      bool1 = false;
      continue;
      label601:
      bool1 = false;
    }
  }
  
  public int Ct()
  {
    return this.cPb;
  }
  
  public int Cu()
  {
    return this.cPc;
  }
  
  public int Cv()
  {
    return this.cPd;
  }
  
  public int Cw()
  {
    return this.cPe;
  }
  
  public Map<String, Long> ag()
  {
    return this.jZ;
  }
  
  public boolean ahR()
  {
    return this.bWn;
  }
  
  public boolean ahS()
  {
    return this.bWo;
  }
  
  public boolean ahT()
  {
    return this.bWp;
  }
  
  public boolean ahU()
  {
    return this.bWq;
  }
  
  public boolean ahV()
  {
    return this.bWr;
  }
  
  public String tO()
  {
    return this.bBf;
  }
  
  public String tP()
  {
    return this.bBg;
  }
  
  public String tQ()
  {
    return this.bBh;
  }
  
  public String tR()
  {
    return this.bBi;
  }
  
  public String tS()
  {
    return this.bBj;
  }
  
  public String tT()
  {
    return this.bBk;
  }
  
  public String tU()
  {
    return this.bBl;
  }
  
  public String tV()
  {
    return this.bBm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetp
 * JD-Core Version:    0.7.0.1
 */