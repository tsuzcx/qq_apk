import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.a;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

class ote
  implements PublicAccountImageCollectionListView.a
{
  ote(otd paramotd) {}
  
  public void Y(Object paramObject)
  {
    if ((paramObject instanceof otd.a))
    {
      if (!this.a.ayi) {
        ((PublicAccountImageCollectionMainActivity)otd.a(this.a)).asF();
      }
      this.a.ayi = true;
    }
    while ((paramObject instanceof otd.b)) {
      if (otd.a(this.a))
      {
        this.a.rc(true);
        return;
        ((PublicAccountImageCollectionMainActivity)otd.a(this.a)).aTb();
      }
      else
      {
        this.a.rc(false);
        return;
      }
    }
    this.a.rc(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ote
 * JD-Core Version:    0.7.0.1
 */