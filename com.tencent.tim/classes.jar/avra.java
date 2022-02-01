import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QzoneGiftFullScreenActionManager.1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class avra
{
  public List<aixr> CL;
  public aixt a;
  public aixv a;
  public aiyf a;
  aiym jdField_a_of_type_Aiym;
  avra.a jdField_a_of_type_Avra$a;
  avra.b jdField_a_of_type_Avra$b;
  public aixr b;
  public aiyl b;
  avrb c;
  String epId;
  public volatile boolean isRelease = false;
  public volatile boolean isShutDown = false;
  volatile boolean isStart = false;
  
  public avra(avrb paramavrb)
  {
    this.jdField_a_of_type_Aixt = null;
    this.c = paramavrb;
    this.jdField_a_of_type_Aixv = new aixv();
    this.jdField_a_of_type_Aiym = new aiym();
  }
  
  public static aixt a(String paramString1, String paramString2)
  {
    paramString1 = new aiyf(paramString2).lH("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new aixv().a(paramString1);
  }
  
  private void a(aixt paramaixt)
  {
    if (this.jdField_a_of_type_Avra$a != null) {
      this.jdField_a_of_type_Avra$a.e(paramaixt);
    }
    if ((paramaixt != null) && (paramaixt.a != null)) {
      paramaixt.dvo();
    }
  }
  
  private void aag(String paramString)
  {
    this.isStart = true;
    this.isShutDown = false;
    this.jdField_b_of_type_Aiyl.init();
    this.jdField_a_of_type_Aiyf = new aiyf(paramString);
    this.jdField_b_of_type_Aiyl.a(this.jdField_a_of_type_Aiyf);
    this.jdField_b_of_type_Aiyl.a(this.jdField_a_of_type_Aiym);
  }
  
  private void b(aixt paramaixt)
  {
    if (this.jdField_a_of_type_Avra$b != null) {
      this.jdField_a_of_type_Avra$b.dvw();
    }
    this.isStart = false;
    if (this.jdField_a_of_type_Avra$a != null) {
      this.jdField_a_of_type_Avra$a.f(paramaixt);
    }
  }
  
  private void dvu()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Aixt == null) || ("non-ver".equals(this.jdField_a_of_type_Aixt.bPU)))
    {
      this.CL = u(false);
      return;
    }
    int[] arrayOfInt1 = l("3.4.4");
    int[] arrayOfInt2 = l(this.jdField_a_of_type_Aixt.bPU);
    int i;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      this.CL = u(bool);
      return;
      if (arrayOfInt1[i] < arrayOfInt2[i])
      {
        i = 0;
      }
      else
      {
        i += 1;
        break;
        i = 1;
      }
    }
  }
  
  private int[] l(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    for (;;)
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      String[] arrayOfString = paramString.split("\\.");
      paramString = arrayOfInt;
      if (arrayOfString != null)
      {
        paramString = arrayOfInt;
        if (arrayOfString.length > 1)
        {
          i = j;
          paramString = arrayOfInt;
          try
          {
            if (i < arrayOfInt.length)
            {
              arrayOfInt[i] = Integer.valueOf(arrayOfString[i]).intValue();
              i += 1;
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
    return arrayOfInt;
  }
  
  public static String rP(String paramString)
  {
    String str = avsu.Gl();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  public static String rQ(String paramString)
  {
    String str = avsu.Gm();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<aixr> u(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CL.iterator();
    for (;;)
    {
      aixr localaixr;
      if (localIterator.hasNext())
      {
        localaixr = (aixr)localIterator.next();
        if (localaixr == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localaixr.name)) {
            continue;
          }
          localArrayList.add(localaixr);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localaixr.name)) {
        localArrayList.add(localaixr);
      }
    }
  }
  
  public void LG(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aixt != null) {
      this.jdField_a_of_type_Aixt.cmC = true;
    }
  }
  
  public void a(aiyl paramaiyl)
  {
    this.jdField_b_of_type_Aiyl = paramaiyl;
  }
  
  public void a(avra.a parama)
  {
    this.jdField_a_of_type_Avra$a = parama;
  }
  
  public void a(avra.b paramb)
  {
    if (paramb != null) {
      this.jdField_a_of_type_Avra$b = paramb;
    }
    this.isShutDown = true;
    if (this.jdField_b_of_type_Aixr != null) {
      this.jdField_b_of_type_Aixr.stop();
    }
    if (this.jdField_a_of_type_Aixt != null) {
      this.jdField_a_of_type_Aixt.a(null);
    }
  }
  
  public boolean apS()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void doAction(String paramString1, String paramString2)
  {
    if (this.isStart) {
      return;
    }
    this.epId = paramString1;
    ThreadManager.post(new QzoneGiftFullScreenActionManager.1(this, paramString2), 8, null, true);
  }
  
  public boolean isStart()
  {
    return this.isStart;
  }
  
  public void release()
  {
    this.isRelease = true;
    if (this.jdField_a_of_type_Aixt != null) {
      this.jdField_a_of_type_Aixt.a(null);
    }
    if (this.jdField_b_of_type_Aiyl != null)
    {
      this.jdField_b_of_type_Aiyl.a(null);
      this.jdField_b_of_type_Aiyl.release();
    }
    if (this.jdField_a_of_type_Aiym != null)
    {
      this.jdField_a_of_type_Aiym.release();
      this.jdField_a_of_type_Aiym = null;
    }
    this.c = null;
  }
  
  public static abstract interface a
  {
    public abstract void e(aixt paramaixt);
    
    public abstract void f(aixt paramaixt);
  }
  
  public static abstract interface b
  {
    public abstract void dvw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avra
 * JD-Core Version:    0.7.0.1
 */