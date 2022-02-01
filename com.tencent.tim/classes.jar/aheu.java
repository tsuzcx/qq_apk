import android.text.TextUtils;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public abstract class aheu
  extends ahet
{
  MethodChannel a;
  
  public aheu(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    super(paramString, paramBinaryMessenger);
    MethodCodec localMethodCodec = a();
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("channelName must not be empty");
    }
    if (localMethodCodec == null) {
      throw new IllegalArgumentException("methodCodec must not be null");
    }
    this.a = new MethodChannel(paramBinaryMessenger, paramString, a());
    this.a.setMethodCallHandler(a());
  }
  
  public abstract MethodChannel.MethodCallHandler a();
  
  public abstract MethodCodec a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aheu
 * JD-Core Version:    0.7.0.1
 */