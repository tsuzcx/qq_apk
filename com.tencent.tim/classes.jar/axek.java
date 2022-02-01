import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class axek
  implements axzv<List<axby>>
{
  axek(axei paramaxei, axdd paramaxdd) {}
  
  public void ah(@Nullable List<axby> paramList)
  {
    axec.a(this.jdField_a_of_type_Axei.a).g().g(axec.a(this.jdField_a_of_type_Axei.a));
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material list state");
    int j;
    int i;
    if (paramList == null)
    {
      QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers == null");
      if ((paramList != null) && (axec.a(this.jdField_a_of_type_Axei.a) != null))
      {
        QLog.e("AEGIFChunkPreviewFragment", 4, "Find materials num = " + paramList.size());
        j = Math.min(paramList.size(), this.jdField_a_of_type_Axdd.eEC);
        Collections.shuffle(paramList);
        i = 0;
      }
    }
    for (;;)
    {
      axdj localaxdj;
      if (i < j)
      {
        axby localaxby = (axby)paramList.get(i);
        localaxdj = new axdj();
        localaxdj.c = localaxby.b;
        QLog.d("AEGIFChunkPreviewFragment", 4, "Assigning material to item index = " + i + "material id = " + localaxby.b.id);
        localaxdj.downloadState = 0;
        localaxdj.state = 10;
        localaxdj.text = "";
        axim.a().acP(localaxby.id);
        if (axec.a(this.jdField_a_of_type_Axei.a).size() < axec.a(this.jdField_a_of_type_Axei.a)) {}
      }
      else
      {
        return;
        if (!paramList.isEmpty()) {
          break;
        }
        QLog.e("AEGIFChunkPreviewFragment", 4, "aeMaterialWrappers is empty");
        break;
      }
      axec.a(this.jdField_a_of_type_Axei.a).add(localaxdj);
      axec.a(this.jdField_a_of_type_Axei.a).notifyItemInserted(axec.a(this.jdField_a_of_type_Axei.a).size() - 1);
      axec.a(this.jdField_a_of_type_Axei.a).a(axol.getAppInterface(), localaxdj);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axek
 * JD-Core Version:    0.7.0.1
 */