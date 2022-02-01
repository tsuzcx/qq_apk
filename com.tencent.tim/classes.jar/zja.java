import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class zja
{
  ArrayList<Object> rE = new ArrayList();
  
  private boolean Pm()
  {
    boolean bool = false;
    if (this.rE != null) {}
    for (int i = this.rE.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if ((bool) && (QLog.isColorLevel())) {
        QLog.d("Q.history.", 2, "isOverLimit");
      }
      return bool;
    }
  }
  
  public void aL(Object paramObject)
  {
    if (w(paramObject))
    {
      this.rE.remove(paramObject);
      return;
    }
    if (Pm())
    {
      ahao.OS(2131693685);
      return;
    }
    this.rE.add(paramObject);
  }
  
  public void cpw()
  {
    this.rE.clear();
  }
  
  public List<Object> dl()
  {
    return this.rE;
  }
  
  public boolean w(Object paramObject)
  {
    return this.rE.contains(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zja
 * JD-Core Version:    0.7.0.1
 */