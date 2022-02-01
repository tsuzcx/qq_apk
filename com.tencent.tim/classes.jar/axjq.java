import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class axjq
  implements axkj.a
{
  axjq(axjp paramaxjp, AppInterface paramAppInterface, axjp.a parama, axkj paramaxkj) {}
  
  public void aee(int paramInt)
  {
    axiy.i(axjp.access$100(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_Axjp$a != null) {
      this.jdField_a_of_type_Axjp$a.a(paramInt, this.jdField_a_of_type_Axkj.a());
    }
  }
  
  public void fB(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    axiy.i(axjp.access$100(), "proxy onDataReadyForRequest");
    axjp.a(this.jdField_a_of_type_Axjp, this.b, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjq
 * JD-Core Version:    0.7.0.1
 */