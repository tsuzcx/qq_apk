import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class awtm
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    if (!FeatureManager.Features.PTU_TOOLS.isFunctionReady()) {
      return paramArrayOfByte;
    }
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtm
 * JD-Core Version:    0.7.0.1
 */