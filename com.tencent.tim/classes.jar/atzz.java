import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atzz
  extends atzy
{
  private List<atzy> KM;
  private atzy b;
  
  public atzz(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public String Fa()
  {
    return this.b.Fa();
  }
  
  public void Oy(int paramInt)
  {
    super.Oy(paramInt);
    Iterator localIterator = this.KM.iterator();
    while (localIterator.hasNext()) {
      ((atzy)localIterator.next()).Oy(paramInt);
    }
  }
  
  public long V()
  {
    return this.b.V();
  }
  
  public atyz a()
  {
    return this.b.a();
  }
  
  public atza a()
  {
    return this.b.a();
  }
  
  public atzb a()
  {
    return this.b.a();
  }
  
  public TeamWorkFileImportInfo a()
  {
    return null;
  }
  
  public void a(int paramInt, atzy.a parama)
  {
    this.b.a(0, parama);
  }
  
  public void a(agsa paramagsa)
  {
    super.a(paramagsa);
    Iterator localIterator = this.KM.iterator();
    while (localIterator.hasNext()) {
      ((atzy)localIterator.next()).a(paramagsa);
    }
  }
  
  public void a(atzy.b paramb)
  {
    this.b.a(paramb);
  }
  
  public void a(atzy.c paramc)
  {
    super.a(paramc);
    if (this.KM != null)
    {
      Iterator localIterator = this.KM.iterator();
      while (localIterator.hasNext()) {
        ((atzy)localIterator.next()).a(paramc);
      }
    }
  }
  
  public void a(atzy.d paramd)
  {
    super.a(paramd);
    if (this.KM != null)
    {
      Iterator localIterator = this.KM.iterator();
      while (localIterator.hasNext()) {
        ((atzy)localIterator.next()).a(paramd);
      }
    }
  }
  
  public String aA()
  {
    return this.b.aA();
  }
  
  public void aA(int paramInt)
  {
    this.b.aA(paramInt);
  }
  
  public String aB()
  {
    return this.b.aB();
  }
  
  public String aC()
  {
    return this.b.aC();
  }
  
  public void aH(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelCenter", 1, "setFileGalleryAdapterIndex. index[" + paramInt + "] curIndex[" + this.mCurrentIndex + "]");
    }
    if (paramInt == this.mCurrentIndex) {
      return;
    }
    if (paramInt > this.KM.size() - 1) {
      QLog.i("FileBrowserModelCenter", 1, "setFileGalleryAdapterIndex. but index is bigger than size.index[" + paramInt + "] size[" + this.KM.size() + "]");
    }
    this.b.removeObserver();
    this.mCurrentIndex = paramInt;
    this.b = ((atzy)this.KM.get(paramInt));
    this.b.ix();
  }
  
  public void ad(List<atzy> paramList, int paramInt)
  {
    this.mCurrentIndex = paramInt;
    this.KM = paramList;
    this.b = ((atzy)this.KM.get(this.mCurrentIndex));
  }
  
  public void at(boolean paramBoolean)
  {
    this.b.at(paramBoolean);
  }
  
  public void ax(int paramInt)
  {
    this.b.ax(paramInt);
  }
  
  public int bE()
  {
    return 6;
  }
  
  public int bF()
  {
    return this.b.bF();
  }
  
  public int bG()
  {
    return this.b.bG();
  }
  
  public int bI()
  {
    return this.b.bI();
  }
  
  public int bK()
  {
    return this.b.bK();
  }
  
  public int bL()
  {
    return this.b.bL();
  }
  
  public boolean cg()
  {
    return this.b.cg();
  }
  
  public boolean ch()
  {
    return this.b.ch();
  }
  
  public boolean ci()
  {
    return this.b.ci();
  }
  
  public boolean cj()
  {
    return this.b.cj();
  }
  
  public boolean cl()
  {
    return this.b.cl();
  }
  
  public boolean cm()
  {
    return this.b.cm();
  }
  
  public boolean cn()
  {
    return this.b.cn();
  }
  
  public boolean co()
  {
    return false;
  }
  
  public void cqt()
  {
    super.cqt();
    Iterator localIterator = this.KM.iterator();
    while (localIterator.hasNext()) {
      ((atzy)localIterator.next()).cqt();
    }
  }
  
  public void djr()
  {
    this.b.djr();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.KM.iterator();
    while (localIterator.hasNext()) {
      ((atzy)localIterator.next()).doOnPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Iterator localIterator = this.KM.iterator();
    while (localIterator.hasNext()) {
      ((atzy)localIterator.next()).doOnResume();
    }
  }
  
  public ArrayList<aufa.b> er()
  {
    return this.b.er();
  }
  
  public String getFileName()
  {
    return this.b.getFileName();
  }
  
  public String getFilePath()
  {
    return this.b.getFilePath();
  }
  
  public long getFileSize()
  {
    return this.b.getFileSize();
  }
  
  public int getFileType()
  {
    return this.b.getFileType();
  }
  
  public long getUin()
  {
    return this.b.getUin();
  }
  
  protected void iA()
  {
    this.b.djr();
  }
  
  public void iB()
  {
    this.b.iB();
  }
  
  public void iC()
  {
    this.b.iC();
  }
  
  public void iD()
  {
    this.b.iD();
  }
  
  public boolean isFromProcessingForward2c2cOrDiscItem()
  {
    return this.b.isFromProcessingForward2c2cOrDiscItem();
  }
  
  protected void ix()
  {
    this.b.ix();
  }
  
  public float k()
  {
    return this.b.k();
  }
  
  public void l(int paramInt, String paramString)
  {
    this.b.l(paramInt, paramString);
  }
  
  protected void removeObserver()
  {
    this.b.removeObserver();
  }
  
  public List<atzy.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.KM != null)
    {
      Iterator localIterator = this.KM.iterator();
      while (localIterator.hasNext())
      {
        List localList = ((atzy)localIterator.next()).u();
        if ((localList != null) && (localList.size() > 0)) {
          localArrayList.add(localList.get(0));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzz
 * JD-Core Version:    0.7.0.1
 */