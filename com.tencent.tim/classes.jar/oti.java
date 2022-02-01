import com.tencent.qphone.base.util.QLog;

class oti
  extends adai.a
{
  oti(otd paramotd) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public int dI()
  {
    return 0;
  }
  
  public void onSuccess(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
    }
    this.a.isFollowed = true;
    otd.a(this.a);
  }
  
  public void p(Object paramObject)
  {
    otd.a(this.a, 2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oti
 * JD-Core Version:    0.7.0.1
 */