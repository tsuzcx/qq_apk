import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;

public class rkm
{
  public final EditVideoParams.EditSource a;
  public final EditVideoParams a;
  public TribeVideoPublishParams a;
  public LpReportInfo_pf00064 a;
  public rkq a;
  public rks a;
  public String aAT;
  public String aAU;
  public boolean aIA;
  public boolean aIB;
  public boolean aIC;
  public boolean aID;
  public PublishParam b;
  public int bsP = 1;
  public int bsQ;
  public final int businessId;
  public WeakReference<View> dg;
  public final PublishVideoEntry g = new PublishVideoEntry();
  
  public rkm(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    this.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams = new TribeVideoPublishParams();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.businessId = paramEditVideoParams.asi;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    this.g.videoLabel = paramEditVideoParams.getStringExtra("story_default_label");
    this.g.putExtra("enable_flow_decode", Boolean.valueOf(alzf.aHn));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkm
 * JD-Core Version:    0.7.0.1
 */