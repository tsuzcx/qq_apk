import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class amhp
  extends DefaultHandler
{
  private amev jdField_a_of_type_Amev;
  private amhg jdField_a_of_type_Amhg;
  private boolean cCF;
  private SparseArray<amev> dq;
  private Stack<amev> k;
  private HashMap<String, Integer> mP = new HashMap();
  private StringBuilder sb = new StringBuilder();
  private ArrayList<amev> zn;
  private ArrayList<amhg> zs;
  private ArrayList<Integer> zt;
  
  public amhp()
  {
    this.mP.put("StateList", Integer.valueOf(1));
    this.mP.put("SubStateList", Integer.valueOf(2));
    this.mP.put("RichState", Integer.valueOf(3));
    this.mP.put("ActionId", Integer.valueOf(4));
    this.mP.put("Display", Integer.valueOf(5));
    this.mP.put("ActionName", Integer.valueOf(6));
    this.mP.put("Describe", Integer.valueOf(7));
    this.mP.put("IconURL", Integer.valueOf(8));
    this.mP.put("TinyIcon", Integer.valueOf(9));
    this.mP.put("Type", Integer.valueOf(10));
    this.mP.put("Parameter", Integer.valueOf(11));
    this.mP.put("DataURL", Integer.valueOf(12));
    this.mP.put("CoverURL", Integer.valueOf(13));
    this.mP.put("NativeList", Integer.valueOf(14));
    this.mP.put("ListParam", Integer.valueOf(15));
    this.mP.put("NativeDetail", Integer.valueOf(16));
    this.mP.put("DetailParam", Integer.valueOf(17));
    this.mP.put("Tags", Integer.valueOf(18));
    this.mP.put("StateTag", Integer.valueOf(19));
    this.mP.put("TagName", Integer.valueOf(20));
    this.mP.put("IdList", Integer.valueOf(21));
    this.mP.put("Action_id", Integer.valueOf(22));
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (this.cCF) {
      this.sb.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public ArrayList<amhg> dz()
  {
    return this.zs;
  }
  
  public void endDocument()
    throws SAXException
  {
    super.endDocument();
    int i = 0;
    while (i < this.zs.size())
    {
      Object localObject = (amhg)this.zs.get(i);
      if (((amhg)localObject).gF != null)
      {
        localObject = ((amhg)localObject).gF.iterator();
        while (((Iterator)localObject).hasNext())
        {
          int j = ((Integer)((Iterator)localObject).next()).intValue();
          amev localamev = (amev)this.dq.get(j);
          if ((localamev != null) && (localamev.type == 2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RichStatus", 2, "filter xml name = " + localamev.title);
            }
            ((Iterator)localObject).remove();
          }
        }
      }
      i += 1;
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    this.cCF = false;
    paramString1 = this.sb.toString();
    paramString2 = (Integer)this.mP.get(paramString2);
    if (paramString2 == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramString2.intValue())
            {
            case 18: 
            case 19: 
            case 21: 
            default: 
              return;
            case 1: 
            case 2: 
              this.jdField_a_of_type_Amev = ((amev)this.k.pop());
              if (this.zn.size() == 0) {
                this.jdField_a_of_type_Amev.zn = null;
              }
              break;
            }
          } while (this.k.size() <= 0);
          this.zn = ((amev)this.k.lastElement()).zn;
          return;
        } while (this.jdField_a_of_type_Amev.id == 0);
        this.dq.put(this.jdField_a_of_type_Amev.id, this.jdField_a_of_type_Amev);
        if (this.jdField_a_of_type_Amev.bot) {
          this.zn.add(this.jdField_a_of_type_Amev);
        }
        this.jdField_a_of_type_Amev = null;
        return;
        try
        {
          this.jdField_a_of_type_Amev.id = Integer.parseInt(paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, paramString1.toString() + ", " + paramString1.getStackTrace().toString());
      return;
      this.jdField_a_of_type_Amev.bot = Boolean.parseBoolean(paramString1);
      return;
      this.jdField_a_of_type_Amev.title = paramString1;
      return;
      this.jdField_a_of_type_Amev.bigIcon = paramString1;
      return;
      this.jdField_a_of_type_Amev.bZO = paramString1;
      return;
      if ("0".equals(paramString1))
      {
        this.jdField_a_of_type_Amev.type = 4;
        return;
      }
      if ("1".equals(paramString1))
      {
        this.jdField_a_of_type_Amev.type = 3;
        return;
      }
      if ("2".equals(paramString1))
      {
        this.jdField_a_of_type_Amev.type = 2;
        return;
      }
    } while (!"4".equals(paramString1));
    this.jdField_a_of_type_Amev.type = 5;
    return;
    this.jdField_a_of_type_Amev.name = paramString1;
    return;
    this.jdField_a_of_type_Amev.baseUrl = paramString1;
    return;
    this.jdField_a_of_type_Amev.bZP = paramString1;
    return;
    this.jdField_a_of_type_Amev.bZQ = paramString1;
    return;
    this.jdField_a_of_type_Amev.bZR = paramString1;
    return;
    this.jdField_a_of_type_Amev.bZS = paramString1;
    return;
    this.jdField_a_of_type_Amev.bZT = paramString1;
    return;
    this.jdField_a_of_type_Amev.bZU = paramString1;
    return;
    this.jdField_a_of_type_Amhg.tagName = paramString1;
    return;
    this.zt.add(Integer.valueOf(Integer.parseInt(paramString1)));
  }
  
  public SparseArray<amev> i()
  {
    return this.dq;
  }
  
  public void startDocument()
    throws SAXException
  {
    this.dq = new SparseArray();
    this.zs = new ArrayList();
    this.jdField_a_of_type_Amhg = new amhg();
    this.k = new Stack();
    this.jdField_a_of_type_Amev = new amev(-1);
    this.dq.put(-1, this.jdField_a_of_type_Amev);
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this.cCF = true;
    this.sb.replace(0, this.sb.length(), "");
    if (("StateList".equals(paramString2)) || ("SubStateList".equals(paramString2)))
    {
      this.zn = new ArrayList();
      this.jdField_a_of_type_Amev.zn = this.zn;
      this.k.push(this.jdField_a_of_type_Amev);
    }
    do
    {
      return;
      if ("RichState".equals(paramString2))
      {
        this.jdField_a_of_type_Amev = new amev(-1);
        return;
      }
      if ("StateTag".equals(paramString2))
      {
        this.jdField_a_of_type_Amhg = new amhg();
        this.zs.add(this.jdField_a_of_type_Amhg);
        return;
      }
    } while (!"IdList".equals(paramString2));
    this.zt = new ArrayList();
    this.jdField_a_of_type_Amhg.gF = this.zt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhp
 * JD-Core Version:    0.7.0.1
 */