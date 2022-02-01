import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class tty
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bjrq jdField_a_of_type_Bjrq;
  private sgh jdField_a_of_type_Sgh;
  
  public tty(Activity paramActivity, sgh paramsgh)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sgh = paramsgh;
    this.jdField_a_of_type_Bjrq = new bjrq(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bjrq != null) && (this.jdField_a_of_type_Bjrq.isShowing())) {
      this.jdField_a_of_type_Bjrq.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    ttz localttz = new ttz(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bjrq.a()) {
      this.jdField_a_of_type_Bjrq.a();
    }
    this.jdField_a_of_type_Bjrq.b = false;
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
      obb.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bjrq.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bjrq.a(paramView, localttz);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bjrq != null) && (this.jdField_a_of_type_Bjrq.isShowing())) {
      this.jdField_a_of_type_Bjrq.dismiss();
    }
    this.jdField_a_of_type_Bjrq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tty
 * JD-Core Version:    0.7.0.1
 */