import android.util.SparseArray;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afnr
{
  private SparseArray<List<View>> cy = new SparseArray();
  
  public View K(int paramInt)
  {
    List localList = (List)this.cy.get(paramInt);
    if ((localList != null) && (localList.size() > 0)) {
      return (View)localList.remove(0);
    }
    return null;
  }
  
  public boolean c(int paramInt, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewPool", 2, "[RecyleView] addRecyleView, type=" + paramInt + ", view=" + paramView);
    }
    if (paramView == null) {
      return false;
    }
    List localList = (List)this.cy.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(3);
      this.cy.put(paramInt, localObject);
    }
    if (((List)localObject).size() >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EmoticonPanelViewPool", 2, "Capacity full for type " + paramInt);
      }
      return false;
    }
    ((List)localObject).add(paramView);
    return true;
  }
  
  public void destroy()
  {
    int j = this.cy.size();
    int i = 0;
    while (i < j)
    {
      int k = this.cy.keyAt(i);
      ((List)this.cy.get(k)).clear();
      i += 1;
    }
    this.cy.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnr
 * JD-Core Version:    0.7.0.1
 */