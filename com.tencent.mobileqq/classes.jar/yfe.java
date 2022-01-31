import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.qphone.base.util.QLog;

class yfe
  implements Runnable
{
  yfe(yfd paramyfd) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SystemMsgListAdapter", 4, "onGetCampusInfo notify refresh list");
    }
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yfe
 * JD-Core Version:    0.7.0.1
 */