import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aedo
{
  private aebd a;
  private aeaz mColorNoteCurd = new aeaz();
  private boolean mIsReady = true;
  private aebf mServiceInfo;
  
  public aedo()
  {
    this.mColorNoteCurd.setOnColorNoteCurdListener(new aeaz.b());
    this.a = new aebd();
    this.a.a(this.mColorNoteCurd);
  }
  
  private boolean jd(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292);
  }
  
  public void Hl(boolean paramBoolean)
  {
    this.mIsReady = paramBoolean;
  }
  
  public void Hm(boolean paramBoolean)
  {
    Object localObject;
    if ((this.mServiceInfo != null) && (this.mColorNoteCurd != null) && (this.a != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.mServiceInfo.getColorNote();
      localObject = localColorNote;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteStateNotice", 1, localException, new Object[0]);
        continue;
        int i = 0;
      }
    }
    if ((localObject != null) && (jd(localObject.getServiceType())))
    {
      i = 1;
      if ((localObject != null) && (i != 0) && (this.mIsReady) && (paramBoolean) && (!this.mColorNoteCurd.u(localObject.getServiceType(), localObject.getSubType())))
      {
        aebs.p(localObject);
        this.a.l(localObject);
      }
      return;
    }
  }
  
  public void a(aeaz paramaeaz)
  {
    this.mColorNoteCurd = paramaeaz;
  }
  
  public void cVR()
  {
    Hm(true);
  }
  
  public void onPause()
  {
    if ((this.mColorNoteCurd != null) && (this.mServiceInfo != null))
    {
      localColorNote = this.mServiceInfo.getColorNote();
      if (localColorNote != null)
      {
        this.mColorNoteCurd.m(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = aebs.a(localColorNote);
        this.mColorNoteCurd.m(localColorNote.getServiceType(), localColorNote.getSubType(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void onResume()
  {
    if ((this.mColorNoteCurd != null) && (this.mServiceInfo != null))
    {
      localColorNote = this.mServiceInfo.getColorNote();
      if (localColorNote != null)
      {
        this.mColorNoteCurd.m(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = aebs.a(localColorNote);
        this.mColorNoteCurd.m(localColorNote.getServiceType(), localColorNote.getSubType(), true);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void setOnColorNoteCurdListener(aeaz.b paramb)
  {
    if (this.mColorNoteCurd != null) {
      this.mColorNoteCurd.setOnColorNoteCurdListener(paramb);
    }
  }
  
  public void setServiceInfo(aebf paramaebf)
  {
    this.mServiceInfo = paramaebf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedo
 * JD-Core Version:    0.7.0.1
 */