import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class uif
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bldc jdField_a_of_type_Bldc;
  private ssm jdField_a_of_type_Ssm;
  
  public uif(Activity paramActivity, ssm paramssm)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ssm = paramssm;
    this.jdField_a_of_type_Bldc = new bldc(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bldc != null) && (this.jdField_a_of_type_Bldc.isShowing())) {
      this.jdField_a_of_type_Bldc.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    uig localuig = new uig(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bldc.a()) {
      this.jdField_a_of_type_Bldc.a();
    }
    this.jdField_a_of_type_Bldc.b = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoInfo.a != null) && (paramVideoInfo.a.e != null))
    {
      int i = 0;
      while (i < paramVideoInfo.a.e.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_Long = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_Long;
        localDislikeInfo.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      ois.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bldc.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bldc.a(paramView, localuig);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bldc != null) && (this.jdField_a_of_type_Bldc.isShowing())) {
      this.jdField_a_of_type_Bldc.dismiss();
    }
    this.jdField_a_of_type_Bldc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uif
 * JD-Core Version:    0.7.0.1
 */