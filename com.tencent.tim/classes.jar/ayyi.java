import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class ayyi
  implements amal
{
  ayyi(ayyh paramayyh, azap paramazap, amae paramamae, PublishVideoEntry paramPublishVideoEntry, ayyj paramayyj) {}
  
  public void a(int paramInt, Throwable arg2)
  {
    ram.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (ayyh.a(this.jdField_a_of_type_Ayyh))
      {
        ayyh.a(this.jdField_a_of_type_Ayyh, true);
        ayyh.a(this.jdField_a_of_type_Ayyh).notifyAll();
        return;
      }
    }
  }
  
  public void auv()
  {
    if (this.jdField_a_of_type_Azap != null) {
      this.jdField_a_of_type_Azap.lH(this.e.width, this.e.height);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void btD()
  {
    if (this.c.isCancel)
    {
      this.d.dJU();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
  
  public void kf(String arg1)
  {
    synchronized (ayyh.a(this.jdField_a_of_type_Ayyh))
    {
      ayyh.a(this.jdField_a_of_type_Ayyh, true);
      ayyh.a(this.jdField_a_of_type_Ayyh).notifyAll();
      if (this.jdField_a_of_type_Azap != null) {
        this.jdField_a_of_type_Azap.eUE();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyi
 * JD-Core Version:    0.7.0.1
 */