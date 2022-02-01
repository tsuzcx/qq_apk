import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class amtx
  extends amsf
{
  private Set<String> cR;
  
  public amtx(aqdf paramaqdf, amsf.a parama, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramaqdf, parama, paramSet1);
    this.cR = paramSet2;
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    if (paramamxy.N() != null)
    {
      localObject = paramampx.getUin();
      if ((this.cR != null) && (this.cR.contains(localObject))) {
        paramamxy.N().setText(acfp.m(2131714211));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = aprg.V((QQAppInterface)localObject, paramampx.getUin());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(paramamxy instanceof amxs)) {
        break label165;
      }
      ((amxs)paramamxy).PA(bool);
    }
    for (;;)
    {
      if (paramamxy.v() != null)
      {
        if ((!(paramampx instanceof amos)) && (!(paramampx instanceof amoi)) && (!(paramampx instanceof amon))) {
          break;
        }
        if (paramamxy.N() != null) {
          paramamxy.N().setVisibility(8);
        }
        paramamxy.v().setVisibility(0);
      }
      return;
      label165:
      if ((paramamxy instanceof amzm)) {
        ((amzm)paramamxy).PA(bool);
      }
    }
    if (paramamxy.N() != null) {
      paramamxy.N().setVisibility(0);
    }
    paramamxy.v().setVisibility(8);
  }
  
  public void d(ampx paramampx, amxy paramamxy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtx
 * JD-Core Version:    0.7.0.1
 */