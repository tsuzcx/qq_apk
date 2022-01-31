import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class uhv
  extends alox
{
  uhv(uhu paramuhu) {}
  
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
      this.a.a(3, localArrayList);
      this.a.a();
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StoryHaloManager", 2, "onAddFriend: failed.  exception: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhv
 * JD-Core Version:    0.7.0.1
 */