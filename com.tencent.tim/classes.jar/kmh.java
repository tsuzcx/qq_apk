import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdDislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class kmh
{
  private auug jdField_a_of_type_Auug;
  private nag jdField_a_of_type_Nag;
  private Activity activity;
  
  public kmh(Activity paramActivity, nag paramnag)
  {
    this.activity = paramActivity;
    this.jdField_a_of_type_Nag = paramnag;
    this.jdField_a_of_type_Auug = new auug(paramActivity);
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    kmj localkmj = new kmj(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Auug.hasInit()) {
      this.jdField_a_of_type_Auug.initPopupWindow();
    }
    this.jdField_a_of_type_Auug.dkE = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoInfo.b != null) && (paramVideoInfo.b.jO != null))
    {
      int i = 0;
      while (i < paramVideoInfo.b.jO.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.vf = ((VideoAdInfo.NegFeedback)paramVideoInfo.b.jO.get(i)).rw;
        localDislikeInfo.agQ = ((VideoAdInfo.NegFeedback)paramVideoInfo.b.jO.get(i)).Wy;
        localArrayList.add(localDislikeInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      jzk.a(paramVideoInfo.b);
      if (this.jdField_a_of_type_Auug.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Auug.a(paramView, localkmj);
      }
    }
  }
  
  public void a(View paramView, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramView == null) || (paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdDislikeInfos == null) || (paramAdvertisementInfo.mAdDislikeInfos.size() == 0)) {}
    kmi localkmi;
    ArrayList localArrayList;
    do
    {
      return;
      localkmi = new kmi(this, paramAdvertisementInfo);
      if (!this.jdField_a_of_type_Auug.hasInit()) {
        this.jdField_a_of_type_Auug.initPopupWindow();
      }
      this.jdField_a_of_type_Auug.dkE = false;
      localArrayList = new ArrayList();
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos.iterator();
      while (paramAdvertisementInfo.hasNext())
      {
        AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.data = localAdDislikeInfo.data;
        localDislikeInfo.type = localAdDislikeInfo.type;
        localDislikeInfo.vf = localAdDislikeInfo.vf;
        localDislikeInfo.puin = localAdDislikeInfo.puin;
        localDislikeInfo.agQ = localAdDislikeInfo.agQ;
        localArrayList.add(localDislikeInfo);
      }
    } while ((localArrayList.size() <= 0) || (!this.jdField_a_of_type_Auug.a(0, localArrayList)));
    this.jdField_a_of_type_Auug.a(paramView, localkmi);
  }
  
  public void destroy()
  {
    if ((this.jdField_a_of_type_Auug != null) && (this.jdField_a_of_type_Auug.isShowing())) {
      this.jdField_a_of_type_Auug.dismiss();
    }
    this.jdField_a_of_type_Auug = null;
  }
  
  public void dismiss()
  {
    if ((this.jdField_a_of_type_Auug != null) && (this.jdField_a_of_type_Auug.isShowing())) {
      this.jdField_a_of_type_Auug.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmh
 * JD-Core Version:    0.7.0.1
 */