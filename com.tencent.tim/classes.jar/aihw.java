import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class aihw
  extends aoif
{
  aihw(aihv paramaihv) {}
  
  protected void a(boolean paramBoolean, aoii paramaoii, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (paramaoii == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + paramaoii.uin);
      } while (!(paramaoii instanceof WatchTogetherSession));
      paramString = aihv.a(this.a, (WatchTogetherSession)paramaoii);
    } while (paramString == null);
    this.a.b(paramaoii.uin, paramString);
    paramInt = paramString.ddo;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihw
 * JD-Core Version:    0.7.0.1
 */