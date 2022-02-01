package dov.com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import ankq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$10
  implements Runnable
{
  PtvTemplateManager$10(PtvTemplateManager paramPtvTemplateManager, File paramFile, boolean paramBoolean, PtvTemplateManager.a parama, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject1 = PtvTemplateManager.p(this.T);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      return;
      localObject1 = PtvTemplateManager.a((String)localObject1);
    } while ((localObject1 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.isEmpty()));
    this.this$0.Av.clear();
    ??? = ((PtvTemplateManager.PtvTemplateInfo)localObject1).doodleInfos.iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject4 = (PtvTemplateManager.DoodleInfo)((Iterator)???).next();
      if (localObject4 != null)
      {
        ((PtvTemplateManager.DoodleInfo)localObject4).doodleUsable = this.this$0.a((PtvTemplateManager.DoodleInfo)localObject4, true);
        if ((((PtvTemplateManager.DoodleInfo)localObject4).doodleUsable) && (this.cFl))
        {
          localObject4 = PtvTemplateManager.cdu + ((PtvTemplateManager.DoodleInfo)localObject4).doodleName;
          VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial((String)localObject4, "params");
          if (localVideoMaterial != null)
          {
            localVideoMaterial.setDataPath((String)localObject4);
            this.this$0.Av.add(localVideoMaterial);
            if (QLog.isDevelopLevel()) {
              QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "initLocalDoodleInfo add DoodleMaterial:", localVideoMaterial.getId() });
            }
          }
        }
      }
    }
    synchronized (this.this$0.eK)
    {
      this.this$0.h = ((PtvTemplateManager.PtvTemplateInfo)localObject1);
      if (this.jdField_b_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$a != null) {
        this.jdField_b_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$a.bsj();
      }
      if ((this.jdField_b_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_b_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (ankq.axZ())) {
        this.this$0.fb((QQAppInterface)this.jdField_b_of_type_ComTencentCommonAppAppInterface);
      }
      PtvTemplateManager.a(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.10
 * JD-Core Version:    0.7.0.1
 */