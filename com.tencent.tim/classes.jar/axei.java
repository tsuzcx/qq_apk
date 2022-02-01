import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class axei
  implements axzv<axdd>
{
  axei(axec paramaxec) {}
  
  public void b(@Nullable axdd paramaxdd)
  {
    int i = 0;
    axec.a(this.a).l().g(axec.a(this.a));
    if (paramaxdd != null)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", "=====" + paramaxdd });
      QLog.d("AEGIFChunkPreviewFragment", 4, "emo ===" + paramaxdd.cTN + "text ===" + paramaxdd.esM + "material ====" + paramaxdd.eEC);
      if (paramaxdd.cTN == null)
      {
        paramaxdd.esM = 0;
        paramaxdd.eEC = 6;
        paramaxdd.cTN = "default";
      }
      if ((paramaxdd.Mu != null) && (paramaxdd.Mu.size() == 0)) {
        paramaxdd.Mu.addAll(axdn.Mw);
      }
      Object localObject;
      if (paramaxdd.cTN.equals("default"))
      {
        localObject = acfp.m(2131702136);
        axec.a(this.a).setText((CharSequence)localObject);
      }
      for (;;)
      {
        if (i < paramaxdd.esM)
        {
          localObject = new axdj();
          ((axdj)localObject).c = null;
          ((axdj)localObject).text = ((String)paramaxdd.Mu.get(i % paramaxdd.Mu.size()));
          ((axdj)localObject).downloadState = 2;
          if (axec.a(this.a).size() < axec.a(this.a)) {}
        }
        else
        {
          axec.a(this.a).a(axec.a(this.a), paramaxdd.cTN);
          axec.a(this.a).k().a(axec.a(this.a), new axej(this, paramaxdd));
          axec.a(this.a).g().a(axec.a(this.a), new axek(this, paramaxdd));
          return;
          localObject = (String)axec.a(this.a).get(paramaxdd.cTN);
          localObject = acfp.m(2131702131) + (String)localObject + acfp.m(2131702138);
          break;
        }
        axec.a(this.a).add(localObject);
        axec.a(this.a).notifyItemInserted(axec.a(this.a).size() - 1);
        axfp localaxfp = new axfp();
        localaxfp.text = ((axdj)localObject).text;
        localaxfp.index = (i + 1);
        axec.a(this.a).a(localaxfp);
        i += 1;
      }
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    paramaxdd = new axdj();
    paramaxdd.materialPath = "";
    paramaxdd.text = "";
    paramaxdd.downloadState = 2;
    paramaxdd.state = 11;
    axec.a(this.a).add(paramaxdd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axei
 * JD-Core Version:    0.7.0.1
 */