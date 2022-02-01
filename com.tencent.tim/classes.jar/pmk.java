import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class pmk
  extends acfd
{
  pmk(pmj parampmj) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onAddFriend: invoked.  addUin: " + paramString);
    }
    try
    {
      paramString = Long.valueOf(paramString);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      this.this$0.z(3, localArrayList);
      this.this$0.blT();
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StoryHaloManager", 2, "onAddFriend: failed.  exception: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmk
 * JD-Core Version:    0.7.0.1
 */