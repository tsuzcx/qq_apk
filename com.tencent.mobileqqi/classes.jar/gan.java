import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;

public class gan
  extends ShakeListener
{
  public gan(MagicfaceActionManager paramMagicfaceActionManager) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    int j = 0;
    paramInt = MagicfaceActionManager.a().length - 1;
    for (;;)
    {
      int i = j;
      if (paramInt >= 0)
      {
        if ((Math.abs(paramFloat1 / 9.81F) > MagicfaceActionManager.a()[paramInt]) || (Math.abs(paramFloat2 / 9.81F) > MagicfaceActionManager.a()[paramInt]) || (Math.abs(paramFloat3 / 9.81F) > MagicfaceActionManager.a()[paramInt])) {
          i = MagicfaceActionManager.a()[paramInt];
        }
      }
      else
      {
        if (MagicfaceActionManager.a(this.a) != null) {
          MagicfaceActionManager.a(this.a).a(i, MagicfaceActionManager.a(this.a));
        }
        return;
      }
      paramInt -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gan
 * JD-Core Version:    0.7.0.1
 */