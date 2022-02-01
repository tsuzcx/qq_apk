import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class aasy
  extends aatc
{
  public void cxZ()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] realDeleteVideoSegment ...");
    }
    localRMVideoStateMgr.a.Ge(100);
    localRMVideoStateMgr.tl(3);
  }
  
  public void initState()
  {
    RMVideoStateMgr.a().a.cww();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] initState end");
    }
  }
  
  public boolean onBackPressed()
  {
    RMVideoStateMgr.a().AQ("RMVideoIdleState");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasy
 * JD-Core Version:    0.7.0.1
 */