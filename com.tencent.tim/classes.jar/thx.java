import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k=3, mv={1, 1, 16})
public final class thx<T>
  implements ValueCallback<String>
{
  public static final thx a = new thx();
  
  public final void onReceiveValue(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData EVENT_CALL_BACK_JS callback " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thx
 * JD-Core Version:    0.7.0.1
 */