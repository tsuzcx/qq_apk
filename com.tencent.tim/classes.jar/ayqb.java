import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.lang.ref.WeakReference;

public class ayqb
{
  public ayqh a;
  public ayqj a;
  public TribeVideoPublishParams a;
  public LpReportInfo_pf00064 a;
  public final EditVideoParams.EditSource a;
  public final EditVideoParams a;
  public String aAT;
  public String aAU;
  public long aDe;
  public boolean aIA;
  public boolean aIB;
  public boolean aIC;
  public boolean aID;
  public PublishParam b;
  public int bsP = 1;
  public final int businessId;
  public boolean dAq;
  public WeakReference<View> dg;
  public final PublishVideoEntry g = new PublishVideoEntry();
  
  public ayqb(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    this.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams = new TribeVideoPublishParams();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.businessId = paramEditVideoParams.asi;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    this.g.videoLabel = paramEditVideoParams.getStringExtra("story_default_label");
    this.aDe = System.currentTimeMillis();
  }
  
  public boolean aQW()
  {
    return (this.aIA) || (this.jdField_a_of_type_Ayqh.bsR > 0);
  }
  
  public View ay()
  {
    if (this.dg != null) {
      return (View)this.dg.get();
    }
    return null;
  }
  
  public void dS(View paramView)
  {
    if (paramView == null)
    {
      this.dg = null;
      return;
    }
    this.dg = new WeakReference(paramView);
  }
  
  public String toString()
  {
    return "GenerateContext{, businessId='" + this.businessId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqb
 * JD-Core Version:    0.7.0.1
 */