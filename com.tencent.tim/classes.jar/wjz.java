import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.a;
import com.tencent.qphone.base.util.QLog;

public class wjz
{
  private volatile wjz.a jdField_a_of_type_Wjz$a;
  AudioHelper.a[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a;
  private boolean bcY = true;
  private volatile boolean bcZ;
  private volatile boolean bda;
  private volatile boolean bdb;
  private boolean bdc;
  private volatile boolean dy;
  
  private AudioHelper.a a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a = AudioHelper.a();
    }
    AudioHelper.a locala2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a[0];
    AudioHelper.a locala1 = locala2;
    if (paramInt >= 0)
    {
      locala1 = locala2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a.length) {
        locala1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a[paramInt];
      }
    }
    return locala1;
  }
  
  private void bYD()
  {
    wjz.a locala1 = a();
    int i = 0;
    if ((AudioPlayerBase.bdf) && (this.bdb)) {
      i = 4;
    }
    for (;;)
    {
      wjz.a locala2 = new wjz.a(a(i), i, true);
      if (!locala1.a(locala2)) {
        this.jdField_a_of_type_Wjz$a = locala2;
      }
      xj("updateCurrentStatus end nextStatusType = " + i);
      return;
      if (this.bcZ) {
        i = 2;
      } else if (this.bda) {
        i = 3;
      } else if ((!this.bcY) || (this.dy)) {
        i = 1;
      }
    }
  }
  
  private void yo(boolean paramBoolean)
  {
    this.bcY = paramBoolean;
    ainb.a().Lg(paramBoolean);
    bYD();
  }
  
  private void yp(boolean paramBoolean)
  {
    if (this.dy != paramBoolean) {
      this.dy = paramBoolean;
    }
    bYD();
  }
  
  private void yq(boolean paramBoolean)
  {
    this.bcZ = paramBoolean;
    bYD();
  }
  
  private void yr(boolean paramBoolean)
  {
    this.bda = AudioHelper.bL(BaseApplicationImpl.getContext());
    this.bdb = AudioHelper.bN(BaseApplicationImpl.getContext());
    bYD();
  }
  
  public boolean Re()
  {
    return this.bcY;
  }
  
  public boolean Rf()
  {
    return this.bcZ;
  }
  
  public boolean Rg()
  {
    return this.bda;
  }
  
  public boolean Rh()
  {
    return this.dy;
  }
  
  public AudioHelper.a a()
  {
    if ((this.jdField_a_of_type_Wjz$a == null) || (this.jdField_a_of_type_Wjz$a.b() == null)) {
      return a(0);
    }
    xj("getCurrentProperParam");
    return this.jdField_a_of_type_Wjz$a.b();
  }
  
  public wjz.a a()
  {
    if (this.jdField_a_of_type_Wjz$a == null) {
      new wjz.a(a(0), 0);
    }
    return this.jdField_a_of_type_Wjz$a;
  }
  
  public wjz.a a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      xj("onAudioDeviceStatusChanged changeType = " + paramInt + "|" + paramBoolean);
      return this.jdField_a_of_type_Wjz$a;
      yo(paramBoolean);
      continue;
      yp(paramBoolean);
      continue;
      yq(paramBoolean);
      continue;
      yr(paramBoolean);
    }
  }
  
  public void a(AudioManager paramAudioManager)
  {
    xj("doOnBluetoothSCODisconnected isBluetoothA2dpOn = " + paramAudioManager.isBluetoothA2dpOn());
    if ((this.bda) && (!paramAudioManager.isBluetoothA2dpOn())) {
      this.bda = false;
    }
  }
  
  public void bYC()
  {
    if (!this.bdc)
    {
      ys(AudioHelper.bN(BaseApplicationImpl.getContext()));
      this.bdc = true;
    }
  }
  
  public void init()
  {
    this.jdField_a_of_type_Wjz$a = new wjz.a(a(0), 0);
    this.bcZ = ija.Y(BaseApplicationImpl.getContext());
    this.bda = AudioHelper.bL(BaseApplicationImpl.getContext());
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.bcY = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getLoudSpeakerState();
    }
    this.bdb = AudioHelper.bN(BaseApplicationImpl.getContext());
    bYD();
    xj("init ");
  }
  
  public int vK()
  {
    return 31;
  }
  
  public void xj(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!aqmr.isEmpty(paramString)) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append("\n mCurDeviceStatus = " + this.jdField_a_of_type_Wjz$a.bNJ);
      localStringBuilder.append("\n  userLoudSpeakerStatus = " + this.bcY);
      localStringBuilder.append("\n  mNearToEar = " + this.dy);
      localStringBuilder.append("\n  wiredHeadsetConnect = " + this.bcZ);
      localStringBuilder.append("\n  blueHeadsetConnect = " + this.bda);
      localStringBuilder.append("\n  mblueHeadsetSCOConnect = " + this.bdb);
      QLog.d("AudioPlayer_DeviceStatus", 2, localStringBuilder.toString());
    }
  }
  
  public void ys(boolean paramBoolean)
  {
    this.bdb = paramBoolean;
    bYD();
  }
  
  public static class a
  {
    AudioHelper.a a;
    public int bNJ;
    volatile boolean bdd;
    
    public a(AudioHelper.a parama, int paramInt)
    {
      this(parama, paramInt, false);
    }
    
    public a(AudioHelper.a parama, int paramInt, boolean paramBoolean)
    {
      this.a = parama;
      this.bdd = paramBoolean;
      this.bNJ = paramInt;
    }
    
    public boolean Ri()
    {
      return this.bdd;
    }
    
    public boolean a(a parama)
    {
      if ((parama == null) || (this.a == null)) {
        return false;
      }
      return this.a.equals(parama.a);
    }
    
    public AudioHelper.a b()
    {
      return this.a;
    }
    
    public void bYE()
    {
      if (this.bdd) {
        this.bdd = false;
      }
    }
    
    public int vL()
    {
      return this.bNJ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjz
 * JD-Core Version:    0.7.0.1
 */