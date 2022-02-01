import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class odu
{
  public static String TAG = "ReadinjoyH5ElementManager";
  private List<odu.a> kW = new ArrayList();
  
  public boolean GE()
  {
    return this.kW.isEmpty();
  }
  
  public void a(String paramString, Rect paramRect)
  {
    if ((TextUtils.isEmpty(paramString)) || (eD(paramString))) {
      return;
    }
    odu.a locala = new odu.a();
    locala.apT = paramString;
    locala.aB = paramRect;
    this.kW.add(locala);
  }
  
  public boolean a(Point paramPoint)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "pt.x = " + paramPoint.x + "  pt.y=" + paramPoint.y);
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.kW.size())
      {
        odu.a locala = (odu.a)this.kW.get(i);
        if ((locala != null) && (locala.aB != null) && (locala.aB.contains(paramPoint.x, paramPoint.y))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean eD(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.kW.size())
      {
        odu.a locala = (odu.a)this.kW.get(i);
        if ((locala != null) && (paramString.equals(locala.apT))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void pv(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.kW.size())
      {
        odu.a locala = (odu.a)this.kW.get(i);
        if ((locala != null) && (paramString.equals(locala.apT)))
        {
          this.kW.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public static class a
  {
    public Rect aB;
    public String apT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odu
 * JD-Core Version:    0.7.0.1
 */