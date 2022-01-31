import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.videostory.app.material.AEMaterialMgr.1;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class wqi
  implements axrt
{
  public wqi(AEMaterialMgr.1 param1) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i(wqh.a(), 2, "onResp url: " + this.a.a.packageUrl + " resultcode: " + paramaxsq.c);
    }
    if (this.a.this$0.a(this.a.a)) {}
    try
    {
      mpx.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.a.a.id), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      wqh.a(this.a.this$0, this.a.a);
      wqh.a(this.a.this$0).remove(this.a.a.id);
      return;
    }
    catch (IOException paramaxsq)
    {
      while (!QLog.isColorLevel()) {}
      paramaxsq.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    wqh.a(this.a.this$0, this.a.a, (int)(paramLong1 / paramLong2 * 100L));
    if (!wqh.a(this.a.this$0).containsKey(this.a.a.id)) {
      wqh.a(this.a.this$0).put(this.a.a.id, this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqi
 * JD-Core Version:    0.7.0.1
 */