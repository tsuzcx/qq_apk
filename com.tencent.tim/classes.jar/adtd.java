import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class adtd
  implements ArkEnvironmentManager.LibraryLoader
{
  public boolean Load()
  {
    ArkAppCenter.cTO();
    return ArkAppCenter.bQm;
  }
  
  public boolean isLibraryLoad()
  {
    return ArkAppCenter.bQm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtd
 * JD-Core Version:    0.7.0.1
 */