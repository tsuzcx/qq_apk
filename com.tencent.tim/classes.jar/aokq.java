import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;

class aokq
  extends aook
{
  aokq(aokp paramaokp) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    aoko localaoko = (aoko)paramMessage.obj;
    if ((i == 2002) || ((aokp.a(this.a).equals(localaoko.mUin)) && (localaoko.fileType == 1) && (i != 2002)))
    {
      if ((localaoko.cly == null) || (!localaoko.cly.equals(aokp.b(this.a)))) {
        return;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      aokp.a(this.a);
      continue;
      if (aqhq.fileExistsAndNotEmpty(aokp.c(this.a)))
      {
        aokp.a(this.a).a().b(this);
        aokp.b(this.a);
      }
      else
      {
        aokp.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokq
 * JD-Core Version:    0.7.0.1
 */