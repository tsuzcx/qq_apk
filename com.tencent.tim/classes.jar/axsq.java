import android.support.annotation.NonNull;
import java.util.List;

public class axsq
{
  public static axpn a(String paramString)
  {
    return new axrd(Integer.valueOf(paramString).intValue());
  }
  
  public static axpn a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    aymz localaymz = ((axsu)axov.a(4)).a(paramString2);
    if ((localaymz instanceof ayne)) {
      return new axso((ayne)localaymz, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localaymz instanceof aynd)) {
      return new axsn((aynd)localaymz, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localaymz instanceof ayna)) {
      return new axsl((ayna)localaymz, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static axpn a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new axud(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static axpn b(String paramString)
  {
    return new axsr(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsq
 * JD-Core Version:    0.7.0.1
 */