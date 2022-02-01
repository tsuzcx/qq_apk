import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class axej
  implements axzv<axcb>
{
  axej(axei paramaxei, axdd paramaxdd) {}
  
  public void a(@Nullable axcb paramaxcb)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if ((paramaxcb == null) || (axec.a(this.jdField_a_of_type_Axei.a) == null)) {}
    label360:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Axdd.esM + 1;
      for (;;)
      {
        if (i >= axec.a(this.jdField_a_of_type_Axei.a).size()) {
          break label360;
        }
        axdj localaxdj = (axdj)axec.a(this.jdField_a_of_type_Axei.a).get(i);
        if ((localaxdj != null) && (localaxdj.c != null) && (localaxdj.c.id.equals(paramaxcb.b.id)))
        {
          if (localaxdj.downloadState != paramaxcb.downloadState) {
            localaxdj.downloadState = paramaxcb.downloadState;
          }
          if (localaxdj.downloadState != 2) {
            break;
          }
          localaxdj.materialPath = axbv.a().a(localaxdj.c);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", "path===" + localaxdj.materialPath });
          paramaxcb = new axfp();
          paramaxcb.index = i;
          paramaxcb.materialPath = localaxdj.materialPath;
          if ((localaxdj.c != null) && ((localaxdj.text == null) || (localaxdj.text.equals("")))) {
            if (localaxdj.c.additionalFields.get("savename") != null)
            {
              paramaxcb.text = "";
              paramaxcb.cUe = ((String)localaxdj.c.additionalFields.get("savename"));
            }
          }
          for (;;)
          {
            axec.a(this.jdField_a_of_type_Axei.a).a(paramaxcb);
            localaxdj.state = 12;
            axec.a(this.jdField_a_of_type_Axei.a).notifyItemChanged(i);
            return;
            paramaxcb.text = "";
            paramaxcb.cUe = "";
            continue;
            if (localaxdj.text == null) {
              paramaxcb.text = "";
            } else {
              paramaxcb.text = localaxdj.text;
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axej
 * JD-Core Version:    0.7.0.1
 */