import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.ColorNoteCurd.1;
import com.tencent.mobileqq.colornote.ColorNoteCurd.2;
import com.tencent.mobileqq.colornote.ColorNoteCurd.3;
import com.tencent.mobileqq.colornote.ColorNoteCurd.4;
import com.tencent.mobileqq.colornote.ColorNoteCurd.5;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

public class aeaz
{
  private aeba a = new aeba();
  private aeaz.b b;
  private Handler mHandler = new aeaz.a(this);
  
  public aeaz()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      if (localQQAppInterface != null) {
        break label74;
      }
      localObject = null;
    }
    for (;;)
    {
      this.a.setApp(localQQAppInterface);
      this.a.a((aebo)localObject);
      return;
      localQQAppInterface = null;
      break;
      label74:
      if (localQQAppInterface.a() == null) {
        localObject = null;
      } else {
        localObject = localQQAppInterface.a().a();
      }
    }
  }
  
  private boolean isInMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public void B(int paramInt1, String paramString, int paramInt2)
  {
    if (isInMainThread())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.2(this, paramInt1, paramString, paramInt2), 32, null, true);
      return;
    }
    C(paramInt1, paramString, paramInt2);
  }
  
  public void C(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = aeba.c(paramInt1, paramString, paramInt2);
    Message localMessage = Message.obtain();
    localMessage.obj = new Pair(Integer.valueOf(paramInt1), paramString);
    if (bool) {}
    for (localMessage.what = 5;; localMessage.what = 6)
    {
      this.mHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public boolean canAddColorNote()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return this.a.agl();
    }
    return aebu.a().agq();
  }
  
  public void cm(Bundle paramBundle)
  {
    if (isInMainThread())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.1(this, paramBundle), 32, null, true);
      return;
    }
    cn(paramBundle);
  }
  
  public void cn(Bundle paramBundle)
  {
    boolean bool = this.a.z(paramBundle);
    Message localMessage = Message.obtain();
    localMessage.obj = paramBundle;
    if (bool) {}
    for (localMessage.what = 3;; localMessage.what = 4)
    {
      this.mHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void deleteColorNote(int paramInt, String paramString)
  {
    B(paramInt, paramString, 0);
  }
  
  public boolean getSyncState()
  {
    return aebu.a().getSyncState();
  }
  
  public void j(ColorNote paramColorNote)
  {
    if (isInMainThread())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.4(this, paramColorNote), 32, null, true);
      return;
    }
    k(paramColorNote);
  }
  
  public void k(ColorNote paramColorNote)
  {
    Object localObject = paramColorNote.getUniKey();
    boolean bool2 = true;
    if (paramColorNote.mMainTitle != null) {
      bool2 = aeba.o((String)localObject, "mMainTitle", paramColorNote.mMainTitle);
    }
    boolean bool1 = bool2;
    if (paramColorNote.mSubTitle != null) {
      bool1 = bool2 & aeba.o((String)localObject, "mSubTitle", paramColorNote.mSubTitle);
    }
    bool2 = bool1;
    if (paramColorNote.mPicUrl != null) {
      bool2 = bool1 & aeba.o((String)localObject, "mPicUrl", paramColorNote.mPicUrl);
    }
    localObject = Message.obtain();
    if (bool2) {}
    for (((Message)localObject).what = 10;; ((Message)localObject).what = 11)
    {
      ((Message)localObject).obj = paramColorNote;
      this.mHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  public void l(ColorNote paramColorNote)
  {
    if (isInMainThread())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.5(this, paramColorNote), 32, null, true);
      return;
    }
    m(paramColorNote);
  }
  
  public void m(int paramInt, String paramString, boolean paramBoolean)
  {
    if (isInMainThread())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.3(this, paramInt, paramString, paramBoolean), 32, null, true);
      return;
    }
    n(paramInt, paramString, paramBoolean);
  }
  
  public void m(ColorNote paramColorNote)
  {
    aeba.a(paramColorNote);
  }
  
  public void n(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = aeba.a(paramInt, paramString, paramBoolean);
    if (localBundle == null) {
      return;
    }
    localBundle.putInt("key_service_type", paramInt);
    localBundle.putString("key_sub_type", paramString);
    paramString = Message.obtain();
    paramString.what = 9;
    paramString.obj = localBundle;
    this.mHandler.sendMessage(paramString);
  }
  
  public void setOnColorNoteCurdListener(aeaz.b paramb)
  {
    this.b = paramb;
  }
  
  public boolean u(int paramInt, String paramString)
  {
    return aebu.a().u(paramInt, paramString);
  }
  
  static class a
    extends Handler
  {
    private WeakReference<aeaz> as;
    
    a(aeaz paramaeaz)
    {
      this.as = new WeakReference(paramaeaz);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      Object localObject1 = (aeaz)this.as.get();
      if (localObject1 == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = aeaz.a((aeaz)localObject1);
              switch (paramMessage.what)
              {
              case 7: 
              case 8: 
              default: 
                return;
              }
            } while (localObject1 == null);
            localObject2 = (Bundle)paramMessage.obj;
            if (paramMessage.what == 3) {}
            for (bool1 = true;; bool1 = false)
            {
              ((aeaz.b)localObject1).onAddColorNote((Bundle)localObject2, bool1);
              return;
            }
          } while (localObject1 == null);
          try
          {
            localObject2 = (Pair)paramMessage.obj;
            int i = ((Integer)((Pair)localObject2).first).intValue();
            localObject2 = (String)((Pair)localObject2).second;
            if (paramMessage.what != 5)
            {
              ((aeaz.b)localObject1).onDeleteColorNote(i, (String)localObject2, bool1);
              return;
            }
          }
          catch (ClassCastException paramMessage)
          {
            for (;;)
            {
              QLog.e("ColorNoteCurd", 2, paramMessage, new Object[0]);
              return;
              bool1 = false;
            }
          }
          catch (Exception paramMessage)
          {
            QLog.e("ColorNoteCurd", 2, paramMessage, new Object[0]);
            return;
          }
        } while ((localObject1 == null) || (paramMessage.obj == null));
        paramMessage = (Bundle)paramMessage.obj;
        ((aeaz.b)localObject1).onUpdateColorNoteState(paramMessage.getInt("key_service_type"), paramMessage.getString("key_sub_type"), paramMessage);
        return;
      } while ((localObject1 == null) || (paramMessage.obj == null));
      Object localObject2 = (ColorNote)paramMessage.obj;
      if (paramMessage.what == 10) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((aeaz.b)localObject1).onUpdateColorNote((ColorNote)localObject2, bool1);
        return;
      }
    }
  }
  
  public static class b
  {
    public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
    {
      if (paramBundle != null)
      {
        int i = paramBundle.getInt("param_service_type");
        String str = paramBundle.getString("param_sub_type");
        if (paramBundle.getInt("param_extra", 1) != 2) {
          aebu.a().o(i, str, paramBoolean);
        }
        aebu.a().a(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
      }
    }
    
    public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
    {
      aebu.a().o(paramInt, paramString, paramBoolean);
    }
    
    public void onUpdateColorNote(ColorNote paramColorNote, boolean paramBoolean) {}
    
    public void onUpdateColorNoteState(int paramInt, String paramString, Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        aebu.a().o(paramInt, paramString, paramBundle.getBoolean("extra_is_colornote_exists"));
        aebu.a().Hh(paramBundle.getBoolean("extra_can_add_colornote"));
        aebu.a().a(new Point(paramBundle.getInt("key_float_window_position_x"), paramBundle.getInt("key_float_window_position_y")));
        boolean bool = paramBundle.getBoolean("extra_after_sync_msg");
        aebu.a().Hg(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeaz
 * JD-Core Version:    0.7.0.1
 */