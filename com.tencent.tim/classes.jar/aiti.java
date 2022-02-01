import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.b;

class aiti
  extends acfd
{
  aiti(aitg paramaitg) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(aitg.a(this.b).xc())))
    {
      aitg.e(aitg.a(this.b), 0, String.valueOf(paramObject));
      if (aitg.a(this.b) != null) {
        aitg.a(this.b).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiti
 * JD-Core Version:    0.7.0.1
 */