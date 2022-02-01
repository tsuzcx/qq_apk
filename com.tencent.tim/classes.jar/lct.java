import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class lct
{
  private boolean ajq;
  private int currentIndex;
  private ArrayList<lcs> kx = new ArrayList();
  
  private void aKr()
  {
    if (this.currentIndex < this.kx.size())
    {
      lcs locallcs = (lcs)this.kx.get(this.currentIndex);
      if (this.ajq)
      {
        locallcs.aKo();
        return;
      }
      locallcs.aKn();
      return;
    }
    QLog.d("RIJPopupAutomator", 2, "startNext currentIndex out of bound");
  }
  
  void a(lcs paramlcs, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPopupAutomator", 2, "finishStep(" + paramlcs.toString() + "): isShown = " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.currentIndex += 1;
      aKr();
    }
  }
  
  public void a(lcs... paramVarArgs)
  {
    this.kx.addAll(Arrays.asList(paramVarArgs));
  }
  
  public void aKl()
  {
    Iterator localIterator = this.kx.iterator();
    while (localIterator.hasNext()) {
      ((lcs)localIterator.next()).aKl();
    }
  }
  
  public void aKm()
  {
    Iterator localIterator = this.kx.iterator();
    while (localIterator.hasNext()) {
      ((lcs)localIterator.next()).aKm();
    }
  }
  
  public void aKp()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnResume");
    this.currentIndex = 0;
    this.ajq = false;
    aKr();
  }
  
  public void aKq()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnShowSelf");
    this.currentIndex = 0;
    this.ajq = true;
    aKr();
  }
  
  public void onCreate()
  {
    Iterator localIterator = this.kx.iterator();
    while (localIterator.hasNext()) {
      ((lcs)localIterator.next()).onCreate();
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.kx.iterator();
    while (localIterator.hasNext()) {
      ((lcs)localIterator.next()).onDestroy();
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = this.kx.iterator();
    while (localIterator.hasNext()) {
      ((lcs)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.kx.iterator();
    while (localIterator.hasNext()) {
      ((lcs)localIterator.next()).onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lct
 * JD-Core Version:    0.7.0.1
 */