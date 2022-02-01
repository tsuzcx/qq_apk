import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.c;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class alxu
{
  public String bZq;
  public String bZr;
  public boolean cAQ;
  public int category;
  public String dgModelName;
  public String dgStageName;
  public String gestureType;
  public String gestureWording;
  public boolean hasFace;
  public String id;
  public int kind;
  public String name;
  public boolean usable;
  
  public static alxu a(EffectsCameraCaptureView.c paramc)
  {
    Object localObject;
    if ((paramc instanceof QIMEffectCameraCaptureUnit))
    {
      localObject = (ayzs)axov.a(3);
      if (localObject == null) {
        break label290;
      }
      localObject = ((ayzs)localObject).a();
      if ((localObject != null) || (!(paramc instanceof awsy))) {
        break label292;
      }
    }
    label290:
    label292:
    for (paramc = ((ayci)axov.a(17)).a();; paramc = (EffectsCameraCaptureView.c)localObject)
    {
      if (paramc != null)
      {
        localObject = new alxu();
        ((alxu)localObject).bZq = ayzs.bYM;
        ((alxu)localObject).usable = paramc.usable;
        ((alxu)localObject).kind = paramc.kind;
        ((alxu)localObject).id = paramc.id;
        ((alxu)localObject).name = paramc.name;
        ((alxu)localObject).dgStageName = paramc.dgStageName;
        ((alxu)localObject).dgModelName = paramc.dgModelName;
        ((alxu)localObject).hasFace = paramc.hasFace();
        ((alxu)localObject).cAQ = paramc.hasGesture();
        ((alxu)localObject).category = paramc.category;
        ((alxu)localObject).gestureType = paramc.gestureType;
        ((alxu)localObject).gestureWording = paramc.gestureWording;
        ((alxu)localObject).bZr = paramc.bigHeadName;
        return localObject;
        paramc = alwd.a().b();
        if (paramc != null)
        {
          localObject = new alxu();
          ((alxu)localObject).bZq = alwd.bYM;
          ((alxu)localObject).usable = paramc.usable;
          ((alxu)localObject).kind = paramc.kind;
          ((alxu)localObject).id = paramc.id;
          ((alxu)localObject).name = paramc.name;
          ((alxu)localObject).dgStageName = paramc.dgStageName;
          ((alxu)localObject).dgModelName = paramc.dgModelName;
          ((alxu)localObject).hasFace = paramc.hasFace();
          ((alxu)localObject).cAQ = paramc.hasGesture();
          ((alxu)localObject).category = paramc.category;
          ((alxu)localObject).gestureType = paramc.gestureType;
          ((alxu)localObject).gestureWording = paramc.gestureWording;
          ((alxu)localObject).bZr = paramc.bigHeadName;
          return localObject;
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxu
 * JD-Core Version:    0.7.0.1
 */