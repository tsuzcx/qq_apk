import android.os.Bundle;
import android.view.View;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.data.MessageForDeviceFile.a;
import com.tencent.mobileqq.data.MessageRecord;
import java.lang.ref.WeakReference;

public class szg
  implements acci
{
  public void a(Session paramSession, float paramFloat) {}
  
  public void a(Session paramSession, boolean paramBoolean) {}
  
  public void a(MessageRecord paramMessageRecord, float paramFloat) {}
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean) {}
  
  public void b(Session paramSession) {}
  
  public void bh(Bundle paramBundle) {}
  
  public void bi(Bundle paramBundle) {}
  
  public void c(Session paramSession) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          Session localSession;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  switch (paramInt)
                  {
                  default: 
                    return;
                  case 100: 
                    paramObject = (Session)paramObject;
                  }
                } while (paramObject == null);
                b(paramObject);
                return;
                paramObject = (Session)paramObject;
              } while (paramObject == null);
              c(paramObject);
              return;
              paramObject = (Object[])paramObject;
            } while (paramObject.length <= 1);
            localSession = (Session)paramObject[0];
          } while (localSession == null);
          a(localSession, ((Float)paramObject[1]).floatValue());
          return;
          paramObject = (Session)paramObject;
        } while (paramObject == null);
        a(paramObject, paramBoolean);
        return;
        paramObject = (Bundle)paramObject;
      } while (paramObject == null);
      bh(paramObject);
      return;
      paramObject = (Bundle)paramObject;
    } while (paramObject == null);
    bi(paramObject);
  }
  
  public class a
  {
    public WeakReference<MessageForDeviceFile.a> callback;
    public WeakReference<View> view;
    
    public a(View paramView, MessageForDeviceFile.a parama)
    {
      this.view = new WeakReference(paramView);
      this.callback = new WeakReference(parama);
    }
    
    public MessageForDeviceFile.a a()
    {
      return (MessageForDeviceFile.a)this.callback.get();
    }
    
    public View getView()
    {
      return (View)this.view.get();
    }
  }
  
  public class b
  {
    public String mPeerUin;
    public int mUinType;
    public long mUniseq;
    
    public b(String paramString, int paramInt, long paramLong)
    {
      this.mPeerUin = paramString;
      this.mUinType = paramInt;
      this.mUniseq = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szg
 * JD-Core Version:    0.7.0.1
 */