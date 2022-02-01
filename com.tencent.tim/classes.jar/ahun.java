import java.util.ArrayList;

class ahun
  extends aqrd
{
  ahun(ahum paramahum) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject)
  {
    super.onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
    if (paramObject == null) {
      return;
    }
    ahum.a(this.a, (ArrayList)paramObject);
    ahum.a(this.a).setData(ahum.a(this.a));
    ahum.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahun
 * JD-Core Version:    0.7.0.1
 */