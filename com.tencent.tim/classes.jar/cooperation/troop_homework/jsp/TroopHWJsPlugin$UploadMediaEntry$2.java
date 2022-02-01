package cooperation.troop_homework.jsp;

import awjs.c;
import com.tencent.qphone.base.util.QLog;

class TroopHWJsPlugin$UploadMediaEntry$2
  implements Runnable
{
  TroopHWJsPlugin$UploadMediaEntry$2(TroopHWJsPlugin.b paramb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "start upload!id = " + this.a.id + " type = " + this.a.type);
    }
    this.a.c.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2
 * JD-Core Version:    0.7.0.1
 */