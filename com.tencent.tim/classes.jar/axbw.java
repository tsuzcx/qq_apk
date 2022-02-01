import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class axbw
  implements aolm.b
{
  public axbw(AEMaterialMgr.1 param1, String paramString) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i(axbv.access$300(), 2, "onResp url: " + this.a.a.packageUrl + " resultcode: " + paramaomh.dPy);
    }
    if (this.a.this$0.a(this.a.a)) {}
    try
    {
      jqp.b(new File(this.cTE, this.a.a.id), awtn.b.b.cSR + File.separator);
      axbv.a(this.a.this$0, this.a.a);
      axbv.a(this.a.this$0).remove(this.a.a.id);
      return;
    }
    catch (IOException paramaomh)
    {
      while (!QLog.isColorLevel()) {}
      paramaomh.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    axbv.a(this.a.this$0, this.a.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!axbv.a(this.a.this$0).containsKey(this.a.a.id)) {
      axbv.a(this.a.this$0).put(this.a.a.id, this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbw
 * JD-Core Version:    0.7.0.1
 */