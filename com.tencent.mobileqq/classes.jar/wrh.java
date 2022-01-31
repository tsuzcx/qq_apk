import android.support.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;

class wrh
  implements bhwg<wqg>
{
  wrh(wrc paramwrc) {}
  
  public void a(@Nullable wqg paramwqg)
  {
    if (paramwqg == null) {
      return;
    }
    wqk localwqk;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = wrc.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localwqk = (wqk)localIterator.next();
      if (!localwqk.jdField_a_of_type_JavaLangString.equals(paramwqg.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)) {
        break;
      }
      if (localwqk.jdField_a_of_type_Int != paramwqg.jdField_a_of_type_Int)
      {
        localwqk.jdField_a_of_type_Int = paramwqg.jdField_a_of_type_Int;
        wrc.a(this.a).notifyItemChanged(wrc.a(this.a).indexOf(localwqk) + 1);
      }
    } while ((localwqk.jdField_a_of_type_Int != 2) || (!localwqk.jdField_a_of_type_JavaLangString.equals(wrc.a(this.a))));
    wrc.a(this.a).a(localwqk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */