import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;

public class ahev
{
  private static ahev jdField_a_of_type_Ahev;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  private TextureRegistry jdField_a_of_type_IoFlutterViewTextureRegistry;
  private HashMap<String, ahet> kY = new HashMap();
  
  public static ahev a()
  {
    if (jdField_a_of_type_Ahev == null) {}
    try
    {
      if (jdField_a_of_type_Ahev == null) {
        jdField_a_of_type_Ahev = new ahev();
      }
      return jdField_a_of_type_Ahev;
    }
    finally {}
  }
  
  private void dnd()
  {
    a(new ahfd("sso_channel", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new ahew("com.tencent.qflutter/apm", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
    a(new ahez("com.tencent.qflutter/scfsetting", this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger));
  }
  
  private void dne() {}
  
  private void dnf() {}
  
  public <T extends ahet> T a(String paramString)
  {
    if (this.kY != null) {
      return (ahet)this.kY.get(paramString);
    }
    return null;
  }
  
  public BinaryMessenger a()
  {
    return this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  }
  
  public TextureRegistry a()
  {
    return this.jdField_a_of_type_IoFlutterViewTextureRegistry;
  }
  
  public void a(ahet paramahet)
  {
    if (TextUtils.isEmpty(paramahet.im())) {
      QLog.d("QFlutter.ChannelManager", 1, "add channel channel name is emptyS");
    }
    do
    {
      return;
      if (!this.kY.containsKey(paramahet.im()))
      {
        ahet localahet = (ahet)this.kY.remove(paramahet.im());
        if (localahet != null) {
          localahet.onDestroy();
        }
      }
      this.kY.put(paramahet.im(), paramahet);
    } while (!QLog.isColorLevel());
    QLog.d("QFlutter.ChannelManager", 2, String.format("addChannel, channelName: %s", new Object[] { paramahet.im() }));
  }
  
  public void a(BinaryMessenger paramBinaryMessenger, TextureRegistry paramTextureRegistry)
  {
    if (paramBinaryMessenger == this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger)
    {
      QLog.d("QFlutter.ChannelManager", 1, "already registered channels");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.ChannelManager", 2, "registerChannels");
    }
    this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger = paramBinaryMessenger;
    this.jdField_a_of_type_IoFlutterViewTextureRegistry = paramTextureRegistry;
    dnd();
    dne();
    dnf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahev
 * JD-Core Version:    0.7.0.1
 */